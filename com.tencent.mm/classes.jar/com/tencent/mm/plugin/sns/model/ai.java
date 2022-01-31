package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.mm.memory.a.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import java.util.HashMap;
import java.util.Map;

public final class ai
  extends a
{
  int alpha = 255;
  long kKK;
  boolean kKL = false;
  private Map<String, Boolean> otd = new HashMap();
  
  public ai(String paramString, n paramn, long paramLong)
  {
    super(paramString, paramn);
    if (paramLong != 0L)
    {
      this.kKK = paramLong;
      this.otd.put(paramString, Boolean.valueOf(true));
      this.kKL = true;
    }
    while (this.otd.containsKey(paramString)) {
      return;
    }
    this.kKK = SystemClock.uptimeMillis();
    this.otd.put(paramString, Boolean.valueOf(true));
    this.kKL = true;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    Bitmap localBitmap = this.dPv.Fe();
    if (!i.s(localBitmap))
    {
      paramCanvas.drawColor(-1118482);
      this.kKK = 0L;
      return;
    }
    float f;
    if (this.kKL)
    {
      f = (float)(SystemClock.uptimeMillis() - this.kKK) / 150.0F;
      if (this.kKK == 0L) {
        f = 0.0F;
      }
      if (f >= 1.0F) {
        this.kKL = false;
      }
    }
    else
    {
      dPt.setAlpha(this.alpha);
      paramCanvas.drawBitmap(localBitmap, null, localRect, dPt);
      return;
    }
    int i = (int)(f * this.alpha);
    dPt.setAlpha(i);
    paramCanvas.drawBitmap(localBitmap, null, localRect, dPt);
    invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ai
 * JD-Core Version:    0.7.0.1
 */