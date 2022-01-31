package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.cb.a;

final class as$e
  extends as.a
{
  TextView oFq;
  MaskImageView pcj;
  View pcr;
  TextView pcs;
  MaskLinearLayout pcy;
  
  as$e(as paramas)
  {
    super(paramas);
  }
  
  public final void init()
  {
    super.init();
    this.pcj.setVisibility(8);
    this.oFq.setVisibility(8);
    this.pcs.setVisibility(8);
    this.pcr.setVisibility(8);
    if (a.cJ(as.a(this.pbW)) > 1.0F) {
      this.oFq.setMaxLines(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.as.e
 * JD-Core Version:    0.7.0.1
 */