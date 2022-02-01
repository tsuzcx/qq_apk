package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class MMImageButton
  extends FrameLayout
{
  private ImageView dxD;
  private TextView xdg;
  
  public MMImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(142026);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    this.dxD = new ImageView(paramContext);
    this.dxD.setLayoutParams(paramAttributeSet);
    addView(this.dxD);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    this.xdg = new TextView(paramContext);
    this.xdg.setLayoutParams(paramAttributeSet);
    this.xdg.setClickable(false);
    this.xdg.setFocusable(false);
    this.xdg.setFocusableInTouchMode(false);
    this.xdg.setTextColor(a.m(paramContext, 2131100651));
    addView(this.xdg);
    AppMethodBeat.o(142026);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(142031);
    super.setEnabled(paramBoolean);
    this.xdg.setEnabled(paramBoolean);
    this.dxD.setEnabled(paramBoolean);
    AppMethodBeat.o(142031);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142028);
    this.dxD.setImageDrawable(paramDrawable);
    this.dxD.setVisibility(0);
    this.xdg.setVisibility(8);
    AppMethodBeat.o(142028);
  }
  
  public void setImageRsource(int paramInt)
  {
    AppMethodBeat.i(142027);
    setImageDrawable(a.l(getContext(), paramInt));
    AppMethodBeat.o(142027);
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(142030);
    this.xdg.setText(paramInt);
    this.xdg.setVisibility(0);
    this.dxD.setVisibility(8);
    AppMethodBeat.o(142030);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(142029);
    this.xdg.setText(paramString);
    this.xdg.setVisibility(0);
    this.dxD.setVisibility(8);
    AppMethodBeat.o(142029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMImageButton
 * JD-Core Version:    0.7.0.1
 */