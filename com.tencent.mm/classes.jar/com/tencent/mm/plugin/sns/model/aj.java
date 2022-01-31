package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import java.util.HashMap;
import java.util.Map;

public final class aj
  extends a
{
  int alpha;
  long nhl;
  boolean nhm;
  private Map<String, Boolean> rhV;
  
  public aj(String paramString, n paramn, long paramLong)
  {
    super(paramString, paramn);
    AppMethodBeat.i(36535);
    this.nhm = false;
    this.alpha = 255;
    this.rhV = new HashMap();
    if (paramLong != 0L)
    {
      this.nhl = paramLong;
      this.rhV.put(paramString, Boolean.TRUE);
      this.nhm = true;
      AppMethodBeat.o(36535);
      return;
    }
    if (!this.rhV.containsKey(paramString))
    {
      this.nhl = SystemClock.uptimeMillis();
      this.rhV.put(paramString, Boolean.TRUE);
      this.nhm = true;
    }
    AppMethodBeat.o(36535);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(36536);
    Rect localRect = getBounds();
    Bitmap localBitmap = this.feU.XT();
    if (!i.A(localBitmap))
    {
      paramCanvas.drawColor(-1118482);
      this.nhl = 0L;
      AppMethodBeat.o(36536);
      return;
    }
    float f;
    if (this.nhm)
    {
      f = (float)(SystemClock.uptimeMillis() - this.nhl) / 150.0F;
      if (this.nhl == 0L) {
        f = 0.0F;
      }
      if (f >= 1.0F) {
        this.nhm = false;
      }
    }
    else
    {
      this.feS.setAlpha(this.alpha);
      paramCanvas.drawBitmap(localBitmap, null, localRect, this.feS);
      AppMethodBeat.o(36536);
      return;
    }
    int i = (int)(f * this.alpha);
    this.feS.setAlpha(i);
    paramCanvas.drawBitmap(localBitmap, null, localRect, this.feS);
    invalidateSelf();
    AppMethodBeat.o(36536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj
 * JD-Core Version:    0.7.0.1
 */