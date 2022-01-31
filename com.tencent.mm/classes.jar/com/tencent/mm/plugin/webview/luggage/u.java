package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.e.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.bag.h.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class u
  implements h.a
{
  public final Bundle L(Bundle paramBundle)
  {
    try
    {
      paramBundle = (Bundle)f.a("com.tencent.mm", paramBundle, a.class);
      return paramBundle;
    }
    catch (c paramBundle)
    {
      y.e("MicroMsg.WebViewUIBagIPCDelegate", "doBagLogic exp=%s", new Object[] { paramBundle.getLocalizedMessage() });
    }
    return null;
  }
  
  public final void u(Object[] paramArrayOfObject)
  {
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
        y.w("MicroMsg.WebViewUIBagIPCDelegate", "kvReport, ex = " + paramArrayOfObject.getMessage());
      }
    }
    paramArrayOfObject = h.nFQ;
    h.f(11576, localArrayList);
    return;
  }
  
  private static class a
    implements i<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.u
 * JD-Core Version:    0.7.0.1
 */