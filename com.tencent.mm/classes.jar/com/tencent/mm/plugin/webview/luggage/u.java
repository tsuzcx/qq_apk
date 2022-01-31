package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.e.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.bag.h.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class u
  implements h.a
{
  public final Bundle ac(Bundle paramBundle)
  {
    AppMethodBeat.i(6241);
    try
    {
      paramBundle = (Bundle)f.a("com.tencent.mm", paramBundle, a.class);
      AppMethodBeat.o(6241);
      return paramBundle;
    }
    catch (c paramBundle)
    {
      ab.e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic exp=%s", new Object[] { paramBundle.getLocalizedMessage() });
      AppMethodBeat.o(6241);
    }
    return null;
  }
  
  public final void z(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(6242);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < 4) {}
      try
      {
        localArrayList.add(String.valueOf(paramArrayOfObject[i]));
        i += 1;
      }
      catch (Exception paramArrayOfObject)
      {
        ab.w("MicroMsg.WebViewUIBagIPCDelegate", "kvReport, ex = " + paramArrayOfObject.getMessage());
        AppMethodBeat.o(6242);
      }
    }
    paramArrayOfObject = h.qsU;
    h.g(11576, localArrayList);
    AppMethodBeat.o(6242);
    return;
  }
  
  static class a
    implements i<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.u
 * JD-Core Version:    0.7.0.1
 */