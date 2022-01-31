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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public class RoundCornerImageView
  extends ImageView
{
  private int qyr;
  private int qys;
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(81144);
    this.qyr = 8;
    this.qys = 8;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(81144);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(81143);
    this.qyr = 8;
    this.qys = 8;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(81143);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(81145);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.RoundCornerImageView);
      this.qyr = paramContext.getDimensionPixelSize(0, this.qyr);
      this.qys = paramContext.getDimensionPixelSize(1, this.qys);
      paramContext.recycle();
      AppMethodBeat.o(81145);
      return;
    }
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.qyr = ((int)(this.qyr * f));
    this.qys = ((int)(f * this.qys));
    AppMethodBeat.o(81145);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(81146);
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
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.qyr, this.qys, Path.Direction.CW);
    localPath.setFillType(Path.FillType.INVERSE_WINDING);
    ((Canvas)localObject2).drawPath(localPath, (Paint)localObject3);
    localObject2 = new Paint();
    ((Paint)localObject2).setXfermode(null);
    paramCanvas.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, (Paint)localObject2);
    ab.i("RoundCornerImageView", "bitmap recycle %s", new Object[] { localObject1.toString() });
    ((Bitmap)localObject1).recycle();
    AppMethodBeat.o(81146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */