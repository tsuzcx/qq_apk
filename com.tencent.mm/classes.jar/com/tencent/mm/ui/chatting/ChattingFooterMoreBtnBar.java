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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private WeImageButton HNA;
  private WeImageButton HNB;
  private WeImageButton HNC;
  private WeImageButton HND;
  private WeImageButton HNz;
  private LinearLayout.LayoutParams trF;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34552);
    setOrientation(0);
    setGravity(16);
    setBackground(ao.aI(getContext(), 2130969246));
    this.trF = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165567), 1.0F);
    this.trF.topMargin = a.fromDPToPix(getContext(), 0);
    this.HNz = new WeImageButton(getContext());
    this.HNz.setImageResource(2131231575);
    this.HNz.setScaleType(ImageView.ScaleType.CENTER);
    this.HNz.setBackgroundResource(0);
    this.HNz.setContentDescription(paramContext.getString(2131757252));
    this.HND = new WeImageButton(getContext());
    this.HND.setImageResource(2131231572);
    this.HND.setScaleType(ImageView.ScaleType.CENTER);
    this.HND.setBackgroundResource(0);
    this.HND.setContentDescription(paramContext.getString(2131757251));
    this.HNC = new WeImageButton(getContext());
    this.HNC.setImageResource(2131231570);
    this.HNC.setScaleType(ImageView.ScaleType.CENTER);
    this.HNC.setBackgroundResource(0);
    this.HNC.setContentDescription(paramContext.getString(2131757249));
    this.HNB = new WeImageButton(getContext());
    this.HNB.setImageResource(2131231573);
    this.HNB.setScaleType(ImageView.ScaleType.CENTER);
    this.HNB.setBackgroundResource(0);
    this.HNB.setContentDescription(paramContext.getString(2131757248));
    this.HNA = new WeImageButton(getContext());
    this.HNA.setImageResource(2131231571);
    this.HNA.setScaleType(ImageView.ScaleType.CENTER);
    this.HNA.setBackgroundResource(0);
    this.HNA.setContentDescription(paramContext.getString(2131757250));
    fls();
    AppMethodBeat.o(34552);
  }
  
  public final void aaH(int paramInt)
  {
    AppMethodBeat.i(34554);
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.HNz.setClickable(bool);
      this.HNz.setEnabled(bool);
      if (j.fkV().size() <= 0) {
        break label97;
      }
      this.HNB.setClickable(bool);
      this.HNB.setEnabled(bool);
    }
    for (;;)
    {
      this.HNC.setClickable(bool);
      this.HNC.setEnabled(bool);
      this.HND.setClickable(bool);
      this.HND.setEnabled(bool);
      AppMethodBeat.o(34554);
      return;
      bool = false;
      break;
      label97:
      this.HNA.setClickable(bool);
      this.HNA.setEnabled(bool);
    }
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(34555);
    switch (paramInt)
    {
    default: 
      ac.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34555);
      return;
    case 2: 
      this.HNB.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 3: 
      this.HNC.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 1: 
      this.HNA.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 0: 
      this.HNz.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    }
    this.HND.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34555);
  }
  
  public final void fls()
  {
    AppMethodBeat.i(34553);
    removeAllViews();
    addView(this.HNz, this.trF);
    addView(this.HND, this.trF);
    addView(this.HNC, this.trF);
    addView(this.HNA, this.trF);
    AppMethodBeat.o(34553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar
 * JD-Core Version:    0.7.0.1
 */