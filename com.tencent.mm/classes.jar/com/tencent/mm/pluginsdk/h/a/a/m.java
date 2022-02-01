package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.protocal.protobuf.vu;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends n
{
  public m() {}
  
  public m(int paramInt)
  {
    AppMethodBeat.i(152000);
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", new Object[] { Integer.valueOf(paramInt) });
    cqj localcqj = new cqj();
    localcqj.ndI = paramInt;
    this.Dll.clear();
    this.Dll.add(localcqj);
    AppMethodBeat.o(152000);
  }
  
  protected final q eLX()
  {
    AppMethodBeat.i(152001);
    Object localObject = new b.a();
    vt localvt = new vt();
    localvt.Eqf.addAll(this.Dll);
    ((b.a)localObject).hvt = localvt;
    ((b.a)localObject).hvu = new vu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkresupdate";
    ((b.a)localObject).funcId = 721;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).aAz();
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
  
  protected final vu h(q paramq)
  {
    return (vu)((b)paramq).hvs.hvw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.m
 * JD-Core Version:    0.7.0.1
 */