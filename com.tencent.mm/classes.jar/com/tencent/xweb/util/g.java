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

public final class g
{
  public static String MNl = "";
  private static boolean MRD = false;
  static WebView.c MRE = WebView.c.MNx;
  static af MRF = null;
  static boolean MRG = false;
  public static String sessionId = "";
  
  public static void Aa(boolean paramBoolean)
  {
    AppMethodBeat.i(157084);
    if (!"toolsmp".equals(MNl))
    {
      AppMethodBeat.o(157084);
      return;
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (WebView.getCurWebType() != WebView.c.MNy) {
        break label63;
      }
    }
    for (int j = 180;; j = 190)
    {
      t(903L, i + j, 1L);
      AppMethodBeat.o(157084);
      return;
      i = 1;
      break;
      label63:
      if (WebView.getCurWebType() != WebView.c.MNz) {
        break label79;
      }
    }
    label79:
    AppMethodBeat.o(157084);
  }
  
  public static void FJ(long paramLong)
  {
    AppMethodBeat.i(157020);
    if (MRF != null) {
      MRF.n(577L, paramLong, 1L);
    }
    AppMethodBeat.o(157020);
  }
  
  public static void FK(long paramLong)
  {
    AppMethodBeat.i(157026);
    if ((MRF != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      MRF.aV(2, 3, (int)paramLong);
    }
    AppMethodBeat.o(157026);
  }
  
  public static void FL(long paramLong)
  {
    AppMethodBeat.i(157029);
    if ((MRF != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      MRF.aV(48, 49, (int)paramLong);
    }
    AppMethodBeat.o(157029);
  }
  
  public static void FM(long paramLong)
  {
    AppMethodBeat.i(157032);
    if ((MRF != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      MRF.aV(44, 45, (int)paramLong);
    }
    AppMethodBeat.o(157032);
  }
  
  public static void FN(long paramLong)
  {
    AppMethodBeat.i(157049);
    if ((MRF != null) && (MRF != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      MRF.aV(11, 12, (int)paramLong);
    }
    AppMethodBeat.o(157049);
  }
  
  public static void FO(long paramLong)
  {
    AppMethodBeat.i(157054);
    if ((MRF != null) && (MRF != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      MRF.aV(22, 23, (int)paramLong);
    }
    AppMethodBeat.o(157054);
  }
  
  public static void FP(long paramLong)
  {
    AppMethodBeat.i(157057);
    if ((MRF != null) && (MRF != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      MRF.aV(27, 28, (int)paramLong);
    }
    AppMethodBeat.o(157057);
  }
  
  public static void FQ(long paramLong)
  {
    AppMethodBeat.i(157061);
    if ((MRF != null) && (MRF != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      MRF.aV(16, 17, (int)paramLong);
    }
    AppMethodBeat.o(157061);
  }
  
  public static void a(WebView.c paramc, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175651);
    a locala;
    if (c.bcN("kv_" + b.a.ID + paramc.toString() + "_" + paramInt))
    {
      locala = new a(b.a.ID);
      locala.eF(Integer.valueOf(paramInt));
      if (paramc != WebView.c.MNy) {
        break label149;
      }
      locala.eF(Integer.valueOf(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
      locala.eF(Integer.valueOf(200901));
      if (!"armeabi-v7a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        break label222;
      }
      locala.eF(Integer.valueOf(b.a.MRK));
    }
    for (;;)
    {
      for (;;)
      {
        locala.eF(Integer.valueOf(paramc.ordinal()));
        dc(locala.MRH, locala.bDt.toString());
        AppMethodBeat.o(175651);
        return;
        label149:
        if (paramc == WebView.c.MNz) {
          try
          {
            paramInt = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
            locala.eF(Integer.valueOf(paramInt));
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
      if (paramc == WebView.c.MNA)
      {
        locala.eF(Integer.valueOf(XWalkEnvironment.safeGetChromiunVersion()));
        break;
      }
      locala.eF(Integer.valueOf(0));
      break;
      label222:
      if ("arm64-v8a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        locala.eF(Integer.valueOf(b.a.MRL));
      }
    }
  }
  
  public static void a(af paramaf)
  {
    MRF = paramaf;
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
        if (MRF == null)
        {
          AppMethodBeat.o(175650);
          return;
        }
        if (!MRG)
        {
          if ("toolsmp".equals(MNl))
          {
            if (!ggB()) {
              break label255;
            }
            lo(903, 106);
          }
          i = ggE();
          j = WebView.getCurWebType().ordinal() - 1;
          if ((i >= 30) && (j >= 0))
          {
            MRG = true;
            lo(903, i + 3 + j);
          }
        }
        if (paramWebView.isX5WrappedSysKernel())
        {
          if (!MNl.equals("mm")) {
            break label272;
          }
          i = 79;
          j = 74;
          if (j != 0) {
            MRF.n(903L, j, 1L);
          }
          if (i != 0) {
            lo(903, i);
          }
        }
        if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
          MRF.n(903L, 102L, 1L);
        }
        i = ggE();
        j = WebView.getCurWebType().ordinal() - 1;
        if ((i >= 30) && (j >= 0)) {
          MRF.n(903L, i + 0 + j, 1L);
        }
        if (!"toolsmp".equals(MNl)) {
          break label374;
        }
        if (!ggB()) {
          break label355;
        }
        MRF.n(903L, 107L, 1L);
        AppMethodBeat.o(175650);
        continue;
        if (!ggC()) {
          continue;
        }
      }
      finally {}
      label255:
      lo(903, 108);
      continue;
      label272:
      if (MNl.equals("tools"))
      {
        i = 75;
        j = 70;
      }
      else if (MNl.equals("toolsmp"))
      {
        i = 75;
        j = 71;
      }
      else if (MNl.equals("appbrand"))
      {
        i = 77;
        j = 72;
      }
      else if (MNl.equals("support"))
      {
        i = 78;
        j = 73;
        continue;
        label355:
        if (ggC()) {
          MRF.n(903L, 109L, 1L);
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
  
  public static void aD(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(217427);
    Log.i("WXWebReporter", "report idkey id = " + paramLong1 + " key = " + paramLong2 + " value = 1");
    if (MRF != null) {
      MRF.n(paramLong1, paramLong2, 1L);
    }
    AppMethodBeat.o(217427);
  }
  
  public static boolean ajl(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void ajm(int paramInt)
  {
    AppMethodBeat.i(157083);
    if (!"toolsmp".equals(MNl))
    {
      AppMethodBeat.o(157083);
      return;
    }
    int j;
    int i;
    if (WebView.getCurWebType() == WebView.c.MNy)
    {
      j = 200;
      if (paramInt >= 0) {
        break label84;
      }
      i = 3;
    }
    for (;;)
    {
      t(903L, j + i, 1L);
      AppMethodBeat.o(157083);
      return;
      if (WebView.getCurWebType() == WebView.c.MNz)
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
  
  public static void bcU(String paramString)
  {
    if (paramString != null) {
      MNl = paramString;
    }
  }
  
  public static void bcV(String paramString)
  {
    int j = 73;
    AppMethodBeat.i(157022);
    int i;
    if (MRF != null)
    {
      MRF.n(577L, 0L, 1L);
      if ((MNl.equals("toolsmp")) && (paramString != null) && (bcW(paramString) == 2)) {
        MRF.n(903L, 101L, 1L);
      }
      if (!MNl.equals("toolsmp")) {
        break label180;
      }
      if (WebView.getCurWebType() != WebView.c.MNy) {
        break label155;
      }
      MRF.n(903L, 105L, 1L);
      if (!MRD)
      {
        if (!MNl.equals("tools")) {
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
        MRD = true;
        lo(577, i + j);
      }
      AppMethodBeat.o(157022);
      return;
      label155:
      if (WebView.getCurWebType() != WebView.c.MNz) {
        break;
      }
      MRF.n(903L, 104L, 1L);
      break;
      label180:
      if ((!MNl.equals("tools")) || (paramString == null) || (bcW(paramString) != 1)) {
        break;
      }
      MRF.n(903L, 103L, 1L);
      break;
      label220:
      i = j;
      if (!MNl.equals("appbrand"))
      {
        i = j;
        if (!MNl.equals("support")) {
          i = -1;
        }
      }
    }
  }
  
  public static int bcW(String paramString)
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
  
  public static void bcX(String paramString)
  {
    AppMethodBeat.i(217432);
    if (MRF == null)
    {
      AppMethodBeat.o(217432);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MRF.n(1068L, 57L, 1L);
      AppMethodBeat.o(217432);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MRF.n(1071L, 57L, 1L);
      AppMethodBeat.o(217432);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MRF.n(1069L, 57L, 1L);
      AppMethodBeat.o(217432);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MRF.n(1070L, 57L, 1L);
    }
    AppMethodBeat.o(217432);
  }
  
  public static void bcY(String paramString)
  {
    AppMethodBeat.i(157079);
    if (MRF == null)
    {
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MRF.n(1068L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MRF.n(1071L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MRF.n(1069L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MRF.n(1070L, 66L, 1L);
    }
    AppMethodBeat.o(157079);
  }
  
  public static void bcZ(String paramString)
  {
    AppMethodBeat.i(157080);
    if ((paramString == null) || (paramString.isEmpty()) || (MRF == null))
    {
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      MRF.n(1068L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      MRF.n(1071L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      MRF.n(1069L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      MRF.n(1070L, 67L, 1L);
    }
    AppMethodBeat.o(157080);
  }
  
  public static void bda(String paramString)
  {
    AppMethodBeat.i(157081);
    if ((paramString == null) || (paramString.isEmpty()) || (MRF == null))
    {
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      MRF.n(1068L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      MRF.n(1071L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      MRF.n(1069L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      MRF.n(1070L, 68L, 1L);
    }
    AppMethodBeat.o(157081);
  }
  
  public static void brU()
  {
    AppMethodBeat.i(157056);
    if (MRF != null) {
      MRF.n(577L, 25L, 1L);
    }
    AppMethodBeat.o(157056);
  }
  
  public static void bx(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157045);
    if (MRF != null)
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
        MRF.n(577L, paramInt, 1L);
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
  
  public static void by(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157046);
    if (MRF != null)
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
        MRF.n(577L, paramInt, 1L);
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
  
  public static void c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(157034);
    af localaf;
    int j;
    int k;
    if (MRF != null)
    {
      ggF();
      MRF.n(577L, 5L, 1L);
      MRF.kvStat(15003, "");
      localaf = MRF;
      j = XWalkEnvironment.getAvailableVersion();
      k = bcW(paramString);
      paramString = sessionId;
      if (JsRuntime.gfd() != null) {
        break label94;
      }
    }
    label94:
    for (int i = 100;; i = JsRuntime.gfd().ordinal())
    {
      localaf.a(j, k, paramString, i, 1, paramInt1, (int)paramLong, paramInt2);
      AppMethodBeat.o(157034);
      return;
    }
  }
  
  public static void dA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(224548);
    int j = e.bcS(paramString).intValue();
    if (paramBoolean) {}
    for (int i = 0;; i = 100)
    {
      t(1511L, i + j % 100, 1L);
      AppMethodBeat.o(224548);
      return;
    }
  }
  
  public static boolean dDJ()
  {
    return MRF != null;
  }
  
  public static void dc(int paramInt, String paramString)
  {
    AppMethodBeat.i(157019);
    if (MRF != null) {
      MRF.kvStat(paramInt, paramString);
    }
    AppMethodBeat.o(157019);
  }
  
  public static void jdMethod_do(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(217428);
    if (MRF == null)
    {
      AppMethodBeat.o(217428);
      return;
    }
    if (paramBoolean) {}
    for (int i = 51; "FullScreenVideo".equals(paramString); i = 60)
    {
      MRF.n(577L, 185L, 1L);
      AppMethodBeat.o(217428);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MRF.n(1068L, i, 1L);
      AppMethodBeat.o(217428);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MRF.n(1071L, i, 1L);
      AppMethodBeat.o(217428);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MRF.n(1069L, i, 1L);
      AppMethodBeat.o(217428);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MRF.n(1070L, i, 1L);
    }
    AppMethodBeat.o(217428);
  }
  
  public static void dp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(217429);
    if (MRF == null)
    {
      AppMethodBeat.o(217429);
      return;
    }
    if (paramBoolean) {}
    for (int i = 52; "FullScreenVideo".equals(paramString); i = 61)
    {
      MRF.n(577L, 186L, 1L);
      AppMethodBeat.o(217429);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MRF.n(1068L, i, 1L);
      AppMethodBeat.o(217429);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MRF.n(1071L, i, 1L);
      AppMethodBeat.o(217429);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MRF.n(1069L, i, 1L);
      AppMethodBeat.o(217429);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MRF.n(1070L, i, 1L);
    }
    AppMethodBeat.o(217429);
  }
  
  public static void dq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(217430);
    if (MRF == null)
    {
      AppMethodBeat.o(217430);
      return;
    }
    if (paramBoolean) {}
    for (int i = 54; "FullScreenVideo".equals(paramString); i = 62)
    {
      MRF.n(577L, 187L, 1L);
      AppMethodBeat.o(217430);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MRF.n(1068L, i, 1L);
      AppMethodBeat.o(217430);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MRF.n(1071L, i, 1L);
      AppMethodBeat.o(217430);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MRF.n(1069L, i, 1L);
      AppMethodBeat.o(217430);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MRF.n(1070L, i, 1L);
    }
    AppMethodBeat.o(217430);
  }
  
  public static void dr(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(217431);
    if (MRF == null)
    {
      AppMethodBeat.o(217431);
      return;
    }
    if (paramBoolean) {}
    for (int i = 55; "FullScreenVideo".equals(paramString); i = 63)
    {
      MRF.n(577L, 188L, 1L);
      AppMethodBeat.o(217431);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MRF.n(1068L, i, 1L);
      AppMethodBeat.o(217431);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MRF.n(1071L, i, 1L);
      AppMethodBeat.o(217431);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MRF.n(1069L, i, 1L);
      AppMethodBeat.o(217431);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MRF.n(1070L, i, 1L);
    }
    AppMethodBeat.o(217431);
  }
  
  public static void ds(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(217433);
    if (MRF == null)
    {
      AppMethodBeat.o(217433);
      return;
    }
    if (paramBoolean) {}
    for (int i = 59; "XFilesPPTReader".equals(paramString); i = 65)
    {
      MRF.n(1068L, i, 1L);
      AppMethodBeat.o(217433);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MRF.n(1071L, i, 1L);
      AppMethodBeat.o(217433);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MRF.n(1069L, i, 1L);
      AppMethodBeat.o(217433);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MRF.n(1070L, i, 1L);
    }
    AppMethodBeat.o(217433);
  }
  
  private static boolean ggB()
  {
    AppMethodBeat.i(157015);
    if ((MRE == WebView.c.MNy) && (WebView.getCurWebType() != MRE))
    {
      AppMethodBeat.o(157015);
      return true;
    }
    AppMethodBeat.o(157015);
    return false;
  }
  
  private static boolean ggC()
  {
    AppMethodBeat.i(157016);
    if ((WebView.getCurWebType() == WebView.c.MNy) && (WebView.getCurWebType() != MRE))
    {
      AppMethodBeat.o(157016);
      return true;
    }
    AppMethodBeat.o(157016);
    return false;
  }
  
  public static void ggD()
  {
    AppMethodBeat.i(217426);
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
      boolean bool = c.nk("report_core_ver", String.valueOf(i));
      if ((c.bcN("report_core_daily")) || (bool))
      {
        if (i > 0) {
          break label187;
        }
        aD(1367L, 251L);
      }
      label105:
      bool = c.nk("report_core_ver_predown", String.valueOf(j));
      if ((c.bcN("report_core_daily_predown")) || (bool))
      {
        if (j > 0) {
          break label203;
        }
        aD(1367L, 252L);
      }
    }
    for (;;)
    {
      if ("armeabi-v7a".equalsIgnoreCase(str2))
      {
        str1 = XWalkEnvironment.getDeviceAbi();
        if ("armeabi-v7a".equalsIgnoreCase(str1))
        {
          lo(1367, 253);
          AppMethodBeat.o(217426);
          return;
          str1 = "armeabi-v7a";
          break;
          label187:
          aD(1367L, i % 100 + 0);
          break label105;
          label203:
          aD(1367L, j % 100 + 100);
          continue;
        }
        if ("arm64-v8a".equalsIgnoreCase(str1)) {
          lo(1367, 254);
        }
      }
    }
    AppMethodBeat.o(217426);
  }
  
  private static int ggE()
  {
    AppMethodBeat.i(157023);
    int i = -1;
    if (MNl.equals("mm")) {
      i = 30;
    }
    for (;;)
    {
      AppMethodBeat.o(157023);
      return i;
      if (MNl.equals("tools")) {
        i = 36;
      } else if (MNl.equals("toolsmp")) {
        i = 42;
      } else if (MNl.equals("appbrand")) {
        i = 48;
      } else if (MNl.equals("support")) {
        i = 54;
      }
    }
  }
  
  public static void ggF()
  {
    AppMethodBeat.i(157025);
    if (MRF != null) {
      MRF.n(577L, 1L, 1L);
    }
    AppMethodBeat.o(157025);
  }
  
  public static void ggG()
  {
    AppMethodBeat.i(157027);
    if (MRF != null) {
      MRF.n(577L, 46L, 1L);
    }
    AppMethodBeat.o(157027);
  }
  
  public static void ggH()
  {
    AppMethodBeat.i(157028);
    if (MRF != null) {
      MRF.n(577L, 47L, 1L);
    }
    AppMethodBeat.o(157028);
  }
  
  public static void ggI()
  {
    AppMethodBeat.i(157030);
    if (MRF != null) {
      MRF.n(577L, 42L, 1L);
    }
    AppMethodBeat.o(157030);
  }
  
  public static void ggJ()
  {
    AppMethodBeat.i(157031);
    if (MRF != null) {
      MRF.n(577L, 43L, 1L);
    }
    AppMethodBeat.o(157031);
  }
  
  public static void ggK()
  {
    AppMethodBeat.i(157037);
    if (MRF != null) {
      MRF.n(577L, 52L, 1L);
    }
    AppMethodBeat.o(157037);
  }
  
  public static void ggL()
  {
    AppMethodBeat.i(157038);
    if (MRF != null) {
      MRF.n(577L, 53L, 1L);
    }
    AppMethodBeat.o(157038);
  }
  
  public static void ggM()
  {
    AppMethodBeat.i(157039);
    if (MRF != null) {
      MRF.n(577L, 54L, 1L);
    }
    AppMethodBeat.o(157039);
  }
  
  public static void ggN()
  {
    AppMethodBeat.i(157040);
    if (MRF != null) {
      MRF.n(577L, 55L, 1L);
    }
    AppMethodBeat.o(157040);
  }
  
  public static void ggO()
  {
    AppMethodBeat.i(157041);
    if (MRF != null) {
      MRF.n(577L, 56L, 1L);
    }
    AppMethodBeat.o(157041);
  }
  
  public static void ggP()
  {
    AppMethodBeat.i(157042);
    if (MRF != null) {
      MRF.n(577L, 57L, 1L);
    }
    AppMethodBeat.o(157042);
  }
  
  public static void ggQ()
  {
    AppMethodBeat.i(157043);
    if (MRF != null) {
      MRF.n(577L, 58L, 1L);
    }
    AppMethodBeat.o(157043);
  }
  
  public static void ggR()
  {
    AppMethodBeat.i(157044);
    if (MRF != null) {
      MRF.n(577L, 59L, 1L);
    }
    AppMethodBeat.o(157044);
  }
  
  public static void ggS()
  {
    AppMethodBeat.i(157047);
    if (MRF != null) {
      MRF.n(577L, 167L, 1L);
    }
    AppMethodBeat.o(157047);
  }
  
  public static void ggT()
  {
    AppMethodBeat.i(157048);
    if (MRF != null) {
      MRF.n(577L, 9L, 1L);
    }
    AppMethodBeat.o(157048);
  }
  
  public static void ggU()
  {
    AppMethodBeat.i(157050);
    if (MRF != null) {
      MRF.n(577L, 10L, 1L);
    }
    AppMethodBeat.o(157050);
  }
  
  public static void ggV()
  {
    AppMethodBeat.i(157051);
    if (MRF != null) {
      MRF.n(577L, 60L, 1L);
    }
    AppMethodBeat.o(157051);
  }
  
  public static void ggW()
  {
    AppMethodBeat.i(157053);
    if (MRF != null) {
      MRF.n(577L, 20L, 1L);
    }
    AppMethodBeat.o(157053);
  }
  
  public static void ggX()
  {
    AppMethodBeat.i(157055);
    if (MRF != null) {
      MRF.n(577L, 21L, 1L);
    }
    AppMethodBeat.o(157055);
  }
  
  public static void ggY()
  {
    AppMethodBeat.i(157058);
    if (MRF != null) {
      MRF.n(577L, 26L, 1L);
    }
    AppMethodBeat.o(157058);
  }
  
  public static void ggZ()
  {
    AppMethodBeat.i(157059);
    if (MRF != null) {
      MRF.n(577L, 14L, 1L);
    }
    AppMethodBeat.o(157059);
  }
  
  public static void gha()
  {
    AppMethodBeat.i(157060);
    if (MRF != null) {
      MRF.n(577L, 15L, 1L);
    }
    AppMethodBeat.o(157060);
  }
  
  public static void ghb()
  {
    AppMethodBeat.i(157062);
    if (MRF == null)
    {
      AppMethodBeat.o(157062);
      return;
    }
    MRF.n(577L, 83L, 1L);
    AppMethodBeat.o(157062);
  }
  
  public static void ghc()
  {
    AppMethodBeat.i(157064);
    if (MRF == null)
    {
      AppMethodBeat.o(157064);
      return;
    }
    MRF.n(577L, 87L, 1L);
    AppMethodBeat.o(157064);
  }
  
  public static void ghd()
  {
    AppMethodBeat.i(157066);
    if (MRF != null) {
      MRF.n(577L, 180L, 1L);
    }
    AppMethodBeat.o(157066);
  }
  
  public static void ghe()
  {
    AppMethodBeat.i(157067);
    if (MRF != null) {
      MRF.n(577L, 181L, 1L);
    }
    AppMethodBeat.o(157067);
  }
  
  public static void ghf()
  {
    AppMethodBeat.i(157068);
    if (MRF != null) {
      MRF.n(577L, 182L, 1L);
    }
    AppMethodBeat.o(157068);
  }
  
  public static void ghg()
  {
    AppMethodBeat.i(157069);
    if (MRF != null) {
      MRF.n(577L, 183L, 1L);
    }
    AppMethodBeat.o(157069);
  }
  
  public static void ghh()
  {
    AppMethodBeat.i(157070);
    if (MRF != null) {
      MRF.n(577L, 184L, 1L);
    }
    AppMethodBeat.o(157070);
  }
  
  public static void ghi()
  {
    AppMethodBeat.i(157071);
    if (MRF != null) {
      MRF.n(577L, 189L, 1L);
    }
    AppMethodBeat.o(157071);
  }
  
  public static void ghj()
  {
    AppMethodBeat.i(157072);
    if (MRF != null) {
      MRF.n(577L, 190L, 1L);
    }
    AppMethodBeat.o(157072);
  }
  
  public static void ghk()
  {
    AppMethodBeat.i(157082);
    if (MRF == null)
    {
      AppMethodBeat.o(157082);
      return;
    }
    MRF.n(577L, 88L, 1L);
    AppMethodBeat.o(157082);
  }
  
  public static void ghl()
  {
    AppMethodBeat.i(157085);
    t(938L, 89L, 1L);
    AppMethodBeat.o(157085);
  }
  
  public static void ghm()
  {
    AppMethodBeat.i(157086);
    t(938L, 90L, 1L);
    AppMethodBeat.o(157086);
  }
  
  public static void ghn()
  {
    AppMethodBeat.i(157087);
    t(938L, 91L, 1L);
    AppMethodBeat.o(157087);
  }
  
  public static void h(WebView.c paramc)
  {
    MRE = paramc;
  }
  
  public static void ht(String paramString, int paramInt)
  {
    AppMethodBeat.i(157033);
    af localaf;
    int j;
    int k;
    if (MRF != null)
    {
      bcV(paramString);
      sessionId = UUID.randomUUID().toString().replace("-", "");
      MRF.n(577L, 4L, 1L);
      localaf = MRF;
      j = XWalkEnvironment.getAvailableVersion();
      k = bcW(paramString);
      paramString = sessionId;
      if (JsRuntime.gfd() != null) {
        break label95;
      }
    }
    label95:
    for (int i = 100;; i = JsRuntime.gfd().ordinal())
    {
      localaf.a(j, k, paramString, i, 0, 0, 0, paramInt);
      AppMethodBeat.o(157033);
      return;
    }
  }
  
  public static void i(WebView.c paramc)
  {
    AppMethodBeat.i(157018);
    if (MRF == null)
    {
      AppMethodBeat.o(157018);
      return;
    }
    int i;
    String str1;
    label36:
    String str3;
    String str2;
    if (paramc == WebView.c.MNy)
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
      if (paramc == WebView.c.MNy)
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
          MRF.n(577L, j % 50 + 100, 1L);
          XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
        }
      }
      if (str3.equals(str2))
      {
        AppMethodBeat.o(157018);
        return;
      }
      if (paramc == WebView.c.MNy)
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
        MRF.n(577L, i, 1L);
        XWalkEnvironment.getSharedPreferences().edit().putString(str1, str3).commit();
        AppMethodBeat.o(157018);
        return;
        if (paramc == WebView.c.MNA)
        {
          i = 97;
        }
        else
        {
          if (paramc != WebView.c.MNz) {
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
    if (MRF == null)
    {
      AppMethodBeat.o(157052);
      return;
    }
    if (paramc == WebView.c.MNy)
    {
      MRF.n(577L, 61L, 1L);
      lo(577, 62);
    }
    AppMethodBeat.o(157052);
  }
  
  public static void k(WebView.c paramc)
  {
    AppMethodBeat.i(157063);
    if (MRF == null)
    {
      AppMethodBeat.o(157063);
      return;
    }
    int i;
    switch (g.1.mKi[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157063);
      return;
    case 1: 
      i = 82;
    }
    for (;;)
    {
      MRF.n(577L, i, 1L);
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
    if (MRF == null)
    {
      AppMethodBeat.o(157065);
      return;
    }
    int i;
    switch (g.1.mKi[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157065);
      return;
    case 1: 
      i = 86;
    }
    for (;;)
    {
      MRF.n(577L, i, 1L);
      AppMethodBeat.o(157065);
      return;
      i = 85;
      continue;
      i = 84;
    }
  }
  
  public static void lo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157017);
    if (MRF == null)
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
    MRF.n(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString(str1, str2).commit();
    AppMethodBeat.o(157017);
  }
  
  public static void s(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(157035);
    FK(paramLong);
    af localaf;
    int j;
    int k;
    if ((MRF != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      MRF.aV(6, 7, (int)paramLong);
      localaf = MRF;
      j = XWalkEnvironment.getAvailableVersion();
      k = bcW(paramString);
      paramString = sessionId;
      if (JsRuntime.gfd() != null) {
        break label96;
      }
    }
    label96:
    for (int i = 100;; i = JsRuntime.gfd().ordinal())
    {
      localaf.a(j, k, paramString, i, 1, 0, (int)paramLong, paramInt);
      AppMethodBeat.o(157035);
      return;
    }
  }
  
  public static void t(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(157021);
    if (MRF != null) {
      MRF.n(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(157021);
  }
  
  public static final class a
  {
    int MRH;
    StringBuilder bDt;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(175648);
      this.bDt = new StringBuilder();
      this.MRH = 0;
      this.MRH = paramInt;
      AppMethodBeat.o(175648);
    }
    
    public final a eF(Object paramObject)
    {
      AppMethodBeat.i(175649);
      if (this.bDt.length() > 0) {
        this.bDt.append(",");
      }
      this.bDt.append(paramObject.toString());
      AppMethodBeat.o(175649);
      return this;
    }
  }
  
  public static final class b$a
  {
    public static int ID = 19307;
    public static int MRI = 1;
    public static int MRJ = 2;
    public static int MRK = 1;
    public static int MRL = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.g
 * JD-Core Version:    0.7.0.1
 */