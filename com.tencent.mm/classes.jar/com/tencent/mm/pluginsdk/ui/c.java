package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.g;
import java.io.IOException;

public final class c
  extends a
  implements e.a
{
  private float ERS;
  private Paint ERT;
  int[] ERU;
  Bitmap nZT;
  
  private c(String paramString)
  {
    super(a.b.fbx(), paramString);
    AppMethodBeat.i(152111);
    this.ERS = 0.5F;
    this.nZT = null;
    this.ERT = new Paint();
    this.ERU = new int[2];
    AppMethodBeat.o(152111);
  }
  
  public c(String paramString, float paramFloat)
  {
    this(paramString);
    this.ERS = paramFloat;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    AppMethodBeat.i(152114);
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.ESV > 1.0F) || (this.vRh))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, this.hxL);
    AppMethodBeat.o(152114);
  }
  
  public final void De(String paramString)
  {
    AppMethodBeat.i(152112);
    super.De(paramString);
    AppMethodBeat.o(152112);
  }
  
  public final void YJ(int paramInt)
  {
    AppMethodBeat.i(152115);
    this.hxL.setAlpha(paramInt);
    AppMethodBeat.o(152115);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject1 = null;
    AppMethodBeat.i(152113);
    String str = this.tag + "-" + this.ERS;
    com.tencent.mm.by.a.a locala = a.a.HTy;
    if (locala != null) {
      localObject1 = a.a.HTy.aoz(str);
    }
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      a(paramCanvas, (Bitmap)localObject1);
      if (this.pressed)
      {
        this.ERT.setColor(-16777216);
        this.ERT.setAlpha(76);
        this.ERT.setAntiAlias(true);
        localObject1 = new RectF(getBounds());
        paramCanvas.drawRoundRect((RectF)localObject1, this.ERS * ((RectF)localObject1).width(), this.ERS * ((RectF)localObject1).height(), this.ERT);
      }
      AppMethodBeat.o(152113);
      return;
    }
    if (this.ESR)
    {
      localObject1 = this.wYb.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      label184:
      if (!(this.wYb instanceof j.b)) {
        break label401;
      }
    }
    label401:
    for (boolean bool = ((j.b)this.wYb).ahv(this.tag);; bool = true) {
      for (;;)
      {
        if (localObject1 != null)
        {
          Object localObject2 = localObject1;
          if (bool) {
            localObject2 = g.a((Bitmap)localObject1, false, this.ERS * ((Bitmap)localObject1).getWidth());
          }
          if (locala != null) {
            locala.p(str, (Bitmap)localObject2);
          }
          if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
            break;
          }
          a(paramCanvas, (Bitmap)localObject2);
          break;
          localObject1 = this.wYb.fg(this.tag);
          break label184;
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
          break;
        }
        if (this.nZT == null) {}
        try
        {
          this.nZT = BackwardSupportUtil.b.b(aj.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
          this.nZT = g.a(this.nZT, false, this.ERS * this.nZT.getWidth());
          localObject1 = this.nZT;
          if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
            break;
          }
          a(paramCanvas, (Bitmap)localObject1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.AvatarRoundDrawable", localIOException, "", new Object[0]);
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