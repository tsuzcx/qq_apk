package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.sdk.platformtools.y;

public class MaskLayout
  extends RelativeLayout
{
  private ImageView kiB;
  private Drawable uZB;
  private View view;
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaskLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.MaskLayout, paramInt, 0);
    this.uZB = paramContext.getDrawable(a.m.MaskLayout_foreground);
    paramContext.recycle();
  }
  
  private void a(MaskLayout.a parama)
  {
    removeView(this.kiB);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    switch (1.uZC[parama.ordinal()])
    {
    default: 
      localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    }
    for (;;)
    {
      addView(this.kiB, localLayoutParams1);
      return;
      localLayoutParams2.addRule(12);
      localLayoutParams2.addRule(11);
      localLayoutParams1 = localLayoutParams2;
      continue;
      localLayoutParams2.addRule(12);
      localLayoutParams2.addRule(9);
      localLayoutParams1 = localLayoutParams2;
      continue;
      localLayoutParams2.addRule(11);
      localLayoutParams1 = localLayoutParams2;
    }
  }
  
  public final void a(Bitmap paramBitmap, MaskLayout.a parama)
  {
    a(parama);
    this.kiB.setImageBitmap(paramBitmap);
  }
  
  public View getContentView()
  {
    return this.view;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.view = findViewById(a.g.content);
    if (this.view == null)
    {
      y.d("MicroMsg.MaskLayout", "%s", new Object[] { "not found view by id, new one" });
      this.view = new View(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      this.view.setLayoutParams(localLayoutParams);
      addView(this.view);
    }
    this.kiB = new ImageView(getContext());
    this.kiB.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.kiB.setImageDrawable(this.uZB);
    addView(this.kiB);
  }
  
  public void setMaskBitmap(Bitmap paramBitmap)
  {
    a(MaskLayout.a.uZH);
    this.kiB.setImageBitmap(paramBitmap);
  }
  
  public void setMaskDrawable(Drawable paramDrawable)
  {
    a(MaskLayout.a.uZH);
    this.kiB.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MaskLayout
 * JD-Core Version:    0.7.0.1
 */