package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class am$e
  extends am.b
{
  TextView aeSd;
  MMNeat7extView aeSk;
  View aeSl;
  ImageView dpM;
  ImageView vIK;
  ImageView vIX;
  View vJg;
  
  public final void eF(View paramView)
  {
    AppMethodBeat.i(37136);
    if (this.vJU != null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_pic_slot);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    localViewStub.inflate();
    this.vJU = paramView.findViewById(R.h.fyw);
    this.vIK = ((ImageView)this.vJU.findViewById(R.h.cover));
    this.vIM = ((ImageView)this.vJU.findViewById(R.h.cover_mask_iv));
    this.vIX = ((ImageView)this.vJU.findViewById(R.h.press_mask_iv));
    this.dpM = ((ImageView)this.vJU.findViewById(R.h.pic_icon));
    this.vJg = this.vJU.findViewById(R.h.chatting_pic_cover_ll);
    this.aeSd = ((TextView)this.vJU.findViewById(R.h.pic_num));
    this.aeSk = ((MMNeat7extView)this.vJU.findViewById(R.h.single_digest_tv));
    this.aeSl = this.vJU.findViewById(R.h.single_top_pic_slot_digest_layout);
    AppMethodBeat.o(37136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.e
 * JD-Core Version:    0.7.0.1
 */