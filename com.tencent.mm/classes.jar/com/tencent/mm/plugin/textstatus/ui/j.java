package com.tencent.mm.plugin.textstatus.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.textstatus.a.m.a;
import com.tencent.mm.plugin.textstatus.b.c.c.b;
import com.tencent.mm.plugin.textstatus.f.f.d;
import com.tencent.mm.plugin.textstatus.g.x;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ah.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog;", "Lcom/tencent/mm/plugin/textstatus/ui/MMImmerseDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cardEventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "cardItemClickListener", "Landroid/view/View$OnClickListener;", "dataSet", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "ivBackImg", "Landroid/widget/ImageView;", "getIvBackImg", "()Landroid/widget/ImageView;", "setIvBackImg", "(Landroid/widget/ImageView;)V", "layoutBottomArrow", "Landroid/view/View;", "getLayoutBottomArrow", "()Landroid/view/View;", "setLayoutBottomArrow", "(Landroid/view/View;)V", "layoutMaxLinear", "Lcom/tencent/mm/plugin/textstatus/ui/MaxHeightLinearLayout;", "getLayoutMaxLinear", "()Lcom/tencent/mm/plugin/textstatus/ui/MaxHeightLinearLayout;", "setLayoutMaxLinear", "(Lcom/tencent/mm/plugin/textstatus/ui/MaxHeightLinearLayout;)V", "layoutWrap", "Landroid/widget/RelativeLayout;", "getLayoutWrap", "()Landroid/widget/RelativeLayout;", "setLayoutWrap", "(Landroid/widget/RelativeLayout;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "planetItemClickListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$planetItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$planetItemClickListener$1;", "rvFriendsStatus", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRvFriendsStatus", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRvFriendsStatus", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "setStatusClickListener", "vBackMask", "getVBackMask", "setVBackMask", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "enterAnim", "", "exitAnim", "listener", "Landroid/animation/Animator$AnimatorListener;", "initList", "initUI", "onBackPressed", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-textstatus_release"})
public final class j
  extends c
  implements i
{
  public static final j.a Gfs;
  WxRecyclerView Gfh;
  public ImageView Gfi;
  public MaxHeightLinearLayout Gfj;
  public View Gfk;
  public View Gfl;
  public RelativeLayout Gfm;
  private final View.OnClickListener Gfn;
  private final View.OnClickListener Gfo;
  private final com.tencent.mm.plugin.textstatus.a.f.a Gfp;
  private final k Gfq;
  private final ArrayList<com.tencent.mm.view.recyclerview.a> Gfr;
  private com.tencent.mm.ui.base.q gxX;
  Context mContext;
  
  static
  {
    AppMethodBeat.i(216619);
    Gfs = new j.a((byte)0);
    AppMethodBeat.o(216619);
  }
  
  public j(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(216618);
    this.mContext = paramContext;
    this.Gfn = ((View.OnClickListener)new l(paramContext));
    this.Gfo = ((View.OnClickListener)new d(this));
    this.Gfp = ((com.tencent.mm.plugin.textstatus.a.f.a)new c(this));
    this.Gfq = new k(this);
    this.Gfr = new ArrayList();
    AppMethodBeat.o(216618);
  }
  
  private final ArrayList<com.tencent.mm.view.recyclerview.a> fwD()
  {
    AppMethodBeat.i(216616);
    Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    Object localObject4 = com.tencent.mm.plugin.textstatus.b.f.aTf(com.tencent.mm.plugin.auth.a.a.ceA());
    if (localObject4 == null) {
      this.Gfr.add(0, new com.tencent.mm.plugin.textstatus.f.d.a(com.tencent.mm.plugin.auth.a.a.ceA(), 0));
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = (List)new ArrayList();
      Object localObject3 = (List)new ArrayList();
      if (localObject4 != null)
      {
        String str = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject4).field_UserName;
        if (str != null) {
          ((List)localObject2).add(str);
        }
        localObject4 = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject4).field_TopicId;
        if (localObject4 != null) {
          ((List)localObject3).add(localObject4);
        }
      }
      localObject4 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      localObject2 = ((Map)com.tencent.mm.plugin.textstatus.b.f.fvM().w((List)localObject2, (List)localObject3)).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        this.Gfr.add(new com.tencent.mm.plugin.textstatus.f.d.b((String)((Map.Entry)localObject3).getKey(), (List)((Map.Entry)localObject3).getValue(), Integer.valueOf(0)));
        ((LinkedList)localObject1).add(((Map.Entry)localObject3).getKey());
      }
      this.Gfr.add(0, new com.tencent.mm.plugin.textstatus.f.d.a(com.tencent.mm.plugin.auth.a.a.ceA(), -1));
    }
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        com.tencent.mm.plugin.textstatus.b.f.a((LinkedList)localObject1, (com.tencent.mm.plugin.textstatus.b.f.a)new f(this));
      }
      localObject1 = this.Gfr;
      AppMethodBeat.o(216616);
      return localObject1;
    }
  }
  
  public final RelativeLayout fwC()
  {
    AppMethodBeat.i(216613);
    RelativeLayout localRelativeLayout = this.Gfm;
    if (localRelativeLayout == null) {
      p.btv("layoutWrap");
    }
    AppMethodBeat.o(216613);
    return localRelativeLayout;
  }
  
  protected final void initUI()
  {
    AppMethodBeat.i(216614);
    super.initUI();
    Object localObject1 = LayoutInflater.from(getContext()).inflate(2131496695, null, false);
    p.g(localObject1, "LayoutInflater.from(cont…s_planet_ui, null, false)");
    p.h(localObject1, "customView");
    Object localObject2 = this.GcD;
    if (localObject2 != null) {
      ((LinearLayout)localObject2).addView((View)localObject1, -1, -2);
    }
    localObject2 = ((View)localObject1).findViewById(2131302878);
    p.g(localObject2, "contentView.findViewById(R.id.iv_back_img)");
    this.Gfi = ((ImageView)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131303090);
    p.g(localObject2, "contentView.findViewById…layout_max_height_linear)");
    this.Gfj = ((MaxHeightLinearLayout)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131303081);
    p.g(localObject2, "contentView.findViewById(R.id.layout_bottom_arrow)");
    this.Gfk = ((View)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131309662);
    p.g(localObject2, "contentView.findViewById(R.id.v_back_mask)");
    this.Gfl = ((View)localObject2);
    localObject2 = ((View)localObject1).findViewById(2131303104);
    p.g(localObject2, "contentView.findViewById(R.id.layout_wrap)");
    this.Gfm = ((RelativeLayout)localObject2);
    double d1 = ah.jS(getContext()).height * 0.75D;
    localObject2 = this.Gfk;
    if (localObject2 == null) {
      p.btv("layoutBottomArrow");
    }
    ((View)localObject2).measure(0, 0);
    localObject2 = this.Gfk;
    if (localObject2 == null) {
      p.btv("layoutBottomArrow");
    }
    int i = ((View)localObject2).getMeasuredHeight();
    localObject2 = this.Gfk;
    if (localObject2 == null) {
      p.btv("layoutBottomArrow");
    }
    localObject2 = ((View)localObject2).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(216614);
      throw ((Throwable)localObject1);
    }
    int j = ((RelativeLayout.LayoutParams)localObject2).bottomMargin;
    localObject2 = this.Gfk;
    if (localObject2 == null) {
      p.btv("layoutBottomArrow");
    }
    localObject2 = ((View)localObject2).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(216614);
      throw ((Throwable)localObject1);
    }
    double d2 = ((RelativeLayout.LayoutParams)localObject2).topMargin + (i + j);
    localObject2 = this.Gfj;
    if (localObject2 == null) {
      p.btv("layoutMaxLinear");
    }
    ((MaxHeightLinearLayout)localObject2).setMaxHeightPx((int)(d1 - d2));
    localObject2 = this.Gfi;
    if (localObject2 == null) {
      p.btv("ivBackImg");
    }
    localObject2 = ((ImageView)localObject2).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(216614);
      throw ((Throwable)localObject1);
    }
    ((RelativeLayout.LayoutParams)localObject2).height = ((int)d1);
    localObject2 = this.Gfm;
    if (localObject2 == null) {
      p.btv("layoutWrap");
    }
    localObject2 = ((RelativeLayout)localObject2).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(216614);
      throw ((Throwable)localObject1);
    }
    ((RelativeLayout.LayoutParams)localObject2).height = ((int)d1);
    localObject2 = com.tencent.mm.plugin.textstatus.e.a.FYI;
    Context localContext = getContext();
    p.g(localContext, "context");
    String str = com.tencent.mm.plugin.auth.a.a.ceA();
    p.g(str, "Account.username()");
    ImageView localImageView = this.Gfi;
    if (localImageView == null) {
      p.btv("ivBackImg");
    }
    com.tencent.mm.plugin.textstatus.e.a.a((com.tencent.mm.plugin.textstatus.e.a)localObject2, localContext, str, localImageView);
    this.Gfh = ((WxRecyclerView)((View)localObject1).findViewById(2131307199));
    localObject1 = this.Gfh;
    if (localObject1 != null) {
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new b(this), fwD()));
    }
    localObject1 = this.Gfh;
    if (localObject1 != null)
    {
      getContext();
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    localObject1 = this.Gfh;
    if (localObject1 != null) {
      ((WxRecyclerView)localObject1).b((RecyclerView.h)new g(this));
    }
    localObject1 = getContext();
    p.g(localObject1, "context");
    i = ((Context)localObject1).getResources().getDimensionPixelSize(2131165299);
    localObject1 = this.Gfi;
    if (localObject1 == null) {
      p.btv("ivBackImg");
    }
    ((ImageView)localObject1).setOutlineProvider((ViewOutlineProvider)new j.h(i));
    localObject1 = this.Gfi;
    if (localObject1 == null) {
      p.btv("ivBackImg");
    }
    ((ImageView)localObject1).setClipToOutline(true);
    localObject1 = this.Gfl;
    if (localObject1 == null) {
      p.btv("vBackMask");
    }
    ((View)localObject1).setOnClickListener((View.OnClickListener)new i(this));
    localObject1 = this.Gfl;
    if (localObject1 == null) {
      p.btv("vBackMask");
    }
    ((View)localObject1).setAlpha(0.0F);
    localObject1 = this.Gfl;
    if (localObject1 == null) {
      p.btv("vBackMask");
    }
    localObject1 = ((View)localObject1).animate();
    if (localObject1 != null)
    {
      localObject1 = ((ViewPropertyAnimator)localObject1).alpha(1.0F);
      if (localObject1 != null) {
        ((ViewPropertyAnimator)localObject1).setDuration(200L);
      }
    }
    localObject1 = this.Gfm;
    if (localObject1 == null) {
      p.btv("layoutWrap");
    }
    ((RelativeLayout)localObject1).setVisibility(4);
    localObject1 = this.Gfm;
    if (localObject1 == null) {
      p.btv("layoutWrap");
    }
    ((RelativeLayout)localObject1).post((Runnable)new j.e(this));
    AppMethodBeat.o(216614);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(216615);
    Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)new j(this);
    Object localObject = this.Gfl;
    if (localObject == null) {
      p.btv("vBackMask");
    }
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
        if (localObject != null) {
          ((ViewPropertyAnimator)localObject).setDuration(200L);
        }
      }
    }
    localObject = this.Gfm;
    if (localObject == null) {
      p.btv("layoutWrap");
    }
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).animate();
      if (localObject != null)
      {
        RelativeLayout localRelativeLayout = this.Gfm;
        if (localRelativeLayout == null) {
          p.btv("layoutWrap");
        }
        localObject = ((ViewPropertyAnimator)localObject).translationY(-localRelativeLayout.getMeasuredHeight());
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
          if (localObject != null)
          {
            ((ViewPropertyAnimator)localObject).setListener(localAnimatorListener);
            AppMethodBeat.o(216615);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(216615);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216617);
    paramString = this.gxX;
    if (paramString != null)
    {
      paramString.dismiss();
      AppMethodBeat.o(216617);
      return;
    }
    AppMethodBeat.o(216617);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(216602);
      switch (paramInt)
      {
      default: 
        locale = (e)new com.tencent.mm.plugin.textstatus.b.c.c((c.b)j.e(this.Gft));
        AppMethodBeat.o(216602);
        return locale;
      case 0: 
        locale = (e)new com.tencent.mm.plugin.textstatus.b.c.b(j.b(this.Gft));
        AppMethodBeat.o(216602);
        return locale;
      }
      e locale = (e)new com.tencent.mm.plugin.textstatus.b.c.a(j.c(this.Gft), j.d(this.Gft));
      AppMethodBeat.o(216602);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "event", "", "extra", "", "kotlin.jvm.PlatformType", "onEvent"})
  static final class c
    implements com.tencent.mm.plugin.textstatus.a.f.a
  {
    c(j paramj) {}
    
    public final void dV(Object paramObject)
    {
      AppMethodBeat.i(216603);
      if (p.j(paramObject, Boolean.TRUE)) {
        this.Gft.dismiss();
      }
      AppMethodBeat.o(216603);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(j paramj) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216604);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$cardItemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if ((paramView != null) && (paramView.getId() == 2131309534)) {
        this.Gft.dismiss();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$cardItemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216604);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initList$2", "Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "onCall", "", "result", "", "plugin-textstatus_release"})
  public static final class f
    implements com.tencent.mm.plugin.textstatus.b.f.a
  {
    public final void dW(Object paramObject)
    {
      AppMethodBeat.i(216606);
      HashMap localHashMap = (HashMap)paramObject;
      Iterator localIterator = j.f(this.Gft).iterator();
      while (localIterator.hasNext())
      {
        paramObject = (com.tencent.mm.view.recyclerview.a)localIterator.next();
        if ((paramObject instanceof com.tencent.mm.plugin.textstatus.f.d.b))
        {
          com.tencent.mm.plugin.textstatus.f.d.b localb = (com.tencent.mm.plugin.textstatus.f.d.b)paramObject;
          paramObject = (x)localHashMap.get(((com.tencent.mm.plugin.textstatus.f.d.b)paramObject).FZz);
          if (paramObject != null) {}
          for (paramObject = Integer.valueOf(paramObject.GaE);; paramObject = null)
          {
            localb.FZA = paramObject;
            break;
          }
        }
      }
      paramObject = this.Gft.Gfh;
      if (paramObject != null)
      {
        paramObject = paramObject.getAdapter();
        if (paramObject != null)
        {
          paramObject.notifyDataSetChanged();
          AppMethodBeat.o(216606);
          return;
        }
      }
      AppMethodBeat.o(216606);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$3", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
  public static final class g
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(216607);
      p.h(paramRect, "outRect");
      p.h(paramRecyclerView, "parent");
      paramRecyclerView = this.Gft.Gfh;
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {}
      }
      for (int i = paramRecyclerView.getItemCount(); (paramInt == i - 1) || (paramInt == 0); i = 1)
      {
        paramRecyclerView = this.Gft.getContext();
        p.g(paramRecyclerView, "context");
        paramRect.bottom = paramRecyclerView.getResources().getDimensionPixelSize(2131165296);
        AppMethodBeat.o(216607);
        return;
      }
      paramRecyclerView = this.Gft.getContext();
      p.g(paramRecyclerView, "context");
      paramRect.bottom = paramRecyclerView.getResources().getDimensionPixelSize(2131165314);
      AppMethodBeat.o(216607);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(j paramj) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216609);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.Gft.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216609);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$onBackPressed$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-textstatus_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(216610);
      j.a(this.Gft);
      AppMethodBeat.o(216610);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$planetItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "onClickItem", "", "itemData", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "view", "Landroid/view/View;", "plugin-textstatus_release"})
  public static final class k
    implements c.b
  {
    public final void a(com.tencent.mm.plugin.textstatus.f.d.b paramb, View paramView)
    {
      AppMethodBeat.i(216611);
      p.h(paramb, "itemData");
      p.h(paramView, "view");
      try
      {
        paramView = new m.a();
        com.tencent.mm.plugin.textstatus.j.b localb = com.tencent.mm.plugin.textstatus.j.b.GfZ;
        paramb = paramView.aSZ(com.tencent.mm.plugin.textstatus.j.b.getName(((com.tencent.mm.plugin.textstatus.f.f.a)paramb.iHf.get(0)).field_IconID)).fvz();
        paramView = TextStatusEditActivity.GeM;
        TextStatusEditActivity.a.b(this.Gft.mContext, paramb);
        AppMethodBeat.o(216611);
        return;
      }
      catch (Throwable paramb)
      {
        AppMethodBeat.o(216611);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216612);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$setStatusClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = TextStatusEditActivity.GeM;
      TextStatusEditActivity.a.b(this.$context, null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$setStatusClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.j
 * JD-Core Version:    0.7.0.1
 */