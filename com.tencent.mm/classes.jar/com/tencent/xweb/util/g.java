package com.tencent.xweb.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ad;
import com.tencent.xweb.internal.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class g
{
  public static String INp = "";
  private static boolean IRD = false;
  static WebView.c IRE = WebView.c.INB;
  static ad IRF = null;
  static boolean IRG = false;
  public static String sessionId = "";
  
  public static void a(WebView.c paramc, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(175651);
    a locala;
    if (c.aPn("kv_" + b.a.ID + paramc.toString() + "_" + paramInt))
    {
      locala = new a(b.a.ID);
      locala.ex(Integer.valueOf(paramInt));
      if (paramc != WebView.c.INC) {
        break label149;
      }
      locala.ex(Integer.valueOf(XWalkEnvironment.getInstalledNewstVersionForCurAbi()));
      locala.ex(Integer.valueOf(200502));
      if (!"armeabi-v7a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        break label222;
      }
      locala.ex(Integer.valueOf(b.a.IRK));
    }
    for (;;)
    {
      for (;;)
      {
        locala.ex(Integer.valueOf(paramc.ordinal()));
        cR(locala.IRH, locala.bvd.toString());
        AppMethodBeat.o(175651);
        return;
        label149:
        if (paramc == WebView.c.IND) {
          try
          {
            paramInt = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
            locala.ex(Integer.valueOf(paramInt));
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
      if (paramc == WebView.c.INE)
      {
        locala.ex(Integer.valueOf(XWalkEnvironment.safeGetChromiunVersion()));
        break;
      }
      locala.ex(Integer.valueOf(0));
      break;
      label222:
      if ("arm64-v8a".equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi())) {
        locala.ex(Integer.valueOf(b.a.IRL));
      }
    }
  }
  
  public static void a(ad paramad)
  {
    IRF = paramad;
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
        if (IRF == null)
        {
          AppMethodBeat.o(175650);
          return;
        }
        if (!IRG)
        {
          if ("toolsmp".equals(INp))
          {
            if (!fsb()) {
              break label255;
            }
            kC(903, 106);
          }
          i = fse();
          j = WebView.getCurWebType().ordinal() - 1;
          if ((i >= 30) && (j >= 0))
          {
            IRG = true;
            kC(903, i + 3 + j);
          }
        }
        if (paramWebView.isX5WrappedSysKernel())
        {
          if (!INp.equals("mm")) {
            break label272;
          }
          i = 79;
          j = 74;
          if (j != 0) {
            IRF.m(903L, j, 1L);
          }
          if (i != 0) {
            kC(903, i);
          }
        }
        if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
          IRF.m(903L, 102L, 1L);
        }
        i = fse();
        j = WebView.getCurWebType().ordinal() - 1;
        if ((i >= 30) && (j >= 0)) {
          IRF.m(903L, i + 0 + j, 1L);
        }
        if (!"toolsmp".equals(INp)) {
          break label371;
        }
        if (!fsb()) {
          break label352;
        }
        IRF.m(903L, 107L, 1L);
        AppMethodBeat.o(175650);
        continue;
        if (!fsc()) {
          continue;
        }
      }
      finally {}
      label255:
      kC(903, 108);
      continue;
      label272:
      if (INp.equals("tools"))
      {
        i = 75;
        j = 70;
      }
      else if (INp.equals("toolsmp"))
      {
        i = 75;
        j = 71;
      }
      else if (INp.equals("appbrand"))
      {
        i = 77;
        j = 72;
      }
      else if (INp.equals("support"))
      {
        i = 78;
        j = 73;
        continue;
        label352:
        if (fsc()) {
          IRF.m(903L, 109L, 1L);
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
  
  public static void aPA(String paramString)
  {
    AppMethodBeat.i(157080);
    if ((paramString == null) || (paramString.isEmpty()) || (IRF == null))
    {
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      IRF.m(1068L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      IRF.m(1071L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      IRF.m(1069L, 67L, 1L);
      AppMethodBeat.o(157080);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      IRF.m(1070L, 67L, 1L);
    }
    AppMethodBeat.o(157080);
  }
  
  public static void aPB(String paramString)
  {
    AppMethodBeat.i(157081);
    if ((paramString == null) || (paramString.isEmpty()) || (IRF == null))
    {
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("ppt")) || (paramString.equalsIgnoreCase("pptx")))
    {
      IRF.m(1068L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if (paramString.equalsIgnoreCase("pdf"))
    {
      IRF.m(1071L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("doc")) || (paramString.equalsIgnoreCase("docx")))
    {
      IRF.m(1069L, 68L, 1L);
      AppMethodBeat.o(157081);
      return;
    }
    if ((paramString.equalsIgnoreCase("xls")) || (paramString.equalsIgnoreCase("xlsx"))) {
      IRF.m(1070L, 68L, 1L);
    }
    AppMethodBeat.o(157081);
  }
  
  public static void aPv(String paramString)
  {
    if (paramString != null) {
      INp = paramString;
    }
  }
  
  public static void aPw(String paramString)
  {
    int j = 73;
    AppMethodBeat.i(157022);
    int i;
    if (IRF != null)
    {
      IRF.m(577L, 0L, 1L);
      if ((INp.equals("toolsmp")) && (paramString != null) && (aPx(paramString) == 2)) {
        IRF.m(903L, 101L, 1L);
      }
      if (!INp.equals("toolsmp")) {
        break label179;
      }
      if (WebView.getCurWebType() != WebView.c.INC) {
        break label154;
      }
      IRF.m(903L, 105L, 1L);
      if (!IRD)
      {
        if (!INp.equals("tools")) {
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
        IRD = true;
        kC(577, i + j);
      }
      AppMethodBeat.o(157022);
      return;
      label154:
      if (WebView.getCurWebType() != WebView.c.IND) {
        break;
      }
      IRF.m(903L, 104L, 1L);
      break;
      label179:
      if ((!INp.equals("tools")) || (paramString == null) || (aPx(paramString) != 1)) {
        break;
      }
      IRF.m(903L, 103L, 1L);
      break;
      label218:
      i = j;
      if (!INp.equals("appbrand"))
      {
        i = j;
        if (!INp.equals("support")) {
          i = -1;
        }
      }
    }
  }
  
  public static int aPx(String paramString)
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
  
  public static void aPy(String paramString)
  {
    AppMethodBeat.i(195188);
    if (IRF == null)
    {
      AppMethodBeat.o(195188);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      IRF.m(1068L, 57L, 1L);
      AppMethodBeat.o(195188);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      IRF.m(1071L, 57L, 1L);
      AppMethodBeat.o(195188);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      IRF.m(1069L, 57L, 1L);
      AppMethodBeat.o(195188);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      IRF.m(1070L, 57L, 1L);
    }
    AppMethodBeat.o(195188);
  }
  
  public static void aPz(String paramString)
  {
    AppMethodBeat.i(157079);
    if (IRF == null)
    {
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      IRF.m(1068L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      IRF.m(1071L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      IRF.m(1069L, 66L, 1L);
      AppMethodBeat.o(157079);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      IRF.m(1070L, 66L, 1L);
    }
    AppMethodBeat.o(157079);
  }
  
  public static boolean ade(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void adf(int paramInt)
  {
    AppMethodBeat.i(157083);
    if (!"toolsmp".equals(INp))
    {
      AppMethodBeat.o(157083);
      return;
    }
    int j;
    int i;
    if (WebView.getCurWebType() == WebView.c.INC)
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
      if (WebView.getCurWebType() == WebView.c.IND)
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
    AppMethodBeat.i(195183);
    Log.i("WXWebReporter", "report idkey id = " + paramLong1 + " key = " + paramLong2 + " value = 1");
    if (IRF != null) {
      IRF.m(paramLong1, paramLong2, 1L);
    }
    AppMethodBeat.o(195183);
  }
  
  public static void b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(157034);
    ad localad;
    int j;
    int k;
    if (IRF != null)
    {
      fsf();
      IRF.m(577L, 5L, 1L);
      IRF.kvStat(15003, "");
      localad = IRF;
      j = XWalkEnvironment.getAvailableVersion();
      k = aPx(paramString);
      paramString = sessionId;
      if (JsRuntime.fqF() != null) {
        break label94;
      }
    }
    label94:
    for (int i = 100;; i = JsRuntime.fqF().ordinal())
    {
      localad.a(j, k, paramString, i, 1, paramInt1, (int)paramLong, paramInt2);
      AppMethodBeat.o(157034);
      return;
    }
  }
  
  public static void bb(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157045);
    if (IRF != null)
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
        IRF.m(577L, paramInt, 1L);
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
  
  public static void bc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(157046);
    if (IRF != null)
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
        IRF.m(577L, paramInt, 1L);
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
  
  public static void bgD()
  {
    AppMethodBeat.i(157056);
    if (IRF != null) {
      IRF.m(577L, 25L, 1L);
    }
    AppMethodBeat.o(157056);
  }
  
  public static void cR(int paramInt, String paramString)
  {
    AppMethodBeat.i(157019);
    if (IRF != null) {
      IRF.kvStat(paramInt, paramString);
    }
    AppMethodBeat.o(157019);
  }
  
  public static void db(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195184);
    if (IRF == null)
    {
      AppMethodBeat.o(195184);
      return;
    }
    if (paramBoolean) {}
    for (int i = 51; "FullScreenVideo".equals(paramString); i = 60)
    {
      IRF.m(577L, 185L, 1L);
      AppMethodBeat.o(195184);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      IRF.m(1068L, i, 1L);
      AppMethodBeat.o(195184);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      IRF.m(1071L, i, 1L);
      AppMethodBeat.o(195184);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      IRF.m(1069L, i, 1L);
      AppMethodBeat.o(195184);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      IRF.m(1070L, i, 1L);
    }
    AppMethodBeat.o(195184);
  }
  
  public static void dc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195185);
    if (IRF == null)
    {
      AppMethodBeat.o(195185);
      return;
    }
    if (paramBoolean) {}
    for (int i = 52; "FullScreenVideo".equals(paramString); i = 61)
    {
      IRF.m(577L, 186L, 1L);
      AppMethodBeat.o(195185);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      IRF.m(1068L, i, 1L);
      AppMethodBeat.o(195185);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      IRF.m(1071L, i, 1L);
      AppMethodBeat.o(195185);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      IRF.m(1069L, i, 1L);
      AppMethodBeat.o(195185);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      IRF.m(1070L, i, 1L);
    }
    AppMethodBeat.o(195185);
  }
  
  public static boolean dch()
  {
    return IRF != null;
  }
  
  public static void dd(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195186);
    if (IRF == null)
    {
      AppMethodBeat.o(195186);
      return;
    }
    if (paramBoolean) {}
    for (int i = 54; "FullScreenVideo".equals(paramString); i = 62)
    {
      IRF.m(577L, 187L, 1L);
      AppMethodBeat.o(195186);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      IRF.m(1068L, i, 1L);
      AppMethodBeat.o(195186);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      IRF.m(1071L, i, 1L);
      AppMethodBeat.o(195186);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      IRF.m(1069L, i, 1L);
      AppMethodBeat.o(195186);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      IRF.m(1070L, i, 1L);
    }
    AppMethodBeat.o(195186);
  }
  
  public static void de(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195187);
    if (IRF == null)
    {
      AppMethodBeat.o(195187);
      return;
    }
    if (paramBoolean) {}
    for (int i = 55; "FullScreenVideo".equals(paramString); i = 63)
    {
      IRF.m(577L, 188L, 1L);
      AppMethodBeat.o(195187);
      return;
    }
    if ("XFilesPPTReader".equals(paramString))
    {
      IRF.m(1068L, i, 1L);
      AppMethodBeat.o(195187);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      IRF.m(1071L, i, 1L);
      AppMethodBeat.o(195187);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      IRF.m(1069L, i, 1L);
      AppMethodBeat.o(195187);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      IRF.m(1070L, i, 1L);
    }
    AppMethodBeat.o(195187);
  }
  
  public static void df(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(195189);
    if (IRF == null)
    {
      AppMethodBeat.o(195189);
      return;
    }
    if (paramBoolean) {}
    for (int i = 59; "XFilesPPTReader".equals(paramString); i = 65)
    {
      IRF.m(1068L, i, 1L);
      AppMethodBeat.o(195189);
      return;
    }
    if ("XFilesPDFReader".equals(paramString))
    {
      IRF.m(1071L, i, 1L);
      AppMethodBeat.o(195189);
      return;
    }
    if ("XFilesWordReader".equals(paramString))
    {
      IRF.m(1069L, i, 1L);
      AppMethodBeat.o(195189);
      return;
    }
    if ("XFilesExcelReader".equals(paramString)) {
      IRF.m(1070L, i, 1L);
    }
    AppMethodBeat.o(195189);
  }
  
  public static void fsA()
  {
    AppMethodBeat.i(157060);
    if (IRF != null) {
      IRF.m(577L, 15L, 1L);
    }
    AppMethodBeat.o(157060);
  }
  
  public static void fsB()
  {
    AppMethodBeat.i(157062);
    if (IRF == null)
    {
      AppMethodBeat.o(157062);
      return;
    }
    IRF.m(577L, 83L, 1L);
    AppMethodBeat.o(157062);
  }
  
  public static void fsC()
  {
    AppMethodBeat.i(157064);
    if (IRF == null)
    {
      AppMethodBeat.o(157064);
      return;
    }
    IRF.m(577L, 87L, 1L);
    AppMethodBeat.o(157064);
  }
  
  public static void fsD()
  {
    AppMethodBeat.i(157066);
    if (IRF != null) {
      IRF.m(577L, 180L, 1L);
    }
    AppMethodBeat.o(157066);
  }
  
  public static void fsE()
  {
    AppMethodBeat.i(157067);
    if (IRF != null) {
      IRF.m(577L, 181L, 1L);
    }
    AppMethodBeat.o(157067);
  }
  
  public static void fsF()
  {
    AppMethodBeat.i(157068);
    if (IRF != null) {
      IRF.m(577L, 182L, 1L);
    }
    AppMethodBeat.o(157068);
  }
  
  public static void fsG()
  {
    AppMethodBeat.i(157069);
    if (IRF != null) {
      IRF.m(577L, 183L, 1L);
    }
    AppMethodBeat.o(157069);
  }
  
  public static void fsH()
  {
    AppMethodBeat.i(157070);
    if (IRF != null) {
      IRF.m(577L, 184L, 1L);
    }
    AppMethodBeat.o(157070);
  }
  
  public static void fsI()
  {
    AppMethodBeat.i(157071);
    if (IRF != null) {
      IRF.m(577L, 189L, 1L);
    }
    AppMethodBeat.o(157071);
  }
  
  public static void fsJ()
  {
    AppMethodBeat.i(157072);
    if (IRF != null) {
      IRF.m(577L, 190L, 1L);
    }
    AppMethodBeat.o(157072);
  }
  
  public static void fsK()
  {
    AppMethodBeat.i(157082);
    if (IRF == null)
    {
      AppMethodBeat.o(157082);
      return;
    }
    IRF.m(577L, 88L, 1L);
    AppMethodBeat.o(157082);
  }
  
  public static void fsL()
  {
    AppMethodBeat.i(157085);
    r(938L, 89L, 1L);
    AppMethodBeat.o(157085);
  }
  
  public static void fsM()
  {
    AppMethodBeat.i(157086);
    r(938L, 90L, 1L);
    AppMethodBeat.o(157086);
  }
  
  public static void fsN()
  {
    AppMethodBeat.i(157087);
    r(938L, 91L, 1L);
    AppMethodBeat.o(157087);
  }
  
  private static boolean fsb()
  {
    AppMethodBeat.i(157015);
    if ((IRE == WebView.c.INC) && (WebView.getCurWebType() != IRE))
    {
      AppMethodBeat.o(157015);
      return true;
    }
    AppMethodBeat.o(157015);
    return false;
  }
  
  private static boolean fsc()
  {
    AppMethodBeat.i(157016);
    if ((WebView.getCurWebType() == WebView.c.INC) && (WebView.getCurWebType() != IRE))
    {
      AppMethodBeat.o(157016);
      return true;
    }
    AppMethodBeat.o(157016);
    return false;
  }
  
  public static void fsd()
  {
    AppMethodBeat.i(195182);
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
      boolean bool = c.mf("report_core_ver", String.valueOf(i));
      if ((c.aPn("report_core_daily")) || (bool))
      {
        if (i > 0) {
          break label187;
        }
        az(1367L, 251L);
      }
      label105:
      bool = c.mf("report_core_ver_predown", String.valueOf(j));
      if ((c.aPn("report_core_daily_predown")) || (bool))
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
          kC(1367, 253);
          AppMethodBeat.o(195182);
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
          kC(1367, 254);
        }
      }
    }
    AppMethodBeat.o(195182);
  }
  
  private static int fse()
  {
    AppMethodBeat.i(157023);
    int i = -1;
    if (INp.equals("mm")) {
      i = 30;
    }
    for (;;)
    {
      AppMethodBeat.o(157023);
      return i;
      if (INp.equals("tools")) {
        i = 36;
      } else if (INp.equals("toolsmp")) {
        i = 42;
      } else if (INp.equals("appbrand")) {
        i = 48;
      } else if (INp.equals("support")) {
        i = 54;
      }
    }
  }
  
  public static void fsf()
  {
    AppMethodBeat.i(157025);
    if (IRF != null) {
      IRF.m(577L, 1L, 1L);
    }
    AppMethodBeat.o(157025);
  }
  
  public static void fsg()
  {
    AppMethodBeat.i(157027);
    if (IRF != null) {
      IRF.m(577L, 46L, 1L);
    }
    AppMethodBeat.o(157027);
  }
  
  public static void fsh()
  {
    AppMethodBeat.i(157028);
    if (IRF != null) {
      IRF.m(577L, 47L, 1L);
    }
    AppMethodBeat.o(157028);
  }
  
  public static void fsi()
  {
    AppMethodBeat.i(157030);
    if (IRF != null) {
      IRF.m(577L, 42L, 1L);
    }
    AppMethodBeat.o(157030);
  }
  
  public static void fsj()
  {
    AppMethodBeat.i(157031);
    if (IRF != null) {
      IRF.m(577L, 43L, 1L);
    }
    AppMethodBeat.o(157031);
  }
  
  public static void fsk()
  {
    AppMethodBeat.i(157037);
    if (IRF != null) {
      IRF.m(577L, 52L, 1L);
    }
    AppMethodBeat.o(157037);
  }
  
  public static void fsl()
  {
    AppMethodBeat.i(157038);
    if (IRF != null) {
      IRF.m(577L, 53L, 1L);
    }
    AppMethodBeat.o(157038);
  }
  
  public static void fsm()
  {
    AppMethodBeat.i(157039);
    if (IRF != null) {
      IRF.m(577L, 54L, 1L);
    }
    AppMethodBeat.o(157039);
  }
  
  public static void fsn()
  {
    AppMethodBeat.i(157040);
    if (IRF != null) {
      IRF.m(577L, 55L, 1L);
    }
    AppMethodBeat.o(157040);
  }
  
  public static void fso()
  {
    AppMethodBeat.i(157041);
    if (IRF != null) {
      IRF.m(577L, 56L, 1L);
    }
    AppMethodBeat.o(157041);
  }
  
  public static void fsp()
  {
    AppMethodBeat.i(157042);
    if (IRF != null) {
      IRF.m(577L, 57L, 1L);
    }
    AppMethodBeat.o(157042);
  }
  
  public static void fsq()
  {
    AppMethodBeat.i(157043);
    if (IRF != null) {
      IRF.m(577L, 58L, 1L);
    }
    AppMethodBeat.o(157043);
  }
  
  public static void fsr()
  {
    AppMethodBeat.i(157044);
    if (IRF != null) {
      IRF.m(577L, 59L, 1L);
    }
    AppMethodBeat.o(157044);
  }
  
  public static void fss()
  {
    AppMethodBeat.i(157047);
    if (IRF != null) {
      IRF.m(577L, 167L, 1L);
    }
    AppMethodBeat.o(157047);
  }
  
  public static void fst()
  {
    AppMethodBeat.i(157048);
    if (IRF != null) {
      IRF.m(577L, 9L, 1L);
    }
    AppMethodBeat.o(157048);
  }
  
  public static void fsu()
  {
    AppMethodBeat.i(157050);
    if (IRF != null) {
      IRF.m(577L, 10L, 1L);
    }
    AppMethodBeat.o(157050);
  }
  
  public static void fsv()
  {
    AppMethodBeat.i(157051);
    if (IRF != null) {
      IRF.m(577L, 60L, 1L);
    }
    AppMethodBeat.o(157051);
  }
  
  public static void fsw()
  {
    AppMethodBeat.i(157053);
    if (IRF != null) {
      IRF.m(577L, 20L, 1L);
    }
    AppMethodBeat.o(157053);
  }
  
  public static void fsx()
  {
    AppMethodBeat.i(157055);
    if (IRF != null) {
      IRF.m(577L, 21L, 1L);
    }
    AppMethodBeat.o(157055);
  }
  
  public static void fsy()
  {
    AppMethodBeat.i(157058);
    if (IRF != null) {
      IRF.m(577L, 26L, 1L);
    }
    AppMethodBeat.o(157058);
  }
  
  public static void fsz()
  {
    AppMethodBeat.i(157059);
    if (IRF != null) {
      IRF.m(577L, 14L, 1L);
    }
    AppMethodBeat.o(157059);
  }
  
  public static void gF(String paramString, int paramInt)
  {
    AppMethodBeat.i(157033);
    ad localad;
    int j;
    int k;
    if (IRF != null)
    {
      aPw(paramString);
      sessionId = UUID.randomUUID().toString().replace("-", "");
      IRF.m(577L, 4L, 1L);
      localad = IRF;
      j = XWalkEnvironment.getAvailableVersion();
      k = aPx(paramString);
      paramString = sessionId;
      if (JsRuntime.fqF() != null) {
        break label95;
      }
    }
    label95:
    for (int i = 100;; i = JsRuntime.fqF().ordinal())
    {
      localad.a(j, k, paramString, i, 0, 0, 0, paramInt);
      AppMethodBeat.o(157033);
      return;
    }
  }
  
  public static void h(WebView.c paramc)
  {
    IRE = paramc;
  }
  
  public static void i(WebView.c paramc)
  {
    AppMethodBeat.i(157018);
    if (IRF == null)
    {
      AppMethodBeat.o(157018);
      return;
    }
    int i;
    String str1;
    label36:
    String str3;
    String str2;
    if (paramc == WebView.c.INC)
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
      if (paramc == WebView.c.INC)
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
          IRF.m(577L, j % 50 + 100, 1L);
          XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
        }
      }
      if (str3.equals(str2))
      {
        AppMethodBeat.o(157018);
        return;
      }
      if (paramc == WebView.c.INC)
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
        IRF.m(577L, i, 1L);
        XWalkEnvironment.getSharedPreferences().edit().putString(str1, str3).commit();
        AppMethodBeat.o(157018);
        return;
        if (paramc == WebView.c.INE)
        {
          i = 97;
        }
        else
        {
          if (paramc != WebView.c.IND) {
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
    if (IRF == null)
    {
      AppMethodBeat.o(157052);
      return;
    }
    if (paramc == WebView.c.INC)
    {
      IRF.m(577L, 61L, 1L);
      kC(577, 62);
    }
    AppMethodBeat.o(157052);
  }
  
  public static void k(WebView.c paramc)
  {
    AppMethodBeat.i(157063);
    if (IRF == null)
    {
      AppMethodBeat.o(157063);
      return;
    }
    int i;
    switch (g.1.lCQ[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157063);
      return;
    case 1: 
      i = 82;
    }
    for (;;)
    {
      IRF.m(577L, i, 1L);
      AppMethodBeat.o(157063);
      return;
      i = 81;
      continue;
      i = 80;
    }
  }
  
  public static void kC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(157017);
    if (IRF == null)
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
    IRF.m(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString(str1, str2).commit();
    AppMethodBeat.o(157017);
  }
  
  public static void l(WebView.c paramc)
  {
    AppMethodBeat.i(157065);
    if (IRF == null)
    {
      AppMethodBeat.o(157065);
      return;
    }
    int i;
    switch (g.1.lCQ[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(157065);
      return;
    case 1: 
      i = 86;
    }
    for (;;)
    {
      IRF.m(577L, i, 1L);
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
    xt(paramLong);
    ad localad;
    int j;
    int k;
    if ((IRF != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      IRF.aR(6, 7, (int)paramLong);
      localad = IRF;
      j = XWalkEnvironment.getAvailableVersion();
      k = aPx(paramString);
      paramString = sessionId;
      if (JsRuntime.fqF() != null) {
        break label96;
      }
    }
    label96:
    for (int i = 100;; i = JsRuntime.fqF().ordinal())
    {
      localad.a(j, k, paramString, i, 1, 0, (int)paramLong, paramInt);
      AppMethodBeat.o(157035);
      return;
    }
  }
  
  public static void r(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(157021);
    if (IRF != null) {
      IRF.m(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(157021);
  }
  
  public static void xI(boolean paramBoolean)
  {
    AppMethodBeat.i(157084);
    if (!"toolsmp".equals(INp))
    {
      AppMethodBeat.o(157084);
      return;
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (WebView.getCurWebType() != WebView.c.INC) {
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
      if (WebView.getCurWebType() != WebView.c.IND) {
        break label82;
      }
    }
    label82:
    AppMethodBeat.o(157084);
  }
  
  public static void xs(long paramLong)
  {
    AppMethodBeat.i(157020);
    if (IRF != null) {
      IRF.m(577L, paramLong, 1L);
    }
    AppMethodBeat.o(157020);
  }
  
  public static void xt(long paramLong)
  {
    AppMethodBeat.i(157026);
    if ((IRF != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      IRF.aR(2, 3, (int)paramLong);
    }
    AppMethodBeat.o(157026);
  }
  
  public static void xu(long paramLong)
  {
    AppMethodBeat.i(157029);
    if ((IRF != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      IRF.aR(48, 49, (int)paramLong);
    }
    AppMethodBeat.o(157029);
  }
  
  public static void xv(long paramLong)
  {
    AppMethodBeat.i(157032);
    if ((IRF != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      IRF.aR(44, 45, (int)paramLong);
    }
    AppMethodBeat.o(157032);
  }
  
  public static void xw(long paramLong)
  {
    AppMethodBeat.i(157049);
    if ((IRF != null) && (IRF != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      IRF.aR(11, 12, (int)paramLong);
    }
    AppMethodBeat.o(157049);
  }
  
  public static void xx(long paramLong)
  {
    AppMethodBeat.i(157054);
    if ((IRF != null) && (IRF != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      IRF.aR(22, 23, (int)paramLong);
    }
    AppMethodBeat.o(157054);
  }
  
  public static void xy(long paramLong)
  {
    AppMethodBeat.i(157057);
    if ((IRF != null) && (IRF != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      IRF.aR(27, 28, (int)paramLong);
    }
    AppMethodBeat.o(157057);
  }
  
  public static void xz(long paramLong)
  {
    AppMethodBeat.i(157061);
    if ((IRF != null) && (IRF != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      IRF.aR(16, 17, (int)paramLong);
    }
    AppMethodBeat.o(157061);
  }
  
  public static final class a
  {
    int IRH;
    StringBuilder bvd;
    
    public a(int paramInt)
    {
      AppMethodBeat.i(175648);
      this.bvd = new StringBuilder();
      this.IRH = 0;
      this.IRH = paramInt;
      AppMethodBeat.o(175648);
    }
    
    public final a ex(Object paramObject)
    {
      AppMethodBeat.i(175649);
      if (this.bvd.length() > 0) {
        this.bvd.append(",");
      }
      this.bvd.append(paramObject.toString());
      AppMethodBeat.o(175649);
      return this;
    }
  }
  
  public static final class b$a
  {
    public static int ID = 19307;
    public static int IRI = 1;
    public static int IRJ = 2;
    public static int IRK = 1;
    public static int IRL = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.util.g
 * JD-Core Version:    0.7.0.1
 */