package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  public com.tencent.mm.ak.f callback;
  private b rr;
  private int type;
  private String zxS;
  private dgc zxT;
  
  public k(dgc paramdgc, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(95564);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dft();
    ((b.a)localObject).hQG = new dfu();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
    ((b.a)localObject).funcId = 682;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dft)this.rr.hQD.hQJ;
    ((dft)localObject).HMV = paramdgc;
    this.type = paramdgc.HNs.nJA;
    this.zxT = paramdgc;
    ((dft)localObject).hFO = paramString1;
    ((dft)localObject).Scene = paramInt;
    this.zxS = paramString1;
    long l = paramdgc.Id;
    paramString1 = ah.dXH().Ax(l);
    if (paramString1 != null)
    {
      paramString1 = paramString1.ebP();
      if (paramString1 != null)
      {
        paramString1 = p.Hh(paramString1.AiG);
        if (paramString1 != null)
        {
          ((dft)localObject).HMW = z.Jw(p.a(paramString1));
          ((dft)localObject).ucK = paramString1.doj;
        }
        ((dft)localObject).HMU = z.Jw(bu.bI(paramString2, ""));
        ae.i("MicroMsg.NetSceneSnsAdComment", paramdgc.HNs.HzT + " " + paramdgc.HNs.Gxp + " type " + paramdgc.HNs.nJA + " aduxinfo " + paramString2 + ", SnsStat=" + ((dft)localObject).HMW + ", source=" + ((dft)localObject).ucK + ", scene=" + paramInt);
        AppMethodBeat.o(95564);
        return;
      }
      ae.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      paramString1 = null;
      break;
      ae.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(95565);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95565);
    return i;
  }
  
  public final int getType()
  {
    return 682;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95566);
    ae.d("MicroMsg.NetSceneSnsAdComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        ah.dXD().h(this.zxT.Id, this.type, this.zxS);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95566);
      return;
    }
    ah.dXD().h(this.zxT.Id, this.type, this.zxS);
    paramq = this.zxT.HNs;
    if ((paramq.nJA == 1) || (paramq.nJA == 2) || (paramq.nJA == 3) || (paramq.nJA == 5) || (paramq.nJA == 7) || (paramq.nJA == 8) || (paramq.nJA == 16))
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
        paramq = (dft)this.rr.hQD.hQJ;
        paramArrayOfByte = (dfu)this.rr.hQE.hQJ;
        if ((paramq.ucK != 1) && (paramq.ucK != 2)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.HDn;
        paramq = paramArrayOfByte.HMY;
        a.a(paramArrayOfByte);
        ae.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + paramq.toString() + " " + paramq.LikeUserList.size() + " " + paramq.CommentUserList.size());
      }
      catch (Exception paramq)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", paramq, "", new Object[0]);
        continue;
      }
      ah.dXD().dXe();
      break;
      paramArrayOfByte = paramArrayOfByte.FOb;
      paramq = paramArrayOfByte.HMY;
      a.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.k
 * JD-Core Version:    0.7.0.1
 */