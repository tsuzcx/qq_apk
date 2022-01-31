package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public class TouchImageView
  extends ImageView
{
  private int a = 90;
  private int b = 0;
  private boolean bIU = true;
  private int g = 0;
  ah oNg;
  Runnable oNh;
  private Rect pkw = new Rect();
  private Paint pkx = new Paint();
  private int r = 0;
  
  public TouchImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    this.oNg = new ah();
    this.oNh = new TouchImageView.1(this);
    super.setOnTouchListener(new TouchImageView.2(this));
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    y.d("MicroMsg.MaskImageView", "onAttachedToWindow");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    y.d("MicroMsg.MaskImageView", "onDetachedFromWindow");
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (isPressed())
    {
      this.pkw.left = getPaddingLeft();
      this.pkw.top = getPaddingTop();
      this.pkw.right = (getWidth() - getPaddingRight());
      this.pkw.bottom = (getHeight() - getPaddingBottom());
      this.pkx.setARGB(this.a, this.r, this.g, this.b);
      paramCanvas.drawRect(this.pkw, this.pkx);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    Assert.assertTrue(false);
  }
  
  public void settouchEnable(boolean paramBoolean)
  {
    this.bIU = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TouchImageView
 * JD-Core Version:    0.7.0.1
 */