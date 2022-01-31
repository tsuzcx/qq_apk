package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.d;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.List;

final class m$b
  implements az.a
{
  private com.tencent.mm.ui.chatting.d.a caz;
  private Context context;
  private String fuO;
  private long jUy;
  private boolean muT;
  private m.a zyD;
  
  public m$b(com.tencent.mm.ui.chatting.d.a parama, Context paramContext, String paramString, long paramLong, m.a parama1)
  {
    AppMethodBeat.i(30606);
    this.caz = parama;
    this.context = paramContext;
    this.fuO = paramString;
    this.jUy = paramLong;
    this.zyD = parama1;
    this.muT = f.lg(paramString);
    AppMethodBeat.o(30606);
  }
  
  private void a(Context paramContext, bi parambi, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(30608);
    if (parambi.isText())
    {
      j.a(paramContext, paramString, parambi, paramBoolean);
      AppMethodBeat.o(30608);
      return;
    }
    if (parambi.dvX())
    {
      j.b(paramContext, paramString, parambi);
      AppMethodBeat.o(30608);
      return;
    }
    if ((parambi.byj()) && (!this.muT))
    {
      j.c(paramContext, paramString, parambi);
      AppMethodBeat.o(30608);
      return;
    }
    if (parambi.bCp())
    {
      j.c(paramContext, paramString, parambi, paramBoolean);
      AppMethodBeat.o(30608);
      return;
    }
    if (((parambi.dxS()) || (parambi.dxT())) && (!this.muT))
    {
      if (!j.aw(parambi))
      {
        j.a(paramContext, paramString, parambi);
        AppMethodBeat.o(30608);
      }
    }
    else if (parambi.bCn())
    {
      if ((this.muT) && (!j.aE(parambi)))
      {
        AppMethodBeat.o(30608);
        return;
      }
      if (j.aF(parambi))
      {
        AppMethodBeat.o(30608);
        return;
      }
      if (parambi.getType() == 318767153)
      {
        AppMethodBeat.o(30608);
        return;
      }
      if (j.aJ(parambi))
      {
        AppMethodBeat.o(30608);
        return;
      }
      if (!j.ay(parambi)) {
        j.b(paramContext, paramString, parambi, paramBoolean);
      }
    }
    AppMethodBeat.o(30608);
  }
  
  private void dGq()
  {
    AppMethodBeat.i(30609);
    Iterator localIterator = this.zyD.zyt.iterator();
    while (localIterator.hasNext())
    {
      bi localbi = (bi)localIterator.next();
      a(this.context, localbi, this.zyD.zvB, this.fuO);
    }
    AppMethodBeat.o(30609);
  }
  
  private void dGr()
  {
    AppMethodBeat.i(30610);
    m.bQ(this.context, this.fuO);
    oa localoa = new oa();
    localoa.cEz.type = 5;
    localoa.cEz.cEF = this.zyD.zyt;
    localoa.cEz.toUser = this.fuO;
    localoa.cEz.cEG = this.zyD.cEG;
    localoa.cEz.context = this.context;
    localoa.cEz.cDZ = this.zyD.cDZ;
    localoa.cEz.cEI = this.zyD.zyu;
    com.tencent.mm.sdk.b.a.ymk.l(localoa);
    AppMethodBeat.o(30610);
  }
  
  public final boolean acS()
  {
    AppMethodBeat.i(30607);
    if (this.muT)
    {
      c localc = z.afk().aG(this.jUy);
      synchronized (e.fxC)
      {
        String str = e.aaQ();
        e.d(localc);
        if (this.zyD.zyC)
        {
          dGq();
          e.ss(str);
          AppMethodBeat.o(30607);
          return true;
        }
        dGr();
      }
    }
    if (this.zyD.zyC) {
      dGq();
    }
    for (;;)
    {
      AppMethodBeat.o(30607);
      return true;
      dGr();
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(30611);
    if (m.dGp() != null) {
      m.dGp().dismiss();
    }
    b.a(this.context, this.caz.findViewById(2131826124), this.context.getString(2131299979), null);
    AppMethodBeat.o(30611);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.b
 * JD-Core Version:    0.7.0.1
 */