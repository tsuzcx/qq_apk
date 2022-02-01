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
  protected TextView Khe;
  protected TextView Khf;
  protected Button Khg;
  protected Button Khh;
  protected ImageView Khi;
  protected TextView iCV;
  
  public final bg gM(View paramView)
  {
    AppMethodBeat.i(37551);
    super.gn(paramView);
    this.iCV = ((TextView)paramView.findViewById(2131298026));
    this.Khe = ((TextView)paramView.findViewById(2131298025));
    this.Khf = ((TextView)paramView.findViewById(2131298048));
    this.Khg = ((Button)paramView.findViewById(2131298137));
    this.Khh = ((Button)paramView.findViewById(2131298136));
    this.Khi = ((ImageView)paramView.findViewById(2131298179));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    AppMethodBeat.o(37551);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bg
 * JD-Core Version:    0.7.0.1
 */