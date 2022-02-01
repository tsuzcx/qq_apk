package com.tencent.xweb.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ag;
import com.tencent.xweb.internal.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class h
{
  public static String aaaX = "";
  private static boolean aafR = false;
  static WebView.c aafS = WebView.c.aabl;
  static ag aafT = null;
  static boolean aafU = false;
  public static String sessionId = "";
  
  public static void IT(boolean paramBoolean)
  {
    AppMethodBeat.i(157084);
    if (!"toolsmp".equals(aaaX))
    {
      AppMethodBeat.o(157084);
      return;
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (WebView.getCurWebType() != WebView.c.aabm) {
        break label63;
      }
    }
    for (int j = 180;; j = 190)
    {
      u(903L, i + j, 1L);
      AppMethodBeat.o(157084);
      return;
      i = 1;
      break;
      label63:
      if (WebView.getCurWebType() != WebView.c.aabn) {
        break label79;
      }
    }
    label79:
    AppMethodBeat.o(157084);
  }
  
  public static void Xg(long paramLong)
  {
    AppMethodBeat.i(157020);
    if (aafT != null) {
      aafT.p(577L, paramLong, 1L);
    }
    AppMethodBeat.o(157020);
  }
  
  public static void Xh(long paramLong)
  {
    AppMethodBeat.i(157026);
    if ((aafT != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      aafT.bh(2, 3, (int)paramLong);
    }
    AppMethodBeat.o(157026);
  }
  
  public static void Xi(long paramLong)
  {
    AppMethodBeat.i(157029);
    if ((aafT != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      aafT.bh(48, 49, (int)paramLong);
    }
    AppMethodBeat.o(157029);
  }
  
  public static void Xj(long paramLong)
  {
    AppMethodBeat.i(157032);
    if ((aafT != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      aafT.bh(44, 45, (int)paramLong);
    }
    AppMethodBeat.o(157032);
  }
  
  public static void Xk(long paramLong)
  {
    AppMethodBeat.i(157049);
    if ((aafT != null) && (aafT != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      aafT.bh(11, 12, (int)paramLong);
    }
    AppMethodBeat.o(157049);
  }
  
  public static void Xl(long paramLong)
  {
    AppMethodBeat.i(157054);
    if ((aafT != null) && (aafT != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      aafT.bh(22, 23, (int)paramLong);
    }
    AppMethodBeat.o(157054);
  }
  
  public static void Xm(long paramLong)
  {
    AppMethodBeat.i(157057);
    if ((aafT != null) && (aafT != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      aafT.bh(27, 28, (int)paramLong);
    }
    AppMethodBeat.o(157057);
  }
  
  public static void Xn(long paramLong)
  {
    AppMethodBeat.i(157061);
    if ((aafT != null) && (aafT != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      aafT.bh(16, 17, (int)paramLong);
    }
    AppMethodBeat.o(157061);
  }
  
  public static void a(WebView.c paramc, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175651);
    a locala;
    if (c.bFw("kv_" + b.a.ffF + paramc.toString() + "_" + paramInt))
    {
      locala = new a(b.a.ffF);
      locala.eR(Integer.valueOf(paramInt));
      if (paramc != WebView.c.aabm) {
        break label149;
      }
      locala.eR(Integer.valueOf(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
      locala.eR(Integer.valueOf(20210601));
      if (!"armeabi-v7a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        break label222;
      }
      locala.eR(Integer.valueOf(b.a.aafY));
    }
    for (;;)
    {
      for (;;)
      {
        locala.eR(Integer.valueOf(paramc.ordinal()));
        dA(locala.aafV, locala.bmW.toString());
        AppMethodBeat.o(175651);
        return;
        label149:
        if (paramc == WebView.c.aabn) {
          try
          {
            paramInt = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
            locala.eR(Integer.valueOf(paramInt));
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.e("onUseCoreFailed", "get tbs core version failed");
              paramInt = i;
            }
          }
        }
      }
      if (paramc == WebView.c.aabo)
      {
        locala.eR(Integer.valueOf(XWalkEnvironment.safeGetChromiunVersion()));
        break;
      }
      locala.eR(Integer.valueOf(0));
      break;
      label222:
      if ("arm64-v8a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        locala.eR(Integer.valueOf(b.a.aafZ));
      }
    }
  }
  
  public static void a(ag paramag)
  {
    aafT = paramag;
  }
  
  public static void a(String paramString, WebView paramWebView)
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        AppMethodBeat.i(175650);
        if (aafT == null)
        {
          AppMethodBeat.o(175650);
          return;
        }
        if (!aafU)
        {
          if ("toolsmp".equals(aaaX))
          {
            if (!ixD()) {
              break label255;
            }
            og(903, 106);
          }
          i = ixG();
          j = WebView.getCurWebType().ordinal() - 1;
          if ((i >= 30) && (j >= 0))
          {
            aafU = true;
            og(903, i + 3 + j);
          }
        }
        if (paramWebView.isX5WrappedSysKernel())
        {
          if (!aaaX.equals("mm")) {
            break label272;
          }
          i = 79;
          j = 74;
          if (j != 0) {
            aafT.p(903L, j, 1L);
          }
          if (i != 0) {
            og(903, i);
          }
        }
        if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
          aafT.p(903L, 102L, 1L);
        }
        i = ixG();
        j = WebView.getCurWebType().ordinal() - 1;
        if ((i >= 30) && (j >= 0)) {
          aafT.p(903L, i + 0 + j, 1L);
        }
        if (!"toolsmp".equals(aaaX)) {
          break label374;
        }
        if (!ixD()) {
          break label355;
        }
        aafT.p(903L, 107L, 1L);
        AppMethodBeat.o(175650);
        continue;
        if (!ixE()) {
          continue;
        }
      }
      finally {}
      label255:
      og(903, 108);
      continue;
      label272:
      if (aaaX.equals("tools"))
      {
        i = 75;
        j = 70;
      }
      else if (aaaX.equals("toolsmp"))
      {
        i = 75;
        j = 71;
      }
      else if (aaaX.equals("appbrand"))
      {
        i = 77;
        j = 72;
      }
      else if (aaaX.equals("support"))
      {
        i = 78;
        j = 73;
        continue;
        label355:
        if (ixE()) {
          aafT.p(903L, 109L, 1L);
        }
        label374:
        AppMethodBeat.o(175650);
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  public static boolean aCL(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void aCM(int paramInt)
  {
    AppMethodBeat.i(157083);
    if (!"toolsmp".equals(aaaX))
    {
      AppMethodBeat.o(157083);
      return;
    }
    int j;
    int i;
    if (WebView.getCurWebType() == WebView.c.aabm)
    {
      j = 200;
      if (paramInt >= 0) {
        break label84;
      }
      i = 3;
    }
    for (;;)
    {
      u(903L, j + i, 1L);
      AppMethodBeat.o(157083);
      return;
      if (WebView.getCurWebType() == WebView.c.aabn)
      {
        j = 220;
        break;
      }
      AppMethodBeat.o(157083);
      return;
      label84:
      i = paramInt;
      if (paramInt > 9) {
        i = 4;
      }
    }
  }
  
  public static void bFF(String paramString)
  {
    if (paramString != null) {
      aaaX = paramString;
    }
  }
  
  public static void bFG(String paramString)
  {
    int j = 73;
    AppMethodBeat.i(157022);
    int i;
    if (aafT != null)
    {
      aafT.p(577L, 0L, 1L);
      if ((aaaX.equals("toolsmp")) && (paramString != null) && (bFH(paramString) == 2)) {
        aafT.p(903L, 101L, 1L);
      }
      if (!aaaX.equals("toolsmp")) {
        break label180;
      }
      if (WebView.getCurWebType() != WebView.c.aabm) {
        break label155;
      }
      aafT.p(903L, 105L, 1L);
      if (!aafR)
      {
        if (!aaaX.equals("tools")) {
          break label220;
        }
        i = 70;
      }
    }
    for (;;)
    {
      j = WebView.getCurWebType().ordinal() - 1;
      if ((i >= 70) && (j >= 0))
      {
        aafR = true;
        og(577, i + j);
      }
      AppMethodBeat.o(157022);
      return;
      label155:
      if (WebView.getCurWebType() != WebView.c.aabn) {
        break;
      }
      aafT.p(903L, 104L, 1L);
      break;
      label180:
      if ((!aaaX.equals("tools")) || (paramString == null) || (bFH(paramString) != 1)) {
        break;
      }
      aafT.p(903L, 103L, 1L);
      break;
      label220:
      i = j;
      if (!aaaX.equals("appbrand"))
      {
        i = j;
        if (!aaaX.equals("support")) {
          i = -1;
        }
      }
    }
  }
  
  public static int bFH(String paramString)
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
  
  public static void bFI(String paramString)
  {
    AppMethodBeat.i(196662);
    if (aafT == null)
    {
      AppMethodBeat.o(196662);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aafT.p(1068L, 57L, 1L);
      AppMethodBeat.o(196662);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aafT.p(1071L, 57L, 1L);
      AppMethodBeat.o(196662);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aafT.p(1069L, 57L, 1L);
      AppMethodBeat.o(196662);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aafT.p(1070L, 57L, 1L);
      AppMethodBeat.o(196662);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aafT.p(1544L, 57L, 1L);
    }
    AppMethodBeat.o(196662);
  }
  
  public static void bFJ(String paramString)
  {
    AppMethodBeat.i(157079);
    if (aafT == null)
    {
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aafT.p(1068L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aafT.p(1071L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aafT.p(1069L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aafT.p(1070L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aafT.p(1544L, 66L, 1L);
    }
    AppMethodBeat.o(157079);
  }
  
  public static void bFK(String paramString)
  {
    AppMethodBeat.i(157080);
    if ((paramString == null) || (paramString.isEmpty()) || (aafT == null))
    {
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      aafT.p(1068L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      aafT.p(1071L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      aafT.p(1069L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      aafT.p(1070L, 67L, 1L);
    }
    AppMethodBeat.o(157080);
  }
  
  public static void bFL(String paramString)
  {
    AppMethodBeat.i(157081);
    if ((paramString == null) || (paramString.isEmpty()) || (aafT == null))
    {
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      aafT.p(1068L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      aafT.p(1071L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      aafT.p(1069L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      aafT.p(1070L, 68L, 1L);
    }
    AppMethodBeat.o(157081);
  }
  
  public static void bb(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(196594);
    Log.i("WXWebReporter", "report idkey id = " + paramLong1 + " key = " + paramLong2 + " value = 1");
    if (aafT != null) {
      aafT.p(paramLong1, paramLong2, 1L);
    }
    AppMethodBeat.o(196594);
  }
  
  public static void ck(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157045);
    if (aafT != null)
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
        aafT.p(577L, paramInt, 1L);
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
  
  public static void cl(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157046);
    if (aafT != null)
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
        aafT.p(577L, paramInt, 1L);
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
  
  public static void d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(157034);
    ag localag;
    int j;
    int k;
    if (aafT != null)
    {
      ixH();
      aafT.p(577L, 5L, 1L);
      aafT.kvStat(15003, "");
      localag = aafT;
      j = XWalkEnvironment.getAvailableVersion();
      k = bFH(paramString);
      paramString = sessionId;
      if (JsRuntime.iwc() != null) {
        break label94;
      }
    }
    label94:
    for (int i = 100;; i = JsRuntime.iwc().ordinal())
    {
      localag.a(j, k, paramString, i, 1, paramInt1, (int)paramLong, paramInt2);
      AppMethodBeat.o(157034);
      return;
    }
  }
  
  public static void dA(int paramInt, String paramString)
  {
    AppMethodBeat.i(157019);
    if (aafT != null) {
      aafT.kvStat(paramInt, paramString);
    }
    AppMethodBeat.o(157019);
  }
  
  public static void dV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196649);
    if (aafT == null)
    {
      AppMethodBeat.o(196649);
      return;
    }
    if (paramBoolean) {}
    for (int i = 51; "FullScreenVideo".equals(paramString); i = 60)
    {
      aafT.p(577L, 185L, 1L);
      AppMethodBeat.o(196649);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aafT.p(1068L, i, 1L);
      AppMethodBeat.o(196649);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aafT.p(1071L, i, 1L);
      AppMethodBeat.o(196649);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aafT.p(1069L, i, 1L);
      AppMethodBeat.o(196649);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aafT.p(1070L, i, 1L);
      AppMethodBeat.o(196649);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aafT.p(1544L, i, 1L);
    }
    AppMethodBeat.o(196649);
  }
  
  public static void dW(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196655);
    if (aafT == null)
    {
      AppMethodBeat.o(196655);
      return;
    }
    if (paramBoolean) {}
    for (int i = 52; "FullScreenVideo".equals(paramString); i = 61)
    {
      aafT.p(577L, 186L, 1L);
      AppMethodBeat.o(196655);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aafT.p(1068L, i, 1L);
      AppMethodBeat.o(196655);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aafT.p(1071L, i, 1L);
      AppMethodBeat.o(196655);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aafT.p(1069L, i, 1L);
      AppMethodBeat.o(196655);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aafT.p(1070L, i, 1L);
      AppMethodBeat.o(196655);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aafT.p(1544L, i, 1L);
    }
    AppMethodBeat.o(196655);
  }
  
  public static void dX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196657);
    if (aafT == null)
    {
      AppMethodBeat.o(196657);
      return;
    }
    if (paramBoolean) {}
    for (int i = 54; "FullScreenVideo".equals(paramString); i = 62)
    {
      aafT.p(577L, 187L, 1L);
      AppMethodBeat.o(196657);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aafT.p(1068L, i, 1L);
      AppMethodBeat.o(196657);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aafT.p(1071L, i, 1L);
      AppMethodBeat.o(196657);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aafT.p(1069L, i, 1L);
      AppMethodBeat.o(196657);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aafT.p(1070L, i, 1L);
      AppMethodBeat.o(196657);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aafT.p(1544L, i, 1L);
    }
    AppMethodBeat.o(196657);
  }
  
  public static void dY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196659);
    if (aafT == null)
    {
      AppMethodBeat.o(196659);
      return;
    }
    if (paramBoolean) {}
    for (int i = 55; "FullScreenVideo".equals(paramString); i = 63)
    {
      aafT.p(577L, 188L, 1L);
      AppMethodBeat.o(196659);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      aafT.p(1068L, i, 1L);
      AppMethodBeat.o(196659);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aafT.p(1071L, i, 1L);
      AppMethodBeat.o(196659);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aafT.p(1069L, i, 1L);
      AppMethodBeat.o(196659);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aafT.p(1070L, i, 1L);
      AppMethodBeat.o(196659);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aafT.p(1544L, i, 1L);
    }
    AppMethodBeat.o(196659);
  }
  
  public static void dZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196664);
    if (aafT == null)
    {
      AppMethodBeat.o(196664);
      return;
    }
    if (paramBoolean) {}
    for (int i = 59; "XFilesPPTReader".equals(paramString); i = 65)
    {
      aafT.p(1068L, i, 1L);
      AppMethodBeat.o(196664);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      aafT.p(1071L, i, 1L);
      AppMethodBeat.o(196664);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      aafT.p(1069L, i, 1L);
      AppMethodBeat.o(196664);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      aafT.p(1070L, i, 1L);
      AppMethodBeat.o(196664);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      aafT.p(1544L, i, 1L);
    }
    AppMethodBeat.o(196664);
  }
  
  public static void ea(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(196672);
    int j = e.bFC(paramString).intValue();
    if (paramBoolean) {}
    for (int i = 0;; i = 100)
    {
      u(1511L, i + j % 100, 1L);
      AppMethodBeat.o(196672);
      return;
    }
  }
  
  public static boolean fpT()
  {
    return aafT != null;
  }
  
  public static void i(WebView.c paramc)
  {
    aafS = paramc;
  }
  
  private static boolean ixD()
  {
    AppMethodBeat.i(157015);
    if ((aafS == WebView.c.aabm) && (WebView.getCurWebType() != aafS))
    {
      AppMethodBeat.o(157015);
      return true;
    }
    AppMethodBeat.o(157015);
    return false;
  }
  
  private static boolean ixE()
  {
    AppMethodBeat.i(157016);
    if ((WebView.getCurWebType() == WebView.c.aabm) && (WebView.getCurWebType() != aafS))
    {
      AppMethodBeat.o(157016);
      return true;
    }
    AppMethodBeat.o(157016);
    return false;
  }
  
  public static void ixF()
  {
    AppMethodBeat.i(196576);
    String str2 = XWalkEnvironment.getRuntimeAbi();
    String str1;
    int i;
    int j;
    if ("armeabi-v7a".equals(str2))
    {
      str1 = "arm64-v8a";
      i = XWalkEnvironment.getInstalledNewstVersion(str2);
      j = XWalkEnvironment.getInstalledNewstVersion(str1);
      Log.i("WXWebReporter", "reportCoreInstalled cur abi ver = " + i + ", predown ver = " + j);
      boolean bool = c.pb("report_core_ver", String.valueOf(i));
      if ((c.bFw("report_core_daily")) || (bool))
      {
        if (i > 0) {
          break label187;
        }
        bb(1367L, 251L);
      }
      label105:
      bool = c.pb("report_core_ver_predown", String.valueOf(j));
      if ((c.bFw("report_core_daily_predown")) || (bool))
      {
        if (j > 0) {
          break label203;
        }
        bb(1367L, 252L);
      }
    }
    for (;;)
    {
      if ("armeabi-v7a".equalsIgnoreCase(str2))
      {
        str1 = XWalkEnvironment.getDeviceAbi();
        if ("armeabi-v7a".equalsIgnoreCase(str1))
        {
          og(1367, 253);
          AppMethodBeat.o(196576);
          return;
          str1 = "armeabi-v7a";
          break;
          label187:
          bb(1367L, i % 100 + 0);
          break label105;
          label203:
          bb(1367L, j % 100 + 100);
          continue;
        }
        if ("arm64-v8a".equalsIgnoreCase(str1)) {
          og(1367, 254);
        }
        AppMethodBeat.o(196576);
        return;
      }
    }
    if ("arm64-v8a".equalsIgnoreCase(str2)) {
      og(1367, 255);
    }
    AppMethodBeat.o(196576);
  }
  
  private static int ixG()
  {
    AppMethodBeat.i(157023);
    int i = -1;
    if (aaaX.equals("mm")) {
      i = 30;
    }
    for (;;)
    {
      AppMethodBeat.o(157023);
      return i;
      if (aaaX.equals("tools")) {
        i = 36;
      } else if (aaaX.equals("toolsmp")) {
        i = 42;
      } else if (aaaX.equals("appbrand")) {
        i = 48;
      } else if (aaaX.equals("support")) {
        i = 54;
      }
    }
  }
  
  public static void ixH()
  {
    AppMethodBeat.i(157025);
    if (aafT != null) {
      aafT.p(577L, 1L, 1L);
    }
    AppMethodBeat.o(157025);
  }
  
  public static void ixI()
  {
    AppMethodBeat.i(157027);
    if (aafT != null) {
      aafT.p(577L, 46L, 1L);
    }
    AppMethodBeat.o(157027);
  }
  
  public static void ixJ()
  {
    AppMethodBeat.i(157028);
    if (aafT != null) {
      aafT.p(577L, 47L, 1L);
    }
    AppMethodBeat.o(157028);
  }
  
  public static void ixK()
  {
    AppMethodBeat.i(157030);
    if (aafT != null) {
      aafT.p(577L, 42L, 1L);
    }
    AppMethodBeat.o(157030);
  }
  
  public static void ixL()
  {
    AppMethodBeat.i(157031);
    if (aafT != null) {
      aafT.p(577L, 43L, 1L);
    }
    AppMethodBeat.o(157031);
  }
  
  public static void ixM()
  {
    AppMethodBeat.i(157037);
    if (aafT != null) {
      aafT.p(577L, 52L, 1L);
    }
    AppMethodBeat.o(157037);
  }
  
  public static void ixN()
  {
    AppMethodBeat.i(157038);
    if (aafT != null) {
      aafT.p(577L, 53L, 1L);
    }
    AppMethodBeat.o(157038);
  }
  
  public static void ixO()
  {
    AppMethodBeat.i(157039);
    if (aafT != null) {
      aafT.p(577L, 54L, 1L);
    }
    AppMethodBeat.o(157039);
  }
  
  public static void ixP()
  {
    AppMethodBeat.i(157040);
    if (aafT != null) {
      aafT.p(577L, 55L, 1L);
    }
    AppMethodBeat.o(157040);
  }
  
  public static void ixQ()
  {
    AppMethodBeat.i(157041);
    if (aafT != null) {
      aafT.p(577L, 56L, 1L);
    }
    AppMethodBeat.o(157041);
  }
  
  public static void ixR()
  {
    AppMethodBeat.i(157042);
    if (aafT != null) {
      aafT.p(577L, 57L, 1L);
    }
    AppMethodBeat.o(157042);
  }
  
  public static void ixS()
  {
    AppMethodBeat.i(157043);
    if (aafT != null) {
      aafT.p(577L, 58L, 1L);
    }
    AppMethodBeat.o(157043);
  }
  
  public static void ixT()
  {
    AppMethodBeat.i(196622);
    if (aafT != null) {
      aafT.p(577L, 175L, 1L);
    }
    AppMethodBeat.o(196622);
  }
  
  public static void ixU()
  {
    AppMethodBeat.i(196624);
    if (aafT != null) {
      aafT.p(577L, 168L, 1L);
    }
    AppMethodBeat.o(196624);
  }
  
  public static void ixV()
  {
    AppMethodBeat.i(196625);
    if (aafT != null) {
      aafT.p(577L, 169L, 1L);
    }
    AppMethodBeat.o(196625);
  }
  
  public static void ixW()
  {
    AppMethodBeat.i(196626);
    if (aafT != null) {
      aafT.p(577L, 174L, 1L);
    }
    AppMethodBeat.o(196626);
  }
  
  public static void ixX()
  {
    AppMethodBeat.i(157044);
    if (aafT != null) {
      aafT.p(577L, 59L, 1L);
    }
    AppMethodBeat.o(157044);
  }
  
  public static void ixY()
  {
    AppMethodBeat.i(157047);
    if (aafT != null) {
      aafT.p(577L, 167L, 1L);
    }
    AppMethodBeat.o(157047);
  }
  
  public static void ixZ()
  {
    AppMethodBeat.i(157048);
    if (aafT != null) {
      aafT.p(577L, 9L, 1L);
    }
    AppMethodBeat.o(157048);
  }
  
  public static void iy(String paramString, int paramInt)
  {
    AppMethodBeat.i(157033);
    ag localag;
    int j;
    int k;
    if (aafT != null)
    {
      bFG(paramString);
      sessionId = UUID.randomUUID().toString().replace("-", "");
      aafT.p(577L, 4L, 1L);
      localag = aafT;
      j = XWalkEnvironment.getAvailableVersion();
      k = bFH(paramString);
      paramString = sessionId;
      if (JsRuntime.iwc() != null) {
        break label95;
      }
    }
    label95:
    for (int i = 100;; i = JsRuntime.iwc().ordinal())
    {
      localag.a(j, k, paramString, i, 0, 0, 0, paramInt);
      AppMethodBeat.o(157033);
      return;
    }
  }
  
  public static void iya()
  {
    AppMethodBeat.i(157050);
    if (aafT != null) {
      aafT.p(577L, 10L, 1L);
    }
    AppMethodBeat.o(157050);
  }
  
  public static void iyb()
  {
    AppMethodBeat.i(157051);
    if (aafT != null) {
      aafT.p(577L, 60L, 1L);
    }
    AppMethodBeat.o(157051);
  }
  
  public static void iyc()
  {
    AppMethodBeat.i(157053);
    if (aafT != null) {
      aafT.p(577L, 20L, 1L);
    }
    AppMethodBeat.o(157053);
  }
  
  public static void iyd()
  {
    AppMethodBeat.i(157055);
    if (aafT != null) {
      aafT.p(577L, 21L, 1L);
    }
    AppMethodBeat.o(157055);
  }
  
  public static void iye()
  {
    AppMethodBeat.i(157056);
    if (aafT != null) {
      aafT.p(577L, 25L, 1L);
    }
    AppMethodBeat.o(157056);
  }
  
  public static void iyf()
  {
    AppMethodBeat.i(157058);
    if (aafT != null) {
      aafT.p(577L, 26L, 1L);
    }
    AppMethodBeat.o(157058);
  }
  
  public static void iyg()
  {
    AppMethodBeat.i(157059);
    if (aafT != null) {
      aafT.p(577L, 14L, 1L);
    }
    AppMethodBeat.o(157059);
  }
  
  public static void iyh()
  {
    AppMethodBeat.i(157060);
    if (aafT != null) {
      aafT.p(577L, 15L, 1L);
    }
    AppMethodBeat.o(157060);
  }
  
  public static void iyi()
  {
    AppMethodBeat.i(157062);
    if (aafT == null)
    {
      AppMethodBeat.o(157062);
      return;
    }
    aafT.p(577L, 83L, 1L);
    AppMethodBeat.o(157062);
  }
  
  public static void iyj()
  {
    AppMethodBeat.i(157064);
    if (aafT == null)
    {
      AppMethodBeat.o(157064);
      return;
    }
    aafT.p(577L, 87L, 1L);
    AppMethodBeat.o(157064);
  }
  
  public static void iyk()
  {
    AppMethodBeat.i(157066);
    if (aafT != null) {
      aafT.p(577L, 180L, 1L);
    }
    AppMethodBeat.o(157066);
  }
  
  public static void iyl()
  {
    AppMethodBeat.i(157067);
    if (aafT != null) {
      aafT.p(577L, 181L, 1L);
    }
    AppMethodBeat.o(157067);
  }
  
  public static void iym()
  {
    AppMethodBeat.i(157068);
    if (aafT != null) {
      aafT.p(577L, 182L, 1L);
    }
    AppMethodBeat.o(157068);
  }
  
  public static void iyn()
  {
    AppMethodBeat.i(157069);
    if (aafT != null) {
      aafT.p(577L, 183L, 1L);
    }
    AppMethodBeat.o(157069);
  }
  
  public static void iyo()
  {
    AppMethodBeat.i(157070);
    if (aafT != null) {
      aafT.p(577L, 184L, 1L);
    }
    AppMethodBeat.o(157070);
  }
  
  public static void iyp()
  {
    AppMethodBeat.i(157071);
    if (aafT != null) {
      aafT.p(577L, 189L, 1L);
    }
    AppMethodBeat.o(157071);
  }
  
  public static void iyq()
  {
    AppMethodBeat.i(157072);
    if (aafT != null) {
      aafT.p(577L, 190L, 1L);
    }
    AppMethodBeat.o(157072);
  }
  
  public static void iyr()
  {
    AppMethodBeat.i(157082);
    if (aafT == null)
    {
      AppMethodBeat.o(157082);
      return;
    }
    aafT.p(577L, 88L, 1L);
    AppMethodBeat.o(157082);
  }
  
  public static void iys()
  {
    AppMethodBeat.i(157085);
    u(938L, 89L, 1L);
    AppMethodBeat.o(157085);
  }
  
  public static void iyt()
  {
    AppMethodBeat.i(157086);
    u(938L, 90L, 1L);
    AppMethodBeat.o(157086);
  }
  
  public static void iyu()
  {
    AppMethodBeat.i(157087);
    u(938L, 91L, 1L);
    AppMethodBeat.o(157087);
  }
  
  public static void j(WebView.c paramc)
  {
    AppMethodBeat.i(157018);
    if (aafT == null)
    {
      AppMethodBeat.o(157018);
      return;
    }
    int i;
    String str1;
    label36:
    String str3;
    String str2;
    if (paramc == WebView.c.aabm)
    {
      i = 1;
      if (i == 0) {
        break label120;
      }
      str1 = "REPORT_APK_VER_TIME";
      str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
      str2 = XWalkEnvironment.getSharedPreferences().getString(str1, "");
      if (str2 != null) {
        break label304;
      }
      str2 = "";
    }
    label304:
    for (;;)
    {
      if (paramc == WebView.c.aabm)
      {
        i = XWalkEnvironment.getSharedPreferences().getInt("REPORT_XWEB_APK_VER", 0);
        int j = XWalkEnvironment.getAvailableVersion();
        if (j <= 0)
        {
          AppMethodBeat.o(157018);
          return;
          i = 0;
          break;
          label120:
          str1 = "REPORT_APK_VER_TIME_".concat(String.valueOf(paramc));
          break label36;
        }
        if ((j != i) || (!str3.equals(str2)))
        {
          aafT.p(577L, j % 50 + 100, 1L);
          XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
        }
      }
      if (str3.equals(str2))
      {
        AppMethodBeat.o(157018);
        return;
      }
      if (paramc == WebView.c.aabm)
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
        aafT.p(577L, i, 1L);
        XWalkEnvironment.getSharedPreferences().edit().putString(str1, str3).commit();
        AppMethodBeat.o(157018);
        return;
        if (paramc == WebView.c.aabo)
        {
          i = 97;
        }
        else
        {
          if (paramc != WebView.c.aabn) {
            break;
          }
          i = 98;
        }
      }
      AppMethodBeat.o(157018);
      return;
    }
  }
  
  public static void k(WebView.c paramc)
  {
    AppMethodBeat.i(157052);
    if (aafT == null)
    {
      AppMethodBeat.o(157052);
      return;
    }
    if (paramc == WebView.c.aabm)
    {
      aafT.p(577L, 61L, 1L);
      og(577, 62);
    }
    AppMethodBeat.o(157052);
  }
  
  public static void l(WebView.c paramc)
  {
    AppMethodBeat.i(157063);
    if (aafT == null)
    {
      AppMethodBeat.o(157063);
      return;
    }
    int i;
    switch (1.qYM[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157063);
      return;
    case 1: 
      i = 82;
    }
    for (;;)
    {
      aafT.p(577L, i, 1L);
      AppMethodBeat.o(157063);
      return;
      i = 81;
      continue;
      i = 80;
    }
  }
  
  public static void m(WebView.c paramc)
  {
    AppMethodBeat.i(157065);
    if (aafT == null)
    {
      AppMethodBeat.o(157065);
      return;
    }
    int i;
    switch (1.qYM[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157065);
      return;
    case 1: 
      i = 86;
    }
    for (;;)
    {
      aafT.p(577L, i, 1L);
      AppMethodBeat.o(157065);
      return;
      i = 85;
      continue;
      i = 84;
    }
  }
  
  public static void og(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157017);
    if (aafT == null)
    {
      AppMethodBeat.o(157017);
      return;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedTransportOld("REPORT_DAILY");
    String str1 = "id_" + paramInt1 + "_key_" + paramInt2;
    String str2 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    if (str2.equals(localSharedPreferences.getString(str1, "")))
    {
      AppMethodBeat.o(157017);
      return;
    }
    aafT.p(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString(str1, str2).commit();
    AppMethodBeat.o(157017);
  }
  
  public static void u(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(157021);
    if (aafT != null) {
      aafT.p(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(157021);
  }
  
  public static void v(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(157035);
    Xh(paramLong);
    ag localag;
    int j;
    int k;
    if ((aafT != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      aafT.bh(6, 7, (int)paramLong);
      localag = aafT;
      j = XWalkEnvironment.getAvailableVersion();
      k = bFH(paramString);
      paramString = sessionId;
      if (JsRuntime.iwc() != null) {
        break label96;
      }
    }
    label96:
    for (int i = 100;; i = JsRuntime.iwc().ordinal())
    {
      localag.a(j, k, paramString, i, 1, 0, (int)paramLong, paramInt);
      AppMethodBeat.o(157035);
      return;
    }
  }
  
  public static final class a
  {
    int aafV;
    StringBuilder bmW;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(175648);
      this.bmW = new StringBuilder();
      this.aafV = 0;
      this.aafV = paramInt;
      AppMethodBeat.o(175648);
    }
    
    public final a eR(Object paramObject)
    {
      AppMethodBeat.i(175649);
      if (this.bmW.length() > 0) {
        this.bmW.append(",");
      }
      this.bmW.append(paramObject.toString());
      AppMethodBeat.o(175649);
      return this;
    }
  }
  
  public static final class b$a
  {
    public static int aafW = 1;
    public static int aafX = 2;
    public static int aafY = 1;
    public static int aafZ = 2;
    public static int ffF = 19307;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.h
 * JD-Core Version:    0.7.0.1
 */