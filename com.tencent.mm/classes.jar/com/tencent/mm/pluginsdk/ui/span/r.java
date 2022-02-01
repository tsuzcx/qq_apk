package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;

public final class r
{
  public static boolean MW()
  {
    boolean bool3 = true;
    AppMethodBeat.i(31945);
    if (!com.tencent.mm.kernel.g.ajA().aiK())
    {
      ad.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
      AppMethodBeat.o(31945);
      return false;
    }
    boolean bool4;
    boolean bool1;
    label97:
    boolean bool2;
    if ((!bt.jk(aj.getContext())) && (j.cSc != 1) && (bt.getInt(com.tencent.mm.n.g.acA().getValue("ShowWeixinPBIntro"), 0) == 0) && (!q.s(aj.getContext(), "com.tencent.pb")))
    {
      i = 1;
      if (i != 0) {
        break label193;
      }
      bool4 = bt.jk(aj.getContext());
      if (j.cSc == 1) {
        break label178;
      }
      bool1 = true;
      if (bt.getInt(com.tencent.mm.n.g.acA().getValue("ShowWeixinPBIntro"), 0) != 0) {
        break label183;
      }
      bool2 = true;
      label114:
      if (q.s(aj.getContext(), "com.tencent.pb")) {
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
    int i = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irf, null), 3);
    ad.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(31945);
      return false;
    }
    com.tencent.mm.kernel.g.ajC().ajl().set(352257, Integer.valueOf(i - 1));
    AppMethodBeat.o(31945);
    return true;
  }
  
  public static void feV()
  {
    AppMethodBeat.i(31946);
    int i = bt.a((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irf, null), 3);
    ad.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Irf, Integer.valueOf(i - 1));
    AppMethodBeat.o(31946);
  }
  
  public static void h(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(31947);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("fromScene");; i = 0)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      paramBundle = f.ccl().aaj("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
      if ((paramBundle == null) || (paramBundle.status != 3)) {
        break;
      }
      ad.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
      if (i.fv(paramBundle.path)) {
        com.tencent.mm.pluginsdk.model.app.r.b(paramContext, paramBundle.path, null, false);
      }
      AppMethodBeat.o(31947);
      return;
    }
    t.makeText(paramContext, paramContext.getString(2131757267), 2000).show();
    paramBundle = new g.a();
    paramBundle.aak("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
    paramBundle.aam(paramContext.getString(2131757273));
    paramBundle.Bp(1);
    paramBundle.jQ(true);
    f.ccl().a(paramBundle.pmN);
    AppMethodBeat.o(31947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.r
 * JD-Core Version:    0.7.0.1
 */