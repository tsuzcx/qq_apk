package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class ab$d
  extends c.a
{
  public static final int ImB;
  public static final int ImC;
  static final c fvC;
  protected ImageView IiL;
  protected ImageView IiO;
  protected ImageView IiP;
  protected TextView IiR;
  protected ChattingItemFooter IiS;
  protected ImageView IiT;
  protected LinearLayout IiU;
  protected ViewGroup IiV;
  protected TextView IiW;
  protected LinearLayout IiX;
  ImageView Ijf;
  protected ImageView Ijj;
  protected TextView Ijk;
  protected TextView Ijl;
  protected LinearLayout Ijm;
  protected TextView Ijq;
  protected TextView ImD;
  protected ViewGroup ImE;
  protected View ImF;
  protected ThreeDotsLoadingView mkI;
  protected ImageView opg;
  
  static
  {
    AppMethodBeat.i(37104);
    ImB = a.fromDPToPix(ai.getContext(), 240);
    ImC = a.fromDPToPix(ai.getContext(), 192);
    com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
    locala1.hKI = 2131689599;
    com.tencent.mm.av.a.a.c.a locala2 = locala1.de(a.fromDPToPix(ai.getContext(), 20), a.fromDPToPix(ai.getContext(), 20));
    locala2.gLt = true;
    locala2.hKx = true;
    locala2.hKv = true;
    fvC = locala1.aFT();
    AppMethodBeat.o(37104);
  }
  
  public final d F(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37103);
    super.fX(paramView);
    this.IiL = ((ImageView)paramView.findViewById(2131298045));
    this.IiO = ((ImageView)this.sSS.findViewById(2131298078));
    this.IiP = ((ImageView)this.sSS.findViewById(2131298177));
    this.IiR = ((TextView)paramView.findViewById(2131298023));
    this.IiT = ((ImageView)paramView.findViewById(2131298039));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    this.IiS = ((ChattingItemFooter)paramView.findViewById(2131300196));
    this.IiU = ((LinearLayout)paramView.findViewById(2131296863));
    this.IiV = ((ViewGroup)paramView.findViewById(2131301542));
    this.IiW = ((TextView)paramView.findViewById(2131301539));
    this.IiX = ((LinearLayout)paramView.findViewById(2131298053));
    this.nDl = paramView.findViewById(2131298069);
    if (!paramBoolean)
    {
      this.Ijf = ((ImageView)this.sSS.findViewById(2131298176));
      this.vYf = ((ProgressBar)this.sSS.findViewById(2131306220));
    }
    this.Ijm = ((LinearLayout)paramView.findViewById(2131298005));
    this.mkI = ((ThreeDotsLoadingView)paramView.findViewById(2131301514));
    this.opg = ((ImageView)paramView.findViewById(2131298824));
    this.Ijq = ((TextView)paramView.findViewById(2131298016));
    this.ImD = ((TextView)paramView.findViewById(2131298007));
    this.Ijj = ((ImageView)paramView.findViewById(2131298018));
    this.Ijk = ((TextView)paramView.findViewById(2131298020));
    this.Ijl = ((TextView)paramView.findViewById(2131298019));
    this.ImE = ((ViewGroup)paramView.findViewById(2131298833));
    AppMethodBeat.o(37103);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.d
 * JD-Core Version:    0.7.0.1
 */