package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/radar/ui/RadarTipsView$tipsHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "plugin-radar_release"})
public final class RadarTipsView$f
  extends ak
{
  RadarTipsView$f(Looper paramLooper)
  {
    super(localLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(103060);
    j.q(paramMessage, "msg");
    int i = paramMessage.what;
    if (i == RadarTipsView.d(this.pSF))
    {
      this.pSF.cfb();
      AppMethodBeat.o(103060);
      return;
    }
    if (i == RadarTipsView.e(this.pSF))
    {
      if ((RadarTipsView.f(this.pSF)) && (this.pSF.pSu))
      {
        RadarTipsView.a(this.pSF);
        AppMethodBeat.o(103060);
      }
    }
    else
    {
      if (i == RadarTipsView.g(this.pSF))
      {
        paramMessage = this.pSF;
        paramMessage.pSr = true;
        paramMessage.pSy = RadarTipsView.pSC;
        ab.d(RadarTipsView.TAG, "showNoviceEducation");
        paramMessage.pSt = true;
        paramMessage.getTextTipsContainer().setVisibility(8);
        paramMessage.getTextTipsContainer().clearAnimation();
        paramMessage.setVisibility(0);
        paramMessage.getNoviceEducationTips().setVisibility(0);
        paramMessage.getNoviceEducationTips().startAnimation(paramMessage.getTipsFadeIn());
        paramMessage.getNoviceEducationTips().requestFocus();
        AppMethodBeat.o(103060);
        return;
      }
      if (i == RadarTipsView.h(this.pSF)) {
        this.pSF.cfa();
      }
    }
    AppMethodBeat.o(103060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarTipsView.f
 * JD-Core Version:    0.7.0.1
 */