package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class c
  extends a
{
  float XXQ;
  int[] XXR;
  Bitmap hkp;
  private Paint uqo;
  
  private c(String paramString)
  {
    super(a.b.iKa(), paramString);
    AppMethodBeat.i(152111);
    this.XXQ = 0.5F;
    this.hkp = null;
    this.uqo = new Paint();
    this.XXR = new int[2];
    AppMethodBeat.o(152111);
  }
  
  public c(String paramString, float paramFloat)
  {
    this(paramString);
    this.XXQ = paramFloat;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    AppMethodBeat.i(152114);
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.XYU > 1.0F) || (this.KYp))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, this.nOA);
    AppMethodBeat.o(152114);
  }
  
  public final void LM(String paramString)
  {
    AppMethodBeat.i(152112);
    super.LM(paramString);
    AppMethodBeat.o(152112);
  }
  
  public final void awg(int paramInt)
  {
    AppMethodBeat.i(152115);
    this.nOA.setAlpha(paramInt);
    AppMethodBeat.o(152115);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject1 = null;
    AppMethodBeat.i(152113);
    String str = this.tag + "-" + this.XXQ;
    com.tencent.mm.by.a.a locala = a.a.acjy;
    if (locala != null) {
      localObject1 = a.a.acjy.aKc(str);
    }
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      a(paramCanvas, (Bitmap)localObject1);
      if (this.aLn)
      {
        this.uqo.setColor(-16777216);
        this.uqo.setAlpha(76);
        this.uqo.setAntiAlias(true);
        localObject1 = new RectF(getBounds());
        paramCanvas.drawRoundRect((RectF)localObject1, this.XXQ * ((RectF)localObject1).width(), this.XXQ * ((RectF)localObject1).height(), this.uqo);
      }
      AppMethodBeat.o(152113);
      return;
    }
    if (this.XYQ)
    {
      localObject1 = this.Ngk.b(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      label184:
      if (!(this.Ngk instanceof j.b)) {
        break label401;
      }
    }
    label401:
    for (boolean bool = ((j.b)this.Ngk).ayI(this.tag);; bool = true) {
      for (;;)
      {
        if (localObject1 != null)
        {
          Object localObject2 = localObject1;
          if (bool) {
            localObject2 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, this.XXQ * ((Bitmap)localObject1).getWidth());
          }
          if (locala != null) {
            locala.p(str, (Bitmap)localObject2);
          }
          if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
            break;
          }
          a(paramCanvas, (Bitmap)localObject2);
          break;
          localObject1 = this.Ngk.loadBitmap(this.tag);
          break label184;
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
          break;
        }
        if (this.hkp == null) {}
        try
        {
          this.hkp = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null));
          this.hkp = BitmapUtil.getRoundedCornerBitmap(this.hkp, false, this.XXQ * this.hkp.getWidth());
          localObject1 = this.hkp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c
 * JD-Core Version:    0.7.0.1
 */