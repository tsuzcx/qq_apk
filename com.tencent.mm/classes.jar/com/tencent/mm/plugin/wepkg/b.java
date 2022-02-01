package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.g;

public final class b
{
  static d EVz;
  
  public static void a(a parama)
  {
    AppMethodBeat.i(209367);
    if (parama != null) {
      parama.amE(getCode());
    }
    AppMethodBeat.o(209367);
  }
  
  private static String getCode()
  {
    AppMethodBeat.i(209366);
    Object localObject = new d();
    EVz = (d)localObject;
    ((d)localObject).k("http://game.weixin.qq.com/jsserver.js?wechat_pkgid=jscore_lib", true, false);
    localObject = EVz;
    if ((((d)localObject).EVJ == null) || (((d)localObject).EVJ.EXz == null))
    {
      AppMethodBeat.o(209366);
      return null;
    }
    localObject = ((d)localObject).EVJ.EXz.fbM();
    AppMethodBeat.o(209366);
    return localObject;
  }
  
  public static abstract interface a
  {
    public abstract void amE(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.b
 * JD-Core Version:    0.7.0.1
 */