package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class f$f
{
  public static final String adwf;
  public static final String adwg;
  public static final String adwh;
  
  static
  {
    AppMethodBeat.i(249303);
    adwf = "https://" + WeChatHosts.domainString(a.k.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect";
    adwg = "https://" + WeChatHosts.domainString(a.k.host_mp_weixin_qq_com) + "/mp/infringement?url=%s#wechat_redirect";
    adwh = "https://" + WeChatHosts.domainString(a.k.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=60";
    AppMethodBeat.o(249303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.f.f
 * JD-Core Version:    0.7.0.1
 */