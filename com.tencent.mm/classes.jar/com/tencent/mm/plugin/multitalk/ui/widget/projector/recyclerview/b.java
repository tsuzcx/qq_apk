package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbnailLayoutHolder;", "Landroid/view/View$OnClickListener;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/content/Context;)V", "bitmapHeight", "", "getBitmapHeight", "()I", "setBitmapHeight", "(I)V", "bitmapWidth", "getBitmapWidth", "setBitmapWidth", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isAttachWaitSmooth", "", "isLoadingAdded", "()Z", "setLoadingAdded", "(Z)V", "mCurrentHeight", "", "getMCurrentHeight", "()F", "setMCurrentHeight", "(F)V", "mCurrentIndex", "mCurrentWidth", "getMCurrentWidth", "setMCurrentWidth", "mMaxCount", "getMMaxCount", "setMMaxCount", "mOnItemClickListener", "Lkotlin/Function2;", "Landroid/view/View;", "", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "thumbnailList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/graphics/Bitmap;", "add", "bitmap", "addAll", "bitmapList", "", "addLoadingFooter", "applyCurrentThumbnail", "index", "w", "h", "clear", "getItem", "position", "getItemCount", "isEmpty", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "onClick", "v", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "remove", "setOnItemClickListener", "listener", "switchToPage", "updateThumbNail", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends RecyclerView.a<d>
  implements View.OnClickListener
{
  public static final float LAd;
  public static final float LAe;
  public static final float LAf;
  public static final b.a LzV;
  private static final float radius;
  public boolean LAa;
  public m<? super View, ? super Integer, ah> LAb;
  private boolean LAc;
  public int LzW;
  public int LzX;
  public float LzY;
  public float LzZ;
  public CopyOnWriteArrayList<Bitmap> Lzf;
  private Context context;
  private RecyclerView mRecyclerView;
  public int sfk;
  public int xYG;
  
  static
  {
    AppMethodBeat.i(285907);
    LzV = new b.a((byte)0);
    LAd = f.Lui;
    LAe = f.Lug;
    LAf = f.Lua;
    radius = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    AppMethodBeat.o(285907);
  }
  
  public b(RecyclerView paramRecyclerView, Context paramContext)
  {
    AppMethodBeat.i(285899);
    this.mRecyclerView = paramRecyclerView;
    this.context = paramContext;
    this.Lzf = new CopyOnWriteArrayList();
    this.LzW = -1;
    this.LzX = -1;
    this.sfk = -1;
    this.xYG = -1;
    this.LzY = LAd;
    this.LzZ = LAe;
    AppMethodBeat.o(285899);
  }
  
  public final void acb(int paramInt)
  {
    AppMethodBeat.i(285913);
    this.xYG = paramInt;
    this.bZE.notifyChanged();
    AppMethodBeat.o(285913);
  }
  
  public final void d(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(285927);
    s.u(paramRecyclerView, "recyclerView");
    super.d(paramRecyclerView);
    this.LAc = true;
    AppMethodBeat.o(285927);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(285922);
    int i = this.Lzf.size();
    AppMethodBeat.o(285922);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(285939);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    s.u(paramView, "v");
    localObject1 = this.LAb;
    if (localObject1 != null)
    {
      Object localObject2 = paramView.getTag();
      if (localObject2 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(285939);
        throw paramView;
      }
      ((m)localObject1).invoke(paramView, Integer.valueOf(((Integer)localObject2).intValue()));
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbLayoutAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(285939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.b
 * JD-Core Version:    0.7.0.1
 */