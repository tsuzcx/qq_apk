package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class am$i
  extends am.b
{
  TextView vLJ;
  ImageView vMs;
  
  public final void eF(View paramView)
  {
    AppMethodBeat.i(37140);
    if (this.vJU != null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_voice_slot);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37140);
      return;
    }
    localViewStub.inflate();
    this.vJU = paramView.findViewById(R.h.fyy);
    this.mll = ((TextView)this.vJU.findViewById(R.h.title));
    this.vLJ = ((TextView)this.vJU.findViewById(R.h.time_tv));
    this.vMs = ((ImageView)this.vJU.findViewById(R.h.play_icon));
    AppMethodBeat.o(37140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.i
 * JD-Core Version:    0.7.0.1
 */