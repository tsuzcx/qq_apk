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
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class ac$d
  extends c.a
{
  public static final int Kzr;
  public static final int Kzs;
  static final c fQP;
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
  protected TextView Kwh;
  protected TextView Kzt;
  protected ViewGroup Kzu;
  protected View Kzv;
  protected ThreeDotsLoadingView mQm;
  protected ImageView oZd;
  
  static
  {
    AppMethodBeat.i(37104);
    Kzr = a.fromDPToPix(ak.getContext(), 240);
    Kzs = a.fromDPToPix(ak.getContext(), 192);
    com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
    locala1.igv = 2131689599;
    com.tencent.mm.av.a.a.c.a locala2 = locala1.dh(a.fromDPToPix(ak.getContext(), 20), a.fromDPToPix(ak.getContext(), 20));
    locala2.hhW = true;
    locala2.igk = true;
    locala2.igi = true;
    fQP = locala1.aJu();
    AppMethodBeat.o(37104);
  }
  
  public final d L(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37103);
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
    this.mQm = ((ThreeDotsLoadingView)paramView.findViewById(2131301514));
    this.oZd = ((ImageView)paramView.findViewById(2131298824));
    this.Kwh = ((TextView)paramView.findViewById(2131298016));
    this.Kzt = ((TextView)paramView.findViewById(2131298007));
    this.Kwa = ((ImageView)paramView.findViewById(2131298018));
    this.Kwb = ((TextView)paramView.findViewById(2131298020));
    this.Kwc = ((TextView)paramView.findViewById(2131298019));
    this.Kzu = ((ViewGroup)paramView.findViewById(2131298833));
    AppMethodBeat.o(37103);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.d
 * JD-Core Version:    0.7.0.1
 */