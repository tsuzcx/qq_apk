package com.tencent.xweb.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.aj;
import com.tencent.xweb.ao;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public final class l
{
  public static String aifr = "";
  private static boolean aimF = false;
  private static WebView.WebViewKind aimG = WebView.WebViewKind.aifH;
  private static aj aimH = null;
  private static boolean aimI = false;
  public static String sessionId = "";
  
  public static void A(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(157035);
    Bs(paramLong);
    if ((aimH != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      aimH.bI(6, 7, (int)paramLong);
      aimH.b(ao.kge(), XWalkEnvironment.getAvailableVersion(), bIg(paramString), sessionId, 1, 0, (int)paramLong, paramInt);
    }
    AppMethodBeat.o(157035);
  }
  
  public static void Br(long paramLong)
  {
    AppMethodBeat.i(157020);
    if (aimH != null) {
      aimH.p(577L, paramLong, 1L);
    }
    AppMethodBeat.o(157020);
  }
  
  public static void Bs(long paramLong)
  {
    AppMethodBeat.i(157026);
    if ((aimH != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      aimH.bI(2, 3, (int)paramLong);
    }
    AppMethodBeat.o(157026);
  }
  
  public static void Bt(long paramLong)
  {
    AppMethodBeat.i(157029);
    if ((aimH != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      aimH.bI(48, 49, (int)paramLong);
    }
    AppMethodBeat.o(157029);
  }
  
  public static void Bu(long paramLong)
  {
    AppMethodBeat.i(157032);
    if ((aimH != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      aimH.bI(44, 45, (int)paramLong);
    }
    AppMethodBeat.o(157032);
  }
  
  public static void Bv(long paramLong)
  {
    AppMethodBeat.i(157049);
    if ((aimH != null) && (aimH != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      aimH.bI(11, 12, (int)paramLong);
    }
    AppMethodBeat.o(157049);
  }
  
  public static void Bw(long paramLong)
  {
    AppMethodBeat.i(157054);
    if ((aimH != null) && (aimH != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      aimH.bI(22, 23, (int)paramLong);
    }
    AppMethodBeat.o(157054);
  }
  
  public static void Bx(long paramLong)
  {
    AppMethodBeat.i(157057);
    if ((aimH != null) && (aimH != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      aimH.bI(27, 28, (int)paramLong);
    }
    AppMethodBeat.o(157057);
  }
  
  public static void By(long paramLong)
  {
    AppMethodBeat.i(157061);
    if ((aimH != null) && (aimH != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      aimH.bI(16, 17, (int)paramLong);
    }
    AppMethodBeat.o(157061);
  }
  
  public static void OZ(boolean paramBoolean)
  {
    AppMethodBeat.i(157084);
    if (!"toolsmp".equals(aifr))
    {
      AppMethodBeat.o(157084);
      return;
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      if ((WebView.getCurWebType() != WebView.WebViewKind.aifI) && (WebView.getCurWebType() != WebView.WebViewKind.aifL)) {
        break label72;
      }
    }
    for (int j = 180;; j = 190)
    {
      y(903L, i + j, 1L);
      AppMethodBeat.o(157084);
      return;
      i = 1;
      break;
      label72:
      if (WebView.getCurWebType() != WebView.WebViewKind.aifJ) {
        break label88;
      }
    }
    label88:
    AppMethodBeat.o(157084);
  }
  
  /* Error */
  public static void a(WebView.WebViewKind paramWebViewKind, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 146
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 148	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 150
    //   13: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: getstatic 158	com/tencent/xweb/util/l$b$a:hjP	I
    //   19: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: invokevirtual 166	com/tencent/xweb/WebView$WebViewKind:toString	()Ljava/lang/String;
    //   26: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 171
    //   31: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_1
    //   35: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 178	com/tencent/xweb/internal/d:bHQ	(Ljava/lang/String;)Z
    //   44: ifeq +107 -> 151
    //   47: new 8	com/tencent/xweb/util/l$a
    //   50: dup
    //   51: getstatic 158	com/tencent/xweb/util/l$b$a:hjP	I
    //   54: invokespecial 180	com/tencent/xweb/util/l$a:<init>	(I)V
    //   57: astore_3
    //   58: aload_3
    //   59: iload_1
    //   60: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   63: invokevirtual 190	com/tencent/xweb/util/l$a:ho	(Ljava/lang/Object;)Lcom/tencent/xweb/util/l$a;
    //   66: pop
    //   67: aload_0
    //   68: getstatic 133	com/tencent/xweb/WebView$WebViewKind:aifI	Lcom/tencent/xweb/WebView$WebViewKind;
    //   71: if_acmpeq +10 -> 81
    //   74: aload_0
    //   75: getstatic 136	com/tencent/xweb/WebView$WebViewKind:aifL	Lcom/tencent/xweb/WebView$WebViewKind;
    //   78: if_acmpne +79 -> 157
    //   81: aload_3
    //   82: invokestatic 193	org/xwalk/core/XWalkEnvironment:getInstalledNewstVersionForCurAbi	()I
    //   85: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: invokevirtual 190	com/tencent/xweb/util/l$a:ho	(Ljava/lang/Object;)Lcom/tencent/xweb/util/l$a;
    //   91: pop
    //   92: aload_3
    //   93: invokestatic 72	com/tencent/xweb/ao:kge	()I
    //   96: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: invokevirtual 190	com/tencent/xweb/util/l$a:ho	(Ljava/lang/Object;)Lcom/tencent/xweb/util/l$a;
    //   102: pop
    //   103: ldc 195
    //   105: invokestatic 200	com/tencent/xweb/util/b:khw	()Ljava/lang/String;
    //   108: invokevirtual 203	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   111: ifeq +127 -> 238
    //   114: aload_3
    //   115: getstatic 206	com/tencent/xweb/util/l$b$a:aimM	I
    //   118: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: invokevirtual 190	com/tencent/xweb/util/l$a:ho	(Ljava/lang/Object;)Lcom/tencent/xweb/util/l$a;
    //   124: pop
    //   125: aload_3
    //   126: aload_0
    //   127: invokevirtual 209	com/tencent/xweb/WebView$WebViewKind:ordinal	()I
    //   130: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: invokevirtual 190	com/tencent/xweb/util/l$a:ho	(Ljava/lang/Object;)Lcom/tencent/xweb/util/l$a;
    //   136: pop
    //   137: aload_3
    //   138: getfield 212	com/tencent/xweb/util/l$a:aimJ	I
    //   141: aload_3
    //   142: getfield 216	com/tencent/xweb/util/l$a:dgR	Ljava/lang/StringBuilder;
    //   145: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 220	com/tencent/xweb/util/l:ev	(ILjava/lang/String;)V
    //   151: ldc 146
    //   153: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: return
    //   157: aload_0
    //   158: getstatic 144	com/tencent/xweb/WebView$WebViewKind:aifJ	Lcom/tencent/xweb/WebView$WebViewKind;
    //   161: if_acmpne +44 -> 205
    //   164: invokestatic 224	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   167: invokestatic 228	com/tencent/xweb/WebView:getInstalledTbsCoreVersion	(Landroid/content/Context;)I
    //   170: istore_1
    //   171: aload_3
    //   172: iload_1
    //   173: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: invokevirtual 190	com/tencent/xweb/util/l$a:ho	(Ljava/lang/Object;)Lcom/tencent/xweb/util/l$a;
    //   179: pop
    //   180: goto -88 -> 92
    //   183: astore 4
    //   185: ldc 230
    //   187: ldc 232
    //   189: aload 4
    //   191: invokestatic 235	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   194: invokevirtual 239	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   197: invokestatic 245	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: iload_2
    //   201: istore_1
    //   202: goto -31 -> 171
    //   205: aload_0
    //   206: getstatic 248	com/tencent/xweb/WebView$WebViewKind:aifK	Lcom/tencent/xweb/WebView$WebViewKind;
    //   209: if_acmpne +17 -> 226
    //   212: aload_3
    //   213: invokestatic 253	com/tencent/xweb/util/d:kgg	()I
    //   216: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: invokevirtual 190	com/tencent/xweb/util/l$a:ho	(Ljava/lang/Object;)Lcom/tencent/xweb/util/l$a;
    //   222: pop
    //   223: goto -131 -> 92
    //   226: aload_3
    //   227: iconst_0
    //   228: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: invokevirtual 190	com/tencent/xweb/util/l$a:ho	(Ljava/lang/Object;)Lcom/tencent/xweb/util/l$a;
    //   234: pop
    //   235: goto -143 -> 92
    //   238: ldc 255
    //   240: invokestatic 200	com/tencent/xweb/util/b:khw	()Ljava/lang/String;
    //   243: invokevirtual 203	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   246: ifeq -121 -> 125
    //   249: aload_3
    //   250: getstatic 258	com/tencent/xweb/util/l$b$a:aimN	I
    //   253: invokestatic 186	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokevirtual 190	com/tencent/xweb/util/l$a:ho	(Ljava/lang/Object;)Lcom/tencent/xweb/util/l$a;
    //   259: pop
    //   260: goto -135 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramWebViewKind	WebView.WebViewKind
    //   0	263	1	paramInt	int
    //   1	200	2	i	int
    //   57	193	3	locala	a
    //   183	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   164	171	183	finally
  }
  
  public static void a(WebView.WebViewKind paramWebViewKind, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(213067);
    if (aimH == null)
    {
      AppMethodBeat.o(213067);
      return;
    }
    switch (1.ueK[paramWebViewKind.ordinal()])
    {
    default: 
      AppMethodBeat.o(213067);
      return;
    case 2: 
      if (paramBoolean)
      {
        i = 78;
        aimH.p(1749L, i, 1L);
        if (!paramBoolean) {
          break label157;
        }
      }
      break;
    }
    label157:
    for (int i = 1;; i = 2)
    {
      com.tencent.xweb.b.d.a(paramWebViewKind, i, 2, false, paramString);
      AppMethodBeat.o(213067);
      return;
      i = 82;
      break;
      if (paramBoolean)
      {
        i = 77;
        break;
      }
      i = 81;
      break;
      if (paramBoolean)
      {
        i = 76;
        break;
      }
      i = 80;
      break;
      if (paramBoolean)
      {
        i = 75;
        break;
      }
      i = 79;
      break;
    }
  }
  
  public static void a(aj paramaj)
  {
    aimH = paramaj;
  }
  
  public static void a(String paramString, WebView paramWebView)
  {
    label396:
    label415:
    for (;;)
    {
      int j;
      int i;
      try
      {
        AppMethodBeat.i(175650);
        if (aimH == null)
        {
          AppMethodBeat.o(175650);
          return;
        }
        if (!aimI)
        {
          if ("toolsmp".equals(aifr))
          {
            if (!khF()) {
              break label296;
            }
            qf(903, 106);
          }
          j = khI();
          i = WebView.getCurWebType().ordinal() - 1;
          if (WebView.getCurWebType() == WebView.WebViewKind.aifL) {
            i = WebView.WebViewKind.aifI.ordinal() - 1;
          }
          if ((j >= 30) && (i >= 0))
          {
            aimI = true;
            qf(903, i + (j + 3));
          }
        }
        if (paramWebView.isX5WrappedSysKernel())
        {
          if (!aifr.equals("mm")) {
            break label313;
          }
          i = 79;
          j = 74;
          if (j != 0) {
            aimH.p(903L, j, 1L);
          }
          if (i != 0) {
            qf(903, i);
          }
        }
        if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
          aimH.p(903L, 102L, 1L);
        }
        j = khI();
        i = WebView.getCurWebType().ordinal() - 1;
        if (WebView.getCurWebType() == WebView.WebViewKind.aifL) {
          i = WebView.WebViewKind.aifI.ordinal() - 1;
        }
        if ((j >= 30) && (i >= 0)) {
          aimH.p(903L, i + (j + 0), 1L);
        }
        if (!"toolsmp".equals(aifr)) {
          break label415;
        }
        if (!khF()) {
          break label396;
        }
        aimH.p(903L, 107L, 1L);
        AppMethodBeat.o(175650);
        continue;
        if (!khG()) {
          continue;
        }
      }
      finally {}
      label296:
      qf(903, 108);
      continue;
      label313:
      if (aifr.equals("tools"))
      {
        i = 75;
        j = 70;
      }
      else if (aifr.equals("toolsmp"))
      {
        i = 75;
        j = 71;
      }
      else if (aifr.equals("appbrand"))
      {
        i = 77;
        j = 72;
      }
      else if (aifr.equals("support"))
      {
        i = 78;
        j = 73;
        continue;
        if (khG()) {
          aimH.p(903L, 109L, 1L);
        }
        AppMethodBeat.o(175650);
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  public static boolean aJE(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void aJF(int paramInt)
  {
    AppMethodBeat.i(157083);
    if (!"toolsmp".equals(aifr))
    {
      AppMethodBeat.o(157083);
      return;
    }
    int j;
    int i;
    if ((WebView.getCurWebType() == WebView.WebViewKind.aifI) || (WebView.getCurWebType() == WebView.WebViewKind.aifL))
    {
      j = 200;
      if (paramInt >= 0) {
        break label93;
      }
      i = 3;
    }
    for (;;)
    {
      y(903L, j + i, 1L);
      AppMethodBeat.o(157083);
      return;
      if (WebView.getCurWebType() == WebView.WebViewKind.aifJ)
      {
        j = 220;
        break;
      }
      AppMethodBeat.o(157083);
      return;
      label93:
      i = paramInt;
      if (paramInt > 9) {
        i = 4;
      }
    }
  }
  
  public static void bIe(String paramString)
  {
    if (paramString != null) {
      aifr = paramString;
    }
  }
  
  public static void bIf(String paramString)
  {
    int j = 73;
    AppMethodBeat.i(157022);
    int i;
    if (aimH != null)
    {
      aimH.p(577L, 0L, 1L);
      if ((aifr.equals("toolsmp")) && (paramString != null) && (bIg(paramString) == 2)) {
        aimH.p(903L, 101L, 1L);
      }
      if (!aifr.equals("toolsmp")) {
        break label207;
      }
      if ((WebView.getCurWebType() != WebView.WebViewKind.aifI) && (WebView.getCurWebType() != WebView.WebViewKind.aifL)) {
        break label182;
      }
      aimH.p(903L, 105L, 1L);
      if (!aimF)
      {
        if (!aifr.equals("tools")) {
          break label247;
        }
        i = 70;
      }
    }
    for (;;)
    {
      j = WebView.getCurWebType().ordinal() - 1;
      if (WebView.getCurWebType() == WebView.WebViewKind.aifL) {
        j = WebView.WebViewKind.aifI.ordinal() - 1;
      }
      if ((i >= 70) && (j >= 0))
      {
        aimF = true;
        qf(577, i + j);
      }
      AppMethodBeat.o(157022);
      return;
      label182:
      if (WebView.getCurWebType() != WebView.WebViewKind.aifJ) {
        break;
      }
      aimH.p(903L, 104L, 1L);
      break;
      label207:
      if ((!aifr.equals("tools")) || (paramString == null) || (bIg(paramString) != 1)) {
        break;
      }
      aimH.p(903L, 103L, 1L);
      break;
      label247:
      i = j;
      if (!aifr.equals("appbrand"))
      {
        i = j;
        if (!aifr.equals("support")) {
          i = -1;
        }
      }
    }
  }
  
  public static int bIg(String paramString)
  {
    AppMethodBeat.i(157036);
    if (paramString.startsWith("https://servicewechat.com/"))
    {
      AppMethodBeat.o(157036);
      return 0;
    }
    if ((paramString.startsWith("http://mp.weixin.qq.com/")) || (paramString.startsWith("https://mp.weixin.qq.com/")) || (paramString.startsWith("https://servicewechat.com/preload/")) || (paramString.startsWith("http://mp.weixinbridge.com/")))
    {
      AppMethodBeat.o(157036);
      return 1;
    }
    AppMethodBeat.o(157036);
    return 2;
  }
  
  public static void bIh(String paramString)
  {
    AppMethodBeat.i(212970);
    if (aimH == null)
    {
      AppMethodBeat.o(212970);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aimH.p(1068L, 57L, 1L);
      AppMethodBeat.o(212970);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aimH.p(1071L, 57L, 1L);
      AppMethodBeat.o(212970);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aimH.p(1069L, 57L, 1L);
      AppMethodBeat.o(212970);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aimH.p(1070L, 57L, 1L);
      AppMethodBeat.o(212970);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aimH.p(1544L, 57L, 1L);
    }
    AppMethodBeat.o(212970);
  }
  
  public static void bIi(String paramString)
  {
    AppMethodBeat.i(157079);
    if (aimH == null)
    {
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aimH.p(1068L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aimH.p(1071L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aimH.p(1069L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aimH.p(1070L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aimH.p(1544L, 66L, 1L);
    }
    AppMethodBeat.o(157079);
  }
  
  public static void bIj(String paramString)
  {
    AppMethodBeat.i(157080);
    if ((paramString == null) || (paramString.isEmpty()) || (aimH == null))
    {
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      aimH.p(1068L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      aimH.p(1071L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      aimH.p(1069L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      aimH.p(1070L, 67L, 1L);
    }
    AppMethodBeat.o(157080);
  }
  
  public static void bIk(String paramString)
  {
    AppMethodBeat.i(157081);
    if ((paramString == null) || (paramString.isEmpty()) || (aimH == null))
    {
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      aimH.p(1068L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      aimH.p(1071L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      aimH.p(1069L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      aimH.p(1070L, 68L, 1L);
    }
    AppMethodBeat.o(157081);
  }
  
  public static void bO(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(212638);
    Log.i("WXWebReporter", "report idkey id = " + paramLong1 + " key = " + paramLong2 + " value = 1");
    if (aimH != null) {
      aimH.p(paramLong1, paramLong2, 1L);
    }
    AppMethodBeat.o(212638);
  }
  
  public static void d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(157034);
    khJ();
    if (aimH != null)
    {
      aimH.p(577L, 5L, 1L);
      aimH.b(ao.kge(), XWalkEnvironment.getAvailableVersion(), bIg(paramString), sessionId, 1, paramInt1, (int)paramLong, paramInt2);
    }
    AppMethodBeat.o(157034);
  }
  
  public static void dd(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157045);
    if (aimH != null)
    {
      int i = 0;
      switch (paramInt)
      {
      default: 
        paramInt = i;
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        aimH.p(577L, paramInt, 1L);
      }
      AppMethodBeat.o(157045);
      return;
      if (paramBoolean)
      {
        paramInt = 163;
      }
      else
      {
        paramInt = 159;
        continue;
        if (paramBoolean)
        {
          paramInt = 164;
        }
        else
        {
          paramInt = 160;
          continue;
          if (paramBoolean)
          {
            paramInt = 165;
          }
          else
          {
            paramInt = 161;
            continue;
            if (paramBoolean) {
              paramInt = 166;
            } else {
              paramInt = 162;
            }
          }
        }
      }
    }
  }
  
  public static void de(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157046);
    if (aimH != null)
    {
      int i = 0;
      switch (paramInt)
      {
      default: 
        paramInt = i;
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        aimH.p(577L, paramInt, 1L);
      }
      AppMethodBeat.o(157046);
      return;
      if (paramBoolean)
      {
        paramInt = 155;
      }
      else
      {
        paramInt = 151;
        continue;
        if (paramBoolean)
        {
          paramInt = 156;
        }
        else
        {
          paramInt = 152;
          continue;
          if (paramBoolean)
          {
            paramInt = 157;
          }
          else
          {
            paramInt = 153;
            continue;
            if (paramBoolean) {
              paramInt = 158;
            } else {
              paramInt = 154;
            }
          }
        }
      }
    }
  }
  
  public static void eK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212947);
    if (aimH == null)
    {
      AppMethodBeat.o(212947);
      return;
    }
    if (paramBoolean) {}
    for (int i = 51; "FullScreenVideo".equals(paramString); i = 60)
    {
      aimH.p(577L, 185L, 1L);
      AppMethodBeat.o(212947);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aimH.p(1068L, i, 1L);
      AppMethodBeat.o(212947);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aimH.p(1071L, i, 1L);
      AppMethodBeat.o(212947);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aimH.p(1069L, i, 1L);
      AppMethodBeat.o(212947);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aimH.p(1070L, i, 1L);
      AppMethodBeat.o(212947);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aimH.p(1544L, i, 1L);
    }
    AppMethodBeat.o(212947);
  }
  
  public static void eL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212953);
    if (aimH == null)
    {
      AppMethodBeat.o(212953);
      return;
    }
    if (paramBoolean) {}
    for (int i = 52; "FullScreenVideo".equals(paramString); i = 61)
    {
      aimH.p(577L, 186L, 1L);
      AppMethodBeat.o(212953);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aimH.p(1068L, i, 1L);
      AppMethodBeat.o(212953);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aimH.p(1071L, i, 1L);
      AppMethodBeat.o(212953);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aimH.p(1069L, i, 1L);
      AppMethodBeat.o(212953);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aimH.p(1070L, i, 1L);
      AppMethodBeat.o(212953);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aimH.p(1544L, i, 1L);
    }
    AppMethodBeat.o(212953);
  }
  
  public static void eM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212957);
    if (aimH == null)
    {
      AppMethodBeat.o(212957);
      return;
    }
    if (paramBoolean) {}
    for (int i = 54; "FullScreenVideo".equals(paramString); i = 62)
    {
      aimH.p(577L, 187L, 1L);
      AppMethodBeat.o(212957);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aimH.p(1068L, i, 1L);
      AppMethodBeat.o(212957);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aimH.p(1071L, i, 1L);
      AppMethodBeat.o(212957);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aimH.p(1069L, i, 1L);
      AppMethodBeat.o(212957);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aimH.p(1070L, i, 1L);
      AppMethodBeat.o(212957);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aimH.p(1544L, i, 1L);
    }
    AppMethodBeat.o(212957);
  }
  
  public static void eN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212964);
    if (aimH == null)
    {
      AppMethodBeat.o(212964);
      return;
    }
    if (paramBoolean) {}
    for (int i = 55; "FullScreenVideo".equals(paramString); i = 63)
    {
      aimH.p(577L, 188L, 1L);
      AppMethodBeat.o(212964);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aimH.p(1068L, i, 1L);
      AppMethodBeat.o(212964);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aimH.p(1071L, i, 1L);
      AppMethodBeat.o(212964);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aimH.p(1069L, i, 1L);
      AppMethodBeat.o(212964);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aimH.p(1070L, i, 1L);
      AppMethodBeat.o(212964);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aimH.p(1544L, i, 1L);
    }
    AppMethodBeat.o(212964);
  }
  
  public static void eO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(212976);
    if (aimH == null)
    {
      AppMethodBeat.o(212976);
      return;
    }
    if (paramBoolean) {}
    for (int i = 59; "XFilesPPTReader".equals(paramString); i = 65)
    {
      aimH.p(1068L, i, 1L);
      AppMethodBeat.o(212976);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aimH.p(1071L, i, 1L);
      AppMethodBeat.o(212976);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aimH.p(1069L, i, 1L);
      AppMethodBeat.o(212976);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aimH.p(1070L, i, 1L);
      AppMethodBeat.o(212976);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aimH.p(1544L, i, 1L);
    }
    AppMethodBeat.o(212976);
  }
  
  public static void eP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(213059);
    int j = i.bIb(paramString).intValue();
    if (paramBoolean) {}
    for (int i = 0;; i = 100)
    {
      y(1511L, i + j % 100, 1L);
      AppMethodBeat.o(213059);
      return;
    }
  }
  
  public static void ev(int paramInt, String paramString)
  {
    AppMethodBeat.i(157019);
    if (aimH != null) {
      aimH.kvStat(paramInt, paramString);
    }
    AppMethodBeat.o(157019);
  }
  
  public static void g(WebView.WebViewKind paramWebViewKind)
  {
    aimG = paramWebViewKind;
  }
  
  public static boolean gBh()
  {
    return aimH != null;
  }
  
  public static void h(WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(157018);
    if (aimH == null)
    {
      AppMethodBeat.o(157018);
      return;
    }
    int i;
    String str1;
    label43:
    String str3;
    String str2;
    if ((paramWebViewKind == WebView.WebViewKind.aifI) || (paramWebViewKind == WebView.WebViewKind.aifL))
    {
      i = 1;
      if (i == 0) {
        break label134;
      }
      str1 = "REPORT_APK_VER_TIME";
      str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
      str2 = XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().getString(str1, "");
      if (str2 != null) {
        break label325;
      }
      str2 = "";
    }
    label134:
    label325:
    for (;;)
    {
      if ((paramWebViewKind == WebView.WebViewKind.aifI) || (paramWebViewKind == WebView.WebViewKind.aifL))
      {
        i = XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().getInt("REPORT_XWEB_APK_VER", 0);
        int j = XWalkEnvironment.getAvailableVersion();
        if (j <= 0)
        {
          AppMethodBeat.o(157018);
          return;
          i = 0;
          break;
          str1 = "REPORT_APK_VER_TIME_".concat(String.valueOf(paramWebViewKind));
          break label43;
        }
        if ((j != i) || (!str3.equals(str2)))
        {
          aimH.p(577L, j % 50 + 100, 1L);
          XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
        }
      }
      if (str3.equals(str2))
      {
        AppMethodBeat.o(157018);
        return;
      }
      if ((paramWebViewKind == WebView.WebViewKind.aifI) || (paramWebViewKind == WebView.WebViewKind.aifL))
      {
        if (XWalkEnvironment.getAvailableVersion() <= 0)
        {
          AppMethodBeat.o(157018);
          return;
        }
        i = 99;
      }
      for (;;)
      {
        aimH.p(577L, i, 1L);
        XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().edit().putString(str1, str3).commit();
        AppMethodBeat.o(157018);
        return;
        if (paramWebViewKind == WebView.WebViewKind.aifK)
        {
          i = 97;
        }
        else
        {
          if (paramWebViewKind != WebView.WebViewKind.aifJ) {
            break;
          }
          i = 98;
        }
      }
      AppMethodBeat.o(157018);
      return;
    }
  }
  
  public static void i(WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(157052);
    if (aimH == null)
    {
      AppMethodBeat.o(157052);
      return;
    }
    if ((paramWebViewKind == WebView.WebViewKind.aifI) || (paramWebViewKind == WebView.WebViewKind.aifL))
    {
      aimH.p(577L, 61L, 1L);
      qf(577, 62);
    }
    AppMethodBeat.o(157052);
  }
  
  public static void j(WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(157063);
    if (aimH == null)
    {
      AppMethodBeat.o(157063);
      return;
    }
    int i;
    switch (1.ueK[paramWebViewKind.ordinal()])
    {
    default: 
      AppMethodBeat.o(157063);
      return;
    case 1: 
    case 2: 
      i = 82;
    }
    for (;;)
    {
      aimH.p(577L, i, 1L);
      AppMethodBeat.o(157063);
      return;
      i = 81;
      continue;
      i = 80;
    }
  }
  
  public static void jK(String paramString, int paramInt)
  {
    AppMethodBeat.i(157033);
    bIf(paramString);
    if (aimH != null)
    {
      sessionId = UUID.randomUUID().toString().replace("-", "");
      aimH.p(577L, 4L, 1L);
      aimH.b(ao.kge(), XWalkEnvironment.getAvailableVersion(), bIg(paramString), sessionId, 0, 0, 0, paramInt);
    }
    AppMethodBeat.o(157033);
  }
  
  public static void k(WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(157065);
    if (aimH == null)
    {
      AppMethodBeat.o(157065);
      return;
    }
    int i;
    switch (1.ueK[paramWebViewKind.ordinal()])
    {
    default: 
      AppMethodBeat.o(157065);
      return;
    case 1: 
    case 2: 
      i = 86;
    }
    for (;;)
    {
      aimH.p(577L, i, 1L);
      AppMethodBeat.o(157065);
      return;
      i = 85;
      continue;
      i = 84;
    }
  }
  
  private static boolean khF()
  {
    AppMethodBeat.i(157015);
    if (((aimG == WebView.WebViewKind.aifI) || (aimG == WebView.WebViewKind.aifL)) && (WebView.getCurWebType() != aimG))
    {
      AppMethodBeat.o(157015);
      return true;
    }
    AppMethodBeat.o(157015);
    return false;
  }
  
  private static boolean khG()
  {
    AppMethodBeat.i(157016);
    if (((WebView.getCurWebType() == WebView.WebViewKind.aifI) || (WebView.getCurWebType() == WebView.WebViewKind.aifL)) && (WebView.getCurWebType() != aimG))
    {
      AppMethodBeat.o(157016);
      return true;
    }
    AppMethodBeat.o(157016);
    return false;
  }
  
  public static void khH()
  {
    AppMethodBeat.i(212657);
    String str2 = b.khw();
    String str1;
    int i;
    int j;
    if ("armeabi-v7a".equals(str2))
    {
      str1 = "arm64-v8a";
      i = XWalkEnvironment.getInstalledNewstVersion(str2);
      j = XWalkEnvironment.getInstalledNewstVersion(str1);
      Log.i("WXWebReporter", "reportCoreInstalled, cur abi(" + str2 + "), ver = " + i + ", predown abi(" + str1 + "), ver = " + j);
      boolean bool = com.tencent.xweb.internal.d.qY("report_core_ver", String.valueOf(i));
      if ((com.tencent.xweb.internal.d.bHQ("report_core_daily")) || (bool))
      {
        if (i > 0) {
          break label207;
        }
        bO(1367L, 251L);
      }
      label125:
      bool = com.tencent.xweb.internal.d.qY("report_core_ver_predown", String.valueOf(j));
      if ((com.tencent.xweb.internal.d.bHQ("report_core_daily_predown")) || (bool))
      {
        if (j > 0) {
          break label223;
        }
        bO(1367L, 252L);
      }
    }
    for (;;)
    {
      if ("armeabi-v7a".equalsIgnoreCase(str2))
      {
        str1 = b.khx();
        if ("armeabi-v7a".equalsIgnoreCase(str1))
        {
          qf(1367, 253);
          AppMethodBeat.o(212657);
          return;
          str1 = "armeabi-v7a";
          break;
          label207:
          bO(1367L, i % 100 + 0);
          break label125;
          label223:
          bO(1367L, j % 100 + 100);
          continue;
        }
        if ("arm64-v8a".equalsIgnoreCase(str1)) {
          qf(1367, 254);
        }
        AppMethodBeat.o(212657);
        return;
      }
    }
    if ("arm64-v8a".equalsIgnoreCase(str2)) {
      qf(1367, 255);
    }
    AppMethodBeat.o(212657);
  }
  
  private static int khI()
  {
    AppMethodBeat.i(157023);
    int i = -1;
    if (aifr.equals("mm")) {
      i = 30;
    }
    for (;;)
    {
      AppMethodBeat.o(157023);
      return i;
      if (aifr.equals("tools")) {
        i = 36;
      } else if (aifr.equals("toolsmp")) {
        i = 42;
      } else if (aifr.equals("appbrand")) {
        i = 48;
      } else if (aifr.equals("support")) {
        i = 54;
      }
    }
  }
  
  public static void khJ()
  {
    AppMethodBeat.i(157025);
    if (aimH != null) {
      aimH.p(577L, 1L, 1L);
    }
    AppMethodBeat.o(157025);
  }
  
  public static void khK()
  {
    AppMethodBeat.i(157027);
    if (aimH != null) {
      aimH.p(577L, 46L, 1L);
    }
    AppMethodBeat.o(157027);
  }
  
  public static void khL()
  {
    AppMethodBeat.i(157028);
    if (aimH != null) {
      aimH.p(577L, 47L, 1L);
    }
    AppMethodBeat.o(157028);
  }
  
  public static void khM()
  {
    AppMethodBeat.i(157030);
    if (aimH != null) {
      aimH.p(577L, 42L, 1L);
    }
    AppMethodBeat.o(157030);
  }
  
  public static void khN()
  {
    AppMethodBeat.i(157031);
    if (aimH != null) {
      aimH.p(577L, 43L, 1L);
    }
    AppMethodBeat.o(157031);
  }
  
  public static void khO()
  {
    AppMethodBeat.i(212708);
    if (aimH != null) {
      aimH.p(1749L, 0L, 1L);
    }
    AppMethodBeat.o(212708);
  }
  
  public static void khP()
  {
    AppMethodBeat.i(212714);
    if (aimH != null) {
      aimH.p(1749L, 1L, 1L);
    }
    AppMethodBeat.o(212714);
  }
  
  public static void khQ()
  {
    AppMethodBeat.i(212718);
    if (aimH != null) {
      aimH.p(1749L, 2L, 1L);
    }
    AppMethodBeat.o(212718);
  }
  
  public static void khR()
  {
    AppMethodBeat.i(212724);
    if (aimH != null) {
      aimH.p(1749L, 3L, 1L);
    }
    AppMethodBeat.o(212724);
  }
  
  public static void khS()
  {
    AppMethodBeat.i(157037);
    if (aimH != null)
    {
      aimH.p(577L, 52L, 1L);
      aimH.p(1749L, 4L, 1L);
    }
    AppMethodBeat.o(157037);
  }
  
  public static void khT()
  {
    AppMethodBeat.i(157038);
    if (aimH != null) {
      aimH.p(577L, 53L, 1L);
    }
    AppMethodBeat.o(157038);
  }
  
  public static void khU()
  {
    AppMethodBeat.i(157039);
    if (aimH != null) {
      aimH.p(577L, 54L, 1L);
    }
    AppMethodBeat.o(157039);
  }
  
  public static void khV()
  {
    AppMethodBeat.i(157040);
    if (aimH != null) {
      aimH.p(577L, 55L, 1L);
    }
    AppMethodBeat.o(157040);
  }
  
  public static void khW()
  {
    AppMethodBeat.i(157041);
    if (aimH != null)
    {
      aimH.p(577L, 56L, 1L);
      aimH.p(1749L, 5L, 1L);
    }
    AppMethodBeat.o(157041);
  }
  
  public static void khX()
  {
    AppMethodBeat.i(157042);
    if (aimH != null) {
      aimH.p(577L, 57L, 1L);
    }
    AppMethodBeat.o(157042);
  }
  
  public static void khY()
  {
    AppMethodBeat.i(157043);
    if (aimH != null) {
      aimH.p(577L, 58L, 1L);
    }
    AppMethodBeat.o(157043);
  }
  
  public static void khZ()
  {
    AppMethodBeat.i(212751);
    if (aimH != null) {
      aimH.p(577L, 175L, 1L);
    }
    AppMethodBeat.o(212751);
  }
  
  public static void kiA()
  {
    AppMethodBeat.i(157068);
    if (aimH != null) {
      aimH.p(577L, 182L, 1L);
    }
    AppMethodBeat.o(157068);
  }
  
  public static void kiB()
  {
    AppMethodBeat.i(157069);
    if (aimH != null) {
      aimH.p(577L, 183L, 1L);
    }
    AppMethodBeat.o(157069);
  }
  
  public static void kiC()
  {
    AppMethodBeat.i(157070);
    if (aimH != null) {
      aimH.p(577L, 184L, 1L);
    }
    AppMethodBeat.o(157070);
  }
  
  public static void kiD()
  {
    AppMethodBeat.i(157071);
    if (aimH != null) {
      aimH.p(577L, 189L, 1L);
    }
    AppMethodBeat.o(157071);
  }
  
  public static void kiE()
  {
    AppMethodBeat.i(157072);
    if (aimH != null) {
      aimH.p(577L, 190L, 1L);
    }
    AppMethodBeat.o(157072);
  }
  
  public static void kiF()
  {
    AppMethodBeat.i(157082);
    if (aimH == null)
    {
      AppMethodBeat.o(157082);
      return;
    }
    aimH.p(577L, 88L, 1L);
    AppMethodBeat.o(157082);
  }
  
  public static void kiG()
  {
    AppMethodBeat.i(157085);
    y(938L, 89L, 1L);
    AppMethodBeat.o(157085);
  }
  
  public static void kiH()
  {
    AppMethodBeat.i(157086);
    y(938L, 90L, 1L);
    AppMethodBeat.o(157086);
  }
  
  public static void kiI()
  {
    AppMethodBeat.i(157087);
    y(938L, 91L, 1L);
    AppMethodBeat.o(157087);
  }
  
  public static void kia()
  {
    AppMethodBeat.i(212754);
    if (aimH != null)
    {
      aimH.p(577L, 168L, 1L);
      aimH.p(1749L, 6L, 1L);
    }
    AppMethodBeat.o(212754);
  }
  
  public static void kib()
  {
    AppMethodBeat.i(212758);
    if (aimH != null) {
      aimH.p(577L, 169L, 1L);
    }
    AppMethodBeat.o(212758);
  }
  
  public static void kic()
  {
    AppMethodBeat.i(212763);
    if (aimH != null) {
      aimH.p(577L, 174L, 1L);
    }
    AppMethodBeat.o(212763);
  }
  
  public static void kid()
  {
    AppMethodBeat.i(157044);
    if (aimH != null) {
      aimH.p(577L, 59L, 1L);
    }
    AppMethodBeat.o(157044);
  }
  
  public static void kie()
  {
    AppMethodBeat.i(212784);
    if (aimH != null) {
      aimH.p(1749L, 7L, 1L);
    }
    AppMethodBeat.o(212784);
  }
  
  public static void kif()
  {
    AppMethodBeat.i(212790);
    if (aimH != null) {
      aimH.p(1749L, 8L, 1L);
    }
    AppMethodBeat.o(212790);
  }
  
  public static void kig()
  {
    AppMethodBeat.i(212792);
    if (aimH != null) {
      aimH.p(1749L, 9L, 1L);
    }
    AppMethodBeat.o(212792);
  }
  
  public static void kih()
  {
    AppMethodBeat.i(212796);
    if (aimH != null) {
      aimH.p(1749L, 10L, 1L);
    }
    AppMethodBeat.o(212796);
  }
  
  public static void kii()
  {
    AppMethodBeat.i(212799);
    if (aimH != null) {
      aimH.p(1749L, 11L, 1L);
    }
    AppMethodBeat.o(212799);
  }
  
  public static void kij()
  {
    AppMethodBeat.i(212806);
    if (aimH != null) {
      aimH.p(1749L, 12L, 1L);
    }
    AppMethodBeat.o(212806);
  }
  
  public static void kik()
  {
    AppMethodBeat.i(212815);
    if (aimH != null) {
      aimH.p(1749L, 13L, 1L);
    }
    AppMethodBeat.o(212815);
  }
  
  public static void kil()
  {
    AppMethodBeat.i(212820);
    if (aimH != null) {
      aimH.p(1749L, 14L, 1L);
    }
    AppMethodBeat.o(212820);
  }
  
  public static void kim()
  {
    AppMethodBeat.i(157047);
    if (aimH != null) {
      aimH.p(577L, 167L, 1L);
    }
    AppMethodBeat.o(157047);
  }
  
  public static void kin()
  {
    AppMethodBeat.i(157048);
    if (aimH != null) {
      aimH.p(577L, 9L, 1L);
    }
    AppMethodBeat.o(157048);
  }
  
  public static void kio()
  {
    AppMethodBeat.i(157050);
    if (aimH != null) {
      aimH.p(577L, 10L, 1L);
    }
    AppMethodBeat.o(157050);
  }
  
  public static void kip()
  {
    AppMethodBeat.i(157051);
    if (aimH != null) {
      aimH.p(577L, 60L, 1L);
    }
    AppMethodBeat.o(157051);
  }
  
  public static void kiq()
  {
    AppMethodBeat.i(157053);
    if (aimH != null) {
      aimH.p(577L, 20L, 1L);
    }
    AppMethodBeat.o(157053);
  }
  
  public static void kir()
  {
    AppMethodBeat.i(157055);
    if (aimH != null) {
      aimH.p(577L, 21L, 1L);
    }
    AppMethodBeat.o(157055);
  }
  
  public static void kis()
  {
    AppMethodBeat.i(157056);
    if (aimH != null) {
      aimH.p(577L, 25L, 1L);
    }
    AppMethodBeat.o(157056);
  }
  
  public static void kit()
  {
    AppMethodBeat.i(157058);
    if (aimH != null) {
      aimH.p(577L, 26L, 1L);
    }
    AppMethodBeat.o(157058);
  }
  
  public static void kiu()
  {
    AppMethodBeat.i(157059);
    if (aimH != null) {
      aimH.p(577L, 14L, 1L);
    }
    AppMethodBeat.o(157059);
  }
  
  public static void kiv()
  {
    AppMethodBeat.i(157060);
    if (aimH != null) {
      aimH.p(577L, 15L, 1L);
    }
    AppMethodBeat.o(157060);
  }
  
  public static void kiw()
  {
    AppMethodBeat.i(157062);
    if (aimH == null)
    {
      AppMethodBeat.o(157062);
      return;
    }
    aimH.p(577L, 83L, 1L);
    AppMethodBeat.o(157062);
  }
  
  public static void kix()
  {
    AppMethodBeat.i(157064);
    if (aimH == null)
    {
      AppMethodBeat.o(157064);
      return;
    }
    aimH.p(577L, 87L, 1L);
    AppMethodBeat.o(157064);
  }
  
  public static void kiy()
  {
    AppMethodBeat.i(157066);
    if (aimH != null) {
      aimH.p(577L, 180L, 1L);
    }
    AppMethodBeat.o(157066);
  }
  
  public static void kiz()
  {
    AppMethodBeat.i(157067);
    if (aimH != null) {
      aimH.p(577L, 181L, 1L);
    }
    AppMethodBeat.o(157067);
  }
  
  public static void qf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157017);
    if (aimH == null)
    {
      AppMethodBeat.o(157017);
      return;
    }
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForReportDaily();
    String str1 = "id_" + paramInt1 + "_key_" + paramInt2;
    String str2 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    if (str2.equals(localSharedPreferences.getString(str1, "")))
    {
      AppMethodBeat.o(157017);
      return;
    }
    aimH.p(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString(str1, str2).commit();
    AppMethodBeat.o(157017);
  }
  
  public static void y(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(157021);
    if (aimH != null) {
      aimH.p(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(157021);
  }
  
  public static final class a
  {
    int aimJ;
    StringBuilder dgR;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(175648);
      this.dgR = new StringBuilder();
      this.aimJ = 0;
      this.aimJ = paramInt;
      AppMethodBeat.o(175648);
    }
    
    public final a ho(Object paramObject)
    {
      AppMethodBeat.i(175649);
      if (this.dgR.length() > 0) {
        this.dgR.append(",");
      }
      this.dgR.append(paramObject.toString());
      AppMethodBeat.o(175649);
      return this;
    }
  }
  
  public static final class b$a
  {
    public static int aimK = 1;
    public static int aimL = 2;
    public static int aimM = 1;
    public static int aimN = 2;
    public static int hjP = 19307;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.util.l
 * JD-Core Version:    0.7.0.1
 */