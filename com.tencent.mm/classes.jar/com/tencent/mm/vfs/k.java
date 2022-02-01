package com.tencent.mm.vfs;

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
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import com.tencent.stubs.logger.LogPrinter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicReference;

public final class k
  implements Handler.Callback
{
  private static final TreeMap<String, String> akmK;
  private static volatile k.b akmo;
  private static volatile boolean akmp;
  private static volatile Context sContext;
  private final Handler akmA;
  private volatile long akmB;
  private volatile long akmC;
  private volatile boolean akmD;
  volatile d akmE;
  private final AtomicReference<e> akmF;
  private final BroadcastReceiver akmG;
  private volatile HashMap<String, Object> akmH;
  volatile boolean akmI;
  private volatile BroadcastReceiver akmJ;
  private q akmq;
  private int akmr;
  private f akms;
  private final Object akmt;
  private p akmu;
  private p akmv;
  private p akmw;
  final File akmx;
  final HandlerThread akmy;
  private final c akmz;
  final Context mContext;
  private final Object mLock;
  
  static
  {
    AppMethodBeat.i(238404);
    sContext = null;
    akmo = null;
    akmp = true;
    akmK = new TreeMap();
    AppMethodBeat.o(238404);
  }
  
  private k()
  {
    AppMethodBeat.i(13122);
    this.mLock = new Object();
    this.akmt = new Object();
    this.akmF = new AtomicReference();
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
    this.akmx = new File((File)localObject1, ".vfs");
    this.akmy = new HandlerThread("VFS.Maintenance", 4);
    this.akmy.start();
    this.akmA = new Handler(this.akmy.getLooper(), this);
    this.akmz = new c((byte)0);
    this.akmB = -1L;
    this.akmC = 9223372036854775807L;
    this.akmI = true;
    this.akmG = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(238432);
        k.b(k.this).sendEmptyMessage(3);
        AppMethodBeat.o(238432);
      }
    };
    this.akmH = nM(this.mContext);
    localObject1 = this.mContext;
    localObject2 = new p();
    ((p)localObject2).agzl.put(null, FileSchemeResolver.jKt());
    ((p)localObject2).agzl.put("", FileSchemeResolver.jKt());
    ((p)localObject2).agzl.put("file", FileSchemeResolver.jKt());
    ((p)localObject2).agzl.put("wcf", WcfSchemeResolver.jKt());
    ((p)localObject2).agzm.put("null", NullFileSystem.jKt());
    ((p)localObject2).agzp.put("data", ((Context)localObject1).getCacheDir().getParent());
    ((p)localObject2).agzp.put("dataCache", ((Context)localObject1).getCacheDir().getPath());
    this.akmw = ((p)localObject2);
    p.f(this.akmw.agzp, this.akmH);
    this.akmu = new p();
    this.akmv = new p();
    this.akmq = new q(this.akmw);
    this.akmr = 0;
    this.akms = new f(null, null, this.akmr, (byte)0);
    AppMethodBeat.o(13122);
  }
  
  public static void Qd(boolean paramBoolean)
  {
    akmp = paramBoolean;
  }
  
  private void Qe(boolean paramBoolean)
  {
    AppMethodBeat.i(238348);
    q localq = new q(new p(this.akmw, paramBoolean).a(this.akmv, paramBoolean).a(this.akmu, paramBoolean));
    synchronized (this.mLock)
    {
      this.akmq = localq;
      this.akmr += 1;
      this.akms = new f(null, null, this.akmr, (byte)0);
      AppMethodBeat.o(238348);
      return;
    }
  }
  
  public static void a(k.b paramb)
  {
    akmo = paramb;
  }
  
  private void ck(Bundle arg1)
  {
    AppMethodBeat.i(13123);
    p localp = p.ce(???);
    synchronized (this.akmt)
    {
      this.akmv = localp;
      Qe(true);
      Log.i("VFS.FileSystemManager", "Loaded public layer from bundle:");
      localp.a(new LogPrinter(4, "VFS.FileSystemManager"));
      AppMethodBeat.o(13123);
      return;
    }
  }
  
  /* Error */
  private void cl(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 395
    //   3: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 401	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_2
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual 404	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   15: aload_2
    //   16: invokevirtual 408	android/os/Parcel:marshall	()[B
    //   19: astore 5
    //   21: aload_2
    //   22: invokevirtual 411	android/os/Parcel:recycle	()V
    //   25: new 130	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: getfield 143	com/tencent/mm/vfs/k:akmx	Ljava/io/File;
    //   33: ldc_w 413
    //   36: invokespecial 141	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   39: astore 6
    //   41: new 130	java/io/File
    //   44: dup
    //   45: aload_0
    //   46: getfield 143	com/tencent/mm/vfs/k:akmx	Ljava/io/File;
    //   49: ldc_w 415
    //   52: invokespecial 141	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore 4
    //   57: new 417	java/io/DataOutputStream
    //   60: dup
    //   61: new 419	java/io/FileOutputStream
    //   64: dup
    //   65: aload 6
    //   67: invokespecial 422	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: invokespecial 425	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   73: astore_3
    //   74: aload_3
    //   75: astore_2
    //   76: aload_3
    //   77: iconst_4
    //   78: invokevirtual 428	java/io/DataOutputStream:writeInt	(I)V
    //   81: aload_3
    //   82: astore_2
    //   83: aload_3
    //   84: aload 5
    //   86: invokevirtual 432	java/io/DataOutputStream:write	([B)V
    //   89: aload_3
    //   90: astore_2
    //   91: aload_3
    //   92: invokevirtual 435	java/io/DataOutputStream:close	()V
    //   95: aload_3
    //   96: astore_2
    //   97: getstatic 440	android/os/Build$VERSION:SDK_INT	I
    //   100: bipush 21
    //   102: if_icmplt +142 -> 244
    //   105: aload_3
    //   106: astore_2
    //   107: aload 6
    //   109: invokevirtual 242	java/io/File:getPath	()Ljava/lang/String;
    //   112: aload 4
    //   114: invokevirtual 242	java/io/File:getPath	()Ljava/lang/String;
    //   117: invokestatic 446	com/tencent/mm/vfs/NativeFileSystem$a:qi	(Ljava/lang/String;Ljava/lang/String;)Z
    //   120: pop
    //   121: aload_3
    //   122: invokestatic 452	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   125: aload_0
    //   126: getfield 115	com/tencent/mm/vfs/k:mContext	Landroid/content/Context;
    //   129: invokevirtual 352	android/content/Context:getPackageName	()Ljava/lang/String;
    //   132: astore_2
    //   133: new 454	android/content/Intent
    //   136: dup
    //   137: new 354	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   144: aload_2
    //   145: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 361
    //   151: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokespecial 455	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   160: astore_2
    //   161: aload 5
    //   163: arraylength
    //   164: ldc_w 456
    //   167: if_icmpge +159 -> 326
    //   170: aload_2
    //   171: aload_1
    //   172: invokevirtual 460	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   175: pop
    //   176: aload_2
    //   177: ldc_w 462
    //   180: invokestatic 468	android/os/Process:myPid	()I
    //   183: invokevirtual 472	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   186: pop
    //   187: ldc_w 295
    //   190: new 354	java/lang/StringBuilder
    //   193: dup
    //   194: ldc_w 474
    //   197: invokespecial 475	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: aload 5
    //   202: arraylength
    //   203: invokevirtual 478	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: ldc_w 480
    //   209: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_2
    //   213: ldc_w 482
    //   216: iconst_0
    //   217: invokevirtual 486	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   220: invokevirtual 489	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   223: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 305	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_0
    //   230: getfield 115	com/tencent/mm/vfs/k:mContext	Landroid/content/Context;
    //   233: aload_2
    //   234: invokevirtual 493	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   237: ldc_w 395
    //   240: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: return
    //   244: aload_3
    //   245: astore_2
    //   246: aload 4
    //   248: invokevirtual 496	java/io/File:delete	()Z
    //   251: pop
    //   252: aload_3
    //   253: astore_2
    //   254: aload 6
    //   256: aload 4
    //   258: invokevirtual 500	java/io/File:renameTo	(Ljava/io/File;)Z
    //   261: pop
    //   262: goto -141 -> 121
    //   265: astore 4
    //   267: aload_3
    //   268: astore_2
    //   269: ldc_w 295
    //   272: new 354	java/lang/StringBuilder
    //   275: dup
    //   276: ldc_w 502
    //   279: invokespecial 475	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload 4
    //   284: invokevirtual 503	java/io/IOException:getMessage	()Ljava/lang/String;
    //   287: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 505	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_3
    //   297: astore_2
    //   298: aload 6
    //   300: invokevirtual 496	java/io/File:delete	()Z
    //   303: pop
    //   304: aload_3
    //   305: invokestatic 452	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   308: goto -183 -> 125
    //   311: astore_1
    //   312: aconst_null
    //   313: astore_2
    //   314: aload_2
    //   315: invokestatic 452	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   318: ldc_w 395
    //   321: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: aload_1
    //   325: athrow
    //   326: aload_2
    //   327: ldc_w 482
    //   330: iconst_1
    //   331: invokevirtual 508	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   334: pop
    //   335: goto -159 -> 176
    //   338: astore_1
    //   339: goto -25 -> 314
    //   342: astore 4
    //   344: aconst_null
    //   345: astore_3
    //   346: goto -79 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	k
    //   0	349	1	paramBundle	Bundle
    //   9	318	2	localObject	Object
    //   73	273	3	localDataOutputStream	java.io.DataOutputStream
    //   55	202	4	localFile1	File
    //   265	18	4	localIOException1	IOException
    //   342	1	4	localIOException2	IOException
    //   19	182	5	arrayOfByte	byte[]
    //   39	260	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   76	81	265	java/io/IOException
    //   83	89	265	java/io/IOException
    //   91	95	265	java/io/IOException
    //   97	105	265	java/io/IOException
    //   107	121	265	java/io/IOException
    //   246	252	265	java/io/IOException
    //   254	262	265	java/io/IOException
    //   57	74	311	finally
    //   76	81	338	finally
    //   83	89	338	finally
    //   91	95	338	finally
    //   97	105	338	finally
    //   107	121	338	finally
    //   246	252	338	finally
    //   254	262	338	finally
    //   269	296	338	finally
    //   298	304	338	finally
    //   57	74	342	java/io/IOException
  }
  
  public static k kMs()
  {
    return g.agxN;
  }
  
  static k.b kMt()
  {
    return akmo;
  }
  
  private Bundle kMy()
  {
    int i = 0;
    AppMethodBeat.i(238339);
    Object localObject1 = new File(this.akmx, "fs.bin");
    long l = ((File)localObject1).length();
    if ((l > 8388608L) || (l <= 4L))
    {
      localObject1 = new IOException("Invalid parcel file size: ".concat(String.valueOf(l)));
      AppMethodBeat.o(238339);
      throw ((Throwable)localObject1);
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      localDataInputStream = new DataInputStream(new FileInputStream((File)localObject1));
      try
      {
        j = localDataInputStream.readInt();
        if (j == 4) {
          break label151;
        }
        localObject1 = new ah.c(k.class, j, 4);
        AppMethodBeat.o(238339);
        throw ((Throwable)localObject1);
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        int j;
        Object localObject3;
        DataInputStream localDataInputStream = null;
      }
    }
    ah.closeQuietly(localDataInputStream);
    localParcel.recycle();
    AppMethodBeat.o(238339);
    throw localObject2;
    label151:
    j = (int)l - 4;
    localObject3 = new byte[j];
    while (i < j) {
      i += localDataInputStream.read((byte[])localObject3, i, j - i);
    }
    localParcel.unmarshall((byte[])localObject3, 0, i);
    localParcel.setDataPosition(0);
    localObject3 = localParcel.readBundle(FileSystem.class.getClassLoader());
    ah.closeQuietly(localDataInputStream);
    localParcel.recycle();
    AppMethodBeat.o(238339);
    return localObject3;
  }
  
  private static HashMap<String, Object> nM(Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(238316);
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
      AppMethodBeat.o(238316);
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
  
  public final f a(Uri paramUri, f paramf)
  {
    AppMethodBeat.i(13118);
    Object localObject = this.mLock;
    if (paramf != null) {}
    q localq;
    int i;
    try
    {
      if (paramf.cSL == this.akmr) {
        return paramf;
      }
      localq = this.akmq;
      i = this.akmr;
      paramf = this.akms;
      localObject = localq.bEj(paramUri.getScheme());
      if (localObject == null)
      {
        AppMethodBeat.o(13118);
        return paramf;
      }
    }
    finally
    {
      AppMethodBeat.o(13118);
    }
    paramUri = ((SchemeResolver.a)localObject).a(localq, paramUri);
    if (paramUri == null)
    {
      AppMethodBeat.o(13118);
      return paramf;
    }
    paramUri = new f((FileSystem.b)paramUri.first, (String)paramUri.second, i, (byte)0);
    AppMethodBeat.o(13118);
    return paramUri;
  }
  
  public final void bK(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(238434);
    long l = this.akmB;
    if ((paramLong1 >= 0L) && (l < 0L))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      this.mContext.registerReceiver(this.akmz, localIntentFilter);
      this.akmz.bF(this.mContext);
    }
    for (;;)
    {
      this.akmB = paramLong1;
      this.akmC = paramLong2;
      this.akmD = true;
      AppMethodBeat.o(238434);
      return;
      if ((paramLong1 < 0L) && (l >= 0L))
      {
        this.mContext.unregisterReceiver(this.akmz);
        this.akmA.removeMessages(2);
      }
    }
  }
  
  /* Error */
  public final boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: sipush 13126
    //   5: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getfield 661	android/os/Message:what	I
    //   12: tableswitch	default:+28 -> 40, 1:+36->48, 2:+158->170, 3:+1141->1153
    //   41: baload
    //   42: fstore_3
    //   43: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: iconst_0
    //   47: ireturn
    //   48: aload_1
    //   49: getfield 664	android/os/Message:obj	Ljava/lang/Object;
    //   52: checkcast 454	android/content/Intent
    //   55: astore_1
    //   56: aload_1
    //   57: ldc_w 566
    //   60: invokevirtual 572	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   63: invokevirtual 668	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   66: aload_1
    //   67: ldc_w 462
    //   70: iconst_0
    //   71: invokevirtual 672	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   74: invokestatic 468	android/os/Process:myPid	()I
    //   77: if_icmpne +20 -> 97
    //   80: ldc_w 295
    //   83: ldc_w 674
    //   86: invokestatic 677	com/tencent/stubs/logger/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: sipush 13126
    //   92: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: iconst_1
    //   96: ireturn
    //   97: aload_1
    //   98: ldc_w 482
    //   101: iconst_0
    //   102: invokevirtual 486	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   105: istore_2
    //   106: ldc_w 295
    //   109: ldc_w 679
    //   112: iload_2
    //   113: invokestatic 682	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   116: invokevirtual 538	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokestatic 305	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: iload_2
    //   123: ifeq +25 -> 148
    //   126: aload_0
    //   127: invokespecial 327	com/tencent/mm/vfs/k:kMy	()Landroid/os/Bundle;
    //   130: astore_1
    //   131: aload_1
    //   132: ifnull +8 -> 140
    //   135: aload_0
    //   136: aload_1
    //   137: invokespecial 330	com/tencent/mm/vfs/k:ck	(Landroid/os/Bundle;)V
    //   140: sipush 13126
    //   143: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iconst_1
    //   147: ireturn
    //   148: aload_1
    //   149: invokevirtual 685	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   152: astore_1
    //   153: goto -22 -> 131
    //   156: astore_1
    //   157: ldc_w 295
    //   160: aload_1
    //   161: ldc_w 687
    //   164: invokestatic 380	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   167: goto -27 -> 140
    //   170: aload_1
    //   171: getfield 664	android/os/Message:obj	Ljava/lang/Object;
    //   174: checkcast 689	android/os/CancellationSignal
    //   177: astore 10
    //   179: aload_0
    //   180: getfield 179	com/tencent/mm/vfs/k:akmC	J
    //   183: lstore 4
    //   185: ldc_w 691
    //   188: invokestatic 695	com/tencent/mm/vfs/ah:bEx	(Ljava/lang/String;)J
    //   191: lstore 6
    //   193: lload 6
    //   195: lload 4
    //   197: lcmp
    //   198: ifge +40 -> 238
    //   201: ldc_w 295
    //   204: ldc_w 697
    //   207: iconst_2
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: lload 6
    //   215: invokestatic 702	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: lload 4
    //   223: invokestatic 702	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   226: aastore
    //   227: invokestatic 705	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: sipush 13126
    //   233: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: iconst_1
    //   237: ireturn
    //   238: aload_0
    //   239: getfield 647	com/tencent/mm/vfs/k:akmD	Z
    //   242: istore_2
    //   243: iload_2
    //   244: ifeq +1021 -> 1265
    //   247: aload_0
    //   248: getfield 115	com/tencent/mm/vfs/k:mContext	Landroid/content/Context;
    //   251: ldc_w 707
    //   254: invokevirtual 711	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   257: ifne +269 -> 526
    //   260: iconst_1
    //   261: istore_2
    //   262: iload_2
    //   263: ifeq +996 -> 1259
    //   266: aload_0
    //   267: getfield 115	com/tencent/mm/vfs/k:mContext	Landroid/content/Context;
    //   270: ldc_w 713
    //   273: invokevirtual 717	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   276: checkcast 719	android/os/PowerManager
    //   279: iconst_1
    //   280: ldc_w 721
    //   283: invokevirtual 725	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   286: astore 8
    //   288: ldc_w 295
    //   291: ldc_w 727
    //   294: iload_2
    //   295: invokestatic 682	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   298: invokevirtual 538	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   301: invokestatic 305	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload 8
    //   306: ifnull +94 -> 400
    //   309: ldc2_w 728
    //   312: new 731	com/tencent/mm/hellhoundlib/b/a
    //   315: dup
    //   316: invokespecial 732	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   319: invokestatic 737	com/tencent/mm/hellhoundlib/b/c:a	(JLcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   322: astore_1
    //   323: aload 8
    //   325: aload_1
    //   326: invokevirtual 741	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   329: ldc_w 743
    //   332: ldc_w 745
    //   335: ldc_w 747
    //   338: ldc_w 749
    //   341: ldc_w 751
    //   344: ldc_w 753
    //   347: invokestatic 758	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   350: aload_1
    //   351: invokestatic 761	com/tencent/mm/hellhoundlib/b/c:a	(Lcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   354: iconst_0
    //   355: invokevirtual 765	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   358: checkcast 699	java/lang/Long
    //   361: invokevirtual 768	java/lang/Long:longValue	()J
    //   364: lstore 4
    //   366: invokestatic 772	com/tencent/mm/hellhoundlib/b/c:aYk	()Lcom/tencent/mm/hellhoundlib/b/a;
    //   369: pop
    //   370: aload 8
    //   372: lload 4
    //   374: invokevirtual 776	android/os/PowerManager$WakeLock:acquire	(J)V
    //   377: aload 8
    //   379: ldc_w 743
    //   382: ldc_w 745
    //   385: ldc_w 747
    //   388: ldc_w 749
    //   391: ldc_w 751
    //   394: ldc_w 753
    //   397: invokestatic 779	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_0
    //   401: getfield 106	com/tencent/mm/vfs/k:mLock	Ljava/lang/Object;
    //   404: astore_1
    //   405: aload_1
    //   406: monitorenter
    //   407: aload_0
    //   408: getfield 258	com/tencent/mm/vfs/k:akmq	Lcom/tencent/mm/vfs/q;
    //   411: astore 11
    //   413: aload_1
    //   414: monitorexit
    //   415: aload_0
    //   416: getfield 113	com/tencent/mm/vfs/k:akmF	Ljava/util/concurrent/atomic/AtomicReference;
    //   419: aconst_null
    //   420: new 23	com/tencent/mm/vfs/k$e
    //   423: dup
    //   424: invokespecial 780	com/tencent/mm/vfs/k$e:<init>	()V
    //   427: invokevirtual 784	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   430: ifne +187 -> 617
    //   433: ldc_w 295
    //   436: ldc_w 786
    //   439: invokestatic 789	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: new 791	android/os/OperationCanceledException
    //   445: dup
    //   446: invokespecial 792	android/os/OperationCanceledException:<init>	()V
    //   449: astore_1
    //   450: sipush 13126
    //   453: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   456: aload_1
    //   457: athrow
    //   458: astore_1
    //   459: aload 8
    //   461: ifnull -231 -> 230
    //   464: aload 8
    //   466: invokevirtual 795	android/os/PowerManager$WakeLock:isHeld	()Z
    //   469: ifeq -239 -> 230
    //   472: aload 8
    //   474: ldc_w 743
    //   477: ldc_w 745
    //   480: ldc_w 747
    //   483: ldc_w 749
    //   486: ldc_w 797
    //   489: ldc_w 798
    //   492: invokestatic 800	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   495: aload 8
    //   497: invokevirtual 802	android/os/PowerManager$WakeLock:release	()V
    //   500: aload 8
    //   502: ldc_w 743
    //   505: ldc_w 745
    //   508: ldc_w 747
    //   511: ldc_w 749
    //   514: ldc_w 797
    //   517: ldc_w 798
    //   520: invokestatic 779	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   523: goto -293 -> 230
    //   526: iconst_0
    //   527: istore_2
    //   528: goto -266 -> 262
    //   531: astore 9
    //   533: aload_1
    //   534: monitorexit
    //   535: sipush 13126
    //   538: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   541: aload 9
    //   543: athrow
    //   544: astore_1
    //   545: aload 8
    //   547: ifnull +62 -> 609
    //   550: aload 8
    //   552: invokevirtual 795	android/os/PowerManager$WakeLock:isHeld	()Z
    //   555: ifeq +54 -> 609
    //   558: aload 8
    //   560: ldc_w 743
    //   563: ldc_w 745
    //   566: ldc_w 747
    //   569: ldc_w 749
    //   572: ldc_w 797
    //   575: ldc_w 798
    //   578: invokestatic 800	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload 8
    //   583: invokevirtual 802	android/os/PowerManager$WakeLock:release	()V
    //   586: aload 8
    //   588: ldc_w 743
    //   591: ldc_w 745
    //   594: ldc_w 747
    //   597: ldc_w 749
    //   600: ldc_w 797
    //   603: ldc_w 798
    //   606: invokestatic 779	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   609: sipush 13126
    //   612: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   615: aload_1
    //   616: athrow
    //   617: aload_0
    //   618: getfield 804	com/tencent/mm/vfs/k:akmE	Lcom/tencent/mm/vfs/k$d;
    //   621: astore 9
    //   623: aload 9
    //   625: ifnull +10 -> 635
    //   628: aload 9
    //   630: invokeinterface 807 1 0
    //   635: aload 11
    //   637: getfield 810	com/tencent/mm/vfs/q:agxI	Lcom/tencent/mm/vfs/p;
    //   640: getfield 199	com/tencent/mm/vfs/p:agzl	Ljava/util/Map;
    //   643: invokeinterface 814 1 0
    //   648: invokeinterface 820 1 0
    //   653: astore_1
    //   654: aload_1
    //   655: invokeinterface 825 1 0
    //   660: ifeq +135 -> 795
    //   663: aload_1
    //   664: invokeinterface 829 1 0
    //   669: checkcast 530	java/lang/String
    //   672: astore 12
    //   674: aload 11
    //   676: aload 12
    //   678: invokevirtual 616	com/tencent/mm/vfs/q:bEj	(Ljava/lang/String;)Lcom/tencent/mm/vfs/SchemeResolver$a;
    //   681: astore 13
    //   683: ldc_w 295
    //   686: new 354	java/lang/StringBuilder
    //   689: dup
    //   690: ldc_w 831
    //   693: invokespecial 475	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   696: aload 12
    //   698: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: ldc_w 833
    //   704: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: aload 13
    //   709: invokeinterface 837 1 0
    //   714: invokevirtual 838	java/lang/Object:toString	()Ljava/lang/String;
    //   717: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   723: invokestatic 305	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   726: goto -72 -> 654
    //   729: astore_1
    //   730: aload_1
    //   731: instanceof 791
    //   734: istore_2
    //   735: iload_2
    //   736: ifeq +402 -> 1138
    //   739: ldc_w 295
    //   742: ldc_w 840
    //   745: invokestatic 305	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: iconst_1
    //   749: istore_2
    //   750: sipush 13126
    //   753: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   756: aload_1
    //   757: athrow
    //   758: astore_1
    //   759: aload 9
    //   761: ifnull +18 -> 779
    //   764: iload_2
    //   765: ifne +5 -> 770
    //   768: iconst_1
    //   769: istore_3
    //   770: aload 9
    //   772: iload_2
    //   773: iload_3
    //   774: invokeinterface 844 3 0
    //   779: aload_0
    //   780: getfield 113	com/tencent/mm/vfs/k:akmF	Ljava/util/concurrent/atomic/AtomicReference;
    //   783: aconst_null
    //   784: invokevirtual 848	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   787: sipush 13126
    //   790: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   793: aload_1
    //   794: athrow
    //   795: aload 11
    //   797: getfield 810	com/tencent/mm/vfs/q:agxI	Lcom/tencent/mm/vfs/p;
    //   800: getfield 223	com/tencent/mm/vfs/p:agzm	Ljava/util/Map;
    //   803: invokeinterface 814 1 0
    //   808: invokeinterface 820 1 0
    //   813: astore_1
    //   814: aload_1
    //   815: invokeinterface 825 1 0
    //   820: ifeq +78 -> 898
    //   823: aload_1
    //   824: invokeinterface 829 1 0
    //   829: checkcast 530	java/lang/String
    //   832: astore 12
    //   834: aload 11
    //   836: aload 12
    //   838: invokevirtual 852	com/tencent/mm/vfs/q:bEh	(Ljava/lang/String;)Lcom/tencent/mm/vfs/FileSystem$b;
    //   841: astore 13
    //   843: ldc_w 295
    //   846: new 354	java/lang/StringBuilder
    //   849: dup
    //   850: ldc_w 831
    //   853: invokespecial 475	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   856: aload 12
    //   858: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: ldc_w 833
    //   864: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload 13
    //   869: invokeinterface 856 1 0
    //   874: invokevirtual 838	java/lang/Object:toString	()Ljava/lang/String;
    //   877: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 305	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   886: aload 13
    //   888: aload 10
    //   890: invokeinterface 858 2 0
    //   895: goto -81 -> 814
    //   898: aload 11
    //   900: getfield 810	com/tencent/mm/vfs/q:agxI	Lcom/tencent/mm/vfs/p;
    //   903: getfield 861	com/tencent/mm/vfs/p:agzn	Ljava/util/Map;
    //   906: invokeinterface 814 1 0
    //   911: invokeinterface 820 1 0
    //   916: astore 12
    //   918: aload 12
    //   920: invokeinterface 825 1 0
    //   925: ifeq +109 -> 1034
    //   928: aload 12
    //   930: invokeinterface 829 1 0
    //   935: checkcast 530	java/lang/String
    //   938: astore 13
    //   940: aload 11
    //   942: getfield 810	com/tencent/mm/vfs/q:agxI	Lcom/tencent/mm/vfs/p;
    //   945: getfield 861	com/tencent/mm/vfs/p:agzn	Ljava/util/Map;
    //   948: aload 13
    //   950: invokeinterface 865 2 0
    //   955: checkcast 867	com/tencent/mm/vfs/r
    //   958: astore_1
    //   959: aload_1
    //   960: ifnonnull +58 -> 1018
    //   963: aconst_null
    //   964: astore_1
    //   965: ldc_w 295
    //   968: new 354	java/lang/StringBuilder
    //   971: dup
    //   972: ldc_w 831
    //   975: invokespecial 475	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   978: aload 13
    //   980: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: ldc_w 833
    //   986: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: aload_1
    //   990: invokeinterface 856 1 0
    //   995: invokevirtual 838	java/lang/Object:toString	()Ljava/lang/String;
    //   998: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 305	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: aload_1
    //   1008: aload 10
    //   1010: invokeinterface 858 2 0
    //   1015: goto -97 -> 918
    //   1018: aload_1
    //   1019: aload 11
    //   1021: invokevirtual 871	com/tencent/mm/vfs/q:jKI	()Ljava/util/Map;
    //   1024: invokevirtual 875	com/tencent/mm/vfs/r:cV	(Ljava/util/Map;)Ljava/lang/Object;
    //   1027: checkcast 628	com/tencent/mm/vfs/FileSystem$b
    //   1030: astore_1
    //   1031: goto -66 -> 965
    //   1034: ldc_w 691
    //   1037: invokestatic 878	com/tencent/mm/vfs/ah:bEw	(Ljava/lang/String;)V
    //   1040: ldc_w 295
    //   1043: ldc_w 880
    //   1046: invokestatic 305	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1049: aload 9
    //   1051: ifnull +12 -> 1063
    //   1054: aload 9
    //   1056: iconst_0
    //   1057: iconst_0
    //   1058: invokeinterface 844 3 0
    //   1063: aload_0
    //   1064: getfield 113	com/tencent/mm/vfs/k:akmF	Ljava/util/concurrent/atomic/AtomicReference;
    //   1067: aconst_null
    //   1068: invokevirtual 848	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   1071: aload 8
    //   1073: ifnull -843 -> 230
    //   1076: aload 8
    //   1078: invokevirtual 795	android/os/PowerManager$WakeLock:isHeld	()Z
    //   1081: ifeq -851 -> 230
    //   1084: aload 8
    //   1086: ldc_w 743
    //   1089: ldc_w 745
    //   1092: ldc_w 747
    //   1095: ldc_w 749
    //   1098: ldc_w 797
    //   1101: ldc_w 798
    //   1104: invokestatic 800	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1107: aload 8
    //   1109: invokevirtual 802	android/os/PowerManager$WakeLock:release	()V
    //   1112: aload 8
    //   1114: ldc_w 743
    //   1117: ldc_w 745
    //   1120: ldc_w 747
    //   1123: ldc_w 749
    //   1126: ldc_w 797
    //   1129: ldc_w 798
    //   1132: invokestatic 779	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1135: goto -905 -> 230
    //   1138: ldc_w 295
    //   1141: aload_1
    //   1142: ldc_w 882
    //   1145: invokestatic 380	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   1148: iconst_0
    //   1149: istore_2
    //   1150: goto -400 -> 750
    //   1153: aload_0
    //   1154: getfield 192	com/tencent/mm/vfs/k:akmH	Ljava/util/HashMap;
    //   1157: astore 8
    //   1159: aload_0
    //   1160: getfield 115	com/tencent/mm/vfs/k:mContext	Landroid/content/Context;
    //   1163: invokestatic 190	com/tencent/mm/vfs/k:nM	(Landroid/content/Context;)Ljava/util/HashMap;
    //   1166: astore_1
    //   1167: aload_1
    //   1168: aload 8
    //   1170: invokevirtual 886	java/util/HashMap:equals	(Ljava/lang/Object;)Z
    //   1173: ifne +60 -> 1233
    //   1176: aload_0
    //   1177: aload_1
    //   1178: putfield 192	com/tencent/mm/vfs/k:akmH	Ljava/util/HashMap;
    //   1181: aload_0
    //   1182: getfield 108	com/tencent/mm/vfs/k:akmt	Ljava/lang/Object;
    //   1185: astore 8
    //   1187: aload 8
    //   1189: monitorenter
    //   1190: aload_0
    //   1191: getfield 244	com/tencent/mm/vfs/k:akmw	Lcom/tencent/mm/vfs/p;
    //   1194: getfield 231	com/tencent/mm/vfs/p:agzp	Ljava/util/Map;
    //   1197: aload_1
    //   1198: invokestatic 247	com/tencent/mm/vfs/p:f	(Ljava/util/Map;Ljava/util/Map;)V
    //   1201: aload_0
    //   1202: iconst_1
    //   1203: invokespecial 287	com/tencent/mm/vfs/k:Qe	(Z)V
    //   1206: aload 8
    //   1208: monitorexit
    //   1209: ldc_w 295
    //   1212: ldc_w 888
    //   1215: invokestatic 305	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1218: new 293	com/tencent/stubs/logger/LogPrinter
    //   1221: dup
    //   1222: iconst_4
    //   1223: ldc_w 295
    //   1226: invokespecial 298	com/tencent/stubs/logger/LogPrinter:<init>	(ILjava/lang/String;)V
    //   1229: aload_1
    //   1230: invokestatic 891	com/tencent/mm/vfs/p:a	(Landroid/util/Printer;Ljava/util/Map;)V
    //   1233: sipush 13126
    //   1236: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1239: iconst_1
    //   1240: ireturn
    //   1241: astore_1
    //   1242: aload 8
    //   1244: monitorexit
    //   1245: sipush 13126
    //   1248: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1251: aload_1
    //   1252: athrow
    //   1253: astore_1
    //   1254: iconst_1
    //   1255: istore_2
    //   1256: goto -497 -> 759
    //   1259: aconst_null
    //   1260: astore 8
    //   1262: goto -974 -> 288
    //   1265: goto -1003 -> 262
    //   1268: astore_1
    //   1269: iconst_0
    //   1270: istore_2
    //   1271: goto -512 -> 759
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1274	0	this	k
    //   0	1274	1	paramMessage	Message
    //   105	1166	2	bool1	boolean
    //   1	773	3	bool2	boolean
    //   183	190	4	l1	long
    //   191	23	6	l2	long
    //   531	11	9	localObject2	Object
    //   621	434	9	locald	d
    //   177	832	10	localCancellationSignal	CancellationSignal
    //   411	609	11	localq	q
    //   672	257	12	localObject3	Object
    //   681	298	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   126	131	156	finally
    //   135	140	156	finally
    //   148	153	156	finally
    //   288	304	458	java/lang/Exception
    //   309	400	458	java/lang/Exception
    //   400	407	458	java/lang/Exception
    //   415	458	458	java/lang/Exception
    //   533	544	458	java/lang/Exception
    //   617	623	458	java/lang/Exception
    //   770	779	458	java/lang/Exception
    //   779	795	458	java/lang/Exception
    //   1054	1063	458	java/lang/Exception
    //   1063	1071	458	java/lang/Exception
    //   407	415	531	finally
    //   288	304	544	finally
    //   309	400	544	finally
    //   400	407	544	finally
    //   415	458	544	finally
    //   533	544	544	finally
    //   617	623	544	finally
    //   770	779	544	finally
    //   779	795	544	finally
    //   1054	1063	544	finally
    //   1063	1071	544	finally
    //   628	635	729	java/lang/RuntimeException
    //   635	654	729	java/lang/RuntimeException
    //   654	726	729	java/lang/RuntimeException
    //   795	814	729	java/lang/RuntimeException
    //   814	895	729	java/lang/RuntimeException
    //   898	918	729	java/lang/RuntimeException
    //   918	959	729	java/lang/RuntimeException
    //   965	1015	729	java/lang/RuntimeException
    //   1018	1031	729	java/lang/RuntimeException
    //   1034	1049	729	java/lang/RuntimeException
    //   750	758	758	finally
    //   1190	1209	1241	finally
    //   739	748	1253	finally
    //   628	635	1268	finally
    //   635	654	1268	finally
    //   654	726	1268	finally
    //   730	735	1268	finally
    //   795	814	1268	finally
    //   814	895	1268	finally
    //   898	918	1268	finally
    //   918	959	1268	finally
    //   965	1015	1268	finally
    //   1018	1031	1268	finally
    //   1034	1049	1268	finally
    //   1138	1148	1268	finally
  }
  
  public final Map<String, FileSystem> jKz()
  {
    AppMethodBeat.i(238443);
    Map localMap = kMw().jKz();
    AppMethodBeat.o(238443);
    return localMap;
  }
  
  final long kMu()
  {
    AppMethodBeat.i(238417);
    e locale = (e)this.akmF.get();
    if ((locale == null) || (locale.tid != Process.myTid()))
    {
      AppMethodBeat.o(238417);
      return -9223372036854775808L;
    }
    long l = locale.timestamp;
    AppMethodBeat.o(238417);
    return l;
  }
  
  public final a kMv()
  {
    AppMethodBeat.i(13119);
    a locala = new a();
    AppMethodBeat.o(13119);
    return locala;
  }
  
  public final o kMw()
  {
    synchronized (this.mLock)
    {
      q localq = this.akmq;
      return localq;
    }
  }
  
  public final Map<String, Object> kMx()
  {
    AppMethodBeat.i(238447);
    Map localMap = kMw().jKI();
    AppMethodBeat.o(238447);
    return localMap;
  }
  
  public final void publish()
  {
    AppMethodBeat.i(13120);
    synchronized (this.akmt)
    {
      Bundle localBundle = this.akmv.writeToBundle();
      cl(localBundle);
      AppMethodBeat.o(13120);
      return;
    }
  }
  
  public final class a
  {
    p agxI;
    boolean agxJ;
    private boolean agxK;
    private final boolean agxL;
    
    a()
    {
      AppMethodBeat.i(13105);
      this.agxI = new p();
      this.agxJ = false;
      this.agxK = false;
      this.agxL = false;
      AppMethodBeat.o(13105);
    }
    
    public final void NS(boolean paramBoolean)
    {
      AppMethodBeat.i(13113);
      p localp1;
      p localp2;
      if (this.agxL)
      {
        localp1 = this.agxI;
        localp2 = null;
        if (!this.agxJ) {
          break label70;
        }
        k.a(k.this, localp2, localp1, paramBoolean);
      }
      for (;;)
      {
        this.agxI = new p();
        this.agxJ = false;
        AppMethodBeat.o(13113);
        return;
        localp2 = this.agxI;
        localp1 = null;
        break;
        label70:
        k.a(k.this, localp2, localp1, this.agxK, paramBoolean);
      }
    }
    
    public final a a(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(13107);
      if (paramFileSystem == null) {}
      for (paramFileSystem = null;; paramFileSystem = new r(paramFileSystem))
      {
        this.agxI.agzm.put(paramString, paramFileSystem);
        AppMethodBeat.o(13107);
        return this;
      }
    }
    
    public final a a(String paramString, SchemeResolver paramSchemeResolver)
    {
      AppMethodBeat.i(13106);
      if (paramSchemeResolver == null) {}
      for (paramSchemeResolver = null;; paramSchemeResolver = new r(paramSchemeResolver))
      {
        this.agxI.agzl.put(paramString, paramSchemeResolver);
        AppMethodBeat.o(13106);
        return this;
      }
    }
    
    public final a b(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(238292);
      paramFileSystem = new r(paramFileSystem);
      this.agxI.agzn.put(paramString, paramFileSystem);
      AppMethodBeat.o(238292);
      return this;
    }
    
    public final a bEb(String paramString)
    {
      AppMethodBeat.i(184814);
      this.agxI.agzm.put(paramString, null);
      AppMethodBeat.o(184814);
      return this;
    }
    
    public final a bEc(String paramString)
    {
      AppMethodBeat.i(13109);
      paramString = ah.v(paramString, true, false);
      this.agxI.agzo.put(new h(paramString), null);
      AppMethodBeat.o(13109);
      return this;
    }
    
    public final a bEd(String paramString)
    {
      AppMethodBeat.i(13111);
      this.agxI.agzp.put(paramString, null);
      this.agxK = true;
      AppMethodBeat.o(13111);
      return this;
    }
    
    public final void commit()
    {
      AppMethodBeat.i(13112);
      NS(k.d(k.this));
      AppMethodBeat.o(13112);
    }
    
    public final a qg(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13108);
      paramString1 = ah.v(paramString1, true, false);
      this.agxI.agzo.put(new h(paramString1), paramString2);
      AppMethodBeat.o(13108);
      return this;
    }
    
    public final a qh(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13110);
      this.agxI.agzp.put(paramString1, paramString2);
      this.agxK = true;
      AppMethodBeat.o(13110);
      return this;
    }
    
    public final a r(String paramString, String[] paramArrayOfString)
    {
      AppMethodBeat.i(238313);
      this.agxI.agzp.put(paramString, paramArrayOfString);
      this.agxK = true;
      AppMethodBeat.o(238313);
      return this;
    }
  }
  
  final class c
    extends BroadcastReceiver
  {
    private CancellationSignal eMV;
    private boolean eRu;
    private boolean wbn;
    
    private c() {}
    
    private void jKC()
    {
      AppMethodBeat.i(238367);
      Log.i("VFS.FileSystemManager", "Idle status changed: charging = " + this.eRu + ", interactive = " + this.wbn);
      if ((this.eRu) && (!this.wbn) && (this.eMV == null))
      {
        long l = k.a(k.this);
        if (l < 0L)
        {
          AppMethodBeat.o(238367);
          return;
        }
        this.eMV = new CancellationSignal();
        k.b(k.this).sendMessageDelayed(Message.obtain(k.b(k.this), 2, this.eMV), l);
        Log.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
        AppMethodBeat.o(238367);
        return;
      }
      if (((!this.eRu) || (this.wbn)) && (this.eMV != null))
      {
        k.b(k.this).removeMessages(2);
        this.eMV.cancel();
        this.eMV = null;
        Log.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
      }
      AppMethodBeat.o(238367);
    }
    
    final void bF(Context paramContext)
    {
      AppMethodBeat.i(238381);
      this.wbn = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
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
        this.eRu = bool;
        jKC();
        AppMethodBeat.o(238381);
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
        jKC();
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
        this.wbn = true;
        continue;
        this.wbn = false;
        continue;
        this.eRu = true;
        continue;
        this.eRu = false;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void bQ(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void jKq();
  }
  
  static final class e
  {
    final int tid;
    final long timestamp;
    
    e()
    {
      AppMethodBeat.i(238353);
      this.tid = Process.myTid();
      this.timestamp = System.nanoTime();
      AppMethodBeat.o(238353);
    }
  }
  
  public static final class f
  {
    public final FileSystem.b agxM;
    final int cSL;
    public final String path;
    
    private f(FileSystem.b paramb, String paramString, int paramInt)
    {
      this.agxM = paramb;
      this.path = paramString;
      this.cSL = paramInt;
    }
    
    public final boolean boj()
    {
      return this.agxM != null;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13115);
      if (!boj())
      {
        AppMethodBeat.o(13115);
        return "[INVALID]";
      }
      String str = this.path + " -> " + this.agxM.toString();
      AppMethodBeat.o(13115);
      return str;
    }
  }
  
  static final class g
  {
    static final k agxN;
    
    static
    {
      AppMethodBeat.i(13116);
      k localk = new k((byte)0);
      agxN = localk;
      k.c(localk);
      AppMethodBeat.o(13116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.k
 * JD-Core Version:    0.7.0.1
 */