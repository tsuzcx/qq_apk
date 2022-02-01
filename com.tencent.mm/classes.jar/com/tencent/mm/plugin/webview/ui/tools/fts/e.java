package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.d;

public final class e
{
  d PCW;
  
  public e(d paramd)
  {
    this.PCW = paramd;
  }
  
  public final void bf(Bundle paramBundle)
  {
    AppMethodBeat.i(80799);
    paramBundle = (String)paramBundle.get("widgetId");
    this.PCW.biJ(paramBundle);
    AppMethodBeat.o(80799);
  }
  
  public final void bg(Bundle paramBundle)
  {
    AppMethodBeat.i(80800);
    paramBundle = paramBundle.getString("fts_key_widget_view_cache_key");
    this.PCW.biK(paramBundle);
    AppMethodBeat.o(80800);
  }
  
  public final void bh(Bundle paramBundle)
  {
    AppMethodBeat.i(80801);
    String str = paramBundle.getString("fts_key_json_data");
    paramBundle = paramBundle.getString("fts_key_widget_view_cache_key");
    this.PCW.mf(str, paramBundle);
    AppMethodBeat.o(80801);
  }
  
  public final void c(Bundle paramBundle, int paramInt)
  {
    AppMethodBeat.i(80798);
    String str1 = paramBundle.getString("fts_key_json_data");
    String str2 = paramBundle.getString("fts_key_widget_view_cache_key");
    this.PCW.s(str1, str2, paramBundle.getInt("websearch_is_test_draw_json"), paramInt);
    AppMethodBeat.o(80798);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(80802);
    this.PCW.onDestroy();
    AppMethodBeat.o(80802);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(80797);
    this.PCW.onPause();
    AppMethodBeat.o(80797);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(80796);
    this.PCW.onResume();
    AppMethodBeat.o(80796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.e
 * JD-Core Version:    0.7.0.1
 */