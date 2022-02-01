package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.protocal.protobuf.dfc;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dfe;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends n
  implements com.tencent.mm.network.k
{
  public static List<Long> zhf;
  public static List<Long> zhg;
  public com.tencent.mm.al.f callback;
  private long dJc;
  private String irN;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(95578);
    zhf = Collections.synchronizedList(new LinkedList());
    zhg = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(95578);
  }
  
  public l(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95574);
    this.dJc = paramLong;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new dfd();
    ((b.a)localObject1).hNN = new dfe();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
    ((b.a)localObject1).funcId = 683;
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.ajD();
    this.irN = (com.tencent.mm.kernel.g.ajC().cachePath + "ad_detail_session");
    int i;
    if (ay.isWifi(aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.vfs.i.aY(this.irN, 0, -1);
      this.rr = ((b.a)localObject1).aDC();
      ((dfd)this.rr.hNK.hNQ).Id = paramLong;
      ((dfd)this.rr.hNK.hNQ).Htx = z.al((byte[])localObject2);
      ((dfd)this.rr.hNK.hNQ).Scene = paramInt;
      ((dfd)this.rr.hNK.hNQ).Htz = i;
      if ((paramString != null) && (paramString.length() > 0)) {
        ((dfd)this.rr.hNK.hNQ).Hty = z.IY(paramString);
      }
      localObject1 = new StringBuilder("req snsId ").append(paramLong).append(" ").append(com.tencent.mm.plugin.sns.data.q.zw(paramLong)).append(" scene ").append(paramInt).append(" buf is null? ");
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.NetSceneSnsAdObjectDetial", bool);
        ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
        AppMethodBeat.o(95574);
        return;
        if (ay.is3G(aj.getContext()))
        {
          i = 3;
          break;
        }
        if (ay.is4G(aj.getContext()))
        {
          i = 4;
          break;
        }
        if (!ay.is2G(aj.getContext())) {
          break label388;
        }
        i = 2;
        break;
      }
      label388:
      i = 0;
    }
  }
  
  public l(long paramLong, cte paramcte)
  {
    this(paramLong, 2, "");
    AppMethodBeat.i(95575);
    ((dfd)this.rr.hNK.hNQ).FvG = paramcte;
    AppMethodBeat.o(95575);
  }
  
  public static boolean zC(long paramLong)
  {
    AppMethodBeat.i(95570);
    if (zhf.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95570);
      return false;
    }
    zhf.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95570);
    return true;
  }
  
  public static boolean zD(long paramLong)
  {
    AppMethodBeat.i(95571);
    if (zhg.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95571);
      return false;
    }
    zhg.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95571);
    return true;
  }
  
  private static boolean zE(long paramLong)
  {
    AppMethodBeat.i(95572);
    zhg.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95572);
    return true;
  }
  
  private static boolean zF(long paramLong)
  {
    AppMethodBeat.i(95573);
    zhf.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95573);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95577);
    ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + paramInt2 + " errCode " + paramInt3);
    int i = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label203;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (((dfd)this.rr.hNK.hNQ).Scene != 2) {
        break label190;
      }
      com.tencent.mm.plugin.report.service.g.yhR.dD(955, 1);
    }
    for (;;)
    {
      zF(this.dJc);
      zE(this.dJc);
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
      paramq = z.a(((dfe)this.rr.hNL.hNQ).Htx);
      if (paramq != null)
      {
        com.tencent.mm.vfs.i.deleteFile(this.irN);
        com.tencent.mm.vfs.i.f(this.irN, paramq, paramq.length);
      }
      paramInt1 = 0;
      break;
      label190:
      com.tencent.mm.plugin.report.service.g.yhR.dD(955, 0);
    }
    label203:
    paramq = z.a(((dfe)this.rr.hNL.hNQ).Htx);
    if (paramq != null)
    {
      com.tencent.mm.vfs.i.deleteFile(this.irN);
      com.tencent.mm.vfs.i.f(this.irN, paramq, paramq.length);
    }
    paramq = ((dfe)this.rr.hNL.hNQ).HtA;
    paramArrayOfByte = ((dfe)this.rr.hNL.hNQ).HtB;
    int j = ((dfd)this.rr.hNK.hNQ).Scene;
    if (paramq != null)
    {
      ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + z.b(paramq.Htv.ObjectDesc));
      ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + paramq.Htw);
    }
    if ((paramq != null) && (paramq.Htv != null) && (paramq.Htv.DeleteFlag > 0))
    {
      ad.i("MicroMsg.NetSceneSnsAdObjectDetial", paramq.Htv.Id + " will remove by get detail ");
      zF(this.dJc);
      zE(this.dJc);
      ag.dUh().delete(paramq.Htv.Id);
      ag.dUj().Ad(paramq.Htv.Id);
      com.tencent.mm.plugin.sns.storage.i.Ac(paramq.Htv.Id);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95577);
      return;
    }
    if ((paramq != null) && (paramq.Htv != null))
    {
      if (paramq.Htv.CommentUserList == null)
      {
        paramInt1 = 0;
        if (paramq.Htv.LikeUserList != null) {
          break label753;
        }
        i = 0;
        ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment.size=" + paramInt1 + " liked.size=" + i + ", likeFlag=" + paramq.Htv.LikeFlag + ", snsId=" + com.tencent.mm.plugin.sns.data.q.zw(paramq.Htv.Id));
      }
    }
    else
    {
      if (j != 2) {
        break label800;
      }
      ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", new Object[] { Long.valueOf(this.dJc) });
      paramq = ((dfe)this.rr.hNL.hNQ).HtC;
      if (paramq != null) {
        a.b(paramq);
      }
    }
    for (;;)
    {
      try
      {
        paramq = ag.dUh().zZ(paramq.FvD.Htv.Id);
        com.tencent.mm.plugin.sns.ad.timeline.a.b.a(paramq.dYl(), paramq.dRL(), 3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        zF(this.dJc);
        zE(this.dJc);
        AppMethodBeat.o(95577);
        return;
        paramInt1 = paramq.Htv.CommentUserList.size();
        break;
        label753:
        i = paramq.Htv.LikeUserList.size();
      }
      catch (Throwable paramq)
      {
        ad.e("MicroMsg.NetSceneSnsAdObjectDetial", "TimeLineAdPreloadHelper->checkPreloadAdResource exp=" + paramq.toString());
        continue;
      }
      label800:
      a.a(paramq, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.l
 * JD-Core Version:    0.7.0.1
 */