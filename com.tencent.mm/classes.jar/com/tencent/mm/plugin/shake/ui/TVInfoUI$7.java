package com.tencent.mm.plugin.shake.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TVInfoUI$7
  implements Runnable
{
  TVInfoUI$7(TVInfoUI paramTVInfoUI, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(24917);
    if ((TVInfoUI.e(this.qRP) != null) && (TVInfoUI.e(this.qRP).equals(this.pnT)))
    {
      if ((TVInfoUI.f(this.qRP) != null) && (this.val$bitmap != null))
      {
        TVInfoUI.f(this.qRP).setImageBitmap(this.val$bitmap);
        TVInfoUI.g(this.qRP);
      }
      TVInfoUI.h(this.qRP);
    }
    AppMethodBeat.o(24917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.7
 * JD-Core Version:    0.7.0.1
 */