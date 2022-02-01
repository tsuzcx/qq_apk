package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.f.e;
import com.tencent.mm.plugin.textstatus.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$HistoryItemLoader;", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "continueFlag", "", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "onSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "hasMoreData", "loadNextPage", "", "release", "plugin-textstatus_release"})
final class StatusAlbumUI$b
{
  b Gdn;
  final RefreshLoadMoreLayout Gdo;
  final i gNh;
  final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> tFp;
  boolean tuG;
  
  public StatusAlbumUI$b(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(216420);
    this.tFp = paramWxRecyclerAdapter;
    this.Gdo = paramRefreshLoadMoreLayout;
    this.gNh = ((i)new a(this));
    g.azz().a(4245, this.gNh);
    AppMethodBeat.o(216420);
  }
  
  public final void epE()
  {
    AppMethodBeat.i(216419);
    e locale = new e(this.Gdn);
    g.azz().b((com.tencent.mm.ak.q)locale);
    AppMethodBeat.o(216419);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "netSceneBase", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class a
    implements i
  {
    a(StatusAlbumUI.b paramb) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(216418);
      p.h(paramq, "netSceneBase");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((e)paramq).FYW;
        if (paramString != null)
        {
          this.Gdp.Gdn = paramString.GaF;
          this.Gdp.tuG = paramString.GaH;
          paramString = paramString.GaG;
          if (paramString != null)
          {
            paramString = ((Iterable)paramString).iterator();
            while (paramString.hasNext())
            {
              paramq = (com.tencent.mm.plugin.textstatus.g.q)paramString.next();
              if (paramq != null) {
                ((List)this.Gdp.tFp.data).add(new com.tencent.mm.plugin.textstatus.f.a.a(paramq));
              }
            }
          }
          Log.i("MicroMsg.TxtStatus.StatusAlbumUI", "data size = " + ((List)this.Gdp.tFp.data).size() + ", continueFlag: " + this.Gdp.tuG);
        }
      }
      this.Gdp.Gdo.apT(0);
      AppMethodBeat.o(216418);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI.b
 * JD-Core Version:    0.7.0.1
 */