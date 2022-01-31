package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class SnsOnlineVideoActivity$5
  implements n.c
{
  SnsOnlineVideoActivity$5(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    int i = 1;
    AppMethodBeat.i(39148);
    if (bo.apV(g.Nq().getValue("SIGHTCannotTransmitForFav")) == 0)
    {
      boolean bool1 = com.tencent.mm.vfs.e.cN(SnsOnlineVideoActivity.t(this.rUf));
      boolean bool2 = com.tencent.mm.vfs.e.cN(SnsOnlineVideoActivity.u(this.rUf));
      ab.i("MicroMsg.SnsOnlineVideoActivity", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      paraml.add(0, 3, 0, this.rUf.getString(2131303767));
      if ((!bool1) || (!bool2)) {}
    }
    for (;;)
    {
      if (d.ahR("favorite")) {
        paraml.add(0, 2, 0, this.rUf.getString(2131302102));
      }
      paraml.add(0, 5, 0, this.rUf.getString(2131302872));
      if (i != 0)
      {
        dr localdr = new dr();
        localdr.crt.crk = SnsOnlineVideoActivity.v(this.rUf);
        a.ymk.l(localdr);
        if (localdr.cru.cqS) {
          paraml.add(0, 4, 0, this.rUf.getString(2131297019));
        }
      }
      AppMethodBeat.o(39148);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.5
 * JD-Core Version:    0.7.0.1
 */