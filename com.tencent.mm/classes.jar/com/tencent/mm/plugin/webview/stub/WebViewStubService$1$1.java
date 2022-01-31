package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.kr;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class WebViewStubService$1$1
  implements Runnable
{
  WebViewStubService$1$1(WebViewStubService.1 param1, int paramInt1, Bundle paramBundle, int paramInt2) {}
  
  public final void run()
  {
    switch (this.rkh)
    {
    default: 
      y.e("MicroMsg.WebViewStubService", "not support action code:[%d]", new Object[] { Integer.valueOf(this.rkh) });
    }
    Object localObject1;
    do
    {
      do
      {
        Object localObject2;
        Object localObject3;
        do
        {
          do
          {
            do
            {
              int j;
              do
              {
                int i;
                do
                {
                  do
                  {
                    return;
                    WebViewStubService.a(this.rkj.rkg, 2, this.byv, this.rki);
                    return;
                    s.gM(this.rkj.rkg);
                    return;
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putInt("stat_scene", 4);
                    localObject2 = h.Db(this.rki);
                    if (localObject2 != null) {
                      ((Bundle)localObject1).putString("stat_url", ((g)localObject2).getCurrentUrl());
                    }
                    WebViewStubService.1.a(this.rkj, this.byv, (Bundle)localObject1);
                    return;
                    WebViewStubService.a(this.rkj.rkg, 3, this.byv, this.rki);
                    return;
                    i = this.byv.getInt("scene_end_type", 0);
                    j = this.byv.getInt("scene_end_listener_hash_code", -1);
                    if (j != -1) {
                      WebViewStubService.a(this.rkj.rkg).add(Integer.valueOf(j));
                    }
                    y.i("MicroMsg.WebViewStubService", "add Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_inc_count[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(WebViewStubService.a(this.rkj.rkg).size()), Integer.valueOf(WebViewStubService.b(this.rkj.rkg)) });
                  } while (i <= 0);
                  WebViewStubService.c(this.rkj.rkg);
                  y.i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", new Object[] { Integer.valueOf(j) });
                  au.Dk().a(233, this.rkj.rkg);
                  au.Dk().a(673, this.rkj.rkg);
                  au.Dk().a(666, this.rkj.rkg);
                  au.Dk().a(1254, this.rkj.rkg);
                  au.Dk().a(1373, this.rkj.rkg);
                  return;
                  i = this.byv.getInt("scene_end_type", 0);
                  j = this.byv.getInt("scene_end_listener_hash_code", -1);
                  if (j != -1) {
                    WebViewStubService.a(this.rkj.rkg).remove(Integer.valueOf(j));
                  }
                  y.i("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_dec_count:[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(WebViewStubService.a(this.rkj.rkg).size()), Integer.valueOf(WebViewStubService.b(this.rkj.rkg)) });
                } while (i <= 0);
                WebViewStubService.d(this.rkj.rkg);
                if (WebViewStubService.b(this.rkj.rkg) < 0)
                {
                  y.e("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set size:[%d], unexpected_count[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(WebViewStubService.a(this.rkj.rkg).size()), Integer.valueOf(WebViewStubService.b(this.rkj.rkg)) });
                  WebViewStubService.e(this.rkj.rkg);
                }
              } while ((WebViewStubService.b(this.rkj.rkg) > 0) || (WebViewStubService.a(this.rkj.rkg).size() > 0));
              y.i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", new Object[] { Integer.valueOf(j) });
            } while (!au.DK());
            au.Dk().b(233, this.rkj.rkg);
            au.Dk().b(673, this.rkj.rkg);
            au.Dk().b(666, this.rkj.rkg);
            au.Dk().b(1254, this.rkj.rkg);
            au.Dk().b(1373, this.rkj.rkg);
            return;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("MMActivity.OverrideEnterAnimation", 0);
            ((Intent)localObject1).putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
            ((Intent)localObject1).addFlags(268435456);
            com.tencent.mm.plugin.webview.a.a.eUR.s((Intent)localObject1, this.rkj.rkg);
            return;
            localObject1 = new Intent();
            ((Intent)localObject1).putExtras(this.byv);
            ((Intent)localObject1).addFlags(268435456);
            com.tencent.mm.plugin.webview.a.a.eUR.t((Intent)localObject1, this.rkj.rkg);
            return;
            this.byv.setClassLoader(getClass().getClassLoader());
            h.Db(this.rki).ryq = this.byv.getBundle("jsapiargs");
            localObject1 = (String)this.byv.getCharSequence("bizofstartfrom");
            localObject2 = this.byv.getBundle("startwebviewparams");
            if ((localObject1 != null) && (localObject2 != null))
            {
              localObject3 = new kr();
              ((kr)localObject3).bTI.bTJ = ((String)localObject1);
              ((kr)localObject3).bTI.bTK = ((Bundle)localObject2);
              com.tencent.mm.sdk.b.a.udP.m((b)localObject3);
            }
            WebViewStubService.a(this.rkj.rkg, this.byv.getInt("screen_orientation", -1));
            return;
            h.Db(this.rki).cgi().putAll(this.byv);
            return;
          } while (!au.DK());
          localObject1 = h.Db(this.rki);
          localObject2 = this.byv;
        } while (((g)localObject1).rzg == null);
        if ((localObject2 == null) || (((Bundle)localObject2).size() <= 0)) {
          ((g)localObject1).a(((g)localObject1).rgh, ((g)localObject1).rzg, "showKeyboard:fail", null, true, true);
        }
        for (;;)
        {
          ((g)localObject1).rzg = null;
          return;
          localObject3 = new HashMap();
          ((Map)localObject3).put("text", bk.pm(((Bundle)localObject2).getString("show_kb_input_callback_text")));
          ((g)localObject1).a(((g)localObject1).rgh, ((g)localObject1).rzg, "showKeyboard:ok", (Map)localObject3, true, true);
        }
        localObject1 = this.byv.getString("srcUsername");
        z.My();
        e.kU((String)localObject1);
        z.My();
        e.kV((String)localObject1);
        z.MJ();
      } while ((bk.bl((String)localObject1)) || (!f.ld((String)localObject1)));
      z.MJ().a((String)localObject1, null, 0);
      return;
      localObject1 = this.byv.getString("srcUsername");
      z.My();
      e.kW((String)localObject1);
      z.MJ();
    } while ((bk.bl((String)localObject1)) || (!f.ld((String)localObject1)));
    z.MJ();
    k.li((String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.1.1
 * JD-Core Version:    0.7.0.1
 */