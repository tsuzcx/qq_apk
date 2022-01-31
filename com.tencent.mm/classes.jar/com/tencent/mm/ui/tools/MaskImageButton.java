package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.tencent.mm.sdk.platformtools.ah;

public class MaskImageButton
  extends ImageButton
{
  private int a = 90;
  private int b = 0;
  private int g = 0;
  private ah oNg = new ah(Looper.getMainLooper());
  private Runnable oNh = new MaskImageButton.1(this);
  private int r = 0;
  public Object wdF;
  
  public MaskImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnTouchListener(new MaskImageButton.2(this));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (isPressed()) {
      paramCanvas.drawARGB(this.a, this.r, this.g, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MaskImageButton
 * JD-Core Version:    0.7.0.1
 */