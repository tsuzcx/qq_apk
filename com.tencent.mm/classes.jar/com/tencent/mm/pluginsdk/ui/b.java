package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class b
  extends a
  implements e.a
{
  private float DmO;
  int[] DmP;
  Bitmap nyv;
  
  private b(String paramString)
  {
    super(a.b.eMA(), paramString);
    AppMethodBeat.i(152111);
    this.DmO = 0.5F;
    this.nyv = null;
    this.DmP = new int[2];
    AppMethodBeat.o(152111);
  }
  
  public b(String paramString, float paramFloat)
  {
    this(paramString);
    this.DmO = paramFloat;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    AppMethodBeat.i(152114);
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.DnQ > 1.0F) || (this.uNY))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, this.hfD);
    AppMethodBeat.o(152114);
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(152112);
    super.Af(paramString);
    AppMethodBeat.o(152112);
  }
  
  public final void WN(int paramInt)
  {
    AppMethodBeat.i(152115);
    this.hfD.setAlpha(paramInt);
    AppMethodBeat.o(152115);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(152113);
    String str = this.tag + "-" + this.DmO;
    com.tencent.mm.bx.a.a locala = a.a.Gik;
    if (locala != null) {
      localBitmap = a.a.Gik.ajM(str);
    }
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      a(paramCanvas, localBitmap);
      AppMethodBeat.o(152113);
      return;
    }
    if (this.DnM) {}
    for (localBitmap = this.vQR.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1); localBitmap != null; localBitmap = this.vQR.el(this.tag))
    {
      localBitmap = f.a(localBitmap, false, this.DmO * localBitmap.getWidth());
      if (locala != null) {
        locala.p(str, localBitmap);
      }
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label271;
      }
      a(paramCanvas, localBitmap);
      AppMethodBeat.o(152113);
      return;
    }
    if (((localBitmap != null) && (!localBitmap.isRecycled())) || (this.nyv == null)) {}
    try
    {
      this.nyv = BackwardSupportUtil.b.b(ai.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cc.a.getDensity(null));
      this.nyv = f.a(this.nyv, false, this.DmO * this.nyv.getWidth());
      localBitmap = this.nyv;
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        a(paramCanvas, localBitmap);
      }
      label271:
      AppMethodBeat.o(152113);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AvatarRoundDrawable", localIOException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b
 * JD-Core Version:    0.7.0.1
 */