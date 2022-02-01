package com.tencent.mm.plugin.profile.ui.tab.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.tools.o;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMsgIndicator", "Landroid/view/View;", "mMsgLayout", "Landroid/view/ViewGroup;", "mMsgTextView", "Landroid/widget/TextView;", "mServiceLayout", "mServiceTextView", "mVideoIndicator", "mVideoLayout", "mVideoTextView", "onMsgTabSelected", "Lkotlin/Function0;", "", "getOnMsgTabSelected", "()Lkotlin/jvm/functions/Function0;", "setOnMsgTabSelected", "(Lkotlin/jvm/functions/Function0;)V", "onServiceTabSelected", "getOnServiceTabSelected", "setOnServiceTabSelected", "onTabSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "getOnTabSelected", "()Lkotlin/jvm/functions/Function1;", "setOnTabSelected", "(Lkotlin/jvm/functions/Function1;)V", "onVideoTabSelected", "getOnVideoTabSelected", "setOnVideoTabSelected", "tabCount", "getTabCount", "()I", "hideAllTab", "initView", "selectFirstTab", "selectIndex", "index", "selectMsgTab", "selectVideoTab", "setVideoTabText", "text", "", "showMsgTab", "showServiceTab", "showVideoTab", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizProfileTabLayout
  extends ConstraintLayout
{
  private TextView NfX;
  private TextView NfY;
  private TextView NfZ;
  public ViewGroup Nga;
  public ViewGroup Ngb;
  public ViewGroup Ngc;
  private View Ngd;
  private View Nge;
  private kotlin.g.a.a<ah> Ngf;
  private kotlin.g.a.a<ah> Ngg;
  private kotlin.g.a.a<ah> Ngh;
  private kotlin.g.a.b<? super Integer, ah> Ngi;
  
  public BizProfileTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(305973);
    initView();
    AppMethodBeat.o(305973);
  }
  
  public BizProfileTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(305980);
    initView();
    AppMethodBeat.o(305980);
  }
  
  private static final void a(BizProfileTabLayout paramBizProfileTabLayout, View paramView)
  {
    AppMethodBeat.i(305999);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBizProfileTabLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBizProfileTabLayout, "this$0");
    paramBizProfileTabLayout = paramBizProfileTabLayout.getOnServiceTabSelected();
    if (paramBizProfileTabLayout != null) {
      paramBizProfileTabLayout.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(305999);
  }
  
  private static final void b(BizProfileTabLayout paramBizProfileTabLayout, View paramView)
  {
    AppMethodBeat.i(306006);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBizProfileTabLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBizProfileTabLayout, "this$0");
    paramView = paramBizProfileTabLayout.getOnMsgTabSelected();
    if (paramView != null) {
      paramView.invoke();
    }
    paramView = paramBizProfileTabLayout.getOnTabSelected();
    if (paramView != null) {
      paramView.invoke(Integer.valueOf(0));
    }
    paramBizProfileTabLayout.gDx();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(306006);
  }
  
  private static final void c(BizProfileTabLayout paramBizProfileTabLayout, View paramView)
  {
    AppMethodBeat.i(306011);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramBizProfileTabLayout);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramBizProfileTabLayout, "this$0");
    localObject2 = paramBizProfileTabLayout.getOnTabSelected();
    if (localObject2 != null)
    {
      localObject1 = paramBizProfileTabLayout.Nga;
      paramView = (View)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mMsgLayout");
        paramView = null;
      }
      if (paramView.getVisibility() != 0) {
        break label151;
      }
    }
    label151:
    for (int i = 1;; i = 0)
    {
      ((kotlin.g.a.b)localObject2).invoke(Integer.valueOf(i));
      paramView = paramBizProfileTabLayout.getOnVideoTabSelected();
      if (paramView != null) {
        paramView.invoke();
      }
      paramBizProfileTabLayout.gDy();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/profile/ui/tab/view/BizProfileTabLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(306011);
      return;
    }
  }
  
  private final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(305990);
    af.mU(getContext()).inflate(R.i.gia, (ViewGroup)this, true);
    Object localObject1 = findViewById(R.h.fua);
    s.s(localObject1, "findViewById(R.id.biz_profile_menu_msg)");
    this.NfX = ((TextView)localObject1);
    localObject1 = findViewById(R.h.fuh);
    s.s(localObject1, "findViewById(R.id.biz_profile_menu_video)");
    this.NfY = ((TextView)localObject1);
    localObject1 = findViewById(R.h.fud);
    s.s(localObject1, "findViewById(R.id.biz_profile_menu_service)");
    this.NfZ = ((TextView)localObject1);
    localObject1 = findViewById(R.h.fuc);
    s.s(localObject1, "findViewById(R.id.biz_profile_menu_msg_layout)");
    this.Nga = ((ViewGroup)localObject1);
    localObject1 = findViewById(R.h.fuj);
    s.s(localObject1, "findViewById(R.id.biz_profile_menu_video_layout)");
    this.Ngb = ((ViewGroup)localObject1);
    localObject1 = findViewById(R.h.fue);
    s.s(localObject1, "findViewById(R.id.biz_profile_menu_service_layout)");
    this.Ngc = ((ViewGroup)localObject1);
    ViewGroup localViewGroup = this.Nga;
    localObject1 = localViewGroup;
    if (localViewGroup == null)
    {
      s.bIx("mMsgLayout");
      localObject1 = null;
    }
    o.F((View)localObject1, 0.7F);
    localViewGroup = this.Ngb;
    localObject1 = localViewGroup;
    if (localViewGroup == null)
    {
      s.bIx("mVideoLayout");
      localObject1 = null;
    }
    o.F((View)localObject1, 0.7F);
    localViewGroup = this.Ngc;
    localObject1 = localViewGroup;
    if (localViewGroup == null)
    {
      s.bIx("mServiceLayout");
      localObject1 = null;
    }
    o.F((View)localObject1, 0.7F);
    localObject1 = findViewById(R.h.fub);
    s.s(localObject1, "findViewById(R.id.biz_profile_menu_msg_indicator)");
    this.Ngd = ((View)localObject1);
    localObject1 = findViewById(R.h.fui);
    s.s(localObject1, "findViewById(R.id.biz_pr…ile_menu_video_indicator)");
    this.Nge = ((View)localObject1);
    localViewGroup = this.Ngc;
    localObject1 = localViewGroup;
    if (localViewGroup == null)
    {
      s.bIx("mServiceLayout");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setOnClickListener(new BizProfileTabLayout..ExternalSyntheticLambda2(this));
    localViewGroup = this.Nga;
    localObject1 = localViewGroup;
    if (localViewGroup == null)
    {
      s.bIx("mMsgLayout");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setOnClickListener(new BizProfileTabLayout..ExternalSyntheticLambda0(this));
    localObject1 = this.Ngb;
    if (localObject1 == null)
    {
      s.bIx("mVideoLayout");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ViewGroup)localObject1).setOnClickListener(new BizProfileTabLayout..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(305990);
      return;
    }
  }
  
  public final void gDw()
  {
    Object localObject2 = null;
    AppMethodBeat.i(306101);
    ViewGroup localViewGroup = this.Nga;
    Object localObject1 = localViewGroup;
    if (localViewGroup == null)
    {
      s.bIx("mMsgLayout");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setVisibility(8);
    localViewGroup = this.Ngb;
    localObject1 = localViewGroup;
    if (localViewGroup == null)
    {
      s.bIx("mVideoLayout");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setVisibility(8);
    localObject1 = this.Ngc;
    if (localObject1 == null)
    {
      s.bIx("mServiceLayout");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ViewGroup)localObject1).setVisibility(8);
      AppMethodBeat.o(306101);
      return;
    }
  }
  
  public final void gDx()
  {
    Object localObject2 = null;
    AppMethodBeat.i(306112);
    Object localObject3 = this.Nga;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mMsgLayout");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setVisibility(0);
    localObject3 = this.Ngd;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mMsgIndicator");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localObject3 = this.Nge;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mVideoIndicator");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject3 = this.NfX;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mMsgTextView");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getContext().getResources().getColor(R.e.normal_text_color));
    localObject3 = this.NfY;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mVideoTextView");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getContext().getResources().getColor(R.e.desc_text));
    localObject1 = am.aixg;
    String str = getResources().getString(R.l.biz_timeline_has_selected);
    s.s(str, "resources.getString(R.st…iz_timeline_has_selected)");
    localObject3 = this.NfX;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mMsgTextView");
      localObject1 = null;
    }
    localObject1 = String.format(str, Arrays.copyOf(new Object[] { ((TextView)localObject1).getText() }, 1));
    s.s(localObject1, "java.lang.String.format(format, *args)");
    localObject3 = k.aeZF;
    localObject3 = getContext();
    s.s(localObject3, "context");
    ((com.tencent.mm.plugin.profile.ui.a)k.nq((Context)localObject3).q(com.tencent.mm.plugin.profile.ui.a.class)).setValue("biz_timeline_profile_menu_selected_msg", (String)localObject1);
    localObject1 = k.aeZF;
    localObject1 = getContext();
    s.s(localObject1, "context");
    localObject3 = (com.tencent.mm.plugin.profile.ui.a)k.nq((Context)localObject1).q(com.tencent.mm.plugin.profile.ui.a.class);
    localObject1 = this.NfY;
    if (localObject1 == null)
    {
      s.bIx("mVideoTextView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.profile.ui.a)localObject3).setValue("biz_timeline_profile_menu_selected_video", ((TextView)localObject1).getText().toString());
      AppMethodBeat.o(306112);
      return;
    }
  }
  
  public final void gDy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(306122);
    Object localObject3 = this.Ngb;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mVideoLayout");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setVisibility(0);
    localObject3 = this.Nge;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mVideoIndicator");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localObject3 = this.Ngd;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mMsgIndicator");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject3 = this.NfY;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mVideoTextView");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getContext().getResources().getColor(R.e.normal_text_color));
    localObject3 = this.NfX;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mMsgTextView");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getContext().getResources().getColor(R.e.desc_text));
    localObject1 = am.aixg;
    String str = getResources().getString(R.l.biz_timeline_has_selected);
    s.s(str, "resources.getString(R.st…iz_timeline_has_selected)");
    localObject3 = this.NfY;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mVideoTextView");
      localObject1 = null;
    }
    localObject1 = String.format(str, Arrays.copyOf(new Object[] { ((TextView)localObject1).getText() }, 1));
    s.s(localObject1, "java.lang.String.format(format, *args)");
    localObject3 = k.aeZF;
    localObject3 = getContext();
    s.s(localObject3, "context");
    ((com.tencent.mm.plugin.profile.ui.a)k.nq((Context)localObject3).q(com.tencent.mm.plugin.profile.ui.a.class)).setValue("biz_timeline_profile_menu_selected_video", (String)localObject1);
    localObject1 = k.aeZF;
    localObject1 = getContext();
    s.s(localObject1, "context");
    localObject3 = (com.tencent.mm.plugin.profile.ui.a)k.nq((Context)localObject1).q(com.tencent.mm.plugin.profile.ui.a.class);
    localObject1 = this.NfX;
    if (localObject1 == null)
    {
      s.bIx("mMsgTextView");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.profile.ui.a)localObject3).setValue("biz_timeline_profile_menu_selected_msg", ((TextView)localObject1).getText().toString());
      AppMethodBeat.o(306122);
      return;
    }
  }
  
  public final kotlin.g.a.a<ah> getOnMsgTabSelected()
  {
    return this.Ngg;
  }
  
  public final kotlin.g.a.a<ah> getOnServiceTabSelected()
  {
    return this.Ngf;
  }
  
  public final kotlin.g.a.b<Integer, ah> getOnTabSelected()
  {
    return this.Ngi;
  }
  
  public final kotlin.g.a.a<ah> getOnVideoTabSelected()
  {
    return this.Ngh;
  }
  
  public final int getTabCount()
  {
    Object localObject2 = null;
    AppMethodBeat.i(306037);
    ViewGroup localViewGroup = this.Nga;
    Object localObject1 = localViewGroup;
    if (localViewGroup == null)
    {
      s.bIx("mMsgLayout");
      localObject1 = null;
    }
    if (((ViewGroup)localObject1).getVisibility() == 0) {}
    for (int j = 1;; j = 0)
    {
      localViewGroup = this.Ngb;
      localObject1 = localViewGroup;
      if (localViewGroup == null)
      {
        s.bIx("mVideoLayout");
        localObject1 = null;
      }
      int i = j;
      if (((ViewGroup)localObject1).getVisibility() == 0) {
        i = j + 1;
      }
      localObject1 = this.Ngc;
      if (localObject1 == null)
      {
        s.bIx("mServiceLayout");
        localObject1 = localObject2;
      }
      for (;;)
      {
        j = i;
        if (((ViewGroup)localObject1).getVisibility() == 0) {
          j = i + 1;
        }
        AppMethodBeat.o(306037);
        return j;
      }
    }
  }
  
  public final void setOnMsgTabSelected(kotlin.g.a.a<ah> parama)
  {
    this.Ngg = parama;
  }
  
  public final void setOnServiceTabSelected(kotlin.g.a.a<ah> parama)
  {
    this.Ngf = parama;
  }
  
  public final void setOnTabSelected(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    this.Ngi = paramb;
  }
  
  public final void setOnVideoTabSelected(kotlin.g.a.a<ah> parama)
  {
    this.Ngh = parama;
  }
  
  public final void setVideoTabText(String paramString)
  {
    AppMethodBeat.i(306093);
    s.u(paramString, "text");
    TextView localTextView2 = this.NfY;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("mVideoTextView");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)paramString);
    AppMethodBeat.o(306093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.view.BizProfileTabLayout
 * JD-Core Version:    0.7.0.1
 */