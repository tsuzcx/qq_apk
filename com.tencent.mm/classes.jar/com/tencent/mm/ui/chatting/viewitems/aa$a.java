package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class aa$a
  extends c.a
{
  protected TextView aeQN;
  protected ImageView aeQO;
  
  public final a lD(View paramView)
  {
    AppMethodBeat.i(36991);
    super.create(paramView);
    this.aeQN = ((TextView)paramView.findViewById(R.h.fNg));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.aeQO = ((ImageView)paramView.findViewById(R.h.fNh));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    AppMethodBeat.o(36991);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.a
 * JD-Core Version:    0.7.0.1
 */