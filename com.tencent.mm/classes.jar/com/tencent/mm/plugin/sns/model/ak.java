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

public final class ak
  extends a
{
  int alpha;
  long zCd;
  boolean zCe;
  private Map<String, Boolean> zCf;
  
  public ak(String paramString, n paramn, long paramLong)
  {
    super(paramString, paramn);
    AppMethodBeat.i(95854);
    this.zCe = false;
    this.alpha = 255;
    this.zCf = new HashMap();
    if (paramLong != 0L)
    {
      this.zCd = paramLong;
      this.zCf.put(paramString, Boolean.TRUE);
      this.zCe = true;
      AppMethodBeat.o(95854);
      return;
    }
    if (!this.zCf.containsKey(paramString))
    {
      this.zCd = SystemClock.uptimeMillis();
      this.zCf.put(paramString, Boolean.TRUE);
      this.zCe = true;
    }
    AppMethodBeat.o(95854);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(95855);
    Rect localRect = getBounds();
    Bitmap localBitmap = this.hAB.ayV();
    if (!r.J(localBitmap))
    {
      paramCanvas.drawColor(-1118482);
      this.zCd = 0L;
      AppMethodBeat.o(95855);
      return;
    }
    float f;
    if (this.zCe)
    {
      f = (float)(SystemClock.uptimeMillis() - this.zCd) / 150.0F;
      if (this.zCd == 0L) {
        f = 0.0F;
      }
      if (f >= 1.0F) {
        this.zCe = false;
      }
    }
    else
    {
      this.hAz.setAlpha(this.alpha);
      paramCanvas.drawBitmap(localBitmap, null, localRect, this.hAz);
      AppMethodBeat.o(95855);
      return;
    }
    int i = (int)(f * this.alpha);
    this.hAz.setAlpha(i);
    paramCanvas.drawBitmap(localBitmap, null, localRect, this.hAz);
    invalidateSelf();
    AppMethodBeat.o(95855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ak
 * JD-Core Version:    0.7.0.1
 */