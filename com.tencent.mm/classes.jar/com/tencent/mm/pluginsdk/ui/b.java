package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

public final class b
  extends a
  implements d.a
{
  Bitmap jVm;
  private float vPS;
  
  private b(String paramString)
  {
    super(a.b.dmT(), paramString);
    AppMethodBeat.i(79665);
    this.vPS = 0.5F;
    this.jVm = null;
    AppMethodBeat.o(79665);
  }
  
  public b(String paramString, float paramFloat)
  {
    this(paramString);
    this.vPS = paramFloat;
  }
  
  private void a(Canvas paramCanvas, Bitmap paramBitmap)
  {
    AppMethodBeat.i(79668);
    Rect localRect2 = getBounds();
    Rect localRect1 = null;
    if ((this.vQR > 1.0F) || (this.oKs))
    {
      int i = paramBitmap.getHeight() / 15 / 2;
      int j = paramBitmap.getWidth() / 15 / 2;
      localRect1 = new Rect(j, i, paramBitmap.getWidth() - j, paramBitmap.getHeight() - i);
    }
    paramCanvas.drawBitmap(paramBitmap, localRect1, localRect2, this.feS);
    AppMethodBeat.o(79668);
  }
  
  public final void LQ(int paramInt)
  {
    AppMethodBeat.i(138584);
    this.feS.setAlpha(paramInt);
    AppMethodBeat.o(138584);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(79667);
    String str = this.tag + "-" + this.vPS;
    com.tencent.mm.bx.a.a locala = a.a.yio;
    if (locala != null) {
      localBitmap = a.a.yio.RY(str);
    }
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      a(paramCanvas, localBitmap);
      AppMethodBeat.o(79667);
      return;
    }
    if (this.vQN) {}
    for (localBitmap = this.pFL.b(this.tag, paramCanvas.getWidth(), paramCanvas.getHeight(), 1); localBitmap != null; localBitmap = this.pFL.dt(this.tag))
    {
      localBitmap = d.a(localBitmap, false, this.vPS * localBitmap.getWidth());
      if (locala != null) {
        locala.p(str, localBitmap);
      }
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label271;
      }
      a(paramCanvas, localBitmap);
      AppMethodBeat.o(79667);
      return;
    }
    if (((localBitmap != null) && (!localBitmap.isRecycled())) || (this.jVm == null)) {}
    try
    {
      this.jVm = BackwardSupportUtil.b.b(ah.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.cb.a.getDensity(null));
      this.jVm = d.a(this.jVm, false, this.vPS * this.jVm.getWidth());
      localBitmap = this.jVm;
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        a(paramCanvas, localBitmap);
      }
      label271:
      AppMethodBeat.o(79667);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AvatarRoundDrawable", localIOException, "", new Object[0]);
      }
    }
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(79666);
    super.re(paramString);
    AppMethodBeat.o(79666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.b
 * JD-Core Version:    0.7.0.1
 */