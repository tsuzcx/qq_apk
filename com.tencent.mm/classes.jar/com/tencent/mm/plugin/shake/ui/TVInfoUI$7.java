package com.tencent.mm.plugin.shake.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.ui.base.preference.f;

final class TVInfoUI$7
  implements Runnable
{
  TVInfoUI$7(TVInfoUI paramTVInfoUI, String paramString, Bitmap paramBitmap) {}
  
  public final void run()
  {
    if ((TVInfoUI.e(this.odI) != null) && (TVInfoUI.e(this.odI).equals(this.mNE)))
    {
      if ((TVInfoUI.f(this.odI) != null) && (this.ara != null))
      {
        TVInfoUI.f(this.odI).setImageBitmap(this.ara);
        TVInfoUI.g(this.odI);
      }
      TVInfoUI.h(this.odI);
    }
    f localf = this.odI.dnn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVInfoUI.7
 * JD-Core Version:    0.7.0.1
 */