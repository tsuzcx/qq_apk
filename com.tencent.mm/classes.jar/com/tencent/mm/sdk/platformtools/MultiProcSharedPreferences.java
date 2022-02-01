package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ApplicationInfo;
import android.os.Looper;
import android.util.LruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

@Deprecated
public class MultiProcSharedPreferences
  implements SharedPreferences
{
  private static final String TAG = "MicroMsg.MultiProcSharedPreferences";
  private static final Object mContent;
  private static MMHandler mMainThreadHandler;
  private static final LruCache<String, MultiProcSharedPreferences> mSPCache;
  private File mBackupFile;
  private int mDiskWritesInFlight;
  private File mFile;
  private FLock mFileLock;
  private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners;
  private boolean mLoaded;
  private Map<String, Object> mMap;
  private int mMode;
  private boolean mShouldLockFile;
  private long mStatSize;
  private long mStatTimestamp;
  private final Object mWritingToDiskLock;
  
  static
  {
    AppMethodBeat.i(156249);
    mMainThreadHandler = null;
    mContent = new Object();
    mSPCache = new LruCache(5);
    AppMethodBeat.o(156249);
  }
  
  private MultiProcSharedPreferences()
  {
    AppMethodBeat.i(156232);
    this.mFileLock = null;
    this.mFile = null;
    this.mBackupFile = null;
    this.mMode = 0;
    this.mShouldLockFile = false;
    this.mMap = null;
    this.mDiskWritesInFlight = 0;
    this.mLoaded = false;
    this.mStatTimestamp = 0L;
    this.mStatSize = 0L;
    this.mWritingToDiskLock = new Object();
    this.mListeners = new WeakHashMap();
    RuntimeException localRuntimeException = new RuntimeException("Not supported.");
    AppMethodBeat.o(156232);
    throw localRuntimeException;
  }
  
  private MultiProcSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(156233);
    this.mFileLock = null;
    this.mFile = null;
    this.mBackupFile = null;
    this.mMode = 0;
    this.mShouldLockFile = false;
    this.mMap = null;
    this.mDiskWritesInFlight = 0;
    this.mLoaded = false;
    this.mStatTimestamp = 0L;
    this.mStatSize = 0L;
    this.mWritingToDiskLock = new Object();
    this.mListeners = new WeakHashMap();
    paramContext = paramContext.getApplicationContext();
    if (mMainThreadHandler == null) {
      mMainThreadHandler = new MMHandler(Looper.getMainLooper());
    }
    this.mFile = new File(getSharedPrefsDir(paramContext), paramString + ".xml");
    this.mBackupFile = makeBackupFile(this.mFile);
    this.mMode = paramInt;
    if ((paramInt & 0x4) != 0) {
      bool = true;
    }
    this.mShouldLockFile = bool;
    if (this.mShouldLockFile) {
      this.mFileLock = new FLock(this.mFile.getPath() + ".lock", true);
    }
    startLoadFromDisk();
    AppMethodBeat.o(156233);
  }
  
  private void awaitLoadedLocked()
  {
    AppMethodBeat.i(156237);
    while (!this.mLoaded) {
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException) {}
    }
    AppMethodBeat.o(156237);
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(244093);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(paramString);
    if (MultiProcSharedPreferences.DynamicConfigStorage.isEnabledMultiProcSP())
    {
      Log.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", new Object[] { paramString });
      MultiProcSharedPreferences localMultiProcSharedPreferences = (MultiProcSharedPreferences)mSPCache.get(paramString);
      if (localMultiProcSharedPreferences == null)
      {
        paramContext = new MultiProcSharedPreferences(paramContext, paramString, paramInt);
        mSPCache.put(paramString, paramContext);
      }
      for (;;)
      {
        MultiProcessMMKV.transport2MMKV(paramContext, localMultiProcessMMKV);
        AppMethodBeat.o(244093);
        return localMultiProcessMMKV;
        paramContext = localMultiProcSharedPreferences;
        if ((paramInt & 0x4) != 0) {
          if (paramBoolean)
          {
            localMultiProcSharedPreferences.startLoadFromDisk();
            paramContext = localMultiProcSharedPreferences;
          }
          else
          {
            localMultiProcSharedPreferences.startReloadIfChangedUnexpectedly();
            paramContext = localMultiProcSharedPreferences;
          }
        }
      }
    }
    Log.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", new Object[] { paramString });
    paramContext = paramContext.getSharedPreferences(paramString, paramInt);
    AppMethodBeat.o(244093);
    return paramContext;
  }
  
  private File getSharedPrefsDir(Context paramContext)
  {
    AppMethodBeat.i(244113);
    String str2 = paramContext.getApplicationInfo().dataDir;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      Log.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
      str1 = paramContext.getCacheDir().getParent();
    }
    Log.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: ".concat(String.valueOf(str1)));
    paramContext = new File(str1, "shared_prefs");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    for (;;)
    {
      AppMethodBeat.o(244113);
      return paramContext;
      if ((!paramContext.canRead()) || (!paramContext.canWrite()))
      {
        paramContext.setReadable(true, true);
        paramContext.setWritable(true, true);
      }
    }
  }
  
  private boolean hasFileChangedUnexpectedly()
  {
    AppMethodBeat.i(244133);
    if (this.mDiskWritesInFlight > 0)
    {
      AppMethodBeat.o(244133);
      return false;
    }
    if ((this.mStatTimestamp != this.mFile.lastModified()) || (this.mStatSize != this.mFile.length()))
    {
      AppMethodBeat.o(244133);
      return true;
    }
    AppMethodBeat.o(244133);
    return false;
  }
  
  /* Error */
  private void loadFromDiskLocked()
  {
    // Byte code:
    //   0: ldc_w 343
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 94	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mShouldLockFile	Z
    //   10: ifeq +10 -> 20
    //   13: aload_0
    //   14: getfield 86	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFileLock	Lcom/tencent/mm/sdk/platformtools/FLock;
    //   17: invokevirtual 346	com/tencent/mm/sdk/platformtools/FLock:lockRead	()V
    //   20: aload_0
    //   21: getfield 100	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mLoaded	Z
    //   24: istore_1
    //   25: iload_1
    //   26: ifeq +49 -> 75
    //   29: aload_0
    //   30: getfield 94	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mShouldLockFile	Z
    //   33: ifeq +35 -> 68
    //   36: aload_0
    //   37: getfield 86	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFileLock	Lcom/tencent/mm/sdk/platformtools/FLock;
    //   40: invokevirtual 349	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
    //   43: ldc_w 343
    //   46: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: return
    //   50: astore_2
    //   51: ldc 29
    //   53: aload_2
    //   54: ldc_w 351
    //   57: iconst_0
    //   58: anewarray 4	java/lang/Object
    //   61: invokestatic 355	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: goto -44 -> 20
    //   67: astore_2
    //   68: ldc_w 343
    //   71: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: return
    //   75: aload_0
    //   76: getfield 90	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mBackupFile	Ljava/io/File;
    //   79: invokevirtual 310	java/io/File:exists	()Z
    //   82: ifeq +23 -> 105
    //   85: aload_0
    //   86: getfield 88	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFile	Ljava/io/File;
    //   89: invokevirtual 358	java/io/File:delete	()Z
    //   92: pop
    //   93: aload_0
    //   94: getfield 90	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mBackupFile	Ljava/io/File;
    //   97: aload_0
    //   98: getfield 88	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFile	Ljava/io/File;
    //   101: invokevirtual 362	java/io/File:renameTo	(Ljava/io/File;)Z
    //   104: pop
    //   105: aload_0
    //   106: getfield 88	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFile	Ljava/io/File;
    //   109: invokevirtual 310	java/io/File:exists	()Z
    //   112: ifeq +44 -> 156
    //   115: aload_0
    //   116: getfield 88	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFile	Ljava/io/File;
    //   119: invokevirtual 316	java/io/File:canRead	()Z
    //   122: ifne +34 -> 156
    //   125: ldc 29
    //   127: new 145	java/lang/StringBuilder
    //   130: dup
    //   131: ldc_w 364
    //   134: invokespecial 365	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 88	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFile	Ljava/io/File;
    //   141: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: ldc_w 370
    //   147: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aconst_null
    //   157: astore 6
    //   159: aconst_null
    //   160: astore 7
    //   162: aconst_null
    //   163: astore 8
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_0
    //   168: getfield 88	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFile	Ljava/io/File;
    //   171: invokevirtual 316	java/io/File:canRead	()Z
    //   174: istore_1
    //   175: iload_1
    //   176: ifeq +67 -> 243
    //   179: aload 6
    //   181: astore_3
    //   182: aload 7
    //   184: astore 4
    //   186: aload 8
    //   188: astore 5
    //   190: new 372	java/io/BufferedInputStream
    //   193: dup
    //   194: new 374	java/io/FileInputStream
    //   197: dup
    //   198: aload_0
    //   199: getfield 88	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFile	Ljava/io/File;
    //   202: invokespecial 377	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   205: sipush 16384
    //   208: invokespecial 380	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   211: astore 9
    //   213: aload 6
    //   215: astore_3
    //   216: aload 7
    //   218: astore 4
    //   220: aload 8
    //   222: astore 5
    //   224: aload 9
    //   226: invokestatic 386	com/tencent/mm/sdk/platformtools/XmlUtils:readMapXml	(Ljava/io/InputStream;)Ljava/util/HashMap;
    //   229: astore_2
    //   230: aload_2
    //   231: astore_3
    //   232: aload_2
    //   233: astore 4
    //   235: aload_2
    //   236: astore 5
    //   238: aload 9
    //   240: invokevirtual 389	java/io/BufferedInputStream:close	()V
    //   243: aload_0
    //   244: iconst_1
    //   245: putfield 100	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mLoaded	Z
    //   248: aload_2
    //   249: ifnull +146 -> 395
    //   252: aload_0
    //   253: aload_2
    //   254: putfield 96	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mMap	Ljava/util/Map;
    //   257: aload_0
    //   258: aload_0
    //   259: getfield 88	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFile	Ljava/io/File;
    //   262: invokevirtual 332	java/io/File:lastModified	()J
    //   265: putfield 102	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mStatTimestamp	J
    //   268: aload_0
    //   269: aload_0
    //   270: getfield 88	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFile	Ljava/io/File;
    //   273: invokevirtual 334	java/io/File:length	()J
    //   276: putfield 104	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mStatSize	J
    //   279: aload_0
    //   280: invokevirtual 392	java/lang/Object:notifyAll	()V
    //   283: aload_0
    //   284: getfield 94	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mShouldLockFile	Z
    //   287: ifeq +130 -> 417
    //   290: aload_0
    //   291: getfield 86	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFileLock	Lcom/tencent/mm/sdk/platformtools/FLock;
    //   294: invokevirtual 349	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
    //   297: ldc_w 343
    //   300: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: return
    //   304: astore_2
    //   305: ldc 29
    //   307: ldc_w 393
    //   310: iconst_1
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload_2
    //   317: aastore
    //   318: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: aload_3
    //   322: astore_2
    //   323: goto -80 -> 243
    //   326: astore_2
    //   327: aload_0
    //   328: getfield 94	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mShouldLockFile	Z
    //   331: ifeq +10 -> 341
    //   334: aload_0
    //   335: getfield 86	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mFileLock	Lcom/tencent/mm/sdk/platformtools/FLock;
    //   338: invokevirtual 349	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
    //   341: ldc_w 343
    //   344: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aload_2
    //   348: athrow
    //   349: astore_2
    //   350: ldc 29
    //   352: ldc_w 393
    //   355: iconst_1
    //   356: anewarray 4	java/lang/Object
    //   359: dup
    //   360: iconst_0
    //   361: aload_2
    //   362: aastore
    //   363: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   366: aload 4
    //   368: astore_2
    //   369: goto -126 -> 243
    //   372: astore_2
    //   373: ldc 29
    //   375: ldc_w 393
    //   378: iconst_1
    //   379: anewarray 4	java/lang/Object
    //   382: dup
    //   383: iconst_0
    //   384: aload_2
    //   385: aastore
    //   386: invokestatic 395	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: aload 5
    //   391: astore_2
    //   392: goto -149 -> 243
    //   395: aload_0
    //   396: new 397	java/util/HashMap
    //   399: dup
    //   400: invokespecial 398	java/util/HashMap:<init>	()V
    //   403: putfield 96	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mMap	Ljava/util/Map;
    //   406: goto -127 -> 279
    //   409: astore_2
    //   410: ldc_w 343
    //   413: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   416: return
    //   417: ldc_w 343
    //   420: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: return
    //   424: astore_3
    //   425: goto -84 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	MultiProcSharedPreferences
    //   24	152	1	bool	boolean
    //   50	4	2	localException1	java.lang.Exception
    //   67	1	2	localException2	java.lang.Exception
    //   166	88	2	localHashMap	HashMap
    //   304	13	2	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    //   322	1	2	localObject1	Object
    //   326	22	2	localObject2	Object
    //   349	13	2	localFileNotFoundException	FileNotFoundException
    //   368	1	2	localObject3	Object
    //   372	13	2	localIOException	java.io.IOException
    //   391	1	2	localObject4	Object
    //   409	1	2	localException3	java.lang.Exception
    //   181	141	3	localObject5	Object
    //   424	1	3	localException4	java.lang.Exception
    //   184	183	4	localObject6	Object
    //   188	202	5	localObject7	Object
    //   157	57	6	localObject8	Object
    //   160	57	7	localObject9	Object
    //   163	58	8	localObject10	Object
    //   211	28	9	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   13	20	50	java/lang/Exception
    //   36	43	67	java/lang/Exception
    //   190	213	304	org/xmlpull/v1/XmlPullParserException
    //   224	230	304	org/xmlpull/v1/XmlPullParserException
    //   238	243	304	org/xmlpull/v1/XmlPullParserException
    //   20	25	326	finally
    //   75	105	326	finally
    //   105	156	326	finally
    //   167	175	326	finally
    //   190	213	326	finally
    //   224	230	326	finally
    //   238	243	326	finally
    //   243	248	326	finally
    //   252	279	326	finally
    //   279	283	326	finally
    //   305	321	326	finally
    //   350	366	326	finally
    //   373	389	326	finally
    //   395	406	326	finally
    //   190	213	349	java/io/FileNotFoundException
    //   224	230	349	java/io/FileNotFoundException
    //   238	243	349	java/io/FileNotFoundException
    //   190	213	372	java/io/IOException
    //   224	230	372	java/io/IOException
    //   238	243	372	java/io/IOException
    //   290	297	409	java/lang/Exception
    //   334	341	424	java/lang/Exception
  }
  
  private File makeBackupFile(File paramFile)
  {
    AppMethodBeat.i(244118);
    paramFile = new File(paramFile.getPath() + ".bak");
    AppMethodBeat.o(244118);
    return paramFile;
  }
  
  private static void setFilePermissionsFromMode(File paramFile, int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(244139);
    if ((paramInt & 0x1) == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramFile.setReadable(true, bool1);
      bool1 = bool2;
      if ((paramInt & 0x2) == 0) {
        bool1 = true;
      }
      paramFile.setWritable(true, bool1);
      AppMethodBeat.o(244139);
      return;
    }
  }
  
  private void startLoadFromDisk()
  {
    AppMethodBeat.i(156234);
    try
    {
      this.mLoaded = false;
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(156202);
          synchronized (MultiProcSharedPreferences.this)
          {
            MultiProcSharedPreferences.access$000(MultiProcSharedPreferences.this);
            AppMethodBeat.o(156202);
            return;
          }
        }
      };
      h.ahAA.bp(local1);
      AppMethodBeat.o(156234);
      return;
    }
    finally
    {
      AppMethodBeat.o(156234);
    }
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(156245);
    try
    {
      awaitLoadedLocked();
      boolean bool = this.mMap.containsKey(paramString);
      return bool;
    }
    finally
    {
      AppMethodBeat.o(156245);
    }
  }
  
  public SharedPreferences.Editor edit()
  {
    AppMethodBeat.i(156246);
    try
    {
      awaitLoadedLocked();
      EditorImpl localEditorImpl = new EditorImpl(null);
      AppMethodBeat.o(156246);
      return localEditorImpl;
    }
    finally
    {
      AppMethodBeat.o(156246);
    }
  }
  
  public Map<String, ?> getAll()
  {
    AppMethodBeat.i(156238);
    try
    {
      awaitLoadedLocked();
      HashMap localHashMap = new HashMap(this.mMap);
      return localHashMap;
    }
    finally
    {
      AppMethodBeat.o(156238);
    }
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156244);
    try
    {
      awaitLoadedLocked();
      paramString = (Boolean)this.mMap.get(paramString);
      if (paramString != null) {
        paramBoolean = paramString.booleanValue();
      }
      return paramBoolean;
    }
    finally
    {
      AppMethodBeat.o(156244);
    }
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    AppMethodBeat.i(156243);
    try
    {
      awaitLoadedLocked();
      paramString = (Float)this.mMap.get(paramString);
      if (paramString != null) {
        paramFloat = paramString.floatValue();
      }
      return paramFloat;
    }
    finally
    {
      AppMethodBeat.o(156243);
    }
  }
  
  public int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(156241);
    try
    {
      awaitLoadedLocked();
      paramString = (Integer)this.mMap.get(paramString);
      if (paramString != null) {
        paramInt = paramString.intValue();
      }
      return paramInt;
    }
    finally
    {
      AppMethodBeat.o(156241);
    }
  }
  
  public long getLong(String paramString, long paramLong)
  {
    AppMethodBeat.i(156242);
    try
    {
      awaitLoadedLocked();
      paramString = (Long)this.mMap.get(paramString);
      if (paramString != null) {
        paramLong = paramString.longValue();
      }
      return paramLong;
    }
    finally
    {
      AppMethodBeat.o(156242);
    }
  }
  
  /* Error */
  public String getString(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 480
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: invokespecial 423	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:awaitLoadedLocked	()V
    //   12: aload_0
    //   13: getfield 96	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mMap	Ljava/util/Map;
    //   16: aload_1
    //   17: invokeinterface 447 2 0
    //   22: checkcast 274	java/lang/String
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: monitorexit
    //   32: ldc_w 480
    //   35: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: aload_2
    //   41: astore_1
    //   42: goto -12 -> 30
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc_w 480
    //   51: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	MultiProcSharedPreferences
    //   0	56	1	paramString1	String
    //   0	56	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   8	26	45	finally
    //   30	32	45	finally
  }
  
  /* Error */
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    // Byte code:
    //   0: ldc_w 483
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: invokespecial 423	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:awaitLoadedLocked	()V
    //   12: aload_0
    //   13: getfield 96	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:mMap	Ljava/util/Map;
    //   16: aload_1
    //   17: invokeinterface 447 2 0
    //   22: checkcast 485	java/util/Set
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: monitorexit
    //   32: ldc_w 483
    //   35: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: aload_1
    //   39: areturn
    //   40: aload_2
    //   41: astore_1
    //   42: goto -12 -> 30
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc_w 483
    //   51: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	MultiProcSharedPreferences
    //   0	56	1	paramString	String
    //   0	56	2	paramSet	Set<String>
    // Exception table:
    //   from	to	target	type
    //   8	26	45	finally
    //   30	32	45	finally
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(156235);
    try
    {
      this.mListeners.put(paramOnSharedPreferenceChangeListener, mContent);
      return;
    }
    finally
    {
      AppMethodBeat.o(156235);
    }
  }
  
  public void startReloadIfChangedUnexpectedly()
  {
    AppMethodBeat.i(244200);
    try
    {
      if (!hasFileChangedUnexpectedly()) {
        return;
      }
      startLoadFromDisk();
      return;
    }
    finally
    {
      AppMethodBeat.o(244200);
    }
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    AppMethodBeat.i(156236);
    try
    {
      this.mListeners.remove(paramOnSharedPreferenceChangeListener);
      return;
    }
    finally
    {
      AppMethodBeat.o(156236);
    }
  }
  
  final class EditorImpl
    implements SharedPreferences.Editor
  {
    private boolean mClear;
    private final Map<String, Object> mModified;
    
    private EditorImpl()
    {
      AppMethodBeat.i(156213);
      this.mModified = new HashMap();
      this.mClear = false;
      AppMethodBeat.o(156213);
    }
    
    private MultiProcSharedPreferences.MemoryCommitResult commitToMemory()
    {
      AppMethodBeat.i(156223);
      MultiProcSharedPreferences.MemoryCommitResult localMemoryCommitResult1 = new MultiProcSharedPreferences.MemoryCommitResult(null);
      for (;;)
      {
        Object localObject2;
        String str;
        synchronized (MultiProcSharedPreferences.this)
        {
          if (MultiProcSharedPreferences.this.mDiskWritesInFlight > 0) {
            MultiProcSharedPreferences.access$402(MultiProcSharedPreferences.this, new HashMap(MultiProcSharedPreferences.this.mMap));
          }
          localMemoryCommitResult1.mapToWriteToDisk = MultiProcSharedPreferences.this.mMap;
          MultiProcSharedPreferences.access$308(MultiProcSharedPreferences.this);
          if (MultiProcSharedPreferences.this.mListeners.size() > 0)
          {
            i = 1;
            if (i != 0)
            {
              localMemoryCommitResult1.keysModified = new ArrayList();
              localMemoryCommitResult1.listeners = new HashSet(MultiProcSharedPreferences.this.mListeners.keySet());
            }
            try
            {
              if (this.mClear)
              {
                if (!MultiProcSharedPreferences.this.mMap.isEmpty())
                {
                  localMemoryCommitResult1.changesMade = true;
                  MultiProcSharedPreferences.this.mMap.clear();
                }
                this.mClear = false;
              }
              Iterator localIterator = this.mModified.entrySet().iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              localObject2 = (Map.Entry)localIterator.next();
              str = (String)((Map.Entry)localObject2).getKey();
              localObject2 = ((Map.Entry)localObject2).getValue();
              if (localObject2 != this) {
                break label315;
              }
              if (!MultiProcSharedPreferences.this.mMap.containsKey(str)) {
                continue;
              }
              MultiProcSharedPreferences.this.mMap.remove(str);
              localMemoryCommitResult1.changesMade = true;
              if (i == 0) {
                continue;
              }
              localMemoryCommitResult1.keysModified.add(str);
              continue;
              localMemoryCommitResult2 = finally;
            }
            finally
            {
              AppMethodBeat.o(156223);
            }
          }
        }
        int i = 0;
        continue;
        label315:
        if (MultiProcSharedPreferences.this.mMap.containsKey(str))
        {
          Object localObject3 = MultiProcSharedPreferences.this.mMap.get(str);
          if ((localObject3 != null) && (localObject3.equals(localObject2))) {}
        }
        else
        {
          MultiProcSharedPreferences.this.mMap.put(str, localObject2);
        }
      }
      this.mModified.clear();
      AppMethodBeat.o(156223);
      return localMemoryCommitResult2;
    }
    
    private FileOutputStream createFileOutputStream(File paramFile)
    {
      AppMethodBeat.i(156225);
      try
      {
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        paramFile = localFileOutputStream;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          Object localObject = paramFile.getParentFile();
          if (!((File)localObject).mkdir())
          {
            Log.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file ".concat(String.valueOf(paramFile)));
            AppMethodBeat.o(156225);
            return null;
          }
          MultiProcSharedPreferences.access$900((File)localObject, MultiProcSharedPreferences.this.mMode);
          try
          {
            localObject = new FileOutputStream(paramFile);
            paramFile = (File)localObject;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            Log.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file ".concat(String.valueOf(paramFile)), new Object[] { localFileNotFoundException2 });
            paramFile = null;
          }
        }
      }
      AppMethodBeat.o(156225);
      return paramFile;
    }
    
    private void enqueueDiskWrite(final MultiProcSharedPreferences.MemoryCommitResult paramMemoryCommitResult, Runnable arg2)
    {
      int j = 1;
      AppMethodBeat.i(156224);
      paramMemoryCommitResult = new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(156211);
          synchronized (MultiProcSharedPreferences.this.mWritingToDiskLock)
          {
            MultiProcSharedPreferences.EditorImpl.access$700(MultiProcSharedPreferences.EditorImpl.this, paramMemoryCommitResult);
          }
          synchronized (MultiProcSharedPreferences.this)
          {
            MultiProcSharedPreferences.access$310(MultiProcSharedPreferences.this);
            if (paramRunnable != null) {
              paramRunnable.run();
            }
            AppMethodBeat.o(156211);
            return;
            localObject2 = finally;
            AppMethodBeat.o(156211);
            throw localObject2;
          }
        }
      };
      int i;
      if (??? == null) {
        i = 1;
      }
      while (i != 0) {
        synchronized (MultiProcSharedPreferences.this)
        {
          if (MultiProcSharedPreferences.this.mDiskWritesInFlight == 1)
          {
            i = j;
            if (i != 0)
            {
              paramMemoryCommitResult.run();
              AppMethodBeat.o(156224);
              return;
              i = 0;
            }
          }
          else
          {
            i = 0;
          }
        }
      }
      QueuedWork.singleThreadExecutor().execute(paramMemoryCommitResult);
      AppMethodBeat.o(156224);
    }
    
    private void notifyListeners(final MultiProcSharedPreferences.MemoryCommitResult paramMemoryCommitResult)
    {
      AppMethodBeat.i(156226);
      if ((paramMemoryCommitResult.listeners == null) || (paramMemoryCommitResult.keysModified == null) || (paramMemoryCommitResult.keysModified.size() == 0))
      {
        AppMethodBeat.o(156226);
        return;
      }
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        int i = paramMemoryCommitResult.keysModified.size() - 1;
        while (i >= 0)
        {
          String str = (String)paramMemoryCommitResult.keysModified.get(i);
          Iterator localIterator = paramMemoryCommitResult.listeners.iterator();
          while (localIterator.hasNext())
          {
            SharedPreferences.OnSharedPreferenceChangeListener localOnSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next();
            if (localOnSharedPreferenceChangeListener != null) {
              localOnSharedPreferenceChangeListener.onSharedPreferenceChanged(MultiProcSharedPreferences.this, str);
            }
          }
          i -= 1;
        }
        AppMethodBeat.o(156226);
        return;
      }
      MultiProcSharedPreferences.mMainThreadHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(156212);
          MultiProcSharedPreferences.EditorImpl.access$1600(MultiProcSharedPreferences.EditorImpl.this, paramMemoryCommitResult);
          AppMethodBeat.o(156212);
        }
      });
      AppMethodBeat.o(156226);
    }
    
    /* Error */
    private void writeToFile(MultiProcSharedPreferences.MemoryCommitResult paramMemoryCommitResult)
    {
      // Byte code:
      //   0: ldc_w 297
      //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   10: invokestatic 301	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1000	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Z
      //   13: ifeq +13 -> 26
      //   16: aload_0
      //   17: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   20: invokestatic 305	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1100	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Lcom/tencent/mm/sdk/platformtools/FLock;
      //   23: invokevirtual 310	com/tencent/mm/sdk/platformtools/FLock:lockWrite	()V
      //   26: aload_0
      //   27: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   30: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   33: invokevirtual 317	java/io/File:exists	()Z
      //   36: ifeq +241 -> 277
      //   39: aload_0
      //   40: monitorenter
      //   41: aload_1
      //   42: getfield 132	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$MemoryCommitResult:changesMade	Z
      //   45: ifne +62 -> 107
      //   48: aload_1
      //   49: iconst_1
      //   50: invokevirtual 321	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$MemoryCommitResult:setDiskWriteResult	(Z)V
      //   53: aload_0
      //   54: monitorexit
      //   55: aload_0
      //   56: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   59: invokestatic 301	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1000	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Z
      //   62: ifeq +38 -> 100
      //   65: aload_0
      //   66: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   69: invokestatic 305	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1100	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Lcom/tencent/mm/sdk/platformtools/FLock;
      //   72: invokevirtual 324	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
      //   75: ldc_w 297
      //   78: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   81: return
      //   82: astore_2
      //   83: ldc 207
      //   85: aload_2
      //   86: ldc_w 326
      //   89: iconst_0
      //   90: anewarray 4	java/lang/Object
      //   93: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   96: goto -70 -> 26
      //   99: astore_1
      //   100: ldc_w 297
      //   103: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   106: return
      //   107: aload_0
      //   108: monitorexit
      //   109: aload_0
      //   110: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   113: invokestatic 333	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1300	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   116: invokevirtual 317	java/io/File:exists	()Z
      //   119: ifne +147 -> 266
      //   122: aload_0
      //   123: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   126: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   129: aload_0
      //   130: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   133: invokestatic 333	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1300	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   136: invokevirtual 337	java/io/File:renameTo	(Ljava/io/File;)Z
      //   139: ifne +138 -> 277
      //   142: ldc 207
      //   144: new 339	java/lang/StringBuilder
      //   147: dup
      //   148: ldc_w 341
      //   151: invokespecial 344	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   154: aload_0
      //   155: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   158: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   161: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   164: ldc_w 350
      //   167: invokevirtual 353	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: aload_0
      //   171: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   174: invokestatic 333	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1300	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   177: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   180: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   183: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   186: aload_1
      //   187: iconst_0
      //   188: invokevirtual 321	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$MemoryCommitResult:setDiskWriteResult	(Z)V
      //   191: aload_0
      //   192: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   195: invokestatic 301	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1000	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Z
      //   198: ifeq +61 -> 259
      //   201: aload_0
      //   202: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   205: invokestatic 305	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1100	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Lcom/tencent/mm/sdk/platformtools/FLock;
      //   208: invokevirtual 324	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
      //   211: ldc_w 297
      //   214: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   217: return
      //   218: astore_1
      //   219: aload_0
      //   220: monitorexit
      //   221: ldc_w 297
      //   224: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   227: aload_1
      //   228: athrow
      //   229: astore_1
      //   230: aload_0
      //   231: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   234: invokestatic 301	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1000	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Z
      //   237: ifeq +13 -> 250
      //   240: aload_0
      //   241: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   244: invokestatic 305	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1100	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Lcom/tencent/mm/sdk/platformtools/FLock;
      //   247: invokevirtual 324	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
      //   250: ldc_w 297
      //   253: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   256: aload_1
      //   257: athrow
      //   258: astore_1
      //   259: ldc_w 297
      //   262: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   265: return
      //   266: aload_0
      //   267: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   270: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   273: invokevirtual 360	java/io/File:delete	()Z
      //   276: pop
      //   277: aload_0
      //   278: aload_0
      //   279: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   282: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   285: invokespecial 362	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:createFileOutputStream	(Ljava/io/File;)Ljava/io/FileOutputStream;
      //   288: astore_2
      //   289: aload_2
      //   290: ifnonnull +43 -> 333
      //   293: aload_1
      //   294: iconst_0
      //   295: invokevirtual 321	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$MemoryCommitResult:setDiskWriteResult	(Z)V
      //   298: aload_0
      //   299: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   302: invokestatic 301	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1000	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Z
      //   305: ifeq +21 -> 326
      //   308: aload_0
      //   309: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   312: invokestatic 305	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1100	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Lcom/tencent/mm/sdk/platformtools/FLock;
      //   315: invokevirtual 324	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
      //   318: ldc_w 297
      //   321: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   324: return
      //   325: astore_1
      //   326: ldc_w 297
      //   329: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   332: return
      //   333: aload_1
      //   334: getfield 90	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$MemoryCommitResult:mapToWriteToDisk	Ljava/util/Map;
      //   337: aload_2
      //   338: invokestatic 368	com/tencent/mm/sdk/platformtools/XmlUtils:writeMapXml	(Ljava/util/Map;Ljava/io/OutputStream;)V
      //   341: aload_2
      //   342: invokevirtual 372	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
      //   345: invokevirtual 377	java/io/FileDescriptor:sync	()V
      //   348: aload_2
      //   349: invokevirtual 380	java/io/FileOutputStream:close	()V
      //   352: aload_0
      //   353: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   356: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   359: aload_0
      //   360: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   363: invokestatic 226	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$800	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)I
      //   366: invokestatic 230	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$900	(Ljava/io/File;I)V
      //   369: aload_0
      //   370: monitorenter
      //   371: aload_0
      //   372: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   375: aload_0
      //   376: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   379: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   382: invokevirtual 384	java/io/File:lastModified	()J
      //   385: invokestatic 388	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1402	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;J)J
      //   388: pop2
      //   389: aload_0
      //   390: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   393: aload_0
      //   394: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   397: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   400: invokevirtual 391	java/io/File:length	()J
      //   403: invokestatic 394	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1502	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;J)J
      //   406: pop2
      //   407: aload_0
      //   408: monitorexit
      //   409: aload_0
      //   410: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   413: invokestatic 333	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1300	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   416: invokevirtual 360	java/io/File:delete	()Z
      //   419: pop
      //   420: aload_1
      //   421: iconst_1
      //   422: invokevirtual 321	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$MemoryCommitResult:setDiskWriteResult	(Z)V
      //   425: aload_0
      //   426: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   429: invokestatic 301	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1000	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Z
      //   432: ifeq +135 -> 567
      //   435: aload_0
      //   436: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   439: invokestatic 305	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1100	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Lcom/tencent/mm/sdk/platformtools/FLock;
      //   442: invokevirtual 324	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
      //   445: ldc_w 297
      //   448: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   451: return
      //   452: astore_2
      //   453: aload_0
      //   454: monitorexit
      //   455: ldc_w 297
      //   458: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   461: aload_2
      //   462: athrow
      //   463: astore_2
      //   464: ldc 207
      //   466: ldc_w 396
      //   469: iconst_1
      //   470: anewarray 4	java/lang/Object
      //   473: dup
      //   474: iconst_0
      //   475: aload_2
      //   476: aastore
      //   477: invokestatic 399	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   480: aload_0
      //   481: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   484: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   487: invokevirtual 317	java/io/File:exists	()Z
      //   490: ifeq +44 -> 534
      //   493: aload_0
      //   494: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   497: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   500: invokevirtual 360	java/io/File:delete	()Z
      //   503: ifne +31 -> 534
      //   506: ldc 207
      //   508: new 339	java/lang/StringBuilder
      //   511: dup
      //   512: ldc_w 401
      //   515: invokespecial 344	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   518: aload_0
      //   519: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   522: invokestatic 314	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1200	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Ljava/io/File;
      //   525: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   528: invokevirtual 357	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   531: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   534: aload_1
      //   535: iconst_0
      //   536: invokevirtual 321	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$MemoryCommitResult:setDiskWriteResult	(Z)V
      //   539: aload_0
      //   540: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   543: invokestatic 301	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1000	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Z
      //   546: ifeq +56 -> 602
      //   549: aload_0
      //   550: getfield 28	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences$EditorImpl:this$0	Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;
      //   553: invokestatic 305	com/tencent/mm/sdk/platformtools/MultiProcSharedPreferences:access$1100	(Lcom/tencent/mm/sdk/platformtools/MultiProcSharedPreferences;)Lcom/tencent/mm/sdk/platformtools/FLock;
      //   556: invokevirtual 324	com/tencent/mm/sdk/platformtools/FLock:unlock	()V
      //   559: ldc_w 297
      //   562: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   565: return
      //   566: astore_1
      //   567: ldc_w 297
      //   570: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   573: return
      //   574: astore_2
      //   575: ldc 207
      //   577: ldc_w 396
      //   580: iconst_1
      //   581: anewarray 4	java/lang/Object
      //   584: dup
      //   585: iconst_0
      //   586: aload_2
      //   587: aastore
      //   588: invokestatic 399	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   591: goto -111 -> 480
      //   594: astore_1
      //   595: ldc_w 297
      //   598: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   601: return
      //   602: ldc_w 297
      //   605: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   608: return
      //   609: astore_2
      //   610: goto -360 -> 250
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	613	0	this	EditorImpl
      //   0	613	1	paramMemoryCommitResult	MultiProcSharedPreferences.MemoryCommitResult
      //   82	4	2	localException1	java.lang.Exception
      //   288	61	2	localFileOutputStream	FileOutputStream
      //   452	10	2	localObject	Object
      //   463	13	2	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
      //   574	13	2	localIOException	java.io.IOException
      //   609	1	2	localException2	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   16	26	82	java/lang/Exception
      //   65	75	99	java/lang/Exception
      //   41	55	218	finally
      //   26	41	229	finally
      //   107	191	229	finally
      //   219	229	229	finally
      //   266	277	229	finally
      //   277	289	229	finally
      //   293	298	229	finally
      //   333	371	229	finally
      //   409	425	229	finally
      //   453	463	229	finally
      //   464	480	229	finally
      //   480	534	229	finally
      //   534	539	229	finally
      //   575	591	229	finally
      //   201	211	258	java/lang/Exception
      //   308	318	325	java/lang/Exception
      //   371	409	452	finally
      //   277	289	463	org/xmlpull/v1/XmlPullParserException
      //   293	298	463	org/xmlpull/v1/XmlPullParserException
      //   333	371	463	org/xmlpull/v1/XmlPullParserException
      //   409	425	463	org/xmlpull/v1/XmlPullParserException
      //   453	463	463	org/xmlpull/v1/XmlPullParserException
      //   435	445	566	java/lang/Exception
      //   277	289	574	java/io/IOException
      //   293	298	574	java/io/IOException
      //   333	371	574	java/io/IOException
      //   409	425	574	java/io/IOException
      //   453	463	574	java/io/IOException
      //   549	559	594	java/lang/Exception
      //   240	250	609	java/lang/Exception
    }
    
    public final void apply()
    {
      AppMethodBeat.i(156222);
      final MultiProcSharedPreferences.MemoryCommitResult localMemoryCommitResult = commitToMemory();
      final Runnable local1 = new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(156209);
          try
          {
            localMemoryCommitResult.writtenToDiskLatch.await();
            AppMethodBeat.o(156209);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            AppMethodBeat.o(156209);
          }
        }
      };
      QueuedWork.add(local1);
      enqueueDiskWrite(localMemoryCommitResult, new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(156210);
          local1.run();
          QueuedWork.remove(local1);
          AppMethodBeat.o(156210);
        }
      });
      notifyListeners(localMemoryCommitResult);
      AppMethodBeat.o(156222);
    }
    
    public final SharedPreferences.Editor clear()
    {
      try
      {
        this.mClear = true;
        return this;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final boolean commit()
    {
      AppMethodBeat.i(156221);
      MultiProcSharedPreferences.MemoryCommitResult localMemoryCommitResult = commitToMemory();
      enqueueDiskWrite(localMemoryCommitResult, null);
      try
      {
        localMemoryCommitResult.writtenToDiskLatch.await();
        notifyListeners(localMemoryCommitResult);
        boolean bool = localMemoryCommitResult.writeToDiskResult;
        AppMethodBeat.o(156221);
        return bool;
      }
      catch (InterruptedException localInterruptedException)
      {
        AppMethodBeat.o(156221);
      }
      return false;
    }
    
    public final SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(156219);
      try
      {
        this.mModified.put(paramString, Boolean.valueOf(paramBoolean));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156219);
      }
    }
    
    public final SharedPreferences.Editor putFloat(String paramString, float paramFloat)
    {
      AppMethodBeat.i(156218);
      try
      {
        this.mModified.put(paramString, Float.valueOf(paramFloat));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156218);
      }
    }
    
    public final SharedPreferences.Editor putInt(String paramString, int paramInt)
    {
      AppMethodBeat.i(156216);
      try
      {
        this.mModified.put(paramString, Integer.valueOf(paramInt));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156216);
      }
    }
    
    public final SharedPreferences.Editor putLong(String paramString, long paramLong)
    {
      AppMethodBeat.i(156217);
      try
      {
        this.mModified.put(paramString, Long.valueOf(paramLong));
        return this;
      }
      finally
      {
        AppMethodBeat.o(156217);
      }
    }
    
    public final SharedPreferences.Editor putString(String paramString1, String paramString2)
    {
      AppMethodBeat.i(156214);
      try
      {
        this.mModified.put(paramString1, paramString2);
        return this;
      }
      finally
      {
        AppMethodBeat.o(156214);
      }
    }
    
    public final SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
    {
      AppMethodBeat.i(156215);
      try
      {
        this.mModified.put(paramString, paramSet);
        return this;
      }
      finally
      {
        AppMethodBeat.o(156215);
      }
    }
    
    public final SharedPreferences.Editor remove(String paramString)
    {
      AppMethodBeat.i(156220);
      try
      {
        this.mModified.put(paramString, this);
        return this;
      }
      finally
      {
        AppMethodBeat.o(156220);
      }
    }
  }
  
  static class MemoryCommitResult
  {
    public boolean changesMade;
    public List<String> keysModified;
    public Set<SharedPreferences.OnSharedPreferenceChangeListener> listeners;
    public Map<String, Object> mapToWriteToDisk;
    public volatile boolean writeToDiskResult;
    public final CountDownLatch writtenToDiskLatch;
    
    private MemoryCommitResult()
    {
      AppMethodBeat.i(156229);
      this.changesMade = false;
      this.keysModified = null;
      this.listeners = null;
      this.mapToWriteToDisk = null;
      this.writtenToDiskLatch = new CountDownLatch(1);
      this.writeToDiskResult = false;
      AppMethodBeat.o(156229);
    }
    
    public void setDiskWriteResult(boolean paramBoolean)
    {
      AppMethodBeat.i(156230);
      this.writeToDiskResult = paramBoolean;
      this.writtenToDiskLatch.countDown();
      AppMethodBeat.o(156230);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences
 * JD-Core Version:    0.7.0.1
 */