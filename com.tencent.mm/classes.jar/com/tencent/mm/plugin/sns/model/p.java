package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Locale;

public final class p
  extends q
  implements m
{
  private String DIa;
  public dzj DIb;
  public int DIk;
  public SnsObject DqN;
  public SnsInfo DqO;
  public i callback;
  private d rr;
  private int type;
  
  public p(dzj paramdzj, String paramString)
  {
    this(paramdzj, paramString, 0);
    AppMethodBeat.i(95586);
    AppMethodBeat.o(95586);
  }
  
  public p(dzj paramdzj, String paramString, int paramInt)
  {
    AppMethodBeat.i(202725);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dzp();
    ((d.a)localObject).iLO = new dzq();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnscomment";
    ((d.a)localObject).funcId = 213;
    ((d.a)localObject).iLP = 100;
    ((d.a)localObject).respCmdId = 1000000100;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dzp)this.rr.iLK.iLR;
    ((dzp)localObject).MYE = paramdzj;
    this.type = paramdzj.MZb.oUv;
    this.DIb = paramdzj;
    this.DIk = paramInt;
    ((dzp)localObject).izX = paramString;
    this.DIa = paramString;
    Log.d("MicroMsg.NetSceneSnsComment", paramdzj.MZb.MKC + " " + paramdzj.MZb.LsY);
    AppMethodBeat.o(202725);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95587);
    SnsInfo localSnsInfo = aj.faO().JJ(this.DIb.Id);
    Object localObject1;
    if (localSnsInfo == null)
    {
      localObject1 = aj.faR().JE(this.DIb.Id);
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
        if ((((SnsObject)localObject1).ObjectOperations != null) && (((SnsObject)localObject1).ObjectOperations.hasBuffer()))
        {
          Object localObject2 = (eaj)new eaj().parseFrom(((SnsObject)localObject1).ObjectOperations.getBufferToBytes());
          localObject1 = (dzp)this.rr.iLK.iLR;
          if (((eaj)localObject2).MZL != null)
          {
            localObject2 = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[] { Integer.valueOf(((eaj)localObject2).MZL.Lqt), Integer.valueOf(((eaj)localObject2).MZL.Lqu) });
            Log.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[] { localObject2 });
            ((dzp)localObject1).MYF = new dqi().bhy((String)localObject2);
          }
        }
        this.DqO = localSnsInfo;
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
        aj.faN().i(this.DIb.Id, this.type, this.DIa);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95588);
      return;
    }
    aj.faN().i(this.DIb.Id, this.type, this.DIa);
    params = this.DIb.MZb;
    if ((params.oUv == 1) || (params.oUv == 2) || (params.oUv == 3) || (params.oUv == 5))
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
        paramArrayOfByte = ((dzq)this.rr.iLL.iLR).MYH;
        this.DqN = paramArrayOfByte;
        if ((params.oUv != 1) && (params.oUv != 5)) {
          continue;
        }
        Log.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + z.b(paramArrayOfByte.ObjectDesc) + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
        an.e(paramArrayOfByte);
      }
      catch (Exception params)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsComment", params, "", new Object[0]);
        continue;
      }
      aj.faN().fan();
      break;
      Log.i("MicroMsg.NetSceneSnsComment", "snsComment:" + paramArrayOfByte.Id + " " + paramArrayOfByte.LikeUserList.size() + " " + paramArrayOfByte.CommentUserList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.p
 * JD-Core Version:    0.7.0.1
 */