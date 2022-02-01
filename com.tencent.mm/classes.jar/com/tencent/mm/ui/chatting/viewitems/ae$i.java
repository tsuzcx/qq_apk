package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ae$i
  extends ae.b
{
  ImageView oeW;
  TextView umZ;
  
  public final void dD(View paramView)
  {
    AppMethodBeat.i(37140);
    if (this.odh != null)
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
    this.odh = paramView.findViewById(2131298113);
    this.gnM = ((TextView)this.odh.findViewById(2131305902));
    this.umZ = ((TextView)this.odh.findViewById(2131305822));
    this.oeW = ((ImageView)this.odh.findViewById(2131303284));
    AppMethodBeat.o(37140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.i
 * JD-Core Version:    0.7.0.1
 */