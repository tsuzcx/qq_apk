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
    paramb.MsI = a(paramElement, "apkMin");
    paramb.MsJ = a(paramElement, "apkMax");
    paramb.MsK = a(paramElement, "preDownApkMin");
    paramb.MsL = a(paramElement, "preDownApkMax");
    paramb.MsG = a(paramElement, "sdkMin");
    paramb.MsH = a(paramElement, "sdkMax");
    paramb.MsM = a(paramElement, "apiMin");
    paramb.MsN = a(paramElement, "apiMax");
    paramb.MsO = paramElement.getAttribute("forbidDeviceRegex");
    paramb.MsP = paramElement.getAttribute("whiteDeviceRegex");
    paramb.MsZ = paramElement.getAttribute("forbidAppRegex");
    paramb.Mta = paramElement.getAttribute("whiteAppRegex");
    paramb.MsQ = a(paramElement, "grayMin");
    paramb.MsR = a(paramElement, "grayMax");
    paramb.MsS = a(paramElement, "dayGrayMin");
    paramb.MsT = a(paramElement, "dayGrayMax");
    paramb.MsU = a(paramElement, "chromeMin");
    paramb.MsV = a(paramElement, "chromeMax");
    paramb.MsW = a(paramElement, "usertype");
    paramb.Mtb = a(paramElement, "x5sdkmin");
    paramb.Mtc = a(paramElement, "x5sdkmax");
    paramb.Mtd = a(paramElement, "x5coremin");
    paramb.Mte = a(paramElement, "x5coremax");
    paramb.MsX = c(paramElement, "hoursStart");
    paramb.MsY = c(paramElement, "hoursEnd");
    paramb.Mtg = paramElement.getAttribute("runtimeAbis");
    paramb.Mti = paramElement.getAttribute("blackRuntimeAbis");
    paramb.Mtf = paramElement.getAttribute("deviceAbis");
    paramb.Mth = paramElement.getAttribute("blackDeviceAbis");
    paramb.Mtj = b(paramElement, "appClientVerMin");
    paramb.Mtk = b(paramElement, "appClientVerMax");
    paramb.Mtl = paramElement.getAttribute("appInfoWhiteList");
    paramb.Mtm = paramElement.getAttribute("appInfoBlackList");
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
        localc.Myl = localElement.getAttribute("url");
        localc.MyA = a(localElement, "targetVersion");
        localc.Mys = localElement.getAttribute("md5");
        localc.Myt = e(localElement, "useCellular");
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
    AppMethodBeat.i(195593);
    if (paramElement == null)
    {
      AppMethodBeat.o(195593);
      return 0;
    }
    paramString = paramElement.getAttribute(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(195593);
      return 0;
    }
    paramElement = paramString;
    if (paramString.contains("0x")) {
      paramElement = paramString.trim().substring(2);
    }
    try
    {
      int i = Integer.parseInt(paramElement, 16);
      AppMethodBeat.o(195593);
      return i;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetIntFromHex failed" + paramElement.getMessage());
      AppMethodBeat.o(195593);
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
          locala.MsD = localElement.getAttribute("optype");
          locala.MsE = localElement.getAttribute("opvalue");
          locala.MsF = localElement.getAttribute("module");
          a(locala.MsC, localElement);
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
  
  public static b bbC(String paramString)
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
    AppMethodBeat.i(195594);
    if (paramElement == null)
    {
      AppMethodBeat.o(195594);
      return -1.0F;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(195594);
      return -1.0F;
    }
    try
    {
      float f = Float.parseFloat(paramElement);
      AppMethodBeat.o(195594);
      return f;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetFloat failed : " + paramElement.getMessage());
      AppMethodBeat.o(195594);
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
  private static b i(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 477
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 483	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
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
    //   28: invokespecial 484	com/tencent/xweb/xwalk/updater/a$b:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 488	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 494	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 500 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 502
    //   63: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 98	java/io/FileInputStream:close	()V
    //   71: ldc_w 477
    //   74: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 58
    //   82: ldc_w 504
    //   85: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 506
    //   100: invokeinterface 44 2 0
    //   105: putfield 507	com/tencent/xweb/xwalk/updater/a$b:Mys	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: aload 5
    //   114: ldc_w 509
    //   117: invokeinterface 44 2 0
    //   122: putfield 511	com/tencent/xweb/xwalk/updater/a$b:signature	Ljava/lang/String;
    //   125: aload 4
    //   127: astore_0
    //   128: aload_3
    //   129: getfield 507	com/tencent/xweb/xwalk/updater/a$b:Mys	Ljava/lang/String;
    //   132: ifnull +17 -> 149
    //   135: aload 4
    //   137: astore_0
    //   138: aload_3
    //   139: getfield 507	com/tencent/xweb/xwalk/updater/a$b:Mys	Ljava/lang/String;
    //   142: aload_1
    //   143: invokevirtual 514	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifne +46 -> 192
    //   149: aload 4
    //   151: astore_0
    //   152: ldc2_w 515
    //   155: invokestatic 522	com/tencent/xweb/util/g:Fh	(J)V
    //   158: aload 4
    //   160: astore_0
    //   161: ldc_w 524
    //   164: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: invokevirtual 98	java/io/FileInputStream:close	()V
    //   172: ldc_w 477
    //   175: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: ldc 58
    //   183: ldc_w 504
    //   186: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -17 -> 172
    //   192: aload 4
    //   194: astore_0
    //   195: aload_3
    //   196: getfield 507	com/tencent/xweb/xwalk/updater/a$b:Mys	Ljava/lang/String;
    //   199: aload_3
    //   200: getfield 511	com/tencent/xweb/xwalk/updater/a$b:signature	Ljava/lang/String;
    //   203: ldc_w 526
    //   206: invokestatic 532	com/tencent/xweb/util/b:bn	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   209: ifne +46 -> 255
    //   212: aload 4
    //   214: astore_0
    //   215: ldc2_w 533
    //   218: invokestatic 522	com/tencent/xweb/util/g:Fh	(J)V
    //   221: aload 4
    //   223: astore_0
    //   224: ldc_w 536
    //   227: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   230: aload 4
    //   232: invokevirtual 98	java/io/FileInputStream:close	()V
    //   235: ldc_w 477
    //   238: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aconst_null
    //   242: areturn
    //   243: astore_0
    //   244: ldc 58
    //   246: ldc_w 504
    //   249: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: goto -17 -> 235
    //   255: aload 4
    //   257: astore_0
    //   258: aload_3
    //   259: aload 5
    //   261: ldc_w 538
    //   264: invokeinterface 44 2 0
    //   269: putfield 541	com/tencent/xweb/xwalk/updater/a$b:Myx	Ljava/lang/String;
    //   272: aload 4
    //   274: astore_0
    //   275: aload_3
    //   276: aload 5
    //   278: invokestatic 543	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/a$a;
    //   281: putfield 547	com/tencent/xweb/xwalk/updater/a$b:Myz	[Lcom/tencent/xweb/internal/a$a;
    //   284: aload 4
    //   286: astore_0
    //   287: aload 5
    //   289: ldc_w 549
    //   292: invokeinterface 328 2 0
    //   297: astore_1
    //   298: aload_1
    //   299: ifnull +508 -> 807
    //   302: aload 4
    //   304: astore_0
    //   305: aload_1
    //   306: invokeinterface 333 1 0
    //   311: ifeq +496 -> 807
    //   314: aload 4
    //   316: astore_0
    //   317: aload_3
    //   318: aload_1
    //   319: invokeinterface 333 1 0
    //   324: anewarray 21	com/tencent/xweb/xwalk/updater/a$f
    //   327: putfield 553	com/tencent/xweb/xwalk/updater/a$b:Myy	[Lcom/tencent/xweb/xwalk/updater/a$f;
    //   330: iconst_0
    //   331: istore_2
    //   332: aload 4
    //   334: astore_0
    //   335: iload_2
    //   336: aload_1
    //   337: invokeinterface 333 1 0
    //   342: if_icmpge +465 -> 807
    //   345: aload 4
    //   347: astore_0
    //   348: new 21	com/tencent/xweb/xwalk/updater/a$f
    //   351: dup
    //   352: invokespecial 554	com/tencent/xweb/xwalk/updater/a$f:<init>	()V
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
    //   379: ldc_w 556
    //   382: invokeinterface 44 2 0
    //   387: putfield 557	com/tencent/xweb/xwalk/updater/a$f:Myl	Ljava/lang/String;
    //   390: aload 4
    //   392: astore_0
    //   393: aload 5
    //   395: aload 6
    //   397: ldc_w 351
    //   400: invokeinterface 44 2 0
    //   405: putfield 558	com/tencent/xweb/xwalk/updater/a$f:Mys	Ljava/lang/String;
    //   408: aload 4
    //   410: astore_0
    //   411: aload 5
    //   413: getfield 559	com/tencent/xweb/xwalk/updater/a$f:MsC	Lcom/tencent/xweb/internal/a$b;
    //   416: aload 6
    //   418: invokestatic 411	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   421: aload 4
    //   423: astore_0
    //   424: aload 5
    //   426: aload 6
    //   428: ldc_w 561
    //   431: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   434: putfield 564	com/tencent/xweb/xwalk/updater/a$f:Myr	I
    //   437: aload 4
    //   439: astore_0
    //   440: aload 5
    //   442: aload 6
    //   444: ldc_w 566
    //   447: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   450: putfield 568	com/tencent/xweb/xwalk/updater/a$f:version	I
    //   453: aload 4
    //   455: astore_0
    //   456: aload 5
    //   458: aload 6
    //   460: ldc_w 356
    //   463: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   466: putfield 569	com/tencent/xweb/xwalk/updater/a$f:Myt	Z
    //   469: aload 4
    //   471: astore_0
    //   472: aload 5
    //   474: aload 6
    //   476: ldc_w 365
    //   479: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   482: putfield 570	com/tencent/xweb/xwalk/updater/a$f:bUseCdn	Z
    //   485: aload 4
    //   487: astore_0
    //   488: aload 5
    //   490: aload 6
    //   492: ldc_w 572
    //   495: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   498: putfield 575	com/tencent/xweb/xwalk/updater/a$f:Myk	I
    //   501: aload 4
    //   503: astore_0
    //   504: aload 5
    //   506: aload 6
    //   508: ldc_w 577
    //   511: invokeinterface 44 2 0
    //   516: putfield 580	com/tencent/xweb/xwalk/updater/a$f:Myo	Ljava/lang/String;
    //   519: aload 4
    //   521: astore_0
    //   522: aload 5
    //   524: aload 6
    //   526: ldc_w 582
    //   529: invokeinterface 44 2 0
    //   534: putfield 585	com/tencent/xweb/xwalk/updater/a$f:Myp	Ljava/lang/String;
    //   537: aload 4
    //   539: astore_0
    //   540: aload 5
    //   542: aload 6
    //   544: ldc_w 587
    //   547: invokeinterface 44 2 0
    //   552: putfield 590	com/tencent/xweb/xwalk/updater/a$f:MyF	Ljava/lang/String;
    //   555: aload 4
    //   557: astore_0
    //   558: aload 5
    //   560: aload 6
    //   562: ldc_w 592
    //   565: invokeinterface 44 2 0
    //   570: putfield 595	com/tencent/xweb/xwalk/updater/a$f:Myu	Ljava/lang/String;
    //   573: aload 4
    //   575: astore_0
    //   576: aload 5
    //   578: aload 6
    //   580: ldc_w 597
    //   583: invokeinterface 44 2 0
    //   588: putfield 600	com/tencent/xweb/xwalk/updater/a$f:Myv	Ljava/lang/String;
    //   591: aload 4
    //   593: astore_0
    //   594: aload 5
    //   596: aload 6
    //   598: ldc_w 602
    //   601: invokeinterface 44 2 0
    //   606: putfield 605	com/tencent/xweb/xwalk/updater/a$f:Myw	Ljava/lang/String;
    //   609: aload 4
    //   611: astore_0
    //   612: aload 5
    //   614: aload 6
    //   616: ldc_w 607
    //   619: invokestatic 609	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   622: putfield 613	com/tencent/xweb/xwalk/updater/a$f:Mym	F
    //   625: aload 4
    //   627: astore_0
    //   628: aload 5
    //   630: aload 6
    //   632: ldc_w 615
    //   635: invokestatic 609	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   638: putfield 618	com/tencent/xweb/xwalk/updater/a$f:Myn	F
    //   641: aload 4
    //   643: astore_0
    //   644: aload 6
    //   646: ldc_w 620
    //   649: invokeinterface 44 2 0
    //   654: astore 7
    //   656: aload 7
    //   658: ifnull +27 -> 685
    //   661: aload 4
    //   663: astore_0
    //   664: aload 7
    //   666: invokevirtual 50	java/lang/String:isEmpty	()Z
    //   669: ifne +16 -> 685
    //   672: aload 4
    //   674: astore_0
    //   675: aload 5
    //   677: aload 7
    //   679: invokestatic 470	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   682: putfield 623	com/tencent/xweb/xwalk/updater/a$f:bTryUseSharedCore	Z
    //   685: aload 4
    //   687: astore_0
    //   688: aload 5
    //   690: aload 6
    //   692: ldc_w 625
    //   695: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   698: putfield 628	com/tencent/xweb/xwalk/updater/a$f:MyE	Z
    //   701: aload 4
    //   703: astore_0
    //   704: aload 5
    //   706: getfield 632	com/tencent/xweb/xwalk/updater/a$f:MyD	Lcom/tencent/xweb/xwalk/updater/a$g;
    //   709: astore 7
    //   711: aload 7
    //   713: ifnull +63 -> 776
    //   716: aload 4
    //   718: astore_0
    //   719: aload 6
    //   721: ldc_w 634
    //   724: invokeinterface 328 2 0
    //   729: astore 8
    //   731: aload 8
    //   733: ifnull +43 -> 776
    //   736: aload 4
    //   738: astore_0
    //   739: aload 8
    //   741: invokeinterface 333 1 0
    //   746: ifeq +30 -> 776
    //   749: aload 4
    //   751: astore_0
    //   752: aload 7
    //   754: aload 8
    //   756: iconst_0
    //   757: invokeinterface 339 2 0
    //   762: checkcast 40	org/w3c/dom/Element
    //   765: ldc_w 636
    //   768: invokeinterface 44 2 0
    //   773: putfield 639	com/tencent/xweb/xwalk/updater/a$g:MyG	Ljava/lang/String;
    //   776: aload 4
    //   778: astore_0
    //   779: aload 5
    //   781: aload 6
    //   783: invokestatic 641	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   786: putfield 645	com/tencent/xweb/xwalk/updater/a$f:Myq	[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   789: aload 4
    //   791: astore_0
    //   792: aload_3
    //   793: getfield 553	com/tencent/xweb/xwalk/updater/a$b:Myy	[Lcom/tencent/xweb/xwalk/updater/a$f;
    //   796: iload_2
    //   797: aload 5
    //   799: aastore
    //   800: iload_2
    //   801: iconst_1
    //   802: iadd
    //   803: istore_2
    //   804: goto -472 -> 332
    //   807: aload 4
    //   809: invokevirtual 98	java/io/FileInputStream:close	()V
    //   812: aload_3
    //   813: astore_0
    //   814: ldc_w 477
    //   817: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   820: aload_0
    //   821: areturn
    //   822: astore_0
    //   823: ldc 58
    //   825: ldc_w 504
    //   828: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: aload_3
    //   832: astore_0
    //   833: goto -19 -> 814
    //   836: astore_0
    //   837: aconst_null
    //   838: astore 4
    //   840: aconst_null
    //   841: astore_1
    //   842: aload 4
    //   844: astore_0
    //   845: ldc_w 502
    //   848: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   851: aload_1
    //   852: astore_0
    //   853: aload 4
    //   855: ifnull -41 -> 814
    //   858: aload 4
    //   860: invokevirtual 98	java/io/FileInputStream:close	()V
    //   863: aload_1
    //   864: astore_0
    //   865: goto -51 -> 814
    //   868: astore_0
    //   869: ldc 58
    //   871: ldc_w 504
    //   874: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: aload_1
    //   878: astore_0
    //   879: goto -65 -> 814
    //   882: astore_0
    //   883: aconst_null
    //   884: astore 4
    //   886: aconst_null
    //   887: astore_1
    //   888: aload 4
    //   890: astore_0
    //   891: ldc_w 502
    //   894: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   897: aload_1
    //   898: astore_0
    //   899: aload 4
    //   901: ifnull -87 -> 814
    //   904: aload 4
    //   906: invokevirtual 98	java/io/FileInputStream:close	()V
    //   909: aload_1
    //   910: astore_0
    //   911: goto -97 -> 814
    //   914: astore_0
    //   915: ldc 58
    //   917: ldc_w 504
    //   920: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   923: aload_1
    //   924: astore_0
    //   925: goto -111 -> 814
    //   928: astore_0
    //   929: aconst_null
    //   930: astore 4
    //   932: aconst_null
    //   933: astore_1
    //   934: aload 4
    //   936: astore_0
    //   937: ldc_w 502
    //   940: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   943: aload_1
    //   944: astore_0
    //   945: aload 4
    //   947: ifnull -133 -> 814
    //   950: aload 4
    //   952: invokevirtual 98	java/io/FileInputStream:close	()V
    //   955: aload_1
    //   956: astore_0
    //   957: goto -143 -> 814
    //   960: astore_0
    //   961: ldc 58
    //   963: ldc_w 504
    //   966: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   969: aload_1
    //   970: astore_0
    //   971: goto -157 -> 814
    //   974: astore_1
    //   975: aconst_null
    //   976: astore_0
    //   977: aload_0
    //   978: ifnull +7 -> 985
    //   981: aload_0
    //   982: invokevirtual 98	java/io/FileInputStream:close	()V
    //   985: ldc_w 477
    //   988: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   991: aload_1
    //   992: athrow
    //   993: astore_0
    //   994: ldc 58
    //   996: ldc_w 504
    //   999: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1002: goto -17 -> 985
    //   1005: astore_1
    //   1006: goto -29 -> 977
    //   1009: astore_0
    //   1010: aconst_null
    //   1011: astore_1
    //   1012: goto -78 -> 934
    //   1015: astore_0
    //   1016: aload_3
    //   1017: astore_1
    //   1018: goto -84 -> 934
    //   1021: astore_0
    //   1022: aconst_null
    //   1023: astore_1
    //   1024: goto -136 -> 888
    //   1027: astore_0
    //   1028: aload_3
    //   1029: astore_1
    //   1030: goto -142 -> 888
    //   1033: astore_0
    //   1034: aconst_null
    //   1035: astore_1
    //   1036: goto -194 -> 842
    //   1039: astore_0
    //   1040: aload_3
    //   1041: astore_1
    //   1042: goto -200 -> 842
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1045	0	paramFile	File
    //   0	1045	1	paramString	String
    //   331	473	2	i	int
    //   31	1010	3	localb	b
    //   19	932	4	localFileInputStream	java.io.FileInputStream
    //   9	789	5	localObject1	Object
    //   370	412	6	localElement	Element
    //   654	99	7	localObject2	Object
    //   729	26	8	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   66	71	79	java/lang/Exception
    //   167	172	180	java/lang/Exception
    //   230	235	243	java/lang/Exception
    //   807	812	822	java/lang/Exception
    //   11	21	836	javax/xml/parsers/ParserConfigurationException
    //   858	863	868	java/lang/Exception
    //   11	21	882	org/xml/sax/SAXException
    //   904	909	914	java/lang/Exception
    //   11	21	928	java/io/IOException
    //   950	955	960	java/lang/Exception
    //   11	21	974	finally
    //   981	985	993	java/lang/Exception
    //   24	32	1005	finally
    //   35	52	1005	finally
    //   60	66	1005	finally
    //   94	108	1005	finally
    //   111	125	1005	finally
    //   128	135	1005	finally
    //   138	149	1005	finally
    //   152	158	1005	finally
    //   161	167	1005	finally
    //   195	212	1005	finally
    //   215	221	1005	finally
    //   224	230	1005	finally
    //   258	272	1005	finally
    //   275	284	1005	finally
    //   287	298	1005	finally
    //   305	314	1005	finally
    //   317	330	1005	finally
    //   335	345	1005	finally
    //   348	357	1005	finally
    //   360	372	1005	finally
    //   375	390	1005	finally
    //   393	408	1005	finally
    //   411	421	1005	finally
    //   424	437	1005	finally
    //   440	453	1005	finally
    //   456	469	1005	finally
    //   472	485	1005	finally
    //   488	501	1005	finally
    //   504	519	1005	finally
    //   522	537	1005	finally
    //   540	555	1005	finally
    //   558	573	1005	finally
    //   576	591	1005	finally
    //   594	609	1005	finally
    //   612	625	1005	finally
    //   628	641	1005	finally
    //   644	656	1005	finally
    //   664	672	1005	finally
    //   675	685	1005	finally
    //   688	701	1005	finally
    //   704	711	1005	finally
    //   719	731	1005	finally
    //   739	749	1005	finally
    //   752	776	1005	finally
    //   779	789	1005	finally
    //   792	800	1005	finally
    //   845	851	1005	finally
    //   891	897	1005	finally
    //   937	943	1005	finally
    //   24	32	1009	java/io/IOException
    //   35	52	1015	java/io/IOException
    //   60	66	1015	java/io/IOException
    //   94	108	1015	java/io/IOException
    //   111	125	1015	java/io/IOException
    //   128	135	1015	java/io/IOException
    //   138	149	1015	java/io/IOException
    //   152	158	1015	java/io/IOException
    //   161	167	1015	java/io/IOException
    //   195	212	1015	java/io/IOException
    //   215	221	1015	java/io/IOException
    //   224	230	1015	java/io/IOException
    //   258	272	1015	java/io/IOException
    //   275	284	1015	java/io/IOException
    //   287	298	1015	java/io/IOException
    //   305	314	1015	java/io/IOException
    //   317	330	1015	java/io/IOException
    //   335	345	1015	java/io/IOException
    //   348	357	1015	java/io/IOException
    //   360	372	1015	java/io/IOException
    //   375	390	1015	java/io/IOException
    //   393	408	1015	java/io/IOException
    //   411	421	1015	java/io/IOException
    //   424	437	1015	java/io/IOException
    //   440	453	1015	java/io/IOException
    //   456	469	1015	java/io/IOException
    //   472	485	1015	java/io/IOException
    //   488	501	1015	java/io/IOException
    //   504	519	1015	java/io/IOException
    //   522	537	1015	java/io/IOException
    //   540	555	1015	java/io/IOException
    //   558	573	1015	java/io/IOException
    //   576	591	1015	java/io/IOException
    //   594	609	1015	java/io/IOException
    //   612	625	1015	java/io/IOException
    //   628	641	1015	java/io/IOException
    //   644	656	1015	java/io/IOException
    //   664	672	1015	java/io/IOException
    //   675	685	1015	java/io/IOException
    //   688	701	1015	java/io/IOException
    //   704	711	1015	java/io/IOException
    //   719	731	1015	java/io/IOException
    //   739	749	1015	java/io/IOException
    //   752	776	1015	java/io/IOException
    //   779	789	1015	java/io/IOException
    //   792	800	1015	java/io/IOException
    //   24	32	1021	org/xml/sax/SAXException
    //   35	52	1027	org/xml/sax/SAXException
    //   60	66	1027	org/xml/sax/SAXException
    //   94	108	1027	org/xml/sax/SAXException
    //   111	125	1027	org/xml/sax/SAXException
    //   128	135	1027	org/xml/sax/SAXException
    //   138	149	1027	org/xml/sax/SAXException
    //   152	158	1027	org/xml/sax/SAXException
    //   161	167	1027	org/xml/sax/SAXException
    //   195	212	1027	org/xml/sax/SAXException
    //   215	221	1027	org/xml/sax/SAXException
    //   224	230	1027	org/xml/sax/SAXException
    //   258	272	1027	org/xml/sax/SAXException
    //   275	284	1027	org/xml/sax/SAXException
    //   287	298	1027	org/xml/sax/SAXException
    //   305	314	1027	org/xml/sax/SAXException
    //   317	330	1027	org/xml/sax/SAXException
    //   335	345	1027	org/xml/sax/SAXException
    //   348	357	1027	org/xml/sax/SAXException
    //   360	372	1027	org/xml/sax/SAXException
    //   375	390	1027	org/xml/sax/SAXException
    //   393	408	1027	org/xml/sax/SAXException
    //   411	421	1027	org/xml/sax/SAXException
    //   424	437	1027	org/xml/sax/SAXException
    //   440	453	1027	org/xml/sax/SAXException
    //   456	469	1027	org/xml/sax/SAXException
    //   472	485	1027	org/xml/sax/SAXException
    //   488	501	1027	org/xml/sax/SAXException
    //   504	519	1027	org/xml/sax/SAXException
    //   522	537	1027	org/xml/sax/SAXException
    //   540	555	1027	org/xml/sax/SAXException
    //   558	573	1027	org/xml/sax/SAXException
    //   576	591	1027	org/xml/sax/SAXException
    //   594	609	1027	org/xml/sax/SAXException
    //   612	625	1027	org/xml/sax/SAXException
    //   628	641	1027	org/xml/sax/SAXException
    //   644	656	1027	org/xml/sax/SAXException
    //   664	672	1027	org/xml/sax/SAXException
    //   675	685	1027	org/xml/sax/SAXException
    //   688	701	1027	org/xml/sax/SAXException
    //   704	711	1027	org/xml/sax/SAXException
    //   719	731	1027	org/xml/sax/SAXException
    //   739	749	1027	org/xml/sax/SAXException
    //   752	776	1027	org/xml/sax/SAXException
    //   779	789	1027	org/xml/sax/SAXException
    //   792	800	1027	org/xml/sax/SAXException
    //   24	32	1033	javax/xml/parsers/ParserConfigurationException
    //   35	52	1039	javax/xml/parsers/ParserConfigurationException
    //   60	66	1039	javax/xml/parsers/ParserConfigurationException
    //   94	108	1039	javax/xml/parsers/ParserConfigurationException
    //   111	125	1039	javax/xml/parsers/ParserConfigurationException
    //   128	135	1039	javax/xml/parsers/ParserConfigurationException
    //   138	149	1039	javax/xml/parsers/ParserConfigurationException
    //   152	158	1039	javax/xml/parsers/ParserConfigurationException
    //   161	167	1039	javax/xml/parsers/ParserConfigurationException
    //   195	212	1039	javax/xml/parsers/ParserConfigurationException
    //   215	221	1039	javax/xml/parsers/ParserConfigurationException
    //   224	230	1039	javax/xml/parsers/ParserConfigurationException
    //   258	272	1039	javax/xml/parsers/ParserConfigurationException
    //   275	284	1039	javax/xml/parsers/ParserConfigurationException
    //   287	298	1039	javax/xml/parsers/ParserConfigurationException
    //   305	314	1039	javax/xml/parsers/ParserConfigurationException
    //   317	330	1039	javax/xml/parsers/ParserConfigurationException
    //   335	345	1039	javax/xml/parsers/ParserConfigurationException
    //   348	357	1039	javax/xml/parsers/ParserConfigurationException
    //   360	372	1039	javax/xml/parsers/ParserConfigurationException
    //   375	390	1039	javax/xml/parsers/ParserConfigurationException
    //   393	408	1039	javax/xml/parsers/ParserConfigurationException
    //   411	421	1039	javax/xml/parsers/ParserConfigurationException
    //   424	437	1039	javax/xml/parsers/ParserConfigurationException
    //   440	453	1039	javax/xml/parsers/ParserConfigurationException
    //   456	469	1039	javax/xml/parsers/ParserConfigurationException
    //   472	485	1039	javax/xml/parsers/ParserConfigurationException
    //   488	501	1039	javax/xml/parsers/ParserConfigurationException
    //   504	519	1039	javax/xml/parsers/ParserConfigurationException
    //   522	537	1039	javax/xml/parsers/ParserConfigurationException
    //   540	555	1039	javax/xml/parsers/ParserConfigurationException
    //   558	573	1039	javax/xml/parsers/ParserConfigurationException
    //   576	591	1039	javax/xml/parsers/ParserConfigurationException
    //   594	609	1039	javax/xml/parsers/ParserConfigurationException
    //   612	625	1039	javax/xml/parsers/ParserConfigurationException
    //   628	641	1039	javax/xml/parsers/ParserConfigurationException
    //   644	656	1039	javax/xml/parsers/ParserConfigurationException
    //   664	672	1039	javax/xml/parsers/ParserConfigurationException
    //   675	685	1039	javax/xml/parsers/ParserConfigurationException
    //   688	701	1039	javax/xml/parsers/ParserConfigurationException
    //   704	711	1039	javax/xml/parsers/ParserConfigurationException
    //   719	731	1039	javax/xml/parsers/ParserConfigurationException
    //   739	749	1039	javax/xml/parsers/ParserConfigurationException
    //   752	776	1039	javax/xml/parsers/ParserConfigurationException
    //   779	789	1039	javax/xml/parsers/ParserConfigurationException
    //   792	800	1039	javax/xml/parsers/ParserConfigurationException
  }
  
  /* Error */
  public static d j(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 648
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 483	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
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
    //   28: invokespecial 649	com/tencent/xweb/xwalk/updater/a$d:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 488	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 494	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 500 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 651
    //   63: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 98	java/io/FileInputStream:close	()V
    //   71: ldc_w 648
    //   74: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 58
    //   82: ldc_w 653
    //   85: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 506
    //   100: invokeinterface 44 2 0
    //   105: putfield 654	com/tencent/xweb/xwalk/updater/a$d:Mys	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: aload 5
    //   114: ldc_w 509
    //   117: invokeinterface 44 2 0
    //   122: putfield 655	com/tencent/xweb/xwalk/updater/a$d:signature	Ljava/lang/String;
    //   125: aload 4
    //   127: astore_0
    //   128: aload_3
    //   129: getfield 654	com/tencent/xweb/xwalk/updater/a$d:Mys	Ljava/lang/String;
    //   132: ifnull +17 -> 149
    //   135: aload 4
    //   137: astore_0
    //   138: aload_3
    //   139: getfield 654	com/tencent/xweb/xwalk/updater/a$d:Mys	Ljava/lang/String;
    //   142: aload_1
    //   143: invokevirtual 514	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifne +37 -> 183
    //   149: aload 4
    //   151: astore_0
    //   152: ldc_w 657
    //   155: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 98	java/io/FileInputStream:close	()V
    //   163: ldc_w 648
    //   166: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: ldc 58
    //   174: ldc_w 653
    //   177: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto -17 -> 163
    //   183: aload 4
    //   185: astore_0
    //   186: aload_3
    //   187: getfield 654	com/tencent/xweb/xwalk/updater/a$d:Mys	Ljava/lang/String;
    //   190: aload_3
    //   191: getfield 655	com/tencent/xweb/xwalk/updater/a$d:signature	Ljava/lang/String;
    //   194: ldc_w 526
    //   197: invokestatic 532	com/tencent/xweb/util/b:bn	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   200: ifne +46 -> 246
    //   203: aload 4
    //   205: astore_0
    //   206: ldc2_w 533
    //   209: invokestatic 522	com/tencent/xweb/util/g:Fh	(J)V
    //   212: aload 4
    //   214: astore_0
    //   215: ldc_w 659
    //   218: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   221: aload 4
    //   223: invokevirtual 98	java/io/FileInputStream:close	()V
    //   226: ldc_w 648
    //   229: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: ldc 58
    //   237: ldc_w 653
    //   240: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -17 -> 226
    //   246: aload 4
    //   248: astore_0
    //   249: aload_3
    //   250: aload 5
    //   252: ldc_w 538
    //   255: invokeinterface 44 2 0
    //   260: putfield 660	com/tencent/xweb/xwalk/updater/a$d:Myx	Ljava/lang/String;
    //   263: aload 4
    //   265: astore_0
    //   266: aload_3
    //   267: aload 5
    //   269: invokestatic 543	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/a$a;
    //   272: putfield 661	com/tencent/xweb/xwalk/updater/a$d:Myz	[Lcom/tencent/xweb/internal/a$a;
    //   275: aload 4
    //   277: astore_0
    //   278: aload 5
    //   280: ldc_w 663
    //   283: invokeinterface 328 2 0
    //   288: astore_1
    //   289: aload_1
    //   290: ifnull +373 -> 663
    //   293: aload 4
    //   295: astore_0
    //   296: aload_1
    //   297: invokeinterface 333 1 0
    //   302: ifeq +361 -> 663
    //   305: aload 4
    //   307: astore_0
    //   308: aload_3
    //   309: aload_1
    //   310: invokeinterface 333 1 0
    //   315: anewarray 18	com/tencent/xweb/xwalk/updater/a$e
    //   318: putfield 667	com/tencent/xweb/xwalk/updater/a$d:MyB	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   321: iconst_0
    //   322: istore_2
    //   323: aload 4
    //   325: astore_0
    //   326: iload_2
    //   327: aload_1
    //   328: invokeinterface 333 1 0
    //   333: if_icmpge +330 -> 663
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
    //   358: invokespecial 668	com/tencent/xweb/xwalk/updater/a$e:<init>	()V
    //   361: astore 6
    //   363: aload 4
    //   365: astore_0
    //   366: aload 6
    //   368: aload 5
    //   370: ldc_w 670
    //   373: invokeinterface 44 2 0
    //   378: putfield 673	com/tencent/xweb/xwalk/updater/a$e:MyC	Ljava/lang/String;
    //   381: aload 4
    //   383: astore_0
    //   384: aload 6
    //   386: aload 5
    //   388: ldc_w 566
    //   391: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   394: putfield 674	com/tencent/xweb/xwalk/updater/a$e:version	I
    //   397: aload 4
    //   399: astore_0
    //   400: aload 6
    //   402: aload 5
    //   404: ldc_w 556
    //   407: invokeinterface 44 2 0
    //   412: putfield 675	com/tencent/xweb/xwalk/updater/a$e:Myl	Ljava/lang/String;
    //   415: aload 4
    //   417: astore_0
    //   418: aload 6
    //   420: aload 5
    //   422: ldc_w 351
    //   425: invokeinterface 44 2 0
    //   430: putfield 676	com/tencent/xweb/xwalk/updater/a$e:Mys	Ljava/lang/String;
    //   433: aload 4
    //   435: astore_0
    //   436: aload 6
    //   438: aload 5
    //   440: ldc_w 356
    //   443: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   446: putfield 677	com/tencent/xweb/xwalk/updater/a$e:Myt	Z
    //   449: aload 4
    //   451: astore_0
    //   452: aload 6
    //   454: aload 5
    //   456: ldc_w 365
    //   459: invokestatic 359	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   462: putfield 678	com/tencent/xweb/xwalk/updater/a$e:bUseCdn	Z
    //   465: aload 4
    //   467: astore_0
    //   468: aload 6
    //   470: aload 5
    //   472: ldc_w 561
    //   475: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   478: putfield 679	com/tencent/xweb/xwalk/updater/a$e:Myr	I
    //   481: aload 4
    //   483: astore_0
    //   484: aload 6
    //   486: aload 5
    //   488: ldc_w 572
    //   491: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   494: putfield 680	com/tencent/xweb/xwalk/updater/a$e:Myk	I
    //   497: aload 4
    //   499: astore_0
    //   500: aload 6
    //   502: aload 5
    //   504: ldc_w 577
    //   507: invokeinterface 44 2 0
    //   512: putfield 681	com/tencent/xweb/xwalk/updater/a$e:Myo	Ljava/lang/String;
    //   515: aload 4
    //   517: astore_0
    //   518: aload 6
    //   520: aload 5
    //   522: ldc_w 582
    //   525: invokeinterface 44 2 0
    //   530: putfield 682	com/tencent/xweb/xwalk/updater/a$e:Myp	Ljava/lang/String;
    //   533: aload 4
    //   535: astore_0
    //   536: aload 6
    //   538: aload 5
    //   540: ldc_w 592
    //   543: invokeinterface 44 2 0
    //   548: putfield 683	com/tencent/xweb/xwalk/updater/a$e:Myu	Ljava/lang/String;
    //   551: aload 4
    //   553: astore_0
    //   554: aload 6
    //   556: aload 5
    //   558: ldc_w 597
    //   561: invokeinterface 44 2 0
    //   566: putfield 684	com/tencent/xweb/xwalk/updater/a$e:Myv	Ljava/lang/String;
    //   569: aload 4
    //   571: astore_0
    //   572: aload 6
    //   574: aload 5
    //   576: ldc_w 602
    //   579: invokeinterface 44 2 0
    //   584: putfield 685	com/tencent/xweb/xwalk/updater/a$e:Myw	Ljava/lang/String;
    //   587: aload 4
    //   589: astore_0
    //   590: aload 6
    //   592: aload 5
    //   594: ldc_w 607
    //   597: invokestatic 609	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   600: putfield 686	com/tencent/xweb/xwalk/updater/a$e:Mym	F
    //   603: aload 4
    //   605: astore_0
    //   606: aload 6
    //   608: aload 5
    //   610: ldc_w 615
    //   613: invokestatic 609	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   616: putfield 687	com/tencent/xweb/xwalk/updater/a$e:Myn	F
    //   619: aload 4
    //   621: astore_0
    //   622: aload 6
    //   624: getfield 688	com/tencent/xweb/xwalk/updater/a$e:MsC	Lcom/tencent/xweb/internal/a$b;
    //   627: aload 5
    //   629: invokestatic 411	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   632: aload 4
    //   634: astore_0
    //   635: aload 6
    //   637: aload 5
    //   639: invokestatic 641	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   642: putfield 689	com/tencent/xweb/xwalk/updater/a$e:Myq	[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   645: aload 4
    //   647: astore_0
    //   648: aload_3
    //   649: getfield 667	com/tencent/xweb/xwalk/updater/a$d:MyB	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   652: iload_2
    //   653: aload 6
    //   655: aastore
    //   656: iload_2
    //   657: iconst_1
    //   658: iadd
    //   659: istore_2
    //   660: goto -337 -> 323
    //   663: aload 4
    //   665: invokevirtual 98	java/io/FileInputStream:close	()V
    //   668: aload_3
    //   669: astore_0
    //   670: ldc_w 648
    //   673: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   676: aload_0
    //   677: areturn
    //   678: astore_0
    //   679: ldc 58
    //   681: ldc_w 653
    //   684: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   687: aload_3
    //   688: astore_0
    //   689: goto -19 -> 670
    //   692: astore_0
    //   693: aconst_null
    //   694: astore 4
    //   696: aconst_null
    //   697: astore_1
    //   698: aload 4
    //   700: astore_0
    //   701: ldc_w 691
    //   704: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   707: aload_1
    //   708: astore_0
    //   709: aload 4
    //   711: ifnull -41 -> 670
    //   714: aload 4
    //   716: invokevirtual 98	java/io/FileInputStream:close	()V
    //   719: aload_1
    //   720: astore_0
    //   721: goto -51 -> 670
    //   724: astore_0
    //   725: ldc 58
    //   727: ldc_w 653
    //   730: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload_1
    //   734: astore_0
    //   735: goto -65 -> 670
    //   738: astore_0
    //   739: aconst_null
    //   740: astore 4
    //   742: aconst_null
    //   743: astore_1
    //   744: aload 4
    //   746: astore_0
    //   747: ldc_w 693
    //   750: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   753: aload_1
    //   754: astore_0
    //   755: aload 4
    //   757: ifnull -87 -> 670
    //   760: aload 4
    //   762: invokevirtual 98	java/io/FileInputStream:close	()V
    //   765: aload_1
    //   766: astore_0
    //   767: goto -97 -> 670
    //   770: astore_0
    //   771: ldc 58
    //   773: ldc_w 653
    //   776: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: aload_1
    //   780: astore_0
    //   781: goto -111 -> 670
    //   784: astore_0
    //   785: aconst_null
    //   786: astore 4
    //   788: aconst_null
    //   789: astore_1
    //   790: aload 4
    //   792: astore_0
    //   793: ldc_w 695
    //   796: invokestatic 423	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   799: aload_1
    //   800: astore_0
    //   801: aload 4
    //   803: ifnull -133 -> 670
    //   806: aload 4
    //   808: invokevirtual 98	java/io/FileInputStream:close	()V
    //   811: aload_1
    //   812: astore_0
    //   813: goto -143 -> 670
    //   816: astore_0
    //   817: ldc 58
    //   819: ldc_w 653
    //   822: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: aload_1
    //   826: astore_0
    //   827: goto -157 -> 670
    //   830: astore_1
    //   831: aconst_null
    //   832: astore_0
    //   833: aload_0
    //   834: ifnull +7 -> 841
    //   837: aload_0
    //   838: invokevirtual 98	java/io/FileInputStream:close	()V
    //   841: ldc_w 648
    //   844: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   847: aload_1
    //   848: athrow
    //   849: astore_0
    //   850: ldc 58
    //   852: ldc_w 653
    //   855: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   858: goto -17 -> 841
    //   861: astore_1
    //   862: goto -29 -> 833
    //   865: astore_0
    //   866: aconst_null
    //   867: astore_1
    //   868: goto -78 -> 790
    //   871: astore_0
    //   872: aload_3
    //   873: astore_1
    //   874: goto -84 -> 790
    //   877: astore_0
    //   878: aconst_null
    //   879: astore_1
    //   880: goto -136 -> 744
    //   883: astore_0
    //   884: aload_3
    //   885: astore_1
    //   886: goto -142 -> 744
    //   889: astore_0
    //   890: aconst_null
    //   891: astore_1
    //   892: goto -194 -> 698
    //   895: astore_0
    //   896: aload_3
    //   897: astore_1
    //   898: goto -200 -> 698
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	901	0	paramFile	File
    //   0	901	1	paramString	String
    //   322	338	2	i	int
    //   31	866	3	locald	d
    //   19	788	4	localFileInputStream	java.io.FileInputStream
    //   9	629	5	localObject	Object
    //   361	293	6	locale	e
    // Exception table:
    //   from	to	target	type
    //   66	71	79	java/lang/Exception
    //   158	163	171	java/lang/Exception
    //   221	226	234	java/lang/Exception
    //   663	668	678	java/lang/Exception
    //   11	21	692	javax/xml/parsers/ParserConfigurationException
    //   714	719	724	java/lang/Exception
    //   11	21	738	org/xml/sax/SAXException
    //   760	765	770	java/lang/Exception
    //   11	21	784	java/io/IOException
    //   806	811	816	java/lang/Exception
    //   11	21	830	finally
    //   837	841	849	java/lang/Exception
    //   24	32	861	finally
    //   35	52	861	finally
    //   60	66	861	finally
    //   94	108	861	finally
    //   111	125	861	finally
    //   128	135	861	finally
    //   138	149	861	finally
    //   152	158	861	finally
    //   186	203	861	finally
    //   206	212	861	finally
    //   215	221	861	finally
    //   249	263	861	finally
    //   266	275	861	finally
    //   278	289	861	finally
    //   296	305	861	finally
    //   308	321	861	finally
    //   326	336	861	finally
    //   339	351	861	finally
    //   354	363	861	finally
    //   366	381	861	finally
    //   384	397	861	finally
    //   400	415	861	finally
    //   418	433	861	finally
    //   436	449	861	finally
    //   452	465	861	finally
    //   468	481	861	finally
    //   484	497	861	finally
    //   500	515	861	finally
    //   518	533	861	finally
    //   536	551	861	finally
    //   554	569	861	finally
    //   572	587	861	finally
    //   590	603	861	finally
    //   606	619	861	finally
    //   622	632	861	finally
    //   635	645	861	finally
    //   648	656	861	finally
    //   701	707	861	finally
    //   747	753	861	finally
    //   793	799	861	finally
    //   24	32	865	java/io/IOException
    //   35	52	871	java/io/IOException
    //   60	66	871	java/io/IOException
    //   94	108	871	java/io/IOException
    //   111	125	871	java/io/IOException
    //   128	135	871	java/io/IOException
    //   138	149	871	java/io/IOException
    //   152	158	871	java/io/IOException
    //   186	203	871	java/io/IOException
    //   206	212	871	java/io/IOException
    //   215	221	871	java/io/IOException
    //   249	263	871	java/io/IOException
    //   266	275	871	java/io/IOException
    //   278	289	871	java/io/IOException
    //   296	305	871	java/io/IOException
    //   308	321	871	java/io/IOException
    //   326	336	871	java/io/IOException
    //   339	351	871	java/io/IOException
    //   354	363	871	java/io/IOException
    //   366	381	871	java/io/IOException
    //   384	397	871	java/io/IOException
    //   400	415	871	java/io/IOException
    //   418	433	871	java/io/IOException
    //   436	449	871	java/io/IOException
    //   452	465	871	java/io/IOException
    //   468	481	871	java/io/IOException
    //   484	497	871	java/io/IOException
    //   500	515	871	java/io/IOException
    //   518	533	871	java/io/IOException
    //   536	551	871	java/io/IOException
    //   554	569	871	java/io/IOException
    //   572	587	871	java/io/IOException
    //   590	603	871	java/io/IOException
    //   606	619	871	java/io/IOException
    //   622	632	871	java/io/IOException
    //   635	645	871	java/io/IOException
    //   648	656	871	java/io/IOException
    //   24	32	877	org/xml/sax/SAXException
    //   35	52	883	org/xml/sax/SAXException
    //   60	66	883	org/xml/sax/SAXException
    //   94	108	883	org/xml/sax/SAXException
    //   111	125	883	org/xml/sax/SAXException
    //   128	135	883	org/xml/sax/SAXException
    //   138	149	883	org/xml/sax/SAXException
    //   152	158	883	org/xml/sax/SAXException
    //   186	203	883	org/xml/sax/SAXException
    //   206	212	883	org/xml/sax/SAXException
    //   215	221	883	org/xml/sax/SAXException
    //   249	263	883	org/xml/sax/SAXException
    //   266	275	883	org/xml/sax/SAXException
    //   278	289	883	org/xml/sax/SAXException
    //   296	305	883	org/xml/sax/SAXException
    //   308	321	883	org/xml/sax/SAXException
    //   326	336	883	org/xml/sax/SAXException
    //   339	351	883	org/xml/sax/SAXException
    //   354	363	883	org/xml/sax/SAXException
    //   366	381	883	org/xml/sax/SAXException
    //   384	397	883	org/xml/sax/SAXException
    //   400	415	883	org/xml/sax/SAXException
    //   418	433	883	org/xml/sax/SAXException
    //   436	449	883	org/xml/sax/SAXException
    //   452	465	883	org/xml/sax/SAXException
    //   468	481	883	org/xml/sax/SAXException
    //   484	497	883	org/xml/sax/SAXException
    //   500	515	883	org/xml/sax/SAXException
    //   518	533	883	org/xml/sax/SAXException
    //   536	551	883	org/xml/sax/SAXException
    //   554	569	883	org/xml/sax/SAXException
    //   572	587	883	org/xml/sax/SAXException
    //   590	603	883	org/xml/sax/SAXException
    //   606	619	883	org/xml/sax/SAXException
    //   622	632	883	org/xml/sax/SAXException
    //   635	645	883	org/xml/sax/SAXException
    //   648	656	883	org/xml/sax/SAXException
    //   24	32	889	javax/xml/parsers/ParserConfigurationException
    //   35	52	895	javax/xml/parsers/ParserConfigurationException
    //   60	66	895	javax/xml/parsers/ParserConfigurationException
    //   94	108	895	javax/xml/parsers/ParserConfigurationException
    //   111	125	895	javax/xml/parsers/ParserConfigurationException
    //   128	135	895	javax/xml/parsers/ParserConfigurationException
    //   138	149	895	javax/xml/parsers/ParserConfigurationException
    //   152	158	895	javax/xml/parsers/ParserConfigurationException
    //   186	203	895	javax/xml/parsers/ParserConfigurationException
    //   206	212	895	javax/xml/parsers/ParserConfigurationException
    //   215	221	895	javax/xml/parsers/ParserConfigurationException
    //   249	263	895	javax/xml/parsers/ParserConfigurationException
    //   266	275	895	javax/xml/parsers/ParserConfigurationException
    //   278	289	895	javax/xml/parsers/ParserConfigurationException
    //   296	305	895	javax/xml/parsers/ParserConfigurationException
    //   308	321	895	javax/xml/parsers/ParserConfigurationException
    //   326	336	895	javax/xml/parsers/ParserConfigurationException
    //   339	351	895	javax/xml/parsers/ParserConfigurationException
    //   354	363	895	javax/xml/parsers/ParserConfigurationException
    //   366	381	895	javax/xml/parsers/ParserConfigurationException
    //   384	397	895	javax/xml/parsers/ParserConfigurationException
    //   400	415	895	javax/xml/parsers/ParserConfigurationException
    //   418	433	895	javax/xml/parsers/ParserConfigurationException
    //   436	449	895	javax/xml/parsers/ParserConfigurationException
    //   452	465	895	javax/xml/parsers/ParserConfigurationException
    //   468	481	895	javax/xml/parsers/ParserConfigurationException
    //   484	497	895	javax/xml/parsers/ParserConfigurationException
    //   500	515	895	javax/xml/parsers/ParserConfigurationException
    //   518	533	895	javax/xml/parsers/ParserConfigurationException
    //   536	551	895	javax/xml/parsers/ParserConfigurationException
    //   554	569	895	javax/xml/parsers/ParserConfigurationException
    //   572	587	895	javax/xml/parsers/ParserConfigurationException
    //   590	603	895	javax/xml/parsers/ParserConfigurationException
    //   606	619	895	javax/xml/parsers/ParserConfigurationException
    //   622	632	895	javax/xml/parsers/ParserConfigurationException
    //   635	645	895	javax/xml/parsers/ParserConfigurationException
    //   648	656	895	javax/xml/parsers/ParserConfigurationException
  }
  
  public static class a
  {
    public com.tencent.xweb.internal.a.b MsC;
    public int Myk;
    public String Myl;
    public float Mym;
    public float Myn;
    public String Myo;
    public String Myp;
    public a.c[] Myq;
    public int Myr;
    public String Mys;
    public boolean Myt;
    public String Myu;
    public String Myv;
    public String Myw;
    public boolean bUseCdn;
    public int version;
    
    public a()
    {
      AppMethodBeat.i(195592);
      this.MsC = new com.tencent.xweb.internal.a.c();
      this.Mym = -1.0F;
      this.Myn = -1.0F;
      AppMethodBeat.o(195592);
    }
  }
  
  public static final class b
  {
    public String Mys;
    public String Myx;
    public a.f[] Myy;
    public com.tencent.xweb.internal.a.a[] Myz;
    public String signature;
  }
  
  public static final class c
  {
    public int MyA;
    public String Myl;
    public String Mys;
    public boolean Myt;
    public boolean bUseCdn;
  }
  
  public static final class d
  {
    public a.e[] MyB = null;
    public String Mys = "";
    public String Myx = "";
    public com.tencent.xweb.internal.a.a[] Myz;
    public String signature;
  }
  
  public static final class e
    extends a.a
  {
    public String MyC;
    
    public e()
    {
      AppMethodBeat.i(154534);
      this.MyC = "";
      AppMethodBeat.o(154534);
    }
  }
  
  public static final class f
    extends a.a
  {
    public a.g MyD;
    public boolean MyE;
    public String MyF;
    public boolean bTryUseSharedCore;
    
    public f()
    {
      AppMethodBeat.i(154535);
      this.MyD = new a.g();
      this.bTryUseSharedCore = true;
      AppMethodBeat.o(154535);
    }
  }
  
  public static final class g
  {
    public String MyG = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.a
 * JD-Core Version:    0.7.0.1
 */