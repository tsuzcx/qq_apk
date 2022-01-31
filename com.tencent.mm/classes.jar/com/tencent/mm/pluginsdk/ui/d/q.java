package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.s;
import java.io.File;

public final class q
{
  public static void g(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("fromScene");; i = 0)
    {
      h.nFQ.f(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      paramBundle = d.aFP().zM("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
      if ((paramBundle == null) || (paramBundle.status != 3)) {
        break;
      }
      y.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
      if (com.tencent.mm.a.e.bK(paramBundle.path)) {
        com.tencent.mm.pluginsdk.model.app.q.g(paramContext, Uri.fromFile(new File(paramBundle.path)));
      }
      return;
    }
    s.makeText(paramContext, paramContext.getString(R.l.chatting_phone_downloading_wxpb), 2000).show();
    paramBundle = new e.a();
    paramBundle.zN("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
    paramBundle.zP(paramContext.getString(R.l.chatting_phone_wxpb));
    paramBundle.pE(1);
    paramBundle.eO(true);
    d.aFP().a(paramBundle.iPG);
  }
  
  public static boolean tp()
  {
    boolean bool3 = true;
    if (!com.tencent.mm.kernel.g.DN().Dc()) {
      y.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
    }
    int i;
    label85:
    label102:
    do
    {
      return false;
      boolean bool4;
      boolean bool1;
      boolean bool2;
      if ((!bk.fV(ae.getContext())) && (com.tencent.mm.sdk.platformtools.e.bvj != 1) && (bk.getInt(com.tencent.mm.m.g.AA().getValue("ShowWeixinPBIntro"), 0) == 0) && (!p.o(ae.getContext(), "com.tencent.pb")))
      {
        i = 1;
        if (i != 0) {
          break label175;
        }
        bool4 = bk.fV(ae.getContext());
        if (com.tencent.mm.sdk.platformtools.e.bvj == 1) {
          break label160;
        }
        bool1 = true;
        if (bk.getInt(com.tencent.mm.m.g.AA().getValue("ShowWeixinPBIntro"), 0) != 0) {
          break label165;
        }
        bool2 = true;
        if (p.o(ae.getContext(), "com.tencent.pb")) {
          break label170;
        }
      }
      for (;;)
      {
        y.d("MicroMsg.WxPhoneBookHelper", "%b, %b, %b, %b", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        return false;
        i = 0;
        break;
        bool1 = false;
        break label85;
        bool2 = false;
        break label102;
        bool3 = false;
      }
      i = bk.a((Integer)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uoH, null), 3);
      y.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", new Object[] { Integer.valueOf(i) });
    } while (i <= 0);
    label160:
    label165:
    label170:
    label175:
    com.tencent.mm.kernel.g.DP().Dz().o(352257, Integer.valueOf(i - 1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.q
 * JD-Core Version:    0.7.0.1
 */