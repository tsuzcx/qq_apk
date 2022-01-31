package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class n$a
{
  public static Bundle ao(Bundle paramBundle)
  {
    AppMethodBeat.i(8253);
    int i = paramBundle.getInt("key_action", -1);
    Bundle localBundle = new Bundle();
    if (!g.RJ().QU())
    {
      ab.w("MicroMsg.WebViewUIBagHelper", "MM doBagLogic not ready");
      AppMethodBeat.o(8253);
      return localBundle;
    }
    if (9 != i) {
      ab.i("MicroMsg.WebViewUIBagHelper", "MM doBagLogic action:%d", new Object[] { Integer.valueOf(i) });
    }
    switch (i)
    {
    default: 
      y(i, paramBundle);
    }
    for (;;)
    {
      AppMethodBeat.o(8253);
      return localBundle;
      paramBundle = paramBundle.getString("key_bag_id");
      localBundle.putBoolean("key_has_bag", l.vix.aiG(paramBundle));
      continue;
      l.vix.oy(paramBundle.getBoolean("key_in_webviewui_from_bag", false));
      continue;
      localBundle.putParcelable("key_current_bag_pos", l.vix.dfk());
    }
  }
  
  private static void y(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(8254);
    al.d(new n.a.1(paramInt, paramBundle));
    AppMethodBeat.o(8254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n.a
 * JD-Core Version:    0.7.0.1
 */