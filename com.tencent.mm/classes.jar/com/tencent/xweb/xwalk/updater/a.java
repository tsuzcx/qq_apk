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
    paramb.KCn = a(paramElement, "apkMin");
    paramb.KCo = a(paramElement, "apkMax");
    paramb.KCl = a(paramElement, "sdkMin");
    paramb.KCm = a(paramElement, "sdkMax");
    paramb.KCp = a(paramElement, "apiMin");
    paramb.KCq = a(paramElement, "apiMax");
    paramb.KCr = paramElement.getAttribute("forbidDeviceRegex");
    paramb.KCs = paramElement.getAttribute("whiteDeviceRegex");
    paramb.KCA = paramElement.getAttribute("forbidAppRegex");
    paramb.KCB = paramElement.getAttribute("whiteAppRegex");
    paramb.KCt = a(paramElement, "grayMin");
    paramb.KCu = a(paramElement, "grayMax");
    paramb.KCv = a(paramElement, "chromeMin");
    paramb.KCw = a(paramElement, "chromeMax");
    paramb.KCx = a(paramElement, "usertype");
    paramb.KCC = a(paramElement, "x5sdkmin");
    paramb.KCD = a(paramElement, "x5sdkmax");
    paramb.KCE = a(paramElement, "x5coremin");
    paramb.KCF = a(paramElement, "x5coremax");
    paramb.KCy = c(paramElement, "hoursStart");
    paramb.KCz = c(paramElement, "hoursEnd");
    paramb.KCH = paramElement.getAttribute("runtimeAbis");
    paramb.KCJ = paramElement.getAttribute("blackRuntimeAbis");
    paramb.KCG = paramElement.getAttribute("deviceAbis");
    paramb.KCI = paramElement.getAttribute("blackDeviceAbis");
    paramb.KCK = b(paramElement, "appClientVerMin");
    paramb.KCL = b(paramElement, "appClientVerMax");
    paramb.KCM = paramElement.getAttribute("appInfoWhiteList");
    paramb.KCN = paramElement.getAttribute("appInfoBlackList");
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
        localc.KHL = localElement.getAttribute("url");
        localc.KHX = a(localElement, "targetVersion");
        localc.KHS = localElement.getAttribute("md5");
        localc.KHT = e(localElement, "useCellular");
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
  
  public static b aVz(String paramString)
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
    AppMethodBeat.i(208953);
    if (paramElement == null)
    {
      AppMethodBeat.o(208953);
      return 0;
    }
    paramString = paramElement.getAttribute(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(208953);
      return 0;
    }
    paramElement = paramString;
    if (paramString.contains("0x")) {
      paramElement = paramString.trim().substring(2);
    }
    try
    {
      int i = Integer.parseInt(paramElement, 16);
      AppMethodBeat.o(208953);
      return i;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetIntFromHex failed" + paramElement.getMessage());
      AppMethodBeat.o(208953);
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
          locala.KCi = localElement.getAttribute("optype");
          locala.KCj = localElement.getAttribute("opvalue");
          locala.KCk = localElement.getAttribute("module");
          a(locala.KCh, localElement);
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
    AppMethodBeat.i(208954);
    if (paramElement == null)
    {
      AppMethodBeat.o(208954);
      return -1.0F;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(208954);
      return -1.0F;
    }
    try
    {
      float f = Float.parseFloat(paramElement);
      AppMethodBeat.o(208954);
      return f;
    }
    catch (Exception paramElement)
    {
      Log.e("ConfigParser", "safeGetFloat failed : " + paramElement.getMessage());
      AppMethodBeat.o(208954);
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
    //   0: ldc_w 457
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 463	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
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
    //   28: invokespecial 464	com/tencent/xweb/xwalk/updater/a$b:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 468	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 474	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 480 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 482
    //   63: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 98	java/io/FileInputStream:close	()V
    //   71: ldc_w 457
    //   74: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 58
    //   82: ldc_w 484
    //   85: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 486
    //   100: invokeinterface 44 2 0
    //   105: putfield 487	com/tencent/xweb/xwalk/updater/a$b:KHS	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: aload 5
    //   114: ldc_w 489
    //   117: invokeinterface 44 2 0
    //   122: putfield 491	com/tencent/xweb/xwalk/updater/a$b:signature	Ljava/lang/String;
    //   125: aload 4
    //   127: astore_0
    //   128: aload_3
    //   129: getfield 487	com/tencent/xweb/xwalk/updater/a$b:KHS	Ljava/lang/String;
    //   132: ifnull +17 -> 149
    //   135: aload 4
    //   137: astore_0
    //   138: aload_3
    //   139: getfield 487	com/tencent/xweb/xwalk/updater/a$b:KHS	Ljava/lang/String;
    //   142: aload_1
    //   143: invokevirtual 494	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifne +46 -> 192
    //   149: aload 4
    //   151: astore_0
    //   152: ldc2_w 495
    //   155: invokestatic 502	com/tencent/xweb/util/g:Cf	(J)V
    //   158: aload 4
    //   160: astore_0
    //   161: ldc_w 504
    //   164: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   167: aload 4
    //   169: invokevirtual 98	java/io/FileInputStream:close	()V
    //   172: ldc_w 457
    //   175: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aconst_null
    //   179: areturn
    //   180: astore_0
    //   181: ldc 58
    //   183: ldc_w 484
    //   186: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -17 -> 172
    //   192: aload 4
    //   194: astore_0
    //   195: aload_3
    //   196: getfield 487	com/tencent/xweb/xwalk/updater/a$b:KHS	Ljava/lang/String;
    //   199: aload_3
    //   200: getfield 491	com/tencent/xweb/xwalk/updater/a$b:signature	Ljava/lang/String;
    //   203: ldc_w 506
    //   206: invokestatic 512	com/tencent/xweb/util/b:be	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   209: ifne +46 -> 255
    //   212: aload 4
    //   214: astore_0
    //   215: ldc2_w 513
    //   218: invokestatic 502	com/tencent/xweb/util/g:Cf	(J)V
    //   221: aload 4
    //   223: astore_0
    //   224: ldc_w 516
    //   227: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   230: aload 4
    //   232: invokevirtual 98	java/io/FileInputStream:close	()V
    //   235: ldc_w 457
    //   238: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aconst_null
    //   242: areturn
    //   243: astore_0
    //   244: ldc 58
    //   246: ldc_w 484
    //   249: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: goto -17 -> 235
    //   255: aload 4
    //   257: astore_0
    //   258: aload_3
    //   259: aload 5
    //   261: ldc_w 518
    //   264: invokeinterface 44 2 0
    //   269: putfield 521	com/tencent/xweb/xwalk/updater/a$b:KHU	Ljava/lang/String;
    //   272: aload 4
    //   274: astore_0
    //   275: aload_3
    //   276: aload 5
    //   278: invokestatic 523	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/a$a;
    //   281: putfield 527	com/tencent/xweb/xwalk/updater/a$b:KHW	[Lcom/tencent/xweb/internal/a$a;
    //   284: aload 4
    //   286: astore_0
    //   287: aload 5
    //   289: ldc_w 529
    //   292: invokeinterface 308 2 0
    //   297: astore_1
    //   298: aload_1
    //   299: ifnull +438 -> 737
    //   302: aload 4
    //   304: astore_0
    //   305: aload_1
    //   306: invokeinterface 313 1 0
    //   311: ifeq +426 -> 737
    //   314: aload 4
    //   316: astore_0
    //   317: aload_3
    //   318: aload_1
    //   319: invokeinterface 313 1 0
    //   324: anewarray 21	com/tencent/xweb/xwalk/updater/a$f
    //   327: putfield 533	com/tencent/xweb/xwalk/updater/a$b:KHV	[Lcom/tencent/xweb/xwalk/updater/a$f;
    //   330: iconst_0
    //   331: istore_2
    //   332: aload 4
    //   334: astore_0
    //   335: iload_2
    //   336: aload_1
    //   337: invokeinterface 313 1 0
    //   342: if_icmpge +395 -> 737
    //   345: aload 4
    //   347: astore_0
    //   348: new 21	com/tencent/xweb/xwalk/updater/a$f
    //   351: dup
    //   352: invokespecial 534	com/tencent/xweb/xwalk/updater/a$f:<init>	()V
    //   355: astore 5
    //   357: aload 4
    //   359: astore_0
    //   360: aload_1
    //   361: iload_2
    //   362: invokeinterface 319 2 0
    //   367: checkcast 40	org/w3c/dom/Element
    //   370: astore 6
    //   372: aload 4
    //   374: astore_0
    //   375: aload 5
    //   377: aload 6
    //   379: ldc_w 536
    //   382: invokeinterface 44 2 0
    //   387: putfield 537	com/tencent/xweb/xwalk/updater/a$f:KHL	Ljava/lang/String;
    //   390: aload 4
    //   392: astore_0
    //   393: aload 5
    //   395: aload 6
    //   397: ldc_w 331
    //   400: invokeinterface 44 2 0
    //   405: putfield 538	com/tencent/xweb/xwalk/updater/a$f:KHS	Ljava/lang/String;
    //   408: aload 4
    //   410: astore_0
    //   411: aload 5
    //   413: getfield 539	com/tencent/xweb/xwalk/updater/a$f:KCh	Lcom/tencent/xweb/internal/a$b;
    //   416: aload 6
    //   418: invokestatic 419	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   421: aload 4
    //   423: astore_0
    //   424: aload 5
    //   426: aload 6
    //   428: ldc_w 541
    //   431: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   434: putfield 544	com/tencent/xweb/xwalk/updater/a$f:KHR	I
    //   437: aload 4
    //   439: astore_0
    //   440: aload 5
    //   442: aload 6
    //   444: ldc_w 546
    //   447: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   450: putfield 548	com/tencent/xweb/xwalk/updater/a$f:version	I
    //   453: aload 4
    //   455: astore_0
    //   456: aload 5
    //   458: aload 6
    //   460: ldc_w 336
    //   463: invokestatic 339	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   466: putfield 549	com/tencent/xweb/xwalk/updater/a$f:KHT	Z
    //   469: aload 4
    //   471: astore_0
    //   472: aload 5
    //   474: aload 6
    //   476: ldc_w 345
    //   479: invokestatic 339	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   482: putfield 550	com/tencent/xweb/xwalk/updater/a$f:bUseCdn	Z
    //   485: aload 4
    //   487: astore_0
    //   488: aload 5
    //   490: aload 6
    //   492: ldc_w 552
    //   495: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   498: putfield 555	com/tencent/xweb/xwalk/updater/a$f:KHK	I
    //   501: aload 4
    //   503: astore_0
    //   504: aload 5
    //   506: aload 6
    //   508: ldc_w 557
    //   511: invokeinterface 44 2 0
    //   516: putfield 560	com/tencent/xweb/xwalk/updater/a$f:KHO	Ljava/lang/String;
    //   519: aload 4
    //   521: astore_0
    //   522: aload 5
    //   524: aload 6
    //   526: ldc_w 562
    //   529: invokeinterface 44 2 0
    //   534: putfield 565	com/tencent/xweb/xwalk/updater/a$f:KHP	Ljava/lang/String;
    //   537: aload 4
    //   539: astore_0
    //   540: aload 5
    //   542: aload 6
    //   544: ldc_w 567
    //   547: invokeinterface 44 2 0
    //   552: putfield 570	com/tencent/xweb/xwalk/updater/a$f:KIb	Ljava/lang/String;
    //   555: aload 4
    //   557: astore_0
    //   558: aload 5
    //   560: aload 6
    //   562: ldc_w 572
    //   565: invokestatic 574	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   568: putfield 578	com/tencent/xweb/xwalk/updater/a$f:KHM	F
    //   571: aload 4
    //   573: astore_0
    //   574: aload 5
    //   576: aload 6
    //   578: ldc_w 580
    //   581: invokestatic 574	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   584: putfield 583	com/tencent/xweb/xwalk/updater/a$f:KHN	F
    //   587: aload 4
    //   589: astore_0
    //   590: aload 6
    //   592: ldc_w 585
    //   595: invokeinterface 44 2 0
    //   600: astore 7
    //   602: aload 7
    //   604: ifnull +27 -> 631
    //   607: aload 4
    //   609: astore_0
    //   610: aload 7
    //   612: invokevirtual 50	java/lang/String:isEmpty	()Z
    //   615: ifne +16 -> 631
    //   618: aload 4
    //   620: astore_0
    //   621: aload 5
    //   623: aload 7
    //   625: invokestatic 450	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   628: putfield 588	com/tencent/xweb/xwalk/updater/a$f:bTryUseSharedCore	Z
    //   631: aload 4
    //   633: astore_0
    //   634: aload 5
    //   636: getfield 592	com/tencent/xweb/xwalk/updater/a$f:KIa	Lcom/tencent/xweb/xwalk/updater/a$g;
    //   639: astore 7
    //   641: aload 7
    //   643: ifnull +63 -> 706
    //   646: aload 4
    //   648: astore_0
    //   649: aload 6
    //   651: ldc_w 594
    //   654: invokeinterface 308 2 0
    //   659: astore 8
    //   661: aload 8
    //   663: ifnull +43 -> 706
    //   666: aload 4
    //   668: astore_0
    //   669: aload 8
    //   671: invokeinterface 313 1 0
    //   676: ifeq +30 -> 706
    //   679: aload 4
    //   681: astore_0
    //   682: aload 7
    //   684: aload 8
    //   686: iconst_0
    //   687: invokeinterface 319 2 0
    //   692: checkcast 40	org/w3c/dom/Element
    //   695: ldc_w 596
    //   698: invokeinterface 44 2 0
    //   703: putfield 599	com/tencent/xweb/xwalk/updater/a$g:KIc	Ljava/lang/String;
    //   706: aload 4
    //   708: astore_0
    //   709: aload 5
    //   711: aload 6
    //   713: invokestatic 601	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   716: putfield 605	com/tencent/xweb/xwalk/updater/a$f:KHQ	[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   719: aload 4
    //   721: astore_0
    //   722: aload_3
    //   723: getfield 533	com/tencent/xweb/xwalk/updater/a$b:KHV	[Lcom/tencent/xweb/xwalk/updater/a$f;
    //   726: iload_2
    //   727: aload 5
    //   729: aastore
    //   730: iload_2
    //   731: iconst_1
    //   732: iadd
    //   733: istore_2
    //   734: goto -402 -> 332
    //   737: aload 4
    //   739: invokevirtual 98	java/io/FileInputStream:close	()V
    //   742: aload_3
    //   743: astore_0
    //   744: ldc_w 457
    //   747: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   750: aload_0
    //   751: areturn
    //   752: astore_0
    //   753: ldc 58
    //   755: ldc_w 484
    //   758: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   775: ldc_w 482
    //   778: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   781: aload_1
    //   782: astore_0
    //   783: aload 4
    //   785: ifnull -41 -> 744
    //   788: aload 4
    //   790: invokevirtual 98	java/io/FileInputStream:close	()V
    //   793: aload_1
    //   794: astore_0
    //   795: goto -51 -> 744
    //   798: astore_0
    //   799: ldc 58
    //   801: ldc_w 484
    //   804: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   821: ldc_w 482
    //   824: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   827: aload_1
    //   828: astore_0
    //   829: aload 4
    //   831: ifnull -87 -> 744
    //   834: aload 4
    //   836: invokevirtual 98	java/io/FileInputStream:close	()V
    //   839: aload_1
    //   840: astore_0
    //   841: goto -97 -> 744
    //   844: astore_0
    //   845: ldc 58
    //   847: ldc_w 484
    //   850: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   867: ldc_w 482
    //   870: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   873: aload_1
    //   874: astore_0
    //   875: aload 4
    //   877: ifnull -133 -> 744
    //   880: aload 4
    //   882: invokevirtual 98	java/io/FileInputStream:close	()V
    //   885: aload_1
    //   886: astore_0
    //   887: goto -143 -> 744
    //   890: astore_0
    //   891: ldc 58
    //   893: ldc_w 484
    //   896: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   899: aload_1
    //   900: astore_0
    //   901: goto -157 -> 744
    //   904: astore_1
    //   905: aconst_null
    //   906: astore_0
    //   907: aload_0
    //   908: ifnull +7 -> 915
    //   911: aload_0
    //   912: invokevirtual 98	java/io/FileInputStream:close	()V
    //   915: ldc_w 457
    //   918: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   921: aload_1
    //   922: athrow
    //   923: astore_0
    //   924: ldc 58
    //   926: ldc_w 484
    //   929: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   31	940	3	localb	b
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
  public static d j(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 608
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 463	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
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
    //   28: invokespecial 609	com/tencent/xweb/xwalk/updater/a$d:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 468	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 474	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 480 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 611
    //   63: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 98	java/io/FileInputStream:close	()V
    //   71: ldc_w 608
    //   74: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 58
    //   82: ldc_w 613
    //   85: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 486
    //   100: invokeinterface 44 2 0
    //   105: putfield 614	com/tencent/xweb/xwalk/updater/a$d:KHS	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: aload 5
    //   114: ldc_w 489
    //   117: invokeinterface 44 2 0
    //   122: putfield 615	com/tencent/xweb/xwalk/updater/a$d:signature	Ljava/lang/String;
    //   125: aload 4
    //   127: astore_0
    //   128: aload_3
    //   129: getfield 614	com/tencent/xweb/xwalk/updater/a$d:KHS	Ljava/lang/String;
    //   132: ifnull +17 -> 149
    //   135: aload 4
    //   137: astore_0
    //   138: aload_3
    //   139: getfield 614	com/tencent/xweb/xwalk/updater/a$d:KHS	Ljava/lang/String;
    //   142: aload_1
    //   143: invokevirtual 494	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   146: ifne +37 -> 183
    //   149: aload 4
    //   151: astore_0
    //   152: ldc_w 617
    //   155: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: invokevirtual 98	java/io/FileInputStream:close	()V
    //   163: ldc_w 608
    //   166: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: ldc 58
    //   174: ldc_w 613
    //   177: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: goto -17 -> 163
    //   183: aload 4
    //   185: astore_0
    //   186: aload_3
    //   187: aload 5
    //   189: ldc_w 518
    //   192: invokeinterface 44 2 0
    //   197: putfield 618	com/tencent/xweb/xwalk/updater/a$d:KHU	Ljava/lang/String;
    //   200: aload 4
    //   202: astore_0
    //   203: aload_3
    //   204: aload 5
    //   206: invokestatic 523	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/a$a;
    //   209: putfield 619	com/tencent/xweb/xwalk/updater/a$d:KHW	[Lcom/tencent/xweb/internal/a$a;
    //   212: aload 4
    //   214: astore_0
    //   215: aload 5
    //   217: ldc_w 621
    //   220: invokeinterface 308 2 0
    //   225: astore_1
    //   226: aload_1
    //   227: ifnull +319 -> 546
    //   230: aload 4
    //   232: astore_0
    //   233: aload_1
    //   234: invokeinterface 313 1 0
    //   239: ifeq +307 -> 546
    //   242: aload 4
    //   244: astore_0
    //   245: aload_3
    //   246: aload_1
    //   247: invokeinterface 313 1 0
    //   252: anewarray 18	com/tencent/xweb/xwalk/updater/a$e
    //   255: putfield 625	com/tencent/xweb/xwalk/updater/a$d:KHY	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   258: iconst_0
    //   259: istore_2
    //   260: aload 4
    //   262: astore_0
    //   263: iload_2
    //   264: aload_1
    //   265: invokeinterface 313 1 0
    //   270: if_icmpge +276 -> 546
    //   273: aload 4
    //   275: astore_0
    //   276: aload_1
    //   277: iload_2
    //   278: invokeinterface 319 2 0
    //   283: checkcast 40	org/w3c/dom/Element
    //   286: astore 5
    //   288: aload 4
    //   290: astore_0
    //   291: new 18	com/tencent/xweb/xwalk/updater/a$e
    //   294: dup
    //   295: invokespecial 626	com/tencent/xweb/xwalk/updater/a$e:<init>	()V
    //   298: astore 6
    //   300: aload 4
    //   302: astore_0
    //   303: aload 6
    //   305: aload 5
    //   307: ldc_w 628
    //   310: invokeinterface 44 2 0
    //   315: putfield 631	com/tencent/xweb/xwalk/updater/a$e:KHZ	Ljava/lang/String;
    //   318: aload 4
    //   320: astore_0
    //   321: aload 6
    //   323: aload 5
    //   325: ldc_w 546
    //   328: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   331: putfield 632	com/tencent/xweb/xwalk/updater/a$e:version	I
    //   334: aload 4
    //   336: astore_0
    //   337: aload 6
    //   339: aload 5
    //   341: ldc_w 536
    //   344: invokeinterface 44 2 0
    //   349: putfield 633	com/tencent/xweb/xwalk/updater/a$e:KHL	Ljava/lang/String;
    //   352: aload 4
    //   354: astore_0
    //   355: aload 6
    //   357: aload 5
    //   359: ldc_w 331
    //   362: invokeinterface 44 2 0
    //   367: putfield 634	com/tencent/xweb/xwalk/updater/a$e:KHS	Ljava/lang/String;
    //   370: aload 4
    //   372: astore_0
    //   373: aload 6
    //   375: aload 5
    //   377: ldc_w 336
    //   380: invokestatic 339	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   383: putfield 635	com/tencent/xweb/xwalk/updater/a$e:KHT	Z
    //   386: aload 4
    //   388: astore_0
    //   389: aload 6
    //   391: aload 5
    //   393: ldc_w 345
    //   396: invokestatic 339	com/tencent/xweb/xwalk/updater/a:e	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   399: putfield 636	com/tencent/xweb/xwalk/updater/a$e:bUseCdn	Z
    //   402: aload 4
    //   404: astore_0
    //   405: aload 6
    //   407: aload 5
    //   409: ldc_w 541
    //   412: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   415: putfield 637	com/tencent/xweb/xwalk/updater/a$e:KHR	I
    //   418: aload 4
    //   420: astore_0
    //   421: aload 6
    //   423: aload 5
    //   425: ldc_w 552
    //   428: invokestatic 147	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   431: putfield 638	com/tencent/xweb/xwalk/updater/a$e:KHK	I
    //   434: aload 4
    //   436: astore_0
    //   437: aload 6
    //   439: aload 5
    //   441: ldc_w 557
    //   444: invokeinterface 44 2 0
    //   449: putfield 639	com/tencent/xweb/xwalk/updater/a$e:KHO	Ljava/lang/String;
    //   452: aload 4
    //   454: astore_0
    //   455: aload 6
    //   457: aload 5
    //   459: ldc_w 562
    //   462: invokeinterface 44 2 0
    //   467: putfield 640	com/tencent/xweb/xwalk/updater/a$e:KHP	Ljava/lang/String;
    //   470: aload 4
    //   472: astore_0
    //   473: aload 6
    //   475: aload 5
    //   477: ldc_w 572
    //   480: invokestatic 574	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   483: putfield 641	com/tencent/xweb/xwalk/updater/a$e:KHM	F
    //   486: aload 4
    //   488: astore_0
    //   489: aload 6
    //   491: aload 5
    //   493: ldc_w 580
    //   496: invokestatic 574	com/tencent/xweb/xwalk/updater/a:d	(Lorg/w3c/dom/Element;Ljava/lang/String;)F
    //   499: putfield 642	com/tencent/xweb/xwalk/updater/a$e:KHN	F
    //   502: aload 4
    //   504: astore_0
    //   505: aload 6
    //   507: getfield 643	com/tencent/xweb/xwalk/updater/a$e:KCh	Lcom/tencent/xweb/internal/a$b;
    //   510: aload 5
    //   512: invokestatic 419	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/a$b;Lorg/w3c/dom/Element;)V
    //   515: aload 4
    //   517: astore_0
    //   518: aload 6
    //   520: aload 5
    //   522: invokestatic 601	com/tencent/xweb/xwalk/updater/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   525: putfield 644	com/tencent/xweb/xwalk/updater/a$e:KHQ	[Lcom/tencent/xweb/xwalk/updater/a$c;
    //   528: aload 4
    //   530: astore_0
    //   531: aload_3
    //   532: getfield 625	com/tencent/xweb/xwalk/updater/a$d:KHY	[Lcom/tencent/xweb/xwalk/updater/a$e;
    //   535: iload_2
    //   536: aload 6
    //   538: aastore
    //   539: iload_2
    //   540: iconst_1
    //   541: iadd
    //   542: istore_2
    //   543: goto -283 -> 260
    //   546: aload 4
    //   548: invokevirtual 98	java/io/FileInputStream:close	()V
    //   551: aload_3
    //   552: astore_0
    //   553: ldc_w 608
    //   556: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   559: aload_0
    //   560: areturn
    //   561: astore_0
    //   562: ldc 58
    //   564: ldc_w 613
    //   567: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload_3
    //   571: astore_0
    //   572: goto -19 -> 553
    //   575: astore_0
    //   576: aconst_null
    //   577: astore 4
    //   579: aconst_null
    //   580: astore_1
    //   581: aload 4
    //   583: astore_0
    //   584: ldc_w 646
    //   587: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   590: aload_1
    //   591: astore_0
    //   592: aload 4
    //   594: ifnull -41 -> 553
    //   597: aload 4
    //   599: invokevirtual 98	java/io/FileInputStream:close	()V
    //   602: aload_1
    //   603: astore_0
    //   604: goto -51 -> 553
    //   607: astore_0
    //   608: ldc 58
    //   610: ldc_w 613
    //   613: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   616: aload_1
    //   617: astore_0
    //   618: goto -65 -> 553
    //   621: astore_0
    //   622: aconst_null
    //   623: astore 4
    //   625: aconst_null
    //   626: astore_1
    //   627: aload 4
    //   629: astore_0
    //   630: ldc_w 648
    //   633: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   636: aload_1
    //   637: astore_0
    //   638: aload 4
    //   640: ifnull -87 -> 553
    //   643: aload 4
    //   645: invokevirtual 98	java/io/FileInputStream:close	()V
    //   648: aload_1
    //   649: astore_0
    //   650: goto -97 -> 553
    //   653: astore_0
    //   654: ldc 58
    //   656: ldc_w 613
    //   659: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: aload_1
    //   663: astore_0
    //   664: goto -111 -> 553
    //   667: astore_0
    //   668: aconst_null
    //   669: astore 4
    //   671: aconst_null
    //   672: astore_1
    //   673: aload 4
    //   675: astore_0
    //   676: ldc_w 650
    //   679: invokestatic 358	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   682: aload_1
    //   683: astore_0
    //   684: aload 4
    //   686: ifnull -133 -> 553
    //   689: aload 4
    //   691: invokevirtual 98	java/io/FileInputStream:close	()V
    //   694: aload_1
    //   695: astore_0
    //   696: goto -143 -> 553
    //   699: astore_0
    //   700: ldc 58
    //   702: ldc_w 613
    //   705: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   708: aload_1
    //   709: astore_0
    //   710: goto -157 -> 553
    //   713: astore_1
    //   714: aconst_null
    //   715: astore_0
    //   716: aload_0
    //   717: ifnull +7 -> 724
    //   720: aload_0
    //   721: invokevirtual 98	java/io/FileInputStream:close	()V
    //   724: ldc_w 608
    //   727: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   730: aload_1
    //   731: athrow
    //   732: astore_0
    //   733: ldc 58
    //   735: ldc_w 613
    //   738: invokestatic 82	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: goto -17 -> 724
    //   744: astore_1
    //   745: goto -29 -> 716
    //   748: astore_0
    //   749: aconst_null
    //   750: astore_1
    //   751: goto -78 -> 673
    //   754: astore_0
    //   755: aload_3
    //   756: astore_1
    //   757: goto -84 -> 673
    //   760: astore_0
    //   761: aconst_null
    //   762: astore_1
    //   763: goto -136 -> 627
    //   766: astore_0
    //   767: aload_3
    //   768: astore_1
    //   769: goto -142 -> 627
    //   772: astore_0
    //   773: aconst_null
    //   774: astore_1
    //   775: goto -194 -> 581
    //   778: astore_0
    //   779: aload_3
    //   780: astore_1
    //   781: goto -200 -> 581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	784	0	paramFile	File
    //   0	784	1	paramString	String
    //   259	284	2	i	int
    //   31	749	3	locald	d
    //   19	671	4	localFileInputStream	java.io.FileInputStream
    //   9	512	5	localObject	Object
    //   298	239	6	locale	e
    // Exception table:
    //   from	to	target	type
    //   66	71	79	java/lang/Exception
    //   158	163	171	java/lang/Exception
    //   546	551	561	java/lang/Exception
    //   11	21	575	javax/xml/parsers/ParserConfigurationException
    //   597	602	607	java/lang/Exception
    //   11	21	621	org/xml/sax/SAXException
    //   643	648	653	java/lang/Exception
    //   11	21	667	java/io/IOException
    //   689	694	699	java/lang/Exception
    //   11	21	713	finally
    //   720	724	732	java/lang/Exception
    //   24	32	744	finally
    //   35	52	744	finally
    //   60	66	744	finally
    //   94	108	744	finally
    //   111	125	744	finally
    //   128	135	744	finally
    //   138	149	744	finally
    //   152	158	744	finally
    //   186	200	744	finally
    //   203	212	744	finally
    //   215	226	744	finally
    //   233	242	744	finally
    //   245	258	744	finally
    //   263	273	744	finally
    //   276	288	744	finally
    //   291	300	744	finally
    //   303	318	744	finally
    //   321	334	744	finally
    //   337	352	744	finally
    //   355	370	744	finally
    //   373	386	744	finally
    //   389	402	744	finally
    //   405	418	744	finally
    //   421	434	744	finally
    //   437	452	744	finally
    //   455	470	744	finally
    //   473	486	744	finally
    //   489	502	744	finally
    //   505	515	744	finally
    //   518	528	744	finally
    //   531	539	744	finally
    //   584	590	744	finally
    //   630	636	744	finally
    //   676	682	744	finally
    //   24	32	748	java/io/IOException
    //   35	52	754	java/io/IOException
    //   60	66	754	java/io/IOException
    //   94	108	754	java/io/IOException
    //   111	125	754	java/io/IOException
    //   128	135	754	java/io/IOException
    //   138	149	754	java/io/IOException
    //   152	158	754	java/io/IOException
    //   186	200	754	java/io/IOException
    //   203	212	754	java/io/IOException
    //   215	226	754	java/io/IOException
    //   233	242	754	java/io/IOException
    //   245	258	754	java/io/IOException
    //   263	273	754	java/io/IOException
    //   276	288	754	java/io/IOException
    //   291	300	754	java/io/IOException
    //   303	318	754	java/io/IOException
    //   321	334	754	java/io/IOException
    //   337	352	754	java/io/IOException
    //   355	370	754	java/io/IOException
    //   373	386	754	java/io/IOException
    //   389	402	754	java/io/IOException
    //   405	418	754	java/io/IOException
    //   421	434	754	java/io/IOException
    //   437	452	754	java/io/IOException
    //   455	470	754	java/io/IOException
    //   473	486	754	java/io/IOException
    //   489	502	754	java/io/IOException
    //   505	515	754	java/io/IOException
    //   518	528	754	java/io/IOException
    //   531	539	754	java/io/IOException
    //   24	32	760	org/xml/sax/SAXException
    //   35	52	766	org/xml/sax/SAXException
    //   60	66	766	org/xml/sax/SAXException
    //   94	108	766	org/xml/sax/SAXException
    //   111	125	766	org/xml/sax/SAXException
    //   128	135	766	org/xml/sax/SAXException
    //   138	149	766	org/xml/sax/SAXException
    //   152	158	766	org/xml/sax/SAXException
    //   186	200	766	org/xml/sax/SAXException
    //   203	212	766	org/xml/sax/SAXException
    //   215	226	766	org/xml/sax/SAXException
    //   233	242	766	org/xml/sax/SAXException
    //   245	258	766	org/xml/sax/SAXException
    //   263	273	766	org/xml/sax/SAXException
    //   276	288	766	org/xml/sax/SAXException
    //   291	300	766	org/xml/sax/SAXException
    //   303	318	766	org/xml/sax/SAXException
    //   321	334	766	org/xml/sax/SAXException
    //   337	352	766	org/xml/sax/SAXException
    //   355	370	766	org/xml/sax/SAXException
    //   373	386	766	org/xml/sax/SAXException
    //   389	402	766	org/xml/sax/SAXException
    //   405	418	766	org/xml/sax/SAXException
    //   421	434	766	org/xml/sax/SAXException
    //   437	452	766	org/xml/sax/SAXException
    //   455	470	766	org/xml/sax/SAXException
    //   473	486	766	org/xml/sax/SAXException
    //   489	502	766	org/xml/sax/SAXException
    //   505	515	766	org/xml/sax/SAXException
    //   518	528	766	org/xml/sax/SAXException
    //   531	539	766	org/xml/sax/SAXException
    //   24	32	772	javax/xml/parsers/ParserConfigurationException
    //   35	52	778	javax/xml/parsers/ParserConfigurationException
    //   60	66	778	javax/xml/parsers/ParserConfigurationException
    //   94	108	778	javax/xml/parsers/ParserConfigurationException
    //   111	125	778	javax/xml/parsers/ParserConfigurationException
    //   128	135	778	javax/xml/parsers/ParserConfigurationException
    //   138	149	778	javax/xml/parsers/ParserConfigurationException
    //   152	158	778	javax/xml/parsers/ParserConfigurationException
    //   186	200	778	javax/xml/parsers/ParserConfigurationException
    //   203	212	778	javax/xml/parsers/ParserConfigurationException
    //   215	226	778	javax/xml/parsers/ParserConfigurationException
    //   233	242	778	javax/xml/parsers/ParserConfigurationException
    //   245	258	778	javax/xml/parsers/ParserConfigurationException
    //   263	273	778	javax/xml/parsers/ParserConfigurationException
    //   276	288	778	javax/xml/parsers/ParserConfigurationException
    //   291	300	778	javax/xml/parsers/ParserConfigurationException
    //   303	318	778	javax/xml/parsers/ParserConfigurationException
    //   321	334	778	javax/xml/parsers/ParserConfigurationException
    //   337	352	778	javax/xml/parsers/ParserConfigurationException
    //   355	370	778	javax/xml/parsers/ParserConfigurationException
    //   373	386	778	javax/xml/parsers/ParserConfigurationException
    //   389	402	778	javax/xml/parsers/ParserConfigurationException
    //   405	418	778	javax/xml/parsers/ParserConfigurationException
    //   421	434	778	javax/xml/parsers/ParserConfigurationException
    //   437	452	778	javax/xml/parsers/ParserConfigurationException
    //   455	470	778	javax/xml/parsers/ParserConfigurationException
    //   473	486	778	javax/xml/parsers/ParserConfigurationException
    //   489	502	778	javax/xml/parsers/ParserConfigurationException
    //   505	515	778	javax/xml/parsers/ParserConfigurationException
    //   518	528	778	javax/xml/parsers/ParserConfigurationException
    //   531	539	778	javax/xml/parsers/ParserConfigurationException
  }
  
  public static class a
  {
    public com.tencent.xweb.internal.a.b KCh;
    public int KHK;
    public String KHL;
    public float KHM;
    public float KHN;
    public String KHO;
    public String KHP;
    public a.c[] KHQ;
    public int KHR;
    public String KHS;
    public boolean KHT;
    public boolean bUseCdn;
    public int version;
    
    public a()
    {
      AppMethodBeat.i(208952);
      this.KCh = new com.tencent.xweb.internal.a.c();
      this.KHM = -1.0F;
      this.KHN = -1.0F;
      AppMethodBeat.o(208952);
    }
  }
  
  public static final class b
  {
    public String KHS;
    public String KHU;
    public a.f[] KHV;
    public com.tencent.xweb.internal.a.a[] KHW;
    public String signature;
  }
  
  public static final class c
  {
    public String KHL;
    public String KHS;
    public boolean KHT;
    public int KHX;
    public boolean bUseCdn;
  }
  
  public static final class d
  {
    public String KHS = "";
    public String KHU = "";
    public com.tencent.xweb.internal.a.a[] KHW;
    public a.e[] KHY = null;
    public String signature;
  }
  
  public static final class e
    extends a.a
  {
    public String KHZ;
    
    public e()
    {
      AppMethodBeat.i(154534);
      this.KHZ = "";
      AppMethodBeat.o(154534);
    }
  }
  
  public static final class f
    extends a.a
  {
    public a.g KIa;
    public String KIb;
    public boolean bTryUseSharedCore;
    
    public f()
    {
      AppMethodBeat.i(154535);
      this.KIa = new a.g();
      this.bTryUseSharedCore = true;
      AppMethodBeat.o(154535);
    }
  }
  
  public static final class g
  {
    public String KIc = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.a
 * JD-Core Version:    0.7.0.1
 */