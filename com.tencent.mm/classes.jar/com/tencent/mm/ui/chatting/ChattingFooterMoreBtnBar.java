package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private WeImageButton JBp;
  private WeImageButton JBq;
  private WeImageButton JBr;
  private WeImageButton JBs;
  private WeImageButton JBt;
  private LinearLayout.LayoutParams uqc;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34552);
    setOrientation(0);
    setGravity(16);
    setBackground(aq.aM(getContext(), 2130969246));
    this.uqc = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165567), 1.0F);
    this.uqc.topMargin = a.fromDPToPix(getContext(), 0);
    this.JBp = new WeImageButton(getContext());
    this.JBp.setImageResource(2131231575);
    this.JBp.setScaleType(ImageView.ScaleType.CENTER);
    this.JBp.setBackgroundResource(0);
    this.JBp.setContentDescription(paramContext.getString(2131757252));
    this.JBt = new WeImageButton(getContext());
    this.JBt.setImageResource(2131231572);
    this.JBt.setScaleType(ImageView.ScaleType.CENTER);
    this.JBt.setBackgroundResource(0);
    this.JBt.setContentDescription(paramContext.getString(2131757251));
    this.JBs = new WeImageButton(getContext());
    this.JBs.setImageResource(2131231570);
    this.JBs.setScaleType(ImageView.ScaleType.CENTER);
    this.JBs.setBackgroundResource(0);
    this.JBs.setContentDescription(paramContext.getString(2131757249));
    this.JBr = new WeImageButton(getContext());
    this.JBr.setImageResource(2131231573);
    this.JBr.setScaleType(ImageView.ScaleType.CENTER);
    this.JBr.setBackgroundResource(0);
    this.JBr.setContentDescription(paramContext.getString(2131757248));
    this.JBq = new WeImageButton(getContext());
    this.JBq.setImageResource(2131231571);
    this.JBq.setScaleType(ImageView.ScaleType.CENTER);
    this.JBq.setBackgroundResource(0);
    this.JBq.setContentDescription(paramContext.getString(2131757250));
    fBI();
    AppMethodBeat.o(34552);
  }
  
  public final void acR(int paramInt)
  {
    AppMethodBeat.i(34554);
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.JBp.setClickable(bool);
      this.JBp.setEnabled(bool);
      if (j.fBk().size() <= 0) {
        break label97;
      }
      this.JBr.setClickable(bool);
      this.JBr.setEnabled(bool);
    }
    for (;;)
    {
      this.JBs.setClickable(bool);
      this.JBs.setEnabled(bool);
      this.JBt.setClickable(bool);
      this.JBt.setEnabled(bool);
      AppMethodBeat.o(34554);
      return;
      bool = false;
      break;
      label97:
      this.JBq.setClickable(bool);
      this.JBq.setEnabled(bool);
    }
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(34555);
    switch (paramInt)
    {
    default: 
      ad.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34555);
      return;
    case 2: 
      this.JBr.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 3: 
      this.JBs.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 1: 
      this.JBq.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 0: 
      this.JBp.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    }
    this.JBt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34555);
  }
  
  public final void fBI()
  {
    AppMethodBeat.i(34553);
    removeAllViews();
    addView(this.JBp, this.uqc);
    addView(this.JBt, this.uqc);
    addView(this.JBs, this.uqc);
    addView(this.JBq, this.uqc);
    AppMethodBeat.o(34553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar
 * JD-Core Version:    0.7.0.1
 */