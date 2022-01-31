package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.cdt;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.Locale;

public final class o
  extends m
  implements k
{
  public com.tencent.mm.ai.f callback;
  private String reo;
  private cdn rep;
  private b rr;
  private int type;
  
  public o(cdn paramcdn, String paramString)
  {
    AppMethodBeat.i(36261);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cdt();
    ((b.a)localObject).fsY = new cdu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnscomment";
    ((b.a)localObject).funcId = 213;
    ((b.a)localObject).reqCmdId = 100;
    ((b.a)localObject).respCmdId = 1000000100;
    this.rr = ((b.a)localObject).ado();
    localObject = (cdt)this.rr.fsV.fta;
    ((cdt)localObject).xNJ = paramcdn;
    this.type = paramcdn.xOe.jKs;
    this.rep = paramcdn;
    ((cdt)localObject).pIw = paramString;
    this.reo = paramString;
    ab.d("MicroMsg.NetSceneSnsComment", paramcdn.xOe.xCG + " " + paramcdn.xOe.wQO);
    AppMethodBeat.o(36261);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(36262);
    Object localObject2 = ag.cpf().lZ(this.rep.Id);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.sns.storage.e locale = ag.cpi().lQ(this.rep.Id);
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.csn();
      }
    }
    if (localObject1 != null) {}
    try
    {
      localObject1 = (SnsObject)new SnsObject().parseFrom(((n)localObject1).field_attrBuf);
      if ((((SnsObject)localObject1).ObjectOperations != null) && (((SnsObject)localObject1).ObjectOperations.hasBuffer()))
      {
        localObject2 = (cel)new cel().parseFrom(((SnsObject)localObject1).ObjectOperations.getBufferToBytes());
        localObject1 = (cdt)this.rr.fsV.fta;
        if (((cel)localObject2).xOP != null)
        {
          localObject2 = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[] { Integer.valueOf(((cel)localObject2).xOP.wPd), Integer.valueOf(((cel)localObject2).xOP.wPe) });
          ab.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[] { localObject2 });
          ((cdt)localObject1).xNK = new bwc().aoF((String)localObject2);
        }
      }
      this.callback = paramf;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(36262);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneSnsComment", localException, "", new Object[0]);
      }
    }
  }
  
  public final int getType()
  {
    return 213;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36263);
    ab.d("MicroMsg.NetSceneSnsComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        ag.cpe().e(this.rep.Id, this.type, this.reo);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36263);
      return;
    }
    ag.cpe().e(this.rep.Id, this.type, this.reo);
    paramq = this.rep.xOe;
    if ((paramq.jKs == 1) || (paramq.jKs == 2) || (paramq.jKs == 3) || (paramq.jKs == 5))
    {
      paramArrayOfByte = new cds();
      paramArrayOfByte.CreateTime = paramq.CreateTime;
      paramArrayOfByte.jKs = paramq.jKs;
      paramArrayOfByte.niK = paramq.niK;
      paramArrayOfByte.Username = paramq.xCG;
      paramArrayOfByte.Nickname = paramq.xNV;
      paramArrayOfByte.ntu = paramq.ntu;
      paramArrayOfByte.xOc = paramq.xOc;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = ((cdu)this.rr.fsW.fta).xNM;
        if ((paramq.jKs != 1) && (paramq.jKs != 5)) {
          continue;
        }
        ab.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + aa.b(paramArrayOfByte.ObjectDesc) + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
        ak.d(paramArrayOfByte);
      }
      catch (Exception paramq)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneSnsComment", paramq, "", new Object[0]);
        continue;
      }
      ag.cpe().coF();
      break;
      ab.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.o
 * JD-Core Version:    0.7.0.1
 */