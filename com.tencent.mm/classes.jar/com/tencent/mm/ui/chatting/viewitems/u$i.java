package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$i
  extends u.b
{
  ImageView jXy;
  TextView nxi;
  
  public final void fj(View paramView)
  {
    AppMethodBeat.i(33078);
    if (this.jXr != null)
    {
      AppMethodBeat.o(33078);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131821882);
    if (localViewStub == null)
    {
      AppMethodBeat.o(33078);
      return;
    }
    localViewStub.inflate();
    this.jXr = paramView.findViewById(2131821942);
    this.gui = ((TextView)this.jXr.findViewById(2131820680));
    this.nxi = ((TextView)this.jXr.findViewById(2131821004));
    this.jXy = ((ImageView)this.jXr.findViewById(2131821895));
    AppMethodBeat.o(33078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.i
 * JD-Core Version:    0.7.0.1
 */