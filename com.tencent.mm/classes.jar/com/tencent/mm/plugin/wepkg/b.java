package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.c;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class b
{
  private static final String URL;
  private static f XEl;
  
  static
  {
    AppMethodBeat.i(278653);
    URL = "http://" + WeChatHosts.domainString(d.a.host_game_weixin_qq_com) + "/jsserver.js?wechat_pkgid=jscore_lib";
    AppMethodBeat.o(278653);
  }
  
  public static void Td()
  {
    AppMethodBeat.i(278636);
    Log.i("MicroMsg.GameJsServerCommLibPkg", "load");
    AppMethodBeat.o(278636);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(278637);
    if (!c.isLive())
    {
      d.b("", new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(278648);
          b.c(b.this);
          AppMethodBeat.o(278648);
        }
      });
      AppMethodBeat.o(278637);
      return;
    }
    b(parama);
    AppMethodBeat.o(278637);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(278649);
    if (parama != null) {
      parama.onCodeReturn(getCode());
    }
    AppMethodBeat.o(278649);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(278644);
    XEl.Jk(false);
    AppMethodBeat.o(278644);
  }
  
  private static String getCode()
  {
    AppMethodBeat.i(278641);
    Object localObject = new f();
    XEl = (f)localObject;
    ((f)localObject).q(URL, true, false);
    localObject = XEl;
    if ((((f)localObject).XEv == null) || (((f)localObject).XEv.XGi == null))
    {
      AppMethodBeat.o(278641);
      return null;
    }
    localObject = ((f)localObject).XEv.XGi.iFs();
    AppMethodBeat.o(278641);
    return localObject;
  }
  
  public static String iEM()
  {
    AppMethodBeat.i(278646);
    if (XEl == null)
    {
      AppMethodBeat.o(278646);
      return null;
    }
    String str = XEl.iEW();
    AppMethodBeat.o(278646);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void onCodeReturn(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b
 * JD-Core Version:    0.7.0.1
 */