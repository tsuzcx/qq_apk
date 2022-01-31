package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.blx;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends n
{
  public m() {}
  
  public m(int paramInt)
  {
    y.i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", new Object[] { Integer.valueOf(paramInt) });
    blx localblx = new blx();
    localblx.hQR = paramInt;
    this.rXd.clear();
    this.rXd.add(localblx);
  }
  
  protected final q clE()
  {
    b.a locala = new b.a();
    pm localpm = new pm();
    localpm.sNo.addAll(this.rXd);
    locala.ecH = localpm;
    locala.ecI = new pn();
    locala.uri = "/cgi-bin/micromsg-bin/checkresupdate";
    locala.ecG = 721;
    locala.ecJ = 0;
    locala.ecK = 0;
    return locala.Kt();
  }
  
  protected final String getTag()
  {
    return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
  }
  
  public final int getType()
  {
    return 721;
  }
  
  protected final pn i(q paramq)
  {
    return (pn)((b)paramq).ecF.ecN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.m
 * JD-Core Version:    0.7.0.1
 */