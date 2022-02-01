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
    AppMethodBeat.i(248906);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(248906);
      return true;
    }
    AppMethodBeat.o(248906);
    return false;
  }
  
  public static boolean blockFTSUpdate()
  {
    AppMethodBeat.i(248909);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(248909);
      return true;
    }
    AppMethodBeat.o(248909);
    return false;
  }
  
  public static boolean blockWeixinUrl()
  {
    AppMethodBeat.i(248911);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(248911);
      return true;
    }
    AppMethodBeat.o(248911);
    return false;
  }
  
  public static boolean forceGooglePlayChannel()
  {
    AppMethodBeat.i(248914);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(248914);
      return true;
    }
    AppMethodBeat.o(248914);
    return false;
  }
  
  public static boolean hardcodeWeChatUSTeam()
  {
    AppMethodBeat.i(248913);
    boolean bool = WeChatBrands.AppInfo.current().isUS();
    AppMethodBeat.o(248913);
    return bool;
  }
  
  public static boolean onlyUSMobile()
  {
    AppMethodBeat.i(248907);
    boolean bool = WeChatBrands.AppInfo.current().isUS();
    AppMethodBeat.o(248907);
    return bool;
  }
  
  public static boolean temporaryBlockMinorLanguage()
  {
    AppMethodBeat.i(248904);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      AppMethodBeat.o(248904);
      return true;
    }
    AppMethodBeat.o(248904);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch
 * JD-Core Version:    0.7.0.1
 */