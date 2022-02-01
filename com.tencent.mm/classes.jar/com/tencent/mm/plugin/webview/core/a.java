package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ay.a.a;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashSet;
import java.util.Set;

public final class a
{
  public static final String PHn;
  public static final Set<String> PHo;
  
  static
  {
    AppMethodBeat.i(207059);
    PHn = WeChatHosts.domainString(a.a.host_weixin110_qq_com) + ";" + WeChatHosts.domainString(a.a.host_res_wx_qq_com) + ";" + WeChatHosts.domainString(a.a.host_weops_qq_com) + ";wx-credit-repay.tencent.com;chong.qq.com;qian.tenpay.com;" + WeChatHosts.domainString(a.a.host_payapp_weixin_qq_com) + ";" + WeChatHosts.domainString(a.a.host_pay_weixin_qq_com) + ";wx.tenpay.com";
    PHo = new HashSet() {};
    AppMethodBeat.o(207059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.a
 * JD-Core Version:    0.7.0.1
 */