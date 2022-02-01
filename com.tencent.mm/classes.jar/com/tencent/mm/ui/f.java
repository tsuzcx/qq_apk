package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class f
{
  public static final String VRS;
  
  static
  {
    AppMethodBeat.i(213517);
    VRS = "https://" + WeChatHosts.domainString(a.k.host_weixin_qq_com);
    AppMethodBeat.o(213517);
  }
  
  public static String bjQ(String paramString)
  {
    AppMethodBeat.i(141283);
    paramString = paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(141283);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.f
 * JD-Core Version:    0.7.0.1
 */