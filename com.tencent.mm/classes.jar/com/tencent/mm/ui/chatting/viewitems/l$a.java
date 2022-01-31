package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$a
  extends c.a
{
  protected TextView mCZ;
  protected ImageView mZY;
  protected View mzQ;
  protected ImageView nef;
  protected TextView zRY;
  protected TextView zTZ;
  protected ImageView zUa;
  
  public final a fc(View paramView)
  {
    AppMethodBeat.i(32951);
    super.eV(paramView);
    this.mZY = ((ImageView)paramView.findViewById(2131822600));
    this.mCZ = ((TextView)paramView.findViewById(2131822607));
    this.zTZ = ((TextView)paramView.findViewById(2131822731));
    this.mzQ = paramView.findViewById(2131822730);
    this.zRY = ((TextView)paramView.findViewById(2131822518));
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.zUa = ((ImageView)paramView.findViewById(2131822622));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.nef = ((ImageView)paramView.findViewById(2131822646));
    AppMethodBeat.o(32951);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.a
 * JD-Core Version:    0.7.0.1
 */