package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.h;
import java.io.IOException;

public final class c
  extends a
  implements e.a
{
  private float Fkn;
  private Paint Fko;
  int[] Fkp;
  Bitmap ofD;
  
  private c(String paramString)
  {
    super(a.b.ffl(), paramString);
    AppMethodBeat.i(152111);
    this.Fkn = 0.5F;
    this.ofD = null;
    this.Fko = new Paint();
    this.Fkp = new int[2];
    AppMethodBeat.o(152111);
  }
  
  public c(String paramString, float paramFloat)
  {
    this(paramString);
    this.Fkn = paramFloat;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    AppMethodBeat.i(152114);
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.Flq > 1.0F) || (this.wdl))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, this.hAz);
    AppMethodBeat.o(152114);
  }
  
  public final void DG(String paramString)
  {
    AppMethodBeat.i(152112);
    super.DG(paramString);
    AppMethodBeat.o(152112);
  }
  
  public final void Zp(int paramInt)
  {
    AppMethodBeat.i(152115);
    this.hAz.setAlpha(paramInt);
    AppMethodBeat.o(152115);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject1 = null;
    AppMethodBeat.i(152113);
    String str = this.tag + "-" + this.Fkn;
    com.tencent.mm.bx.a.a locala = a.a.InF;
    if (locala != null) {
      localObject1 = a.a.InF.apE(str);
    }
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      a(paramCanvas, (Bitmap)localObject1);
      if (this.pressed)
      {
        this.Fko.setColor(-16777216);
        this.Fko.setAlpha(76);
        this.Fko.setAntiAlias(true);
        localObject1 = new RectF(getBounds());
        paramCanvas.drawRoundRect((RectF)localObject1, this.Fkn * ((RectF)localObject1).width(), this.Fkn * ((RectF)localObject1).height(), this.Fko);
      }
      AppMethodBeat.o(152113);
      return;
    }
    if (this.Flm)
    {
      localObject1 = this.xnS.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      label184:
      if (!(this.xnS instanceof j.b)) {
        break label401;
      }
    }
    label401:
    for (boolean bool = ((j.b)this.xnS).ais(this.tag);; bool = true) {
      for (;;)
      {
        if (localObject1 != null)
        {
          Object localObject2 = localObject1;
          if (bool) {
            localObject2 = h.a((Bitmap)localObject1, false, this.Fkn * ((Bitmap)localObject1).getWidth());
          }
          if (locala != null) {
            locala.p(str, (Bitmap)localObject2);
          }
          if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
            break;
          }
          a(paramCanvas, (Bitmap)localObject2);
          break;
          localObject1 = this.xnS.fl(this.tag);
          break label184;
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
          break;
        }
        if (this.ofD == null) {}
        try
        {
          this.ofD = BackwardSupportUtil.b.b(ak.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
          this.ofD = h.a(this.ofD, false, this.Fkn * this.ofD.getWidth());
          localObject1 = this.ofD;
          if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
            break;
          }
          a(paramCanvas, (Bitmap)localObject1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.AvatarRoundDrawable", localIOException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c
 * JD-Core Version:    0.7.0.1
 */