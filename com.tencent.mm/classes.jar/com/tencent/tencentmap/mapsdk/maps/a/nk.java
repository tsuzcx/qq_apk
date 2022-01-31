package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

public class nk
{
  private static ConcurrentHashMap<String, b[]> a;
  private static volatile nk b;
  private ReentrantReadWriteLock c;
  private String d;
  private String e;
  private boolean f;
  private AtomicInteger g;
  
  static
  {
    AppMethodBeat.i(149491);
    a = new ConcurrentHashMap();
    AppMethodBeat.o(149491);
  }
  
  private nk()
  {
    AppMethodBeat.i(149481);
    this.c = new ReentrantReadWriteLock();
    this.d = null;
    this.e = null;
    this.f = false;
    this.g = new AtomicInteger(0);
    AppMethodBeat.o(149481);
  }
  
  public static nk a()
  {
    AppMethodBeat.i(149482);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new nk();
      }
      nk localnk = b;
      AppMethodBeat.o(149482);
      return localnk;
    }
    finally
    {
      AppMethodBeat.o(149482);
    }
  }
  
  public static boolean a(b paramb, b[] paramArrayOfb)
  {
    AppMethodBeat.i(149489);
    if ((paramArrayOfb == null) || (paramArrayOfb.length < 3))
    {
      AppMethodBeat.o(149489);
      return false;
    }
    int j = paramArrayOfb.length - 1;
    int i = 0;
    int k = 0;
    if (i < paramArrayOfb.length)
    {
      int m;
      if ((paramArrayOfb[i].a() >= paramb.a()) || (paramArrayOfb[j].a() < paramb.a()))
      {
        m = k;
        if (paramArrayOfb[j].a() < paramb.a())
        {
          m = k;
          if (paramArrayOfb[i].a() < paramb.a()) {}
        }
      }
      else if (paramArrayOfb[i].b() > paramb.b())
      {
        m = k;
        if (paramArrayOfb[j].b() > paramb.b()) {}
      }
      else
      {
        if (paramArrayOfb[i].b() + (paramb.a() - paramArrayOfb[i].a()) / (paramArrayOfb[j].a() - paramArrayOfb[i].a()) * (paramArrayOfb[j].b() - paramArrayOfb[i].b()) >= paramb.b()) {
          break label209;
        }
      }
      label209:
      for (j = 1;; j = 0)
      {
        m = k ^ j;
        j = i;
        i += 1;
        k = m;
        break;
      }
    }
    AppMethodBeat.o(149489);
    return k;
  }
  
  public static boolean a(b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    AppMethodBeat.i(149490);
    int m = paramArrayOfb1.length;
    int i = 0;
    int j = 0;
    if (i < m)
    {
      j |= a(paramArrayOfb1[i], paramArrayOfb2);
      if (j == 0) {}
    }
    for (i = 1;; i = 0)
    {
      int n = paramArrayOfb2.length;
      j = 0;
      m = 0;
      boolean bool = false;
      for (;;)
      {
        if (j < n)
        {
          bool |= a(paramArrayOfb2[j], paramArrayOfb1);
          if (bool) {
            m = 1;
          }
          int k;
          j += 1;
          continue;
          i += 1;
          break;
        }
      }
      if ((i != 0) || (m != 0))
      {
        AppMethodBeat.o(149490);
        return true;
      }
      AppMethodBeat.o(149490);
      return false;
    }
  }
  
  private static b[] d(String paramString)
  {
    AppMethodBeat.i(149487);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(149487);
      return null;
    }
    paramString = paramString.split(":");
    if (paramString.length == 0)
    {
      AppMethodBeat.o(149487);
      return null;
    }
    b[] arrayOfb = new b[paramString.length];
    int i = 0;
    while (i < paramString.length)
    {
      String[] arrayOfString = paramString[i].split(",");
      arrayOfb[i] = hn.a(new GeoPoint((int)(Double.parseDouble(arrayOfString[1]) * 1000000.0D), (int)(Double.parseDouble(arrayOfString[0]) * 1000000.0D)));
      i += 1;
    }
    AppMethodBeat.o(149487);
    return arrayOfb;
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(149483);
    if ((paramContext != null) && (!this.f))
    {
      this.d = (paramContext.getFilesDir() + "/frontiers.dat");
      this.e = (this.d + ".bak");
      this.f = true;
    }
    if (this.g.getAndIncrement() <= 0)
    {
      paramContext = b();
      if (paramContext == null)
      {
        paramContext = d("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.959229,21.677848:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
        a.put("china", paramContext);
        paramContext = d("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
        a.put("inland", paramContext);
        paramContext = d("121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:121.959229,21.677848");
        a.put("taiwan", paramContext);
        AppMethodBeat.o(149483);
        return;
      }
      b(paramContext);
    }
    AppMethodBeat.o(149483);
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: ldc 165
    //   8: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: getfield 45	com/tencent/tencentmap/mapsdk/maps/a/nk:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   15: invokevirtual 169	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   18: invokevirtual 174	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   21: new 176	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: getfield 47	com/tencent/tencentmap/mapsdk/maps/a/nk:d	Ljava/lang/String;
    //   29: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore 6
    //   34: new 176	java/io/File
    //   37: dup
    //   38: aload_0
    //   39: getfield 49	com/tencent/tencentmap/mapsdk/maps/a/nk:e	Ljava/lang/String;
    //   42: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 7
    //   47: aload 7
    //   49: invokevirtual 183	java/io/File:exists	()Z
    //   52: ifeq +23 -> 75
    //   55: aload 7
    //   57: invokevirtual 186	java/io/File:delete	()Z
    //   60: ifne +15 -> 75
    //   63: aload 7
    //   65: invokevirtual 189	java/io/File:deleteOnExit	()V
    //   68: ldc 165
    //   70: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_0
    //   74: ireturn
    //   75: aload 6
    //   77: invokevirtual 183	java/io/File:exists	()Z
    //   80: ifeq +44 -> 124
    //   83: aload 6
    //   85: aload 7
    //   87: invokevirtual 193	java/io/File:renameTo	(Ljava/io/File;)Z
    //   90: istore_2
    //   91: iload_2
    //   92: ifne +32 -> 124
    //   95: aconst_null
    //   96: invokestatic 198	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   99: aload 7
    //   101: aload 6
    //   103: invokevirtual 193	java/io/File:renameTo	(Ljava/io/File;)Z
    //   106: pop
    //   107: aload_0
    //   108: getfield 45	com/tencent/tencentmap/mapsdk/maps/a/nk:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   111: invokevirtual 169	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   114: invokevirtual 201	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   117: ldc 165
    //   119: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_0
    //   123: ireturn
    //   124: new 203	java/io/FileOutputStream
    //   127: dup
    //   128: aload 6
    //   130: invokespecial 206	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   133: astore_3
    //   134: aload_3
    //   135: aload_1
    //   136: ldc 208
    //   138: invokevirtual 212	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   141: invokevirtual 216	java/io/FileOutputStream:write	([B)V
    //   144: aload_3
    //   145: invokevirtual 219	java/io/FileOutputStream:flush	()V
    //   148: aload_3
    //   149: invokestatic 198	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   152: aload 7
    //   154: invokevirtual 186	java/io/File:delete	()Z
    //   157: pop
    //   158: aload_0
    //   159: getfield 45	com/tencent/tencentmap/mapsdk/maps/a/nk:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   162: invokevirtual 169	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   165: invokevirtual 201	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   168: ldc 165
    //   170: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iconst_1
    //   174: ireturn
    //   175: astore_1
    //   176: aload 4
    //   178: astore_1
    //   179: aload_1
    //   180: invokestatic 198	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   183: aload 7
    //   185: aload 6
    //   187: invokevirtual 193	java/io/File:renameTo	(Ljava/io/File;)Z
    //   190: pop
    //   191: aload_0
    //   192: getfield 45	com/tencent/tencentmap/mapsdk/maps/a/nk:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   195: invokevirtual 169	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   198: invokevirtual 201	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   201: ldc 165
    //   203: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: iconst_0
    //   207: ireturn
    //   208: astore_1
    //   209: aload 5
    //   211: astore_3
    //   212: aload_3
    //   213: invokestatic 198	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   216: aload 7
    //   218: aload 6
    //   220: invokevirtual 193	java/io/File:renameTo	(Ljava/io/File;)Z
    //   223: pop
    //   224: aload_0
    //   225: getfield 45	com/tencent/tencentmap/mapsdk/maps/a/nk:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   228: invokevirtual 169	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   231: invokevirtual 201	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   234: ldc 165
    //   236: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_1
    //   240: athrow
    //   241: astore_1
    //   242: goto -30 -> 212
    //   245: astore_1
    //   246: aload_3
    //   247: astore_1
    //   248: goto -69 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	nk
    //   0	251	1	paramString	String
    //   90	2	2	bool	boolean
    //   133	114	3	localObject1	Object
    //   4	173	4	localObject2	Object
    //   1	209	5	localObject3	Object
    //   32	187	6	localFile1	java.io.File
    //   45	172	7	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   75	91	175	java/lang/Throwable
    //   124	134	175	java/lang/Throwable
    //   75	91	208	finally
    //   124	134	208	finally
    //   134	148	241	finally
    //   134	148	245	java/lang/Throwable
  }
  
  public int b(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(149486);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(149486);
      return 0;
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        int j = 0;
        i = j;
        try
        {
          if (!localIterator.hasNext()) {
            continue;
          }
          String str = (String)localIterator.next();
          if ("version".equals(str))
          {
            j = paramString.optInt(str);
            continue;
          }
          b[] arrayOfb = d(paramString.optString(str));
          j = i;
          if (arrayOfb == null) {
            continue;
          }
          a.put(str, arrayOfb);
          j = i;
        }
        catch (Throwable paramString) {}
      }
      catch (Throwable paramString)
      {
        continue;
      }
      AppMethodBeat.o(149486);
      return i;
      if (!a.containsKey("china"))
      {
        paramString = d("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.959229,21.677848:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
        if (paramString != null) {
          a.put("china", paramString);
        }
      }
      if (!a.containsKey("inland"))
      {
        paramString = d("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
        if (paramString != null) {
          a.put("inland", paramString);
        }
      }
      if (!a.containsKey("taiwan"))
      {
        paramString = d("121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:121.959229,21.677848");
        if (paramString != null) {
          a.put("taiwan", paramString);
        }
      }
    }
  }
  
  /* Error */
  public String b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 253
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 45	com/tencent/tencentmap/mapsdk/maps/a/nk:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   11: invokevirtual 257	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   14: invokevirtual 260	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   17: new 262	java/io/FileInputStream
    //   20: dup
    //   21: new 176	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: getfield 47	com/tencent/tencentmap/mapsdk/maps/a/nk:d	Ljava/lang/String;
    //   29: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 263	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: astore_1
    //   36: new 79	java/lang/String
    //   39: dup
    //   40: aload_1
    //   41: invokestatic 266	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/InputStream;)[B
    //   44: ldc 208
    //   46: invokespecial 269	java/lang/String:<init>	([BLjava/lang/String;)V
    //   49: astore_2
    //   50: aload_1
    //   51: invokestatic 198	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   54: aload_0
    //   55: getfield 45	com/tencent/tencentmap/mapsdk/maps/a/nk:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   58: invokevirtual 257	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   61: invokevirtual 270	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   64: ldc 253
    //   66: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_2
    //   70: areturn
    //   71: astore_1
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: invokestatic 198	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   78: aload_0
    //   79: getfield 45	com/tencent/tencentmap/mapsdk/maps/a/nk:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   82: invokevirtual 257	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   85: invokevirtual 270	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   88: ldc 253
    //   90: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_1
    //   96: aload_2
    //   97: invokestatic 198	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   100: aload_0
    //   101: getfield 45	com/tencent/tencentmap/mapsdk/maps/a/nk:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   104: invokevirtual 257	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   107: invokevirtual 270	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   110: ldc 253
    //   112: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: athrow
    //   117: astore_3
    //   118: aload_1
    //   119: astore_2
    //   120: aload_3
    //   121: astore_1
    //   122: goto -26 -> 96
    //   125: astore_2
    //   126: goto -52 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	nk
    //   35	16	1	localFileInputStream	java.io.FileInputStream
    //   71	1	1	localThrowable1	Throwable
    //   73	2	1	localCloseable	java.io.Closeable
    //   95	24	1	localObject1	Object
    //   121	1	1	localObject2	Object
    //   1	119	2	localObject3	Object
    //   125	1	2	localThrowable2	Throwable
    //   117	4	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	36	71	java/lang/Throwable
    //   17	36	95	finally
    //   36	50	117	finally
    //   36	50	125	java/lang/Throwable
  }
  
  public b[] c(String paramString)
  {
    AppMethodBeat.i(149488);
    paramString = (b[])a.get(paramString);
    AppMethodBeat.o(149488);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nk
 * JD-Core Version:    0.7.0.1
 */