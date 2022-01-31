package com.tencent.mm.storage;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

public final class bs
  extends k
{
  private z yOX = null;
  
  public bs(z paramz)
  {
    this.yOX = paramz;
  }
  
  public static boolean asD(String paramString)
  {
    AppMethodBeat.i(59014);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(59014);
      return false;
    }
    try
    {
      Map localMap = br.F(paramString, "deviceinfoconfig");
      if (localMap == null)
      {
        AppMethodBeat.o(59014);
        return false;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", new Object[] { bo.l(paramString) });
      AppMethodBeat.o(59014);
      return false;
    }
    if (!g.RG())
    {
      AppMethodBeat.o(59014);
      return false;
    }
    g.RM();
    g.RL().Rv().asC(paramString);
    AppMethodBeat.o(59014);
    return true;
  }
  
  /* Error */
  private static boolean asE(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 83
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 85	java/io/File
    //   10: dup
    //   11: getstatic 91	com/tencent/mm/storage/ac:eQv	Ljava/lang/String;
    //   14: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 97	java/io/File:exists	()Z
    //   22: ifne +8 -> 30
    //   25: aload_2
    //   26: invokevirtual 100	java/io/File:mkdirs	()Z
    //   29: pop
    //   30: aconst_null
    //   31: astore_2
    //   32: ldc 43
    //   34: ldc 102
    //   36: iconst_2
    //   37: anewarray 47	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: new 104	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   49: getstatic 91	com/tencent/mm/storage/ac:eQv	Ljava/lang/String;
    //   52: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 111
    //   57: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_0
    //   67: aastore
    //   68: invokestatic 117	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: new 119	java/io/FileWriter
    //   74: dup
    //   75: new 104	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   82: getstatic 91	com/tencent/mm/storage/ac:eQv	Ljava/lang/String;
    //   85: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 111
    //   90: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 120	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_3
    //   101: astore_2
    //   102: aload_3
    //   103: aload_0
    //   104: invokevirtual 123	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   107: aload_3
    //   108: astore_2
    //   109: aload_3
    //   110: invokevirtual 126	java/io/FileWriter:close	()V
    //   113: aload_3
    //   114: invokevirtual 126	java/io/FileWriter:close	()V
    //   117: ldc 83
    //   119: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iload_1
    //   123: ireturn
    //   124: astore_0
    //   125: ldc 43
    //   127: ldc 45
    //   129: iconst_1
    //   130: anewarray 47	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: invokestatic 51	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: goto -26 -> 117
    //   146: astore_0
    //   147: aconst_null
    //   148: astore_3
    //   149: iconst_0
    //   150: istore_1
    //   151: aload_3
    //   152: astore_2
    //   153: ldc 43
    //   155: ldc 45
    //   157: iconst_1
    //   158: anewarray 47	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_0
    //   164: invokestatic 51	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   167: aastore
    //   168: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_3
    //   172: ifnull +86 -> 258
    //   175: aload_3
    //   176: invokevirtual 126	java/io/FileWriter:close	()V
    //   179: goto -62 -> 117
    //   182: astore_0
    //   183: ldc 43
    //   185: ldc 45
    //   187: iconst_1
    //   188: anewarray 47	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload_0
    //   194: invokestatic 51	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   197: aastore
    //   198: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: goto -84 -> 117
    //   204: astore_0
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 126	java/io/FileWriter:close	()V
    //   213: ldc 83
    //   215: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload_0
    //   219: athrow
    //   220: astore_2
    //   221: ldc 43
    //   223: ldc 45
    //   225: iconst_1
    //   226: anewarray 47	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_2
    //   232: invokestatic 51	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   235: aastore
    //   236: invokestatic 57	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: goto -26 -> 213
    //   242: astore_0
    //   243: goto -38 -> 205
    //   246: astore_0
    //   247: iconst_0
    //   248: istore_1
    //   249: goto -98 -> 151
    //   252: astore_0
    //   253: iconst_1
    //   254: istore_1
    //   255: goto -104 -> 151
    //   258: goto -141 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramString	String
    //   1	254	1	bool	boolean
    //   17	193	2	localObject	Object
    //   220	12	2	localException	Exception
    //   99	77	3	localFileWriter	java.io.FileWriter
    // Exception table:
    //   from	to	target	type
    //   113	117	124	java/lang/Exception
    //   32	100	146	java/lang/Exception
    //   175	179	182	java/lang/Exception
    //   32	100	204	finally
    //   209	213	220	java/lang/Exception
    //   102	107	242	finally
    //   109	113	242	finally
    //   153	171	242	finally
    //   102	107	246	java/lang/Exception
    //   109	113	252	java/lang/Exception
  }
  
  private boolean dyK()
  {
    AppMethodBeat.i(59008);
    String str = (String)this.yOX.get(77825, null);
    ab.i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml ".concat(String.valueOf(str)));
    if (!bo.isNullOrNil(str)) {
      super.doNotify(str);
    }
    if (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(59008);
      return true;
    }
    AppMethodBeat.o(59008);
    return false;
  }
  
  private int dyL()
  {
    AppMethodBeat.i(59009);
    if (!dyK())
    {
      Object localObject = ac.eQv + "deviceconfig.cfg";
      if (!com.tencent.mm.a.e.cN((String)localObject))
      {
        AppMethodBeat.o(59009);
        return -1;
      }
      localObject = com.tencent.mm.a.e.j((String)localObject, 0, -1);
      if (bo.ce((byte[])localObject))
      {
        AppMethodBeat.o(59009);
        return -2;
      }
      localObject = new String((byte[])localObject, Charset.defaultCharset());
      if (bo.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(59009);
        return -3;
      }
      ab.i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", new Object[] { localObject });
      asC((String)localObject);
      AppMethodBeat.o(59009);
      return 0;
    }
    ab.i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
    AppMethodBeat.o(59009);
    return 0;
  }
  
  public static String dyN()
  {
    AppMethodBeat.i(59012);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    String str2 = Build.FINGERPRINT;
    String str1 = str2;
    if (str2 != null) {
      str1 = str2.replace("/", ":");
    }
    localLinkedHashMap.put("fingerprint", str1);
    localLinkedHashMap.put("manufacturer", Build.MANUFACTURER);
    localLinkedHashMap.put("device", Build.DEVICE);
    localLinkedHashMap.put("model", Build.MODEL);
    localLinkedHashMap.put("product", Build.PRODUCT);
    localLinkedHashMap.put("board", Build.BOARD);
    localLinkedHashMap.put("release", Build.VERSION.RELEASE);
    localLinkedHashMap.put("codename", Build.VERSION.CODENAME);
    localLinkedHashMap.put("incremental", Build.VERSION.INCREMENTAL);
    localLinkedHashMap.put("display", Build.DISPLAY);
    str1 = bo.a(localLinkedHashMap);
    ab.d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  ".concat(String.valueOf(str1)));
    AppMethodBeat.o(59012);
    return str1;
  }
  
  public static String dyO()
  {
    AppMethodBeat.i(59013);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("<deviceinfo>");
    ((StringBuffer)localObject).append("<MANUFACTURER name=\"");
    ((StringBuffer)localObject).append(Build.MANUFACTURER);
    ((StringBuffer)localObject).append("\">");
    ((StringBuffer)localObject).append("<MODEL name=\"");
    ((StringBuffer)localObject).append(Build.MODEL);
    ((StringBuffer)localObject).append("\">");
    ((StringBuffer)localObject).append("<VERSION_RELEASE name=\"");
    ((StringBuffer)localObject).append(Build.VERSION.RELEASE);
    ((StringBuffer)localObject).append("\">");
    ((StringBuffer)localObject).append("<VERSION_INCREMENTAL name=\"");
    ((StringBuffer)localObject).append(Build.VERSION.INCREMENTAL);
    ((StringBuffer)localObject).append("\">");
    ((StringBuffer)localObject).append("<DISPLAY name=\"");
    ((StringBuffer)localObject).append(Build.DISPLAY);
    ((StringBuffer)localObject).append("\">");
    ((StringBuffer)localObject).append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
    ab.d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(59013);
    return localObject;
  }
  
  public final int asC(String paramString)
  {
    AppMethodBeat.i(59011);
    ab.d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", new Object[] { paramString });
    this.yOX.set(77825, paramString);
    asE(paramString);
    super.doNotify(paramString);
    AppMethodBeat.o(59011);
    return 0;
  }
  
  public final void dyJ()
  {
    AppMethodBeat.i(59007);
    ab.i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", new Object[] { Integer.valueOf(dyL()) });
    AppMethodBeat.o(59007);
  }
  
  public final String dyM()
  {
    AppMethodBeat.i(59010);
    String str = (String)this.yOX.get(77825, null);
    ab.d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
    AppMethodBeat.o(59010);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bs
 * JD-Core Version:    0.7.0.1
 */