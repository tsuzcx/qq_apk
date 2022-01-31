package com.tencent.mm.ui.chatting.c.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.appbrand.b;

final class a$2$1
  implements Runnable
{
  a$2$1(a.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(31889);
    String str2 = b.ats(this.zJt.zJr.caz.getTalkerUserName());
    String str1;
    if (bo.isNullOrNil(str2))
    {
      str2 = this.zJt.zJr.caz.getTalkerUserName();
      if (bo.isNullOrNil(this.zJt.zJr.caz.dHF())) {
        str1 = b.att(this.zJt.zJr.caz.getTalkerUserName());
      }
    }
    for (;;)
    {
      a.b(this.zJt.zJr).username = this.zJt.zJr.caz.getTalkerUserName();
      a.b(this.zJt.zJr).jvs = false;
      a.b(this.zJt.zJr).scene = a.c(this.zJt.zJr);
      a.b(this.zJt.zJr).zgj = a.d(this.zJt.zJr);
      if ((a.c(this.zJt.zJr) == 3) && (TextUtils.isEmpty(a.e(this.zJt.zJr).nickname))) {
        a.e(this.zJt.zJr).nickname = str1;
      }
      if ((a.c(this.zJt.zJr) != 2) && (a.c(this.zJt.zJr) != 3)) {
        break label344;
      }
      a.b(this.zJt.zJr).iOe = a.e(this.zJt.zJr);
      if (!a.a(this.zJt.zJr)) {
        break;
      }
      a.b(this.zJt.zJr).show(1);
      AppMethodBeat.o(31889);
      return;
      str1 = this.zJt.zJr.caz.dHF();
      continue;
      str1 = b.att(str2);
    }
    a.b(this.zJt.zJr).show(2);
    AppMethodBeat.o(31889);
    return;
    label344:
    WxaExposedParams.a locala = new WxaExposedParams.a();
    locala.appId = b.Aq(str2);
    locala.from = 4;
    locala.username = str2;
    locala.nickname = str1;
    a.b(this.zJt.zJr).iOe = locala.ayJ();
    a.b(this.zJt.zJr).appId = this.zJt.zJr.getAppId();
    if (a.a(this.zJt.zJr))
    {
      a.b(this.zJt.zJr).show(5);
      AppMethodBeat.o(31889);
      return;
    }
    a.b(this.zJt.zJr).show(6);
    AppMethodBeat.o(31889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.a.2.1
 * JD-Core Version:    0.7.0.1
 */