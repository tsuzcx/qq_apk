package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WeChatSomeFeatureSwitch
{
  public static boolean blockBizEetnryRemoteConfigs()
  {
    return true;
  }
  
  public static boolean blockCNMobile()
  {
    AppMethodBeat.i(244160);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(244160);
      return true;
    }
    AppMethodBeat.o(244160);
    return false;
  }
  
  public static boolean blockFTSUpdate()
  {
    AppMethodBeat.i(244168);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(244168);
      return true;
    }
    AppMethodBeat.o(244168);
    return false;
  }
  
  public static boolean blockWeixinUrl()
  {
    AppMethodBeat.i(244172);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(244172);
      return true;
    }
    AppMethodBeat.o(244172);
    return false;
  }
  
  public static boolean forceGooglePlayChannel()
  {
    AppMethodBeat.i(244175);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(244175);
      return true;
    }
    AppMethodBeat.o(244175);
    return false;
  }
  
  public static boolean hardcodeWeChatUSTeam()
  {
    AppMethodBeat.i(244174);
    boolean bool = WeChatBrands.AppInfo.current().isUS();
    AppMethodBeat.o(244174);
    return bool;
  }
  
  public static boolean onlyUSMobile()
  {
    AppMethodBeat.i(244164);
    boolean bool = WeChatBrands.AppInfo.current().isUS();
    AppMethodBeat.o(244164);
    return bool;
  }
  
  public static boolean temporaryBlockMinorLanguage()
  {
    AppMethodBeat.i(244156);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(244156);
      return true;
    }
    AppMethodBeat.o(244156);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch
 * JD-Core Version:    0.7.0.1
 */