package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.webview.model.n;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.ui.MMActivity;

final class g$109
  implements f
{
  g$109(g paramg1, i parami, g paramg2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = -1;
    AppMethodBeat.i(9185);
    if ((g.E(this.vqm) != null) && (g.E(this.vqm).isShowing()))
    {
      g.E(this.vqm).dismiss();
      g.a(this.vqm, null);
    }
    com.tencent.mm.kernel.g.Rc().b(1393, this);
    String str = "openEnterpriseContact:fail";
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramm = null;
      paramInt1 = i;
      paramString = str;
    }
    while (paramInt1 != 0)
    {
      this.vqm.a(this.uZa, paramString, null);
      AppMethodBeat.o(9185);
      return;
      ahl localahl = ((n)paramm).dbK();
      paramString = str;
      paramm = localahl;
      paramInt1 = i;
      if (localahl != null)
      {
        paramString = str;
        paramm = localahl;
        paramInt1 = i;
        if (localahl.wyn != null)
        {
          paramInt2 = localahl.wyn.ret;
          paramString = str;
          paramm = localahl;
          paramInt1 = paramInt2;
          if (localahl.wyn.csW != null)
          {
            paramString = str;
            paramm = localahl;
            paramInt1 = paramInt2;
            if (localahl.wyn.csW.length() > 0)
            {
              paramString = localahl.wyn.csW;
              paramm = localahl;
              paramInt1 = paramInt2;
            }
          }
        }
      }
    }
    paramString = paramm.wqy;
    paramm = new Intent();
    paramm.putExtra("rawUrl", paramString);
    paramm.putExtra("useJs", true);
    ((MMActivity)g.j(this.vqm)).mmSetOnActivityResultCallback(this.vrx);
    d.b(g.j(this.vqm), "webview", ".ui.tools.WebViewUI", paramm, 31);
    AppMethodBeat.o(9185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.109
 * JD-Core Version:    0.7.0.1
 */