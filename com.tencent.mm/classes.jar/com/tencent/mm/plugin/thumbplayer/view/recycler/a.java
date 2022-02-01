package com.tencent.mm.plugin.thumbplayer.view.recycler;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.thumbplayer.f.b;
import com.tencent.mm.plugin.thumbplayer.view.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "videoLayoutId", "", "maxRemainCount", "(Landroidx/appcompat/app/AppCompatActivity;II)V", "TAG", "", "ThreadTag", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "busyVideoViewMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMRecyclerVideoLayout;", "", "getBusyVideoViewMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "idleVideoViews", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getMaxRemainCount", "()I", "getVideoLayoutId", "attachToRecyclerView", "", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "destroy", "getOrCreateVideoLayout", "recycleVideoLayout", "videoLayout", "plugin-thumbplayer_release"})
public final class a
{
  public final ConcurrentLinkedDeque<MMRecyclerVideoLayout> MVj;
  public final ConcurrentHashMap<MMRecyclerVideoLayout, Long> MVk;
  private final int MVl;
  private final int MVm;
  final String TAG;
  public final String qNn;
  private final AppCompatActivity xGq;
  
  public a(AppCompatActivity paramAppCompatActivity, int paramInt)
  {
    AppMethodBeat.i(191068);
    this.xGq = paramAppCompatActivity;
    this.MVl = paramInt;
    this.MVm = 3;
    this.qNn = "TP.Recycler";
    this.TAG = "MicroMsg.TP.MMVideoLayoutRecycler";
    this.MVj = new ConcurrentLinkedDeque();
    this.MVk = new ConcurrentHashMap();
    AppMethodBeat.o(191068);
  }
  
  public final MMRecyclerVideoLayout gpf()
  {
    AppMethodBeat.i(191067);
    Object localObject = (MMRecyclerVideoLayout)j.f((Iterable)this.MVj);
    String str;
    if (localObject != null)
    {
      str = "from idle queue";
      this.MVj.remove(localObject);
      if (localObject != null) {}
    }
    else
    {
      localObject = (a)this;
      str = "from create";
      localObject = new MMRecyclerVideoLayout((Context)((a)localObject).xGq);
    }
    for (;;)
    {
      ((MMRecyclerVideoLayout)localObject).setId(this.MVl);
      ((Map)this.MVk).put(localObject, Long.valueOf(cm.bfE()));
      Log.i(this.TAG, "getOrCreateVideoLayout ".concat(String.valueOf(str)));
      AppMethodBeat.o(191067);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public a(a parama, MMRecyclerVideoLayout paramMMRecyclerVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.recycler.a
 * JD-Core Version:    0.7.0.1
 */