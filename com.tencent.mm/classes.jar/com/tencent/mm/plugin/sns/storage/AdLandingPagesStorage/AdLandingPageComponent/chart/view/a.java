package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;

public final class a
  extends View
{
  private c zBW;
  
  public a(Context paramContext, c paramc)
  {
    super(paramContext);
    this.zBW = paramc;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(96344);
    super.onDraw(paramCanvas);
    int k = getHeight();
    int i = getWidth();
    int j = (int)(Math.min(k, i) / 2.0F * 0.8D);
    i = (int)(i / 2.0F);
    k = (int)(k / 2.0F);
    Bitmap localBitmap = this.zBW.zBE;
    if (localBitmap != null)
    {
      j = (int)(j * 2 + this.zBW.zBF * 2.0F);
      int m = localBitmap.getWidth() * j / localBitmap.getHeight();
      paramCanvas.drawBitmap(Bitmap.createScaledBitmap(localBitmap, m, j, false), i - (m >>> 1), k - (j >>> 1), null);
    }
    AppMethodBeat.o(96344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.a
 * JD-Core Version:    0.7.0.1
 */