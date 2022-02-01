package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ejd;
import com.tencent.mm.protocal.protobuf.eje;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  public static List<Long> JVb;
  public static List<Long> JVc;
  public com.tencent.mm.an.i callback;
  private long fWg;
  private String mfv;
  private d rr;
  
  static
  {
    AppMethodBeat.i(95578);
    JVb = Collections.synchronizedList(new LinkedList());
    JVc = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(95578);
  }
  
  public m(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95574);
    this.fWg = paramLong;
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new eje();
    ((d.a)localObject1).lBV = new ejf();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
    ((d.a)localObject1).funcId = 683;
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.h.aHH();
    this.mfv = (com.tencent.mm.kernel.h.aHG().cachePath + "ad_detail_session");
    int i = t.avq();
    localObject2 = u.aY(this.mfv, 0, -1);
    this.rr = ((d.a)localObject1).bgN();
    ((eje)d.b.b(this.rr.lBR)).Id = paramLong;
    ((eje)d.b.b(this.rr.lBR)).Uld = z.aN((byte[])localObject2);
    ((eje)d.b.b(this.rr.lBR)).CPw = paramInt;
    ((eje)d.b.b(this.rr.lBR)).Ulf = i;
    if ((paramString != null) && (paramString.length() > 0)) {
      ((eje)d.b.b(this.rr.lBR)).Ule = z.ZX(paramString);
    }
    com.tencent.mm.plugin.report.service.h.IzE.el(1612, 32);
    localObject1 = new StringBuilder("NetSceneSnsAdObjectDetial, snsId=").append(t.Qu(paramLong)).append(", scene=").append(paramInt).append(", buf is null?");
    if (localObject2 == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", bool + ", syncBuf=" + paramString);
      AppMethodBeat.o(95574);
      return;
    }
  }
  
  public m(long paramLong, dwf paramdwf)
  {
    this(paramLong, 2, "");
    AppMethodBeat.i(95575);
    ((eje)d.b.b(this.rr.lBR)).RJc = paramdwf;
    if (paramdwf == null)
    {
      Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "NetSceneSnsAdObjectDetial, remindFriendsInfo==null");
      AppMethodBeat.o(95575);
      return;
    }
    String str = null;
    if (paramdwf.Uck != null) {
      str = z.b(paramdwf.Uck);
    }
    Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "NetSceneSnsAdObjectDetial, scene=2, ADGroupId64=" + paramdwf.Ucl + ", ADGroupId=" + paramdwf.Ucg + ", extInfo=" + str);
    AppMethodBeat.o(95575);
  }
  
  public static boolean QA(long paramLong)
  {
    AppMethodBeat.i(95571);
    if (JVc.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95571);
      return false;
    }
    JVc.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95571);
    return true;
  }
  
  private static boolean QB(long paramLong)
  {
    AppMethodBeat.i(95572);
    JVc.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95572);
    return true;
  }
  
  private static boolean QC(long paramLong)
  {
    AppMethodBeat.i(95573);
    JVb.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95573);
    return true;
  }
  
  public static boolean Qz(long paramLong)
  {
    AppMethodBeat.i(95570);
    if (JVb.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95570);
      return false;
    }
    JVb.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95570);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(95576);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95576);
    return i;
  }
  
  public final int getType()
  {
    return 683;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95577);
    params = t.Qu(this.fWg);
    Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + paramInt2 + " errCode " + paramInt3 + ", snsId=" + params);
    int i = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label234;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (((eje)d.b.b(this.rr.lBR)).CPw != 2) {
        break label221;
      }
      com.tencent.mm.plugin.report.service.h.IzE.el(955, 1);
    }
    for (;;)
    {
      QC(this.fWg);
      QB(this.fWg);
      com.tencent.mm.plugin.report.service.h.IzE.el(1612, 27);
      AppMethodBeat.o(95577);
      return;
      paramInt1 = i;
      if (paramInt2 != 4) {
        break;
      }
      paramInt1 = i;
      if (paramInt3 != 1) {
        break;
      }
      paramArrayOfByte = z.a(((ejf)d.c.b(this.rr.lBS)).Uld);
      if (paramArrayOfByte != null)
      {
        u.deleteFile(this.mfv);
        u.f(this.mfv, paramArrayOfByte, paramArrayOfByte.length);
      }
      paramInt1 = 0;
      break;
      label221:
      com.tencent.mm.plugin.report.service.h.IzE.el(955, 0);
    }
    label234:
    paramArrayOfByte = z.a(((ejf)d.c.b(this.rr.lBS)).Uld);
    if (paramArrayOfByte != null)
    {
      u.deleteFile(this.mfv);
      u.f(this.mfv, paramArrayOfByte, paramArrayOfByte.length);
    }
    paramArrayOfByte = ((ejf)d.c.b(this.rr.lBS)).Ulg;
    eae localeae = ((ejf)d.c.b(this.rr.lBS)).Ulh;
    int j = ((eje)d.b.b(this.rr.lBR)).CPw;
    if (paramArrayOfByte != null)
    {
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail scene=" + j + ", snsXml=" + z.b(paramArrayOfByte.Ulb.ObjectDesc));
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml=" + paramArrayOfByte.Ulc);
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "dynamicData=" + z.b(localeae));
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.Ulb != null) && (paramArrayOfByte.Ulb.DeleteFlag > 0))
    {
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", t.Qu(paramArrayOfByte.Ulb.Id) + " will remove by get detail ");
      QC(this.fWg);
      QB(this.fWg);
      aj.fOL().delete(paramArrayOfByte.Ulb.Id);
      aj.fON().Rb(paramArrayOfByte.Ulb.Id);
      com.tencent.mm.plugin.sns.storage.g.Ra(paramArrayOfByte.Ulb.Id);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95577);
      return;
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.Ulb != null))
    {
      if (paramArrayOfByte.Ulb.CommentUserList == null)
      {
        paramInt1 = 0;
        if (paramArrayOfByte.Ulb.LikeUserList != null) {
          break label865;
        }
        i = 0;
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment.size=" + paramInt1 + " liked.size=" + i + ", likeFlag=" + paramArrayOfByte.Ulb.LikeFlag + ", snsId=" + t.Qu(paramArrayOfByte.Ulb.Id));
      }
    }
    else
    {
      if (j != 2) {
        break label923;
      }
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", new Object[] { params });
      paramArrayOfByte = ((ejf)d.c.b(this.rr.lBS)).Uli;
      if (paramArrayOfByte == null) {
        break label912;
      }
      Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "recv at adInfoXml=".concat(String.valueOf(z.a(paramArrayOfByte.RJa))));
      a.a(paramArrayOfByte);
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = aj.fOL().QX(paramArrayOfByte.RIZ.Ulb.Id);
        com.tencent.mm.plugin.sns.ad.timeline.b.f.a(paramArrayOfByte.getTimeLine(), paramArrayOfByte.getAdXml(), 3);
        Log.i("MicroMsg.NetSceneSnsAdObjectDetial", "preDownloadAdLandingPagesForAtMsg, id=".concat(String.valueOf(params)));
        j.bbj(paramArrayOfByte.field_adxml);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        QC(this.fWg);
        QB(this.fWg);
        AppMethodBeat.o(95577);
        return;
        paramInt1 = paramArrayOfByte.Ulb.CommentUserList.size();
        break;
        label865:
        i = paramArrayOfByte.Ulb.LikeUserList.size();
      }
      catch (Throwable params)
      {
        Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "TimeLineAdPreloadHelper->checkPreloadAdResource exp=" + params.toString());
        continue;
      }
      label912:
      Log.e("MicroMsg.NetSceneSnsAdObjectDetial", "remindObject == null");
      continue;
      label923:
      a.a(paramArrayOfByte, localeae);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.m
 * JD-Core Version:    0.7.0.1
 */