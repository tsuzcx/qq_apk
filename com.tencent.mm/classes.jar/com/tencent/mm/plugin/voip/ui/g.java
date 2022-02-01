package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.e.a.b;
import com.tencent.mm.plugin.voip.e.a.c;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.widget.MMCheckBox;
import com.tencent.mm.plugin.voip.widget.VoIPControlIconLayout;
import com.tencent.mm.plugin.voip.widget.VoIPFuncIconLayout;
import com.tencent.mm.plugin.voip.widget.VoipSmallIconButton;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/ui/VoIPBottomControlUI;", "", "statusManager", "Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;", "(Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;)V", "mBottomControlUI", "Landroid/view/View;", "mClickIgnoreLsn", "Landroid/view/View$OnClickListener;", "mIgnoreBtn", "Lcom/tencent/mm/plugin/voip/widget/VoipSmallIconButton;", "mIsMute", "", "mMainBtnController", "Lcom/tencent/mm/plugin/voip/ui/VoIPMainBtnControl;", "mMainControlRoot", "Landroid/widget/FrameLayout;", "mMicBtn", "Lcom/tencent/mm/plugin/voip/widget/VoIPControlIconLayout;", "mMuteClickLsn", "mSpeakerBtn", "mSpeakerClickLsn", "mSwitchAudioAcceptBtn", "Lcom/tencent/mm/plugin/voip/widget/VoIPFuncIconLayout;", "mSwitchAudioAcceptClickLsn", "mSwitchAudioClickLsn", "mSwitchCameraBtn", "mSwitchCameraClickLsn", "mSwitchToAudioBtn", "mVoicePlayDevice", "", "mWaitingView", "getStatusManager", "()Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;", "setStatusManager", "applyEvent", "", "isVideo", "checkSwitchCameraVisible", "checkVoipPlayDevice", "device", "dismissUI", "getLayout", "context", "Landroid/content/Context;", "rootView", "responseAfterAccept", "responseAfterReject", "responseAfterScreenClick", "visible", "setCancelBtnEnable", "isEnable", "setMute", "mute", "setVoicePlayDevice", "showCalledConnecting", "showCalledInviting", "showCallingConnecting", "showCallingInviting", "showCallingWaitingAccept", "showFinish", "showUI", "showVoIPTalking", "updateCameraDesc", "updateSpeakerStatus", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a UJx;
  final View.OnClickListener UIQ;
  VoIPFuncIconLayout UJA;
  VoIPFuncIconLayout UJB;
  VoIPFuncIconLayout UJC;
  View UJD;
  private View UJE;
  h UJF;
  FrameLayout UJG;
  VoIPControlIconLayout UJH;
  VoIPControlIconLayout UJI;
  final View.OnClickListener UJJ;
  final View.OnClickListener UJK;
  final View.OnClickListener UJL;
  final View.OnClickListener UJM;
  final View.OnClickListener UJN;
  private com.tencent.mm.plugin.voip.e.a UJy;
  VoipSmallIconButton UJz;
  int Uxg;
  boolean mIsMute;
  
  static
  {
    AppMethodBeat.i(292516);
    UJx = new g.a((byte)0);
    AppMethodBeat.o(292516);
  }
  
  public g(com.tencent.mm.plugin.voip.e.a parama)
  {
    AppMethodBeat.i(292452);
    this.UJy = parama;
    this.Uxg = 1;
    this.UJF = new h(this.UJy);
    this.UJJ = new g..ExternalSyntheticLambda1(this);
    this.UJK = new g..ExternalSyntheticLambda3(this);
    this.UJL = new g..ExternalSyntheticLambda4(this);
    this.UIQ = new g..ExternalSyntheticLambda2(this);
    this.UJM = new g..ExternalSyntheticLambda5(this);
    this.UJN = new g..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(292452);
  }
  
  private static final void a(g paramg, Bundle paramBundle)
  {
    AppMethodBeat.i(292505);
    s.u(paramg, "this$0");
    s.u(paramBundle, "$params");
    paramg.UJy.a(a.c.UHL, paramBundle);
    AppMethodBeat.o(292505);
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(292466);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    a.b.a(paramg.UJy, a.c.UHT);
    paramg.ghJ();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292466);
  }
  
  private static final void b(g paramg, View paramView)
  {
    AppMethodBeat.i(292470);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    a.b.a(paramg.UJy, a.c.UHR);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292470);
  }
  
  private static final void c(g paramg, View paramView)
  {
    AppMethodBeat.i(292480);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    a.b.a(paramg.UJy, a.c.UHS);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292480);
  }
  
  private static final void d(g paramg, View paramView)
  {
    AppMethodBeat.i(292487);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    a.b.a(paramg.UJy, a.c.UHM);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292487);
  }
  
  private static final void e(g paramg, View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(292497);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    paramView = paramg.UJI;
    boolean bool3;
    if (paramView != null)
    {
      bool3 = paramView.LtJ.isChecked();
      Log.i("MicroMsg.VoIPBottomControlUI", "onMicClick, status: %b", new Object[] { Boolean.valueOf(bool3) });
      localObject = new Bundle();
      if (bool3) {
        break label183;
      }
      bool1 = true;
      ((Bundle)localObject).putBoolean("mute", bool1);
      paramg.UJy.a(a.c.UHK, (Bundle)localObject);
      if (bool3) {
        break label188;
      }
    }
    label183:
    label188:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramg.mIsMute = bool1;
      paramView.setChecked(bool3);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292497);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static final void f(g paramg, View paramView)
  {
    AppMethodBeat.i(292510);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    paramView = paramg.UJH;
    boolean bool;
    if (paramView != null)
    {
      bool = paramView.LtJ.isChecked();
      Log.i("MicroMsg.VoIPBottomControlUI", "onSpeakerClick, status: %b", new Object[] { Boolean.valueOf(bool) });
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("speaker", bool);
      com.tencent.threadpool.h.ahAA.bm(new g..ExternalSyntheticLambda6(paramg, (Bundle)localObject));
      if (!bool) {
        break label175;
      }
    }
    label175:
    for (int i = 1;; i = 2)
    {
      paramg.Uxg = i;
      paramView.setChecked(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPBottomControlUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292510);
      return;
    }
  }
  
  private final void ghJ()
  {
    VoIPFuncIconLayout localVoIPFuncIconLayout = null;
    Object localObject1 = null;
    AppMethodBeat.i(292459);
    Object localObject2 = SubCoreVoip.hVp();
    int i;
    if (localObject2 != null)
    {
      localObject2 = ((u)localObject2).UBF;
      if ((localObject2 != null) && (!((com.tencent.mm.plugin.voip.a)localObject2).hVn()))
      {
        i = 1;
        if (i != 0) {
          break label110;
        }
        localVoIPFuncIconLayout = this.UJB;
        if (localVoIPFuncIconLayout == null) {
          break label141;
        }
        localObject2 = this.UJD;
        if (localObject2 != null) {
          break label86;
        }
      }
    }
    for (;;)
    {
      localVoIPFuncIconLayout.setContentDescription((CharSequence)localObject1);
      AppMethodBeat.o(292459);
      return;
      i = 0;
      break;
      label86:
      localObject2 = ((View)localObject2).getContext();
      if (localObject2 != null) {
        localObject1 = ((Context)localObject2).getString(b.g.voip_fore_camera_desc);
      }
    }
    label110:
    localObject2 = this.UJB;
    if (localObject2 != null)
    {
      localObject1 = this.UJD;
      if (localObject1 != null) {
        break label148;
      }
      localObject1 = localVoIPFuncIconLayout;
    }
    for (;;)
    {
      ((VoIPFuncIconLayout)localObject2).setContentDescription((CharSequence)localObject1);
      label141:
      AppMethodBeat.o(292459);
      return;
      label148:
      Context localContext = ((View)localObject1).getContext();
      localObject1 = localVoIPFuncIconLayout;
      if (localContext != null) {
        localObject1 = localContext.getString(b.g.voip_back_camera_desc);
      }
    }
  }
  
  public final void GD(boolean paramBoolean)
  {
    AppMethodBeat.i(292612);
    Object localObject = this.UJE;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    if (m.RW("VOIPBlockIgnoreButton") == 0)
    {
      localObject = this.UJz;
      if (localObject != null) {
        ((VoipSmallIconButton)localObject).setVisibility(0);
      }
      if (!paramBoolean) {
        break label159;
      }
      localObject = this.UJA;
      if (localObject != null) {
        ((VoIPFuncIconLayout)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      localObject = this.UJC;
      if (localObject != null) {
        ((VoIPFuncIconLayout)localObject).setVisibility(8);
      }
      localObject = this.UJB;
      if (localObject != null) {
        ((VoIPFuncIconLayout)localObject).setVisibility(8);
      }
      localObject = this.UJI;
      if (localObject != null) {
        ((VoIPControlIconLayout)localObject).setVisibility(8);
      }
      localObject = this.UJH;
      if (localObject != null) {
        ((VoIPControlIconLayout)localObject).setVisibility(8);
      }
      localObject = this.UJF;
      if (localObject != null) {
        ((h)localObject).iak();
      }
      AppMethodBeat.o(292612);
      return;
      localObject = this.UJz;
      if (localObject == null) {
        break;
      }
      ((VoipSmallIconButton)localObject).setVisibility(8);
      break;
      label159:
      localObject = this.UJA;
      if (localObject != null) {
        ((VoIPFuncIconLayout)localObject).setVisibility(8);
      }
    }
  }
  
  public final void GE(boolean paramBoolean)
  {
    AppMethodBeat.i(292569);
    Object localObject = this.UJz;
    if (localObject != null) {
      ((VoipSmallIconButton)localObject).setVisibility(8);
    }
    if (!paramBoolean)
    {
      localObject = this.UJI;
      if (localObject != null) {
        ((VoIPControlIconLayout)localObject).setVisibility(0);
      }
      localObject = this.UJI;
      if (localObject != null) {
        ((VoIPControlIconLayout)localObject).setIconEnabled(true);
      }
      localObject = this.UJI;
      if (localObject != null) {
        ((VoIPControlIconLayout)localObject).setChecked(true);
      }
      localObject = this.UJH;
      if (localObject != null) {
        ((VoIPControlIconLayout)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      localObject = this.UJF;
      if (localObject != null) {
        ((h)localObject).GE(paramBoolean);
      }
      localObject = this.UJE;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      AppMethodBeat.o(292569);
      return;
      localObject = this.UJB;
      if (localObject != null) {
        ((VoIPFuncIconLayout)localObject).setVisibility(8);
      }
      localObject = this.UJC;
      if (localObject != null) {
        ((VoIPFuncIconLayout)localObject).setVisibility(8);
      }
      localObject = this.UJA;
      if (localObject != null) {
        ((VoIPFuncIconLayout)localObject).setVisibility(8);
      }
    }
  }
  
  public final void GF(boolean paramBoolean)
  {
    AppMethodBeat.i(292595);
    Object localObject = this.UJz;
    if (localObject != null) {
      ((VoipSmallIconButton)localObject).setVisibility(8);
    }
    localObject = this.UJI;
    if (localObject != null) {
      ((VoIPControlIconLayout)localObject).setIconEnabled(false);
    }
    localObject = this.UJF;
    if (localObject != null) {
      ((h)localObject).GF(paramBoolean);
    }
    AppMethodBeat.o(292595);
  }
  
  public final void GG(boolean paramBoolean)
  {
    AppMethodBeat.i(292618);
    Object localObject = this.UJE;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.UJz;
    if (localObject != null) {
      ((VoipSmallIconButton)localObject).setVisibility(8);
    }
    localObject = this.UJI;
    if (localObject != null) {
      ((VoIPControlIconLayout)localObject).setVisibility(8);
    }
    localObject = this.UJH;
    if (localObject != null) {
      ((VoIPControlIconLayout)localObject).setVisibility(8);
    }
    localObject = this.UJA;
    if (localObject != null) {
      ((VoIPFuncIconLayout)localObject).setVisibility(8);
    }
    localObject = this.UJF;
    if (localObject != null) {
      ((h)localObject).GG(paramBoolean);
    }
    AppMethodBeat.o(292618);
  }
  
  public final boolean aqR(int paramInt)
  {
    return this.Uxg == paramInt;
  }
  
  public final void aqS(int paramInt)
  {
    AppMethodBeat.i(292686);
    Object localObject = this.UJB;
    if (localObject != null) {
      ((VoIPFuncIconLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.UJC;
    if (localObject != null) {
      ((VoIPFuncIconLayout)localObject).setVisibility(paramInt);
    }
    localObject = this.UJF;
    if (localObject != null) {
      ((h)localObject).aqT(paramInt);
    }
    AppMethodBeat.o(292686);
  }
  
  public final void iaA()
  {
    boolean bool = true;
    AppMethodBeat.i(292586);
    Object localObject = this.UJE;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.UJz;
    if (localObject != null) {
      ((VoipSmallIconButton)localObject).setVisibility(8);
    }
    localObject = this.UJB;
    if (localObject != null) {
      ((VoIPFuncIconLayout)localObject).setVisibility(0);
    }
    localObject = this.UJC;
    if (localObject != null) {
      ((VoIPFuncIconLayout)localObject).setVisibility(0);
    }
    ghJ();
    localObject = this.UJF;
    if (localObject != null) {
      ((h)localObject).iaA();
    }
    localObject = this.UJA;
    if (localObject != null) {
      ((VoIPFuncIconLayout)localObject).setVisibility(8);
    }
    localObject = this.UJH;
    if (localObject != null) {
      ((VoIPControlIconLayout)localObject).setVisibility(0);
    }
    localObject = this.UJI;
    if (localObject != null) {
      ((VoIPControlIconLayout)localObject).setVisibility(0);
    }
    localObject = this.UJI;
    if (localObject != null) {
      ((VoIPControlIconLayout)localObject).setIconEnabled(true);
    }
    localObject = this.UJI;
    if (localObject != null) {
      ((VoIPControlIconLayout)localObject).setOnClickListener(this.UJM);
    }
    localObject = this.UJI;
    if (localObject != null) {
      if (this.mIsMute) {
        break label208;
      }
    }
    for (;;)
    {
      ((VoIPControlIconLayout)localObject).setChecked(bool);
      if (this.mIsMute) {
        this.UJM.onClick((View)this.UJI);
      }
      AppMethodBeat.o(292586);
      return;
      label208:
      bool = false;
    }
  }
  
  public final void iaB()
  {
    AppMethodBeat.i(292603);
    Object localObject = this.UJz;
    if (localObject != null) {
      ((VoipSmallIconButton)localObject).setEnabled(false);
    }
    localObject = this.UJG;
    if (localObject != null) {
      ((FrameLayout)localObject).setEnabled(false);
    }
    AppMethodBeat.o(292603);
  }
  
  public final void iaC()
  {
    AppMethodBeat.i(292633);
    FrameLayout localFrameLayout = this.UJG;
    if (localFrameLayout != null) {
      localFrameLayout.setEnabled(false);
    }
    AppMethodBeat.o(292633);
  }
  
  public final void iaD()
  {
    AppMethodBeat.i(292641);
    FrameLayout localFrameLayout = this.UJG;
    if (localFrameLayout != null) {
      localFrameLayout.setEnabled(false);
    }
    AppMethodBeat.o(292641);
  }
  
  public final void iaE()
  {
    AppMethodBeat.i(292647);
    FrameLayout localFrameLayout = this.UJG;
    if (localFrameLayout != null) {
      localFrameLayout.setEnabled(false);
    }
    AppMethodBeat.o(292647);
  }
  
  public final void iaF()
  {
    AppMethodBeat.i(292656);
    View localView = this.UJD;
    if (localView != null) {
      localView.setVisibility(8);
    }
    AppMethodBeat.o(292656);
  }
  
  public final void iaG()
  {
    AppMethodBeat.i(292661);
    View localView = this.UJD;
    if (localView != null) {
      localView.setVisibility(0);
    }
    AppMethodBeat.o(292661);
  }
  
  final void iaH()
  {
    AppMethodBeat.i(292672);
    if (this.UJH == null)
    {
      Log.e("MicroMsg.VoIPBottomControlUI", "speaker is null");
      AppMethodBeat.o(292672);
      return;
    }
    VoIPControlIconLayout localVoIPControlIconLayout;
    if ((4 == this.Uxg) || (3 == this.Uxg))
    {
      localVoIPControlIconLayout = this.UJH;
      if (localVoIPControlIconLayout != null) {
        localVoIPControlIconLayout.setChecked(false);
      }
      localVoIPControlIconLayout = this.UJH;
      if (localVoIPControlIconLayout != null) {
        localVoIPControlIconLayout.setIconEnabled(false);
      }
      Log.i("MicroMsg.VoIPBottomControlUI", "updateSpeakerStatus, disable mCbVoiceSpeakerSwitcher");
      AppMethodBeat.o(292672);
      return;
    }
    if (this.Uxg == 1) {}
    for (boolean bool = true;; bool = false)
    {
      localVoIPControlIconLayout = this.UJH;
      if (localVoIPControlIconLayout != null) {
        localVoIPControlIconLayout.setIconEnabled(true);
      }
      localVoIPControlIconLayout = this.UJH;
      if (localVoIPControlIconLayout != null) {
        localVoIPControlIconLayout.setChecked(bool);
      }
      Log.i("MicroMsg.VoIPBottomControlUI", "updateSpeakerStatus, set mCbVoiceSpeakerSwitcher isChecked:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(292672);
      return;
    }
  }
  
  public final int iaI()
  {
    int i = 1;
    AppMethodBeat.i(292678);
    VoIPFuncIconLayout localVoIPFuncIconLayout = this.UJB;
    if ((localVoIPFuncIconLayout != null) && (localVoIPFuncIconLayout.isShown() == true)) {}
    while (i != 0)
    {
      AppMethodBeat.o(292678);
      return 4;
      i = 0;
    }
    AppMethodBeat.o(292678);
    return 0;
  }
  
  public final void iaz()
  {
    boolean bool = true;
    AppMethodBeat.i(292577);
    Object localObject = this.UJz;
    if (localObject != null) {
      ((VoipSmallIconButton)localObject).setVisibility(8);
    }
    localObject = this.UJI;
    if (localObject != null) {
      ((VoIPControlIconLayout)localObject).setVisibility(0);
    }
    localObject = this.UJI;
    if (localObject != null) {
      ((VoIPControlIconLayout)localObject).setIconEnabled(true);
    }
    localObject = this.UJI;
    if (localObject != null) {
      if (this.mIsMute) {
        break label176;
      }
    }
    for (;;)
    {
      ((VoIPControlIconLayout)localObject).setChecked(bool);
      localObject = this.UJH;
      if (localObject != null) {
        ((VoIPControlIconLayout)localObject).setVisibility(0);
      }
      localObject = this.UJF;
      if (localObject != null)
      {
        VoIPFuncIconLayout localVoIPFuncIconLayout = ((h)localObject).UJS;
        if (localVoIPFuncIconLayout != null) {
          localVoIPFuncIconLayout.setVisibility(8);
        }
        localVoIPFuncIconLayout = ((h)localObject).UJQ;
        if (localVoIPFuncIconLayout != null) {
          localVoIPFuncIconLayout.setVisibility(8);
        }
        localVoIPFuncIconLayout = ((h)localObject).UJR;
        if (localVoIPFuncIconLayout != null) {
          localVoIPFuncIconLayout.setVisibility(8);
        }
        localObject = ((h)localObject).UJP;
        if (localObject != null) {
          ((VoIPFuncIconLayout)localObject).setVisibility(0);
        }
      }
      localObject = this.UJE;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      AppMethodBeat.o(292577);
      return;
      label176:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.g
 * JD-Core Version:    0.7.0.1
 */