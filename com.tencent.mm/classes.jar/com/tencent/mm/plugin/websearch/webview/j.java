package com.tencent.mm.plugin.websearch.webview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/websearch/webview/WebSearchUtils;", "", "()V", "Companion", "ui-websearch_release"})
public final class j
{
  private static final int PBD = -1;
  private static final int PBE = -2;
  private static final int PBF = 1;
  private static final int PBG = 2;
  private static final int PBH = 3;
  public static final j.a PBI;
  private static final String TAG = "MicroMsg.WebSearch.WebSearchUtils";
  
  static
  {
    AppMethodBeat.i(198201);
    PBI = new j.a((byte)0);
    TAG = "MicroMsg.WebSearch.WebSearchUtils";
    PBD = -1;
    PBE = -2;
    PBF = 1;
    PBG = 2;
    PBH = 3;
    AppMethodBeat.o(198201);
  }
  
  public static final boolean bjd(String paramString)
  {
    AppMethodBeat.i(198205);
    boolean bool = j.a.bjd(paramString);
    AppMethodBeat.o(198205);
    return bool;
  }
  
  public static final void d(JSONObject paramJSONObject, boolean paramBoolean)
  {
    AppMethodBeat.i(198207);
    j.a.d(paramJSONObject, paramBoolean);
    AppMethodBeat.o(198207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.webview.j
 * JD-Core Version:    0.7.0.1
 */