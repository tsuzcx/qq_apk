package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.c.a.c;
import java.util.ArrayList;
import java.util.List;

final class g$1
  implements c.a.c
{
  g$1(View paramView, ArrayList paramArrayList, String paramString, List paramList) {}
  
  public final void dnx()
  {
    AppMethodBeat.i(27639);
    bo.hideVKB(this.vTo);
    if ((this.vTp.size() == 0) && (!bo.isNullOrNil(this.bZZ))) {
      g.a(this.vTp, this.hjF);
    }
    AppMethodBeat.o(27639);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.1
 * JD-Core Version:    0.7.0.1
 */