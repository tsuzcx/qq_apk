package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.g;

public final class b
{
  static d EDd;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(214439);
    if (parama != null) {
      parama.alE(getCode());
    }
    AppMethodBeat.o(214439);
  }
  
  private static String getCode()
  {
    AppMethodBeat.i(214438);
    Object localObject = new d();
    EDd = (d)localObject;
    ((d)localObject).k("http://game.weixin.qq.com/jsserver.js?wechat_pkgid=jscore_lib", true, false);
    localObject = EDd;
    if ((((d)localObject).EDn == null) || (((d)localObject).EDn.EFd == null))
    {
      AppMethodBeat.o(214438);
      return null;
    }
    localObject = ((d)localObject).EDn.EFd.eYa();
    AppMethodBeat.o(214438);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void alE(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b
 * JD-Core Version:    0.7.0.1
 */