package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ai;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public class ns
{
  private static volatile ns a;
  private int b;
  private List<nr> c;
  private String d;
  private String e;
  private ExecutorService f;
  
  private ns(ic paramic)
  {
    AppMethodBeat.i(149566);
    this.f = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque());
    this.c = new ArrayList();
    this.d = (paramic.i().getFilesDir().getAbsolutePath() + File.separator + "stData");
    Object localObject = new File(this.d);
    if (!((File)localObject).exists()) {}
    try
    {
      ((File)localObject).createNewFile();
      label110:
      String str = "";
      localObject = "";
      if (paramic.p() != null)
      {
        str = paramic.p().h();
        localObject = paramic.p().g();
      }
      this.e = ("https://pr.map.qq.com/ditusdk/monitor?" + ka.a(str, (String)localObject));
      this.f.execute(new ns.1(this));
      AppMethodBeat.o(149566);
      return;
    }
    catch (IOException localIOException)
    {
      break label110;
    }
  }
  
  public static ns a(ic paramic)
  {
    AppMethodBeat.i(149565);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ns(paramic);
      }
      paramic = a;
      AppMethodBeat.o(149565);
      return paramic;
    }
    finally
    {
      AppMethodBeat.o(149565);
    }
  }
  
  private JSONArray a(List<nr> paramList)
  {
    JSONArray localJSONArray;
    try
    {
      AppMethodBeat.i(149571);
      localJSONArray = new JSONArray();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (nr)paramList.next();
          if (localObject != null)
          {
            localObject = ((nr)localObject).a();
            if (localObject != null) {
              localJSONArray.put(localObject);
            }
          }
        }
      }
      AppMethodBeat.o(149571);
    }
    finally {}
    return localJSONArray;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 176
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 178	java/io/BufferedReader
    //   10: dup
    //   11: new 180	java/io/FileReader
    //   14: dup
    //   15: aload_0
    //   16: getfield 87	com/tencent/tencentmap/mapsdk/maps/a/ns:d	Ljava/lang/String;
    //   19: invokespecial 181	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 184	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_3
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +74 -> 110
    //   39: aload_3
    //   40: astore_2
    //   41: new 146	org/json/JSONArray
    //   44: dup
    //   45: aload 4
    //   47: invokespecial 188	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   50: astore 4
    //   52: aload_3
    //   53: astore_2
    //   54: aload 4
    //   56: invokevirtual 192	org/json/JSONArray:length	()I
    //   59: ifle -33 -> 26
    //   62: iconst_0
    //   63: istore_1
    //   64: aload_3
    //   65: astore_2
    //   66: iload_1
    //   67: aload 4
    //   69: invokevirtual 192	org/json/JSONArray:length	()I
    //   72: if_icmpge -46 -> 26
    //   75: aload_3
    //   76: astore_2
    //   77: aload 4
    //   79: iload_1
    //   80: invokevirtual 196	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   83: invokestatic 199	com/tencent/tencentmap/mapsdk/maps/a/nr:a	(Lorg/json/JSONObject;)Lcom/tencent/tencentmap/mapsdk/maps/a/nr;
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull +95 -> 185
    //   93: aload_3
    //   94: astore_2
    //   95: aload_0
    //   96: getfield 53	com/tencent/tencentmap/mapsdk/maps/a/ns:c	Ljava/util/List;
    //   99: aload 5
    //   101: invokeinterface 203 2 0
    //   106: pop
    //   107: goto +78 -> 185
    //   110: aload_3
    //   111: astore_2
    //   112: aload_0
    //   113: getfield 87	com/tencent/tencentmap/mapsdk/maps/a/ns:d	Ljava/lang/String;
    //   116: invokestatic 208	com/tencent/tencentmap/mapsdk/a/t:c	(Ljava/lang/String;)Z
    //   119: pop
    //   120: aload_3
    //   121: invokestatic 211	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   124: ldc 176
    //   126: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_0
    //   130: monitorexit
    //   131: return
    //   132: astore 4
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_3
    //   137: astore_2
    //   138: ldc 213
    //   140: aload 4
    //   142: invokestatic 218	com/tencent/map/lib/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_3
    //   146: invokestatic 211	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   149: ldc 176
    //   151: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   154: goto -25 -> 129
    //   157: astore_2
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_2
    //   161: athrow
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: invokestatic 211	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   169: ldc 176
    //   171: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: goto -12 -> 165
    //   180: astore 4
    //   182: goto -46 -> 136
    //   185: iload_1
    //   186: iconst_1
    //   187: iadd
    //   188: istore_1
    //   189: goto -125 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	ns
    //   63	126	1	i	int
    //   27	111	2	localBufferedReader1	java.io.BufferedReader
    //   157	4	2	localObject1	Object
    //   164	2	2	localCloseable	java.io.Closeable
    //   25	121	3	localBufferedReader2	java.io.BufferedReader
    //   162	13	3	localObject2	Object
    //   176	1	3	localObject3	Object
    //   32	46	4	localObject4	Object
    //   132	9	4	localException1	java.lang.Exception
    //   180	1	4	localException2	java.lang.Exception
    //   86	14	5	localnr	nr
    // Exception table:
    //   from	to	target	type
    //   7	26	132	java/lang/Exception
    //   2	7	157	finally
    //   120	129	157	finally
    //   145	154	157	finally
    //   165	176	157	finally
    //   7	26	162	finally
    //   28	34	176	finally
    //   41	52	176	finally
    //   54	62	176	finally
    //   66	75	176	finally
    //   77	88	176	finally
    //   95	107	176	finally
    //   112	120	176	finally
    //   138	145	176	finally
    //   28	34	180	java/lang/Exception
    //   41	52	180	java/lang/Exception
    //   54	62	180	java/lang/Exception
    //   66	75	180	java/lang/Exception
    //   77	88	180	java/lang/Exception
    //   95	107	180	java/lang/Exception
    //   112	120	180	java/lang/Exception
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 226
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokestatic 232	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: istore_2
    //   12: iload_2
    //   13: ifne +94 -> 107
    //   16: new 234	java/io/FileOutputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 87	com/tencent/tencentmap/mapsdk/maps/a/ns:d	Ljava/lang/String;
    //   24: invokespecial 235	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: aload_1
    //   35: invokevirtual 241	java/lang/String:getBytes	()[B
    //   38: invokevirtual 245	java/io/FileOutputStream:write	([B)V
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokevirtual 248	java/io/FileOutputStream:flush	()V
    //   49: aload 4
    //   51: invokestatic 211	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   54: ldc 226
    //   56: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: return
    //   62: astore 5
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_1
    //   67: astore_3
    //   68: aload 5
    //   70: invokestatic 254	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   73: invokestatic 255	com/tencent/map/lib/d:a	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokestatic 211	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   80: ldc 226
    //   82: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: goto -26 -> 59
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: invokestatic 211	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   100: ldc 226
    //   102: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_1
    //   106: athrow
    //   107: ldc 226
    //   109: invokestatic 135	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: goto -53 -> 59
    //   115: astore_1
    //   116: goto -20 -> 96
    //   119: astore 5
    //   121: aload 4
    //   123: astore_1
    //   124: goto -58 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	ns
    //   0	127	1	paramString	String
    //   11	2	2	bool	boolean
    //   31	66	3	localObject	Object
    //   27	95	4	localFileOutputStream	java.io.FileOutputStream
    //   62	7	5	localException1	java.lang.Exception
    //   119	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   16	29	62	java/lang/Exception
    //   2	12	88	finally
    //   49	59	88	finally
    //   76	85	88	finally
    //   96	107	88	finally
    //   107	112	88	finally
    //   16	29	93	finally
    //   32	41	115	finally
    //   44	49	115	finally
    //   68	76	115	finally
    //   32	41	119	java/lang/Exception
    //   44	49	119	java/lang/Exception
  }
  
  public void a(nr paramnr)
  {
    AppMethodBeat.i(149570);
    this.b -= 1;
    if (paramnr != null) {}
    try
    {
      this.c.add(paramnr);
      if (this.b != 0)
      {
        AppMethodBeat.o(149570);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(149570);
    }
    paramnr = a(this.c).toString();
    this.f.execute(new ns.2(this, paramnr));
    try
    {
      this.c.clear();
      return;
    }
    finally
    {
      AppMethodBeat.o(149570);
    }
  }
  
  public void b(ic paramic)
  {
    AppMethodBeat.i(149569);
    if (paramic == null)
    {
      AppMethodBeat.o(149569);
      return;
    }
    if (this.b == 0) {
      a();
    }
    this.b += 1;
    AppMethodBeat.o(149569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ns
 * JD-Core Version:    0.7.0.1
 */