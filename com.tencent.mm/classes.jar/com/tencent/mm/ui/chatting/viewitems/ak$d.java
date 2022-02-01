package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.cd.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class ak$d
  extends c.a
{
  public static final int aeRR;
  public static final int aeRS;
  static final c lCf;
  ImageView aeNG;
  protected ImageView aeNK;
  protected TextView aeNL;
  protected TextView aeNM;
  protected LinearLayout aeNN;
  protected TextView aeNR;
  protected ImageView aeNm;
  protected ImageView aeNp;
  protected ImageView aeNq;
  protected TextView aeNs;
  protected ChattingItemFooter aeNt;
  protected ImageView aeNu;
  protected LinearLayout aeNv;
  protected ViewGroup aeNw;
  protected TextView aeNx;
  protected LinearLayout aeNy;
  protected TextView aeRT;
  protected ViewGroup aeRU;
  protected View aeRV;
  protected ImageView coverIv;
  protected ThreeDotsLoadingView uiD;
  
  static
  {
    AppMethodBeat.i(37104);
    aeRR = a.fromDPToPix(MMApplicationContext.getContext(), 240);
    aeRS = a.fromDPToPix(MMApplicationContext.getContext(), 192);
    com.tencent.mm.modelimage.loader.a.c.a locala1 = new com.tencent.mm.modelimage.loader.a.c.a();
    locala1.oKB = R.k.app_brand_app_default_icon_for_tail;
    com.tencent.mm.modelimage.loader.a.c.a locala2 = locala1.eG(a.fromDPToPix(MMApplicationContext.getContext(), 20), a.fromDPToPix(MMApplicationContext.getContext(), 20));
    locala2.nrc = true;
    locala2.oKp = true;
    locala2.oKn = true;
    lCf = locala1.bKx();
    AppMethodBeat.o(37104);
  }
  
  public final d ab(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37103);
    super.create(paramView);
    this.aeNm = ((ImageView)paramView.findViewById(R.h.fxa));
    this.aeNp = ((ImageView)this.convertView.findViewById(R.h.fxD));
    this.aeNq = ((ImageView)this.convertView.findViewById(R.h.fAl));
    this.aeNs = ((TextView)paramView.findViewById(R.h.fwD));
    this.aeNu = ((ImageView)paramView.findViewById(R.h.fwU));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.aeNt = ((ChattingItemFooter)paramView.findViewById(R.h.footer));
    this.aeNv = ((LinearLayout)paramView.findViewById(R.h.app_msg_layout));
    this.aeNw = ((ViewGroup)paramView.findViewById(R.h.fNj));
    this.aeNx = ((TextView)paramView.findViewById(R.h.fNg));
    this.aeNy = ((LinearLayout)paramView.findViewById(R.h.fxi));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    if (!paramBoolean)
    {
      this.aeNG = ((ImageView)this.convertView.findViewById(R.h.chatting_status_tick));
      this.uploadingPB = ((ProgressBar)this.convertView.findViewById(R.h.gbo));
    }
    this.aeNN = ((LinearLayout)paramView.findViewById(R.h.fwl));
    this.uiD = ((ThreeDotsLoadingView)paramView.findViewById(R.h.loading_view));
    this.coverIv = ((ImageView)paramView.findViewById(R.h.cover_iv));
    this.aeNR = ((TextView)paramView.findViewById(R.h.fww));
    this.aeRT = ((TextView)paramView.findViewById(R.h.fwn));
    this.aeNK = ((ImageView)paramView.findViewById(R.h.fwy));
    this.aeNL = ((TextView)paramView.findViewById(R.h.fwA));
    this.aeNM = ((TextView)paramView.findViewById(R.h.fwz));
    this.aeRU = ((ViewGroup)paramView.findViewById(R.h.fDO));
    AppMethodBeat.o(37103);
    return this;
  }
  
  public final View getMainContainerView()
  {
    return this.aeNy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.d
 * JD-Core Version:    0.7.0.1
 */