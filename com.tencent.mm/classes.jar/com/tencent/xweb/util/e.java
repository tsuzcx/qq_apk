package com.tencent.xweb.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.g;
import com.tencent.xweb.g.a;
import com.tencent.xweb.r;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

public final class e
{
  public static String bIB = "";
  private static String xhd = "";
  private static boolean xke = false;
  static r xkf = null;
  static boolean xkg = false;
  
  public static boolean KF(int paramInt)
  {
    return (paramInt == 15625) || (paramInt == 15626);
  }
  
  public static void a(r paramr)
  {
    xkf = paramr;
  }
  
  public static void agY(String paramString)
  {
    if (paramString != null) {
      xhd = paramString;
    }
  }
  
  public static void agZ(String paramString)
  {
    int j = 73;
    int i;
    if (xkf != null)
    {
      xkf.h(577L, 0L, 1L);
      if ((!xhd.equals("toolsmp")) || (paramString == null) || (ahb(paramString) != 2)) {
        break label109;
      }
      xkf.h(903L, 101L, 1L);
      if (!xke)
      {
        if (!xhd.equals("tools")) {
          break label148;
        }
        i = 70;
      }
    }
    for (;;)
    {
      j = WebView.getCurWebType().ordinal() - 1;
      if ((i >= 70) && (j >= 0))
      {
        xke = true;
        gr(577, i + j);
      }
      return;
      label109:
      if ((!xhd.equals("tools")) || (paramString == null) || (ahb(paramString) != 1)) {
        break;
      }
      xkf.h(903L, 103L, 1L);
      break;
      label148:
      i = j;
      if (!xhd.equals("appbrand"))
      {
        i = j;
        if (!xhd.equals("support")) {
          i = -1;
        }
      }
    }
  }
  
  public static void aha(String paramString)
  {
    if (xkf == null) {}
    int i;
    int j;
    do
    {
      return;
      if (!xkg)
      {
        i = cSK();
        j = WebView.getCurWebType().ordinal() - 1;
        if ((i >= 30) && (j >= 0))
        {
          xkg = true;
          gr(903, i + 3 + j);
        }
      }
      if ((paramString != null) && ("https://servicewechat.com/preload/page-frame.html".equalsIgnoreCase(paramString.trim()))) {
        xkf.h(903L, 102L, 1L);
      }
      i = cSK();
      j = WebView.getCurWebType().ordinal() - 1;
    } while ((i < 30) || (j < 0));
    xkf.h(903L, i + 0 + j, 1L);
  }
  
  public static int ahb(String paramString)
  {
    if (paramString.startsWith("https://servicewechat.com/")) {
      return 0;
    }
    if ((paramString.startsWith("http://mp.weixin.qq.com/")) || (paramString.startsWith("https://mp.weixin.qq.com/")) || (paramString.startsWith("https://servicewechat.com/preload/")) || (paramString.startsWith("http://mp.weixinbridge.com/"))) {
      return 1;
    }
    return 2;
  }
  
  public static void ax(int paramInt, boolean paramBoolean)
  {
    if (xkf != null)
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
        xkf.h(577L, paramInt, 1L);
      }
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
  
  public static void ay(int paramInt, boolean paramBoolean)
  {
    if (xkf != null)
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
        xkf.h(577L, paramInt, 1L);
      }
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
  
  public static void b(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    r localr;
    int j;
    int k;
    if (xkf != null)
    {
      cSL();
      xkf.h(577L, 5L, 1L);
      xkf.aC(15003, "");
      localr = xkf;
      j = XWalkEnvironment.getAvailableVersion();
      k = ahb(paramString);
      paramString = bIB;
      if (g.cSh() != null) {
        break label82;
      }
    }
    label82:
    for (int i = 100;; i = g.cSh().ordinal())
    {
      localr.a(j, k, paramString, i, 1, paramInt1, (int)paramLong, paramInt2);
      return;
    }
  }
  
  public static void bp(int paramInt, String paramString)
  {
    if (xkf != null) {
      xkf.aC(paramInt, paramString);
    }
  }
  
  public static boolean bsu()
  {
    return xkf != null;
  }
  
  private static int cSK()
  {
    int i = -1;
    if (xhd.equals("mm")) {
      i = 30;
    }
    do
    {
      return i;
      if (xhd.equals("tools")) {
        return 36;
      }
      if (xhd.equals("toolsmp")) {
        return 42;
      }
      if (xhd.equals("appbrand")) {
        return 48;
      }
    } while (!xhd.equals("support"));
    return 54;
  }
  
  public static void cSL()
  {
    if (xkf != null) {
      xkf.h(577L, 1L, 1L);
    }
  }
  
  public static void cSM()
  {
    if (xkf != null) {
      xkf.h(577L, 46L, 1L);
    }
  }
  
  public static void cSN()
  {
    if (xkf != null) {
      xkf.h(577L, 47L, 1L);
    }
  }
  
  public static void cSO()
  {
    if (xkf != null) {
      xkf.h(577L, 42L, 1L);
    }
  }
  
  public static void cSP()
  {
    if (xkf != null) {
      xkf.h(577L, 43L, 1L);
    }
  }
  
  public static void cSQ()
  {
    if (xkf != null) {
      xkf.h(577L, 52L, 1L);
    }
  }
  
  public static void cSR()
  {
    if (xkf != null) {
      xkf.h(577L, 53L, 1L);
    }
  }
  
  public static void cSS()
  {
    if (xkf != null) {
      xkf.h(577L, 54L, 1L);
    }
  }
  
  public static void cST()
  {
    if (xkf != null) {
      xkf.h(577L, 55L, 1L);
    }
  }
  
  public static void cSU()
  {
    if (xkf != null) {
      xkf.h(577L, 56L, 1L);
    }
  }
  
  public static void cSV()
  {
    if (xkf != null) {
      xkf.h(577L, 57L, 1L);
    }
  }
  
  public static void cSW()
  {
    if (xkf != null) {
      xkf.h(577L, 58L, 1L);
    }
  }
  
  public static void cSX()
  {
    if (xkf != null) {
      xkf.h(577L, 59L, 1L);
    }
  }
  
  public static void cSY()
  {
    if (xkf != null) {
      xkf.h(577L, 167L, 1L);
    }
  }
  
  public static void cSZ()
  {
    if (xkf != null) {
      xkf.h(577L, 9L, 1L);
    }
  }
  
  public static void cTa()
  {
    if (xkf != null) {
      xkf.h(577L, 10L, 1L);
    }
  }
  
  public static void cTb()
  {
    if (xkf != null) {
      xkf.h(577L, 60L, 1L);
    }
  }
  
  public static void cTc()
  {
    if (xkf != null) {
      xkf.h(577L, 20L, 1L);
    }
  }
  
  public static void cTd()
  {
    if (xkf != null) {
      xkf.h(577L, 21L, 1L);
    }
  }
  
  public static void cTe()
  {
    if (xkf != null) {
      xkf.h(577L, 25L, 1L);
    }
  }
  
  public static void cTf()
  {
    if (xkf != null) {
      xkf.h(577L, 26L, 1L);
    }
  }
  
  public static void cTg()
  {
    if (xkf != null) {
      xkf.h(577L, 14L, 1L);
    }
  }
  
  public static void cTh()
  {
    if (xkf != null) {
      xkf.h(577L, 15L, 1L);
    }
  }
  
  public static void cTi()
  {
    if (xkf == null) {
      return;
    }
    xkf.h(577L, 83L, 1L);
  }
  
  public static void cTj()
  {
    if (xkf == null) {
      return;
    }
    xkf.h(577L, 87L, 1L);
  }
  
  public static void cTk()
  {
    if (xkf != null) {
      xkf.h(577L, 180L, 1L);
    }
  }
  
  public static void cTl()
  {
    if (xkf != null) {
      xkf.h(577L, 181L, 1L);
    }
  }
  
  public static void cTm()
  {
    if (xkf != null) {
      xkf.h(577L, 182L, 1L);
    }
  }
  
  public static void cTn()
  {
    if (xkf != null) {
      xkf.h(577L, 183L, 1L);
    }
  }
  
  public static void cTo()
  {
    if (xkf != null) {
      xkf.h(577L, 184L, 1L);
    }
  }
  
  public static void cTp()
  {
    if (xkf != null) {
      xkf.h(577L, 185L, 1L);
    }
  }
  
  public static void cTq()
  {
    if (xkf != null) {
      xkf.h(577L, 186L, 1L);
    }
  }
  
  public static void cTr()
  {
    if (xkf != null) {
      xkf.h(577L, 187L, 1L);
    }
  }
  
  public static void cTs()
  {
    if (xkf != null) {
      xkf.h(577L, 188L, 1L);
    }
  }
  
  public static void cTt()
  {
    if (xkf != null) {
      xkf.h(577L, 189L, 1L);
    }
  }
  
  public static void cTu()
  {
    if (xkf != null) {
      xkf.h(577L, 190L, 1L);
    }
  }
  
  public static void cTv()
  {
    if (xkf == null) {
      return;
    }
    xkf.h(577L, 88L, 1L);
  }
  
  public static void d(WebView.d paramd)
  {
    if (xkf == null) {
      return;
    }
    int i;
    label16:
    String str1;
    label24:
    String str3;
    String str2;
    if (paramd == WebView.d.xho)
    {
      i = 1;
      if (i == 0) {
        break label218;
      }
      str1 = "REPORT_APK_VER_TIME";
      str3 = new SimpleDateFormat("yyyyMMdd").format(new Date());
      str2 = XWalkEnvironment.getSharedPreferences().getString(str1, "");
      if (str2 != null) {
        break label265;
      }
      str2 = "";
    }
    label265:
    for (;;)
    {
      if (paramd == WebView.d.xho)
      {
        i = XWalkEnvironment.getSharedPreferences().getInt("REPORT_XWEB_APK_VER", 0);
        int j = XWalkEnvironment.getAvailableVersion();
        if (j <= 0) {
          break;
        }
        if ((j != i) || (!str3.equals(str2)))
        {
          xkf.h(577L, j % 50 + 100, 1L);
          XWalkEnvironment.getSharedPreferences().edit().putInt("REPORT_XWEB_APK_VER", j).commit();
        }
      }
      if (str3.equals(str2)) {
        break;
      }
      if (paramd == WebView.d.xho)
      {
        if (XWalkEnvironment.getAvailableVersion() <= 0) {
          break;
        }
        i = 99;
      }
      for (;;)
      {
        xkf.h(577L, i, 1L);
        XWalkEnvironment.getSharedPreferences().edit().putString(str1, str3).commit();
        return;
        i = 0;
        break label16;
        label218:
        str1 = "REPORT_APK_VER_TIME_" + paramd;
        break label24;
        if (paramd == WebView.d.xhq)
        {
          i = 97;
        }
        else
        {
          if (paramd != WebView.d.xhp) {
            break;
          }
          i = 98;
        }
      }
    }
  }
  
  public static void e(WebView.d paramd)
  {
    if (xkf == null) {}
    while (paramd != WebView.d.xho) {
      return;
    }
    xkf.h(577L, 61L, 1L);
    gr(577, 62);
  }
  
  public static void eb(String paramString, int paramInt)
  {
    r localr;
    int j;
    int k;
    if (xkf != null)
    {
      agZ(paramString);
      bIB = UUID.randomUUID().toString().replace("-", "");
      xkf.h(577L, 4L, 1L);
      localr = xkf;
      j = XWalkEnvironment.getAvailableVersion();
      k = ahb(paramString);
      paramString = bIB;
      if (g.cSh() != null) {
        break label83;
      }
    }
    label83:
    for (int i = 100;; i = g.cSh().ordinal())
    {
      localr.a(j, k, paramString, i, 0, 0, 0, paramInt);
      return;
    }
  }
  
  public static void f(long paramLong1, long paramLong2, int paramInt)
  {
    if (xkf != null) {
      xkf.h(paramLong1, paramLong2, paramInt);
    }
  }
  
  public static void f(WebView.d paramd)
  {
    if (xkf == null) {
      return;
    }
    int i;
    switch (1.xkh[paramd.ordinal()])
    {
    default: 
      return;
    case 1: 
      i = 82;
    }
    for (;;)
    {
      xkf.h(577L, i, 1L);
      return;
      i = 81;
      continue;
      i = 80;
    }
  }
  
  public static void g(WebView.d paramd)
  {
    if (xkf == null) {
      return;
    }
    int i;
    switch (1.xkh[paramd.ordinal()])
    {
    default: 
      return;
    case 1: 
      i = 86;
    }
    for (;;)
    {
      xkf.h(577L, i, 1L);
      return;
      i = 85;
      continue;
      i = 84;
    }
  }
  
  private static void gr(int paramInt1, int paramInt2)
  {
    if (xkf == null) {}
    SharedPreferences localSharedPreferences;
    String str1;
    String str2;
    do
    {
      return;
      localSharedPreferences = XWalkEnvironment.getApplicationContext().getSharedPreferences("REPORT_DAILY", 4);
      str1 = "id_" + paramInt1 + "_key_" + paramInt2;
      str2 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    } while (str2.equals(localSharedPreferences.getString(str1, "")));
    xkf.h(paramInt1, paramInt2, 1L);
    localSharedPreferences.edit().putString(str1, str2).commit();
  }
  
  public static void iA(long paramLong)
  {
    if ((xkf != null) && (xkf != null) && (paramLong > 0L) && (paramLong < 120000L)) {
      xkf.at(16, 17, (int)paramLong);
    }
  }
  
  public static void it(long paramLong)
  {
    if (xkf != null) {
      xkf.h(577L, paramLong, 1L);
    }
  }
  
  public static void iu(long paramLong)
  {
    if ((xkf != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      xkf.at(2, 3, (int)paramLong);
    }
  }
  
  public static void iv(long paramLong)
  {
    if ((xkf != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      xkf.at(48, 49, (int)paramLong);
    }
  }
  
  public static void iw(long paramLong)
  {
    if ((xkf != null) && (paramLong > 0L) && (paramLong < 300000L)) {
      xkf.at(44, 45, (int)paramLong);
    }
  }
  
  public static void ix(long paramLong)
  {
    if ((xkf != null) && (xkf != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      xkf.at(11, 12, (int)paramLong);
    }
  }
  
  public static void iy(long paramLong)
  {
    if ((xkf != null) && (xkf != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      xkf.at(22, 23, (int)paramLong);
    }
  }
  
  public static void iz(long paramLong)
  {
    if ((xkf != null) && (xkf != null) && (paramLong > 0L) && (paramLong < 600000L)) {
      xkf.at(27, 28, (int)paramLong);
    }
  }
  
  public static void m(String paramString, long paramLong, int paramInt)
  {
    iu(paramLong);
    r localr;
    int j;
    int k;
    if ((xkf != null) && (paramLong > 0L) && (paramLong < 300000L))
    {
      xkf.at(6, 7, (int)paramLong);
      localr = xkf;
      j = XWalkEnvironment.getAvailableVersion();
      k = ahb(paramString);
      paramString = bIB;
      if (g.cSh() != null) {
        break label84;
      }
    }
    label84:
    for (int i = 100;; i = g.cSh().ordinal())
    {
      localr.a(j, k, paramString, i, 1, 0, (int)paramLong, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.util.e
 * JD-Core Version:    0.7.0.1
 */