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
  private static boolean KDZ = false;
  static WebView.c KEa = WebView.c.KzY;
  static af KEb = null;
  static boolean KEc = false;
  public static String KzM;
  public static String sessionId = "";
  
  static
  {
    KzM = "";
  }
  
  public static void Cf(long paramLong)
  {
    AppMethodBeat.i(157020);
    if (KEb != null) {
      KEb.n(577L, paramLong, 1L);
    }
    AppMethodBeat.o(157020);
  }
  
  public static void Cg(long paramLong)
  {
    AppMethodBeat.i(157026);
    if ((KEb != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      KEb.aT(2, 3, (int)paramLong);
    }
    AppMethodBeat.o(157026);
  }
  
  public static void Ch(long paramLong)
  {
    AppMethodBeat.i(157029);
    if ((KEb != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      KEb.aT(48, 49, (int)paramLong);
    }
    AppMethodBeat.o(157029);
  }
  
  public static void Ci(long paramLong)
  {
    AppMethodBeat.i(157032);
    if ((KEb != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      KEb.aT(44, 45, (int)paramLong);
    }
    AppMethodBeat.o(157032);
  }
  
  public static void Cj(long paramLong)
  {
    AppMethodBeat.i(157049);
    if ((KEb != null) && (KEb != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      KEb.aT(11, 12, (int)paramLong);
    }
    AppMethodBeat.o(157049);
  }
  
  public static void Ck(long paramLong)
  {
    AppMethodBeat.i(157054);
    if ((KEb != null) && (KEb != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      KEb.aT(22, 23, (int)paramLong);
    }
    AppMethodBeat.o(157054);
  }
  
  public static void Cl(long paramLong)
  {
    AppMethodBeat.i(157057);
    if ((KEb != null) && (KEb != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      KEb.aT(27, 28, (int)paramLong);
    }
    AppMethodBeat.o(157057);
  }
  
  public static void Cm(long paramLong)
  {
    AppMethodBeat.i(157061);
    if ((KEb != null) && (KEb != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      KEb.aT(16, 17, (int)paramLong);
    }
    AppMethodBeat.o(157061);
  }
  
  public static void a(WebView.c paramc, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175651);
    a locala;
    if (c.aVg("kv_" + b.a.ID + paramc.toString() + "_" + paramInt))
    {
      locala = new a(b.a.ID);
      locala.ez(Integer.valueOf(paramInt));
      if (paramc != WebView.c.KzZ) {
        break label149;
      }
      locala.ez(Integer.valueOf(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
      locala.ez(Integer.valueOf(200601));
      if (!"armeabi-v7a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        break label222;
      }
      locala.ez(Integer.valueOf(b.a.KEg));
    }
    for (;;)
    {
      for (;;)
      {
        locala.ez(Integer.valueOf(paramc.ordinal()));
        cU(locala.KEd, locala.btc.toString());
        AppMethodBeat.o(175651);
        return;
        label149:
        if (paramc == WebView.c.KAa) {
          try
          {
            paramInt = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
            locala.ez(Integer.valueOf(paramInt));
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
      if (paramc == WebView.c.KAb)
      {
        locala.ez(Integer.valueOf(XWalkEnvironment.safeGetChromiunVersion()));
        break;
      }
      locala.ez(Integer.valueOf(0));
      break;
      label222:
      if ("arm64-v8a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        locala.ez(Integer.valueOf(b.a.KEh));
      }
    }
  }
  
  public static void a(af paramaf)
  {
    KEb = paramaf;
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
        if (KEb == null)
        {
          AppMethodBeat.o(175650);
          return;
        }
        if (!KEc)
        {
          if ("toolsmp".equals(KzM))
          {
            if (!fKE()) {
              break label255;
            }
            kS(903, 106);
          }
          i = fKH();
          j = WebView.getCurWebType().ordinal() - 1;
          if ((i >= 30) && (j >= 0))
          {
            KEc = true;
            kS(903, i + 3 + j);
          }
        }
        if (paramWebView.isX5WrappedSysKernel())
        {
          if (!KzM.equals("mm")) {
            break label272;
          }
          i = 79;
          j = 74;
          if (j != 0) {
            KEb.n(903L, j, 1L);
          }
          if (i != 0) {
            kS(903, i);
          }
        }
        if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
          KEb.n(903L, 102L, 1L);
        }
        i = fKH();
        j = WebView.getCurWebType().ordinal() - 1;
        if ((i >= 30) && (j >= 0)) {
          KEb.n(903L, i + 0 + j, 1L);
        }
        if (!"toolsmp".equals(KzM)) {
          break label371;
        }
        if (!fKE()) {
          break label352;
        }
        KEb.n(903L, 107L, 1L);
        AppMethodBeat.o(175650);
        continue;
        if (!fKF()) {
          continue;
        }
      }
      finally {}
      label255:
      kS(903, 108);
      continue;
      label272:
      if (KzM.equals("tools"))
      {
        i = 75;
        j = 70;
      }
      else if (KzM.equals("toolsmp"))
      {
        i = 75;
        j = 71;
      }
      else if (KzM.equals("appbrand"))
      {
        i = 77;
        j = 72;
      }
      else if (KzM.equals("support"))
      {
        i = 78;
        j = 73;
        continue;
        label352:
        if (fKF()) {
          KEb.n(903L, 109L, 1L);
        }
        label371:
        AppMethodBeat.o(175650);
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  public static void aVo(String paramString)
  {
    if (paramString != null) {
      KzM = paramString;
    }
  }
  
  public static void aVp(String paramString)
  {
    int j = 73;
    AppMethodBeat.i(157022);
    int i;
    if (KEb != null)
    {
      KEb.n(577L, 0L, 1L);
      if ((KzM.equals("toolsmp")) && (paramString != null) && (aVq(paramString) == 2)) {
        KEb.n(903L, 101L, 1L);
      }
      if (!KzM.equals("toolsmp")) {
        break label179;
      }
      if (WebView.getCurWebType() != WebView.c.KzZ) {
        break label154;
      }
      KEb.n(903L, 105L, 1L);
      if (!KDZ)
      {
        if (!KzM.equals("tools")) {
          break label218;
        }
        i = 70;
      }
    }
    for (;;)
    {
      j = WebView.getCurWebType().ordinal() - 1;
      if ((i >= 70) && (j >= 0))
      {
        KDZ = true;
        kS(577, i + j);
      }
      AppMethodBeat.o(157022);
      return;
      label154:
      if (WebView.getCurWebType() != WebView.c.KAa) {
        break;
      }
      KEb.n(903L, 104L, 1L);
      break;
      label179:
      if ((!KzM.equals("tools")) || (paramString == null) || (aVq(paramString) != 1)) {
        break;
      }
      KEb.n(903L, 103L, 1L);
      break;
      label218:
      i = j;
      if (!KzM.equals("appbrand"))
      {
        i = j;
        if (!KzM.equals("support")) {
          i = -1;
        }
      }
    }
  }
  
  public static int aVq(String paramString)
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
  
  public static void aVr(String paramString)
  {
    AppMethodBeat.i(205101);
    if (KEb == null)
    {
      AppMethodBeat.o(205101);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      KEb.n(1068L, 57L, 1L);
      AppMethodBeat.o(205101);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      KEb.n(1071L, 57L, 1L);
      AppMethodBeat.o(205101);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      KEb.n(1069L, 57L, 1L);
      AppMethodBeat.o(205101);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      KEb.n(1070L, 57L, 1L);
    }
    AppMethodBeat.o(205101);
  }
  
  public static void aVs(String paramString)
  {
    AppMethodBeat.i(157079);
    if (KEb == null)
    {
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      KEb.n(1068L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      KEb.n(1071L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      KEb.n(1069L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      KEb.n(1070L, 66L, 1L);
    }
    AppMethodBeat.o(157079);
  }
  
  public static void aVt(String paramString)
  {
    AppMethodBeat.i(157080);
    if ((paramString == null) || (paramString.isEmpty()) || (KEb == null))
    {
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      KEb.n(1068L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      KEb.n(1071L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      KEb.n(1069L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      KEb.n(1070L, 67L, 1L);
    }
    AppMethodBeat.o(157080);
  }
  
  public static void aVu(String paramString)
  {
    AppMethodBeat.i(157081);
    if ((paramString == null) || (paramString.isEmpty()) || (KEb == null))
    {
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      KEb.n(1068L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      KEb.n(1071L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      KEb.n(1069L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      KEb.n(1070L, 68L, 1L);
    }
    AppMethodBeat.o(157081);
  }
  
  public static boolean agb(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void agc(int paramInt)
  {
    AppMethodBeat.i(157083);
    if (!"toolsmp".equals(KzM))
    {
      AppMethodBeat.o(157083);
      return;
    }
    int j;
    int i;
    if (WebView.getCurWebType() == WebView.c.KzZ)
    {
      j = 200;
      if (paramInt >= 0) {
        break label84;
      }
      i = 3;
    }
    for (;;)
    {
      r(903L, j + i, 1L);
      AppMethodBeat.o(157083);
      return;
      if (WebView.getCurWebType() == WebView.c.KAa)
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
  
  public static void az(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205096);
    Log.i("WXWebReporter", "report idkey id = " + paramLong1 + " key = " + paramLong2 + " value = 1");
    if (KEb != null) {
      KEb.n(paramLong1, paramLong2, 1L);
    }
    AppMethodBeat.o(205096);
  }
  
  public static void b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(157034);
    af localaf;
    int j;
    int k;
    if (KEb != null)
    {
      fKI();
      KEb.n(577L, 5L, 1L);
      KEb.kvStat(15003, "");
      localaf = KEb;
      j = XWalkEnvironment.getAvailableVersion();
      k = aVq(paramString);
      paramString = sessionId;
      if (JsRuntime.fJf() != null) {
        break label94;
      }
    }
    label94:
    for (int i = 100;; i = JsRuntime.fJf().ordinal())
    {
      localaf.a(j, k, paramString, i, 1, paramInt1, (int)paramLong, paramInt2);
      AppMethodBeat.o(157034);
      return;
    }
  }
  
  public static void bg(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157045);
    if (KEb != null)
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
        KEb.n(577L, paramInt, 1L);
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
  
  public static void bh(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157046);
    if (KEb != null)
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
        KEb.n(577L, paramInt, 1L);
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
  
  public static void bnx()
  {
    AppMethodBeat.i(157056);
    if (KEb != null) {
      KEb.n(577L, 25L, 1L);
    }
    AppMethodBeat.o(157056);
  }
  
  public static void cU(int paramInt, String paramString)
  {
    AppMethodBeat.i(157019);
    if (KEb != null) {
      KEb.kvStat(paramInt, paramString);
    }
    AppMethodBeat.o(157019);
  }
  
  public static void dg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205097);
    if (KEb == null)
    {
      AppMethodBeat.o(205097);
      return;
    }
    if (paramBoolean) {}
    for (int i = 51; "FullScreenVideo".equals(paramString); i = 60)
    {
      KEb.n(577L, 185L, 1L);
      AppMethodBeat.o(205097);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      KEb.n(1068L, i, 1L);
      AppMethodBeat.o(205097);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      KEb.n(1071L, i, 1L);
      AppMethodBeat.o(205097);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      KEb.n(1069L, i, 1L);
      AppMethodBeat.o(205097);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      KEb.n(1070L, i, 1L);
    }
    AppMethodBeat.o(205097);
  }
  
  public static void dh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205098);
    if (KEb == null)
    {
      AppMethodBeat.o(205098);
      return;
    }
    if (paramBoolean) {}
    for (int i = 52; "FullScreenVideo".equals(paramString); i = 61)
    {
      KEb.n(577L, 186L, 1L);
      AppMethodBeat.o(205098);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      KEb.n(1068L, i, 1L);
      AppMethodBeat.o(205098);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      KEb.n(1071L, i, 1L);
      AppMethodBeat.o(205098);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      KEb.n(1069L, i, 1L);
      AppMethodBeat.o(205098);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      KEb.n(1070L, i, 1L);
    }
    AppMethodBeat.o(205098);
  }
  
  public static void di(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205099);
    if (KEb == null)
    {
      AppMethodBeat.o(205099);
      return;
    }
    if (paramBoolean) {}
    for (int i = 54; "FullScreenVideo".equals(paramString); i = 62)
    {
      KEb.n(577L, 187L, 1L);
      AppMethodBeat.o(205099);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      KEb.n(1068L, i, 1L);
      AppMethodBeat.o(205099);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      KEb.n(1071L, i, 1L);
      AppMethodBeat.o(205099);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      KEb.n(1069L, i, 1L);
      AppMethodBeat.o(205099);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      KEb.n(1070L, i, 1L);
    }
    AppMethodBeat.o(205099);
  }
  
  public static void dj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205100);
    if (KEb == null)
    {
      AppMethodBeat.o(205100);
      return;
    }
    if (paramBoolean) {}
    for (int i = 55; "FullScreenVideo".equals(paramString); i = 63)
    {
      KEb.n(577L, 188L, 1L);
      AppMethodBeat.o(205100);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      KEb.n(1068L, i, 1L);
      AppMethodBeat.o(205100);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      KEb.n(1071L, i, 1L);
      AppMethodBeat.o(205100);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      KEb.n(1069L, i, 1L);
      AppMethodBeat.o(205100);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      KEb.n(1070L, i, 1L);
    }
    AppMethodBeat.o(205100);
  }
  
  public static void dk(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(205102);
    if (KEb == null)
    {
      AppMethodBeat.o(205102);
      return;
    }
    if (paramBoolean) {}
    for (int i = 59; "XFilesPPTReader".equals(paramString); i = 65)
    {
      KEb.n(1068L, i, 1L);
      AppMethodBeat.o(205102);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      KEb.n(1071L, i, 1L);
      AppMethodBeat.o(205102);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      KEb.n(1069L, i, 1L);
      AppMethodBeat.o(205102);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      KEb.n(1070L, i, 1L);
    }
    AppMethodBeat.o(205102);
  }
  
  public static boolean dpP()
  {
    return KEb != null;
  }
  
  private static boolean fKE()
  {
    AppMethodBeat.i(157015);
    if ((KEa == WebView.c.KzZ) && (WebView.getCurWebType() != KEa))
    {
      AppMethodBeat.o(157015);
      return true;
    }
    AppMethodBeat.o(157015);
    return false;
  }
  
  private static boolean fKF()
  {
    AppMethodBeat.i(157016);
    if ((WebView.getCurWebType() == WebView.c.KzZ) && (WebView.getCurWebType() != KEa))
    {
      AppMethodBeat.o(157016);
      return true;
    }
    AppMethodBeat.o(157016);
    return false;
  }
  
  public static void fKG()
  {
    AppMethodBeat.i(205095);
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
      boolean bool = c.mG("report_core_ver", String.valueOf(i));
      if ((c.aVg("report_core_daily")) || (bool))
      {
        if (i > 0) {
          break label187;
        }
        az(1367L, 251L);
      }
      label105:
      bool = c.mG("report_core_ver_predown", String.valueOf(j));
      if ((c.aVg("report_core_daily_predown")) || (bool))
      {
        if (j > 0) {
          break label203;
        }
        az(1367L, 252L);
      }
    }
    for (;;)
    {
      if ("armeabi-v7a".equalsIgnoreCase(str2))
      {
        str1 = XWalkEnvironment.getDeviceAbi();
        if ("armeabi-v7a".equalsIgnoreCase(str1))
        {
          kS(1367, 253);
          AppMethodBeat.o(205095);
          return;
          str1 = "armeabi-v7a";
          break;
          label187:
          az(1367L, i % 100 + 0);
          break label105;
          label203:
          az(1367L, j % 100 + 100);
          continue;
        }
        if ("arm64-v8a".equalsIgnoreCase(str1)) {
          kS(1367, 254);
        }
      }
    }
    AppMethodBeat.o(205095);
  }
  
  private static int fKH()
  {
    AppMethodBeat.i(157023);
    int i = -1;
    if (KzM.equals("mm")) {
      i = 30;
    }
    for (;;)
    {
      AppMethodBeat.o(157023);
      return i;
      if (KzM.equals("tools")) {
        i = 36;
      } else if (KzM.equals("toolsmp")) {
        i = 42;
      } else if (KzM.equals("appbrand")) {
        i = 48;
      } else if (KzM.equals("support")) {
        i = 54;
      }
    }
  }
  
  public static void fKI()
  {
    AppMethodBeat.i(157025);
    if (KEb != null) {
      KEb.n(577L, 1L, 1L);
    }
    AppMethodBeat.o(157025);
  }
  
  public static void fKJ()
  {
    AppMethodBeat.i(157027);
    if (KEb != null) {
      KEb.n(577L, 46L, 1L);
    }
    AppMethodBeat.o(157027);
  }
  
  public static void fKK()
  {
    AppMethodBeat.i(157028);
    if (KEb != null) {
      KEb.n(577L, 47L, 1L);
    }
    AppMethodBeat.o(157028);
  }
  
  public static void fKL()
  {
    AppMethodBeat.i(157030);
    if (KEb != null) {
      KEb.n(577L, 42L, 1L);
    }
    AppMethodBeat.o(157030);
  }
  
  public static void fKM()
  {
    AppMethodBeat.i(157031);
    if (KEb != null) {
      KEb.n(577L, 43L, 1L);
    }
    AppMethodBeat.o(157031);
  }
  
  public static void fKN()
  {
    AppMethodBeat.i(157037);
    if (KEb != null) {
      KEb.n(577L, 52L, 1L);
    }
    AppMethodBeat.o(157037);
  }
  
  public static void fKO()
  {
    AppMethodBeat.i(157038);
    if (KEb != null) {
      KEb.n(577L, 53L, 1L);
    }
    AppMethodBeat.o(157038);
  }
  
  public static void fKP()
  {
    AppMethodBeat.i(157039);
    if (KEb != null) {
      KEb.n(577L, 54L, 1L);
    }
    AppMethodBeat.o(157039);
  }
  
  public static void fKQ()
  {
    AppMethodBeat.i(157040);
    if (KEb != null) {
      KEb.n(577L, 55L, 1L);
    }
    AppMethodBeat.o(157040);
  }
  
  public static void fKR()
  {
    AppMethodBeat.i(157041);
    if (KEb != null) {
      KEb.n(577L, 56L, 1L);
    }
    AppMethodBeat.o(157041);
  }
  
  public static void fKS()
  {
    AppMethodBeat.i(157042);
    if (KEb != null) {
      KEb.n(577L, 57L, 1L);
    }
    AppMethodBeat.o(157042);
  }
  
  public static void fKT()
  {
    AppMethodBeat.i(157043);
    if (KEb != null) {
      KEb.n(577L, 58L, 1L);
    }
    AppMethodBeat.o(157043);
  }
  
  public static void fKU()
  {
    AppMethodBeat.i(157044);
    if (KEb != null) {
      KEb.n(577L, 59L, 1L);
    }
    AppMethodBeat.o(157044);
  }
  
  public static void fKV()
  {
    AppMethodBeat.i(157047);
    if (KEb != null) {
      KEb.n(577L, 167L, 1L);
    }
    AppMethodBeat.o(157047);
  }
  
  public static void fKW()
  {
    AppMethodBeat.i(157048);
    if (KEb != null) {
      KEb.n(577L, 9L, 1L);
    }
    AppMethodBeat.o(157048);
  }
  
  public static void fKX()
  {
    AppMethodBeat.i(157050);
    if (KEb != null) {
      KEb.n(577L, 10L, 1L);
    }
    AppMethodBeat.o(157050);
  }
  
  public static void fKY()
  {
    AppMethodBeat.i(157051);
    if (KEb != null) {
      KEb.n(577L, 60L, 1L);
    }
    AppMethodBeat.o(157051);
  }
  
  public static void fKZ()
  {
    AppMethodBeat.i(157053);
    if (KEb != null) {
      KEb.n(577L, 20L, 1L);
    }
    AppMethodBeat.o(157053);
  }
  
  public static void fLa()
  {
    AppMethodBeat.i(157055);
    if (KEb != null) {
      KEb.n(577L, 21L, 1L);
    }
    AppMethodBeat.o(157055);
  }
  
  public static void fLb()
  {
    AppMethodBeat.i(157058);
    if (KEb != null) {
      KEb.n(577L, 26L, 1L);
    }
    AppMethodBeat.o(157058);
  }
  
  public static void fLc()
  {
    AppMethodBeat.i(157059);
    if (KEb != null) {
      KEb.n(577L, 14L, 1L);
    }
    AppMethodBeat.o(157059);
  }
  
  public static void fLd()
  {
    AppMethodBeat.i(157060);
    if (KEb != null) {
      KEb.n(577L, 15L, 1L);
    }
    AppMethodBeat.o(157060);
  }
  
  public static void fLe()
  {
    AppMethodBeat.i(157062);
    if (KEb == null)
    {
      AppMethodBeat.o(157062);
      return;
    }
    KEb.n(577L, 83L, 1L);
    AppMethodBeat.o(157062);
  }
  
  public static void fLf()
  {
    AppMethodBeat.i(157064);
    if (KEb == null)
    {
      AppMethodBeat.o(157064);
      return;
    }
    KEb.n(577L, 87L, 1L);
    AppMethodBeat.o(157064);
  }
  
  public static void fLg()
  {
    AppMethodBeat.i(157066);
    if (KEb != null) {
      KEb.n(577L, 180L, 1L);
    }
    AppMethodBeat.o(157066);
  }
  
  public static void fLh()
  {
    AppMethodBeat.i(157067);
    if (KEb != null) {
      KEb.n(577L, 181L, 1L);
    }
    AppMethodBeat.o(157067);
  }
  
  public static void fLi()
  {
    AppMethodBeat.i(157068);
    if (KEb != null) {
      KEb.n(577L, 182L, 1L);
    }
    AppMethodBeat.o(157068);
  }
  
  public static void fLj()
  {
    AppMethodBeat.i(157069);
    if (KEb != null) {
      KEb.n(577L, 183L, 1L);
    }
    AppMethodBeat.o(157069);
  }
  
  public static void fLk()
  {
    AppMethodBeat.i(157070);
    if (KEb != null) {
      KEb.n(577L, 184L, 1L);
    }
    AppMethodBeat.o(157070);
  }
  
  public static void fLl()
  {
    AppMethodBeat.i(157071);
    if (KEb != null) {
      KEb.n(577L, 189L, 1L);
    }
    AppMethodBeat.o(157071);
  }
  
  public static void fLm()
  {
    AppMethodBeat.i(157072);
    if (KEb != null) {
      KEb.n(577L, 190L, 1L);
    }
    AppMethodBeat.o(157072);
  }
  
  public static void fLn()
  {
    AppMethodBeat.i(157082);
    if (KEb == null)
    {
      AppMethodBeat.o(157082);
      return;
    }
    KEb.n(577L, 88L, 1L);
    AppMethodBeat.o(157082);
  }
  
  public static void fLo()
  {
    AppMethodBeat.i(157085);
    r(938L, 89L, 1L);
    AppMethodBeat.o(157085);
  }
  
  public static void fLp()
  {
    AppMethodBeat.i(157086);
    r(938L, 90L, 1L);
    AppMethodBeat.o(157086);
  }
  
  public static void fLq()
  {
    AppMethodBeat.i(157087);
    r(938L, 91L, 1L);
    AppMethodBeat.o(157087);
  }
  
  public static void gL(String paramString, int paramInt)
  {
    AppMethodBeat.i(157033);
    af localaf;
    int j;
    int k;
    if (KEb != null)
    {
      aVp(paramString);
      sessionId = UUID.randomUUID().toString().replace("-", "");
      KEb.n(577L, 4L, 1L);
      localaf = KEb;
      j = XWalkEnvironment.getAvailableVersion();
      k = aVq(paramString);
      paramString = sessionId;
      if (JsRuntime.fJf() != null) {
        break label95;
      }
    }
    label95:
    for (int i = 100;; i = JsRuntime.fJf().ordinal())
    {
      localaf.a(j, k, paramString, i, 0, 0, 0, paramInt);
      AppMethodBeat.o(157033);
      return;
    }
  }
  
  public static void h(WebView.c paramc)
  {
    KEa = paramc;
  }
  
  public static void i(WebView.c paramc)
  {
    AppMethodBeat.i(157018);
    if (KEb == null)
    {
      AppMethodBeat.o(157018);
      return;
    }
    int i;
    String str1;
    label36:
    String str3;
    String str2;
    if (paramc == WebView.c.KzZ)
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
      if (paramc == WebView.c.KzZ)
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
          KEb.n(577L, j % 50 + 100, 1L);
          XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
        }
      }
      if (str3.equals(str2))
      {
        AppMethodBeat.o(157018);
        return;
      }
      if (paramc == WebView.c.KzZ)
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
        KEb.n(577L, i, 1L);
        XWalkEnvironment.getSharedPreferences().edit().putString(str1, str3).commit();
        AppMethodBeat.o(157018);
        return;
        if (paramc == WebView.c.KAb)
        {
          i = 97;
        }
        else
        {
          if (paramc != WebView.c.KAa) {
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
    if (KEb == null)
    {
      AppMethodBeat.o(157052);
      return;
    }
    if (paramc == WebView.c.KzZ)
    {
      KEb.n(577L, 61L, 1L);
      kS(577, 62);
    }
    AppMethodBeat.o(157052);
  }
  
  public static void k(WebView.c paramc)
  {
    AppMethodBeat.i(157063);
    if (KEb == null)
    {
      AppMethodBeat.o(157063);
      return;
    }
    int i;
    switch (g.1.meK[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157063);
      return;
    case 1: 
      i = 82;
    }
    for (;;)
    {
      KEb.n(577L, i, 1L);
      AppMethodBeat.o(157063);
      return;
      i = 81;
      continue;
      i = 80;
    }
  }
  
  public static void kS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157017);
    if (KEb == null)
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
    KEb.n(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString(str1, str2).commit();
    AppMethodBeat.o(157017);
  }
  
  public static void l(WebView.c paramc)
  {
    AppMethodBeat.i(157065);
    if (KEb == null)
    {
      AppMethodBeat.o(157065);
      return;
    }
    int i;
    switch (g.1.meK[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157065);
      return;
    case 1: 
      i = 86;
    }
    for (;;)
    {
      KEb.n(577L, i, 1L);
      AppMethodBeat.o(157065);
      return;
      i = 85;
      continue;
      i = 84;
    }
  }
  
  public static void q(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(157035);
    Cg(paramLong);
    af localaf;
    int j;
    int k;
    if ((KEb != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      KEb.aT(6, 7, (int)paramLong);
      localaf = KEb;
      j = XWalkEnvironment.getAvailableVersion();
      k = aVq(paramString);
      paramString = sessionId;
      if (JsRuntime.fJf() != null) {
        break label96;
      }
    }
    label96:
    for (int i = 100;; i = JsRuntime.fJf().ordinal())
    {
      localaf.a(j, k, paramString, i, 1, 0, (int)paramLong, paramInt);
      AppMethodBeat.o(157035);
      return;
    }
  }
  
  public static void r(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(157021);
    if (KEb != null) {
      KEb.n(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(157021);
  }
  
  public static void za(boolean paramBoolean)
  {
    AppMethodBeat.i(157084);
    if (!"toolsmp".equals(KzM))
    {
      AppMethodBeat.o(157084);
      return;
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (WebView.getCurWebType() != WebView.c.KzZ) {
        break label66;
      }
    }
    for (int j = 180;; j = 190)
    {
      r(903L, i + j, 1L);
      AppMethodBeat.o(157084);
      return;
      i = 1;
      break;
      label66:
      if (WebView.getCurWebType() != WebView.c.KAa) {
        break label82;
      }
    }
    label82:
    AppMethodBeat.o(157084);
  }
  
  public static final class a
  {
    int KEd;
    StringBuilder btc;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(175648);
      this.btc = new StringBuilder();
      this.KEd = 0;
      this.KEd = paramInt;
      AppMethodBeat.o(175648);
    }
    
    public final a ez(Object paramObject)
    {
      AppMethodBeat.i(175649);
      if (this.btc.length() > 0) {
        this.btc.append(",");
      }
      this.btc.append(paramObject.toString());
      AppMethodBeat.o(175649);
      return this;
    }
  }
  
  public static final class b$a
  {
    public static int ID = 19307;
    public static int KEe = 1;
    public static int KEf = 2;
    public static int KEg = 1;
    public static int KEh = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.g
 * JD-Core Version:    0.7.0.1
 */