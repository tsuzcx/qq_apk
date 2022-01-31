package com.tencent.xweb.xwalk.b;

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
    AppMethodBeat.i(85448);
    if (paramElement == null)
    {
      AppMethodBeat.o(85448);
      return 0;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(85448);
      return 0;
    }
    int i = Integer.parseInt(paramElement);
    AppMethodBeat.o(85448);
    return i;
  }
  
  /* Error */
  public static String a(File paramFile, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 51
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_1
    //   8: newarray byte
    //   10: astore 5
    //   12: new 53	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore_0
    //   21: aload_0
    //   22: aload 5
    //   24: iconst_0
    //   25: aload 5
    //   27: arraylength
    //   28: invokevirtual 61	java/io/FileInputStream:read	([BII)I
    //   31: istore_1
    //   32: aload 5
    //   34: arraylength
    //   35: istore 4
    //   37: iload_1
    //   38: iload 4
    //   40: if_icmpeq +25 -> 65
    //   43: aload_0
    //   44: invokevirtual 65	java/io/FileInputStream:close	()V
    //   47: ldc 51
    //   49: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aconst_null
    //   53: areturn
    //   54: astore_0
    //   55: ldc 67
    //   57: ldc 69
    //   59: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: goto -15 -> 47
    //   65: new 36	java/lang/String
    //   68: dup
    //   69: aload 5
    //   71: iconst_0
    //   72: iload_1
    //   73: invokespecial 78	java/lang/String:<init>	([BII)V
    //   76: astore 5
    //   78: aload 5
    //   80: aload_2
    //   81: invokevirtual 81	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   84: istore_1
    //   85: iload_1
    //   86: ifge +25 -> 111
    //   89: aload_0
    //   90: invokevirtual 65	java/io/FileInputStream:close	()V
    //   93: ldc 51
    //   95: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_0
    //   101: ldc 67
    //   103: ldc 69
    //   105: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: goto -15 -> 93
    //   111: aload 5
    //   113: iload_1
    //   114: invokevirtual 85	java/lang/String:substring	(I)Ljava/lang/String;
    //   117: astore_2
    //   118: ldc 87
    //   120: invokestatic 93	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   123: aload_2
    //   124: invokevirtual 97	java/lang/String:getBytes	()[B
    //   127: invokevirtual 101	java/security/MessageDigest:digest	([B)[B
    //   130: astore_2
    //   131: aload_2
    //   132: ifnull +10 -> 142
    //   135: aload_2
    //   136: arraylength
    //   137: istore_1
    //   138: iload_1
    //   139: ifne +25 -> 164
    //   142: aload_0
    //   143: invokevirtual 65	java/io/FileInputStream:close	()V
    //   146: ldc 51
    //   148: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_0
    //   154: ldc 67
    //   156: ldc 69
    //   158: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: goto -15 -> 146
    //   164: new 103	java/lang/StringBuilder
    //   167: dup
    //   168: aload_2
    //   169: arraylength
    //   170: invokespecial 105	java/lang/StringBuilder:<init>	(I)V
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
    //   194: invokestatic 108	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   197: astore 6
    //   199: aload 6
    //   201: invokevirtual 112	java/lang/String:length	()I
    //   204: iconst_1
    //   205: if_icmpne +10 -> 215
    //   208: aload 5
    //   210: iconst_0
    //   211: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 5
    //   217: aload 6
    //   219: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: iload_1
    //   224: iconst_1
    //   225: iadd
    //   226: istore_1
    //   227: goto -46 -> 181
    //   230: aload 5
    //   232: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokevirtual 126	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   238: astore_2
    //   239: aload_0
    //   240: invokevirtual 65	java/io/FileInputStream:close	()V
    //   243: ldc 51
    //   245: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_2
    //   249: areturn
    //   250: astore_0
    //   251: ldc 67
    //   253: ldc 69
    //   255: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: goto -15 -> 243
    //   261: astore_0
    //   262: aconst_null
    //   263: astore_0
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 65	java/io/FileInputStream:close	()V
    //   272: ldc 51
    //   274: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   277: aconst_null
    //   278: areturn
    //   279: astore_0
    //   280: ldc 67
    //   282: ldc 69
    //   284: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: goto -15 -> 272
    //   290: astore_0
    //   291: aconst_null
    //   292: astore_2
    //   293: aload_2
    //   294: ifnull +7 -> 301
    //   297: aload_2
    //   298: invokevirtual 65	java/io/FileInputStream:close	()V
    //   301: ldc 51
    //   303: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload_0
    //   307: athrow
    //   308: astore_2
    //   309: ldc 67
    //   311: ldc 69
    //   313: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  private static void a(com.tencent.xweb.c.a.b paramb, Element paramElement)
  {
    AppMethodBeat.i(155117);
    paramb.BGp = a(paramElement, "apkMin");
    paramb.BGq = a(paramElement, "apkMax");
    paramb.BGn = a(paramElement, "sdkMin");
    paramb.BGo = a(paramElement, "sdkMax");
    paramb.BGr = a(paramElement, "apiMin");
    paramb.BGs = a(paramElement, "apiMax");
    paramb.BGt = paramElement.getAttribute("forbidDeviceRegex");
    paramb.BGu = paramElement.getAttribute("whiteDeviceRegex");
    paramb.BGA = paramElement.getAttribute("forbidAppRegex");
    paramb.BGB = paramElement.getAttribute("whiteAppRegex");
    paramb.BGv = a(paramElement, "grayMin");
    paramb.BGw = a(paramElement, "grayMax");
    paramb.BGx = a(paramElement, "chromeMin");
    paramb.BGy = a(paramElement, "chromeMax");
    paramb.BGz = a(paramElement, "usertype");
    paramb.BGC = a(paramElement, "x5sdkmin");
    paramb.BGD = a(paramElement, "x5sdkmax");
    paramb.BGE = a(paramElement, "x5coremin");
    paramb.BGF = a(paramElement, "x5coremax");
    paramb.BGH = paramElement.getAttribute("runtimeAbis");
    paramb.BGJ = paramElement.getAttribute("blackRuntimeAbis");
    paramb.BGG = paramElement.getAttribute("deviceAbis");
    paramb.BGI = paramElement.getAttribute("blackDeviceAbis");
    AppMethodBeat.o(155117);
  }
  
  private static void a(a.a parama, Element paramElement)
  {
    AppMethodBeat.i(85451);
    if (paramElement == null)
    {
      AppMethodBeat.o(85451);
      return;
    }
    try
    {
      paramElement = paramElement.getElementsByTagName("command");
      if ((paramElement != null) && (paramElement.getLength() != 0))
      {
        parama.BKM = new com.tencent.xweb.c.a.a[paramElement.getLength()];
        int i = 0;
        while (i < paramElement.getLength())
        {
          com.tencent.xweb.c.a.a locala = new com.tencent.xweb.c.a.a();
          Element localElement = (Element)paramElement.item(i);
          locala.BGk = localElement.getAttribute("optype");
          locala.BGl = localElement.getAttribute("opvalue");
          locala.BGm = localElement.getAttribute("module");
          a(locala.BGj, localElement);
          parama.BKM[i] = locala;
          i += 1;
        }
      }
      AppMethodBeat.o(85451);
      return;
    }
    catch (Exception parama)
    {
      Log.e("ConfigParser", "parseCmds failed: " + parama.getMessage());
      AppMethodBeat.o(85451);
    }
  }
  
  private static a.b[] a(Element paramElement)
  {
    AppMethodBeat.i(85450);
    paramElement = paramElement.getElementsByTagName("Patch");
    if ((paramElement != null) && (paramElement.getLength() != 0))
    {
      a.b[] arrayOfb = new a.b[paramElement.getLength()];
      int i = 0;
      while (i < paramElement.getLength())
      {
        a.b localb = new a.b();
        Element localElement = (Element)paramElement.item(i);
        localb.BKO = localElement.getAttribute("url");
        localb.BKN = a(localElement, "targetVersion");
        localb.BKJ = localElement.getAttribute("md5");
        localb.BKP = b(localElement, "useCellular");
        localb.bUseCdn = b(localElement, "useCdn");
        arrayOfb[i] = localb;
        i += 1;
      }
      AppMethodBeat.o(85450);
      return arrayOfb;
    }
    AppMethodBeat.o(85450);
    return null;
  }
  
  public static a.a ayr(String paramString)
  {
    AppMethodBeat.i(85446);
    if (paramString == null)
    {
      XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
      AppMethodBeat.o(85446);
      return null;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
      AppMethodBeat.o(85446);
      return null;
    }
    paramString = k(paramString, a(paramString, (int)paramString.length(), "<Versions>"));
    AppMethodBeat.o(85446);
    return paramString;
  }
  
  private static boolean b(Element paramElement, String paramString)
  {
    AppMethodBeat.i(85449);
    if (paramElement == null)
    {
      AppMethodBeat.o(85449);
      return false;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(85449);
      return false;
    }
    boolean bool = Boolean.parseBoolean(paramElement);
    AppMethodBeat.o(85449);
    return bool;
  }
  
  /* Error */
  private static a.a k(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 381
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 387	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   9: astore 5
    //   11: new 53	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_0
    //   24: new 6	com/tencent/xweb/xwalk/b/a$a
    //   27: dup
    //   28: invokespecial 388	com/tencent/xweb/xwalk/b/a$a:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 392	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 398	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 404 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 406
    //   63: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 65	java/io/FileInputStream:close	()V
    //   71: ldc_w 381
    //   74: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 67
    //   82: ldc_w 408
    //   85: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 410
    //   100: invokeinterface 34 2 0
    //   105: putfield 411	com/tencent/xweb/xwalk/b/a$a:BKJ	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: getfield 411	com/tencent/xweb/xwalk/b/a$a:BKJ	Ljava/lang/String;
    //   115: ifnull +17 -> 132
    //   118: aload 4
    //   120: astore_0
    //   121: aload_3
    //   122: getfield 411	com/tencent/xweb/xwalk/b/a$a:BKJ	Ljava/lang/String;
    //   125: aload_1
    //   126: invokevirtual 414	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   129: ifne +46 -> 175
    //   132: aload 4
    //   134: astore_0
    //   135: ldc2_w 415
    //   138: invokestatic 422	com/tencent/xweb/util/f:pf	(J)V
    //   141: aload 4
    //   143: astore_0
    //   144: ldc_w 424
    //   147: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   150: aload 4
    //   152: invokevirtual 65	java/io/FileInputStream:close	()V
    //   155: ldc_w 381
    //   158: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_0
    //   164: ldc 67
    //   166: ldc_w 408
    //   169: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: goto -17 -> 155
    //   175: aload 4
    //   177: astore_0
    //   178: aload_3
    //   179: aload 5
    //   181: ldc_w 426
    //   184: invokeinterface 34 2 0
    //   189: putfield 429	com/tencent/xweb/xwalk/b/a$a:BKK	Ljava/lang/String;
    //   192: aload 4
    //   194: astore_0
    //   195: aload_3
    //   196: aload 5
    //   198: invokestatic 431	com/tencent/xweb/xwalk/b/a:a	(Lcom/tencent/xweb/xwalk/b/a$a;Lorg/w3c/dom/Element;)V
    //   201: aload 4
    //   203: astore_0
    //   204: aload 5
    //   206: ldc_w 433
    //   209: invokeinterface 257 2 0
    //   214: astore_1
    //   215: aload_1
    //   216: ifnull +336 -> 552
    //   219: aload 4
    //   221: astore_0
    //   222: aload_1
    //   223: invokeinterface 262 1 0
    //   228: ifeq +324 -> 552
    //   231: aload 4
    //   233: astore_0
    //   234: aload_3
    //   235: aload_1
    //   236: invokeinterface 262 1 0
    //   241: anewarray 14	com/tencent/xweb/xwalk/b/a$e
    //   244: putfield 437	com/tencent/xweb/xwalk/b/a$a:BKL	[Lcom/tencent/xweb/xwalk/b/a$e;
    //   247: iconst_0
    //   248: istore_2
    //   249: aload 4
    //   251: astore_0
    //   252: iload_2
    //   253: aload_1
    //   254: invokeinterface 262 1 0
    //   259: if_icmpge +293 -> 552
    //   262: aload 4
    //   264: astore_0
    //   265: new 14	com/tencent/xweb/xwalk/b/a$e
    //   268: dup
    //   269: invokespecial 438	com/tencent/xweb/xwalk/b/a$e:<init>	()V
    //   272: astore 5
    //   274: aload 4
    //   276: astore_0
    //   277: aload_1
    //   278: iload_2
    //   279: invokeinterface 274 2 0
    //   284: checkcast 30	org/w3c/dom/Element
    //   287: astore 6
    //   289: aload 4
    //   291: astore_0
    //   292: aload 5
    //   294: aload 6
    //   296: ldc_w 440
    //   299: invokeinterface 34 2 0
    //   304: putfield 441	com/tencent/xweb/xwalk/b/a$e:BKO	Ljava/lang/String;
    //   307: aload 4
    //   309: astore_0
    //   310: aload 5
    //   312: aload 6
    //   314: ldc_w 320
    //   317: invokeinterface 34 2 0
    //   322: putfield 442	com/tencent/xweb/xwalk/b/a$e:BKJ	Ljava/lang/String;
    //   325: aload 4
    //   327: astore_0
    //   328: aload 5
    //   330: getfield 443	com/tencent/xweb/xwalk/b/a$e:BGj	Lcom/tencent/xweb/c/a$b;
    //   333: aload 6
    //   335: invokestatic 295	com/tencent/xweb/xwalk/b/a:a	(Lcom/tencent/xweb/c/a$b;Lorg/w3c/dom/Element;)V
    //   338: aload 4
    //   340: astore_0
    //   341: aload 5
    //   343: aload 6
    //   345: ldc_w 445
    //   348: invokestatic 132	com/tencent/xweb/xwalk/b/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   351: putfield 448	com/tencent/xweb/xwalk/b/a$e:BKT	I
    //   354: aload 4
    //   356: astore_0
    //   357: aload 5
    //   359: aload 6
    //   361: ldc_w 450
    //   364: invokestatic 132	com/tencent/xweb/xwalk/b/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   367: putfield 453	com/tencent/xweb/xwalk/b/a$e:BKV	I
    //   370: aload 4
    //   372: astore_0
    //   373: aload 5
    //   375: aload 6
    //   377: ldc_w 325
    //   380: invokestatic 329	com/tencent/xweb/xwalk/b/a:b	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   383: putfield 454	com/tencent/xweb/xwalk/b/a$e:BKP	Z
    //   386: aload 4
    //   388: astore_0
    //   389: aload 5
    //   391: aload 6
    //   393: ldc_w 335
    //   396: invokestatic 329	com/tencent/xweb/xwalk/b/a:b	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   399: putfield 455	com/tencent/xweb/xwalk/b/a$e:bUseCdn	Z
    //   402: aload 4
    //   404: astore_0
    //   405: aload 6
    //   407: ldc_w 457
    //   410: invokeinterface 34 2 0
    //   415: astore 7
    //   417: aload 7
    //   419: ifnull +27 -> 446
    //   422: aload 4
    //   424: astore_0
    //   425: aload 7
    //   427: invokevirtual 40	java/lang/String:isEmpty	()Z
    //   430: ifne +16 -> 446
    //   433: aload 4
    //   435: astore_0
    //   436: aload 5
    //   438: aload 7
    //   440: invokestatic 374	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   443: putfield 460	com/tencent/xweb/xwalk/b/a$e:bTryUseSharedCore	Z
    //   446: aload 4
    //   448: astore_0
    //   449: aload 5
    //   451: getfield 464	com/tencent/xweb/xwalk/b/a$e:BKW	Lcom/tencent/xweb/xwalk/b/a$f;
    //   454: astore 7
    //   456: aload 7
    //   458: ifnull +63 -> 521
    //   461: aload 4
    //   463: astore_0
    //   464: aload 6
    //   466: ldc_w 466
    //   469: invokeinterface 257 2 0
    //   474: astore 8
    //   476: aload 8
    //   478: ifnull +43 -> 521
    //   481: aload 4
    //   483: astore_0
    //   484: aload 8
    //   486: invokeinterface 262 1 0
    //   491: ifeq +30 -> 521
    //   494: aload 4
    //   496: astore_0
    //   497: aload 7
    //   499: aload 8
    //   501: iconst_0
    //   502: invokeinterface 274 2 0
    //   507: checkcast 30	org/w3c/dom/Element
    //   510: ldc_w 468
    //   513: invokeinterface 34 2 0
    //   518: putfield 471	com/tencent/xweb/xwalk/b/a$f:BKX	Ljava/lang/String;
    //   521: aload 4
    //   523: astore_0
    //   524: aload 5
    //   526: aload 6
    //   528: invokestatic 473	com/tencent/xweb/xwalk/b/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/b/a$b;
    //   531: putfield 477	com/tencent/xweb/xwalk/b/a$e:BKU	[Lcom/tencent/xweb/xwalk/b/a$b;
    //   534: aload 4
    //   536: astore_0
    //   537: aload_3
    //   538: getfield 437	com/tencent/xweb/xwalk/b/a$a:BKL	[Lcom/tencent/xweb/xwalk/b/a$e;
    //   541: iload_2
    //   542: aload 5
    //   544: aastore
    //   545: iload_2
    //   546: iconst_1
    //   547: iadd
    //   548: istore_2
    //   549: goto -300 -> 249
    //   552: aload 4
    //   554: invokevirtual 65	java/io/FileInputStream:close	()V
    //   557: aload_3
    //   558: astore_0
    //   559: ldc_w 381
    //   562: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   565: aload_0
    //   566: areturn
    //   567: astore_0
    //   568: ldc 67
    //   570: ldc_w 408
    //   573: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: aload_3
    //   577: astore_0
    //   578: goto -19 -> 559
    //   581: astore_0
    //   582: aconst_null
    //   583: astore 4
    //   585: aconst_null
    //   586: astore_1
    //   587: aload 4
    //   589: astore_0
    //   590: ldc_w 406
    //   593: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   596: aload_1
    //   597: astore_0
    //   598: aload 4
    //   600: ifnull -41 -> 559
    //   603: aload 4
    //   605: invokevirtual 65	java/io/FileInputStream:close	()V
    //   608: aload_1
    //   609: astore_0
    //   610: goto -51 -> 559
    //   613: astore_0
    //   614: ldc 67
    //   616: ldc_w 408
    //   619: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   622: aload_1
    //   623: astore_0
    //   624: goto -65 -> 559
    //   627: astore_0
    //   628: aconst_null
    //   629: astore 4
    //   631: aconst_null
    //   632: astore_1
    //   633: aload 4
    //   635: astore_0
    //   636: ldc_w 406
    //   639: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   642: aload_1
    //   643: astore_0
    //   644: aload 4
    //   646: ifnull -87 -> 559
    //   649: aload 4
    //   651: invokevirtual 65	java/io/FileInputStream:close	()V
    //   654: aload_1
    //   655: astore_0
    //   656: goto -97 -> 559
    //   659: astore_0
    //   660: ldc 67
    //   662: ldc_w 408
    //   665: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   668: aload_1
    //   669: astore_0
    //   670: goto -111 -> 559
    //   673: astore_0
    //   674: aconst_null
    //   675: astore 4
    //   677: aconst_null
    //   678: astore_1
    //   679: aload 4
    //   681: astore_0
    //   682: ldc_w 406
    //   685: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   688: aload_1
    //   689: astore_0
    //   690: aload 4
    //   692: ifnull -133 -> 559
    //   695: aload 4
    //   697: invokevirtual 65	java/io/FileInputStream:close	()V
    //   700: aload_1
    //   701: astore_0
    //   702: goto -143 -> 559
    //   705: astore_0
    //   706: ldc 67
    //   708: ldc_w 408
    //   711: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   714: aload_1
    //   715: astore_0
    //   716: goto -157 -> 559
    //   719: astore_1
    //   720: aconst_null
    //   721: astore_0
    //   722: aload_0
    //   723: ifnull +7 -> 730
    //   726: aload_0
    //   727: invokevirtual 65	java/io/FileInputStream:close	()V
    //   730: ldc_w 381
    //   733: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   736: aload_1
    //   737: athrow
    //   738: astore_0
    //   739: ldc 67
    //   741: ldc_w 408
    //   744: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: goto -17 -> 730
    //   750: astore_1
    //   751: goto -29 -> 722
    //   754: astore_0
    //   755: aconst_null
    //   756: astore_1
    //   757: goto -78 -> 679
    //   760: astore_0
    //   761: aload_3
    //   762: astore_1
    //   763: goto -84 -> 679
    //   766: astore_0
    //   767: aconst_null
    //   768: astore_1
    //   769: goto -136 -> 633
    //   772: astore_0
    //   773: aload_3
    //   774: astore_1
    //   775: goto -142 -> 633
    //   778: astore_0
    //   779: aconst_null
    //   780: astore_1
    //   781: goto -194 -> 587
    //   784: astore_0
    //   785: aload_3
    //   786: astore_1
    //   787: goto -200 -> 587
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	790	0	paramFile	File
    //   0	790	1	paramString	String
    //   248	301	2	i	int
    //   31	755	3	locala	a.a
    //   19	677	4	localFileInputStream	java.io.FileInputStream
    //   9	534	5	localObject1	Object
    //   287	240	6	localElement	Element
    //   415	83	7	localObject2	Object
    //   474	26	8	localNodeList	NodeList
    // Exception table:
    //   from	to	target	type
    //   66	71	79	java/lang/Exception
    //   150	155	163	java/lang/Exception
    //   552	557	567	java/lang/Exception
    //   11	21	581	javax/xml/parsers/ParserConfigurationException
    //   603	608	613	java/lang/Exception
    //   11	21	627	org/xml/sax/SAXException
    //   649	654	659	java/lang/Exception
    //   11	21	673	java/io/IOException
    //   695	700	705	java/lang/Exception
    //   11	21	719	finally
    //   726	730	738	java/lang/Exception
    //   24	32	750	finally
    //   35	52	750	finally
    //   60	66	750	finally
    //   94	108	750	finally
    //   111	118	750	finally
    //   121	132	750	finally
    //   135	141	750	finally
    //   144	150	750	finally
    //   178	192	750	finally
    //   195	201	750	finally
    //   204	215	750	finally
    //   222	231	750	finally
    //   234	247	750	finally
    //   252	262	750	finally
    //   265	274	750	finally
    //   277	289	750	finally
    //   292	307	750	finally
    //   310	325	750	finally
    //   328	338	750	finally
    //   341	354	750	finally
    //   357	370	750	finally
    //   373	386	750	finally
    //   389	402	750	finally
    //   405	417	750	finally
    //   425	433	750	finally
    //   436	446	750	finally
    //   449	456	750	finally
    //   464	476	750	finally
    //   484	494	750	finally
    //   497	521	750	finally
    //   524	534	750	finally
    //   537	545	750	finally
    //   590	596	750	finally
    //   636	642	750	finally
    //   682	688	750	finally
    //   24	32	754	java/io/IOException
    //   35	52	760	java/io/IOException
    //   60	66	760	java/io/IOException
    //   94	108	760	java/io/IOException
    //   111	118	760	java/io/IOException
    //   121	132	760	java/io/IOException
    //   135	141	760	java/io/IOException
    //   144	150	760	java/io/IOException
    //   178	192	760	java/io/IOException
    //   195	201	760	java/io/IOException
    //   204	215	760	java/io/IOException
    //   222	231	760	java/io/IOException
    //   234	247	760	java/io/IOException
    //   252	262	760	java/io/IOException
    //   265	274	760	java/io/IOException
    //   277	289	760	java/io/IOException
    //   292	307	760	java/io/IOException
    //   310	325	760	java/io/IOException
    //   328	338	760	java/io/IOException
    //   341	354	760	java/io/IOException
    //   357	370	760	java/io/IOException
    //   373	386	760	java/io/IOException
    //   389	402	760	java/io/IOException
    //   405	417	760	java/io/IOException
    //   425	433	760	java/io/IOException
    //   436	446	760	java/io/IOException
    //   449	456	760	java/io/IOException
    //   464	476	760	java/io/IOException
    //   484	494	760	java/io/IOException
    //   497	521	760	java/io/IOException
    //   524	534	760	java/io/IOException
    //   537	545	760	java/io/IOException
    //   24	32	766	org/xml/sax/SAXException
    //   35	52	772	org/xml/sax/SAXException
    //   60	66	772	org/xml/sax/SAXException
    //   94	108	772	org/xml/sax/SAXException
    //   111	118	772	org/xml/sax/SAXException
    //   121	132	772	org/xml/sax/SAXException
    //   135	141	772	org/xml/sax/SAXException
    //   144	150	772	org/xml/sax/SAXException
    //   178	192	772	org/xml/sax/SAXException
    //   195	201	772	org/xml/sax/SAXException
    //   204	215	772	org/xml/sax/SAXException
    //   222	231	772	org/xml/sax/SAXException
    //   234	247	772	org/xml/sax/SAXException
    //   252	262	772	org/xml/sax/SAXException
    //   265	274	772	org/xml/sax/SAXException
    //   277	289	772	org/xml/sax/SAXException
    //   292	307	772	org/xml/sax/SAXException
    //   310	325	772	org/xml/sax/SAXException
    //   328	338	772	org/xml/sax/SAXException
    //   341	354	772	org/xml/sax/SAXException
    //   357	370	772	org/xml/sax/SAXException
    //   373	386	772	org/xml/sax/SAXException
    //   389	402	772	org/xml/sax/SAXException
    //   405	417	772	org/xml/sax/SAXException
    //   425	433	772	org/xml/sax/SAXException
    //   436	446	772	org/xml/sax/SAXException
    //   449	456	772	org/xml/sax/SAXException
    //   464	476	772	org/xml/sax/SAXException
    //   484	494	772	org/xml/sax/SAXException
    //   497	521	772	org/xml/sax/SAXException
    //   524	534	772	org/xml/sax/SAXException
    //   537	545	772	org/xml/sax/SAXException
    //   24	32	778	javax/xml/parsers/ParserConfigurationException
    //   35	52	784	javax/xml/parsers/ParserConfigurationException
    //   60	66	784	javax/xml/parsers/ParserConfigurationException
    //   94	108	784	javax/xml/parsers/ParserConfigurationException
    //   111	118	784	javax/xml/parsers/ParserConfigurationException
    //   121	132	784	javax/xml/parsers/ParserConfigurationException
    //   135	141	784	javax/xml/parsers/ParserConfigurationException
    //   144	150	784	javax/xml/parsers/ParserConfigurationException
    //   178	192	784	javax/xml/parsers/ParserConfigurationException
    //   195	201	784	javax/xml/parsers/ParserConfigurationException
    //   204	215	784	javax/xml/parsers/ParserConfigurationException
    //   222	231	784	javax/xml/parsers/ParserConfigurationException
    //   234	247	784	javax/xml/parsers/ParserConfigurationException
    //   252	262	784	javax/xml/parsers/ParserConfigurationException
    //   265	274	784	javax/xml/parsers/ParserConfigurationException
    //   277	289	784	javax/xml/parsers/ParserConfigurationException
    //   292	307	784	javax/xml/parsers/ParserConfigurationException
    //   310	325	784	javax/xml/parsers/ParserConfigurationException
    //   328	338	784	javax/xml/parsers/ParserConfigurationException
    //   341	354	784	javax/xml/parsers/ParserConfigurationException
    //   357	370	784	javax/xml/parsers/ParserConfigurationException
    //   373	386	784	javax/xml/parsers/ParserConfigurationException
    //   389	402	784	javax/xml/parsers/ParserConfigurationException
    //   405	417	784	javax/xml/parsers/ParserConfigurationException
    //   425	433	784	javax/xml/parsers/ParserConfigurationException
    //   436	446	784	javax/xml/parsers/ParserConfigurationException
    //   449	456	784	javax/xml/parsers/ParserConfigurationException
    //   464	476	784	javax/xml/parsers/ParserConfigurationException
    //   484	494	784	javax/xml/parsers/ParserConfigurationException
    //   497	521	784	javax/xml/parsers/ParserConfigurationException
    //   524	534	784	javax/xml/parsers/ParserConfigurationException
    //   537	545	784	javax/xml/parsers/ParserConfigurationException
  }
  
  /* Error */
  public static a.c l(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 480
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 387	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   9: astore 5
    //   11: new 53	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore 4
    //   21: aload 4
    //   23: astore_0
    //   24: new 10	com/tencent/xweb/xwalk/b/a$c
    //   27: dup
    //   28: invokespecial 481	com/tencent/xweb/xwalk/b/a$c:<init>	()V
    //   31: astore_3
    //   32: aload 4
    //   34: astore_0
    //   35: aload 5
    //   37: invokevirtual 392	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   40: aload 4
    //   42: invokevirtual 398	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   45: invokeinterface 404 1 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnonnull +37 -> 91
    //   57: aload 4
    //   59: astore_0
    //   60: ldc_w 483
    //   63: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   66: aload 4
    //   68: invokevirtual 65	java/io/FileInputStream:close	()V
    //   71: ldc_w 480
    //   74: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aconst_null
    //   78: areturn
    //   79: astore_0
    //   80: ldc 67
    //   82: ldc_w 485
    //   85: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: goto -17 -> 71
    //   91: aload 4
    //   93: astore_0
    //   94: aload_3
    //   95: aload 5
    //   97: ldc_w 410
    //   100: invokeinterface 34 2 0
    //   105: putfield 486	com/tencent/xweb/xwalk/b/a$c:BKJ	Ljava/lang/String;
    //   108: aload 4
    //   110: astore_0
    //   111: aload_3
    //   112: getfield 486	com/tencent/xweb/xwalk/b/a$c:BKJ	Ljava/lang/String;
    //   115: ifnull +17 -> 132
    //   118: aload 4
    //   120: astore_0
    //   121: aload_3
    //   122: getfield 486	com/tencent/xweb/xwalk/b/a$c:BKJ	Ljava/lang/String;
    //   125: aload_1
    //   126: invokevirtual 414	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   129: ifne +37 -> 166
    //   132: aload 4
    //   134: astore_0
    //   135: ldc_w 488
    //   138: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   141: aload 4
    //   143: invokevirtual 65	java/io/FileInputStream:close	()V
    //   146: ldc_w 480
    //   149: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: ldc 67
    //   157: ldc_w 485
    //   160: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: goto -17 -> 146
    //   166: aload 4
    //   168: astore_0
    //   169: aload_3
    //   170: aload 5
    //   172: ldc_w 426
    //   175: invokeinterface 34 2 0
    //   180: putfield 489	com/tencent/xweb/xwalk/b/a$c:BKK	Ljava/lang/String;
    //   183: aload 4
    //   185: astore_0
    //   186: aload 5
    //   188: ldc_w 491
    //   191: invokeinterface 257 2 0
    //   196: astore_1
    //   197: aload_1
    //   198: ifnull +235 -> 433
    //   201: aload 4
    //   203: astore_0
    //   204: aload_1
    //   205: invokeinterface 262 1 0
    //   210: ifeq +223 -> 433
    //   213: aload 4
    //   215: astore_0
    //   216: aload_3
    //   217: aload_1
    //   218: invokeinterface 262 1 0
    //   223: anewarray 12	com/tencent/xweb/xwalk/b/a$d
    //   226: putfield 495	com/tencent/xweb/xwalk/b/a$c:BKQ	[Lcom/tencent/xweb/xwalk/b/a$d;
    //   229: iconst_0
    //   230: istore_2
    //   231: aload 4
    //   233: astore_0
    //   234: iload_2
    //   235: aload_1
    //   236: invokeinterface 262 1 0
    //   241: if_icmpge +192 -> 433
    //   244: aload 4
    //   246: astore_0
    //   247: aload_1
    //   248: iload_2
    //   249: invokeinterface 274 2 0
    //   254: checkcast 30	org/w3c/dom/Element
    //   257: astore 5
    //   259: aload 4
    //   261: astore_0
    //   262: new 12	com/tencent/xweb/xwalk/b/a$d
    //   265: dup
    //   266: invokespecial 496	com/tencent/xweb/xwalk/b/a$d:<init>	()V
    //   269: astore 6
    //   271: aload 4
    //   273: astore_0
    //   274: aload 6
    //   276: aload 5
    //   278: ldc_w 498
    //   281: invokeinterface 34 2 0
    //   286: putfield 501	com/tencent/xweb/xwalk/b/a$d:BKR	Ljava/lang/String;
    //   289: aload 4
    //   291: astore_0
    //   292: aload 6
    //   294: aload 5
    //   296: ldc_w 450
    //   299: invokestatic 132	com/tencent/xweb/xwalk/b/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   302: putfield 504	com/tencent/xweb/xwalk/b/a$d:BKS	I
    //   305: aload 4
    //   307: astore_0
    //   308: aload 6
    //   310: aload 5
    //   312: ldc_w 440
    //   315: invokeinterface 34 2 0
    //   320: putfield 505	com/tencent/xweb/xwalk/b/a$d:BKO	Ljava/lang/String;
    //   323: aload 4
    //   325: astore_0
    //   326: aload 6
    //   328: aload 5
    //   330: ldc_w 320
    //   333: invokeinterface 34 2 0
    //   338: putfield 506	com/tencent/xweb/xwalk/b/a$d:BKJ	Ljava/lang/String;
    //   341: aload 4
    //   343: astore_0
    //   344: aload 6
    //   346: aload 5
    //   348: ldc_w 325
    //   351: invokestatic 329	com/tencent/xweb/xwalk/b/a:b	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   354: putfield 507	com/tencent/xweb/xwalk/b/a$d:BKP	Z
    //   357: aload 4
    //   359: astore_0
    //   360: aload 6
    //   362: aload 5
    //   364: ldc_w 335
    //   367: invokestatic 329	com/tencent/xweb/xwalk/b/a:b	(Lorg/w3c/dom/Element;Ljava/lang/String;)Z
    //   370: putfield 508	com/tencent/xweb/xwalk/b/a$d:bUseCdn	Z
    //   373: aload 4
    //   375: astore_0
    //   376: aload 6
    //   378: aload 5
    //   380: ldc_w 445
    //   383: invokestatic 132	com/tencent/xweb/xwalk/b/a:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)I
    //   386: putfield 509	com/tencent/xweb/xwalk/b/a$d:BKT	I
    //   389: aload 4
    //   391: astore_0
    //   392: aload 6
    //   394: getfield 510	com/tencent/xweb/xwalk/b/a$d:BGj	Lcom/tencent/xweb/c/a$b;
    //   397: aload 5
    //   399: invokestatic 295	com/tencent/xweb/xwalk/b/a:a	(Lcom/tencent/xweb/c/a$b;Lorg/w3c/dom/Element;)V
    //   402: aload 4
    //   404: astore_0
    //   405: aload 6
    //   407: aload 5
    //   409: invokestatic 473	com/tencent/xweb/xwalk/b/a:a	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/xwalk/b/a$b;
    //   412: putfield 511	com/tencent/xweb/xwalk/b/a$d:BKU	[Lcom/tencent/xweb/xwalk/b/a$b;
    //   415: aload 4
    //   417: astore_0
    //   418: aload_3
    //   419: getfield 495	com/tencent/xweb/xwalk/b/a$c:BKQ	[Lcom/tencent/xweb/xwalk/b/a$d;
    //   422: iload_2
    //   423: aload 6
    //   425: aastore
    //   426: iload_2
    //   427: iconst_1
    //   428: iadd
    //   429: istore_2
    //   430: goto -199 -> 231
    //   433: aload 4
    //   435: invokevirtual 65	java/io/FileInputStream:close	()V
    //   438: aload_3
    //   439: astore_0
    //   440: ldc_w 480
    //   443: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   446: aload_0
    //   447: areturn
    //   448: astore_0
    //   449: ldc 67
    //   451: ldc_w 485
    //   454: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: aload_3
    //   458: astore_0
    //   459: goto -19 -> 440
    //   462: astore_0
    //   463: aconst_null
    //   464: astore 4
    //   466: aconst_null
    //   467: astore_1
    //   468: aload 4
    //   470: astore_0
    //   471: ldc_w 513
    //   474: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   477: aload_1
    //   478: astore_0
    //   479: aload 4
    //   481: ifnull -41 -> 440
    //   484: aload 4
    //   486: invokevirtual 65	java/io/FileInputStream:close	()V
    //   489: aload_1
    //   490: astore_0
    //   491: goto -51 -> 440
    //   494: astore_0
    //   495: ldc 67
    //   497: ldc_w 485
    //   500: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload_1
    //   504: astore_0
    //   505: goto -65 -> 440
    //   508: astore_0
    //   509: aconst_null
    //   510: astore 4
    //   512: aconst_null
    //   513: astore_1
    //   514: aload 4
    //   516: astore_0
    //   517: ldc_w 515
    //   520: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   523: aload_1
    //   524: astore_0
    //   525: aload 4
    //   527: ifnull -87 -> 440
    //   530: aload 4
    //   532: invokevirtual 65	java/io/FileInputStream:close	()V
    //   535: aload_1
    //   536: astore_0
    //   537: goto -97 -> 440
    //   540: astore_0
    //   541: ldc 67
    //   543: ldc_w 485
    //   546: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   549: aload_1
    //   550: astore_0
    //   551: goto -111 -> 440
    //   554: astore_0
    //   555: aconst_null
    //   556: astore 4
    //   558: aconst_null
    //   559: astore_1
    //   560: aload 4
    //   562: astore_0
    //   563: ldc_w 517
    //   566: invokestatic 348	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   569: aload_1
    //   570: astore_0
    //   571: aload 4
    //   573: ifnull -133 -> 440
    //   576: aload 4
    //   578: invokevirtual 65	java/io/FileInputStream:close	()V
    //   581: aload_1
    //   582: astore_0
    //   583: goto -143 -> 440
    //   586: astore_0
    //   587: ldc 67
    //   589: ldc_w 485
    //   592: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   595: aload_1
    //   596: astore_0
    //   597: goto -157 -> 440
    //   600: astore_1
    //   601: aconst_null
    //   602: astore_0
    //   603: aload_0
    //   604: ifnull +7 -> 611
    //   607: aload_0
    //   608: invokevirtual 65	java/io/FileInputStream:close	()V
    //   611: ldc_w 480
    //   614: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   617: aload_1
    //   618: athrow
    //   619: astore_0
    //   620: ldc 67
    //   622: ldc_w 485
    //   625: invokestatic 75	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: goto -17 -> 611
    //   631: astore_1
    //   632: goto -29 -> 603
    //   635: astore_0
    //   636: aconst_null
    //   637: astore_1
    //   638: goto -78 -> 560
    //   641: astore_0
    //   642: aload_3
    //   643: astore_1
    //   644: goto -84 -> 560
    //   647: astore_0
    //   648: aconst_null
    //   649: astore_1
    //   650: goto -136 -> 514
    //   653: astore_0
    //   654: aload_3
    //   655: astore_1
    //   656: goto -142 -> 514
    //   659: astore_0
    //   660: aconst_null
    //   661: astore_1
    //   662: goto -194 -> 468
    //   665: astore_0
    //   666: aload_3
    //   667: astore_1
    //   668: goto -200 -> 468
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	paramFile	File
    //   0	671	1	paramString	String
    //   230	200	2	i	int
    //   31	636	3	localc	a.c
    //   19	558	4	localFileInputStream	java.io.FileInputStream
    //   9	399	5	localObject	Object
    //   269	155	6	locald	a.d
    // Exception table:
    //   from	to	target	type
    //   66	71	79	java/lang/Exception
    //   141	146	154	java/lang/Exception
    //   433	438	448	java/lang/Exception
    //   11	21	462	javax/xml/parsers/ParserConfigurationException
    //   484	489	494	java/lang/Exception
    //   11	21	508	org/xml/sax/SAXException
    //   530	535	540	java/lang/Exception
    //   11	21	554	java/io/IOException
    //   576	581	586	java/lang/Exception
    //   11	21	600	finally
    //   607	611	619	java/lang/Exception
    //   24	32	631	finally
    //   35	52	631	finally
    //   60	66	631	finally
    //   94	108	631	finally
    //   111	118	631	finally
    //   121	132	631	finally
    //   135	141	631	finally
    //   169	183	631	finally
    //   186	197	631	finally
    //   204	213	631	finally
    //   216	229	631	finally
    //   234	244	631	finally
    //   247	259	631	finally
    //   262	271	631	finally
    //   274	289	631	finally
    //   292	305	631	finally
    //   308	323	631	finally
    //   326	341	631	finally
    //   344	357	631	finally
    //   360	373	631	finally
    //   376	389	631	finally
    //   392	402	631	finally
    //   405	415	631	finally
    //   418	426	631	finally
    //   471	477	631	finally
    //   517	523	631	finally
    //   563	569	631	finally
    //   24	32	635	java/io/IOException
    //   35	52	641	java/io/IOException
    //   60	66	641	java/io/IOException
    //   94	108	641	java/io/IOException
    //   111	118	641	java/io/IOException
    //   121	132	641	java/io/IOException
    //   135	141	641	java/io/IOException
    //   169	183	641	java/io/IOException
    //   186	197	641	java/io/IOException
    //   204	213	641	java/io/IOException
    //   216	229	641	java/io/IOException
    //   234	244	641	java/io/IOException
    //   247	259	641	java/io/IOException
    //   262	271	641	java/io/IOException
    //   274	289	641	java/io/IOException
    //   292	305	641	java/io/IOException
    //   308	323	641	java/io/IOException
    //   326	341	641	java/io/IOException
    //   344	357	641	java/io/IOException
    //   360	373	641	java/io/IOException
    //   376	389	641	java/io/IOException
    //   392	402	641	java/io/IOException
    //   405	415	641	java/io/IOException
    //   418	426	641	java/io/IOException
    //   24	32	647	org/xml/sax/SAXException
    //   35	52	653	org/xml/sax/SAXException
    //   60	66	653	org/xml/sax/SAXException
    //   94	108	653	org/xml/sax/SAXException
    //   111	118	653	org/xml/sax/SAXException
    //   121	132	653	org/xml/sax/SAXException
    //   135	141	653	org/xml/sax/SAXException
    //   169	183	653	org/xml/sax/SAXException
    //   186	197	653	org/xml/sax/SAXException
    //   204	213	653	org/xml/sax/SAXException
    //   216	229	653	org/xml/sax/SAXException
    //   234	244	653	org/xml/sax/SAXException
    //   247	259	653	org/xml/sax/SAXException
    //   262	271	653	org/xml/sax/SAXException
    //   274	289	653	org/xml/sax/SAXException
    //   292	305	653	org/xml/sax/SAXException
    //   308	323	653	org/xml/sax/SAXException
    //   326	341	653	org/xml/sax/SAXException
    //   344	357	653	org/xml/sax/SAXException
    //   360	373	653	org/xml/sax/SAXException
    //   376	389	653	org/xml/sax/SAXException
    //   392	402	653	org/xml/sax/SAXException
    //   405	415	653	org/xml/sax/SAXException
    //   418	426	653	org/xml/sax/SAXException
    //   24	32	659	javax/xml/parsers/ParserConfigurationException
    //   35	52	665	javax/xml/parsers/ParserConfigurationException
    //   60	66	665	javax/xml/parsers/ParserConfigurationException
    //   94	108	665	javax/xml/parsers/ParserConfigurationException
    //   111	118	665	javax/xml/parsers/ParserConfigurationException
    //   121	132	665	javax/xml/parsers/ParserConfigurationException
    //   135	141	665	javax/xml/parsers/ParserConfigurationException
    //   169	183	665	javax/xml/parsers/ParserConfigurationException
    //   186	197	665	javax/xml/parsers/ParserConfigurationException
    //   204	213	665	javax/xml/parsers/ParserConfigurationException
    //   216	229	665	javax/xml/parsers/ParserConfigurationException
    //   234	244	665	javax/xml/parsers/ParserConfigurationException
    //   247	259	665	javax/xml/parsers/ParserConfigurationException
    //   262	271	665	javax/xml/parsers/ParserConfigurationException
    //   274	289	665	javax/xml/parsers/ParserConfigurationException
    //   292	305	665	javax/xml/parsers/ParserConfigurationException
    //   308	323	665	javax/xml/parsers/ParserConfigurationException
    //   326	341	665	javax/xml/parsers/ParserConfigurationException
    //   344	357	665	javax/xml/parsers/ParserConfigurationException
    //   360	373	665	javax/xml/parsers/ParserConfigurationException
    //   376	389	665	javax/xml/parsers/ParserConfigurationException
    //   392	402	665	javax/xml/parsers/ParserConfigurationException
    //   405	415	665	javax/xml/parsers/ParserConfigurationException
    //   418	426	665	javax/xml/parsers/ParserConfigurationException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.a
 * JD-Core Version:    0.7.0.1
 */