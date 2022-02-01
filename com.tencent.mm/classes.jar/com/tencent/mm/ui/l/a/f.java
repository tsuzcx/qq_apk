package com.tencent.mm.ui.l.a;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.vfs.s;
import com.tencent.mmkv.MMKV;

public final class f
  extends e
{
  private final WxaPkg Qma;
  private final String Qmb;
  
  public f(g paramg)
  {
    super(paramg);
    AppMethodBeat.i(234389);
    if (((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) || (!paramg.getAppId().equals(MMKV.mmkvWithID("magic_emoji_test").decodeString("last_open_appid"))))
    {
      paramg = new RuntimeException("Not legal for test environment!!");
      AppMethodBeat.o(234389);
      throw paramg;
    }
    this.Qma = new WxaPkg(bes());
    if (!this.Qma.bvf())
    {
      paramg = new RuntimeException("No test package");
      AppMethodBeat.o(234389);
      throw paramg;
    }
    this.Qmb = CdnLogic.calcFileMD5(s.k(bes(), false));
    AppMethodBeat.o(234389);
  }
  
  public final String bes()
  {
    AppMethodBeat.i(234390);
    String str = MMKV.mmkvWithID("magic_emoji_test").decodeString("last_open_pkg");
    AppMethodBeat.o(234390);
    return str;
  }
  
  public final String gWF()
  {
    return this.Qmb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.f
 * JD-Core Version:    0.7.0.1
 */