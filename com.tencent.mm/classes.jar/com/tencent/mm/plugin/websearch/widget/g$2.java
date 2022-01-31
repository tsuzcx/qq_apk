package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.ui.widget.picker.c.a;

final class g$2
  implements c.a
{
  g$2(g paramg, com.tencent.mm.ui.widget.picker.c paramc, Bundle paramBundle, t paramt) {}
  
  public final void d(boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.qXn;
    if (((com.tencent.mm.ui.widget.picker.c)localObject).vAB != null) {
      ((com.tencent.mm.ui.widget.picker.c)localObject).vAB.dismiss();
    }
    localObject = this.qXo;
    if (paramBoolean) {}
    for (paramObject = paramObject.toString();; paramObject = "")
    {
      ((Bundle)localObject).putString("value", paramObject);
      if (this.qXl != null) {
        this.qXl.b(paramBoolean, "", this.qXo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.g.2
 * JD-Core Version:    0.7.0.1
 */