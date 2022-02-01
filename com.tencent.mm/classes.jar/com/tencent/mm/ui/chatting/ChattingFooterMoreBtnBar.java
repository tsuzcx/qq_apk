package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import java.util.List;

public class ChattingFooterMoreBtnBar
  extends LinearLayout
{
  private WeImageButton JWg;
  private WeImageButton JWh;
  private WeImageButton JWi;
  private WeImageButton JWj;
  private WeImageButton JWk;
  private LinearLayout.LayoutParams uBy;
  
  public ChattingFooterMoreBtnBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34552);
    setOrientation(0);
    setGravity(16);
    setBackground(aq.aM(getContext(), 2130969246));
    this.uBy = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165567), 1.0F);
    this.uBy.topMargin = a.fromDPToPix(getContext(), 0);
    this.JWg = new WeImageButton(getContext());
    this.JWg.setImageResource(2131231575);
    this.JWg.setScaleType(ImageView.ScaleType.CENTER);
    this.JWg.setBackgroundResource(0);
    this.JWg.setContentDescription(paramContext.getString(2131757252));
    this.JWk = new WeImageButton(getContext());
    this.JWk.setImageResource(2131231572);
    this.JWk.setScaleType(ImageView.ScaleType.CENTER);
    this.JWk.setBackgroundResource(0);
    this.JWk.setContentDescription(paramContext.getString(2131757251));
    this.JWj = new WeImageButton(getContext());
    this.JWj.setImageResource(2131231570);
    this.JWj.setScaleType(ImageView.ScaleType.CENTER);
    this.JWj.setBackgroundResource(0);
    this.JWj.setContentDescription(paramContext.getString(2131757249));
    this.JWi = new WeImageButton(getContext());
    this.JWi.setImageResource(2131231573);
    this.JWi.setScaleType(ImageView.ScaleType.CENTER);
    this.JWi.setBackgroundResource(0);
    this.JWi.setContentDescription(paramContext.getString(2131757248));
    this.JWh = new WeImageButton(getContext());
    this.JWh.setImageResource(2131231571);
    this.JWh.setScaleType(ImageView.ScaleType.CENTER);
    this.JWh.setBackgroundResource(0);
    this.JWh.setContentDescription(paramContext.getString(2131757250));
    fFK();
    AppMethodBeat.o(34552);
  }
  
  public final void adz(int paramInt)
  {
    AppMethodBeat.i(34554);
    boolean bool;
    if (paramInt > 0)
    {
      bool = true;
      this.JWg.setClickable(bool);
      this.JWg.setEnabled(bool);
      if (k.fFm().size() <= 0) {
        break label97;
      }
      this.JWi.setClickable(bool);
      this.JWi.setEnabled(bool);
    }
    for (;;)
    {
      this.JWj.setClickable(bool);
      this.JWj.setEnabled(bool);
      this.JWk.setClickable(bool);
      this.JWk.setEnabled(bool);
      AppMethodBeat.o(34554);
      return;
      bool = false;
      break;
      label97:
      this.JWh.setClickable(bool);
      this.JWh.setEnabled(bool);
    }
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(34555);
    switch (paramInt)
    {
    default: 
      ae.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34555);
      return;
    case 2: 
      this.JWi.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 3: 
      this.JWj.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 1: 
      this.JWh.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    case 0: 
      this.JWg.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34555);
      return;
    }
    this.JWk.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34555);
  }
  
  public final void fFK()
  {
    AppMethodBeat.i(34553);
    removeAllViews();
    addView(this.JWg, this.uBy);
    addView(this.JWk, this.uBy);
    addView(this.JWj, this.uBy);
    addView(this.JWh, this.uBy);
    AppMethodBeat.o(34553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar
 * JD-Core Version:    0.7.0.1
 */