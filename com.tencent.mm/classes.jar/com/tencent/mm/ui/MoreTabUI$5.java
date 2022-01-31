package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.at.a.d.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.preference.IconPreference;

final class MoreTabUI$5
  implements g
{
  MoreTabUI$5(MoreTabUI paramMoreTabUI, IconPreference paramIconPreference) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    AppMethodBeat.i(29696);
    if (paramb.bitmap != null)
    {
      al.d(new MoreTabUI.5.2(this, paramb.bitmap));
      AppMethodBeat.o(29696);
      return;
    }
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29694);
        MoreTabUI.5.this.zdv.ap(null);
        MoreTabUI.5.this.zdv.OP(8);
        AppMethodBeat.o(29694);
      }
    });
    AppMethodBeat.o(29696);
  }
  
  public final void tF(String paramString)
  {
    AppMethodBeat.i(29695);
    al.d(new MoreTabUI.5.1(this));
    AppMethodBeat.o(29695);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.5
 * JD-Core Version:    0.7.0.1
 */