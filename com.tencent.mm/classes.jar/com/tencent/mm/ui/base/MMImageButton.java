package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;

public class MMImageButton
  extends FrameLayout
{
  private ImageView dkL;
  private TextView nyS;
  
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
    this.dkL = new ImageView(paramContext);
    this.dkL.setLayoutParams(paramAttributeSet);
    addView(this.dkL);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    this.nyS = new TextView(paramContext);
    this.nyS.setLayoutParams(paramAttributeSet);
    this.nyS.setClickable(false);
    this.nyS.setFocusable(false);
    this.nyS.setFocusableInTouchMode(false);
    this.nyS.setTextColor(a.m(paramContext, 2131100651));
    addView(this.nyS);
    AppMethodBeat.o(142026);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(142031);
    super.setEnabled(paramBoolean);
    this.nyS.setEnabled(paramBoolean);
    this.dkL.setEnabled(paramBoolean);
    AppMethodBeat.o(142031);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142028);
    this.dkL.setImageDrawable(paramDrawable);
    this.dkL.setVisibility(0);
    this.nyS.setVisibility(8);
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
    this.nyS.setText(paramInt);
    this.nyS.setVisibility(0);
    this.dkL.setVisibility(8);
    AppMethodBeat.o(142030);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(142029);
    this.nyS.setText(paramString);
    this.nyS.setVisibility(0);
    this.dkL.setVisibility(8);
    AppMethodBeat.o(142029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMImageButton
 * JD-Core Version:    0.7.0.1
 */