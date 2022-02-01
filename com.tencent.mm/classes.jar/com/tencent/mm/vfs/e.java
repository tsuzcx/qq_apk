package com.tencent.mm.vfs;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.OperationCanceledException;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class e
  implements Handler.Callback
{
  private static volatile b OAA = null;
  private static volatile boolean OAB = true;
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Context sContext = null;
  private h OAC;
  private int OAD;
  private e OAE;
  final h OAF;
  private final File OAG;
  final HandlerThread OAH;
  private final c OAI;
  private final Handler OAJ;
  private volatile long OAK;
  private volatile long OAL;
  private volatile boolean OAM;
  volatile d OAN;
  volatile boolean OAO;
  private volatile BroadcastReceiver OAP;
  final Context mContext;
  private final Object mLock;
  
  private e()
  {
    AppMethodBeat.i(13122);
    this.mLock = new Object();
    this.mContext = sContext;
    if (this.mContext == null)
    {
      localObject1 = new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
      AppMethodBeat.o(13122);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = this.mContext.getFilesDir().getParentFile();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.mContext.getCacheDir();
    }
    this.OAG = new File((File)localObject1, ".vfs");
    this.OAH = new HandlerThread("VFS.Maintenance", 4);
    this.OAH.start();
    this.OAJ = new Handler(this.OAH.getLooper(), this);
    this.OAI = new c((byte)0);
    this.OAK = -1L;
    this.OAL = 9223372036854775807L;
    this.OAO = true;
    Object localObject3 = this.mContext;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put(null, FileSchemeResolver.fSO());
    ((HashMap)localObject1).put("", FileSchemeResolver.fSO());
    ((HashMap)localObject1).put("file", FileSchemeResolver.fSO());
    ((HashMap)localObject1).put("wcf", WcfSchemeResolver.fSO());
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("data", ((Context)localObject3).getCacheDir().getParent());
    ((HashMap)localObject2).put("dataCache", ((Context)localObject3).getCacheDir().getPath());
    localObject3 = ((Context)localObject3).getExternalCacheDir();
    if (localObject3 != null)
    {
      ((HashMap)localObject2).put("extData", ((File)localObject3).getParent());
      ((HashMap)localObject2).put("extCache", ((File)localObject3).getPath());
    }
    localObject3 = Environment.getExternalStorageDirectory();
    if (localObject3 != null) {
      ((HashMap)localObject2).put("storage", ((File)localObject3).getPath());
    }
    this.OAF = new h().a((Map)localObject1, Collections.emptyMap(), new TreeMap(), (Map)localObject2, null);
    this.OAC = this.OAF;
    this.OAD = 0;
    this.OAE = new e(null, null, this.OAD, (byte)0);
    AppMethodBeat.o(13122);
  }
  
  private void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(170153);
    File localFile = new File(this.OAG, "maintain.timestamp");
    h localh;
    String str;
    Object localObject2;
    synchronized (this.mLock)
    {
      localh = this.OAC;
      ??? = localh.LHs.keySet().iterator();
      if (((Iterator)???).hasNext())
      {
        str = (String)((Iterator)???).next();
        localObject2 = localh.aZQ(str);
        Log.i("VFS.FileSystemManager", "[Maintenance] " + str + " => " + ((SchemeResolver.a)localObject2).fTd().toString());
      }
    }
    ??? = localh.LHt.keySet().iterator();
    while (((Iterator)???).hasNext())
    {
      str = (String)((Iterator)???).next();
      localObject2 = localh.aZO(str);
      Log.i("VFS.FileSystemManager", "[Maintenance] " + str + " => " + ((FileSystem.b)localObject2).fSK().toString());
      ((FileSystem.b)localObject2).a(paramCancellationSignal);
    }
    try
    {
      localFile.createNewFile();
      localFile.setLastModified(System.currentTimeMillis());
      AppMethodBeat.o(170153);
      return;
    }
    catch (IOException paramCancellationSignal)
    {
      Log.w("VFS.FileSystemManager", "Unable to update maintenance timestamp: " + paramCancellationSignal.getMessage());
      AppMethodBeat.o(170153);
    }
  }
  
  public static void a(b paramb)
  {
    OAA = paramb;
  }
  
  /* Error */
  private void a(h paramh)
  {
    // Byte code:
    //   0: sipush 13125
    //   3: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 391	com/tencent/mm/vfs/h:ebW	()Landroid/os/Bundle;
    //   10: astore 5
    //   12: invokestatic 397	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   15: astore_2
    //   16: aload_2
    //   17: aload 5
    //   19: invokevirtual 401	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   22: aload_2
    //   23: invokevirtual 405	android/os/Parcel:marshall	()[B
    //   26: astore 4
    //   28: aload_2
    //   29: invokevirtual 408	android/os/Parcel:recycle	()V
    //   32: new 410	java/io/DataOutputStream
    //   35: dup
    //   36: new 412	java/io/FileOutputStream
    //   39: dup
    //   40: new 102	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: getfield 115	com/tencent/mm/vfs/e:OAG	Ljava/io/File;
    //   48: ldc_w 414
    //   51: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: invokespecial 417	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 420	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: iconst_3
    //   65: invokevirtual 423	java/io/DataOutputStream:writeInt	(I)V
    //   68: aload_3
    //   69: astore_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokevirtual 427	java/io/DataOutputStream:write	([B)V
    //   76: aload_3
    //   77: invokestatic 433	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: getfield 84	com/tencent/mm/vfs/e:mContext	Landroid/content/Context;
    //   84: invokevirtual 436	android/content/Context:getPackageName	()Ljava/lang/String;
    //   87: astore_2
    //   88: new 438	android/content/Intent
    //   91: dup
    //   92: new 271	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   99: aload_2
    //   100: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 440
    //   106: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 441	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   115: astore_2
    //   116: aload_2
    //   117: aload 5
    //   119: invokevirtual 445	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   122: pop
    //   123: aload_2
    //   124: ldc_w 447
    //   127: invokestatic 453	android/os/Process:myPid	()I
    //   130: invokevirtual 457	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   133: pop
    //   134: aload_0
    //   135: getfield 84	com/tencent/mm/vfs/e:mContext	Landroid/content/Context;
    //   138: aload_2
    //   139: invokevirtual 461	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   142: new 271	java/lang/StringBuilder
    //   145: dup
    //   146: sipush 2048
    //   149: invokespecial 463	java/lang/StringBuilder:<init>	(I)V
    //   152: astore_2
    //   153: aload_2
    //   154: ldc_w 465
    //   157: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: getfield 239	com/tencent/mm/vfs/h:LHs	Ljava/util/Map;
    //   165: aload_2
    //   166: invokestatic 365	com/tencent/mm/vfs/e:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   169: aload_2
    //   170: ldc_w 367
    //   173: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: getfield 298	com/tencent/mm/vfs/h:LHt	Ljava/util/Map;
    //   181: aload_2
    //   182: invokestatic 365	com/tencent/mm/vfs/e:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   185: aload_2
    //   186: ldc_w 372
    //   189: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: getfield 469	com/tencent/mm/vfs/h:LHu	Ljava/util/SortedMap;
    //   197: aload_2
    //   198: invokestatic 365	com/tencent/mm/vfs/e:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   201: aload_2
    //   202: ldc_w 374
    //   205: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_1
    //   210: getfield 472	com/tencent/mm/vfs/h:LHw	Ljava/util/Map;
    //   213: aload_2
    //   214: invokestatic 365	com/tencent/mm/vfs/e:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   217: aload_2
    //   218: ldc_w 376
    //   221: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_1
    //   225: getfield 475	com/tencent/mm/vfs/h:LHx	Lcom/tencent/mm/vfs/d;
    //   228: invokevirtual 289	java/lang/Object:toString	()Ljava/lang/String;
    //   231: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: bipush 10
    //   236: invokevirtual 382	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc_w 269
    //   243: new 271	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 477
    //   250: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_2
    //   254: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 295	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: sipush 13125
    //   269: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: return
    //   273: astore 4
    //   275: aconst_null
    //   276: astore_3
    //   277: aload_3
    //   278: astore_2
    //   279: ldc_w 269
    //   282: new 271	java/lang/StringBuilder
    //   285: dup
    //   286: ldc_w 479
    //   289: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   292: aload 4
    //   294: invokevirtual 328	java/io/IOException:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 481	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_3
    //   307: invokestatic 433	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   310: goto -230 -> 80
    //   313: astore_1
    //   314: aconst_null
    //   315: astore_2
    //   316: aload_2
    //   317: invokestatic 433	com/tencent/mm/vfs/w:closeQuietly	(Ljava/io/Closeable;)V
    //   320: sipush 13125
    //   323: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: aload_1
    //   327: athrow
    //   328: astore_1
    //   329: goto -13 -> 316
    //   332: astore 4
    //   334: goto -57 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	e
    //   0	337	1	paramh	h
    //   15	302	2	localObject	Object
    //   60	247	3	localDataOutputStream	java.io.DataOutputStream
    //   26	46	4	arrayOfByte	byte[]
    //   273	20	4	localIOException1	IOException
    //   332	1	4	localIOException2	IOException
    //   10	108	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   32	61	273	java/io/IOException
    //   32	61	313	finally
    //   63	68	328	finally
    //   70	76	328	finally
    //   279	306	328	finally
    //   63	68	332	java/io/IOException
    //   70	76	332	java/io/IOException
  }
  
  private static <K, V> void a(Map<K, V> paramMap, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(13124);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramStringBuilder.append("  ").append(localEntry.getKey());
      if (localEntry.getValue() == null) {
        paramStringBuilder.append(" (deleted)\n");
      } else {
        paramStringBuilder.append(" => ").append(localEntry.getValue().toString()).append('\n');
      }
    }
    AppMethodBeat.o(13124);
  }
  
  private void bk(Bundle paramBundle)
  {
    AppMethodBeat.i(13123);
    ??? = paramBundle;
    if (paramBundle == null) {
      ??? = new Bundle();
    }
    if (((Bundle)???).getInt("pid") == Process.myPid())
    {
      Log.v("VFS.FileSystemManager", "Ignore filesystem change broadcast from the same process.");
      AppMethodBeat.o(13123);
      return;
    }
    paramBundle = h.bl((Bundle)???);
    synchronized (this.mLock)
    {
      this.OAC = paramBundle;
      this.OAD += 1;
      this.OAE = new e(null, null, this.OAD, (byte)0);
      ??? = new StringBuilder(2048);
      ((StringBuilder)???).append("[Schemes]\n");
      a(paramBundle.LHs, (StringBuilder)???);
      ((StringBuilder)???).append("[File systems]\n");
      a(paramBundle.LHt, (StringBuilder)???);
      ((StringBuilder)???).append("[Mount points]\n");
      a(paramBundle.LHu, (StringBuilder)???);
      ((StringBuilder)???).append("[Environment]\n");
      a(paramBundle.LHw, (StringBuilder)???);
      ((StringBuilder)???).append("[Root]\n  ").append(paramBundle.LHx.toString()).append('\n');
      Log.i("VFS.FileSystemManager", "Loaded file system from bundle:\n" + ((StringBuilder)???).toString());
      AppMethodBeat.o(13123);
      return;
    }
  }
  
  public static e fSU()
  {
    return f.LGF;
  }
  
  static b gEj()
  {
    return OAA;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(13117);
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {}
    for (;;)
    {
      sContext = paramContext;
      AppMethodBeat.o(13117);
      return;
      paramContext = localContext;
    }
  }
  
  public static void zn(boolean paramBoolean)
  {
    OAB = paramBoolean;
  }
  
  public final e a(Uri paramUri, e parame)
  {
    AppMethodBeat.i(13118);
    Object localObject = this.mLock;
    if (parame != null) {}
    h localh;
    int i;
    try
    {
      if (parame.bpt == this.OAD) {
        return parame;
      }
      localh = this.OAC;
      i = this.OAD;
      parame = this.OAE;
      localObject = localh.aZQ(paramUri.getScheme());
      if (localObject == null)
      {
        AppMethodBeat.o(13118);
        return parame;
      }
    }
    finally
    {
      AppMethodBeat.o(13118);
    }
    paramUri = ((SchemeResolver.a)localObject).a(localh, paramUri);
    if (paramUri == null)
    {
      AppMethodBeat.o(13118);
      return parame;
    }
    paramUri = new e((FileSystem.b)paramUri.first, (String)paramUri.second, i, (byte)0);
    AppMethodBeat.o(13118);
    return paramUri;
  }
  
  public final void aB(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(193373);
    long l = this.OAK;
    if ((paramLong1 >= 0L) && (l < 0L))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      this.mContext.registerReceiver(this.OAI, localIntentFilter);
      this.OAI.kP(this.mContext);
    }
    for (;;)
    {
      this.OAK = paramLong1;
      this.OAL = paramLong2;
      this.OAM = true;
      AppMethodBeat.o(193373);
      return;
      if ((paramLong1 < 0L) && (l >= 0L))
      {
        this.mContext.unregisterReceiver(this.OAI);
        this.OAJ.removeMessages(2);
      }
    }
  }
  
  public final a gEk()
  {
    AppMethodBeat.i(13119);
    a locala = new a();
    AppMethodBeat.o(13119);
    return locala;
  }
  
  public final void gEl()
  {
    AppMethodBeat.i(13120);
    synchronized (this.mLock)
    {
      h localh = this.OAC;
      a(localh);
      AppMethodBeat.o(13120);
      return;
    }
  }
  
  public final g gEm()
  {
    synchronized (this.mLock)
    {
      h localh = this.OAC;
      return localh;
    }
  }
  
  public final Map<String, String> gEn()
  {
    AppMethodBeat.i(193374);
    Map localMap = gEm().fTa();
    AppMethodBeat.o(193374);
    return localMap;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(13126);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(13126);
      return false;
    case 1: 
      paramMessage = (Intent)paramMessage.obj;
      paramMessage.setExtrasClassLoader(FileSystem.class.getClassLoader());
      Log.i("VFS.FileSystemManager", "Refresh file system from broadcast.");
      try
      {
        bk(paramMessage.getExtras());
        AppMethodBeat.o(13126);
        return true;
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          Log.e("VFS.FileSystemManager", paramMessage, "Failed to refresh file system from broadcast.");
        }
      }
    }
    CancellationSignal localCancellationSignal = (CancellationSignal)paramMessage.obj;
    long l1 = this.OAL;
    paramMessage = new File(this.OAG, "maintain.timestamp");
    long l2 = System.currentTimeMillis();
    long l3 = paramMessage.lastModified();
    if (l2 - l3 < l1)
    {
      Log.i("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
      AppMethodBeat.o(13126);
      return true;
    }
    boolean bool = this.OAM;
    if (bool) {
      if (this.mContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramMessage = null;
        if (bool) {
          paramMessage = ((PowerManager)this.mContext.getSystemService("power")).newWakeLock(1, "VFS:Maintenance");
        }
        d locald = this.OAN;
        try
        {
          Log.i("VFS.FileSystemManager", "Maintenance started. WakeLock: ".concat(String.valueOf(bool)));
          if (locald != null) {
            locald.fSW();
          }
          if (paramMessage != null) {
            paramMessage.acquire(1200000L);
          }
          a(localCancellationSignal);
          Log.i("VFS.FileSystemManager", "Maintenance finished.");
          if ((paramMessage != null) && (paramMessage.isHeld())) {
            paramMessage.release();
          }
          if (locald == null) {
            break;
          }
          locald.aX(false, false);
          break;
          bool = false;
        }
        catch (OperationCanceledException localOperationCanceledException)
        {
          Log.i("VFS.FileSystemManager", "Maintenance cancelled.");
          if ((paramMessage != null) && (paramMessage.isHeld())) {
            paramMessage.release();
          }
          if (locald == null) {
            break;
          }
          locald.aX(true, false);
          break;
        }
        catch (Exception localException)
        {
          Log.e("VFS.FileSystemManager", localException, "Maintenance failed.");
          if ((paramMessage != null) && (paramMessage.isHeld())) {
            paramMessage.release();
          }
          if (locald == null) {
            break;
          }
          locald.aX(false, true);
          break;
        }
        finally
        {
          if ((paramMessage != null) && (paramMessage.isHeld())) {
            paramMessage.release();
          }
          if (locald != null) {
            locald.aX(false, false);
          }
          AppMethodBeat.o(13126);
        }
      }
    }
  }
  
  public final class a
  {
    final TreeMap<String, String> LGA;
    final HashMap<String, String> LGB;
    d LGC;
    boolean LGD;
    final HashMap<String, i> LGy;
    final HashMap<String, d> LGz;
    
    public a()
    {
      AppMethodBeat.i(13105);
      this.LGy = new HashMap();
      this.LGz = new HashMap();
      this.LGA = new TreeMap();
      this.LGB = new HashMap();
      this.LGC = null;
      this.LGD = false;
      AppMethodBeat.o(13105);
    }
    
    public final a a(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(13107);
      if (paramFileSystem == null) {}
      for (paramFileSystem = null;; paramFileSystem = new d(paramFileSystem))
      {
        this.LGz.put(paramString, paramFileSystem);
        AppMethodBeat.o(13107);
        return this;
      }
    }
    
    public final a a(String paramString, SchemeResolver paramSchemeResolver)
    {
      AppMethodBeat.i(13106);
      if (paramSchemeResolver == null) {}
      for (paramSchemeResolver = null;; paramSchemeResolver = new i(paramSchemeResolver))
      {
        this.LGy.put(paramString, paramSchemeResolver);
        AppMethodBeat.o(13106);
        return this;
      }
    }
    
    public final a aZJ(String paramString)
    {
      AppMethodBeat.i(184814);
      this.LGz.put(paramString, null);
      AppMethodBeat.o(184814);
      return this;
    }
    
    public final a aZK(String paramString)
    {
      AppMethodBeat.i(13109);
      paramString = w.o(paramString, true, false);
      this.LGA.put(paramString, null);
      AppMethodBeat.o(13109);
      return this;
    }
    
    public final a aZL(String paramString)
    {
      AppMethodBeat.i(13111);
      this.LGB.put(paramString, null);
      AppMethodBeat.o(13111);
      return this;
    }
    
    public final void commit()
    {
      AppMethodBeat.i(13112);
      zo(e.d(e.this));
      AppMethodBeat.o(13112);
    }
    
    public final a mB(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13108);
      paramString1 = w.o(paramString1, true, false);
      this.LGA.put(paramString1, paramString2);
      AppMethodBeat.o(13108);
      return this;
    }
    
    public final a mC(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13110);
      this.LGB.put(paramString1, paramString2);
      AppMethodBeat.o(13110);
      return this;
    }
    
    public final void zo(boolean paramBoolean)
    {
      AppMethodBeat.i(13113);
      e.a(e.this, this, paramBoolean);
      this.LGz.clear();
      this.LGA.clear();
      this.LGB.clear();
      this.LGD = false;
      AppMethodBeat.o(13113);
    }
  }
  
  public static abstract interface b
  {
    public abstract Key S(String paramString, Map<String, String> paramMap);
  }
  
  final class c
    extends BroadcastReceiver
  {
    private CancellationSignal ItQ;
    private boolean oCl;
    private boolean oCm;
    
    private c() {}
    
    private void fSV()
    {
      AppMethodBeat.i(193371);
      Log.d("VFS.FileSystemManager", "Idle status changed: charging = " + this.oCl + ", interactive = " + this.oCm);
      if ((this.oCl) && (!this.oCm) && (this.ItQ == null))
      {
        long l = e.a(e.this);
        if (l < 0L)
        {
          AppMethodBeat.o(193371);
          return;
        }
        this.ItQ = new CancellationSignal();
        e.b(e.this).sendMessageDelayed(Message.obtain(e.b(e.this), 2, this.ItQ), l);
        Log.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
        AppMethodBeat.o(193371);
        return;
      }
      if (((!this.oCl) || (this.oCm)) && (this.ItQ != null))
      {
        e.b(e.this).removeMessages(2);
        this.ItQ.cancel();
        this.ItQ = null;
        Log.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
      }
      AppMethodBeat.o(193371);
    }
    
    final void kP(Context paramContext)
    {
      AppMethodBeat.i(193372);
      this.oCm = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (paramContext != null)
      {
        int i = paramContext.getIntExtra("status", -1);
        if ((i != 2) && (i != 5)) {
          break label75;
        }
      }
      label75:
      for (boolean bool = true;; bool = false)
      {
        this.oCl = bool;
        fSV();
        AppMethodBeat.o(193372);
        return;
      }
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(13114);
      paramContext = paramIntent.getAction();
      if (paramContext == null)
      {
        AppMethodBeat.o(13114);
        return;
      }
      int i = -1;
      switch (paramContext.hashCode())
      {
      default: 
        switch (i)
        {
        }
        break;
      }
      for (;;)
      {
        fSV();
        AppMethodBeat.o(13114);
        return;
        if (!paramContext.equals("android.intent.action.SCREEN_ON")) {
          break;
        }
        i = 0;
        break;
        if (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
          break;
        }
        i = 1;
        break;
        if (!paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
          break;
        }
        i = 2;
        break;
        if (!paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
          break;
        }
        i = 3;
        break;
        this.oCm = true;
        continue;
        this.oCm = false;
        continue;
        this.oCl = true;
        continue;
        this.oCl = false;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void aX(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void fSW();
  }
  
  public static final class e
  {
    final FileSystem.b LGE;
    final int bpt;
    final String path;
    
    private e(FileSystem.b paramb, String paramString, int paramInt)
    {
      this.LGE = paramb;
      this.path = paramString;
      this.bpt = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13115);
      if (!valid())
      {
        AppMethodBeat.o(13115);
        return "[INVALID]";
      }
      String str = this.path + " -> " + this.LGE.toString();
      AppMethodBeat.o(13115);
      return str;
    }
    
    final boolean valid()
    {
      return this.LGE != null;
    }
  }
  
  static final class f
  {
    @SuppressLint({"StaticFieldLeak"})
    static final e LGF;
    
    static
    {
      AppMethodBeat.i(13116);
      e locale = new e((byte)0);
      LGF = locale;
      e.c(locale);
      AppMethodBeat.o(13116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.e
 * JD-Core Version:    0.7.0.1
 */