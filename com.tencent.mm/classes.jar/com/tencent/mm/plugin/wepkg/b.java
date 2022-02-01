package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class b
{
  private static e JLt;
  private static final String URL;
  
  static
  {
    AppMethodBeat.i(200138);
    URL = "http://" + WeChatHosts.domainString(2131761707) + "/jsserver.js?wechat_pkgid=jscore_lib";
    AppMethodBeat.o(200138);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(200132);
    if (!AppBrandMainProcessService.isLive())
    {
      d.b("", new a()
      {
        public final void a(BaseWepkgProcessTask paramAnonymousBaseWepkgProcessTask)
        {
          AppMethodBeat.i(200130);
          b.c(this.JLu);
          AppMethodBeat.o(200130);
        }
      });
      AppMethodBeat.o(200132);
      return;
    }
    b(parama);
    AppMethodBeat.o(200132);
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(200136);
    if (parama != null) {
      parama.azT(getCode());
    }
    AppMethodBeat.o(200136);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(200134);
    JLt.zE(false);
    AppMethodBeat.o(200134);
  }
  
  private static String getCode()
  {
    AppMethodBeat.i(200133);
    Object localObject = new e();
    JLt = (e)localObject;
    ((e)localObject).m(URL, true, false);
    localObject = JLt;
    if ((((e)localObject).JLD == null) || (((e)localObject).JLD.JNr == null))
    {
      AppMethodBeat.o(200133);
      return null;
    }
    localObject = ((e)localObject).JLD.JNr.gkR();
    AppMethodBeat.o(200133);
    return localObject;
  }
  
  public static String gkn()
  {
    AppMethodBeat.i(200135);
    if (JLt == null)
    {
      AppMethodBeat.o(200135);
      return null;
    }
    String str = JLt.gkx();
    AppMethodBeat.o(200135);
    return str;
  }
  
  public static void vC()
  {
    AppMethodBeat.i(200131);
    Log.i("MicroMsg.GameJsServerCommLibPkg", "load");
    AppMethodBeat.o(200131);
  }
  
  public static abstract interface a
  {
    public abstract void azT(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b
 * JD-Core Version:    0.7.0.1
 */