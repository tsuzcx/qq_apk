package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;

final class p$3
  implements p.b.a
{
  p$3(Context paramContext) {}
  
  public final void onClick(String paramString)
  {
    AppMethodBeat.i(245160);
    Log.i("MicroMsg.MMSpanManager", "click %s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(this.val$context, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(245160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.p.3
 * JD-Core Version:    0.7.0.1
 */