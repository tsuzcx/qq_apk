package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends n
  implements k
{
  public g callback;
  private int dgm;
  private b rr;
  private int scene;
  private long xSi;
  
  public v(int paramInt1, long paramLong, String paramString, int paramInt2, List<String> paramList, int paramInt3)
  {
    AppMethodBeat.i(95655);
    this.scene = 0;
    ac.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + paramInt1 + " tagName " + paramString + " memberList " + paramList.size() + " scene " + paramInt3);
    this.dgm = paramInt1;
    this.xSi = paramLong;
    this.scene = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dbj();
    ((b.a)localObject).hvu = new dbk();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
    ((b.a)localObject).funcId = 291;
    ((b.a)localObject).reqCmdId = 115;
    ((b.a)localObject).respCmdId = 1000000115;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dbj)this.rr.hvr.hvw;
    ((dbj)localObject).OpCode = paramInt1;
    ((dbj)localObject).FKv = paramLong;
    ((dbj)localObject).tkJ = paramString;
    ((dbj)localObject).ncL = paramInt2;
    ((dbj)localObject).Scene = this.scene;
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString.add(new crm().aJV(str));
    }
    ((dbj)localObject).ncM = paramString;
    ac.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + localObject.toString());
    AppMethodBeat.o(95655);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(95656);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95656);
    return i;
  }
  
  public final int getType()
  {
    return 291;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95657);
    ac.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
    }
    paramq = ((dbk)((b)paramq).hvs.hvw).FKx;
    ac.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + paramq.toString());
    paramArrayOfByte = af.dHX().xM(paramq.FKv);
    paramArrayOfByte.field_tagId = paramq.FKv;
    paramArrayOfByte.field_tagName = bs.bG(paramq.tkJ, "");
    switch (this.dgm)
    {
    }
    for (;;)
    {
      af.dHX().a(paramArrayOfByte);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
      paramArrayOfByte.field_count = paramq.ncL;
      paramArrayOfByte.fH(paramq.ncM);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.v
 * JD-Core Version:    0.7.0.1
 */