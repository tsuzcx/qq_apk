package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class am$d
  extends am.b
{
  ImageView vIK;
  ImageView vMs;
  TextView vNi;
  ImageView vNj;
  
  public final void eF(View paramView)
  {
    AppMethodBeat.i(37135);
    if (this.vJU != null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_music_slot);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    localViewStub.inflate();
    this.vJU = paramView.findViewById(R.h.fyv);
    this.vIK = ((ImageView)this.vJU.findViewById(R.h.cover));
    this.mll = ((TextView)this.vJU.findViewById(R.h.title));
    this.vNi = ((TextView)this.vJU.findViewById(R.h.player_tv));
    this.vMs = ((ImageView)this.vJU.findViewById(R.h.play_icon));
    this.vNj = ((ImageView)this.vJU.findViewById(R.h.watermark_iv));
    this.vIM = ((ImageView)this.vJU.findViewById(R.h.cover_mask_iv));
    AppMethodBeat.o(37135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.d
 * JD-Core Version:    0.7.0.1
 */