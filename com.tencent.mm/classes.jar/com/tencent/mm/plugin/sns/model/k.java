package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  public com.tencent.mm.ai.f callback;
  private String reo;
  private cdn rep;
  private b rr;
  private int type;
  
  public k(cdn paramcdn, String paramString1, String paramString2)
  {
    AppMethodBeat.i(36239);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cde();
    ((b.a)localObject).fsY = new cdf();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
    ((b.a)localObject).funcId = 682;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cde)this.rr.fsV.fta;
    ((cde)localObject).xNJ = paramcdn;
    this.type = paramcdn.xOe.jKs;
    this.rep = paramcdn;
    ((cde)localObject).pIw = paramString1;
    this.reo = paramString1;
    long l = paramcdn.Id;
    paramString1 = ag.cpi().lQ(l);
    if (paramString1 != null)
    {
      paramString1 = paramString1.csh();
      if (paramString1 != null)
      {
        paramString1 = p.uI(paramString1.rHA);
        if (paramString1 != null)
        {
          ((cde)localObject).xNK = aa.wA(p.a(paramString1));
          ((cde)localObject).niK = paramString1.cpt;
        }
        ((cde)localObject).xNI = aa.wA(bo.bf(paramString2, ""));
        ab.i("MicroMsg.NetSceneSnsAdComment", paramcdn.xOe.xCG + " " + paramcdn.xOe.wQO + " type " + paramcdn.xOe.jKs + " aduxinfo " + paramString2 + ", SnsStat=" + ((cde)localObject).xNK + ", source=" + ((cde)localObject).niK);
        AppMethodBeat.o(36239);
        return;
      }
      ab.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      paramString1 = null;
      break;
      ab.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(36240);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36240);
    return i;
  }
  
  public final int getType()
  {
    return 682;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36241);
    ab.d("MicroMsg.NetSceneSnsAdComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        ag.cpe().e(this.rep.Id, this.type, this.reo);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36241);
      return;
    }
    ag.cpe().e(this.rep.Id, this.type, this.reo);
    paramq = this.rep.xOe;
    if ((paramq.jKs == 1) || (paramq.jKs == 2) || (paramq.jKs == 3) || (paramq.jKs == 5) || (paramq.jKs == 7) || (paramq.jKs == 8) || (paramq.jKs == 16))
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
        paramq = (cde)this.rr.fsV.fta;
        paramArrayOfByte = (cdf)this.rr.fsW.fta;
        if ((paramq.niK != 1) && (paramq.niK != 2)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.xFA;
        paramq = paramArrayOfByte.xNM;
        a.a(paramArrayOfByte);
        ab.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + paramq.toString() + " " + paramq.LikeUserList.size() + " " + paramq.CommentUserList.size());
      }
      catch (Exception paramq)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", paramq, "", new Object[0]);
        continue;
      }
      ag.cpe().coF();
      break;
      paramArrayOfByte = paramArrayOfByte.wpl;
      paramq = paramArrayOfByte.xNM;
      a.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.k
 * JD-Core Version:    0.7.0.1
 */