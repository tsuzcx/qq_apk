package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.cuq;
import com.tencent.mm.protocal.protobuf.cvi;
import java.util.LinkedList;
import java.util.Locale;

public final class n
  extends com.tencent.mm.al.n
  implements k
{
  public g callback;
  private b rr;
  private int type;
  private String wEN;
  private cuj wEO;
  
  public n(cuj paramcuj, String paramString)
  {
    AppMethodBeat.i(95586);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cup();
    ((b.a)localObject).gUV = new cuq();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnscomment";
    ((b.a)localObject).funcId = 213;
    ((b.a)localObject).reqCmdId = 100;
    ((b.a)localObject).respCmdId = 1000000100;
    this.rr = ((b.a)localObject).atI();
    localObject = (cup)this.rr.gUS.gUX;
    ((cup)localObject).ElL = paramcuj;
    this.type = paramcuj.Emi.mBH;
    this.wEO = paramcuj;
    ((cup)localObject).gKn = paramString;
    this.wEN = paramString;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsComment", paramcuj.Emi.DZr + " " + paramcuj.Emi.DdY);
    AppMethodBeat.o(95586);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(95587);
    Object localObject2 = af.dtu().th(this.wEO.Id);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      com.tencent.mm.plugin.sns.storage.e locale = af.dtx().sY(this.wEO.Id);
      localObject1 = localObject2;
      if (locale != null) {
        localObject1 = locale.dxE();
      }
    }
    if (localObject1 != null) {}
    try
    {
      localObject1 = (SnsObject)new SnsObject().parseFrom(((p)localObject1).field_attrBuf);
      if ((((SnsObject)localObject1).ObjectOperations != null) && (((SnsObject)localObject1).ObjectOperations.hasBuffer()))
      {
        localObject2 = (cvi)new cvi().parseFrom(((SnsObject)localObject1).ObjectOperations.getBufferToBytes());
        localObject1 = (cup)this.rr.gUS.gUX;
        if (((cvi)localObject2).EmU != null)
        {
          localObject2 = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[] { Integer.valueOf(((cvi)localObject2).EmU.DbH), Integer.valueOf(((cvi)localObject2).EmU.DbI) });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[] { localObject2 });
          ((cup)localObject1).ElM = new cmf().aEE((String)localObject2);
        }
      }
      this.callback = paramg;
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(95587);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsComment", localException, "", new Object[0]);
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
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneSnsComment", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (paramInt2 == 4) {
        af.dtt().e(this.wEO.Id, this.type, this.wEN);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95588);
      return;
    }
    af.dtt().e(this.wEO.Id, this.type, this.wEN);
    paramq = this.wEO.Emi;
    if ((paramq.mBH == 1) || (paramq.mBH == 2) || (paramq.mBH == 3) || (paramq.mBH == 5))
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
        paramArrayOfByte = ((cuq)this.rr.gUT.gUX).ElO;
        if ((paramq.mBH != 1) && (paramq.mBH != 5)) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + z.b(paramArrayOfByte.ObjectDesc) + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
        aj.d(paramArrayOfByte);
      }
      catch (Exception paramq)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsComment", paramq, "", new Object[0]);
        continue;
      }
      af.dtt().dsV();
      break;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.n
 * JD-Core Version:    0.7.0.1
 */