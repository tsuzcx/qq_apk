package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/SecondCutConfig;", "", "()V", "CHINESE_SIMPLE", "", "CHINESE_TRADITION", "ENGLISH", "TAG", "getEditVideoToSecondCutEntrance", "", "getFinderWordingTime", "", "getPopupFinderWording", "getPopupSecondCutWording", "getPopupWeSeeWording", "getSecondCutDownloadUrl", "getSecondCutSimpleStyleEntrance", "getSecondCutSimpleStyleWording", "getSecondCutWordingTime", "getShareVideoDuration", "getSnsToSecondCutEntrance", "getWeSeeWordingTime", "getWordingByLanguageFromJson", "json", "plugin-recordvideo_release"})
public final class h
{
  public static final h Ifn;
  
  static
  {
    AppMethodBeat.i(224172);
    Ifn = new h();
    AppMethodBeat.o(224172);
  }
  
  public static String aWv(String paramString)
  {
    AppMethodBeat.i(224164);
    p.k(paramString, "json");
    try
    {
      paramString = new i(paramString);
      if (LocaleUtil.isSimplifiedChineseAppLang())
      {
        paramString = paramString.optString("simple");
        p.j(paramString, "jsonObject.optString(CHINESE_SIMPLE)");
        AppMethodBeat.o(224164);
        return paramString;
      }
      if (LocaleUtil.isTraditionalChineseAppLang())
      {
        paramString = paramString.optString("tradition");
        p.j(paramString, "jsonObject.optString(CHINESE_TRADITION)");
        AppMethodBeat.o(224164);
        return paramString;
      }
    }
    catch (g paramString)
    {
      Log.e("MicroMsg.SecondCutConfig", "parse wording JSON error");
      AppMethodBeat.o(224164);
      return "";
    }
    paramString = paramString.optString("english");
    p.j(paramString, "jsonObject.optString(ENGLISH)");
    AppMethodBeat.o(224164);
    return paramString;
  }
  
  public static boolean fzA()
  {
    AppMethodBeat.i(224141);
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vNr, false);
    Log.i("MicroMsg.SecondCutConfig", "EditVideoToSecondCutEntrance: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(224141);
    return bool;
  }
  
  public static int fzB()
  {
    AppMethodBeat.i(224144);
    int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vNu, 30);
    Log.i("MicroMsg.SecondCutConfig", "ShareVideoDuration: ".concat(String.valueOf(i)));
    AppMethodBeat.o(224144);
    return i;
  }
  
  public static String fzC()
  {
    AppMethodBeat.i(224146);
    String str = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vNv, "https://miaojian.weixin.qq.com/download/apps?channel=");
    Log.i("MicroMsg.SecondCutConfig", "SecondCutDownloadUrl: ".concat(String.valueOf(str)));
    p.j(str, "url");
    AppMethodBeat.o(224146);
    return str;
  }
  
  public static int fzD()
  {
    AppMethodBeat.i(224151);
    int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vNw, 30);
    Log.i("MicroMsg.SecondCutConfig", "SecondCutWordingTime: ".concat(String.valueOf(i)));
    AppMethodBeat.o(224151);
    return i;
  }
  
  public static int fzE()
  {
    AppMethodBeat.i(224153);
    int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vNx, 30);
    Log.i("MicroMsg.SecondCutConfig", "WeSeeWordingTime: ".concat(String.valueOf(i)));
    AppMethodBeat.o(224153);
    return i;
  }
  
  public static int fzF()
  {
    AppMethodBeat.i(224156);
    int i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vNy, 60);
    Log.i("MicroMsg.SecondCutConfig", "FinderWordingTime: ".concat(String.valueOf(i)));
    AppMethodBeat.o(224156);
    return i;
  }
  
  public static boolean fzG()
  {
    AppMethodBeat.i(224169);
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vNC, false);
    Log.i("MicroMsg.SecondCutConfig", "SecondCutSimpleStyleEntrance: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(224169);
    return bool;
  }
  
  public static boolean fzz()
  {
    AppMethodBeat.i(224140);
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vNs, false);
    Log.i("MicroMsg.SecondCutConfig", "SecondCutEntrance: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(224140);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.h
 * JD-Core Version:    0.7.0.1
 */