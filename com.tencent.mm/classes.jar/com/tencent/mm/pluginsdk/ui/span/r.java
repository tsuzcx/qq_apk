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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.o;

public final class r
{
  public static boolean MR()
  {
    boolean bool3 = true;
    AppMethodBeat.i(31945);
    if (!com.tencent.mm.kernel.g.ajP().aiZ())
    {
      ae.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
      AppMethodBeat.o(31945);
      return false;
    }
    boolean bool4;
    boolean bool1;
    label97:
    boolean bool2;
    if ((!bu.jq(ak.getContext())) && (k.cSM != 1) && (bu.getInt(com.tencent.mm.n.g.acL().getValue("ShowWeixinPBIntro"), 0) == 0) && (!q.s(ak.getContext(), "com.tencent.pb")))
    {
      i = 1;
      if (i != 0) {
        break label193;
      }
      bool4 = bu.jq(ak.getContext());
      if (k.cSM == 1) {
        break label178;
      }
      bool1 = true;
      if (bu.getInt(com.tencent.mm.n.g.acL().getValue("ShowWeixinPBIntro"), 0) != 0) {
        break label183;
      }
      bool2 = true;
      label114:
      if (q.s(ak.getContext(), "com.tencent.pb")) {
        break label188;
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.WxPhoneBookHelper", "%b, %b, %b, %b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
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
    int i = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILB, null), 3);
    ae.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(31945);
      return false;
    }
    com.tencent.mm.kernel.g.ajR().ajA().set(352257, Integer.valueOf(i - 1));
    AppMethodBeat.o(31945);
    return true;
  }
  
  public static void fiL()
  {
    AppMethodBeat.i(31946);
    int i = bu.a((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILB, null), 3);
    ae.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.kernel.g.ajR().ajA().set(am.a.ILB, Integer.valueOf(i - 1));
    AppMethodBeat.o(31946);
  }
  
  public static void h(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(31947);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("fromScene");; i = 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      paramBundle = f.cdA().aba("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
      if ((paramBundle == null) || (paramBundle.status != 3)) {
        break;
      }
      ae.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
      if (o.fB(paramBundle.path)) {
        com.tencent.mm.pluginsdk.model.app.r.b(paramContext, paramBundle.path, null, false);
      }
      AppMethodBeat.o(31947);
      return;
    }
    t.makeText(paramContext, paramContext.getString(2131757267), 2000).show();
    paramBundle = new g.a();
    paramBundle.abb("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
    paramBundle.abd(paramContext.getString(2131757273));
    paramBundle.BB(1);
    paramBundle.jP(true);
    f.cdA().a(paramBundle.ptu);
    AppMethodBeat.o(31947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.r
 * JD-Core Version:    0.7.0.1
 */