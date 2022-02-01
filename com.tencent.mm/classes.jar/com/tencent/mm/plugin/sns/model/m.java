package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cty;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.dfy;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.vfs.o;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends n
  implements com.tencent.mm.network.k
{
  public static List<Long> zxU;
  public static List<Long> zxV;
  public com.tencent.mm.ak.f callback;
  private long dKq;
  private String iuH;
  private b rr;
  
  static
  {
    AppMethodBeat.i(95578);
    zxU = Collections.synchronizedList(new LinkedList());
    zxV = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(95578);
  }
  
  public m(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95574);
    this.dKq = paramLong;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new dfx();
    ((b.a)localObject1).hQG = new dfy();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
    ((b.a)localObject1).funcId = 683;
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.ajS();
    this.iuH = (com.tencent.mm.kernel.g.ajR().cachePath + "ad_detail_session");
    int i;
    if (az.isWifi(ak.getContext())) {
      i = 1;
    }
    for (;;)
    {
      localObject2 = o.bb(this.iuH, 0, -1);
      this.rr = ((b.a)localObject1).aDS();
      ((dfx)this.rr.hQD.hQJ).Id = paramLong;
      ((dfx)this.rr.hQD.hQJ).HNa = z.al((byte[])localObject2);
      ((dfx)this.rr.hQD.hQJ).Scene = paramInt;
      ((dfx)this.rr.hQD.hQJ).HNc = i;
      if ((paramString != null) && (paramString.length() > 0)) {
        ((dfx)this.rr.hQD.hQJ).HNb = z.Jx(paramString);
      }
      localObject1 = new StringBuilder("req snsId ").append(paramLong).append(" ").append(r.zV(paramLong)).append(" scene ").append(paramInt).append(" buf is null? ");
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.d("MicroMsg.NetSceneSnsAdObjectDetial", bool);
        ae.i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
        AppMethodBeat.o(95574);
        return;
        if (az.is3G(ak.getContext()))
        {
          i = 3;
          break;
        }
        if (az.is4G(ak.getContext()))
        {
          i = 4;
          break;
        }
        if (!az.is2G(ak.getContext())) {
          break label388;
        }
        i = 2;
        break;
      }
      label388:
      i = 0;
    }
  }
  
  public m(long paramLong, cty paramcty)
  {
    this(paramLong, 2, "");
    AppMethodBeat.i(95575);
    ((dfx)this.rr.hQD.hQJ).FOe = paramcty;
    AppMethodBeat.o(95575);
  }
  
  public static boolean Aa(long paramLong)
  {
    AppMethodBeat.i(95570);
    if (zxU.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95570);
      return false;
    }
    zxU.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95570);
    return true;
  }
  
  public static boolean Ab(long paramLong)
  {
    AppMethodBeat.i(95571);
    if (zxV.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95571);
      return false;
    }
    zxV.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95571);
    return true;
  }
  
  private static boolean Ac(long paramLong)
  {
    AppMethodBeat.i(95572);
    zxV.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95572);
    return true;
  }
  
  private static boolean Ad(long paramLong)
  {
    AppMethodBeat.i(95573);
    zxU.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95573);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(95576);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95576);
    return i;
  }
  
  public final int getType()
  {
    return 683;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95577);
    ae.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + paramInt2 + " errCode " + paramInt3);
    int i = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label203;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (((dfx)this.rr.hQD.hQJ).Scene != 2) {
        break label190;
      }
      com.tencent.mm.plugin.report.service.g.yxI.dD(955, 1);
    }
    for (;;)
    {
      Ad(this.dKq);
      Ac(this.dKq);
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
      paramq = z.a(((dfy)this.rr.hQE.hQJ).HNa);
      if (paramq != null)
      {
        o.deleteFile(this.iuH);
        o.f(this.iuH, paramq, paramq.length);
      }
      paramInt1 = 0;
      break;
      label190:
      com.tencent.mm.plugin.report.service.g.yxI.dD(955, 0);
    }
    label203:
    paramq = z.a(((dfy)this.rr.hQE.hQJ).HNa);
    if (paramq != null)
    {
      o.deleteFile(this.iuH);
      o.f(this.iuH, paramq, paramq.length);
    }
    paramq = ((dfy)this.rr.hQE.hQJ).HNd;
    paramArrayOfByte = ((dfy)this.rr.hQE.hQJ).HNe;
    int j = ((dfx)this.rr.hQD.hQJ).Scene;
    if (paramq != null)
    {
      ae.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + z.b(paramq.HMY.ObjectDesc));
      ae.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + paramq.HMZ);
    }
    if ((paramq != null) && (paramq.HMY != null) && (paramq.HMY.DeleteFlag > 0))
    {
      ae.i("MicroMsg.NetSceneSnsAdObjectDetial", paramq.HMY.Id + " will remove by get detail ");
      Ad(this.dKq);
      Ac(this.dKq);
      ah.dXH().delete(paramq.HMY.Id);
      ah.dXJ().AB(paramq.HMY.Id);
      i.AA(paramq.HMY.Id);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95577);
      return;
    }
    if ((paramq != null) && (paramq.HMY != null))
    {
      if (paramq.HMY.CommentUserList == null)
      {
        paramInt1 = 0;
        if (paramq.HMY.LikeUserList != null) {
          break label753;
        }
        i = 0;
        ae.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment.size=" + paramInt1 + " liked.size=" + i + ", likeFlag=" + paramq.HMY.LikeFlag + ", snsId=" + r.zV(paramq.HMY.Id));
      }
    }
    else
    {
      if (j != 2) {
        break label800;
      }
      ae.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", new Object[] { Long.valueOf(this.dKq) });
      paramq = ((dfy)this.rr.hQE.hQJ).HNf;
      if (paramq != null) {
        a.b(paramq);
      }
    }
    for (;;)
    {
      try
      {
        paramq = ah.dXH().Ax(paramq.FOb.HMY.Id);
        d.a(paramq.ebP(), paramq.dVj(), 3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        Ad(this.dKq);
        Ac(this.dKq);
        AppMethodBeat.o(95577);
        return;
        paramInt1 = paramq.HMY.CommentUserList.size();
        break;
        label753:
        i = paramq.HMY.LikeUserList.size();
      }
      catch (Throwable paramq)
      {
        ae.e("MicroMsg.NetSceneSnsAdObjectDetial", "TimeLineAdPreloadHelper->checkPreloadAdResource exp=" + paramq.toString());
        continue;
      }
      label800:
      a.a(paramq, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.m
 * JD-Core Version:    0.7.0.1
 */