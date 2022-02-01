package com.tencent.mm.plugin.mv.model.flex;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "listener", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "(Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateTime", "tv", "Landroid/widget/TextView;", "durationMs", "IOnDelBtnClickedListener", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<a>
{
  private final a LYy;
  
  public b(a parama)
  {
    AppMethodBeat.i(286235);
    this.LYy = parama;
    AppMethodBeat.o(286235);
  }
  
  private static final void a(b paramb, int paramInt, a parama, View paramView)
  {
    AppMethodBeat.i(286243);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    s.u(parama, "$item");
    paramb = paramb.LYy;
    if (paramb != null) {
      paramb.a(paramInt, parama);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286243);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(286256);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(286256);
  }
  
  public final int getLayoutId()
  {
    return b.f.LVt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/flex/MusicMvFlexVideoItemConvert$IOnDelBtnClickedListener;", "", "onClicked", "", "pos", "", "item", "Lcom/tencent/mm/plugin/mv/model/flex/MusicMVFlexVideoLiveItem;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt, a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.flex.b
 * JD-Core Version:    0.7.0.1
 */