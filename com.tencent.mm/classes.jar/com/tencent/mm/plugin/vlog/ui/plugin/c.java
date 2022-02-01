package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.v;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "previewId", "", "getRecycler", "()Landroid/support/v7/widget/RecyclerView;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "getSelectPathList", "()Ljava/util/ArrayList;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCurrentId", "", "initRecyclerView", "", "onDetach", "select", "index", "setVisibility", "visibility", "updateList", "list", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "PreviewItemView", "plugin-vlog_release"})
public final class c
  implements t
{
  public static final c.a GGD;
  final ArrayList<GalleryItem.MediaItem> GGB;
  private c.b GGC;
  private final RecyclerView gTW;
  private long vLr;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d wgr;
  
  static
  {
    AppMethodBeat.i(191210);
    GGD = new c.a((byte)0);
    AppMethodBeat.o(191210);
  }
  
  public c(RecyclerView paramRecyclerView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(191209);
    this.gTW = paramRecyclerView;
    this.wgr = paramd;
    this.GGB = new ArrayList();
    this.gTW.setHasFixedSize(true);
    this.gTW.getContext();
    paramRecyclerView = new LinearLayoutManager();
    paramRecyclerView.setOrientation(0);
    paramRecyclerView.setItemPrefetchEnabled(true);
    this.gTW.setLayoutManager((RecyclerView.LayoutManager)paramRecyclerView);
    this.gTW.setItemAnimator((RecyclerView.f)new v());
    this.gTW.b((RecyclerView.h)new c.e(this));
    this.GGC = new c.b(this);
    paramRecyclerView = this.GGC;
    if (paramRecyclerView == null) {
      p.btv("adapter");
    }
    paramRecyclerView.setItems((List)this.GGB);
    paramRecyclerView = this.GGC;
    if (paramRecyclerView == null) {
      p.btv("adapter");
    }
    new android.support.v7.widget.a.a((android.support.v7.widget.a.a.a)new c((com.tencent.mm.ui.base.a.a)paramRecyclerView)).f(this.gTW);
    paramRecyclerView = this.gTW;
    paramd = this.GGC;
    if (paramd == null) {
      p.btv("adapter");
    }
    paramRecyclerView.setAdapter((RecyclerView.a)paramd);
    paramRecyclerView = this.GGC;
    if (paramRecyclerView == null) {
      p.btv("adapter");
    }
    paramRecyclerView.OXb = ((com.tencent.mm.ui.base.a.a.a)new f(this));
    this.gTW.setVisibility(0);
    AppMethodBeat.o(191209);
  }
  
  public final void aSs() {}
  
  public final void aU(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(191204);
    p.h(paramArrayList, "list");
    Log.i("MicroMsg.EditFooterRecyclerPlugin", "updateList = " + paramArrayList.size());
    this.GGB.clear();
    this.GGB.addAll((Collection)paramArrayList);
    paramArrayList = this.GGC;
    if (paramArrayList == null) {
      p.btv("adapter");
    }
    paramArrayList.setItems((List)this.GGB);
    paramArrayList = this.GGC;
    if (paramArrayList == null) {
      p.btv("adapter");
    }
    paramArrayList.notifyDataSetChanged();
    AppMethodBeat.o(191204);
  }
  
  public final int fCS()
  {
    AppMethodBeat.i(191206);
    Iterator localIterator = ((Iterable)this.GGB).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.hxH();
      }
      if (((GalleryItem.MediaItem)localObject).xiZ == this.vLr)
      {
        AppMethodBeat.o(191206);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(191206);
    return 0;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(191208);
    c.b localb = this.GGC;
    if (localb == null) {
      p.btv("adapter");
    }
    localb.clearItems();
    AppMethodBeat.o(191208);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191211);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191211);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(191205);
    int i = ((Collection)this.GGB).size();
    if (paramInt >= 0)
    {
      if (i <= paramInt) {
        AppMethodBeat.o(191205);
      }
    }
    else
    {
      AppMethodBeat.o(191205);
      return;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.GGB.get(paramInt);
    this.vLr = localMediaItem.xiZ;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE", (Parcelable)localMediaItem);
    this.wgr.a(d.c.BWa, localBundle);
    AppMethodBeat.o(191205);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191207);
    this.gTW.setVisibility(paramInt);
    AppMethodBeat.o(191207);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-vlog_release"})
  public final class c
    extends android.support.v7.widget.a.a.a
  {
    int eeE;
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, c.d> vLA;
    private int vLx;
    private int vLy;
    private int vLz;
    
    public c()
    {
      AppMethodBeat.i(191196);
      this.vLA = localObject;
      this.eeE = -1;
      this.vLx = -1;
      this.vLy = -1;
      AppMethodBeat.o(191196);
    }
    
    public final float M(RecyclerView.v paramv)
    {
      AppMethodBeat.i(191193);
      p.h(paramv, "viewHolder");
      AppMethodBeat.o(191193);
      return 0.295858F;
    }
    
    public final void N(RecyclerView.v paramv)
    {
      AppMethodBeat.i(191192);
      p.h(paramv, "viewHolder");
      AppMethodBeat.o(191192);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(191195);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramv, "viewHolder");
      int i = android.support.v7.widget.a.a.a.db(51);
      AppMethodBeat.o(191195);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(191194);
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramv, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(191194);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(191189);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramv1, "viewHolder");
      p.h(paramv2, "target");
      int i = paramv1.lR();
      int j = paramv2.lR();
      Log.d("MicroMsg.EditFooterRecyclerPlugin", "[onMove] from=" + i + " to=" + j);
      com.tencent.mm.plugin.gallery.a.d.swap((List)c.this.GGB, i, j);
      this.vLA.ar(i, j);
      this.vLy = j;
      AppMethodBeat.o(191189);
      return true;
    }
    
    public final void d(RecyclerView paramRecyclerView, final RecyclerView.v paramv)
    {
      AppMethodBeat.i(191191);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramv, "viewHolder");
      super.d(paramRecyclerView, paramv);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), 2130772113);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramv));
      paramv.aus.startAnimation(paramRecyclerView);
      AppMethodBeat.o(191191);
    }
    
    public final void f(final RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(191190);
      super.f(paramv, paramInt);
      if (paramv != null)
      {
        Object localObject = paramv.aus;
        p.g(localObject, "viewHolder.itemView");
        localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772114);
        ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramv, paramInt));
        paramv.aus.startAnimation((Animation)localObject);
      }
      AppMethodBeat.o(191190);
    }
    
    public final boolean nq()
    {
      return true;
    }
    
    public final boolean nr()
    {
      return false;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.v paramv) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(191184);
        p.h(paramAnimation, "animation");
        paramAnimation = paramv.aus;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        Log.d("MicroMsg.EditFooterRecyclerPlugin", "finally change from=" + c.c.b(this.GGG) + " to=" + c.c.a(this.GGG));
        AppMethodBeat.o(191184);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(191185);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(191185);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(191183);
        p.h(paramAnimation, "animation");
        paramAnimation = paramv.aus;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        AppMethodBeat.o(191183);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
    public static final class b
      implements Animation.AnimationListener
    {
      b(c.c paramc, RecyclerView.v paramv, int paramInt) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(191187);
        p.h(paramAnimation, "animation");
        paramAnimation = paramv.aus;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        AppMethodBeat.o(191187);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(191188);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(191188);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(191186);
        p.h(paramAnimation, "animation");
        paramAnimation = paramv.aus;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        if (paramInt == 2)
        {
          c.c.a(this.GGG, paramv.lR());
          c.c.b(this.GGG, c.c.a(this.GGG));
          this.GGG.eeE = c.c.c(this.GGG);
        }
        AppMethodBeat.o(191186);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$2", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-vlog_release"})
  public static final class f
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c
 * JD-Core Version:    0.7.0.1
 */