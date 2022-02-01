package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.q;
import java.util.HashMap;
import java.util.Map;

public final class ai
  extends a
{
  int alpha;
  long xUT;
  boolean xUU;
  private Map<String, Boolean> xUV;
  
  public ai(String paramString, n paramn, long paramLong)
  {
    super(paramString, paramn);
    AppMethodBeat.i(95854);
    this.xUU = false;
    this.alpha = 255;
    this.xUV = new HashMap();
    if (paramLong != 0L)
    {
      this.xUT = paramLong;
      this.xUV.put(paramString, Boolean.TRUE);
      this.xUU = true;
      AppMethodBeat.o(95854);
      return;
    }
    if (!this.xUV.containsKey(paramString))
    {
      this.xUT = SystemClock.uptimeMillis();
      this.xUV.put(paramString, Boolean.TRUE);
      this.xUU = true;
    }
    AppMethodBeat.o(95854);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(95855);
    Rect localRect = getBounds();
    Bitmap localBitmap = this.hfF.avT();
    if (!q.I(localBitmap))
    {
      paramCanvas.drawColor(-1118482);
      this.xUT = 0L;
      AppMethodBeat.o(95855);
      return;
    }
    float f;
    if (this.xUU)
    {
      f = (float)(SystemClock.uptimeMillis() - this.xUT) / 150.0F;
      if (this.xUT == 0L) {
        f = 0.0F;
      }
      if (f >= 1.0F) {
        this.xUU = false;
      }
    }
    else
    {
      this.hfD.setAlpha(this.alpha);
      paramCanvas.drawBitmap(localBitmap, null, localRect, this.hfD);
      AppMethodBeat.o(95855);
      return;
    }
    int i = (int)(f * this.alpha);
    this.hfD.setAlpha(i);
    paramCanvas.drawBitmap(localBitmap, null, localRect, this.hfD);
    invalidateSelf();
    AppMethodBeat.o(95855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ai
 * JD-Core Version:    0.7.0.1
 */