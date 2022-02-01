package com.tencent.mm.plugin.welab.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.v4.graphics.drawable.b;
import android.support.v4.graphics.drawable.d;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WelabRoundCornerImageView
  extends ImageView
{
  private float BCo;
  
  public WelabRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WelabRoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public Bitmap getDisplayingBitmap()
  {
    AppMethodBeat.i(146297);
    Object localObject = getDrawable();
    if ((localObject == null) || (!(localObject instanceof b)))
    {
      AppMethodBeat.o(146297);
      return null;
    }
    localObject = ((b)localObject).mBitmap;
    AppMethodBeat.o(146297);
    return localObject;
  }
  
  public void setCornerRadiusPercent(float paramFloat)
  {
    this.BCo = paramFloat;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(146296);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramBitmap.getWidth() < 0) || (paramBitmap.getHeight() < 0))
    {
      super.setImageBitmap(paramBitmap);
      AppMethodBeat.o(146296);
      return;
    }
    if (this.BCo <= 0.0F)
    {
      super.setImageBitmap(paramBitmap);
      AppMethodBeat.o(146296);
      return;
    }
    b localb = d.a(getResources(), paramBitmap);
    float f = Math.min(paramBitmap.getWidth() * this.BCo, paramBitmap.getHeight() * this.BCo);
    if (localb.Hx != f)
    {
      localb.HB = false;
      if (!b.v(f)) {
        break label147;
      }
      localb.mPaint.setShader(localb.Hv);
    }
    for (;;)
    {
      localb.Hx = f;
      localb.invalidateSelf();
      super.setImageDrawable(localb);
      AppMethodBeat.o(146296);
      return;
      label147:
      localb.mPaint.setShader(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */