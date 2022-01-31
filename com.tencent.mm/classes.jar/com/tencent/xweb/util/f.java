package com.tencent.xweb.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;
import com.tencent.xweb.k.a;
import com.tencent.xweb.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

public final class f
{
  public static String BEe = "";
  private static boolean BHJ = false;
  static WebView.d BHK = WebView.d.BEp;
  static y BHL = null;
  static boolean BHM = false;
  public static String cpW = "";
  
  public static void TA(int paramInt)
  {
    AppMethodBeat.i(4087);
    if (!"toolsmp".equals(BEe))
    {
      AppMethodBeat.o(4087);
      return;
    }
    int j;
    int i;
    if (WebView.getCurWebType() == WebView.d.BEq)
    {
      j = 200;
      if (paramInt >= 0) {
        break label84;
      }
      i = 3;
    }
    for (;;)
    {
      m(903L, j + i, 1L);
      AppMethodBeat.o(4087);
      return;
      if (WebView.getCurWebType() == WebView.d.BEr)
      {
        j = 220;
        break;
      }
      AppMethodBeat.o(4087);
      return;
      label84:
      i = paramInt;
      if (paramInt > 9) {
        i = 4;
      }
    }
  }
  
  public static boolean Tz(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void a(y paramy)
  {
    BHL = paramy;
  }
  
  public static void aGV()
  {
    AppMethodBeat.i(4065);
    if (BHL != null) {
      BHL.j(577L, 25L, 1L);
    }
    AppMethodBeat.o(4065);
  }
  
  public static void aN(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4054);
    if (BHL != null)
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
        BHL.j(577L, paramInt, 1L);
      }
      AppMethodBeat.o(4054);
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
  
  public static void aO(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(4055);
    if (BHL != null)
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
        BHL.j(577L, paramInt, 1L);
      }
      AppMethodBeat.o(4055);
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
  
  public static void ayh(String paramString)
  {
    if (paramString != null) {
      BEe = paramString;
    }
  }
  
  public static void ayi(String paramString)
  {
    int j = 73;
    AppMethodBeat.i(4031);
    int i;
    if (BHL != null)
    {
      BHL.j(577L, 0L, 1L);
      if ((BEe.equals("toolsmp")) && (paramString != null) && (ayk(paramString) == 2)) {
        BHL.j(903L, 101L, 1L);
      }
      if (!BEe.equals("toolsmp")) {
        break label179;
      }
      if (WebView.getCurWebType() != WebView.d.BEq) {
        break label154;
      }
      BHL.j(903L, 105L, 1L);
      if (!BHJ)
      {
        if (!BEe.equals("tools")) {
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
        BHJ = true;
        iB(577, i + j);
      }
      AppMethodBeat.o(4031);
      return;
      label154:
      if (WebView.getCurWebType() != WebView.d.BEr) {
        break;
      }
      BHL.j(903L, 104L, 1L);
      break;
      label179:
      if ((!BEe.equals("tools")) || (paramString == null) || (ayk(paramString) != 1)) {
        break;
      }
      BHL.j(903L, 103L, 1L);
      break;
      label218:
      i = j;
      if (!BEe.equals("appbrand"))
      {
        i = j;
        if (!BEe.equals("support")) {
          i = -1;
        }
      }
    }
  }
  
  public static void ayj(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(4033);
        if (BHL == null)
        {
          AppMethodBeat.o(4033);
          return;
        }
        if (!BHM)
        {
          if ("toolsmp".equals(BEe))
          {
            if (!dYZ()) {
              break label207;
            }
            iB(903, 106);
          }
          i = dZb();
          j = WebView.getCurWebType().ordinal() - 1;
          if ((i >= 30) && (j >= 0))
          {
            BHM = true;
            iB(903, i + 3 + j);
          }
        }
        if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
          BHL.j(903L, 102L, 1L);
        }
        int i = dZb();
        int j = WebView.getCurWebType().ordinal() - 1;
        if ((i >= 30) && (j >= 0)) {
          BHL.j(903L, i + 0 + j, 1L);
        }
        if (!"toolsmp".equals(BEe)) {
          break label243;
        }
        if (!dYZ()) {
          break label224;
        }
        BHL.j(903L, 107L, 1L);
        AppMethodBeat.o(4033);
        continue;
        if (!dZa()) {
          continue;
        }
      }
      finally {}
      label207:
      iB(903, 108);
      continue;
      label224:
      if (dZa()) {
        BHL.j(903L, 109L, 1L);
      }
      label243:
      AppMethodBeat.o(4033);
    }
  }
  
  public static int ayk(String paramString)
  {
    AppMethodBeat.i(4045);
    if (paramString.startsWith("https://servicewechat.com/"))
    {
      AppMethodBeat.o(4045);
      return 0;
    }
    if ((paramString.startsWith("http://mp.weixin.qq.com/")) || (paramString.startsWith("https://mp.weixin.qq.com/")) || (paramString.startsWith("https://servicewechat.com/preload/")) || (paramString.startsWith("http://mp.weixinbridge.com/")))
    {
      AppMethodBeat.o(4045);
      return 1;
    }
    AppMethodBeat.o(4045);
    return 2;
  }
  
  public static void ayl(String paramString)
  {
    AppMethodBeat.i(151450);
    if ((paramString == null) || (paramString.isEmpty()) || (BHL == null))
    {
      AppMethodBeat.o(151450);
      return;
    }
    if ((paramString.endsWith("ppt")) || (paramString.endsWith("pptx"))) {
      BHL.j(1068L, 67L, 1L);
    }
    AppMethodBeat.o(151450);
  }
  
  public static void aym(String paramString)
  {
    AppMethodBeat.i(151451);
    if ((paramString == null) || (paramString.isEmpty()) || (BHL == null))
    {
      AppMethodBeat.o(151451);
      return;
    }
    if ((paramString.endsWith("ppt")) || (paramString.endsWith("pptx"))) {
      BHL.j(1068L, 68L, 1L);
    }
    AppMethodBeat.o(151451);
  }
  
  public static void b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(4043);
    y localy;
    int j;
    int k;
    if (BHL != null)
    {
      dZc();
      BHL.j(577L, 5L, 1L);
      BHL.kvStat(15003, "");
      localy = BHL;
      j = XWalkEnvironment.getAvailableVersion();
      k = ayk(paramString);
      paramString = cpW;
      if (k.dYj() != null) {
        break label94;
      }
    }
    label94:
    for (int i = 100;; i = k.dYj().ordinal())
    {
      localy.a(j, k, paramString, i, 1, paramInt1, (int)paramLong, paramInt2);
      AppMethodBeat.o(4043);
      return;
    }
  }
  
  public static void bW(int paramInt, String paramString)
  {
    AppMethodBeat.i(4028);
    if (BHL != null) {
      BHL.kvStat(paramInt, paramString);
    }
    AppMethodBeat.o(4028);
  }
  
  public static boolean cbQ()
  {
    return BHL != null;
  }
  
  private static boolean dYZ()
  {
    AppMethodBeat.i(4024);
    if ((BHK == WebView.d.BEq) && (WebView.getCurWebType() != BHK))
    {
      AppMethodBeat.o(4024);
      return true;
    }
    AppMethodBeat.o(4024);
    return false;
  }
  
  public static void dZA()
  {
    AppMethodBeat.i(4075);
    if (BHL != null) {
      BHL.j(577L, 180L, 1L);
    }
    AppMethodBeat.o(4075);
  }
  
  public static void dZB()
  {
    AppMethodBeat.i(4076);
    if (BHL != null) {
      BHL.j(577L, 181L, 1L);
    }
    AppMethodBeat.o(4076);
  }
  
  public static void dZC()
  {
    AppMethodBeat.i(4077);
    if (BHL != null) {
      BHL.j(577L, 182L, 1L);
    }
    AppMethodBeat.o(4077);
  }
  
  public static void dZD()
  {
    AppMethodBeat.i(4078);
    if (BHL != null) {
      BHL.j(577L, 183L, 1L);
    }
    AppMethodBeat.o(4078);
  }
  
  public static void dZE()
  {
    AppMethodBeat.i(4079);
    if (BHL != null) {
      BHL.j(577L, 184L, 1L);
    }
    AppMethodBeat.o(4079);
  }
  
  public static void dZF()
  {
    AppMethodBeat.i(4080);
    if (BHL != null) {
      BHL.j(577L, 185L, 1L);
    }
    AppMethodBeat.o(4080);
  }
  
  public static void dZG()
  {
    AppMethodBeat.i(4081);
    if (BHL != null) {
      BHL.j(577L, 186L, 1L);
    }
    AppMethodBeat.o(4081);
  }
  
  public static void dZH()
  {
    AppMethodBeat.i(4082);
    if (BHL != null) {
      BHL.j(577L, 187L, 1L);
    }
    AppMethodBeat.o(4082);
  }
  
  public static void dZI()
  {
    AppMethodBeat.i(4083);
    if (BHL != null) {
      BHL.j(577L, 188L, 1L);
    }
    AppMethodBeat.o(4083);
  }
  
  public static void dZJ()
  {
    AppMethodBeat.i(4084);
    if (BHL != null) {
      BHL.j(577L, 189L, 1L);
    }
    AppMethodBeat.o(4084);
  }
  
  public static void dZK()
  {
    AppMethodBeat.i(4085);
    if (BHL != null) {
      BHL.j(577L, 190L, 1L);
    }
    AppMethodBeat.o(4085);
  }
  
  public static void dZL()
  {
    AppMethodBeat.i(4086);
    if (BHL == null)
    {
      AppMethodBeat.o(4086);
      return;
    }
    BHL.j(577L, 88L, 1L);
    AppMethodBeat.o(4086);
  }
  
  public static void dZM()
  {
    AppMethodBeat.i(151443);
    if (BHL != null) {
      BHL.j(1068L, 60L, 1L);
    }
    AppMethodBeat.o(151443);
  }
  
  public static void dZN()
  {
    AppMethodBeat.i(151444);
    if (BHL != null) {
      BHL.j(1068L, 61L, 1L);
    }
    AppMethodBeat.o(151444);
  }
  
  public static void dZO()
  {
    AppMethodBeat.i(151445);
    if (BHL != null) {
      BHL.j(1068L, 62L, 1L);
    }
    AppMethodBeat.o(151445);
  }
  
  public static void dZP()
  {
    AppMethodBeat.i(151446);
    if (BHL != null) {
      BHL.j(1068L, 63L, 1L);
    }
    AppMethodBeat.o(151446);
  }
  
  public static void dZQ()
  {
    AppMethodBeat.i(151447);
    if (BHL != null) {
      BHL.j(1068L, 64L, 1L);
    }
    AppMethodBeat.o(151447);
  }
  
  public static void dZR()
  {
    AppMethodBeat.i(151448);
    if (BHL != null) {
      BHL.j(1068L, 65L, 1L);
    }
    AppMethodBeat.o(151448);
  }
  
  public static void dZS()
  {
    AppMethodBeat.i(151449);
    if (BHL != null) {
      BHL.j(1068L, 66L, 1L);
    }
    AppMethodBeat.o(151449);
  }
  
  public static void dZT()
  {
    AppMethodBeat.i(138352);
    m(938L, 89L, 1L);
    AppMethodBeat.o(138352);
  }
  
  public static void dZU()
  {
    AppMethodBeat.i(138353);
    m(938L, 90L, 1L);
    AppMethodBeat.o(138353);
  }
  
  public static void dZV()
  {
    AppMethodBeat.i(138354);
    m(938L, 91L, 1L);
    AppMethodBeat.o(138354);
  }
  
  private static boolean dZa()
  {
    AppMethodBeat.i(4025);
    if ((WebView.getCurWebType() == WebView.d.BEq) && (WebView.getCurWebType() != BHK))
    {
      AppMethodBeat.o(4025);
      return true;
    }
    AppMethodBeat.o(4025);
    return false;
  }
  
  private static int dZb()
  {
    AppMethodBeat.i(4032);
    int i = -1;
    if (BEe.equals("mm")) {
      i = 30;
    }
    for (;;)
    {
      AppMethodBeat.o(4032);
      return i;
      if (BEe.equals("tools")) {
        i = 36;
      } else if (BEe.equals("toolsmp")) {
        i = 42;
      } else if (BEe.equals("appbrand")) {
        i = 48;
      } else if (BEe.equals("support")) {
        i = 54;
      }
    }
  }
  
  public static void dZc()
  {
    AppMethodBeat.i(4034);
    if (BHL != null) {
      BHL.j(577L, 1L, 1L);
    }
    AppMethodBeat.o(4034);
  }
  
  public static void dZd()
  {
    AppMethodBeat.i(4036);
    if (BHL != null) {
      BHL.j(577L, 46L, 1L);
    }
    AppMethodBeat.o(4036);
  }
  
  public static void dZe()
  {
    AppMethodBeat.i(4037);
    if (BHL != null) {
      BHL.j(577L, 47L, 1L);
    }
    AppMethodBeat.o(4037);
  }
  
  public static void dZf()
  {
    AppMethodBeat.i(4039);
    if (BHL != null) {
      BHL.j(577L, 42L, 1L);
    }
    AppMethodBeat.o(4039);
  }
  
  public static void dZg()
  {
    AppMethodBeat.i(4040);
    if (BHL != null) {
      BHL.j(577L, 43L, 1L);
    }
    AppMethodBeat.o(4040);
  }
  
  public static void dZh()
  {
    AppMethodBeat.i(4046);
    if (BHL != null) {
      BHL.j(577L, 52L, 1L);
    }
    AppMethodBeat.o(4046);
  }
  
  public static void dZi()
  {
    AppMethodBeat.i(4047);
    if (BHL != null) {
      BHL.j(577L, 53L, 1L);
    }
    AppMethodBeat.o(4047);
  }
  
  public static void dZj()
  {
    AppMethodBeat.i(4048);
    if (BHL != null) {
      BHL.j(577L, 54L, 1L);
    }
    AppMethodBeat.o(4048);
  }
  
  public static void dZk()
  {
    AppMethodBeat.i(4049);
    if (BHL != null) {
      BHL.j(577L, 55L, 1L);
    }
    AppMethodBeat.o(4049);
  }
  
  public static void dZl()
  {
    AppMethodBeat.i(4050);
    if (BHL != null) {
      BHL.j(577L, 56L, 1L);
    }
    AppMethodBeat.o(4050);
  }
  
  public static void dZm()
  {
    AppMethodBeat.i(4051);
    if (BHL != null) {
      BHL.j(577L, 57L, 1L);
    }
    AppMethodBeat.o(4051);
  }
  
  public static void dZn()
  {
    AppMethodBeat.i(4052);
    if (BHL != null) {
      BHL.j(577L, 58L, 1L);
    }
    AppMethodBeat.o(4052);
  }
  
  public static void dZo()
  {
    AppMethodBeat.i(4053);
    if (BHL != null) {
      BHL.j(577L, 59L, 1L);
    }
    AppMethodBeat.o(4053);
  }
  
  public static void dZp()
  {
    AppMethodBeat.i(4056);
    if (BHL != null) {
      BHL.j(577L, 167L, 1L);
    }
    AppMethodBeat.o(4056);
  }
  
  public static void dZq()
  {
    AppMethodBeat.i(4057);
    if (BHL != null) {
      BHL.j(577L, 9L, 1L);
    }
    AppMethodBeat.o(4057);
  }
  
  public static void dZr()
  {
    AppMethodBeat.i(4059);
    if (BHL != null) {
      BHL.j(577L, 10L, 1L);
    }
    AppMethodBeat.o(4059);
  }
  
  public static void dZs()
  {
    AppMethodBeat.i(4060);
    if (BHL != null) {
      BHL.j(577L, 60L, 1L);
    }
    AppMethodBeat.o(4060);
  }
  
  public static void dZt()
  {
    AppMethodBeat.i(4062);
    if (BHL != null) {
      BHL.j(577L, 20L, 1L);
    }
    AppMethodBeat.o(4062);
  }
  
  public static void dZu()
  {
    AppMethodBeat.i(4064);
    if (BHL != null) {
      BHL.j(577L, 21L, 1L);
    }
    AppMethodBeat.o(4064);
  }
  
  public static void dZv()
  {
    AppMethodBeat.i(4067);
    if (BHL != null) {
      BHL.j(577L, 26L, 1L);
    }
    AppMethodBeat.o(4067);
  }
  
  public static void dZw()
  {
    AppMethodBeat.i(4068);
    if (BHL != null) {
      BHL.j(577L, 14L, 1L);
    }
    AppMethodBeat.o(4068);
  }
  
  public static void dZx()
  {
    AppMethodBeat.i(4069);
    if (BHL != null) {
      BHL.j(577L, 15L, 1L);
    }
    AppMethodBeat.o(4069);
  }
  
  public static void dZy()
  {
    AppMethodBeat.i(4071);
    if (BHL == null)
    {
      AppMethodBeat.o(4071);
      return;
    }
    BHL.j(577L, 83L, 1L);
    AppMethodBeat.o(4071);
  }
  
  public static void dZz()
  {
    AppMethodBeat.i(4073);
    if (BHL == null)
    {
      AppMethodBeat.o(4073);
      return;
    }
    BHL.j(577L, 87L, 1L);
    AppMethodBeat.o(4073);
  }
  
  public static void f(WebView.d paramd)
  {
    BHK = paramd;
  }
  
  public static void fl(String paramString, int paramInt)
  {
    AppMethodBeat.i(4042);
    y localy;
    int j;
    int k;
    if (BHL != null)
    {
      ayi(paramString);
      cpW = UUID.randomUUID().toString().replace("-", "");
      BHL.j(577L, 4L, 1L);
      localy = BHL;
      j = XWalkEnvironment.getAvailableVersion();
      k = ayk(paramString);
      paramString = cpW;
      if (k.dYj() != null) {
        break label95;
      }
    }
    label95:
    for (int i = 100;; i = k.dYj().ordinal())
    {
      localy.a(j, k, paramString, i, 0, 0, 0, paramInt);
      AppMethodBeat.o(4042);
      return;
    }
  }
  
  public static void g(WebView.d paramd)
  {
    AppMethodBeat.i(4027);
    if (BHL == null)
    {
      AppMethodBeat.o(4027);
      return;
    }
    int i;
    String str1;
    label36:
    String str3;
    String str2;
    if (paramd == WebView.d.BEq)
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
      if (paramd == WebView.d.BEq)
      {
        i = XWalkEnvironment.getSharedPreferences().getInt("REPORT_XWEB_APK_VER", 0);
        int j = XWalkEnvironment.getAvailableVersion();
        if (j <= 0)
        {
          AppMethodBeat.o(4027);
          return;
          i = 0;
          break;
          label120:
          str1 = "REPORT_APK_VER_TIME_".concat(String.valueOf(paramd));
          break label36;
        }
        if ((j != i) || (!str3.equals(str2)))
        {
          BHL.j(577L, j % 50 + 100, 1L);
          XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
        }
      }
      if (str3.equals(str2))
      {
        AppMethodBeat.o(4027);
        return;
      }
      if (paramd == WebView.d.BEq)
      {
        if (XWalkEnvironment.getAvailableVersion() <= 0)
        {
          AppMethodBeat.o(4027);
          return;
        }
        i = 99;
      }
      for (;;)
      {
        BHL.j(577L, i, 1L);
        XWalkEnvironment.getSharedPreferences().edit().putString(str1, str3).commit();
        AppMethodBeat.o(4027);
        return;
        if (paramd == WebView.d.BEs)
        {
          i = 97;
        }
        else
        {
          if (paramd != WebView.d.BEr) {
            break;
          }
          i = 98;
        }
      }
      AppMethodBeat.o(4027);
      return;
    }
  }
  
  public static void h(WebView.d paramd)
  {
    AppMethodBeat.i(4061);
    if (BHL == null)
    {
      AppMethodBeat.o(4061);
      return;
    }
    if (paramd == WebView.d.BEq)
    {
      BHL.j(577L, 61L, 1L);
      iB(577, 62);
    }
    AppMethodBeat.o(4061);
  }
  
  public static void i(WebView.d paramd)
  {
    AppMethodBeat.i(4072);
    if (BHL == null)
    {
      AppMethodBeat.o(4072);
      return;
    }
    int i;
    switch (f.1.iPi[paramd.ordinal()])
    {
    default: 
      AppMethodBeat.o(4072);
      return;
    case 1: 
      i = 82;
    }
    for (;;)
    {
      BHL.j(577L, i, 1L);
      AppMethodBeat.o(4072);
      return;
      i = 81;
      continue;
      i = 80;
    }
  }
  
  public static void iB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4026);
    if (BHL == null)
    {
      AppMethodBeat.o(4026);
      return;
    }
    SharedPreferences localSharedPreferences = XWalkEnvironment.getMMKVSharedTransportOld("REPORT_DAILY");
    String str1 = "id_" + paramInt1 + "_key_" + paramInt2;
    String str2 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    if (str2.equals(localSharedPreferences.getString(str1, "")))
    {
      AppMethodBeat.o(4026);
      return;
    }
    BHL.j(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString(str1, str2).commit();
    AppMethodBeat.o(4026);
  }
  
  public static void j(WebView.d paramd)
  {
    AppMethodBeat.i(4074);
    if (BHL == null)
    {
      AppMethodBeat.o(4074);
      return;
    }
    int i;
    switch (f.1.iPi[paramd.ordinal()])
    {
    default: 
      AppMethodBeat.o(4074);
      return;
    case 1: 
      i = 86;
    }
    for (;;)
    {
      BHL.j(577L, i, 1L);
      AppMethodBeat.o(4074);
      return;
      i = 85;
      continue;
      i = 84;
    }
  }
  
  public static void m(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(4030);
    if (BHL != null) {
      BHL.j(paramLong1, paramLong2, paramLong3);
    }
    AppMethodBeat.o(4030);
  }
  
  public static void pf(long paramLong)
  {
    AppMethodBeat.i(4029);
    if (BHL != null) {
      BHL.j(577L, paramLong, 1L);
    }
    AppMethodBeat.o(4029);
  }
  
  public static void pg(long paramLong)
  {
    AppMethodBeat.i(4035);
    if ((BHL != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      BHL.aF(2, 3, (int)paramLong);
    }
    AppMethodBeat.o(4035);
  }
  
  public static void ph(long paramLong)
  {
    AppMethodBeat.i(4038);
    if ((BHL != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      BHL.aF(48, 49, (int)paramLong);
    }
    AppMethodBeat.o(4038);
  }
  
  public static void pi(long paramLong)
  {
    AppMethodBeat.i(4041);
    if ((BHL != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      BHL.aF(44, 45, (int)paramLong);
    }
    AppMethodBeat.o(4041);
  }
  
  public static void pj(long paramLong)
  {
    AppMethodBeat.i(4058);
    if ((BHL != null) && (BHL != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      BHL.aF(11, 12, (int)paramLong);
    }
    AppMethodBeat.o(4058);
  }
  
  public static void pk(long paramLong)
  {
    AppMethodBeat.i(4063);
    if ((BHL != null) && (BHL != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      BHL.aF(22, 23, (int)paramLong);
    }
    AppMethodBeat.o(4063);
  }
  
  public static void pl(long paramLong)
  {
    AppMethodBeat.i(4066);
    if ((BHL != null) && (BHL != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      BHL.aF(27, 28, (int)paramLong);
    }
    AppMethodBeat.o(4066);
  }
  
  public static void pm(long paramLong)
  {
    AppMethodBeat.i(4070);
    if ((BHL != null) && (BHL != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      BHL.aF(16, 17, (int)paramLong);
    }
    AppMethodBeat.o(4070);
  }
  
  public static void q(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(4044);
    pg(paramLong);
    y localy;
    int j;
    int k;
    if ((BHL != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      BHL.aF(6, 7, (int)paramLong);
      localy = BHL;
      j = XWalkEnvironment.getAvailableVersion();
      k = ayk(paramString);
      paramString = cpW;
      if (k.dYj() != null) {
        break label96;
      }
    }
    label96:
    for (int i = 100;; i = k.dYj().ordinal())
    {
      localy.a(j, k, paramString, i, 1, 0, (int)paramLong, paramInt);
      AppMethodBeat.o(4044);
      return;
    }
  }
  
  public static void si(boolean paramBoolean)
  {
    AppMethodBeat.i(4088);
    if (!"toolsmp".equals(BEe))
    {
      AppMethodBeat.o(4088);
      return;
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (WebView.getCurWebType() != WebView.d.BEq) {
        break label66;
      }
    }
    for (int j = 180;; j = 190)
    {
      m(903L, i + j, 1L);
      AppMethodBeat.o(4088);
      return;
      i = 1;
      break;
      label66:
      if (WebView.getCurWebType() != WebView.d.BEr) {
        break label82;
      }
    }
    label82:
    AppMethodBeat.o(4088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.util.f
 * JD-Core Version:    0.7.0.1
 */