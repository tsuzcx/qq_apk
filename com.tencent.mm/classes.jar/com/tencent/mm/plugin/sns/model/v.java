package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends n
  implements k
{
  public f callback;
  private int drI;
  private b rr;
  private int scene;
  private long zic;
  
  public v(int paramInt1, long paramLong, String paramString, int paramInt2, List<String> paramList, int paramInt3)
  {
    AppMethodBeat.i(95655);
    this.scene = 0;
    ad.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + paramInt1 + " tagName " + paramString + " memberList " + paramList.size() + " scene " + paramInt3);
    this.drI = paramInt1;
    this.zic = paramLong;
    this.scene = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dgw();
    ((b.a)localObject).hNN = new dgx();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
    ((b.a)localObject).funcId = 291;
    ((b.a)localObject).hNO = 115;
    ((b.a)localObject).respCmdId = 1000000115;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dgw)this.rr.hNK.hNQ;
    ((dgw)localObject).OpCode = paramInt1;
    ((dgw)localObject).Hvd = paramLong;
    ((dgw)localObject).uiP = paramString;
    ((dgw)localObject).nDi = paramInt2;
    ((dgw)localObject).Scene = this.scene;
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString.add(new cwt().aPy(str));
    }
    ((dgw)localObject).nDj = paramString;
    ad.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + localObject.toString());
    AppMethodBeat.o(95655);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(95656);
    this.callback = paramf;
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
    ad.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
    }
    paramq = ((dgx)((b)paramq).hNL.hNQ).Hvf;
    ad.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + paramq.toString());
    paramArrayOfByte = ag.dUk().Ak(paramq.Hvd);
    paramArrayOfByte.field_tagId = paramq.Hvd;
    paramArrayOfByte.field_tagName = bt.bI(paramq.uiP, "");
    switch (this.drI)
    {
    }
    for (;;)
    {
      ag.dUk().a(paramArrayOfByte);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
      paramArrayOfByte.field_count = paramq.nDi;
      paramArrayOfByte.fS(paramq.nDj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.v
 * JD-Core Version:    0.7.0.1
 */