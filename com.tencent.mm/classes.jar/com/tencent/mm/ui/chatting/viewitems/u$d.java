package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$d
  extends u.b
{
  ImageView jXx;
  ImageView jXy;
  TextView jYx;
  ImageView jYy;
  
  public final void fj(View paramView)
  {
    AppMethodBeat.i(33073);
    if (this.jXr != null)
    {
      AppMethodBeat.o(33073);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131821883);
    if (localViewStub == null)
    {
      AppMethodBeat.o(33073);
      return;
    }
    localViewStub.inflate();
    this.jXr = paramView.findViewById(2131821913);
    this.jXx = ((ImageView)this.jXr.findViewById(2131821438));
    this.gui = ((TextView)this.jXr.findViewById(2131820680));
    this.jYx = ((TextView)this.jXr.findViewById(2131821915));
    this.jXy = ((ImageView)this.jXr.findViewById(2131821895));
    this.jYy = ((ImageView)this.jXr.findViewById(2131821916));
    this.jXG = ((ImageView)this.jXr.findViewById(2131821917));
    AppMethodBeat.o(33073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.d
 * JD-Core Version:    0.7.0.1
 */