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
import java.security.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class g
  implements Handler.Callback
{
  private static volatile b Uvc = null;
  private static volatile boolean Uvd = true;
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Context sContext = null;
  l Uve;
  private int Uvf;
  private e Uvg;
  final l Uvh;
  final File Uvi;
  final HandlerThread Uvj;
  private final c Uvk;
  private final Handler Uvl;
  private volatile long Uvm;
  private volatile long Uvn;
  private volatile boolean Uvo;
  volatile d Uvp;
  volatile boolean Uvq;
  private volatile BroadcastReceiver Uvr;
  final Context mContext;
  final Object mLock;
  
  private g()
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
    this.Uvi = new File((File)localObject1, ".vfs");
    this.Uvj = new HandlerThread("VFS.Maintenance", 4);
    this.Uvj.start();
    this.Uvl = new Handler(this.Uvj.getLooper(), this);
    this.Uvk = new c((byte)0);
    this.Uvm = -1L;
    this.Uvn = 9223372036854775807L;
    this.Uvq = true;
    Object localObject3 = this.mContext;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put(null, FileSchemeResolver.hdX());
    ((HashMap)localObject1).put("", FileSchemeResolver.hdX());
    ((HashMap)localObject1).put("file", FileSchemeResolver.hdX());
    ((HashMap)localObject1).put("wcf", WcfSchemeResolver.hdX());
    localObject2 = Collections.singletonMap("null", NullFileSystem.heh());
    HashMap localHashMap = new HashMap();
    localHashMap.put("data", ((Context)localObject3).getCacheDir().getParent());
    localHashMap.put("dataCache", ((Context)localObject3).getCacheDir().getPath());
    localObject3 = ((Context)localObject3).getExternalCacheDir();
    if (localObject3 != null)
    {
      localHashMap.put("extData", ((File)localObject3).getParent());
      localHashMap.put("extCache", ((File)localObject3).getPath());
    }
    localObject3 = Environment.getExternalStorageDirectory();
    if (localObject3 != null) {
      localHashMap.put("storage", ((File)localObject3).getPath());
    }
    this.Uvh = new l().a((Map)localObject1, (Map)localObject2, Collections.emptyMap(), new TreeMap(), localHashMap, null);
    this.Uve = this.Uvh;
    this.Uvf = 0;
    this.Uvg = new e(null, null, this.Uvf, (byte)0);
    AppMethodBeat.o(13122);
  }
  
  public static void Fh(boolean paramBoolean)
  {
    Uvd = paramBoolean;
  }
  
  public static void a(b paramb)
  {
    Uvc = paramb;
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
  
  private void bx(Bundle paramBundle)
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
    paramBundle = l.by((Bundle)???);
    synchronized (this.mLock)
    {
      this.Uve = paramBundle;
      this.Uvf += 1;
      this.Uvg = new e(null, null, this.Uvf, (byte)0);
      ??? = new StringBuilder(2048);
      ((StringBuilder)???).append("[Schemes]\n");
      a(paramBundle.Rde, (StringBuilder)???);
      ((StringBuilder)???).append("[File systems]\n");
      a(paramBundle.Rdf, (StringBuilder)???);
      ((StringBuilder)???).append("[Maintenance-only] ").append(paramBundle.Rdg.size()).append('\n');
      ((StringBuilder)???).append("[Mount points]\n");
      a(paramBundle.Rdh, (StringBuilder)???);
      ((StringBuilder)???).append("[Environment]\n");
      a(paramBundle.Rdj, (StringBuilder)???);
      ((StringBuilder)???).append("[Root]\n  ").append(paramBundle.Rdk.toString()).append('\n');
      Log.i("VFS.FileSystemManager", "Loaded file system from bundle:\n" + ((StringBuilder)???).toString());
      AppMethodBeat.o(13123);
      return;
    }
  }
  
  public static g hRR()
  {
    return f.Rcm;
  }
  
  static b hRS()
  {
    return Uvc;
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
    l locall;
    int i;
    try
    {
      if (parame.bpo == this.Uvf) {
        return parame;
      }
      locall = this.Uve;
      i = this.Uvf;
      parame = this.Uvg;
      localObject = locall.boV(paramUri.getScheme());
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
    paramUri = ((SchemeResolver.a)localObject).a(locall, paramUri);
    if (paramUri == null)
    {
      AppMethodBeat.o(13118);
      return parame;
    }
    paramUri = new e((FileSystem.b)paramUri.first, (String)paramUri.second, i, (byte)0);
    AppMethodBeat.o(13118);
    return paramUri;
  }
  
  /* Error */
  final void a(l paraml)
  {
    // Byte code:
    //   0: sipush 13125
    //   3: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 365	android/os/Bundle
    //   9: dup
    //   10: invokespecial 366	android/os/Bundle:<init>	()V
    //   13: astore 5
    //   15: new 155	java/util/HashMap
    //   18: dup
    //   19: invokespecial 156	java/util/HashMap:<init>	()V
    //   22: astore 4
    //   24: new 596	java/util/ArrayList
    //   27: dup
    //   28: aload_1
    //   29: getfield 395	com/tencent/mm/vfs/l:Rde	Ljava/util/Map;
    //   32: invokeinterface 406 1 0
    //   37: invokespecial 597	java/util/ArrayList:<init>	(I)V
    //   40: astore 6
    //   42: new 365	android/os/Bundle
    //   45: dup
    //   46: invokespecial 366	android/os/Bundle:<init>	()V
    //   49: astore 7
    //   51: aload_1
    //   52: getfield 395	com/tencent/mm/vfs/l:Rde	Ljava/util/Map;
    //   55: invokeinterface 328 1 0
    //   60: invokeinterface 334 1 0
    //   65: astore 8
    //   67: aload 8
    //   69: invokeinterface 339 1 0
    //   74: ifeq +95 -> 169
    //   77: aload 8
    //   79: invokeinterface 343 1 0
    //   84: checkcast 345	java/util/Map$Entry
    //   87: astore 9
    //   89: aload 9
    //   91: invokeinterface 353 1 0
    //   96: checkcast 599	com/tencent/mm/vfs/m
    //   99: getfield 603	com/tencent/mm/vfs/m:Rds	Lcom/tencent/mm/vfs/SchemeResolver;
    //   102: astore 10
    //   104: aload 4
    //   106: aload 10
    //   108: invokevirtual 607	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   111: checkcast 609	java/lang/Integer
    //   114: astore_3
    //   115: aload_3
    //   116: astore_2
    //   117: aload_3
    //   118: ifnonnull +29 -> 147
    //   121: aload 6
    //   123: invokevirtual 610	java/util/ArrayList:size	()I
    //   126: invokestatic 613	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: astore_2
    //   130: aload 6
    //   132: aload 10
    //   134: invokevirtual 617	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: aload 4
    //   140: aload 10
    //   142: aload_2
    //   143: invokevirtual 166	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: aload 7
    //   149: aload 9
    //   151: invokeinterface 350 1 0
    //   156: checkcast 452	java/lang/String
    //   159: aload_2
    //   160: invokevirtual 620	java/lang/Integer:intValue	()I
    //   163: invokevirtual 623	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   166: goto -99 -> 67
    //   169: aload 5
    //   171: ldc_w 625
    //   174: aload 6
    //   176: invokevirtual 629	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   179: aload 5
    //   181: ldc_w 631
    //   184: aload 7
    //   186: invokevirtual 635	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   189: new 365	android/os/Bundle
    //   192: dup
    //   193: invokespecial 366	android/os/Bundle:<init>	()V
    //   196: astore_2
    //   197: aload_1
    //   198: getfield 398	com/tencent/mm/vfs/l:Rdf	Ljava/util/Map;
    //   201: invokeinterface 328 1 0
    //   206: invokeinterface 334 1 0
    //   211: astore_3
    //   212: aload_3
    //   213: invokeinterface 339 1 0
    //   218: ifeq +44 -> 262
    //   221: aload_3
    //   222: invokeinterface 343 1 0
    //   227: checkcast 345	java/util/Map$Entry
    //   230: astore 4
    //   232: aload_2
    //   233: aload 4
    //   235: invokeinterface 350 1 0
    //   240: checkcast 452	java/lang/String
    //   243: aload 4
    //   245: invokeinterface 353 1 0
    //   250: checkcast 421	com/tencent/mm/vfs/f
    //   253: getfield 639	com/tencent/mm/vfs/f:RbM	Lcom/tencent/mm/vfs/FileSystem;
    //   256: invokevirtual 643	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   259: goto -47 -> 212
    //   262: aload 5
    //   264: ldc_w 645
    //   267: aload_2
    //   268: invokevirtual 635	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   271: new 365	android/os/Bundle
    //   274: dup
    //   275: invokespecial 366	android/os/Bundle:<init>	()V
    //   278: astore_2
    //   279: aload_1
    //   280: getfield 403	com/tencent/mm/vfs/l:Rdg	Ljava/util/Map;
    //   283: invokeinterface 328 1 0
    //   288: invokeinterface 334 1 0
    //   293: astore_3
    //   294: aload_3
    //   295: invokeinterface 339 1 0
    //   300: ifeq +44 -> 344
    //   303: aload_3
    //   304: invokeinterface 343 1 0
    //   309: checkcast 345	java/util/Map$Entry
    //   312: astore 4
    //   314: aload_2
    //   315: aload 4
    //   317: invokeinterface 350 1 0
    //   322: checkcast 452	java/lang/String
    //   325: aload 4
    //   327: invokeinterface 353 1 0
    //   332: checkcast 421	com/tencent/mm/vfs/f
    //   335: getfield 639	com/tencent/mm/vfs/f:RbM	Lcom/tencent/mm/vfs/FileSystem;
    //   338: invokevirtual 643	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   341: goto -47 -> 294
    //   344: aload 5
    //   346: ldc_w 647
    //   349: aload_2
    //   350: invokevirtual 635	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   353: new 365	android/os/Bundle
    //   356: dup
    //   357: invokespecial 366	android/os/Bundle:<init>	()V
    //   360: astore_2
    //   361: aload_1
    //   362: getfield 413	com/tencent/mm/vfs/l:Rdh	Ljava/util/SortedMap;
    //   365: invokeinterface 648 1 0
    //   370: invokeinterface 334 1 0
    //   375: astore_3
    //   376: aload_3
    //   377: invokeinterface 339 1 0
    //   382: ifeq +41 -> 423
    //   385: aload_3
    //   386: invokeinterface 343 1 0
    //   391: checkcast 345	java/util/Map$Entry
    //   394: astore 4
    //   396: aload_2
    //   397: aload 4
    //   399: invokeinterface 350 1 0
    //   404: checkcast 452	java/lang/String
    //   407: aload 4
    //   409: invokeinterface 353 1 0
    //   414: checkcast 452	java/lang/String
    //   417: invokevirtual 651	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: goto -44 -> 376
    //   423: aload 5
    //   425: ldc_w 653
    //   428: aload_2
    //   429: invokevirtual 635	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   432: new 365	android/os/Bundle
    //   435: dup
    //   436: invokespecial 366	android/os/Bundle:<init>	()V
    //   439: astore_2
    //   440: aload_1
    //   441: getfield 416	com/tencent/mm/vfs/l:Rdj	Ljava/util/Map;
    //   444: invokeinterface 328 1 0
    //   449: invokeinterface 334 1 0
    //   454: astore_3
    //   455: aload_3
    //   456: invokeinterface 339 1 0
    //   461: ifeq +41 -> 502
    //   464: aload_3
    //   465: invokeinterface 343 1 0
    //   470: checkcast 345	java/util/Map$Entry
    //   473: astore 4
    //   475: aload_2
    //   476: aload 4
    //   478: invokeinterface 350 1 0
    //   483: checkcast 452	java/lang/String
    //   486: aload 4
    //   488: invokeinterface 353 1 0
    //   493: checkcast 452	java/lang/String
    //   496: invokevirtual 651	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: goto -44 -> 455
    //   502: aload 5
    //   504: ldc_w 655
    //   507: aload_2
    //   508: invokevirtual 635	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   511: aload 5
    //   513: ldc_w 657
    //   516: aload_1
    //   517: getfield 419	com/tencent/mm/vfs/l:Rdk	Lcom/tencent/mm/vfs/f;
    //   520: getfield 639	com/tencent/mm/vfs/f:RbM	Lcom/tencent/mm/vfs/FileSystem;
    //   523: invokevirtual 643	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   526: invokestatic 438	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   529: astore_2
    //   530: aload_2
    //   531: aload 5
    //   533: invokevirtual 660	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   536: aload_2
    //   537: invokevirtual 664	android/os/Parcel:marshall	()[B
    //   540: astore 4
    //   542: aload_2
    //   543: invokevirtual 471	android/os/Parcel:recycle	()V
    //   546: new 666	java/io/DataOutputStream
    //   549: dup
    //   550: new 668	java/io/FileOutputStream
    //   553: dup
    //   554: new 102	java/io/File
    //   557: dup
    //   558: aload_0
    //   559: getfield 115	com/tencent/mm/vfs/g:Uvi	Ljava/io/File;
    //   562: ldc_w 440
    //   565: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   568: invokespecial 669	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   571: invokespecial 672	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   574: astore_3
    //   575: aload_3
    //   576: astore_2
    //   577: aload_3
    //   578: iconst_4
    //   579: invokevirtual 675	java/io/DataOutputStream:writeInt	(I)V
    //   582: aload_3
    //   583: astore_2
    //   584: aload_3
    //   585: aload 4
    //   587: invokevirtual 679	java/io/DataOutputStream:write	([B)V
    //   590: aload_3
    //   591: invokestatic 468	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   594: aload_0
    //   595: getfield 84	com/tencent/mm/vfs/g:mContext	Landroid/content/Context;
    //   598: invokevirtual 478	android/content/Context:getPackageName	()Ljava/lang/String;
    //   601: astore_2
    //   602: new 681	android/content/Intent
    //   605: dup
    //   606: new 271	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   613: aload_2
    //   614: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc_w 482
    //   620: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokespecial 682	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   629: astore_2
    //   630: aload_2
    //   631: aload 5
    //   633: invokevirtual 686	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   636: pop
    //   637: aload_2
    //   638: ldc_w 368
    //   641: invokestatic 378	android/os/Process:myPid	()I
    //   644: invokevirtual 690	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   647: pop
    //   648: aload_0
    //   649: getfield 84	com/tencent/mm/vfs/g:mContext	Landroid/content/Context;
    //   652: aload_2
    //   653: invokevirtual 694	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   656: new 271	java/lang/StringBuilder
    //   659: dup
    //   660: sipush 2048
    //   663: invokespecial 389	java/lang/StringBuilder:<init>	(I)V
    //   666: astore_2
    //   667: aload_2
    //   668: ldc_w 391
    //   671: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload_1
    //   676: getfield 395	com/tencent/mm/vfs/l:Rde	Ljava/util/Map;
    //   679: aload_2
    //   680: invokestatic 289	com/tencent/mm/vfs/g:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   683: aload_2
    //   684: ldc_w 291
    //   687: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload_1
    //   692: getfield 398	com/tencent/mm/vfs/l:Rdf	Ljava/util/Map;
    //   695: aload_2
    //   696: invokestatic 289	com/tencent/mm/vfs/g:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   699: aload_2
    //   700: ldc_w 400
    //   703: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload_1
    //   707: getfield 403	com/tencent/mm/vfs/l:Rdg	Ljava/util/Map;
    //   710: invokeinterface 406 1 0
    //   715: invokevirtual 409	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   718: bipush 10
    //   720: invokevirtual 308	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload_2
    //   725: ldc_w 298
    //   728: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload_1
    //   733: getfield 413	com/tencent/mm/vfs/l:Rdh	Ljava/util/SortedMap;
    //   736: aload_2
    //   737: invokestatic 289	com/tencent/mm/vfs/g:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   740: aload_2
    //   741: ldc_w 300
    //   744: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload_1
    //   749: getfield 416	com/tencent/mm/vfs/l:Rdj	Ljava/util/Map;
    //   752: aload_2
    //   753: invokestatic 289	com/tencent/mm/vfs/g:a	(Ljava/util/Map;Ljava/lang/StringBuilder;)V
    //   756: aload_2
    //   757: ldc_w 302
    //   760: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: aload_1
    //   764: getfield 419	com/tencent/mm/vfs/l:Rdk	Lcom/tencent/mm/vfs/f;
    //   767: invokevirtual 422	com/tencent/mm/vfs/f:toString	()Ljava/lang/String;
    //   770: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: bipush 10
    //   775: invokevirtual 308	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   778: pop
    //   779: ldc_w 310
    //   782: new 271	java/lang/StringBuilder
    //   785: dup
    //   786: ldc_w 696
    //   789: invokespecial 313	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   792: aload_2
    //   793: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 321	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: sipush 13125
    //   808: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   811: return
    //   812: astore 4
    //   814: aconst_null
    //   815: astore_3
    //   816: aload_3
    //   817: astore_2
    //   818: ldc_w 310
    //   821: new 271	java/lang/StringBuilder
    //   824: dup
    //   825: ldc_w 698
    //   828: invokespecial 313	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   831: aload 4
    //   833: invokevirtual 699	java/io/IOException:getMessage	()Ljava/lang/String;
    //   836: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 462	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   845: aload_3
    //   846: invokestatic 468	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   849: goto -255 -> 594
    //   852: astore_1
    //   853: aconst_null
    //   854: astore_2
    //   855: aload_2
    //   856: invokestatic 468	com/tencent/mm/vfs/aa:closeQuietly	(Ljava/io/Closeable;)V
    //   859: sipush 13125
    //   862: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   865: aload_1
    //   866: athrow
    //   867: astore_1
    //   868: goto -13 -> 855
    //   871: astore 4
    //   873: goto -57 -> 816
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	876	0	this	g
    //   0	876	1	paraml	l
    //   116	740	2	localObject1	Object
    //   114	732	3	localObject2	Object
    //   22	564	4	localObject3	Object
    //   812	20	4	localIOException1	java.io.IOException
    //   871	1	4	localIOException2	java.io.IOException
    //   13	619	5	localBundle1	Bundle
    //   40	135	6	localArrayList	java.util.ArrayList
    //   49	136	7	localBundle2	Bundle
    //   65	13	8	localIterator	Iterator
    //   87	63	9	localEntry	Map.Entry
    //   102	39	10	localSchemeResolver	SchemeResolver
    // Exception table:
    //   from	to	target	type
    //   546	575	812	java/io/IOException
    //   546	575	852	finally
    //   577	582	867	finally
    //   584	590	867	finally
    //   818	845	867	finally
    //   577	582	871	java/io/IOException
    //   584	590	871	java/io/IOException
  }
  
  public final void aP(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(187656);
    long l = this.Uvm;
    if ((paramLong1 >= 0L) && (l < 0L))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      this.mContext.registerReceiver(this.Uvk, localIntentFilter);
      this.Uvk.kM(this.mContext);
    }
    for (;;)
    {
      this.Uvm = paramLong1;
      this.Uvn = paramLong2;
      this.Uvo = true;
      AppMethodBeat.o(187656);
      return;
      if ((paramLong1 < 0L) && (l >= 0L))
      {
        this.mContext.unregisterReceiver(this.Uvk);
        this.Uvl.removeMessages(2);
      }
    }
  }
  
  public final a hRT()
  {
    AppMethodBeat.i(13119);
    a locala = new a();
    AppMethodBeat.o(13119);
    return locala;
  }
  
  public final k hRU()
  {
    synchronized (this.mLock)
    {
      l locall = this.Uve;
      return locall;
    }
  }
  
  public final Map<String, String> hRV()
  {
    AppMethodBeat.i(187658);
    Map localMap = hRU().hej();
    AppMethodBeat.o(187658);
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
        bx(paramMessage.getExtras());
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
    CancellationSignal localCancellationSignal1 = (CancellationSignal)paramMessage.obj;
    long l1 = this.Uvn;
    long l2 = aa.bpi("maintain");
    if (l2 < l1)
    {
      Log.i("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. %d / %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
      AppMethodBeat.o(13126);
      return true;
    }
    boolean bool = this.Uvo;
    if (bool) {
      if (this.mContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if (bool) {}
      for (paramMessage = ((PowerManager)this.mContext.getSystemService("power")).newWakeLock(1, "VFS:Maintenance");; paramMessage = null)
      {
        d locald;
        l locall;
        Object localObject5;
        for (;;)
        {
          locald = this.Uvp;
          try
          {
            Log.i("VFS.FileSystemManager", "Maintenance started. WakeLock: ".concat(String.valueOf(bool)));
            if (locald != null) {
              locald.hdV();
            }
            if (paramMessage != null) {
              paramMessage.acquire(1200000L);
            }
          }
          catch (OperationCanceledException localOperationCanceledException) {}catch (Exception localException)
          {
            Log.e("VFS.FileSystemManager", localException, "Maintenance failed.");
            if ((paramMessage != null) && (paramMessage.isHeld())) {
              paramMessage.release();
            }
            if (locald == null) {
              break;
            }
            locald.bh(false, true);
            break;
            Iterator localIterator = locall.Rdf.keySet().iterator();
            while (localIterator.hasNext())
            {
              localObject4 = (String)localIterator.next();
              localObject5 = locall.boT((String)localObject4);
              Log.i("VFS.FileSystemManager", "[Maintenance] " + (String)localObject4 + " => " + ((FileSystem.b)localObject5).hdQ().toString());
              ((FileSystem.b)localObject5).a(localCancellationSignal2);
            }
          }
          finally
          {
            if ((paramMessage != null) && (paramMessage.isHeld())) {
              paramMessage.release();
            }
            if (locald != null) {
              locald.bh(false, false);
            }
            AppMethodBeat.o(13126);
          }
        }
        Object localObject4 = locall.Rdg.keySet().iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          Object localObject3 = (f)locall.Rdg.get(localObject5);
          if (localObject3 == null) {}
          for (localObject3 = null;; localObject3 = ((f)localObject3).RbK)
          {
            Log.i("VFS.FileSystemManager", "[Maintenance] " + (String)localObject5 + " => " + ((FileSystem.b)localObject3).hdQ().toString());
            ((FileSystem.b)localObject3).a(localCancellationSignal2);
            break;
            if (((f)localObject3).RbK == null) {
              ((f)localObject3).RbK = ((f)localObject3).RbM.cj(locall.hej());
            }
          }
        }
        aa.bph("maintain");
        Log.i("VFS.FileSystemManager", "Maintenance finished.");
        if ((paramMessage != null) && (paramMessage.isHeld())) {
          paramMessage.release();
        }
        if (locald == null) {
          break;
        }
        locald.bh(false, false);
        break;
      }
    }
  }
  
  public final Map<String, FileSystem> hec()
  {
    AppMethodBeat.i(187657);
    Map localMap = hRU().hec();
    AppMethodBeat.o(187657);
    return localMap;
  }
  
  public final class a
  {
    final HashMap<String, m> Rce;
    final HashMap<String, f> Rcf;
    final HashMap<String, f> Rcg;
    final TreeMap<String, String> Rch;
    final HashMap<String, String> Rci;
    f Rcj;
    boolean Rck;
    
    public a()
    {
      AppMethodBeat.i(13105);
      this.Rce = new HashMap();
      this.Rcf = new HashMap();
      this.Rcg = new HashMap();
      this.Rch = new TreeMap();
      this.Rci = new HashMap();
      this.Rcj = null;
      this.Rck = false;
      AppMethodBeat.o(13105);
    }
    
    public final void Dx(boolean paramBoolean)
    {
      AppMethodBeat.i(13113);
      g.a(g.this, this, paramBoolean);
      this.Rcf.clear();
      this.Rch.clear();
      this.Rci.clear();
      this.Rck = false;
      AppMethodBeat.o(13113);
    }
    
    public final a a(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(13107);
      if (paramFileSystem == null) {}
      for (paramFileSystem = null;; paramFileSystem = new f(paramFileSystem))
      {
        this.Rcf.put(paramString, paramFileSystem);
        AppMethodBeat.o(13107);
        return this;
      }
    }
    
    public final a a(String paramString, SchemeResolver paramSchemeResolver)
    {
      AppMethodBeat.i(13106);
      if (paramSchemeResolver == null) {}
      for (paramSchemeResolver = null;; paramSchemeResolver = new m(paramSchemeResolver))
      {
        this.Rce.put(paramString, paramSchemeResolver);
        AppMethodBeat.o(13106);
        return this;
      }
    }
    
    public final a b(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(187653);
      paramFileSystem = new f(paramFileSystem);
      this.Rcg.put(paramString, paramFileSystem);
      AppMethodBeat.o(187653);
      return this;
    }
    
    public final a boO(String paramString)
    {
      AppMethodBeat.i(184814);
      this.Rcf.put(paramString, null);
      AppMethodBeat.o(184814);
      return this;
    }
    
    public final a boP(String paramString)
    {
      AppMethodBeat.i(13109);
      paramString = aa.q(paramString, true, false);
      this.Rch.put(paramString, null);
      AppMethodBeat.o(13109);
      return this;
    }
    
    public final a boQ(String paramString)
    {
      AppMethodBeat.i(13111);
      this.Rci.put(paramString, null);
      AppMethodBeat.o(13111);
      return this;
    }
    
    public final void commit()
    {
      AppMethodBeat.i(13112);
      Dx(g.d(g.this));
      AppMethodBeat.o(13112);
    }
    
    public final a ns(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13108);
      paramString1 = aa.q(paramString1, true, false);
      this.Rch.put(paramString1, paramString2);
      AppMethodBeat.o(13108);
      return this;
    }
    
    public final a nt(String paramString1, String paramString2)
    {
      AppMethodBeat.i(13110);
      this.Rci.put(paramString1, paramString2);
      AppMethodBeat.o(13110);
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract Key Z(String paramString, Map<String, String> paramMap);
  }
  
  final class c
    extends BroadcastReceiver
  {
    private CancellationSignal NHn;
    private boolean cSX;
    private boolean pPV;
    
    private c() {}
    
    private void hee()
    {
      AppMethodBeat.i(187654);
      Log.d("VFS.FileSystemManager", "Idle status changed: charging = " + this.cSX + ", interactive = " + this.pPV);
      if ((this.cSX) && (!this.pPV) && (this.NHn == null))
      {
        long l = g.a(g.this);
        if (l < 0L)
        {
          AppMethodBeat.o(187654);
          return;
        }
        this.NHn = new CancellationSignal();
        g.b(g.this).sendMessageDelayed(Message.obtain(g.b(g.this), 2, this.NHn), l);
        Log.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
        AppMethodBeat.o(187654);
        return;
      }
      if (((!this.cSX) || (this.pPV)) && (this.NHn != null))
      {
        g.b(g.this).removeMessages(2);
        this.NHn.cancel();
        this.NHn = null;
        Log.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
      }
      AppMethodBeat.o(187654);
    }
    
    final void kM(Context paramContext)
    {
      AppMethodBeat.i(187655);
      this.pPV = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
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
        this.cSX = bool;
        hee();
        AppMethodBeat.o(187655);
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
        hee();
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
        this.pPV = true;
        continue;
        this.pPV = false;
        continue;
        this.cSX = true;
        continue;
        this.cSX = false;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void bh(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void hdV();
  }
  
  public static final class e
  {
    final FileSystem.b Rcl;
    final int bpo;
    final String path;
    
    private e(FileSystem.b paramb, String paramString, int paramInt)
    {
      this.Rcl = paramb;
      this.path = paramString;
      this.bpo = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(13115);
      if (!valid())
      {
        AppMethodBeat.o(13115);
        return "[INVALID]";
      }
      String str = this.path + " -> " + this.Rcl.toString();
      AppMethodBeat.o(13115);
      return str;
    }
    
    final boolean valid()
    {
      return this.Rcl != null;
    }
  }
  
  static final class f
  {
    @SuppressLint({"StaticFieldLeak"})
    static final g Rcm;
    
    static
    {
      AppMethodBeat.i(13116);
      g localg = new g((byte)0);
      Rcm = localg;
      g.c(localg);
      AppMethodBeat.o(13116);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.g
 * JD-Core Version:    0.7.0.1
 */