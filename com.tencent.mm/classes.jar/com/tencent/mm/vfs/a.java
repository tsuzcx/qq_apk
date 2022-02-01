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
  private static volatile b Kgu = null;
  private static volatile boolean Kgv = true;
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Context sContext = null;
  private final File KgA;
  final HandlerThread KgB;
  private c Kgw;
  private int Kgx;
  private e Kgy;
  final c Kgz;
  private final c KhX;
  private final Handler KiX;
  private volatile long KiY;
  private volatile long KiZ;
  private volatile boolean Kja;
  volatile d Kjb;
  volatile boolean Kjc;
  private volatile BroadcastReceiver Kjd;
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
    this.KgA = new File((File)localObject1, ".vfs");
    this.KgB = new HandlerThread("VFS.Maintenance", 4);
    this.KgB.start();
    this.KiX = new Handler(this.KgB.getLooper(), this);
    this.KhX = new c((byte)0);
    this.KiY = -1L;
    this.KiZ = 9223372036854775807L;
    this.Kjc = true;
    Object localObject3 = this.mContext;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put(null, FileSchemeResolver.fxF());
    ((HashMap)localObject1).put("", FileSchemeResolver.fxF());
    ((HashMap)localObject1).put("file", FileSchemeResolver.fxF());
    ((HashMap)localObject1).put("wcf", WcfSchemeResolver.fyA());
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
    this.Kgz = new c().a((Map)localObject1, Collections.emptyMap(), new TreeMap(), (Map)localObject2, null);
    this.Kgw = this.Kgz;
    this.Kgx = 0;
    this.Kgy = new e(null, null, this.Kgx, (byte)0);
    AppMethodBeat.o(13122);
  }
  
  private void a(CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(170153);
    File localFile = new File(this.KgA, "maintain.timestamp");
    Object localObject3;
    synchronized (this.mLock)
    {
      localObject1 = this.Kgw;
      ??? = ((c)localObject1).Jtl.entrySet().iterator();
      if (((Iterator)???).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)???).next();
        SchemeResolver localSchemeResolver = (SchemeResolver)((Map.Entry)localObject3).getValue();
        Log.i("VFS.FileSystemManager", "[Maintenance] " + (String)((Map.Entry)localObject3).getKey() + " => " + localSchemeResolver.toString());
      }
    }
    Object localObject1 = ((c)localObject1).Jtm.entrySet().iterator();
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
    Kgu = paramb;
  }
  
  /* Error */
  private void a(c paramc)
  {
    // Byte code:
    //   0: sipush 13125
    //   3: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokevirtual 403	com/tencent/mm/vfs/c:dMc	()Landroid/os/Bundle;
    //   10: astore 5
    //   12: invokestatic 409	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   15: astore_2
    //   16: aload_2
    //   17: aload 5
    //   19: invokevirtual 413	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   22: aload_2
    //   23: invokevirtual 417	android/os/Parcel:marshall	()[B
    //   26: astore 4
    //   28: aload_2
    //   29: invokevirtual 420	android/os/Parcel:recycle	()V
    //   32: new 422	java/io/DataOutputStream
    //   35: dup
    //   36: new 424	java/io/FileOutputStream
    //   39: dup
    //   40: new 102	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: getfield 115	com/tencent/mm/vfs/a:KgA	Ljava/io/File;
    //   48: ldc_w 426
    //   51: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: invokespecial 429	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 432	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_2
    //   63: aload_3
    //   64: iconst_2
    //   65: invokevirtual 435	java/io/DataOutputStream:writeInt	(I)V
    //   68: aload_3
    //   69: astore_2
    //   70: aload_3
    //   71: aload 4
    //   73: invokevirtual 439	java/io/DataOutputStream:write	([B)V
    //   76: aload_3
    //   77: invokestatic 445	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: getfield 84	com/tencent/mm/vfs/a:mContext	Landroid/content/Context;
    //   84: invokevirtual 448	android/content/Context:getPackageName	()Ljava/lang/String;
    //   87: astore_2
    //   88: new 450	android/content/Intent
    //   91: dup
    //   92: new 275	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   99: aload_2
    //   100: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 452
    //   106: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 453	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   115: astore_2
    //   116: aload_2
    //   117: aload 5
    //   119: invokevirtual 457	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   122: pop
    //   123: aload_2
    //   124: ldc_w 459
    //   127: invokestatic 465	android/os/Process:myPid	()I
    //   130: invokevirtual 469	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   133: pop
    //   134: aload_0
    //   135: getfield 84	com/tencent/mm/vfs/a:mContext	Landroid/content/Context;
    //   138: aload_2
    //   139: invokevirtual 473	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   142: new 275	java/lang/StringBuilder
    //   145: dup
    //   146: sipush 2048
    //   149: invokespecial 475	java/lang/StringBuilder:<init>	(I)V
    //   152: astore_2
    //   153: aload_2
    //   154: ldc_w 477
    //   157: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: getfield 242	com/tencent/mm/vfs/c:Jtl	Ljava/util/Map;
    //   165: aload_2
    //   166: invokestatic 360	com/tencent/mm/vfs/a:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   169: aload_2
    //   170: ldc_w 362
    //   173: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_1
    //   178: getfield 301	com/tencent/mm/vfs/c:Jtm	Ljava/util/Map;
    //   181: aload_2
    //   182: invokestatic 360	com/tencent/mm/vfs/a:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   185: aload_2
    //   186: ldc_w 367
    //   189: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_1
    //   194: getfield 481	com/tencent/mm/vfs/c:Jtn	Ljava/util/SortedMap;
    //   197: aload_2
    //   198: invokestatic 360	com/tencent/mm/vfs/a:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   201: aload_2
    //   202: ldc_w 369
    //   205: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_1
    //   210: getfield 484	com/tencent/mm/vfs/c:Jtp	Ljava/util/Map;
    //   213: aload_2
    //   214: invokestatic 360	com/tencent/mm/vfs/a:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   217: aload_2
    //   218: ldc_w 371
    //   221: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_1
    //   225: getfield 385	com/tencent/mm/vfs/c:Jtq	Lcom/tencent/mm/vfs/FileSystem;
    //   228: invokevirtual 292	java/lang/Object:toString	()Ljava/lang/String;
    //   231: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: bipush 10
    //   236: invokevirtual 377	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: ldc_w 273
    //   243: new 275	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 486
    //   250: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_2
    //   254: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 298	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: sipush 13125
    //   269: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: return
    //   273: astore 4
    //   275: aconst_null
    //   276: astore_3
    //   277: aload_3
    //   278: astore_2
    //   279: ldc_w 273
    //   282: new 275	java/lang/StringBuilder
    //   285: dup
    //   286: ldc_w 488
    //   289: invokespecial 278	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   292: aload 4
    //   294: invokevirtual 323	java/io/IOException:getMessage	()Ljava/lang/String;
    //   297: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 490	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: aload_3
    //   307: invokestatic 445	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
    //   310: goto -230 -> 80
    //   313: astore_1
    //   314: aconst_null
    //   315: astore_2
    //   316: aload_2
    //   317: invokestatic 445	com/tencent/mm/vfs/q:closeQuietly	(Ljava/io/Closeable;)V
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
  
  private void be(Bundle paramBundle)
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
    paramBundle = c.bf((Bundle)???);
    Map localMap = paramBundle.fxQ();
    synchronized (this.mLock)
    {
      this.Kgw = paramBundle;
      this.Kgx += 1;
      this.Kgy = new e(null, null, this.Kgx, (byte)0);
      paramBundle.Jtq.bS(localMap);
      localIterator = paramBundle.Jtl.values().iterator();
      if (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    Iterator localIterator = paramBundle.Jtm.values().iterator();
    while (localIterator.hasNext()) {
      ((FileSystem)localIterator.next()).bS(localMap);
    }
    ??? = new StringBuilder(2048);
    ((StringBuilder)???).append("[Schemes]\n");
    a(paramBundle.Jtl, (StringBuilder)???);
    ((StringBuilder)???).append("[File systems]\n");
    a(paramBundle.Jtm, (StringBuilder)???);
    ((StringBuilder)???).append("[Mount points]\n");
    a(paramBundle.Jtn, (StringBuilder)???);
    ((StringBuilder)???).append("[Environment]\n");
    a(paramBundle.Jtp, (StringBuilder)???);
    ((StringBuilder)???).append("[Root]\n  ").append(paramBundle.Jtq.toString()).append('\n');
    Log.i("VFS.FileSystemManager", "Loaded file system from bundle:\n" + ((StringBuilder)???).toString());
    AppMethodBeat.o(13123);
  }
  
  public static a ghk()
  {
    return f.JsG;
  }
  
  static b ghl()
  {
    return Kgu;
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
  
  public static void zM(boolean paramBoolean)
  {
    Kgv = paramBoolean;
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
      if (parame.beY == this.Kgx) {
        return parame;
      }
      localc = this.Kgw;
      i = this.Kgx;
      parame = this.Kgy;
      localObject = paramUri.getScheme();
      localObject = (SchemeResolver)localc.Jtl.get(localObject);
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
  
  public final void ax(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192573);
    long l = this.KiY;
    if ((paramLong1 >= 0L) && (l < 0L))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      this.mContext.registerReceiver(this.KhX, localIntentFilter);
      this.KhX.kw(this.mContext);
    }
    for (;;)
    {
      this.KiY = paramLong1;
      this.KiZ = paramLong2;
      this.Kja = true;
      AppMethodBeat.o(192573);
      return;
      if ((paramLong1 < 0L) && (l >= 0L))
      {
        this.mContext.unregisterReceiver(this.KhX);
        this.KiX.removeMessages(2);
      }
    }
  }
  
  public final a ghm()
  {
    AppMethodBeat.i(13119);
    a locala = new a();
    AppMethodBeat.o(13119);
    return locala;
  }
  
  public final void ghn()
  {
    AppMethodBeat.i(13120);
    synchronized (this.mLock)
    {
      c localc = this.Kgw;
      a(localc);
      AppMethodBeat.o(13120);
      return;
    }
  }
  
  public final Map<String, FileSystem> gho()
  {
    AppMethodBeat.i(192574);
    synchronized (this.mLock)
    {
      Object localObject2 = this.Kgw;
      if (((c)localObject2).Jtr == null) {
        ((c)localObject2).Jtr = Collections.unmodifiableMap(((c)localObject2).Jtm);
      }
      localObject2 = ((c)localObject2).Jtr;
      AppMethodBeat.o(192574);
      return localObject2;
    }
  }
  
  public final Map<String, String> ghp()
  {
    AppMethodBeat.i(192575);
    synchronized (this.mLock)
    {
      Map localMap = this.Kgw.fxQ();
      AppMethodBeat.o(192575);
      return localMap;
    }
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
        be(paramMessage.getExtras());
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
    long l1 = this.KiZ;
    paramMessage = new File(this.KgA, "maintain.timestamp");
    long l2 = System.currentTimeMillis();
    long l3 = paramMessage.lastModified();
    if (l2 - l3 < l1)
    {
      Log.i("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
      AppMethodBeat.o(13126);
      return true;
    }
    boolean bool = this.Kja;
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
        d locald = this.Kjb;
        try
        {
          Log.i("VFS.FileSystemManager", "Maintenance started. WakeLock: ".concat(String.valueOf(bool)));
          if (locald != null) {
            locald.fxN();
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
          locald.aQ(false, false);
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
          locald.aQ(true, false);
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
          locald.aQ(false, true);
          break;
        }
        finally
        {
          if ((paramMessage != null) && (paramMessage.isHeld())) {
            paramMessage.release();
          }
          if (locald != null) {
            locald.aQ(false, false);
          }
          AppMethodBeat.o(13126);
        }
      }
    }
  }
  
  public final class a
  {
    final HashMap<String, SchemeResolver> JsA;
    final HashMap<String, FileSystem> JsB;
    final TreeMap<String, String> JsC;
    final HashMap<String, String> JsD;
    FileSystem JsE;
    boolean JsF;
    
    public a()
    {
      AppMethodBeat.i(13105);
      this.JsA = new HashMap();
      this.JsB = new HashMap();
      this.JsC = new TreeMap();
      this.JsD = new HashMap();
      this.JsE = null;
      this.JsF = false;
      AppMethodBeat.o(13105);
    }
    
    public final a a(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(13107);
      this.JsB.put(paramString, paramFileSystem);
      AppMethodBeat.o(13107);
      return this;
    }
    
    public final a a(String paramString, SchemeResolver paramSchemeResolver)
    {
      AppMethodBeat.i(13106);
      this.JsA.put(paramString, paramSchemeResolver);
      AppMethodBeat.o(13106);
      return this;
    }
    
    public final a aSl(String paramString)
    {
      AppMethodBeat.i(184814);
      this.JsB.put(paramString, null);
      AppMethodBeat.o(184814);
      return this;
    }
    
    public final a aSm(String paramString)
    {
      AppMethodBeat.i(13109);
      paramString = q.m(paramString, true, false);
      this.JsC.put(paramString, null);
      AppMethodBeat.o(13109);
      return this;
    }
    
    public final a aSn(String paramString)
    {
      AppMethodBeat.i(13111);
      this.JsD.put(paramString, null);
      AppMethodBeat.o(13111);
      return this;
    }
    
    public final void commit()
    {
      AppMethodBeat.i(13112);
      yo(a.d(a.this));
      AppMethodBeat.o(13112);
    }
    
    public final a lV(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13108);
      paramString1 = q.m(paramString1, true, false);
      this.JsC.put(paramString1, paramString2);
      AppMethodBeat.o(13108);
      return this;
    }
    
    public final a lW(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13110);
      this.JsD.put(paramString1, paramString2);
      AppMethodBeat.o(13110);
      return this;
    }
    
    public final void yo(boolean paramBoolean)
    {
      AppMethodBeat.i(13113);
      a.a(a.this, this, paramBoolean);
      this.JsB.clear();
      this.JsC.clear();
      this.JsD.clear();
      this.JsF = false;
      AppMethodBeat.o(13113);
    }
  }
  
  public static abstract interface b
  {
    public abstract Key P(String paramString, Map<String, String> paramMap);
  }
  
  final class c
    extends BroadcastReceiver
  {
    private CancellationSignal GnW;
    private boolean nSp;
    private boolean nSq;
    
    private c() {}
    
    private void fxM()
    {
      AppMethodBeat.i(192571);
      Log.d("VFS.FileSystemManager", "Idle status changed: charging = " + this.nSp + ", interactive = " + this.nSq);
      if ((this.nSp) && (!this.nSq) && (this.GnW == null))
      {
        long l = a.a(a.this);
        if (l < 0L)
        {
          AppMethodBeat.o(192571);
          return;
        }
        this.GnW = new CancellationSignal();
        a.b(a.this).sendMessageDelayed(Message.obtain(a.b(a.this), 2, this.GnW), l);
        Log.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
        AppMethodBeat.o(192571);
        return;
      }
      if (((!this.nSp) || (this.nSq)) && (this.GnW != null))
      {
        a.b(a.this).removeMessages(2);
        this.GnW.cancel();
        this.GnW = null;
        Log.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
      }
      AppMethodBeat.o(192571);
    }
    
    final void kw(Context paramContext)
    {
      AppMethodBeat.i(192572);
      this.nSq = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
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
        this.nSp = bool;
        fxM();
        AppMethodBeat.o(192572);
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
        fxM();
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
        this.nSq = true;
        continue;
        this.nSq = false;
        continue;
        this.nSp = true;
        continue;
        this.nSp = false;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void aQ(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void fxN();
  }
  
  public static final class e
  {
    public final FileSystem Jsh;
    final int beY;
    public final String path;
    
    private e(FileSystem paramFileSystem, String paramString, int paramInt)
    {
      this.Jsh = paramFileSystem;
      this.path = paramString;
      this.beY = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13115);
      if (!valid())
      {
        AppMethodBeat.o(13115);
        return "[INVALID]";
      }
      String str = this.path + " -> " + this.Jsh.toString();
      AppMethodBeat.o(13115);
      return str;
    }
    
    public final boolean valid()
    {
      return this.Jsh != null;
    }
  }
  
  static final class f
  {
    @SuppressLint({"StaticFieldLeak"})
    static final a JsG;
    
    static
    {
      AppMethodBeat.i(13116);
      a locala = new a((byte)0);
      JsG = locala;
      a.c(locala);
      AppMethodBeat.o(13116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.a
 * JD-Core Version:    0.7.0.1
 */