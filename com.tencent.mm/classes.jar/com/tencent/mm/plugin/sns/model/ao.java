package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.m;
import com.tencent.mm.plugin.sns.data.t;
import java.util.HashMap;
import java.util.Map;

public final class ao
  extends a
{
  private Map<String, Boolean> Qwq;
  int alpha;
  boolean animating;
  long cmk;
  
  public ao(String paramString, m paramm, long paramLong)
  {
    super(paramString, paramm);
    AppMethodBeat.i(95854);
    this.animating = false;
    this.alpha = 255;
    this.Qwq = new HashMap();
    if (paramLong != 0L)
    {
      this.cmk = paramLong;
      this.Qwq.put(paramString, Boolean.TRUE);
      this.animating = true;
      AppMethodBeat.o(95854);
      return;
    }
    if (!this.Qwq.containsKey(paramString))
    {
      this.cmk = SystemClock.uptimeMillis();
      this.Qwq.put(paramString, Boolean.TRUE);
      this.animating = true;
    }
    AppMethodBeat.o(95854);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(95855);
    Rect localRect = getBounds();
    Bitmap localBitmap = this.nOC.bvR();
    if (!t.S(localBitmap))
    {
      paramCanvas.drawColor(-1118482);
      this.cmk = 0L;
      AppMethodBeat.o(95855);
      return;
    }
    float f;
    if (this.animating)
    {
      f = (float)(SystemClock.uptimeMillis() - this.cmk) / 150.0F;
      if (this.cmk == 0L) {
        f = 0.0F;
      }
      if (f >= 1.0F) {
        this.animating = false;
      }
    }
    else
    {
      this.nOA.setAlpha(this.alpha);
      paramCanvas.drawBitmap(localBitmap, null, localRect, this.nOA);
      AppMethodBeat.o(95855);
      return;
    }
    int i = (int)(f * this.alpha);
    this.nOA.setAlpha(i);
    paramCanvas.drawBitmap(localBitmap, null, localRect, this.nOA);
    invalidateSelf();
    AppMethodBeat.o(95855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ao
 * JD-Core Version:    0.7.0.1
 */