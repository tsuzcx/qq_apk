package com.tencent.mm.storage;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.vfs.i;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

public final class bw
  extends k
{
  private ae GZO = null;
  
  public bw(ae paramae)
  {
    this.GZO = paramae;
  }
  
  public static boolean aOE(String paramString)
  {
    AppMethodBeat.i(133306);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133306);
      return false;
    }
    try
    {
      Map localMap = bv.L(paramString, "deviceinfoconfig");
      if (localMap == null)
      {
        AppMethodBeat.o(133306);
        return false;
      }
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", new Object[] { bs.m(paramString) });
      AppMethodBeat.o(133306);
      return false;
    }
    if (!g.agM())
    {
      AppMethodBeat.o(133306);
      return false;
    }
    g.agS();
    g.agR().agB().aOD(paramString);
    AppMethodBeat.o(133306);
    return true;
  }
  
  /* Error */
  private static boolean aOF(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 83
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 85	com/tencent/mm/vfs/e
    //   10: dup
    //   11: getstatic 91	com/tencent/mm/storage/ah:GDu	Ljava/lang/String;
    //   14: invokespecial 94	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 97	com/tencent/mm/vfs/e:exists	()Z
    //   22: ifne +8 -> 30
    //   25: aload_2
    //   26: invokevirtual 100	com/tencent/mm/vfs/e:mkdirs	()Z
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
    //   49: getstatic 91	com/tencent/mm/storage/ah:GDu	Ljava/lang/String;
    //   52: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 111
    //   57: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: aload_0
    //   67: aastore
    //   68: invokestatic 117	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: new 119	com/tencent/mm/vfs/l
    //   74: dup
    //   75: new 104	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   82: getstatic 91	com/tencent/mm/storage/ah:GDu	Ljava/lang/String;
    //   85: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 111
    //   90: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 120	com/tencent/mm/vfs/l:<init>	(Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_3
    //   101: astore_2
    //   102: aload_3
    //   103: aload_0
    //   104: invokevirtual 123	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   107: aload_3
    //   108: astore_2
    //   109: aload_3
    //   110: invokevirtual 126	com/tencent/mm/vfs/l:close	()V
    //   113: aload_3
    //   114: invokevirtual 126	com/tencent/mm/vfs/l:close	()V
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
    //   136: invokestatic 51	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   164: invokestatic 51	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   167: aastore
    //   168: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_3
    //   172: ifnull +86 -> 258
    //   175: aload_3
    //   176: invokevirtual 126	com/tencent/mm/vfs/l:close	()V
    //   179: goto -62 -> 117
    //   182: astore_0
    //   183: ldc 43
    //   185: ldc 45
    //   187: iconst_1
    //   188: anewarray 47	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: aload_0
    //   194: invokestatic 51	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   197: aastore
    //   198: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: goto -84 -> 117
    //   204: astore_0
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 126	com/tencent/mm/vfs/l:close	()V
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
    //   232: invokestatic 51	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   235: aastore
    //   236: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   99	77	3	locall	com.tencent.mm.vfs.l
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
  
  public static String fcB()
  {
    AppMethodBeat.i(133304);
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
    str1 = bs.a(localLinkedHashMap);
    ac.d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  ".concat(String.valueOf(str1)));
    AppMethodBeat.o(133304);
    return str1;
  }
  
  public static String fcC()
  {
    AppMethodBeat.i(133305);
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
    ac.d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + ((StringBuffer)localObject).toString());
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(133305);
    return localObject;
  }
  
  private boolean fcy()
  {
    AppMethodBeat.i(133300);
    String str = (String)this.GZO.get(77825, null);
    ac.i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml ".concat(String.valueOf(str)));
    if (!bs.isNullOrNil(str)) {
      super.doNotify(str);
    }
    if (!bs.isNullOrNil(str))
    {
      AppMethodBeat.o(133300);
      return true;
    }
    AppMethodBeat.o(133300);
    return false;
  }
  
  private int fcz()
  {
    AppMethodBeat.i(133301);
    if (!fcy())
    {
      Object localObject = ah.GDu + "deviceconfig.cfg";
      if (!i.eA((String)localObject))
      {
        AppMethodBeat.o(133301);
        return -1;
      }
      localObject = i.aU((String)localObject, 0, -1);
      if (bs.cv((byte[])localObject))
      {
        AppMethodBeat.o(133301);
        return -2;
      }
      localObject = new String((byte[])localObject, Charset.defaultCharset());
      if (bs.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(133301);
        return -3;
      }
      ac.i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", new Object[] { localObject });
      aOD((String)localObject);
      AppMethodBeat.o(133301);
      return 0;
    }
    ac.i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
    AppMethodBeat.o(133301);
    return 0;
  }
  
  public final int aOD(String paramString)
  {
    AppMethodBeat.i(133303);
    ac.d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", new Object[] { paramString });
    this.GZO.set(77825, paramString);
    aOF(paramString);
    super.doNotify(paramString);
    AppMethodBeat.o(133303);
    return 0;
  }
  
  public final String fcA()
  {
    AppMethodBeat.i(133302);
    String str = (String)this.GZO.get(77825, null);
    ac.d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
    AppMethodBeat.o(133302);
    return str;
  }
  
  public final void fcx()
  {
    AppMethodBeat.i(133299);
    ac.i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", new Object[] { Integer.valueOf(fcz()) });
    AppMethodBeat.o(133299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bw
 * JD-Core Version:    0.7.0.1
 */