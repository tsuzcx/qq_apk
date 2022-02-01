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
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class ai$d
  extends c.a
{
  public static final int PLR;
  public static final int PLS;
  static final c gvY;
  protected ImageView PHT;
  protected ImageView PHW;
  protected ImageView PHX;
  protected TextView PHZ;
  protected ChattingItemFooter PIa;
  protected ImageView PIb;
  protected LinearLayout PIc;
  protected ViewGroup PId;
  protected TextView PIe;
  protected LinearLayout PIf;
  ImageView PIn;
  protected ImageView PIr;
  protected TextView PIs;
  protected TextView PIt;
  protected LinearLayout PIu;
  protected TextView PIy;
  protected TextView PLT;
  protected ViewGroup PLU;
  protected View PLV;
  protected ThreeDotsLoadingView odq;
  protected ImageView puw;
  
  static
  {
    AppMethodBeat.i(37104);
    PLR = a.fromDPToPix(MMApplicationContext.getContext(), 240);
    PLS = a.fromDPToPix(MMApplicationContext.getContext(), 192);
    com.tencent.mm.av.a.a.c.a locala1 = new com.tencent.mm.av.a.a.c.a();
    locala1.jbq = 2131689602;
    com.tencent.mm.av.a.a.c.a locala2 = locala1.dr(a.fromDPToPix(MMApplicationContext.getContext(), 20), a.fromDPToPix(MMApplicationContext.getContext(), 20));
    locala2.iaT = true;
    locala2.jbf = true;
    locala2.jbd = true;
    gvY = locala1.bdv();
    AppMethodBeat.o(37104);
  }
  
  public final d R(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37103);
    super.create(paramView);
    this.PHT = ((ImageView)paramView.findViewById(2131298386));
    this.PHW = ((ImageView)this.convertView.findViewById(2131298421));
    this.PHX = ((ImageView)this.convertView.findViewById(2131298557));
    this.PHZ = ((TextView)paramView.findViewById(2131298364));
    this.PIb = ((ImageView)paramView.findViewById(2131298380));
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.PIa = ((ChattingItemFooter)paramView.findViewById(2131301661));
    this.PIc = ((LinearLayout)paramView.findViewById(2131296956));
    this.PId = ((ViewGroup)paramView.findViewById(2131303752));
    this.PIe = ((TextView)paramView.findViewById(2131303749));
    this.PIf = ((LinearLayout)paramView.findViewById(2131298394));
    this.clickArea = paramView.findViewById(2131298411);
    if (!paramBoolean)
    {
      this.PIn = ((ImageView)this.convertView.findViewById(2131298556));
      this.uploadingPB = ((ProgressBar)this.convertView.findViewById(2131309619));
    }
    this.PIu = ((LinearLayout)paramView.findViewById(2131298346));
    this.odq = ((ThreeDotsLoadingView)paramView.findViewById(2131303719));
    this.puw = ((ImageView)paramView.findViewById(2131299289));
    this.PIy = ((TextView)paramView.findViewById(2131298357));
    this.PLT = ((TextView)paramView.findViewById(2131298348));
    this.PIr = ((ImageView)paramView.findViewById(2131298359));
    this.PIs = ((TextView)paramView.findViewById(2131298361));
    this.PIt = ((TextView)paramView.findViewById(2131298360));
    this.PLU = ((ViewGroup)paramView.findViewById(2131299298));
    AppMethodBeat.o(37103);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.PIf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ai.d
 * JD-Core Version:    0.7.0.1
 */