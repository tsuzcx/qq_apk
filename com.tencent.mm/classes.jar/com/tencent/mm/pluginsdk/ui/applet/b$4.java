package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;

final class b$4
  implements com.tencent.mm.ah.f
{
  b$4(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.sbU.faz != null) {
      this.sbU.faz.dismiss();
    }
    if (this.sbU.sbS != null)
    {
      g.DQ();
      g.DO().dJT.b(106, this.sbU.sbS);
    }
    if (this.sbU.faz == null)
    {
      y.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
      this.sbU.hK(0);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.sbU.hK(-1);
      return;
    }
    if (this.sbU.mContext == null)
    {
      y.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
      this.sbU.hK(-1);
      return;
    }
    if (((this.sbU.mContext instanceof Activity)) && (((Activity)this.sbU.mContext).isFinishing()))
    {
      y.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
      this.sbU.hK(-1);
      return;
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bhH();
    paramm = aa.a(paramString.sQs);
    if (bk.bl(paramm))
    {
      y.e("MicroMsg.AddContactDialog", "searchContact, user is null");
      h.bC(this.sbU.mContext, this.sbU.mContext.getResources().getString(R.l.wv_follow_is_not_biz));
      this.sbU.hK(-1);
      return;
    }
    if ((this.sbU.hcm == null) || (!this.sbU.hcm.equals(paramm))) {
      y.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { this.sbU.hcm, paramm });
    }
    b localb = this.sbU;
    g.DQ();
    localb.jgl = ((j)g.r(j.class)).Fw().abl(paramm);
    if ((this.sbU.jgl == null) || ((int)this.sbU.jgl.dBe == 0))
    {
      y.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramm + ", try get by alias");
      localb = this.sbU;
      g.DQ();
      localb.jgl = ((j)g.r(j.class)).Fw().abh(paramm);
      if ((this.sbU.jgl == null) || ((int)this.sbU.jgl.dBe == 0))
      {
        y.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
        this.sbU.jgl = new ad(paramm);
        this.sbU.jgl.cZ(paramString.ffm);
        this.sbU.jgl.dk(aa.a(paramString.tmw));
        this.sbU.jgl.dl(aa.a(paramString.sQa));
        this.sbU.jgl.dm(aa.a(paramString.sQb));
        this.sbU.jgl.fm(paramString.ffh);
        this.sbU.jgl.dF(RegionCodeDecoder.ao(paramString.ffq, paramString.ffi, paramString.ffj));
        this.sbU.jgl.dz(paramString.ffk);
        this.sbU.jgl.fi(paramString.tpg);
        this.sbU.jgl.dE(paramString.tph);
        this.sbU.jgl.fh(paramString.tpk);
        this.sbU.jgl.dn(paramString.tpj);
        this.sbU.jgl.dD(paramString.tpi);
      }
    }
    for (;;)
    {
      this.sbU.Q(this.sbU.jgl);
      return;
      y.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramm });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b.4
 * JD-Core Version:    0.7.0.1
 */