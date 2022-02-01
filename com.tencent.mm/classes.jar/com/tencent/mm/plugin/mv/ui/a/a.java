package com.tencent.mm.plugin.mv.ui.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.model.e;
import com.tencent.mm.plugin.mv.ui.uic.k.b;
import com.tencent.mm.plugin.mv.ui.uic.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;)V", "TAG", "", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVEditItemAction;", "itemWidth", "", "getSizeResolver", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerFixEditUIC$IMVItemSizeResolver;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f<e>
{
  public static final a MaU;
  private final k.c MaV;
  private final k.b MaW;
  private final String TAG;
  private final int wLI;
  
  static
  {
    AppMethodBeat.i(288217);
    MaU = new a((byte)0);
    AppMethodBeat.o(288217);
  }
  
  public a(k.c paramc, k.b paramb)
  {
    AppMethodBeat.i(288186);
    this.MaV = paramc;
    this.MaW = paramb;
    this.TAG = "MicroMsg.MusicMVVideoItemConverter";
    this.wLI = this.MaV.getItemWidth();
    AppMethodBeat.o(288186);
  }
  
  private static final void a(a parama, int paramInt, e parame, j paramj, View paramView)
  {
    AppMethodBeat.i(288194);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(parame);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(parame, "$item");
    s.u(paramj, "$holder");
    parama = parama.MaW;
    paramj = paramj.caK;
    s.s(paramj, "holder.itemView");
    parama.a(paramInt, parame, paramj);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288194);
  }
  
  private static final void b(a parama, int paramInt, e parame, j paramj, View paramView)
  {
    AppMethodBeat.i(288208);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(parame);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    s.u(parame, "$item");
    s.u(paramj, "$holder");
    parama = parama.MaW;
    paramj = paramj.caK;
    s.s(paramj, "holder.itemView");
    parama.b(paramInt, parame, paramj);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288208);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(288247);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = (LinearLayout)paramj.UH(b.e.LTy);
    Log.d(this.TAG, s.X("onCreateViewHolder, itemWidth:", Integer.valueOf(this.wLI)));
    paramRecyclerView.getLayoutParams().width = this.wLI;
    paramRecyclerView.getLayoutParams().height = -1;
    AppMethodBeat.o(288247);
  }
  
  public final int getLayoutId()
  {
    return b.f.LVK;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$Companion;", "", "()V", "handleSelection", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(j paramj, e parame)
    {
      AppMethodBeat.i(288146);
      s.u(paramj, "holder");
      s.u(parame, "item");
      paramj.caK.setSelected(parame.Bvd);
      View localView = paramj.UH(b.e.LTl);
      if (parame.Bvd)
      {
        if (parame.type != 0)
        {
          paramj.caK.findViewById(b.e.LTx).setVisibility(8);
          localView.setVisibility(0);
        }
        for (;;)
        {
          paramj.UH(b.e.LTw).setVisibility(0);
          AppMethodBeat.o(288146);
          return;
          paramj.caK.findViewById(b.e.LTx).setVisibility(0);
          localView.setVisibility(8);
        }
      }
      ((ProgressBar)paramj.caK.findViewById(b.e.LUr)).setProgress(0);
      paramj.caK.findViewById(b.e.LTx).setVisibility(0);
      localView.setVisibility(8);
      paramj.UH(b.e.LTw).setVisibility(8);
      AppMethodBeat.o(288146);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.a
 * JD-Core Version:    0.7.0.1
 */