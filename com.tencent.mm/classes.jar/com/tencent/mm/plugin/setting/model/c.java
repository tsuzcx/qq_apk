package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.protocal.protobuf.euz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  private i callback;
  private List<String> wtq;
  
  public c(List<String> paramList)
  {
    this.wtq = paramList;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73763);
    this.callback = parami;
    parami = new d.a();
    dm localdm = new dm();
    ArrayList localArrayList = new ArrayList();
    if (this.wtq != null)
    {
      i = 0;
      while (i < this.wtq.size())
      {
        euz localeuz = new euz();
        localeuz.UserName = ((String)this.wtq.get(i));
        localArrayList.add(localeuz);
        i += 1;
      }
    }
    localdm.RIV.addAll(localArrayList);
    parami.lBU = localdm;
    parami.lBV = new dn();
    parami.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
    parami.funcId = 583;
    parami.lBW = 0;
    parami.lBW = 0;
    int i = dispatch(paramg, parami.bgN(), this);
    AppMethodBeat.o(73763);
    return i;
  }
  
  public final int getType()
  {
    return 583;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(73762);
    updateDispatchIdNew(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      Log.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(73762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.c
 * JD-Core Version:    0.7.0.1
 */