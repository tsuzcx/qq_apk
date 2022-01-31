package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.cb.a;

public class MMImageButton
  extends FrameLayout
{
  private ImageView bQf;
  private TextView mTE;
  
  public MMImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    this.bQf = new ImageView(paramContext);
    this.bQf.setLayoutParams(paramAttributeSet);
    addView(this.bQf);
    paramAttributeSet = new FrameLayout.LayoutParams(-2, -2);
    paramAttributeSet.gravity = 17;
    this.mTE = new TextView(paramContext);
    this.mTE.setLayoutParams(paramAttributeSet);
    this.mTE.setClickable(false);
    this.mTE.setFocusable(false);
    this.mTE.setFocusableInTouchMode(false);
    this.mTE.setTextColor(a.h(paramContext, a.d.mm_title_btn_text));
    addView(this.mTE);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.mTE.setEnabled(paramBoolean);
    this.bQf.setEnabled(paramBoolean);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.bQf.setImageDrawable(paramDrawable);
    this.bQf.setVisibility(0);
    this.mTE.setVisibility(8);
  }
  
  public void setImageRsource(int paramInt)
  {
    setImageDrawable(a.g(getContext(), paramInt));
  }
  
  public void setText(int paramInt)
  {
    this.mTE.setText(paramInt);
    this.mTE.setVisibility(0);
    this.bQf.setVisibility(8);
  }
  
  public void setText(String paramString)
  {
    this.mTE.setText(paramString);
    this.mTE.setVisibility(0);
    this.bQf.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMImageButton
 * JD-Core Version:    0.7.0.1
 */