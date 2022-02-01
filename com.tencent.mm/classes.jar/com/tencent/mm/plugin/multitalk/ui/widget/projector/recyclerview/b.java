package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;", "Landroid/view/View$OnClickListener;", "mRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/support/v7/widget/RecyclerView;Landroid/content/Context;)V", "bitmapHeight", "", "getBitmapHeight", "()I", "setBitmapHeight", "(I)V", "bitmapWidth", "getBitmapWidth", "setBitmapWidth", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isAttachWaitSmooth", "", "isLoadingAdded", "()Z", "setLoadingAdded", "(Z)V", "mCurrentHeight", "", "getMCurrentHeight", "()F", "setMCurrentHeight", "(F)V", "mCurrentIndex", "mCurrentWidth", "getMCurrentWidth", "setMCurrentWidth", "mMaxCount", "getMMaxCount", "setMMaxCount", "mOnItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "getMRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "thumbnailList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/Bitmap;", "add", "bitmap", "addAll", "bitmapList", "", "addLoadingFooter", "applyCurrentThumbnail", "index", "w", "h", "clear", "getItem", "position", "getItemCount", "isEmpty", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "onClick", "v", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "remove", "setOnItemClickListener", "listener", "switchToPage", "updateThumbNail", "Companion", "plugin-multitalk_release"})
public final class b
  extends RecyclerView.a<d>
  implements View.OnClickListener
{
  private static final float radius;
  public static final float zYI;
  public static final float zYJ;
  public static final float zYK;
  public static final b.a zYL;
  private Context context;
  public int mMaxCount;
  private RecyclerView mRecyclerView;
  public int rmJ;
  public CopyOnWriteArrayList<Bitmap> zXD;
  public int zYB;
  public int zYC;
  public float zYD;
  public float zYE;
  public boolean zYF;
  public m<? super View, ? super Integer, x> zYG;
  private boolean zYH;
  
  static
  {
    AppMethodBeat.i(240079);
    zYL = new b.a((byte)0);
    zYI = f.zSu;
    zYJ = f.zSs;
    zYK = f.zSm;
    radius = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    AppMethodBeat.o(240079);
  }
  
  public b(RecyclerView paramRecyclerView, Context paramContext)
  {
    AppMethodBeat.i(240078);
    this.mRecyclerView = paramRecyclerView;
    this.context = paramContext;
    this.zXD = new CopyOnWriteArrayList();
    this.zYB = -1;
    this.zYC = -1;
    this.mMaxCount = -1;
    this.rmJ = -1;
    this.zYD = zYI;
    this.zYE = zYJ;
    AppMethodBeat.o(240078);
  }
  
  public final void RB(int paramInt)
  {
    AppMethodBeat.i(240072);
    this.rmJ = paramInt;
    notifyDataSetChanged();
    AppMethodBeat.o(240072);
  }
  
  public final void b(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(240075);
    p.h(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView);
    this.zYH = true;
    AppMethodBeat.o(240075);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(240074);
    int i = this.zXD.size();
    AppMethodBeat.o(240074);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(240077);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    p.h(paramView, "v");
    localObject1 = this.zYG;
    if (localObject1 != null)
    {
      Object localObject2 = paramView.getTag();
      if (localObject2 == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(240077);
        throw paramView;
      }
      ((m)localObject1).invoke(paramView, (Integer)localObject2);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(240077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */