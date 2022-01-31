package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.f;

final class a$12
  implements a.a
{
  a$12(a parama, ad paramad, int paramInt) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(23217);
    if (paramBoolean1)
    {
      paramString1 = this.pxs;
      paramString2 = this.ejm;
      int i = this.pxx;
      if ((int)paramString2.euF == 0)
      {
        com.tencent.mm.model.aw.aaz();
        c.YA().Z(paramString2);
        com.tencent.mm.model.aw.aaz();
        c.YA().arw(paramString2.field_username);
      }
      if ((int)paramString2.euF <= 0)
      {
        ab.e("MicroMsg.NewContactWidgetNormal", "addContact : insert contact failed");
        AppMethodBeat.o(23217);
        return;
      }
      h localh;
      String str;
      if ((!com.tencent.mm.n.a.je(paramString2.field_type)) && (i == 15))
      {
        com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(paramString2.field_username);
        if ((locala != null) && (!bo.isNullOrNil(paramString2.dqZ)))
        {
          localh = h.qsU;
          str = paramString2.field_username;
          if (!bo.isNullOrNil(locala.Al())) {
            break label247;
          }
          i = 0;
          if (paramString2.dqZ.toString().split(",").length < 5) {
            break label253;
          }
        }
      }
      label247:
      label253:
      for (int j = 5;; j = paramString2.dqZ.toString().split(",").length)
      {
        localh.e(12040, new Object[] { str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j) });
        t.q(paramString2);
        paramString1.iLA.notifyDataSetChanged();
        AppMethodBeat.o(23217);
        return;
        i = 1;
        break;
      }
    }
    if (paramBoolean2)
    {
      d.ali().eD(paramString1, 2);
      AppMethodBeat.o(23217);
      return;
    }
    ab.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(23217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a.12
 * JD-Core Version:    0.7.0.1
 */