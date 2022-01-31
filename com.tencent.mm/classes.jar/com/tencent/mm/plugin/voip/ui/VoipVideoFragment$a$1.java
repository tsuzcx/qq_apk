package com.tencent.mm.plugin.voip.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoipVideoFragment$a$1
  implements Runnable
{
  VoipVideoFragment$a$1(VoipVideoFragment.a parama, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(4897);
    if (this.tEs.tEo.tCv != null) {
      this.tEs.tEo.tCv.setBackgroundDrawable(new BitmapDrawable(this.tCE));
    }
    VoipVideoFragment.E(this.tEs.tEo);
    AppMethodBeat.o(4897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.a.1
 * JD-Core Version:    0.7.0.1
 */