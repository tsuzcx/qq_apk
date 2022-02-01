package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class c
  extends a
{
  private float RbK;
  private Paint RbL;
  int[] RbM;
  Bitmap fgf;
  
  private c(String paramString)
  {
    super(a.b.hjf(), paramString);
    AppMethodBeat.i(152111);
    this.RbK = 0.5F;
    this.fgf = null;
    this.RbL = new Paint();
    this.RbM = new int[2];
    AppMethodBeat.o(152111);
  }
  
  public c(String paramString, float paramFloat)
  {
    this(paramString);
    this.RbK = paramFloat;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    AppMethodBeat.i(152114);
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.RcO > 1.0F) || (this.FcG))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, this.ljP);
    AppMethodBeat.o(152114);
  }
  
  public final void TM(String paramString)
  {
    AppMethodBeat.i(152112);
    super.TM(paramString);
    AppMethodBeat.o(152112);
  }
  
  public final void aqc(int paramInt)
  {
    AppMethodBeat.i(152115);
    this.ljP.setAlpha(paramInt);
    AppMethodBeat.o(152115);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject1 = null;
    AppMethodBeat.i(152113);
    String str = this.tag + "-" + this.RbK;
    com.tencent.mm.ce.a.a locala = a.a.UOn;
    if (locala != null) {
      localObject1 = a.a.UOn.aNh(str);
    }
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      a(paramCanvas, (Bitmap)localObject1);
      if (this.RbI)
      {
        this.RbL.setColor(-16777216);
        this.RbL.setAlpha(76);
        this.RbL.setAntiAlias(true);
        localObject1 = new RectF(getBounds());
        paramCanvas.drawRoundRect((RectF)localObject1, this.RbK * ((RectF)localObject1).width(), this.RbK * ((RectF)localObject1).height(), this.RbL);
      }
      AppMethodBeat.o(152113);
      return;
    }
    if (this.RcK)
    {
      localObject1 = this.Hix.b(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1);
      label184:
      if (!(this.Hix instanceof j.b)) {
        break label401;
      }
    }
    label401:
    for (boolean bool = ((j.b)this.Hix).aDn(this.tag);; bool = true) {
      for (;;)
      {
        if (localObject1 != null)
        {
          Object localObject2 = localObject1;
          if (bool) {
            localObject2 = BitmapUtil.getRoundedCornerBitmap((Bitmap)localObject1, false, this.RbK * ((Bitmap)localObject1).getWidth());
          }
          if (locala != null) {
            locala.p(str, (Bitmap)localObject2);
          }
          if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
            break;
          }
          a(paramCanvas, (Bitmap)localObject2);
          break;
          localObject1 = this.Hix.gJ(this.tag);
          break label184;
        }
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
          break;
        }
        if (this.fgf == null) {}
        try
        {
          this.fgf = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.ci.a.getDensity(null));
          this.fgf = BitmapUtil.getRoundedCornerBitmap(this.fgf, false, this.RbK * this.fgf.getWidth());
          localObject1 = this.fgf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.c
 * JD-Core Version:    0.7.0.1
 */