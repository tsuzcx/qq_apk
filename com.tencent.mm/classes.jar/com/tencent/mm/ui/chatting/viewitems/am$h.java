package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class am$h
  extends am.b
{
  ImageView dpM;
  TextView timeTv;
  ImageView vIK;
  MMNeat7extView vIW;
  ImageView vIX;
  View vJg;
  
  public final void eF(View paramView)
  {
    AppMethodBeat.i(37139);
    if (this.vJU != null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_video_slot);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    localViewStub.inflate();
    this.vJU = paramView.findViewById(R.h.fyx);
    this.vIK = ((ImageView)this.vJU.findViewById(R.h.cover));
    this.vIM = ((ImageView)this.vJU.findViewById(R.h.cover_mask_iv));
    this.vIX = ((ImageView)this.vJU.findViewById(R.h.press_mask_iv));
    this.dpM = ((ImageView)this.vJU.findViewById(R.h.video_icon));
    this.vIW = ((MMNeat7extView)this.vJU.findViewById(R.h.title_tv));
    this.timeTv = ((TextView)this.vJU.findViewById(R.h.time_tv));
    this.vJg = this.vJU.findViewById(R.h.chatting_video_cover_ll);
    AppMethodBeat.o(37139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.h
 * JD-Core Version:    0.7.0.1
 */