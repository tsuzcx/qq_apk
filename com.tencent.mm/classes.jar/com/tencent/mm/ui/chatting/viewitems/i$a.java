package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMTextView;

final class i$a
  extends c.a
{
  ImageView PIn;
  MMTextView PJU;
  View jxm;
  
  public final c.a G(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(36886);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.PJU = ((MMTextView)paramView.findViewById(2131298416));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    this.jxm = paramView.findViewById(2131298414);
    if (!paramBoolean)
    {
      this.PIn = ((ImageView)paramView.findViewById(2131298556));
      this.stateIV = ((ImageView)paramView.findViewById(2131298554));
      this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
    }
    AppMethodBeat.o(36886);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.jxm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.i.a
 * JD-Core Version:    0.7.0.1
 */