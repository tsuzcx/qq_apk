package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.model.l;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.ui.MMActivity;

final class g$101
  implements f
{
  g$101(g paramg1, i parami, g paramg2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = -1;
    if ((g.k(this.rzi) != null) && (g.k(this.rzi).isShowing()))
    {
      g.k(this.rzi).dismiss();
      g.a(this.rzi, null);
    }
    au.Dk().b(1393, this);
    String str = "selectEnterpriseContact:fail";
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramm = null;
      paramInt1 = i;
      paramString = str;
    }
    while (paramInt1 != 0)
    {
      g.a(this.rzi, this.rzk, paramString, null);
      return;
      act localact = ((l)paramm).cbH();
      paramString = str;
      paramm = localact;
      paramInt1 = i;
      if (localact != null)
      {
        paramString = str;
        paramm = localact;
        paramInt1 = i;
        if (localact.sCU != null)
        {
          paramInt2 = localact.sCU.ret;
          paramString = str;
          paramm = localact;
          paramInt1 = paramInt2;
          if (localact.sCU.bLC != null)
          {
            paramString = str;
            paramm = localact;
            paramInt1 = paramInt2;
            if (localact.sCU.bLC.length() > 0)
            {
              paramString = localact.sCU.bLC;
              paramm = localact;
              paramInt1 = paramInt2;
            }
          }
        }
      }
    }
    paramString = paramm.sLy;
    paramm = new Intent();
    paramm.putExtra("rawUrl", paramString);
    paramm.putExtra("useJs", true);
    ((MMActivity)g.i(this.rzi)).gJb = this.rAu;
    d.b(g.i(this.rzi), "webview", ".ui.tools.WebViewUI", paramm, 53);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.101
 * JD-Core Version:    0.7.0.1
 */