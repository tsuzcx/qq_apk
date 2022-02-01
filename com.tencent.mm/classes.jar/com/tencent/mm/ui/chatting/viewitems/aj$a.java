package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class aj$a
  extends c.a
{
  protected TextView Xdu;
  protected MMNeat7extView Xgx;
  protected ImageView stateIV;
  protected TextView wRL;
  
  public final View getMainContainerView()
  {
    return this.Xgx;
  }
  
  public final a im(View paramView)
  {
    AppMethodBeat.i(37056);
    super.create(paramView);
    this.Xgx = ((MMNeat7extView)paramView.findViewById(R.h.chatting_content_itv));
    this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
    this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
    this.wRL = ((TextView)paramView.findViewById(R.h.dwI));
    this.Xdu = ((TextView)paramView.findViewById(R.h.dwm));
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    AppMethodBeat.o(37056);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.a
 * JD-Core Version:    0.7.0.1
 */