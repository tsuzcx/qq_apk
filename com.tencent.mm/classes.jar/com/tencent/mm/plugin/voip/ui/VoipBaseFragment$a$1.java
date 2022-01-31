package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipBaseFragment$a$1
  implements Runnable
{
  VoipBaseFragment$a$1(VoipBaseFragment.a parama, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(4844);
    if (this.tCF.tCD.tCv != null)
    {
      this.tCF.tCD.tCv.setBackgroundDrawable(new BitmapDrawable(this.tCE));
      this.tCF.tCD.tCv.getBackground().setAlpha(128);
    }
    VoipBaseFragment.a(this.tCF.tCD);
    AppMethodBeat.o(4844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipBaseFragment.a.1
 * JD-Core Version:    0.7.0.1
 */