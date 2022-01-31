package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

final class g$4
  implements b.a
{
  g$4(g paramg, b paramb, Bundle paramBundle, t paramt) {}
  
  public final void f(boolean paramBoolean, Object paramObject)
  {
    this.hEL.hide();
    Bundle localBundle = this.qXo;
    if (paramBoolean) {}
    for (paramObject = this.hEL.cKk();; paramObject = "-1")
    {
      localBundle.putString("value", paramObject);
      if (this.qXl != null) {
        this.qXl.b(paramBoolean, "", this.qXo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.g.4
 * JD-Core Version:    0.7.0.1
 */