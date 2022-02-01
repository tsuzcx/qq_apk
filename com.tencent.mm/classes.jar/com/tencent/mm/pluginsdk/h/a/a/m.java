package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.protocal.protobuf.vk;
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
    clc localclc = new clc();
    localclc.mBH = paramInt;
    this.BSV.clear();
    this.BSV.add(localclc);
    AppMethodBeat.o(152000);
  }
  
  protected final q ewD()
  {
    AppMethodBeat.i(152001);
    Object localObject = new b.a();
    vj localvj = new vj();
    localvj.CXw.addAll(this.BSV);
    ((b.a)localObject).gUU = localvj;
    ((b.a)localObject).gUV = new vk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkresupdate";
    ((b.a)localObject).funcId = 721;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
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
  
  protected final vk h(q paramq)
  {
    return (vk)((b)paramq).gUT.gUX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.m
 * JD-Core Version:    0.7.0.1
 */