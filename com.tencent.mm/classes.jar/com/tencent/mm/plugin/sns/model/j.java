package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dez;
import com.tencent.mm.protocal.protobuf.dfa;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  public com.tencent.mm.al.f callback;
  private b rr;
  private int type;
  private String zhc;
  private dfi zhd;
  
  public j(dfi paramdfi, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(95564);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dez();
    ((b.a)localObject).hNN = new dfa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
    ((b.a)localObject).funcId = 682;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dez)this.rr.hNK.hNQ;
    ((dez)localObject).Hts = paramdfi;
    this.type = paramdfi.HtP.nEf;
    this.zhd = paramdfi;
    ((dez)localObject).hCW = paramString1;
    ((dez)localObject).Scene = paramInt;
    this.zhc = paramString1;
    long l = paramdfi.Id;
    paramString1 = ag.dUh().zZ(l);
    if (paramString1 != null)
    {
      paramString1 = paramString1.dYl();
      if (paramString1 != null)
      {
        paramString1 = p.GF(paramString1.zRz);
        if (paramString1 != null)
        {
          ((dez)localObject).Htt = z.IX(p.a(paramString1));
          ((dez)localObject).tRT = paramString1.dnh;
        }
        ((dez)localObject).Htr = z.IX(bt.bI(paramString2, ""));
        ad.i("MicroMsg.NetSceneSnsAdComment", paramdfi.HtP.Hgt + " " + paramdfi.HtP.GeH + " type " + paramdfi.HtP.nEf + " aduxinfo " + paramString2 + ", SnsStat=" + ((dez)localObject).Htt + ", source=" + ((dez)localObject).tRT + ", scene=" + paramInt);
        AppMethodBeat.o(95564);
        return;
      }
      ad.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      paramString1 = null;
      break;
      ad.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
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
    ad.d("MicroMsg.NetSceneSnsAdComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        ag.dUd().i(this.zhd.Id, this.type, this.zhc);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95566);
      return;
    }
    ag.dUd().i(this.zhd.Id, this.type, this.zhc);
    paramq = this.zhd.HtP;
    if ((paramq.nEf == 1) || (paramq.nEf == 2) || (paramq.nEf == 3) || (paramq.nEf == 5) || (paramq.nEf == 7) || (paramq.nEf == 8) || (paramq.nEf == 16))
    {
      paramArrayOfByte = new dfn();
      paramArrayOfByte.CreateTime = paramq.CreateTime;
      paramArrayOfByte.nEf = paramq.nEf;
      paramArrayOfByte.tRT = paramq.tRT;
      paramArrayOfByte.Username = paramq.Hgt;
      paramArrayOfByte.Nickname = paramq.HtE;
      paramArrayOfByte.hDa = paramq.hDa;
      paramArrayOfByte.HtL = paramq.HtL;
    }
    for (;;)
    {
      try
      {
        paramq = (dez)this.rr.hNK.hNQ;
        paramArrayOfByte = (dfa)this.rr.hNL.hNQ;
        if ((paramq.tRT != 1) && (paramq.tRT != 2)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.HjN;
        paramq = paramArrayOfByte.Htv;
        a.a(paramArrayOfByte);
        ad.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + paramq.toString() + " " + paramq.LikeUserList.size() + " " + paramq.CommentUserList.size());
      }
      catch (Exception paramq)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", paramq, "", new Object[0]);
        continue;
      }
      ag.dUd().dTE();
      break;
      paramArrayOfByte = paramArrayOfByte.FvD;
      paramq = paramArrayOfByte.Htv;
      a.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.j
 * JD-Core Version:    0.7.0.1
 */