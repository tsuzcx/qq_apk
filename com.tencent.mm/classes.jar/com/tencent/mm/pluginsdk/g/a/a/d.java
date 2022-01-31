package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.g.a.b.e;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class d
  extends n.a<c>
{
  public d(c paramc)
  {
    super(paramc);
  }
  
  protected final m a(com.tencent.mm.pluginsdk.g.a.c.j paramj)
  {
    c localc = (c)aci();
    String str1 = i.Wg(localc.rVT);
    String str2 = localc.bIW;
    if ((localc.qZj) && (bk.pm(g.bQ(i.Wg(localc.rVT))).equals(str2)))
    {
      y.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
      return new m(localc, a.Jr(str1));
    }
    if ((!bk.bE(((c)aci()).rWy)) && (a.v(i.Wg(((c)aci()).rVT), ((c)aci()).rWy)) && (bk.pm(g.bQ(i.Wg(((c)aci()).rVT))).equals(((c)aci()).bIW))) {
      return new m((l)aci(), a.Jr(i.Wg(((c)aci()).rVT)));
    }
    paramj = super.a(paramj);
    y.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = " + paramj, new Object[] { localc.rVT });
    if (paramj == null) {
      return new m("CheckResUpdate", cls(), getURL(), bjl(), 0L, "", new e());
    }
    if (paramj.status == 2)
    {
      if ((!bk.bl(((c)aci()).bIW)) && (((c)aci()).bIW.equals(g.bQ(bjl())))) {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", new Object[] { localc.rVT });
      }
    }
    else {
      return paramj;
    }
    y.i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", new Object[] { localc.rVT });
    return new m("CheckResUpdate", cls(), getURL(), bjl(), paramj.ceJ, paramj.aRN, new com.tencent.mm.pluginsdk.g.a.b.c());
  }
  
  public final String acb()
  {
    return "CheckResUpdate";
  }
  
  public final boolean ach()
  {
    if (super.ach())
    {
      j.s(((c)aci()).rWb, 12L);
      return true;
    }
    j.s(((c)aci()).rWb, 27L);
    return false;
  }
  
  public final boolean ct(long paramLong)
  {
    if ((((c)aci()).fileSize > 0L) && (((c)aci()).fileSize != a.Jr(bjl()) + paramLong)) {
      return false;
    }
    return super.ct(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.d
 * JD-Core Version:    0.7.0.1
 */