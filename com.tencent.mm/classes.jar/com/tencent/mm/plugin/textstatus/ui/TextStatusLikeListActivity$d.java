package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.textstatus.f.f;
import com.tencent.mm.plugin.textstatus.g.n;
import com.tencent.mm.plugin.textstatus.g.u;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$HistoryItemLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "statusID", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Ljava/lang/String;Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "continueFlag", "", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "onSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getStatusID", "()Ljava/lang/String;", "hasMoreData", "loadNextPage", "", "release", "plugin-textstatus_release"})
final class TextStatusLikeListActivity$d
  extends TextStatusLikeListActivity.c
{
  private b Gdn;
  final RefreshLoadMoreLayout Gdo;
  final String Gfz;
  private final i gNh;
  private boolean tuG;
  
  public TextStatusLikeListActivity$d(String paramString, final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    super(paramWxRecyclerAdapter);
    AppMethodBeat.i(216630);
    this.Gfz = paramString;
    this.Gdo = paramRefreshLoadMoreLayout;
    this.gNh = ((i)new a(this, paramWxRecyclerAdapter));
    g.azz().a(6621, this.gNh);
    AppMethodBeat.o(216630);
  }
  
  public final void epE()
  {
    AppMethodBeat.i(216628);
    f localf = new f(this.Gfz, this.Gdn);
    g.azz().b((q)localf);
    AppMethodBeat.o(216628);
  }
  
  public final boolean fwE()
  {
    return this.tuG;
  }
  
  public final void release()
  {
    AppMethodBeat.i(216629);
    g.azz().b(6621, this.gNh);
    AppMethodBeat.o(216629);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "netSceneBase", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class a
    implements i
  {
    a(TextStatusLikeListActivity.d paramd, WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(216627);
      p.h(paramq, "netSceneBase");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((f)paramq).FYY;
        if (paramString != null)
        {
          TextStatusLikeListActivity.d.a(this.GfA, paramString.GaF);
          TextStatusLikeListActivity.d.a(this.GfA, paramString.GaH);
          paramString = paramString.GaK;
          if (paramString != null)
          {
            paramString = ((Iterable)paramString).iterator();
            while (paramString.hasNext())
            {
              paramq = (u)paramString.next();
              if (paramq != null) {
                ((List)paramWxRecyclerAdapter.data).add(new com.tencent.mm.plugin.textstatus.f.c.a(this.GfA.Gfz, paramq));
              }
            }
          }
          paramWxRecyclerAdapter.notifyDataSetChanged();
        }
      }
      this.GfA.Gdo.apT(0);
      AppMethodBeat.o(216627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.d
 * JD-Core Version:    0.7.0.1
 */