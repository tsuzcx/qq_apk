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
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "adapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "itemPositionChangedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "from", "to", "", "getItemPositionChangedCallback", "()Lkotlin/jvm/functions/Function2;", "setItemPositionChangedCallback", "(Lkotlin/jvm/functions/Function2;)V", "previewId", "", "getRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "selectPathList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lkotlin/collections/ArrayList;", "getSelectPathList", "()Ljava/util/ArrayList;", "getCurrentId", "initRecyclerView", "onDetach", "select", "index", "setBottomMargin", "margin", "setVisibility", "visibility", "updateList", "list", "Companion", "FooterPreviewAdapter", "ItemTouchHelperCallback", "PreviewItemView", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.recordvideo.plugin.a
{
  public static final c.a UhH;
  private long FRG;
  final ArrayList<GalleryItem.MediaItem> UhI;
  private b UhJ;
  public m<? super Integer, ? super Integer, ah> UhK;
  public final RecyclerView mex;
  
  static
  {
    AppMethodBeat.i(282410);
    UhH = new c.a((byte)0);
    AppMethodBeat.o(282410);
  }
  
  public c(RecyclerView paramRecyclerView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282378);
    this.mex = paramRecyclerView;
    this.UhI = new ArrayList();
    this.mex.setHasFixedSize(true);
    this.mex.getContext();
    paramRecyclerView = new LinearLayoutManager();
    paramRecyclerView.setOrientation(0);
    paramRecyclerView.setItemPrefetchEnabled(true);
    this.mex.setLayoutManager((RecyclerView.LayoutManager)paramRecyclerView);
    this.mex.setItemAnimator((RecyclerView.f)new f());
    this.mex.a((RecyclerView.h)new e(this));
    this.UhJ = new b();
    paramRecyclerView = this.UhJ;
    if (paramRecyclerView == null)
    {
      s.bIx("adapter");
      paramRecyclerView = null;
      paramRecyclerView.setItems((List)this.UhI);
      parama = this.UhJ;
      paramRecyclerView = parama;
      if (parama == null)
      {
        s.bIx("adapter");
        paramRecyclerView = null;
      }
      new k((k.a)new c((com.tencent.mm.ui.base.a.a)paramRecyclerView)).a(this.mex);
      RecyclerView localRecyclerView = this.mex;
      parama = this.UhJ;
      paramRecyclerView = parama;
      if (parama == null)
      {
        s.bIx("adapter");
        paramRecyclerView = null;
      }
      localRecyclerView.setAdapter((RecyclerView.a)paramRecyclerView);
      paramRecyclerView = this.UhJ;
      if (paramRecyclerView != null) {
        break label287;
      }
      s.bIx("adapter");
      paramRecyclerView = localObject;
    }
    label287:
    for (;;)
    {
      paramRecyclerView.adXy = ((com.tencent.mm.ui.base.a.a.a)new f(this));
      this.mex.setVisibility(0);
      AppMethodBeat.o(282378);
      return;
      break;
    }
  }
  
  public final void bJ(ArrayList<GalleryItem.MediaItem> paramArrayList)
  {
    Object localObject = null;
    AppMethodBeat.i(282421);
    s.u(paramArrayList, "list");
    Log.i("MicroMsg.EditFooterRecyclerPlugin", s.X("updateList = ", Integer.valueOf(paramArrayList.size())));
    this.UhI.clear();
    this.UhI.addAll((Collection)paramArrayList);
    paramArrayList = this.UhJ;
    if (paramArrayList == null)
    {
      s.bIx("adapter");
      paramArrayList = null;
      paramArrayList.setItems((List)this.UhI);
      paramArrayList = this.UhJ;
      if (paramArrayList != null) {
        break label108;
      }
      s.bIx("adapter");
      paramArrayList = localObject;
    }
    label108:
    for (;;)
    {
      paramArrayList.bZE.notifyChanged();
      AppMethodBeat.o(282421);
      return;
      break;
    }
  }
  
  public final int hSG()
  {
    AppMethodBeat.i(282433);
    Iterator localIterator = ((Iterable)this.UhI).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      if (((GalleryItem.MediaItem)localObject).HHJ == this.FRG)
      {
        AppMethodBeat.o(282433);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(282433);
    return 0;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(282445);
    super.onDetach();
    b localb2 = this.UhJ;
    b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("adapter");
      localb1 = null;
    }
    int i = localb1.ell.size();
    localb1.ell.clear();
    localb1.bB(0, i);
    AppMethodBeat.o(282445);
  }
  
  public final void select(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(282428);
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt <= this.UhI.size() - 1) {
        i = 1;
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(282428);
      return;
    }
    GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)this.UhI.get(paramInt);
    this.FRG = localMediaItem.HHJ;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("PARAM_VLOG_MULTI_IMAGE_SELECT_VALUE", (Parcelable)localMediaItem);
    this.GrC.a(com.tencent.mm.plugin.recordvideo.plugin.parent.a.c.NPv, localBundle);
    AppMethodBeat.o(282428);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282438);
    super.setVisibility(paramInt);
    this.mex.setVisibility(paramInt);
    AppMethodBeat.o(282438);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$FooterPreviewAdapter;", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;)V", "getItemId", "", "position", "", "onBindViewHolder", "", "viewWrapper", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "i", "holder", "payloads", "", "", "onCreateItemView", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, c.d>
  {
    public b()
    {
      AppMethodBeat.i(282708);
      bf(true);
      AppMethodBeat.o(282708);
    }
    
    private static final void hSH() {}
    
    public final void a(b paramb, int paramInt)
    {
      AppMethodBeat.i(282739);
      s.u(paramb, "viewWrapper");
      super.a(paramb, paramInt);
      paramb = (c.d)paramb.view;
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)aBc(paramInt);
      com.tencent.mm.plugin.gallery.ui.h.a(paramb.getImageView(), localMediaItem.getType(), localMediaItem.bud(), localMediaItem.Gcc, localMediaItem.HHJ, c.b..ExternalSyntheticLambda0.INSTANCE, localMediaItem.HHK);
      if (localMediaItem.HHJ == c.b(this.UhL))
      {
        bool = true;
        paramb.setSelected(bool);
        if (localMediaItem.HHJ != c.b(this.UhL)) {
          break label127;
        }
      }
      label127:
      for (boolean bool = true;; bool = false)
      {
        paramb.setFocusable(bool);
        AppMethodBeat.o(282739);
        return;
        bool = false;
        break;
      }
    }
    
    public final void a(b paramb, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(282746);
      s.u(paramb, "holder");
      s.u(paramList, "payloads");
      if (paramList.isEmpty()) {
        a(paramb, paramInt);
      }
      AppMethodBeat.o(282746);
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(282755);
      long l = ((GalleryItem.MediaItem)aBc(paramInt)).HHJ;
      AppMethodBeat.o(282755);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "adapter", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase;)V", "lastVisiblePos", "", "getLastVisiblePos", "()I", "setLastVisiblePos", "(I)V", "mBeginDragPos", "mCurPositionInBar", "mEndDragPos", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getMoveThreshold", "", "getMovementFlags", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSelectedChanged", "onSwiped", "direction", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends k.a
  {
    private final com.tencent.mm.ui.base.a.a<GalleryItem.MediaItem, c.d> FRL;
    private int FRM;
    private int FRN;
    private int FRO;
    int ieV;
    
    public c()
    {
      AppMethodBeat.i(282740);
      this.FRL = localObject;
      this.ieV = -1;
      this.FRM = -1;
      this.FRN = -1;
      AppMethodBeat.o(282740);
    }
    
    public final boolean Ji()
    {
      return true;
    }
    
    public final boolean Jj()
    {
      return false;
    }
    
    public final int a(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(282837);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv, "viewHolder");
      int i = k.a.bk(51, 0);
      AppMethodBeat.o(282837);
      return i;
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.v paramv, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(282829);
      s.u(paramCanvas, "c");
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv, "viewHolder");
      super.a(paramCanvas, paramRecyclerView, paramv, paramFloat1 / 1.3F, paramFloat2 / 1.3F, paramInt, paramBoolean);
      AppMethodBeat.o(282829);
    }
    
    public final boolean a(RecyclerView paramRecyclerView, RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      AppMethodBeat.i(282782);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv1, "viewHolder");
      s.u(paramv2, "target");
      int i = paramv1.KJ();
      int j = paramv2.KJ();
      Log.d("MicroMsg.EditFooterRecyclerPlugin", "[onMove] from=" + i + " to=" + j);
      com.tencent.mm.plugin.gallery.b.h.m((List)c.this.UhI, i, j);
      this.FRL.bz(i, j);
      this.FRN = j;
      AppMethodBeat.o(282782);
      return true;
    }
    
    public final void b(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(282792);
      super.b(paramv, paramInt);
      if (paramv != null)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(paramv.caK.getContext(), com.tencent.mm.plugin.vlog.a.a.pickerview_dialog_scale_out);
        localAnimation.setAnimationListener((Animation.AnimationListener)new b(paramv, paramInt, this));
        paramv.caK.startAnimation(localAnimation);
      }
      AppMethodBeat.o(282792);
    }
    
    public final void d(RecyclerView paramRecyclerView, RecyclerView.v paramv)
    {
      AppMethodBeat.i(282804);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramv, "viewHolder");
      super.d(paramRecyclerView, paramv);
      paramRecyclerView = AnimationUtils.loadAnimation(paramRecyclerView.getContext(), com.tencent.mm.plugin.vlog.a.a.pickerview_dialog_scale_in);
      paramRecyclerView.setAnimationListener((Animation.AnimationListener)new a(paramv, this, c.this));
      paramv.caK.startAnimation(paramRecyclerView);
      AppMethodBeat.o(282804);
    }
    
    public final float g(RecyclerView.v paramv)
    {
      AppMethodBeat.i(282822);
      s.u(paramv, "viewHolder");
      AppMethodBeat.o(282822);
      return 0.295858F;
    }
    
    public final void h(RecyclerView.v paramv)
    {
      AppMethodBeat.i(282812);
      s.u(paramv, "viewHolder");
      AppMethodBeat.o(282812);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$clearView$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Animation.AnimationListener
    {
      a(RecyclerView.v paramv, c.c paramc, c paramc1) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(282644);
        s.u(paramAnimation, "animation");
        this.FRP.caK.setTag(null);
        Log.d("MicroMsg.EditFooterRecyclerPlugin", "finally change from=" + c.c.a(jdField_this) + " to=" + c.c.b(jdField_this));
        paramAnimation = this.UhN.UhK;
        if (paramAnimation != null) {
          paramAnimation.invoke(Integer.valueOf(c.c.a(jdField_this)), Integer.valueOf(c.c.b(jdField_this)));
        }
        AppMethodBeat.o(282644);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(282653);
        s.u(paramAnimation, "animation");
        AppMethodBeat.o(282653);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(282635);
        s.u(paramAnimation, "animation");
        this.FRP.caK.setTag(new Object());
        AppMethodBeat.o(282635);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$ItemTouchHelperCallback$onSelectedChanged$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements Animation.AnimationListener
    {
      b(RecyclerView.v paramv, int paramInt, c.c paramc) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(282645);
        s.u(paramAnimation, "animation");
        this.FRP.caK.setTag(null);
        AppMethodBeat.o(282645);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation)
      {
        AppMethodBeat.i(282652);
        s.u(paramAnimation, "animation");
        AppMethodBeat.o(282652);
      }
      
      public final void onAnimationStart(Animation paramAnimation)
      {
        AppMethodBeat.i(282639);
        s.u(paramAnimation, "animation");
        this.FRP.caK.setTag(new Object());
        if (paramInt == 2)
        {
          c.c.a(jdField_this, this.FRP.KJ());
          c.c.b(jdField_this, c.c.b(jdField_this));
          jdField_this.ieV = c.c.c(jdField_this);
        }
        AppMethodBeat.o(282639);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$PreviewItemView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "focusedView", "Landroid/view/View;", "getFocusedView", "()Landroid/view/View;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "maskView", "getMaskView", "orangeColor", "padding", "getPadding", "()I", "size", "getSize", "setFocusable", "", "focusable", "", "setSelected", "selected", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends FrameLayout
  {
    private final View FRV;
    private final int Fbw;
    private final ImageView hIz;
    private final View maskView;
    private final int padding;
    private final int size;
    
    public d()
    {
      super();
      AppMethodBeat.i(282678);
      this.Fbw = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.vlog.a.c.orange_bg_color);
      this.hIz = new ImageView(getContext());
      this.maskView = new View(getContext());
      this.FRV = new View(getContext());
      this.padding = ((int)getContext().getResources().getDimension(a.d.Edge_0_5_A));
      this.size = ((int)getContext().getResources().getDimension(a.d.Edge_7A));
      this.hIz.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this$1 = new FrameLayout.LayoutParams(this.size + this.padding * 2, this.size + this.padding * 2);
      Object localObject = new FrameLayout.LayoutParams(this.size, this.size);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.size, this.size);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      c.this.gravity = 17;
      localLayoutParams.gravity = 17;
      this.FRV.setBackgroundColor(this.Fbw);
      addView(this.FRV, (ViewGroup.LayoutParams)c.this);
      addView((View)this.hIz, (ViewGroup.LayoutParams)localLayoutParams);
      this.maskView.setBackgroundColor(getContext().getResources().getColor(com.tencent.mm.plugin.vlog.a.c.white));
      this.maskView.setAlpha(0.5F);
      this$1 = new FrameLayout.LayoutParams(-2, -1);
      c.this.gravity = 17;
      setLayoutParams((ViewGroup.LayoutParams)c.this);
      AppMethodBeat.o(282678);
    }
    
    public final View getFocusedView()
    {
      return this.FRV;
    }
    
    public final ImageView getImageView()
    {
      return this.hIz;
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
      AppMethodBeat.i(282723);
      super.setFocusable(paramBoolean);
      if (paramBoolean)
      {
        this.FRV.setVisibility(0);
        AppMethodBeat.o(282723);
        return;
      }
      this.FRV.setVisibility(4);
      AppMethodBeat.o(282723);
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      AppMethodBeat.i(282731);
      super.setSelected(paramBoolean);
      if (paramBoolean)
      {
        this.maskView.setVisibility(4);
        AppMethodBeat.o(282731);
        return;
      }
      this.maskView.setVisibility(0);
      AppMethodBeat.o(282731);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.h
  {
    private final float offset;
    
    e(c paramc)
    {
      AppMethodBeat.i(282674);
      this.offset = MMApplicationContext.getContext().getResources().getDimension(a.d.Edge_2A);
      AppMethodBeat.o(282674);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(282682);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      super.a(paramRect, paramView, paramRecyclerView, params);
      int i = paramRecyclerView.bj(paramView).KJ();
      paramView = this.UhL;
      paramRect.left = ((int)this.offset);
      if (i + 1 == paramView.UhI.size()) {
        paramRect.right = ((int)this.offset);
      }
      AppMethodBeat.o(282682);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$2", "Lcom/tencent/mm/ui/base/adapter/RecyclerViewAdapterBase$OnItemClickListeners;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "item", "onItemLongClick", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.ui.base.a.a.a<GalleryItem.MediaItem>
  {
    f(c paramc) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c
 * JD-Core Version:    0.7.0.1
 */