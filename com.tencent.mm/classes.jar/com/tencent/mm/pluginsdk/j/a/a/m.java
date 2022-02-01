package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends n
{
  public m() {}
  
  public m(int paramInt)
  {
    AppMethodBeat.i(152000);
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", new Object[] { Integer.valueOf(paramInt) });
    dpb localdpb = new dpb();
    localdpb.oUv = paramInt;
    this.JZC.clear();
    this.JZC.add(localdpb);
    AppMethodBeat.o(152000);
  }
  
  protected final String getTag()
  {
    return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
  }
  
  public final int getType()
  {
    return 721;
  }
  
  protected final s gnS()
  {
    AppMethodBeat.i(152001);
    Object localObject = new d.a();
    zh localzh = new zh();
    localzh.LkB.addAll(this.JZC);
    ((d.a)localObject).iLN = localzh;
    ((d.a)localObject).iLO = new zi();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkresupdate";
    ((d.a)localObject).funcId = 721;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).aXF();
    AppMethodBeat.o(152001);
    return localObject;
  }
  
  protected final zi h(s params)
  {
    return (zi)((d)params).iLL.iLR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.m
 * JD-Core Version:    0.7.0.1
 */