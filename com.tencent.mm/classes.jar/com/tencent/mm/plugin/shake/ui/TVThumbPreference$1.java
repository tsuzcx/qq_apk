package com.tencent.mm.plugin.shake.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.f;

final class TVThumbPreference$1
  implements Runnable
{
  TVThumbPreference$1(TVThumbPreference paramTVThumbPreference, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(24936);
    TVThumbPreference.a(this.qRV).setImageBitmap(this.val$bitmap);
    if (TVThumbPreference.b(this.qRV) != null) {
      TVThumbPreference.b(this.qRV).notifyDataSetChanged();
    }
    AppMethodBeat.o(24936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVThumbPreference.1
 * JD-Core Version:    0.7.0.1
 */