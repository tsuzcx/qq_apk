package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ai.t;
import com.tencent.mm.protocal.c.acv;
import com.tencent.mm.protocal.c.bih;
import java.util.HashMap;
import java.util.Map;

final class g$98
  implements f
{
  g$98(g paramg, i parami) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = -1;
    t.a(this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      paramString = "getEnterpriseChat:fail";
      paramm = null;
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        g.a(this.rzi, this.rzk, paramString, null);
        return;
        paramString = (t)paramm;
        if ((paramString.dmK != null) && (paramString.dmK.ecF.ecN != null)) {}
        for (paramm = (acv)paramString.dmK.ecF.ecN;; paramm = null)
        {
          if ((paramm != null) && (paramm.sCU != null)) {
            break label111;
          }
          paramString = "getEnterpriseChat:fail";
          paramInt1 = i;
          break;
        }
        label111:
        paramInt1 = paramm.sCU.ret;
        if ((paramm.sCU.bLC != null) && (paramm.sCU.bLC.length() > 0)) {
          paramString = "getEnterpriseChat:fail_" + paramm.sCU.bLC;
        }
      }
      else
      {
        paramString = new HashMap();
        paramString.put("result", paramm.result);
        g.a(this.rzi, this.rzk, "getEnterpriseChat:ok", paramString);
        return;
      }
      paramString = "getEnterpriseChat:fail";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.98
 * JD-Core Version:    0.7.0.1
 */