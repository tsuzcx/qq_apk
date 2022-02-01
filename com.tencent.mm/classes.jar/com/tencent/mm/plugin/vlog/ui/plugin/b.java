package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/support/v7/widget/RecyclerView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "previewId", "", "getRecycler", "()Landroid/support/v7/widget/RecyclerView;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "getSelectPathList", "()Ljava/util/ArrayList;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCurrentId", "", "initRecyclerView", "", "onDetach", "select", "index", "setVisibility", "visibility", "updateList", "list", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "PreviewItemView", "plugin-vlog_release"})
public final class b
  implements t
{
  public static final b.a BMM;
  public final ArrayList<GalleryItem.MediaItem> BMK;
  public b BML;
  private final RecyclerView ghz;
  public long sDo;
  public com.tencent.mm.plugin.recordvideo.plugin.parent.d sQE;
  
  static
  {
    AppMethodBeat.i(196152);
    BMM = new b.a((byte)0);
    AppMethodBeat.o(196152);
  }
  
  public b(RecyclerView paramRecyclerView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(196151);
    this.ghz = paramRecyclerView;
    this.sQE = paramd;
    this.BMK = new ArrayList();
    this.ghz.setHasFixedSize(true);
    this.ghz.getContext();
    paramRecyclerView = new LinearLayoutManager();
    paramRecyclerView.setOrientation(0);
    paramRecyclerView.aw(true);
    this.ghz.setLayoutManager((RecyclerView.i)paramRecyclerView);
    this.ghz.setItemAnimator((RecyclerView.f)new v());
    this.ghz.b((RecyclerView.h)new e(this));
    this.BML = new b();
    paramRecyclerView = this.BML;
    if (paramRecyclerView == null) {
      p.bcb("adapter");
    }
    paramRecyclerView.setItems((List)this.BMK);
    paramRecyclerView = this.BML;
    if (paramRecyclerView == null) {
      p.bcb("adapter");
    }
    new android.support.v7.widget.a.a((android.support.v7.widget.a.a.a)new c((com.tencent.mm.ui.base.a.a)paramRecyclerView)).j(this.ghz);
    paramRecyclerView = this.ghz;
    paramd = this.BML;
    if (paramd == null) {
      p.bcb("adapter");
    }
    paramRecyclerView.setAdapter((RecyclerView.a)paramd);
    paramRecyclerView = this.BML;
    if (paramRecyclerView == null) {
      p.bcb("adapter");
    }
    paramRecyclerView.Jrp = ((com.tencent.mm.ui.base.a.a.a)new f(this));
    this.ghz.setVisibility(0);
    AppMethodBeat.o(196151);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(196150);
    b localb = this.BML;
    if (localb == null) {
      p.bcb("adapter");
    }
    localb.clearItems();
    AppMethodBeat.o(196150);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196153);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196153);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(196149);
    this.ghz.setVisibility(paramInt);
    AppMethodBeat.o(196149);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, b.d>
  {
    public b()
    {
      AppMethodBeat.i(196127);
      av(true);
      AppMethodBeat.o(196127);
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt)
    {
      AppMethodBeat.i(196122);
      p.h(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (b.d)paramb.getView();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)getItemAtPosition(paramInt);
      ImageView localImageView = paramb.getImageView();
      p.g(localMediaItem, "media");
      h.a(localImageView, localMediaItem.getType(), localMediaItem.axA(), localMediaItem.cVj(), localMediaItem.tGV, (h.a)a.BMO, localMediaItem.tGW);
      p.g(paramb, "itemView");
      if (localMediaItem.tGV == b.a(this.BMN))
      {
        bool = true;
        paramb.setSelected(bool);
        if (localMediaItem.tGV != b.a(this.BMN)) {
          break label147;
        }
      }
      label147:
      for (boolean bool = true;; bool = false)
      {
        paramb.setFocusable(bool);
        AppMethodBeat.o(196122);
        return;
        bool = false;
        break;
      }
    }
    
    public final void a(com.tencent.mm.ui.base.a.b paramb, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(196124);
      p.h(paramb, "holder");
      p.h(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(196124);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(196126);
      long l = ((GalleryItem.MediaItem)getItemAtPosition(paramInt)).tGV;
      AppMethodBeat.o(196126);
      return l;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "attached"})
    static final class a
      implements h.a
    {
      public static final a BMO;
      
      static
      {
        AppMethodBeat.i(196120);
        BMO = new a();
        AppMethodBeat.o(196120);
      }
      
      public final void cWp() {}
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-vlog_release"})
  public final class c
    extends android.support.v7.widget.a.a.a
  {
    int dLx;
    private int sDu;
    private int sDv;
    private int sDw;
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, b.d> sDx;
    
    public c()
    {
      AppMethodBeat.i(196141);
      this.sDx = localObject;
      this.dLx = -1;
      this.sDu = -1;
      this.sDv = -1;
      AppMethodBeat.o(196141);
    }
    
    public final float K(RecyclerView.w paramw)
    {
      AppMethodBeat.i(196138);
      p.h(paramw, "viewHolder");
      AppMethodBeat.o(196138);
      return 0.295858F;
    }
    
    public final void L(RecyclerView.w paramw)
    {
      AppMethodBeat.i(196137);
      p.h(paramw, "viewHolder");
      AppMethodBeat.o(196137);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.w paramw)
    {
      AppMethodBeat.i(196140);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramw, "viewHolder");
      int i = android.support.v7.widget.a.a.a.dh(51);
      AppMethodBeat.o(196140);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.w paramw, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(196139);
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramw, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramw, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(196139);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.w paramw1, RecyclerView.w paramw2)
    {
      AppMethodBeat.i(196134);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramw1, "viewHolder");
      p.h(paramw2, "target");
      int i = paramw1.lN();
      int j = paramw2.lN();
      ad.d("MicroMsg.EditFooterRecyclerPlugin", "[onMove] from=" + i + " to=" + j);
      com.tencent.mm.plugin.gallery.a.d.swap((List)b.this.BMK, i, j);
      this.sDx.aq(i, j);
      this.sDv = j;
      AppMethodBeat.o(196134);
      return true;
    }
    
    public final void d(RecyclerView paramRecyclerView, final RecyclerView.w paramw)
    {
      AppMethodBeat.i(196136);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramw, "viewHolder");
      super.d(paramRecyclerView, paramw);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), 2130772091);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramw));
      paramw.auu.startAnimation(paramRecyclerView);
      AppMethodBeat.o(196136);
    }
    
    public final void f(final RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(196135);
      super.f(paramw, paramInt);
      if (paramw != null)
      {
        Object localObject = paramw.auu;
        p.g(localObject, "viewHolder.itemView");
        localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), 2130772092);
        ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramw, paramInt));
        paramw.auu.startAnimation((Animation)localObject);
      }
      AppMethodBeat.o(196135);
    }
    
    public final boolean no()
    {
      return true;
    }
    
    public final boolean np()
    {
      return false;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.w paramw) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(196129);
        p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        ad.d("MicroMsg.EditFooterRecyclerPlugin", "finally change from=" + b.c.b(this.BMP) + " to=" + b.c.a(this.BMP));
        AppMethodBeat.o(196129);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(196130);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(196130);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(196128);
        p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        AppMethodBeat.o(196128);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
    public static final class b
      implements Animation.AnimationListener
    {
      b(b.c paramc, RecyclerView.w paramw, int paramInt) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(196132);
        p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        AppMethodBeat.o(196132);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(196133);
        p.h(paramAnimation, "animation");
        AppMethodBeat.o(196133);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(196131);
        p.h(paramAnimation, "animation");
        paramAnimation = paramw.auu;
        p.g(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        if (paramInt == 2)
        {
          b.c.a(this.BMP, paramw.lN());
          b.c.b(this.BMP, b.c.a(this.BMP));
          this.BMP.dLx = b.c.c(this.BMP);
        }
        AppMethodBeat.o(196131);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-vlog_release"})
  public final class d
    extends FrameLayout
  {
    private final ImageView dsD;
    private final View gZU;
    private final int padding;
    private final int sDF;
    private final View sDG;
    private final int size;
    
    public d()
    {
      super();
      AppMethodBeat.i(196144);
      this$1 = aj.getContext();
      p.g(b.this, "MMApplicationContext.getContext()");
      this.sDF = b.this.getResources().getColor(2131100726);
      this.dsD = new ImageView(getContext());
      this.gZU = new View(getContext());
      this.sDG = new View(getContext());
      this$1 = getContext();
      p.g(b.this, "context");
      this.padding = ((int)b.this.getResources().getDimension(2131165274));
      this$1 = getContext();
      p.g(b.this, "context");
      this.size = ((int)b.this.getResources().getDimension(2131165299));
      this.dsD.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this$1 = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      b.this.gravity = 17;
      localLayoutParams.gravity = 17;
      this.sDG.setBackgroundColor(this.sDF);
      addView(this.sDG, (ViewGroup.LayoutParams)b.this);
      addView((View)this.dsD, (ViewGroup.LayoutParams)localLayoutParams);
      this$1 = this.gZU;
      localObject = getContext();
      p.g(localObject, "context");
      b.this.setBackgroundColor(((Context)localObject).getResources().getColor(2131101179));
      this.gZU.setAlpha(0.5F);
      this$1 = new FrameLayout.LayoutParams(-2, -1);
      b.this.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)b.this);
      AppMethodBeat.o(196144);
    }
    
    public final View getFocusedView()
    {
      return this.sDG;
    }
    
    public final ImageView getImageView()
    {
      return this.dsD;
    }
    
    public final View getMaskView()
    {
      return this.gZU;
    }
    
    public final int getPadding()
    {
      return this.padding;
    }
    
    public final int getSize()
    {
      return this.size;
    }
    
    public final void setFocusable(boolean paramBoolean)
    {
      AppMethodBeat.i(196142);
      super.setFocusable(paramBoolean);
      if (paramBoolean)
      {
        this.sDG.setVisibility(0);
        AppMethodBeat.o(196142);
        return;
      }
      this.sDG.setVisibility(4);
      AppMethodBeat.o(196142);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(196143);
      super.setSelected(paramBoolean);
      if (paramBoolean)
      {
        this.gZU.setVisibility(4);
        AppMethodBeat.o(196143);
        return;
      }
      this.gZU.setVisibility(0);
      AppMethodBeat.o(196143);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-vlog_release"})
  public static final class e
    extends RecyclerView.h
  {
    private final float offset;
    
    e()
    {
      AppMethodBeat.i(196146);
      Context localContext = aj.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      this.offset = localContext.getResources().getDimension(2131165289);
      AppMethodBeat.o(196146);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(196145);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      super.a(paramRect, paramView, paramRecyclerView, paramt);
      paramView = paramRecyclerView.bh(paramView);
      p.g(paramView, "parent.getChildViewHolder(view)");
      int i = paramView.lN();
      paramRect.left = ((int)this.offset);
      if (i + 1 == this.BMN.BMK.size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(196145);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$2", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-vlog_release"})
  public static final class f
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.b
 * JD-Core Version:    0.7.0.1
 */