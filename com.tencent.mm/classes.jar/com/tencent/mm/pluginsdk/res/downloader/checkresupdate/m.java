package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.esb;
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
    esb localesb = new esb();
    localesb.vhJ = paramInt;
    this.XWj.clear();
    this.XWj.add(localesb);
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
  
  protected final abj i(s params)
  {
    AppMethodBeat.i(245035);
    params = (abj)c.c.b(((c)params).otC);
    AppMethodBeat.o(245035);
    return params;
  }
  
  protected final s iJy()
  {
    AppMethodBeat.i(152001);
    Object localObject = new c.a();
    abi localabi = new abi();
    localabi.ZjU.addAll(this.XWj);
    ((c.a)localObject).otE = localabi;
    ((c.a)localObject).otF = new abj();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/checkresupdate";
    ((c.a)localObject).funcId = 721;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    AppMethodBeat.o(152001);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.m
 * JD-Core Version:    0.7.0.1
 */