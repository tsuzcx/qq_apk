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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class ac$d
  extends c.a
{
  public static final int KcZ;
  public static final int Kda;
  static final c fOJ;
  ImageView JZD;
  protected ImageView JZH;
  protected TextView JZI;
  protected TextView JZJ;
  protected LinearLayout JZK;
  protected TextView JZO;
  protected ImageView JZj;
  protected ImageView JZm;
  protected ImageView JZn;
  protected TextView JZp;
  protected ChattingItemFooter JZq;
  protected ImageView JZr;
  protected LinearLayout JZs;
  protected ViewGroup JZt;
  protected TextView JZu;
  protected LinearLayout JZv;
  protected TextView Kdb;
  protected ViewGroup Kdc;
  protected View Kdd;
  protected ThreeDotsLoadingView mLk;
  protected ImageView oSB;
  
  static
  {
    AppMethodBeat.i(37104);
    KcZ = a.fromDPToPix(aj.getContext(), 240);
    Kda = a.fromDPToPix(aj.getContext(), 192);
    com.tencent.mm.aw.a.a.c.a locala1 = new com.tencent.mm.aw.a.a.c.a();
    locala1.idD = 2131689599;
    com.tencent.mm.aw.a.a.c.a locala2 = locala1.dh(a.fromDPToPix(aj.getContext(), 20), a.fromDPToPix(aj.getContext(), 20));
    locala2.hfi = true;
    locala2.idr = true;
    locala2.idp = true;
    fOJ = locala1.aJc();
    AppMethodBeat.o(37104);
  }
  
  public final d G(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37103);
    super.gn(paramView);
    this.JZj = ((ImageView)paramView.findViewById(2131298045));
    this.JZm = ((ImageView)this.tPw.findViewById(2131298078));
    this.JZn = ((ImageView)this.tPw.findViewById(2131298177));
    this.JZp = ((TextView)paramView.findViewById(2131298023));
    this.JZr = ((ImageView)paramView.findViewById(2131298039));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    this.JZq = ((ChattingItemFooter)paramView.findViewById(2131300196));
    this.JZs = ((LinearLayout)paramView.findViewById(2131296863));
    this.JZt = ((ViewGroup)paramView.findViewById(2131301542));
    this.JZu = ((TextView)paramView.findViewById(2131301539));
    this.JZv = ((LinearLayout)paramView.findViewById(2131298053));
    this.ofK = paramView.findViewById(2131298069);
    if (!paramBoolean)
    {
      this.JZD = ((ImageView)this.tPw.findViewById(2131298176));
      this.xfR = ((ProgressBar)this.tPw.findViewById(2131306220));
    }
    this.JZK = ((LinearLayout)paramView.findViewById(2131298005));
    this.mLk = ((ThreeDotsLoadingView)paramView.findViewById(2131301514));
    this.oSB = ((ImageView)paramView.findViewById(2131298824));
    this.JZO = ((TextView)paramView.findViewById(2131298016));
    this.Kdb = ((TextView)paramView.findViewById(2131298007));
    this.JZH = ((ImageView)paramView.findViewById(2131298018));
    this.JZI = ((TextView)paramView.findViewById(2131298020));
    this.JZJ = ((TextView)paramView.findViewById(2131298019));
    this.Kdc = ((ViewGroup)paramView.findViewById(2131298833));
    AppMethodBeat.o(37103);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.d
 * JD-Core Version:    0.7.0.1
 */