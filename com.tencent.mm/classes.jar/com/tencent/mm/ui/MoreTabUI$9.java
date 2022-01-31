package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.preference.IconPreference;

final class MoreTabUI$9
  implements g
{
  MoreTabUI$9(MoreTabUI paramMoreTabUI, IconPreference paramIconPreference) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(29702);
    if ((paramb.status == 0) && (paramb.bitmap != null))
    {
      al.d(new MoreTabUI.9.1(this, paramb.bitmap));
      AppMethodBeat.o(29702);
      return;
    }
    al.d(new MoreTabUI.9.2(this));
    AppMethodBeat.o(29702);
  }
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.9
 * JD-Core Version:    0.7.0.1
 */