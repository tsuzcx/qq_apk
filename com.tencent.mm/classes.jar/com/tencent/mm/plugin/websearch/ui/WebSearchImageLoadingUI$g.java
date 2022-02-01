package com.tencent.mm.plugin.websearch.ui;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class WebSearchImageLoadingUI$g
  implements Runnable
{
  WebSearchImageLoadingUI$g(WebSearchImageLoadingUI paramWebSearchImageLoadingUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(224534);
    Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).doJ().ys(this.DVm);
    boolean bool = WebSearchImageLoadingUI.cB((bv)localObject);
    ae.i(WebSearchImageLoadingUI.a(this.DVl), "tryDownloadImage msgId: %s, msgSvrId: %s, talker: %s, canDownload: %b", new Object[] { Long.valueOf(this.DVm), Long.valueOf(((bv)localObject).VY()), ((bv)localObject).Wa(), Boolean.valueOf(bool) });
    if (bool)
    {
      localObject = q.aIX().F(((bv)localObject).Wa(), ((bv)localObject).VY());
      WebSearchImageLoadingUI.a(this.DVl, ((com.tencent.mm.av.g)localObject).getLocalId());
      if (q.aIY().a(WebSearchImageLoadingUI.d(this.DVl), this.DVm, 0, Long.valueOf(this.DVm), 2131231564, (e.a)WebSearchImageLoadingUI.e(this.DVl), 0, true) != 0)
      {
        WebSearchImageLoadingUI.f(this.DVl);
        AppMethodBeat.o(224534);
        return;
      }
      WebSearchImageLoadingUI.a(this.DVl, true);
      h.MqF.aM((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(224533);
          WebSearchImageLoadingUI.g(this.Jim.DVl);
          AppMethodBeat.o(224533);
        }
      });
    }
    AppMethodBeat.o(224534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI.g
 * JD-Core Version:    0.7.0.1
 */