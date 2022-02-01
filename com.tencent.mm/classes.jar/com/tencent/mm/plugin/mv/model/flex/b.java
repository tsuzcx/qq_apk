package com.tencent.mm.plugin.mv.model.flex;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "listener", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "(Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateTime", "tv", "Landroid/widget/TextView;", "durationMs", "IOnDelBtnClickedListener", "plugin-mv_release"})
public final class b
  extends e<a>
{
  final a GcQ;
  
  public b(a parama)
  {
    AppMethodBeat.i(229849);
    this.GcQ = parama;
    AppMethodBeat.o(229849);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(229847);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(229847);
  }
  
  public final int getLayoutId()
  {
    return b.f.FZw;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "", "onClicked", "", "pos", "", "item", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "plugin-mv_release"})
  public static abstract interface a
  {
    public abstract void a(int paramInt, a parama);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(b paramb, int paramInt, a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(239460);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.GcR.GcQ;
      if (paramView != null) {
        paramView.a(this.jEN, this.GcS);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(239460);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.flex.b
 * JD-Core Version:    0.7.0.1
 */