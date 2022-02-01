package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.graphics.Canvas;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.v;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "previewId", "", "getRecycler", "()Landroid/support/v7/widget/RecyclerView;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "getSelectPathList", "()Ljava/util/ArrayList;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCurrentId", "", "initRecyclerView", "", "onDetach", "select", "index", "setVisibility", "visibility", "updateList", "list", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "PreviewItemView", "plugin-vlog_release"})
public final class b
  implements t
{
  public static final b.a Cel;
  public final ArrayList<GalleryItem.MediaItem> Cej;
  public b Cek;
  private final RecyclerView gjR;
  public long sOn;
  public com.tencent.mm.plugin.recordvideo.plugin.parent.d tbP;
  
  static
  {
    AppMethodBeat.i(191611);
    Cel = new b.a((byte)0);
    AppMethodBeat.o(191611);
  }
  
  public b(RecyclerView paramRecyclerView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(191610);
    this.gjR = paramRecyclerView;
    this.tbP = paramd;
    this.Cej = new ArrayList();
    this.gjR.setHasFixedSize(true);
    this.gjR.getContext();
    paramRecyclerView = new LinearLayoutManager();
    paramRecyclerView.setOrientation(0);
    paramRecyclerView.aw(true);
    this.gjR.setLayoutManager((RecyclerView.i)paramRecyclerView);
    this.gjR.setItemAnimator((RecyclerView.f)new v());
    this.gjR.b((RecyclerView.h)new b.e(this));
    this.Cek = new b();
    paramRecyclerView = this.Cek;
    if (paramRecyclerView == null) {
      p.bdF("adapter");
    }
    paramRecyclerView.setItems((List)this.Cej);
    paramRecyclerView = this.Cek;
    if (paramRecyclerView == null) {
      p.bdF("adapter");
    }
    new android.support.v7.widget.a.a((android.support.v7.widget.a.a.a)new c((com.tencent.mm.ui.base.a.a)paramRecyclerView)).j(this.gjR);
    paramRecyclerView = this.gjR;
    paramd = this.Cek;
    if (paramd == null) {
      p.bdF("adapter");
    }
    paramRecyclerView.setAdapter((RecyclerView.a)paramd);
    paramRecyclerView = this.Cek;
    if (paramRecyclerView == null) {
      p.bdF("adapter");
    }
    paramRecyclerView.JMe = ((com.tencent.mm.ui.base.a.a.a)new f(this));
    this.gjR.setVisibility(0);
    AppMethodBeat.o(191610);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(191609);
    b localb = this.Cek;
    if (localb == null) {
      p.bdF("adapter");
    }
    localb.clearItems();
    AppMethodBeat.o(191609);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191612);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191612);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(191608);
    this.gjR.setVisibility(paramInt);
    AppMethodBeat.o(191608);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, b.d>
  {
    public b()
    {
      AppMethodBeat.i(191586);
      av(true);
      AppMethodBeat.o(191586);
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
    {
      AppMethodBeat.i(191581);
      p.h(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (b.d)paramb.getView();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)getItemAtPosition(paramInt);
      ImageView localImageView = paramb.getImageView();
      p.g(localMediaItem, "media");
      h.a(localImageView, localMediaItem.getType(), localMediaItem.axP(), localMediaItem.cXO(), localMediaItem.tRM, (h.a)a.Cen, localMediaItem.tRN);
      p.g(paramb, "itemView");
      if (localMediaItem.tRM == b.a(this.Cem))
      {
        bool = true;
        paramb.setSelected(bool);
        if (localMediaItem.tRM != b.a(this.Cem)) {
          break label147;
        }
      }
      label147:
      for (boolean bool = true;; bool = false)
      {
        paramb.setFocusable(bool);
        AppMethodBeat.o(191581);
        return;
        bool = false;
        break;
      }
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(191583);
      p.h(paramb, "holder");
      p.h(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(191583);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(191585);
      long l = ((GalleryItem.MediaItem)getItemAtPosition(paramInt)).tRM;
      AppMethodBeat.o(191585);
      return l;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "attached"})
    static final class a
      implements h.a
    {
      public static final a Cen;
      
      static
      {
        AppMethodBeat.i(191579);
        Cen = new a();
        AppMethodBeat.o(191579);
      }
      
      public final void cYU() {}
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-vlog_release"})
  public final class c
    extends android.support.v7.widget.a.a.a
  {
    int dMM;
    private int sOt;
    private int sOu;
    private int sOv;
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, b.d> sOw;
    
    public c()
    {
      AppMethodBeat.i(191600);
      this.sOw = localObject;
      this.dMM = -1;
      this.sOt = -1;
      this.sOu = -1;
      AppMethodBeat.o(191600);
    }
    
    public final float K(RecyclerView.w paramw)
    {
      AppMethodBeat.i(191597);
      p.h(paramw, "viewHolder");
      AppMethodBeat.o(191597);
      return 0.295858F;
    }
    
    public final void L(RecyclerView.w paramw)
    {
      AppMethodBeat.i(191596);
      p.h(paramw, "viewHolder");
      AppMethodBeat.o(191596);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      AppMethodBeat.i(191599);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramw, "viewHolder");
      int i = android.support.v7.widget.a.a.a.dh(51);
      AppMethodBeat.o(191599);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.w paramw, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(191598);
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramw, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramw, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(191598);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.w paramw1, RecyclerView.w paramw2)
    {
      AppMethodBeat.i(191593);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramw1, "viewHolder");
      p.h(paramw2, "target");
      int i = paramw1.lN();
      int j = paramw2.lN();
      ae.d("MicroMsg.EditFooterRecyclerPlugin", "[onMove] from=" + i + " to=" + j);
      com.tencent.mm.plugin.gallery.a.d.swap((List)b.this.Cej, i, j);
      this.sOw.aq(i, j);
      this.sOu = j;
      AppMethodBeat.o(191593);
      return true;
    }
    
    public final void d(RecyclerView paramRecyclerView, final RecyclerView.w paramw)
    {
      AppMethodBeat.i(191595);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramw, "viewHolder");
      super.d(paramRecyclerView, paramw);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), 2130772091);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramw));
      paramw.auu.startAnimation(paramRecyclerView);
      AppMethodBeat.o(191595);
    }
    
    public final void f(final RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(191594);
      super.f(paramw, paramInt);
      if (paramw != null)
      {
        Object localObject = paramw.auu;
        p.g(localObject, "viewHolder.itemView");
        localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772092);
        ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramw, paramInt));
        paramw.auu.startAnimation((Animation)localObject);
      }
      AppMethodBeat.o(191594);
    }
    
    public final boolean no()
    {
      return true;
    }
    
    public final boolean np()
    {
      return false;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.w paramw) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(191588);
        p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        ae.d("MicroMsg.EditFooterRecyclerPlugin", "finally change from=" + b.c.b(this.Ceo) + " to=" + b.c.a(this.Ceo));
        AppMethodBeat.o(191588);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(191589);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(191589);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(191587);
        p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        AppMethodBeat.o(191587);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
    public static final class b
      implements Animation.AnimationListener
    {
      b(b.c paramc, RecyclerView.w paramw, int paramInt) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(191591);
        p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        AppMethodBeat.o(191591);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(191592);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(191592);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(191590);
        p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        if (paramInt == 2)
        {
          b.c.a(this.Ceo, paramw.lN());
          b.c.b(this.Ceo, b.c.a(this.Ceo));
          this.Ceo.dMM = b.c.c(this.Ceo);
        }
        AppMethodBeat.o(191590);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$2", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-vlog_release"})
  public static final class f
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.b
 * JD-Core Version:    0.7.0.1
 */