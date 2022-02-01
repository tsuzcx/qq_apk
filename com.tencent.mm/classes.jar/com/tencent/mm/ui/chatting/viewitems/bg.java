package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bg
  extends c.a
{
  protected TextView KDA;
  protected Button KDB;
  protected Button KDC;
  protected ImageView KDD;
  protected TextView KDz;
  protected TextView iFO;
  
  public final bg gR(View paramView)
  {
    AppMethodBeat.i(37551);
    super.gs(paramView);
    this.iFO = ((TextView)paramView.findViewById(2131298026));
    this.KDz = ((TextView)paramView.findViewById(2131298025));
    this.KDA = ((TextView)paramView.findViewById(2131298048));
    this.KDB = ((Button)paramView.findViewById(2131298137));
    this.KDC = ((Button)paramView.findViewById(2131298136));
    this.KDD = ((ImageView)paramView.findViewById(2131298179));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    AppMethodBeat.o(37551);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bg
 * JD-Core Version:    0.7.0.1
 */