package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.cfa;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends m
  implements k
{
  public f callback;
  private int ctW;
  private long rfq;
  private b rr;
  private int scene;
  
  public w(int paramInt1, long paramLong, String paramString, int paramInt2, List<String> paramList, int paramInt3)
  {
    AppMethodBeat.i(36330);
    this.scene = 0;
    ab.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + paramInt1 + " tagName " + paramString + " memberList " + paramList.size() + " scene " + paramInt3);
    this.ctW = paramInt1;
    this.rfq = paramLong;
    this.scene = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cfa();
    ((b.a)localObject).fsY = new cfb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
    ((b.a)localObject).funcId = 291;
    ((b.a)localObject).reqCmdId = 115;
    ((b.a)localObject).respCmdId = 1000000115;
    this.rr = ((b.a)localObject).ado();
    localObject = (cfa)this.rr.fsV.fta;
    ((cfa)localObject).OpCode = paramInt1;
    ((cfa)localObject).xPq = paramLong;
    ((cfa)localObject).ntn = paramString;
    ((cfa)localObject).jJu = paramInt2;
    ((cfa)localObject).Scene = this.scene;
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString.add(new bwc().aoF(str));
    }
    ((cfa)localObject).jJv = paramString;
    ab.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + localObject.toString());
    AppMethodBeat.o(36330);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(36331);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36331);
    return i;
  }
  
  public final int getType()
  {
    return 291;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36332);
    ab.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36332);
      return;
    }
    paramq = ((cfb)((b)paramq).fsW.fta).xPs;
    ab.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + paramq.toString());
    paramArrayOfByte = ag.cpl().mb(paramq.xPq);
    paramArrayOfByte.field_tagId = paramq.xPq;
    paramArrayOfByte.field_tagName = bo.bf(paramq.ntn, "");
    switch (this.ctW)
    {
    }
    for (;;)
    {
      ag.cpl().a(paramArrayOfByte);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36332);
      return;
      paramArrayOfByte.field_count = paramq.jJu;
      paramArrayOfByte.dj(paramq.jJv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.w
 * JD-Core Version:    0.7.0.1
 */