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
  private Map<String, Boolean> wIA;
  long wIy;
  boolean wIz;
  
  public ai(String paramString, n paramn, long paramLong)
  {
    super(paramString, paramn);
    AppMethodBeat.i(95854);
    this.wIz = false;
    this.alpha = 255;
    this.wIA = new HashMap();
    if (paramLong != 0L)
    {
      this.wIy = paramLong;
      this.wIA.put(paramString, Boolean.TRUE);
      this.wIz = true;
      AppMethodBeat.o(95854);
      return;
    }
    if (!this.wIA.containsKey(paramString))
    {
      this.wIy = SystemClock.uptimeMillis();
      this.wIA.put(paramString, Boolean.TRUE);
      this.wIz = true;
    }
    AppMethodBeat.o(95854);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(95855);
    Rect localRect = getBounds();
    Bitmap localBitmap = this.gFe.apc();
    if (!q.I(localBitmap))
    {
      paramCanvas.drawColor(-1118482);
      this.wIy = 0L;
      AppMethodBeat.o(95855);
      return;
    }
    float f;
    if (this.wIz)
    {
      f = (float)(SystemClock.uptimeMillis() - this.wIy) / 150.0F;
      if (this.wIy == 0L) {
        f = 0.0F;
      }
      if (f >= 1.0F) {
        this.wIz = false;
      }
    }
    else
    {
      this.gFc.setAlpha(this.alpha);
      paramCanvas.drawBitmap(localBitmap, null, localRect, this.gFc);
      AppMethodBeat.o(95855);
      return;
    }
    int i = (int)(f * this.alpha);
    this.gFc.setAlpha(i);
    paramCanvas.drawBitmap(localBitmap, null, localRect, this.gFc);
    invalidateSelf();
    AppMethodBeat.o(95855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ai
 * JD-Core Version:    0.7.0.1
 */