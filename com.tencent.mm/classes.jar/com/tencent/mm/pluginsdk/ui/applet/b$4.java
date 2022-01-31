package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;

final class b$4
  implements com.tencent.mm.ai.f
{
  b$4(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(27627);
    if (this.vTc.gsr != null) {
      this.vTc.gsr.dismiss();
    }
    if (this.vTc.vTa != null)
    {
      g.RM();
      g.RK().eHt.b(106, this.vTc.vTa);
    }
    if (this.vTc.gsr == null)
    {
      ab.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
      this.vTc.kw(0);
      AppMethodBeat.o(27627);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.vTc.kw(-1);
      AppMethodBeat.o(27627);
      return;
    }
    if (this.vTc.mContext == null)
    {
      ab.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
      this.vTc.kw(-1);
      AppMethodBeat.o(27627);
      return;
    }
    if (((this.vTc.mContext instanceof Activity)) && (((Activity)this.vTc.mContext).isFinishing()))
    {
      ab.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
      this.vTc.kw(-1);
      AppMethodBeat.o(27627);
      return;
    }
    paramString = ((com.tencent.mm.plugin.messenger.a.f)paramm).bPI();
    paramm = aa.a(paramString.wOT);
    if (bo.isNullOrNil(paramm))
    {
      ab.e("MicroMsg.AddContactDialog", "searchContact, user is null");
      h.bO(this.vTc.mContext, this.vTc.mContext.getResources().getString(2131306018));
      this.vTc.kw(-1);
      AppMethodBeat.o(27627);
      return;
    }
    if ((this.vTc.ikj == null) || (!this.vTc.ikj.equals(paramm))) {
      ab.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", new Object[] { this.vTc.ikj, paramm });
    }
    b localb = this.vTc;
    g.RM();
    localb.lpe = ((j)g.E(j.class)).YA().arw(paramm);
    if ((this.vTc.lpe == null) || ((int)this.vTc.lpe.euF == 0))
    {
      ab.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + paramm + ", try get by alias");
      localb = this.vTc;
      g.RM();
      localb.lpe = ((j)g.E(j.class)).YA().ars(paramm);
      if ((this.vTc.lpe == null) || ((int)this.vTc.lpe.euF == 0))
      {
        ab.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
        this.vTc.lpe = new ad(paramm);
        this.vTc.lpe.jm(paramString.gwU);
        this.vTc.lpe.jp(aa.a(paramString.xmi));
        this.vTc.lpe.jq(aa.a(paramString.wOv));
        this.vTc.lpe.jr(aa.a(paramString.wOw));
        this.vTc.lpe.hy(paramString.gwP);
        this.vTc.lpe.jL(RegionCodeDecoder.aF(paramString.gwY, paramString.gwQ, paramString.gwR));
        this.vTc.lpe.jF(paramString.gwS);
        this.vTc.lpe.hu(paramString.xpe);
        this.vTc.lpe.jK(paramString.xpf);
        this.vTc.lpe.ht(paramString.xpi);
        this.vTc.lpe.js(paramString.xph);
        this.vTc.lpe.jJ(paramString.xpg);
      }
    }
    for (;;)
    {
      this.vTc.T(this.vTc.lpe);
      AppMethodBeat.o(27627);
      return;
      ab.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", new Object[] { paramm });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.b.4
 * JD-Core Version:    0.7.0.1
 */