package com.tencent.mm.plugin.textstatus.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.textstatus.a.h.a;
import com.tencent.mm.plugin.textstatus.b.c;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.c.c;
import com.tencent.mm.plugin.textstatus.b.c.c.b;
import com.tencent.mm.plugin.textstatus.b.f.a;
import com.tencent.mm.plugin.textstatus.proto.ao;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import com.tencent.mm.ui.base.s;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog;", "Lcom/tencent/mm/plugin/textstatus/ui/MMImmerseDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cardEventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "cardItemClickListener", "Landroid/view/View$OnClickListener;", "dataSet", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "ivBackImg", "Landroid/widget/ImageView;", "getIvBackImg", "()Landroid/widget/ImageView;", "setIvBackImg", "(Landroid/widget/ImageView;)V", "layoutBottomArrow", "Landroid/view/View;", "getLayoutBottomArrow", "()Landroid/view/View;", "setLayoutBottomArrow", "(Landroid/view/View;)V", "layoutMaxLinear", "Lcom/tencent/mm/plugin/textstatus/ui/MaxHeightLinearLayout;", "getLayoutMaxLinear", "()Lcom/tencent/mm/plugin/textstatus/ui/MaxHeightLinearLayout;", "setLayoutMaxLinear", "(Lcom/tencent/mm/plugin/textstatus/ui/MaxHeightLinearLayout;)V", "layoutWrap", "Landroid/widget/RelativeLayout;", "getLayoutWrap", "()Landroid/widget/RelativeLayout;", "setLayoutWrap", "(Landroid/widget/RelativeLayout;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "planetItemClickListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$planetItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$planetItemClickListener$1;", "rvFriendsStatus", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRvFriendsStatus", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRvFriendsStatus", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "setStatusClickListener", "vBackMask", "getVBackMask", "setVBackMask", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "enterAnim", "", "exitAnim", "listener", "Landroid/animation/Animator$AnimatorListener;", "initList", "initUI", "onBackPressed", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-textstatus_release"})
public final class n
  extends d
  implements i
{
  public static final n.a MNl;
  WxRecyclerView MNa;
  public ImageView MNb;
  public MaxHeightLinearLayout MNc;
  public View MNd;
  public View MNe;
  public RelativeLayout MNf;
  private final View.OnClickListener MNg;
  private final View.OnClickListener MNh;
  private final h.a MNi;
  private final k MNj;
  private final ArrayList<com.tencent.mm.view.recyclerview.a> MNk;
  private s jhZ;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(234536);
    MNl = new n.a((byte)0);
    AppMethodBeat.o(234536);
  }
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(234535);
    this.mContext = paramContext;
    this.MNg = ((View.OnClickListener)n.l.MNo);
    this.MNh = ((View.OnClickListener)new d(this));
    this.MNi = ((h.a)new c(this));
    this.MNj = new k();
    this.MNk = new ArrayList();
    AppMethodBeat.o(234535);
  }
  
  private final ArrayList<com.tencent.mm.view.recyclerview.a> gnu()
  {
    AppMethodBeat.i(234531);
    Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    Object localObject4 = com.tencent.mm.plugin.textstatus.b.f.bep(com.tencent.mm.plugin.auth.a.a.crN());
    if (localObject4 == null) {
      this.MNk.add(0, new com.tencent.mm.plugin.textstatus.g.c.a(com.tencent.mm.plugin.auth.a.a.crN(), 0));
    }
    Object localObject2;
    for (;;)
    {
      localObject1 = new LinkedList();
      localObject2 = (List)new ArrayList();
      Object localObject3 = (List)new ArrayList();
      if (localObject4 != null)
      {
        String str = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject4).field_UserName;
        if (str != null) {
          ((List)localObject2).add(str);
        }
        localObject4 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject4).field_TopicId;
        if (localObject4 != null) {
          ((List)localObject3).add(localObject4);
        }
      }
      localObject4 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      localObject2 = ((Map)com.tencent.mm.plugin.textstatus.b.f.gly().A((List)localObject2, (List)localObject3)).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        this.MNk.add(new com.tencent.mm.plugin.textstatus.g.c.b((String)((Map.Entry)localObject3).getKey(), (List)((Map.Entry)localObject3).getValue(), Integer.valueOf(0)));
        ((LinkedList)localObject1).add(((Map.Entry)localObject3).getKey());
      }
      this.MNk.add(0, new com.tencent.mm.plugin.textstatus.g.c.a(com.tencent.mm.plugin.auth.a.a.crN(), -1));
    }
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        com.tencent.mm.plugin.textstatus.b.f.a((LinkedList)localObject1, (f.a)new f(this));
      }
      localObject1 = this.MNk;
      AppMethodBeat.o(234531);
      return localObject1;
    }
  }
  
  public final RelativeLayout gnt()
  {
    AppMethodBeat.i(234522);
    RelativeLayout localRelativeLayout = this.MNf;
    if (localRelativeLayout == null) {
      p.bGy("layoutWrap");
    }
    AppMethodBeat.o(234522);
    return localRelativeLayout;
  }
  
  protected final void initUI()
  {
    AppMethodBeat.i(234525);
    super.initUI();
    Object localObject1 = LayoutInflater.from(getContext()).inflate(b.f.MxX, null, false);
    p.j(localObject1, "LayoutInflater.from(cont…s_planet_ui, null, false)");
    setCustomView((View)localObject1);
    Object localObject2 = ((View)localObject1).findViewById(b.e.Mvo);
    p.j(localObject2, "contentView.findViewById(R.id.iv_back_img)");
    this.MNb = ((ImageView)localObject2);
    localObject2 = ((View)localObject1).findViewById(b.e.MvU);
    p.j(localObject2, "contentView.findViewById…layout_max_height_linear)");
    this.MNc = ((MaxHeightLinearLayout)localObject2);
    localObject2 = ((View)localObject1).findViewById(b.e.MvJ);
    p.j(localObject2, "contentView.findViewById(R.id.layout_bottom_arrow)");
    this.MNd = ((View)localObject2);
    localObject2 = ((View)localObject1).findViewById(b.e.Mxs);
    p.j(localObject2, "contentView.findViewById(R.id.v_back_mask)");
    this.MNe = ((View)localObject2);
    localObject2 = ((View)localObject1).findViewById(b.e.Mwn);
    p.j(localObject2, "contentView.findViewById(R.id.layout_wrap)");
    this.MNf = ((RelativeLayout)localObject2);
    double d1 = ak.kU(getContext()).height * 0.75D;
    localObject2 = this.MNd;
    if (localObject2 == null) {
      p.bGy("layoutBottomArrow");
    }
    ((View)localObject2).measure(0, 0);
    localObject2 = this.MNd;
    if (localObject2 == null) {
      p.bGy("layoutBottomArrow");
    }
    int i = ((View)localObject2).getMeasuredHeight();
    localObject2 = this.MNd;
    if (localObject2 == null) {
      p.bGy("layoutBottomArrow");
    }
    localObject2 = ((View)localObject2).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(234525);
      throw ((Throwable)localObject1);
    }
    int j = ((RelativeLayout.LayoutParams)localObject2).bottomMargin;
    localObject2 = this.MNd;
    if (localObject2 == null) {
      p.bGy("layoutBottomArrow");
    }
    localObject2 = ((View)localObject2).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(234525);
      throw ((Throwable)localObject1);
    }
    double d2 = ((RelativeLayout.LayoutParams)localObject2).topMargin + (i + j);
    localObject2 = this.MNc;
    if (localObject2 == null) {
      p.bGy("layoutMaxLinear");
    }
    ((MaxHeightLinearLayout)localObject2).setMaxHeightPx((int)(d1 - d2));
    localObject2 = this.MNb;
    if (localObject2 == null) {
      p.bGy("ivBackImg");
    }
    localObject2 = ((ImageView)localObject2).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(234525);
      throw ((Throwable)localObject1);
    }
    ((RelativeLayout.LayoutParams)localObject2).height = ((int)d1);
    localObject2 = this.MNf;
    if (localObject2 == null) {
      p.bGy("layoutWrap");
    }
    localObject2 = ((RelativeLayout)localObject2).getLayoutParams();
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(234525);
      throw ((Throwable)localObject1);
    }
    ((RelativeLayout.LayoutParams)localObject2).height = ((int)d1);
    localObject2 = com.tencent.mm.plugin.textstatus.f.a.MCH;
    Context localContext = getContext();
    p.j(localContext, "context");
    String str = com.tencent.mm.plugin.auth.a.a.crN();
    p.j(str, "Account.username()");
    ImageView localImageView = this.MNb;
    if (localImageView == null) {
      p.bGy("ivBackImg");
    }
    com.tencent.mm.plugin.textstatus.f.a.a((com.tencent.mm.plugin.textstatus.f.a)localObject2, localContext, str, localImageView);
    this.MNa = ((WxRecyclerView)((View)localObject1).findViewById(b.e.MwB));
    localObject1 = this.MNa;
    if (localObject1 != null) {
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new b(this), gnu()));
    }
    localObject1 = this.MNa;
    if (localObject1 != null)
    {
      getContext();
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    localObject1 = this.MNa;
    if (localObject1 != null) {
      ((WxRecyclerView)localObject1).b((RecyclerView.h)new g(this));
    }
    localObject1 = getContext();
    p.j(localObject1, "context");
    i = ((Context)localObject1).getResources().getDimensionPixelSize(b.c.Edge_3A);
    localObject1 = this.MNb;
    if (localObject1 == null) {
      p.bGy("ivBackImg");
    }
    ((ImageView)localObject1).setOutlineProvider((ViewOutlineProvider)new n.h(i));
    localObject1 = this.MNb;
    if (localObject1 == null) {
      p.bGy("ivBackImg");
    }
    ((ImageView)localObject1).setClipToOutline(true);
    localObject1 = this.MNe;
    if (localObject1 == null) {
      p.bGy("vBackMask");
    }
    ((View)localObject1).setOnClickListener((View.OnClickListener)new i(this));
    localObject1 = this.MNe;
    if (localObject1 == null) {
      p.bGy("vBackMask");
    }
    ((View)localObject1).setAlpha(0.0F);
    localObject1 = this.MNe;
    if (localObject1 == null) {
      p.bGy("vBackMask");
    }
    localObject1 = ((View)localObject1).animate();
    if (localObject1 != null)
    {
      localObject1 = ((ViewPropertyAnimator)localObject1).alpha(1.0F);
      if (localObject1 != null) {
        ((ViewPropertyAnimator)localObject1).setDuration(200L);
      }
    }
    localObject1 = this.MNf;
    if (localObject1 == null) {
      p.bGy("layoutWrap");
    }
    ((RelativeLayout)localObject1).setVisibility(4);
    localObject1 = this.MNf;
    if (localObject1 == null) {
      p.bGy("layoutWrap");
    }
    ((RelativeLayout)localObject1).post((Runnable)new n.e(this));
    AppMethodBeat.o(234525);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(234528);
    Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)new j(this);
    Object localObject = this.MNe;
    if (localObject == null) {
      p.bGy("vBackMask");
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
    localObject = this.MNf;
    if (localObject == null) {
      p.bGy("layoutWrap");
    }
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).animate();
      if (localObject != null)
      {
        RelativeLayout localRelativeLayout = this.MNf;
        if (localRelativeLayout == null) {
          p.bGy("layoutWrap");
        }
        localObject = ((ViewPropertyAnimator)localObject).translationY(-localRelativeLayout.getMeasuredHeight());
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
          if (localObject != null)
          {
            ((ViewPropertyAnimator)localObject).setListener(localAnimatorListener);
            AppMethodBeat.o(234528);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(234528);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(234533);
    paramString = this.jhZ;
    if (paramString != null)
    {
      paramString.dismiss();
      AppMethodBeat.o(234533);
      return;
    }
    AppMethodBeat.o(234533);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(236040);
      switch (paramInt)
      {
      default: 
        locale = (e)new c((c.b)n.e(this.MNm));
        AppMethodBeat.o(236040);
        return locale;
      case 0: 
        locale = (e)new com.tencent.mm.plugin.textstatus.b.c.b(n.b(this.MNm));
        AppMethodBeat.o(236040);
        return locale;
      }
      e locale = (e)new com.tencent.mm.plugin.textstatus.b.c.a(n.c(this.MNm), n.d(this.MNm));
      AppMethodBeat.o(236040);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "event", "", "extra", "", "kotlin.jvm.PlatformType", "onEvent"})
  static final class c
    implements h.a
  {
    c(n paramn) {}
    
    public final void dZ(Object paramObject)
    {
      AppMethodBeat.i(236495);
      if (p.h(paramObject, Boolean.TRUE)) {
        this.MNm.dismiss();
      }
      AppMethodBeat.o(236495);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(233553);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$cardItemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if ((paramView != null) && (paramView.getId() == b.e.Mxk)) {
        this.MNm.dismiss();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$cardItemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233553);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initList$2", "Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "onCall", "", "result", "", "plugin-textstatus_release"})
  public static final class f
    implements f.a
  {
    public final void ea(Object paramObject)
    {
      AppMethodBeat.i(232346);
      HashMap localHashMap = (HashMap)paramObject;
      Iterator localIterator = n.f(this.MNm).iterator();
      while (localIterator.hasNext())
      {
        paramObject = (com.tencent.mm.view.recyclerview.a)localIterator.next();
        if ((paramObject instanceof com.tencent.mm.plugin.textstatus.g.c.b))
        {
          com.tencent.mm.plugin.textstatus.g.c.b localb = (com.tencent.mm.plugin.textstatus.g.c.b)paramObject;
          paramObject = (ao)localHashMap.get(((com.tencent.mm.plugin.textstatus.g.c.b)paramObject).topicId);
          if (paramObject != null) {}
          for (paramObject = Integer.valueOf(paramObject.live_member_count);; paramObject = null)
          {
            localb.MDP = paramObject;
            break;
          }
        }
      }
      paramObject = this.MNm.MNa;
      if (paramObject != null)
      {
        paramObject = paramObject.getAdapter();
        if (paramObject != null)
        {
          paramObject.notifyDataSetChanged();
          AppMethodBeat.o(232346);
          return;
        }
      }
      AppMethodBeat.o(232346);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$3", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"})
  public static final class g
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(237049);
      p.k(paramRect, "outRect");
      p.k(paramRecyclerView, "parent");
      paramRecyclerView = this.MNm.MNa;
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {}
      }
      for (int i = paramRecyclerView.getItemCount(); (paramInt == i - 1) || (paramInt == 0); i = 1)
      {
        paramRecyclerView = this.MNm.getContext();
        p.j(paramRecyclerView, "context");
        paramRect.bottom = paramRecyclerView.getResources().getDimensionPixelSize(b.c.Edge_2A);
        AppMethodBeat.o(237049);
        return;
      }
      paramRecyclerView = this.MNm.getContext();
      p.j(paramRecyclerView, "context");
      paramRect.bottom = paramRecyclerView.getResources().getDimensionPixelSize(b.c.Edge_A);
      AppMethodBeat.o(237049);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235713);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.MNm.onBackPressed();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(235713);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$onBackPressed$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-textstatus_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(238736);
      n.a(this.MNm);
      AppMethodBeat.o(238736);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$planetItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "onClickItem", "", "itemData", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "view", "Landroid/view/View;", "plugin-textstatus_release"})
  public static final class k
    implements c.b
  {
    public final void a(com.tencent.mm.plugin.textstatus.g.c.b paramb, View paramView)
    {
      AppMethodBeat.i(237978);
      p.k(paramb, "itemData");
      p.k(paramView, "view");
      AppMethodBeat.o(237978);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.n
 * JD-Core Version:    0.7.0.1
 */