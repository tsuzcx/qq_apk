package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.t;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.bqx;
import java.util.HashMap;
import java.util.Map;

final class g$108
  implements f
{
  g$108(g paramg, i parami) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = -1;
    AppMethodBeat.i(155028);
    t.b(this);
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
        this.vqm.a(this.uZa, paramString, null);
        AppMethodBeat.o(155028);
        return;
        paramString = (t)paramm;
        if ((paramString.rr != null) && (paramString.rr.fsW.fta != null)) {}
        for (paramm = (ahn)paramString.rr.fsW.fta;; paramm = null)
        {
          if ((paramm != null) && (paramm.wyn != null)) {
            break label121;
          }
          paramString = "getEnterpriseChat:fail";
          paramInt1 = i;
          break;
        }
        label121:
        paramInt1 = paramm.wyn.ret;
        if ((paramm.wyn.csW != null) && (paramm.wyn.csW.length() > 0)) {
          paramString = "getEnterpriseChat:fail_" + paramm.wyn.csW;
        }
      }
      else
      {
        paramString = new HashMap();
        paramString.put("result", paramm.result);
        this.vqm.a(this.uZa, "getEnterpriseChat:ok", paramString);
        AppMethodBeat.o(155028);
        return;
      }
      paramString = "getEnterpriseChat:fail";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.108
 * JD-Core Version:    0.7.0.1
 */