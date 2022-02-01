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
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public final class h
  implements Handler.Callback
{
  private static volatile h.b abSN;
  private static volatile boolean abSO;
  private static final TreeMap<String, String> abTf;
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Context sContext;
  private m abSP;
  private int abSQ;
  private e abSR;
  final m abSS;
  final File abST;
  final HandlerThread abSU;
  private final c abSV;
  private final Handler abSW;
  private volatile long abSX;
  private volatile long abSY;
  private volatile boolean abSZ;
  private volatile d abTa;
  private final BroadcastReceiver abTb;
  private volatile HashMap<String, String> abTc;
  private volatile boolean abTd;
  private volatile BroadcastReceiver abTe;
  final Context mContext;
  private final Object mLock;
  
  static
  {
    AppMethodBeat.i(236241);
    sContext = null;
    abSN = null;
    abSO = true;
    abTf = new TreeMap();
    AppMethodBeat.o(236241);
  }
  
  private h()
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
    this.abST = new File((File)localObject1, ".vfs");
    this.abSU = new HandlerThread("VFS.Maintenance", 4);
    this.abSU.start();
    this.abSW = new Handler(this.abSU.getLooper(), this);
    this.abSV = new c((byte)0);
    this.abSX = -1L;
    this.abSY = 9223372036854775807L;
    this.abTd = true;
    this.abTb = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(236155);
        h.b(h.this).sendEmptyMessage(3);
        AppMethodBeat.o(236155);
      }
    };
    this.abTc = lI(this.mContext);
    localObject1 = this.mContext;
    localObject2 = new HashMap();
    ((HashMap)localObject2).put(null, FileSchemeResolver.iff());
    ((HashMap)localObject2).put("", FileSchemeResolver.iff());
    ((HashMap)localObject2).put("file", FileSchemeResolver.iff());
    ((HashMap)localObject2).put("wcf", WcfSchemeResolver.iff());
    Map localMap = Collections.singletonMap("null", NullFileSystem.ifr());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", ((Context)localObject1).getCacheDir().getParent());
    localHashMap.put("dataCache", ((Context)localObject1).getCacheDir().getPath());
    this.abSS = new m().a((Map)localObject2, localMap, Collections.emptyMap(), abTf, localHashMap, null);
    this.abSP = this.abSS.a(Collections.emptyMap(), Collections.emptyMap(), Collections.emptyMap(), abTf, this.abTc, null);
    this.abSQ = 0;
    this.abSR = new e(null, null, this.abSQ, (byte)0);
    AppMethodBeat.o(13122);
  }
  
  public static void Bu(boolean paramBoolean)
  {
    abSO = paramBoolean;
  }
  
  public static void a(h.b paramb)
  {
    abSN = paramb;
  }
  
  /* Error */
  private void a(m paramm)
  {
    // Byte code:
    //   0: sipush 13125
    //   3: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 264	com/tencent/mm/vfs/m:writeToBundle	()Landroid/os/Bundle;
    //   10: astore 5
    //   12: invokestatic 270	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   15: astore_2
    //   16: aload_2
    //   17: aload 5
    //   19: invokevirtual 274	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   22: aload_2
    //   23: invokevirtual 278	android/os/Parcel:marshall	()[B
    //   26: astore 4
    //   28: aload_2
    //   29: invokevirtual 281	android/os/Parcel:recycle	()V
    //   32: new 283	java/io/DataOutputStream
    //   35: dup
    //   36: new 285	java/io/FileOutputStream
    //   39: dup
    //   40: new 116	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: getfield 129	com/tencent/mm/vfs/h:abST	Ljava/io/File;
    //   48: ldc_w 287
    //   51: invokespecial 127	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: invokespecial 290	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 293	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: iconst_4
    //   65: invokevirtual 296	java/io/DataOutputStream:writeInt	(I)V
    //   68: aload_3
    //   69: astore_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokevirtual 300	java/io/DataOutputStream:write	([B)V
    //   76: aload_3
    //   77: invokestatic 306	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: getfield 101	com/tencent/mm/vfs/h:mContext	Landroid/content/Context;
    //   84: invokevirtual 309	android/content/Context:getPackageName	()Ljava/lang/String;
    //   87: astore_2
    //   88: new 311	android/content/Intent
    //   91: dup
    //   92: new 313	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   99: aload_2
    //   100: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 320
    //   106: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 324	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   115: astore_2
    //   116: aload_2
    //   117: aload 5
    //   119: invokevirtual 328	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   122: pop
    //   123: aload_2
    //   124: ldc_w 330
    //   127: invokestatic 336	android/os/Process:myPid	()I
    //   130: invokevirtual 340	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   133: pop
    //   134: aload_0
    //   135: getfield 101	com/tencent/mm/vfs/h:mContext	Landroid/content/Context;
    //   138: aload_2
    //   139: invokevirtual 344	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   142: new 313	java/lang/StringBuilder
    //   145: dup
    //   146: sipush 1024
    //   149: invokespecial 346	java/lang/StringBuilder:<init>	(I)V
    //   152: astore_2
    //   153: ldc_w 348
    //   156: ldc_w 350
    //   159: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: ldc_w 348
    //   165: ldc_w 357
    //   168: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload_1
    //   172: getfield 361	com/tencent/mm/vfs/m:YDS	Ljava/util/Map;
    //   175: aload_2
    //   176: invokestatic 364	com/tencent/mm/vfs/h:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   179: ldc_w 348
    //   182: ldc_w 366
    //   185: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload_1
    //   189: getfield 369	com/tencent/mm/vfs/m:YDT	Ljava/util/Map;
    //   192: aload_2
    //   193: invokestatic 364	com/tencent/mm/vfs/h:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   196: ldc_w 348
    //   199: new 313	java/lang/StringBuilder
    //   202: dup
    //   203: ldc_w 371
    //   206: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: aload_1
    //   210: getfield 375	com/tencent/mm/vfs/m:YDU	Ljava/util/Map;
    //   213: invokeinterface 380 1 0
    //   218: invokevirtual 383	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: ldc_w 348
    //   230: ldc_w 385
    //   233: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: aload_1
    //   237: getfield 389	com/tencent/mm/vfs/m:YDV	Ljava/util/SortedMap;
    //   240: aload_2
    //   241: invokestatic 364	com/tencent/mm/vfs/h:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   244: ldc_w 348
    //   247: ldc_w 391
    //   250: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_1
    //   254: getfield 394	com/tencent/mm/vfs/m:YDX	Ljava/util/Map;
    //   257: aload_2
    //   258: invokestatic 364	com/tencent/mm/vfs/h:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   261: ldc_w 348
    //   264: ldc_w 396
    //   267: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: ldc_w 348
    //   273: new 313	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 398
    //   280: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_1
    //   284: getfield 402	com/tencent/mm/vfs/m:YDY	Lcom/tencent/mm/vfs/g;
    //   287: invokevirtual 405	com/tencent/mm/vfs/g:toString	()Ljava/lang/String;
    //   290: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: sipush 13125
    //   302: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: return
    //   306: astore 4
    //   308: aconst_null
    //   309: astore_3
    //   310: aload_3
    //   311: astore_2
    //   312: ldc_w 348
    //   315: new 313	java/lang/StringBuilder
    //   318: dup
    //   319: ldc_w 407
    //   322: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   325: aload 4
    //   327: invokevirtual 410	java/io/IOException:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 412	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload_3
    //   340: invokestatic 306	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   343: goto -263 -> 80
    //   346: astore_1
    //   347: aconst_null
    //   348: astore_2
    //   349: aload_2
    //   350: invokestatic 306	com/tencent/mm/vfs/ad:closeQuietly	(Ljava/io/Closeable;)V
    //   353: sipush 13125
    //   356: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: aload_1
    //   360: athrow
    //   361: astore_1
    //   362: goto -13 -> 349
    //   365: astore 4
    //   367: goto -57 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	h
    //   0	370	1	paramm	m
    //   15	335	2	localObject	Object
    //   60	280	3	localDataOutputStream	java.io.DataOutputStream
    //   26	46	4	arrayOfByte	byte[]
    //   306	20	4	localIOException1	java.io.IOException
    //   365	1	4	localIOException2	java.io.IOException
    //   10	108	5	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   32	61	306	java/io/IOException
    //   32	61	346	finally
    //   63	68	361	finally
    //   70	76	361	finally
    //   312	339	361	finally
    //   63	68	365	java/io/IOException
    //   70	76	365	java/io/IOException
  }
  
  private static <K, V> void a(Map<K, V> paramMap, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(13124);
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramStringBuilder.setLength(0);
      paramStringBuilder.append("  ").append(localEntry.getKey());
      if (localEntry.getValue() == null) {
        paramStringBuilder.append(" (deleted)\n");
      }
      for (;;)
      {
        Log.i("VFS.FileSystemManager", paramStringBuilder.toString());
        break;
        paramStringBuilder.append(" => ").append(localEntry.getValue().toString());
      }
    }
    AppMethodBeat.o(13124);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, Map<String, n> paramMap, Map<String, g> paramMap1, Map<String, g> paramMap2, SortedMap<String, String> paramSortedMap, Map<String, String> paramMap3, g paramg)
  {
    AppMethodBeat.i(236229);
    Object localObject1 = new StringBuilder(1024);
    Log.i("VFS.FileSystemManager", "FileSystem configuration changed:");
    if (paramBoolean2) {
      Log.i("VFS.FileSystemManager", "[CLEAN ALL]");
    }
    if (!paramMap.isEmpty())
    {
      Log.i("VFS.FileSystemManager", "[Scheme]");
      a(paramMap, (StringBuilder)localObject1);
    }
    if (!paramMap1.isEmpty())
    {
      Log.i("VFS.FileSystemManager", "[FileSystems]");
      a(paramMap1, (StringBuilder)localObject1);
    }
    if (!paramMap2.isEmpty())
    {
      Log.i("VFS.FileSystemManager", "[Maintenance-only FileSystems]");
      a(paramMap2, (StringBuilder)localObject1);
    }
    if (!paramSortedMap.isEmpty())
    {
      Log.i("VFS.FileSystemManager", "[Mount points]");
      a(paramSortedMap, (StringBuilder)localObject1);
    }
    if (!paramMap3.isEmpty())
    {
      Log.i("VFS.FileSystemManager", "[Environment]");
      a(paramMap3, (StringBuilder)localObject1);
    }
    if (paramg != null)
    {
      Log.i("VFS.FileSystemManager", "[Root]");
      Log.i("VFS.FileSystemManager", "  " + paramg.toString());
    }
    for (;;)
    {
      int i;
      synchronized (this.mLock)
      {
        localObject1 = this.abSP;
        i = this.abSQ;
        if (paramBoolean2)
        {
          localObject1 = this.abSS;
          paramMap3.putAll(lI(this.mContext));
        }
        localObject1 = ((m)localObject1).a(paramMap, paramMap1, paramMap2, paramSortedMap, paramMap3, paramg);
      }
      synchronized (this.mLock)
      {
        if (i != this.abSQ)
        {
          localObject1 = this.abSP;
          i = this.abSQ;
          continue;
          paramMap = finally;
          AppMethodBeat.o(236229);
          throw paramMap;
        }
        this.abSP = ((m)localObject1);
        this.abSQ = (i + 1);
        this.abSR = new e(null, null, this.abSQ, (byte)0);
        if (paramBoolean1) {
          a((m)localObject1);
        }
        AppMethodBeat.o(236229);
        return;
      }
    }
  }
  
  private void bB(Bundle paramBundle)
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
    paramBundle = m.bv((Bundle)???);
    synchronized (this.mLock)
    {
      this.abSP = paramBundle;
      this.abSQ += 1;
      this.abSR = new e(null, null, this.abSQ, (byte)0);
      ??? = new StringBuilder(1024);
      Log.i("VFS.FileSystemManager", "Loaded file system from bundle:");
      Log.i("VFS.FileSystemManager", "[Schemes]");
      a(paramBundle.YDS, (StringBuilder)???);
      Log.i("VFS.FileSystemManager", "[FileSystems]");
      a(paramBundle.YDT, (StringBuilder)???);
      Log.i("VFS.FileSystemManager", "[Maintenance-only] " + paramBundle.YDU.size());
      Log.i("VFS.FileSystemManager", "[Mount points]");
      a(paramBundle.YDV, (StringBuilder)???);
      Log.i("VFS.FileSystemManager", "[Environment]");
      a(paramBundle.YDX, (StringBuilder)???);
      Log.i("VFS.FileSystemManager", "[Root]");
      Log.i("VFS.FileSystemManager", "  " + paramBundle.YDY.toString());
      AppMethodBeat.o(13123);
      return;
    }
  }
  
  public static h iWH()
  {
    return f.YCP;
  }
  
  static h.b iWI()
  {
    return abSN;
  }
  
  private static HashMap<String, String> lI(Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(236206);
    HashMap localHashMap = new HashMap();
    File localFile = paramContext.getExternalCacheDir();
    if (localFile == null)
    {
      paramContext = null;
      localHashMap.put("extData", paramContext);
      if (localFile != null) {
        break label86;
      }
      paramContext = null;
      label42:
      localHashMap.put("extCache", paramContext);
      paramContext = Environment.getExternalStorageDirectory();
      if (paramContext != null) {
        break label94;
      }
    }
    label86:
    label94:
    for (paramContext = localObject;; paramContext = paramContext.getPath())
    {
      localHashMap.put("storage", paramContext);
      AppMethodBeat.o(236206);
      return localHashMap;
      paramContext = localFile.getParent();
      break;
      paramContext = localFile.getPath();
      break label42;
    }
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
  
  public final void ER(boolean paramBoolean)
  {
    this.abTd = paramBoolean;
  }
  
  public final d a(d paramd)
  {
    d locald = this.abTa;
    this.abTa = paramd;
    return locald;
  }
  
  final e a(Uri paramUri, e parame)
  {
    AppMethodBeat.i(13118);
    Object localObject = this.mLock;
    if (parame != null) {}
    m localm;
    int i;
    try
    {
      if (parame.aYQ == this.abSQ) {
        return parame;
      }
      localm = this.abSP;
      i = this.abSQ;
      parame = this.abSR;
      localObject = localm.bBN(paramUri.getScheme());
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
    paramUri = ((SchemeResolver.a)localObject).a(localm, paramUri);
    if (paramUri == null)
    {
      AppMethodBeat.o(13118);
      return parame;
    }
    paramUri = new e((FileSystem.b)paramUri.first, (String)paramUri.second, i, (byte)0);
    AppMethodBeat.o(13118);
    return paramUri;
  }
  
  public final void bh(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(236213);
    long l = this.abSX;
    boolean bool;
    if ((paramLong1 >= 0L) && (l < 0L))
    {
      Object localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject1).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject1).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      this.mContext.registerReceiver(this.abSV, (IntentFilter)localObject1);
      localObject1 = this.abSV;
      Object localObject2 = this.mContext;
      ((c)localObject1).sWW = ((PowerManager)((Context)localObject2).getSystemService("power")).isScreenOn();
      localObject2 = ((Context)localObject2).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 != null)
      {
        int i = ((Intent)localObject2).getIntExtra("status", -1);
        if ((i == 2) || (i == 5))
        {
          bool = true;
          ((c)localObject1).cVD = bool;
        }
      }
      else
      {
        ((c)localObject1).ifo();
      }
    }
    for (;;)
    {
      this.abSX = paramLong1;
      this.abSY = paramLong2;
      this.abSZ = true;
      AppMethodBeat.o(236213);
      return;
      bool = false;
      break;
      if ((paramLong1 < 0L) && (l >= 0L))
      {
        this.mContext.unregisterReceiver(this.abSV);
        this.abSW.removeMessages(2);
      }
    }
  }
  
  /* Error */
  public final boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: sipush 13126
    //   3: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: getfield 722	android/os/Message:what	I
    //   10: tableswitch	default:+26 -> 36, 1:+34->44, 2:+91->101, 3:+1082->1092
    //   37: baload
    //   38: fstore_3
    //   39: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_1
    //   45: getfield 725	android/os/Message:obj	Ljava/lang/Object;
    //   48: checkcast 311	android/content/Intent
    //   51: astore_1
    //   52: aload_1
    //   53: ldc_w 581
    //   56: invokevirtual 587	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   59: invokevirtual 729	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   62: ldc_w 348
    //   65: ldc_w 731
    //   68: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual 734	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   76: invokespecial 593	com/tencent/mm/vfs/h:bB	(Landroid/os/Bundle;)V
    //   79: sipush 13126
    //   82: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_1
    //   88: ldc_w 348
    //   91: aload_1
    //   92: ldc_w 736
    //   95: invokestatic 598	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   98: goto -19 -> 79
    //   101: aload_1
    //   102: getfield 725	android/os/Message:obj	Ljava/lang/Object;
    //   105: checkcast 738	android/os/CancellationSignal
    //   108: astore 9
    //   110: aload_0
    //   111: getfield 165	com/tencent/mm/vfs/h:abSY	J
    //   114: lstore_2
    //   115: ldc_w 740
    //   118: invokestatic 744	com/tencent/mm/vfs/ad:bCe	(Ljava/lang/String;)J
    //   121: lstore 4
    //   123: lload 4
    //   125: lload_2
    //   126: lcmp
    //   127: ifge +39 -> 166
    //   130: ldc_w 348
    //   133: ldc_w 746
    //   136: iconst_2
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: lload 4
    //   144: invokestatic 751	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: lload_2
    //   151: invokestatic 751	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   154: aastore
    //   155: invokestatic 754	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: sipush 13126
    //   161: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: iconst_1
    //   165: ireturn
    //   166: aload_0
    //   167: getfield 708	com/tencent/mm/vfs/h:abSZ	Z
    //   170: istore 6
    //   172: iload 6
    //   174: ifeq +976 -> 1150
    //   177: aload_0
    //   178: getfield 101	com/tencent/mm/vfs/h:mContext	Landroid/content/Context;
    //   181: ldc_w 756
    //   184: invokevirtual 759	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   187: ifne +361 -> 548
    //   190: iconst_1
    //   191: istore 6
    //   193: aconst_null
    //   194: astore_1
    //   195: iload 6
    //   197: ifeq +24 -> 221
    //   200: aload_0
    //   201: getfield 101	com/tencent/mm/vfs/h:mContext	Landroid/content/Context;
    //   204: ldc_w 680
    //   207: invokevirtual 684	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   210: checkcast 686	android/os/PowerManager
    //   213: iconst_1
    //   214: ldc_w 761
    //   217: invokevirtual 765	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 639	com/tencent/mm/vfs/h:abTa	Lcom/tencent/mm/vfs/h$d;
    //   225: astore 8
    //   227: ldc_w 348
    //   230: ldc_w 767
    //   233: iload 6
    //   235: invokestatic 770	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   238: invokevirtual 523	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   241: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 8
    //   246: ifnull +10 -> 256
    //   249: aload 8
    //   251: invokeinterface 773 1 0
    //   256: aload_1
    //   257: ifnull +92 -> 349
    //   260: ldc2_w 774
    //   263: new 777	com/tencent/mm/hellhoundlib/b/a
    //   266: dup
    //   267: invokespecial 778	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   270: invokestatic 783	com/tencent/mm/hellhoundlib/b/c:a	(JLcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   273: astore 7
    //   275: aload_1
    //   276: aload 7
    //   278: invokevirtual 787	com/tencent/mm/hellhoundlib/b/a:aFh	()[Ljava/lang/Object;
    //   281: ldc_w 789
    //   284: ldc_w 791
    //   287: ldc_w 793
    //   290: ldc_w 795
    //   293: ldc_w 797
    //   296: ldc_w 799
    //   299: invokestatic 804	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload 7
    //   304: invokestatic 807	com/tencent/mm/hellhoundlib/b/c:a	(Lcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   307: iconst_0
    //   308: invokevirtual 811	com/tencent/mm/hellhoundlib/b/a:sf	(I)Ljava/lang/Object;
    //   311: checkcast 748	java/lang/Long
    //   314: invokevirtual 814	java/lang/Long:longValue	()J
    //   317: lstore_2
    //   318: invokestatic 818	com/tencent/mm/hellhoundlib/b/c:aFj	()Lcom/tencent/mm/hellhoundlib/b/a;
    //   321: pop
    //   322: aload_1
    //   323: lload_2
    //   324: invokevirtual 822	android/os/PowerManager$WakeLock:acquire	(J)V
    //   327: aload_1
    //   328: ldc_w 789
    //   331: ldc_w 791
    //   334: ldc_w 793
    //   337: ldc_w 795
    //   340: ldc_w 797
    //   343: ldc_w 799
    //   346: invokestatic 825	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_0
    //   350: getfield 99	com/tencent/mm/vfs/h:mLock	Ljava/lang/Object;
    //   353: astore 7
    //   355: aload 7
    //   357: monitorenter
    //   358: aload_0
    //   359: getfield 239	com/tencent/mm/vfs/h:abSP	Lcom/tencent/mm/vfs/m;
    //   362: astore 10
    //   364: aload 7
    //   366: monitorexit
    //   367: aload 10
    //   369: getfield 361	com/tencent/mm/vfs/m:YDS	Ljava/util/Map;
    //   372: invokeinterface 828 1 0
    //   377: invokeinterface 422 1 0
    //   382: astore 7
    //   384: aload 7
    //   386: invokeinterface 428 1 0
    //   391: ifeq +266 -> 657
    //   394: aload 7
    //   396: invokeinterface 432 1 0
    //   401: checkcast 515	java/lang/String
    //   404: astore 11
    //   406: aload 10
    //   408: aload 11
    //   410: invokevirtual 652	com/tencent/mm/vfs/m:bBN	(Ljava/lang/String;)Lcom/tencent/mm/vfs/SchemeResolver$a;
    //   413: astore 12
    //   415: ldc_w 348
    //   418: new 313	java/lang/StringBuilder
    //   421: dup
    //   422: ldc_w 830
    //   425: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   428: aload 11
    //   430: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc_w 450
    //   436: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 12
    //   441: invokeinterface 834 1 0
    //   446: invokevirtual 451	java/lang/Object:toString	()Ljava/lang/String;
    //   449: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: goto -74 -> 384
    //   461: astore 7
    //   463: ldc_w 348
    //   466: ldc_w 836
    //   469: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload_1
    //   473: ifnull +58 -> 531
    //   476: aload_1
    //   477: invokevirtual 839	android/os/PowerManager$WakeLock:isHeld	()Z
    //   480: ifeq +51 -> 531
    //   483: aload_1
    //   484: ldc_w 789
    //   487: ldc_w 791
    //   490: ldc_w 793
    //   493: ldc_w 795
    //   496: ldc_w 841
    //   499: ldc_w 842
    //   502: invokestatic 844	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   505: aload_1
    //   506: invokevirtual 846	android/os/PowerManager$WakeLock:release	()V
    //   509: aload_1
    //   510: ldc_w 789
    //   513: ldc_w 791
    //   516: ldc_w 793
    //   519: ldc_w 795
    //   522: ldc_w 841
    //   525: ldc_w 842
    //   528: invokestatic 825	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   531: aload 8
    //   533: ifnull -375 -> 158
    //   536: aload 8
    //   538: iconst_1
    //   539: iconst_0
    //   540: invokeinterface 850 3 0
    //   545: goto -387 -> 158
    //   548: iconst_0
    //   549: istore 6
    //   551: goto -358 -> 193
    //   554: astore 9
    //   556: aload 7
    //   558: monitorexit
    //   559: sipush 13126
    //   562: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload 9
    //   567: athrow
    //   568: astore 7
    //   570: ldc_w 348
    //   573: aload 7
    //   575: ldc_w 852
    //   578: invokestatic 598	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   581: aload_1
    //   582: ifnull +58 -> 640
    //   585: aload_1
    //   586: invokevirtual 839	android/os/PowerManager$WakeLock:isHeld	()Z
    //   589: ifeq +51 -> 640
    //   592: aload_1
    //   593: ldc_w 789
    //   596: ldc_w 791
    //   599: ldc_w 793
    //   602: ldc_w 795
    //   605: ldc_w 841
    //   608: ldc_w 842
    //   611: invokestatic 844	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_1
    //   615: invokevirtual 846	android/os/PowerManager$WakeLock:release	()V
    //   618: aload_1
    //   619: ldc_w 789
    //   622: ldc_w 791
    //   625: ldc_w 793
    //   628: ldc_w 795
    //   631: ldc_w 841
    //   634: ldc_w 842
    //   637: invokestatic 825	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   640: aload 8
    //   642: ifnull -484 -> 158
    //   645: aload 8
    //   647: iconst_0
    //   648: iconst_1
    //   649: invokeinterface 850 3 0
    //   654: goto -496 -> 158
    //   657: aload 10
    //   659: getfield 369	com/tencent/mm/vfs/m:YDT	Ljava/util/Map;
    //   662: invokeinterface 828 1 0
    //   667: invokeinterface 422 1 0
    //   672: astore 7
    //   674: aload 7
    //   676: invokeinterface 428 1 0
    //   681: ifeq +163 -> 844
    //   684: aload 7
    //   686: invokeinterface 432 1 0
    //   691: checkcast 515	java/lang/String
    //   694: astore 11
    //   696: aload 10
    //   698: aload 11
    //   700: invokevirtual 856	com/tencent/mm/vfs/m:bBL	(Ljava/lang/String;)Lcom/tencent/mm/vfs/FileSystem$b;
    //   703: astore 12
    //   705: ldc_w 348
    //   708: new 313	java/lang/StringBuilder
    //   711: dup
    //   712: ldc_w 830
    //   715: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   718: aload 11
    //   720: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: ldc_w 450
    //   726: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload 12
    //   731: invokeinterface 860 1 0
    //   736: invokevirtual 451	java/lang/Object:toString	()Ljava/lang/String;
    //   739: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: aload 12
    //   750: aload 9
    //   752: invokeinterface 862 2 0
    //   757: goto -83 -> 674
    //   760: astore 7
    //   762: aload_1
    //   763: ifnull +58 -> 821
    //   766: aload_1
    //   767: invokevirtual 839	android/os/PowerManager$WakeLock:isHeld	()Z
    //   770: ifeq +51 -> 821
    //   773: aload_1
    //   774: ldc_w 789
    //   777: ldc_w 791
    //   780: ldc_w 793
    //   783: ldc_w 795
    //   786: ldc_w 841
    //   789: ldc_w 842
    //   792: invokestatic 844	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   795: aload_1
    //   796: invokevirtual 846	android/os/PowerManager$WakeLock:release	()V
    //   799: aload_1
    //   800: ldc_w 789
    //   803: ldc_w 791
    //   806: ldc_w 793
    //   809: ldc_w 795
    //   812: ldc_w 841
    //   815: ldc_w 842
    //   818: invokestatic 825	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   821: aload 8
    //   823: ifnull +12 -> 835
    //   826: aload 8
    //   828: iconst_0
    //   829: iconst_0
    //   830: invokeinterface 850 3 0
    //   835: sipush 13126
    //   838: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   841: aload 7
    //   843: athrow
    //   844: aload 10
    //   846: getfield 375	com/tencent/mm/vfs/m:YDU	Ljava/util/Map;
    //   849: invokeinterface 828 1 0
    //   854: invokeinterface 422 1 0
    //   859: astore 11
    //   861: aload 11
    //   863: invokeinterface 428 1 0
    //   868: ifeq +133 -> 1001
    //   871: aload 11
    //   873: invokeinterface 432 1 0
    //   878: checkcast 515	java/lang/String
    //   881: astore 12
    //   883: aload 10
    //   885: getfield 375	com/tencent/mm/vfs/m:YDU	Ljava/util/Map;
    //   888: aload 12
    //   890: invokeinterface 866 2 0
    //   895: checkcast 404	com/tencent/mm/vfs/g
    //   898: astore 7
    //   900: aload 7
    //   902: ifnonnull +61 -> 963
    //   905: aconst_null
    //   906: astore 7
    //   908: ldc_w 348
    //   911: new 313	java/lang/StringBuilder
    //   914: dup
    //   915: ldc_w 830
    //   918: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   921: aload 12
    //   923: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: ldc_w 450
    //   929: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: aload 7
    //   934: invokeinterface 860 1 0
    //   939: invokevirtual 451	java/lang/Object:toString	()Ljava/lang/String;
    //   942: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   951: aload 7
    //   953: aload 9
    //   955: invokeinterface 862 2 0
    //   960: goto -99 -> 861
    //   963: aload 7
    //   965: getfield 870	com/tencent/mm/vfs/g:YCk	Lcom/tencent/mm/vfs/FileSystem$b;
    //   968: ifnonnull +23 -> 991
    //   971: aload 7
    //   973: aload 7
    //   975: getfield 874	com/tencent/mm/vfs/g:YCm	Lcom/tencent/mm/vfs/FileSystem;
    //   978: aload 10
    //   980: invokevirtual 877	com/tencent/mm/vfs/m:ift	()Ljava/util/Map;
    //   983: invokeinterface 881 2 0
    //   988: putfield 870	com/tencent/mm/vfs/g:YCk	Lcom/tencent/mm/vfs/FileSystem$b;
    //   991: aload 7
    //   993: getfield 870	com/tencent/mm/vfs/g:YCk	Lcom/tencent/mm/vfs/FileSystem$b;
    //   996: astore 7
    //   998: goto -90 -> 908
    //   1001: ldc_w 740
    //   1004: invokestatic 884	com/tencent/mm/vfs/ad:bCd	(Ljava/lang/String;)V
    //   1007: ldc_w 348
    //   1010: ldc_w 886
    //   1013: invokestatic 355	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1016: aload_1
    //   1017: ifnull +58 -> 1075
    //   1020: aload_1
    //   1021: invokevirtual 839	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1024: ifeq +51 -> 1075
    //   1027: aload_1
    //   1028: ldc_w 789
    //   1031: ldc_w 791
    //   1034: ldc_w 793
    //   1037: ldc_w 795
    //   1040: ldc_w 841
    //   1043: ldc_w 842
    //   1046: invokestatic 844	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1049: aload_1
    //   1050: invokevirtual 846	android/os/PowerManager$WakeLock:release	()V
    //   1053: aload_1
    //   1054: ldc_w 789
    //   1057: ldc_w 791
    //   1060: ldc_w 793
    //   1063: ldc_w 795
    //   1066: ldc_w 841
    //   1069: ldc_w 842
    //   1072: invokestatic 825	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1075: aload 8
    //   1077: ifnull -919 -> 158
    //   1080: aload 8
    //   1082: iconst_0
    //   1083: iconst_0
    //   1084: invokeinterface 850 3 0
    //   1089: goto -931 -> 158
    //   1092: aload_0
    //   1093: getfield 178	com/tencent/mm/vfs/h:abTc	Ljava/util/HashMap;
    //   1096: astore_1
    //   1097: aload_0
    //   1098: getfield 101	com/tencent/mm/vfs/h:mContext	Landroid/content/Context;
    //   1101: invokestatic 176	com/tencent/mm/vfs/h:lI	(Landroid/content/Context;)Ljava/util/HashMap;
    //   1104: astore 7
    //   1106: aload 7
    //   1108: aload_1
    //   1109: invokevirtual 890	java/util/HashMap:equals	(Ljava/lang/Object;)Z
    //   1112: ifne +30 -> 1142
    //   1115: aload_0
    //   1116: aload 7
    //   1118: putfield 178	com/tencent/mm/vfs/h:abTc	Ljava/util/HashMap;
    //   1121: aload_0
    //   1122: iconst_0
    //   1123: iconst_0
    //   1124: invokestatic 232	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   1127: invokestatic 232	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   1130: invokestatic 232	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   1133: getstatic 92	com/tencent/mm/vfs/h:abTf	Ljava/util/TreeMap;
    //   1136: aload 7
    //   1138: aconst_null
    //   1139: invokespecial 257	com/tencent/mm/vfs/h:a	(ZZLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/SortedMap;Ljava/util/Map;Lcom/tencent/mm/vfs/g;)V
    //   1142: sipush 13126
    //   1145: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1148: iconst_1
    //   1149: ireturn
    //   1150: goto -957 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1153	0	this	h
    //   0	1153	1	paramMessage	Message
    //   114	210	2	l1	long
    //   121	22	4	l2	long
    //   170	380	6	bool	boolean
    //   461	96	7	localOperationCanceledException	android.os.OperationCanceledException
    //   568	6	7	localException	java.lang.Exception
    //   672	13	7	localIterator	Iterator
    //   760	82	7	localObject2	Object
    //   898	239	7	localObject3	Object
    //   225	856	8	locald	d
    //   108	1	9	localCancellationSignal1	CancellationSignal
    //   554	400	9	localCancellationSignal2	CancellationSignal
    //   362	617	10	localm	m
    //   404	468	11	localObject4	Object
    //   413	509	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   71	79	87	java/lang/Throwable
    //   227	244	461	android/os/OperationCanceledException
    //   249	256	461	android/os/OperationCanceledException
    //   260	349	461	android/os/OperationCanceledException
    //   349	358	461	android/os/OperationCanceledException
    //   367	384	461	android/os/OperationCanceledException
    //   384	458	461	android/os/OperationCanceledException
    //   556	568	461	android/os/OperationCanceledException
    //   657	674	461	android/os/OperationCanceledException
    //   674	757	461	android/os/OperationCanceledException
    //   844	861	461	android/os/OperationCanceledException
    //   861	900	461	android/os/OperationCanceledException
    //   908	960	461	android/os/OperationCanceledException
    //   963	991	461	android/os/OperationCanceledException
    //   991	998	461	android/os/OperationCanceledException
    //   1001	1016	461	android/os/OperationCanceledException
    //   358	367	554	finally
    //   227	244	568	java/lang/Exception
    //   249	256	568	java/lang/Exception
    //   260	349	568	java/lang/Exception
    //   349	358	568	java/lang/Exception
    //   367	384	568	java/lang/Exception
    //   384	458	568	java/lang/Exception
    //   556	568	568	java/lang/Exception
    //   657	674	568	java/lang/Exception
    //   674	757	568	java/lang/Exception
    //   844	861	568	java/lang/Exception
    //   861	900	568	java/lang/Exception
    //   908	960	568	java/lang/Exception
    //   963	991	568	java/lang/Exception
    //   991	998	568	java/lang/Exception
    //   1001	1016	568	java/lang/Exception
    //   227	244	760	finally
    //   249	256	760	finally
    //   260	349	760	finally
    //   349	358	760	finally
    //   367	384	760	finally
    //   384	458	760	finally
    //   463	472	760	finally
    //   556	568	760	finally
    //   570	581	760	finally
    //   657	674	760	finally
    //   674	757	760	finally
    //   844	861	760	finally
    //   861	900	760	finally
    //   908	960	760	finally
    //   963	991	760	finally
    //   991	998	760	finally
    //   1001	1016	760	finally
  }
  
  final Looper iWJ()
  {
    AppMethodBeat.i(236210);
    Looper localLooper = this.abSU.getLooper();
    AppMethodBeat.o(236210);
    return localLooper;
  }
  
  public final a iWK()
  {
    AppMethodBeat.i(13119);
    a locala = new a();
    AppMethodBeat.o(13119);
    return locala;
  }
  
  public final l iWL()
  {
    synchronized (this.mLock)
    {
      m localm = this.abSP;
      return localm;
    }
  }
  
  public final Map<String, String> iWM()
  {
    AppMethodBeat.i(236218);
    Map localMap = iWL().ift();
    AppMethodBeat.o(236218);
    return localMap;
  }
  
  public final Map<String, FileSystem> ifl()
  {
    AppMethodBeat.i(236216);
    Map localMap = iWL().ifl();
    AppMethodBeat.o(236216);
    return localMap;
  }
  
  public final e p(Uri paramUri)
  {
    AppMethodBeat.i(236208);
    paramUri = a(paramUri, null);
    AppMethodBeat.o(236208);
    return paramUri;
  }
  
  public final void publish()
  {
    AppMethodBeat.i(13120);
    synchronized (this.mLock)
    {
      m localm = this.abSP;
      a(localm);
      AppMethodBeat.o(13120);
      return;
    }
  }
  
  public final class a
  {
    private final HashMap<String, n> YCH;
    private final HashMap<String, g> YCI;
    private final HashMap<String, g> YCJ;
    private final TreeMap<String, String> YCK;
    private final HashMap<String, String> YCL;
    private g YCM;
    private boolean YCN;
    
    public a()
    {
      AppMethodBeat.i(13105);
      this.YCH = new HashMap();
      this.YCI = new HashMap();
      this.YCJ = new HashMap();
      this.YCK = new TreeMap();
      this.YCL = new HashMap();
      this.YCM = null;
      this.YCN = false;
      AppMethodBeat.o(13105);
    }
    
    public final void HX(boolean paramBoolean)
    {
      AppMethodBeat.i(13113);
      h localh = h.this;
      boolean bool = this.YCN;
      HashMap localHashMap1 = this.YCH;
      HashMap localHashMap2 = this.YCI;
      HashMap localHashMap3 = this.YCJ;
      TreeMap localTreeMap = this.YCK;
      HashMap localHashMap4 = this.YCL;
      if ((this.YCM == null) || (this.YCM.YCm == null)) {}
      for (g localg = null;; localg = this.YCM)
      {
        h.a(localh, paramBoolean, bool, localHashMap1, localHashMap2, localHashMap3, localTreeMap, localHashMap4, localg);
        this.YCI.clear();
        this.YCK.clear();
        this.YCL.clear();
        this.YCN = false;
        AppMethodBeat.o(13113);
        return;
      }
    }
    
    public final a a(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(13107);
      if (paramFileSystem == null) {}
      for (paramFileSystem = null;; paramFileSystem = new g(paramFileSystem))
      {
        this.YCI.put(paramString, paramFileSystem);
        AppMethodBeat.o(13107);
        return this;
      }
    }
    
    public final a a(String paramString, SchemeResolver paramSchemeResolver)
    {
      AppMethodBeat.i(13106);
      if (paramSchemeResolver == null) {}
      for (paramSchemeResolver = null;; paramSchemeResolver = new n(paramSchemeResolver))
      {
        this.YCH.put(paramString, paramSchemeResolver);
        AppMethodBeat.o(13106);
        return this;
      }
    }
    
    public final a b(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(236164);
      paramFileSystem = new g(paramFileSystem);
      this.YCJ.put(paramString, paramFileSystem);
      AppMethodBeat.o(236164);
      return this;
    }
    
    public final a bBF(String paramString)
    {
      AppMethodBeat.i(184814);
      this.YCI.put(paramString, null);
      AppMethodBeat.o(184814);
      return this;
    }
    
    public final a bBG(String paramString)
    {
      AppMethodBeat.i(13109);
      paramString = ad.r(paramString, true, false);
      this.YCK.put(paramString, null);
      AppMethodBeat.o(13109);
      return this;
    }
    
    public final a bBH(String paramString)
    {
      AppMethodBeat.i(13111);
      this.YCL.put(paramString, null);
      AppMethodBeat.o(13111);
      return this;
    }
    
    public final void commit()
    {
      AppMethodBeat.i(13112);
      HX(h.d(h.this));
      AppMethodBeat.o(13112);
    }
    
    public final a ifn()
    {
      AppMethodBeat.i(236168);
      this.YCI.clear();
      this.YCK.clear();
      this.YCL.clear();
      this.YCM = null;
      this.YCN = true;
      AppMethodBeat.o(236168);
      return this;
    }
    
    public final a oi(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13108);
      paramString1 = ad.r(paramString1, true, false);
      this.YCK.put(paramString1, paramString2);
      AppMethodBeat.o(13108);
      return this;
    }
    
    public final a oj(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13110);
      this.YCL.put(paramString1, paramString2);
      AppMethodBeat.o(13110);
      return this;
    }
  }
  
  final class c
    extends BroadcastReceiver
  {
    private CancellationSignal cRE;
    boolean cVD;
    boolean sWW;
    
    private c() {}
    
    final void ifo()
    {
      AppMethodBeat.i(236184);
      Log.i("VFS.FileSystemManager", "Idle status changed: charging = " + this.cVD + ", interactive = " + this.sWW);
      if ((this.cVD) && (!this.sWW) && (this.cRE == null))
      {
        long l = h.a(h.this);
        if (l < 0L)
        {
          AppMethodBeat.o(236184);
          return;
        }
        this.cRE = new CancellationSignal();
        h.b(h.this).sendMessageDelayed(Message.obtain(h.b(h.this), 2, this.cRE), l);
        Log.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
        AppMethodBeat.o(236184);
        return;
      }
      if (((!this.cVD) || (this.sWW)) && (this.cRE != null))
      {
        h.b(h.this).removeMessages(2);
        this.cRE.cancel();
        this.cRE = null;
        Log.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
      }
      AppMethodBeat.o(236184);
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
        ifo();
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
        this.sWW = true;
        continue;
        this.sWW = false;
        continue;
        this.cVD = true;
        continue;
        this.cVD = false;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void br(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void ife();
  }
  
  public static final class e
  {
    final FileSystem.b YCO;
    final int aYQ;
    final String path;
    
    private e(FileSystem.b paramb, String paramString, int paramInt)
    {
      this.YCO = paramb;
      this.path = paramString;
      this.aYQ = paramInt;
    }
    
    final boolean fCF()
    {
      return this.YCO != null;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13115);
      if (!fCF())
      {
        AppMethodBeat.o(13115);
        return "[INVALID]";
      }
      String str = this.path + " -> " + this.YCO.toString();
      AppMethodBeat.o(13115);
      return str;
    }
  }
  
  static final class f
  {
    @SuppressLint({"StaticFieldLeak"})
    static final h YCP;
    
    static
    {
      AppMethodBeat.i(13116);
      h localh = new h((byte)0);
      YCP = localh;
      h.c(localh);
      AppMethodBeat.o(13116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.h
 * JD-Core Version:    0.7.0.1
 */