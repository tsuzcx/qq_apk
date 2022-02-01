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
  public static String Mqh;
  static WebView.c MuA = WebView.c.Mqt;
  static af MuB = null;
  static boolean MuC = false;
  private static boolean Muz;
  public static String sessionId = "";
  
  static
  {
    Mqh = "";
    Muz = false;
  }
  
  public static void Fh(long paramLong)
  {
    AppMethodBeat.i(157020);
    if (MuB != null) {
      MuB.n(577L, paramLong, 1L);
    }
    AppMethodBeat.o(157020);
  }
  
  public static void Fi(long paramLong)
  {
    AppMethodBeat.i(157026);
    if ((MuB != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      MuB.aU(2, 3, (int)paramLong);
    }
    AppMethodBeat.o(157026);
  }
  
  public static void Fj(long paramLong)
  {
    AppMethodBeat.i(157029);
    if ((MuB != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      MuB.aU(48, 49, (int)paramLong);
    }
    AppMethodBeat.o(157029);
  }
  
  public static void Fk(long paramLong)
  {
    AppMethodBeat.i(157032);
    if ((MuB != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      MuB.aU(44, 45, (int)paramLong);
    }
    AppMethodBeat.o(157032);
  }
  
  public static void Fl(long paramLong)
  {
    AppMethodBeat.i(157049);
    if ((MuB != null) && (MuB != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      MuB.aU(11, 12, (int)paramLong);
    }
    AppMethodBeat.o(157049);
  }
  
  public static void Fm(long paramLong)
  {
    AppMethodBeat.i(157054);
    if ((MuB != null) && (MuB != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      MuB.aU(22, 23, (int)paramLong);
    }
    AppMethodBeat.o(157054);
  }
  
  public static void Fn(long paramLong)
  {
    AppMethodBeat.i(157057);
    if ((MuB != null) && (MuB != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      MuB.aU(27, 28, (int)paramLong);
    }
    AppMethodBeat.o(157057);
  }
  
  public static void Fo(long paramLong)
  {
    AppMethodBeat.i(157061);
    if ((MuB != null) && (MuB != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      MuB.aU(16, 17, (int)paramLong);
    }
    AppMethodBeat.o(157061);
  }
  
  public static void a(WebView.c paramc, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175651);
    a locala;
    if (c.bbk("kv_" + b.a.ID + paramc.toString() + "_" + paramInt))
    {
      locala = new a(b.a.ID);
      locala.eC(Integer.valueOf(paramInt));
      if (paramc != WebView.c.Mqu) {
        break label149;
      }
      locala.eC(Integer.valueOf(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
      locala.eC(Integer.valueOf(200801));
      if (!"armeabi-v7a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        break label222;
      }
      locala.eC(Integer.valueOf(b.a.MuG));
    }
    for (;;)
    {
      for (;;)
      {
        locala.eC(Integer.valueOf(paramc.ordinal()));
        dc(locala.MuD, locala.bDt.toString());
        AppMethodBeat.o(175651);
        return;
        label149:
        if (paramc == WebView.c.Mqv) {
          try
          {
            paramInt = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
            locala.eC(Integer.valueOf(paramInt));
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
      if (paramc == WebView.c.Mqw)
      {
        locala.eC(Integer.valueOf(XWalkEnvironment.safeGetChromiunVersion()));
        break;
      }
      locala.eC(Integer.valueOf(0));
      break;
      label222:
      if ("arm64-v8a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        locala.eC(Integer.valueOf(b.a.MuH));
      }
    }
  }
  
  public static void a(af paramaf)
  {
    MuB = paramaf;
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
        if (MuB == null)
        {
          AppMethodBeat.o(175650);
          return;
        }
        if (!MuC)
        {
          if ("toolsmp".equals(Mqh))
          {
            if (!gbZ()) {
              break label255;
            }
            lh(903, 106);
          }
          i = gcc();
          j = WebView.getCurWebType().ordinal() - 1;
          if ((i >= 30) && (j >= 0))
          {
            MuC = true;
            lh(903, i + 3 + j);
          }
        }
        if (paramWebView.isX5WrappedSysKernel())
        {
          if (!Mqh.equals("mm")) {
            break label272;
          }
          i = 79;
          j = 74;
          if (j != 0) {
            MuB.n(903L, j, 1L);
          }
          if (i != 0) {
            lh(903, i);
          }
        }
        if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
          MuB.n(903L, 102L, 1L);
        }
        i = gcc();
        j = WebView.getCurWebType().ordinal() - 1;
        if ((i >= 30) && (j >= 0)) {
          MuB.n(903L, i + 0 + j, 1L);
        }
        if (!"toolsmp".equals(Mqh)) {
          break label372;
        }
        if (!gbZ()) {
          break label353;
        }
        MuB.n(903L, 107L, 1L);
        AppMethodBeat.o(175650);
        continue;
        if (!gca()) {
          continue;
        }
      }
      finally {}
      label255:
      lh(903, 108);
      continue;
      label272:
      if (Mqh.equals("tools"))
      {
        i = 75;
        j = 70;
      }
      else if (Mqh.equals("toolsmp"))
      {
        i = 75;
        j = 71;
      }
      else if (Mqh.equals("appbrand"))
      {
        i = 77;
        j = 72;
      }
      else if (Mqh.equals("support"))
      {
        i = 78;
        j = 73;
        continue;
        label353:
        if (gca()) {
          MuB.n(903L, 109L, 1L);
        }
        label372:
        AppMethodBeat.o(175650);
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  public static void aE(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(197109);
    Log.i("WXWebReporter", "report idkey id = " + paramLong1 + " key = " + paramLong2 + " value = 1");
    if (MuB != null) {
      MuB.n(paramLong1, paramLong2, 1L);
    }
    AppMethodBeat.o(197109);
  }
  
  public static boolean aiC(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void aiD(int paramInt)
  {
    AppMethodBeat.i(157083);
    if (!"toolsmp".equals(Mqh))
    {
      AppMethodBeat.o(157083);
      return;
    }
    int j;
    int i;
    if (WebView.getCurWebType() == WebView.c.Mqu)
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
      if (WebView.getCurWebType() == WebView.c.Mqv)
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
  
  public static void bbr(String paramString)
  {
    if (paramString != null) {
      Mqh = paramString;
    }
  }
  
  public static void bbs(String paramString)
  {
    int j = 73;
    AppMethodBeat.i(157022);
    int i;
    if (MuB != null)
    {
      MuB.n(577L, 0L, 1L);
      if ((Mqh.equals("toolsmp")) && (paramString != null) && (bbt(paramString) == 2)) {
        MuB.n(903L, 101L, 1L);
      }
      if (!Mqh.equals("toolsmp")) {
        break label179;
      }
      if (WebView.getCurWebType() != WebView.c.Mqu) {
        break label154;
      }
      MuB.n(903L, 105L, 1L);
      if (!Muz)
      {
        if (!Mqh.equals("tools")) {
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
        Muz = true;
        lh(577, i + j);
      }
      AppMethodBeat.o(157022);
      return;
      label154:
      if (WebView.getCurWebType() != WebView.c.Mqv) {
        break;
      }
      MuB.n(903L, 104L, 1L);
      break;
      label179:
      if ((!Mqh.equals("tools")) || (paramString == null) || (bbt(paramString) != 1)) {
        break;
      }
      MuB.n(903L, 103L, 1L);
      break;
      label218:
      i = j;
      if (!Mqh.equals("appbrand"))
      {
        i = j;
        if (!Mqh.equals("support")) {
          i = -1;
        }
      }
    }
  }
  
  public static int bbt(String paramString)
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
  
  public static void bbu(String paramString)
  {
    AppMethodBeat.i(197114);
    if (MuB == null)
    {
      AppMethodBeat.o(197114);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MuB.n(1068L, 57L, 1L);
      AppMethodBeat.o(197114);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MuB.n(1071L, 57L, 1L);
      AppMethodBeat.o(197114);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MuB.n(1069L, 57L, 1L);
      AppMethodBeat.o(197114);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MuB.n(1070L, 57L, 1L);
    }
    AppMethodBeat.o(197114);
  }
  
  public static void bbv(String paramString)
  {
    AppMethodBeat.i(157079);
    if (MuB == null)
    {
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MuB.n(1068L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MuB.n(1071L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MuB.n(1069L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MuB.n(1070L, 66L, 1L);
    }
    AppMethodBeat.o(157079);
  }
  
  public static void bbw(String paramString)
  {
    AppMethodBeat.i(157080);
    if ((paramString == null) || (paramString.isEmpty()) || (MuB == null))
    {
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      MuB.n(1068L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      MuB.n(1071L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      MuB.n(1069L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      MuB.n(1070L, 67L, 1L);
    }
    AppMethodBeat.o(157080);
  }
  
  public static void bbx(String paramString)
  {
    AppMethodBeat.i(157081);
    if ((paramString == null) || (paramString.isEmpty()) || (MuB == null))
    {
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      MuB.n(1068L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      MuB.n(1071L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      MuB.n(1069L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      MuB.n(1070L, 68L, 1L);
    }
    AppMethodBeat.o(157081);
  }
  
  public static void bo(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157045);
    if (MuB != null)
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
        MuB.n(577L, paramInt, 1L);
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
  
  public static void bp(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157046);
    if (MuB != null)
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
        MuB.n(577L, paramInt, 1L);
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
  
  public static void brj()
  {
    AppMethodBeat.i(157056);
    if (MuB != null) {
      MuB.n(577L, 25L, 1L);
    }
    AppMethodBeat.o(157056);
  }
  
  public static void c(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(157034);
    af localaf;
    int j;
    int k;
    if (MuB != null)
    {
      gcd();
      MuB.n(577L, 5L, 1L);
      MuB.kvStat(15003, "");
      localaf = MuB;
      j = XWalkEnvironment.getAvailableVersion();
      k = bbt(paramString);
      paramString = sessionId;
      if (JsRuntime.gaB() != null) {
        break label94;
      }
    }
    label94:
    for (int i = 100;; i = JsRuntime.gaB().ordinal())
    {
      localaf.a(j, k, paramString, i, 1, paramInt1, (int)paramLong, paramInt2);
      AppMethodBeat.o(157034);
      return;
    }
  }
  
  public static boolean dAs()
  {
    return MuB != null;
  }
  
  public static void dc(int paramInt, String paramString)
  {
    AppMethodBeat.i(157019);
    if (MuB != null) {
      MuB.kvStat(paramInt, paramString);
    }
    AppMethodBeat.o(157019);
  }
  
  public static void dl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197110);
    if (MuB == null)
    {
      AppMethodBeat.o(197110);
      return;
    }
    if (paramBoolean) {}
    for (int i = 51; "FullScreenVideo".equals(paramString); i = 60)
    {
      MuB.n(577L, 185L, 1L);
      AppMethodBeat.o(197110);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MuB.n(1068L, i, 1L);
      AppMethodBeat.o(197110);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MuB.n(1071L, i, 1L);
      AppMethodBeat.o(197110);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MuB.n(1069L, i, 1L);
      AppMethodBeat.o(197110);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MuB.n(1070L, i, 1L);
    }
    AppMethodBeat.o(197110);
  }
  
  public static void dm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197111);
    if (MuB == null)
    {
      AppMethodBeat.o(197111);
      return;
    }
    if (paramBoolean) {}
    for (int i = 52; "FullScreenVideo".equals(paramString); i = 61)
    {
      MuB.n(577L, 186L, 1L);
      AppMethodBeat.o(197111);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MuB.n(1068L, i, 1L);
      AppMethodBeat.o(197111);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MuB.n(1071L, i, 1L);
      AppMethodBeat.o(197111);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MuB.n(1069L, i, 1L);
      AppMethodBeat.o(197111);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MuB.n(1070L, i, 1L);
    }
    AppMethodBeat.o(197111);
  }
  
  public static void dn(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197112);
    if (MuB == null)
    {
      AppMethodBeat.o(197112);
      return;
    }
    if (paramBoolean) {}
    for (int i = 54; "FullScreenVideo".equals(paramString); i = 62)
    {
      MuB.n(577L, 187L, 1L);
      AppMethodBeat.o(197112);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MuB.n(1068L, i, 1L);
      AppMethodBeat.o(197112);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MuB.n(1071L, i, 1L);
      AppMethodBeat.o(197112);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MuB.n(1069L, i, 1L);
      AppMethodBeat.o(197112);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MuB.n(1070L, i, 1L);
    }
    AppMethodBeat.o(197112);
  }
  
  public static void jdMethod_do(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197113);
    if (MuB == null)
    {
      AppMethodBeat.o(197113);
      return;
    }
    if (paramBoolean) {}
    for (int i = 55; "FullScreenVideo".equals(paramString); i = 63)
    {
      MuB.n(577L, 188L, 1L);
      AppMethodBeat.o(197113);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      MuB.n(1068L, i, 1L);
      AppMethodBeat.o(197113);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MuB.n(1071L, i, 1L);
      AppMethodBeat.o(197113);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MuB.n(1069L, i, 1L);
      AppMethodBeat.o(197113);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MuB.n(1070L, i, 1L);
    }
    AppMethodBeat.o(197113);
  }
  
  public static void dp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(197115);
    if (MuB == null)
    {
      AppMethodBeat.o(197115);
      return;
    }
    if (paramBoolean) {}
    for (int i = 59; "XFilesPPTReader".equals(paramString); i = 65)
    {
      MuB.n(1068L, i, 1L);
      AppMethodBeat.o(197115);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      MuB.n(1071L, i, 1L);
      AppMethodBeat.o(197115);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      MuB.n(1069L, i, 1L);
      AppMethodBeat.o(197115);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      MuB.n(1070L, i, 1L);
    }
    AppMethodBeat.o(197115);
  }
  
  private static boolean gbZ()
  {
    AppMethodBeat.i(157015);
    if ((MuA == WebView.c.Mqu) && (WebView.getCurWebType() != MuA))
    {
      AppMethodBeat.o(157015);
      return true;
    }
    AppMethodBeat.o(157015);
    return false;
  }
  
  public static void gcA()
  {
    AppMethodBeat.i(157064);
    if (MuB == null)
    {
      AppMethodBeat.o(157064);
      return;
    }
    MuB.n(577L, 87L, 1L);
    AppMethodBeat.o(157064);
  }
  
  public static void gcB()
  {
    AppMethodBeat.i(157066);
    if (MuB != null) {
      MuB.n(577L, 180L, 1L);
    }
    AppMethodBeat.o(157066);
  }
  
  public static void gcC()
  {
    AppMethodBeat.i(157067);
    if (MuB != null) {
      MuB.n(577L, 181L, 1L);
    }
    AppMethodBeat.o(157067);
  }
  
  public static void gcD()
  {
    AppMethodBeat.i(157068);
    if (MuB != null) {
      MuB.n(577L, 182L, 1L);
    }
    AppMethodBeat.o(157068);
  }
  
  public static void gcE()
  {
    AppMethodBeat.i(157069);
    if (MuB != null) {
      MuB.n(577L, 183L, 1L);
    }
    AppMethodBeat.o(157069);
  }
  
  public static void gcF()
  {
    AppMethodBeat.i(157070);
    if (MuB != null) {
      MuB.n(577L, 184L, 1L);
    }
    AppMethodBeat.o(157070);
  }
  
  public static void gcG()
  {
    AppMethodBeat.i(157071);
    if (MuB != null) {
      MuB.n(577L, 189L, 1L);
    }
    AppMethodBeat.o(157071);
  }
  
  public static void gcH()
  {
    AppMethodBeat.i(157072);
    if (MuB != null) {
      MuB.n(577L, 190L, 1L);
    }
    AppMethodBeat.o(157072);
  }
  
  public static void gcI()
  {
    AppMethodBeat.i(157082);
    if (MuB == null)
    {
      AppMethodBeat.o(157082);
      return;
    }
    MuB.n(577L, 88L, 1L);
    AppMethodBeat.o(157082);
  }
  
  public static void gcJ()
  {
    AppMethodBeat.i(157085);
    t(938L, 89L, 1L);
    AppMethodBeat.o(157085);
  }
  
  public static void gcK()
  {
    AppMethodBeat.i(157086);
    t(938L, 90L, 1L);
    AppMethodBeat.o(157086);
  }
  
  public static void gcL()
  {
    AppMethodBeat.i(157087);
    t(938L, 91L, 1L);
    AppMethodBeat.o(157087);
  }
  
  private static boolean gca()
  {
    AppMethodBeat.i(157016);
    if ((WebView.getCurWebType() == WebView.c.Mqu) && (WebView.getCurWebType() != MuA))
    {
      AppMethodBeat.o(157016);
      return true;
    }
    AppMethodBeat.o(157016);
    return false;
  }
  
  public static void gcb()
  {
    AppMethodBeat.i(197108);
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
      boolean bool = c.ne("report_core_ver", String.valueOf(i));
      if ((c.bbk("report_core_daily")) || (bool))
      {
        if (i > 0) {
          break label187;
        }
        aE(1367L, 251L);
      }
      label105:
      bool = c.ne("report_core_ver_predown", String.valueOf(j));
      if ((c.bbk("report_core_daily_predown")) || (bool))
      {
        if (j > 0) {
          break label203;
        }
        aE(1367L, 252L);
      }
    }
    for (;;)
    {
      if ("armeabi-v7a".equalsIgnoreCase(str2))
      {
        str1 = XWalkEnvironment.getDeviceAbi();
        if ("armeabi-v7a".equalsIgnoreCase(str1))
        {
          lh(1367, 253);
          AppMethodBeat.o(197108);
          return;
          str1 = "armeabi-v7a";
          break;
          label187:
          aE(1367L, i % 100 + 0);
          break label105;
          label203:
          aE(1367L, j % 100 + 100);
          continue;
        }
        if ("arm64-v8a".equalsIgnoreCase(str1)) {
          lh(1367, 254);
        }
      }
    }
    AppMethodBeat.o(197108);
  }
  
  private static int gcc()
  {
    AppMethodBeat.i(157023);
    int i = -1;
    if (Mqh.equals("mm")) {
      i = 30;
    }
    for (;;)
    {
      AppMethodBeat.o(157023);
      return i;
      if (Mqh.equals("tools")) {
        i = 36;
      } else if (Mqh.equals("toolsmp")) {
        i = 42;
      } else if (Mqh.equals("appbrand")) {
        i = 48;
      } else if (Mqh.equals("support")) {
        i = 54;
      }
    }
  }
  
  public static void gcd()
  {
    AppMethodBeat.i(157025);
    if (MuB != null) {
      MuB.n(577L, 1L, 1L);
    }
    AppMethodBeat.o(157025);
  }
  
  public static void gce()
  {
    AppMethodBeat.i(157027);
    if (MuB != null) {
      MuB.n(577L, 46L, 1L);
    }
    AppMethodBeat.o(157027);
  }
  
  public static void gcf()
  {
    AppMethodBeat.i(157028);
    if (MuB != null) {
      MuB.n(577L, 47L, 1L);
    }
    AppMethodBeat.o(157028);
  }
  
  public static void gcg()
  {
    AppMethodBeat.i(157030);
    if (MuB != null) {
      MuB.n(577L, 42L, 1L);
    }
    AppMethodBeat.o(157030);
  }
  
  public static void gch()
  {
    AppMethodBeat.i(157031);
    if (MuB != null) {
      MuB.n(577L, 43L, 1L);
    }
    AppMethodBeat.o(157031);
  }
  
  public static void gci()
  {
    AppMethodBeat.i(157037);
    if (MuB != null) {
      MuB.n(577L, 52L, 1L);
    }
    AppMethodBeat.o(157037);
  }
  
  public static void gcj()
  {
    AppMethodBeat.i(157038);
    if (MuB != null) {
      MuB.n(577L, 53L, 1L);
    }
    AppMethodBeat.o(157038);
  }
  
  public static void gck()
  {
    AppMethodBeat.i(157039);
    if (MuB != null) {
      MuB.n(577L, 54L, 1L);
    }
    AppMethodBeat.o(157039);
  }
  
  public static void gcl()
  {
    AppMethodBeat.i(157040);
    if (MuB != null) {
      MuB.n(577L, 55L, 1L);
    }
    AppMethodBeat.o(157040);
  }
  
  public static void gcm()
  {
    AppMethodBeat.i(157041);
    if (MuB != null) {
      MuB.n(577L, 56L, 1L);
    }
    AppMethodBeat.o(157041);
  }
  
  public static void gcn()
  {
    AppMethodBeat.i(157042);
    if (MuB != null) {
      MuB.n(577L, 57L, 1L);
    }
    AppMethodBeat.o(157042);
  }
  
  public static void gco()
  {
    AppMethodBeat.i(157043);
    if (MuB != null) {
      MuB.n(577L, 58L, 1L);
    }
    AppMethodBeat.o(157043);
  }
  
  public static void gcp()
  {
    AppMethodBeat.i(157044);
    if (MuB != null) {
      MuB.n(577L, 59L, 1L);
    }
    AppMethodBeat.o(157044);
  }
  
  public static void gcq()
  {
    AppMethodBeat.i(157047);
    if (MuB != null) {
      MuB.n(577L, 167L, 1L);
    }
    AppMethodBeat.o(157047);
  }
  
  public static void gcr()
  {
    AppMethodBeat.i(157048);
    if (MuB != null) {
      MuB.n(577L, 9L, 1L);
    }
    AppMethodBeat.o(157048);
  }
  
  public static void gcs()
  {
    AppMethodBeat.i(157050);
    if (MuB != null) {
      MuB.n(577L, 10L, 1L);
    }
    AppMethodBeat.o(157050);
  }
  
  public static void gct()
  {
    AppMethodBeat.i(157051);
    if (MuB != null) {
      MuB.n(577L, 60L, 1L);
    }
    AppMethodBeat.o(157051);
  }
  
  public static void gcu()
  {
    AppMethodBeat.i(157053);
    if (MuB != null) {
      MuB.n(577L, 20L, 1L);
    }
    AppMethodBeat.o(157053);
  }
  
  public static void gcv()
  {
    AppMethodBeat.i(157055);
    if (MuB != null) {
      MuB.n(577L, 21L, 1L);
    }
    AppMethodBeat.o(157055);
  }
  
  public static void gcw()
  {
    AppMethodBeat.i(157058);
    if (MuB != null) {
      MuB.n(577L, 26L, 1L);
    }
    AppMethodBeat.o(157058);
  }
  
  public static void gcx()
  {
    AppMethodBeat.i(157059);
    if (MuB != null) {
      MuB.n(577L, 14L, 1L);
    }
    AppMethodBeat.o(157059);
  }
  
  public static void gcy()
  {
    AppMethodBeat.i(157060);
    if (MuB != null) {
      MuB.n(577L, 15L, 1L);
    }
    AppMethodBeat.o(157060);
  }
  
  public static void gcz()
  {
    AppMethodBeat.i(157062);
    if (MuB == null)
    {
      AppMethodBeat.o(157062);
      return;
    }
    MuB.n(577L, 83L, 1L);
    AppMethodBeat.o(157062);
  }
  
  public static void h(WebView.c paramc)
  {
    MuA = paramc;
  }
  
  public static void hk(String paramString, int paramInt)
  {
    AppMethodBeat.i(157033);
    af localaf;
    int j;
    int k;
    if (MuB != null)
    {
      bbs(paramString);
      sessionId = UUID.randomUUID().toString().replace("-", "");
      MuB.n(577L, 4L, 1L);
      localaf = MuB;
      j = XWalkEnvironment.getAvailableVersion();
      k = bbt(paramString);
      paramString = sessionId;
      if (JsRuntime.gaB() != null) {
        break label95;
      }
    }
    label95:
    for (int i = 100;; i = JsRuntime.gaB().ordinal())
    {
      localaf.a(j, k, paramString, i, 0, 0, 0, paramInt);
      AppMethodBeat.o(157033);
      return;
    }
  }
  
  public static void i(WebView.c paramc)
  {
    AppMethodBeat.i(157018);
    if (MuB == null)
    {
      AppMethodBeat.o(157018);
      return;
    }
    int i;
    String str1;
    label36:
    String str3;
    String str2;
    if (paramc == WebView.c.Mqu)
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
      if (paramc == WebView.c.Mqu)
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
          MuB.n(577L, j % 50 + 100, 1L);
          XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
        }
      }
      if (str3.equals(str2))
      {
        AppMethodBeat.o(157018);
        return;
      }
      if (paramc == WebView.c.Mqu)
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
        MuB.n(577L, i, 1L);
        XWalkEnvironment.getSharedPreferences().edit().putString(str1, str3).commit();
        AppMethodBeat.o(157018);
        return;
        if (paramc == WebView.c.Mqw)
        {
          i = 97;
        }
        else
        {
          if (paramc != WebView.c.Mqv) {
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
    if (MuB == null)
    {
      AppMethodBeat.o(157052);
      return;
    }
    if (paramc == WebView.c.Mqu)
    {
      MuB.n(577L, 61L, 1L);
      lh(577, 62);
    }
    AppMethodBeat.o(157052);
  }
  
  public static void k(WebView.c paramc)
  {
    AppMethodBeat.i(157063);
    if (MuB == null)
    {
      AppMethodBeat.o(157063);
      return;
    }
    int i;
    switch (1.mFe[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157063);
      return;
    case 1: 
      i = 82;
    }
    for (;;)
    {
      MuB.n(577L, i, 1L);
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
    if (MuB == null)
    {
      AppMethodBeat.o(157065);
      return;
    }
    int i;
    switch (1.mFe[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157065);
      return;
    case 1: 
      i = 86;
    }
    for (;;)
    {
      MuB.n(577L, i, 1L);
      AppMethodBeat.o(157065);
      return;
      i = 85;
      continue;
      i = 84;
    }
  }
  
  public static void lh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157017);
    if (MuB == null)
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
    MuB.n(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString(str1, str2).commit();
    AppMethodBeat.o(157017);
  }
  
  public static void s(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(157035);
    Fi(paramLong);
    af localaf;
    int j;
    int k;
    if ((MuB != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      MuB.aU(6, 7, (int)paramLong);
      localaf = MuB;
      j = XWalkEnvironment.getAvailableVersion();
      k = bbt(paramString);
      paramString = sessionId;
      if (JsRuntime.gaB() != null) {
        break label96;
      }
    }
    label96:
    for (int i = 100;; i = JsRuntime.gaB().ordinal())
    {
      localaf.a(j, k, paramString, i, 1, 0, (int)paramLong, paramInt);
      AppMethodBeat.o(157035);
      return;
    }
  }
  
  public static void t(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(157021);
    if (MuB != null) {
      MuB.n(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(157021);
  }
  
  public static void zN(boolean paramBoolean)
  {
    AppMethodBeat.i(157084);
    if (!"toolsmp".equals(Mqh))
    {
      AppMethodBeat.o(157084);
      return;
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (WebView.getCurWebType() != WebView.c.Mqu) {
        break label66;
      }
    }
    for (int j = 180;; j = 190)
    {
      t(903L, i + j, 1L);
      AppMethodBeat.o(157084);
      return;
      i = 1;
      break;
      label66:
      if (WebView.getCurWebType() != WebView.c.Mqv) {
        break label82;
      }
    }
    label82:
    AppMethodBeat.o(157084);
  }
  
  public static final class a
  {
    int MuD;
    StringBuilder bDt;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(175648);
      this.bDt = new StringBuilder();
      this.MuD = 0;
      this.MuD = paramInt;
      AppMethodBeat.o(175648);
    }
    
    public final a eC(Object paramObject)
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
    public static int MuE = 1;
    public static int MuF = 2;
    public static int MuG = 1;
    public static int MuH = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.g
 * JD-Core Version:    0.7.0.1
 */