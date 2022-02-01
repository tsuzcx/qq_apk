package com.tencent.mm.plugin.profile.ui.tab.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.ad;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMsgIndicator", "Landroid/view/View;", "mMsgLayout", "Landroid/view/ViewGroup;", "mMsgTextView", "Landroid/widget/TextView;", "mServiceLayout", "mServiceTextView", "mVideoIndicator", "mVideoLayout", "mVideoTextView", "onMsgTabSelected", "Lkotlin/Function0;", "", "getOnMsgTabSelected", "()Lkotlin/jvm/functions/Function0;", "setOnMsgTabSelected", "(Lkotlin/jvm/functions/Function0;)V", "onServiceTabSelected", "getOnServiceTabSelected", "setOnServiceTabSelected", "onTabSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "getOnTabSelected", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function1;)V", "onVideoTabSelected", "getOnVideoTabSelected", "setOnVideoTabSelected", "tabCount", "getTabCount", "()I", "hideAllTab", "initView", "selectFirstTab", "selectIndex", "index", "selectMsgTab", "selectVideoTab", "showMsgTab", "showServiceTab", "showVideoTab", "app_release"})
public final class BizProfileTabLayout
  extends ConstraintLayout
{
  private TextView Hij;
  private TextView Hik;
  private TextView Hil;
  public ViewGroup Him;
  public ViewGroup Hin;
  public ViewGroup Hio;
  private View Hip;
  private View Hiq;
  private kotlin.g.a.a<x> Hir;
  private kotlin.g.a.a<x> His;
  private kotlin.g.a.a<x> Hit;
  private kotlin.g.a.b<? super Integer, x> Hiu;
  
  public BizProfileTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(222423);
    initView();
    AppMethodBeat.o(222423);
  }
  
  public BizProfileTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(222424);
    initView();
    AppMethodBeat.o(222424);
  }
  
  @SuppressLint({"ResourceType"})
  private final void initView()
  {
    AppMethodBeat.i(222408);
    ad.kS(getContext()).inflate(R.i.efg, (ViewGroup)this, true);
    Object localObject = findViewById(R.h.dtJ);
    kotlin.g.b.p.j(localObject, "findViewById(R.id.biz_profile_menu_msg)");
    this.Hij = ((TextView)localObject);
    localObject = findViewById(R.h.dtQ);
    kotlin.g.b.p.j(localObject, "findViewById(R.id.biz_profile_menu_video)");
    this.Hik = ((TextView)localObject);
    localObject = findViewById(R.h.dtM);
    kotlin.g.b.p.j(localObject, "findViewById(R.id.biz_profile_menu_service)");
    this.Hil = ((TextView)localObject);
    localObject = findViewById(R.h.dtL);
    kotlin.g.b.p.j(localObject, "findViewById(R.id.biz_profile_menu_msg_layout)");
    this.Him = ((ViewGroup)localObject);
    localObject = findViewById(R.h.dtS);
    kotlin.g.b.p.j(localObject, "findViewById(R.id.biz_profile_menu_video_layout)");
    this.Hin = ((ViewGroup)localObject);
    localObject = findViewById(R.h.dtN);
    kotlin.g.b.p.j(localObject, "findViewById(R.id.biz_profile_menu_service_layout)");
    this.Hio = ((ViewGroup)localObject);
    localObject = this.Him;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mMsgLayout");
    }
    com.tencent.mm.ui.tools.p.iF((View)localObject);
    localObject = this.Hin;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mVideoLayout");
    }
    com.tencent.mm.ui.tools.p.iF((View)localObject);
    localObject = this.Hio;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mServiceLayout");
    }
    com.tencent.mm.ui.tools.p.iF((View)localObject);
    localObject = findViewById(R.h.dtK);
    kotlin.g.b.p.j(localObject, "findViewById(R.id.biz_profile_menu_msg_indicator)");
    this.Hip = ((View)localObject);
    localObject = findViewById(R.h.dtR);
    kotlin.g.b.p.j(localObject, "findViewById(R.id.biz_pr…ile_menu_video_indicator)");
    this.Hiq = ((View)localObject);
    localObject = this.Hio;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mServiceLayout");
    }
    ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new a(this));
    localObject = this.Him;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mMsgLayout");
    }
    ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new b(this));
    localObject = this.Hin;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mVideoLayout");
    }
    ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(222408);
  }
  
  public final void frO()
  {
    AppMethodBeat.i(222410);
    ViewGroup localViewGroup = this.Him;
    if (localViewGroup == null) {
      kotlin.g.b.p.bGy("mMsgLayout");
    }
    localViewGroup.setVisibility(8);
    localViewGroup = this.Hin;
    if (localViewGroup == null) {
      kotlin.g.b.p.bGy("mVideoLayout");
    }
    localViewGroup.setVisibility(8);
    localViewGroup = this.Hio;
    if (localViewGroup == null) {
      kotlin.g.b.p.bGy("mServiceLayout");
    }
    localViewGroup.setVisibility(8);
    AppMethodBeat.o(222410);
  }
  
  public final void frP()
  {
    AppMethodBeat.i(222413);
    Object localObject = this.Him;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mMsgLayout");
    }
    ((ViewGroup)localObject).setVisibility(0);
    localObject = this.Hip;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mMsgIndicator");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.Hiq;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mVideoIndicator");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.Hij;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mMsgTextView");
    }
    Context localContext = getContext();
    kotlin.g.b.p.j(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(R.e.normal_text_color));
    localObject = this.Hik;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mVideoTextView");
    }
    localContext = getContext();
    kotlin.g.b.p.j(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(R.e.desc_text));
    AppMethodBeat.o(222413);
  }
  
  public final void frQ()
  {
    AppMethodBeat.i(222421);
    Object localObject = this.Hin;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mVideoLayout");
    }
    ((ViewGroup)localObject).setVisibility(0);
    localObject = this.Hiq;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mVideoIndicator");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.Hip;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mMsgIndicator");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.Hik;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mVideoTextView");
    }
    Context localContext = getContext();
    kotlin.g.b.p.j(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(R.e.normal_text_color));
    localObject = this.Hij;
    if (localObject == null) {
      kotlin.g.b.p.bGy("mMsgTextView");
    }
    localContext = getContext();
    kotlin.g.b.p.j(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(R.e.desc_text));
    AppMethodBeat.o(222421);
  }
  
  public final kotlin.g.a.a<x> getOnMsgTabSelected()
  {
    return this.His;
  }
  
  public final kotlin.g.a.a<x> getOnServiceTabSelected()
  {
    return this.Hir;
  }
  
  public final kotlin.g.a.b<Integer, x> getOnTabSelected()
  {
    return this.Hiu;
  }
  
  public final kotlin.g.a.a<x> getOnVideoTabSelected()
  {
    return this.Hit;
  }
  
  public final int getTabCount()
  {
    AppMethodBeat.i(222389);
    int j = 0;
    ViewGroup localViewGroup = this.Him;
    if (localViewGroup == null) {
      kotlin.g.b.p.bGy("mMsgLayout");
    }
    if (localViewGroup.getVisibility() == 0) {
      j = 1;
    }
    localViewGroup = this.Hin;
    if (localViewGroup == null) {
      kotlin.g.b.p.bGy("mVideoLayout");
    }
    int i = j;
    if (localViewGroup.getVisibility() == 0) {
      i = j + 1;
    }
    localViewGroup = this.Hio;
    if (localViewGroup == null) {
      kotlin.g.b.p.bGy("mServiceLayout");
    }
    j = i;
    if (localViewGroup.getVisibility() == 0) {
      j = i + 1;
    }
    AppMethodBeat.o(222389);
    return j;
  }
  
  public final void setOnMsgTabSelected(kotlin.g.a.a<x> parama)
  {
    this.His = parama;
  }
  
  public final void setOnServiceTabSelected(kotlin.g.a.a<x> parama)
  {
    this.Hir = parama;
  }
  
  public final void setOnTabSelected(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.Hiu = paramb;
  }
  
  public final void setOnVideoTabSelected(kotlin.g.a.a<x> parama)
  {
    this.Hit = parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(BizProfileTabLayout paramBizProfileTabLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289359);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Hiv.getOnServiceTabSelected();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289359);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(BizProfileTabLayout paramBizProfileTabLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(272030);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Hiv.getOnMsgTabSelected();
      if (paramView != null) {
        paramView.invoke();
      }
      paramView = this.Hiv.getOnTabSelected();
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(0));
      }
      this.Hiv.frP();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272030);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(BizProfileTabLayout paramBizProfileTabLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282039);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.Hiv.getOnTabSelected();
      if (paramView != null) {
        if (BizProfileTabLayout.a(this.Hiv).getVisibility() != 0) {
          break label116;
        }
      }
      label116:
      for (int i = 1;; i = 0)
      {
        paramView.invoke(Integer.valueOf(i));
        paramView = this.Hiv.getOnVideoTabSelected();
        if (paramView != null) {
          paramView.invoke();
        }
        this.Hiv.frQ();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(282039);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.view.BizProfileTabLayout
 * JD-Core Version:    0.7.0.1
 */