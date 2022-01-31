package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.preference.IconPreference;

final class ac$5
  implements g
{
  ac$5(ac paramac, IconPreference paramIconPreference) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    if ((paramb.status == 0) && (paramb.bitmap != null))
    {
      ai.d(new ac.5.1(this, paramb.bitmap));
      return;
    }
    ai.d(new ac.5.2(this));
  }
  
  public final void mv(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.ac.5
 * JD-Core Version:    0.7.0.1
 */