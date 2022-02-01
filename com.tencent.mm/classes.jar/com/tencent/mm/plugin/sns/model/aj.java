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

public final class aj
  extends a
{
  int alpha;
  long zkO;
  boolean zkP;
  private Map<String, Boolean> zkQ;
  
  public aj(String paramString, n paramn, long paramLong)
  {
    super(paramString, paramn);
    AppMethodBeat.i(95854);
    this.zkP = false;
    this.alpha = 255;
    this.zkQ = new HashMap();
    if (paramLong != 0L)
    {
      this.zkO = paramLong;
      this.zkQ.put(paramString, Boolean.TRUE);
      this.zkP = true;
      AppMethodBeat.o(95854);
      return;
    }
    if (!this.zkQ.containsKey(paramString))
    {
      this.zkO = SystemClock.uptimeMillis();
      this.zkQ.put(paramString, Boolean.TRUE);
      this.zkP = true;
    }
    AppMethodBeat.o(95854);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(95855);
    Rect localRect = getBounds();
    Bitmap localBitmap = this.hxN.ayG();
    if (!q.I(localBitmap))
    {
      paramCanvas.drawColor(-1118482);
      this.zkO = 0L;
      AppMethodBeat.o(95855);
      return;
    }
    float f;
    if (this.zkP)
    {
      f = (float)(SystemClock.uptimeMillis() - this.zkO) / 150.0F;
      if (this.zkO == 0L) {
        f = 0.0F;
      }
      if (f >= 1.0F) {
        this.zkP = false;
      }
    }
    else
    {
      this.hxL.setAlpha(this.alpha);
      paramCanvas.drawBitmap(localBitmap, null, localRect, this.hxL);
      AppMethodBeat.o(95855);
      return;
    }
    int i = (int)(f * this.alpha);
    this.hxL.setAlpha(i);
    paramCanvas.drawBitmap(localBitmap, null, localRect, this.hxL);
    invalidateSelf();
    AppMethodBeat.o(95855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aj
 * JD-Core Version:    0.7.0.1
 */