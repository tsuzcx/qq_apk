package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.cm;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Log;

final class AppAttachDownloadUI$a
{
  private boolean HEv;
  private TextView bFR;
  Button xQQ;
  
  public AppAttachDownloadUI$a(AppAttachDownloadUI paramAppAttachDownloadUI, Button paramButton, TextView paramTextView)
  {
    AppMethodBeat.i(34126);
    this.xQQ = paramButton;
    this.bFR = paramTextView;
    if (paramTextView != null)
    {
      int i = h.axc().getInt("MsgFileExpiredInterval", 432000);
      long l = AppAttachDownloadUI.R(paramAppAttachDownloadUI).field_createTime / 1000L;
      Math.floor((i - cm.secondsToNow(l)) * 1.0D / 86400.0D);
      paramTextView.setText("");
    }
    AppMethodBeat.o(34126);
  }
  
  public final void hLO()
  {
    AppMethodBeat.i(34128);
    Log.i("MicroMsg.AppAttachDownloadUI", "showErrorTip overtime %s", new Object[] { Long.valueOf(AppAttachDownloadUI.R(this.WwM).field_msgId) });
    if (this.xQQ != null) {
      this.xQQ.setVisibility(4);
    }
    if (this.bFR != null)
    {
      this.bFR.setVisibility(0);
      this.bFR.setText(R.l.eEK);
      this.bFR.setTextColor(this.WwM.getResources().getColor(R.e.Red_120));
      AppAttachDownloadUI.S(this.WwM).setVisibility(8);
      AppAttachDownloadUI.D(this.WwM).setVisibility(8);
      if (!this.HEv)
      {
        this.HEv = true;
        AppAttachDownloadUI.T(this.WwM);
      }
    }
    AppMethodBeat.o(34128);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(34127);
    if (this.xQQ != null) {
      this.xQQ.setVisibility(paramInt);
    }
    if (this.bFR != null) {
      this.bFR.setVisibility(paramInt);
    }
    AppMethodBeat.o(34127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.a
 * JD-Core Version:    0.7.0.1
 */