package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.t;
import java.util.HashMap;
import java.util.Map;

public final class am
  extends a
{
  long JZg;
  private Map<String, Boolean> JZh;
  int alpha;
  boolean animating;
  
  public am(String paramString, n paramn, long paramLong)
  {
    super(paramString, paramn);
    AppMethodBeat.i(95854);
    this.animating = false;
    this.alpha = 255;
    this.JZh = new HashMap();
    if (paramLong != 0L)
    {
      this.JZg = paramLong;
      this.JZh.put(paramString, Boolean.TRUE);
      this.animating = true;
      AppMethodBeat.o(95854);
      return;
    }
    if (!this.JZh.containsKey(paramString))
    {
      this.JZg = SystemClock.uptimeMillis();
      this.JZh.put(paramString, Boolean.TRUE);
      this.animating = true;
    }
    AppMethodBeat.o(95854);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(95855);
    Rect localRect = getBounds();
    Bitmap localBitmap = this.ljR.baW();
    if (!t.K(localBitmap))
    {
      paramCanvas.drawColor(-1118482);
      this.JZg = 0L;
      AppMethodBeat.o(95855);
      return;
    }
    float f;
    if (this.animating)
    {
      f = (float)(SystemClock.uptimeMillis() - this.JZg) / 150.0F;
      if (this.JZg == 0L) {
        f = 0.0F;
      }
      if (f >= 1.0F) {
        this.animating = false;
      }
    }
    else
    {
      this.ljP.setAlpha(this.alpha);
      paramCanvas.drawBitmap(localBitmap, null, localRect, this.ljP);
      AppMethodBeat.o(95855);
      return;
    }
    int i = (int)(f * this.alpha);
    this.ljP.setAlpha(i);
    paramCanvas.drawBitmap(localBitmap, null, localRect, this.ljP);
    invalidateSelf();
    AppMethodBeat.o(95855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.am
 * JD-Core Version:    0.7.0.1
 */