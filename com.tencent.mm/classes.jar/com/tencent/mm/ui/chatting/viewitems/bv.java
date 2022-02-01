package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;

class bv
  extends c.a
{
  public ImageView Xdw;
  bx XmA;
  cd XmB;
  b XmC;
  LinearLayout sHk;
  
  bv()
  {
    AppMethodBeat.i(37552);
    this.XmA = new bx();
    this.XmB = new cd();
    this.XmC = new b();
    AppMethodBeat.o(37552);
  }
  
  public View getMainContainerView()
  {
    return this.sHk;
  }
  
  public c.a iu(View paramView)
  {
    AppMethodBeat.i(219824);
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
    this.maskView = paramView.findViewById(R.h.dyD);
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.avatarIV = ((ChattingAvatarImageView)paramView.findViewById(R.h.chatting_avatar_iv));
    this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
    this.sHk = ((LinearLayout)paramView.findViewById(R.h.dxf));
    this.XmA.sEi = paramView.findViewById(R.h.dxV);
    this.XmA.XmD = paramView.findViewById(R.h.dIr);
    this.XmA.jMg = ((TextView)this.XmA.sEi.findViewById(R.h.title));
    this.XmA.XmG = ((LinearLayout)this.XmA.sEi.findViewById(R.h.dEN));
    this.XmA.zau = ((TextView)this.sHk.findViewById(R.h.dEg));
    this.XmA.XmH = this.sHk.findViewById(R.h.dTM);
    this.XmA.XmE = paramView.findViewById(R.h.dMO);
    this.XmA.XmF = paramView.findViewById(R.h.dMP);
    this.XmB.Xnd = paramView.findViewById(R.h.dxU);
    this.XmB.Xne = ((ImageView)paramView.findViewById(R.h.dOm));
    this.XmB.Xnf = ((ViewGroup)paramView.findViewById(R.h.dOn));
    this.XmB.Xng = paramView.findViewById(R.h.dOk);
    this.XmB.Xni = ((TextView)paramView.findViewById(R.h.dOD));
    ar.a(this.XmB.Xni.getPaint(), 0.8F);
    this.XmB.Xnh = ((ImageView)paramView.findViewById(R.h.dNI));
    this.XmB.Xnj = paramView.findViewById(R.h.dNM);
    this.XmB.Xnk = ((ImageView)paramView.findViewById(R.h.dOr));
    this.XmB.Xnl = paramView.findViewById(R.h.dOp);
    this.XmB.Xnm = paramView.findViewById(R.h.dOq);
    this.XmB.XnP = ((TextView)paramView.findViewById(R.h.dOC));
    this.XmB.XnQ = ((ViewGroup)paramView.findViewById(R.h.dOg));
    this.XmB.XnR = ((ImageView)paramView.findViewById(R.h.dOh));
    this.XmB.XnS = ((TextView)paramView.findViewById(R.h.dOi));
    this.XmB.Xnn = ((TextView)paramView.findViewById(R.h.dOv));
    this.XmB.Xno = ((TextView)paramView.findViewById(R.h.dNJ));
    this.XmB.Xnp = ((TextView)paramView.findViewById(R.h.dOj));
    this.XmB.Xnq = paramView.findViewById(R.h.dOl);
    this.XmB.Xnr = ((LinearLayout)paramView.findViewById(R.h.dOw));
    this.XmB.Xns = ((TextView)paramView.findViewById(R.h.dOy));
    this.XmB.Xnu = ((TextView)paramView.findViewById(R.h.dOz));
    this.XmB.Xnt = ((TextView)paramView.findViewById(R.h.dOA));
    this.XmB.Xnv = ((TextView)paramView.findViewById(R.h.dOB));
    this.XmB.Xnw = paramView.findViewById(R.h.dOx);
    this.XmB.Xnx = ((LinearLayout)paramView.findViewById(R.h.dOo));
    this.XmB.XnB = paramView.findViewById(R.h.dOb);
    this.XmB.Xny = paramView.findViewById(R.h.duz);
    this.XmB.Xnz = ((LinearLayout)paramView.findViewById(R.h.dNZ));
    this.XmB.XnA = ((LinearLayout)paramView.findViewById(R.h.dFo));
    this.XmB.XnC = ((LinearLayout)paramView.findViewById(R.h.dNN));
    this.XmB.XnF = ((TextView)paramView.findViewById(R.h.dNP));
    this.XmB.XnH = ((ImageView)paramView.findViewById(R.h.dNO));
    this.XmB.XnE = paramView.findViewById(R.h.dOa);
    this.XmB.XnD = ((LinearLayout)paramView.findViewById(R.h.dNQ));
    this.XmB.XnG = ((TextView)paramView.findViewById(R.h.dNS));
    this.XmB.XnI = ((ImageView)paramView.findViewById(R.h.dNR));
    this.XmB.XnJ = ((ImageView)paramView.findViewById(R.h.dNH));
    this.Xdw = ((ImageView)paramView.findViewById(R.h.dxS));
    this.XmB.XnK = paramView.findViewById(R.h.dOs);
    this.XmB.XnL = ((ImageView)paramView.findViewById(R.h.dOt));
    this.XmB.XnM = ((TextView)paramView.findViewById(R.h.dOu));
    this.XmB.XnN = ((LinearLayout)paramView.findViewById(R.h.dNK));
    this.XmB.XnO = ((TextView)paramView.findViewById(R.h.dNL));
    this.XmC.XbU = ((LinearLayout)paramView.findViewById(R.h.dOe));
    this.XmC.XbV = ((CdnImageView)paramView.findViewById(R.h.dOd));
    this.XmC.XbW = ((TextView)paramView.findViewById(R.h.dOf));
    this.XmC.XbX = ((TextView)paramView.findViewById(R.h.dOc));
    AppMethodBeat.o(219824);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bv
 * JD-Core Version:    0.7.0.1
 */