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
  private a OuH;
  
  public c(Picture paramPicture, int paramInt) {}
  
  public final void draw(Canvas paramCanvas)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(148721);
    long l1 = com.tencent.mm.svg.b.b.gFZ();
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
        if (this.OuH.OuI == null)
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "Must not go here! %s", new Object[] { Integer.valueOf(this.Ouy) });
          if (this.OuH.OuJ == null) {
            break label522;
          }
          if (!this.OuH.OuJ.isRecycled()) {
            break label361;
          }
          break label522;
          localObject4 = gFS();
          Object localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject1 = a.C(this);
            gr((View)localObject1);
          }
          a.b((View)localObject1, this.OuA);
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
        if ((this.OuH.OuJ != null) && (!this.OuH.OuJ.isRecycled())) {
          continue;
        }
        if ((getIntrinsicWidth() > 2048) || (getIntrinsicHeight() > 2048))
        {
          com.tencent.mm.svg.b.c.e("MicroMsg.SVGPictureDrawable", "This drawable is too big. %s", new Object[] { Integer.valueOf(this.Ouy) });
          continue;
        }
        if (getIntrinsicWidth() <= 0) {
          break label281;
        }
      }
      finally
      {
        this.mDuration = com.tencent.mm.svg.b.b.Nn(l1);
        d.gGb();
        y(paramCanvas);
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
        this.OuH.OuI.draw((Canvas)localObject4);
        this.OuH.OuJ = ((Bitmap)localObject3);
        com.tencent.mm.svg.b.b.Nn(l2);
        d.gGa();
        y((Canvas)localObject4);
        continue;
        label361:
        gFQ();
        paramCanvas.drawBitmap(this.OuH.OuJ, null, this.Ky, this.OuA);
        break label524;
        i = j;
        if (this.OuH.OuJ != null)
        {
          i = j;
          if (!this.OuH.OuJ.isRecycled())
          {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGPictureDrawable", "recycle bitmap:%s", new Object[] { this.OuH.OuJ.toString() });
            this.OuH.OuJ.recycle();
            this.OuH.OuJ = null;
            i = j;
            continue;
            label462:
            localObject3 = this.OuH.OuI;
            if (localObject3 != null)
            {
              gFQ();
              paramCanvas.save();
              paramCanvas.drawPicture((Picture)localObject3, this.Ky);
              paramCanvas.restore();
            }
            label499:
            this.mDuration = com.tencent.mm.svg.b.b.Nn(l1);
            d.gGb();
            y(paramCanvas);
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
    return this.OuH;
  }
  
  public static final class a
    extends Drawable.ConstantState
  {
    protected int GRb;
    protected Picture OuI;
    protected Bitmap OuJ;
    
    public a(Picture paramPicture, int paramInt)
    {
      this.OuI = paramPicture;
      this.GRb = paramInt;
    }
    
    public final int getChangingConfigurations()
    {
      return 0;
    }
    
    public final Drawable newDrawable()
    {
      AppMethodBeat.i(148717);
      c localc = new c(this.OuI, this.GRb);
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