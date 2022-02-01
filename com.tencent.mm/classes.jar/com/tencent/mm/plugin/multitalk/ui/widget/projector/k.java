package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "bottomUiLayout", "Landroid/view/View;", "getBottomUiLayout", "()Landroid/view/View;", "setBottomUiLayout", "(Landroid/view/View;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isTouchEnable", "", "mCloseDoodleLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getMCloseDoodleLayout", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setMCloseDoodleLayout", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "mDoodleFinishIv", "getMDoodleFinishIv", "setMDoodleFinishIv", "mDoodleLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "getMDoodleLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "setMDoodleLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;)V", "mIsDoodleFuncSupport", "mIsMoreFuncSupport", "mIsTextFuncSupport", "mMicMuteLayout", "getMMicMuteLayout", "setMMicMuteLayout", "mMoreControlIv", "mSpeakerLayout", "getMSpeakerLayout", "setMSpeakerLayout", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "toastView", "Landroid/widget/Toast;", "applyClickEvent", "", "clearScreen", "getLandScapeLayout", "rootView", "Landroid/widget/FrameLayout;", "getPortraitLayout", "setEnable", "enable", "showCenterToast", "text", "", "showListBottomSheet", "showReaderContent", "show", "plugin-multitalk_release"})
public final class k
{
  View FCp;
  MultiTalkSmallControlIconLayout FCq;
  WeImageView FCr;
  MultiTalkSmallControlIconLayout FCs;
  MultiTalkSmallControlIconLayout FCt;
  private Toast FCu;
  private boolean FCv;
  private boolean FCw;
  private boolean FCx;
  private WeImageView FCy;
  boolean FCz;
  e FvZ;
  a Fwg;
  Context context;
  
  public k(Context paramContext, a parama, e parame)
  {
    AppMethodBeat.i(200509);
    this.context = paramContext;
    this.Fwg = parama;
    this.FvZ = parame;
    paramContext = this.FvZ;
    if (paramContext != null)
    {
      bool1 = paramContext.XO(3);
      this.FCv = bool1;
      paramContext = this.FvZ;
      if (paramContext == null) {
        break label121;
      }
    }
    label121:
    for (boolean bool1 = paramContext.XO(1);; bool1 = false)
    {
      this.FCw = bool1;
      paramContext = this.FvZ;
      bool1 = bool2;
      if (paramContext != null) {
        bool1 = paramContext.XO(2);
      }
      this.FCx = bool1;
      AppMethodBeat.o(200509);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void bt(Context paramContext, String paramString)
  {
    AppMethodBeat.i(200505);
    Object localObject = this.FCu;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    this.FCu = Toast.makeText(paramContext, (CharSequence)"", 0);
    paramContext = View.inflate(paramContext, a.f.multitalk_screen_toast, null);
    localObject = paramContext.findViewById(a.e.toast_text);
    if (localObject == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(200505);
      throw paramContext;
    }
    ((TextView)localObject).setText((CharSequence)paramString);
    paramString = this.FCu;
    if (paramString != null) {
      paramString.setGravity(17, 0, 0);
    }
    paramString = this.FCu;
    if (paramString != null) {
      paramString.setView(paramContext);
    }
    paramContext = this.FCu;
    if (paramContext != null)
    {
      paramContext.show();
      AppMethodBeat.o(200505);
      return;
    }
    AppMethodBeat.o(200505);
  }
  
  final void eZo()
  {
    int j = 4;
    AppMethodBeat.i(200502);
    if (this.FCw)
    {
      localObject = this.FCp;
      if (localObject == null) {
        break label583;
      }
      localObject = (WeImageView)((View)localObject).findViewById(a.e.close_doodle_layout);
      this.FCr = ((WeImageView)localObject);
      localObject = this.FCr;
      if (localObject != null) {
        ((WeImageView)localObject).setImageDrawable(au.o(this.context, a.g.icons_filled_close, -1));
      }
      localObject = this.FCr;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(-1);
      }
      localObject = this.FCr;
      if (localObject != null) {
        ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject = this.FCp;
      if (localObject == null) {
        break label588;
      }
      localObject = (MultiTalkSmallControlIconLayout)((View)localObject).findViewById(a.e.doodle_layout);
      label122:
      this.FCq = ((MultiTalkSmallControlIconLayout)localObject);
      if (!this.Fwg.eYW()) {
        break label593;
      }
      localObject = this.FCq;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setVisibility(8);
      }
      localObject = this.FCr;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
      label168:
      localObject = this.FCq;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setChecked(this.Fwg.eYW());
      }
      localObject = this.FCq;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setOnClickListener((View.OnClickListener)new b(this));
      }
    }
    Object localObject = this.FCp;
    if (localObject != null)
    {
      localObject = (MultiTalkSmallControlIconLayout)((View)localObject).findViewById(a.e.mic_mute_layout);
      label234:
      this.FCs = ((MultiTalkSmallControlIconLayout)localObject);
      localObject = this.FCs;
      q localq;
      if (localObject != null)
      {
        localq = ad.eYc();
        kotlin.g.b.p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        ((MultiTalkSmallControlIconLayout)localObject).setChecked(localq.aeg());
      }
      localObject = this.FCs;
      if (localObject != null)
      {
        if (!this.Fwg.eYW()) {
          break label615;
        }
        i = 4;
        label293:
        ((MultiTalkSmallControlIconLayout)localObject).setVisibility(i);
      }
      localObject = this.FCs;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setOnClickListener((View.OnClickListener)new c(this));
      }
      localObject = this.FCp;
      if (localObject == null) {
        break label620;
      }
      localObject = (MultiTalkSmallControlIconLayout)((View)localObject).findViewById(a.e.speaker_layout);
      label342:
      this.FCt = ((MultiTalkSmallControlIconLayout)localObject);
      localObject = this.FCt;
      if (localObject != null)
      {
        localq = ad.eYc();
        kotlin.g.b.p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        ((MultiTalkSmallControlIconLayout)localObject).setChecked(localq.eXe());
      }
      localObject = this.FCt;
      if (localObject != null) {
        ((MultiTalkSmallControlIconLayout)localObject).setOnClickListener((View.OnClickListener)new d(this));
      }
      localObject = this.FCt;
      if (localObject != null)
      {
        if (!this.Fwg.eYW()) {
          break label625;
        }
        i = 4;
        label425:
        ((MultiTalkSmallControlIconLayout)localObject).setVisibility(i);
      }
      if (!this.FCv) {
        break label640;
      }
      localObject = this.FCp;
      if (localObject == null) {
        break label630;
      }
      localObject = (WeImageView)((View)localObject).findViewById(a.e.more_iv);
      label457:
      this.FCy = ((WeImageView)localObject);
      localObject = this.FCy;
      if (localObject != null) {
        ((WeImageView)localObject).setImageDrawable(au.o(this.context, a.g.icons_filled_more, this.context.getResources().getColor(com.tencent.mm.plugin.multitalk.a.b.White)));
      }
      localObject = this.FCy;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(this.context.getResources().getColor(com.tencent.mm.plugin.multitalk.a.b.White));
      }
      localObject = this.FCy;
      if (localObject != null) {
        if (!this.Fwg.eYW()) {
          break label635;
        }
      }
    }
    label583:
    label588:
    label593:
    label615:
    label620:
    label625:
    label630:
    label635:
    for (int i = j;; i = 0)
    {
      ((WeImageView)localObject).setVisibility(i);
      localObject = this.FCy;
      if (localObject == null) {
        break label640;
      }
      ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new e(this));
      AppMethodBeat.o(200502);
      return;
      localObject = null;
      break;
      localObject = null;
      break label122;
      localObject = this.FCq;
      if (localObject == null) {
        break label168;
      }
      ((MultiTalkSmallControlIconLayout)localObject).setVisibility(0);
      break label168;
      localObject = null;
      break label234;
      i = 0;
      break label293;
      localObject = null;
      break label342;
      i = 0;
      break label425;
      localObject = null;
      break label457;
    }
    label640:
    AppMethodBeat.o(200502);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200611);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!k.a(this.FCA))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(200611);
        return;
      }
      paramView = this.FCA.FCq;
      if (paramView != null) {
        paramView.setChecked(false);
      }
      paramView = this.FCA.FCq;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      a.b.a(this.FCA.Fwg, a.c.FAY);
      paramView = this.FCA.FCs;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = this.FCA.FCt;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (k.b(this.FCA))
      {
        paramView = k.c(this.FCA);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
      }
      paramView = this.FCA.FCr;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200611);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195905);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if (!k.a(this.FCA))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195905);
        return;
      }
      paramView = this.FCA.FCq;
      if (paramView != null)
      {
        localObject = ad.eYc();
        kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        com.tencent.mm.plugin.multitalk.model.p.q(((q)localObject).eXb().FmO, 1, 7, 1);
        localObject = f.FEQ;
        f.faf();
        if (paramView.FBr) {
          break label247;
        }
        a.b.a(this.FCA.Fwg, a.c.FAX);
        paramView.setChecked(true);
        paramView = this.FCA.FCs;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = this.FCA.FCt;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        if (k.b(this.FCA))
        {
          paramView = k.c(this.FCA);
          if (paramView != null) {
            paramView.setVisibility(8);
          }
        }
        paramView = this.FCA.FCq;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = this.FCA.FCr;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195905);
        return;
        label247:
        a.b.a(this.FCA.Fwg, a.c.FAY);
        paramView.setChecked(false);
        paramView = this.FCA.FCs;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = this.FCA.FCt;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        if (k.b(this.FCA))
        {
          paramView = k.c(this.FCA);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(205274);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if (!k.a(this.FCA))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205274);
        return;
      }
      paramView = this.FCA.FCs;
      if (paramView != null)
      {
        localObject = f.FEQ;
        f.fag();
        localObject = ad.eYc();
        kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        com.tencent.mm.plugin.multitalk.model.p.q(((q)localObject).eXb().FmO, 1, 5, 1);
        if (paramView.FBr) {
          break label184;
        }
        this.FCA.bt(this.FCA.context, this.FCA.context.getResources().getString(a.h.screen_mute_on));
        paramView.setChecked(true);
      }
      for (;;)
      {
        h.ZvG.be((Runnable)new a(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(205274);
        return;
        label184:
        this.FCA.bt(this.FCA.context, this.FCA.context.getResources().getString(a.h.screen_mute_off));
        paramView.setChecked(false);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MultiTalkSmallControlIconLayout paramMultiTalkSmallControlIconLayout) {}
      
      public final void run()
      {
        AppMethodBeat.i(203622);
        ad.eYc().uN(this.FCB.FBr);
        AppMethodBeat.o(203622);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206990);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if (!k.a(this.FCA))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206990);
        return;
      }
      paramView = this.FCA.FCt;
      if (paramView != null)
      {
        localObject = f.FEQ;
        f.fah();
        localObject = ad.eYc();
        kotlin.g.b.p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
        com.tencent.mm.plugin.multitalk.model.p.q(((q)localObject).eXb().FmO, 1, 6, 1);
        if (paramView.isEnabled())
        {
          if (paramView.FBr) {
            break label192;
          }
          this.FCA.bt(this.FCA.context, this.FCA.context.getResources().getString(a.h.screen_speaker_on));
          paramView.setChecked(true);
        }
      }
      for (;;)
      {
        h.ZvG.be((Runnable)new a(paramView));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206990);
        return;
        label192:
        this.FCA.bt(this.FCA.context, this.FCA.context.getResources().getString(a.h.screen_speaker_off));
        paramView.setChecked(false);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MultiTalkSmallControlIconLayout paramMultiTalkSmallControlIconLayout) {}
      
      public final void run()
      {
        AppMethodBeat.i(198614);
        ad.eYc().uM(this.FCB.FBr);
        AppMethodBeat.o(198614);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206471);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!k.a(this.FCA))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206471);
        return;
      }
      k.a(this.FCA, this.FCA.context);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI$applyClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206471);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class g
    implements q.g
  {
    g(k paramk) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(197783);
      kotlin.g.b.p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(197783);
        return;
        paramMenuItem = ad.eYc();
        kotlin.g.b.p.j(paramMenuItem, "SubCoreMultiTalk.getMultiTalkManager()");
        com.tencent.mm.plugin.multitalk.model.p.q(paramMenuItem.eXb().FmO, 1, 8, 1);
        paramMenuItem = this.FCA;
        MultiTalkSmallControlIconLayout localMultiTalkSmallControlIconLayout = paramMenuItem.FCq;
        if ((localMultiTalkSmallControlIconLayout != null) && (localMultiTalkSmallControlIconLayout.FBr == true))
        {
          paramMenuItem = paramMenuItem.FCq;
          if (paramMenuItem != null) {
            paramMenuItem.callOnClick();
          }
        }
        a.b.a(this.FCA.Fwg, a.c.FBa);
        AppMethodBeat.o(197783);
        return;
        a.b.a(this.FCA.Fwg, a.c.FBl);
        AppMethodBeat.o(197783);
        return;
        a.b.a(this.FCA.Fwg, a.c.FBm);
        AppMethodBeat.o(197783);
        return;
        a.b.a(this.FCA.Fwg, a.c.FBn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.k
 * JD-Core Version:    0.7.0.1
 */