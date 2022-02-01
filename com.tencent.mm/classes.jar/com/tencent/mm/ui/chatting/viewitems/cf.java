package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class cf
  extends c.a
{
  protected ImageView XnX;
  protected TextView mrM;
  
  public final View getMainContainerView()
  {
    return null;
  }
  
  public final cf iv(View paramView)
  {
    AppMethodBeat.i(37564);
    super.create(paramView);
    this.mrM = ((TextView)paramView.findViewById(R.h.dwq));
    this.XnX = ((ImageView)paramView.findViewById(R.h.dwL));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    AppMethodBeat.o(37564);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.cf
 * JD-Core Version:    0.7.0.1
 */