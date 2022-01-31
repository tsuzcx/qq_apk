package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class WebViewStubService$1$1
  implements Runnable
{
  WebViewStubService$1$1(WebViewStubService.1 param1, int paramInt1, Bundle paramBundle, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(7105);
    switch (this.uZz)
    {
    default: 
      ab.e("MicroMsg.WebViewStubService", "not support action code:[%d]", new Object[] { Integer.valueOf(this.uZz) });
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 20: 
    case 21: 
    case 41: 
      Object localObject2;
      Object localObject3;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  AppMethodBeat.o(7105);
                  return;
                  WebViewStubService.a(this.uZB.uZy, 2, this.cax, this.uZA);
                  AppMethodBeat.o(7105);
                  return;
                  t.ii(this.uZB.uZy);
                  AppMethodBeat.o(7105);
                  return;
                  localObject1 = new Bundle();
                  ((Bundle)localObject1).putInt("stat_scene", 4);
                  localObject2 = h.KW(this.uZA);
                  if (localObject2 != null) {
                    ((Bundle)localObject1).putString("stat_url", ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject2).getCurrentUrl());
                  }
                  WebViewStubService.1.a(this.uZB, this.cax, (Bundle)localObject1);
                  AppMethodBeat.o(7105);
                  return;
                  WebViewStubService.a(this.uZB.uZy, 3, this.cax, this.uZA);
                  AppMethodBeat.o(7105);
                  return;
                  i = this.cax.getInt("scene_end_type", 0);
                  j = this.cax.getInt("scene_end_listener_hash_code", -1);
                  if (j != -1) {
                    WebViewStubService.a(this.uZB.uZy).add(Integer.valueOf(j));
                  }
                  ab.i("MicroMsg.WebViewStubService", "add Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_inc_count[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(WebViewStubService.a(this.uZB.uZy).size()), Integer.valueOf(WebViewStubService.b(this.uZB.uZy)) });
                } while (i <= 0);
                WebViewStubService.c(this.uZB.uZy);
                ab.i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", new Object[] { Integer.valueOf(j) });
                com.tencent.mm.kernel.g.Rc().a(233, this.uZB.uZy);
                com.tencent.mm.kernel.g.Rc().a(673, this.uZB.uZy);
                com.tencent.mm.kernel.g.Rc().a(666, this.uZB.uZy);
                com.tencent.mm.kernel.g.Rc().a(1254, this.uZB.uZy);
                com.tencent.mm.kernel.g.Rc().a(1373, this.uZB.uZy);
                AppMethodBeat.o(7105);
                return;
                i = this.cax.getInt("scene_end_type", 0);
                j = this.cax.getInt("scene_end_listener_hash_code", -1);
                if (j != -1) {
                  WebViewStubService.a(this.uZB.uZy).remove(Integer.valueOf(j));
                }
                ab.i("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_dec_count:[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(WebViewStubService.a(this.uZB.uZy).size()), Integer.valueOf(WebViewStubService.b(this.uZB.uZy)) });
              } while (i <= 0);
              WebViewStubService.d(this.uZB.uZy);
              if (WebViewStubService.b(this.uZB.uZy) < 0)
              {
                ab.e("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set size:[%d], unexpected_count[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(WebViewStubService.a(this.uZB.uZy).size()), Integer.valueOf(WebViewStubService.b(this.uZB.uZy)) });
                WebViewStubService.e(this.uZB.uZy);
              }
            } while ((WebViewStubService.b(this.uZB.uZy) > 0) || (WebViewStubService.a(this.uZB.uZy).size() > 0));
            ab.i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", new Object[] { Integer.valueOf(j) });
          } while (!com.tencent.mm.kernel.g.RG());
          com.tencent.mm.kernel.g.Rc().b(233, this.uZB.uZy);
          com.tencent.mm.kernel.g.Rc().b(673, this.uZB.uZy);
          com.tencent.mm.kernel.g.Rc().b(666, this.uZB.uZy);
          com.tencent.mm.kernel.g.Rc().b(1254, this.uZB.uZy);
          com.tencent.mm.kernel.g.Rc().b(1373, this.uZB.uZy);
          AppMethodBeat.o(7105);
          return;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("MMActivity.OverrideEnterAnimation", 0);
          ((Intent)localObject1).putExtra("MMActivity.OverrideExitAnimation", 2131034228);
          ((Intent)localObject1).addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.gmO.r((Intent)localObject1, this.uZB.uZy);
          AppMethodBeat.o(7105);
          return;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras(this.cax);
          ((Intent)localObject1).addFlags(268435456);
          com.tencent.mm.plugin.webview.a.a.gmO.s((Intent)localObject1, this.uZB.uZy);
          AppMethodBeat.o(7105);
          return;
          this.cax.setClassLoader(getClass().getClassLoader());
          h.KW(this.uZA).vpr = this.cax.getBundle("jsapiargs");
          localObject1 = (String)this.cax.getCharSequence("bizofstartfrom");
          localObject2 = this.cax.getBundle("startwebviewparams");
          if ((localObject1 != null) && (localObject2 != null))
          {
            localObject3 = new lf();
            ((lf)localObject3).cBp.cBq = ((String)localObject1);
            ((lf)localObject3).cBp.params = ((Bundle)localObject2);
            com.tencent.mm.sdk.b.a.ymk.l((b)localObject3);
          }
          WebViewStubService.a(this.uZB.uZy, this.cax.getInt("screen_orientation", -1));
          AppMethodBeat.o(7105);
          return;
          h.KW(this.uZA).dgw().putAll(this.cax);
          AppMethodBeat.o(7105);
          return;
        } while (!com.tencent.mm.kernel.g.RG());
        localObject1 = h.KW(this.uZA);
        localObject2 = this.cax;
      } while (((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).vqi == null);
      if ((localObject2 == null) || (((Bundle)localObject2).size() <= 0)) {
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).uWu, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).vqi, "showKeyboard:fail", null);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).vqi = null;
        AppMethodBeat.o(7105);
        return;
        localObject3 = new HashMap();
        ((Map)localObject3).put("text", bo.nullAsNil(((Bundle)localObject2).getString("show_kb_input_callback_text")));
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).uWu, ((com.tencent.mm.plugin.webview.ui.tools.jsapi.g)localObject1).vqi, "showKeyboard:ok", (Map)localObject3);
      }
    case 29: 
      localObject1 = this.cax.getString("srcUsername");
      z.afi();
      com.tencent.mm.aj.e.rP((String)localObject1);
      z.afi();
      com.tencent.mm.aj.e.rQ((String)localObject1);
      z.aft();
      if ((!bo.isNullOrNil((String)localObject1)) && (f.rY((String)localObject1))) {
        z.aft().a((String)localObject1, null, 0, null);
      }
      AppMethodBeat.o(7105);
      return;
    case 30: 
      localObject1 = this.cax.getString("srcUsername");
      z.afi();
      com.tencent.mm.aj.e.rR((String)localObject1);
      z.aft();
      if ((!bo.isNullOrNil((String)localObject1)) && (f.rY((String)localObject1))) {
        z.aft().a((String)localObject1, null);
      }
      AppMethodBeat.o(7105);
      return;
    }
    Object localObject1 = this.cax.getString("wxa_result");
    int i = this.cax.getInt("wxa_code_type", 0);
    int j = this.cax.getInt("wxa_code_version", 0);
    ((d)com.tencent.mm.kernel.g.E(d.class)).z((String)localObject1, i, j).a(new WebViewStubService.1.1.1(this));
    AppMethodBeat.o(7105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubService.1.1
 * JD-Core Version:    0.7.0.1
 */