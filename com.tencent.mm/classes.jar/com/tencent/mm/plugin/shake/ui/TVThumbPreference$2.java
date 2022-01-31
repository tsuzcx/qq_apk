package com.tencent.mm.plugin.shake.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.ui.base.preference.f;

final class TVThumbPreference$2
  implements Runnable
{
  TVThumbPreference$2(TVThumbPreference paramTVThumbPreference, Bitmap paramBitmap) {}
  
  public final void run()
  {
    TVThumbPreference.c(this.odO).setImageBitmap(this.ara);
    if (TVThumbPreference.b(this.odO) != null) {
      TVThumbPreference.b(this.odO).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVThumbPreference.2
 * JD-Core Version:    0.7.0.1
 */