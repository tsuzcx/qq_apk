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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.svg.b.d;

public final class c
  extends b
{
  private a ySd;
  
  public c(Picture paramPicture, int paramInt) {}
  
  public final void draw(Canvas paramCanvas)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(70093);
    long l1 = com.tencent.mm.svg.b.b.dAm();
    label388:
    label522:
    label524:
    for (;;)
    {
      Object localObject4;
      long l2;
      try
      {
        if (!paramCanvas.isHardwareAccelerated()) {
          break label388;
        }
        if (this.ySd.ySe == null)
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", new Object[] { Integer.valueOf(this.yRU) });
          if (this.ySd.ySf == null) {
            break label522;
          }
          if (!this.ySd.ySf.isRecycled()) {
            break label361;
          }
          break label522;
          localObject4 = dAf();
          Object localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = a.v(this);
            eJ((View)localObject1);
          }
          a.b((View)localObject1, this.yRW);
          if (i != 0) {
            break label499;
          }
          if ((!paramCanvas.isHardwareAccelerated()) || (Build.VERSION.SDK_INT >= 16)) {
            break label462;
          }
          com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "Skip this draw.", new Object[0]);
          return;
        }
        l2 = System.nanoTime();
        if ((this.ySd.ySf != null) && (!this.ySd.ySf.isRecycled())) {
          continue;
        }
        if ((getIntrinsicWidth() > 2048) || (getIntrinsicHeight() > 2048))
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", new Object[] { Integer.valueOf(this.yRU) });
          continue;
        }
        if (getIntrinsicWidth() <= 0) {
          break label281;
        }
      }
      finally
      {
        this.mDuration = com.tencent.mm.svg.b.b.ot(l1);
        d.dAo();
        m(paramCanvas);
        AppMethodBeat.o(70093);
      }
      if (getIntrinsicHeight() <= 0)
      {
        label281:
        com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "width and height must > 0.", new Object[0]);
      }
      else
      {
        Object localObject3 = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        localObject4 = new Canvas((Bitmap)localObject3);
        this.ySd.ySe.draw((Canvas)localObject4);
        this.ySd.ySf = ((Bitmap)localObject3);
        com.tencent.mm.svg.b.b.ot(l2);
        d.dAn();
        m((Canvas)localObject4);
        continue;
        label361:
        dAd();
        paramCanvas.drawBitmap(this.ySd.ySf, null, this.Bc, this.yRW);
        break label524;
        i = j;
        if (this.ySd.ySf != null)
        {
          i = j;
          if (!this.ySd.ySf.isRecycled())
          {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", new Object[] { this.ySd.ySf.toString() });
            this.ySd.ySf.recycle();
            this.ySd.ySf = null;
            i = j;
            continue;
            label462:
            localObject3 = this.ySd.ySe;
            if (localObject3 != null)
            {
              dAd();
              paramCanvas.save();
              paramCanvas.drawPicture((Picture)localObject3, this.Bc);
              paramCanvas.restore();
            }
            label499:
            this.mDuration = com.tencent.mm.svg.b.b.ot(l1);
            d.dAo();
            m(paramCanvas);
            AppMethodBeat.o(70093);
            return;
            i = 0;
          }
        }
      }
    }
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    return this.ySd;
  }
  
  public static final class a
    extends Drawable.ConstantState
  {
    protected int trq;
    protected Picture ySe;
    protected Bitmap ySf;
    
    public a(Picture paramPicture, int paramInt)
    {
      this.ySe = paramPicture;
      this.trq = paramInt;
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(70089);
      ab.i("MicroMsg.SVGPictureDrawable", "SVGPictureConstantState newDrawable %s", new Object[] { Integer.valueOf(this.trq) });
      c localc = new c(this.ySe, this.trq);
      AppMethodBeat.o(70089);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(70090);
      paramResources = newDrawable();
      AppMethodBeat.o(70090);
      return paramResources;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(70091);
      paramResources = newDrawable(paramResources);
      AppMethodBeat.o(70091);
      return paramResources;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.c
 * JD-Core Version:    0.7.0.1
 */