package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;

class bw
  extends c.a
{
  public ImageView aeNu;
  by aeXD;
  ce aeXE;
  ce aeXF;
  ce aeXG;
  b aeXH;
  LinearLayout vMH;
  
  bw()
  {
    AppMethodBeat.i(37552);
    this.aeXD = new by();
    this.aeXE = new ce(false);
    this.aeXF = new ce(true);
    this.aeXG = this.aeXE;
    this.aeXH = new b();
    AppMethodBeat.o(37552);
  }
  
  public View getMainContainerView()
  {
    return this.vMH;
  }
  
  public c.a lR(View paramView)
  {
    AppMethodBeat.i(255222);
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.avatarIV = ((ChattingAvatarImageView)paramView.findViewById(R.h.fxl));
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.vMH = ((LinearLayout)paramView.findViewById(R.h.fxA));
    this.aeXD.vJU = paramView.findViewById(R.h.fyD);
    this.aeXD.aeXI = paramView.findViewById(R.h.fJG);
    this.aeXD.mll = ((TextView)this.aeXD.vJU.findViewById(R.h.title));
    this.aeXD.aeXL = ((LinearLayout)this.aeXD.vJU.findViewById(R.h.fFR));
    this.aeXD.DTW = ((TextView)this.vMH.findViewById(R.h.fEZ));
    this.aeXD.aeXM = this.vMH.findViewById(R.h.fVU);
    this.aeXD.aeXJ = paramView.findViewById(R.h.fOz);
    this.aeXD.aeXK = paramView.findViewById(R.h.fOA);
    this.aeXE.aeYg = paramView.findViewById(R.h.fyB);
    this.aeXF.aeYg = paramView.findViewById(R.h.fyE);
    this.aeXE.a(this.aeXH);
    this.aeXF.a(this.aeXH);
    this.aeNu = ((ImageView)paramView.findViewById(R.h.fyz));
    AppMethodBeat.o(255222);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bw
 * JD-Core Version:    0.7.0.1
 */