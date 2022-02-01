package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class j
  extends n
  implements k
{
  public g callback;
  private b rr;
  private int type;
  private String wEN;
  private cuj wEO;
  
  public j(cuj paramcuj, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(95564);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cua();
    ((b.a)localObject).gUV = new cub();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
    ((b.a)localObject).funcId = 682;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (cua)this.rr.gUS.gUX;
    ((cua)localObject).ElL = paramcuj;
    this.type = paramcuj.Emi.mBH;
    this.wEO = paramcuj;
    ((cua)localObject).gKn = paramString1;
    ((cua)localObject).Scene = paramInt;
    this.wEN = paramString1;
    long l = paramcuj.Id;
    paramString1 = af.dtx().sY(l);
    if (paramString1 != null)
    {
      paramString1 = paramString1.dxy();
      if (paramString1 != null)
      {
        paramString1 = p.zv(paramString1.xns);
        if (paramString1 != null)
        {
          ((cua)localObject).ElM = z.BE(p.a(paramString1));
          ((cua)localObject).rNz = paramString1.dep;
        }
        ((cua)localObject).ElK = z.BE(bt.by(paramString2, ""));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsAdComment", paramcuj.Emi.DZr + " " + paramcuj.Emi.DdY + " type " + paramcuj.Emi.mBH + " aduxinfo " + paramString2 + ", SnsStat=" + ((cua)localObject).ElM + ", source=" + ((cua)localObject).rNz + ", scene=" + paramInt);
        AppMethodBeat.o(95564);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      paramString1 = null;
      break;
      com.tencent.mm.sdk.platformtools.ad.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsAdComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        af.dtt().e(this.wEO.Id, this.type, this.wEN);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95566);
      return;
    }
    af.dtt().e(this.wEO.Id, this.type, this.wEN);
    paramq = this.wEO.Emi;
    if ((paramq.mBH == 1) || (paramq.mBH == 2) || (paramq.mBH == 3) || (paramq.mBH == 5) || (paramq.mBH == 7) || (paramq.mBH == 8) || (paramq.mBH == 16))
    {
      paramArrayOfByte = new cuo();
      paramArrayOfByte.CreateTime = paramq.CreateTime;
      paramArrayOfByte.mBH = paramq.mBH;
      paramArrayOfByte.rNz = paramq.rNz;
      paramArrayOfByte.Username = paramq.DZr;
      paramArrayOfByte.Nickname = paramq.ElX;
      paramArrayOfByte.gKr = paramq.gKr;
      paramArrayOfByte.Eme = paramq.Eme;
    }
    for (;;)
    {
      try
      {
        paramq = (cua)this.rr.gUS.gUX;
        paramArrayOfByte = (cub)this.rr.gUT.gUX;
        if ((paramq.rNz != 1) && (paramq.rNz != 2)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.EcK;
        paramq = paramArrayOfByte.ElO;
        a.a(paramArrayOfByte);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + paramq.toString() + " " + paramq.LikeUserList.size() + " " + paramq.CommentUserList.size());
      }
      catch (Exception paramq)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", paramq, "", new Object[0]);
        continue;
      }
      af.dtt().dsV();
      break;
      paramArrayOfByte = paramArrayOfByte.CxS;
      paramq = paramArrayOfByte.ElO;
      a.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.j
 * JD-Core Version:    0.7.0.1
 */