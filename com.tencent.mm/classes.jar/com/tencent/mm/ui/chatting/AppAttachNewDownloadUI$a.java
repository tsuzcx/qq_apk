package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
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

final class AppAttachNewDownloadUI$a
{
  private boolean HEv;
  private TextView bFR;
  Button xQQ;
  
  public AppAttachNewDownloadUI$a(AppAttachNewDownloadUI paramAppAttachNewDownloadUI, Button paramButton, TextView paramTextView)
  {
    AppMethodBeat.i(291968);
    this.xQQ = paramButton;
    this.bFR = paramTextView;
    if (paramTextView != null)
    {
      int i = h.axc().getInt("MsgFileExpiredInterval", 432000);
      long l = AppAttachNewDownloadUI.F(paramAppAttachNewDownloadUI).field_createTime / 1000L;
      Math.floor((i - cm.secondsToNow(l)) * 1.0D / 86400.0D);
      paramTextView.setText("");
    }
    AppMethodBeat.o(291968);
  }
  
  public final void Gf(boolean paramBoolean)
  {
    AppMethodBeat.i(291970);
    Log.i("MicroMsg.AppAttachNewDownloadUI", "showErrorTip overtime %s", new Object[] { Long.valueOf(AppAttachNewDownloadUI.F(this.Wxg).field_msgId) });
    if (this.xQQ != null) {
      this.xQQ.setVisibility(4);
    }
    if (this.bFR != null)
    {
      this.bFR.setVisibility(0);
      if (!paramBoolean) {
        break label135;
      }
      this.bFR.setText(R.l.eEJ);
      AppAttachNewDownloadUI.b(this.Wxg, 17, -1);
    }
    for (;;)
    {
      this.bFR.setTextColor(this.Wxg.getResources().getColor(R.e.Red_120));
      if (!this.HEv)
      {
        this.HEv = true;
        AppAttachNewDownloadUI.b(this.Wxg, 8, 6);
      }
      AppMethodBeat.o(291970);
      return;
      label135:
      this.bFR.setText(R.l.eEK);
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(291969);
    if (this.xQQ != null) {
      this.xQQ.setVisibility(paramInt);
    }
    if (this.bFR != null) {
      this.bFR.setVisibility(paramInt);
    }
    AppMethodBeat.o(291969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.a
 * JD-Core Version:    0.7.0.1
 */