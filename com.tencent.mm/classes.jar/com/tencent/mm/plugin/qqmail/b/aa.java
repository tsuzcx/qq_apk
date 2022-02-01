package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.LinkedList;

public final class aa
{
  ac vTx;
  ArrayList<ab> vVf;
  z vVg;
  boolean vVh;
  ac.f vVi;
  ac.e vVj;
  
  public aa()
  {
    AppMethodBeat.i(122766);
    this.vVf = new ArrayList();
    this.vTx = ((o)g.ad(o.class)).getShareModeMailAppService();
    this.vVg = null;
    this.vVh = false;
    this.vVi = new ac.f()
    {
      public final void ap(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(122764);
        if (paramAnonymousInt1 == paramAnonymousInt2)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", new Object[] { Integer.valueOf(aa.this.vVf.size()) });
          if (aa.this.vVg != null) {
            aa.this.vVg.apX(paramAnonymousString);
          }
          if (aa.this.vVf.size() > 0)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareMailQueue", "continue to send next mail");
            paramAnonymousString = (ab)aa.this.vVf.remove(0);
            aa.this.b(paramAnonymousString);
            aa.this.vTx.a(this, aa.this.vVj);
            AppMethodBeat.o(122764);
            return;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareMailQueue", "finished sent all mails");
          aa.this.vVh = false;
        }
        AppMethodBeat.o(122764);
      }
    };
    this.vVj = new ac.e()
    {
      public final void apZ(String paramAnonymousString)
      {
        AppMethodBeat.i(122765);
        z localz;
        if (aa.this.vVg != null)
        {
          localz = aa.this.vVg;
          if (!bs.isNullOrNil(paramAnonymousString)) {
            break label104;
          }
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
        }
        while (aa.this.vVf.size() > 0)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareMailQueue", "continue to send next mail");
          paramAnonymousString = (ab)aa.this.vVf.remove(0);
          aa.this.b(paramAnonymousString);
          aa.this.vTx.a(aa.this.vVi, this);
          AppMethodBeat.o(122765);
          return;
          label104:
          z.apY(paramAnonymousString);
          localz.apX(paramAnonymousString);
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ShareMailQueue", "final job fail");
        aa.this.vVh = false;
        AppMethodBeat.o(122765);
      }
    };
    AppMethodBeat.o(122766);
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(122767);
    if (!g.agP().afY())
    {
      AppMethodBeat.o(122767);
      return;
    }
    if (this.vVg == null) {
      this.vVg = new z();
    }
    z localz = this.vVg;
    String str = paramab.vTY;
    if (bs.isNullOrNil(str)) {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
    }
    for (;;)
    {
      this.vVf.add(paramab);
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", new Object[] { Integer.valueOf(this.vVf.size()) });
      if (!this.vVh)
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ShareMailQueue", "start execute");
        if (this.vVf.size() > 0)
        {
          this.vVh = true;
          b((ab)this.vVf.remove(0));
          this.vTx.a(this.vVi, this.vVj);
        }
      }
      AppMethodBeat.o(122767);
      return;
      x localx = new x();
      localx.vTY = str;
      localz.vVe.uEi.add(localx);
      localz.save();
    }
  }
  
  final void b(ab paramab)
  {
    AppMethodBeat.i(122768);
    this.vTx.clearData();
    this.vTx.dng = paramab.dng;
    this.vTx.vTY = paramab.vTY;
    this.vTx.vUz = paramab.vUz;
    this.vTx.vUA = paramab.vUA;
    this.vTx.vVl = paramab.vVl;
    this.vTx.av(paramab.vVm);
    this.vTx.aw(paramab.vVn);
    this.vTx.ax(paramab.vVo);
    AppMethodBeat.o(122768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.aa
 * JD-Core Version:    0.7.0.1
 */