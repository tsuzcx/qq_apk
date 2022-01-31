package com.tencent.mm.plugin.voiceprint.ui;

import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.1;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;

final class BaseVoicePrintUI$5
  implements ak.a
{
  BaseVoicePrintUI$5(BaseVoicePrintUI paramBaseVoicePrintUI) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(26135);
    if (paramMessage.what == 1)
    {
      ab.d("MicroMsg.BaseVoicePrintUI", "start record");
      ay.a(ah.getContext(), 2131304257, new BaseVoicePrintUI.5.1(this));
      BaseVoicePrintUI.a(this.trX, "voice_pt_voice_print_record.rec");
      paramMessage = BaseVoicePrintUI.a(this.trX);
      Object localObject = BaseVoicePrintUI.d(this.trX);
      BaseVoicePrintUI localBaseVoicePrintUI = this.trX;
      paramMessage.fileName = ((String)localObject);
      ab.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[] { paramMessage.fileName });
      aw.aaA().a(paramMessage);
      int i = aw.aaA().KE();
      paramMessage.sXv = false;
      paramMessage.gaP = new b(localBaseVoicePrintUI);
      if (i != 0)
      {
        paramMessage.gy(100);
        BaseVoicePrintUI.e(this.trX).ag(100L, 100L);
        paramMessage = this.trX;
        paramMessage.trO.cLA();
        localObject = paramMessage.trO;
        ab.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(((VoiceTipInfoView)localObject).iJG.getVisibility()), Boolean.valueOf(((VoiceTipInfoView)localObject).tsO) });
        if ((((VoiceTipInfoView)localObject).iJG.getVisibility() != 0) || (((VoiceTipInfoView)localObject).tsO)) {
          break label363;
        }
        ((VoiceTipInfoView)localObject).iJG.clearAnimation();
        ((VoiceTipInfoView)localObject).tsO = true;
        a.a(((VoiceTipInfoView)localObject).iJG, ((VoiceTipInfoView)localObject).getContext(), new VoiceTipInfoView.3((VoiceTipInfoView)localObject));
      }
      for (;;)
      {
        paramMessage.trO.setTipText(paramMessage.tru);
        paramMessage.trV.stopTimer();
        paramMessage.trV.ag(500L, 500L);
        paramMessage.trM.setVisibility(0);
        paramMessage = paramMessage.trN;
        paramMessage.reset();
        paramMessage.mIsPlaying = true;
        localObject = paramMessage.tsx;
        long l = VoicePrintVolumeMeter.oeV;
        ((ap)localObject).ag(l, l);
        paramMessage.cLv();
        AppMethodBeat.o(26135);
        return true;
        new p.1(paramMessage).sendEmptyMessageDelayed(0, 50L);
        break;
        label363:
        ab.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
        ((VoiceTipInfoView)localObject).iJG.clearAnimation();
        ((VoiceTipInfoView)localObject).iJG.setVisibility(4);
        ((VoiceTipInfoView)localObject).iJG.invalidate();
      }
    }
    AppMethodBeat.o(26135);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.5
 * JD-Core Version:    0.7.0.1
 */