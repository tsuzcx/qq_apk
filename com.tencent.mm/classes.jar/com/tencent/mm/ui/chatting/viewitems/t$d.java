package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

final class t$d
  extends c.a
{
  public static final int zUv;
  public static final int zUw;
  static c zUx;
  protected ImageView zRS;
  protected ImageView zRV;
  protected ImageView zRW;
  protected TextView zRY;
  protected ChattingItemFooter zRZ;
  protected ImageView zSa;
  protected LinearLayout zSb;
  protected ViewGroup zSc;
  protected TextView zSd;
  protected LinearLayout zSe;
  ImageView zSm;
  protected ImageView zSq;
  protected TextView zSr;
  protected TextView zSs;
  protected LinearLayout zSt;
  protected ImageView zSu;
  protected ImageView zSv;
  protected TextView zSw;
  protected TextView zUG;
  protected TextView zUH;
  protected TextView zUy;
  
  static
  {
    AppMethodBeat.i(33066);
    zUv = a.fromDPToPix(ah.getContext(), 240);
    zUw = a.fromDPToPix(ah.getContext(), 192);
    com.tencent.mm.at.a.a.c.a locala = new com.tencent.mm.at.a.a.c.a();
    locala.eNY = 2131230843;
    locala.cx(a.fromDPToPix(ah.getContext(), 20), a.fromDPToPix(ah.getContext(), 20)).eNK = true;
    zUx = locala.ahY();
    AppMethodBeat.o(33066);
  }
  
  public final d D(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(33065);
    super.eV(paramView);
    this.zRS = ((ImageView)paramView.findViewById(2131822621));
    this.zRV = ((ImageView)this.ngZ.findViewById(2131822620));
    this.zRW = ((ImageView)this.ngZ.findViewById(2131822619));
    this.zRY = ((TextView)paramView.findViewById(2131822518));
    this.zSa = ((ImageView)paramView.findViewById(2131822622));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.zRZ = ((ChattingItemFooter)paramView.findViewById(2131822618));
    this.zSb = ((LinearLayout)paramView.findViewById(2131822579));
    this.zSc = ((ViewGroup)paramView.findViewById(2131822576));
    this.zSd = ((TextView)paramView.findViewById(2131822578));
    this.zSe = ((LinearLayout)paramView.findViewById(2131821948));
    this.jYu = paramView.findViewById(2131822580);
    if (!paramBoolean)
    {
      this.zSm = ((ImageView)this.ngZ.findViewById(2131822729));
      this.pNd = ((ProgressBar)this.ngZ.findViewById(2131822728));
    }
    this.zSt = ((LinearLayout)paramView.findViewById(2131822581));
    this.zSu = ((ImageView)paramView.findViewById(2131822586));
    this.zSv = ((ImageView)paramView.findViewById(2131822585));
    this.zSw = ((TextView)paramView.findViewById(2131822584));
    this.zUy = ((TextView)paramView.findViewById(2131822653));
    this.zUG = ((TextView)paramView.findViewById(2131822654));
    this.zSq = ((ImageView)paramView.findViewById(2131822582));
    this.zSr = ((TextView)paramView.findViewById(2131822583));
    this.zSs = ((TextView)paramView.findViewById(2131822588));
    this.zUH = ((TextView)paramView.findViewById(2131822655));
    AppMethodBeat.o(33065);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.d
 * JD-Core Version:    0.7.0.1
 */