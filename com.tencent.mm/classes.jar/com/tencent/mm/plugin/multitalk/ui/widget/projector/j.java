package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.e.d;
import com.tencent.mm.plugin.multitalk.e.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "bottomUiLayout", "Landroid/view/View;", "getBottomUiLayout", "()Landroid/view/View;", "setBottomUiLayout", "(Landroid/view/View;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isTouchEnable", "", "mCloseDoodleLayout", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getMCloseDoodleLayout", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setMCloseDoodleLayout", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "mDoodleFinishIv", "getMDoodleFinishIv", "setMDoodleFinishIv", "mDoodleLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "getMDoodleLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;", "setMDoodleLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkSmallControlIconLayout;)V", "mIsDoodleFuncSupport", "mIsMoreFuncSupport", "mIsTextFuncSupport", "mMicMuteLayout", "getMMicMuteLayout", "setMMicMuteLayout", "mMoreControlIv", "mSpeakerLayout", "getMSpeakerLayout", "setMSpeakerLayout", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "toastView", "Landroid/widget/Toast;", "applyClickEvent", "", "clearScreen", "getLandScapeLayout", "rootView", "Landroid/widget/FrameLayout;", "getPortraitLayout", "setEnable", "enable", "showCenterToast", "text", "", "showListBottomSheet", "showReaderContent", "show", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  private e Lsc;
  private a Lsq;
  View Lym;
  private MultiTalkSmallControlIconLayout Lyn;
  private WeImageView Lyo;
  private MultiTalkSmallControlIconLayout Lyp;
  private MultiTalkSmallControlIconLayout Lyq;
  private Toast Lyr;
  private boolean Lys;
  private boolean Lyt;
  private boolean Lyu;
  private WeImageView Lyv;
  boolean Lyw;
  private Context context;
  
  public j(Context paramContext, a parama, e parame)
  {
    AppMethodBeat.i(285640);
    this.context = paramContext;
    this.Lsq = parama;
    this.Lsc = parame;
    paramContext = this.Lsc;
    if (paramContext == null)
    {
      bool1 = false;
      this.Lys = bool1;
      paramContext = this.Lsc;
      if (paramContext != null) {
        break label110;
      }
      bool1 = false;
      label69:
      this.Lyt = bool1;
      paramContext = this.Lsc;
      if (paramContext != null) {
        break label120;
      }
    }
    label110:
    label120:
    for (boolean bool1 = bool2;; bool1 = paramContext.abY(2))
    {
      this.Lyu = bool1;
      AppMethodBeat.o(285640);
      return;
      bool1 = paramContext.abY(3);
      break;
      bool1 = paramContext.abY(1);
      break label69;
    }
  }
  
  private static final void a(MultiTalkSmallControlIconLayout paramMultiTalkSmallControlIconLayout)
  {
    AppMethodBeat.i(285699);
    kotlin.g.b.s.u(paramMultiTalkSmallControlIconLayout, "$it");
    ac.ggS().zc(paramMultiTalkSmallControlIconLayout.Lxu);
    AppMethodBeat.o(285699);
  }
  
  private static final void a(j paramj, MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 1;
    AppMethodBeat.i(285764);
    kotlin.g.b.s.u(paramj, "this$0");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(285764);
      return;
      ac.ggS();
      o.gfF();
      paramMenuItem = paramj.Lyn;
      if ((paramMenuItem != null) && (paramMenuItem.Lxu == true)) {}
      for (;;)
      {
        if (paramInt != 0)
        {
          paramMenuItem = paramj.Lyn;
          if (paramMenuItem != null) {
            paramMenuItem.callOnClick();
          }
        }
        a.b.a(paramj.Lsq, a.c.Lxc);
        AppMethodBeat.o(285764);
        return;
        paramInt = 0;
      }
      a.b.a(paramj.Lsq, a.c.Lxn);
      AppMethodBeat.o(285764);
      return;
      a.b.a(paramj.Lsq, a.c.Lxo);
      AppMethodBeat.o(285764);
      return;
      a.b.a(paramj.Lsq, a.c.Lxp);
    }
  }
  
  private static final void a(j paramj, View paramView)
  {
    AppMethodBeat.i(285678);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "this$0");
    if (!paramj.Lyw)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285678);
      return;
    }
    paramView = paramj.Lyn;
    if (paramView != null) {
      paramView.setChecked(false);
    }
    paramView = paramj.Lyn;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    a.b.a(paramj.Lsq, a.c.Lxa);
    paramView = paramj.Lyp;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    paramView = paramj.Lyq;
    if (paramView != null) {
      paramView.setVisibility(0);
    }
    if (paramj.Lys)
    {
      paramView = paramj.Lyv;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
    }
    paramj = paramj.Lyo;
    if (paramj != null) {
      paramj.setVisibility(8);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(285678);
  }
  
  private static final void a(j paramj, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(285754);
    kotlin.g.b.s.u(paramj, "this$0");
    paramj = paramj.Lsc;
    if (paramj != null)
    {
      paramj = paramj.LxP;
      if (paramj != null)
      {
        paramj = ((Iterable)paramj).iterator();
        while (paramj.hasNext())
        {
          e.c localc = (e.c)paramj.next();
          params.a(localc.LxR, -1, (CharSequence)localc.name);
        }
      }
    }
    AppMethodBeat.o(285754);
  }
  
  private static final void b(MultiTalkSmallControlIconLayout paramMultiTalkSmallControlIconLayout)
  {
    AppMethodBeat.i(285717);
    kotlin.g.b.s.u(paramMultiTalkSmallControlIconLayout, "$it");
    ac.ggS().zb(paramMultiTalkSmallControlIconLayout.Lxu);
    AppMethodBeat.o(285717);
  }
  
  private static final void b(j paramj, View paramView)
  {
    AppMethodBeat.i(285690);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "this$0");
    if (!paramj.Lyw)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285690);
      return;
    }
    paramView = paramj.Lyn;
    if (paramView != null)
    {
      localObject = g.LAS;
      g.gjk();
      if (paramView.Lxu) {
        break label239;
      }
      a.b.a(paramj.Lsq, a.c.LwZ);
      paramView.setChecked(true);
      paramView = paramj.Lyp;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = paramj.Lyq;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      if (paramj.Lys)
      {
        paramView = paramj.Lyv;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
      }
      paramView = paramj.Lyn;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramj = paramj.Lyo;
      if (paramj != null) {
        paramj.setVisibility(0);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285690);
      return;
      label239:
      a.b.a(paramj.Lsq, a.c.Lxa);
      paramView.setChecked(false);
      paramView = paramj.Lyp;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = paramj.Lyq;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      if (paramj.Lys)
      {
        paramj = paramj.Lyv;
        if (paramj != null) {
          paramj.setVisibility(0);
        }
      }
    }
  }
  
  private void bv(Context paramContext, String paramString)
  {
    AppMethodBeat.i(285663);
    Object localObject = this.Lyr;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    this.Lyr = Toast.makeText(paramContext, (CharSequence)"", 0);
    paramContext = View.inflate(paramContext, a.f.multitalk_screen_toast, null);
    localObject = paramContext.findViewById(a.e.toast_text);
    if (localObject == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(285663);
      throw paramContext;
    }
    ((TextView)localObject).setText((CharSequence)paramString);
    paramString = this.Lyr;
    if (paramString != null) {
      paramString.setGravity(17, 0, 0);
    }
    paramString = this.Lyr;
    if (paramString != null) {
      paramString.setView(paramContext);
    }
    paramContext = this.Lyr;
    if (paramContext != null) {
      paramContext.show();
    }
    AppMethodBeat.o(285663);
  }
  
  private static final void c(j paramj, View paramView)
  {
    AppMethodBeat.i(285712);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "this$0");
    if (!paramj.Lyw)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285712);
      return;
    }
    paramView = paramj.Lyp;
    if (paramView != null)
    {
      localObject = g.LAS;
      g.gjl();
      localObject = d.LAq;
      d.ace(5);
      if (paramView.Lxu) {
        break label216;
      }
      paramj.bv(paramj.context, paramj.context.getResources().getString(a.h.screen_mute_on));
      paramj = paramj.Lyp;
      if (paramj != null) {
        paramj.setContentDescription((CharSequence)MMApplicationContext.getString(a.h.multitalk_members_msc_off));
      }
      paramView.setChecked(true);
    }
    for (;;)
    {
      h.ahAA.bm(new j..ExternalSyntheticLambda8(paramView));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285712);
      return;
      label216:
      paramj.bv(paramj.context, paramj.context.getResources().getString(a.h.screen_mute_off));
      paramj = paramj.Lyp;
      if (paramj != null) {
        paramj.setContentDescription((CharSequence)MMApplicationContext.getString(a.h.multitalk_members_msc_on));
      }
      paramView.setChecked(false);
    }
  }
  
  private static final void d(j paramj, View paramView)
  {
    AppMethodBeat.i(285733);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "this$0");
    if (!paramj.Lyw)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285733);
      return;
    }
    paramView = paramj.Lyq;
    if (paramView != null)
    {
      localObject = g.LAS;
      g.gjm();
      localObject = d.LAq;
      d.ace(6);
      if (paramView.isEnabled())
      {
        if (paramView.Lxu) {
          break label224;
        }
        paramj.bv(paramj.context, paramj.context.getResources().getString(a.h.screen_speaker_on));
        paramj = paramj.Lyq;
        if (paramj != null) {
          paramj.setContentDescription((CharSequence)MMApplicationContext.getString(a.h.multitalk_members_speaker_on));
        }
        paramView.setChecked(true);
      }
    }
    for (;;)
    {
      h.ahAA.bm(new j..ExternalSyntheticLambda7(paramView));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285733);
      return;
      label224:
      paramj.bv(paramj.context, paramj.context.getResources().getString(a.h.screen_speaker_off));
      paramj = paramj.Lyq;
      if (paramj != null) {
        paramj.setContentDescription((CharSequence)MMApplicationContext.getString(a.h.multitalk_members_speaker_off));
      }
      paramView.setChecked(false);
    }
  }
  
  private static final void e(j paramj, View paramView)
  {
    AppMethodBeat.i(285744);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "this$0");
    if (!paramj.Lyw)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285744);
      return;
    }
    paramj.jd(paramj.context);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(285744);
  }
  
  private final void gin()
  {
    int j = 4;
    Object localObject2 = null;
    AppMethodBeat.i(285656);
    if (this.Lyt)
    {
      localObject1 = this.Lym;
      if (localObject1 != null) {
        break label579;
      }
      localObject1 = null;
      this.Lyo = ((WeImageView)localObject1);
      localObject1 = this.Lyo;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setImageDrawable(bb.m(this.context, a.g.icons_filled_close, -1));
      }
      localObject1 = this.Lyo;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setIconColor(-1);
      }
      localObject1 = this.Lyo;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setOnClickListener(new j..ExternalSyntheticLambda4(this));
      }
      localObject1 = this.Lym;
      if (localObject1 != null) {
        break label593;
      }
      localObject1 = null;
      label104:
      this.Lyn = ((MultiTalkSmallControlIconLayout)localObject1);
      if (!this.Lsq.ghV()) {
        break label607;
      }
      localObject1 = this.Lyn;
      if (localObject1 != null) {
        ((MultiTalkSmallControlIconLayout)localObject1).setVisibility(8);
      }
      localObject1 = this.Lyo;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setVisibility(0);
      }
      label150:
      localObject1 = this.Lyn;
      if (localObject1 != null) {
        ((MultiTalkSmallControlIconLayout)localObject1).setChecked(this.Lsq.ghV());
      }
      localObject1 = this.Lyn;
      if (localObject1 != null) {
        ((MultiTalkSmallControlIconLayout)localObject1).setOnClickListener(new j..ExternalSyntheticLambda2(this));
      }
    }
    Object localObject1 = this.Lym;
    if (localObject1 == null)
    {
      localObject1 = null;
      label204:
      this.Lyp = ((MultiTalkSmallControlIconLayout)localObject1);
      localObject1 = this.Lyp;
      if (localObject1 != null) {
        ((MultiTalkSmallControlIconLayout)localObject1).setChecked(ac.ggS().lAj);
      }
      localObject1 = this.Lyp;
      kotlin.g.b.s.checkNotNull(localObject1);
      if (!((MultiTalkSmallControlIconLayout)localObject1).Lxu) {
        break label638;
      }
      localObject1 = this.Lyp;
      if (localObject1 != null) {
        ((MultiTalkSmallControlIconLayout)localObject1).setContentDescription((CharSequence)MMApplicationContext.getString(a.h.multitalk_members_msc_off));
      }
      label266:
      localObject1 = this.Lyp;
      if (localObject1 != null)
      {
        if (!this.Lsq.ghV()) {
          break label663;
        }
        i = 4;
        label289:
        ((MultiTalkSmallControlIconLayout)localObject1).setVisibility(i);
      }
      localObject1 = this.Lyp;
      if (localObject1 != null) {
        ((MultiTalkSmallControlIconLayout)localObject1).setOnClickListener(new j..ExternalSyntheticLambda1(this));
      }
      localObject1 = this.Lym;
      if (localObject1 != null) {
        break label668;
      }
      localObject1 = null;
      label326:
      this.Lyq = ((MultiTalkSmallControlIconLayout)localObject1);
      localObject1 = this.Lyq;
      if (localObject1 != null) {
        ((MultiTalkSmallControlIconLayout)localObject1).setChecked(ac.ggS().snA);
      }
      localObject1 = this.Lyq;
      kotlin.g.b.s.checkNotNull(localObject1);
      if (!((MultiTalkSmallControlIconLayout)localObject1).Lxu) {
        break label682;
      }
      localObject1 = this.Lyq;
      if (localObject1 != null) {
        ((MultiTalkSmallControlIconLayout)localObject1).setContentDescription((CharSequence)MMApplicationContext.getString(a.h.multitalk_members_speaker_off));
      }
      label388:
      localObject1 = this.Lyq;
      if (localObject1 != null) {
        ((MultiTalkSmallControlIconLayout)localObject1).setOnClickListener(new j..ExternalSyntheticLambda0(this));
      }
      localObject1 = this.Lyq;
      if (localObject1 != null)
      {
        if (!this.Lsq.ghV()) {
          break label707;
        }
        i = 4;
        label432:
        ((MultiTalkSmallControlIconLayout)localObject1).setVisibility(i);
      }
      if (this.Lys)
      {
        localObject1 = this.Lym;
        if (localObject1 != null) {
          break label712;
        }
        localObject1 = localObject2;
        label456:
        this.Lyv = ((WeImageView)localObject1);
        localObject1 = this.Lyv;
        if (localObject1 != null) {
          ((WeImageView)localObject1).setImageDrawable(bb.m(this.context, a.g.icons_filled_more, this.context.getResources().getColor(com.tencent.mm.plugin.multitalk.a.b.White)));
        }
        localObject1 = this.Lyv;
        if (localObject1 != null) {
          ((WeImageView)localObject1).setIconColor(this.context.getResources().getColor(com.tencent.mm.plugin.multitalk.a.b.White));
        }
        localObject1 = this.Lyv;
        if (localObject1 != null) {
          if (!this.Lsq.ghV()) {
            break label726;
          }
        }
      }
    }
    label579:
    label593:
    label726:
    for (int i = j;; i = 0)
    {
      ((WeImageView)localObject1).setVisibility(i);
      localObject1 = this.Lyv;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setOnClickListener(new j..ExternalSyntheticLambda3(this));
      }
      AppMethodBeat.o(285656);
      return;
      localObject1 = (WeImageView)((View)localObject1).findViewById(a.e.close_doodle_layout);
      break;
      localObject1 = (MultiTalkSmallControlIconLayout)((View)localObject1).findViewById(a.e.doodle_layout);
      break label104;
      label607:
      localObject1 = this.Lyn;
      if (localObject1 == null) {
        break label150;
      }
      ((MultiTalkSmallControlIconLayout)localObject1).setVisibility(0);
      break label150;
      localObject1 = (MultiTalkSmallControlIconLayout)((View)localObject1).findViewById(a.e.mic_mute_layout);
      break label204;
      label638:
      localObject1 = this.Lyp;
      if (localObject1 == null) {
        break label266;
      }
      ((MultiTalkSmallControlIconLayout)localObject1).setContentDescription((CharSequence)MMApplicationContext.getString(a.h.multitalk_members_msc_on));
      break label266;
      i = 0;
      break label289;
      localObject1 = (MultiTalkSmallControlIconLayout)((View)localObject1).findViewById(a.e.speaker_layout);
      break label326;
      localObject1 = this.Lyq;
      if (localObject1 == null) {
        break label388;
      }
      ((MultiTalkSmallControlIconLayout)localObject1).setContentDescription((CharSequence)MMApplicationContext.getString(a.h.multitalk_members_speaker_on));
      break label388;
      i = 0;
      break label432;
      localObject1 = (WeImageView)((View)localObject1).findViewById(a.e.more_iv);
      break label456;
    }
  }
  
  private final void jd(Context paramContext)
  {
    AppMethodBeat.i(285670);
    paramContext = new f(paramContext, 1, false);
    paramContext.Vtg = new j..ExternalSyntheticLambda5(this);
    paramContext.NE(true);
    paramContext.GAC = new j..ExternalSyntheticLambda6(this);
    paramContext.uR(false);
    paramContext.dDn();
    AppMethodBeat.o(285670);
  }
  
  public final View d(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(285823);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFrameLayout, "rootView");
    this.Lym = LayoutInflater.from(paramContext).inflate(a.f.multitalk_screen_project_bottom_ui, (ViewGroup)paramFrameLayout);
    gin();
    paramContext = this.Lym;
    AppMethodBeat.o(285823);
    return paramContext;
  }
  
  public final View e(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(285831);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramFrameLayout, "rootView");
    this.Lym = LayoutInflater.from(paramContext).inflate(a.f.multitalk_screen_project_bottom_ui_land, (ViewGroup)paramFrameLayout);
    gin();
    paramContext = this.Lym;
    AppMethodBeat.o(285831);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.j
 * JD-Core Version:    0.7.0.1
 */