package com.tencent.mm.ui.tools;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;

final class MoreShareAppUI$a$a
{
  TextView eXO;
  ImageView gSx;
  View iVb;
  ImageView iVc;
  MMSwitchBtn lAy;
  
  public MoreShareAppUI$a$a(View paramView)
  {
    this.iVc = ((ImageView)paramView.findViewById(R.h.hookIV));
    this.gSx = ((ImageView)paramView.findViewById(R.h.iconIV));
    this.eXO = ((TextView)paramView.findViewById(R.h.titleTV));
    this.lAy = ((MMSwitchBtn)paramView.findViewById(R.h.switchbtn));
    this.iVb = paramView.findViewById(R.h.container);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MoreShareAppUI.a.a
 * JD-Core Version:    0.7.0.1
 */