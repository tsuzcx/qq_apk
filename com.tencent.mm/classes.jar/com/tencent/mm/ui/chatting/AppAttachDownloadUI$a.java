package com.tencent.mm.ui.chatting;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.cb;

final class AppAttachDownloadUI$a
{
  private TextView euY;
  Button uxz;
  
  public AppAttachDownloadUI$a(AppAttachDownloadUI paramAppAttachDownloadUI, Button paramButton, TextView paramTextView)
  {
    AppMethodBeat.i(30276);
    this.uxz = paramButton;
    this.euY = paramTextView;
    if (paramTextView != null)
    {
      int i = g.Nq().getInt("MsgFileExpiredInterval", 432000);
      long l = AppAttachDownloadUI.A(paramAppAttachDownloadUI).field_createTime / 1000L;
      Math.floor((i - cb.gz(l)) * 1.0D / 86400.0D);
      paramTextView.setText("");
    }
    AppMethodBeat.o(30276);
  }
  
  public final void dFA()
  {
    AppMethodBeat.i(30278);
    if (this.uxz != null) {
      this.uxz.setVisibility(4);
    }
    if (this.euY != null)
    {
      this.euY.setVisibility(0);
      this.euY.setText(2131299882);
      this.euY.setTextColor(this.zvM.getResources().getColor(2131689606));
      AppAttachDownloadUI.B(this.zvM).setVisibility(8);
      AppAttachDownloadUI.m(this.zvM).setVisibility(8);
    }
    AppMethodBeat.o(30278);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(30277);
    if (this.uxz != null) {
      this.uxz.setVisibility(paramInt);
    }
    if (this.euY != null) {
      this.euY.setVisibility(paramInt);
    }
    AppMethodBeat.o(30277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.a
 * JD-Core Version:    0.7.0.1
 */