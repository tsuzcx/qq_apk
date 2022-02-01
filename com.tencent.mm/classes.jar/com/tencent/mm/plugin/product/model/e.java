package com.tencent.mm.plugin.product.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.etr;
import com.tencent.mm.protocal.protobuf.ve;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class e
  extends p
  implements m
{
  private h callback;
  private c rr;
  
  public e(LinkedList<etr> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(66888);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ve();
    ((c.a)localObject).otF = new vf();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/cancelpreorder";
    ((c.a)localObject).funcId = 555;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ve)c.b.b(this.rr.otB);
    ((ve)localObject).Zbf = paramLinkedList;
    if (paramLinkedList != null) {
      i = paramLinkedList.size();
    }
    ((ve)localObject).MFk = i;
    ((ve)localObject).Zbg = paramString;
    Log.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(66888);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(66890);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(66890);
    return i;
  }
  
  public final int getType()
  {
    return 555;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66889);
    paramArrayOfByte = (vf)c.c.b(((c)params).otC);
    paramInt1 = paramInt3;
    params = paramString;
    if (paramInt3 == 0)
    {
      paramInt1 = paramInt3;
      params = paramString;
      if (paramArrayOfByte.YME != 0)
      {
        paramInt1 = paramArrayOfByte.YME;
        params = paramArrayOfByte.YMF;
      }
    }
    Log.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + paramInt1 + ", errMsg " + params);
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(66889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.model.e
 * JD-Core Version:    0.7.0.1
 */