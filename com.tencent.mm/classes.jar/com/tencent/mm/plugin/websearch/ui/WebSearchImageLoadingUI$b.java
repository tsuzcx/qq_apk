package com.tencent.mm.plugin.websearch.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/websearch/ui/WebSearchImageLoadingUI$downloadImageCallback$1", "Lcom/tencent/mm/modelimage/DownloadImgService$IOnImgTaskListener;", "onImgTaskCanceled", "", "imgLocalId", "", "msgLocalId", "compressType", "", "resId", "data", "", "onImgTaskEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onImgTaskProgress", "offset", "totalLen", "ui-websearch_release"})
public final class WebSearchImageLoadingUI$b
  implements e.a
{
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(224526);
    ae.i(WebSearchImageLoadingUI.a(this.DVl), "onImgTaskCanceled msgId: %d, imgLocalId: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
    WebSearchImageLoadingUI.a(this.DVl, false);
    AppMethodBeat.o(224526);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn)
  {
    AppMethodBeat.i(224525);
    ae.d(WebSearchImageLoadingUI.a(this.DVl), "onImgTaskProgress msgId: %d, imgLocalId: %d, compressType: %d, offset: %d, totalLen: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(224525);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(224524);
    ae.i(WebSearchImageLoadingUI.a(this.DVl), "onImgTaskEnd msgId: %d, imgLocalId: %d, compressType: %d, errType %d, errCode: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    WebSearchImageLoadingUI.a(this.DVl, false);
    WebSearchImageLoadingUI.h(this.DVl);
    AppMethodBeat.o(224524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchImageLoadingUI.b
 * JD-Core Version:    0.7.0.1
 */