package com.tencent.mm.plugin.recordvideo.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/SecondCutConfig;", "", "()V", "CHINESE_SIMPLE", "", "CHINESE_TRADITION", "ENGLISH", "TAG", "getEditVideoToSecondCutEntrance", "", "getFinderWordingTime", "", "getPopupFinderWording", "getPopupSecondCutWording", "getPopupWeSeeWording", "getSecondCutDownloadUrl", "getSecondCutSimpleStyleEntrance", "getSecondCutSimpleStyleWording", "getSecondCutWordingTime", "getShareVideoDuration", "getSnsToSecondCutEntrance", "getWeSeeWordingTime", "getWordingByLanguageFromJson", "json", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k ObH;
  
  static
  {
    AppMethodBeat.i(279584);
    ObH = new k();
    AppMethodBeat.o(279584);
  }
  
  public static String aTJ(String paramString)
  {
    AppMethodBeat.i(279560);
    s.u(paramString, "json");
    try
    {
      paramString = new i(paramString);
      if (LocaleUtil.isSimplifiedChineseAppLang())
      {
        paramString = paramString.optString("simple");
        s.s(paramString, "{\n                    js…SIMPLE)\n                }");
        AppMethodBeat.o(279560);
        return paramString;
      }
      if (LocaleUtil.isTraditionalChineseAppLang())
      {
        paramString = paramString.optString("tradition");
        s.s(paramString, "{\n                    js…DITION)\n                }");
        AppMethodBeat.o(279560);
        return paramString;
      }
    }
    catch (g paramString)
    {
      Log.e("MicroMsg.SecondCutConfig", "parse wording JSON error");
      AppMethodBeat.o(279560);
      return "";
    }
    paramString = paramString.optString("english");
    s.s(paramString, "{\n                    js…NGLISH)\n                }");
    AppMethodBeat.o(279560);
    return paramString;
  }
  
  public static boolean gLl()
  {
    AppMethodBeat.i(279520);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zfr, false);
    Log.i("MicroMsg.SecondCutConfig", s.X("SecondCutEntrance: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(279520);
    return bool;
  }
  
  public static boolean gLm()
  {
    AppMethodBeat.i(279525);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zfq, false);
    Log.i("MicroMsg.SecondCutConfig", s.X("EditVideoToSecondCutEntrance: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(279525);
    return bool;
  }
  
  public static int gLn()
  {
    AppMethodBeat.i(279531);
    int i = ((c)h.ax(c.class)).a(c.a.zft, 30);
    Log.i("MicroMsg.SecondCutConfig", s.X("ShareVideoDuration: ", Integer.valueOf(i)));
    AppMethodBeat.o(279531);
    return i;
  }
  
  public static String gLo()
  {
    AppMethodBeat.i(279538);
    String str = ((c)h.ax(c.class)).a(c.a.zfu, "https://miaojian.weixin.qq.com/download/apps?channel=");
    Log.i("MicroMsg.SecondCutConfig", s.X("SecondCutDownloadUrl: ", str));
    s.s(str, "url");
    AppMethodBeat.o(279538);
    return str;
  }
  
  public static int gLp()
  {
    AppMethodBeat.i(279545);
    int i = ((c)h.ax(c.class)).a(c.a.zfv, 30);
    Log.i("MicroMsg.SecondCutConfig", s.X("SecondCutWordingTime: ", Integer.valueOf(i)));
    AppMethodBeat.o(279545);
    return i;
  }
  
  public static int gLq()
  {
    AppMethodBeat.i(279552);
    int i = ((c)h.ax(c.class)).a(c.a.zfw, 30);
    Log.i("MicroMsg.SecondCutConfig", s.X("WeSeeWordingTime: ", Integer.valueOf(i)));
    AppMethodBeat.o(279552);
    return i;
  }
  
  public static boolean gLr()
  {
    AppMethodBeat.i(279571);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zfB, false);
    Log.i("MicroMsg.SecondCutConfig", s.X("SecondCutSimpleStyleEntrance: ", Boolean.valueOf(bool)));
    AppMethodBeat.o(279571);
    return bool;
  }
  
  public static String gLs()
  {
    AppMethodBeat.i(279578);
    String str2 = ((c)h.ax(c.class)).a(c.a.zfC, "");
    Log.i("MicroMsg.SecondCutConfig", s.X("SecondCutSimpleStyleLeftWording: ", str2));
    String str1 = str2;
    if (!TextUtils.isEmpty((CharSequence)str2))
    {
      s.s(str2, "result");
      str1 = aTJ(str2);
      Log.i("MicroMsg.SecondCutConfig", s.X("PopupSecondCutSimpleStyleLeftWording: ", str1));
    }
    s.s(str1, "result");
    AppMethodBeat.o(279578);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.k
 * JD-Core Version:    0.7.0.1
 */