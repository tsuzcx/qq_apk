package com.tencent.mm.plugin.webview.ui.tools.preload;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.c.apm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class d$2
  implements f
{
  d$2(String paramString, h paramh, d.a parama, i parami, e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(233, this);
    d.bDc().remove(this.rch);
    y.i("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth]errType:%d, errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = this.iiP.Qf();
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth] fail fullurl is null");
      a.jdMethod_if(82);
      this.rBt.a(this.rzk, this.rzk.rAO + ":fail", null);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {}
    for (;;)
    {
      try
      {
        paramm = new Bundle();
        paramm.putString("geta8key_result_req_url", this.iiP.Qg());
        paramm.putString("geta8key_result_full_url", paramString);
        List localList = this.iiP.Qm();
        if (!bk.dk(localList))
        {
          Object localObject1 = localList.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label534;
          }
          Object localObject2 = (apm)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!bk.bl(((apm)localObject2).sCH)) && (!bk.bl(((apm)localObject2).nFs))) {
            continue;
          }
          y.e("MicroMsg.TmplWebViewJsAPi", "http header has null value");
          paramInt1 = 1;
          if (paramInt1 == 0)
          {
            localObject1 = new String[localList.size()];
            localObject2 = new String[localList.size()];
            paramInt1 = 0;
            if (paramInt1 < localList.size())
            {
              Object localObject3 = (apm)localList.get(paramInt1);
              String str = ((apm)localObject3).sCH;
              localObject3 = ((apm)localObject3).nFs;
              y.i("MicroMsg.TmplWebViewJsAPi", "http header index = %d, key = %s, value = %s", new Object[] { Integer.valueOf(paramInt1), str, localObject3 });
              localObject1[paramInt1] = str;
              localObject2[paramInt1] = localObject3;
              paramInt1 += 1;
              continue;
            }
            paramm.putStringArray("geta8key_result_http_header_key_list", (String[])localObject1);
            paramm.putStringArray("geta8key_result_http_header_value_list", (String[])localObject2);
          }
        }
        this.rBu.f(90004, paramm);
      }
      catch (RemoteException paramm)
      {
        y.printErrStackTrace("MicroMsg.TmplWebViewJsAPi", paramm, "", new Object[0]);
        continue;
      }
      paramm = new HashMap();
      paramm.put("fullUrl", paramString);
      y.i("MicroMsg.TmplWebViewJsAPi", "[updatePageAuth]values:%s", new Object[] { paramm });
      a.jdMethod_if(81);
      this.rBt.a(this.rzk, this.rzk.rAO + ":ok", paramm);
      return;
      a.jdMethod_if(82);
      this.rBt.a(this.rzk, this.rzk.rAO + ":fail", null);
      return;
      label534:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.d.2
 * JD-Core Version:    0.7.0.1
 */