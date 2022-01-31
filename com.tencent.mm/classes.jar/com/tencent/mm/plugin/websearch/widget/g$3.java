package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import java.text.SimpleDateFormat;
import java.util.Date;

final class g$3
  implements a.a
{
  g$3(g paramg, a parama, SimpleDateFormat paramSimpleDateFormat, Bundle paramBundle, t paramt) {}
  
  public final void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(91453);
    this.udA.hide();
    Object localObject = new Date(paramInt1 - 1900, paramInt2 - 1, paramInt3);
    localObject = this.uME.format((Date)localObject);
    Bundle localBundle = this.uMD;
    if (paramBoolean) {}
    for (;;)
    {
      localBundle.putString("value", (String)localObject);
      if (this.uMA != null) {
        this.uMA.b(paramBoolean, "", this.uMD);
      }
      AppMethodBeat.o(91453);
      return;
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.g.3
 * JD-Core Version:    0.7.0.1
 */