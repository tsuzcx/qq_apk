package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.protocal.c.vo;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.protocal.p.b;
import java.util.LinkedList;

public final class o
  extends n
{
  public static void awa()
  {
    o localo = new o();
    g.DO().dJT.a(localo, 0);
  }
  
  protected final q clE()
  {
    o.a locala = new o.a();
    p.a locala1 = (p.a)locala.rXh;
    locala1.fn(0);
    locala1.sqa.sSR.sSP.sNo.addAll(this.rXd);
    return locala;
  }
  
  protected final String getTag()
  {
    return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneEncryptCheckResUpdate";
  }
  
  public final int getType()
  {
    return 722;
  }
  
  protected final pn i(q paramq)
  {
    return ((o.a)paramq).rXi.sqd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.o
 * JD-Core Version:    0.7.0.1
 */