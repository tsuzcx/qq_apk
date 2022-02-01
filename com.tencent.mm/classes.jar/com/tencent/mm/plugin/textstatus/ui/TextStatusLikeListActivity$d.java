package com.tencent.mm.plugin.textstatus.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.textstatus.g.b.c;
import com.tencent.mm.plugin.textstatus.proto.ak;
import com.tencent.mm.plugin.textstatus.proto.an;
import com.tencent.mm.plugin.textstatus.proto.v;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$HistoryItemLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "statusID", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Ljava/lang/String;Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "continueFlag", "", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "onSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getStatusID", "()Ljava/lang/String;", "hasMoreData", "loadNextPage", "", "release", "plugin-textstatus_release"})
final class TextStatusLikeListActivity$d
  extends TextStatusLikeListActivity.c
{
  private b MKx;
  final RefreshLoadMoreLayout MKy;
  final String MNy;
  private final i jxB;
  private boolean xcp;
  
  public TextStatusLikeListActivity$d(String paramString, final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    super(paramWxRecyclerAdapter);
    AppMethodBeat.i(234655);
    this.MNy = paramString;
    this.MKy = paramRefreshLoadMoreLayout;
    this.jxB = ((i)new a(this, paramWxRecyclerAdapter));
    com.tencent.mm.kernel.h.aGY().a(6621, this.jxB);
    AppMethodBeat.o(234655);
  }
  
  public final void eZs()
  {
    AppMethodBeat.i(234651);
    com.tencent.mm.plugin.textstatus.g.h localh = new com.tencent.mm.plugin.textstatus.g.h(this.MNy, this.MKx);
    com.tencent.mm.kernel.h.aGY().b((q)localh);
    AppMethodBeat.o(234651);
  }
  
  public final boolean gnv()
  {
    return this.xcp;
  }
  
  public final void release()
  {
    AppMethodBeat.i(234654);
    com.tencent.mm.kernel.h.aGY().b(6621, this.jxB);
    AppMethodBeat.o(234654);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "netSceneBase", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class a
    implements i
  {
    a(TextStatusLikeListActivity.d paramd, WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(236561);
      p.k(paramq, "netSceneBase");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramq = ((com.tencent.mm.plugin.textstatus.g.h)paramq).MDm;
        if (paramq != null)
        {
          TextStatusLikeListActivity.d.a(this.MNz, paramq.MFp);
          TextStatusLikeListActivity.d.a(this.MNz, paramq.MFr);
          paramString = new ArrayList();
          paramString.addAll((Collection)paramq.MFu);
          paramString.addAll((Collection)paramq.MFv);
          paramq = (List)paramString;
          if (paramq.size() > 1) {
            j.a(paramq, (Comparator)new a());
          }
          paramString = ((Iterable)paramString).iterator();
          while (paramString.hasNext())
          {
            paramq = paramString.next();
            if ((paramq instanceof ak)) {
              ((List)paramWxRecyclerAdapter.data).add(new com.tencent.mm.plugin.textstatus.g.b.a(this.MNz.MNy, (ak)paramq));
            } else if ((paramq instanceof an)) {
              ((List)paramWxRecyclerAdapter.data).add(new c(this.MNz.MNy, (an)paramq));
            }
          }
          paramWxRecyclerAdapter.notifyDataSetChanged();
        }
      }
      this.MNz.MKy.azs(0);
      AppMethodBeat.o(236561);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
    public static final class a<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        int j = 0;
        AppMethodBeat.i(237443);
        int i;
        if ((paramT2 instanceof ak))
        {
          i = ((ak)paramT2).ChC;
          paramT2 = (Comparable)Integer.valueOf(i);
          if (!(paramT1 instanceof ak)) {
            break label88;
          }
          i = ((ak)paramT1).ChC;
        }
        for (;;)
        {
          i = kotlin.b.a.a(paramT2, (Comparable)Integer.valueOf(i));
          AppMethodBeat.o(237443);
          return i;
          if ((paramT2 instanceof an))
          {
            i = ((an)paramT2).ChC;
            break;
          }
          i = 0;
          break;
          label88:
          i = j;
          if ((paramT1 instanceof an)) {
            i = ((an)paramT1).ChC;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.d
 * JD-Core Version:    0.7.0.1
 */