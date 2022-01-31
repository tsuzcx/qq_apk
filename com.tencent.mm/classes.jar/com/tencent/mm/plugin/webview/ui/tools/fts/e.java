package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.mm.plugin.websearch.api.f;

public final class e
{
  f qXH;
  
  public e(f paramf)
  {
    this.qXH = paramf;
  }
  
  public final void aa(Bundle paramBundle)
  {
    paramBundle = (String)paramBundle.get("widgetId");
    this.qXH.Ro(paramBundle);
  }
  
  public final void ab(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("fts_key_widget_view_cache_key");
    this.qXH.Rp(paramBundle);
  }
  
  public final void ac(Bundle paramBundle)
  {
    String str = paramBundle.getString("fts_key_json_data");
    paramBundle = paramBundle.getString("fts_key_widget_view_cache_key");
    this.qXH.fn(str, paramBundle);
  }
  
  public final void b(Bundle paramBundle, int paramInt)
  {
    String str1 = paramBundle.getString("fts_key_json_data");
    String str2 = paramBundle.getString("fts_key_widget_view_cache_key");
    this.qXH.n(str1, str2, paramBundle.getInt("websearch_is_test_draw_json"), paramInt);
  }
  
  public final void onDestroy()
  {
    this.qXH.onDestroy();
  }
  
  public final void onPause()
  {
    this.qXH.onPause();
  }
  
  public final void onResume()
  {
    this.qXH.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.e
 * JD-Core Version:    0.7.0.1
 */