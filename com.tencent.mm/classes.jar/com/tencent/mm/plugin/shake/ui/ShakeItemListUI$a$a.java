package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ShakeItemListUI$a$a
{
  TextView gvI;
  ImageView gxs;
  TextView gxt;
  TextView pdA;
  TextView pdB;
  ImageView pdC;
  View qPP;
  ImageView qPQ;
  TextView qPR;
  LinearLayout qPS;
  TextView qPT;
  
  ShakeItemListUI$a$a(ShakeItemListUI.a parama) {}
  
  public final void clear()
  {
    AppMethodBeat.i(24731);
    if (this.gxs != null)
    {
      this.gxs.setImageDrawable(null);
      this.gxs.setVisibility(8);
    }
    if (this.gvI != null)
    {
      this.gvI.setText("");
      this.gvI.setVisibility(8);
    }
    if (this.gxt != null) {
      this.gxt.setVisibility(8);
    }
    if (this.qPQ != null) {
      this.qPQ.setVisibility(8);
    }
    if (this.pdA != null)
    {
      this.pdA.setText("");
      this.pdA.setVisibility(8);
    }
    if (this.pdB != null)
    {
      this.pdB.setVisibility(8);
      this.qPP.setVisibility(8);
    }
    if (this.pdC != null) {
      this.pdC.setVisibility(8);
    }
    if (this.qPR != null)
    {
      this.qPR.setText("");
      this.qPR.setVisibility(8);
    }
    AppMethodBeat.o(24731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a.a
 * JD-Core Version:    0.7.0.1
 */