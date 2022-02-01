package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class b
{
  private static f QKM;
  private static final String URL;
  
  static
  {
    AppMethodBeat.i(194378);
    URL = "http://" + WeChatHosts.domainString(d.a.host_game_weixin_qq_com) + "/jsserver.js?wechat_pkgid=jscore_lib";
    AppMethodBeat.o(194378);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(194364);
    if (!com.tencent.mm.plugin.appbrand.ipc.b.isLive())
    {
      d.b("", new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(194072);
          b.c(this.QKN);
          AppMethodBeat.o(194072);
        }
      });
      AppMethodBeat.o(194364);
      return;
    }
    b(parama);
    AppMethodBeat.o(194364);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(194373);
    if (parama != null) {
      parama.aqk(getCode());
    }
    AppMethodBeat.o(194373);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(194370);
    QKM.DD(false);
    AppMethodBeat.o(194370);
  }
  
  private static String getCode()
  {
    AppMethodBeat.i(194369);
    Object localObject = new f();
    QKM = (f)localObject;
    ((f)localObject).m(URL, true, false);
    localObject = QKM;
    if ((((f)localObject).QKW == null) || (((f)localObject).QKW.QMK == null))
    {
      AppMethodBeat.o(194369);
      return null;
    }
    localObject = ((f)localObject).QKW.QMK.heK();
    AppMethodBeat.o(194369);
    return localObject;
  }
  
  public static String hee()
  {
    AppMethodBeat.i(194371);
    if (QKM == null)
    {
      AppMethodBeat.o(194371);
      return null;
    }
    String str = QKM.heo();
    AppMethodBeat.o(194371);
    return str;
  }
  
  public static void tA()
  {
    AppMethodBeat.i(194362);
    Log.i("MicroMsg.GameJsServerCommLibPkg", "load");
    AppMethodBeat.o(194362);
  }
  
  public static abstract interface a
  {
    public abstract void aqk(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b
 * JD-Core Version:    0.7.0.1
 */