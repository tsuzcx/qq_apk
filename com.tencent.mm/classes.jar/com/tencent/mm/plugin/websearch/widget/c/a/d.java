package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.widget.c.c;
import com.tencent.mm.sdk.platformtools.ah;

public final class d
  implements a
{
  public final boolean agF(String paramString)
  {
    AppMethodBeat.i(91470);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(91470);
      return false;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(91470);
      return true;
    }
    AppMethodBeat.o(91470);
    return false;
  }
  
  public final boolean agG(String paramString)
  {
    AppMethodBeat.i(91472);
    if (!agF(paramString))
    {
      AppMethodBeat.o(91472);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("useJs", true);
    com.tencent.mm.bq.d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(91472);
    return true;
  }
  
  public final boolean nm(long paramLong)
  {
    AppMethodBeat.i(91471);
    boolean bool = c.J(paramLong, 0);
    AppMethodBeat.o(91471);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.d
 * JD-Core Version:    0.7.0.1
 */