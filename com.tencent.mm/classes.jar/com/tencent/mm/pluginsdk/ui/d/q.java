package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;
import java.io.File;

public final class q
{
  public static boolean BT()
  {
    boolean bool3 = true;
    AppMethodBeat.i(28155);
    if (!com.tencent.mm.kernel.g.RJ().QU())
    {
      ab.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
      AppMethodBeat.o(28155);
      return false;
    }
    boolean bool4;
    boolean bool1;
    label97:
    boolean bool2;
    if ((!bo.hl(ah.getContext())) && (com.tencent.mm.sdk.platformtools.g.bWu != 1) && (bo.getInt(com.tencent.mm.m.g.Nq().getValue("ShowWeixinPBIntro"), 0) == 0) && (!p.u(ah.getContext(), "com.tencent.pb")))
    {
      i = 1;
      if (i != 0) {
        break label193;
      }
      bool4 = bo.hl(ah.getContext());
      if (com.tencent.mm.sdk.platformtools.g.bWu == 1) {
        break label178;
      }
      bool1 = true;
      if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("ShowWeixinPBIntro"), 0) != 0) {
        break label183;
      }
      bool2 = true;
      label114:
      if (p.u(ah.getContext(), "com.tencent.pb")) {
        break label188;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.WxPhoneBookHelper", "%b, %b, %b, %b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      AppMethodBeat.o(28155);
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
    int i = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyD, null), 3);
    ab.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      AppMethodBeat.o(28155);
      return false;
    }
    com.tencent.mm.kernel.g.RL().Ru().set(352257, Integer.valueOf(i - 1));
    AppMethodBeat.o(28155);
    return true;
  }
  
  public static void dpr()
  {
    AppMethodBeat.i(28156);
    int i = bo.a((Integer)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyD, null), 3);
    ab.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", new Object[] { Integer.valueOf(i) });
    com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yyD, Integer.valueOf(i - 1));
    AppMethodBeat.o(28156);
  }
  
  public static void i(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(28157);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("fromScene");; i = 0)
    {
      h.qsU.e(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      paramBundle = f.bjl().JI("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
      if ((paramBundle == null) || (paramBundle.status != 3)) {
        break;
      }
      ab.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
      if (com.tencent.mm.a.e.cN(paramBundle.path)) {
        com.tencent.mm.pluginsdk.model.app.q.a(paramContext, Uri.fromFile(new File(paramBundle.path)), null);
      }
      AppMethodBeat.o(28157);
      return;
    }
    t.makeText(paramContext, paramContext.getString(2131298276), 2000).show();
    paramBundle = new g.a();
    paramBundle.JJ("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
    paramBundle.JL(paramContext.getString(2131298282));
    paramBundle.tV(1);
    paramBundle.gr(true);
    f.bjl().a(paramBundle.kYR);
    AppMethodBeat.o(28157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.q
 * JD-Core Version:    0.7.0.1
 */