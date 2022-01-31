package com.tencent.mm.plugin.shake.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.f;

final class TVThumbPreference$2
  implements Runnable
{
  TVThumbPreference$2(TVThumbPreference paramTVThumbPreference, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(24937);
    TVThumbPreference.c(this.qRV).setImageBitmap(this.val$bitmap);
    if (TVThumbPreference.b(this.qRV) != null) {
      TVThumbPreference.b(this.qRV).notifyDataSetChanged();
    }
    AppMethodBeat.o(24937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVThumbPreference.2
 * JD-Core Version:    0.7.0.1
 */