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
  private a FDN;
  
  public c(Picture paramPicture, int paramInt) {}
  
  public final void draw(Canvas paramCanvas)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(148721);
    long l1 = com.tencent.mm.svg.b.b.eOy();
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
        if (this.FDN.FDO == null)
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", new Object[] { Integer.valueOf(this.FDE) });
          if (this.FDN.FDP == null) {
            break label522;
          }
          if (!this.FDN.FDP.isRecycled()) {
            break label361;
          }
          break label522;
          localObject4 = eOr();
          Object localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = a.C(this);
            fA((View)localObject1);
          }
          a.b((View)localObject1, this.FDG);
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
        if ((this.FDN.FDP != null) && (!this.FDN.FDP.isRecycled())) {
          continue;
        }
        if ((getIntrinsicWidth() > 2048) || (getIntrinsicHeight() > 2048))
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", new Object[] { Integer.valueOf(this.FDE) });
          continue;
        }
        if (getIntrinsicWidth() <= 0) {
          break label281;
        }
      }
      finally
      {
        this.mDuration = com.tencent.mm.svg.b.b.wr(l1);
        d.eOA();
        p(paramCanvas);
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
        this.FDN.FDO.draw((Canvas)localObject4);
        this.FDN.FDP = ((Bitmap)localObject3);
        com.tencent.mm.svg.b.b.wr(l2);
        d.eOz();
        p((Canvas)localObject4);
        continue;
        label361:
        eOp();
        paramCanvas.drawBitmap(this.FDN.FDP, null, this.Hy, this.FDG);
        break label524;
        i = j;
        if (this.FDN.FDP != null)
        {
          i = j;
          if (!this.FDN.FDP.isRecycled())
          {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", new Object[] { this.FDN.FDP.toString() });
            this.FDN.FDP.recycle();
            this.FDN.FDP = null;
            i = j;
            continue;
            label462:
            localObject3 = this.FDN.FDO;
            if (localObject3 != null)
            {
              eOp();
              paramCanvas.save();
              paramCanvas.drawPicture((Picture)localObject3, this.Hy);
              paramCanvas.restore();
            }
            label499:
            this.mDuration = com.tencent.mm.svg.b.b.wr(l1);
            d.eOA();
            p(paramCanvas);
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
    return this.FDN;
  }
  
  public static final class a
    extends Drawable.ConstantState
  {
    protected Picture FDO;
    protected Bitmap FDP;
    protected int zdA;
    
    public a(Picture paramPicture, int paramInt)
    {
      this.FDO = paramPicture;
      this.zdA = paramInt;
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(148717);
      c localc = new c(this.FDO, this.zdA);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.svg.a.c
 * JD-Core Version:    0.7.0.1
 */