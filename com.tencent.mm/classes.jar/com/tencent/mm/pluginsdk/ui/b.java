package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class b
  extends i
  implements d.a
{
  Bitmap iez = null;
  private float rZb = 0.5F;
  
  private b(String paramString)
  {
    super(a.b.cmd(), paramString);
  }
  
  public b(String paramString, float paramFloat)
  {
    this(paramString);
    this.rZb = paramFloat;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.saa > 1.0F) || (this.mlm))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, dPt);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = null;
    com.tencent.mm.bx.a.a locala = a.a.uay;
    if (locala != null) {
      localBitmap = a.a.uay.Gv(this.tag);
    }
    if (localBitmap != null) {
      a(paramCanvas, localBitmap);
    }
    do
    {
      return;
      if (this.rZV) {}
      for (localBitmap = this.nav.b(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1); localBitmap != null; localBitmap = this.nav.ch(this.tag))
      {
        localBitmap = c.a(localBitmap, false, this.rZb * localBitmap.getWidth());
        if (locala != null) {
          locala.n(this.tag, localBitmap);
        }
        a(paramCanvas, localBitmap);
        return;
      }
    } while ((localBitmap != null) && (!localBitmap.isRecycled()));
    if (this.iez == null) {}
    try
    {
      this.iez = BackwardSupportUtil.b.a(ae.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      this.iez = c.a(this.iez, false, this.rZb * this.iez.getWidth());
      a(paramCanvas, this.iez);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AvatarRoundDrawable", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final void kk(String paramString)
  {
    super.kk(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b
 * JD-Core Version:    0.7.0.1
 */