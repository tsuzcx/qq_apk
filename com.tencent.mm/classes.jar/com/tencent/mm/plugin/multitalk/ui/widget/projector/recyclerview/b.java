package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;", "Landroid/view/View$OnClickListener;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/content/Context;)V", "bitmapHeight", "", "getBitmapHeight", "()I", "setBitmapHeight", "(I)V", "bitmapWidth", "getBitmapWidth", "setBitmapWidth", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isAttachWaitSmooth", "", "isLoadingAdded", "()Z", "setLoadingAdded", "(Z)V", "mCurrentHeight", "", "getMCurrentHeight", "()F", "setMCurrentHeight", "(F)V", "mCurrentIndex", "mCurrentWidth", "getMCurrentWidth", "setMCurrentWidth", "mMaxCount", "getMMaxCount", "setMMaxCount", "mOnItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "thumbnailList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/Bitmap;", "add", "bitmap", "addAll", "bitmapList", "", "addLoadingFooter", "applyCurrentThumbnail", "index", "w", "h", "clear", "getItem", "position", "getItemCount", "isEmpty", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "onClick", "v", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "remove", "setOnItemClickListener", "listener", "switchToPage", "updateThumbNail", "Companion", "plugin-multitalk_release"})
public final class b
  extends RecyclerView.a<d>
  implements View.OnClickListener
{
  public static final float FEt;
  public static final float FEu;
  public static final float FEv;
  public static final b.a FEw;
  private static final float radius;
  public CopyOnWriteArrayList<Bitmap> FDp;
  public int FEm;
  public int FEn;
  public float FEo;
  public float FEp;
  public boolean FEq;
  public m<? super View, ? super Integer, x> FEr;
  private boolean FEs;
  private Context context;
  public int mMaxCount;
  private RecyclerView mRecyclerView;
  public int uPV;
  
  static
  {
    AppMethodBeat.i(205608);
    FEw = new b.a((byte)0);
    FEt = f.FxW;
    FEu = f.FxU;
    FEv = f.FxO;
    radius = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    AppMethodBeat.o(205608);
  }
  
  public b(RecyclerView paramRecyclerView, Context paramContext)
  {
    AppMethodBeat.i(205607);
    this.mRecyclerView = paramRecyclerView;
    this.context = paramContext;
    this.FDp = new CopyOnWriteArrayList();
    this.FEm = -1;
    this.FEn = -1;
    this.mMaxCount = -1;
    this.uPV = -1;
    this.FEo = FEt;
    this.FEp = FEu;
    AppMethodBeat.o(205607);
  }
  
  public final void XR(int paramInt)
  {
    AppMethodBeat.i(205593);
    this.uPV = paramInt;
    notifyDataSetChanged();
    AppMethodBeat.o(205593);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(205598);
    p.k(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    this.FEs = true;
    AppMethodBeat.o(205598);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(205597);
    int i = this.FDp.size();
    AppMethodBeat.o(205597);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(205604);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    p.k(paramView, "v");
    localObject1 = this.FEr;
    if (localObject1 != null)
    {
      Object localObject2 = paramView.getTag();
      if (localObject2 == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(205604);
        throw paramView;
      }
      ((m)localObject1).invoke(paramView, (Integer)localObject2);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(205604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */