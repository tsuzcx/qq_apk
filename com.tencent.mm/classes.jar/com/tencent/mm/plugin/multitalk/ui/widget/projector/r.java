package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "COUNT_DOWN_END", "", "COUNT_DOWN_START", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "countDownDetail", "Landroid/widget/TextView;", "countDownTv", "curCountDown", "readyUiLayout", "Landroid/view/View;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "timerHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getReadyLayout", "rootView", "Landroid/widget/FrameLayout;", "reset", "", "setTextWithAnim", "setVisible", "visible", "startCountDown", "startScreenProject", "stopCountDown", "plugin-multitalk_release"})
public final class r
{
  private Context context;
  final int hSo;
  final int hSp;
  TextView hSr;
  int hSs;
  MTimerHandler timerHandler;
  private a zQD;
  e zQw;
  View zYc;
  TextView zYd;
  
  public r(Context paramContext, a parama, e parame)
  {
    AppMethodBeat.i(240063);
    this.context = paramContext;
    this.zQD = parama;
    this.zQw = parame;
    this.hSo = 4;
    this.hSp = 1;
    this.hSs = this.hSo;
    this.timerHandler = new MTimerHandler((MTimerHandler.CallBack)new a(this), true);
    AppMethodBeat.o(240063);
  }
  
  final void aHG()
  {
    AppMethodBeat.i(240062);
    Object localObject = this.hSr;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)String.valueOf(this.hSs));
    }
    TextView localTextView = this.zYd;
    if (localTextView != null)
    {
      localObject = this.context;
      if (localObject == null) {
        break label154;
      }
    }
    label154:
    for (localObject = ((Context)localObject).getResources();; localObject = null)
    {
      localTextView.setText((CharSequence)((Resources)localObject).getString(2131764225));
      localObject = this.hSr;
      if (localObject != null) {
        ((TextView)localObject).setScaleX(1.5F);
      }
      localObject = this.hSr;
      if (localObject != null) {
        ((TextView)localObject).setScaleY(1.5F);
      }
      localObject = this.hSr;
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
      AppMethodBeat.o(240062);
      return;
    }
    AppMethodBeat.o(240062);
  }
  
  final void epK()
  {
    AppMethodBeat.i(240061);
    a.b.a(this.zQD, a.c.zVA);
    AppMethodBeat.o(240061);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onTimerExpired"})
  static final class a
    implements MTimerHandler.CallBack
  {
    a(r paramr) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(240060);
      if (this.zYe.hSs > this.zYe.hSp)
      {
        r localr = this.zYe;
        localr.hSs -= 1;
        this.zYe.aHG();
        AppMethodBeat.o(240060);
        return true;
      }
      this.zYe.epK();
      AppMethodBeat.o(240060);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.r
 * JD-Core Version:    0.7.0.1
 */