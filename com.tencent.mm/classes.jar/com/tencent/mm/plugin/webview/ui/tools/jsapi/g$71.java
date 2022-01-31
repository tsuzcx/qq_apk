package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.picker.a.a;
import java.util.HashMap;
import java.util.Map;

final class g$71
  implements a.a
{
  g$71(g paramg, i parami) {}
  
  public final void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.MsgHandler", "date set: %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramBoolean)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("selectTime", String.format("%d-%d-%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      g.a(this.rzi, this.rzk, "showDatePickerView:ok", localHashMap);
      return;
    }
    y.i("MicroMsg.MsgHandler", "cancel date set");
    g.a(this.rzi, this.rzk, "showDatePickerView:cancel", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.71
 * JD-Core Version:    0.7.0.1
 */