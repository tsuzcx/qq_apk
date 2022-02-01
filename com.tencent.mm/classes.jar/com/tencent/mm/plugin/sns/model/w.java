package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends n
  implements k
{
  public f callback;
  private int dsO;
  private b rr;
  private int scene;
  private long zyR;
  
  public w(int paramInt1, long paramLong, String paramString, int paramInt2, List<String> paramList, int paramInt3)
  {
    AppMethodBeat.i(95655);
    this.scene = 0;
    ae.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + paramInt1 + " tagName " + paramString + " memberList " + paramList.size() + " scene " + paramInt3);
    this.dsO = paramInt1;
    this.zyR = paramLong;
    this.scene = paramInt3;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dhq();
    ((b.a)localObject).hQG = new dhr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
    ((b.a)localObject).funcId = 291;
    ((b.a)localObject).hQH = 115;
    ((b.a)localObject).respCmdId = 1000000115;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dhq)this.rr.hQD.hQJ;
    ((dhq)localObject).OpCode = paramInt1;
    ((dhq)localObject).HOG = paramLong;
    ((dhq)localObject).uum = paramString;
    ((dhq)localObject).nID = paramInt2;
    ((dhq)localObject).Scene = this.scene;
    paramString = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      paramString.add(new cxn().aQV(str));
    }
    ((dhq)localObject).nIE = paramString;
    ae.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + localObject.toString());
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
    ae.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
    }
    paramq = ((dhr)((b)paramq).hQE.hQJ).HOI;
    ae.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + paramq.toString());
    paramArrayOfByte = ah.dXK().AI(paramq.HOG);
    paramArrayOfByte.field_tagId = paramq.HOG;
    paramArrayOfByte.field_tagName = bu.bI(paramq.uum, "");
    switch (this.dsO)
    {
    }
    for (;;)
    {
      ah.dXK().a(paramArrayOfByte);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95657);
      return;
      paramArrayOfByte.field_count = paramq.nID;
      paramArrayOfByte.gb(paramq.nIE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.w
 * JD-Core Version:    0.7.0.1
 */