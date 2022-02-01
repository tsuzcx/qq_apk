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
import com.tencent.mm.svg.b.d;

public final class c
  extends b
{
  private a VKF;
  
  public c(Picture paramPicture, int paramInt) {}
  
  public final void aI(Bitmap paramBitmap)
  {
    this.VKF.VKH = paramBitmap;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(148721);
    long l1 = com.tencent.mm.svg.b.b.hCr();
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
        if (this.VKF.VKG == null)
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", new Object[] { Integer.valueOf(this.VKw) });
          if (this.VKF.VKH == null) {
            break label522;
          }
          if (!this.VKF.VKH.isRecycled()) {
            break label361;
          }
          break label522;
          localObject4 = hCj();
          Object localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = a.I(this);
            hB((View)localObject1);
          }
          a.b((View)localObject1, this.VKy);
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
        if ((this.VKF.VKH != null) && (!this.VKF.VKH.isRecycled())) {
          continue;
        }
        if ((getIntrinsicWidth() > 2048) || (getIntrinsicHeight() > 2048))
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", new Object[] { Integer.valueOf(this.VKw) });
          continue;
        }
        if (getIntrinsicWidth() <= 0) {
          break label281;
        }
      }
      finally
      {
        this.mDuration = com.tencent.mm.svg.b.b.Vb(l1);
        d.hCt();
        B(paramCanvas);
        AppMethodBeat.o(148721);
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
        this.VKF.VKG.draw((Canvas)localObject4);
        this.VKF.VKH = ((Bitmap)localObject3);
        com.tencent.mm.svg.b.b.Vb(l2);
        d.hCs();
        B((Canvas)localObject4);
        continue;
        label361:
        hCh();
        paramCanvas.drawBitmap(this.VKF.VKH, null, this.KV, this.VKy);
        break label524;
        i = j;
        if (this.VKF.VKH != null)
        {
          i = j;
          if (!this.VKF.VKH.isRecycled())
          {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", new Object[] { this.VKF.VKH.toString() });
            this.VKF.VKH.recycle();
            this.VKF.VKH = null;
            i = j;
            continue;
            label462:
            localObject3 = this.VKF.VKG;
            if (localObject3 != null)
            {
              hCh();
              paramCanvas.save();
              paramCanvas.drawPicture((Picture)localObject3, this.KV);
              paramCanvas.restore();
            }
            label499:
            this.mDuration = com.tencent.mm.svg.b.b.Vb(l1);
            d.hCt();
            B(paramCanvas);
            AppMethodBeat.o(148721);
            return;
            i = 0;
          }
        }
      }
    }
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    return this.VKF;
  }
  
  public final Picture hCk()
  {
    return this.VKF.VKG;
  }
  
  public static final class a
    extends Drawable.ConstantState
  {
    protected int NHm;
    protected Picture VKG;
    protected Bitmap VKH;
    
    public a(Picture paramPicture, int paramInt)
    {
      this.VKG = paramPicture;
      this.NHm = paramInt;
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(148717);
      c localc = new c(this.VKG, this.NHm);
      AppMethodBeat.o(148717);
      return localc;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AppMethodBeat.i(148718);
      paramResources = newDrawable();
      AppMethodBeat.o(148718);
      return paramResources;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AppMethodBeat.i(148719);
      paramResources = newDrawable(paramResources);
      AppMethodBeat.o(148719);
      return paramResources;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.svg.a.c
 * JD-Core Version:    0.7.0.1
 */