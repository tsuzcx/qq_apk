package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private WeImageButton GnI;
  private WeImageButton GnJ;
  private WeImageButton GnK;
  private WeImageButton GnL;
  private WeImageButton GnM;
  private LinearLayout.LayoutParams sjM;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34552);
    setOrientation(0);
    setGravity(16);
    setBackground(ao.aC(getContext(), 2130969246));
    this.sjM = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165567), 1.0F);
    this.sjM.topMargin = a.fromDPToPix(getContext(), 0);
    this.GnI = new WeImageButton(getContext());
    this.GnI.setImageResource(2131231575);
    this.GnI.setScaleType(ImageView.ScaleType.CENTER);
    this.GnI.setBackgroundResource(0);
    this.GnI.setContentDescription(paramContext.getString(2131757252));
    this.GnM = new WeImageButton(getContext());
    this.GnM.setImageResource(2131231572);
    this.GnM.setScaleType(ImageView.ScaleType.CENTER);
    this.GnM.setBackgroundResource(0);
    this.GnM.setContentDescription(paramContext.getString(2131757251));
    this.GnL = new WeImageButton(getContext());
    this.GnL.setImageResource(2131231570);
    this.GnL.setScaleType(ImageView.ScaleType.CENTER);
    this.GnL.setBackgroundResource(0);
    this.GnL.setContentDescription(paramContext.getString(2131757249));
    this.GnK = new WeImageButton(getContext());
    this.GnK.setImageResource(2131231573);
    this.GnK.setScaleType(ImageView.ScaleType.CENTER);
    this.GnK.setBackgroundResource(0);
    this.GnK.setContentDescription(paramContext.getString(2131757248));
    this.GnJ = new WeImageButton(getContext());
    this.GnJ.setImageResource(2131231571);
    this.GnJ.setScaleType(ImageView.ScaleType.CENTER);
    this.GnJ.setBackgroundResource(0);
    this.GnJ.setContentDescription(paramContext.getString(2131757250));
    eVG();
    AppMethodBeat.o(34552);
  }
  
  public final void Yw(int paramInt)
  {
    AppMethodBeat.i(34554);
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.GnI.setClickable(bool);
      this.GnI.setEnabled(bool);
      if (j.eVj().size() <= 0) {
        break label97;
      }
      this.GnK.setClickable(bool);
      this.GnK.setEnabled(bool);
    }
    for (;;)
    {
      this.GnL.setClickable(bool);
      this.GnL.setEnabled(bool);
      this.GnM.setClickable(bool);
      this.GnM.setEnabled(bool);
      AppMethodBeat.o(34554);
      return;
      bool = false;
      break;
      label97:
      this.GnJ.setClickable(bool);
      this.GnJ.setEnabled(bool);
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
      this.GnK.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 3: 
      this.GnL.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 1: 
      this.GnJ.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 0: 
      this.GnI.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    }
    this.GnM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34555);
  }
  
  public final void eVG()
  {
    AppMethodBeat.i(34553);
    removeAllViews();
    addView(this.GnI, this.sjM);
    addView(this.GnM, this.sjM);
    addView(this.GnL, this.sjM);
    addView(this.GnJ, this.sjM);
    AppMethodBeat.o(34553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar
 * JD-Core Version:    0.7.0.1
 */