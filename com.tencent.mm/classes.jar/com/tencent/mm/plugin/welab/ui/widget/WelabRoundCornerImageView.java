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
  private float vvG;
  
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
    AppMethodBeat.i(80627);
    Object localObject = getDrawable();
    if ((localObject == null) || (!(localObject instanceof b)))
    {
      AppMethodBeat.o(80627);
      return null;
    }
    localObject = ((b)localObject).mBitmap;
    AppMethodBeat.o(80627);
    return localObject;
  }
  
  public void setCornerRadiusPercent(float paramFloat)
  {
    this.vvG = paramFloat;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(80626);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (paramBitmap.getWidth() < 0) || (paramBitmap.getHeight() < 0))
    {
      super.setImageBitmap(paramBitmap);
      AppMethodBeat.o(80626);
      return;
    }
    if (this.vvG <= 0.0F)
    {
      super.setImageBitmap(paramBitmap);
      AppMethodBeat.o(80626);
      return;
    }
    b localb = d.a(getResources(), paramBitmap);
    float f = Math.min(paramBitmap.getWidth() * this.vvG, paramBitmap.getHeight() * this.vvG);
    if (localb.kq != f)
    {
      localb.Bf = false;
      if (!b.r(f)) {
        break label147;
      }
      localb.mPaint.setShader(localb.Ba);
    }
    for (;;)
    {
      localb.kq = f;
      localb.invalidateSelf();
      super.setImageDrawable(localb);
      AppMethodBeat.o(80626);
      return;
      label147:
      localb.mPaint.setShader(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */