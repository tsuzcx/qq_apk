package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
final class h$a$a
  implements IPCRunCgi.a
{
  public static final a EHg;
  
  static
  {
    AppMethodBeat.i(82677);
    EHg = new a();
    AppMethodBeat.o(82677);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(82676);
    ae.i(h.access$getTAG$cp(), "appmsg_report errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(82676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.h.a.a
 * JD-Core Version:    0.7.0.1
 */