package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class ToolsBar
  extends LinearLayout
{
  private WeImageButton HND;
  private WeImageButton HNz;
  private WeImageButton HQZ;
  private LinearLayout.LayoutParams trF;
  
  public ToolsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34960);
    setOrientation(0);
    setGravity(16);
    setBackground(ao.aI(getContext(), 2130969246));
    this.trF = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165567), 1.0F);
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
    this.HQZ = new WeImageButton(getContext());
    this.HQZ.setImageResource(2131231574);
    this.HQZ.setScaleType(ImageView.ScaleType.CENTER);
    this.HQZ.setBackgroundResource(0);
    this.HQZ.setContentDescription(paramContext.getString(2131757251));
    removeAllViews();
    addView(this.HNz, this.trF);
    addView(this.HND, this.trF);
    addView(this.HQZ, this.trF);
    AppMethodBeat.o(34960);
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(34961);
    switch (paramInt)
    {
    default: 
      ac.w("MicroMsg.ToolsBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34961);
      return;
    case 0: 
      this.HNz.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    case 1: 
      this.HND.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    }
    this.HQZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ToolsBar
 * JD-Core Version:    0.7.0.1
 */