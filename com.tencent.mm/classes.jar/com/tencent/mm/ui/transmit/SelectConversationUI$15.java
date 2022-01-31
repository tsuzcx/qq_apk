package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.bq.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.widget.b.c.a.b;

final class SelectConversationUI$15
  implements c.a.b
{
  SelectConversationUI$15(SelectConversationUI paramSelectConversationUI, j.b paramb) {}
  
  public final void byw()
  {
    AppMethodBeat.i(35139);
    Object localObject2 = p.H(this.iaj.url, "message");
    String str = p.H(this.iaj.fgv, "message");
    Object localObject1;
    if (at.isMobile(this.AAp.getContext()))
    {
      localObject1 = localObject2;
      if (str != null)
      {
        if (str.length() > 0) {
          break label117;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("showShare", false);
      d.b(this.AAp.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(35139);
      return;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 0) {}
      }
      else
      {
        label117:
        localObject1 = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI.15
 * JD-Core Version:    0.7.0.1
 */