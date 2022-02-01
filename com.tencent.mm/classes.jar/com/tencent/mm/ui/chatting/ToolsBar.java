package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class ToolsBar
  extends LinearLayout
{
  private WeImageButton JWg;
  private WeImageButton JWk;
  private WeImageButton JZG;
  private LinearLayout.LayoutParams uBy;
  
  public ToolsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34960);
    setOrientation(0);
    setGravity(16);
    setBackground(aq.aM(getContext(), 2130969246));
    this.uBy = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165567), 1.0F);
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
    this.JZG = new WeImageButton(getContext());
    this.JZG.setImageResource(2131231574);
    this.JZG.setScaleType(ImageView.ScaleType.CENTER);
    this.JZG.setBackgroundResource(0);
    this.JZG.setContentDescription(paramContext.getString(2131757251));
    removeAllViews();
    addView(this.JWg, this.uBy);
    addView(this.JWk, this.uBy);
    addView(this.JZG, this.uBy);
    AppMethodBeat.o(34960);
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(34961);
    switch (paramInt)
    {
    default: 
      ae.w("MicroMsg.ToolsBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34961);
      return;
    case 0: 
      this.JWg.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    case 1: 
      this.JWk.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    }
    this.JZG.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ToolsBar
 * JD-Core Version:    0.7.0.1
 */