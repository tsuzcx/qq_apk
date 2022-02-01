package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.a.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.ui.h;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.vlog.a.c;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "itemPositionChangedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "from", "to", "", "getItemPositionChangedCallback", "()Lkotlin/jvm/functions/Function2;", "setItemPositionChangedCallback", "(Lkotlin/jvm/functions/Function2;)V", "previewId", "", "getRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "getSelectPathList", "()Ljava/util/ArrayList;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getCurrentId", "initRecyclerView", "onDetach", "select", "index", "setBottomMargin", "margin", "setVisibility", "visibility", "updateList", "list", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "PreviewItemView", "plugin-vlog_release"})
public final class c
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final a Nut;
  d APl;
  private long Ase;
  final ArrayList<GalleryItem.MediaItem> Nuq;
  private b Nur;
  public m<? super Integer, ? super Integer, x> Nus;
  public final RecyclerView jEA;
  
  static
  {
    AppMethodBeat.i(237174);
    Nut = new a((byte)0);
    AppMethodBeat.o(237174);
  }
  
  public c(RecyclerView paramRecyclerView, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(237172);
    this.jEA = paramRecyclerView;
    this.APl = paramd;
    this.Nuq = new ArrayList();
    this.jEA.setHasFixedSize(true);
    this.jEA.getContext();
    paramRecyclerView = new LinearLayoutManager();
    paramRecyclerView.setOrientation(0);
    paramRecyclerView.setItemPrefetchEnabled(true);
    this.jEA.setLayoutManager((RecyclerView.LayoutManager)paramRecyclerView);
    this.jEA.setItemAnimator((RecyclerView.f)new g());
    this.jEA.b((RecyclerView.h)new e(this));
    this.Nur = new b();
    paramRecyclerView = this.Nur;
    if (paramRecyclerView == null) {
      p.bGy("adapter");
    }
    paramRecyclerView.setItems((List)this.Nuq);
    paramRecyclerView = this.Nur;
    if (paramRecyclerView == null) {
      p.bGy("adapter");
    }
    new androidx.recyclerview.widget.l((l.a)new c((com.tencent.mm.ui.base.a.a)paramRecyclerView)).a(this.jEA);
    paramRecyclerView = this.jEA;
    paramd = this.Nur;
    if (paramd == null) {
      p.bGy("adapter");
    }
    paramRecyclerView.setAdapter((RecyclerView.a)paramd);
    paramRecyclerView = this.Nur;
    if (paramRecyclerView == null) {
      p.bGy("adapter");
    }
    paramRecyclerView.Wqm = ((com.tencent.mm.ui.base.a.a.a)new f(this));
    this.jEA.setVisibility(0);
    AppMethodBeat.o(237172);
  }
  
  public final void bi(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    AppMethodBeat.i(237161);
    p.k(paramArrayList, "list");
    Log.i("MicroMsg.EditFooterRecyclerPlugin", "updateList = " + paramArrayList.size());
    this.Nuq.clear();
    this.Nuq.addAll((Collection)paramArrayList);
    paramArrayList = this.Nur;
    if (paramArrayList == null) {
      p.bGy("adapter");
    }
    paramArrayList.setItems((List)this.Nuq);
    paramArrayList = this.Nur;
    if (paramArrayList == null) {
      p.bGy("adapter");
    }
    paramArrayList.notifyDataSetChanged();
    AppMethodBeat.o(237161);
  }
  
  public final int guR()
  {
    AppMethodBeat.i(237165);
    Iterator localIterator = ((Iterable)this.Nuq).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      if (((GalleryItem.MediaItem)localObject).BVl == this.Ase)
      {
        AppMethodBeat.o(237165);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(237165);
    return 0;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(237168);
    super.onDetach();
    b localb = this.Nur;
    if (localb == null) {
      p.bGy("adapter");
    }
    localb.clearItems();
    AppMethodBeat.o(237168);
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(237163);
    int i = ((Collection)this.Nuq).size();
    if (paramInt >= 0)
    {
      if (i <= paramInt) {
        AppMethodBeat.o(237163);
      }
    }
    else
    {
      AppMethodBeat.o(237163);
      return;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.Nuq.get(paramInt);
    this.Ase = localMediaItem.BVl;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE", (Parcelable)localMediaItem);
    this.APl.a(d.c.HSP, localBundle);
    AppMethodBeat.o(237163);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(237166);
    super.setVisibility(paramInt);
    this.jEA.setVisibility(paramInt);
    AppMethodBeat.o(237166);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"})
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, c.d>
  {
    public b()
    {
      AppMethodBeat.i(245560);
      aw(true);
      AppMethodBeat.o(245560);
    }
    
    public final void a(b paramb, int paramInt)
    {
      AppMethodBeat.i(245552);
      p.k(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (c.d)paramb.getView();
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)auB(paramInt);
      ImageView localImageView = paramb.getImageView();
      p.j(localMediaItem, "media");
      h.a(localImageView, localMediaItem.getType(), localMediaItem.aZe(), localMediaItem.etI(), localMediaItem.BVl, (h.a)a.Nuv, localMediaItem.BVm);
      p.j(paramb, "itemView");
      if (localMediaItem.BVl == c.a(this.Nuu))
      {
        bool = true;
        paramb.setSelected(bool);
        if (localMediaItem.BVl != c.a(this.Nuu)) {
          break label147;
        }
      }
      label147:
      for (boolean bool = true;; bool = false)
      {
        paramb.setFocusable(bool);
        AppMethodBeat.o(245552);
        return;
        bool = false;
        break;
      }
    }
    
    public final void a(b paramb, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(245555);
      p.k(paramb, "holder");
      p.k(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(245555);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(245558);
      long l = ((GalleryItem.MediaItem)auB(paramInt)).BVl;
      AppMethodBeat.o(245558);
      return l;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "attached"})
    static final class a
      implements h.a
    {
      public static final a Nuv;
      
      static
      {
        AppMethodBeat.i(234204);
        Nuv = new a();
        AppMethodBeat.o(234204);
      }
      
      public final void euT() {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-vlog_release"})
  public final class c
    extends l.a
  {
    private int Ask;
    private int Asl;
    private int Asm;
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, c.d> Asn;
    int fYT;
    
    public c()
    {
      AppMethodBeat.i(240785);
      this.Asn = localObject;
      this.fYT = -1;
      this.Ask = -1;
      this.Asl = -1;
      AppMethodBeat.o(240785);
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(240782);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv, "viewHolder");
      int i = l.a.cA(51);
      AppMethodBeat.o(240782);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(240781);
      p.k(paramCanvas, "c");
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(240781);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(240765);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv1, "viewHolder");
      p.k(paramv2, "target");
      int i = paramv1.md();
      int j = paramv2.md();
      Log.d("MicroMsg.EditFooterRecyclerPlugin", "[onMove] from=" + i + " to=" + j);
      e.e((List)c.this.Nuq, i, j);
      this.Asn.aF(i, j);
      this.Asl = j;
      AppMethodBeat.o(240765);
      return true;
    }
    
    public final void b(final RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(240771);
      super.b(paramv, paramInt);
      if (paramv != null)
      {
        Object localObject = paramv.amk;
        p.j(localObject, "viewHolder.itemView");
        localObject = AnimationUtils.loadAnimation(((View)localObject).getContext(), com.tencent.mm.plugin.vlog.a.a.pickerview_dialog_scale_out);
        ((Animation)localObject).setAnimationListener((Animation.AnimationListener)new b(this, paramv, paramInt));
        paramv.amk.startAnimation((Animation)localObject);
      }
      AppMethodBeat.o(240771);
    }
    
    public final void d(RecyclerView paramRecyclerView, final RecyclerView.v paramv)
    {
      AppMethodBeat.i(240775);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramv, "viewHolder");
      super.d(paramRecyclerView, paramv);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), com.tencent.mm.plugin.vlog.a.a.pickerview_dialog_scale_in);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(this, paramv));
      paramv.amk.startAnimation(paramRecyclerView);
      AppMethodBeat.o(240775);
    }
    
    public final float f(RecyclerView.v paramv)
    {
      AppMethodBeat.i(240779);
      p.k(paramv, "viewHolder");
      AppMethodBeat.o(240779);
      return 0.295858F;
    }
    
    public final void g(RecyclerView.v paramv)
    {
      AppMethodBeat.i(240776);
      p.k(paramv, "viewHolder");
      AppMethodBeat.o(240776);
    }
    
    public final boolean kA()
    {
      return false;
    }
    
    public final boolean kz()
    {
      return true;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.v paramv) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(227214);
        p.k(paramAnimation, "animation");
        paramAnimation = paramv.amk;
        p.j(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        Log.d("MicroMsg.EditFooterRecyclerPlugin", "finally change from=" + c.c.b(this.Nuw) + " to=" + c.c.a(this.Nuw));
        paramAnimation = this.Nuw.Nuu.Nus;
        if (paramAnimation != null)
        {
          paramAnimation.invoke(Integer.valueOf(c.c.b(this.Nuw)), Integer.valueOf(c.c.a(this.Nuw)));
          AppMethodBeat.o(227214);
          return;
        }
        AppMethodBeat.o(227214);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(227215);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(227215);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(227211);
        p.k(paramAnimation, "animation");
        paramAnimation = paramv.amk;
        p.j(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        AppMethodBeat.o(227211);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"})
    public static final class b
      implements Animation.AnimationListener
    {
      b(c.c paramc, RecyclerView.v paramv, int paramInt) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(227396);
        p.k(paramAnimation, "animation");
        paramAnimation = paramv.amk;
        p.j(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(null);
        AppMethodBeat.o(227396);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(227397);
        p.k(paramAnimation, "animation");
        AppMethodBeat.o(227397);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(227393);
        p.k(paramAnimation, "animation");
        paramAnimation = paramv.amk;
        p.j(paramAnimation, "viewHolder.itemView");
        paramAnimation.setTag(new Object());
        if (paramInt == 2)
        {
          c.c.a(this.Nuw, paramv.md());
          c.c.b(this.Nuw, c.c.a(this.Nuw));
          this.Nuw.fYT = c.c.c(this.Nuw);
        }
        AppMethodBeat.o(227393);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-vlog_release"})
  public final class d
    extends FrameLayout
  {
    private final int Asv;
    private final View Asw;
    private final ImageView fDJ;
    private final View maskView;
    private final int padding;
    private final int size;
    
    public d()
    {
      super();
      AppMethodBeat.i(229877);
      this$1 = MMApplicationContext.getContext();
      p.j(c.this, "MMApplicationContext.getContext()");
      this.Asv = c.this.getResources().getColor(a.c.orange_bg_color);
      this.fDJ = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.Asw = new View(getContext());
      this$1 = getContext();
      p.j(c.this, "context");
      this.padding = ((int)c.this.getResources().getDimension(a.d.Edge_0_5_A));
      this$1 = getContext();
      p.j(c.this, "context");
      this.size = ((int)c.this.getResources().getDimension(a.d.Edge_7A));
      this.fDJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this$1 = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      c.this.gravity = 17;
      localLayoutParams.gravity = 17;
      this.Asw.setBackgroundColor(this.Asv);
      addView(this.Asw, (ViewGroup.LayoutParams)c.this);
      addView((View)this.fDJ, (ViewGroup.LayoutParams)localLayoutParams);
      this$1 = this.maskView;
      localObject = getContext();
      p.j(localObject, "context");
      c.this.setBackgroundColor(((Context)localObject).getResources().getColor(a.c.white));
      this.maskView.setAlpha(0.5F);
      this$1 = new FrameLayout.LayoutParams(-2, -1);
      c.this.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)c.this);
      AppMethodBeat.o(229877);
    }
    
    public final View getFocusedView()
    {
      return this.Asw;
    }
    
    public final ImageView getImageView()
    {
      return this.fDJ;
    }
    
    public final View getMaskView()
    {
      return this.maskView;
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
      AppMethodBeat.i(229868);
      super.setFocusable(paramBoolean);
      if (paramBoolean)
      {
        this.Asw.setVisibility(0);
        AppMethodBeat.o(229868);
        return;
      }
      this.Asw.setVisibility(4);
      AppMethodBeat.o(229868);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(229870);
      super.setSelected(paramBoolean);
      if (paramBoolean)
      {
        this.maskView.setVisibility(4);
        AppMethodBeat.o(229870);
        return;
      }
      this.maskView.setVisibility(0);
      AppMethodBeat.o(229870);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-vlog_release"})
  public static final class e
    extends RecyclerView.h
  {
    private final float offset;
    
    e()
    {
      AppMethodBeat.i(227147);
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      this.offset = localContext.getResources().getDimension(a.d.Edge_2A);
      AppMethodBeat.o(227147);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(227143);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      paramView = paramRecyclerView.aQ(paramView);
      p.j(paramView, "parent.getChildViewHolder(view)");
      int i = paramView.md();
      paramRect.left = ((int)this.offset);
      if (i + 1 == this.Nuu.Nuq.size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(227143);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$2", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-vlog_release"})
  public static final class f
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c
 * JD-Core Version:    0.7.0.1
 */