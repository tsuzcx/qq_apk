package com.tencent.mm.svg.a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends b
{
  private a uFu;
  
  public c(Picture paramPicture, int paramInt) {}
  
  public final void draw(Canvas paramCanvas)
  {
    int i = 1;
    int j = 0;
    long l1 = com.tencent.mm.svg.b.b.cxu();
    label260:
    label337:
    label475:
    label490:
    label492:
    for (;;)
    {
      Object localObject4;
      long l2;
      try
      {
        if (!paramCanvas.isHardwareAccelerated()) {
          break label364;
        }
        if (this.uFu.uFv == null)
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", new Object[] { Integer.valueOf(this.uFm) });
          if (this.uFu.uFw == null) {
            break label490;
          }
          if (!this.uFu.uFw.isRecycled()) {
            break label337;
          }
          break label490;
          localObject4 = cVu();
          Object localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = a.r(this);
            ev((View)localObject1);
          }
          a.b((View)localObject1, this.uFo);
          if (i != 0) {
            break label475;
          }
          if ((!paramCanvas.isHardwareAccelerated()) || (Build.VERSION.SDK_INT >= 16)) {
            break label438;
          }
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
          return;
        }
        l2 = System.nanoTime();
        if ((this.uFu.uFw != null) && (!this.uFu.uFw.isRecycled())) {
          continue;
        }
        if ((getIntrinsicWidth() > 2048) || (getIntrinsicHeight() > 2048))
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", new Object[] { Integer.valueOf(this.uFm) });
          continue;
        }
        if (getIntrinsicWidth() <= 0) {
          break label260;
        }
      }
      finally
      {
        this.mDuration = com.tencent.mm.svg.b.b.hJ(l1);
        m(paramCanvas);
      }
      if (getIntrinsicHeight() <= 0)
      {
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
      }
      else
      {
        Object localObject3 = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        localObject4 = new Canvas((Bitmap)localObject3);
        this.uFu.uFv.draw((Canvas)localObject4);
        this.uFu.uFw = ((Bitmap)localObject3);
        com.tencent.mm.svg.b.b.hJ(l2);
        m((Canvas)localObject4);
        continue;
        cxo();
        paramCanvas.drawBitmap(this.uFu.uFw, null, this.Aq, this.uFo);
        break label492;
        label364:
        i = j;
        if (this.uFu.uFw != null)
        {
          i = j;
          if (!this.uFu.uFw.isRecycled())
          {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", new Object[] { this.uFu.uFw.toString() });
            this.uFu.uFw.recycle();
            this.uFu.uFw = null;
            i = j;
            continue;
            localObject3 = this.uFu.uFv;
            if (localObject3 != null)
            {
              cxo();
              paramCanvas.save();
              paramCanvas.drawPicture((Picture)localObject3, this.Aq);
              paramCanvas.restore();
            }
            this.mDuration = com.tencent.mm.svg.b.b.hJ(l1);
            m(paramCanvas);
            return;
            i = 0;
          }
        }
      }
    }
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    return this.uFu;
  }
  
  public static final class a
    extends Drawable.ConstantState
  {
    protected int pLu;
    protected Picture uFv;
    protected Bitmap uFw;
    
    public a(Picture paramPicture, int paramInt)
    {
      this.uFv = paramPicture;
      this.pLu = paramInt;
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      y.i("MicroMsg.SVGPictureDrawable", "SVGPictureConstantState newDrawable %s", new Object[] { Integer.valueOf(this.pLu) });
      return new c(this.uFv, this.pLu);
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      return newDrawable();
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      return newDrawable(paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.c
 * JD-Core Version:    0.7.0.1
 */