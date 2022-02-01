package com.tencent.xweb.xwalk.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.b.b;
import com.tencent.xweb.internal.b.c;
import com.tencent.xweb.internal.b.d;
import com.tencent.xweb.internal.b.e;
import com.tencent.xweb.internal.b.f;
import com.tencent.xweb.internal.b.g;
import com.tencent.xweb.internal.b.h;
import com.tencent.xweb.internal.b.i;
import com.tencent.xweb.util.g;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

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
    finally
    {
      Log.e("ConfigParser", "safeGetInt error:".concat(String.valueOf(paramElement)));
      AppMethodBeat.o(154538);
    }
    return 0;
  }
  
  private static void a(b.c paramc, Element paramElement)
  {
    AppMethodBeat.i(213033);
    paramElement = paramElement.getElementsByTagName("VersionInfo");
    if ((paramElement != null) && (paramElement.getLength() != 0))
    {
      paramc.aiiV = new b.h[paramElement.getLength()];
      int i = 0;
      while (i < paramElement.getLength())
      {
        b.h localh = new b.h();
        Element localElement = (Element)paramElement.item(i);
        localh.aiiC = localElement.getAttribute("fullurl");
        localh.aiiJ = localElement.getAttribute("md5");
        a(localh.aiiB, localElement);
        localh.aiiI = a(localElement, "period");
        localh.version = a(localElement, "version");
        localh.aiiK = e(localElement, "useCellular");
        localh.aiiM = e(localElement, "lowPriority");
        localh.aiiL = e(localElement, "useCdn");
        localh.aiiA = a(localElement, "versionId");
        localh.aiiF = localElement.getAttribute("updateSchedule");
        localh.aiiG = localElement.getAttribute("releaseDate");
        localh.aijN = localElement.getAttribute("updateHourSpeed");
        localh.aiiN = localElement.getAttribute("UPDATE_SPEED_CONFIG");
        localh.aiiO = localElement.getAttribute("UPDATE_FORWARD_SPEED_CONFIG");
        localh.aiiP = localElement.getAttribute("UPDATE_SCHEDULE_TIME_RANGE_BIND");
        localh.aiiD = d(localElement, "updateStartTime");
        localh.aiiE = d(localElement, "updateEndTime");
        localh.aiiQ = e(localElement, "forbidDownloadWhenNoUin");
        Object localObject = localElement.getAttribute("tryUseSharedCore");
        if ((localObject != null) && (!((String)localObject).isEmpty())) {
          localh.aijL = Boolean.parseBoolean((String)localObject);
        }
        localh.aijM = e(localElement, "supportPredown");
        localObject = localh.aijK;
        if (localObject != null)
        {
          NodeList localNodeList = localElement.getElementsByTagName("Description");
          if ((localNodeList != null) && (localNodeList.getLength() != 0)) {
            ((b.i)localObject).aijO = ((Element)localNodeList.item(0)).getAttribute("versionStr");
          }
        }
        localh.aiiH = a(localElement);
        paramc.aiiV[i] = localh;
        i += 1;
      }
    }
    AppMethodBeat.o(213033);
  }
  
  private static void a(b.d paramd, Element paramElement)
  {
    AppMethodBeat.i(154543);
    paramd.aiiZ = a(paramElement, "apkMin");
    paramd.aija = a(paramElement, "apkMax");
    paramd.aijb = a(paramElement, "preDownApkMin");
    paramd.aijc = a(paramElement, "preDownApkMax");
    paramd.aiiX = a(paramElement, "sdkMin");
    paramd.aiiY = a(paramElement, "sdkMax");
    paramd.aijd = a(paramElement, "apiMin");
    paramd.aije = a(paramElement, "apiMax");
    paramd.aijf = a(paramElement, "targetApiMin");
    paramd.aijg = a(paramElement, "targetApiMax");
    paramd.aijh = paramElement.getAttribute("forbidDeviceRegex");
    paramd.aiji = paramElement.getAttribute("whiteDeviceRegex");
    paramd.aijs = paramElement.getAttribute("forbidAppRegex");
    paramd.aijt = paramElement.getAttribute("whiteAppRegex");
    paramd.aijj = a(paramElement, "grayMin");
    paramd.aijk = a(paramElement, "grayMax");
    paramd.aijl = a(paramElement, "dayGrayMin");
    paramd.aijm = a(paramElement, "dayGrayMax");
    paramd.aijn = a(paramElement, "chromeMin");
    paramd.aijo = a(paramElement, "chromeMax");
    paramd.aijp = a(paramElement, "usertype");
    paramd.aiju = a(paramElement, "x5sdkmin");
    paramd.aijv = a(paramElement, "x5sdkmax");
    paramd.aijw = a(paramElement, "x5coremin");
    paramd.aijx = a(paramElement, "x5coremax");
    paramd.aijq = c(paramElement, "hoursStart");
    paramd.aijr = c(paramElement, "hoursEnd");
    paramd.aijz = paramElement.getAttribute("runtimeAbis");
    paramd.aijB = paramElement.getAttribute("blackRuntimeAbis");
    paramd.aijy = paramElement.getAttribute("deviceAbis");
    paramd.aijA = paramElement.getAttribute("blackDeviceAbis");
    paramd.aijC = b(paramElement, "appClientVerMin");
    paramd.aijD = b(paramElement, "appClientVerMax");
    paramd.aijE = paramElement.getAttribute("appInfoWhiteList");
    paramd.aijF = paramElement.getAttribute("appInfoBlackList");
    AppMethodBeat.o(154543);
  }
  
  private static void a(b.f paramf, Element paramElement)
  {
    AppMethodBeat.i(213047);
    paramElement = paramElement.getElementsByTagName("PluginInfo");
    if ((paramElement != null) && (paramElement.getLength() != 0))
    {
      paramf.aijI = new b.g[paramElement.getLength()];
      int i = 0;
      while (i < paramElement.getLength())
      {
        Element localElement = (Element)paramElement.item(i);
        b.g localg = new b.g();
        localg.aijJ = localElement.getAttribute("name");
        localg.version = a(localElement, "version");
        localg.aiiC = localElement.getAttribute("fullurl");
        localg.aiiJ = localElement.getAttribute("md5");
        localg.aiiK = e(localElement, "useCellular");
        localg.aiiM = e(localElement, "lowPriority");
        localg.aiiL = e(localElement, "useCdn");
        localg.aiiI = a(localElement, "period");
        localg.aiiA = a(localElement, "versionId");
        localg.aiiF = localElement.getAttribute("updateSchedule");
        localg.aiiG = localElement.getAttribute("releaseDate");
        localg.aiiN = localElement.getAttribute("UPDATE_SPEED_CONFIG");
        localg.aiiO = localElement.getAttribute("UPDATE_FORWARD_SPEED_CONFIG");
        localg.aiiP = localElement.getAttribute("UPDATE_SCHEDULE_TIME_RANGE_BIND");
        localg.aiiD = d(localElement, "updateStartTime");
        localg.aiiE = d(localElement, "updateEndTime");
        a(localg.aiiB, localElement);
        localg.aiiH = a(localElement);
        paramf.aijI[i] = localg;
        i += 1;
      }
    }
    AppMethodBeat.o(213047);
  }
  
  private static b.e[] a(Element paramElement)
  {
    AppMethodBeat.i(213057);
    paramElement = paramElement.getElementsByTagName("Patch");
    if ((paramElement != null) && (paramElement.getLength() != 0))
    {
      b.e[] arrayOfe = new b.e[paramElement.getLength()];
      int i = 0;
      while (i < paramElement.getLength())
      {
        b.e locale = new b.e();
        Element localElement = (Element)paramElement.item(i);
        locale.aiiC = localElement.getAttribute("url");
        locale.aijH = a(localElement, "targetVersion");
        locale.aiiJ = localElement.getAttribute("md5");
        locale.aiiK = e(localElement, "useCellular");
        locale.aiiL = e(localElement, "useCdn");
        arrayOfe[i] = locale;
        i += 1;
      }
      AppMethodBeat.o(213057);
      return arrayOfe;
    }
    AppMethodBeat.o(213057);
    return null;
  }
  
  private static int b(Element paramElement, String paramString)
  {
    AppMethodBeat.i(213074);
    if (paramElement == null)
    {
      AppMethodBeat.o(213074);
      return 0;
    }
    paramString = paramElement.getAttribute(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(213074);
      return 0;
    }
    paramElement = paramString;
    if (paramString.contains("0x")) {
      paramElement = paramString.trim().substring(2);
    }
    try
    {
      int i = Integer.parseInt(paramElement, 16);
      AppMethodBeat.o(213074);
      return i;
    }
    finally
    {
      Log.e("ConfigParser", "safeGetIntFromHex error:".concat(String.valueOf(paramElement)));
      AppMethodBeat.o(213074);
    }
    return 0;
  }
  
  private static b.b[] b(Element paramElement)
  {
    AppMethodBeat.i(213063);
    if (paramElement == null)
    {
      AppMethodBeat.o(213063);
      return null;
    }
    try
    {
      paramElement = paramElement.getElementsByTagName("command");
      Object localObject = new StringBuilder("parseCommandList, size:");
      if (paramElement != null) {}
      for (int i = paramElement.getLength();; i = 0)
      {
        Log.d("ConfigParser", i);
        if ((paramElement == null) || (paramElement.getLength() == 0)) {
          break label209;
        }
        localObject = new b.b[paramElement.getLength()];
        i = 0;
        while (i < paramElement.getLength())
        {
          b.b localb = new b.b();
          Element localElement = (Element)paramElement.item(i);
          localb.aiiR = localElement.getAttribute("optype");
          localb.aiiS = localElement.getAttribute("opvalue");
          localb.aiiT = localElement.getAttribute("module");
          a(localb.aiiB, localElement);
          localObject[i] = localb;
          i += 1;
        }
      }
      AppMethodBeat.o(213063);
      return localObject;
    }
    finally
    {
      Log.e("ConfigParser", "parseCommandList error:".concat(String.valueOf(paramElement)));
      label209:
      AppMethodBeat.o(213063);
    }
    return null;
  }
  
  public static b.c bIr(String paramString)
  {
    AppMethodBeat.i(213016);
    if (paramString == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("ConfigParser", "parse config failed, path is empty");
      AppMethodBeat.o(213016);
      return null;
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      XWalkEnvironment.addXWalkInitializeLog("ConfigParser", "parse config failed, file not exist");
      AppMethodBeat.o(213016);
      return null;
    }
    paramString = l(paramString, c(paramString, (int)paramString.length(), "<Versions>"));
    AppMethodBeat.o(213016);
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
    finally
    {
      Log.e("ConfigParser", "safeGetDouble error:".concat(String.valueOf(paramElement)));
      AppMethodBeat.o(154539);
    }
    return -1.0D;
  }
  
  public static String c(File paramFile, int paramInt, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(154537);
    try
    {
      Object localObject = new byte[paramInt];
      paramFile = new FileInputStream(paramFile);
      try
      {
        int j;
        String str;
        Log.e("ConfigParser", "getConfigCheckValue error:".concat(String.valueOf(paramString)));
        return null;
      }
      finally
      {
        g.d(paramFile);
        AppMethodBeat.o(154537);
      }
    }
    finally
    {
      try
      {
        paramInt = paramFile.read((byte[])localObject, 0, localObject.length);
        j = localObject.length;
        if (paramInt != j)
        {
          g.d(paramFile);
          AppMethodBeat.o(154537);
          return null;
        }
        localObject = new String((byte[])localObject, 0, paramInt);
        paramInt = ((String)localObject).indexOf(paramString);
        if (paramInt < 0)
        {
          g.d(paramFile);
          AppMethodBeat.o(154537);
          return null;
        }
        paramString = ((String)localObject).substring(paramInt);
        paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
        if (paramString != null)
        {
          paramInt = paramString.length;
          if (paramInt != 0) {}
        }
        else
        {
          g.d(paramFile);
          AppMethodBeat.o(154537);
          return null;
        }
        localObject = new StringBuilder(paramString.length);
        j = paramString.length;
        paramInt = i;
        while (paramInt < j)
        {
          str = Integer.toHexString(paramString[paramInt] & 0xFF);
          if (str.length() == 1) {
            ((StringBuilder)localObject).append(0);
          }
          ((StringBuilder)localObject).append(str);
          paramInt += 1;
        }
        paramString = ((StringBuilder)localObject).toString().toUpperCase();
        g.d(paramFile);
        AppMethodBeat.o(154537);
        return paramString;
      }
      finally
      {
        break label226;
      }
      paramString = finally;
      paramFile = null;
    }
  }
  
  private static float d(Element paramElement, String paramString)
  {
    AppMethodBeat.i(213081);
    if (paramElement == null)
    {
      AppMethodBeat.o(213081);
      return -1.0F;
    }
    paramElement = paramElement.getAttribute(paramString);
    if ((paramElement == null) || (paramElement.isEmpty()))
    {
      AppMethodBeat.o(213081);
      return -1.0F;
    }
    try
    {
      float f = Float.parseFloat(paramElement);
      AppMethodBeat.o(213081);
      return f;
    }
    finally
    {
      Log.e("ConfigParser", "safeGetFloat error:".concat(String.valueOf(paramElement)));
      AppMethodBeat.o(213081);
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
    try
    {
      boolean bool = Boolean.parseBoolean(paramElement);
      AppMethodBeat.o(154540);
      return bool;
    }
    finally
    {
      Log.e("ConfigParser", "safeGetBoolean error:".concat(String.valueOf(paramElement)));
      AppMethodBeat.o(154540);
    }
    return false;
  }
  
  /* Error */
  private static b.c l(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 635
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 36
    //   8: new 486	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 637
    //   15: invokespecial 491	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 640	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   22: invokevirtual 610	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 642	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: invokestatic 648	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   34: astore 4
    //   36: new 566	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 569	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore_2
    //   45: aload_2
    //   46: astore_0
    //   47: new 70	com/tencent/xweb/internal/b$c
    //   50: dup
    //   51: invokespecial 649	com/tencent/xweb/internal/b$c:<init>	()V
    //   54: astore_3
    //   55: aload_2
    //   56: astore_0
    //   57: aload 4
    //   59: invokevirtual 653	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   62: aload_2
    //   63: invokevirtual 659	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   66: invokeinterface 665 1 0
    //   71: astore 4
    //   73: aload 4
    //   75: ifnonnull +25 -> 100
    //   78: aload_2
    //   79: astore_0
    //   80: ldc 36
    //   82: ldc_w 667
    //   85: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   92: ldc_w 635
    //   95: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aconst_null
    //   99: areturn
    //   100: aload_2
    //   101: astore_0
    //   102: aload_3
    //   103: aload 4
    //   105: ldc_w 669
    //   108: invokeinterface 22 2 0
    //   113: putfield 670	com/tencent/xweb/internal/b$c:aiiJ	Ljava/lang/String;
    //   116: aload_2
    //   117: astore_0
    //   118: aload_3
    //   119: aload 4
    //   121: ldc_w 672
    //   124: invokeinterface 22 2 0
    //   129: putfield 674	com/tencent/xweb/internal/b$c:signature	Ljava/lang/String;
    //   132: aload_2
    //   133: astore_0
    //   134: aload_3
    //   135: getfield 670	com/tencent/xweb/internal/b$c:aiiJ	Ljava/lang/String;
    //   138: ifnull +16 -> 154
    //   141: aload_2
    //   142: astore_0
    //   143: aload_3
    //   144: getfield 670	com/tencent/xweb/internal/b$c:aiiJ	Ljava/lang/String;
    //   147: aload_1
    //   148: invokevirtual 677	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   151: ifne +33 -> 184
    //   154: aload_2
    //   155: astore_0
    //   156: ldc2_w 678
    //   159: invokestatic 685	com/tencent/xweb/util/l:Br	(J)V
    //   162: aload_2
    //   163: astore_0
    //   164: ldc 36
    //   166: ldc_w 687
    //   169: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_2
    //   173: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   176: ldc_w 635
    //   179: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aconst_null
    //   183: areturn
    //   184: aload_2
    //   185: astore_0
    //   186: aload_3
    //   187: getfield 670	com/tencent/xweb/internal/b$c:aiiJ	Ljava/lang/String;
    //   190: aload_3
    //   191: getfield 674	com/tencent/xweb/internal/b$c:signature	Ljava/lang/String;
    //   194: ldc_w 689
    //   197: invokestatic 695	com/tencent/xweb/util/e:bR	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   200: ifne +33 -> 233
    //   203: aload_2
    //   204: astore_0
    //   205: ldc2_w 696
    //   208: invokestatic 685	com/tencent/xweb/util/l:Br	(J)V
    //   211: aload_2
    //   212: astore_0
    //   213: ldc 36
    //   215: ldc_w 699
    //   218: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload_2
    //   222: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   225: ldc_w 635
    //   228: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   231: aconst_null
    //   232: areturn
    //   233: aload_2
    //   234: astore_0
    //   235: aload_3
    //   236: aload 4
    //   238: ldc_w 701
    //   241: invokeinterface 22 2 0
    //   246: putfield 704	com/tencent/xweb/internal/b$c:aiiU	Ljava/lang/String;
    //   249: aload_2
    //   250: astore_0
    //   251: aload_3
    //   252: aload 4
    //   254: invokestatic 706	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/b$b;
    //   257: putfield 710	com/tencent/xweb/internal/b$c:aiiW	[Lcom/tencent/xweb/internal/b$b;
    //   260: aload_2
    //   261: astore_0
    //   262: aload_3
    //   263: aload 4
    //   265: invokestatic 712	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/b$c;Lorg/w3c/dom/Element;)V
    //   268: aload_2
    //   269: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   272: ldc_w 635
    //   275: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_3
    //   279: areturn
    //   280: astore_1
    //   281: aconst_null
    //   282: astore_2
    //   283: aconst_null
    //   284: astore_3
    //   285: aload_2
    //   286: astore_0
    //   287: ldc 36
    //   289: ldc_w 714
    //   292: aload_1
    //   293: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   296: invokevirtual 45	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   299: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_2
    //   303: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   306: goto -34 -> 272
    //   309: astore_1
    //   310: aconst_null
    //   311: astore_2
    //   312: aconst_null
    //   313: astore_3
    //   314: aload_2
    //   315: astore_0
    //   316: ldc 36
    //   318: ldc_w 716
    //   321: aload_1
    //   322: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   325: invokevirtual 45	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   328: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload_2
    //   332: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   335: goto -63 -> 272
    //   338: astore_1
    //   339: aconst_null
    //   340: astore_2
    //   341: aconst_null
    //   342: astore_3
    //   343: aload_2
    //   344: astore_0
    //   345: ldc 36
    //   347: ldc_w 718
    //   350: aload_1
    //   351: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   354: invokevirtual 45	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   357: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_2
    //   361: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   364: goto -92 -> 272
    //   367: astore_1
    //   368: aconst_null
    //   369: astore_0
    //   370: aload_0
    //   371: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   374: ldc_w 635
    //   377: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   380: aload_1
    //   381: athrow
    //   382: astore_1
    //   383: goto -13 -> 370
    //   386: astore_1
    //   387: aconst_null
    //   388: astore_3
    //   389: goto -46 -> 343
    //   392: astore_1
    //   393: goto -50 -> 343
    //   396: astore_1
    //   397: aconst_null
    //   398: astore_3
    //   399: goto -85 -> 314
    //   402: astore_1
    //   403: goto -89 -> 314
    //   406: astore_1
    //   407: aconst_null
    //   408: astore_3
    //   409: goto -124 -> 285
    //   412: astore_1
    //   413: goto -128 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramFile	File
    //   0	416	1	paramString	String
    //   44	317	2	localFileInputStream	FileInputStream
    //   54	355	3	localc	b.c
    //   34	230	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	45	280	javax/xml/parsers/ParserConfigurationException
    //   36	45	309	org/xml/sax/SAXException
    //   36	45	338	java/io/IOException
    //   36	45	367	finally
    //   47	55	382	finally
    //   57	73	382	finally
    //   80	88	382	finally
    //   102	116	382	finally
    //   118	132	382	finally
    //   134	141	382	finally
    //   143	154	382	finally
    //   156	162	382	finally
    //   164	172	382	finally
    //   186	203	382	finally
    //   205	211	382	finally
    //   213	221	382	finally
    //   235	249	382	finally
    //   251	260	382	finally
    //   262	268	382	finally
    //   287	302	382	finally
    //   316	331	382	finally
    //   345	360	382	finally
    //   47	55	386	java/io/IOException
    //   57	73	392	java/io/IOException
    //   80	88	392	java/io/IOException
    //   102	116	392	java/io/IOException
    //   118	132	392	java/io/IOException
    //   134	141	392	java/io/IOException
    //   143	154	392	java/io/IOException
    //   156	162	392	java/io/IOException
    //   164	172	392	java/io/IOException
    //   186	203	392	java/io/IOException
    //   205	211	392	java/io/IOException
    //   213	221	392	java/io/IOException
    //   235	249	392	java/io/IOException
    //   251	260	392	java/io/IOException
    //   262	268	392	java/io/IOException
    //   47	55	396	org/xml/sax/SAXException
    //   57	73	402	org/xml/sax/SAXException
    //   80	88	402	org/xml/sax/SAXException
    //   102	116	402	org/xml/sax/SAXException
    //   118	132	402	org/xml/sax/SAXException
    //   134	141	402	org/xml/sax/SAXException
    //   143	154	402	org/xml/sax/SAXException
    //   156	162	402	org/xml/sax/SAXException
    //   164	172	402	org/xml/sax/SAXException
    //   186	203	402	org/xml/sax/SAXException
    //   205	211	402	org/xml/sax/SAXException
    //   213	221	402	org/xml/sax/SAXException
    //   235	249	402	org/xml/sax/SAXException
    //   251	260	402	org/xml/sax/SAXException
    //   262	268	402	org/xml/sax/SAXException
    //   47	55	406	javax/xml/parsers/ParserConfigurationException
    //   57	73	412	javax/xml/parsers/ParserConfigurationException
    //   80	88	412	javax/xml/parsers/ParserConfigurationException
    //   102	116	412	javax/xml/parsers/ParserConfigurationException
    //   118	132	412	javax/xml/parsers/ParserConfigurationException
    //   134	141	412	javax/xml/parsers/ParserConfigurationException
    //   143	154	412	javax/xml/parsers/ParserConfigurationException
    //   156	162	412	javax/xml/parsers/ParserConfigurationException
    //   164	172	412	javax/xml/parsers/ParserConfigurationException
    //   186	203	412	javax/xml/parsers/ParserConfigurationException
    //   205	211	412	javax/xml/parsers/ParserConfigurationException
    //   213	221	412	javax/xml/parsers/ParserConfigurationException
    //   235	249	412	javax/xml/parsers/ParserConfigurationException
    //   251	260	412	javax/xml/parsers/ParserConfigurationException
    //   262	268	412	javax/xml/parsers/ParserConfigurationException
  }
  
  /* Error */
  public static b.f m(File paramFile, String paramString)
  {
    // Byte code:
    //   0: ldc_w 721
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 36
    //   8: new 486	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 723
    //   15: invokespecial 491	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 640	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   22: invokevirtual 610	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 498	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 642	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: invokestatic 648	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   34: astore 4
    //   36: new 566	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 569	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore_2
    //   45: aload_2
    //   46: astore_0
    //   47: new 416	com/tencent/xweb/internal/b$f
    //   50: dup
    //   51: invokespecial 724	com/tencent/xweb/internal/b$f:<init>	()V
    //   54: astore_3
    //   55: aload_2
    //   56: astore_0
    //   57: aload 4
    //   59: invokevirtual 653	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   62: aload_2
    //   63: invokevirtual 659	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   66: invokeinterface 665 1 0
    //   71: astore 4
    //   73: aload 4
    //   75: ifnonnull +25 -> 100
    //   78: aload_2
    //   79: astore_0
    //   80: ldc 36
    //   82: ldc_w 726
    //   85: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   92: ldc_w 721
    //   95: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aconst_null
    //   99: areturn
    //   100: aload_2
    //   101: astore_0
    //   102: aload_3
    //   103: aload 4
    //   105: ldc_w 669
    //   108: invokeinterface 22 2 0
    //   113: putfield 727	com/tencent/xweb/internal/b$f:aiiJ	Ljava/lang/String;
    //   116: aload_2
    //   117: astore_0
    //   118: aload_3
    //   119: aload 4
    //   121: ldc_w 672
    //   124: invokeinterface 22 2 0
    //   129: putfield 728	com/tencent/xweb/internal/b$f:signature	Ljava/lang/String;
    //   132: aload_2
    //   133: astore_0
    //   134: aload_3
    //   135: getfield 727	com/tencent/xweb/internal/b$f:aiiJ	Ljava/lang/String;
    //   138: ifnull +16 -> 154
    //   141: aload_2
    //   142: astore_0
    //   143: aload_3
    //   144: getfield 727	com/tencent/xweb/internal/b$f:aiiJ	Ljava/lang/String;
    //   147: aload_1
    //   148: invokevirtual 677	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   151: ifne +25 -> 176
    //   154: aload_2
    //   155: astore_0
    //   156: ldc 36
    //   158: ldc_w 730
    //   161: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: aload_2
    //   165: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   168: ldc_w 721
    //   171: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aconst_null
    //   175: areturn
    //   176: aload_2
    //   177: astore_0
    //   178: aload_3
    //   179: getfield 727	com/tencent/xweb/internal/b$f:aiiJ	Ljava/lang/String;
    //   182: aload_3
    //   183: getfield 728	com/tencent/xweb/internal/b$f:signature	Ljava/lang/String;
    //   186: ldc_w 689
    //   189: invokestatic 695	com/tencent/xweb/util/e:bR	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   192: ifne +33 -> 225
    //   195: aload_2
    //   196: astore_0
    //   197: ldc2_w 696
    //   200: invokestatic 685	com/tencent/xweb/util/l:Br	(J)V
    //   203: aload_2
    //   204: astore_0
    //   205: ldc 36
    //   207: ldc_w 732
    //   210: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_2
    //   214: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   217: ldc_w 721
    //   220: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aconst_null
    //   224: areturn
    //   225: aload_2
    //   226: astore_0
    //   227: aload_3
    //   228: aload 4
    //   230: ldc_w 701
    //   233: invokeinterface 22 2 0
    //   238: putfield 733	com/tencent/xweb/internal/b$f:aiiU	Ljava/lang/String;
    //   241: aload_2
    //   242: astore_0
    //   243: aload_3
    //   244: aload 4
    //   246: invokestatic 706	com/tencent/xweb/xwalk/updater/a:b	(Lorg/w3c/dom/Element;)[Lcom/tencent/xweb/internal/b$b;
    //   249: putfield 734	com/tencent/xweb/internal/b$f:aiiW	[Lcom/tencent/xweb/internal/b$b;
    //   252: aload_2
    //   253: astore_0
    //   254: aload_3
    //   255: aload 4
    //   257: invokestatic 736	com/tencent/xweb/xwalk/updater/a:a	(Lcom/tencent/xweb/internal/b$f;Lorg/w3c/dom/Element;)V
    //   260: aload_2
    //   261: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   264: ldc_w 721
    //   267: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   270: aload_3
    //   271: areturn
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_2
    //   275: aconst_null
    //   276: astore_3
    //   277: aload_2
    //   278: astore_0
    //   279: ldc 36
    //   281: ldc_w 738
    //   284: aload_1
    //   285: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   288: invokevirtual 45	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_2
    //   295: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   298: goto -34 -> 264
    //   301: astore_1
    //   302: aconst_null
    //   303: astore_2
    //   304: aconst_null
    //   305: astore_3
    //   306: aload_2
    //   307: astore_0
    //   308: ldc 36
    //   310: ldc_w 740
    //   313: aload_1
    //   314: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   317: invokevirtual 45	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   320: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aload_2
    //   324: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   327: goto -63 -> 264
    //   330: astore_1
    //   331: aconst_null
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_3
    //   335: aload_2
    //   336: astore_0
    //   337: ldc 36
    //   339: ldc_w 742
    //   342: aload_1
    //   343: invokestatic 42	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   346: invokevirtual 45	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokestatic 531	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_2
    //   353: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   356: goto -92 -> 264
    //   359: astore_1
    //   360: aconst_null
    //   361: astore_0
    //   362: aload_0
    //   363: invokestatic 578	com/tencent/xweb/util/g:d	(Ljava/io/Closeable;)V
    //   366: ldc_w 721
    //   369: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload_1
    //   373: athrow
    //   374: astore_1
    //   375: goto -13 -> 362
    //   378: astore_1
    //   379: aconst_null
    //   380: astore_3
    //   381: goto -46 -> 335
    //   384: astore_1
    //   385: goto -50 -> 335
    //   388: astore_1
    //   389: aconst_null
    //   390: astore_3
    //   391: goto -85 -> 306
    //   394: astore_1
    //   395: goto -89 -> 306
    //   398: astore_1
    //   399: aconst_null
    //   400: astore_3
    //   401: goto -124 -> 277
    //   404: astore_1
    //   405: goto -128 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	paramFile	File
    //   0	408	1	paramString	String
    //   44	309	2	localFileInputStream	FileInputStream
    //   54	347	3	localf	b.f
    //   34	222	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	45	272	javax/xml/parsers/ParserConfigurationException
    //   36	45	301	org/xml/sax/SAXException
    //   36	45	330	java/io/IOException
    //   36	45	359	finally
    //   47	55	374	finally
    //   57	73	374	finally
    //   80	88	374	finally
    //   102	116	374	finally
    //   118	132	374	finally
    //   134	141	374	finally
    //   143	154	374	finally
    //   156	164	374	finally
    //   178	195	374	finally
    //   197	203	374	finally
    //   205	213	374	finally
    //   227	241	374	finally
    //   243	252	374	finally
    //   254	260	374	finally
    //   279	294	374	finally
    //   308	323	374	finally
    //   337	352	374	finally
    //   47	55	378	java/io/IOException
    //   57	73	384	java/io/IOException
    //   80	88	384	java/io/IOException
    //   102	116	384	java/io/IOException
    //   118	132	384	java/io/IOException
    //   134	141	384	java/io/IOException
    //   143	154	384	java/io/IOException
    //   156	164	384	java/io/IOException
    //   178	195	384	java/io/IOException
    //   197	203	384	java/io/IOException
    //   205	213	384	java/io/IOException
    //   227	241	384	java/io/IOException
    //   243	252	384	java/io/IOException
    //   254	260	384	java/io/IOException
    //   47	55	388	org/xml/sax/SAXException
    //   57	73	394	org/xml/sax/SAXException
    //   80	88	394	org/xml/sax/SAXException
    //   102	116	394	org/xml/sax/SAXException
    //   118	132	394	org/xml/sax/SAXException
    //   134	141	394	org/xml/sax/SAXException
    //   143	154	394	org/xml/sax/SAXException
    //   156	164	394	org/xml/sax/SAXException
    //   178	195	394	org/xml/sax/SAXException
    //   197	203	394	org/xml/sax/SAXException
    //   205	213	394	org/xml/sax/SAXException
    //   227	241	394	org/xml/sax/SAXException
    //   243	252	394	org/xml/sax/SAXException
    //   254	260	394	org/xml/sax/SAXException
    //   47	55	398	javax/xml/parsers/ParserConfigurationException
    //   57	73	404	javax/xml/parsers/ParserConfigurationException
    //   80	88	404	javax/xml/parsers/ParserConfigurationException
    //   102	116	404	javax/xml/parsers/ParserConfigurationException
    //   118	132	404	javax/xml/parsers/ParserConfigurationException
    //   134	141	404	javax/xml/parsers/ParserConfigurationException
    //   143	154	404	javax/xml/parsers/ParserConfigurationException
    //   156	164	404	javax/xml/parsers/ParserConfigurationException
    //   178	195	404	javax/xml/parsers/ParserConfigurationException
    //   197	203	404	javax/xml/parsers/ParserConfigurationException
    //   205	213	404	javax/xml/parsers/ParserConfigurationException
    //   227	241	404	javax/xml/parsers/ParserConfigurationException
    //   243	252	404	javax/xml/parsers/ParserConfigurationException
    //   254	260	404	javax/xml/parsers/ParserConfigurationException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.a
 * JD-Core Version:    0.7.0.1
 */