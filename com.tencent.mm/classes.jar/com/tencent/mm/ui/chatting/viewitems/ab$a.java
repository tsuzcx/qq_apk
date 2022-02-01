package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.s;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

public final class ab$a
  extends c.a
{
  protected TextView Aoo;
  com.tencent.mm.ui.widget.b.a GAa;
  ImageView Yft;
  ImageView Yfu;
  FrameLayout Yfv;
  a.f aeMh;
  protected TextView aeNs;
  View aeQT;
  protected MMNeat7extView aeQs;
  com.tencent.mm.ui.widget.textview.a aeQt;
  l aeQu;
  a.e aeQv;
  ViewStub aeQw;
  ChattingItemTranslate aeQx;
  public View hDw;
  protected ImageView stateIV;
  
  public final View getMainContainerView()
  {
    return this.aeQs;
  }
  
  public final a lE(View paramView)
  {
    AppMethodBeat.i(37002);
    super.create(paramView);
    this.aeQs = ((MMNeat7extView)paramView.findViewById(R.h.fxy));
    this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
    this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
    this.Aoo = ((TextView)paramView.findViewById(R.h.fwZ));
    this.Yfv = ((FrameLayout)paramView.findViewById(R.h.fOH));
    this.Yft = ((ImageView)paramView.findViewById(R.h.fOI));
    this.Yfu = ((ImageView)paramView.findViewById(R.h.fOM));
    this.aeNs = ((TextView)paramView.findViewById(R.h.fwD));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.clickArea = paramView.findViewById(R.h.fTY);
    this.aeQT = paramView.findViewById(R.h.fTZ);
    this.hDw = paramView.findViewById(R.h.fxw);
    this.aeQw = ((ViewStub)paramView.findViewById(R.h.gaF));
    this.aeQu = new l(this.aeQs, new s(this.aeQs.getContext()));
    AppMethodBeat.o(37002);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.a
 * JD-Core Version:    0.7.0.1
 */