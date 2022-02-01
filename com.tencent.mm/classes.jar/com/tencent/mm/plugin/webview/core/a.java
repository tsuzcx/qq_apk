package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ba.a.e;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashSet;
import java.util.Set;

public final class a
{
  public static final String WxT;
  public static final Set<String> WxU;
  
  static
  {
    AppMethodBeat.i(295120);
    WxT = WeChatHosts.domainString(a.e.host_weixin110_qq_com) + ";" + WeChatHosts.domainString(a.e.host_res_wx_qq_com) + ";" + WeChatHosts.domainString(a.e.host_weops_qq_com) + ";wx-credit-repay.tencent.com;chong.qq.com;qian.tenpay.com;" + WeChatHosts.domainString(a.e.host_payapp_weixin_qq_com) + ";" + WeChatHosts.domainString(a.e.host_pay_weixin_qq_com) + ";wx.tenpay.com";
    WxU = new HashSet() {};
    AppMethodBeat.o(295120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.a
 * JD-Core Version:    0.7.0.1
 */