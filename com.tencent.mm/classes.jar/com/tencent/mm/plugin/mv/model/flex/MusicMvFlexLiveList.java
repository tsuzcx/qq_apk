package com.tencent.mm.plugin.mv.model.flex;

import androidx.lifecycle.LiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.plugin.mvvmlist.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexLiveList;", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "_selectedItemChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "selectedItemFlow", "Lkotlinx/coroutines/flow/Flow;", "getSelectedItemFlow", "()Lkotlinx/coroutines/flow/Flow;", "submitBgUpdate", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvFlexLiveList
  extends MvvmList<a>
{
  private final kotlinx.coroutines.a.q<HashSet<a>> LYv;
  public final g<HashSet<a>> LYw;
  
  public MusicMvFlexLiveList(com.tencent.mm.plugin.mvvmlist.a.f<a, c<a>, d<a>> paramf, e parame, androidx.lifecycle.q paramq)
  {
    super(paramf, parame, paramq);
    AppMethodBeat.i(286232);
    this.MmR.a(paramq, new MusicMvFlexLiveList..ExternalSyntheticLambda0(this));
    this.LYv = new kotlinx.coroutines.a.q();
    this.LYw = k.a((kotlinx.coroutines.a.f)this.LYv);
    AppMethodBeat.o(286232);
  }
  
  private static final void a(MusicMvFlexLiveList paramMusicMvFlexLiveList, List paramList)
  {
    AppMethodBeat.i(286237);
    s.u(paramMusicMvFlexLiveList, "this$0");
    paramMusicMvFlexLiveList = paramMusicMvFlexLiveList.LYv;
    s.s(paramList, "it");
    paramMusicMvFlexLiveList.offer(p.o((Iterable)paramList));
    AppMethodBeat.o(286237);
  }
  
  public final void gpN()
  {
    AppMethodBeat.i(286249);
    aA((b)a.LYx);
    AppMethodBeat.o(286249);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<ArrayList<a>, ah>
  {
    public static final a LYx;
    
    static
    {
      AppMethodBeat.i(286231);
      LYx = new a();
      AppMethodBeat.o(286231);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.flex.MusicMvFlexLiveList
 * JD-Core Version:    0.7.0.1
 */