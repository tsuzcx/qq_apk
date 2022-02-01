package com.tencent.mm.plugin.profile.ui.tab.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.tools.o;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMsgIndicator", "Landroid/view/View;", "mMsgLayout", "Landroid/view/ViewGroup;", "mMsgTextView", "Landroid/widget/TextView;", "mServiceLayout", "mServiceTextView", "mVideoIndicator", "mVideoLayout", "mVideoTextView", "onMsgTabSelected", "Lkotlin/Function0;", "", "getOnMsgTabSelected", "()Lkotlin/jvm/functions/Function0;", "setOnMsgTabSelected", "(Lkotlin/jvm/functions/Function0;)V", "onServiceTabSelected", "getOnServiceTabSelected", "setOnServiceTabSelected", "onTabSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "getOnTabSelected", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function1;)V", "onVideoTabSelected", "getOnVideoTabSelected", "setOnVideoTabSelected", "tabCount", "getTabCount", "()I", "hideAllTab", "initView", "selectFirstTab", "selectIndex", "index", "selectMsgTab", "selectVideoTab", "showMsgTab", "showServiceTab", "showVideoTab", "app_release"})
public final class BizProfileTabLayout
  extends ConstraintLayout
{
  private TextView BnQ;
  private TextView BnR;
  private TextView BnS;
  public ViewGroup BnT;
  public ViewGroup BnU;
  public ViewGroup BnV;
  private View BnW;
  private View BnX;
  private kotlin.g.a.a<x> BnY;
  private kotlin.g.a.a<x> BnZ;
  private kotlin.g.a.a<x> Boa;
  private kotlin.g.a.b<? super Integer, x> Bob;
  
  public BizProfileTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(230888);
    initView();
    AppMethodBeat.o(230888);
  }
  
  public BizProfileTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(230889);
    initView();
    AppMethodBeat.o(230889);
  }
  
  @SuppressLint({"ResourceType"})
  private final void initView()
  {
    AppMethodBeat.i(230884);
    aa.jQ(getContext()).inflate(2131493746, (ViewGroup)this, true);
    Object localObject = findViewById(2131297471);
    p.g(localObject, "findViewById(R.id.biz_profile_menu_msg)");
    this.BnQ = ((TextView)localObject);
    localObject = findViewById(2131297478);
    p.g(localObject, "findViewById(R.id.biz_profile_menu_video)");
    this.BnR = ((TextView)localObject);
    localObject = findViewById(2131297474);
    p.g(localObject, "findViewById(R.id.biz_profile_menu_service)");
    this.BnS = ((TextView)localObject);
    localObject = findViewById(2131297473);
    p.g(localObject, "findViewById(R.id.biz_profile_menu_msg_layout)");
    this.BnT = ((ViewGroup)localObject);
    localObject = findViewById(2131297480);
    p.g(localObject, "findViewById(R.id.biz_profile_menu_video_layout)");
    this.BnU = ((ViewGroup)localObject);
    localObject = findViewById(2131297475);
    p.g(localObject, "findViewById(R.id.biz_profile_menu_service_layout)");
    this.BnV = ((ViewGroup)localObject);
    localObject = this.BnT;
    if (localObject == null) {
      p.btv("mMsgLayout");
    }
    o.hp((View)localObject);
    localObject = this.BnU;
    if (localObject == null) {
      p.btv("mVideoLayout");
    }
    o.hp((View)localObject);
    localObject = this.BnV;
    if (localObject == null) {
      p.btv("mServiceLayout");
    }
    o.hp((View)localObject);
    localObject = findViewById(2131297472);
    p.g(localObject, "findViewById(R.id.biz_profile_menu_msg_indicator)");
    this.BnW = ((View)localObject);
    localObject = findViewById(2131297479);
    p.g(localObject, "findViewById(R.id.biz_pr…ile_menu_video_indicator)");
    this.BnX = ((View)localObject);
    localObject = this.BnV;
    if (localObject == null) {
      p.btv("mServiceLayout");
    }
    ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new a(this));
    localObject = this.BnT;
    if (localObject == null) {
      p.btv("mMsgLayout");
    }
    ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new b(this));
    localObject = this.BnU;
    if (localObject == null) {
      p.btv("mVideoLayout");
    }
    ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(230884);
  }
  
  public final void eFP()
  {
    AppMethodBeat.i(230885);
    ViewGroup localViewGroup = this.BnT;
    if (localViewGroup == null) {
      p.btv("mMsgLayout");
    }
    localViewGroup.setVisibility(8);
    localViewGroup = this.BnU;
    if (localViewGroup == null) {
      p.btv("mVideoLayout");
    }
    localViewGroup.setVisibility(8);
    localViewGroup = this.BnV;
    if (localViewGroup == null) {
      p.btv("mServiceLayout");
    }
    localViewGroup.setVisibility(8);
    AppMethodBeat.o(230885);
  }
  
  public final void eFQ()
  {
    AppMethodBeat.i(230886);
    Object localObject = this.BnT;
    if (localObject == null) {
      p.btv("mMsgLayout");
    }
    ((ViewGroup)localObject).setVisibility(0);
    localObject = this.BnW;
    if (localObject == null) {
      p.btv("mMsgIndicator");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.BnX;
    if (localObject == null) {
      p.btv("mVideoIndicator");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.BnQ;
    if (localObject == null) {
      p.btv("mMsgTextView");
    }
    Context localContext = getContext();
    p.g(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131100904));
    localObject = this.BnR;
    if (localObject == null) {
      p.btv("mVideoTextView");
    }
    localContext = getContext();
    p.g(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131100244));
    AppMethodBeat.o(230886);
  }
  
  public final void eFR()
  {
    AppMethodBeat.i(230887);
    Object localObject = this.BnU;
    if (localObject == null) {
      p.btv("mVideoLayout");
    }
    ((ViewGroup)localObject).setVisibility(0);
    localObject = this.BnX;
    if (localObject == null) {
      p.btv("mVideoIndicator");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.BnW;
    if (localObject == null) {
      p.btv("mMsgIndicator");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.BnR;
    if (localObject == null) {
      p.btv("mVideoTextView");
    }
    Context localContext = getContext();
    p.g(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131100904));
    localObject = this.BnQ;
    if (localObject == null) {
      p.btv("mMsgTextView");
    }
    localContext = getContext();
    p.g(localContext, "context");
    ((TextView)localObject).setTextColor(localContext.getResources().getColor(2131100244));
    AppMethodBeat.o(230887);
  }
  
  public final kotlin.g.a.a<x> getOnMsgTabSelected()
  {
    return this.BnZ;
  }
  
  public final kotlin.g.a.a<x> getOnServiceTabSelected()
  {
    return this.BnY;
  }
  
  public final kotlin.g.a.b<Integer, x> getOnTabSelected()
  {
    return this.Bob;
  }
  
  public final kotlin.g.a.a<x> getOnVideoTabSelected()
  {
    return this.Boa;
  }
  
  public final int getTabCount()
  {
    AppMethodBeat.i(230883);
    int j = 0;
    ViewGroup localViewGroup = this.BnT;
    if (localViewGroup == null) {
      p.btv("mMsgLayout");
    }
    if (localViewGroup.getVisibility() == 0) {
      j = 1;
    }
    localViewGroup = this.BnU;
    if (localViewGroup == null) {
      p.btv("mVideoLayout");
    }
    int i = j;
    if (localViewGroup.getVisibility() == 0) {
      i = j + 1;
    }
    localViewGroup = this.BnV;
    if (localViewGroup == null) {
      p.btv("mServiceLayout");
    }
    j = i;
    if (localViewGroup.getVisibility() == 0) {
      j = i + 1;
    }
    AppMethodBeat.o(230883);
    return j;
  }
  
  public final void setOnMsgTabSelected(kotlin.g.a.a<x> parama)
  {
    this.BnZ = parama;
  }
  
  public final void setOnServiceTabSelected(kotlin.g.a.a<x> parama)
  {
    this.BnY = parama;
  }
  
  public final void setOnTabSelected(kotlin.g.a.b<? super Integer, x> paramb)
  {
    this.Bob = paramb;
  }
  
  public final void setOnVideoTabSelected(kotlin.g.a.a<x> parama)
  {
    this.Boa = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(BizProfileTabLayout paramBizProfileTabLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230880);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.Boc.getOnServiceTabSelected();
      if (paramView != null) {
        paramView.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230880);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(BizProfileTabLayout paramBizProfileTabLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230881);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.Boc.getOnMsgTabSelected();
      if (paramView != null) {
        paramView.invoke();
      }
      paramView = this.Boc.getOnTabSelected();
      if (paramView != null) {
        paramView.invoke(Integer.valueOf(0));
      }
      this.Boc.eFQ();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230881);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(BizProfileTabLayout paramBizProfileTabLayout) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230882);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.Boc.getOnTabSelected();
      if (paramView != null) {
        if (BizProfileTabLayout.a(this.Boc).getVisibility() != 0) {
          break label116;
        }
      }
      label116:
      for (int i = 1;; i = 0)
      {
        paramView.invoke(Integer.valueOf(i));
        paramView = this.Boc.getOnVideoTabSelected();
        if (paramView != null) {
          paramView.invoke();
        }
        this.Boc.eFR();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(230882);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.view.BizProfileTabLayout
 * JD-Core Version:    0.7.0.1
 */