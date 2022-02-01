package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "countDownDetail", "Landroid/widget/TextView;", "countDownTv", "curCountDown", "readyUiLayout", "Landroid/view/View;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getReadyLayout", "rootView", "Landroid/widget/FrameLayout;", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startScreenProject", "stopCountDown", "stopScreenProject", "plugin-multitalk_release"})
public final class r
{
  View FDO;
  TextView FDP;
  e FvZ;
  private a Fwg;
  private Context context;
  final int kGL;
  private final int kGM;
  TextView kGO;
  int kGP;
  MTimerHandler timerHandler;
  
  public r(Context paramContext, a parama, e parame)
  {
    AppMethodBeat.i(199153);
    this.context = paramContext;
    this.Fwg = parama;
    this.FvZ = parame;
    this.kGL = 4;
    this.kGM = 1;
    this.kGP = this.kGL;
    this.timerHandler = new MTimerHandler((MTimerHandler.CallBack)new a(this), true);
    AppMethodBeat.o(199153);
  }
  
  final void aPE()
  {
    AppMethodBeat.i(199149);
    Object localObject = this.kGO;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)String.valueOf(this.kGP));
    }
    TextView localTextView = this.FDP;
    if (localTextView != null)
    {
      localObject = this.context;
      if (localObject == null) {
        break label155;
      }
    }
    label155:
    for (localObject = ((Context)localObject).getResources();; localObject = null)
    {
      localTextView.setText((CharSequence)((Resources)localObject).getString(a.h.ready_detail_screen_project));
      localObject = this.kGO;
      if (localObject != null) {
        ((TextView)localObject).setScaleX(1.5F);
      }
      localObject = this.kGO;
      if (localObject != null) {
        ((TextView)localObject).setScaleY(1.5F);
      }
      localObject = this.kGO;
      if (localObject == null) {
        break;
      }
      localObject = ((TextView)localObject).animate();
      if (localObject == null) {
        break;
      }
      localObject = ((ViewPropertyAnimator)localObject).scaleX(1.0F);
      if (localObject == null) {
        break;
      }
      localObject = ((ViewPropertyAnimator)localObject).scaleY(1.0F);
      if (localObject == null) {
        break;
      }
      localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
      if (localObject == null) {
        break;
      }
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(199149);
      return;
    }
    AppMethodBeat.o(199149);
  }
  
  final void eZy()
  {
    AppMethodBeat.i(199146);
    a.b.a(this.Fwg, a.c.FBk);
    AppMethodBeat.o(199146);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    a(r paramr) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(202629);
      if (r.a(this.FDQ) > r.b(this.FDQ))
      {
        r localr = this.FDQ;
        r.a(localr, r.a(localr) - 1);
        r.c(this.FDQ);
        AppMethodBeat.o(202629);
        return true;
      }
      r.d(this.FDQ);
      AppMethodBeat.o(202629);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.r
 * JD-Core Version:    0.7.0.1
 */