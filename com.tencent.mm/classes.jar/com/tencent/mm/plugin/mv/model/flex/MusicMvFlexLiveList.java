package com.tencent.mm.plugin.mv.model.flex;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.livelist.a.c;
import com.tencent.mm.plugin.livelist.a.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.g.b.q;
import kotlin.x;
import kotlinx.coroutines.a.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexLiveList;", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "_selectedItemChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "selectedItemFlow", "Lkotlinx/coroutines/flow/Flow;", "getSelectedItemFlow", "()Lkotlinx/coroutines/flow/Flow;", "submitBgUpdate", "", "plugin-mv_release"})
public final class MusicMvFlexLiveList
  extends MMLiveList<a>
{
  private final n<HashSet<a>> GcM;
  public final kotlinx.coroutines.b.b<HashSet<a>> GcN;
  
  public MusicMvFlexLiveList(com.tencent.mm.plugin.livelist.a.e<a, c<a>, d<a>> parame, com.tencent.mm.plugin.livelist.f paramf, androidx.lifecycle.l paraml)
  {
    super(parame, paramf, paraml);
    AppMethodBeat.i(227515);
    this.EhK.a(paraml, (s)new s() {});
    this.GcM = new n();
    this.GcN = kotlinx.coroutines.b.e.a((kotlinx.coroutines.a.f)this.GcM);
    AppMethodBeat.o(227515);
  }
  
  public final void fgm()
  {
    AppMethodBeat.i(227513);
    T((kotlin.g.a.b)a.GcP);
    AppMethodBeat.o(227513);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<ArrayList<a>, x>
  {
    public static final a GcP;
    
    static
    {
      AppMethodBeat.i(228722);
      GcP = new a();
      AppMethodBeat.o(228722);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.flex.MusicMvFlexLiveList
 * JD-Core Version:    0.7.0.1
 */