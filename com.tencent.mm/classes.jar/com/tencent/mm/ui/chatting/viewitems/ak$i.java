package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ak$i
  extends ak.b
{
  TextView pwO;
  ImageView pxu;
  
  public final void du(View paramView)
  {
    AppMethodBeat.i(37140);
    if (this.puO != null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131309899);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    localViewStub.inflate();
    this.puO = paramView.findViewById(2131298463);
    this.hbb = ((TextView)this.puO.findViewById(2131309195));
    this.pwO = ((TextView)this.puO.findViewById(2131309101));
    this.pxu = ((ImageView)this.puO.findViewById(2131305957));
    AppMethodBeat.o(37140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.i
 * JD-Core Version:    0.7.0.1
 */