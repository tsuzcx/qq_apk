package com.tencent.mm.pluginsdk.wallet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aq.a.h;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class c
{
  public static final String Rzq;
  public static final String[] Rzr;
  
  static
  {
    AppMethodBeat.i(187933);
    Rzq = "https://" + WeChatHosts.domainString(a.h.host_weixin_qq_com) + "/cgi-bin/readtemplate?lang=en_US&check=false&t=weixin_agreement&s=terms";
    Rzr = new String[] { "/cgi-bin/mmpay-bin/cancelqrpay", "/cgi-bin/mmpay-bin/tenpay/elementquerynew", "/cgi-bin/mmpay-bin/tenpay/payorderquery", "/cgi-bin/mmpay-bin/tenpay/datareport", "/cgi-bin/mmpay-bin/tenpay/offlinecreate", "/cgi-bin/mmpay-bin/tenpay/offlinegettoken", "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser", "/cgi-bin/mmpay-bin/tenpay/queryuserwallet", "/cgi-bin/mmpay-bin/tenpay/unbindbanner", "/cgi-bin/mmpay-bin/tenpay/unbind", "/cgi-bin/mmpay-bin/tenpay/bindquerynew", "/cgi-bin/mmpay-bin/tenpay/getbannerinfo", "/cgi-bin/mmpay-bin/tenpay/paymanage", "/cgi-bin/mmpay-bin/tenpay/timeseed", "/cgi-bin/micromsg-bin/paydeluserroll", "/cgi-bin/mmpay-bin/getrealnamewording", "/cgi-bin/mmpay-bin/bankresource", "/cgi-bin/mmpay-bin/tenpay/sns_aa_payorderquery", "/cgi-bin/mmpay-bin/tenpay/sns_payorderquery", "/cgi-bin/mmpay-bin/tenpay/sns_tf_payorderquery", "/cgi-bin/mmpay-bin/tenpay/sns_ff_payorderquery", "/cgi-bin/mmpay-bin/tenpay/ts_payorderquery", "/cgi-bin/mmpay-bin/tenpay/payorderquery" };
    AppMethodBeat.o(187933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.wallet.c
 * JD-Core Version:    0.7.0.1
 */