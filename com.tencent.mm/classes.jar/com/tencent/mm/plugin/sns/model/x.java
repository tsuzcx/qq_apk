package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ekw;
import com.tencent.mm.protocal.protobuf.ekz;
import com.tencent.mm.protocal.protobuf.ela;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class x
  extends q
  implements m
{
  private long JWb;
  public i callback;
  private int fCN;
  private d rr;
  private int scene;
  
  public x(int paramInt1, long paramLong, String paramString, int paramInt2, List<String> paramList, int paramInt3)
  {
    AppMethodBeat.i(95655);
    this.scene = 0;
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + paramInt1 + " tagName " + paramString + " memberList " + paramList.size() + " scene " + paramInt3);
    this.fCN = paramInt1;
    this.JWb = paramLong;
    this.scene = paramInt3;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ekz();
    ((d.a)localObject).lBV = new ela();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
    ((d.a)localObject).funcId = 291;
    ((d.a)localObject).lBW = 115;
    ((d.a)localObject).respCmdId = 1000000115;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ekz)d.b.b(this.rr.lBR);
    ((ekz)localObject).RLe = paramInt1;
    ((ekz)localObject).UmL = paramLong;
    ((ekz)localObject).CQx = paramString;
    ((ekz)localObject).rVx = paramInt2;
    ((ekz)localObject).CPw = this.scene;
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString.add(new eaf().btQ(str));
    }
    ((ekz)localObject).rVy = paramString;
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + localObject.toString());
    AppMethodBeat.o(95655);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95656);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95656);
    return i;
  }
  
  public final int getType()
  {
    return 291;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95657);
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
    }
    params = ((ela)d.c.b(((d)params).lBS)).UmN;
    Log.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + params.toString());
    paramArrayOfByte = aj.fOO().Rf(params.UmL);
    paramArrayOfByte.field_tagId = params.UmL;
    paramArrayOfByte.field_tagName = Util.nullAs(params.CQx, "");
    switch (this.fCN)
    {
    }
    for (;;)
    {
      aj.fOO().a(paramArrayOfByte);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
      paramArrayOfByte.field_count = params.rVx;
      paramArrayOfByte.hF(params.rVy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.x
 * JD-Core Version:    0.7.0.1
 */