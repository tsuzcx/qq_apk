package com.tencent.mm.plugin.websearch.widget.c.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.widget.c.c;
import com.tencent.mm.sdk.platformtools.aj;

public final class d
  implements a
{
  public final boolean avn(String paramString)
  {
    AppMethodBeat.i(116665);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(116665);
      return false;
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      AppMethodBeat.o(116665);
      return true;
    }
    AppMethodBeat.o(116665);
    return false;
  }
  
  public final boolean avo(String paramString)
  {
    AppMethodBeat.i(116667);
    if (!avn(paramString))
    {
      AppMethodBeat.o(116667);
      return false;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("useJs", true);
    com.tencent.mm.bs.d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(116667);
    return true;
  }
  
  public final boolean uX(long paramLong)
  {
    AppMethodBeat.i(116666);
    boolean bool = c.Z(paramLong, 0);
    AppMethodBeat.o(116666);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.a.d
 * JD-Core Version:    0.7.0.1
 */