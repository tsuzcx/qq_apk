package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.map.lib.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mg
  implements m
{
  private static volatile Map<String, List<WeakReference<nv>>> e = new HashMap();
  private boolean a = false;
  private String b;
  private s c;
  private r d;
  private WeakReference<nv> f;
  private String g;
  private String h;
  private String i;
  private String j;
  
  public mg(Context paramContext, nv paramnv, String paramString)
  {
    this.d = r.a(paramContext);
    this.b = "";
    if ((paramnv != null) && (paramnv.l() != null) && (paramnv.l().getMap() != null)) {
      this.b = paramnv.l().getMap().I();
    }
    this.f = new WeakReference(paramnv);
    this.g = paramString;
    this.h = this.d.g(this.g);
    this.i = this.d.h(this.g);
    this.j = this.d.i(this.g);
    this.c = u.a(paramContext, this.g);
  }
  
  private String a(String paramString)
  {
    String str;
    if (paramString.equals("mapconfig")) {
      str = "mapconfig.dat";
    }
    do
    {
      return str;
      if ((paramString.equals("indoormap_config")) || (paramString.equals("indoormap_config_premium"))) {
        return "indoormap_config.dat";
      }
      if (paramString.equals("indoorpoi_icon")) {
        return "poi_icon_indoor@2x.png";
      }
      if (paramString.equals("closedroadstyle_normalmode")) {
        return "style_normalmode.xml";
      }
      if (paramString.equals("closedroadstyle_trafficmode")) {
        return "style_trafficmode.xml";
      }
      str = paramString;
    } while (!paramString.contains("@3x"));
    return null;
  }
  
  private void a()
  {
    this.c.a("mapConfigLastCheckTime", System.currentTimeMillis());
    if (this.a)
    {
      Object localObject = (List)e.get(b());
      if (localObject == null) {
        return;
      }
      int m = ((List)localObject).size();
      localObject = (WeakReference[])((List)localObject).toArray(new WeakReference[m]);
      int k = 0;
      while (k < m)
      {
        if (localObject[k] != null)
        {
          nv localnv = (nv)localObject[k].get();
          if ((localnv != null) && (localnv.l() != null) && (localnv.l().getMap() != null))
          {
            f localf = localnv.l().getMap();
            localf.p();
            if (localnv.b() != null) {
              localnv.b().a(localf);
            }
            localf.a();
          }
        }
        k += 1;
      }
    }
    e.clear();
    u.b();
  }
  
  /* Error */
  private void a(String paramString, WeakReference<nv> paramWeakReference)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 35	com/tencent/tencentmap/mapsdk/a/mg:e	Ljava/util/Map;
    //   5: aload_1
    //   6: invokeinterface 196 2 0
    //   11: ifeq +25 -> 36
    //   14: getstatic 35	com/tencent/tencentmap/mapsdk/a/mg:e	Ljava/util/Map;
    //   17: aload_1
    //   18: invokeinterface 153 2 0
    //   23: checkcast 155	java/util/List
    //   26: aload_2
    //   27: invokeinterface 199 2 0
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: new 201	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 202	java/util/ArrayList:<init>	()V
    //   43: astore_3
    //   44: aload_3
    //   45: aload_2
    //   46: invokeinterface 199 2 0
    //   51: pop
    //   52: getstatic 35	com/tencent/tencentmap/mapsdk/a/mg:e	Ljava/util/Map;
    //   55: aload_1
    //   56: aload_3
    //   57: invokeinterface 206 3 0
    //   62: pop
    //   63: goto -30 -> 33
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	mg
    //   0	71	1	paramString	String
    //   0	71	2	paramWeakReference	WeakReference<nv>
    //   43	14	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	33	66	finally
    //   36	63	66	finally
  }
  
  /* Error */
  private boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 215	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 222	java/io/File:exists	()Z
    //   13: ifeq +7 -> 20
    //   16: aload_3
    //   17: ifnonnull +9 -> 26
    //   20: iconst_0
    //   21: istore 7
    //   23: iload 7
    //   25: ireturn
    //   26: aload_3
    //   27: aload_1
    //   28: invokestatic 227	com/tencent/map/lib/util/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   31: invokevirtual 106	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: istore 7
    //   36: iload 7
    //   38: ifne +13 -> 51
    //   41: iconst_0
    //   42: ireturn
    //   43: astore_3
    //   44: aload_3
    //   45: invokevirtual 230	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   48: invokestatic 234	com/tencent/map/lib/d:b	(Ljava/lang/String;)V
    //   51: iload 4
    //   53: ifeq +16 -> 69
    //   56: aload_1
    //   57: aload_0
    //   58: getfield 91	com/tencent/tencentmap/mapsdk/a/mg:j	Ljava/lang/String;
    //   61: invokestatic 240	com/tencent/map/lib/util/ZipUtil:upZipFile	(Ljava/io/File;Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokevirtual 243	java/io/File:delete	()Z
    //   68: pop
    //   69: new 215	java/io/File
    //   72: dup
    //   73: aload_0
    //   74: getfield 91	com/tencent/tencentmap/mapsdk/a/mg:j	Ljava/lang/String;
    //   77: invokespecial 218	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: astore 8
    //   82: aload 8
    //   84: invokevirtual 222	java/io/File:exists	()Z
    //   87: ifeq +11 -> 98
    //   90: aload 8
    //   92: invokevirtual 246	java/io/File:isDirectory	()Z
    //   95: ifne +38 -> 133
    //   98: new 248	java/lang/StringBuilder
    //   101: dup
    //   102: ldc 250
    //   104: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 91	com/tencent/tencentmap/mapsdk/a/mg:j	Ljava/lang/String;
    //   111: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 234	com/tencent/map/lib/d:b	(Ljava/lang/String;)V
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 259	java/io/IOException:getMessage	()Ljava/lang/String;
    //   127: invokestatic 234	com/tencent/map/lib/d:b	(Ljava/lang/String;)V
    //   130: goto -61 -> 69
    //   133: aload_0
    //   134: invokespecial 147	com/tencent/tencentmap/mapsdk/a/mg:b	()Ljava/lang/String;
    //   137: astore_3
    //   138: getstatic 35	com/tencent/tencentmap/mapsdk/a/mg:e	Ljava/util/Map;
    //   141: ifnull +35 -> 176
    //   144: getstatic 35	com/tencent/tencentmap/mapsdk/a/mg:e	Ljava/util/Map;
    //   147: aload_3
    //   148: invokeinterface 153 2 0
    //   153: ifnull +23 -> 176
    //   156: getstatic 35	com/tencent/tencentmap/mapsdk/a/mg:e	Ljava/util/Map;
    //   159: aload_3
    //   160: invokeinterface 153 2 0
    //   165: checkcast 155	java/util/List
    //   168: invokeinterface 159 1 0
    //   173: ifne +5 -> 178
    //   176: iconst_0
    //   177: ireturn
    //   178: aconst_null
    //   179: astore_1
    //   180: getstatic 35	com/tencent/tencentmap/mapsdk/a/mg:e	Ljava/util/Map;
    //   183: aload_3
    //   184: invokeinterface 153 2 0
    //   189: checkcast 155	java/util/List
    //   192: astore 9
    //   194: iconst_0
    //   195: istore 5
    //   197: aload_1
    //   198: astore_3
    //   199: iload 5
    //   201: aload 9
    //   203: invokeinterface 159 1 0
    //   208: if_icmpge +49 -> 257
    //   211: aload 9
    //   213: iload 5
    //   215: invokeinterface 262 2 0
    //   220: ifnull +28 -> 248
    //   223: aload 9
    //   225: iload 5
    //   227: invokeinterface 262 2 0
    //   232: checkcast 71	java/lang/ref/WeakReference
    //   235: invokevirtual 168	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   238: checkcast 53	com/tencent/tencentmap/mapsdk/a/nv
    //   241: astore_1
    //   242: aload_1
    //   243: astore_3
    //   244: aload_1
    //   245: ifnonnull +12 -> 257
    //   248: iload 5
    //   250: iconst_1
    //   251: iadd
    //   252: istore 5
    //   254: goto -57 -> 197
    //   257: aload_3
    //   258: ifnull +20 -> 278
    //   261: aload_3
    //   262: invokevirtual 57	com/tencent/tencentmap/mapsdk/a/nv:l	()Lcom/tencent/tencentmap/mapsdk/a/ma;
    //   265: ifnull +13 -> 278
    //   268: aload_3
    //   269: invokevirtual 57	com/tencent/tencentmap/mapsdk/a/nv:l	()Lcom/tencent/tencentmap/mapsdk/a/ma;
    //   272: invokevirtual 63	com/tencent/tencentmap/mapsdk/a/ma:getMap	()Lcom/tencent/map/lib/f;
    //   275: ifnonnull +5 -> 280
    //   278: iconst_0
    //   279: ireturn
    //   280: aload_3
    //   281: invokevirtual 57	com/tencent/tencentmap/mapsdk/a/nv:l	()Lcom/tencent/tencentmap/mapsdk/a/ma;
    //   284: invokevirtual 63	com/tencent/tencentmap/mapsdk/a/ma:getMap	()Lcom/tencent/map/lib/f;
    //   287: astore_3
    //   288: iconst_1
    //   289: istore 4
    //   291: aload 8
    //   293: invokevirtual 266	java/io/File:listFiles	()[Ljava/io/File;
    //   296: astore 8
    //   298: aload 8
    //   300: arraylength
    //   301: istore 6
    //   303: iconst_0
    //   304: istore 5
    //   306: iload 4
    //   308: istore 7
    //   310: iload 5
    //   312: iload 6
    //   314: if_icmpge -291 -> 23
    //   317: aload 8
    //   319: iload 5
    //   321: aaload
    //   322: astore 10
    //   324: aload_0
    //   325: aload 10
    //   327: invokevirtual 269	java/io/File:getName	()Ljava/lang/String;
    //   330: invokespecial 271	com/tencent/tencentmap/mapsdk/a/mg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   333: astore 9
    //   335: aload 9
    //   337: ifnonnull +18 -> 355
    //   340: aload 10
    //   342: invokevirtual 243	java/io/File:delete	()Z
    //   345: pop
    //   346: iload 5
    //   348: iconst_1
    //   349: iadd
    //   350: istore 5
    //   352: goto -46 -> 306
    //   355: new 273	java/io/FileInputStream
    //   358: dup
    //   359: aload 10
    //   361: invokespecial 276	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   364: astore_1
    //   365: aload 10
    //   367: invokevirtual 279	java/io/File:length	()J
    //   370: l2i
    //   371: newarray byte
    //   373: astore 10
    //   375: aload_1
    //   376: aload 10
    //   378: iconst_0
    //   379: aload 10
    //   381: arraylength
    //   382: invokevirtual 285	java/io/InputStream:read	([BII)I
    //   385: pop
    //   386: aload_2
    //   387: aload_0
    //   388: getfield 83	com/tencent/tencentmap/mapsdk/a/mg:h	Ljava/lang/String;
    //   391: invokevirtual 106	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   394: ifeq +31 -> 425
    //   397: aload_3
    //   398: aload 9
    //   400: aload 10
    //   402: invokevirtual 288	com/tencent/map/lib/f:a	(Ljava/lang/String;[B)Z
    //   405: istore 7
    //   407: iload 4
    //   409: iload 7
    //   411: iand
    //   412: istore 7
    //   414: aload_1
    //   415: invokestatic 293	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   418: iload 7
    //   420: istore 4
    //   422: goto -76 -> 346
    //   425: iload 4
    //   427: istore 7
    //   429: aload_2
    //   430: aload_0
    //   431: getfield 87	com/tencent/tencentmap/mapsdk/a/mg:i	Ljava/lang/String;
    //   434: invokevirtual 106	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   437: ifeq -23 -> 414
    //   440: aload_3
    //   441: aload 9
    //   443: aload 10
    //   445: invokevirtual 295	com/tencent/map/lib/f:b	(Ljava/lang/String;[B)Z
    //   448: istore 7
    //   450: iload 4
    //   452: iload 7
    //   454: iand
    //   455: istore 7
    //   457: goto -43 -> 414
    //   460: astore_1
    //   461: aconst_null
    //   462: astore_1
    //   463: aload_1
    //   464: invokestatic 293	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   467: goto -121 -> 346
    //   470: astore_1
    //   471: aconst_null
    //   472: astore_1
    //   473: aload_1
    //   474: invokestatic 293	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   477: goto -131 -> 346
    //   480: astore_2
    //   481: aconst_null
    //   482: astore_1
    //   483: aload_1
    //   484: invokestatic 293	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   487: aload_2
    //   488: athrow
    //   489: astore_2
    //   490: goto -7 -> 483
    //   493: astore 9
    //   495: goto -22 -> 473
    //   498: astore 9
    //   500: goto -37 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	mg
    //   0	503	1	paramString1	String
    //   0	503	2	paramString2	String
    //   0	503	3	paramString3	String
    //   0	503	4	paramBoolean	boolean
    //   195	156	5	k	int
    //   301	14	6	m	int
    //   21	435	7	bool	boolean
    //   80	238	8	localObject1	Object
    //   192	250	9	localObject2	Object
    //   493	1	9	localIOException	java.io.IOException
    //   498	1	9	localFileNotFoundException	java.io.FileNotFoundException
    //   322	122	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   26	36	43	java/io/FileNotFoundException
    //   56	69	122	java/io/IOException
    //   355	365	460	java/io/FileNotFoundException
    //   355	365	470	java/io/IOException
    //   355	365	480	finally
    //   365	407	489	finally
    //   429	450	489	finally
    //   365	407	493	java/io/IOException
    //   429	450	493	java/io/IOException
    //   365	407	498	java/io/FileNotFoundException
    //   429	450	498	java/io/FileNotFoundException
  }
  
  private boolean a(boolean paramBoolean, lf paramlf)
  {
    if ((!paramBoolean) || (paramlf == null)) {}
    while (paramlf.d == 0) {
      return false;
    }
    v.a(this.j);
    String str1 = this.j + paramlf.a;
    String str2 = paramlf.a;
    int k = -1;
    switch (str2.hashCode())
    {
    default: 
      switch (k)
      {
      default: 
        paramBoolean = false;
      }
      break;
    }
    for (;;)
    {
      v.c(this.j);
      return paramBoolean;
      if (!str2.equals("mapconfig")) {
        break;
      }
      k = 0;
      break;
      if (!str2.equals("poi_icon")) {
        break;
      }
      k = 1;
      break;
      if (!str2.equals("map_icon")) {
        break;
      }
      k = 2;
      break;
      if (!str2.equals("rtt_config.json")) {
        break;
      }
      k = 3;
      break;
      if (!str2.equals("closedroadstyle_normalmode")) {
        break;
      }
      k = 4;
      break;
      if (!str2.equals("closedroadstyle_trafficmode")) {
        break;
      }
      k = 5;
      break;
      if (!str2.equals("indoormap_config_premium")) {
        break;
      }
      k = 6;
      break;
      if (!str2.equals("indoormap_config")) {
        break;
      }
      k = 7;
      break;
      if (!str2.equals("indoorpoi_icon")) {
        break;
      }
      k = 8;
      break;
      if (!str2.equals("sdk_offline_city_ver.json")) {
        break;
      }
      k = 9;
      break;
      boolean bool = a(str1, this.h, paramlf.f, false);
      paramBoolean = bool;
      if (bool)
      {
        this.c.a("mapConfigVersion", paramlf.c);
        this.c.a("mapConfigZipMd5", paramlf.f);
        paramBoolean = bool;
        continue;
        bool = a(str1, this.h, paramlf.f, true);
        paramBoolean = bool;
        if (bool)
        {
          this.c.a("poiIconVersion", paramlf.c);
          this.c.a("mapPoiIconZipMd5", paramlf.f);
          paramBoolean = bool;
          continue;
          bool = a(str1, this.i, paramlf.f, true);
          paramBoolean = bool;
          if (bool)
          {
            this.c.a("mapIconVersion", paramlf.c);
            this.c.a("mapIconZipMd5", paramlf.f);
            paramBoolean = bool;
            continue;
            bool = a(str1, this.h, paramlf.f, false);
            paramBoolean = bool;
            if (bool)
            {
              this.c.a("rttConfigVersion", paramlf.c);
              this.c.a("rttConfigMd5", paramlf.f);
              paramBoolean = bool;
              continue;
              bool = a(str1, this.h, paramlf.f, false);
              paramBoolean = bool;
              if (bool)
              {
                this.c.a("closeRoadSytleNomalModeVersion", paramlf.c);
                this.c.a("closeRoadSytleNomalModeMd5", paramlf.f);
                paramBoolean = bool;
                continue;
                bool = a(str1, this.h, paramlf.f, false);
                paramBoolean = bool;
                if (bool)
                {
                  this.c.a("closeRoadStyleTrafficModeVersion", paramlf.c);
                  this.c.a("closeRoadStyleTrafficModeMd5", paramlf.f);
                  paramBoolean = bool;
                  continue;
                  bool = a(str1, this.h, paramlf.f, false);
                  paramBoolean = bool;
                  if (bool)
                  {
                    this.c.a(new String[] { "mapConfigIndoorVersion", "mapConfigIndoorMd5" });
                    this.c.a("mapConfigIndoorPremiumVersion", paramlf.c);
                    this.c.a("mapConfigIndoorPremiumMd5", paramlf.f);
                    paramBoolean = bool;
                    continue;
                    bool = a(str1, this.h, paramlf.f, false);
                    paramBoolean = bool;
                    if (bool)
                    {
                      this.c.a(new String[] { "mapConfigIndoorPremiumVersion", "mapConfigIndoorPremiumMd5" });
                      this.c.a("mapConfigIndoorVersion", paramlf.c);
                      this.c.a("mapConfigIndoorMd5", paramlf.f);
                      paramBoolean = bool;
                      continue;
                      bool = a(str1, this.h, paramlf.f, false);
                      paramBoolean = bool;
                      if (bool)
                      {
                        this.c.a("mapPoiIconIndoorVersion", paramlf.c);
                        this.c.a("poiIconIndoorMd5", paramlf.f);
                        paramBoolean = bool;
                        continue;
                        bool = a(str1, this.h, paramlf.f, false);
                        paramBoolean = bool;
                        if (bool)
                        {
                          this.c.a("offlineCityListVersion", paramlf.c);
                          this.c.a("offlineCityListMd5", paramlf.f);
                          paramBoolean = bool;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private String b()
  {
    String str2 = this.g;
    String str1 = str2;
    if (str2 == null) {
      str1 = lq.a;
    }
    return str1;
  }
  
  private void b(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new le("mapconfig", this.c.b("mapConfigVersion"), this.c.a("mapConfigZipMd5")));
    localArrayList.add(new le("poi_icon", this.c.b("poiIconVersion"), this.c.a("mapPoiIconZipMd5")));
    localArrayList.add(new le("map_icon", this.c.b("mapIconVersion"), this.c.a("mapIconZipMd5")));
    localArrayList.add(new le("rtt_config.json", this.c.b("rttConfigVersion"), this.c.a("rttConfigMd5")));
    localArrayList.add(new le("closedroadstyle_normalmode", this.c.b("closeRoadSytleNomalModeVersion"), this.c.a("closeRoadSytleNomalModeMd5")));
    localArrayList.add(new le("closedroadstyle_trafficmode", this.c.b("closeRoadStyleTrafficModeVersion"), this.c.a("closeRoadStyleTrafficModeMd5")));
    if (paramInt == mb.d) {}
    for (Object localObject = new le("indoormap_config_premium", this.c.b("mapConfigIndoorPremiumVersion"), this.c.a("mapConfigIndoorPremiumMd5"));; localObject = new le("indoormap_config", this.c.b("mapConfigIndoorVersion"), this.c.a("mapConfigIndoorMd5")))
    {
      localArrayList.add(localObject);
      localArrayList.add(new le("indoorpoi_icon", this.c.b("mapPoiIconIndoorVersion"), this.c.a("poiIconIndoorMd5")));
      localArrayList.add(new le("sdk_offline_city_ver.json", this.c.b("offlineCityListVersion"), this.c.a("offlineCityListMd5")));
      localObject = b();
      paramString = new ld(localArrayList, (String)localObject, "4.1.1.2", null, this.b, paramString);
      new n().a(this.j, paramString, this, (String)localObject);
      return;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if ((paramInt == 0) && ((paramObject instanceof lf)))
    {
      if ((a(true, (lf)paramObject)) || (this.a)) {
        bool1 = true;
      }
      this.a = bool1;
      return;
    }
    if (!a(false, null))
    {
      bool1 = bool2;
      if (!this.a) {}
    }
    else
    {
      bool1 = true;
    }
    this.a = bool1;
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = b();
    if (e.containsKey(str))
    {
      a(str, this.f);
      return;
    }
    a(str, this.f);
    new mg.a(this, paramString, paramInt).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mg
 * JD-Core Version:    0.7.0.1
 */