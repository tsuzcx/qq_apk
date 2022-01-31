package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.ui.widget.picker.a.a;
import java.text.SimpleDateFormat;
import java.util.Date;

final class g$3
  implements a.a
{
  g$3(g paramg, a parama, SimpleDateFormat paramSimpleDateFormat, Bundle paramBundle, t paramt) {}
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.qCo.hide();
    Object localObject = new Date(paramInt1 - 1900, paramInt2 - 1, paramInt3);
    localObject = this.qXp.format((Date)localObject);
    Bundle localBundle = this.qXo;
    if (paramBoolean) {}
    for (;;)
    {
      localBundle.putString("value", (String)localObject);
      if (this.qXl != null) {
        this.qXl.b(paramBoolean, "", this.qXo);
      }
      return;
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.g.3
 * JD-Core Version:    0.7.0.1
 */