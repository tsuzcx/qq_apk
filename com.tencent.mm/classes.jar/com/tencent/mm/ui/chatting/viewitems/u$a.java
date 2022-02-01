package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$a
  extends c.a
{
  TextView PKz;
  ImageView gyr;
  TextView hPW;
  TextView pIN;
  public ImageView tickIV;
  
  public final a P(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(233705);
    super.create(paramView);
    this.gyr = ((ImageView)paramView.findViewById(2131302052));
    this.pIN = ((TextView)paramView.findViewById(2131302055));
    this.hPW = ((TextView)paramView.findViewById(2131302054));
    this.PKz = ((TextView)paramView.findViewById(2131302056));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    if (paramBoolean)
    {
      this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
      this.tickIV = ((ImageView)paramView.findViewById(2131298556));
    }
    AppMethodBeat.o(233705);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.a
 * JD-Core Version:    0.7.0.1
 */