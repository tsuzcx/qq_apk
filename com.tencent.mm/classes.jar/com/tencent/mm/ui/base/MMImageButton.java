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
  private TextView BaI;
  private ImageView dPk;
  
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
    this.dPk = new ImageView(paramContext);
    this.dPk.setLayoutParams(paramAttributeSet);
    addView(this.dPk);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    this.BaI = new TextView(paramContext);
    this.BaI.setLayoutParams(paramAttributeSet);
    this.BaI.setClickable(false);
    this.BaI.setFocusable(false);
    this.BaI.setFocusableInTouchMode(false);
    this.BaI.setTextColor(a.m(paramContext, 2131100821));
    addView(this.BaI);
    AppMethodBeat.o(142026);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(142031);
    super.setEnabled(paramBoolean);
    this.BaI.setEnabled(paramBoolean);
    this.dPk.setEnabled(paramBoolean);
    AppMethodBeat.o(142031);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142028);
    this.dPk.setImageDrawable(paramDrawable);
    this.dPk.setVisibility(0);
    this.BaI.setVisibility(8);
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
    this.BaI.setText(paramInt);
    this.BaI.setVisibility(0);
    this.dPk.setVisibility(8);
    AppMethodBeat.o(142030);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(142029);
    this.BaI.setText(paramString);
    this.BaI.setVisibility(0);
    this.dPk.setVisibility(8);
    AppMethodBeat.o(142029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMImageButton
 * JD-Core Version:    0.7.0.1
 */