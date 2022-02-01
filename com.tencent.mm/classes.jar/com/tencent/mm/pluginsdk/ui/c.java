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
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class c
  extends a
  implements e.a
{
  private float Kbf;
  private Paint Kbg;
  int[] Kbh;
  Bitmap pqA;
  
  private c(String paramString)
  {
    super(a.b.gov(), paramString);
    AppMethodBeat.i(152111);
    this.Kbf = 0.5F;
    this.pqA = null;
    this.Kbg = new Paint();
    this.Kbh = new int[2];
    AppMethodBeat.o(152111);
  }
  
  public c(String paramString, float paramFloat)
  {
    this(paramString);
    this.Kbf = paramFloat;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    AppMethodBeat.i(152114);
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.Kcj > 1.0F) || (this.zxm))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, this.iuG);
    AppMethodBeat.o(152114);
  }
  
  public final void Mr(String paramString)
  {
    AppMethodBeat.i(152112);
    super.Mr(paramString);
    AppMethodBeat.o(152112);
  }
  
  public final void aib(int paramInt)
  {
    AppMethodBeat.i(152115);
    this.iuG.setAlpha(paramInt);
    AppMethodBeat.o(152115);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject1 = null;
    AppMethodBeat.i(152113);
    String str = this.tag + "-" + this.Kbf;
    com.tencent.mm.bx.a.a locala = a.a.NAL;
    if (locala != null) {
      localObject1 = a.a.NAL.aCX(str);
    }
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      a(paramCanvas, (Bitmap)localObject1);
      if (this.pressed)
      {
        this.Kbg.setColor(-16777216);
        this.Kbg.setAlpha(76);
        this.Kbg.setAntiAlias(true);
        localObject1 = new RectF(getBounds());
        paramCanvas.drawRoundRect((RectF)localObject1, this.Kbf * ((RectF)localObject1).width(), this.Kbf * ((RectF)localObject1).height(), this.Kbg);
      }
      AppMethodBeat.o(152113);
      return;
    }
    if (this.Kcf)
    {
      localObject1 = this.Boe.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      label184:
      if (!(this.Boe instanceof j.b)) {
        break label401;
      }
    }
    label401:
    for (boolean bool = ((j.b)this.Boe).aub(this.tag);; bool = true) {
      for (;;)
      {
        if (localObject1 != null)
        {
          Object localObject2 = localObject1;
          if (bool) {
            localObject2 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, this.Kbf * ((Bitmap)localObject1).getWidth());
          }
          if (locala != null) {
            locala.p(str, (Bitmap)localObject2);
          }
          if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
            break;
          }
          a(paramCanvas, (Bitmap)localObject2);
          break;
          localObject1 = this.Boe.fZ(this.tag);
          break label184;
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
          break;
        }
        if (this.pqA == null) {}
        try
        {
          this.pqA = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
          this.pqA = BitmapUtil.getRoundedCornerBitmap(this.pqA, false, this.Kbf * this.pqA.getWidth());
          localObject1 = this.pqA;
          if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
            break;
          }
          a(paramCanvas, (Bitmap)localObject1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.AvatarRoundDrawable", localIOException, "", new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c
 * JD-Core Version:    0.7.0.1
 */