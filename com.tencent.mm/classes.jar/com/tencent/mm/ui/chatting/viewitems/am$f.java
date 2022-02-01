package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class am$f
  extends am.b
{
  View Nwq;
  MMNeat7extView Nwt;
  ImageView Nwu;
  TextView aeSm;
  ImageView vIK;
  MMNeat7extView vIW;
  ImageView vIX;
  View vJg;
  
  public final void eF(View paramView)
  {
    AppMethodBeat.i(37137);
    if (this.vJU != null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(R.h.viewstub_top_slot);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    localViewStub.inflate();
    this.vJU = paramView.findViewById(R.h.gaA);
    this.vIW = ((MMNeat7extView)this.vJU.findViewById(R.h.title));
    this.vIK = ((ImageView)this.vJU.findViewById(R.h.cover));
    this.vJg = this.vJU.findViewById(R.h.fDM);
    this.Nwq = this.vJU.findViewById(R.h.fuQ);
    this.Nwt = ((MMNeat7extView)this.vJU.findViewById(R.h.gad));
    this.aeSm = ((TextView)this.vJU.findViewById(R.h.fFQ));
    this.vIX = ((ImageView)this.vJU.findViewById(R.h.press_mask_iv));
    this.Nwu = ((ImageView)this.vJU.findViewById(R.h.fDN));
    AppMethodBeat.o(37137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.f
 * JD-Core Version:    0.7.0.1
 */