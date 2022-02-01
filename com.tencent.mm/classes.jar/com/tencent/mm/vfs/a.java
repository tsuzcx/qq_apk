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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class a
  implements Handler.Callback
{
  private static volatile b Oft = null;
  private static volatile boolean Ofu = true;
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Context sContext = null;
  final HandlerThread OfA;
  private final c OfB;
  private final Handler OfC;
  private volatile long OfD;
  private volatile long OfE;
  private volatile boolean OfF;
  volatile d OfG;
  volatile boolean OfH;
  private volatile BroadcastReceiver OfI;
  private c Ofv;
  private int Ofw;
  private e Ofx;
  final c Ofy;
  private final File Ofz;
  final Context mContext;
  private final Object mLock;
  
  private a()
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
    this.Ofz = new File((File)localObject1, ".vfs");
    this.OfA = new HandlerThread("VFS.Maintenance", 4);
    this.OfA.start();
    this.OfC = new Handler(this.OfA.getLooper(), this);
    this.OfB = new c((byte)0);
    this.OfD = -1L;
    this.OfE = 9223372036854775807L;
    this.OfH = true;
    Object localObject3 = this.mContext;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put(null, FileSchemeResolver.fOs());
    ((HashMap)localObject1).put("", FileSchemeResolver.fOs());
    ((HashMap)localObject1).put("file", FileSchemeResolver.fOs());
    ((HashMap)localObject1).put("wcf", WcfSchemeResolver.fPu());
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
    this.Ofy = new c().a((Map)localObject1, Collections.emptyMap(), new TreeMap(), (Map)localObject2, null);
    this.Ofv = this.Ofy;
    this.Ofw = 0;
    this.Ofx = new e(null, null, this.Ofw, (byte)0);
    AppMethodBeat.o(13122);
  }
  
  public static void AC(boolean paramBoolean)
  {
    Ofu = paramBoolean;
  }
  
  private void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(170153);
    File localFile = new File(this.Ofz, "maintain.timestamp");
    Object localObject3;
    synchronized (this.mLock)
    {
      localObject1 = this.Ofv;
      ??? = ((c)localObject1).LkQ.entrySet().iterator();
      if (((Iterator)???).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)???).next();
        SchemeResolver localSchemeResolver = (SchemeResolver)((Map.Entry)localObject3).getValue();
        Log.i("VFS.FileSystemManager", "[Maintenance] " + (String)((Map.Entry)localObject3).getKey() + " => " + localSchemeResolver.toString());
      }
    }
    Object localObject1 = ((c)localObject1).LkR.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ??? = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = (FileSystem)((Map.Entry)???).getValue();
      Log.i("VFS.FileSystemManager", "[Maintenance] " + (String)((Map.Entry)???).getKey() + " => " + localObject3.toString());
      ((FileSystem)localObject3).a(paramCancellationSignal);
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
    Oft = paramb;
  }
  
  /* Error */
  private void a(c paramc)
  {
    // Byte code:
    //   0: sipush 13125
    //   3: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 405	com/tencent/mm/vfs/c:dYs	()Landroid/os/Bundle;
    //   10: astore 5
    //   12: invokestatic 411	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   15: astore_2
    //   16: aload_2
    //   17: aload 5
    //   19: invokevirtual 415	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   22: aload_2
    //   23: invokevirtual 419	android/os/Parcel:marshall	()[B
    //   26: astore 4
    //   28: aload_2
    //   29: invokevirtual 422	android/os/Parcel:recycle	()V
    //   32: new 424	java/io/DataOutputStream
    //   35: dup
    //   36: new 426	java/io/FileOutputStream
    //   39: dup
    //   40: new 102	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: getfield 115	com/tencent/mm/vfs/a:Ofz	Ljava/io/File;
    //   48: ldc_w 428
    //   51: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: invokespecial 431	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 434	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: iconst_2
    //   65: invokevirtual 437	java/io/DataOutputStream:writeInt	(I)V
    //   68: aload_3
    //   69: astore_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokevirtual 441	java/io/DataOutputStream:write	([B)V
    //   76: aload_3
    //   77: invokestatic 447	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: getfield 84	com/tencent/mm/vfs/a:mContext	Landroid/content/Context;
    //   84: invokevirtual 450	android/content/Context:getPackageName	()Ljava/lang/String;
    //   87: astore_2
    //   88: new 452	android/content/Intent
    //   91: dup
    //   92: new 277	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 352	java/lang/StringBuilder:<init>	()V
    //   99: aload_2
    //   100: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 454
    //   106: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 455	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   115: astore_2
    //   116: aload_2
    //   117: aload 5
    //   119: invokevirtual 459	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   122: pop
    //   123: aload_2
    //   124: ldc_w 461
    //   127: invokestatic 467	android/os/Process:myPid	()I
    //   130: invokevirtual 471	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   133: pop
    //   134: aload_0
    //   135: getfield 84	com/tencent/mm/vfs/a:mContext	Landroid/content/Context;
    //   138: aload_2
    //   139: invokevirtual 475	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   142: new 277	java/lang/StringBuilder
    //   145: dup
    //   146: sipush 2048
    //   149: invokespecial 477	java/lang/StringBuilder:<init>	(I)V
    //   152: astore_2
    //   153: aload_2
    //   154: ldc_w 479
    //   157: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: getfield 244	com/tencent/mm/vfs/c:LkQ	Ljava/util/Map;
    //   165: aload_2
    //   166: invokestatic 362	com/tencent/mm/vfs/a:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   169: aload_2
    //   170: ldc_w 364
    //   173: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: getfield 303	com/tencent/mm/vfs/c:LkR	Ljava/util/Map;
    //   181: aload_2
    //   182: invokestatic 362	com/tencent/mm/vfs/a:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   185: aload_2
    //   186: ldc_w 369
    //   189: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: getfield 483	com/tencent/mm/vfs/c:LkS	Ljava/util/SortedMap;
    //   197: aload_2
    //   198: invokestatic 362	com/tencent/mm/vfs/a:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   201: aload_2
    //   202: ldc_w 371
    //   205: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_1
    //   210: getfield 486	com/tencent/mm/vfs/c:LkU	Ljava/util/Map;
    //   213: aload_2
    //   214: invokestatic 362	com/tencent/mm/vfs/a:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   217: aload_2
    //   218: ldc_w 373
    //   221: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_1
    //   225: getfield 387	com/tencent/mm/vfs/c:LkV	Lcom/tencent/mm/vfs/FileSystem;
    //   228: invokevirtual 294	java/lang/Object:toString	()Ljava/lang/String;
    //   231: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: bipush 10
    //   236: invokevirtual 379	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc_w 275
    //   243: new 277	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 488
    //   250: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_2
    //   254: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 300	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: sipush 13125
    //   269: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: return
    //   273: astore 4
    //   275: aconst_null
    //   276: astore_3
    //   277: aload_3
    //   278: astore_2
    //   279: ldc_w 275
    //   282: new 277	java/lang/StringBuilder
    //   285: dup
    //   286: ldc_w 490
    //   289: invokespecial 280	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   292: aload 4
    //   294: invokevirtual 325	java/io/IOException:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 492	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_3
    //   307: invokestatic 447	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   310: goto -230 -> 80
    //   313: astore_1
    //   314: aconst_null
    //   315: astore_2
    //   316: aload_2
    //   317: invokestatic 447	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
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
    //   0	337	0	this	a
    //   0	337	1	paramc	c
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
  
  private void bj(Bundle paramBundle)
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
    paramBundle = c.bk((Bundle)???);
    Map localMap = paramBundle.fOF();
    synchronized (this.mLock)
    {
      this.Ofv = paramBundle;
      this.Ofw += 1;
      this.Ofx = new e(null, null, this.Ofw, (byte)0);
      paramBundle.LkV.bY(localMap);
      localIterator = paramBundle.LkQ.values().iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    Iterator localIterator = paramBundle.LkR.values().iterator();
    while (localIterator.hasNext()) {
      ((FileSystem)localIterator.next()).bY(localMap);
    }
    ??? = new StringBuilder(2048);
    ((StringBuilder)???).append("[Schemes]\n");
    a(paramBundle.LkQ, (StringBuilder)???);
    ((StringBuilder)???).append("[File systems]\n");
    a(paramBundle.LkR, (StringBuilder)???);
    ((StringBuilder)???).append("[Mount points]\n");
    a(paramBundle.LkS, (StringBuilder)???);
    ((StringBuilder)???).append("[Environment]\n");
    a(paramBundle.LkU, (StringBuilder)???);
    ((StringBuilder)???).append("[Root]\n  ").append(paramBundle.LkV.toString()).append('\n');
    Log.i("VFS.FileSystemManager", "Loaded file system from bundle:\n" + ((StringBuilder)???).toString());
    AppMethodBeat.o(13123);
  }
  
  public static a gzU()
  {
    return f.Lkl;
  }
  
  static b gzV()
  {
    return Oft;
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
  
  public final e a(Uri paramUri, e parame)
  {
    AppMethodBeat.i(13118);
    Object localObject = this.mLock;
    if (parame != null) {}
    c localc;
    int i;
    try
    {
      if (parame.bpt == this.Ofw) {
        return parame;
      }
      localc = this.Ofv;
      i = this.Ofw;
      parame = this.Ofx;
      localObject = paramUri.getScheme();
      localObject = (SchemeResolver)localc.LkQ.get(localObject);
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
    paramUri = ((SchemeResolver)localObject).a(localc, paramUri);
    if (paramUri == null)
    {
      AppMethodBeat.o(13118);
      return parame;
    }
    paramUri = new e((FileSystem)paramUri.first, (String)paramUri.second, i, (byte)0);
    AppMethodBeat.o(13118);
    return paramUri;
  }
  
  public final void aC(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(190379);
    long l = this.OfD;
    if ((paramLong1 >= 0L) && (l < 0L))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      this.mContext.registerReceiver(this.OfB, localIntentFilter);
      this.OfB.kI(this.mContext);
    }
    for (;;)
    {
      this.OfD = paramLong1;
      this.OfE = paramLong2;
      this.OfF = true;
      AppMethodBeat.o(190379);
      return;
      if ((paramLong1 < 0L) && (l >= 0L))
      {
        this.mContext.unregisterReceiver(this.OfB);
        this.OfC.removeMessages(2);
      }
    }
  }
  
  public final a gzW()
  {
    AppMethodBeat.i(13119);
    a locala = new a();
    AppMethodBeat.o(13119);
    return locala;
  }
  
  public final void gzX()
  {
    AppMethodBeat.i(13120);
    synchronized (this.mLock)
    {
      c localc = this.Ofv;
      a(localc);
      AppMethodBeat.o(13120);
      return;
    }
  }
  
  public final SchemeResolver.b gzY()
  {
    synchronized (this.mLock)
    {
      c localc = this.Ofv;
      return localc;
    }
  }
  
  public final Map<String, String> gzZ()
  {
    AppMethodBeat.i(190380);
    Map localMap = gzY().fOF();
    AppMethodBeat.o(190380);
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
        bj(paramMessage.getExtras());
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
    long l1 = this.OfE;
    paramMessage = new File(this.Ofz, "maintain.timestamp");
    long l2 = System.currentTimeMillis();
    long l3 = paramMessage.lastModified();
    if (l2 - l3 < l1)
    {
      Log.i("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
      AppMethodBeat.o(13126);
      return true;
    }
    boolean bool = this.OfF;
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
        d locald = this.OfG;
        try
        {
          Log.i("VFS.FileSystemManager", "Maintenance started. WakeLock: ".concat(String.valueOf(bool)));
          if (locald != null) {
            locald.fOA();
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
          locald.aY(false, false);
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
          locald.aY(true, false);
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
          locald.aY(false, true);
          break;
        }
        finally
        {
          if ((paramMessage != null) && (paramMessage.isHeld())) {
            paramMessage.release();
          }
          if (locald != null) {
            locald.aY(false, false);
          }
          AppMethodBeat.o(13126);
        }
      }
    }
  }
  
  public final class a
  {
    final HashMap<String, SchemeResolver> Lkf;
    final HashMap<String, FileSystem> Lkg;
    final TreeMap<String, String> Lkh;
    final HashMap<String, String> Lki;
    FileSystem Lkj;
    boolean Lkk;
    
    public a()
    {
      AppMethodBeat.i(13105);
      this.Lkf = new HashMap();
      this.Lkg = new HashMap();
      this.Lkh = new TreeMap();
      this.Lki = new HashMap();
      this.Lkj = null;
      this.Lkk = false;
      AppMethodBeat.o(13105);
    }
    
    public final a a(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(13107);
      this.Lkg.put(paramString, paramFileSystem);
      AppMethodBeat.o(13107);
      return this;
    }
    
    public final a a(String paramString, SchemeResolver paramSchemeResolver)
    {
      AppMethodBeat.i(13106);
      this.Lkf.put(paramString, paramSchemeResolver);
      AppMethodBeat.o(13106);
      return this;
    }
    
    public final a aYk(String paramString)
    {
      AppMethodBeat.i(184814);
      this.Lkg.put(paramString, null);
      AppMethodBeat.o(184814);
      return this;
    }
    
    public final a aYl(String paramString)
    {
      AppMethodBeat.i(13109);
      paramString = q.o(paramString, true, false);
      this.Lkh.put(paramString, null);
      AppMethodBeat.o(13109);
      return this;
    }
    
    public final a aYm(String paramString)
    {
      AppMethodBeat.i(13111);
      this.Lki.put(paramString, null);
      AppMethodBeat.o(13111);
      return this;
    }
    
    public final void commit()
    {
      AppMethodBeat.i(13112);
      za(a.d(a.this));
      AppMethodBeat.o(13112);
    }
    
    public final a mv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13108);
      paramString1 = q.o(paramString1, true, false);
      this.Lkh.put(paramString1, paramString2);
      AppMethodBeat.o(13108);
      return this;
    }
    
    public final a mw(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13110);
      this.Lki.put(paramString1, paramString2);
      AppMethodBeat.o(13110);
      return this;
    }
    
    public final void za(boolean paramBoolean)
    {
      AppMethodBeat.i(13113);
      a.a(a.this, this, paramBoolean);
      this.Lkg.clear();
      this.Lkh.clear();
      this.Lki.clear();
      this.Lkk = false;
      AppMethodBeat.o(13113);
    }
  }
  
  public static abstract interface b
  {
    public abstract Key R(String paramString, Map<String, String> paramMap);
  }
  
  final class c
    extends BroadcastReceiver
  {
    private CancellationSignal HZJ;
    private boolean ovK;
    private boolean ovL;
    
    private c() {}
    
    private void fOz()
    {
      AppMethodBeat.i(190377);
      Log.d("VFS.FileSystemManager", "Idle status changed: charging = " + this.ovK + ", interactive = " + this.ovL);
      if ((this.ovK) && (!this.ovL) && (this.HZJ == null))
      {
        long l = a.a(a.this);
        if (l < 0L)
        {
          AppMethodBeat.o(190377);
          return;
        }
        this.HZJ = new CancellationSignal();
        a.b(a.this).sendMessageDelayed(Message.obtain(a.b(a.this), 2, this.HZJ), l);
        Log.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
        AppMethodBeat.o(190377);
        return;
      }
      if (((!this.ovK) || (this.ovL)) && (this.HZJ != null))
      {
        a.b(a.this).removeMessages(2);
        this.HZJ.cancel();
        this.HZJ = null;
        Log.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
      }
      AppMethodBeat.o(190377);
    }
    
    final void kI(Context paramContext)
    {
      AppMethodBeat.i(190378);
      this.ovL = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
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
        this.ovK = bool;
        fOz();
        AppMethodBeat.o(190378);
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
        fOz();
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
        this.ovL = true;
        continue;
        this.ovL = false;
        continue;
        this.ovK = true;
        continue;
        this.ovK = false;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void aY(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void fOA();
  }
  
  public static final class e
  {
    final FileSystem LjM;
    final int bpt;
    final String path;
    
    private e(FileSystem paramFileSystem, String paramString, int paramInt)
    {
      this.LjM = paramFileSystem;
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
      String str = this.path + " -> " + this.LjM.toString();
      AppMethodBeat.o(13115);
      return str;
    }
    
    final boolean valid()
    {
      return this.LjM != null;
    }
  }
  
  static final class f
  {
    @SuppressLint({"StaticFieldLeak"})
    static final a Lkl;
    
    static
    {
      AppMethodBeat.i(13116);
      a locala = new a((byte)0);
      Lkl = locala;
      a.c(locala);
      AppMethodBeat.o(13116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a
 * JD-Core Version:    0.7.0.1
 */