package com.tencent.mm.ui.n.a;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;

public final class f
  extends e
{
  private final WxaPkg XJP;
  private final String XJQ;
  
  public f(g paramg)
  {
    super(paramg);
    AppMethodBeat.i(263181);
    if (((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) || (!paramg.getAppId().equals(MultiProcessMMKV.getSingleMMKV("magic_emoji_test").decodeString("last_open_appid"))))
    {
      paramg = new RuntimeException("Not legal for test environment!!");
      AppMethodBeat.o(263181);
      throw paramg;
    }
    this.XJP = new WxaPkg(bnR());
    if (!this.XJP.bGl())
    {
      paramg = new RuntimeException("No test package");
      AppMethodBeat.o(263181);
      throw paramg;
    }
    this.XJQ = CdnLogic.calcFileMD5(u.n(bnR(), false));
    AppMethodBeat.o(263181);
  }
  
  public final String bnR()
  {
    AppMethodBeat.i(263182);
    String str = MultiProcessMMKV.getSingleMMKV("magic_emoji_test").decodeString("last_open_pkg");
    AppMethodBeat.o(263182);
    return str;
  }
  
  public final String hXo()
  {
    return this.XJQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.f
 * JD-Core Version:    0.7.0.1
 */