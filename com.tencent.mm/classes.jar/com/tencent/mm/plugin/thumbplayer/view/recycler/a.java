package com.tencent.mm.plugin.thumbplayer.view.recycler;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.thumbplayer.e.b;
import com.tencent.mm.plugin.thumbplayer.view.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "videoLayoutId", "", "maxRemainCount", "(Landroidx/appcompat/app/AppCompatActivity;II)V", "TAG", "", "ThreadTag", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "busyVideoViewMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMRecyclerVideoLayout;", "", "getBusyVideoViewMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "idleVideoViews", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "getMaxRemainCount", "()I", "getVideoLayoutId", "attachToRecyclerView", "", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "destroy", "getOrCreateVideoLayout", "recycleVideoLayout", "videoLayout", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  final String TAG;
  private final int THL;
  private final int THM;
  public final ConcurrentLinkedDeque<MMRecyclerVideoLayout> THN;
  public final ConcurrentHashMap<MMRecyclerVideoLayout, Long> THO;
  private final AppCompatActivity activity;
  public final String tRX;
  
  public a(AppCompatActivity paramAppCompatActivity, int paramInt)
  {
    AppMethodBeat.i(272446);
    this.activity = paramAppCompatActivity;
    this.THL = paramInt;
    this.THM = 3;
    this.tRX = "TP.Recycler";
    this.TAG = "MicroMsg.TP.MMVideoLayoutRecycler";
    this.THN = new ConcurrentLinkedDeque();
    this.THO = new ConcurrentHashMap();
    AppMethodBeat.o(272446);
  }
  
  public final MMRecyclerVideoLayout hLR()
  {
    AppMethodBeat.i(272453);
    Object localObject = (MMRecyclerVideoLayout)p.f((Iterable)this.THN);
    String str;
    if (localObject == null)
    {
      localObject = null;
      str = null;
      if (localObject != null) {
        break label117;
      }
      localObject = (a)this;
      str = "from create";
      localObject = new MMRecyclerVideoLayout((Context)((a)localObject).activity);
    }
    label117:
    for (;;)
    {
      ((MMRecyclerVideoLayout)localObject).setId(this.THL);
      ((Map)this.THO).put(localObject, Long.valueOf(cn.bDw()));
      Log.i(this.TAG, s.X("getOrCreateVideoLayout ", str));
      AppMethodBeat.o(272453);
      return localObject;
      str = "from idle queue";
      this.THN.remove(localObject);
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public a(MMRecyclerVideoLayout paramMMRecyclerVideoLayout, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.recycler.a
 * JD-Core Version:    0.7.0.1
 */