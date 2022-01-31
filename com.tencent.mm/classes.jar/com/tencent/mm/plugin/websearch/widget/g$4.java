package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

final class g$4
  implements b.a
{
  g$4(g paramg, b paramb, Bundle paramBundle, t paramt) {}
  
  public final void onResult(boolean paramBoolean, Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(146048);
    this.jxY.hide();
    paramObject2 = this.uMD;
    if (paramBoolean) {}
    for (paramObject1 = this.jxY.dPp();; paramObject1 = "-1")
    {
      paramObject2.putString("value", paramObject1);
      if (this.uMA != null) {
        this.uMA.b(paramBoolean, "", this.uMD);
      }
      AppMethodBeat.o(146048);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.g.4
 * JD-Core Version:    0.7.0.1
 */