package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class ToolsBar
  extends LinearLayout
{
  private LinearLayout.LayoutParams nAm;
  private ImageButton zCM;
  private ImageButton zyX;
  private ImageButton zzA;
  
  public ToolsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31072);
    setOrientation(0);
    setGravity(16);
    setBackgroundResource(2130838022);
    this.nAm = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(2131427853), 1.0F);
    this.zyX = new ImageButton(getContext());
    this.zyX.setImageResource(2130838239);
    this.zyX.setScaleType(ImageView.ScaleType.CENTER);
    this.zyX.setBackgroundResource(0);
    this.zyX.setContentDescription(paramContext.getString(2131298261));
    this.zzA = new ImageButton(getContext());
    this.zzA.setImageResource(2130838236);
    this.zzA.setScaleType(ImageView.ScaleType.CENTER);
    this.zzA.setBackgroundResource(0);
    this.zzA.setContentDescription(paramContext.getString(2131298260));
    this.zCM = new ImageButton(getContext());
    this.zCM.setImageResource(2130838238);
    this.zCM.setScaleType(ImageView.ScaleType.CENTER);
    this.zCM.setBackgroundResource(0);
    this.zCM.setContentDescription(paramContext.getString(2131298260));
    removeAllViews();
    addView(this.zyX, this.nAm);
    addView(this.zzA, this.nAm);
    addView(this.zCM, this.nAm);
    AppMethodBeat.o(31072);
  }
  
  public final void c(int paramInt, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(31073);
    switch (paramInt)
    {
    default: 
      ab.w("MicroMsg.ToolsBar", "set button listener error button index %d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(31073);
      return;
    case 0: 
      this.zyX.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(31073);
      return;
    case 1: 
      this.zzA.setOnClickListener(paramOnClickListener);
      AppMethodBeat.o(31073);
      return;
    }
    this.zCM.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(31073);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ToolsBar
 * JD-Core Version:    0.7.0.1
 */