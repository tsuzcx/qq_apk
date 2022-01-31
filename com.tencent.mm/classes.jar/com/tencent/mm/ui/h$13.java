package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;
import com.tencent.mm.h.a.gw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.preference.IconPreference;

final class h$13
  implements g
{
  h$13(h paramh, gw paramgw, IconPreference paramIconPreference, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    this.lgj.bOG.uC = 2;
    this.lgj.bOG.url = paramString;
    a.udP.m(this.lgj);
    if (paramb == null) {
      return;
    }
    int i = paramb.from;
    if ((paramb.status == 0) && (paramb.bitmap != null))
    {
      ai.d(new h.13.2(this, paramb.bitmap, i));
      return;
    }
    ai.d(new h.13.3(this, i));
  }
  
  public final void mv(String paramString)
  {
    ai.d(new h.13.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.h.13
 * JD-Core Version:    0.7.0.1
 */