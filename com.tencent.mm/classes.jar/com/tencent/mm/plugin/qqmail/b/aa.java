package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.LinkedList;

public final class aa
{
  ac uKG;
  ArrayList<ab> uMp;
  z uMq;
  boolean uMr;
  ac.f uMs;
  ac.e uMt;
  
  public aa()
  {
    AppMethodBeat.i(122766);
    this.uMp = new ArrayList();
    this.uKG = ((o)g.ad(o.class)).getShareModeMailAppService();
    this.uMq = null;
    this.uMr = false;
    this.uMs = new ac.f()
    {
      public final void aq(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(122764);
        if (paramAnonymousInt1 == paramAnonymousInt2)
        {
          ad.i("MicroMsg.ShareMailQueue", "finished one job, queue.size = %d", new Object[] { Integer.valueOf(aa.this.uMp.size()) });
          if (aa.this.uMq != null) {
            aa.this.uMq.akY(paramAnonymousString);
          }
          if (aa.this.uMp.size() > 0)
          {
            ad.i("MicroMsg.ShareMailQueue", "continue to send next mail");
            paramAnonymousString = (ab)aa.this.uMp.remove(0);
            aa.this.b(paramAnonymousString);
            aa.this.uKG.a(this, aa.this.uMt);
            AppMethodBeat.o(122764);
            return;
          }
          ad.i("MicroMsg.ShareMailQueue", "finished sent all mails");
          aa.this.uMr = false;
        }
        AppMethodBeat.o(122764);
      }
    };
    this.uMt = new ac.e()
    {
      public final void ala(String paramAnonymousString)
      {
        AppMethodBeat.i(122765);
        z localz;
        if (aa.this.uMq != null)
        {
          localz = aa.this.uMq;
          if (!bt.isNullOrNil(paramAnonymousString)) {
            break label104;
          }
          ad.w("MicroMsg.ShareMailInfoMgr", "notify fail error, subject is null");
        }
        while (aa.this.uMp.size() > 0)
        {
          ad.i("MicroMsg.ShareMailQueue", "continue to send next mail");
          paramAnonymousString = (ab)aa.this.uMp.remove(0);
          aa.this.b(paramAnonymousString);
          aa.this.uKG.a(aa.this.uMs, this);
          AppMethodBeat.o(122765);
          return;
          label104:
          z.akZ(paramAnonymousString);
          localz.akY(paramAnonymousString);
        }
        ad.i("MicroMsg.ShareMailQueue", "final job fail");
        aa.this.uMr = false;
        AppMethodBeat.o(122765);
      }
    };
    AppMethodBeat.o(122766);
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(122767);
    if (!g.afz().aeI())
    {
      AppMethodBeat.o(122767);
      return;
    }
    if (this.uMq == null) {
      this.uMq = new z();
    }
    z localz = this.uMq;
    String str = paramab.uLh;
    if (bt.isNullOrNil(str)) {
      ad.w("MicroMsg.ShareMailInfoMgr", "add info fail, info is null");
    }
    for (;;)
    {
      this.uMp.add(paramab);
      ad.d("MicroMsg.ShareMailQueue", "add a new job, queue.size: %d", new Object[] { Integer.valueOf(this.uMp.size()) });
      if (!this.uMr)
      {
        ad.d("MicroMsg.ShareMailQueue", "start execute");
        if (this.uMp.size() > 0)
        {
          this.uMr = true;
          b((ab)this.uMp.remove(0));
          this.uKG.a(this.uMs, this.uMt);
        }
      }
      AppMethodBeat.o(122767);
      return;
      x localx = new x();
      localx.uLh = str;
      localz.uMo.tvP.add(localx);
      localz.save();
    }
  }
  
  final void b(ab paramab)
  {
    AppMethodBeat.i(122768);
    this.uKG.clearData();
    this.uKG.dpv = paramab.dpv;
    this.uKG.uLh = paramab.uLh;
    this.uKG.uLJ = paramab.uLJ;
    this.uKG.uLK = paramab.uLK;
    this.uKG.uMv = paramab.uMv;
    this.uKG.at(paramab.uMw);
    this.uKG.au(paramab.uMx);
    this.uKG.av(paramab.uMy);
    AppMethodBeat.o(122768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.aa
 * JD-Core Version:    0.7.0.1
 */