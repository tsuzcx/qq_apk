package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class ToolsBar
  extends LinearLayout
{
  private WeImageButton JBp;
  private WeImageButton JBt;
  private WeImageButton JEP;
  private LinearLayout.LayoutParams uqc;
  
  public ToolsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34960);
    setOrientation(0);
    setGravity(16);
    setBackground(aq.aM(getContext(), 2130969246));
    this.uqc = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165567), 1.0F);
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
    this.JEP = new WeImageButton(getContext());
    this.JEP.setImageResource(2131231574);
    this.JEP.setScaleType(ImageView.ScaleType.CENTER);
    this.JEP.setBackgroundResource(0);
    this.JEP.setContentDescription(paramContext.getString(2131757251));
    removeAllViews();
    addView(this.JBp, this.uqc);
    addView(this.JBt, this.uqc);
    addView(this.JEP, this.uqc);
    AppMethodBeat.o(34960);
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(34961);
    switch (paramInt)
    {
    default: 
      ad.w("MicroMsg.ToolsBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34961);
      return;
    case 0: 
      this.JBp.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    case 1: 
      this.JBt.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    }
    this.JEP.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ToolsBar
 * JD-Core Version:    0.7.0.1
 */