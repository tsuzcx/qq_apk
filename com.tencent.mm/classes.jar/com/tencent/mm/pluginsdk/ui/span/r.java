package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.t;

public final class r
{
  public static boolean Lq()
  {
    boolean bool3 = true;
    AppMethodBeat.i(31945);
    if (!com.tencent.mm.kernel.g.afz().aeI())
    {
      ad.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
      AppMethodBeat.o(31945);
      return false;
    }
    boolean bool4;
    boolean bool1;
    label97:
    boolean bool2;
    if ((!bt.iP(aj.getContext())) && (com.tencent.mm.sdk.platformtools.i.cJR != 1) && (bt.getInt(com.tencent.mm.m.g.Zd().getValue("ShowWeixinPBIntro"), 0) == 0) && (!q.t(aj.getContext(), "com.tencent.pb")))
    {
      i = 1;
      if (i != 0) {
        break label193;
      }
      bool4 = bt.iP(aj.getContext());
      if (com.tencent.mm.sdk.platformtools.i.cJR == 1) {
        break label178;
      }
      bool1 = true;
      if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("ShowWeixinPBIntro"), 0) != 0) {
        break label183;
      }
      bool2 = true;
      label114:
      if (q.t(aj.getContext(), "com.tencent.pb")) {
        break label188;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.WxPhoneBookHelper", "%b, %b, %b, %b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(31945);
      return false;
      i = 0;
      break;
      label178:
      bool1 = false;
      break label97;
      label183:
      bool2 = false;
      break label114;
      label188:
      bool3 = false;
    }
    label193:
    int i = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FgY, null), 3);
    ad.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(31945);
      return false;
    }
    com.tencent.mm.kernel.g.afB().afk().set(352257, Integer.valueOf(i - 1));
    AppMethodBeat.o(31945);
    return true;
  }
  
  public static void eAz()
  {
    AppMethodBeat.i(31946);
    int i = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FgY, null), 3);
    ad.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.kernel.g.afB().afk().set(ae.a.FgY, Integer.valueOf(i - 1));
    AppMethodBeat.o(31946);
  }
  
  public static void h(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(31947);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("fromScene");; i = 0)
    {
      h.vKh.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      paramBundle = f.bQt().Sq("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
      if ((paramBundle == null) || (paramBundle.status != 3)) {
        break;
      }
      ad.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
      if (com.tencent.mm.vfs.i.eK(paramBundle.path)) {
        com.tencent.mm.pluginsdk.model.app.r.b(paramContext, paramBundle.path, null, false);
      }
      AppMethodBeat.o(31947);
      return;
    }
    t.makeText(paramContext, paramContext.getString(2131757267), 2000).show();
    paramBundle = new g.a();
    paramBundle.Sr("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
    paramBundle.St(paramContext.getString(2131757273));
    paramBundle.zO(1);
    paramBundle.jc(true);
    f.bQt().a(paramBundle.ofF);
    AppMethodBeat.o(31947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.r
 * JD-Core Version:    0.7.0.1
 */