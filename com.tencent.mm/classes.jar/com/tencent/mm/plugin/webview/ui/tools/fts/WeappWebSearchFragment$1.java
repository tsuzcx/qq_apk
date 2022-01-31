package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;

final class WeappWebSearchFragment$1
  extends com.tencent.mm.plugin.webview.ui.tools.widget.k
{
  WeappWebSearchFragment$1(WeappWebSearchFragment paramWeappWebSearchFragment, MMWebView paramMMWebView)
  {
    super(paramMMWebView);
  }
  
  public final void a(d paramd, com.tencent.mm.plugin.webview.ui.tools.k paramk)
  {
    AppMethodBeat.i(8608);
    try
    {
      super.a(paramd, paramk);
      if (WeappWebSearchFragment.a(this.vmc) != null) {
        WeappWebSearchFragment.a(this.vmc).uQS = WeappWebSearchFragment.b(this.vmc).getJsapi();
      }
      AppMethodBeat.o(8608);
      return;
    }
    catch (Exception paramd)
    {
      ab.printErrStackTrace("MicroMsg.WebSearch.WeappWebSearchFragment", paramd, "", new Object[0]);
      AppMethodBeat.o(8608);
    }
  }
  
  public final m aGm()
  {
    AppMethodBeat.i(8609);
    m local1 = new m()
    {
      public final boolean e(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(8607);
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          boolean bool = super.e(paramAnonymousInt, paramAnonymousBundle);
          AppMethodBeat.o(8607);
          return bool;
          WeappWebSearchFragment.1.this.vmc.z(paramAnonymousInt, paramAnonymousBundle);
        }
      }
    };
    AppMethodBeat.o(8609);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.WeappWebSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */