package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.fdh;
import com.tencent.mm.protocal.protobuf.fdi;
import com.tencent.mm.protocal.protobuf.fdk;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.fey;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class k
  extends p
  implements m
{
  public SnsObject PJP;
  public SnsInfo PJQ;
  private String Qsb;
  public fdq Qsc;
  public com.tencent.mm.am.h callback;
  public int mScene;
  private c rr;
  private int type;
  
  public k(fdq paramfdq, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(95564);
    this.mScene = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fdh();
    ((c.a)localObject).otF = new fdi();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
    ((c.a)localObject).funcId = 682;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fdh)c.b.b(this.rr.otB);
    ((fdh)localObject).abCN = paramfdq;
    this.type = paramfdq.abDp.vhJ;
    this.Qsc = paramfdq;
    ((fdh)localObject).nUv = paramString1;
    ((fdh)localObject).IJG = paramInt;
    this.Qsb = paramString1;
    long l = paramfdq.Id;
    paramString1 = al.hgE().vd(l);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getTimeLine();
      if (paramString1 != null)
      {
        paramString1 = o.Pt(paramString1.statExtStr);
        if (paramString1 != null)
        {
          ((fdh)localObject).abCO = com.tencent.mm.platformtools.w.Sk(o.a(paramString1));
          ((fdh)localObject).IcB = paramString1.source;
        }
        ((fdh)localObject).abCM = com.tencent.mm.platformtools.w.Sk(Util.nullAs(paramString2, ""));
        this.mScene = paramInt;
        Log.i("MicroMsg.NetSceneSnsAdComment", paramfdq.abDp.abnl + " " + paramfdq.abDp.Zvy + " type " + paramfdq.abDp.vhJ + " aduxinfo " + paramString2 + ", SnsStat=" + ((fdh)localObject).abCO + ", source=" + ((fdh)localObject).IcB + ", scene=" + paramInt);
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(95565);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95565);
    return i;
  }
  
  public final int getType()
  {
    return 682;
  }
  
  public final SnsInfo hfN()
  {
    AppMethodBeat.i(309580);
    try
    {
      SnsInfo localSnsInfo2 = al.hgB().vj(this.Qsc.Id);
      SnsInfo localSnsInfo1 = localSnsInfo2;
      if (localSnsInfo2 == null)
      {
        AdSnsInfo localAdSnsInfo = al.hgE().vd(this.Qsc.Id);
        localSnsInfo1 = localSnsInfo2;
        if (localAdSnsInfo != null) {
          localSnsInfo1 = localAdSnsInfo.convertToSnsInfo();
        }
      }
      return localSnsInfo1;
    }
    finally
    {
      AppMethodBeat.o(309580);
    }
    return null;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95566);
    Log.d("MicroMsg.NetSceneSnsAdComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        al.hgA().j(this.Qsc.Id, this.type, this.Qsb);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95566);
      return;
    }
    al.hgA().j(this.Qsc.Id, this.type, this.Qsb);
    params = this.Qsc.abDp;
    if ((params.vhJ == 1) || (params.vhJ == 2) || (params.vhJ == 3) || (params.vhJ == 5) || (params.vhJ == 7) || (params.vhJ == 8) || (params.vhJ == 16))
    {
      paramArrayOfByte = new fdv();
      paramArrayOfByte.CreateTime = params.CreateTime;
      paramArrayOfByte.vhJ = params.vhJ;
      paramArrayOfByte.IcB = params.IcB;
      paramArrayOfByte.Username = params.abnl;
      paramArrayOfByte.Nickname = params.abDe;
      paramArrayOfByte.nUB = params.nUB;
      paramArrayOfByte.abDl = params.abDl;
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = (fdh)c.b.b(this.rr.otB);
        params = (fdi)c.c.b(this.rr.otC);
        if ((paramArrayOfByte.IcB != 1) && (paramArrayOfByte.IcB != 2)) {
          continue;
        }
        paramArrayOfByte = params.abqV;
        params = paramArrayOfByte.abCS;
        a.a(paramArrayOfByte);
        this.PJP = params;
        Log.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + params.toString() + " " + params.LikeUserList.size() + " " + params.CommentUserList.size());
      }
      catch (Exception params)
      {
        boolean bool1;
        Log.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", params, "", new Object[0]);
        continue;
        boolean bool2 = false;
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1802, 3);
        params = "";
        continue;
        params = paramArrayOfByte;
        if (paramArrayOfByte != null) {
          continue;
        }
        params = "";
        continue;
        paramInt1 = 0;
        if (!bool2) {
          continue;
        }
        paramInt1 = 2;
        int i = paramInt1;
        if (!bool2) {
          continue;
        }
        i = paramInt1;
        if (bool1) {
          continue;
        }
        i = 1;
        continue;
      }
      al.hgA().hfT();
      break;
      synchronized (a.Qqy)
      {
        fdk localfdk = params.YGn;
        SnsObject localSnsObject = localfdk.abCS;
        if (a.hfz() == 1)
        {
          bool2 = true;
          bool1 = false;
          paramArrayOfByte = "";
          if (!bool2) {
            continue;
          }
          bool1 = a.a(localfdk);
          if (!bool1) {
            continue;
          }
          if (localfdk == null) {
            continue;
          }
          paramArrayOfByte = com.tencent.mm.platformtools.w.a(localfdk.abCV);
          continue;
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1802, 2);
          continue;
          Log.i("MicroMsg.NetSceneSnsAdComment", "adDynamic, graySwitch=" + bool2 + ", isValid=" + bool1 + ", replaceMode=" + i + ", dynamicAdInfoStr=" + params);
          a.a(localfdk, params, i);
          params = localSnsObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.k
 * JD-Core Version:    0.7.0.1
 */