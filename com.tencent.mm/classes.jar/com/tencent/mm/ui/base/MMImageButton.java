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
  private ImageView cxy;
  private TextView pvK;
  
  public MMImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106676);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    this.cxy = new ImageView(paramContext);
    this.cxy.setLayoutParams(paramAttributeSet);
    addView(this.cxy);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    this.pvK = new TextView(paramContext);
    this.pvK.setLayoutParams(paramAttributeSet);
    this.pvK.setClickable(false);
    this.pvK.setFocusable(false);
    this.pvK.setFocusableInTouchMode(false);
    this.pvK.setTextColor(a.l(paramContext, 2131690778));
    addView(this.pvK);
    AppMethodBeat.o(106676);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(106681);
    super.setEnabled(paramBoolean);
    this.pvK.setEnabled(paramBoolean);
    this.cxy.setEnabled(paramBoolean);
    AppMethodBeat.o(106681);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(106678);
    this.cxy.setImageDrawable(paramDrawable);
    this.cxy.setVisibility(0);
    this.pvK.setVisibility(8);
    AppMethodBeat.o(106678);
  }
  
  public void setImageRsource(int paramInt)
  {
    AppMethodBeat.i(106677);
    setImageDrawable(a.k(getContext(), paramInt));
    AppMethodBeat.o(106677);
  }
  
  public void setText(int paramInt)
  {
    AppMethodBeat.i(106680);
    this.pvK.setText(paramInt);
    this.pvK.setVisibility(0);
    this.cxy.setVisibility(8);
    AppMethodBeat.o(106680);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(106679);
    this.pvK.setText(paramString);
    this.pvK.setVisibility(0);
    this.cxy.setVisibility(8);
    AppMethodBeat.o(106679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMImageButton
 * JD-Core Version:    0.7.0.1
 */