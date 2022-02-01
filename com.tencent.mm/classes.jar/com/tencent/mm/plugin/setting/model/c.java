package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.protocal.protobuf.dp;
import com.tencent.mm.protocal.protobuf.eku;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  private i callback;
  private List<String> sNv;
  
  public c(List<String> paramList)
  {
    this.sNv = paramList;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(73763);
    this.callback = parami;
    parami = new d.a();
    do localdo = new do();
    ArrayList localArrayList = new ArrayList();
    if (this.sNv != null)
    {
      i = 0;
      while (i < this.sNv.size())
      {
        eku localeku = new eku();
        localeku.UserName = ((String)this.sNv.get(i));
        localArrayList.add(localeku);
        i += 1;
      }
    }
    localdo.KHC.addAll(localArrayList);
    parami.iLN = localdo;
    parami.iLO = new dp();
    parami.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
    parami.funcId = 583;
    parami.iLP = 0;
    parami.iLP = 0;
    int i = dispatch(paramg, parami.aXF(), this);
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