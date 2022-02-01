package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cwi;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends n
{
  public m() {}
  
  public m(int paramInt)
  {
    AppMethodBeat.i(152000);
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", new Object[] { Integer.valueOf(paramInt) });
    cwi localcwi = new cwi();
    localcwi.nJA = paramInt;
    this.FiI.clear();
    this.FiI.add(localcwi);
    AppMethodBeat.o(152000);
  }
  
  protected final q feI()
  {
    AppMethodBeat.i(152001);
    Object localObject = new b.a();
    xv localxv = new xv();
    localxv.GpP.addAll(this.FiI);
    ((b.a)localObject).hQF = localxv;
    ((b.a)localObject).hQG = new xw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkresupdate";
    ((b.a)localObject).funcId = 721;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aDS();
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
  
  protected final xw h(q paramq)
  {
    return (xw)((b)paramq).hQE.hQJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.m
 * JD-Core Version:    0.7.0.1
 */