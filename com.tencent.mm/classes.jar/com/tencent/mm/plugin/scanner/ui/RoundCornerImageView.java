package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mm.R.n;

public class RoundCornerImageView
  extends ImageView
{
  private int roundHeight = 8;
  private int roundWidth = 8;
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.RoundCornerImageView);
      this.roundWidth = paramContext.getDimensionPixelSize(R.n.RoundCornerImageView_roundWidth, this.roundWidth);
      this.roundHeight = paramContext.getDimensionPixelSize(R.n.RoundCornerImageView_roundHeight, this.roundHeight);
      paramContext.recycle();
      return;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.roundWidth = ((int)(this.roundWidth * f));
    this.roundHeight = ((int)(f * this.roundHeight));
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject3 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
    Object localObject2 = new Canvas((Bitmap)localObject3);
    Object localObject1 = localObject3;
    if (((Bitmap)localObject3).isRecycled())
    {
      localObject1 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
    }
    super.draw((Canvas)localObject2);
    localObject3 = new Paint();
    ((Paint)localObject3).setAntiAlias(true);
    ((Paint)localObject3).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.roundWidth, this.roundHeight, Path.Direction.CW);
    localPath.setFillType(Path.FillType.INVERSE_WINDING);
    ((Canvas)localObject2).drawPath(localPath, (Paint)localObject3);
    localObject2 = new Paint();
    ((Paint)localObject2).setXfermode(null);
    paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, (Paint)localObject2);
    ((Bitmap)localObject1).recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */