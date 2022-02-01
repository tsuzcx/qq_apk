package com.tencent.xweb.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.af;
import com.tencent.xweb.internal.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class h
{
  public static String SAg = "";
  private static boolean SEH = false;
  static WebView.c SEI = WebView.c.SAs;
  static af SEJ = null;
  static boolean SEK = false;
  public static String sessionId = "";
  
  public static void Eq(boolean paramBoolean)
  {
    AppMethodBeat.i(157084);
    if (!"toolsmp".equals(SAg))
    {
      AppMethodBeat.o(157084);
      return;
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (WebView.getCurWebType() != WebView.c.SAt) {
        break label63;
      }
    }
    for (int j = 180;; j = 190)
    {
      s(903L, i + j, 1L);
      AppMethodBeat.o(157084);
      return;
      i = 1;
      break;
      label63:
      if (WebView.getCurWebType() != WebView.c.SAu) {
        break label79;
      }
    }
    label79:
    AppMethodBeat.o(157084);
  }
  
  public static void OQ(long paramLong)
  {
    AppMethodBeat.i(157020);
    if (SEJ != null) {
      SEJ.n(577L, paramLong, 1L);
    }
    AppMethodBeat.o(157020);
  }
  
  public static void OR(long paramLong)
  {
    AppMethodBeat.i(157026);
    if ((SEJ != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      SEJ.bc(2, 3, (int)paramLong);
    }
    AppMethodBeat.o(157026);
  }
  
  public static void OS(long paramLong)
  {
    AppMethodBeat.i(157029);
    if ((SEJ != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      SEJ.bc(48, 49, (int)paramLong);
    }
    AppMethodBeat.o(157029);
  }
  
  public static void OT(long paramLong)
  {
    AppMethodBeat.i(157032);
    if ((SEJ != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      SEJ.bc(44, 45, (int)paramLong);
    }
    AppMethodBeat.o(157032);
  }
  
  public static void OU(long paramLong)
  {
    AppMethodBeat.i(157049);
    if ((SEJ != null) && (SEJ != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      SEJ.bc(11, 12, (int)paramLong);
    }
    AppMethodBeat.o(157049);
  }
  
  public static void OV(long paramLong)
  {
    AppMethodBeat.i(157054);
    if ((SEJ != null) && (SEJ != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      SEJ.bc(22, 23, (int)paramLong);
    }
    AppMethodBeat.o(157054);
  }
  
  public static void OW(long paramLong)
  {
    AppMethodBeat.i(157057);
    if ((SEJ != null) && (SEJ != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      SEJ.bc(27, 28, (int)paramLong);
    }
    AppMethodBeat.o(157057);
  }
  
  public static void OX(long paramLong)
  {
    AppMethodBeat.i(157061);
    if ((SEJ != null) && (SEJ != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      SEJ.bc(16, 17, (int)paramLong);
    }
    AppMethodBeat.o(157061);
  }
  
  public static void a(WebView.c paramc, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175651);
    a locala;
    if (c.bsx("kv_" + h.b.a.ID + paramc.toString() + "_" + paramInt))
    {
      locala = new a(h.b.a.ID);
      locala.eL(Integer.valueOf(paramInt));
      if (paramc != WebView.c.SAt) {
        break label149;
      }
      locala.eL(Integer.valueOf(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
      locala.eL(Integer.valueOf(201201));
      if (!"armeabi-v7a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        break label222;
      }
      locala.eL(Integer.valueOf(h.b.a.SEO));
    }
    for (;;)
    {
      for (;;)
      {
        locala.eL(Integer.valueOf(paramc.ordinal()));
        dz(locala.SEL, locala.bDv.toString());
        AppMethodBeat.o(175651);
        return;
        label149:
        if (paramc == WebView.c.SAu) {
          try
          {
            paramInt = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
            locala.eL(Integer.valueOf(paramInt));
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
      if (paramc == WebView.c.SAv)
      {
        locala.eL(Integer.valueOf(XWalkEnvironment.safeGetChromiunVersion()));
        break;
      }
      locala.eL(Integer.valueOf(0));
      break;
      label222:
      if ("arm64-v8a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        locala.eL(Integer.valueOf(h.b.a.SEP));
      }
    }
  }
  
  public static void a(af paramaf)
  {
    SEJ = paramaf;
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
        if (SEJ == null)
        {
          AppMethodBeat.o(175650);
          return;
        }
        if (!SEK)
        {
          if ("toolsmp".equals(SAg))
          {
            if (!htU()) {
              break label255;
            }
            mO(903, 106);
          }
          i = htX();
          j = WebView.getCurWebType().ordinal() - 1;
          if ((i >= 30) && (j >= 0))
          {
            SEK = true;
            mO(903, i + 3 + j);
          }
        }
        if (paramWebView.isX5WrappedSysKernel())
        {
          if (!SAg.equals("mm")) {
            break label272;
          }
          i = 79;
          j = 74;
          if (j != 0) {
            SEJ.n(903L, j, 1L);
          }
          if (i != 0) {
            mO(903, i);
          }
        }
        if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
          SEJ.n(903L, 102L, 1L);
        }
        i = htX();
        j = WebView.getCurWebType().ordinal() - 1;
        if ((i >= 30) && (j >= 0)) {
          SEJ.n(903L, i + 0 + j, 1L);
        }
        if (!"toolsmp".equals(SAg)) {
          break label374;
        }
        if (!htU()) {
          break label355;
        }
        SEJ.n(903L, 107L, 1L);
        AppMethodBeat.o(175650);
        continue;
        if (!htV()) {
          continue;
        }
      }
      finally {}
      label255:
      mO(903, 108);
      continue;
      label272:
      if (SAg.equals("tools"))
      {
        i = 75;
        j = 70;
      }
      else if (SAg.equals("toolsmp"))
      {
        i = 75;
        j = 71;
      }
      else if (SAg.equals("appbrand"))
      {
        i = 77;
        j = 72;
      }
      else if (SAg.equals("support"))
      {
        i = 78;
        j = 73;
        continue;
        label355:
        if (htV()) {
          SEJ.n(903L, 109L, 1L);
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
  
  public static void aJ(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(219088);
    Log.i("WXWebReporter", "report idkey id = " + paramLong1 + " key = " + paramLong2 + " value = 1");
    if (SEJ != null) {
      SEJ.n(paramLong1, paramLong2, 1L);
    }
    AppMethodBeat.o(219088);
  }
  
  public static boolean asU(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void asV(int paramInt)
  {
    AppMethodBeat.i(157083);
    if (!"toolsmp".equals(SAg))
    {
      AppMethodBeat.o(157083);
      return;
    }
    int j;
    int i;
    if (WebView.getCurWebType() == WebView.c.SAt)
    {
      j = 200;
      if (paramInt >= 0) {
        break label84;
      }
      i = 3;
    }
    for (;;)
    {
      s(903L, j + i, 1L);
      AppMethodBeat.o(157083);
      return;
      if (WebView.getCurWebType() == WebView.c.SAu)
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
  
  public static void bY(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157045);
    if (SEJ != null)
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
        SEJ.n(577L, paramInt, 1L);
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
  
  public static void bZ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157046);
    if (SEJ != null)
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
        SEJ.n(577L, paramInt, 1L);
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
  
  public static void bsG(String paramString)
  {
    if (paramString != null) {
      SAg = paramString;
    }
  }
  
  public static void bsH(String paramString)
  {
    int j = 73;
    AppMethodBeat.i(157022);
    int i;
    if (SEJ != null)
    {
      SEJ.n(577L, 0L, 1L);
      if ((SAg.equals("toolsmp")) && (paramString != null) && (bsI(paramString) == 2)) {
        SEJ.n(903L, 101L, 1L);
      }
      if (!SAg.equals("toolsmp")) {
        break label180;
      }
      if (WebView.getCurWebType() != WebView.c.SAt) {
        break label155;
      }
      SEJ.n(903L, 105L, 1L);
      if (!SEH)
      {
        if (!SAg.equals("tools")) {
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
        SEH = true;
        mO(577, i + j);
      }
      AppMethodBeat.o(157022);
      return;
      label155:
      if (WebView.getCurWebType() != WebView.c.SAu) {
        break;
      }
      SEJ.n(903L, 104L, 1L);
      break;
      label180:
      if ((!SAg.equals("tools")) || (paramString == null) || (bsI(paramString) != 1)) {
        break;
      }
      SEJ.n(903L, 103L, 1L);
      break;
      label220:
      i = j;
      if (!SAg.equals("appbrand"))
      {
        i = j;
        if (!SAg.equals("support")) {
          i = -1;
        }
      }
    }
  }
  
  public static int bsI(String paramString)
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
  
  public static void bsJ(String paramString)
  {
    AppMethodBeat.i(219093);
    if (SEJ == null)
    {
      AppMethodBeat.o(219093);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      SEJ.n(1068L, 57L, 1L);
      AppMethodBeat.o(219093);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      SEJ.n(1071L, 57L, 1L);
      AppMethodBeat.o(219093);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      SEJ.n(1069L, 57L, 1L);
      AppMethodBeat.o(219093);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      SEJ.n(1070L, 57L, 1L);
      AppMethodBeat.o(219093);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      SEJ.n(1544L, 57L, 1L);
    }
    AppMethodBeat.o(219093);
  }
  
  public static void bsK(String paramString)
  {
    AppMethodBeat.i(157079);
    if (SEJ == null)
    {
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      SEJ.n(1068L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      SEJ.n(1071L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      SEJ.n(1069L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      SEJ.n(1070L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      SEJ.n(1544L, 66L, 1L);
    }
    AppMethodBeat.o(157079);
  }
  
  public static void bsL(String paramString)
  {
    AppMethodBeat.i(157080);
    if ((paramString == null) || (paramString.isEmpty()) || (SEJ == null))
    {
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      SEJ.n(1068L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      SEJ.n(1071L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      SEJ.n(1069L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      SEJ.n(1070L, 67L, 1L);
    }
    AppMethodBeat.o(157080);
  }
  
  public static void bsM(String paramString)
  {
    AppMethodBeat.i(157081);
    if ((paramString == null) || (paramString.isEmpty()) || (SEJ == null))
    {
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      SEJ.n(1068L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      SEJ.n(1071L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      SEJ.n(1069L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      SEJ.n(1070L, 68L, 1L);
    }
    AppMethodBeat.o(157081);
  }
  
  public static void d(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(157034);
    af localaf;
    int j;
    int k;
    if (SEJ != null)
    {
      htY();
      SEJ.n(577L, 5L, 1L);
      SEJ.kvStat(15003, "");
      localaf = SEJ;
      j = XWalkEnvironment.getAvailableVersion();
      k = bsI(paramString);
      paramString = sessionId;
      if (JsRuntime.hsu() != null) {
        break label94;
      }
    }
    label94:
    for (int i = 100;; i = JsRuntime.hsu().ordinal())
    {
      localaf.a(j, k, paramString, i, 1, paramInt1, (int)paramLong, paramInt2);
      AppMethodBeat.o(157034);
      return;
    }
  }
  
  public static void dJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219089);
    if (SEJ == null)
    {
      AppMethodBeat.o(219089);
      return;
    }
    if (paramBoolean) {}
    for (int i = 51; "FullScreenVideo".equals(paramString); i = 60)
    {
      SEJ.n(577L, 185L, 1L);
      AppMethodBeat.o(219089);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      SEJ.n(1068L, i, 1L);
      AppMethodBeat.o(219089);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      SEJ.n(1071L, i, 1L);
      AppMethodBeat.o(219089);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      SEJ.n(1069L, i, 1L);
      AppMethodBeat.o(219089);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      SEJ.n(1070L, i, 1L);
      AppMethodBeat.o(219089);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      SEJ.n(1544L, i, 1L);
    }
    AppMethodBeat.o(219089);
  }
  
  public static void dK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219090);
    if (SEJ == null)
    {
      AppMethodBeat.o(219090);
      return;
    }
    if (paramBoolean) {}
    for (int i = 52; "FullScreenVideo".equals(paramString); i = 61)
    {
      SEJ.n(577L, 186L, 1L);
      AppMethodBeat.o(219090);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      SEJ.n(1068L, i, 1L);
      AppMethodBeat.o(219090);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      SEJ.n(1071L, i, 1L);
      AppMethodBeat.o(219090);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      SEJ.n(1069L, i, 1L);
      AppMethodBeat.o(219090);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      SEJ.n(1070L, i, 1L);
      AppMethodBeat.o(219090);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      SEJ.n(1544L, i, 1L);
    }
    AppMethodBeat.o(219090);
  }
  
  public static void dL(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219091);
    if (SEJ == null)
    {
      AppMethodBeat.o(219091);
      return;
    }
    if (paramBoolean) {}
    for (int i = 54; "FullScreenVideo".equals(paramString); i = 62)
    {
      SEJ.n(577L, 187L, 1L);
      AppMethodBeat.o(219091);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      SEJ.n(1068L, i, 1L);
      AppMethodBeat.o(219091);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      SEJ.n(1071L, i, 1L);
      AppMethodBeat.o(219091);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      SEJ.n(1069L, i, 1L);
      AppMethodBeat.o(219091);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      SEJ.n(1070L, i, 1L);
      AppMethodBeat.o(219091);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      SEJ.n(1544L, i, 1L);
    }
    AppMethodBeat.o(219091);
  }
  
  public static void dM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219092);
    if (SEJ == null)
    {
      AppMethodBeat.o(219092);
      return;
    }
    if (paramBoolean) {}
    for (int i = 55; "FullScreenVideo".equals(paramString); i = 63)
    {
      SEJ.n(577L, 188L, 1L);
      AppMethodBeat.o(219092);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      SEJ.n(1068L, i, 1L);
      AppMethodBeat.o(219092);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      SEJ.n(1071L, i, 1L);
      AppMethodBeat.o(219092);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      SEJ.n(1069L, i, 1L);
      AppMethodBeat.o(219092);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      SEJ.n(1070L, i, 1L);
      AppMethodBeat.o(219092);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      SEJ.n(1544L, i, 1L);
    }
    AppMethodBeat.o(219092);
  }
  
  public static void dN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219094);
    if (SEJ == null)
    {
      AppMethodBeat.o(219094);
      return;
    }
    if (paramBoolean) {}
    for (int i = 59; "XFilesPPTReader".equals(paramString); i = 65)
    {
      SEJ.n(1068L, i, 1L);
      AppMethodBeat.o(219094);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      SEJ.n(1071L, i, 1L);
      AppMethodBeat.o(219094);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      SEJ.n(1069L, i, 1L);
      AppMethodBeat.o(219094);
      return;
    }
    if ("XFilesExcelReader".equals(paramString))
    {
      SEJ.n(1070L, i, 1L);
      AppMethodBeat.o(219094);
      return;
    }
    if ("XFilesOfficeReader".equals(paramString)) {
      SEJ.n(1544L, i, 1L);
    }
    AppMethodBeat.o(219094);
  }
  
  public static void dO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(219095);
    int j = e.bsD(paramString).intValue();
    if (paramBoolean) {}
    for (int i = 0;; i = 100)
    {
      s(1511L, i + j % 100, 1L);
      AppMethodBeat.o(219095);
      return;
    }
  }
  
  public static void dz(int paramInt, String paramString)
  {
    AppMethodBeat.i(157019);
    if (SEJ != null) {
      SEJ.kvStat(paramInt, paramString);
    }
    AppMethodBeat.o(157019);
  }
  
  public static boolean eEa()
  {
    return SEJ != null;
  }
  
  public static void h(WebView.c paramc)
  {
    SEI = paramc;
  }
  
  public static void hP(String paramString, int paramInt)
  {
    AppMethodBeat.i(157033);
    af localaf;
    int j;
    int k;
    if (SEJ != null)
    {
      bsH(paramString);
      sessionId = UUID.randomUUID().toString().replace("-", "");
      SEJ.n(577L, 4L, 1L);
      localaf = SEJ;
      j = XWalkEnvironment.getAvailableVersion();
      k = bsI(paramString);
      paramString = sessionId;
      if (JsRuntime.hsu() != null) {
        break label95;
      }
    }
    label95:
    for (int i = 100;; i = JsRuntime.hsu().ordinal())
    {
      localaf.a(j, k, paramString, i, 0, 0, 0, paramInt);
      AppMethodBeat.o(157033);
      return;
    }
  }
  
  private static boolean htU()
  {
    AppMethodBeat.i(157015);
    if ((SEI == WebView.c.SAt) && (WebView.getCurWebType() != SEI))
    {
      AppMethodBeat.o(157015);
      return true;
    }
    AppMethodBeat.o(157015);
    return false;
  }
  
  private static boolean htV()
  {
    AppMethodBeat.i(157016);
    if ((WebView.getCurWebType() == WebView.c.SAt) && (WebView.getCurWebType() != SEI))
    {
      AppMethodBeat.o(157016);
      return true;
    }
    AppMethodBeat.o(157016);
    return false;
  }
  
  public static void htW()
  {
    AppMethodBeat.i(219087);
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
      boolean bool = c.of("report_core_ver", String.valueOf(i));
      if ((c.bsx("report_core_daily")) || (bool))
      {
        if (i > 0) {
          break label187;
        }
        aJ(1367L, 251L);
      }
      label105:
      bool = c.of("report_core_ver_predown", String.valueOf(j));
      if ((c.bsx("report_core_daily_predown")) || (bool))
      {
        if (j > 0) {
          break label203;
        }
        aJ(1367L, 252L);
      }
    }
    for (;;)
    {
      if ("armeabi-v7a".equalsIgnoreCase(str2))
      {
        str1 = XWalkEnvironment.getDeviceAbi();
        if ("armeabi-v7a".equalsIgnoreCase(str1))
        {
          mO(1367, 253);
          AppMethodBeat.o(219087);
          return;
          str1 = "armeabi-v7a";
          break;
          label187:
          aJ(1367L, i % 100 + 0);
          break label105;
          label203:
          aJ(1367L, j % 100 + 100);
          continue;
        }
        if ("arm64-v8a".equalsIgnoreCase(str1)) {
          mO(1367, 254);
        }
      }
    }
    AppMethodBeat.o(219087);
  }
  
  private static int htX()
  {
    AppMethodBeat.i(157023);
    int i = -1;
    if (SAg.equals("mm")) {
      i = 30;
    }
    for (;;)
    {
      AppMethodBeat.o(157023);
      return i;
      if (SAg.equals("tools")) {
        i = 36;
      } else if (SAg.equals("toolsmp")) {
        i = 42;
      } else if (SAg.equals("appbrand")) {
        i = 48;
      } else if (SAg.equals("support")) {
        i = 54;
      }
    }
  }
  
  public static void htY()
  {
    AppMethodBeat.i(157025);
    if (SEJ != null) {
      SEJ.n(577L, 1L, 1L);
    }
    AppMethodBeat.o(157025);
  }
  
  public static void htZ()
  {
    AppMethodBeat.i(157027);
    if (SEJ != null) {
      SEJ.n(577L, 46L, 1L);
    }
    AppMethodBeat.o(157027);
  }
  
  public static void huA()
  {
    AppMethodBeat.i(157069);
    if (SEJ != null) {
      SEJ.n(577L, 183L, 1L);
    }
    AppMethodBeat.o(157069);
  }
  
  public static void huB()
  {
    AppMethodBeat.i(157070);
    if (SEJ != null) {
      SEJ.n(577L, 184L, 1L);
    }
    AppMethodBeat.o(157070);
  }
  
  public static void huC()
  {
    AppMethodBeat.i(157071);
    if (SEJ != null) {
      SEJ.n(577L, 189L, 1L);
    }
    AppMethodBeat.o(157071);
  }
  
  public static void huD()
  {
    AppMethodBeat.i(157072);
    if (SEJ != null) {
      SEJ.n(577L, 190L, 1L);
    }
    AppMethodBeat.o(157072);
  }
  
  public static void huE()
  {
    AppMethodBeat.i(157082);
    if (SEJ == null)
    {
      AppMethodBeat.o(157082);
      return;
    }
    SEJ.n(577L, 88L, 1L);
    AppMethodBeat.o(157082);
  }
  
  public static void huF()
  {
    AppMethodBeat.i(157085);
    s(938L, 89L, 1L);
    AppMethodBeat.o(157085);
  }
  
  public static void huG()
  {
    AppMethodBeat.i(157086);
    s(938L, 90L, 1L);
    AppMethodBeat.o(157086);
  }
  
  public static void huH()
  {
    AppMethodBeat.i(157087);
    s(938L, 91L, 1L);
    AppMethodBeat.o(157087);
  }
  
  public static void hua()
  {
    AppMethodBeat.i(157028);
    if (SEJ != null) {
      SEJ.n(577L, 47L, 1L);
    }
    AppMethodBeat.o(157028);
  }
  
  public static void hub()
  {
    AppMethodBeat.i(157030);
    if (SEJ != null) {
      SEJ.n(577L, 42L, 1L);
    }
    AppMethodBeat.o(157030);
  }
  
  public static void huc()
  {
    AppMethodBeat.i(157031);
    if (SEJ != null) {
      SEJ.n(577L, 43L, 1L);
    }
    AppMethodBeat.o(157031);
  }
  
  public static void hud()
  {
    AppMethodBeat.i(157037);
    if (SEJ != null) {
      SEJ.n(577L, 52L, 1L);
    }
    AppMethodBeat.o(157037);
  }
  
  public static void hue()
  {
    AppMethodBeat.i(157038);
    if (SEJ != null) {
      SEJ.n(577L, 53L, 1L);
    }
    AppMethodBeat.o(157038);
  }
  
  public static void huf()
  {
    AppMethodBeat.i(157039);
    if (SEJ != null) {
      SEJ.n(577L, 54L, 1L);
    }
    AppMethodBeat.o(157039);
  }
  
  public static void hug()
  {
    AppMethodBeat.i(157040);
    if (SEJ != null) {
      SEJ.n(577L, 55L, 1L);
    }
    AppMethodBeat.o(157040);
  }
  
  public static void huh()
  {
    AppMethodBeat.i(157041);
    if (SEJ != null) {
      SEJ.n(577L, 56L, 1L);
    }
    AppMethodBeat.o(157041);
  }
  
  public static void hui()
  {
    AppMethodBeat.i(157042);
    if (SEJ != null) {
      SEJ.n(577L, 57L, 1L);
    }
    AppMethodBeat.o(157042);
  }
  
  public static void huj()
  {
    AppMethodBeat.i(157043);
    if (SEJ != null) {
      SEJ.n(577L, 58L, 1L);
    }
    AppMethodBeat.o(157043);
  }
  
  public static void huk()
  {
    AppMethodBeat.i(157044);
    if (SEJ != null) {
      SEJ.n(577L, 59L, 1L);
    }
    AppMethodBeat.o(157044);
  }
  
  public static void hul()
  {
    AppMethodBeat.i(157047);
    if (SEJ != null) {
      SEJ.n(577L, 167L, 1L);
    }
    AppMethodBeat.o(157047);
  }
  
  public static void hum()
  {
    AppMethodBeat.i(157048);
    if (SEJ != null) {
      SEJ.n(577L, 9L, 1L);
    }
    AppMethodBeat.o(157048);
  }
  
  public static void hun()
  {
    AppMethodBeat.i(157050);
    if (SEJ != null) {
      SEJ.n(577L, 10L, 1L);
    }
    AppMethodBeat.o(157050);
  }
  
  public static void huo()
  {
    AppMethodBeat.i(157051);
    if (SEJ != null) {
      SEJ.n(577L, 60L, 1L);
    }
    AppMethodBeat.o(157051);
  }
  
  public static void hup()
  {
    AppMethodBeat.i(157053);
    if (SEJ != null) {
      SEJ.n(577L, 20L, 1L);
    }
    AppMethodBeat.o(157053);
  }
  
  public static void huq()
  {
    AppMethodBeat.i(157055);
    if (SEJ != null) {
      SEJ.n(577L, 21L, 1L);
    }
    AppMethodBeat.o(157055);
  }
  
  public static void hur()
  {
    AppMethodBeat.i(157056);
    if (SEJ != null) {
      SEJ.n(577L, 25L, 1L);
    }
    AppMethodBeat.o(157056);
  }
  
  public static void hus()
  {
    AppMethodBeat.i(157058);
    if (SEJ != null) {
      SEJ.n(577L, 26L, 1L);
    }
    AppMethodBeat.o(157058);
  }
  
  public static void hut()
  {
    AppMethodBeat.i(157059);
    if (SEJ != null) {
      SEJ.n(577L, 14L, 1L);
    }
    AppMethodBeat.o(157059);
  }
  
  public static void huu()
  {
    AppMethodBeat.i(157060);
    if (SEJ != null) {
      SEJ.n(577L, 15L, 1L);
    }
    AppMethodBeat.o(157060);
  }
  
  public static void huv()
  {
    AppMethodBeat.i(157062);
    if (SEJ == null)
    {
      AppMethodBeat.o(157062);
      return;
    }
    SEJ.n(577L, 83L, 1L);
    AppMethodBeat.o(157062);
  }
  
  public static void huw()
  {
    AppMethodBeat.i(157064);
    if (SEJ == null)
    {
      AppMethodBeat.o(157064);
      return;
    }
    SEJ.n(577L, 87L, 1L);
    AppMethodBeat.o(157064);
  }
  
  public static void hux()
  {
    AppMethodBeat.i(157066);
    if (SEJ != null) {
      SEJ.n(577L, 180L, 1L);
    }
    AppMethodBeat.o(157066);
  }
  
  public static void huy()
  {
    AppMethodBeat.i(157067);
    if (SEJ != null) {
      SEJ.n(577L, 181L, 1L);
    }
    AppMethodBeat.o(157067);
  }
  
  public static void huz()
  {
    AppMethodBeat.i(157068);
    if (SEJ != null) {
      SEJ.n(577L, 182L, 1L);
    }
    AppMethodBeat.o(157068);
  }
  
  public static void i(WebView.c paramc)
  {
    AppMethodBeat.i(157018);
    if (SEJ == null)
    {
      AppMethodBeat.o(157018);
      return;
    }
    int i;
    String str1;
    label36:
    String str3;
    String str2;
    if (paramc == WebView.c.SAt)
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
      if (paramc == WebView.c.SAt)
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
          SEJ.n(577L, j % 50 + 100, 1L);
          XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
        }
      }
      if (str3.equals(str2))
      {
        AppMethodBeat.o(157018);
        return;
      }
      if (paramc == WebView.c.SAt)
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
        SEJ.n(577L, i, 1L);
        XWalkEnvironment.getSharedPreferences().edit().putString(str1, str3).commit();
        AppMethodBeat.o(157018);
        return;
        if (paramc == WebView.c.SAv)
        {
          i = 97;
        }
        else
        {
          if (paramc != WebView.c.SAu) {
            break;
          }
          i = 98;
        }
      }
      AppMethodBeat.o(157018);
      return;
    }
  }
  
  public static void j(WebView.c paramc)
  {
    AppMethodBeat.i(157052);
    if (SEJ == null)
    {
      AppMethodBeat.o(157052);
      return;
    }
    if (paramc == WebView.c.SAt)
    {
      SEJ.n(577L, 61L, 1L);
      mO(577, 62);
    }
    AppMethodBeat.o(157052);
  }
  
  public static void k(WebView.c paramc)
  {
    AppMethodBeat.i(157063);
    if (SEJ == null)
    {
      AppMethodBeat.o(157063);
      return;
    }
    int i;
    switch (1.nXl[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157063);
      return;
    case 1: 
      i = 82;
    }
    for (;;)
    {
      SEJ.n(577L, i, 1L);
      AppMethodBeat.o(157063);
      return;
      i = 81;
      continue;
      i = 80;
    }
  }
  
  public static void l(WebView.c paramc)
  {
    AppMethodBeat.i(157065);
    if (SEJ == null)
    {
      AppMethodBeat.o(157065);
      return;
    }
    int i;
    switch (1.nXl[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157065);
      return;
    case 1: 
      i = 86;
    }
    for (;;)
    {
      SEJ.n(577L, i, 1L);
      AppMethodBeat.o(157065);
      return;
      i = 85;
      continue;
      i = 84;
    }
  }
  
  public static void mO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157017);
    if (SEJ == null)
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
    SEJ.n(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString(str1, str2).commit();
    AppMethodBeat.o(157017);
  }
  
  public static void s(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(157021);
    if (SEJ != null) {
      SEJ.n(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(157021);
  }
  
  public static void u(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(157035);
    OR(paramLong);
    af localaf;
    int j;
    int k;
    if ((SEJ != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      SEJ.bc(6, 7, (int)paramLong);
      localaf = SEJ;
      j = XWalkEnvironment.getAvailableVersion();
      k = bsI(paramString);
      paramString = sessionId;
      if (JsRuntime.hsu() != null) {
        break label96;
      }
    }
    label96:
    for (int i = 100;; i = JsRuntime.hsu().ordinal())
    {
      localaf.a(j, k, paramString, i, 1, 0, (int)paramLong, paramInt);
      AppMethodBeat.o(157035);
      return;
    }
  }
  
  public static final class a
  {
    int SEL;
    StringBuilder bDv;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(175648);
      this.bDv = new StringBuilder();
      this.SEL = 0;
      this.SEL = paramInt;
      AppMethodBeat.o(175648);
    }
    
    public final a eL(Object paramObject)
    {
      AppMethodBeat.i(175649);
      if (this.bDv.length() > 0) {
        this.bDv.append(",");
      }
      this.bDv.append(paramObject.toString());
      AppMethodBeat.o(175649);
      return this;
    }
  }
  
  public static final class b
  {
    public static final class a
    {
      public static int ID = 19307;
      public static int SEM = 1;
      public static int SEN = 2;
      public static int SEO = 1;
      public static int SEP = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.util.h
 * JD-Core Version:    0.7.0.1
 */