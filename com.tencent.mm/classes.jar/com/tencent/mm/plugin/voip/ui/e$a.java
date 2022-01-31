package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class e$a
  implements Runnable
{
  public final void run()
  {
    y.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
    Bitmap localBitmap = e.H(this.pYP);
    this.pYP.hcZ.post(new e.a.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.a
 * JD-Core Version:    0.7.0.1
 */