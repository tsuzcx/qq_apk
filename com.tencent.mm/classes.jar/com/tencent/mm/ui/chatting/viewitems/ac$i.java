package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac$i
  extends ac.b
{
  ImageView mZQ;
  TextView sgI;
  
  public final void dy(View paramView)
  {
    AppMethodBeat.i(37140);
    if (this.mYI != null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306456);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    localViewStub.inflate();
    this.mYI = paramView.findViewById(2131298113);
    this.fQp = ((TextView)this.mYI.findViewById(2131305902));
    this.sgI = ((TextView)this.mYI.findViewById(2131305822));
    this.mZQ = ((ImageView)this.mYI.findViewById(2131303284));
    AppMethodBeat.o(37140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.i
 * JD-Core Version:    0.7.0.1
 */