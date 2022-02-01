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
    //   2: ldc 82
    //   4: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: newarray byte
    //   10: astore 5
    //   12: new 84	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_0
    //   21: aload_0
    //   22: aload 5
    //   24: iconst_0
    //   25: aload 5
    //   27: arraylength
    //   28: invokevirtual 91	java/io/FileInputStream:read	([BII)I
    //   31: istore_1
    //   32: aload 5
    //   34: arraylength
    //   35: istore 4
    //   37: iload_1
    //   38: iload 4
    //   40: if_icmpeq +25 -> 65
    //   43: aload_0
    //   44: invokevirtual 95	java/io/FileInputStream:close	()V
    //   47: ldc 82
    //   49: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: ldc 55
    //   57: ldc 97
    //   59: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: goto -15 -> 47
    //   65: new 43	java/lang/String
    //   68: dup
    //   69: aload 5
    //   71: iconst_0
    //   72: iload_1
    //   73: invokespecial 100	java/lang/String:<init>	([BII)V
    //   76: astore 5
    //   78: aload 5
    //   80: aload_2
    //   81: invokevirtual 103	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   84: istore_1
    //   85: iload_1
    //   86: ifge +25 -> 111
    //   89: aload_0
    //   90: invokevirtual 95	java/io/FileInputStream:close	()V
    //   93: ldc 82
    //   95: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: ldc 55
    //   103: ldc 97
    //   105: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: goto -15 -> 93
    //   111: aload 5
    //   113: iload_1
    //   114: invokevirtual 107	java/lang/String:substring	(I)Ljava/lang/String;
    //   117: astore_2
    //   118: ldc 109
    //   120: invokestatic 115	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   123: aload_2
    //   124: invokevirtual 119	java/lang/String:getBytes	()[B
    //   127: invokevirtual 123	java/security/MessageDigest:digest	([B)[B
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +10 -> 142
    //   135: aload_2
    //   136: arraylength
    //   137: istore_1
    //   138: iload_1
    //   139: ifne +25 -> 164
    //   142: aload_0
    //   143: invokevirtual 95	java/io/FileInputStream:close	()V
    //   146: ldc 82
    //   148: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_0
    //   154: ldc 55
    //   156: ldc 97
    //   158: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: goto -15 -> 146
    //   164: new 57	java/lang/StringBuilder
    //   167: dup
    //   168: aload_2
    //   169: arraylength
    //   170: invokespecial 125	java/lang/StringBuilder:<init>	(I)V
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
    //   194: invokestatic 128	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   197: astore 6
    //   199: aload 6
    //   201: invokevirtual 132	java/lang/String:length	()I
    //   204: iconst_1
    //   205: if_icmpne +10 -> 215
    //   208: aload 5
    //   210: iconst_0
    //   211: invokevirtual 135	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 5
    //   217: aload 6
    //   219: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: iload_1
    //   224: iconst_1
    //   225: iadd
    //   226: istore_1
    //   227: goto -46 -> 181
    //   230: aload 5
    //   232: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokevirtual 138	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   238: astore_2
    //   239: aload_0
    //   240: invokevirtual 95	java/io/FileInputStream:close	()V
    //   243: ldc 82
    //   245: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_2
    //   249: areturn
    //   250: astore_0
    //   251: ldc 55
    //   253: ldc 97
    //   255: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: goto -15 -> 243
    //   261: astore_0
    //   262: aconst_null
    //   263: astore_0
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 95	java/io/FileInputStream:close	()V
    //   272: ldc 82
    //   274: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_0
    //   280: ldc 55
    //   282: ldc 97
    //   284: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: goto -15 -> 272
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_2
    //   293: aload_2
    //   294: ifnull +7 -> 301
    //   297: aload_2
    //   298: invokevirtual 95	java/io/FileInputStream:close	()V
    //   301: ldc 82
    //   303: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_0
    //   307: athrow
    //   308: astore_2
    //   309: ldc 55
    //   311: ldc 97
    //   313: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    paramb.IPS = a(paramElement, "apkMin");
    paramb.IPT = a(paramElement, "apkMax");
    paramb.IPQ = a(paramElement, "sdkMin");
    paramb.IPR = a(paramElement, "sdkMax");
    paramb.IPU = a(paramElement, "apiMin");
    paramb.IPV = a(paramElement, "apiMax");
    paramb.IPW = paramElement.getAttribute("forbidDeviceRegex");
    paramb.IPX = paramElement.getAttribute("whiteDeviceRegex");
    paramb.IQf = paramElement.getAttribute("forbidAppRegex");
    paramb.IQg = paramElement.getAttribute("whiteAppRegex");
    paramb.IPY = a(paramElement, "grayMin");
    paramb.IPZ = a(paramElement, "grayMax");
    paramb.IQa = a(paramElement, "chromeMin");
    paramb.IQb = a(paramElement, "chromeMax");
    paramb.IQc = a(paramElement, "usertype");
    paramb.IQh = a(paramElement, "x5sdkmin");
    paramb.IQi = a(paramElement, "x5sdkmax");
    paramb.IQj = a(paramElement, "x5coremin");
    paramb.IQk = a(paramElement, "x5coremax");
    paramb.IQd = c(paramElement, "hoursStart");
    paramb.IQe = c(paramElement, "hoursEnd");
    paramb.IQm = paramElement.getAttribute("runtimeAbis");
    paramb.IQo = paramElement.getAttribute("blackRuntimeAbis");
    paramb.IQl = paramElement.getAttribute("deviceAbis");
    paramb.IQn = paramElement.getAttribute("blackDeviceAbis");
    paramb.IQp = b(paramElement, "appClientVerMin");
    paramb.IQq = b(paramElement, "appClientVerMax");
    paramb.IQr = paramElement.getAttribute("appInfoWhiteList");
    paramb.IQs = paramElement.getAttribute("appInfoBlackList");
    AppMethodBeat.o(154543);
  }
  
  private static b[] a(Element paramElement)
  {
    AppMethodBeat.i(154541);
    paramElement = paramElement.getElementsByTagName("Patch");
    if ((paramElement != null) && (paramElement.getLength() != 0))
    {
      b[] arrayOfb = new b[paramElement.getLength()];
      int i = 0;
      while (i < paramElement.getLength())
      {
        b localb = new b();
        Element localElement = (Element)paramElement.item(i);
        localb.IVr = localElement.getAttribute("url");
        localb.IVq = a(localElement, "targetVersion");
        localb.IVm = localElement.getAttribute("md5");
        localb.IVs = e(localElement, "useCellular");
        localb.bUseCdn = e(localElement, "useCdn");
        arrayOfb[i] = localb;
        i += 1;
      }
      AppMethodBeat.o(154541);
      return arrayOfb;
    }
    AppMethodBeat.o(154541);
    return null;
  }
  
  public static a aPF(String paramString)
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
    paramString = i(paramString, a(paramString, (int)paramString.length(), "<Versions>"));
    AppMethodBeat.o(154536);
    return paramString;
  }
  
  private static int b(Element paramElement, String paramString)
  {
    AppMethodBeat.i(194708);
    if (paramElement == null)
    {
      AppMethodBeat.o(194708);
      return 0;
    }
    paramString = paramElement.getAttribute(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(194708);
      return 0;
    }
    paramElement = paramString;
    if (paramString.contains("0x")) {
      paramElement = paramString.trim().substring(2);
    }
    try
    {
      int i = Integer.parseInt(paramElement, 16);
      AppMethodBeat.o(194708);
      return i;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetIntFromHex failed" + paramElement.getMessage());
      AppMethodBeat.o(194708);
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
          locala.IPN = localElement.getAttribute("optype");
          locala.IPO = localElement.getAttribute("opvalue");
          locala.IPP = localElement.getAttribute("module");
          a(locala.IPM, localElement);
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
    AppMethodBeat.i(194709);
    if (paramElement == null)
    {
      AppMethodBeat.o(194709);
      return -1.0F;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(194709);
      return -1.0F;
    }
    try
    {
      float f = Float.parseFloat(paramElement);
      AppMethodBeat.o(194709);
      return f;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetFloat failed : " + paramElement.getMessage());
      AppMethodBeat.o(194709);
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
  private static a i(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 454
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 460	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   9: astore 5
    //   11: new 84	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_0
    //   24: new 6	com/tencent/xweb/xwalk/updater/a$a
    //   27: dup
    //   28: invokespecial 461	com/tencent/xweb/xwalk/updater/a$a:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 465	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 471	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 477 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 479
    //   63: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 95	java/io/FileInputStream:close	()V
    //   71: ldc_w 454
    //   74: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 55
    //   82: ldc_w 481
    //   85: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 483
    //   100: invokeinterface 41 2 0
    //   105: putfield 484	com/tencent/xweb/xwalk/updater/a$a:IVm	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: aload 5
    //   114: ldc_w 486
    //   117: invokeinterface 41 2 0
    //   122: putfield 488	com/tencent/xweb/xwalk/updater/a$a:signature	Ljava/lang/String;
    //   125: aload 4
    //   127: astore_0
    //   128: aload_3
    //   129: getfield 484	com/tencent/xweb/xwalk/updater/a$a:IVm	Ljava/lang/String;
    //   132: ifnull +17 -> 149
    //   135: aload 4
    //   137: astore_0
    //   138: aload_3
    //   139: getfield 484	com/tencent/xweb/xwalk/updater/a$a:IVm	Ljava/lang/String;
    //   142: aload_1
    //   143: invokevirtual 491	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifne +46 -> 192
    //   149: aload 4
    //   151: astore_0
    //   152: ldc2_w 492
    //   155: invokestatic 499	com/tencent/xweb/util/g:xs	(J)V
    //   158: aload 4
    //   160: astore_0
    //   161: ldc_w 501
    //   164: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: invokevirtual 95	java/io/FileInputStream:close	()V
    //   172: ldc_w 454
    //   175: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: ldc 55
    //   183: ldc_w 481
    //   186: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -17 -> 172
    //   192: aload 4
    //   194: astore_0
    //   195: aload_3
    //   196: getfield 484	com/tencent/xweb/xwalk/updater/a$a:IVm	Ljava/lang/String;
    //   199: aload_3
    //   200: getfield 488	com/tencent/xweb/xwalk/updater/a$a:signature	Ljava/lang/String;
    //   203: ldc_w 503
    //   206: invokestatic 509	com/tencent/xweb/util/b:aZ	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   209: ifne +46 -> 255
    //   212: aload 4
    //   214: astore_0
    //   215: ldc2_w 510
    //   218: invokestatic 499	com/tencent/xweb/util/g:xs	(J)V
    //   221: aload 4
    //   223: astore_0
    //   224: ldc_w 513
    //   227: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   230: aload 4
    //   232: invokevirtual 95	java/io/FileInputStream:close	()V
    //   235: ldc_w 454
    //   238: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aconst_null
    //   242: areturn
    //   243: astore_0
    //   244: ldc 55
    //   246: ldc_w 481
    //   249: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: goto -17 -> 235
    //   255: aload 4
    //   257: astore_0
    //   258: aload_3
    //   259: aload 5
    //   261: ldc_w 515
    //   264: invokeinterface 41 2 0
    //   269: putfield 518	com/tencent/xweb/xwalk/updater/a$a:IVn	Ljava/lang/String;
    //   272: aload 4
    //   274: astore_0
    //   275: aload_3
    //   276: aload 5
    //   278: invokestatic 520	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/a$a;
    //   281: putfield 524	com/tencent/xweb/xwalk/updater/a$a:IVp	[Lcom/tencent/xweb/internal/a$a;
    //   284: aload 4
    //   286: astore_0
    //   287: aload 5
    //   289: ldc_w 526
    //   292: invokeinterface 305 2 0
    //   297: astore_1
    //   298: aload_1
    //   299: ifnull +438 -> 737
    //   302: aload 4
    //   304: astore_0
    //   305: aload_1
    //   306: invokeinterface 310 1 0
    //   311: ifeq +426 -> 737
    //   314: aload 4
    //   316: astore_0
    //   317: aload_3
    //   318: aload_1
    //   319: invokeinterface 310 1 0
    //   324: anewarray 18	com/tencent/xweb/xwalk/updater/a$e
    //   327: putfield 530	com/tencent/xweb/xwalk/updater/a$a:IVo	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   330: iconst_0
    //   331: istore_2
    //   332: aload 4
    //   334: astore_0
    //   335: iload_2
    //   336: aload_1
    //   337: invokeinterface 310 1 0
    //   342: if_icmpge +395 -> 737
    //   345: aload 4
    //   347: astore_0
    //   348: new 18	com/tencent/xweb/xwalk/updater/a$e
    //   351: dup
    //   352: invokespecial 531	com/tencent/xweb/xwalk/updater/a$e:<init>	()V
    //   355: astore 5
    //   357: aload 4
    //   359: astore_0
    //   360: aload_1
    //   361: iload_2
    //   362: invokeinterface 316 2 0
    //   367: checkcast 37	org/w3c/dom/Element
    //   370: astore 6
    //   372: aload 4
    //   374: astore_0
    //   375: aload 5
    //   377: aload 6
    //   379: ldc_w 533
    //   382: invokeinterface 41 2 0
    //   387: putfield 534	com/tencent/xweb/xwalk/updater/a$e:IVr	Ljava/lang/String;
    //   390: aload 4
    //   392: astore_0
    //   393: aload 5
    //   395: aload 6
    //   397: ldc_w 328
    //   400: invokeinterface 41 2 0
    //   405: putfield 535	com/tencent/xweb/xwalk/updater/a$e:IVm	Ljava/lang/String;
    //   408: aload 4
    //   410: astore_0
    //   411: aload 5
    //   413: getfield 536	com/tencent/xweb/xwalk/updater/a$e:IPM	Lcom/tencent/xweb/internal/a$b;
    //   416: aload 6
    //   418: invokestatic 416	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   421: aload 4
    //   423: astore_0
    //   424: aload 5
    //   426: aload 6
    //   428: ldc_w 538
    //   431: invokestatic 144	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   434: putfield 541	com/tencent/xweb/xwalk/updater/a$e:IVw	I
    //   437: aload 4
    //   439: astore_0
    //   440: aload 5
    //   442: aload 6
    //   444: ldc_w 543
    //   447: invokestatic 144	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   450: putfield 546	com/tencent/xweb/xwalk/updater/a$e:IVy	I
    //   453: aload 4
    //   455: astore_0
    //   456: aload 5
    //   458: aload 6
    //   460: ldc_w 333
    //   463: invokestatic 336	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   466: putfield 547	com/tencent/xweb/xwalk/updater/a$e:IVs	Z
    //   469: aload 4
    //   471: astore_0
    //   472: aload 5
    //   474: aload 6
    //   476: ldc_w 342
    //   479: invokestatic 336	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   482: putfield 548	com/tencent/xweb/xwalk/updater/a$e:bUseCdn	Z
    //   485: aload 4
    //   487: astore_0
    //   488: aload 5
    //   490: aload 6
    //   492: ldc_w 550
    //   495: invokestatic 144	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   498: putfield 553	com/tencent/xweb/xwalk/updater/a$e:IVA	I
    //   501: aload 4
    //   503: astore_0
    //   504: aload 5
    //   506: aload 6
    //   508: ldc_w 555
    //   511: invokeinterface 41 2 0
    //   516: putfield 558	com/tencent/xweb/xwalk/updater/a$e:IVD	Ljava/lang/String;
    //   519: aload 4
    //   521: astore_0
    //   522: aload 5
    //   524: aload 6
    //   526: ldc_w 560
    //   529: invokeinterface 41 2 0
    //   534: putfield 563	com/tencent/xweb/xwalk/updater/a$e:IVE	Ljava/lang/String;
    //   537: aload 4
    //   539: astore_0
    //   540: aload 5
    //   542: aload 6
    //   544: ldc_w 565
    //   547: invokeinterface 41 2 0
    //   552: putfield 568	com/tencent/xweb/xwalk/updater/a$e:IVF	Ljava/lang/String;
    //   555: aload 4
    //   557: astore_0
    //   558: aload 5
    //   560: aload 6
    //   562: ldc_w 570
    //   565: invokestatic 572	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   568: putfield 576	com/tencent/xweb/xwalk/updater/a$e:IVB	F
    //   571: aload 4
    //   573: astore_0
    //   574: aload 5
    //   576: aload 6
    //   578: ldc_w 578
    //   581: invokestatic 572	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   584: putfield 581	com/tencent/xweb/xwalk/updater/a$e:IVC	F
    //   587: aload 4
    //   589: astore_0
    //   590: aload 6
    //   592: ldc_w 583
    //   595: invokeinterface 41 2 0
    //   600: astore 7
    //   602: aload 7
    //   604: ifnull +27 -> 631
    //   607: aload 4
    //   609: astore_0
    //   610: aload 7
    //   612: invokevirtual 47	java/lang/String:isEmpty	()Z
    //   615: ifne +16 -> 631
    //   618: aload 4
    //   620: astore_0
    //   621: aload 5
    //   623: aload 7
    //   625: invokestatic 447	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   628: putfield 586	com/tencent/xweb/xwalk/updater/a$e:bTryUseSharedCore	Z
    //   631: aload 4
    //   633: astore_0
    //   634: aload 5
    //   636: getfield 590	com/tencent/xweb/xwalk/updater/a$e:IVz	Lcom/tencent/xweb/xwalk/updater/a$f;
    //   639: astore 7
    //   641: aload 7
    //   643: ifnull +63 -> 706
    //   646: aload 4
    //   648: astore_0
    //   649: aload 6
    //   651: ldc_w 592
    //   654: invokeinterface 305 2 0
    //   659: astore 8
    //   661: aload 8
    //   663: ifnull +43 -> 706
    //   666: aload 4
    //   668: astore_0
    //   669: aload 8
    //   671: invokeinterface 310 1 0
    //   676: ifeq +30 -> 706
    //   679: aload 4
    //   681: astore_0
    //   682: aload 7
    //   684: aload 8
    //   686: iconst_0
    //   687: invokeinterface 316 2 0
    //   692: checkcast 37	org/w3c/dom/Element
    //   695: ldc_w 594
    //   698: invokeinterface 41 2 0
    //   703: putfield 597	com/tencent/xweb/xwalk/updater/a$f:IVG	Ljava/lang/String;
    //   706: aload 4
    //   708: astore_0
    //   709: aload 5
    //   711: aload 6
    //   713: invokestatic 599	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$b;
    //   716: putfield 603	com/tencent/xweb/xwalk/updater/a$e:IVx	[Lcom/tencent/xweb/xwalk/updater/a$b;
    //   719: aload 4
    //   721: astore_0
    //   722: aload_3
    //   723: getfield 530	com/tencent/xweb/xwalk/updater/a$a:IVo	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   726: iload_2
    //   727: aload 5
    //   729: aastore
    //   730: iload_2
    //   731: iconst_1
    //   732: iadd
    //   733: istore_2
    //   734: goto -402 -> 332
    //   737: aload 4
    //   739: invokevirtual 95	java/io/FileInputStream:close	()V
    //   742: aload_3
    //   743: astore_0
    //   744: ldc_w 454
    //   747: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   750: aload_0
    //   751: areturn
    //   752: astore_0
    //   753: ldc 55
    //   755: ldc_w 481
    //   758: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   761: aload_3
    //   762: astore_0
    //   763: goto -19 -> 744
    //   766: astore_0
    //   767: aconst_null
    //   768: astore 4
    //   770: aconst_null
    //   771: astore_1
    //   772: aload 4
    //   774: astore_0
    //   775: ldc_w 479
    //   778: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   781: aload_1
    //   782: astore_0
    //   783: aload 4
    //   785: ifnull -41 -> 744
    //   788: aload 4
    //   790: invokevirtual 95	java/io/FileInputStream:close	()V
    //   793: aload_1
    //   794: astore_0
    //   795: goto -51 -> 744
    //   798: astore_0
    //   799: ldc 55
    //   801: ldc_w 481
    //   804: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: aload_1
    //   808: astore_0
    //   809: goto -65 -> 744
    //   812: astore_0
    //   813: aconst_null
    //   814: astore 4
    //   816: aconst_null
    //   817: astore_1
    //   818: aload 4
    //   820: astore_0
    //   821: ldc_w 479
    //   824: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   827: aload_1
    //   828: astore_0
    //   829: aload 4
    //   831: ifnull -87 -> 744
    //   834: aload 4
    //   836: invokevirtual 95	java/io/FileInputStream:close	()V
    //   839: aload_1
    //   840: astore_0
    //   841: goto -97 -> 744
    //   844: astore_0
    //   845: ldc 55
    //   847: ldc_w 481
    //   850: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   853: aload_1
    //   854: astore_0
    //   855: goto -111 -> 744
    //   858: astore_0
    //   859: aconst_null
    //   860: astore 4
    //   862: aconst_null
    //   863: astore_1
    //   864: aload 4
    //   866: astore_0
    //   867: ldc_w 479
    //   870: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   873: aload_1
    //   874: astore_0
    //   875: aload 4
    //   877: ifnull -133 -> 744
    //   880: aload 4
    //   882: invokevirtual 95	java/io/FileInputStream:close	()V
    //   885: aload_1
    //   886: astore_0
    //   887: goto -143 -> 744
    //   890: astore_0
    //   891: ldc 55
    //   893: ldc_w 481
    //   896: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   899: aload_1
    //   900: astore_0
    //   901: goto -157 -> 744
    //   904: astore_1
    //   905: aconst_null
    //   906: astore_0
    //   907: aload_0
    //   908: ifnull +7 -> 915
    //   911: aload_0
    //   912: invokevirtual 95	java/io/FileInputStream:close	()V
    //   915: ldc_w 454
    //   918: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   921: aload_1
    //   922: athrow
    //   923: astore_0
    //   924: ldc 55
    //   926: ldc_w 481
    //   929: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   932: goto -17 -> 915
    //   935: astore_1
    //   936: goto -29 -> 907
    //   939: astore_0
    //   940: aconst_null
    //   941: astore_1
    //   942: goto -78 -> 864
    //   945: astore_0
    //   946: aload_3
    //   947: astore_1
    //   948: goto -84 -> 864
    //   951: astore_0
    //   952: aconst_null
    //   953: astore_1
    //   954: goto -136 -> 818
    //   957: astore_0
    //   958: aload_3
    //   959: astore_1
    //   960: goto -142 -> 818
    //   963: astore_0
    //   964: aconst_null
    //   965: astore_1
    //   966: goto -194 -> 772
    //   969: astore_0
    //   970: aload_3
    //   971: astore_1
    //   972: goto -200 -> 772
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	975	0	paramFile	File
    //   0	975	1	paramString	String
    //   331	403	2	i	int
    //   31	940	3	locala	a
    //   19	862	4	localFileInputStream	java.io.FileInputStream
    //   9	719	5	localObject1	Object
    //   370	342	6	localElement	Element
    //   600	83	7	localObject2	Object
    //   659	26	8	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   66	71	79	java/lang/Exception
    //   167	172	180	java/lang/Exception
    //   230	235	243	java/lang/Exception
    //   737	742	752	java/lang/Exception
    //   11	21	766	javax/xml/parsers/ParserConfigurationException
    //   788	793	798	java/lang/Exception
    //   11	21	812	org/xml/sax/SAXException
    //   834	839	844	java/lang/Exception
    //   11	21	858	java/io/IOException
    //   880	885	890	java/lang/Exception
    //   11	21	904	finally
    //   911	915	923	java/lang/Exception
    //   24	32	935	finally
    //   35	52	935	finally
    //   60	66	935	finally
    //   94	108	935	finally
    //   111	125	935	finally
    //   128	135	935	finally
    //   138	149	935	finally
    //   152	158	935	finally
    //   161	167	935	finally
    //   195	212	935	finally
    //   215	221	935	finally
    //   224	230	935	finally
    //   258	272	935	finally
    //   275	284	935	finally
    //   287	298	935	finally
    //   305	314	935	finally
    //   317	330	935	finally
    //   335	345	935	finally
    //   348	357	935	finally
    //   360	372	935	finally
    //   375	390	935	finally
    //   393	408	935	finally
    //   411	421	935	finally
    //   424	437	935	finally
    //   440	453	935	finally
    //   456	469	935	finally
    //   472	485	935	finally
    //   488	501	935	finally
    //   504	519	935	finally
    //   522	537	935	finally
    //   540	555	935	finally
    //   558	571	935	finally
    //   574	587	935	finally
    //   590	602	935	finally
    //   610	618	935	finally
    //   621	631	935	finally
    //   634	641	935	finally
    //   649	661	935	finally
    //   669	679	935	finally
    //   682	706	935	finally
    //   709	719	935	finally
    //   722	730	935	finally
    //   775	781	935	finally
    //   821	827	935	finally
    //   867	873	935	finally
    //   24	32	939	java/io/IOException
    //   35	52	945	java/io/IOException
    //   60	66	945	java/io/IOException
    //   94	108	945	java/io/IOException
    //   111	125	945	java/io/IOException
    //   128	135	945	java/io/IOException
    //   138	149	945	java/io/IOException
    //   152	158	945	java/io/IOException
    //   161	167	945	java/io/IOException
    //   195	212	945	java/io/IOException
    //   215	221	945	java/io/IOException
    //   224	230	945	java/io/IOException
    //   258	272	945	java/io/IOException
    //   275	284	945	java/io/IOException
    //   287	298	945	java/io/IOException
    //   305	314	945	java/io/IOException
    //   317	330	945	java/io/IOException
    //   335	345	945	java/io/IOException
    //   348	357	945	java/io/IOException
    //   360	372	945	java/io/IOException
    //   375	390	945	java/io/IOException
    //   393	408	945	java/io/IOException
    //   411	421	945	java/io/IOException
    //   424	437	945	java/io/IOException
    //   440	453	945	java/io/IOException
    //   456	469	945	java/io/IOException
    //   472	485	945	java/io/IOException
    //   488	501	945	java/io/IOException
    //   504	519	945	java/io/IOException
    //   522	537	945	java/io/IOException
    //   540	555	945	java/io/IOException
    //   558	571	945	java/io/IOException
    //   574	587	945	java/io/IOException
    //   590	602	945	java/io/IOException
    //   610	618	945	java/io/IOException
    //   621	631	945	java/io/IOException
    //   634	641	945	java/io/IOException
    //   649	661	945	java/io/IOException
    //   669	679	945	java/io/IOException
    //   682	706	945	java/io/IOException
    //   709	719	945	java/io/IOException
    //   722	730	945	java/io/IOException
    //   24	32	951	org/xml/sax/SAXException
    //   35	52	957	org/xml/sax/SAXException
    //   60	66	957	org/xml/sax/SAXException
    //   94	108	957	org/xml/sax/SAXException
    //   111	125	957	org/xml/sax/SAXException
    //   128	135	957	org/xml/sax/SAXException
    //   138	149	957	org/xml/sax/SAXException
    //   152	158	957	org/xml/sax/SAXException
    //   161	167	957	org/xml/sax/SAXException
    //   195	212	957	org/xml/sax/SAXException
    //   215	221	957	org/xml/sax/SAXException
    //   224	230	957	org/xml/sax/SAXException
    //   258	272	957	org/xml/sax/SAXException
    //   275	284	957	org/xml/sax/SAXException
    //   287	298	957	org/xml/sax/SAXException
    //   305	314	957	org/xml/sax/SAXException
    //   317	330	957	org/xml/sax/SAXException
    //   335	345	957	org/xml/sax/SAXException
    //   348	357	957	org/xml/sax/SAXException
    //   360	372	957	org/xml/sax/SAXException
    //   375	390	957	org/xml/sax/SAXException
    //   393	408	957	org/xml/sax/SAXException
    //   411	421	957	org/xml/sax/SAXException
    //   424	437	957	org/xml/sax/SAXException
    //   440	453	957	org/xml/sax/SAXException
    //   456	469	957	org/xml/sax/SAXException
    //   472	485	957	org/xml/sax/SAXException
    //   488	501	957	org/xml/sax/SAXException
    //   504	519	957	org/xml/sax/SAXException
    //   522	537	957	org/xml/sax/SAXException
    //   540	555	957	org/xml/sax/SAXException
    //   558	571	957	org/xml/sax/SAXException
    //   574	587	957	org/xml/sax/SAXException
    //   590	602	957	org/xml/sax/SAXException
    //   610	618	957	org/xml/sax/SAXException
    //   621	631	957	org/xml/sax/SAXException
    //   634	641	957	org/xml/sax/SAXException
    //   649	661	957	org/xml/sax/SAXException
    //   669	679	957	org/xml/sax/SAXException
    //   682	706	957	org/xml/sax/SAXException
    //   709	719	957	org/xml/sax/SAXException
    //   722	730	957	org/xml/sax/SAXException
    //   24	32	963	javax/xml/parsers/ParserConfigurationException
    //   35	52	969	javax/xml/parsers/ParserConfigurationException
    //   60	66	969	javax/xml/parsers/ParserConfigurationException
    //   94	108	969	javax/xml/parsers/ParserConfigurationException
    //   111	125	969	javax/xml/parsers/ParserConfigurationException
    //   128	135	969	javax/xml/parsers/ParserConfigurationException
    //   138	149	969	javax/xml/parsers/ParserConfigurationException
    //   152	158	969	javax/xml/parsers/ParserConfigurationException
    //   161	167	969	javax/xml/parsers/ParserConfigurationException
    //   195	212	969	javax/xml/parsers/ParserConfigurationException
    //   215	221	969	javax/xml/parsers/ParserConfigurationException
    //   224	230	969	javax/xml/parsers/ParserConfigurationException
    //   258	272	969	javax/xml/parsers/ParserConfigurationException
    //   275	284	969	javax/xml/parsers/ParserConfigurationException
    //   287	298	969	javax/xml/parsers/ParserConfigurationException
    //   305	314	969	javax/xml/parsers/ParserConfigurationException
    //   317	330	969	javax/xml/parsers/ParserConfigurationException
    //   335	345	969	javax/xml/parsers/ParserConfigurationException
    //   348	357	969	javax/xml/parsers/ParserConfigurationException
    //   360	372	969	javax/xml/parsers/ParserConfigurationException
    //   375	390	969	javax/xml/parsers/ParserConfigurationException
    //   393	408	969	javax/xml/parsers/ParserConfigurationException
    //   411	421	969	javax/xml/parsers/ParserConfigurationException
    //   424	437	969	javax/xml/parsers/ParserConfigurationException
    //   440	453	969	javax/xml/parsers/ParserConfigurationException
    //   456	469	969	javax/xml/parsers/ParserConfigurationException
    //   472	485	969	javax/xml/parsers/ParserConfigurationException
    //   488	501	969	javax/xml/parsers/ParserConfigurationException
    //   504	519	969	javax/xml/parsers/ParserConfigurationException
    //   522	537	969	javax/xml/parsers/ParserConfigurationException
    //   540	555	969	javax/xml/parsers/ParserConfigurationException
    //   558	571	969	javax/xml/parsers/ParserConfigurationException
    //   574	587	969	javax/xml/parsers/ParserConfigurationException
    //   590	602	969	javax/xml/parsers/ParserConfigurationException
    //   610	618	969	javax/xml/parsers/ParserConfigurationException
    //   621	631	969	javax/xml/parsers/ParserConfigurationException
    //   634	641	969	javax/xml/parsers/ParserConfigurationException
    //   649	661	969	javax/xml/parsers/ParserConfigurationException
    //   669	679	969	javax/xml/parsers/ParserConfigurationException
    //   682	706	969	javax/xml/parsers/ParserConfigurationException
    //   709	719	969	javax/xml/parsers/ParserConfigurationException
    //   722	730	969	javax/xml/parsers/ParserConfigurationException
  }
  
  /* Error */
  public static c j(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 606
    //   3: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 460	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   9: astore 5
    //   11: new 84	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 87	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_0
    //   24: new 12	com/tencent/xweb/xwalk/updater/a$c
    //   27: dup
    //   28: invokespecial 607	com/tencent/xweb/xwalk/updater/a$c:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 465	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 471	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 477 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 609
    //   63: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 95	java/io/FileInputStream:close	()V
    //   71: ldc_w 606
    //   74: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 55
    //   82: ldc_w 611
    //   85: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 483
    //   100: invokeinterface 41 2 0
    //   105: putfield 612	com/tencent/xweb/xwalk/updater/a$c:IVm	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: aload 5
    //   114: ldc_w 486
    //   117: invokeinterface 41 2 0
    //   122: putfield 613	com/tencent/xweb/xwalk/updater/a$c:signature	Ljava/lang/String;
    //   125: aload 4
    //   127: astore_0
    //   128: aload_3
    //   129: getfield 612	com/tencent/xweb/xwalk/updater/a$c:IVm	Ljava/lang/String;
    //   132: ifnull +17 -> 149
    //   135: aload 4
    //   137: astore_0
    //   138: aload_3
    //   139: getfield 612	com/tencent/xweb/xwalk/updater/a$c:IVm	Ljava/lang/String;
    //   142: aload_1
    //   143: invokevirtual 491	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifne +37 -> 183
    //   149: aload 4
    //   151: astore_0
    //   152: ldc_w 615
    //   155: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 95	java/io/FileInputStream:close	()V
    //   163: ldc_w 606
    //   166: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: ldc 55
    //   174: ldc_w 611
    //   177: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto -17 -> 163
    //   183: aload 4
    //   185: astore_0
    //   186: aload_3
    //   187: aload 5
    //   189: ldc_w 515
    //   192: invokeinterface 41 2 0
    //   197: putfield 616	com/tencent/xweb/xwalk/updater/a$c:IVn	Ljava/lang/String;
    //   200: aload 4
    //   202: astore_0
    //   203: aload_3
    //   204: aload 5
    //   206: invokestatic 520	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/a$a;
    //   209: putfield 617	com/tencent/xweb/xwalk/updater/a$c:IVp	[Lcom/tencent/xweb/internal/a$a;
    //   212: aload 4
    //   214: astore_0
    //   215: aload 5
    //   217: ldc_w 619
    //   220: invokeinterface 305 2 0
    //   225: astore_1
    //   226: aload_1
    //   227: ifnull +235 -> 462
    //   230: aload 4
    //   232: astore_0
    //   233: aload_1
    //   234: invokeinterface 310 1 0
    //   239: ifeq +223 -> 462
    //   242: aload 4
    //   244: astore_0
    //   245: aload_3
    //   246: aload_1
    //   247: invokeinterface 310 1 0
    //   252: anewarray 15	com/tencent/xweb/xwalk/updater/a$d
    //   255: putfield 623	com/tencent/xweb/xwalk/updater/a$c:IVt	[Lcom/tencent/xweb/xwalk/updater/a$d;
    //   258: iconst_0
    //   259: istore_2
    //   260: aload 4
    //   262: astore_0
    //   263: iload_2
    //   264: aload_1
    //   265: invokeinterface 310 1 0
    //   270: if_icmpge +192 -> 462
    //   273: aload 4
    //   275: astore_0
    //   276: aload_1
    //   277: iload_2
    //   278: invokeinterface 316 2 0
    //   283: checkcast 37	org/w3c/dom/Element
    //   286: astore 5
    //   288: aload 4
    //   290: astore_0
    //   291: new 15	com/tencent/xweb/xwalk/updater/a$d
    //   294: dup
    //   295: invokespecial 624	com/tencent/xweb/xwalk/updater/a$d:<init>	()V
    //   298: astore 6
    //   300: aload 4
    //   302: astore_0
    //   303: aload 6
    //   305: aload 5
    //   307: ldc_w 626
    //   310: invokeinterface 41 2 0
    //   315: putfield 629	com/tencent/xweb/xwalk/updater/a$d:IVu	Ljava/lang/String;
    //   318: aload 4
    //   320: astore_0
    //   321: aload 6
    //   323: aload 5
    //   325: ldc_w 543
    //   328: invokestatic 144	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   331: putfield 632	com/tencent/xweb/xwalk/updater/a$d:IVv	I
    //   334: aload 4
    //   336: astore_0
    //   337: aload 6
    //   339: aload 5
    //   341: ldc_w 533
    //   344: invokeinterface 41 2 0
    //   349: putfield 633	com/tencent/xweb/xwalk/updater/a$d:IVr	Ljava/lang/String;
    //   352: aload 4
    //   354: astore_0
    //   355: aload 6
    //   357: aload 5
    //   359: ldc_w 328
    //   362: invokeinterface 41 2 0
    //   367: putfield 634	com/tencent/xweb/xwalk/updater/a$d:IVm	Ljava/lang/String;
    //   370: aload 4
    //   372: astore_0
    //   373: aload 6
    //   375: aload 5
    //   377: ldc_w 333
    //   380: invokestatic 336	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   383: putfield 635	com/tencent/xweb/xwalk/updater/a$d:IVs	Z
    //   386: aload 4
    //   388: astore_0
    //   389: aload 6
    //   391: aload 5
    //   393: ldc_w 342
    //   396: invokestatic 336	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   399: putfield 636	com/tencent/xweb/xwalk/updater/a$d:bUseCdn	Z
    //   402: aload 4
    //   404: astore_0
    //   405: aload 6
    //   407: aload 5
    //   409: ldc_w 538
    //   412: invokestatic 144	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   415: putfield 637	com/tencent/xweb/xwalk/updater/a$d:IVw	I
    //   418: aload 4
    //   420: astore_0
    //   421: aload 6
    //   423: getfield 638	com/tencent/xweb/xwalk/updater/a$d:IPM	Lcom/tencent/xweb/internal/a$b;
    //   426: aload 5
    //   428: invokestatic 416	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   431: aload 4
    //   433: astore_0
    //   434: aload 6
    //   436: aload 5
    //   438: invokestatic 599	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$b;
    //   441: putfield 639	com/tencent/xweb/xwalk/updater/a$d:IVx	[Lcom/tencent/xweb/xwalk/updater/a$b;
    //   444: aload 4
    //   446: astore_0
    //   447: aload_3
    //   448: getfield 623	com/tencent/xweb/xwalk/updater/a$c:IVt	[Lcom/tencent/xweb/xwalk/updater/a$d;
    //   451: iload_2
    //   452: aload 6
    //   454: aastore
    //   455: iload_2
    //   456: iconst_1
    //   457: iadd
    //   458: istore_2
    //   459: goto -199 -> 260
    //   462: aload 4
    //   464: invokevirtual 95	java/io/FileInputStream:close	()V
    //   467: aload_3
    //   468: astore_0
    //   469: ldc_w 606
    //   472: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: aload_0
    //   476: areturn
    //   477: astore_0
    //   478: ldc 55
    //   480: ldc_w 611
    //   483: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: aload_3
    //   487: astore_0
    //   488: goto -19 -> 469
    //   491: astore_0
    //   492: aconst_null
    //   493: astore 4
    //   495: aconst_null
    //   496: astore_1
    //   497: aload 4
    //   499: astore_0
    //   500: ldc_w 641
    //   503: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   506: aload_1
    //   507: astore_0
    //   508: aload 4
    //   510: ifnull -41 -> 469
    //   513: aload 4
    //   515: invokevirtual 95	java/io/FileInputStream:close	()V
    //   518: aload_1
    //   519: astore_0
    //   520: goto -51 -> 469
    //   523: astore_0
    //   524: ldc 55
    //   526: ldc_w 611
    //   529: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   532: aload_1
    //   533: astore_0
    //   534: goto -65 -> 469
    //   537: astore_0
    //   538: aconst_null
    //   539: astore 4
    //   541: aconst_null
    //   542: astore_1
    //   543: aload 4
    //   545: astore_0
    //   546: ldc_w 643
    //   549: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   552: aload_1
    //   553: astore_0
    //   554: aload 4
    //   556: ifnull -87 -> 469
    //   559: aload 4
    //   561: invokevirtual 95	java/io/FileInputStream:close	()V
    //   564: aload_1
    //   565: astore_0
    //   566: goto -97 -> 469
    //   569: astore_0
    //   570: ldc 55
    //   572: ldc_w 611
    //   575: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: aload_1
    //   579: astore_0
    //   580: goto -111 -> 469
    //   583: astore_0
    //   584: aconst_null
    //   585: astore 4
    //   587: aconst_null
    //   588: astore_1
    //   589: aload 4
    //   591: astore_0
    //   592: ldc_w 645
    //   595: invokestatic 355	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   598: aload_1
    //   599: astore_0
    //   600: aload 4
    //   602: ifnull -133 -> 469
    //   605: aload 4
    //   607: invokevirtual 95	java/io/FileInputStream:close	()V
    //   610: aload_1
    //   611: astore_0
    //   612: goto -143 -> 469
    //   615: astore_0
    //   616: ldc 55
    //   618: ldc_w 611
    //   621: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   624: aload_1
    //   625: astore_0
    //   626: goto -157 -> 469
    //   629: astore_1
    //   630: aconst_null
    //   631: astore_0
    //   632: aload_0
    //   633: ifnull +7 -> 640
    //   636: aload_0
    //   637: invokevirtual 95	java/io/FileInputStream:close	()V
    //   640: ldc_w 606
    //   643: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   646: aload_1
    //   647: athrow
    //   648: astore_0
    //   649: ldc 55
    //   651: ldc_w 611
    //   654: invokestatic 79	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   657: goto -17 -> 640
    //   660: astore_1
    //   661: goto -29 -> 632
    //   664: astore_0
    //   665: aconst_null
    //   666: astore_1
    //   667: goto -78 -> 589
    //   670: astore_0
    //   671: aload_3
    //   672: astore_1
    //   673: goto -84 -> 589
    //   676: astore_0
    //   677: aconst_null
    //   678: astore_1
    //   679: goto -136 -> 543
    //   682: astore_0
    //   683: aload_3
    //   684: astore_1
    //   685: goto -142 -> 543
    //   688: astore_0
    //   689: aconst_null
    //   690: astore_1
    //   691: goto -194 -> 497
    //   694: astore_0
    //   695: aload_3
    //   696: astore_1
    //   697: goto -200 -> 497
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	700	0	paramFile	File
    //   0	700	1	paramString	String
    //   259	200	2	i	int
    //   31	665	3	localc	c
    //   19	587	4	localFileInputStream	java.io.FileInputStream
    //   9	428	5	localObject	Object
    //   298	155	6	locald	d
    // Exception table:
    //   from	to	target	type
    //   66	71	79	java/lang/Exception
    //   158	163	171	java/lang/Exception
    //   462	467	477	java/lang/Exception
    //   11	21	491	javax/xml/parsers/ParserConfigurationException
    //   513	518	523	java/lang/Exception
    //   11	21	537	org/xml/sax/SAXException
    //   559	564	569	java/lang/Exception
    //   11	21	583	java/io/IOException
    //   605	610	615	java/lang/Exception
    //   11	21	629	finally
    //   636	640	648	java/lang/Exception
    //   24	32	660	finally
    //   35	52	660	finally
    //   60	66	660	finally
    //   94	108	660	finally
    //   111	125	660	finally
    //   128	135	660	finally
    //   138	149	660	finally
    //   152	158	660	finally
    //   186	200	660	finally
    //   203	212	660	finally
    //   215	226	660	finally
    //   233	242	660	finally
    //   245	258	660	finally
    //   263	273	660	finally
    //   276	288	660	finally
    //   291	300	660	finally
    //   303	318	660	finally
    //   321	334	660	finally
    //   337	352	660	finally
    //   355	370	660	finally
    //   373	386	660	finally
    //   389	402	660	finally
    //   405	418	660	finally
    //   421	431	660	finally
    //   434	444	660	finally
    //   447	455	660	finally
    //   500	506	660	finally
    //   546	552	660	finally
    //   592	598	660	finally
    //   24	32	664	java/io/IOException
    //   35	52	670	java/io/IOException
    //   60	66	670	java/io/IOException
    //   94	108	670	java/io/IOException
    //   111	125	670	java/io/IOException
    //   128	135	670	java/io/IOException
    //   138	149	670	java/io/IOException
    //   152	158	670	java/io/IOException
    //   186	200	670	java/io/IOException
    //   203	212	670	java/io/IOException
    //   215	226	670	java/io/IOException
    //   233	242	670	java/io/IOException
    //   245	258	670	java/io/IOException
    //   263	273	670	java/io/IOException
    //   276	288	670	java/io/IOException
    //   291	300	670	java/io/IOException
    //   303	318	670	java/io/IOException
    //   321	334	670	java/io/IOException
    //   337	352	670	java/io/IOException
    //   355	370	670	java/io/IOException
    //   373	386	670	java/io/IOException
    //   389	402	670	java/io/IOException
    //   405	418	670	java/io/IOException
    //   421	431	670	java/io/IOException
    //   434	444	670	java/io/IOException
    //   447	455	670	java/io/IOException
    //   24	32	676	org/xml/sax/SAXException
    //   35	52	682	org/xml/sax/SAXException
    //   60	66	682	org/xml/sax/SAXException
    //   94	108	682	org/xml/sax/SAXException
    //   111	125	682	org/xml/sax/SAXException
    //   128	135	682	org/xml/sax/SAXException
    //   138	149	682	org/xml/sax/SAXException
    //   152	158	682	org/xml/sax/SAXException
    //   186	200	682	org/xml/sax/SAXException
    //   203	212	682	org/xml/sax/SAXException
    //   215	226	682	org/xml/sax/SAXException
    //   233	242	682	org/xml/sax/SAXException
    //   245	258	682	org/xml/sax/SAXException
    //   263	273	682	org/xml/sax/SAXException
    //   276	288	682	org/xml/sax/SAXException
    //   291	300	682	org/xml/sax/SAXException
    //   303	318	682	org/xml/sax/SAXException
    //   321	334	682	org/xml/sax/SAXException
    //   337	352	682	org/xml/sax/SAXException
    //   355	370	682	org/xml/sax/SAXException
    //   373	386	682	org/xml/sax/SAXException
    //   389	402	682	org/xml/sax/SAXException
    //   405	418	682	org/xml/sax/SAXException
    //   421	431	682	org/xml/sax/SAXException
    //   434	444	682	org/xml/sax/SAXException
    //   447	455	682	org/xml/sax/SAXException
    //   24	32	688	javax/xml/parsers/ParserConfigurationException
    //   35	52	694	javax/xml/parsers/ParserConfigurationException
    //   60	66	694	javax/xml/parsers/ParserConfigurationException
    //   94	108	694	javax/xml/parsers/ParserConfigurationException
    //   111	125	694	javax/xml/parsers/ParserConfigurationException
    //   128	135	694	javax/xml/parsers/ParserConfigurationException
    //   138	149	694	javax/xml/parsers/ParserConfigurationException
    //   152	158	694	javax/xml/parsers/ParserConfigurationException
    //   186	200	694	javax/xml/parsers/ParserConfigurationException
    //   203	212	694	javax/xml/parsers/ParserConfigurationException
    //   215	226	694	javax/xml/parsers/ParserConfigurationException
    //   233	242	694	javax/xml/parsers/ParserConfigurationException
    //   245	258	694	javax/xml/parsers/ParserConfigurationException
    //   263	273	694	javax/xml/parsers/ParserConfigurationException
    //   276	288	694	javax/xml/parsers/ParserConfigurationException
    //   291	300	694	javax/xml/parsers/ParserConfigurationException
    //   303	318	694	javax/xml/parsers/ParserConfigurationException
    //   321	334	694	javax/xml/parsers/ParserConfigurationException
    //   337	352	694	javax/xml/parsers/ParserConfigurationException
    //   355	370	694	javax/xml/parsers/ParserConfigurationException
    //   373	386	694	javax/xml/parsers/ParserConfigurationException
    //   389	402	694	javax/xml/parsers/ParserConfigurationException
    //   405	418	694	javax/xml/parsers/ParserConfigurationException
    //   421	431	694	javax/xml/parsers/ParserConfigurationException
    //   434	444	694	javax/xml/parsers/ParserConfigurationException
    //   447	455	694	javax/xml/parsers/ParserConfigurationException
  }
  
  public static final class a
  {
    public String IVm;
    public String IVn;
    public a.e[] IVo;
    public com.tencent.xweb.internal.a.a[] IVp;
    public String signature;
  }
  
  public static final class b
  {
    public String IVm;
    public int IVq;
    public String IVr;
    public boolean IVs;
    public boolean bUseCdn;
  }
  
  public static final class c
  {
    public String IVm = "";
    public String IVn = "";
    public com.tencent.xweb.internal.a.a[] IVp;
    public a.d[] IVt = null;
    public String signature;
  }
  
  public static final class d
  {
    public com.tencent.xweb.internal.a.b IPM;
    public String IVm;
    public String IVr;
    public boolean IVs;
    public String IVu;
    public int IVv;
    public int IVw;
    public a.b[] IVx;
    public boolean bUseCdn;
    
    public d()
    {
      AppMethodBeat.i(154534);
      this.IPM = new com.tencent.xweb.internal.a.c();
      this.IVu = "";
      this.IVr = "";
      this.IVm = "";
      this.IVv = 0;
      this.IVw = 0;
      this.IVx = null;
      AppMethodBeat.o(154534);
    }
  }
  
  public static final class e
  {
    com.tencent.xweb.internal.a.b IPM;
    public int IVA;
    public float IVB;
    public float IVC;
    public String IVD;
    public String IVE;
    public String IVF;
    public String IVm;
    public String IVr;
    public boolean IVs;
    public int IVw;
    public a.b[] IVx;
    public int IVy;
    public a.f IVz;
    public boolean bTryUseSharedCore;
    public boolean bUseCdn;
    
    public e()
    {
      AppMethodBeat.i(154535);
      this.IPM = new com.tencent.xweb.internal.a.c();
      this.IVz = new a.f();
      this.bTryUseSharedCore = true;
      this.IVB = -1.0F;
      this.IVC = -1.0F;
      AppMethodBeat.o(154535);
    }
  }
  
  public static final class f
  {
    public String IVG = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.a
 * JD-Core Version:    0.7.0.1
 */