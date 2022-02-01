package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.g.g;
import com.tencent.mm.plugin.textstatus.proto.aa;
import com.tencent.mm.plugin.textstatus.proto.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$HistoryItemLoader;", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "continueFlag", "", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "onSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "hasMoreData", "loadNextPage", "", "release", "plugin-textstatus_release"})
final class StatusAlbumUI$b
{
  b MKx;
  final RefreshLoadMoreLayout MKy;
  final i jxB;
  boolean xcp;
  final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> xnR;
  
  public StatusAlbumUI$b(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(232691);
    this.xnR = paramWxRecyclerAdapter;
    this.MKy = paramRefreshLoadMoreLayout;
    this.jxB = ((i)new a(this));
    h.aGY().a(4245, this.jxB);
    AppMethodBeat.o(232691);
  }
  
  public final void eZs()
  {
    AppMethodBeat.i(232686);
    g localg = new g(this.MKx);
    h.aGY().b((q)localg);
    AppMethodBeat.o(232686);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "netSceneBase", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class a
    implements i
  {
    a(StatusAlbumUI.b paramb) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(232315);
      p.k(paramq, "netSceneBase");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((g)paramq).MDk;
        if (paramString != null)
        {
          this.MKz.MKx = paramString.MFp;
          this.MKz.xcp = paramString.MFr;
          paramString = paramString.MFq;
          if (paramString != null)
          {
            paramString = ((Iterable)paramString).iterator();
            while (paramString.hasNext())
            {
              paramq = (aa)paramString.next();
              if (paramq != null) {
                ((List)this.MKz.xnR.data).add(new com.tencent.mm.plugin.textstatus.g.a.a(paramq));
              }
            }
          }
          Log.i("MicroMsg.TextStatus.StatusAlbumUI", "data size = " + ((List)this.MKz.xnR.data).size() + ", continueFlag: " + this.MKz.xcp);
        }
      }
      this.MKz.MKy.azs(0);
      AppMethodBeat.o(232315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI.b
 * JD-Core Version:    0.7.0.1
 */