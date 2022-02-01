package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dfi;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.Locale;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  public com.tencent.mm.al.f callback;
  private b rr;
  private int type;
  private String zhc;
  private dfi zhd;
  
  public n(dfi paramdfi, String paramString)
  {
    AppMethodBeat.i(95586);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dfo();
    ((b.a)localObject).hNN = new dfp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnscomment";
    ((b.a)localObject).funcId = 213;
    ((b.a)localObject).hNO = 100;
    ((b.a)localObject).respCmdId = 1000000100;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dfo)this.rr.hNK.hNQ;
    ((dfo)localObject).Hts = paramdfi;
    this.type = paramdfi.HtP.nEf;
    this.zhd = paramdfi;
    ((dfo)localObject).hCW = paramString;
    this.zhc = paramString;
    ad.d("MicroMsg.NetSceneSnsComment", paramdfi.HtP.Hgt + " " + paramdfi.HtP.GeH);
    AppMethodBeat.o(95586);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(95587);
    Object localObject2 = ag.dUe().Ai(this.zhd.Id);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.sns.storage.e locale = ag.dUh().zZ(this.zhd.Id);
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.dYr();
      }
    }
    if (localObject1 != null) {}
    try
    {
      localObject1 = (SnsObject)new SnsObject().parseFrom(((p)localObject1).field_attrBuf);
      if ((((SnsObject)localObject1).ObjectOperations != null) && (((SnsObject)localObject1).ObjectOperations.hasBuffer()))
      {
        localObject2 = (dgh)new dgh().parseFrom(((SnsObject)localObject1).ObjectOperations.getBufferToBytes());
        localObject1 = (dfo)this.rr.hNK.hNQ;
        if (((dgh)localObject2).HuB != null)
        {
          localObject2 = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[] { Integer.valueOf(((dgh)localObject2).HuB.Gch), Integer.valueOf(((dgh)localObject2).HuB.Gci) });
          ad.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[] { localObject2 });
          ((dfo)localObject1).Htt = new cwt().aPy((String)localObject2);
        }
      }
      this.callback = paramf;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(95587);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneSnsComment", localException, "", new Object[0]);
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
    ad.d("MicroMsg.NetSceneSnsComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        ag.dUd().i(this.zhd.Id, this.type, this.zhc);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95588);
      return;
    }
    ag.dUd().i(this.zhd.Id, this.type, this.zhc);
    paramq = this.zhd.HtP;
    if ((paramq.nEf == 1) || (paramq.nEf == 2) || (paramq.nEf == 3) || (paramq.nEf == 5))
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
        paramArrayOfByte = ((dfp)this.rr.hNL.hNQ).Htv;
        if ((paramq.nEf != 1) && (paramq.nEf != 5)) {
          continue;
        }
        ad.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + z.b(paramArrayOfByte.ObjectDesc) + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
        ak.d(paramArrayOfByte);
      }
      catch (Exception paramq)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneSnsComment", paramq, "", new Object[0]);
        continue;
      }
      ag.dUd().dTE();
      break;
      ad.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.n
 * JD-Core Version:    0.7.0.1
 */