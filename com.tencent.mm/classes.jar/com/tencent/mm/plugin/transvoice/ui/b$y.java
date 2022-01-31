package com.tencent.mm.plugin.transvoice.ui;

import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/transvoice/ui/TransVoiceDialog$startTrans$2", "Lcom/tencent/mm/modelvoiceaddr/SceneVoiceInputAddr$UICallback;", "onError", "", "errType", "", "errCode", "localCode", "voiceid", "", "onRecognizeFinish", "onRecordFin", "onRes", "lst", "", "", "voiceIdSet", "", "([Ljava/lang/String;Ljava/util/List;)V", "plugin-transvoice_release"})
public final class b$y
  implements g.b
{
  public final void amK()
  {
    AppMethodBeat.i(155259);
    ab.d("MicroMsg.TransVoiceDialog", "onRecordFin.");
    AppMethodBeat.o(155259);
  }
  
  public final void amO()
  {
    AppMethodBeat.i(155260);
    ab.d("MicroMsg.TransVoiceDialog", "onRecognizeFinish.");
    b.j(this.tqJ, false);
    b.p(this.tqJ).tpz = 1;
    b.p(this.tqJ).tpv = System.currentTimeMillis();
    Object localObject = b.v(this.tqJ);
    if (localObject != null) {
      ((ak)localObject).removeMessages(5000);
    }
    localObject = b.w(this.tqJ);
    if (localObject != null) {
      ((ap)localObject).stopTimer();
    }
    b.I(this.tqJ);
    localObject = b.u(this.tqJ);
    if (localObject != null)
    {
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(155260);
      return;
    }
    AppMethodBeat.o(155260);
  }
  
  public final void b(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(155257);
    ab.d("MicroMsg.TransVoiceDialog", "onRes.");
    b.a(this.tqJ, paramList);
    paramList = b.v(this.tqJ);
    if (paramList != null) {
      paramList.removeMessages(5000);
    }
    paramList = b.v(this.tqJ);
    if (paramList != null) {
      paramList.sendEmptyMessageDelayed(5000, 5000L);
    }
    if (paramArrayOfString != null)
    {
      paramList = paramArrayOfString[0];
      if (paramList != null)
      {
        if (((CharSequence)paramList).length() > 0) {}
        for (int i = 1; i == 1; i = 0)
        {
          this.tqJ.aex(paramArrayOfString[0]);
          ab.d("MicroMsg.TransVoiceDialog", "onRes, curTxt: %s.", new Object[] { this.tqJ.tqy });
          b.p(this.tqJ).tpw = this.tqJ.tqy.length();
          if (b.s(this.tqJ)) {
            break;
          }
          b.j(this.tqJ, true);
          paramArrayOfString = b.e(this.tqJ);
          if (paramArrayOfString != null) {
            paramArrayOfString.setFocusable(true);
          }
          paramArrayOfString = b.e(this.tqJ);
          if (paramArrayOfString != null) {
            paramArrayOfString.setFocusableInTouchMode(true);
          }
          paramArrayOfString = b.e(this.tqJ);
          if (paramArrayOfString == null) {
            break;
          }
          paramArrayOfString.requestFocus();
          AppMethodBeat.o(155257);
          return;
        }
      }
    }
    AppMethodBeat.o(155257);
    return;
    AppMethodBeat.o(155257);
  }
  
  public final void c(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(155258);
    ab.d("MicroMsg.TransVoiceDialog", "onError, errType: %d, errCode: %d, localCode: %d, voiceid: %d.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(paramLong) });
    b.p(this.tqJ).tpz = 0;
    b.p(this.tqJ).tpv = System.currentTimeMillis();
    AppMethodBeat.o(155258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.transvoice.ui.b.y
 * JD-Core Version:    0.7.0.1
 */