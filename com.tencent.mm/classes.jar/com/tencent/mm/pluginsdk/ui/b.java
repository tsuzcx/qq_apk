package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;

public final class b
  extends a
  implements e.a
{
  private float BUy;
  int[] BUz;
  Bitmap mVW;
  
  private b(String paramString)
  {
    super(a.b.exg(), paramString);
    AppMethodBeat.i(152111);
    this.BUy = 0.5F;
    this.mVW = null;
    this.BUz = new int[2];
    AppMethodBeat.o(152111);
  }
  
  public b(String paramString, float paramFloat)
  {
    this(paramString);
    this.BUy = paramFloat;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    AppMethodBeat.i(152114);
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.BVz > 1.0F) || (this.tFD))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, this.gFc);
    AppMethodBeat.o(152114);
  }
  
  public final void UD(int paramInt)
  {
    AppMethodBeat.i(152115);
    this.gFc.setAlpha(paramInt);
    AppMethodBeat.o(152115);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(152113);
    String str = this.tag + "-" + this.BUy;
    com.tencent.mm.by.a.a locala = a.a.EKY;
    if (locala != null) {
      localBitmap = a.a.EKY.aeS(str);
    }
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      a(paramCanvas, localBitmap);
      AppMethodBeat.o(152113);
      return;
    }
    if (this.BVv) {}
    for (localBitmap = this.uIa.a(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1); localBitmap != null; localBitmap = this.uIa.ew(this.tag))
    {
      localBitmap = f.a(localBitmap, false, this.BUy * localBitmap.getWidth());
      if (locala != null) {
        locala.q(str, localBitmap);
      }
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label271;
      }
      a(paramCanvas, localBitmap);
      AppMethodBeat.o(152113);
      return;
    }
    if (((localBitmap != null) && (!localBitmap.isRecycled())) || (this.mVW == null)) {}
    try
    {
      this.mVW = BackwardSupportUtil.b.b(aj.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cd.a.getDensity(null));
      this.mVW = f.a(this.mVW, false, this.BUy * this.mVW.getWidth());
      localBitmap = this.mVW;
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
        ad.printErrStackTrace("MicroMsg.AvatarRoundDrawable", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(152112);
    super.vZ(paramString);
    AppMethodBeat.o(152112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b
 * JD-Core Version:    0.7.0.1
 */