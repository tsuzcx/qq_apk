package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.zl;
import com.tencent.mm.protocal.protobuf.zm;
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
    dyx localdyx = new dyx();
    localdyx.rWu = paramInt;
    this.Raf.clear();
    this.Raf.add(localdyx);
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
  
  protected final s hiz()
  {
    AppMethodBeat.i(152001);
    Object localObject = new d.a();
    zl localzl = new zl();
    localzl.SlK.addAll(this.Raf);
    ((d.a)localObject).lBU = localzl;
    ((d.a)localObject).lBV = new zm();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkresupdate";
    ((d.a)localObject).funcId = 721;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localObject = ((d.a)localObject).bgN();
    AppMethodBeat.o(152001);
    return localObject;
  }
  
  protected final zm i(s params)
  {
    AppMethodBeat.i(197128);
    params = (zm)d.c.b(((d)params).lBS);
    AppMethodBeat.o(197128);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.m
 * JD-Core Version:    0.7.0.1
 */