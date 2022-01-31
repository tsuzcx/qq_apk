package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipBaseFragment$b$1
  implements Runnable
{
  VoipBaseFragment$b$1(VoipBaseFragment.b paramb, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(4846);
    if (this.tCG.tCD.tCw != null)
    {
      this.tCG.tCD.tCw.setBackgroundDrawable(new BitmapDrawable(this.tCE));
      this.tCG.tCD.tCw.getBackground().setAlpha(230);
      this.tCG.tCD.tCw.getBackground().setFilterBitmap(true);
    }
    VoipBaseFragment.b(this.tCG.tCD);
    AppMethodBeat.o(4846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.b.1
 * JD-Core Version:    0.7.0.1
 */