package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class aa$d
  extends c.a
{
  public static final int GMA;
  public static final int GMz;
  static final c frV;
  protected ImageView GIO;
  protected ImageView GIR;
  protected ImageView GIS;
  protected TextView GIU;
  protected ChattingItemFooter GIV;
  protected ImageView GIW;
  protected LinearLayout GIX;
  protected ViewGroup GIY;
  protected TextView GIZ;
  protected LinearLayout GJa;
  ImageView GJi;
  protected ImageView GJm;
  protected TextView GJn;
  protected TextView GJo;
  protected LinearLayout GJp;
  protected TextView GJt;
  protected TextView GMB;
  protected ViewGroup GMC;
  protected View GMD;
  protected ThreeDotsLoadingView lIL;
  protected ImageView nMg;
  
  static
  {
    AppMethodBeat.i(37104);
    GMz = a.fromDPToPix(aj.getContext(), 240);
    GMA = a.fromDPToPix(aj.getContext(), 192);
    com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
    locala1.hkf = 2131689599;
    com.tencent.mm.aw.a.a.c.a locala2 = locala1.de(a.fromDPToPix(aj.getContext(), 20), a.fromDPToPix(aj.getContext(), 20));
    locala2.gkG = true;
    locala2.hjU = true;
    locala2.hjS = true;
    frV = locala1.azc();
    AppMethodBeat.o(37104);
  }
  
  public final d F(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37103);
    super.fK(paramView);
    this.GIO = ((ImageView)paramView.findViewById(2131298045));
    this.GIR = ((ImageView)this.rLd.findViewById(2131298078));
    this.GIS = ((ImageView)this.rLd.findViewById(2131298177));
    this.GIU = ((TextView)paramView.findViewById(2131298023));
    this.GIW = ((ImageView)paramView.findViewById(2131298039));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    this.wet = ((TextView)paramView.findViewById(2131298185));
    this.GIV = ((ChattingItemFooter)paramView.findViewById(2131300196));
    this.GIX = ((LinearLayout)paramView.findViewById(2131296863));
    this.GIY = ((ViewGroup)paramView.findViewById(2131301542));
    this.GIZ = ((TextView)paramView.findViewById(2131301539));
    this.GJa = ((LinearLayout)paramView.findViewById(2131298053));
    this.naN = paramView.findViewById(2131298069);
    if (!paramBoolean)
    {
      this.GJi = ((ImageView)this.rLd.findViewById(2131298176));
      this.uPp = ((ProgressBar)this.rLd.findViewById(2131306220));
    }
    this.GJp = ((LinearLayout)paramView.findViewById(2131298005));
    this.lIL = ((ThreeDotsLoadingView)paramView.findViewById(2131301514));
    this.nMg = ((ImageView)paramView.findViewById(2131298824));
    this.GJt = ((TextView)paramView.findViewById(2131298016));
    this.GMB = ((TextView)paramView.findViewById(2131298007));
    this.GJm = ((ImageView)paramView.findViewById(2131298018));
    this.GJn = ((TextView)paramView.findViewById(2131298020));
    this.GJo = ((TextView)paramView.findViewById(2131298019));
    this.GMC = ((ViewGroup)paramView.findViewById(2131298833));
    AppMethodBeat.o(37103);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.d
 * JD-Core Version:    0.7.0.1
 */