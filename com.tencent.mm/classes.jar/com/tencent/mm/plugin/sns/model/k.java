package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.eja;
import com.tencent.mm.protocal.protobuf.ejb;
import com.tencent.mm.protocal.protobuf.ejd;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.protocal.protobuf.emq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  private String JUZ;
  public ejj JVa;
  public SnsObject Jwr;
  public SnsInfo Jws;
  public i callback;
  public int mScene;
  private d rr;
  private int type;
  
  public k(ejj paramejj, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(95564);
    this.mScene = 0;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new eja();
    ((d.a)localObject).lBV = new ejb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
    ((d.a)localObject).funcId = 682;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (eja)d.b.b(this.rr.lBR);
    ((eja)localObject).UkW = paramejj;
    this.type = paramejj.Ulv.rWu;
    this.JVa = paramejj;
    ((eja)localObject).lps = paramString1;
    ((eja)localObject).CPw = paramInt;
    this.JUZ = paramString1;
    long l = paramejj.Id;
    paramString1 = aj.fOL().QX(l);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getTimeLine();
      if (paramString1 != null)
      {
        paramString1 = o.Xr(paramString1.statExtStr);
        if (paramString1 != null)
        {
          ((eja)localObject).UkX = z.ZW(o.a(paramString1));
          ((eja)localObject).Cqs = paramString1.source;
        }
        ((eja)localObject).UkV = z.ZW(Util.nullAs(paramString2, ""));
        this.mScene = paramInt;
        Log.i("MicroMsg.NetSceneSnsAdComment", paramejj.Ulv.TWw + " " + paramejj.Ulv.Svt + " type " + paramejj.Ulv.rWu + " aduxinfo " + paramString2 + ", SnsStat=" + ((eja)localObject).UkX + ", source=" + ((eja)localObject).Cqs + ", scene=" + paramInt);
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
  
  public final SnsInfo fNZ()
  {
    AppMethodBeat.i(269295);
    try
    {
      SnsInfo localSnsInfo2 = aj.fOI().Rd(this.JVa.Id);
      SnsInfo localSnsInfo1 = localSnsInfo2;
      if (localSnsInfo2 == null)
      {
        AdSnsInfo localAdSnsInfo = aj.fOL().QX(this.JVa.Id);
        localSnsInfo1 = localSnsInfo2;
        if (localAdSnsInfo != null) {
          localSnsInfo1 = localAdSnsInfo.convertToSnsInfo();
        }
      }
      AppMethodBeat.o(269295);
      return localSnsInfo1;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(269295);
    }
    return null;
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
        aj.fOH().h(this.JVa.Id, this.type, this.JUZ);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95566);
      return;
    }
    aj.fOH().h(this.JVa.Id, this.type, this.JUZ);
    params = this.JVa.Ulv;
    if ((params.rWu == 1) || (params.rWu == 2) || (params.rWu == 3) || (params.rWu == 5) || (params.rWu == 7) || (params.rWu == 8) || (params.rWu == 16))
    {
      paramArrayOfByte = new ejo();
      paramArrayOfByte.CreateTime = params.CreateTime;
      paramArrayOfByte.rWu = params.rWu;
      paramArrayOfByte.Cqs = params.Cqs;
      paramArrayOfByte.Username = params.TWw;
      paramArrayOfByte.Nickname = params.Ulk;
      paramArrayOfByte.lpy = params.lpy;
      paramArrayOfByte.Ulr = params.Ulr;
    }
    for (;;)
    {
      try
      {
        params = (eja)d.b.b(this.rr.lBR);
        paramArrayOfByte = (ejb)d.c.b(this.rr.lBS);
        if ((params.Cqs != 1) && (params.Cqs != 2)) {
          continue;
        }
        paramArrayOfByte = paramArrayOfByte.TZY;
        params = paramArrayOfByte.Ulb;
        a.a(paramArrayOfByte);
        this.Jwr = params;
        Log.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + params.toString() + " " + params.LikeUserList.size() + " " + params.CommentUserList.size());
      }
      catch (Exception params)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", params, "", new Object[0]);
        continue;
      }
      aj.fOH().fOh();
      break;
      paramArrayOfByte = paramArrayOfByte.RIZ;
      params = paramArrayOfByte.Ulb;
      a.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.k
 * JD-Core Version:    0.7.0.1
 */