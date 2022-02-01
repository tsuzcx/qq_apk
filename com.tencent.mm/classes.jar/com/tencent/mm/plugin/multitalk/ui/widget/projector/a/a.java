package com.tencent.mm.plugin.multitalk.ui.widget.projector.a;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a.c;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/receiver/ReceiverAvatarCellIconManager;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "mAvatarUi", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "mCurrentOrientation", "", "checkCallerState", "checkCurrentInAvatarLayout", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "getCurrentFileMd5", "", "getCurrentStatus", "hideAvatar", "", "rootView", "Landroid/view/ViewGroup;", "onTimeTick", "release", "setOrientation", "orientation", "showAvatar", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Landroid/os/Bundle;", "unInitLayout", "plugin-multitalk_release"})
public final class a
  implements com.tencent.mm.plugin.multitalk.ui.widget.projector.a
{
  private boolean FCT;
  public j FEl;
  private Context context;
  private int mCurrentOrientation;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(207144);
    this.context = paramContext;
    this.mCurrentOrientation = -1;
    this.FEl = new j(this.context, (com.tencent.mm.plugin.multitalk.ui.widget.projector.a)this);
    AppMethodBeat.o(207144);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(207139);
    p.k(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207139);
      return;
      paramc = ad.eYc();
      p.j(paramc, "SubCoreMultiTalk.getMultiTalkManager()");
      if (paramc.eXq().eVP())
      {
        paramc = this.FEl;
        if (paramc != null)
        {
          paramc = paramc.qoE;
          if ((paramc != null) && (paramc.getVisibility() == 0)) {}
          for (int i = 1; i == 1; i = 0)
          {
            if (paramBundle == null) {
              break label159;
            }
            paramc = paramBundle.getStringArrayList("avatar_available_speaker");
            paramBundle = this.FEl;
            if (paramBundle != null)
            {
              if (paramc == null) {
                p.iCn();
              }
              bool = paramBundle.aK(paramc);
            }
            this.FCT = bool;
            AppMethodBeat.o(207139);
            return;
          }
        }
        AppMethodBeat.o(207139);
        return;
        label159:
        AppMethodBeat.o(207139);
        return;
        this.FCT = false;
      }
    }
  }
  
  public final int eYV()
  {
    return this.mCurrentOrientation;
  }
  
  public final boolean eYW()
  {
    return false;
  }
  
  public final boolean eYX()
  {
    return this.FCT;
  }
  
  public final int eYY()
  {
    return 0;
  }
  
  public final boolean getCurrentStatus()
  {
    return false;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(207138);
    this.mCurrentOrientation = paramInt;
    j localj = this.FEl;
    if (localj != null)
    {
      localj.XQ(paramInt);
      AppMethodBeat.o(207138);
      return;
    }
    AppMethodBeat.o(207138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a
 * JD-Core Version:    0.7.0.1
 */