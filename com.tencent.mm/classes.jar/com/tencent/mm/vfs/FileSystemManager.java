package com.tencent.mm.vfs;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class FileSystemManager
  implements Handler.Callback
{
  private static volatile boolean APB = true;
  private static volatile b APy;
  @SuppressLint({"StaticFieldLeak"})
  public static volatile Context sContext = null;
  private TreeMap<String, String> APA;
  private HashMap<String, String> APC;
  private ArrayList<c> APD;
  private FileSystem APF;
  private int APG;
  private d APH;
  final HashMap<String, String> APJ;
  private final FileSystem APK;
  private final FileSystem APL;
  private final File APM;
  final HandlerThread APN;
  public final MaintenanceBroadcastReceiver APO;
  private final Handler APQ;
  public volatile long APR;
  public volatile long APS;
  public volatile boolean APT;
  public volatile boolean APU;
  private HashMap<String, FileSystem> APz;
  private volatile BroadcastReceiver CSX;
  private final Object mLock;
  
  static
  {
    APy = null;
  }
  
  private FileSystemManager()
  {
    AppMethodBeat.i(54526);
    this.mLock = new Object();
    this.APJ = new HashMap();
    Object localObject = sContext;
    if (localObject == null)
    {
      localObject = new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
      AppMethodBeat.o(54526);
      throw ((Throwable)localObject);
    }
    this.APM = new File(((Context)localObject).getCacheDir(), ".vfs");
    this.APN = new HandlerThread("VFS.Maintenance", 4);
    this.APN.start();
    this.APQ = new Handler(this.APN.getLooper(), this);
    this.APO = new MaintenanceBroadcastReceiver((byte)0);
    this.APR = -1L;
    this.APS = 9223372036854775807L;
    this.APU = true;
    this.APK = new RawFileSystem("", (byte)0);
    this.APL = new AssetsFileSystem((Context)localObject);
    this.APG = 0;
    this.APz = new HashMap();
    this.APA = new TreeMap();
    this.APD = new ArrayList();
    this.APC = new HashMap();
    this.APF = this.APK;
    this.APH = new d(null, null, this.APG, (byte)0);
    iJ((Context)localObject);
    AppMethodBeat.o(54526);
  }
  
  static RandomAccessFile a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(54523);
    String str = a(paramd, paramBoolean, false);
    if (str == null)
    {
      AppMethodBeat.o(54523);
      return null;
    }
    if (paramBoolean) {}
    for (paramd = "rw";; paramd = "r")
    {
      paramd = new RandomAccessFile(str, paramd);
      AppMethodBeat.o(54523);
      return paramd;
    }
  }
  
  static String a(d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(54522);
    int i = paramd.AQb.ajj();
    if ((paramBoolean2) && ((i & 0x4) == 0))
    {
      AppMethodBeat.o(54522);
      return null;
    }
    if ((!paramBoolean2) && ((i & 0x2) == 0))
    {
      AppMethodBeat.o(54522);
      return null;
    }
    paramd = paramd.AQb.P(paramd.path, paramBoolean1);
    AppMethodBeat.o(54522);
    return paramd;
  }
  
  private static ArrayList<c> a(HashMap<String, FileSystem> paramHashMap, TreeMap<String, String> paramTreeMap, Map<String, String> paramMap)
  {
    AppMethodBeat.i(54531);
    ArrayList localArrayList = new ArrayList(paramTreeMap.size());
    Iterator localIterator = paramTreeMap.entrySet().iterator();
    paramTreeMap = null;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      FileSystem localFileSystem = (FileSystem)paramHashMap.get(localObject);
      if (localFileSystem == null)
      {
        paramHashMap = new IllegalArgumentException("FileSystem '" + (String)localObject + "' for mount point '" + str + "' not exist.");
        AppMethodBeat.o(54531);
        throw paramHashMap;
      }
      str = j.J(str, paramMap);
      if (str != null)
      {
        if ((paramTreeMap != null) && (str.startsWith(paramTreeMap))) {}
        for (boolean bool = true;; bool = false)
        {
          localArrayList.add(new c(str, (String)localObject, localFileSystem, bool));
          paramTreeMap = str;
          break;
        }
      }
    }
    AppMethodBeat.o(54531);
    return localArrayList;
  }
  
  public static void a(b paramb)
  {
    APy = paramb;
  }
  
  /* Error */
  private void a(HashMap<String, FileSystem> paramHashMap, TreeMap<String, String> paramTreeMap, HashMap<String, String> paramHashMap1, FileSystem paramFileSystem)
  {
    // Byte code:
    //   0: ldc_w 390
    //   3: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 392	android/os/Bundle
    //   9: dup
    //   10: invokespecial 393	android/os/Bundle:<init>	()V
    //   13: astore 5
    //   15: new 392	android/os/Bundle
    //   18: dup
    //   19: invokespecial 393	android/os/Bundle:<init>	()V
    //   22: astore 6
    //   24: aload_1
    //   25: invokevirtual 394	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   28: invokeinterface 255 1 0
    //   33: astore_1
    //   34: aload_1
    //   35: invokeinterface 261 1 0
    //   40: ifeq +42 -> 82
    //   43: aload_1
    //   44: invokeinterface 265 1 0
    //   49: checkcast 267	java/util/Map$Entry
    //   52: astore 7
    //   54: aload 6
    //   56: aload 7
    //   58: invokeinterface 270 1 0
    //   63: checkcast 272	java/lang/String
    //   66: aload 7
    //   68: invokeinterface 275 1 0
    //   73: checkcast 396	android/os/Parcelable
    //   76: invokevirtual 400	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   79: goto -45 -> 34
    //   82: aload 5
    //   84: ldc_w 402
    //   87: aload 6
    //   89: invokevirtual 406	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   92: new 392	android/os/Bundle
    //   95: dup
    //   96: invokespecial 393	android/os/Bundle:<init>	()V
    //   99: astore_1
    //   100: aload_2
    //   101: invokevirtual 249	java/util/TreeMap:entrySet	()Ljava/util/Set;
    //   104: invokeinterface 255 1 0
    //   109: astore_2
    //   110: aload_2
    //   111: invokeinterface 261 1 0
    //   116: ifeq +41 -> 157
    //   119: aload_2
    //   120: invokeinterface 265 1 0
    //   125: checkcast 267	java/util/Map$Entry
    //   128: astore 6
    //   130: aload_1
    //   131: aload 6
    //   133: invokeinterface 270 1 0
    //   138: checkcast 272	java/lang/String
    //   141: aload 6
    //   143: invokeinterface 275 1 0
    //   148: checkcast 272	java/lang/String
    //   151: invokevirtual 409	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: goto -44 -> 110
    //   157: aload 5
    //   159: ldc_w 411
    //   162: aload_1
    //   163: invokevirtual 406	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   166: new 392	android/os/Bundle
    //   169: dup
    //   170: invokespecial 393	android/os/Bundle:<init>	()V
    //   173: astore_1
    //   174: aload_3
    //   175: invokevirtual 394	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   178: invokeinterface 255 1 0
    //   183: astore_2
    //   184: aload_2
    //   185: invokeinterface 261 1 0
    //   190: ifeq +38 -> 228
    //   193: aload_2
    //   194: invokeinterface 265 1 0
    //   199: checkcast 267	java/util/Map$Entry
    //   202: astore_3
    //   203: aload_1
    //   204: aload_3
    //   205: invokeinterface 270 1 0
    //   210: checkcast 272	java/lang/String
    //   213: aload_3
    //   214: invokeinterface 275 1 0
    //   219: checkcast 272	java/lang/String
    //   222: invokevirtual 409	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: goto -41 -> 184
    //   228: aload 5
    //   230: ldc_w 413
    //   233: aload_1
    //   234: invokevirtual 406	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   237: aload 5
    //   239: ldc_w 415
    //   242: aload 4
    //   244: invokevirtual 400	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   247: invokestatic 421	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   250: astore_1
    //   251: aload_1
    //   252: aload 5
    //   254: invokevirtual 425	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   257: aload_1
    //   258: invokevirtual 429	android/os/Parcel:marshall	()[B
    //   261: astore_3
    //   262: aload_1
    //   263: invokevirtual 432	android/os/Parcel:recycle	()V
    //   266: new 434	java/io/DataOutputStream
    //   269: dup
    //   270: new 436	java/io/FileOutputStream
    //   273: dup
    //   274: new 110	java/io/File
    //   277: dup
    //   278: aload_0
    //   279: getfield 123	com/tencent/mm/vfs/FileSystemManager:APM	Ljava/io/File;
    //   282: ldc_w 438
    //   285: invokespecial 121	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   288: invokespecial 441	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   291: invokespecial 444	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   294: astore_2
    //   295: aload_2
    //   296: astore_1
    //   297: aload_2
    //   298: iconst_1
    //   299: invokevirtual 447	java/io/DataOutputStream:writeInt	(I)V
    //   302: aload_2
    //   303: astore_1
    //   304: aload_2
    //   305: aload_3
    //   306: invokevirtual 451	java/io/DataOutputStream:write	([B)V
    //   309: aload_2
    //   310: invokevirtual 454	java/io/DataOutputStream:close	()V
    //   313: getstatic 76	com/tencent/mm/vfs/FileSystemManager:sContext	Landroid/content/Context;
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 457	android/content/Context:getPackageName	()Ljava/lang/String;
    //   321: astore_2
    //   322: new 459	android/content/Intent
    //   325: dup
    //   326: new 283	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   333: aload_2
    //   334: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 461
    //   340: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokespecial 462	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   349: astore_2
    //   350: aload_2
    //   351: aload 5
    //   353: invokevirtual 466	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   356: pop
    //   357: aload_2
    //   358: ldc_w 468
    //   361: invokestatic 473	android/os/Process:myPid	()I
    //   364: invokevirtual 477	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   367: pop
    //   368: aload_1
    //   369: aload_2
    //   370: invokevirtual 481	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   373: ldc_w 346
    //   376: ldc_w 483
    //   379: invokestatic 352	com/tencent/f/a/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: ldc_w 390
    //   385: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: return
    //   389: astore_3
    //   390: aconst_null
    //   391: astore_2
    //   392: aload_2
    //   393: astore_1
    //   394: ldc_w 346
    //   397: new 283	java/lang/StringBuilder
    //   400: dup
    //   401: ldc_w 485
    //   404: invokespecial 286	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   407: aload_3
    //   408: invokevirtual 488	java/io/IOException:getMessage	()Ljava/lang/String;
    //   411: invokevirtual 290	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 298	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 490	com/tencent/f/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: aload_2
    //   421: ifnull -108 -> 313
    //   424: aload_2
    //   425: invokevirtual 454	java/io/DataOutputStream:close	()V
    //   428: goto -115 -> 313
    //   431: astore_1
    //   432: goto -119 -> 313
    //   435: astore_2
    //   436: aconst_null
    //   437: astore_1
    //   438: aload_1
    //   439: ifnull +7 -> 446
    //   442: aload_1
    //   443: invokevirtual 454	java/io/DataOutputStream:close	()V
    //   446: ldc_w 390
    //   449: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: aload_2
    //   453: athrow
    //   454: astore_1
    //   455: goto -142 -> 313
    //   458: astore_1
    //   459: goto -13 -> 446
    //   462: astore_2
    //   463: goto -25 -> 438
    //   466: astore_3
    //   467: goto -75 -> 392
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	FileSystemManager
    //   0	470	1	paramHashMap	HashMap<String, FileSystem>
    //   0	470	2	paramTreeMap	TreeMap<String, String>
    //   0	470	3	paramHashMap1	HashMap<String, String>
    //   0	470	4	paramFileSystem	FileSystem
    //   13	339	5	localBundle	Bundle
    //   22	120	6	localObject	Object
    //   52	15	7	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   266	295	389	java/io/IOException
    //   424	428	431	java/io/IOException
    //   266	295	435	finally
    //   309	313	454	java/io/IOException
    //   442	446	458	java/io/IOException
    //   297	302	462	finally
    //   304	309	462	finally
    //   394	420	462	finally
    //   297	302	466	java/io/IOException
    //   304	309	466	java/io/IOException
  }
  
  private static <K, V> void a(Map<K, V> paramMap, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(54529);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramStringBuilder.append("  ").append(localEntry.getKey().toString());
      if (localEntry.getValue() == null) {
        paramStringBuilder.append(" (deleted)\n");
      } else {
        paramStringBuilder.append(" => ").append(localEntry.getValue().toString()).append('\n');
      }
    }
    AppMethodBeat.o(54529);
  }
  
  private void aK(Bundle arg1)
  {
    AppMethodBeat.i(54527);
    Bundle localBundle = ???;
    if (??? == null) {
      localBundle = new Bundle();
    }
    if (localBundle.getInt("pid") == Process.myPid()) {}
    HashMap localHashMap;
    synchronized (this.mLock)
    {
      if (this.APF != null)
      {
        AppMethodBeat.o(54527);
        return;
      }
      ??? = localBundle.getBundle("fs");
      localHashMap = new HashMap();
      if (??? != null)
      {
        ???.setClassLoader(localBundle.getClassLoader());
        localObject3 = ???.keySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localHashMap.put(localObject4, ???.getParcelable((String)localObject4));
        }
      }
    }
    ??? = localObject1.getBundle("mp");
    Object localObject3 = new TreeMap();
    Object localObject5;
    if (??? != null)
    {
      ???.setClassLoader(localObject1.getClassLoader());
      localObject4 = ???.keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        ((TreeMap)localObject3).put(localObject5, ???.getString((String)localObject5));
      }
    }
    ??? = localObject1.getBundle("env");
    Object localObject4 = new HashMap();
    Object localObject6;
    if (??? != null)
    {
      localObject5 = ???.keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (String)((Iterator)localObject5).next();
        ((HashMap)localObject4).put(localObject6, ???.getString((String)localObject6));
      }
    }
    ??? = (FileSystem)localObject1.getParcelable("root");
    if (??? == null) {
      ??? = this.APK;
    }
    for (;;)
    {
      ??? = new HashMap(this.APJ);
      ((Map)???).putAll((Map)localObject4);
      localObject5 = a(localHashMap, (TreeMap)localObject3, (Map)???);
      localObject6 = Collections.unmodifiableMap((Map)???);
      synchronized (this.mLock)
      {
        this.APz = localHashMap;
        this.APA = ((TreeMap)localObject3);
        this.APD = ((ArrayList)localObject5);
        this.APC = ((HashMap)localObject4);
        this.APF = ???;
        this.APG += 1;
        this.APH = new d(null, null, this.APG, (byte)0);
        this.APF.q((Map)localObject6);
        localObject5 = localHashMap.values().iterator();
        if (((Iterator)localObject5).hasNext()) {
          ((FileSystem)((Iterator)localObject5).next()).q((Map)localObject6);
        }
      }
      ??? = new StringBuilder(1024);
      ((StringBuilder)???).append("[File systems]\n");
      a(localHashMap, (StringBuilder)???);
      ((StringBuilder)???).append("[Mount points]\n");
      a((Map)localObject3, (StringBuilder)???);
      ((StringBuilder)???).append("[Environment]\n");
      a((Map)localObject4, (StringBuilder)???);
      ((StringBuilder)???).append("[Root]\n  ").append(???.toString()).append('\n');
      b.i("VFS.FileSystemManager", "Loaded file system from bundle:\n" + ((StringBuilder)???).toString());
      AppMethodBeat.o(54527);
      return;
    }
  }
  
  private static String azV(String paramString)
  {
    AppMethodBeat.i(54520);
    paramString = new File(paramString);
    try
    {
      String str = paramString.getCanonicalPath();
      AppMethodBeat.o(54520);
      return str;
    }
    catch (IOException localIOException)
    {
      paramString = paramString.getAbsolutePath();
      AppMethodBeat.o(54520);
    }
    return paramString;
  }
  
  public static FileSystemManager dQE()
  {
    return e.AQd;
  }
  
  private static <K, V> void e(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
    AppMethodBeat.i(54528);
    paramMap2 = paramMap2.entrySet().iterator();
    while (paramMap2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap2.next();
      if (localEntry.getValue() == null) {
        paramMap1.remove(localEntry.getKey());
      } else {
        paramMap1.put(localEntry.getKey(), localEntry.getValue());
      }
    }
    AppMethodBeat.o(54528);
  }
  
  static b erR()
  {
    return APy;
  }
  
  private void iJ(Context paramContext)
  {
    AppMethodBeat.i(54519);
    this.APJ.put("data", paramContext.getCacheDir().getParent());
    this.APJ.put("dataCache", paramContext.getCacheDir().getPath());
    try
    {
      paramContext = paramContext.getExternalCacheDir();
      if (paramContext != null)
      {
        this.APJ.put("extData", paramContext.getParent());
        this.APJ.put("extCache", paramContext.getPath());
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        b.b("VFS.FileSystemManager", paramContext, "Cannot get external cache directory.");
      }
      AppMethodBeat.o(54519);
    }
    paramContext = Environment.getExternalStorageDirectory();
    if (paramContext != null) {
      this.APJ.put("storage", paramContext.getPath());
    }
    b.i("VFS.FileSystemManager", "Static environment:");
    paramContext = this.APJ.entrySet().iterator();
    while (paramContext.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramContext.next();
      b.i("VFS.FileSystemManager", "  " + (String)localEntry.getKey() + " => " + (String)localEntry.getValue());
    }
  }
  
  public static void nT(boolean paramBoolean)
  {
    APB = paramBoolean;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(54518);
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {}
    for (;;)
    {
      sContext = paramContext;
      AppMethodBeat.o(54518);
      return;
      paramContext = localContext;
    }
  }
  
  final d a(Uri paramUri, d paramd)
  {
    AppMethodBeat.i(54521);
    Object localObject = this.mLock;
    if (paramd != null) {}
    HashMap localHashMap;
    ArrayList localArrayList;
    int j;
    d locald;
    String str;
    try
    {
      if (paramd.aIT == this.APG) {
        return paramd;
      }
      localHashMap = this.APz;
      localArrayList = this.APD;
      paramd = this.APF;
      j = this.APG;
      locald = this.APH;
      localObject = paramUri.getPath();
      str = paramUri.getScheme();
      if ((str != null) && (!str.equals("file"))) {
        break label333;
      }
      if ((localObject == null) || (((String)localObject).isEmpty()))
      {
        AppMethodBeat.o(54521);
        return locald;
      }
    }
    finally
    {
      AppMethodBeat.o(54521);
    }
    localObject = azV((String)localObject);
    int i = Collections.binarySearch(localArrayList, localObject);
    if (i >= 0) {
      paramd = ((c)localArrayList.get(i)).AQb;
    }
    for (paramUri = "";; paramUri = ((String)localObject).substring(paramUri.APZ.length() + 1))
    {
      paramUri = new d(paramd, paramUri, j, (byte)0);
      AppMethodBeat.o(54521);
      return paramUri;
      i = -i - 2;
      if (i >= 0) {
        paramUri = (c)localArrayList.get(i);
      }
      while ((paramUri != null) && ((!((String)localObject).startsWith(paramUri.APZ)) || (((String)localObject).charAt(paramUri.APZ.length()) != '/'))) {
        if (paramUri.AQc)
        {
          i -= 1;
          paramUri = (c)localArrayList.get(i);
          continue;
          paramUri = null;
        }
        else
        {
          paramUri = null;
        }
      }
      if (paramUri == null) {
        break;
      }
      paramd = paramUri.AQb;
    }
    if ((!((String)localObject).isEmpty()) && (((String)localObject).charAt(0) == '/')) {}
    for (paramUri = ((String)localObject).substring(1);; paramUri = (Uri)localObject)
    {
      break;
      label333:
      if (str.equals("wcf"))
      {
        paramUri = (FileSystem)localHashMap.get(paramUri.getAuthority());
        if (localObject == null)
        {
          localObject = "";
          paramd = paramUri;
          paramUri = (Uri)localObject;
          break;
        }
        localObject = j.l((String)localObject, true, true);
        paramd = paramUri;
        paramUri = (Uri)localObject;
        break;
      }
      if (str.equals("assets"))
      {
        paramd = this.APL;
        if (localObject == null)
        {
          paramUri = "";
          break;
        }
        paramUri = j.l((String)localObject, true, true);
        break;
      }
      AppMethodBeat.o(54521);
      return locald;
    }
  }
  
  public final a erS()
  {
    AppMethodBeat.i(54524);
    a locala = new a();
    AppMethodBeat.o(54524);
    return locala;
  }
  
  public final void erT()
  {
    AppMethodBeat.i(54525);
    synchronized (this.mLock)
    {
      HashMap localHashMap1 = this.APz;
      TreeMap localTreeMap = this.APA;
      HashMap localHashMap2 = this.APC;
      FileSystem localFileSystem = this.APF;
      a(localHashMap1, localTreeMap, localHashMap2, localFileSystem);
      AppMethodBeat.o(54525);
      return;
    }
  }
  
  public final boolean handleMessage(Message arg1)
  {
    AppMethodBeat.i(54532);
    switch (???.what)
    {
    default: 
      AppMethodBeat.o(54532);
      return false;
    case 1: 
      ??? = (Intent)???.obj;
      ???.setExtrasClassLoader(FileSystem.class.getClassLoader());
      b.i("VFS.FileSystemManager", "Refresh file system from broadcast.");
      try
      {
        aK(???.getExtras());
        AppMethodBeat.o(54532);
        return true;
      }
      catch (RuntimeException ???)
      {
        for (;;)
        {
          b.b("VFS.FileSystemManager", ???, "Failed to refresh file system from broadcast.");
        }
      }
    }
    CancellationSignal localCancellationSignal = (CancellationSignal)???.obj;
    long l1 = this.APS;
    File localFile = new File(this.APM, "maintain.timestamp");
    long l2 = System.currentTimeMillis();
    long l3 = localFile.lastModified();
    if (l2 - l3 < l1)
    {
      b.i("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
      AppMethodBeat.o(54532);
      return true;
    }
    Object localObject4 = sContext;
    boolean bool = this.APT;
    if (bool) {
      if (((Context)localObject4).checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      label222:
      Object localObject3;
      synchronized (this.mLock)
      {
        localObject3 = this.APz;
        if (bool) {
          ??? = ((PowerManager)((Context)localObject4).getSystemService("power")).newWakeLock(1, "VFS:Maintenance");
        }
      }
      for (;;)
      {
        try
        {
          b.i("VFS.FileSystemManager", "Maintenance started. WakeLock: ".concat(String.valueOf(bool)));
          if (??? != null) {
            ???.acquire(1200000L);
          }
          localObject3 = ((HashMap)localObject3).entrySet().iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject3).next();
            FileSystem localFileSystem = (FileSystem)((Map.Entry)localObject4).getValue();
            b.i("VFS.FileSystemManager", "[Maintenance] " + (String)((Map.Entry)localObject4).getKey() + " => " + localFileSystem.toString());
            localFileSystem.a(localCancellationSignal);
            continue;
          }
        }
        catch (OperationCanceledException localOperationCanceledException)
        {
          b.i("VFS.FileSystemManager", "Maintenance cancelled.");
          if ((??? == null) || (!???.isHeld())) {
            break;
          }
          ???.release();
          break;
          bool = false;
          break label222;
          localObject1 = finally;
          AppMethodBeat.o(54532);
          throw localObject1;
          localFile.createNewFile();
          localFile.setLastModified(System.currentTimeMillis());
          b.i("VFS.FileSystemManager", "Maintenance finished.");
          if ((??? == null) || (!???.isHeld())) {
            break;
          }
          ???.release();
          break;
        }
        catch (Exception localException)
        {
          b.b("VFS.FileSystemManager", localException, "Maintenance failed.");
          if ((??? == null) || (!???.isHeld())) {
            break;
          }
          ???.release();
          break;
        }
        finally
        {
          if ((??? != null) && (???.isHeld())) {
            ???.release();
          }
          AppMethodBeat.o(54532);
        }
        ??? = null;
      }
    }
  }
  
  public final class MaintenanceBroadcastReceiver
    extends BroadcastReceiver
  {
    private CancellationSignal APY;
    public boolean kkm;
    public boolean kkn;
    
    private MaintenanceBroadcastReceiver() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(54514);
      paramContext = paramIntent.getAction();
      if (paramContext == null)
      {
        AppMethodBeat.o(54514);
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
        b.d("VFS.FileSystemManager", "Idle status changed: charging = " + this.kkm + ", interactive = " + this.kkn);
        if ((!this.kkm) || (this.kkn) || (this.APY != null)) {
          break label337;
        }
        long l = FileSystemManager.a(FileSystemManager.this);
        if (l < 0L) {
          break label388;
        }
        this.APY = new CancellationSignal();
        FileSystemManager.b(FileSystemManager.this).sendMessageDelayed(Message.obtain(FileSystemManager.b(FileSystemManager.this), 2, this.APY), l);
        b.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
        AppMethodBeat.o(54514);
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
        this.kkn = true;
        continue;
        this.kkn = false;
        continue;
        this.kkm = true;
        continue;
        this.kkm = false;
      }
      label337:
      if (((!this.kkm) || (this.kkn)) && (this.APY != null))
      {
        FileSystemManager.b(FileSystemManager.this).removeMessages(2);
        this.APY.cancel();
        this.APY = null;
        b.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
      }
      label388:
      AppMethodBeat.o(54514);
    }
  }
  
  public final class a
  {
    public final TreeMap<String, String> APA;
    public final HashMap<String, String> APC;
    public FileSystem APW;
    public boolean APX;
    public final HashMap<String, FileSystem> APz;
    
    public a()
    {
      AppMethodBeat.i(54508);
      this.APz = new HashMap();
      this.APA = new TreeMap();
      this.APC = new HashMap();
      this.APW = null;
      this.APX = false;
      AppMethodBeat.o(54508);
    }
    
    public final a a(String paramString, FileSystem paramFileSystem)
    {
      AppMethodBeat.i(54509);
      this.APz.put(paramString, paramFileSystem);
      AppMethodBeat.o(54509);
      return this;
    }
    
    public final void commit()
    {
      AppMethodBeat.i(54512);
      rM(FileSystemManager.d(FileSystemManager.this));
      AppMethodBeat.o(54512);
    }
    
    public final a iD(String paramString1, String paramString2)
    {
      AppMethodBeat.i(54510);
      this.APA.put(paramString1, paramString2);
      AppMethodBeat.o(54510);
      return this;
    }
    
    public final a iE(String paramString1, String paramString2)
    {
      AppMethodBeat.i(54511);
      this.APC.put(paramString1, paramString2);
      AppMethodBeat.o(54511);
      return this;
    }
    
    public final void rM(boolean paramBoolean)
    {
      AppMethodBeat.i(54513);
      FileSystemManager.a(FileSystemManager.this, this.APz, this.APA, this.APC, this.APW, this.APX, paramBoolean);
      this.APz.clear();
      this.APA.clear();
      this.APC.clear();
      this.APX = false;
      AppMethodBeat.o(54513);
    }
  }
  
  public static abstract interface b
  {
    public abstract Key e(String paramString, Map<String, String> paramMap);
  }
  
  static final class c
    implements Comparable<String>
  {
    final String APZ;
    final String AQa;
    final FileSystem AQb;
    final boolean AQc;
    
    c(String paramString1, String paramString2, FileSystem paramFileSystem, boolean paramBoolean)
    {
      this.APZ = paramString1;
      this.AQa = paramString2;
      this.AQb = paramFileSystem;
      this.AQc = paramBoolean;
    }
  }
  
  public static final class d
  {
    public final FileSystem AQb;
    final int aIT;
    public final String path;
    
    private d(FileSystem paramFileSystem, String paramString, int paramInt)
    {
      this.AQb = paramFileSystem;
      this.path = paramString;
      this.aIT = paramInt;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(54516);
      String str = this.path + " -> " + this.AQb.toString();
      AppMethodBeat.o(54516);
      return str;
    }
    
    public final boolean valid()
    {
      return this.AQb != null;
    }
  }
  
  static final class e
  {
    @SuppressLint({"StaticFieldLeak"})
    static final FileSystemManager AQd;
    
    static
    {
      AppMethodBeat.i(54517);
      FileSystemManager localFileSystemManager = new FileSystemManager((byte)0);
      AQd = localFileSystemManager;
      FileSystemManager.c(localFileSystemManager);
      AppMethodBeat.o(54517);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager
 * JD-Core Version:    0.7.0.1
 */