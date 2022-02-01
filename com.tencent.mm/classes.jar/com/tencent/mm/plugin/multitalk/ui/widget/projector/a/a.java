package com.tencent.mm.plugin.multitalk.ui.widget.projector.a;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a.c;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/receiver/ReceiverAvatarCellIconManager;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "mAvatarUi", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "mCurrentOrientation", "", "checkCallerState", "checkCurrentInAvatarLayout", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "getCurrentStatus", "hideAvatar", "", "rootView", "Landroid/view/ViewGroup;", "onTimeTick", "release", "setOrientation", "orientation", "showAvatar", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Landroid/os/Bundle;", "unInitLayout", "plugin-multitalk_release"})
public final class a
  implements com.tencent.mm.plugin.multitalk.ui.widget.projector.a
{
  private Context context;
  private int mCurrentOrientation;
  private boolean zXk;
  public j zYA;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(240067);
    this.context = paramContext;
    this.mCurrentOrientation = -1;
    this.zYA = new j(this.context, (com.tencent.mm.plugin.multitalk.ui.widget.projector.a)this);
    AppMethodBeat.o(240067);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(240066);
    p.h(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(240066);
      return;
      paramc = ac.eom();
      p.g(paramc, "SubCoreMultiTalk.getMultiTalkManager()");
      if (paramc.enA().emb())
      {
        paramc = this.zYA;
        if (paramc != null)
        {
          paramc = paramc.nmW;
          if ((paramc != null) && (paramc.getVisibility() == 0)) {}
          for (int i = 1; i == 1; i = 0)
          {
            if (paramBundle == null) {
              break label159;
            }
            paramc = paramBundle.getStringArrayList("avatar_available_speaker");
            paramBundle = this.zYA;
            if (paramBundle != null)
            {
              if (paramc == null) {
                p.hyc();
              }
              bool = paramBundle.aD(paramc);
            }
            this.zXk = bool;
            AppMethodBeat.o(240066);
            return;
          }
        }
        AppMethodBeat.o(240066);
        return;
        label159:
        AppMethodBeat.o(240066);
        return;
        this.zXk = false;
      }
    }
  }
  
  public final int epf()
  {
    return this.mCurrentOrientation;
  }
  
  public final boolean epg()
  {
    return false;
  }
  
  public final boolean eph()
  {
    return this.zXk;
  }
  
  public final int epi()
  {
    return 0;
  }
  
  public final boolean getCurrentStatus()
  {
    return false;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(240065);
    this.mCurrentOrientation = paramInt;
    j localj = this.zYA;
    if (localj != null)
    {
      localj.RA(paramInt);
      AppMethodBeat.o(240065);
      return;
    }
    AppMethodBeat.o(240065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a
 * JD-Core Version:    0.7.0.1
 */