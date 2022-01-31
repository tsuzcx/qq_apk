package com.tencent.mm.storage;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;

public final class bs
  extends j
{
  private z uCL = null;
  
  public bs(z paramz)
  {
    this.uCL = paramz;
  }
  
  public static boolean acr(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Map localMap = bn.s(paramString, "deviceinfoconfig");
        if ((localMap != null) && (g.DK()))
        {
          g.DQ();
          g.DP().DA().acq(paramString);
          return true;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", new Object[] { bk.j(paramString) });
      }
    }
    return false;
  }
  
  /* Error */
  private static boolean acs(String paramString)
  {
    // Byte code:
    //   0: new 76	java/io/File
    //   3: dup
    //   4: getstatic 82	com/tencent/mm/storage/ac:dOP	Ljava/lang/String;
    //   7: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 88	java/io/File:exists	()Z
    //   15: ifne +8 -> 23
    //   18: aload_2
    //   19: invokevirtual 91	java/io/File:mkdirs	()Z
    //   22: pop
    //   23: aconst_null
    //   24: astore_2
    //   25: ldc 57
    //   27: ldc 93
    //   29: iconst_2
    //   30: anewarray 61	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: new 95	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   42: getstatic 82	com/tencent/mm/storage/ac:dOP	Ljava/lang/String;
    //   45: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 102
    //   50: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: aload_0
    //   60: aastore
    //   61: invokestatic 109	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: new 111	java/io/FileWriter
    //   67: dup
    //   68: new 95	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   75: getstatic 82	com/tencent/mm/storage/ac:dOP	Ljava/lang/String;
    //   78: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 102
    //   83: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokespecial 112	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   92: astore_3
    //   93: aload_3
    //   94: astore_2
    //   95: aload_3
    //   96: aload_0
    //   97: invokevirtual 115	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   100: aload_3
    //   101: astore_2
    //   102: aload_3
    //   103: invokevirtual 118	java/io/FileWriter:close	()V
    //   106: aload_3
    //   107: invokevirtual 118	java/io/FileWriter:close	()V
    //   110: iconst_1
    //   111: ireturn
    //   112: astore_0
    //   113: ldc 57
    //   115: ldc 59
    //   117: iconst_1
    //   118: anewarray 61	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_0
    //   124: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   127: aastore
    //   128: invokestatic 71	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_3
    //   136: iconst_0
    //   137: istore_1
    //   138: aload_3
    //   139: astore_2
    //   140: ldc 57
    //   142: ldc 59
    //   144: iconst_1
    //   145: anewarray 61	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload_0
    //   151: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   154: aastore
    //   155: invokestatic 71	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: aload_3
    //   159: ifnull +79 -> 238
    //   162: aload_3
    //   163: invokevirtual 118	java/io/FileWriter:close	()V
    //   166: iload_1
    //   167: ireturn
    //   168: astore_0
    //   169: ldc 57
    //   171: ldc 59
    //   173: iconst_1
    //   174: anewarray 61	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_0
    //   180: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   183: aastore
    //   184: invokestatic 71	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: iload_1
    //   188: ireturn
    //   189: astore_0
    //   190: aload_2
    //   191: ifnull +7 -> 198
    //   194: aload_2
    //   195: invokevirtual 118	java/io/FileWriter:close	()V
    //   198: aload_0
    //   199: athrow
    //   200: astore_2
    //   201: ldc 57
    //   203: ldc 59
    //   205: iconst_1
    //   206: anewarray 61	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload_2
    //   212: invokestatic 65	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   215: aastore
    //   216: invokestatic 71	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: goto -21 -> 198
    //   222: astore_0
    //   223: goto -33 -> 190
    //   226: astore_0
    //   227: iconst_0
    //   228: istore_1
    //   229: goto -91 -> 138
    //   232: astore_0
    //   233: iconst_1
    //   234: istore_1
    //   235: goto -97 -> 138
    //   238: iload_1
    //   239: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   137	102	1	bool	boolean
    //   10	185	2	localObject	Object
    //   200	12	2	localIOException	java.io.IOException
    //   92	71	3	localFileWriter	java.io.FileWriter
    // Exception table:
    //   from	to	target	type
    //   106	110	112	java/io/IOException
    //   25	93	133	java/lang/Exception
    //   162	166	168	java/io/IOException
    //   25	93	189	finally
    //   194	198	200	java/io/IOException
    //   95	100	222	finally
    //   102	106	222	finally
    //   140	158	222	finally
    //   95	100	226	java/lang/Exception
    //   102	106	232	java/lang/Exception
  }
  
  public static String cwb()
  {
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
    str1 = bk.a(localLinkedHashMap);
    y.d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  " + str1);
    return str1;
  }
  
  public static String cwc()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("<deviceinfo>");
    localStringBuffer.append("<MANUFACTURER name=\"");
    localStringBuffer.append(Build.MANUFACTURER);
    localStringBuffer.append("\">");
    localStringBuffer.append("<MODEL name=\"");
    localStringBuffer.append(Build.MODEL);
    localStringBuffer.append("\">");
    localStringBuffer.append("<VERSION_RELEASE name=\"");
    localStringBuffer.append(Build.VERSION.RELEASE);
    localStringBuffer.append("\">");
    localStringBuffer.append("<VERSION_INCREMENTAL name=\"");
    localStringBuffer.append(Build.VERSION.INCREMENTAL);
    localStringBuffer.append("\">");
    localStringBuffer.append("<DISPLAY name=\"");
    localStringBuffer.append(Build.DISPLAY);
    localStringBuffer.append("\">");
    localStringBuffer.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
    y.d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + localStringBuffer.toString());
    return localStringBuffer.toString();
  }
  
  public final int acq(String paramString)
  {
    y.d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", new Object[] { paramString });
    this.uCL.o(77825, paramString);
    acs(paramString);
    super.aam(paramString);
    return 0;
  }
  
  public final void cvZ()
  {
    Object localObject = (String)this.uCL.get(77825, null);
    y.i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml " + (String)localObject);
    if (!bk.bl((String)localObject)) {
      super.aam((String)localObject);
    }
    int i;
    if (!bk.bl((String)localObject))
    {
      i = 1;
      if (i != 0) {
        break label188;
      }
      localObject = ac.dOP + "deviceconfig.cfg";
      if (com.tencent.mm.a.e.bK((String)localObject)) {
        break label116;
      }
      i = -1;
    }
    for (;;)
    {
      y.i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", new Object[] { Integer.valueOf(i) });
      return;
      i = 0;
      break;
      label116:
      localObject = com.tencent.mm.a.e.d((String)localObject, 0, -1);
      if (bk.bE((byte[])localObject))
      {
        i = -2;
      }
      else
      {
        localObject = new String((byte[])localObject, Charset.defaultCharset());
        if (bk.bl((String)localObject))
        {
          i = -3;
        }
        else
        {
          y.i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", new Object[] { localObject });
          acq((String)localObject);
          i = 0;
          continue;
          label188:
          y.i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
          i = 0;
        }
      }
    }
  }
  
  public final String cwa()
  {
    String str = (String)this.uCL.get(77825, null);
    y.d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.bs
 * JD-Core Version:    0.7.0.1
 */