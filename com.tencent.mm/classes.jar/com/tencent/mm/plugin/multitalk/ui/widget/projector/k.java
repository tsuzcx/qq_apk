package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "bottomUiLayout", "Landroid/view/View;", "getBottomUiLayout", "()Landroid/view/View;", "setBottomUiLayout", "(Landroid/view/View;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isTouchEnable", "", "mCloseDoodleLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getMCloseDoodleLayout", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setMCloseDoodleLayout", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "mDoodleFinishIv", "getMDoodleFinishIv", "setMDoodleFinishIv", "mDoodleLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "getMDoodleLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "setMDoodleLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;)V", "mIsDoodleFuncSupport", "mIsMoreFuncSupport", "mIsTextFuncSupport", "mMicMuteLayout", "getMMicMuteLayout", "setMMicMuteLayout", "mMoreControlIv", "mSpeakerLayout", "getMSpeakerLayout", "setMSpeakerLayout", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "toastView", "Landroid/widget/Toast;", "applyClickEvent", "", "clearScreen", "getLandScapeLayout", "rootView", "Landroid/widget/FrameLayout;", "getPortraitLayout", "setEnable", "enable", "showCenterToast", "text", "", "showListBottomSheet", "showReaderContent", "show", "plugin-multitalk_release"})
public final class k
{
  Context context;
  a zQD;
  e zQw;
  View zWH;
  MultiTalkSmallControlIconLayout zWI;
  WeImageView zWJ;
  MultiTalkSmallControlIconLayout zWK;
  MultiTalkSmallControlIconLayout zWL;
  private Toast zWM;
  boolean zWN;
  private boolean zWO;
  private boolean zWP;
  WeImageView zWQ;
  boolean zWR;
  
  public k(Context paramContext, a parama, e parame)
  {
    AppMethodBeat.i(240019);
    this.context = paramContext;
    this.zQD = parama;
    this.zQw = parame;
    paramContext = this.zQw;
    if (paramContext != null)
    {
      bool1 = paramContext.Rx(3);
      this.zWN = bool1;
      paramContext = this.zQw;
      if (paramContext == null) {
        break label121;
      }
    }
    label121:
    for (boolean bool1 = paramContext.Rx(1);; bool1 = false)
    {
      this.zWO = bool1;
      paramContext = this.zQw;
      bool1 = bool2;
      if (paramContext != null) {
        bool1 = paramContext.Rx(2);
      }
      this.zWP = bool1;
      AppMethodBeat.o(240019);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void bh(Context paramContext, String paramString)
  {
    AppMethodBeat.i(240018);
    Object localObject = this.zWM;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    this.zWM = Toast.makeText(paramContext, (CharSequence)"", 0);
    paramContext = View.inflate(paramContext, 2131495753, null);
    localObject = paramContext.findViewById(2131309260);
    if (localObject == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(240018);
      throw paramContext;
    }
    ((TextView)localObject).setText((CharSequence)paramString);
    paramString = this.zWM;
    if (paramString != null) {
      paramString.setGravity(17, 0, 0);
    }
    paramString = this.zWM;
    if (paramString != null) {
      paramString.setView(paramContext);
    }
    paramContext = this.zWM;
    if (paramContext != null)
    {
      paramContext.show();
      AppMethodBeat.o(240018);
      return;
    }
    AppMethodBeat.o(240018);
  }
  
  final void epA()
  {
    int j = 4;
    AppMethodBeat.i(240017);
    if (this.zWO)
    {
      localObject = this.zWH;
      if (localObject == null) {
        break label578;
      }
      localObject = (WeImageView)((View)localObject).findViewById(2131298775);
      this.zWJ = ((WeImageView)localObject);
      localObject = this.zWJ;
      if (localObject != null) {
        ((WeImageView)localObject).setImageDrawable(ar.m(this.context, 2131690514, -1));
      }
      localObject = this.zWJ;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(-1);
      }
      localObject = this.zWJ;
      if (localObject != null) {
        ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject = this.zWH;
      if (localObject == null) {
        break label583;
      }
      localObject = (MultiTalkSmallControlIconLayout)((View)localObject).findViewById(2131299732);
      label118:
      this.zWI = ((MultiTalkSmallControlIconLayout)localObject);
      if (!this.zQD.epg()) {
        break label588;
      }
      localObject = this.zWI;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setVisibility(8);
      }
      localObject = this.zWJ;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      label164:
      localObject = this.zWI;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setChecked(this.zQD.epg());
      }
      localObject = this.zWI;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setOnClickListener((View.OnClickListener)new b(this));
      }
    }
    Object localObject = this.zWH;
    if (localObject != null)
    {
      localObject = (MultiTalkSmallControlIconLayout)((View)localObject).findViewById(2131304659);
      label230:
      this.zWK = ((MultiTalkSmallControlIconLayout)localObject);
      localObject = this.zWK;
      q localq;
      if (localObject != null)
      {
        localq = ac.eom();
        kotlin.g.b.p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        ((MultiTalkSmallControlIconLayout)localObject).setChecked(localq.Zx());
      }
      localObject = this.zWK;
      if (localObject != null)
      {
        if (!this.zQD.epg()) {
          break label610;
        }
        i = 4;
        label289:
        ((MultiTalkSmallControlIconLayout)localObject).setVisibility(i);
      }
      localObject = this.zWK;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setOnClickListener((View.OnClickListener)new c(this));
      }
      localObject = this.zWH;
      if (localObject == null) {
        break label615;
      }
      localObject = (MultiTalkSmallControlIconLayout)((View)localObject).findViewById(2131308323);
      label338:
      this.zWL = ((MultiTalkSmallControlIconLayout)localObject);
      localObject = this.zWL;
      if (localObject != null)
      {
        localq = ac.eom();
        kotlin.g.b.p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        ((MultiTalkSmallControlIconLayout)localObject).setChecked(localq.enq());
      }
      localObject = this.zWL;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setOnClickListener((View.OnClickListener)new d(this));
      }
      localObject = this.zWL;
      if (localObject != null)
      {
        if (!this.zQD.epg()) {
          break label620;
        }
        i = 4;
        label421:
        ((MultiTalkSmallControlIconLayout)localObject).setVisibility(i);
      }
      if (!this.zWN) {
        break label635;
      }
      localObject = this.zWH;
      if (localObject == null) {
        break label625;
      }
      localObject = (WeImageView)((View)localObject).findViewById(2131304887);
      label453:
      this.zWQ = ((WeImageView)localObject);
      localObject = this.zWQ;
      if (localObject != null) {
        ((WeImageView)localObject).setImageDrawable(ar.m(this.context, 2131690612, this.context.getResources().getColor(2131099844)));
      }
      localObject = this.zWQ;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(this.context.getResources().getColor(2131099844));
      }
      localObject = this.zWQ;
      if (localObject != null) {
        if (!this.zQD.epg()) {
          break label630;
        }
      }
    }
    label578:
    label583:
    label588:
    label610:
    label615:
    label620:
    label625:
    label630:
    for (int i = j;; i = 0)
    {
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.zWQ;
      if (localObject == null) {
        break label635;
      }
      ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new e(this));
      AppMethodBeat.o(240017);
      return;
      localObject = null;
      break;
      localObject = null;
      break label118;
      localObject = this.zWI;
      if (localObject == null) {
        break label164;
      }
      ((MultiTalkSmallControlIconLayout)localObject).setVisibility(0);
      break label164;
      localObject = null;
      break label230;
      i = 0;
      break label289;
      localObject = null;
      break label338;
      i = 0;
      break label421;
      localObject = null;
      break label453;
    }
    label635:
    AppMethodBeat.o(240017);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240008);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!this.zWS.zWR)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240008);
        return;
      }
      paramView = this.zWS.zWI;
      if (paramView != null) {
        paramView.setChecked(false);
      }
      paramView = this.zWS.zWI;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      a.b.a(this.zWS.zQD, a.c.zVo);
      paramView = this.zWS.zWK;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = this.zWS.zWL;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (this.zWS.zWN)
      {
        paramView = this.zWS.zWQ;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
      }
      paramView = this.zWS.zWJ;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240008);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240009);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      if (!this.zWS.zWR)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240009);
        return;
      }
      paramView = this.zWS.zWI;
      if (paramView != null)
      {
        localObject = ac.eom();
        kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        com.tencent.mm.plugin.multitalk.model.p.n(((q)localObject).enn().zHD, 1, 7, 1);
        localObject = f.zZd;
        f.eqp();
        if (paramView.zVH) {
          break label247;
        }
        a.b.a(this.zWS.zQD, a.c.zVn);
        paramView.setChecked(true);
        paramView = this.zWS.zWK;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = this.zWS.zWL;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        if (this.zWS.zWN)
        {
          paramView = this.zWS.zWQ;
          if (paramView != null) {
            paramView.setVisibility(8);
          }
        }
        paramView = this.zWS.zWI;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = this.zWS.zWJ;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240009);
        return;
        label247:
        a.b.a(this.zWS.zQD, a.c.zVo);
        paramView.setChecked(false);
        paramView = this.zWS.zWK;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = this.zWS.zWL;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        if (this.zWS.zWN)
        {
          paramView = this.zWS.zWQ;
          if (paramView != null) {
            paramView.setVisibility(0);
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240011);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      if (!this.zWS.zWR)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240011);
        return;
      }
      paramView = this.zWS.zWK;
      if (paramView != null)
      {
        localObject = f.zZd;
        f.eqq();
        localObject = ac.eom();
        kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        com.tencent.mm.plugin.multitalk.model.p.n(((q)localObject).enn().zHD, 1, 5, 1);
        if (paramView.zVH) {
          break label183;
        }
        this.zWS.bh(this.zWS.context, this.zWS.context.getResources().getString(2131765010));
        paramView.setChecked(true);
      }
      for (;;)
      {
        h.RTc.aX((Runnable)new a(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240011);
        return;
        label183:
        this.zWS.bh(this.zWS.context, this.zWS.context.getResources().getString(2131765009));
        paramView.setChecked(false);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MultiTalkSmallControlIconLayout paramMultiTalkSmallControlIconLayout) {}
      
      public final void run()
      {
        AppMethodBeat.i(240010);
        ac.eom().rK(this.zWT.zVH);
        AppMethodBeat.o(240010);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240013);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      if (!this.zWS.zWR)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240013);
        return;
      }
      paramView = this.zWS.zWL;
      if (paramView != null)
      {
        localObject = f.zZd;
        f.eqr();
        localObject = ac.eom();
        kotlin.g.b.p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        com.tencent.mm.plugin.multitalk.model.p.n(((q)localObject).enn().zHD, 1, 6, 1);
        if (paramView.isEnabled())
        {
          if (paramView.zVH) {
            break label191;
          }
          this.zWS.bh(this.zWS.context, this.zWS.context.getResources().getString(2131765028));
          paramView.setChecked(true);
        }
      }
      for (;;)
      {
        h.RTc.aX((Runnable)new a(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240013);
        return;
        label191:
        this.zWS.bh(this.zWS.context, this.zWS.context.getResources().getString(2131765027));
        paramView.setChecked(false);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MultiTalkSmallControlIconLayout paramMultiTalkSmallControlIconLayout) {}
      
      public final void run()
      {
        AppMethodBeat.i(240012);
        ac.eom().rJ(this.zWT.zVH);
        AppMethodBeat.o(240012);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240014);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      if (!this.zWS.zWR)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240014);
        return;
      }
      paramView = this.zWS;
      localObject = new com.tencent.mm.ui.widget.a.e(this.zWS.context, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject).a((o.f)new k.f(paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject).hbr();
      ((com.tencent.mm.ui.widget.a.e)localObject).a((o.g)new k.g(paramView));
      ((com.tencent.mm.ui.widget.a.e)localObject).Dm(false);
      ((com.tencent.mm.ui.widget.a.e)localObject).dGm();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240014);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements o.g
  {
    g(k paramk) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(240016);
      kotlin.g.b.p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(240016);
        return;
        paramMenuItem = ac.eom();
        kotlin.g.b.p.g(paramMenuItem, "SubCoreMultiTalk.getMultiTalkManager()");
        com.tencent.mm.plugin.multitalk.model.p.n(paramMenuItem.enn().zHD, 1, 8, 1);
        paramMenuItem = this.zWS;
        MultiTalkSmallControlIconLayout localMultiTalkSmallControlIconLayout = paramMenuItem.zWI;
        if ((localMultiTalkSmallControlIconLayout != null) && (localMultiTalkSmallControlIconLayout.zVH == true))
        {
          paramMenuItem = paramMenuItem.zWI;
          if (paramMenuItem != null) {
            paramMenuItem.callOnClick();
          }
        }
        a.b.a(this.zWS.zQD, a.c.zVq);
        AppMethodBeat.o(240016);
        return;
        a.b.a(this.zWS.zQD, a.c.zVB);
        AppMethodBeat.o(240016);
        return;
        a.b.a(this.zWS.zQD, a.c.zVC);
        AppMethodBeat.o(240016);
        return;
        a.b.a(this.zWS.zQD, a.c.zVD);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.k
 * JD-Core Version:    0.7.0.1
 */