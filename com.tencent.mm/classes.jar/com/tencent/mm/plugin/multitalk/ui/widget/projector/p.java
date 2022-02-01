package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "countDownDetail", "Landroid/widget/TextView;", "countDownTv", "curCountDown", "readyUiLayout", "Landroid/view/View;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getReadyLayout", "rootView", "Landroid/widget/FrameLayout;", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startScreenProject", "stopCountDown", "stopScreenProject", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  e Lsc;
  private a Lsq;
  TextView LzA;
  View Lzz;
  private Context context;
  final int njG;
  private final int njH;
  TextView njJ;
  int njK;
  MTimerHandler timerHandler;
  
  public p(Context paramContext, a parama, e parame)
  {
    AppMethodBeat.i(285635);
    this.context = paramContext;
    this.Lsq = parama;
    this.Lsc = parame;
    this.njG = 4;
    this.njH = 1;
    this.njK = this.njG;
    this.timerHandler = new MTimerHandler(new p..ExternalSyntheticLambda0(this), true);
    AppMethodBeat.o(285635);
  }
  
  private static final boolean a(p paramp)
  {
    AppMethodBeat.i(285643);
    s.u(paramp, "this$0");
    if (paramp.njK > paramp.njH)
    {
      paramp.njK -= 1;
      paramp.bjs();
      AppMethodBeat.o(285643);
      return true;
    }
    paramp.giy();
    AppMethodBeat.o(285643);
    return false;
  }
  
  final void bjs()
  {
    AppMethodBeat.i(285664);
    Object localObject = this.njJ;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)String.valueOf(this.njK));
    }
    TextView localTextView = this.LzA;
    if (localTextView != null)
    {
      localObject = this.context;
      if (localObject != null) {
        break label152;
      }
    }
    label152:
    for (localObject = null;; localObject = ((Context)localObject).getResources())
    {
      localTextView.setText((CharSequence)((Resources)localObject).getString(a.h.ready_detail_screen_project));
      localObject = this.njJ;
      if (localObject != null) {
        ((TextView)localObject).setScaleX(1.5F);
      }
      localObject = this.njJ;
      if (localObject != null) {
        ((TextView)localObject).setScaleY(1.5F);
      }
      localObject = this.njJ;
      if (localObject != null)
      {
        localObject = ((TextView)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).scaleX(1.0F);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).scaleY(1.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
      }
      AppMethodBeat.o(285664);
      return;
    }
  }
  
  final void giy()
  {
    AppMethodBeat.i(285655);
    a.b.a(this.Lsq, a.c.Lxm);
    AppMethodBeat.o(285655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.p
 * JD-Core Version:    0.7.0.1
 */