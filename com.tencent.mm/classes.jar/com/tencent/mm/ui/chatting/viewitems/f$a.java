package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class f$a
  extends c.a
{
  public View EpV;
  public ImageView KGE;
  public ImageView KHc;
  public boolean Wmn;
  public ImageView aeOS;
  public TextView aeOT;
  public TextView aeOU;
  public TextView aeOV;
  public TextView aeOW;
  public TextView aeOX;
  public ImageView aeOY;
  public ImageView aeOZ;
  public int aeOt = 0;
  public View aePa;
  public int aePb = 0;
  public int aePc;
  public long aePd;
  public int aePe;
  public int aePf;
  public int maxSize = 0;
  public View pKl;
  public View uiF;
  
  public final View getMainContainerView()
  {
    return this.EpV;
  }
  
  public final a lt(View paramView)
  {
    AppMethodBeat.i(36847);
    super.create(paramView);
    this.aePa = this.convertView.findViewById(R.h.fxn);
    this.timeTV = ((TextView)this.convertView.findViewById(R.h.fAm));
    this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.fxt));
    this.maskView = this.convertView.findViewById(R.h.fzn);
    this.userTV = ((TextView)this.convertView.findViewById(R.h.fAr));
    this.uiF = this.convertView.findViewById(R.h.footer);
    this.pKl = ((ImageView)this.convertView.findViewById(R.h.divider));
    this.aeOS = ((ImageView)this.convertView.findViewById(R.h.frS));
    this.aeOT = ((TextView)this.convertView.findViewById(R.h.frY));
    this.aeOU = ((TextView)this.convertView.findViewById(R.h.frQ));
    this.aeOV = ((TextView)this.convertView.findViewById(R.h.fsc));
    this.clickArea = this.convertView.findViewById(R.h.chatting_click_area);
    this.EpV = this.convertView.findViewById(R.h.fxw);
    this.KGE = ((ImageView)this.convertView.findViewById(R.h.fyF));
    this.aeOX = ((TextView)this.convertView.findViewById(R.h.fsb));
    this.aeOW = ((TextView)this.convertView.findViewById(R.h.frZ));
    this.KHc = ((ImageView)this.convertView.findViewById(R.h.fyG));
    this.aeOY = ((ImageView)this.convertView.findViewById(R.h.fsa));
    this.aeOZ = ((ImageView)this.convertView.findViewById(R.h.fAO));
    this.pKl = this.convertView.findViewById(R.h.frR);
    this.aeOt = c.nn(MMApplicationContext.getContext());
    this.aePb = a.br(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize);
    this.maxSize = ((int)(a.bs(MMApplicationContext.getContext(), R.f.ChatLucyTitleTextSize) * 1.45F));
    this.aePc = a.fromDPToPix(MMApplicationContext.getContext(), 20);
    AppMethodBeat.o(36847);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f.a
 * JD-Core Version:    0.7.0.1
 */