package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgi;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.Locale;

public final class o
  extends n
  implements k
{
  public com.tencent.mm.ak.f callback;
  private b rr;
  private int type;
  private String zxS;
  private dgc zxT;
  
  public o(dgc paramdgc, String paramString)
  {
    AppMethodBeat.i(95586);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dgi();
    ((b.a)localObject).hQG = new dgj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnscomment";
    ((b.a)localObject).funcId = 213;
    ((b.a)localObject).hQH = 100;
    ((b.a)localObject).respCmdId = 1000000100;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dgi)this.rr.hQD.hQJ;
    ((dgi)localObject).HMV = paramdgc;
    this.type = paramdgc.HNs.nJA;
    this.zxT = paramdgc;
    ((dgi)localObject).hFO = paramString;
    this.zxS = paramString;
    ae.d("MicroMsg.NetSceneSnsComment", paramdgc.HNs.HzT + " " + paramdgc.HNs.Gxp);
    AppMethodBeat.o(95586);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(95587);
    Object localObject2 = ah.dXE().AG(this.zxT.Id);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.sns.storage.e locale = ah.dXH().Ax(this.zxT.Id);
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.ebV();
      }
    }
    if (localObject1 != null) {}
    try
    {
      localObject1 = (SnsObject)new SnsObject().parseFrom(((p)localObject1).field_attrBuf);
      if ((((SnsObject)localObject1).ObjectOperations != null) && (((SnsObject)localObject1).ObjectOperations.hasBuffer()))
      {
        localObject2 = (dhb)new dhb().parseFrom(((SnsObject)localObject1).ObjectOperations.getBufferToBytes());
        localObject1 = (dgi)this.rr.hQD.hQJ;
        if (((dhb)localObject2).HOe != null)
        {
          localObject2 = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[] { Integer.valueOf(((dhb)localObject2).HOe.GuO), Integer.valueOf(((dhb)localObject2).HOe.GuP) });
          ae.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[] { localObject2 });
          ((dgi)localObject1).HMW = new cxn().aQV((String)localObject2);
        }
      }
      this.callback = paramf;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(95587);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneSnsComment", localException, "", new Object[0]);
      }
    }
  }
  
  public final int getType()
  {
    return 213;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95588);
    ae.d("MicroMsg.NetSceneSnsComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        ah.dXD().h(this.zxT.Id, this.type, this.zxS);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95588);
      return;
    }
    ah.dXD().h(this.zxT.Id, this.type, this.zxS);
    paramq = this.zxT.HNs;
    if ((paramq.nJA == 1) || (paramq.nJA == 2) || (paramq.nJA == 3) || (paramq.nJA == 5))
    {
      paramArrayOfByte = new dgh();
      paramArrayOfByte.CreateTime = paramq.CreateTime;
      paramArrayOfByte.nJA = paramq.nJA;
      paramArrayOfByte.ucK = paramq.ucK;
      paramArrayOfByte.Username = paramq.HzT;
      paramArrayOfByte.Nickname = paramq.HNh;
      paramArrayOfByte.hFS = paramq.hFS;
      paramArrayOfByte.HNo = paramq.HNo;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = ((dgj)this.rr.hQE.hQJ).HMY;
        if ((paramq.nJA != 1) && (paramq.nJA != 5)) {
          continue;
        }
        ae.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + z.b(paramArrayOfByte.ObjectDesc) + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
        al.e(paramArrayOfByte);
      }
      catch (Exception paramq)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneSnsComment", paramq, "", new Object[0]);
        continue;
      }
      ah.dXD().dXe();
      break;
      ae.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.o
 * JD-Core Version:    0.7.0.1
 */