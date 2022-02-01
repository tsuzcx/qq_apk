package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class f$e
{
  public static final String VRX;
  public static final String VRY;
  public static final String VRZ;
  
  static
  {
    AppMethodBeat.i(200595);
    VRX = "https://" + WeChatHosts.domainString(a.k.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect";
    VRY = "https://" + WeChatHosts.domainString(a.k.host_mp_weixin_qq_com) + "/mp/infringement?url=%s#wechat_redirect";
    VRZ = "https://" + WeChatHosts.domainString(a.k.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=60";
    AppMethodBeat.o(200595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.f.e
 * JD-Core Version:    0.7.0.1
 */