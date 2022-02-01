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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ak;

final class ad$d
  extends c.a
{
  public static final int Kzr;
  public static final int Kzs;
  static c fQP;
  protected ImageView KvC;
  protected ImageView KvF;
  protected ImageView KvG;
  protected TextView KvI;
  protected ChattingItemFooter KvJ;
  protected ImageView KvK;
  protected LinearLayout KvL;
  protected ViewGroup KvM;
  protected TextView KvN;
  protected LinearLayout KvO;
  ImageView KvW;
  protected ImageView Kwa;
  protected TextView Kwb;
  protected TextView Kwc;
  protected LinearLayout Kwd;
  protected ImageView Kwe;
  protected ImageView Kwg;
  protected TextView Kwh;
  protected TextView KzB;
  protected TextView KzC;
  protected TextView Kzt;
  
  static
  {
    AppMethodBeat.i(37128);
    Kzr = a.fromDPToPix(ak.getContext(), 240);
    Kzs = a.fromDPToPix(ak.getContext(), 192);
    com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
    locala.igv = 2131689599;
    locala.dh(a.fromDPToPix(ak.getContext(), 20), a.fromDPToPix(ak.getContext(), 20)).igi = true;
    fQP = locala.aJu();
    AppMethodBeat.o(37128);
  }
  
  public final d M(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37127);
    super.gs(paramView);
    this.KvC = ((ImageView)paramView.findViewById(2131298045));
    this.KvF = ((ImageView)this.uan.findViewById(2131298078));
    this.KvG = ((ImageView)this.uan.findViewById(2131298177));
    this.KvI = ((TextView)paramView.findViewById(2131298023));
    this.KvK = ((ImageView)paramView.findViewById(2131298039));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    this.yUp = ((TextView)paramView.findViewById(2131298185));
    this.KvJ = ((ChattingItemFooter)paramView.findViewById(2131300196));
    this.KvL = ((LinearLayout)paramView.findViewById(2131296863));
    this.KvM = ((ViewGroup)paramView.findViewById(2131301542));
    this.KvN = ((TextView)paramView.findViewById(2131301539));
    this.KvO = ((LinearLayout)paramView.findViewById(2131298053));
    this.olI = paramView.findViewById(2131298069);
    if (!paramBoolean)
    {
      this.KvW = ((ImageView)this.uan.findViewById(2131298176));
      this.xvJ = ((ProgressBar)this.uan.findViewById(2131306220));
    }
    this.Kwd = ((LinearLayout)paramView.findViewById(2131298005));
    this.Kwe = ((ImageView)paramView.findViewById(2131298006));
    this.Kwg = ((ImageView)paramView.findViewById(2131299519));
    this.Kwh = ((TextView)paramView.findViewById(2131298016));
    this.Kzt = ((TextView)paramView.findViewById(2131298007));
    this.KzB = ((TextView)paramView.findViewById(2131298022));
    this.Kwa = ((ImageView)paramView.findViewById(2131298018));
    this.Kwb = ((TextView)paramView.findViewById(2131298020));
    this.Kwc = ((TextView)paramView.findViewById(2131298019));
    this.KzC = ((TextView)paramView.findViewById(2131298021));
    AppMethodBeat.o(37127);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.d
 * JD-Core Version:    0.7.0.1
 */