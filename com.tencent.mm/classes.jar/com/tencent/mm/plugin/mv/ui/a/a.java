package com.tencent.mm.plugin.mv.ui.a;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mv.a.d;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.b;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMakerEditUIC.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/model/MusicMVVideoConvertData;", "sizeResolver", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "actionCallback", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;)V", "TAG", "", "getActionCallback", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVEditItemAction;", "itemWidth", "", "getSizeResolver", "()Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvMakerEditUIC$IMVItemSizeResolver;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-mv_release"})
public final class a
  extends e<d>
{
  public static final a.c JRL;
  private final MusicMvMakerEditUIC.c ArU;
  final MusicMvMakerEditUIC.b ArV;
  private final String TAG;
  private final int qmd;
  
  static
  {
    AppMethodBeat.i(258209);
    JRL = new a.c((byte)0);
    AppMethodBeat.o(258209);
  }
  
  public a(MusicMvMakerEditUIC.c paramc, MusicMvMakerEditUIC.b paramb)
  {
    AppMethodBeat.i(257000);
    this.ArU = paramc;
    this.ArV = paramb;
    this.TAG = "MicroMsg.MusicMVVideoItemConverter";
    this.qmd = this.ArU.getItemWidth();
    AppMethodBeat.o(257000);
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(256997);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = (LinearLayout)paramh.Mn(2131305146);
    Log.d(this.TAG, "onCreateViewHolder, itemWidth:" + this.qmd);
    p.g(paramRecyclerView, "root");
    paramRecyclerView.getLayoutParams().width = this.qmd;
    paramRecyclerView.getLayoutParams().height = -1;
    AppMethodBeat.o(256997);
  }
  
  public final int getLayoutId()
  {
    return 2131495798;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(a parama, int paramInt, d paramd, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256995);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.ArW.ArV;
      int i = this.gUj;
      localObject = this.ArX;
      View localView = this.qhp.aus;
      p.g(localView, "holder.itemView");
      paramView.a(i, (d)localObject, localView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256995);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, int paramInt, d paramd, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256996);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.ArW.ArV;
      int i = this.gUj;
      localObject = this.ArX;
      View localView = this.qhp.aus;
      p.g(localView, "holder.itemView");
      paramView.b(i, (d)localObject, localView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/convert/MusicMVVideoItemConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(256996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.a
 * JD-Core Version:    0.7.0.1
 */