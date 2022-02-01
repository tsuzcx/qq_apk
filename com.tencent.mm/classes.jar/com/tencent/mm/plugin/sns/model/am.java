package com.tencent.mm.plugin.sns.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.b.a;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.r;
import java.util.HashMap;
import java.util.Map;

public final class am
  extends a
{
  long DMd;
  boolean DMe;
  private Map<String, Boolean> DMf;
  int alpha;
  
  public am(String paramString, n paramn, long paramLong)
  {
    super(paramString, paramn);
    AppMethodBeat.i(95854);
    this.DMe = false;
    this.alpha = 255;
    this.DMf = new HashMap();
    if (paramLong != 0L)
    {
      this.DMd = paramLong;
      this.DMf.put(paramString, Boolean.TRUE);
      this.DMe = true;
      AppMethodBeat.o(95854);
      return;
    }
    if (!this.DMf.containsKey(paramString))
    {
      this.DMd = SystemClock.uptimeMillis();
      this.DMf.put(paramString, Boolean.TRUE);
      this.DMe = true;
    }
    AppMethodBeat.o(95854);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(95855);
    Rect localRect = getBounds();
    Bitmap localBitmap = this.iuI.aSb();
    if (!r.M(localBitmap))
    {
      paramCanvas.drawColor(-1118482);
      this.DMd = 0L;
      AppMethodBeat.o(95855);
      return;
    }
    float f;
    if (this.DMe)
    {
      f = (float)(SystemClock.uptimeMillis() - this.DMd) / 150.0F;
      if (this.DMd == 0L) {
        f = 0.0F;
      }
      if (f >= 1.0F) {
        this.DMe = false;
      }
    }
    else
    {
      this.iuG.setAlpha(this.alpha);
      paramCanvas.drawBitmap(localBitmap, null, localRect, this.iuG);
      AppMethodBeat.o(95855);
      return;
    }
    int i = (int)(f * this.alpha);
    this.iuG.setAlpha(i);
    paramCanvas.drawBitmap(localBitmap, null, localRect, this.iuG);
    invalidateSelf();
    AppMethodBeat.o(95855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.am
 * JD-Core Version:    0.7.0.1
 */