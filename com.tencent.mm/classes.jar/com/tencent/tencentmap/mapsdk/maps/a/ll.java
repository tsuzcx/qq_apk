package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ap;
import com.tencent.tencentmap.mapsdk.a.l;
import com.tencent.tencentmap.mapsdk.a.m;
import com.tencent.tencentmap.mapsdk.a.o;
import com.tencent.tencentmap.mapsdk.a.p;
import com.tencent.tencentmap.mapsdk.a.q;
import com.tencent.tencentmap.mapsdk.a.s;
import com.tencent.tencentmap.mapsdk.a.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ll
{
  private static volatile Map<String, List<WeakReference<ap>>> e;
  public volatile boolean a;
  private String b;
  private q c;
  private p d;
  private WeakReference<ap> f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  static
  {
    AppMethodBeat.i(149186);
    e = new HashMap();
    AppMethodBeat.o(149186);
  }
  
  public ll(Context paramContext, ap paramap, String paramString)
  {
    AppMethodBeat.i(149173);
    this.a = false;
    this.d = p.a(paramContext);
    this.b = "";
    if ((paramap != null) && (paramap.k() != null) && (paramap.k().b() != null)) {
      this.b = paramap.k().b().E();
    }
    this.f = new WeakReference(paramap);
    this.g = paramString;
    this.c = s.a(paramContext, this.g);
    AppMethodBeat.o(149173);
  }
  
  private void a(jo paramjo)
  {
    AppMethodBeat.i(149178);
    if (paramjo.d != 1)
    {
      AppMethodBeat.o(149178);
      return;
    }
    String str = paramjo.a;
    int m = -1;
    switch (str.hashCode())
    {
    default: 
      switch (m)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(149178);
      return;
      if (!str.equals("mapconfig")) {
        break;
      }
      m = 0;
      break;
      if (!str.equals("poi_icon")) {
        break;
      }
      m = 1;
      break;
      if (!str.equals("map_icon")) {
        break;
      }
      m = 2;
      break;
      if (!str.equals("rtt_config.json")) {
        break;
      }
      m = 3;
      break;
      if (!str.equals("closedroadstyle_normalmode")) {
        break;
      }
      m = 4;
      break;
      if (!str.equals("closedroadstyle_trafficmode")) {
        break;
      }
      m = 5;
      break;
      if (!str.equals("indoormap_config_premium")) {
        break;
      }
      m = 6;
      break;
      if (!str.equals("indoormap_config")) {
        break;
      }
      m = 7;
      break;
      if (!str.equals("indoorpoi_icon")) {
        break;
      }
      m = 8;
      break;
      if (!str.equals("sdk_offline_city_ver.json")) {
        break;
      }
      m = 9;
      break;
      this.c.a("mapConfigVersion", paramjo.c);
      this.c.a("mapConfigZipMd5", paramjo.f);
      AppMethodBeat.o(149178);
      return;
      this.c.a("poiIconVersion", paramjo.c);
      this.c.a("mapPoiIconZipMd5", paramjo.f);
      AppMethodBeat.o(149178);
      return;
      this.c.a("mapIconVersion", paramjo.c);
      this.c.a("mapIconZipMd5", paramjo.f);
      AppMethodBeat.o(149178);
      return;
      this.c.a("rttConfigVersion", paramjo.c);
      this.c.a("rttConfigMd5", paramjo.f);
      AppMethodBeat.o(149178);
      return;
      this.c.a("closeRoadSytleNomalModeVersion", paramjo.c);
      this.c.a("closeRoadSytleNomalModeMd5", paramjo.f);
      AppMethodBeat.o(149178);
      return;
      this.c.a("closeRoadStyleTrafficModeVersion", paramjo.c);
      this.c.a("closeRoadStyleTrafficModeMd5", paramjo.f);
      AppMethodBeat.o(149178);
      return;
      this.c.a(new String[] { "mapConfigIndoorVersion", "mapConfigIndoorMd5" });
      this.c.a("mapConfigIndoorPremiumVersion", paramjo.c);
      this.c.a("mapConfigIndoorPremiumMd5", paramjo.f);
      AppMethodBeat.o(149178);
      return;
      this.c.a(new String[] { "mapConfigIndoorPremiumVersion", "mapConfigIndoorPremiumMd5" });
      this.c.a("mapConfigIndoorVersion", paramjo.c);
      this.c.a("mapConfigIndoorMd5", paramjo.f);
      AppMethodBeat.o(149178);
      return;
      this.c.a("mapPoiIconIndoorVersion", paramjo.c);
      this.c.a("poiIconIndoorMd5", paramjo.f);
      AppMethodBeat.o(149178);
      return;
      this.c.a("offlineCityListVersion", paramjo.c);
      this.c.a("offlineCityListMd5", paramjo.f);
    }
  }
  
  /* Error */
  private void a(String paramString, WeakReference<ap> paramWeakReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 205
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 40	com/tencent/tencentmap/mapsdk/maps/a/ll:e	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 210 2 0
    //   16: ifeq +30 -> 46
    //   19: getstatic 40	com/tencent/tencentmap/mapsdk/maps/a/ll:e	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 214 2 0
    //   28: checkcast 216	java/util/List
    //   31: aload_2
    //   32: invokeinterface 219 2 0
    //   37: pop
    //   38: ldc 205
    //   40: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: new 221	java/util/ArrayList
    //   49: dup
    //   50: invokespecial 222	java/util/ArrayList:<init>	()V
    //   53: astore_3
    //   54: aload_3
    //   55: aload_2
    //   56: invokeinterface 219 2 0
    //   61: pop
    //   62: getstatic 40	com/tencent/tencentmap/mapsdk/maps/a/ll:e	Ljava/util/Map;
    //   65: aload_1
    //   66: aload_3
    //   67: invokeinterface 226 3 0
    //   72: pop
    //   73: ldc 205
    //   75: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: goto -35 -> 43
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ll
    //   0	86	1	paramString	String
    //   0	86	2	paramWeakReference	WeakReference<ap>
    //   53	14	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	43	81	finally
    //   46	78	81	finally
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(149177);
    this.c.a("mapConfigLastCheckTime", System.currentTimeMillis());
    t.c(this.j);
    t.c(this.k);
    long l = System.currentTimeMillis();
    if (!paramBoolean) {
      l = 0L;
    }
    for (;;)
    {
      Object localObject = (List)e.get(b());
      if (localObject == null)
      {
        AppMethodBeat.o(149177);
        return;
      }
      int n = ((List)localObject).size();
      localObject = (WeakReference[])((List)localObject).toArray(new WeakReference[n]);
      int m = 0;
      if (m < n)
      {
        f localf;
        nr localnr;
        if (localObject[m] != null)
        {
          ap localap = (ap)localObject[m].get();
          if ((localap != null) && (localap.k() != null) && (localap.k().b() != null))
          {
            localf = localap.k().b();
            localnr = localap.k().o();
            if (!this.a) {
              break label254;
            }
            localf.p();
            if (localap.b() != null) {
              localap.b().a(localf);
            }
            localf.a();
            localap.k().a(1);
            localap.k().a(true);
            if (localnr != null)
            {
              localnr.a(false);
              localnr.a(paramBoolean, l);
            }
          }
        }
        for (;;)
        {
          localf.k(true);
          m += 1;
          break;
          label254:
          if ((!paramBoolean) && (localnr != null)) {
            localnr.a(paramBoolean, l);
          }
        }
      }
      e.clear();
      s.c();
      AppMethodBeat.o(149177);
      return;
    }
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 302
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 83	com/tencent/tencentmap/mapsdk/maps/a/ll:f	Ljava/lang/ref/WeakReference;
    //   10: ifnull +39 -> 49
    //   13: aload_0
    //   14: getfield 83	com/tencent/tencentmap/mapsdk/maps/a/ll:f	Ljava/lang/ref/WeakReference;
    //   17: invokevirtual 261	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   20: checkcast 62	com/tencent/tencentmap/mapsdk/a/ap
    //   23: astore 7
    //   25: aload 7
    //   27: ifnull +22 -> 49
    //   30: aload 7
    //   32: invokevirtual 65	com/tencent/tencentmap/mapsdk/a/ap:k	()Lcom/tencent/tencentmap/mapsdk/maps/a/kx;
    //   35: ifnull +14 -> 49
    //   38: aload 7
    //   40: invokevirtual 65	com/tencent/tencentmap/mapsdk/a/ap:k	()Lcom/tencent/tencentmap/mapsdk/maps/a/kx;
    //   43: invokevirtual 70	com/tencent/tencentmap/mapsdk/maps/a/kx:b	()Lcom/tencent/map/lib/f;
    //   46: ifnonnull +11 -> 57
    //   49: ldc_w 302
    //   52: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: aload 7
    //   59: invokevirtual 65	com/tencent/tencentmap/mapsdk/a/ap:k	()Lcom/tencent/tencentmap/mapsdk/maps/a/kx;
    //   62: invokevirtual 70	com/tencent/tencentmap/mapsdk/maps/a/kx:b	()Lcom/tencent/map/lib/f;
    //   65: astore 8
    //   67: new 304	java/io/File
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 307	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore 7
    //   77: aload 7
    //   79: invokevirtual 311	java/io/File:exists	()Z
    //   82: ifeq +11 -> 93
    //   85: aload 7
    //   87: invokevirtual 314	java/io/File:isDirectory	()Z
    //   90: ifne +24 -> 114
    //   93: ldc_w 316
    //   96: aload_1
    //   97: invokestatic 320	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   100: invokevirtual 324	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   103: invokestatic 328	com/tencent/map/lib/d:b	(Ljava/lang/String;)V
    //   106: ldc_w 302
    //   109: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: aload 7
    //   116: invokevirtual 332	java/io/File:listFiles	()[Ljava/io/File;
    //   119: astore 9
    //   121: aload 9
    //   123: ifnonnull +11 -> 134
    //   126: ldc_w 302
    //   129: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iconst_0
    //   133: ireturn
    //   134: iconst_1
    //   135: istore 6
    //   137: aconst_null
    //   138: astore_1
    //   139: aload 9
    //   141: arraylength
    //   142: istore 4
    //   144: iconst_0
    //   145: istore_3
    //   146: iload_3
    //   147: iload 4
    //   149: if_icmpge +167 -> 316
    //   152: aload 9
    //   154: iload_3
    //   155: aaload
    //   156: astore 10
    //   158: new 334	java/io/FileInputStream
    //   161: dup
    //   162: aload 10
    //   164: invokespecial 337	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   167: astore 7
    //   169: aload 10
    //   171: invokevirtual 340	java/io/File:length	()J
    //   174: l2i
    //   175: newarray byte
    //   177: astore_1
    //   178: aload 7
    //   180: aload_1
    //   181: iconst_0
    //   182: aload_1
    //   183: arraylength
    //   184: invokevirtual 346	java/io/InputStream:read	([BII)I
    //   187: pop
    //   188: aload_2
    //   189: aload_0
    //   190: getfield 348	com/tencent/tencentmap/mapsdk/maps/a/ll:h	Ljava/lang/String;
    //   193: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifeq +42 -> 238
    //   199: aload 8
    //   201: aload 10
    //   203: invokevirtual 351	java/io/File:getName	()Ljava/lang/String;
    //   206: aload_1
    //   207: invokevirtual 354	com/tencent/map/lib/f:a	(Ljava/lang/String;[B)Z
    //   210: istore 5
    //   212: iload 6
    //   214: iload 5
    //   216: iand
    //   217: istore 5
    //   219: aload 7
    //   221: invokestatic 357	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   224: iload_3
    //   225: iconst_1
    //   226: iadd
    //   227: istore_3
    //   228: aload 7
    //   230: astore_1
    //   231: iload 5
    //   233: istore 6
    //   235: goto -89 -> 146
    //   238: iload 6
    //   240: istore 5
    //   242: aload_2
    //   243: aload_0
    //   244: getfield 359	com/tencent/tencentmap/mapsdk/maps/a/ll:i	Ljava/lang/String;
    //   247: invokevirtual 121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq -31 -> 219
    //   253: aload 8
    //   255: aload 10
    //   257: invokevirtual 351	java/io/File:getName	()Ljava/lang/String;
    //   260: aload_1
    //   261: invokevirtual 361	com/tencent/map/lib/f:b	(Ljava/lang/String;[B)Z
    //   264: istore 5
    //   266: iload 6
    //   268: iload 5
    //   270: iand
    //   271: istore 5
    //   273: goto -54 -> 219
    //   276: astore_1
    //   277: aload 7
    //   279: invokestatic 357	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   282: iload 6
    //   284: istore 5
    //   286: goto -62 -> 224
    //   289: astore_1
    //   290: aload 7
    //   292: invokestatic 357	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   295: iload 6
    //   297: istore 5
    //   299: goto -75 -> 224
    //   302: astore_1
    //   303: aload 7
    //   305: invokestatic 357	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   308: ldc_w 302
    //   311: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   314: aload_1
    //   315: athrow
    //   316: ldc_w 302
    //   319: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: iload 6
    //   324: ireturn
    //   325: astore_2
    //   326: aload_1
    //   327: astore 7
    //   329: aload_2
    //   330: astore_1
    //   331: goto -28 -> 303
    //   334: astore 7
    //   336: aload_1
    //   337: astore 7
    //   339: goto -49 -> 290
    //   342: astore 7
    //   344: aload_1
    //   345: astore 7
    //   347: goto -70 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	ll
    //   0	350	1	paramString1	String
    //   0	350	2	paramString2	String
    //   145	83	3	m	int
    //   142	8	4	n	int
    //   210	88	5	bool1	boolean
    //   135	188	6	bool2	boolean
    //   23	305	7	localObject	Object
    //   334	1	7	localIOException	java.io.IOException
    //   337	1	7	str1	String
    //   342	1	7	localFileNotFoundException	java.io.FileNotFoundException
    //   345	1	7	str2	String
    //   65	189	8	localf	f
    //   119	34	9	arrayOfFile	java.io.File[]
    //   156	100	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   169	212	276	java/io/FileNotFoundException
    //   242	266	276	java/io/FileNotFoundException
    //   169	212	289	java/io/IOException
    //   242	266	289	java/io/IOException
    //   169	212	302	finally
    //   242	266	302	finally
    //   158	169	325	finally
    //   158	169	334	java/io/IOException
    //   158	169	342	java/io/FileNotFoundException
  }
  
  private String b()
  {
    AppMethodBeat.i(149179);
    String str = this.g;
    if (StringUtil.isEmpty(this.g)) {
      str = ka.a;
    }
    AppMethodBeat.o(149179);
    return str;
  }
  
  private List<jo> b(String paramString, m paramm)
  {
    AppMethodBeat.i(149175);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new jn("mapconfig", this.c.b("mapConfigVersion"), this.c.a("mapConfigZipMd5")));
    localArrayList.add(new jn("poi_icon", this.c.b("poiIconVersion"), this.c.a("mapPoiIconZipMd5")));
    localArrayList.add(new jn("map_icon", this.c.b("mapIconVersion"), this.c.a("mapIconZipMd5")));
    localArrayList.add(new jn("rtt_config.json", this.c.b("rttConfigVersion"), this.c.a("rttConfigMd5")));
    localArrayList.add(new jn("closedroadstyle_normalmode", this.c.b("closeRoadSytleNomalModeVersion"), this.c.a("closeRoadSytleNomalModeMd5")));
    localArrayList.add(new jn("closedroadstyle_trafficmode", this.c.b("closeRoadStyleTrafficModeVersion"), this.c.a("closeRoadStyleTrafficModeMd5")));
    if ((paramm != null) && (paramm.a() == 1)) {
      if (paramm.b() != 1) {
        break label544;
      }
    }
    label544:
    for (paramm = new jn("indoormap_config_premium", this.c.b("mapConfigIndoorPremiumVersion"), this.c.a("mapConfigIndoorPremiumMd5"));; paramm = new jn("indoormap_config", this.c.b("mapConfigIndoorVersion"), this.c.a("mapConfigIndoorMd5")))
    {
      localArrayList.add(paramm);
      localArrayList.add(new jn("indoorpoi_icon", this.c.b("mapPoiIconIndoorVersion"), this.c.a("poiIconIndoorMd5")));
      localArrayList.add(new jn("sdk_offline_city_ver.json", this.c.b("offlineCityListVersion"), this.c.a("offlineCityListMd5")));
      paramm = b();
      paramString = new jm(localArrayList, paramm, "4.2.3.3", null, this.b, paramString);
      this.h = this.d.b(this.g);
      this.i = this.d.c(this.g);
      this.j = (this.d.d(this.g) + "config/");
      this.k = (this.d.d(this.g) + "assets/");
      t.a(this.j);
      t.a(this.k);
      paramString = new l().a(this.d.d(this.g) + "config/", this.d.d(this.g) + "assets/", paramm, paramString, this);
      AppMethodBeat.o(149175);
      return paramString;
    }
  }
  
  public void a(String paramString, m paramm)
  {
    AppMethodBeat.i(149174);
    String str = b();
    if (e.containsKey(str))
    {
      a(str, this.f);
      AppMethodBeat.o(149174);
      return;
    }
    a(str, this.f);
    new ll.a(this, paramString, paramm).start();
    AppMethodBeat.o(149174);
  }
  
  public WeakReference<ap>[] a()
  {
    AppMethodBeat.i(149181);
    Object localObject = (List)e.get(b());
    if (localObject == null)
    {
      AppMethodBeat.o(149181);
      return null;
    }
    localObject = (WeakReference[])((List)localObject).toArray(new WeakReference[((List)localObject).size()]);
    AppMethodBeat.o(149181);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ll
 * JD-Core Version:    0.7.0.1
 */