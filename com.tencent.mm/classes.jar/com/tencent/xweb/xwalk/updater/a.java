package com.tencent.xweb.xwalk.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkInitializer;

public final class a
{
  private static int a(Element paramElement, String paramString)
  {
    AppMethodBeat.i(154538);
    if (paramElement == null)
    {
      AppMethodBeat.o(154538);
      return 0;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(154538);
      return 0;
    }
    try
    {
      int i = Integer.parseInt(paramElement);
      AppMethodBeat.o(154538);
      return i;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetInt failed : " + paramElement.getMessage());
      AppMethodBeat.o(154538);
    }
    return 0;
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 85
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: newarray byte
    //   10: astore 5
    //   12: new 87	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_0
    //   21: aload_0
    //   22: aload 5
    //   24: iconst_0
    //   25: aload 5
    //   27: arraylength
    //   28: invokevirtual 94	java/io/FileInputStream:read	([BII)I
    //   31: istore_1
    //   32: aload 5
    //   34: arraylength
    //   35: istore 4
    //   37: iload_1
    //   38: iload 4
    //   40: if_icmpeq +25 -> 65
    //   43: aload_0
    //   44: invokevirtual 98	java/io/FileInputStream:close	()V
    //   47: ldc 85
    //   49: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: ldc 58
    //   57: ldc 100
    //   59: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: goto -15 -> 47
    //   65: new 46	java/lang/String
    //   68: dup
    //   69: aload 5
    //   71: iconst_0
    //   72: iload_1
    //   73: invokespecial 103	java/lang/String:<init>	([BII)V
    //   76: astore 5
    //   78: aload 5
    //   80: aload_2
    //   81: invokevirtual 106	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   84: istore_1
    //   85: iload_1
    //   86: ifge +25 -> 111
    //   89: aload_0
    //   90: invokevirtual 98	java/io/FileInputStream:close	()V
    //   93: ldc 85
    //   95: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: ldc 58
    //   103: ldc 100
    //   105: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: goto -15 -> 93
    //   111: aload 5
    //   113: iload_1
    //   114: invokevirtual 110	java/lang/String:substring	(I)Ljava/lang/String;
    //   117: astore_2
    //   118: ldc 112
    //   120: invokestatic 118	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   123: aload_2
    //   124: invokevirtual 122	java/lang/String:getBytes	()[B
    //   127: invokevirtual 126	java/security/MessageDigest:digest	([B)[B
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +10 -> 142
    //   135: aload_2
    //   136: arraylength
    //   137: istore_1
    //   138: iload_1
    //   139: ifne +25 -> 164
    //   142: aload_0
    //   143: invokevirtual 98	java/io/FileInputStream:close	()V
    //   146: ldc 85
    //   148: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_0
    //   154: ldc 58
    //   156: ldc 100
    //   158: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: goto -15 -> 146
    //   164: new 60	java/lang/StringBuilder
    //   167: dup
    //   168: aload_2
    //   169: arraylength
    //   170: invokespecial 128	java/lang/StringBuilder:<init>	(I)V
    //   173: astore 5
    //   175: aload_2
    //   176: arraylength
    //   177: istore 4
    //   179: iload_3
    //   180: istore_1
    //   181: iload_1
    //   182: iload 4
    //   184: if_icmpge +46 -> 230
    //   187: aload_2
    //   188: iload_1
    //   189: baload
    //   190: sipush 255
    //   193: iand
    //   194: invokestatic 131	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   197: astore 6
    //   199: aload 6
    //   201: invokevirtual 135	java/lang/String:length	()I
    //   204: iconst_1
    //   205: if_icmpne +10 -> 215
    //   208: aload 5
    //   210: iconst_0
    //   211: invokevirtual 138	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 5
    //   217: aload 6
    //   219: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: iload_1
    //   224: iconst_1
    //   225: iadd
    //   226: istore_1
    //   227: goto -46 -> 181
    //   230: aload 5
    //   232: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokevirtual 141	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   238: astore_2
    //   239: aload_0
    //   240: invokevirtual 98	java/io/FileInputStream:close	()V
    //   243: ldc 85
    //   245: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_2
    //   249: areturn
    //   250: astore_0
    //   251: ldc 58
    //   253: ldc 100
    //   255: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: goto -15 -> 243
    //   261: astore_0
    //   262: aconst_null
    //   263: astore_0
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 98	java/io/FileInputStream:close	()V
    //   272: ldc 85
    //   274: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_0
    //   280: ldc 58
    //   282: ldc 100
    //   284: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: goto -15 -> 272
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_2
    //   293: aload_2
    //   294: ifnull +7 -> 301
    //   297: aload_2
    //   298: invokevirtual 98	java/io/FileInputStream:close	()V
    //   301: ldc 85
    //   303: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_0
    //   307: athrow
    //   308: astore_2
    //   309: ldc 58
    //   311: ldc 100
    //   313: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: goto -15 -> 301
    //   319: astore_2
    //   320: aload_0
    //   321: astore 5
    //   323: aload_2
    //   324: astore_0
    //   325: aload 5
    //   327: astore_2
    //   328: goto -35 -> 293
    //   331: astore_2
    //   332: goto -68 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	paramFile	File
    //   0	335	1	paramInt	int
    //   0	335	2	paramString	String
    //   1	179	3	i	int
    //   35	150	4	j	int
    //   10	316	5	localObject	Object
    //   197	21	6	str	String
    // Exception table:
    //   from	to	target	type
    //   43	47	54	java/lang/Exception
    //   89	93	100	java/lang/Exception
    //   142	146	153	java/lang/Exception
    //   239	243	250	java/lang/Exception
    //   7	21	261	java/lang/Exception
    //   268	272	279	java/lang/Exception
    //   7	21	290	finally
    //   297	301	308	java/lang/Exception
    //   21	37	319	finally
    //   65	85	319	finally
    //   111	131	319	finally
    //   135	138	319	finally
    //   164	179	319	finally
    //   187	215	319	finally
    //   215	223	319	finally
    //   230	239	319	finally
    //   21	37	331	java/lang/Exception
    //   65	85	331	java/lang/Exception
    //   111	131	331	java/lang/Exception
    //   135	138	331	java/lang/Exception
    //   164	179	331	java/lang/Exception
    //   187	215	331	java/lang/Exception
    //   215	223	331	java/lang/Exception
    //   230	239	331	java/lang/Exception
  }
  
  private static void a(com.tencent.xweb.internal.a.b paramb, Element paramElement)
  {
    AppMethodBeat.i(154543);
    paramb.MPM = a(paramElement, "apkMin");
    paramb.MPN = a(paramElement, "apkMax");
    paramb.MPO = a(paramElement, "preDownApkMin");
    paramb.MPP = a(paramElement, "preDownApkMax");
    paramb.MPK = a(paramElement, "sdkMin");
    paramb.MPL = a(paramElement, "sdkMax");
    paramb.MPQ = a(paramElement, "apiMin");
    paramb.MPR = a(paramElement, "apiMax");
    paramb.MPS = paramElement.getAttribute("forbidDeviceRegex");
    paramb.MPT = paramElement.getAttribute("whiteDeviceRegex");
    paramb.MQd = paramElement.getAttribute("forbidAppRegex");
    paramb.MQe = paramElement.getAttribute("whiteAppRegex");
    paramb.MPU = a(paramElement, "grayMin");
    paramb.MPV = a(paramElement, "grayMax");
    paramb.MPW = a(paramElement, "dayGrayMin");
    paramb.MPX = a(paramElement, "dayGrayMax");
    paramb.MPY = a(paramElement, "chromeMin");
    paramb.MPZ = a(paramElement, "chromeMax");
    paramb.MQa = a(paramElement, "usertype");
    paramb.MQf = a(paramElement, "x5sdkmin");
    paramb.MQg = a(paramElement, "x5sdkmax");
    paramb.MQh = a(paramElement, "x5coremin");
    paramb.MQi = a(paramElement, "x5coremax");
    paramb.MQb = c(paramElement, "hoursStart");
    paramb.MQc = c(paramElement, "hoursEnd");
    paramb.MQk = paramElement.getAttribute("runtimeAbis");
    paramb.MQm = paramElement.getAttribute("blackRuntimeAbis");
    paramb.MQj = paramElement.getAttribute("deviceAbis");
    paramb.MQl = paramElement.getAttribute("blackDeviceAbis");
    paramb.MQn = b(paramElement, "appClientVerMin");
    paramb.MQo = b(paramElement, "appClientVerMax");
    paramb.MQp = paramElement.getAttribute("appInfoWhiteList");
    paramb.MQq = paramElement.getAttribute("appInfoBlackList");
    AppMethodBeat.o(154543);
  }
  
  private static c[] a(Element paramElement)
  {
    AppMethodBeat.i(154541);
    paramElement = paramElement.getElementsByTagName("Patch");
    if ((paramElement != null) && (paramElement.getLength() != 0))
    {
      c[] arrayOfc = new c[paramElement.getLength()];
      int i = 0;
      while (i < paramElement.getLength())
      {
        c localc = new c();
        Element localElement = (Element)paramElement.item(i);
        localc.MVp = localElement.getAttribute("url");
        localc.MVF = a(localElement, "targetVersion");
        localc.MVw = localElement.getAttribute("md5");
        localc.MVx = e(localElement, "useCellular");
        localc.bUseCdn = e(localElement, "useCdn");
        arrayOfc[i] = localc;
        i += 1;
      }
      AppMethodBeat.o(154541);
      return arrayOfc;
    }
    AppMethodBeat.o(154541);
    return null;
  }
  
  private static int b(Element paramElement, String paramString)
  {
    AppMethodBeat.i(207614);
    if (paramElement == null)
    {
      AppMethodBeat.o(207614);
      return 0;
    }
    paramString = paramElement.getAttribute(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(207614);
      return 0;
    }
    paramElement = paramString;
    if (paramString.contains("0x")) {
      paramElement = paramString.trim().substring(2);
    }
    try
    {
      int i = Integer.parseInt(paramElement, 16);
      AppMethodBeat.o(207614);
      return i;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetIntFromHex failed" + paramElement.getMessage());
      AppMethodBeat.o(207614);
    }
    return 0;
  }
  
  private static com.tencent.xweb.internal.a.a[] b(Element paramElement)
  {
    AppMethodBeat.i(154542);
    if (paramElement == null)
    {
      AppMethodBeat.o(154542);
      return null;
    }
    try
    {
      paramElement = paramElement.getElementsByTagName("command");
      if ((paramElement != null) && (paramElement.getLength() != 0))
      {
        com.tencent.xweb.internal.a.a[] arrayOfa = new com.tencent.xweb.internal.a.a[paramElement.getLength()];
        int i = 0;
        while (i < paramElement.getLength())
        {
          com.tencent.xweb.internal.a.a locala = new com.tencent.xweb.internal.a.a();
          Element localElement = (Element)paramElement.item(i);
          locala.MPH = localElement.getAttribute("optype");
          locala.MPI = localElement.getAttribute("opvalue");
          locala.MPJ = localElement.getAttribute("module");
          a(locala.MPG, localElement);
          arrayOfa[i] = locala;
          i += 1;
        }
        AppMethodBeat.o(154542);
        return arrayOfa;
      }
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "parseCmds failed: " + paramElement.getMessage());
      AppMethodBeat.o(154542);
    }
    return null;
  }
  
  public static b bdf(String paramString)
  {
    AppMethodBeat.i(154536);
    if (paramString == null)
    {
      XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
      AppMethodBeat.o(154536);
      return null;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
      AppMethodBeat.o(154536);
      return null;
    }
    paramString = j(paramString, a(paramString, (int)paramString.length(), "<Versions>"));
    AppMethodBeat.o(154536);
    return paramString;
  }
  
  private static double c(Element paramElement, String paramString)
  {
    AppMethodBeat.i(154539);
    if (paramElement == null)
    {
      AppMethodBeat.o(154539);
      return -1.0D;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(154539);
      return -1.0D;
    }
    try
    {
      double d = Double.parseDouble(paramElement);
      AppMethodBeat.o(154539);
      return d;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetDouble failed : " + paramElement.getMessage());
      AppMethodBeat.o(154539);
    }
    return -1.0D;
  }
  
  private static float d(Element paramElement, String paramString)
  {
    AppMethodBeat.i(207615);
    if (paramElement == null)
    {
      AppMethodBeat.o(207615);
      return -1.0F;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(207615);
      return -1.0F;
    }
    try
    {
      float f = Float.parseFloat(paramElement);
      AppMethodBeat.o(207615);
      return f;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetFloat failed : " + paramElement.getMessage());
      AppMethodBeat.o(207615);
    }
    return -1.0F;
  }
  
  private static boolean e(Element paramElement, String paramString)
  {
    AppMethodBeat.i(154540);
    if (paramElement == null)
    {
      AppMethodBeat.o(154540);
      return false;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(154540);
      return false;
    }
    boolean bool = Boolean.parseBoolean(paramElement);
    AppMethodBeat.o(154540);
    return bool;
  }
  
  /* Error */
  private static b j(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 478
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 484	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   9: astore 5
    //   11: new 87	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_0
    //   24: new 9	com/tencent/xweb/xwalk/updater/a$b
    //   27: dup
    //   28: invokespecial 485	com/tencent/xweb/xwalk/updater/a$b:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 489	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 495	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 501 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 503
    //   63: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 98	java/io/FileInputStream:close	()V
    //   71: ldc_w 478
    //   74: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 58
    //   82: ldc_w 505
    //   85: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 507
    //   100: invokeinterface 44 2 0
    //   105: putfield 508	com/tencent/xweb/xwalk/updater/a$b:MVw	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: aload 5
    //   114: ldc_w 510
    //   117: invokeinterface 44 2 0
    //   122: putfield 512	com/tencent/xweb/xwalk/updater/a$b:signature	Ljava/lang/String;
    //   125: aload 4
    //   127: astore_0
    //   128: aload_3
    //   129: getfield 508	com/tencent/xweb/xwalk/updater/a$b:MVw	Ljava/lang/String;
    //   132: ifnull +17 -> 149
    //   135: aload 4
    //   137: astore_0
    //   138: aload_3
    //   139: getfield 508	com/tencent/xweb/xwalk/updater/a$b:MVw	Ljava/lang/String;
    //   142: aload_1
    //   143: invokevirtual 515	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifne +46 -> 192
    //   149: aload 4
    //   151: astore_0
    //   152: ldc2_w 516
    //   155: invokestatic 523	com/tencent/xweb/util/g:FJ	(J)V
    //   158: aload 4
    //   160: astore_0
    //   161: ldc_w 525
    //   164: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: invokevirtual 98	java/io/FileInputStream:close	()V
    //   172: ldc_w 478
    //   175: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: ldc 58
    //   183: ldc_w 505
    //   186: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -17 -> 172
    //   192: aload 4
    //   194: astore_0
    //   195: aload_3
    //   196: getfield 508	com/tencent/xweb/xwalk/updater/a$b:MVw	Ljava/lang/String;
    //   199: aload_3
    //   200: getfield 512	com/tencent/xweb/xwalk/updater/a$b:signature	Ljava/lang/String;
    //   203: ldc_w 527
    //   206: invokestatic 533	com/tencent/xweb/util/b:bo	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   209: ifne +46 -> 255
    //   212: aload 4
    //   214: astore_0
    //   215: ldc2_w 534
    //   218: invokestatic 523	com/tencent/xweb/util/g:FJ	(J)V
    //   221: aload 4
    //   223: astore_0
    //   224: ldc_w 537
    //   227: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   230: aload 4
    //   232: invokevirtual 98	java/io/FileInputStream:close	()V
    //   235: ldc_w 478
    //   238: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aconst_null
    //   242: areturn
    //   243: astore_0
    //   244: ldc 58
    //   246: ldc_w 505
    //   249: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: goto -17 -> 235
    //   255: aload 4
    //   257: astore_0
    //   258: aload_3
    //   259: aload 5
    //   261: ldc_w 539
    //   264: invokeinterface 44 2 0
    //   269: putfield 542	com/tencent/xweb/xwalk/updater/a$b:MVC	Ljava/lang/String;
    //   272: aload 4
    //   274: astore_0
    //   275: aload_3
    //   276: aload 5
    //   278: invokestatic 544	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/a$a;
    //   281: putfield 548	com/tencent/xweb/xwalk/updater/a$b:MVE	[Lcom/tencent/xweb/internal/a$a;
    //   284: aload 4
    //   286: astore_0
    //   287: aload 5
    //   289: ldc_w 550
    //   292: invokeinterface 328 2 0
    //   297: astore_1
    //   298: aload_1
    //   299: ifnull +524 -> 823
    //   302: aload 4
    //   304: astore_0
    //   305: aload_1
    //   306: invokeinterface 333 1 0
    //   311: ifeq +512 -> 823
    //   314: aload 4
    //   316: astore_0
    //   317: aload_3
    //   318: aload_1
    //   319: invokeinterface 333 1 0
    //   324: anewarray 21	com/tencent/xweb/xwalk/updater/a$f
    //   327: putfield 554	com/tencent/xweb/xwalk/updater/a$b:MVD	[Lcom/tencent/xweb/xwalk/updater/a$f;
    //   330: iconst_0
    //   331: istore_2
    //   332: aload 4
    //   334: astore_0
    //   335: iload_2
    //   336: aload_1
    //   337: invokeinterface 333 1 0
    //   342: if_icmpge +481 -> 823
    //   345: aload 4
    //   347: astore_0
    //   348: new 21	com/tencent/xweb/xwalk/updater/a$f
    //   351: dup
    //   352: invokespecial 555	com/tencent/xweb/xwalk/updater/a$f:<init>	()V
    //   355: astore 5
    //   357: aload 4
    //   359: astore_0
    //   360: aload_1
    //   361: iload_2
    //   362: invokeinterface 339 2 0
    //   367: checkcast 40	org/w3c/dom/Element
    //   370: astore 6
    //   372: aload 4
    //   374: astore_0
    //   375: aload 5
    //   377: aload 6
    //   379: ldc_w 557
    //   382: invokeinterface 44 2 0
    //   387: putfield 558	com/tencent/xweb/xwalk/updater/a$f:MVp	Ljava/lang/String;
    //   390: aload 4
    //   392: astore_0
    //   393: aload 5
    //   395: aload 6
    //   397: ldc_w 351
    //   400: invokeinterface 44 2 0
    //   405: putfield 559	com/tencent/xweb/xwalk/updater/a$f:MVw	Ljava/lang/String;
    //   408: aload 4
    //   410: astore_0
    //   411: aload 5
    //   413: getfield 560	com/tencent/xweb/xwalk/updater/a$f:MPG	Lcom/tencent/xweb/internal/a$b;
    //   416: aload 6
    //   418: invokestatic 411	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   421: aload 4
    //   423: astore_0
    //   424: aload 5
    //   426: aload 6
    //   428: ldc_w 562
    //   431: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   434: putfield 565	com/tencent/xweb/xwalk/updater/a$f:MVv	I
    //   437: aload 4
    //   439: astore_0
    //   440: aload 5
    //   442: aload 6
    //   444: ldc_w 567
    //   447: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   450: putfield 569	com/tencent/xweb/xwalk/updater/a$f:version	I
    //   453: aload 4
    //   455: astore_0
    //   456: aload 5
    //   458: aload 6
    //   460: ldc_w 356
    //   463: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   466: putfield 570	com/tencent/xweb/xwalk/updater/a$f:MVx	Z
    //   469: aload 4
    //   471: astore_0
    //   472: aload 5
    //   474: aload 6
    //   476: ldc_w 572
    //   479: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   482: putfield 575	com/tencent/xweb/xwalk/updater/a$f:MVy	Z
    //   485: aload 4
    //   487: astore_0
    //   488: aload 5
    //   490: aload 6
    //   492: ldc_w 365
    //   495: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   498: putfield 576	com/tencent/xweb/xwalk/updater/a$f:bUseCdn	Z
    //   501: aload 4
    //   503: astore_0
    //   504: aload 5
    //   506: aload 6
    //   508: ldc_w 578
    //   511: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   514: putfield 581	com/tencent/xweb/xwalk/updater/a$f:MVo	I
    //   517: aload 4
    //   519: astore_0
    //   520: aload 5
    //   522: aload 6
    //   524: ldc_w 583
    //   527: invokeinterface 44 2 0
    //   532: putfield 586	com/tencent/xweb/xwalk/updater/a$f:MVs	Ljava/lang/String;
    //   535: aload 4
    //   537: astore_0
    //   538: aload 5
    //   540: aload 6
    //   542: ldc_w 588
    //   545: invokeinterface 44 2 0
    //   550: putfield 591	com/tencent/xweb/xwalk/updater/a$f:MVt	Ljava/lang/String;
    //   553: aload 4
    //   555: astore_0
    //   556: aload 5
    //   558: aload 6
    //   560: ldc_w 593
    //   563: invokeinterface 44 2 0
    //   568: putfield 596	com/tencent/xweb/xwalk/updater/a$f:MVK	Ljava/lang/String;
    //   571: aload 4
    //   573: astore_0
    //   574: aload 5
    //   576: aload 6
    //   578: ldc_w 598
    //   581: invokeinterface 44 2 0
    //   586: putfield 601	com/tencent/xweb/xwalk/updater/a$f:MVz	Ljava/lang/String;
    //   589: aload 4
    //   591: astore_0
    //   592: aload 5
    //   594: aload 6
    //   596: ldc_w 603
    //   599: invokeinterface 44 2 0
    //   604: putfield 606	com/tencent/xweb/xwalk/updater/a$f:MVA	Ljava/lang/String;
    //   607: aload 4
    //   609: astore_0
    //   610: aload 5
    //   612: aload 6
    //   614: ldc_w 608
    //   617: invokeinterface 44 2 0
    //   622: putfield 611	com/tencent/xweb/xwalk/updater/a$f:MVB	Ljava/lang/String;
    //   625: aload 4
    //   627: astore_0
    //   628: aload 5
    //   630: aload 6
    //   632: ldc_w 613
    //   635: invokestatic 615	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   638: putfield 619	com/tencent/xweb/xwalk/updater/a$f:MVq	F
    //   641: aload 4
    //   643: astore_0
    //   644: aload 5
    //   646: aload 6
    //   648: ldc_w 621
    //   651: invokestatic 615	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   654: putfield 624	com/tencent/xweb/xwalk/updater/a$f:MVr	F
    //   657: aload 4
    //   659: astore_0
    //   660: aload 6
    //   662: ldc_w 626
    //   665: invokeinterface 44 2 0
    //   670: astore 7
    //   672: aload 7
    //   674: ifnull +27 -> 701
    //   677: aload 4
    //   679: astore_0
    //   680: aload 7
    //   682: invokevirtual 50	java/lang/String:isEmpty	()Z
    //   685: ifne +16 -> 701
    //   688: aload 4
    //   690: astore_0
    //   691: aload 5
    //   693: aload 7
    //   695: invokestatic 471	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   698: putfield 629	com/tencent/xweb/xwalk/updater/a$f:bTryUseSharedCore	Z
    //   701: aload 4
    //   703: astore_0
    //   704: aload 5
    //   706: aload 6
    //   708: ldc_w 631
    //   711: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   714: putfield 634	com/tencent/xweb/xwalk/updater/a$f:MVJ	Z
    //   717: aload 4
    //   719: astore_0
    //   720: aload 5
    //   722: getfield 638	com/tencent/xweb/xwalk/updater/a$f:MVI	Lcom/tencent/xweb/xwalk/updater/a$g;
    //   725: astore 7
    //   727: aload 7
    //   729: ifnull +63 -> 792
    //   732: aload 4
    //   734: astore_0
    //   735: aload 6
    //   737: ldc_w 640
    //   740: invokeinterface 328 2 0
    //   745: astore 8
    //   747: aload 8
    //   749: ifnull +43 -> 792
    //   752: aload 4
    //   754: astore_0
    //   755: aload 8
    //   757: invokeinterface 333 1 0
    //   762: ifeq +30 -> 792
    //   765: aload 4
    //   767: astore_0
    //   768: aload 7
    //   770: aload 8
    //   772: iconst_0
    //   773: invokeinterface 339 2 0
    //   778: checkcast 40	org/w3c/dom/Element
    //   781: ldc_w 642
    //   784: invokeinterface 44 2 0
    //   789: putfield 645	com/tencent/xweb/xwalk/updater/a$g:MVL	Ljava/lang/String;
    //   792: aload 4
    //   794: astore_0
    //   795: aload 5
    //   797: aload 6
    //   799: invokestatic 647	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   802: putfield 651	com/tencent/xweb/xwalk/updater/a$f:MVu	[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   805: aload 4
    //   807: astore_0
    //   808: aload_3
    //   809: getfield 554	com/tencent/xweb/xwalk/updater/a$b:MVD	[Lcom/tencent/xweb/xwalk/updater/a$f;
    //   812: iload_2
    //   813: aload 5
    //   815: aastore
    //   816: iload_2
    //   817: iconst_1
    //   818: iadd
    //   819: istore_2
    //   820: goto -488 -> 332
    //   823: aload 4
    //   825: invokevirtual 98	java/io/FileInputStream:close	()V
    //   828: aload_3
    //   829: astore_0
    //   830: ldc_w 478
    //   833: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   836: aload_0
    //   837: areturn
    //   838: astore_0
    //   839: ldc 58
    //   841: ldc_w 505
    //   844: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: aload_3
    //   848: astore_0
    //   849: goto -19 -> 830
    //   852: astore_0
    //   853: aconst_null
    //   854: astore 4
    //   856: aconst_null
    //   857: astore_1
    //   858: aload 4
    //   860: astore_0
    //   861: ldc_w 503
    //   864: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   867: aload_1
    //   868: astore_0
    //   869: aload 4
    //   871: ifnull -41 -> 830
    //   874: aload 4
    //   876: invokevirtual 98	java/io/FileInputStream:close	()V
    //   879: aload_1
    //   880: astore_0
    //   881: goto -51 -> 830
    //   884: astore_0
    //   885: ldc 58
    //   887: ldc_w 505
    //   890: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   893: aload_1
    //   894: astore_0
    //   895: goto -65 -> 830
    //   898: astore_0
    //   899: aconst_null
    //   900: astore 4
    //   902: aconst_null
    //   903: astore_1
    //   904: aload 4
    //   906: astore_0
    //   907: ldc_w 503
    //   910: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   913: aload_1
    //   914: astore_0
    //   915: aload 4
    //   917: ifnull -87 -> 830
    //   920: aload 4
    //   922: invokevirtual 98	java/io/FileInputStream:close	()V
    //   925: aload_1
    //   926: astore_0
    //   927: goto -97 -> 830
    //   930: astore_0
    //   931: ldc 58
    //   933: ldc_w 505
    //   936: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   939: aload_1
    //   940: astore_0
    //   941: goto -111 -> 830
    //   944: astore_0
    //   945: aconst_null
    //   946: astore 4
    //   948: aconst_null
    //   949: astore_1
    //   950: aload 4
    //   952: astore_0
    //   953: ldc_w 503
    //   956: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   959: aload_1
    //   960: astore_0
    //   961: aload 4
    //   963: ifnull -133 -> 830
    //   966: aload 4
    //   968: invokevirtual 98	java/io/FileInputStream:close	()V
    //   971: aload_1
    //   972: astore_0
    //   973: goto -143 -> 830
    //   976: astore_0
    //   977: ldc 58
    //   979: ldc_w 505
    //   982: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   985: aload_1
    //   986: astore_0
    //   987: goto -157 -> 830
    //   990: astore_1
    //   991: aconst_null
    //   992: astore_0
    //   993: aload_0
    //   994: ifnull +7 -> 1001
    //   997: aload_0
    //   998: invokevirtual 98	java/io/FileInputStream:close	()V
    //   1001: ldc_w 478
    //   1004: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1007: aload_1
    //   1008: athrow
    //   1009: astore_0
    //   1010: ldc 58
    //   1012: ldc_w 505
    //   1015: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1018: goto -17 -> 1001
    //   1021: astore_1
    //   1022: goto -29 -> 993
    //   1025: astore_0
    //   1026: aconst_null
    //   1027: astore_1
    //   1028: goto -78 -> 950
    //   1031: astore_0
    //   1032: aload_3
    //   1033: astore_1
    //   1034: goto -84 -> 950
    //   1037: astore_0
    //   1038: aconst_null
    //   1039: astore_1
    //   1040: goto -136 -> 904
    //   1043: astore_0
    //   1044: aload_3
    //   1045: astore_1
    //   1046: goto -142 -> 904
    //   1049: astore_0
    //   1050: aconst_null
    //   1051: astore_1
    //   1052: goto -194 -> 858
    //   1055: astore_0
    //   1056: aload_3
    //   1057: astore_1
    //   1058: goto -200 -> 858
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1061	0	paramFile	File
    //   0	1061	1	paramString	String
    //   331	489	2	i	int
    //   31	1026	3	localb	b
    //   19	948	4	localFileInputStream	java.io.FileInputStream
    //   9	805	5	localObject1	Object
    //   370	428	6	localElement	Element
    //   670	99	7	localObject2	Object
    //   745	26	8	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   66	71	79	java/lang/Exception
    //   167	172	180	java/lang/Exception
    //   230	235	243	java/lang/Exception
    //   823	828	838	java/lang/Exception
    //   11	21	852	javax/xml/parsers/ParserConfigurationException
    //   874	879	884	java/lang/Exception
    //   11	21	898	org/xml/sax/SAXException
    //   920	925	930	java/lang/Exception
    //   11	21	944	java/io/IOException
    //   966	971	976	java/lang/Exception
    //   11	21	990	finally
    //   997	1001	1009	java/lang/Exception
    //   24	32	1021	finally
    //   35	52	1021	finally
    //   60	66	1021	finally
    //   94	108	1021	finally
    //   111	125	1021	finally
    //   128	135	1021	finally
    //   138	149	1021	finally
    //   152	158	1021	finally
    //   161	167	1021	finally
    //   195	212	1021	finally
    //   215	221	1021	finally
    //   224	230	1021	finally
    //   258	272	1021	finally
    //   275	284	1021	finally
    //   287	298	1021	finally
    //   305	314	1021	finally
    //   317	330	1021	finally
    //   335	345	1021	finally
    //   348	357	1021	finally
    //   360	372	1021	finally
    //   375	390	1021	finally
    //   393	408	1021	finally
    //   411	421	1021	finally
    //   424	437	1021	finally
    //   440	453	1021	finally
    //   456	469	1021	finally
    //   472	485	1021	finally
    //   488	501	1021	finally
    //   504	517	1021	finally
    //   520	535	1021	finally
    //   538	553	1021	finally
    //   556	571	1021	finally
    //   574	589	1021	finally
    //   592	607	1021	finally
    //   610	625	1021	finally
    //   628	641	1021	finally
    //   644	657	1021	finally
    //   660	672	1021	finally
    //   680	688	1021	finally
    //   691	701	1021	finally
    //   704	717	1021	finally
    //   720	727	1021	finally
    //   735	747	1021	finally
    //   755	765	1021	finally
    //   768	792	1021	finally
    //   795	805	1021	finally
    //   808	816	1021	finally
    //   861	867	1021	finally
    //   907	913	1021	finally
    //   953	959	1021	finally
    //   24	32	1025	java/io/IOException
    //   35	52	1031	java/io/IOException
    //   60	66	1031	java/io/IOException
    //   94	108	1031	java/io/IOException
    //   111	125	1031	java/io/IOException
    //   128	135	1031	java/io/IOException
    //   138	149	1031	java/io/IOException
    //   152	158	1031	java/io/IOException
    //   161	167	1031	java/io/IOException
    //   195	212	1031	java/io/IOException
    //   215	221	1031	java/io/IOException
    //   224	230	1031	java/io/IOException
    //   258	272	1031	java/io/IOException
    //   275	284	1031	java/io/IOException
    //   287	298	1031	java/io/IOException
    //   305	314	1031	java/io/IOException
    //   317	330	1031	java/io/IOException
    //   335	345	1031	java/io/IOException
    //   348	357	1031	java/io/IOException
    //   360	372	1031	java/io/IOException
    //   375	390	1031	java/io/IOException
    //   393	408	1031	java/io/IOException
    //   411	421	1031	java/io/IOException
    //   424	437	1031	java/io/IOException
    //   440	453	1031	java/io/IOException
    //   456	469	1031	java/io/IOException
    //   472	485	1031	java/io/IOException
    //   488	501	1031	java/io/IOException
    //   504	517	1031	java/io/IOException
    //   520	535	1031	java/io/IOException
    //   538	553	1031	java/io/IOException
    //   556	571	1031	java/io/IOException
    //   574	589	1031	java/io/IOException
    //   592	607	1031	java/io/IOException
    //   610	625	1031	java/io/IOException
    //   628	641	1031	java/io/IOException
    //   644	657	1031	java/io/IOException
    //   660	672	1031	java/io/IOException
    //   680	688	1031	java/io/IOException
    //   691	701	1031	java/io/IOException
    //   704	717	1031	java/io/IOException
    //   720	727	1031	java/io/IOException
    //   735	747	1031	java/io/IOException
    //   755	765	1031	java/io/IOException
    //   768	792	1031	java/io/IOException
    //   795	805	1031	java/io/IOException
    //   808	816	1031	java/io/IOException
    //   24	32	1037	org/xml/sax/SAXException
    //   35	52	1043	org/xml/sax/SAXException
    //   60	66	1043	org/xml/sax/SAXException
    //   94	108	1043	org/xml/sax/SAXException
    //   111	125	1043	org/xml/sax/SAXException
    //   128	135	1043	org/xml/sax/SAXException
    //   138	149	1043	org/xml/sax/SAXException
    //   152	158	1043	org/xml/sax/SAXException
    //   161	167	1043	org/xml/sax/SAXException
    //   195	212	1043	org/xml/sax/SAXException
    //   215	221	1043	org/xml/sax/SAXException
    //   224	230	1043	org/xml/sax/SAXException
    //   258	272	1043	org/xml/sax/SAXException
    //   275	284	1043	org/xml/sax/SAXException
    //   287	298	1043	org/xml/sax/SAXException
    //   305	314	1043	org/xml/sax/SAXException
    //   317	330	1043	org/xml/sax/SAXException
    //   335	345	1043	org/xml/sax/SAXException
    //   348	357	1043	org/xml/sax/SAXException
    //   360	372	1043	org/xml/sax/SAXException
    //   375	390	1043	org/xml/sax/SAXException
    //   393	408	1043	org/xml/sax/SAXException
    //   411	421	1043	org/xml/sax/SAXException
    //   424	437	1043	org/xml/sax/SAXException
    //   440	453	1043	org/xml/sax/SAXException
    //   456	469	1043	org/xml/sax/SAXException
    //   472	485	1043	org/xml/sax/SAXException
    //   488	501	1043	org/xml/sax/SAXException
    //   504	517	1043	org/xml/sax/SAXException
    //   520	535	1043	org/xml/sax/SAXException
    //   538	553	1043	org/xml/sax/SAXException
    //   556	571	1043	org/xml/sax/SAXException
    //   574	589	1043	org/xml/sax/SAXException
    //   592	607	1043	org/xml/sax/SAXException
    //   610	625	1043	org/xml/sax/SAXException
    //   628	641	1043	org/xml/sax/SAXException
    //   644	657	1043	org/xml/sax/SAXException
    //   660	672	1043	org/xml/sax/SAXException
    //   680	688	1043	org/xml/sax/SAXException
    //   691	701	1043	org/xml/sax/SAXException
    //   704	717	1043	org/xml/sax/SAXException
    //   720	727	1043	org/xml/sax/SAXException
    //   735	747	1043	org/xml/sax/SAXException
    //   755	765	1043	org/xml/sax/SAXException
    //   768	792	1043	org/xml/sax/SAXException
    //   795	805	1043	org/xml/sax/SAXException
    //   808	816	1043	org/xml/sax/SAXException
    //   24	32	1049	javax/xml/parsers/ParserConfigurationException
    //   35	52	1055	javax/xml/parsers/ParserConfigurationException
    //   60	66	1055	javax/xml/parsers/ParserConfigurationException
    //   94	108	1055	javax/xml/parsers/ParserConfigurationException
    //   111	125	1055	javax/xml/parsers/ParserConfigurationException
    //   128	135	1055	javax/xml/parsers/ParserConfigurationException
    //   138	149	1055	javax/xml/parsers/ParserConfigurationException
    //   152	158	1055	javax/xml/parsers/ParserConfigurationException
    //   161	167	1055	javax/xml/parsers/ParserConfigurationException
    //   195	212	1055	javax/xml/parsers/ParserConfigurationException
    //   215	221	1055	javax/xml/parsers/ParserConfigurationException
    //   224	230	1055	javax/xml/parsers/ParserConfigurationException
    //   258	272	1055	javax/xml/parsers/ParserConfigurationException
    //   275	284	1055	javax/xml/parsers/ParserConfigurationException
    //   287	298	1055	javax/xml/parsers/ParserConfigurationException
    //   305	314	1055	javax/xml/parsers/ParserConfigurationException
    //   317	330	1055	javax/xml/parsers/ParserConfigurationException
    //   335	345	1055	javax/xml/parsers/ParserConfigurationException
    //   348	357	1055	javax/xml/parsers/ParserConfigurationException
    //   360	372	1055	javax/xml/parsers/ParserConfigurationException
    //   375	390	1055	javax/xml/parsers/ParserConfigurationException
    //   393	408	1055	javax/xml/parsers/ParserConfigurationException
    //   411	421	1055	javax/xml/parsers/ParserConfigurationException
    //   424	437	1055	javax/xml/parsers/ParserConfigurationException
    //   440	453	1055	javax/xml/parsers/ParserConfigurationException
    //   456	469	1055	javax/xml/parsers/ParserConfigurationException
    //   472	485	1055	javax/xml/parsers/ParserConfigurationException
    //   488	501	1055	javax/xml/parsers/ParserConfigurationException
    //   504	517	1055	javax/xml/parsers/ParserConfigurationException
    //   520	535	1055	javax/xml/parsers/ParserConfigurationException
    //   538	553	1055	javax/xml/parsers/ParserConfigurationException
    //   556	571	1055	javax/xml/parsers/ParserConfigurationException
    //   574	589	1055	javax/xml/parsers/ParserConfigurationException
    //   592	607	1055	javax/xml/parsers/ParserConfigurationException
    //   610	625	1055	javax/xml/parsers/ParserConfigurationException
    //   628	641	1055	javax/xml/parsers/ParserConfigurationException
    //   644	657	1055	javax/xml/parsers/ParserConfigurationException
    //   660	672	1055	javax/xml/parsers/ParserConfigurationException
    //   680	688	1055	javax/xml/parsers/ParserConfigurationException
    //   691	701	1055	javax/xml/parsers/ParserConfigurationException
    //   704	717	1055	javax/xml/parsers/ParserConfigurationException
    //   720	727	1055	javax/xml/parsers/ParserConfigurationException
    //   735	747	1055	javax/xml/parsers/ParserConfigurationException
    //   755	765	1055	javax/xml/parsers/ParserConfigurationException
    //   768	792	1055	javax/xml/parsers/ParserConfigurationException
    //   795	805	1055	javax/xml/parsers/ParserConfigurationException
    //   808	816	1055	javax/xml/parsers/ParserConfigurationException
  }
  
  /* Error */
  public static d k(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 654
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 484	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   9: astore 5
    //   11: new 87	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_0
    //   24: new 15	com/tencent/xweb/xwalk/updater/a$d
    //   27: dup
    //   28: invokespecial 655	com/tencent/xweb/xwalk/updater/a$d:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 489	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 495	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 501 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 657
    //   63: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 98	java/io/FileInputStream:close	()V
    //   71: ldc_w 654
    //   74: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 58
    //   82: ldc_w 659
    //   85: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 507
    //   100: invokeinterface 44 2 0
    //   105: putfield 660	com/tencent/xweb/xwalk/updater/a$d:MVw	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: aload 5
    //   114: ldc_w 510
    //   117: invokeinterface 44 2 0
    //   122: putfield 661	com/tencent/xweb/xwalk/updater/a$d:signature	Ljava/lang/String;
    //   125: aload 4
    //   127: astore_0
    //   128: aload_3
    //   129: getfield 660	com/tencent/xweb/xwalk/updater/a$d:MVw	Ljava/lang/String;
    //   132: ifnull +17 -> 149
    //   135: aload 4
    //   137: astore_0
    //   138: aload_3
    //   139: getfield 660	com/tencent/xweb/xwalk/updater/a$d:MVw	Ljava/lang/String;
    //   142: aload_1
    //   143: invokevirtual 515	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifne +37 -> 183
    //   149: aload 4
    //   151: astore_0
    //   152: ldc_w 663
    //   155: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 98	java/io/FileInputStream:close	()V
    //   163: ldc_w 654
    //   166: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: ldc 58
    //   174: ldc_w 659
    //   177: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto -17 -> 163
    //   183: aload 4
    //   185: astore_0
    //   186: aload_3
    //   187: getfield 660	com/tencent/xweb/xwalk/updater/a$d:MVw	Ljava/lang/String;
    //   190: aload_3
    //   191: getfield 661	com/tencent/xweb/xwalk/updater/a$d:signature	Ljava/lang/String;
    //   194: ldc_w 527
    //   197: invokestatic 533	com/tencent/xweb/util/b:bo	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   200: ifne +46 -> 246
    //   203: aload 4
    //   205: astore_0
    //   206: ldc2_w 534
    //   209: invokestatic 523	com/tencent/xweb/util/g:FJ	(J)V
    //   212: aload 4
    //   214: astore_0
    //   215: ldc_w 665
    //   218: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   221: aload 4
    //   223: invokevirtual 98	java/io/FileInputStream:close	()V
    //   226: ldc_w 654
    //   229: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: ldc 58
    //   237: ldc_w 659
    //   240: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -17 -> 226
    //   246: aload 4
    //   248: astore_0
    //   249: aload_3
    //   250: aload 5
    //   252: ldc_w 539
    //   255: invokeinterface 44 2 0
    //   260: putfield 666	com/tencent/xweb/xwalk/updater/a$d:MVC	Ljava/lang/String;
    //   263: aload 4
    //   265: astore_0
    //   266: aload_3
    //   267: aload 5
    //   269: invokestatic 544	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/a$a;
    //   272: putfield 667	com/tencent/xweb/xwalk/updater/a$d:MVE	[Lcom/tencent/xweb/internal/a$a;
    //   275: aload 4
    //   277: astore_0
    //   278: aload 5
    //   280: ldc_w 669
    //   283: invokeinterface 328 2 0
    //   288: astore_1
    //   289: aload_1
    //   290: ifnull +389 -> 679
    //   293: aload 4
    //   295: astore_0
    //   296: aload_1
    //   297: invokeinterface 333 1 0
    //   302: ifeq +377 -> 679
    //   305: aload 4
    //   307: astore_0
    //   308: aload_3
    //   309: aload_1
    //   310: invokeinterface 333 1 0
    //   315: anewarray 18	com/tencent/xweb/xwalk/updater/a$e
    //   318: putfield 673	com/tencent/xweb/xwalk/updater/a$d:MVG	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   321: iconst_0
    //   322: istore_2
    //   323: aload 4
    //   325: astore_0
    //   326: iload_2
    //   327: aload_1
    //   328: invokeinterface 333 1 0
    //   333: if_icmpge +346 -> 679
    //   336: aload 4
    //   338: astore_0
    //   339: aload_1
    //   340: iload_2
    //   341: invokeinterface 339 2 0
    //   346: checkcast 40	org/w3c/dom/Element
    //   349: astore 5
    //   351: aload 4
    //   353: astore_0
    //   354: new 18	com/tencent/xweb/xwalk/updater/a$e
    //   357: dup
    //   358: invokespecial 674	com/tencent/xweb/xwalk/updater/a$e:<init>	()V
    //   361: astore 6
    //   363: aload 4
    //   365: astore_0
    //   366: aload 6
    //   368: aload 5
    //   370: ldc_w 676
    //   373: invokeinterface 44 2 0
    //   378: putfield 679	com/tencent/xweb/xwalk/updater/a$e:MVH	Ljava/lang/String;
    //   381: aload 4
    //   383: astore_0
    //   384: aload 6
    //   386: aload 5
    //   388: ldc_w 567
    //   391: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   394: putfield 680	com/tencent/xweb/xwalk/updater/a$e:version	I
    //   397: aload 4
    //   399: astore_0
    //   400: aload 6
    //   402: aload 5
    //   404: ldc_w 557
    //   407: invokeinterface 44 2 0
    //   412: putfield 681	com/tencent/xweb/xwalk/updater/a$e:MVp	Ljava/lang/String;
    //   415: aload 4
    //   417: astore_0
    //   418: aload 6
    //   420: aload 5
    //   422: ldc_w 351
    //   425: invokeinterface 44 2 0
    //   430: putfield 682	com/tencent/xweb/xwalk/updater/a$e:MVw	Ljava/lang/String;
    //   433: aload 4
    //   435: astore_0
    //   436: aload 6
    //   438: aload 5
    //   440: ldc_w 356
    //   443: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   446: putfield 683	com/tencent/xweb/xwalk/updater/a$e:MVx	Z
    //   449: aload 4
    //   451: astore_0
    //   452: aload 6
    //   454: aload 5
    //   456: ldc_w 572
    //   459: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   462: putfield 684	com/tencent/xweb/xwalk/updater/a$e:MVy	Z
    //   465: aload 4
    //   467: astore_0
    //   468: aload 6
    //   470: aload 5
    //   472: ldc_w 365
    //   475: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   478: putfield 685	com/tencent/xweb/xwalk/updater/a$e:bUseCdn	Z
    //   481: aload 4
    //   483: astore_0
    //   484: aload 6
    //   486: aload 5
    //   488: ldc_w 562
    //   491: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   494: putfield 686	com/tencent/xweb/xwalk/updater/a$e:MVv	I
    //   497: aload 4
    //   499: astore_0
    //   500: aload 6
    //   502: aload 5
    //   504: ldc_w 578
    //   507: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   510: putfield 687	com/tencent/xweb/xwalk/updater/a$e:MVo	I
    //   513: aload 4
    //   515: astore_0
    //   516: aload 6
    //   518: aload 5
    //   520: ldc_w 583
    //   523: invokeinterface 44 2 0
    //   528: putfield 688	com/tencent/xweb/xwalk/updater/a$e:MVs	Ljava/lang/String;
    //   531: aload 4
    //   533: astore_0
    //   534: aload 6
    //   536: aload 5
    //   538: ldc_w 588
    //   541: invokeinterface 44 2 0
    //   546: putfield 689	com/tencent/xweb/xwalk/updater/a$e:MVt	Ljava/lang/String;
    //   549: aload 4
    //   551: astore_0
    //   552: aload 6
    //   554: aload 5
    //   556: ldc_w 598
    //   559: invokeinterface 44 2 0
    //   564: putfield 690	com/tencent/xweb/xwalk/updater/a$e:MVz	Ljava/lang/String;
    //   567: aload 4
    //   569: astore_0
    //   570: aload 6
    //   572: aload 5
    //   574: ldc_w 603
    //   577: invokeinterface 44 2 0
    //   582: putfield 691	com/tencent/xweb/xwalk/updater/a$e:MVA	Ljava/lang/String;
    //   585: aload 4
    //   587: astore_0
    //   588: aload 6
    //   590: aload 5
    //   592: ldc_w 608
    //   595: invokeinterface 44 2 0
    //   600: putfield 692	com/tencent/xweb/xwalk/updater/a$e:MVB	Ljava/lang/String;
    //   603: aload 4
    //   605: astore_0
    //   606: aload 6
    //   608: aload 5
    //   610: ldc_w 613
    //   613: invokestatic 615	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   616: putfield 693	com/tencent/xweb/xwalk/updater/a$e:MVq	F
    //   619: aload 4
    //   621: astore_0
    //   622: aload 6
    //   624: aload 5
    //   626: ldc_w 621
    //   629: invokestatic 615	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   632: putfield 694	com/tencent/xweb/xwalk/updater/a$e:MVr	F
    //   635: aload 4
    //   637: astore_0
    //   638: aload 6
    //   640: getfield 695	com/tencent/xweb/xwalk/updater/a$e:MPG	Lcom/tencent/xweb/internal/a$b;
    //   643: aload 5
    //   645: invokestatic 411	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   648: aload 4
    //   650: astore_0
    //   651: aload 6
    //   653: aload 5
    //   655: invokestatic 647	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   658: putfield 696	com/tencent/xweb/xwalk/updater/a$e:MVu	[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   661: aload 4
    //   663: astore_0
    //   664: aload_3
    //   665: getfield 673	com/tencent/xweb/xwalk/updater/a$d:MVG	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   668: iload_2
    //   669: aload 6
    //   671: aastore
    //   672: iload_2
    //   673: iconst_1
    //   674: iadd
    //   675: istore_2
    //   676: goto -353 -> 323
    //   679: aload 4
    //   681: invokevirtual 98	java/io/FileInputStream:close	()V
    //   684: aload_3
    //   685: astore_0
    //   686: ldc_w 654
    //   689: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   692: aload_0
    //   693: areturn
    //   694: astore_0
    //   695: ldc 58
    //   697: ldc_w 659
    //   700: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   703: aload_3
    //   704: astore_0
    //   705: goto -19 -> 686
    //   708: astore_0
    //   709: aconst_null
    //   710: astore 4
    //   712: aconst_null
    //   713: astore_1
    //   714: aload 4
    //   716: astore_0
    //   717: ldc_w 698
    //   720: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   723: aload_1
    //   724: astore_0
    //   725: aload 4
    //   727: ifnull -41 -> 686
    //   730: aload 4
    //   732: invokevirtual 98	java/io/FileInputStream:close	()V
    //   735: aload_1
    //   736: astore_0
    //   737: goto -51 -> 686
    //   740: astore_0
    //   741: ldc 58
    //   743: ldc_w 659
    //   746: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   749: aload_1
    //   750: astore_0
    //   751: goto -65 -> 686
    //   754: astore_0
    //   755: aconst_null
    //   756: astore 4
    //   758: aconst_null
    //   759: astore_1
    //   760: aload 4
    //   762: astore_0
    //   763: ldc_w 700
    //   766: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   769: aload_1
    //   770: astore_0
    //   771: aload 4
    //   773: ifnull -87 -> 686
    //   776: aload 4
    //   778: invokevirtual 98	java/io/FileInputStream:close	()V
    //   781: aload_1
    //   782: astore_0
    //   783: goto -97 -> 686
    //   786: astore_0
    //   787: ldc 58
    //   789: ldc_w 659
    //   792: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   795: aload_1
    //   796: astore_0
    //   797: goto -111 -> 686
    //   800: astore_0
    //   801: aconst_null
    //   802: astore 4
    //   804: aconst_null
    //   805: astore_1
    //   806: aload 4
    //   808: astore_0
    //   809: ldc_w 702
    //   812: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   815: aload_1
    //   816: astore_0
    //   817: aload 4
    //   819: ifnull -133 -> 686
    //   822: aload 4
    //   824: invokevirtual 98	java/io/FileInputStream:close	()V
    //   827: aload_1
    //   828: astore_0
    //   829: goto -143 -> 686
    //   832: astore_0
    //   833: ldc 58
    //   835: ldc_w 659
    //   838: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   841: aload_1
    //   842: astore_0
    //   843: goto -157 -> 686
    //   846: astore_1
    //   847: aconst_null
    //   848: astore_0
    //   849: aload_0
    //   850: ifnull +7 -> 857
    //   853: aload_0
    //   854: invokevirtual 98	java/io/FileInputStream:close	()V
    //   857: ldc_w 654
    //   860: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   863: aload_1
    //   864: athrow
    //   865: astore_0
    //   866: ldc 58
    //   868: ldc_w 659
    //   871: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   874: goto -17 -> 857
    //   877: astore_1
    //   878: goto -29 -> 849
    //   881: astore_0
    //   882: aconst_null
    //   883: astore_1
    //   884: goto -78 -> 806
    //   887: astore_0
    //   888: aload_3
    //   889: astore_1
    //   890: goto -84 -> 806
    //   893: astore_0
    //   894: aconst_null
    //   895: astore_1
    //   896: goto -136 -> 760
    //   899: astore_0
    //   900: aload_3
    //   901: astore_1
    //   902: goto -142 -> 760
    //   905: astore_0
    //   906: aconst_null
    //   907: astore_1
    //   908: goto -194 -> 714
    //   911: astore_0
    //   912: aload_3
    //   913: astore_1
    //   914: goto -200 -> 714
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	917	0	paramFile	File
    //   0	917	1	paramString	String
    //   322	354	2	i	int
    //   31	882	3	locald	d
    //   19	804	4	localFileInputStream	java.io.FileInputStream
    //   9	645	5	localObject	Object
    //   361	309	6	locale	e
    // Exception table:
    //   from	to	target	type
    //   66	71	79	java/lang/Exception
    //   158	163	171	java/lang/Exception
    //   221	226	234	java/lang/Exception
    //   679	684	694	java/lang/Exception
    //   11	21	708	javax/xml/parsers/ParserConfigurationException
    //   730	735	740	java/lang/Exception
    //   11	21	754	org/xml/sax/SAXException
    //   776	781	786	java/lang/Exception
    //   11	21	800	java/io/IOException
    //   822	827	832	java/lang/Exception
    //   11	21	846	finally
    //   853	857	865	java/lang/Exception
    //   24	32	877	finally
    //   35	52	877	finally
    //   60	66	877	finally
    //   94	108	877	finally
    //   111	125	877	finally
    //   128	135	877	finally
    //   138	149	877	finally
    //   152	158	877	finally
    //   186	203	877	finally
    //   206	212	877	finally
    //   215	221	877	finally
    //   249	263	877	finally
    //   266	275	877	finally
    //   278	289	877	finally
    //   296	305	877	finally
    //   308	321	877	finally
    //   326	336	877	finally
    //   339	351	877	finally
    //   354	363	877	finally
    //   366	381	877	finally
    //   384	397	877	finally
    //   400	415	877	finally
    //   418	433	877	finally
    //   436	449	877	finally
    //   452	465	877	finally
    //   468	481	877	finally
    //   484	497	877	finally
    //   500	513	877	finally
    //   516	531	877	finally
    //   534	549	877	finally
    //   552	567	877	finally
    //   570	585	877	finally
    //   588	603	877	finally
    //   606	619	877	finally
    //   622	635	877	finally
    //   638	648	877	finally
    //   651	661	877	finally
    //   664	672	877	finally
    //   717	723	877	finally
    //   763	769	877	finally
    //   809	815	877	finally
    //   24	32	881	java/io/IOException
    //   35	52	887	java/io/IOException
    //   60	66	887	java/io/IOException
    //   94	108	887	java/io/IOException
    //   111	125	887	java/io/IOException
    //   128	135	887	java/io/IOException
    //   138	149	887	java/io/IOException
    //   152	158	887	java/io/IOException
    //   186	203	887	java/io/IOException
    //   206	212	887	java/io/IOException
    //   215	221	887	java/io/IOException
    //   249	263	887	java/io/IOException
    //   266	275	887	java/io/IOException
    //   278	289	887	java/io/IOException
    //   296	305	887	java/io/IOException
    //   308	321	887	java/io/IOException
    //   326	336	887	java/io/IOException
    //   339	351	887	java/io/IOException
    //   354	363	887	java/io/IOException
    //   366	381	887	java/io/IOException
    //   384	397	887	java/io/IOException
    //   400	415	887	java/io/IOException
    //   418	433	887	java/io/IOException
    //   436	449	887	java/io/IOException
    //   452	465	887	java/io/IOException
    //   468	481	887	java/io/IOException
    //   484	497	887	java/io/IOException
    //   500	513	887	java/io/IOException
    //   516	531	887	java/io/IOException
    //   534	549	887	java/io/IOException
    //   552	567	887	java/io/IOException
    //   570	585	887	java/io/IOException
    //   588	603	887	java/io/IOException
    //   606	619	887	java/io/IOException
    //   622	635	887	java/io/IOException
    //   638	648	887	java/io/IOException
    //   651	661	887	java/io/IOException
    //   664	672	887	java/io/IOException
    //   24	32	893	org/xml/sax/SAXException
    //   35	52	899	org/xml/sax/SAXException
    //   60	66	899	org/xml/sax/SAXException
    //   94	108	899	org/xml/sax/SAXException
    //   111	125	899	org/xml/sax/SAXException
    //   128	135	899	org/xml/sax/SAXException
    //   138	149	899	org/xml/sax/SAXException
    //   152	158	899	org/xml/sax/SAXException
    //   186	203	899	org/xml/sax/SAXException
    //   206	212	899	org/xml/sax/SAXException
    //   215	221	899	org/xml/sax/SAXException
    //   249	263	899	org/xml/sax/SAXException
    //   266	275	899	org/xml/sax/SAXException
    //   278	289	899	org/xml/sax/SAXException
    //   296	305	899	org/xml/sax/SAXException
    //   308	321	899	org/xml/sax/SAXException
    //   326	336	899	org/xml/sax/SAXException
    //   339	351	899	org/xml/sax/SAXException
    //   354	363	899	org/xml/sax/SAXException
    //   366	381	899	org/xml/sax/SAXException
    //   384	397	899	org/xml/sax/SAXException
    //   400	415	899	org/xml/sax/SAXException
    //   418	433	899	org/xml/sax/SAXException
    //   436	449	899	org/xml/sax/SAXException
    //   452	465	899	org/xml/sax/SAXException
    //   468	481	899	org/xml/sax/SAXException
    //   484	497	899	org/xml/sax/SAXException
    //   500	513	899	org/xml/sax/SAXException
    //   516	531	899	org/xml/sax/SAXException
    //   534	549	899	org/xml/sax/SAXException
    //   552	567	899	org/xml/sax/SAXException
    //   570	585	899	org/xml/sax/SAXException
    //   588	603	899	org/xml/sax/SAXException
    //   606	619	899	org/xml/sax/SAXException
    //   622	635	899	org/xml/sax/SAXException
    //   638	648	899	org/xml/sax/SAXException
    //   651	661	899	org/xml/sax/SAXException
    //   664	672	899	org/xml/sax/SAXException
    //   24	32	905	javax/xml/parsers/ParserConfigurationException
    //   35	52	911	javax/xml/parsers/ParserConfigurationException
    //   60	66	911	javax/xml/parsers/ParserConfigurationException
    //   94	108	911	javax/xml/parsers/ParserConfigurationException
    //   111	125	911	javax/xml/parsers/ParserConfigurationException
    //   128	135	911	javax/xml/parsers/ParserConfigurationException
    //   138	149	911	javax/xml/parsers/ParserConfigurationException
    //   152	158	911	javax/xml/parsers/ParserConfigurationException
    //   186	203	911	javax/xml/parsers/ParserConfigurationException
    //   206	212	911	javax/xml/parsers/ParserConfigurationException
    //   215	221	911	javax/xml/parsers/ParserConfigurationException
    //   249	263	911	javax/xml/parsers/ParserConfigurationException
    //   266	275	911	javax/xml/parsers/ParserConfigurationException
    //   278	289	911	javax/xml/parsers/ParserConfigurationException
    //   296	305	911	javax/xml/parsers/ParserConfigurationException
    //   308	321	911	javax/xml/parsers/ParserConfigurationException
    //   326	336	911	javax/xml/parsers/ParserConfigurationException
    //   339	351	911	javax/xml/parsers/ParserConfigurationException
    //   354	363	911	javax/xml/parsers/ParserConfigurationException
    //   366	381	911	javax/xml/parsers/ParserConfigurationException
    //   384	397	911	javax/xml/parsers/ParserConfigurationException
    //   400	415	911	javax/xml/parsers/ParserConfigurationException
    //   418	433	911	javax/xml/parsers/ParserConfigurationException
    //   436	449	911	javax/xml/parsers/ParserConfigurationException
    //   452	465	911	javax/xml/parsers/ParserConfigurationException
    //   468	481	911	javax/xml/parsers/ParserConfigurationException
    //   484	497	911	javax/xml/parsers/ParserConfigurationException
    //   500	513	911	javax/xml/parsers/ParserConfigurationException
    //   516	531	911	javax/xml/parsers/ParserConfigurationException
    //   534	549	911	javax/xml/parsers/ParserConfigurationException
    //   552	567	911	javax/xml/parsers/ParserConfigurationException
    //   570	585	911	javax/xml/parsers/ParserConfigurationException
    //   588	603	911	javax/xml/parsers/ParserConfigurationException
    //   606	619	911	javax/xml/parsers/ParserConfigurationException
    //   622	635	911	javax/xml/parsers/ParserConfigurationException
    //   638	648	911	javax/xml/parsers/ParserConfigurationException
    //   651	661	911	javax/xml/parsers/ParserConfigurationException
    //   664	672	911	javax/xml/parsers/ParserConfigurationException
  }
  
  public static class a
  {
    public com.tencent.xweb.internal.a.b MPG;
    public String MVA;
    public String MVB;
    public int MVo;
    public String MVp;
    public float MVq;
    public float MVr;
    public String MVs;
    public String MVt;
    public a.c[] MVu;
    public int MVv;
    public String MVw;
    public boolean MVx;
    public boolean MVy;
    public String MVz;
    public boolean bUseCdn;
    public int version;
    
    public a()
    {
      AppMethodBeat.i(207613);
      this.MPG = new com.tencent.xweb.internal.a.c();
      this.MVq = -1.0F;
      this.MVr = -1.0F;
      AppMethodBeat.o(207613);
    }
  }
  
  public static final class b
  {
    public String MVC;
    public a.f[] MVD;
    public com.tencent.xweb.internal.a.a[] MVE;
    public String MVw;
    public String signature;
  }
  
  public static final class c
  {
    public int MVF;
    public String MVp;
    public String MVw;
    public boolean MVx;
    public boolean bUseCdn;
  }
  
  public static final class d
  {
    public String MVC = "";
    public com.tencent.xweb.internal.a.a[] MVE;
    public a.e[] MVG = null;
    public String MVw = "";
    public String signature;
  }
  
  public static final class e
    extends a.a
  {
    public String MVH;
    
    public e()
    {
      AppMethodBeat.i(154534);
      this.MVH = "";
      AppMethodBeat.o(154534);
    }
  }
  
  public static final class f
    extends a.a
  {
    public a.g MVI;
    public boolean MVJ;
    public String MVK;
    public boolean bTryUseSharedCore;
    
    public f()
    {
      AppMethodBeat.i(154535);
      this.MVI = new a.g();
      this.bTryUseSharedCore = true;
      AppMethodBeat.o(154535);
    }
  }
  
  public static final class g
  {
    public String MVL = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.a
 * JD-Core Version:    0.7.0.1
 */