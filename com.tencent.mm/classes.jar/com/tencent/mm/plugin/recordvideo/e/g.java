package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/util/SecondCutConfig;", "", "()V", "TAG", "", "getEditVideoToSecondCutEntrance", "", "getSecondCutDownloadUrl", "getShareVideoDuration", "", "getSnsToSecondCutEntrance", "plugin-recordvideo_release"})
public final class g
{
  public static final g Ciw;
  
  static
  {
    AppMethodBeat.i(238001);
    Ciw = new g();
    AppMethodBeat.o(238001);
  }
  
  public static boolean eMO()
  {
    AppMethodBeat.i(237997);
    boolean bool = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sdX, false);
    Log.i("MicroMsg.SecondCutConfig", "SecondCutEntrance: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(237997);
    return bool;
  }
  
  public static boolean eMP()
  {
    AppMethodBeat.i(237998);
    boolean bool = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sdW, false);
    Log.i("MicroMsg.SecondCutConfig", "EditVideoToSecondCutEntrance: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(237998);
    return bool;
  }
  
  public static int eMQ()
  {
    AppMethodBeat.i(237999);
    int i = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sdY, 30);
    Log.i("MicroMsg.SecondCutConfig", "ShareVideoDuration: ".concat(String.valueOf(i)));
    AppMethodBeat.o(237999);
    return i;
  }
  
  public static String eMR()
  {
    AppMethodBeat.i(238000);
    String str = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sdZ, "https://miaojian.weixin.qq.com/download/apps?channel=");
    Log.i("MicroMsg.SecondCutConfig", "SecondCutDownloadUrl: ".concat(String.valueOf(str)));
    p.g(str, "url");
    AppMethodBeat.o(238000);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.g
 * JD-Core Version:    0.7.0.1
 */