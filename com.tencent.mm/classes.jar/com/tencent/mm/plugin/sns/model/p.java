package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.ejp;
import com.tencent.mm.protocal.protobuf.ejq;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Locale;

public final class p
  extends q
  implements m
{
  private String JUZ;
  public ejj JVa;
  public int JVk;
  public SnsObject Jwr;
  public SnsInfo Jws;
  public i callback;
  private d rr;
  private int type;
  
  public p(ejj paramejj, String paramString)
  {
    this(paramejj, paramString, 0);
    AppMethodBeat.i(95586);
    AppMethodBeat.o(95586);
  }
  
  public p(ejj paramejj, String paramString, int paramInt)
  {
    AppMethodBeat.i(201526);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ejp();
    ((d.a)localObject).lBV = new ejq();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnscomment";
    ((d.a)localObject).funcId = 213;
    ((d.a)localObject).lBW = 100;
    ((d.a)localObject).respCmdId = 1000000100;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ejp)d.b.b(this.rr.lBR);
    ((ejp)localObject).UkW = paramejj;
    this.type = paramejj.Ulv.rWu;
    this.JVa = paramejj;
    this.JVk = paramInt;
    ((ejp)localObject).lps = paramString;
    this.JUZ = paramString;
    Log.d("MicroMsg.NetSceneSnsComment", paramejj.Ulv.TWw + " " + paramejj.Ulv.Svt);
    AppMethodBeat.o(201526);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95587);
    SnsInfo localSnsInfo = aj.fOI().Rd(this.JVa.Id);
    Object localObject1;
    if (localSnsInfo == null)
    {
      localObject1 = aj.fOL().QX(this.JVa.Id);
      if (localObject1 != null) {
        localSnsInfo = ((AdSnsInfo)localObject1).convertToSnsInfo();
      }
    }
    for (;;)
    {
      if (localSnsInfo != null) {}
      try
      {
        localObject1 = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
        if ((((SnsObject)localObject1).ObjectOperations != null) && (((SnsObject)localObject1).ObjectOperations.YtU))
        {
          Object localObject2 = (ekj)new ekj().parseFrom(((SnsObject)localObject1).ObjectOperations.Tkb.UH);
          localObject1 = (ejp)d.b.b(this.rr.lBR);
          if (((ekj)localObject2).Umf != null)
          {
            localObject2 = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[] { Integer.valueOf(((ekj)localObject2).Umf.SrQ), Integer.valueOf(((ekj)localObject2).Umf.SrR) });
            Log.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[] { localObject2 });
            ((ejp)localObject1).UkX = new eaf().btQ((String)localObject2);
          }
        }
        this.Jws = localSnsInfo;
        this.callback = parami;
        int i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(95587);
        return i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsComment", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public final int getType()
  {
    return 213;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95588);
    Log.d("MicroMsg.NetSceneSnsComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        aj.fOH().h(this.JVa.Id, this.type, this.JUZ);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95588);
      return;
    }
    aj.fOH().h(this.JVa.Id, this.type, this.JUZ);
    params = this.JVa.Ulv;
    if ((params.rWu == 1) || (params.rWu == 2) || (params.rWu == 3) || (params.rWu == 5))
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
        paramArrayOfByte = ((ejq)d.c.b(this.rr.lBS)).Ulb;
        this.Jwr = paramArrayOfByte;
        if ((params.rWu != 1) && (params.rWu != 5)) {
          continue;
        }
        Log.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + z.b(paramArrayOfByte.ObjectDesc) + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
        an.g(paramArrayOfByte);
      }
      catch (Exception params)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsComment", params, "", new Object[0]);
        continue;
      }
      aj.fOH().fOh();
      break;
      Log.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.p
 * JD-Core Version:    0.7.0.1
 */