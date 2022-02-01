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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class ToolsBar
  extends LinearLayout
{
  private WeImageButton GnI;
  private WeImageButton GnM;
  private WeImageButton Grh;
  private LinearLayout.LayoutParams sjM;
  
  public ToolsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34960);
    setOrientation(0);
    setGravity(16);
    setBackground(ao.aC(getContext(), 2130969246));
    this.sjM = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131165567), 1.0F);
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
    this.Grh = new WeImageButton(getContext());
    this.Grh.setImageResource(2131231574);
    this.Grh.setScaleType(ImageView.ScaleType.CENTER);
    this.Grh.setBackgroundResource(0);
    this.Grh.setContentDescription(paramContext.getString(2131757251));
    removeAllViews();
    addView(this.GnI, this.sjM);
    addView(this.GnM, this.sjM);
    addView(this.Grh, this.sjM);
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
      this.GnI.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    case 1: 
      this.GnM.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(34961);
      return;
    }
    this.Grh.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(34961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ToolsBar
 * JD-Core Version:    0.7.0.1
 */