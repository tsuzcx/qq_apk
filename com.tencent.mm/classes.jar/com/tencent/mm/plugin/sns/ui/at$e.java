package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

final class at$e
  extends at.a
{
  MaskImageView rUT;
  View rVb;
  TextView rVc;
  MaskLinearLayout rVi;
  TextView ruR;
  
  at$e(at paramat)
  {
    super(paramat);
  }
  
  public final void init()
  {
    AppMethodBeat.i(39210);
    super.init();
    this.rUT.setVisibility(8);
    this.ruR.setVisibility(8);
    this.rVc.setVisibility(8);
    this.rVb.setVisibility(8);
    if (a.dr(at.a(this.rUG)) > 1.0F) {
      this.ruR.setMaxLines(2);
    }
    AppMethodBeat.o(39210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.at.e
 * JD-Core Version:    0.7.0.1
 */