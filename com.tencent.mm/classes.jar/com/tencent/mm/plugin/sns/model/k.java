package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzb;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.eaq;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  private String DIa;
  private dzj DIb;
  public i callback;
  private d rr;
  private int type;
  
  public k(dzj paramdzj, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(95564);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dza();
    ((d.a)localObject).iLO = new dzb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
    ((d.a)localObject).funcId = 682;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dza)this.rr.iLK.iLR;
    ((dza)localObject).MYE = paramdzj;
    this.type = paramdzj.MZb.oUv;
    this.DIb = paramdzj;
    ((dza)localObject).izX = paramString1;
    ((dza)localObject).Scene = paramInt;
    this.DIa = paramString1;
    long l = paramdzj.Id;
    paramString1 = aj.faR().JE(l);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getTimeLine();
      if (paramString1 != null)
      {
        paramString1 = p.PU(paramString1.statExtStr);
        if (paramString1 != null)
        {
          ((dza)localObject).MYF = z.Su(p.a(paramString1));
          ((dza)localObject).xub = paramString1.source;
        }
        ((dza)localObject).MYD = z.Su(Util.nullAs(paramString2, ""));
        Log.i("MicroMsg.NetSceneSnsAdComment", paramdzj.MZb.MKC + " " + paramdzj.MZb.LsY + " type " + paramdzj.MZb.oUv + " aduxinfo " + paramString2 + ", SnsStat=" + ((dza)localObject).MYF + ", source=" + ((dza)localObject).xub + ", scene=" + paramInt);
        AppMethodBeat.o(95564);
        return;
      }
      Log.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
    for (;;)
    {
      paramString1 = null;
      break;
      Log.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[] { Long.valueOf(l) });
    }
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95565);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95565);
    return i;
  }
  
  public final int getType()
  {
    return 682;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95566);
    Log.d("MicroMsg.NetSceneSnsAdComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        aj.faN().i(this.DIb.Id, this.type, this.DIa);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95566);
      return;
    }
    aj.faN().i(this.DIb.Id, this.type, this.DIa);
    params = this.DIb.MZb;
    if ((params.oUv == 1) || (params.oUv == 2) || (params.oUv == 3) || (params.oUv == 5) || (params.oUv == 7) || (params.oUv == 8) || (params.oUv == 16))
    {
      paramArrayOfByte = new dzo();
      paramArrayOfByte.CreateTime = params.CreateTime;
      paramArrayOfByte.oUv = params.oUv;
      paramArrayOfByte.xub = params.xub;
      paramArrayOfByte.Username = params.MKC;
      paramArrayOfByte.Nickname = params.MYQ;
      paramArrayOfByte.iAc = params.iAc;
      paramArrayOfByte.MYX = params.MYX;
    }
    for (;;)
    {
      try
      {
        params = (dza)this.rr.iLK.iLR;
        paramArrayOfByte = (dzb)this.rr.iLL.iLR;
        if ((params.xub != 1) && (params.xub != 2)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.MOf;
        params = paramArrayOfByte.MYH;
        a.a(paramArrayOfByte);
        Log.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + params.toString() + " " + params.LikeUserList.size() + " " + params.CommentUserList.size());
      }
      catch (Exception params)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", params, "", new Object[0]);
        continue;
      }
      aj.faN().fan();
      break;
      paramArrayOfByte = paramArrayOfByte.KHG;
      params = paramArrayOfByte.MYH;
      a.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.k
 * JD-Core Version:    0.7.0.1
 */