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
import com.tencent.e.a.b;
import java.io.File;
import java.io.IOException;
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
  @SuppressLint({"StaticFieldLeak"})
  public static volatile Context sContext = null;
  private static volatile b xvO = null;
  private static volatile boolean xvP = true;
  private final Object mLock = new Object();
  private HashMap<String, FileSystem> wuB;
  private TreeMap<String, String> wuC;
  private HashMap<String, String> wuE;
  private ArrayList<c> xvQ;
  private FileSystem xvR;
  private int xvS;
  private d xvT;
  final HashMap<String, String> xvU = new HashMap();
  private final FileSystem xvV;
  private final FileSystem xvW;
  private final File xvX;
  final HandlerThread xvY;
  public final MaintenanceBroadcastReceiver xvZ;
  private final Handler xwa;
  public volatile long xwb;
  public volatile long xwc;
  public volatile boolean xwd;
  public volatile boolean xwe;
  private volatile BroadcastReceiver xwf;
  
  private FileSystemManager()
  {
    Context localContext = sContext;
    if (localContext == null) {
      throw new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
    }
    this.xvX = new File(localContext.getCacheDir(), ".vfs");
    this.xvY = new HandlerThread("VFS.Maintenance", 4);
    this.xvY.start();
    this.xwa = new Handler(this.xvY.getLooper(), this);
    this.xvZ = new MaintenanceBroadcastReceiver((byte)0);
    this.xwb = -1L;
    this.xwc = 9223372036854775807L;
    this.xwe = true;
    this.xvV = new RawFileSystem("", (byte)0);
    this.xvW = new AssetsFileSystem(localContext);
    this.xvS = 0;
    this.wuB = new HashMap();
    this.wuC = new TreeMap();
    this.xvQ = new ArrayList();
    this.wuE = new HashMap();
    this.xvR = this.xvV;
    this.xvT = new d(null, null, this.xvS, (byte)0);
    hk(localContext);
  }
  
  private static String PM(String paramString)
  {
    paramString = new File(paramString);
    try
    {
      String str = paramString.getCanonicalPath();
      return str;
    }
    catch (IOException localIOException) {}
    return paramString.getAbsolutePath();
  }
  
  static String a(d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramd.wva.Qd();
    if ((paramBoolean2) && ((i & 0x4) == 0)) {}
    while ((!paramBoolean2) && ((i & 0x2) == 0)) {
      return null;
    }
    return paramd.wva.L(paramd.path, paramBoolean1);
  }
  
  private static ArrayList<c> a(HashMap<String, FileSystem> paramHashMap, TreeMap<String, String> paramTreeMap, Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramTreeMap.size());
    Iterator localIterator = paramTreeMap.entrySet().iterator();
    paramTreeMap = null;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      FileSystem localFileSystem = (FileSystem)paramHashMap.get(localObject);
      if (localFileSystem == null) {
        throw new IllegalArgumentException("FileSystem '" + (String)localObject + "' for mount point '" + str + "' not exist.");
      }
      str = j.y(str, paramMap);
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
    return localArrayList;
  }
  
  public static void a(b paramb)
  {
    xvO = paramb;
  }
  
  /* Error */
  private void a(HashMap<String, FileSystem> paramHashMap, TreeMap<String, String> paramTreeMap, HashMap<String, String> paramHashMap1, FileSystem paramFileSystem)
  {
    // Byte code:
    //   0: new 378	android/os/Bundle
    //   3: dup
    //   4: invokespecial 379	android/os/Bundle:<init>	()V
    //   7: astore 5
    //   9: new 378	android/os/Bundle
    //   12: dup
    //   13: invokespecial 379	android/os/Bundle:<init>	()V
    //   16: astore 6
    //   18: aload_1
    //   19: invokevirtual 380	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   22: invokeinterface 243 1 0
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 249 1 0
    //   34: ifeq +42 -> 76
    //   37: aload_1
    //   38: invokeinterface 253 1 0
    //   43: checkcast 255	java/util/Map$Entry
    //   46: astore 7
    //   48: aload 6
    //   50: aload 7
    //   52: invokeinterface 258 1 0
    //   57: checkcast 260	java/lang/String
    //   60: aload 7
    //   62: invokeinterface 263 1 0
    //   67: checkcast 382	android/os/Parcelable
    //   70: invokevirtual 386	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   73: goto -45 -> 28
    //   76: aload 5
    //   78: ldc_w 388
    //   81: aload 6
    //   83: invokevirtual 392	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   86: new 378	android/os/Bundle
    //   89: dup
    //   90: invokespecial 379	android/os/Bundle:<init>	()V
    //   93: astore_1
    //   94: aload_2
    //   95: invokevirtual 237	java/util/TreeMap:entrySet	()Ljava/util/Set;
    //   98: invokeinterface 243 1 0
    //   103: astore_2
    //   104: aload_2
    //   105: invokeinterface 249 1 0
    //   110: ifeq +41 -> 151
    //   113: aload_2
    //   114: invokeinterface 253 1 0
    //   119: checkcast 255	java/util/Map$Entry
    //   122: astore 6
    //   124: aload_1
    //   125: aload 6
    //   127: invokeinterface 258 1 0
    //   132: checkcast 260	java/lang/String
    //   135: aload 6
    //   137: invokeinterface 263 1 0
    //   142: checkcast 260	java/lang/String
    //   145: invokevirtual 395	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -44 -> 104
    //   151: aload 5
    //   153: ldc_w 397
    //   156: aload_1
    //   157: invokevirtual 392	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   160: new 378	android/os/Bundle
    //   163: dup
    //   164: invokespecial 379	android/os/Bundle:<init>	()V
    //   167: astore_1
    //   168: aload_3
    //   169: invokevirtual 380	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   172: invokeinterface 243 1 0
    //   177: astore_2
    //   178: aload_2
    //   179: invokeinterface 249 1 0
    //   184: ifeq +38 -> 222
    //   187: aload_2
    //   188: invokeinterface 253 1 0
    //   193: checkcast 255	java/util/Map$Entry
    //   196: astore_3
    //   197: aload_1
    //   198: aload_3
    //   199: invokeinterface 258 1 0
    //   204: checkcast 260	java/lang/String
    //   207: aload_3
    //   208: invokeinterface 263 1 0
    //   213: checkcast 260	java/lang/String
    //   216: invokevirtual 395	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: goto -41 -> 178
    //   222: aload 5
    //   224: ldc_w 399
    //   227: aload_1
    //   228: invokevirtual 392	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   231: aload 5
    //   233: ldc_w 401
    //   236: aload 4
    //   238: invokevirtual 386	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   241: invokestatic 407	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   244: astore_1
    //   245: aload_1
    //   246: aload 5
    //   248: invokevirtual 411	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   251: aload_1
    //   252: invokevirtual 415	android/os/Parcel:marshall	()[B
    //   255: astore_3
    //   256: aload_1
    //   257: invokevirtual 418	android/os/Parcel:recycle	()V
    //   260: new 420	java/io/DataOutputStream
    //   263: dup
    //   264: new 422	java/io/FileOutputStream
    //   267: dup
    //   268: new 100	java/io/File
    //   271: dup
    //   272: aload_0
    //   273: getfield 113	com/tencent/mm/vfs/FileSystemManager:xvX	Ljava/io/File;
    //   276: ldc_w 424
    //   279: invokespecial 111	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   282: invokespecial 427	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   285: invokespecial 430	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   288: astore_2
    //   289: aload_2
    //   290: astore_1
    //   291: aload_2
    //   292: iconst_1
    //   293: invokevirtual 433	java/io/DataOutputStream:writeInt	(I)V
    //   296: aload_2
    //   297: astore_1
    //   298: aload_2
    //   299: aload_3
    //   300: invokevirtual 437	java/io/DataOutputStream:write	([B)V
    //   303: aload_2
    //   304: invokevirtual 440	java/io/DataOutputStream:close	()V
    //   307: getstatic 76	com/tencent/mm/vfs/FileSystemManager:sContext	Landroid/content/Context;
    //   310: astore_1
    //   311: aload_1
    //   312: invokevirtual 443	android/content/Context:getPackageName	()Ljava/lang/String;
    //   315: astore_2
    //   316: new 445	android/content/Intent
    //   319: dup
    //   320: new 271	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   327: aload_2
    //   328: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: ldc_w 447
    //   334: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokespecial 448	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   343: astore_2
    //   344: aload_2
    //   345: aload 5
    //   347: invokevirtual 452	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   350: pop
    //   351: aload_2
    //   352: ldc_w 454
    //   355: invokestatic 459	android/os/Process:myPid	()I
    //   358: invokevirtual 463	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   361: pop
    //   362: aload_1
    //   363: aload_2
    //   364: invokevirtual 467	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   367: ldc_w 333
    //   370: ldc_w 469
    //   373: invokestatic 341	com/tencent/e/a/b:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: return
    //   377: astore_3
    //   378: aconst_null
    //   379: astore_2
    //   380: aload_2
    //   381: astore_1
    //   382: ldc_w 333
    //   385: new 271	java/lang/StringBuilder
    //   388: dup
    //   389: ldc_w 471
    //   392: invokespecial 274	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   395: aload_3
    //   396: invokevirtual 474	java/io/IOException:getMessage	()Ljava/lang/String;
    //   399: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 476	com/tencent/e/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload_2
    //   409: ifnull -102 -> 307
    //   412: aload_2
    //   413: invokevirtual 440	java/io/DataOutputStream:close	()V
    //   416: goto -109 -> 307
    //   419: astore_1
    //   420: goto -113 -> 307
    //   423: astore_2
    //   424: aconst_null
    //   425: astore_1
    //   426: aload_1
    //   427: ifnull +7 -> 434
    //   430: aload_1
    //   431: invokevirtual 440	java/io/DataOutputStream:close	()V
    //   434: aload_2
    //   435: athrow
    //   436: astore_1
    //   437: goto -130 -> 307
    //   440: astore_1
    //   441: goto -7 -> 434
    //   444: astore_2
    //   445: goto -19 -> 426
    //   448: astore_3
    //   449: goto -69 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	FileSystemManager
    //   0	452	1	paramHashMap	HashMap<String, FileSystem>
    //   0	452	2	paramTreeMap	TreeMap<String, String>
    //   0	452	3	paramHashMap1	HashMap<String, String>
    //   0	452	4	paramFileSystem	FileSystem
    //   7	339	5	localBundle	Bundle
    //   16	120	6	localObject	Object
    //   46	15	7	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   260	289	377	java/io/IOException
    //   412	416	419	java/io/IOException
    //   260	289	423	finally
    //   303	307	436	java/io/IOException
    //   430	434	440	java/io/IOException
    //   291	296	444	finally
    //   298	303	444	finally
    //   382	408	444	finally
    //   291	296	448	java/io/IOException
    //   298	303	448	java/io/IOException
  }
  
  private static <K, V> void a(Map<K, V> paramMap, StringBuilder paramStringBuilder)
  {
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
  }
  
  private void as(Bundle arg1)
  {
    Bundle localBundle = ???;
    if (??? == null) {
      localBundle = new Bundle();
    }
    if (localBundle.getInt("pid") == Process.myPid()) {}
    HashMap localHashMap;
    synchronized (this.mLock)
    {
      if (this.xvR != null) {
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
      ??? = this.xvV;
    }
    for (;;)
    {
      ??? = new HashMap(this.xvU);
      ((Map)???).putAll((Map)localObject4);
      localObject5 = a(localHashMap, (TreeMap)localObject3, (Map)???);
      localObject6 = Collections.unmodifiableMap((Map)???);
      synchronized (this.mLock)
      {
        this.wuB = localHashMap;
        this.wuC = ((TreeMap)localObject3);
        this.xvQ = ((ArrayList)localObject5);
        this.wuE = ((HashMap)localObject4);
        this.xvR = ???;
        this.xvS += 1;
        this.xvT = new d(null, null, this.xvS, (byte)0);
        this.xvR.m((Map)localObject6);
        localObject5 = localHashMap.values().iterator();
        if (((Iterator)localObject5).hasNext()) {
          ((FileSystem)((Iterator)localObject5).next()).m((Map)localObject6);
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
      return;
    }
  }
  
  public static FileSystemManager cVw()
  {
    return e.wvd;
  }
  
  static b cVx()
  {
    return xvO;
  }
  
  private static <K, V> void d(Map<K, V> paramMap1, Map<K, V> paramMap2)
  {
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
  }
  
  private void hk(Context paramContext)
  {
    this.xvU.put("data", paramContext.getCacheDir().getParent());
    this.xvU.put("dataCache", paramContext.getCacheDir().getPath());
    try
    {
      paramContext = paramContext.getExternalCacheDir();
      if (paramContext != null)
      {
        this.xvU.put("extData", paramContext.getParent());
        this.xvU.put("extCache", paramContext.getPath());
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        b.b("VFS.FileSystemManager", paramContext, "Cannot get external cache directory.");
      }
    }
    paramContext = Environment.getExternalStorageDirectory();
    if (paramContext != null) {
      this.xvU.put("storage", paramContext.getPath());
    }
    b.i("VFS.FileSystemManager", "Static environment:");
    paramContext = this.xvU.entrySet().iterator();
    while (paramContext.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramContext.next();
      b.i("VFS.FileSystemManager", "  " + (String)localEntry.getKey() + " => " + (String)localEntry.getValue());
    }
  }
  
  public static void oA(boolean paramBoolean)
  {
    xvP = paramBoolean;
  }
  
  public static void setContext(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {}
    for (;;)
    {
      sContext = paramContext;
      return;
      paramContext = localContext;
    }
  }
  
  final d a(Uri paramUri, d paramd)
  {
    Object localObject = this.mLock;
    if (paramd != null) {}
    HashMap localHashMap;
    d locald;
    String str;
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        if (paramd.wvc == this.xvS) {
          return paramd;
        }
        localHashMap = this.wuB;
        localArrayList = this.xvQ;
        paramd = this.xvR;
        int j = this.xvS;
        locald = this.xvT;
        localObject = paramUri.getPath();
        str = paramUri.getScheme();
        if ((str != null) && (!str.equals("file"))) {
          break;
        }
        if ((localObject == null) || (((String)localObject).isEmpty())) {
          break label400;
        }
        localObject = PM((String)localObject);
        i = Collections.binarySearch(localArrayList, localObject);
        if (i >= 0)
        {
          paramd = ((c)localArrayList.get(i)).wva;
          paramUri = "";
          return new d(paramd, paramUri, j, (byte)0);
        }
      }
      finally {}
      int i = -i - 2;
      if (i >= 0) {
        paramUri = (c)localArrayList.get(i);
      }
      while ((paramUri != null) && ((!((String)localObject).startsWith(paramUri.wuY)) || (((String)localObject).charAt(paramUri.wuY.length()) != '/'))) {
        if (paramUri.wvb)
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
      if (paramUri != null)
      {
        paramd = paramUri.wva;
        paramUri = ((String)localObject).substring(paramUri.wuY.length() + 1);
      }
      else
      {
        if ((((String)localObject).isEmpty()) || (((String)localObject).charAt(0) != '/')) {
          break label394;
        }
      }
    }
    label394:
    for (paramUri = ((String)localObject).substring(1);; paramUri = (Uri)localObject)
    {
      break;
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
        localObject = j.h((String)localObject, true, true);
        paramd = paramUri;
        paramUri = (Uri)localObject;
        break;
      }
      if (!str.equals("assets")) {
        break label400;
      }
      paramd = this.xvW;
      if (localObject == null)
      {
        paramUri = "";
        break;
      }
      paramUri = j.h((String)localObject, true, true);
      break;
    }
    label400:
    return locald;
  }
  
  public final a cVy()
  {
    return new a();
  }
  
  public final void cVz()
  {
    synchronized (this.mLock)
    {
      HashMap localHashMap1 = this.wuB;
      TreeMap localTreeMap = this.wuC;
      HashMap localHashMap2 = this.wuE;
      FileSystem localFileSystem = this.xvR;
      a(localHashMap1, localTreeMap, localHashMap2, localFileSystem);
      return;
    }
  }
  
  public final boolean handleMessage(Message arg1)
  {
    boolean bool3 = false;
    boolean bool2 = true;
    switch (???.what)
    {
    default: 
      bool1 = false;
      return bool1;
    case 1: 
      ??? = (Intent)???.obj;
      ???.setExtrasClassLoader(FileSystem.class.getClassLoader());
      b.i("VFS.FileSystemManager", "Refresh file system from broadcast.");
      as(???.getExtras());
      return true;
    }
    CancellationSignal localCancellationSignal = (CancellationSignal)???.obj;
    long l1 = this.xwc;
    File localFile = new File(this.xvX, "maintain.timestamp");
    long l2 = System.currentTimeMillis();
    long l3 = localFile.lastModified();
    if (l2 - l3 < l1)
    {
      b.i("VFS.FileSystemManager", "Maintenance interval not match, skip maintenance. ct=%d, ts=%d, int=%d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
      return true;
    }
    Object localObject4 = sContext;
    boolean bool4 = this.xwd;
    boolean bool1 = bool4;
    if (bool4)
    {
      bool1 = bool3;
      if (((Context)localObject4).checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool1 = true;
      }
    }
    Object localObject3;
    synchronized (this.mLock)
    {
      localObject3 = this.wuB;
      if (bool1) {
        ??? = ((PowerManager)((Context)localObject4).getSystemService("power")).newWakeLock(1, "VFS.Maintenance");
      }
    }
    for (;;)
    {
      try
      {
        b.i("VFS.FileSystemManager", "Maintenance started. WakeLock: " + bool1);
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
        bool1 = bool2;
        if (??? == null) {
          break;
        }
        bool1 = bool2;
        if (!???.isHeld()) {
          break;
        }
        ???.release();
        return true;
        localObject1 = finally;
        throw localObject1;
        localFile.createNewFile();
        localFile.setLastModified(System.currentTimeMillis());
        b.i("VFS.FileSystemManager", "Maintenance finished.");
        bool1 = bool2;
        if (??? == null) {
          break;
        }
        bool1 = bool2;
        if (!???.isHeld()) {
          break;
        }
        ???.release();
        return true;
      }
      catch (Exception localException)
      {
        b.b("VFS.FileSystemManager", localException, "Maintenance failed.");
        bool1 = bool2;
        if (??? == null) {
          break;
        }
        bool1 = bool2;
        if (!???.isHeld()) {
          break;
        }
        ???.release();
        return true;
      }
      finally
      {
        if ((??? != null) && (???.isHeld())) {
          ???.release();
        }
      }
      ??? = null;
    }
  }
  
  private final class MaintenanceBroadcastReceiver
    extends BroadcastReceiver
  {
    public boolean ijm;
    public boolean ijn;
    private CancellationSignal wuX;
    
    private MaintenanceBroadcastReceiver() {}
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext == null) {}
      label60:
      label324:
      do
      {
        return;
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
          b.d("VFS.FileSystemManager", "Idle status changed: charging = " + this.ijm + ", interactive = " + this.ijn);
          if ((!this.ijm) || (this.ijn) || (this.wuX != null)) {
            break label324;
          }
          long l = FileSystemManager.a(FileSystemManager.this);
          if (l < 0L) {
            break;
          }
          this.wuX = new CancellationSignal();
          FileSystemManager.b(FileSystemManager.this).sendMessageDelayed(Message.obtain(FileSystemManager.b(FileSystemManager.this), 2, this.wuX), l);
          b.i("VFS.FileSystemManager", "System idle, trigger maintenance timer for " + l / 1000L + " seconds.");
          return;
          if (!paramContext.equals("android.intent.action.SCREEN_ON")) {
            break label60;
          }
          i = 0;
          break label60;
          if (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
            break label60;
          }
          i = 1;
          break label60;
          if (!paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
            break label60;
          }
          i = 2;
          break label60;
          if (!paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
            break label60;
          }
          i = 3;
          break label60;
          this.ijn = true;
          continue;
          this.ijn = false;
          continue;
          this.ijm = true;
          continue;
          this.ijm = false;
        }
      } while (((this.ijm) && (!this.ijn)) || (this.wuX == null));
      FileSystemManager.b(FileSystemManager.this).removeMessages(2);
      this.wuX.cancel();
      this.wuX = null;
      b.i("VFS.FileSystemManager", "Exit idle state, maintenance cancelled.");
    }
  }
  
  public final class a
  {
    public final HashMap<String, FileSystem> wuB = new HashMap();
    public final TreeMap<String, String> wuC = new TreeMap();
    public final HashMap<String, String> wuE = new HashMap();
    public FileSystem wuV = null;
    public boolean wuW = false;
    
    public a() {}
    
    public final a a(String paramString, FileSystem paramFileSystem)
    {
      this.wuB.put(paramString, paramFileSystem);
      return this;
    }
    
    public final void commit()
    {
      oc(FileSystemManager.d(FileSystemManager.this));
    }
    
    public final a gA(String paramString1, String paramString2)
    {
      this.wuC.put(paramString1, paramString2);
      return this;
    }
    
    public final a gB(String paramString1, String paramString2)
    {
      this.wuE.put(paramString1, paramString2);
      return this;
    }
    
    public final void oc(boolean paramBoolean)
    {
      FileSystemManager.a(FileSystemManager.this, this.wuB, this.wuC, this.wuE, this.wuV, this.wuW, paramBoolean);
      this.wuB.clear();
      this.wuC.clear();
      this.wuE.clear();
      this.wuW = false;
    }
  }
  
  public static abstract interface b
  {
    public abstract Key d(String paramString, Map<String, String> paramMap);
  }
  
  private static final class c
    implements Comparable<String>
  {
    final String wuY;
    final String wuZ;
    final FileSystem wva;
    final boolean wvb;
    
    c(String paramString1, String paramString2, FileSystem paramFileSystem, boolean paramBoolean)
    {
      this.wuY = paramString1;
      this.wuZ = paramString2;
      this.wva = paramFileSystem;
      this.wvb = paramBoolean;
    }
  }
  
  public static final class d
  {
    public final String path;
    public final FileSystem wva;
    final int wvc;
    
    private d(FileSystem paramFileSystem, String paramString, int paramInt)
    {
      this.wva = paramFileSystem;
      this.path = paramString;
      this.wvc = paramInt;
    }
    
    public final String toString()
    {
      return this.path + " -> " + this.wva.toString();
    }
    
    public final boolean valid()
    {
      return this.wva != null;
    }
  }
  
  private static final class e
  {
    @SuppressLint({"StaticFieldLeak"})
    static final FileSystemManager wvd;
    
    static
    {
      FileSystemManager localFileSystemManager = new FileSystemManager((byte)0);
      wvd = localFileSystemManager;
      FileSystemManager.c(localFileSystemManager);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager
 * JD-Core Version:    0.7.0.1
 */