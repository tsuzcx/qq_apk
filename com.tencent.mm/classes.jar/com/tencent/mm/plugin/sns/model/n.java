package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dab;
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.Locale;

public final class n
  extends com.tencent.mm.ak.n
  implements k
{
  public g callback;
  private b rr;
  private int type;
  private String xRi;
  private czv xRj;
  
  public n(czv paramczv, String paramString)
  {
    AppMethodBeat.i(95586);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dab();
    ((b.a)localObject).hvu = new dac();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnscomment";
    ((b.a)localObject).funcId = 213;
    ((b.a)localObject).reqCmdId = 100;
    ((b.a)localObject).respCmdId = 1000000100;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dab)this.rr.hvr.hvw;
    ((dab)localObject).FIK = paramczv;
    this.type = paramczv.FJh.ndI;
    this.xRj = paramczv;
    ((dab)localObject).hkN = paramString;
    this.xRi = paramString;
    ac.d("MicroMsg.NetSceneSnsComment", paramczv.FJh.Fwn + " " + paramczv.FJh.Exe);
    AppMethodBeat.o(95586);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(95587);
    Object localObject2 = af.dHR().xK(this.xRj.Id);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.sns.storage.e locale = af.dHU().xB(this.xRj.Id);
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.dMb();
      }
    }
    if (localObject1 != null) {}
    try
    {
      localObject1 = (SnsObject)new SnsObject().parseFrom(((p)localObject1).field_attrBuf);
      if ((((SnsObject)localObject1).ObjectOperations != null) && (((SnsObject)localObject1).ObjectOperations.hasBuffer()))
      {
        localObject2 = (dau)new dau().parseFrom(((SnsObject)localObject1).ObjectOperations.getBufferToBytes());
        localObject1 = (dab)this.rr.hvr.hvw;
        if (((dau)localObject2).FJT != null)
        {
          localObject2 = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[] { Integer.valueOf(((dau)localObject2).FJT.EuN), Integer.valueOf(((dau)localObject2).FJT.EuO) });
          ac.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[] { localObject2 });
          ((dab)localObject1).FIL = new crm().aJV((String)localObject2);
        }
      }
      this.callback = paramg;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(95587);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneSnsComment", localException, "", new Object[0]);
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
    ac.d("MicroMsg.NetSceneSnsComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        af.dHQ().h(this.xRj.Id, this.type, this.xRi);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95588);
      return;
    }
    af.dHQ().h(this.xRj.Id, this.type, this.xRi);
    paramq = this.xRj.FJh;
    if ((paramq.ndI == 1) || (paramq.ndI == 2) || (paramq.ndI == 3) || (paramq.ndI == 5))
    {
      paramArrayOfByte = new daa();
      paramArrayOfByte.CreateTime = paramq.CreateTime;
      paramArrayOfByte.ndI = paramq.ndI;
      paramArrayOfByte.sVo = paramq.sVo;
      paramArrayOfByte.Username = paramq.Fwn;
      paramArrayOfByte.Nickname = paramq.FIW;
      paramArrayOfByte.hkR = paramq.hkR;
      paramArrayOfByte.FJd = paramq.FJd;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = ((dac)this.rr.hvs.hvw).FIN;
        if ((paramq.ndI != 1) && (paramq.ndI != 5)) {
          continue;
        }
        ac.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + z.b(paramArrayOfByte.ObjectDesc) + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
        aj.d(paramArrayOfByte);
      }
      catch (Exception paramq)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneSnsComment", paramq, "", new Object[0]);
        continue;
      }
      af.dHQ().dHs();
      break;
      ac.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.n
 * JD-Core Version:    0.7.0.1
 */