package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashSet;
import java.util.Set;

public final class a
{
  public static final String ILp;
  public static final Set<String> ILq;
  
  static
  {
    AppMethodBeat.i(224211);
    ILp = WeChatHosts.domainString(2131761748) + ";" + WeChatHosts.domainString(2131761736) + ";" + WeChatHosts.domainString(2131761750) + ";wx-credit-repay.tencent.com;chong.qq.com;qian.tenpay.com;" + WeChatHosts.domainString(2131761732) + ";" + WeChatHosts.domainString(2131761731) + ";wx.tenpay.com";
    ILq = new HashSet() {};
    AppMethodBeat.o(224211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.core.a
 * JD-Core Version:    0.7.0.1
 */