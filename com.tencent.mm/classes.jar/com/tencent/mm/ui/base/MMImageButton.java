package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public class MMImageButton
  extends FrameLayout
{
  private ImageView dnd;
  private TextView mWt;
  
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
    this.dnd = new ImageView(paramContext);
    this.dnd.setLayoutParams(paramAttributeSet);
    addView(this.dnd);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    this.mWt = new TextView(paramContext);
    this.mWt.setLayoutParams(paramAttributeSet);
    this.mWt.setClickable(false);
    this.mWt.setFocusable(false);
    this.mWt.setFocusableInTouchMode(false);
    this.mWt.setTextColor(a.m(paramContext, 2131100651));
    addView(this.mWt);
    AppMethodBeat.o(142026);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(142031);
    super.setEnabled(paramBoolean);
    this.mWt.setEnabled(paramBoolean);
    this.dnd.setEnabled(paramBoolean);
    AppMethodBeat.o(142031);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(142028);
    this.dnd.setImageDrawable(paramDrawable);
    this.dnd.setVisibility(0);
    this.mWt.setVisibility(8);
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
    this.mWt.setText(paramInt);
    this.mWt.setVisibility(0);
    this.dnd.setVisibility(8);
    AppMethodBeat.o(142030);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(142029);
    this.mWt.setText(paramString);
    this.mWt.setVisibility(0);
    this.dnd.setVisibility(8);
    AppMethodBeat.o(142029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMImageButton
 * JD-Core Version:    0.7.0.1
 */