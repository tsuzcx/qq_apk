package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.e.a.b;
import com.tencent.mm.plugin.voip.e.a.c;
import com.tencent.mm.plugin.voip.widget.VoIPFuncIconLayout;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/ui/VoIPMainBtnControl;", "Landroid/view/View$OnClickListener;", "statusManager", "Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;", "(Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;)V", "mAcceptBtn", "Lcom/tencent/mm/plugin/voip/widget/VoIPFuncIconLayout;", "mAcceptUseVoiceBtn", "mCancelBtn", "mHangUpBtn", "mRejectBtn", "mainControlView", "Landroid/view/View;", "getStatusManager", "()Lcom/tencent/mm/plugin/voip/status/IVoIPWidgetEvent;", "setStatusManager", "applyEvent", "", "getLayout", "context", "Landroid/content/Context;", "rootView", "Landroid/widget/FrameLayout;", "isVideo", "", "onClick", "v", "responseScreenClick", "visible", "", "showCalledConnecting", "showCalledInviting", "showCallingConnecting", "showCallingInviting", "showCallingWaitingAccept", "showVoIPTalking", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements View.OnClickListener
{
  public static final h.a UJO;
  VoIPFuncIconLayout UJP;
  VoIPFuncIconLayout UJQ;
  VoIPFuncIconLayout UJR;
  VoIPFuncIconLayout UJS;
  VoIPFuncIconLayout UJT;
  View UJU;
  private com.tencent.mm.plugin.voip.e.a UJy;
  
  static
  {
    AppMethodBeat.i(292453);
    UJO = new h.a((byte)0);
    AppMethodBeat.o(292453);
  }
  
  public h(com.tencent.mm.plugin.voip.e.a parama)
  {
    AppMethodBeat.i(292445);
    this.UJy = parama;
    AppMethodBeat.o(292445);
  }
  
  private static final void a(h paramh, View paramView)
  {
    AppMethodBeat.i(292448);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPMainBtnControl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    a.b.a(paramh.UJy, a.c.UHQ);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/voip/ui/VoIPMainBtnControl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(292448);
  }
  
  public final void GE(boolean paramBoolean)
  {
    AppMethodBeat.i(292491);
    VoIPFuncIconLayout localVoIPFuncIconLayout = this.UJS;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    localVoIPFuncIconLayout = this.UJQ;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    localVoIPFuncIconLayout = this.UJR;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    localVoIPFuncIconLayout = this.UJP;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(0);
    }
    if (paramBoolean)
    {
      localVoIPFuncIconLayout = this.UJT;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setVisibility(0);
      }
    }
    AppMethodBeat.o(292491);
  }
  
  public final void GF(boolean paramBoolean)
  {
    AppMethodBeat.i(292483);
    if (!paramBoolean)
    {
      VoIPFuncIconLayout localVoIPFuncIconLayout = this.UJS;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setVisibility(8);
      }
      localVoIPFuncIconLayout = this.UJQ;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setVisibility(8);
      }
      localVoIPFuncIconLayout = this.UJR;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setVisibility(0);
      }
      localVoIPFuncIconLayout = this.UJP;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setVisibility(8);
      }
    }
    AppMethodBeat.o(292483);
  }
  
  public final void GG(boolean paramBoolean)
  {
    AppMethodBeat.i(292469);
    VoIPFuncIconLayout localVoIPFuncIconLayout;
    if (!paramBoolean)
    {
      localVoIPFuncIconLayout = this.UJS;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setIconEnabled(false);
      }
      localVoIPFuncIconLayout = this.UJS;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setVisibility(0);
      }
      localVoIPFuncIconLayout = this.UJQ;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setVisibility(0);
      }
      localVoIPFuncIconLayout = this.UJQ;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setOnClickListener(new h..ExternalSyntheticLambda0(this));
      }
      localVoIPFuncIconLayout = this.UJR;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setVisibility(8);
      }
      localVoIPFuncIconLayout = this.UJP;
      if (localVoIPFuncIconLayout != null)
      {
        localVoIPFuncIconLayout.setVisibility(8);
        AppMethodBeat.o(292469);
      }
    }
    else
    {
      localVoIPFuncIconLayout = this.UJR;
      if (localVoIPFuncIconLayout != null) {
        localVoIPFuncIconLayout.setVisibility(8);
      }
    }
    AppMethodBeat.o(292469);
  }
  
  public final void aqT(int paramInt)
  {
    AppMethodBeat.i(292501);
    VoIPFuncIconLayout localVoIPFuncIconLayout = this.UJR;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(paramInt);
    }
    AppMethodBeat.o(292501);
  }
  
  public final void iaA()
  {
    AppMethodBeat.i(292463);
    VoIPFuncIconLayout localVoIPFuncIconLayout = this.UJP;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    localVoIPFuncIconLayout = this.UJR;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(0);
    }
    localVoIPFuncIconLayout = this.UJS;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    localVoIPFuncIconLayout = this.UJQ;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    localVoIPFuncIconLayout = this.UJT;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    AppMethodBeat.o(292463);
  }
  
  public final void iak()
  {
    AppMethodBeat.i(292477);
    VoIPFuncIconLayout localVoIPFuncIconLayout = this.UJS;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(0);
    }
    localVoIPFuncIconLayout = this.UJQ;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(0);
    }
    localVoIPFuncIconLayout = this.UJR;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    localVoIPFuncIconLayout = this.UJP;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    localVoIPFuncIconLayout = this.UJT;
    if (localVoIPFuncIconLayout != null) {
      localVoIPFuncIconLayout.setVisibility(8);
    }
    AppMethodBeat.o(292477);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(292509);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoIPMainBtnControl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView != null)
    {
      i = paramView.getId();
      if (i != b.d.voip_reject) {
        break label109;
      }
      paramView = a.c.UHP;
    }
    for (;;)
    {
      Log.i("MicroMg.VoIPMainBtnControl", "click  " + paramView.name() + " invite button");
      a.b.a(this.UJy, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoIPMainBtnControl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(292509);
      return;
      label109:
      if (i == b.d.voip_hangup) {
        paramView = a.c.UHQ;
      } else if (i == b.d.voip_cancel) {
        paramView = a.c.UHN;
      } else if (i == b.d.voip_accept) {
        paramView = a.c.UHO;
      } else if (i == b.d.voip_accept_use_voice) {
        paramView = a.c.UHS;
      } else {
        paramView = a.c.UHH;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.h
 * JD-Core Version:    0.7.0.1
 */