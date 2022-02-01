package com.tencent.mm.plugin.multitalk.ui.widget.projector.a;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a.c;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/receiver/ReceiverAvatarCellIconManager;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "mAvatarUi", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "mCurrentOrientation", "", "checkCallerState", "checkCurrentInAvatarLayout", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "getCurrentFileMd5", "", "getCurrentStatus", "hideAvatar", "", "rootView", "Landroid/view/ViewGroup;", "onTimeTick", "release", "setOrientation", "orientation", "showAvatar", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "Landroid/os/Bundle;", "unInitLayout", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.multitalk.ui.widget.projector.a
{
  private boolean LyP;
  public i LzU;
  private Context context;
  private int mCurrentOrientation;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(285943);
    this.context = paramContext;
    this.mCurrentOrientation = -1;
    this.LzU = new i(this.context, (com.tencent.mm.plugin.multitalk.ui.widget.projector.a)this);
    AppMethodBeat.o(285943);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    int j = 1;
    boolean bool = false;
    AppMethodBeat.i(285955);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(285955);
      return;
      if (ac.ggS().ggg().geG())
      {
        paramc = this.LzU;
        int i;
        if (paramc != null)
        {
          paramc = paramc.tth;
          if ((paramc != null) && (paramc.getVisibility() == 0))
          {
            i = 1;
            if (i != 1) {
              break label142;
            }
            i = j;
            label101:
            if ((i == 0) || (paramBundle == null)) {
              continue;
            }
            paramc = paramBundle.getStringArrayList("avatar_available_speaker");
            paramBundle = this.LzU;
            if (paramBundle != null) {
              break label147;
            }
          }
        }
        for (;;)
        {
          this.LyP = bool;
          AppMethodBeat.o(285955);
          return;
          i = 0;
          break;
          label142:
          i = 0;
          break label101;
          label147:
          s.checkNotNull(paramc);
          bool = paramBundle.be(paramc);
        }
        this.LyP = false;
      }
    }
  }
  
  public final boolean getCurrentStatus()
  {
    return false;
  }
  
  public final int ghU()
  {
    return this.mCurrentOrientation;
  }
  
  public final boolean ghV()
  {
    return false;
  }
  
  public final boolean ghW()
  {
    return this.LyP;
  }
  
  public final int ghX()
  {
    return 0;
  }
  
  public final void setOrientation(int paramInt)
  {
    AppMethodBeat.i(285947);
    this.mCurrentOrientation = paramInt;
    i locali = this.LzU;
    if (locali != null) {
      locali.aca(paramInt);
    }
    AppMethodBeat.o(285947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.a.a
 * JD-Core Version:    0.7.0.1
 */