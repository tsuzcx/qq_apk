package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.l.a.a;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ego;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fdq;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.fdw;
import com.tencent.mm.protocal.protobuf.fdx;
import com.tencent.mm.protocal.protobuf.fer;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Locale;

public final class p
  extends com.tencent.mm.am.p
  implements m
{
  public SnsObject PJP;
  public SnsInfo PJQ;
  private String Qsb;
  public fdq Qsc;
  public int Qsl;
  public h callback;
  private c rr;
  private int type;
  
  public p(fdq paramfdq, String paramString)
  {
    this(paramfdq, paramString, 0);
    AppMethodBeat.i(95586);
    AppMethodBeat.o(95586);
  }
  
  public p(fdq paramfdq, String paramString, int paramInt)
  {
    AppMethodBeat.i(309554);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fdw();
    ((c.a)localObject).otF = new fdx();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnscomment";
    ((c.a)localObject).funcId = 213;
    ((c.a)localObject).otG = 100;
    ((c.a)localObject).respCmdId = 1000000100;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fdw)c.b.b(this.rr.otB);
    ((fdw)localObject).abCN = paramfdq;
    a.a locala = com.tencent.mm.plugin.sns.l.a.akV(2);
    int i;
    if (locala != null)
    {
      if (((locala.eQp & 0x4) == 0) && ((locala.eQp & 0x8) == 0)) {
        break label287;
      }
      if ((locala.eQp & 0x4) == 0) {
        break label281;
      }
      i = 2;
      Log.i("MicroMsg.NetSceneSnsComment", "has paste fully flag, %d", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      ((fdw)localObject).abDB = t.dd(i, locala.QCX);
      com.tencent.mm.plugin.sns.l.a.akW(2);
      Log.d("MicroMsg.NetSceneSnsComment", "sendComment req.ReportData：%s", new Object[] { ((fdw)localObject).abDB });
      this.type = paramfdq.abDp.vhJ;
      this.Qsc = paramfdq;
      this.Qsl = paramInt;
      ((fdw)localObject).nUv = paramString;
      this.Qsb = paramString;
      Log.d("MicroMsg.NetSceneSnsComment", paramfdq.abDp.abnl + " " + paramfdq.abDp.Zvy);
      AppMethodBeat.o(309554);
      return;
      label281:
      i = 3;
      break;
      label287:
      if (((locala.eQp & 0x10) != 0) || ((locala.eQp & 0x20) != 0))
      {
        if ((locala.eQp & 0x10) != 0) {}
        for (i = 4;; i = 5)
        {
          Log.i("MicroMsg.NetSceneSnsComment", "has paste similar change flag, %d", new Object[] { Integer.valueOf(i) });
          break;
        }
      }
      i = 0;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(95587);
    SnsInfo localSnsInfo = al.hgB().vj(this.Qsc.Id);
    Object localObject1;
    if (localSnsInfo == null)
    {
      localObject1 = al.hgE().vd(this.Qsc.Id);
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
        if ((((SnsObject)localObject1).ObjectOperations != null) && (((SnsObject)localObject1).ObjectOperations.aklm))
        {
          Object localObject2 = (fer)new fer().parseFrom(((SnsObject)localObject1).ObjectOperations.aaxD.Op);
          localObject1 = (fdw)c.b.b(this.rr.otB);
          if (((fer)localObject2).abEg != null)
          {
            localObject2 = String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[] { Integer.valueOf(((fer)localObject2).abEg.ZqV), Integer.valueOf(((fer)localObject2).abEg.ZqW) });
            Log.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[] { localObject2 });
            ((fdw)localObject1).abCO = new etl().btH((String)localObject2);
          }
        }
        this.PJQ = localSnsInfo;
        this.callback = paramh;
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
        al.hgA().j(this.Qsc.Id, this.type, this.Qsb);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95588);
      return;
    }
    al.hgA().j(this.Qsc.Id, this.type, this.Qsb);
    paramArrayOfByte = this.Qsc.abDp;
    if ((paramArrayOfByte.vhJ == 1) || (paramArrayOfByte.vhJ == 2) || (paramArrayOfByte.vhJ == 3) || (paramArrayOfByte.vhJ == 5))
    {
      params = new fdv();
      params.CreateTime = paramArrayOfByte.CreateTime;
      params.vhJ = paramArrayOfByte.vhJ;
      params.IcB = paramArrayOfByte.IcB;
      params.Username = paramArrayOfByte.abnl;
      params.Nickname = paramArrayOfByte.abDe;
      params.nUB = paramArrayOfByte.nUB;
      params.abDl = paramArrayOfByte.abDl;
    }
    for (;;)
    {
      try
      {
        localSnsObject = ((fdx)c.c.b(this.rr.otC)).abCS;
        this.PJP = localSnsObject;
        if ((paramArrayOfByte.vhJ != 1) && (paramArrayOfByte.vhJ != 5)) {
          continue;
        }
        Log.i("MicroMsg.NetSceneSnsComment", "snsComment:" + localSnsObject.Id + " " + com.tencent.mm.platformtools.w.b(localSnsObject.ObjectDesc) + " " + localSnsObject.LikeUserList.size() + " " + localSnsObject.CommentUserList.size());
        ap.h(localSnsObject);
      }
      catch (Exception paramArrayOfByte)
      {
        SnsObject localSnsObject;
        Log.printErrStackTrace("MicroMsg.NetSceneSnsComment", paramArrayOfByte, "", new Object[0]);
        continue;
      }
      com.tencent.mm.plugin.sns.h.a.aXN(params.nUB);
      al.hgA().hfT();
      break;
      Log.i("MicroMsg.NetSceneSnsComment", "snsComment:" + localSnsObject.Id + " " + localSnsObject.LikeUserList.size() + " " + localSnsObject.CommentUserList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.p
 * JD-Core Version:    0.7.0.1
 */