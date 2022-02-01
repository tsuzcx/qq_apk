package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"getUriStr", "", "plugin-webview_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final String bmM(String paramString)
  {
    AppMethodBeat.i(297619);
    s.u(paramString, "<this>");
    if (!n.U(paramString, "?", false))
    {
      paramString = s.X("?", paramString);
      AppMethodBeat.o(297619);
      return paramString;
    }
    AppMethodBeat.o(297619);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.aa
 * JD-Core Version:    0.7.0.1
 */