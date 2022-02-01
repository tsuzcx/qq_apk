package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ag$a
  extends c.a
{
  protected TextView PHZ;
  protected MMNeat7extView PKD;
  protected ImageView stateIV;
  protected TextView tln;
  
  public final View getMainContainerView()
  {
    return this.PKD;
  }
  
  public final a ha(View paramView)
  {
    AppMethodBeat.i(37056);
    super.create(paramView);
    this.PKD = ((MMNeat7extView)paramView.findViewById(2131298416));
    this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
    this.stateIV = ((ImageView)paramView.findViewById(2131298554));
    this.tln = ((TextView)paramView.findViewById(2131298385));
    this.PHZ = ((TextView)paramView.findViewById(2131298364));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    AppMethodBeat.o(37056);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag.a
 * JD-Core Version:    0.7.0.1
 */