package com.tencent.mm.plugin.websearch.webview;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchUtils;", "", "()V", "Companion", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  private static final String TAG;
  public static final q.a Wsi;
  private static final int Wsj;
  private static final int Wsk;
  private static final int Wsl;
  private static final int Wsm;
  private static final int Wsn;
  
  static
  {
    AppMethodBeat.i(315309);
    Wsi = new q.a((byte)0);
    TAG = "MicroMsg.WebSearch.WebSearchUtils";
    Wsj = -1;
    Wsk = -2;
    Wsl = 1;
    Wsm = 2;
    Wsn = 3;
    AppMethodBeat.o(315309);
  }
  
  public static final void a(Context paramContext, q.a.a parama, String paramString)
  {
    AppMethodBeat.i(315231);
    q.a.a(paramContext, parama, paramString);
    AppMethodBeat.o(315231);
  }
  
  public static final void a(Context paramContext, q.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(315242);
    q.a.a(paramContext, parama, paramBoolean);
    AppMethodBeat.o(315242);
  }
  
  public static final boolean biO(String paramString)
  {
    AppMethodBeat.i(315219);
    boolean bool = q.a.biO(paramString);
    AppMethodBeat.o(315219);
    return bool;
  }
  
  public static final void d(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(315224);
    q.a.d(paramJSONObject, paramBoolean);
    AppMethodBeat.o(315224);
  }
  
  public static final void t(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(315250);
    q.a.t(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(315250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.q
 * JD-Core Version:    0.7.0.1
 */