package com.tencent.mm.plugin.textstatus.ui;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.textstatus.h.d.c;
import com.tencent.mm.plugin.textstatus.h.i;
import com.tencent.mm.plugin.textstatus.proto.ak;
import com.tencent.mm.plugin.textstatus.proto.bc;
import com.tencent.mm.plugin.textstatus.proto.bk;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$HistoryItemLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$DataLoader;", "statusID", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Ljava/lang/String;Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "continueFlag", "", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "onSceneEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getStatusID", "()Ljava/lang/String;", "hasMoreData", "loadNextPage", "", "release", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
final class TextStatusLikeListFragment$d
  extends TextStatusLikeListFragment.c
{
  private boolean ABD;
  private final RefreshLoadMoreLayout TwH;
  private b TwI;
  private final String Tzz;
  private final com.tencent.mm.am.h maV;
  
  public TextStatusLikeListFragment$d(String paramString, WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    super(paramWxRecyclerAdapter);
    AppMethodBeat.i(291448);
    this.Tzz = paramString;
    this.TwH = paramRefreshLoadMoreLayout;
    this.maV = new TextStatusLikeListFragment.d..ExternalSyntheticLambda0(this, paramWxRecyclerAdapter);
    com.tencent.mm.kernel.h.aZW().a(6621, this.maV);
    AppMethodBeat.o(291448);
  }
  
  private static final void a(d paramd, WxRecyclerAdapter paramWxRecyclerAdapter, int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(291461);
    kotlin.g.b.s.u(paramd, "this$0");
    kotlin.g.b.s.u(paramWxRecyclerAdapter, "$adapter");
    kotlin.g.b.s.u(paramp, "netSceneBase");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramp = ((i)paramp).TmR;
      if (paramp != null)
      {
        paramd.TwI = paramp.TpC;
        paramd.ABD = paramp.TpE;
        paramString = new ArrayList();
        paramString.addAll((Collection)paramp.TpH);
        paramString.addAll((Collection)paramp.TpI);
        paramp = (List)paramString;
        if (paramp.size() > 1) {
          kotlin.a.p.a(paramp, (Comparator)new a());
        }
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext())
        {
          paramp = paramString.next();
          if ((paramp instanceof bc)) {
            ((List)paramWxRecyclerAdapter.data).add(new com.tencent.mm.plugin.textstatus.h.d.a(paramd.Tzz, (bc)paramp));
          } else if ((paramp instanceof bk)) {
            ((List)paramWxRecyclerAdapter.data).add(new c(paramd.Tzz, (bk)paramp));
          }
        }
        paramWxRecyclerAdapter.bZE.notifyChanged();
      }
    }
    paramd.TwH.aFW(0);
    AppMethodBeat.o(291461);
  }
  
  public final void gir()
  {
    AppMethodBeat.i(291480);
    i locali = new i(this.Tzz, this.TwI);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)locali, 0);
    AppMethodBeat.o(291480);
  }
  
  public final boolean hJS()
  {
    return this.ABD;
  }
  
  public final void release()
  {
    AppMethodBeat.i(291495);
    com.tencent.mm.kernel.h.aZW().b(6621, this.maV);
    AppMethodBeat.o(291495);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      int j = 0;
      AppMethodBeat.i(291593);
      int i;
      if ((paramT2 instanceof bc))
      {
        i = ((bc)paramT2).HTK;
        paramT2 = (Comparable)Integer.valueOf(i);
        if (!(paramT1 instanceof bc)) {
          break label88;
        }
        i = ((bc)paramT1).HTK;
      }
      for (;;)
      {
        i = kotlin.b.a.b(paramT2, (Comparable)Integer.valueOf(i));
        AppMethodBeat.o(291593);
        return i;
        if ((paramT2 instanceof bk))
        {
          i = ((bk)paramT2).HTK;
          break;
        }
        i = 0;
        break;
        label88:
        i = j;
        if ((paramT1 instanceof bk)) {
          i = ((bk)paramT1).HTK;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListFragment.d
 * JD-Core Version:    0.7.0.1
 */