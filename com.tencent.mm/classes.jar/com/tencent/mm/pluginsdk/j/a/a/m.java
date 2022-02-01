package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends n
{
  public m() {}
  
  public m(int paramInt)
  {
    AppMethodBeat.i(152000);
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", new Object[] { Integer.valueOf(paramInt) });
    cvo localcvo = new cvo();
    localcvo.nEf = paramInt;
    this.EQn.clear();
    this.EQn.add(localcvo);
    AppMethodBeat.o(152000);
  }
  
  protected final q faU()
  {
    AppMethodBeat.i(152001);
    Object localObject = new b.a();
    xs localxs = new xs();
    localxs.FXq.addAll(this.EQn);
    ((b.a)localObject).hNM = localxs;
    ((b.a)localObject).hNN = new xt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkresupdate";
    ((b.a)localObject).funcId = 721;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDC();
    AppMethodBeat.o(152001);
    return localObject;
  }
  
  protected final String getTag()
  {
    return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
  }
  
  public final int getType()
  {
    return 721;
  }
  
  protected final xt h(q paramq)
  {
    return (xt)((b)paramq).hNL.hNQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.m
 * JD-Core Version:    0.7.0.1
 */