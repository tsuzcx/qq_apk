package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.czm;
import com.tencent.mm.protocal.protobuf.czn;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.czv;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  public g callback;
  private b rr;
  private int type;
  private String xRi;
  private czv xRj;
  
  public j(czv paramczv, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(95564);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new czm();
    ((b.a)localObject).hvu = new czn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
    ((b.a)localObject).funcId = 682;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (czm)this.rr.hvr.hvw;
    ((czm)localObject).FIK = paramczv;
    this.type = paramczv.FJh.ndI;
    this.xRj = paramczv;
    ((czm)localObject).hkN = paramString1;
    ((czm)localObject).Scene = paramInt;
    this.xRi = paramString1;
    long l = paramczv.Id;
    paramString1 = af.dHU().xB(l);
    if (paramString1 != null)
    {
      paramString1 = paramString1.dLV();
      if (paramString1 != null)
      {
        paramString1 = p.DA(paramString1.yAj);
        if (paramString1 != null)
        {
          ((czm)localObject).FIL = z.FI(p.a(paramString1));
          ((czm)localObject).sVo = paramString1.dbL;
        }
        ((czm)localObject).FIJ = z.FI(bs.bG(paramString2, ""));
        ac.i("MicroMsg.NetSceneSnsAdComment", paramczv.FJh.Fwn + " " + paramczv.FJh.Exe + " type " + paramczv.FJh.ndI + " aduxinfo " + paramString2 + ", SnsStat=" + ((czm)localObject).FIL + ", source=" + ((czm)localObject).sVo + ", scene=" + paramInt);
        AppMethodBeat.o(95564);
        return;
      }
      ac.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      paramString1 = null;
      break;
      ac.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(95565);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneSnsAdComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        af.dHQ().h(this.xRj.Id, this.type, this.xRi);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95566);
      return;
    }
    af.dHQ().h(this.xRj.Id, this.type, this.xRi);
    paramq = this.xRj.FJh;
    if ((paramq.ndI == 1) || (paramq.ndI == 2) || (paramq.ndI == 3) || (paramq.ndI == 5) || (paramq.ndI == 7) || (paramq.ndI == 8) || (paramq.ndI == 16))
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
        paramq = (czm)this.rr.hvr.hvw;
        paramArrayOfByte = (czn)this.rr.hvs.hvw;
        if ((paramq.sVo != 1) && (paramq.sVo != 2)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.FzF;
        paramq = paramArrayOfByte.FIN;
        a.a(paramArrayOfByte);
        ac.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + paramq.toString() + " " + paramq.LikeUserList.size() + " " + paramq.CommentUserList.size());
      }
      catch (Exception paramq)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", paramq, "", new Object[0]);
        continue;
      }
      af.dHQ().dHs();
      break;
      paramArrayOfByte = paramArrayOfByte.DQo;
      paramq = paramArrayOfByte.FIN;
      a.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.j
 * JD-Core Version:    0.7.0.1
 */