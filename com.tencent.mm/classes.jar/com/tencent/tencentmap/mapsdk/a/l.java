package com.tencent.tencentmap.mapsdk.a;

import android.util.Log;
import com.tencent.map.lib.d;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.ZipUtil;
import com.tencent.map.lib.util.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.jm;
import com.tencent.tencentmap.mapsdk.maps.a.jn;
import com.tencent.tencentmap.mapsdk.maps.a.jo;
import com.tencent.tencentmap.mapsdk.maps.a.jp;
import com.tencent.tencentmap.mapsdk.maps.a.k;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.kx;
import com.tencent.tencentmap.mapsdk.maps.a.ll;
import com.tencent.tencentmap.mapsdk.maps.a.nr;
import com.tencent.tencentmap.mapsdk.maps.a.nr.c;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class l
{
  private WeakReference<ll> a;
  private List<jn> b;
  private String c;
  private String d;
  private String e;
  private int f;
  
  private nr.c a(jo paramjo)
  {
    AppMethodBeat.i(147038);
    if ((paramjo == null) || (paramjo.b != 0))
    {
      AppMethodBeat.o(147038);
      return null;
    }
    String str = paramjo.a;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(147038);
        return null;
        if (str.equals("mapconfig"))
        {
          i = 0;
          continue;
          if (str.equals("poi_icon"))
          {
            i = 1;
            continue;
            if (str.equals("map_icon"))
            {
              i = 2;
              continue;
              if (str.equals("rtt_config.json"))
              {
                i = 3;
                continue;
                if (str.equals("closedroadstyle_normalmode"))
                {
                  i = 4;
                  continue;
                  if (str.equals("closedroadstyle_trafficmode"))
                  {
                    i = 5;
                    continue;
                    if (str.equals("indoormap_config_premium"))
                    {
                      i = 6;
                      continue;
                      if (str.equals("indoormap_config"))
                      {
                        i = 7;
                        continue;
                        if (str.equals("indoorpoi_icon"))
                        {
                          i = 8;
                          continue;
                          if (str.equals("sdk_offline_city_ver.json")) {
                            i = 9;
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
        break;
      }
    }
    paramjo = a(paramjo, this.c, false);
    AppMethodBeat.o(147038);
    return paramjo;
    paramjo = a(paramjo, this.c, true);
    AppMethodBeat.o(147038);
    return paramjo;
    paramjo = a(paramjo, this.d, true);
    AppMethodBeat.o(147038);
    return paramjo;
    paramjo = a(paramjo, this.c, false);
    AppMethodBeat.o(147038);
    return paramjo;
    paramjo = a(paramjo, this.c, false);
    AppMethodBeat.o(147038);
    return paramjo;
    paramjo = a(paramjo, this.c, false);
    AppMethodBeat.o(147038);
    return paramjo;
    paramjo = a(paramjo, this.c, false);
    AppMethodBeat.o(147038);
    return paramjo;
    paramjo = a(paramjo, this.c, false);
    AppMethodBeat.o(147038);
    return paramjo;
    paramjo = a(paramjo, this.c, false);
    AppMethodBeat.o(147038);
    return paramjo;
    paramjo = a(paramjo, this.c, false);
    AppMethodBeat.o(147038);
    return paramjo;
  }
  
  private nr.c a(jo paramjo, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(147039);
    if (paramjo.d != 1)
    {
      AppMethodBeat.o(147039);
      return null;
    }
    Object localObject = a(paramjo.a);
    paramString = new File(paramString + (String)localObject);
    localObject = a(paramjo.e, paramString);
    if (localObject != null)
    {
      ((nr.c)localObject).a = paramjo.a;
      AppMethodBeat.o(147039);
      return localObject;
    }
    try
    {
      localObject = a.a(paramString);
      if (!paramjo.f.equals(localObject))
      {
        paramString = new nr.c();
        paramString.a = paramjo.a;
        paramString.c = paramjo.f;
        paramString.d = ((String)localObject);
        AppMethodBeat.o(147039);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      d.b(paramString.getMessage());
      paramString = new nr.c();
      paramString.a = paramjo.a;
      AppMethodBeat.o(147039);
      return paramString;
    }
    if (paramBoolean) {}
    try
    {
      ZipUtil.upZipFile(paramString, paramString.getParent());
      paramString.delete();
      if ((this.a != null) && (this.a.get() != null)) {
        ((ll)this.a.get()).a = true;
      }
      AppMethodBeat.o(147039);
      return null;
    }
    catch (IOException paramString)
    {
      d.b(paramString.getMessage());
      paramString = new nr.c();
      paramString.a = paramjo.a;
      AppMethodBeat.o(147039);
    }
    return paramString;
  }
  
  /* Error */
  private nr.c a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: ldc 154
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: sipush 200
    //   8: istore 4
    //   10: iload 4
    //   12: istore_3
    //   13: new 156	java/net/URL
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 157	java/net/URL:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 161	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: checkcast 163	java/net/HttpURLConnection
    //   27: astore 7
    //   29: iload 4
    //   31: istore_3
    //   32: aload 7
    //   34: invokevirtual 166	java/net/HttpURLConnection:getResponseCode	()I
    //   37: istore 4
    //   39: iload 4
    //   41: istore_3
    //   42: aload 7
    //   44: invokevirtual 170	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 173	java/io/File:exists	()Z
    //   52: ifne +25 -> 77
    //   55: aload_2
    //   56: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +9 -> 72
    //   66: aload 5
    //   68: invokevirtual 180	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: aload_2
    //   73: invokevirtual 183	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: new 185	java/io/FileOutputStream
    //   80: dup
    //   81: aload_2
    //   82: iconst_0
    //   83: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   86: astore_2
    //   87: aload_2
    //   88: astore 6
    //   90: aload_1
    //   91: astore 5
    //   93: aload_1
    //   94: aload_2
    //   95: invokestatic 193	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   98: pop2
    //   99: aload_2
    //   100: astore 6
    //   102: aload_1
    //   103: astore 5
    //   105: aload 7
    //   107: invokevirtual 196	java/net/HttpURLConnection:disconnect	()V
    //   110: aload_1
    //   111: invokestatic 199	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   114: aload_2
    //   115: invokestatic 199	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   118: ldc 154
    //   120: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aconst_null
    //   124: areturn
    //   125: astore 7
    //   127: aconst_null
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_2
    //   132: astore 6
    //   134: aload_1
    //   135: astore 5
    //   137: aload 7
    //   139: invokestatic 205	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   142: invokestatic 126	com/tencent/map/lib/d:b	(Ljava/lang/String;)V
    //   145: aload_2
    //   146: astore 6
    //   148: aload_1
    //   149: astore 5
    //   151: new 108	com/tencent/tencentmap/mapsdk/maps/a/nr$c
    //   154: dup
    //   155: invokespecial 117	com/tencent/tencentmap/mapsdk/maps/a/nr$c:<init>	()V
    //   158: astore 7
    //   160: aload_2
    //   161: astore 6
    //   163: aload_1
    //   164: astore 5
    //   166: aload 7
    //   168: iload_3
    //   169: putfield 207	com/tencent/tencentmap/mapsdk/maps/a/nr$c:f	I
    //   172: aload_1
    //   173: invokestatic 199	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   176: aload_2
    //   177: invokestatic 199	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   180: ldc 154
    //   182: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload 7
    //   187: areturn
    //   188: astore_2
    //   189: aconst_null
    //   190: astore 6
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: invokestatic 199	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   198: aload 6
    //   200: invokestatic 199	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   203: ldc 154
    //   205: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_2
    //   209: athrow
    //   210: astore_2
    //   211: aconst_null
    //   212: astore 6
    //   214: goto -20 -> 194
    //   217: astore_2
    //   218: aload 5
    //   220: astore_1
    //   221: goto -27 -> 194
    //   224: astore 7
    //   226: aconst_null
    //   227: astore_2
    //   228: iload 4
    //   230: istore_3
    //   231: goto -100 -> 131
    //   234: astore 7
    //   236: iload 4
    //   238: istore_3
    //   239: goto -108 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	l
    //   0	242	1	paramString	String
    //   0	242	2	paramFile	File
    //   12	227	3	i	int
    //   8	229	4	j	int
    //   59	160	5	localObject	Object
    //   88	125	6	localFile	File
    //   27	79	7	localHttpURLConnection	java.net.HttpURLConnection
    //   125	13	7	localException1	Exception
    //   158	28	7	localc	nr.c
    //   224	1	7	localException2	Exception
    //   234	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   13	29	125	java/lang/Exception
    //   32	39	125	java/lang/Exception
    //   42	48	125	java/lang/Exception
    //   13	29	188	finally
    //   32	39	188	finally
    //   42	48	188	finally
    //   48	61	210	finally
    //   66	72	210	finally
    //   72	77	210	finally
    //   77	87	210	finally
    //   93	99	217	finally
    //   105	110	217	finally
    //   137	145	217	finally
    //   151	160	217	finally
    //   166	172	217	finally
    //   48	61	224	java/lang/Exception
    //   66	72	224	java/lang/Exception
    //   72	77	224	java/lang/Exception
    //   77	87	224	java/lang/Exception
    //   93	99	234	java/lang/Exception
    //   105	110	234	java/lang/Exception
  }
  
  private String a(String paramString)
  {
    AppMethodBeat.i(147041);
    if (paramString.equals("mapconfig"))
    {
      AppMethodBeat.o(147041);
      return "mapconfig.dat";
    }
    if ((paramString.equals("indoormap_config")) || (paramString.equals("indoormap_config_premium")))
    {
      AppMethodBeat.o(147041);
      return "indoormap_config.dat";
    }
    if (paramString.equals("indoorpoi_icon"))
    {
      AppMethodBeat.o(147041);
      return "poi_icon_indoor@2x.png";
    }
    if (paramString.equals("closedroadstyle_normalmode"))
    {
      AppMethodBeat.o(147041);
      return "style_normalmode.xml";
    }
    if (paramString.equals("closedroadstyle_trafficmode"))
    {
      AppMethodBeat.o(147041);
      return "style_trafficmode.xml";
    }
    AppMethodBeat.o(147041);
    return paramString;
  }
  
  private List<jo> a(jm paramjm)
  {
    AppMethodBeat.i(147037);
    try
    {
      Object localObject = "https://vectorsdk.map.qq.com".concat(String.valueOf(ka.a(this.e)));
      paramjm = dp.a().a((String)localObject, "androidsdk", paramjm.toByteArray("UTF-8"));
      if (paramjm != null)
      {
        localObject = paramjm.a;
        if (localObject != null) {}
      }
      else
      {
        AppMethodBeat.o(147037);
        return null;
      }
      paramjm = new k(paramjm.a);
      paramjm.a("UTF-8");
      localObject = new jp();
      ((jp)localObject).readFrom(paramjm);
      if (((jp)localObject).a == 0)
      {
        paramjm = ((jp)localObject).b;
        AppMethodBeat.o(147037);
        return paramjm;
      }
      AppMethodBeat.o(147037);
      return null;
    }
    catch (Exception paramjm)
    {
      d.b(Log.getStackTraceString(paramjm));
      AppMethodBeat.o(147037);
    }
    return null;
  }
  
  private void a(nr.c paramc)
  {
    AppMethodBeat.i(147042);
    if (this.a != null)
    {
      localObject1 = (ll)this.a.get();
      if (localObject1 != null) {}
    }
    else
    {
      AppMethodBeat.o(147042);
      return;
    }
    Object localObject1 = ((ll)localObject1).a();
    if (localObject1 == null)
    {
      AppMethodBeat.o(147042);
      return;
    }
    int i = 0;
    while (i < localObject1.length)
    {
      if (localObject1[i] != null)
      {
        Object localObject2 = (ap)localObject1[i].get();
        if ((localObject2 != null) && (((ap)localObject2).k() != null) && (((ap)localObject2).k().b() != null))
        {
          localObject2 = ((ap)localObject2).k().o();
          if ((localObject2 == null) || (((nr)localObject2).c == null))
          {
            AppMethodBeat.o(147042);
            return;
          }
          paramc.b -= ((nr)localObject2).a;
          ((nr)localObject2).a(paramc);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(147042);
  }
  
  private jn b(String paramString)
  {
    AppMethodBeat.i(147043);
    if ((this.b == null) || (this.b.isEmpty()))
    {
      AppMethodBeat.o(147043);
      return null;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      jn localjn = (jn)localIterator.next();
      if (StringUtil.isEqual(localjn.a, paramString))
      {
        AppMethodBeat.o(147043);
        return localjn;
      }
    }
    AppMethodBeat.o(147043);
    return null;
  }
  
  public List<jo> a(String paramString1, String paramString2, String paramString3, jm paramjm, ll paramll)
  {
    AppMethodBeat.i(147036);
    if ((paramjm == null) || (paramll == null))
    {
      AppMethodBeat.o(147036);
      return null;
    }
    this.b = paramjm.a;
    this.c = paramString1;
    this.d = paramString2;
    this.a = new WeakReference(paramll);
    this.e = paramString3;
    paramString2 = a(paramjm);
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(147036);
      return null;
    }
    this.f = paramString2.size();
    paramString3 = paramString2.iterator();
    while (paramString3.hasNext())
    {
      paramString1 = a((jo)paramString3.next());
      if (paramString1 != null)
      {
        paramString2 = b(paramString1.a);
        if (paramString2 != null) {}
        for (paramString1.e = paramString2.b;; paramString1.e = -1)
        {
          paramString1.b = System.currentTimeMillis();
          a(paramString1);
          AppMethodBeat.o(147036);
          return null;
        }
      }
      this.f -= 1;
    }
    if (this.f != 0)
    {
      AppMethodBeat.o(147036);
      return null;
    }
    AppMethodBeat.o(147036);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.l
 * JD-Core Version:    0.7.0.1
 */