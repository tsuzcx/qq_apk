package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.preference.IconPreference;

final class ac$2
  implements g
{
  ac$2(ac paramac, IconPreference paramIconPreference) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    if (paramb.bitmap != null)
    {
      ai.d(new ac.2.2(this, paramb.bitmap));
      return;
    }
    ai.d(new ac.2.3(this));
  }
  
  public final void mv(String paramString)
  {
    ai.d(new ac.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ac.2
 * JD-Core Version:    0.7.0.1
 */