package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.czq;
import com.tencent.mm.protocal.protobuf.czr;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class l
  extends n
  implements com.tencent.mm.network.k
{
  public static List<Long> xRl;
  public static List<Long> xRm;
  public com.tencent.mm.ak.g callback;
  private long dwQ;
  private String hYr;
  private b rr;
  
  static
  {
    AppMethodBeat.i(95578);
    xRl = Collections.synchronizedList(new LinkedList());
    xRm = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(95578);
  }
  
  public l(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95574);
    this.dwQ = paramLong;
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new czq();
    ((b.a)localObject1).hvu = new czr();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
    ((b.a)localObject1).funcId = 683;
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.agS();
    this.hYr = (com.tencent.mm.kernel.g.agR().cachePath + "ad_detail_session");
    int i;
    if (ax.isWifi(ai.getContext())) {
      i = 1;
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.vfs.i.aU(this.hYr, 0, -1);
      this.rr = ((b.a)localObject1).aAz();
      ((czq)this.rr.hvr.hvw).Id = paramLong;
      ((czq)this.rr.hvr.hvw).FIP = z.al((byte[])localObject2);
      ((czq)this.rr.hvr.hvw).Scene = paramInt;
      ((czq)this.rr.hvr.hvw).FIR = i;
      if ((paramString != null) && (paramString.length() > 0)) {
        ((czq)this.rr.hvr.hvw).FIQ = z.FJ(paramString);
      }
      localObject1 = new StringBuilder("req snsId ").append(paramLong).append(" ").append(com.tencent.mm.plugin.sns.data.q.wW(paramLong)).append(" scene ").append(paramInt).append(" buf is null? ");
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.d("MicroMsg.NetSceneSnsAdObjectDetial", bool);
        ac.i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
        AppMethodBeat.o(95574);
        return;
        if (ax.is3G(ai.getContext()))
        {
          i = 3;
          break;
        }
        if (ax.is4G(ai.getContext()))
        {
          i = 4;
          break;
        }
        if (!ax.is2G(ai.getContext())) {
          break label388;
        }
        i = 2;
        break;
      }
      label388:
      i = 0;
    }
  }
  
  public l(long paramLong, cob paramcob)
  {
    this(paramLong, 2, "");
    AppMethodBeat.i(95575);
    ((czq)this.rr.hvr.hvw).DQr = paramcob;
    AppMethodBeat.o(95575);
  }
  
  public static boolean xd(long paramLong)
  {
    AppMethodBeat.i(95570);
    if (xRl.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95570);
      return false;
    }
    xRl.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95570);
    return true;
  }
  
  public static boolean xe(long paramLong)
  {
    AppMethodBeat.i(95571);
    if (xRm.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95571);
      return false;
    }
    xRm.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95571);
    return true;
  }
  
  private static boolean xf(long paramLong)
  {
    AppMethodBeat.i(95572);
    xRm.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95572);
    return true;
  }
  
  private static boolean xg(long paramLong)
  {
    AppMethodBeat.i(95573);
    xRl.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95573);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(95576);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + paramInt2 + " errCode " + paramInt3);
    int i = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label203;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (((czq)this.rr.hvr.hvw).Scene != 2) {
        break label190;
      }
      h.wUl.dB(955, 1);
    }
    for (;;)
    {
      xg(this.dwQ);
      xf(this.dwQ);
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
      paramq = z.a(((czr)this.rr.hvs.hvw).FIP);
      if (paramq != null)
      {
        com.tencent.mm.vfs.i.deleteFile(this.hYr);
        com.tencent.mm.vfs.i.f(this.hYr, paramq, paramq.length);
      }
      paramInt1 = 0;
      break;
      label190:
      h.wUl.dB(955, 0);
    }
    label203:
    paramq = z.a(((czr)this.rr.hvs.hvw).FIP);
    if (paramq != null)
    {
      com.tencent.mm.vfs.i.deleteFile(this.hYr);
      com.tencent.mm.vfs.i.f(this.hYr, paramq, paramq.length);
    }
    paramq = ((czr)this.rr.hvs.hvw).FIS;
    paramArrayOfByte = ((czr)this.rr.hvs.hvw).FIT;
    int j = ((czq)this.rr.hvr.hvw).Scene;
    if (paramq != null)
    {
      ac.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + z.b(paramq.FIN.ObjectDesc));
      ac.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + paramq.FIO);
    }
    if ((paramq != null) && (paramq.FIN != null) && (paramq.FIN.DeleteFlag > 0))
    {
      ac.i("MicroMsg.NetSceneSnsAdObjectDetial", paramq.FIN.Id + " will remove by get detail ");
      xg(this.dwQ);
      xf(this.dwQ);
      af.dHU().delete(paramq.FIN.Id);
      af.dHW().xF(paramq.FIN.Id);
      com.tencent.mm.plugin.sns.storage.i.xE(paramq.FIN.Id);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95577);
      return;
    }
    if ((paramq != null) && (paramq.FIN != null))
    {
      if (paramq.FIN.CommentUserList == null)
      {
        paramInt1 = 0;
        if (paramq.FIN.LikeUserList != null) {
          break label753;
        }
        i = 0;
        ac.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment.size=" + paramInt1 + " liked.size=" + i + ", likeFlag=" + paramq.FIN.LikeFlag + ", snsId=" + com.tencent.mm.plugin.sns.data.q.wW(paramq.FIN.Id));
      }
    }
    else
    {
      if (j != 2) {
        break label800;
      }
      ac.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", new Object[] { Long.valueOf(this.dwQ) });
      paramq = ((czr)this.rr.hvs.hvw).FIU;
      if (paramq != null) {
        a.b(paramq);
      }
    }
    for (;;)
    {
      try
      {
        paramq = af.dHU().xB(paramq.DQo.FIN.Id);
        com.tencent.mm.plugin.sns.ad.timeline.a.a.a(paramq.dLV(), paramq.dFR(), 3);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        xg(this.dwQ);
        xf(this.dwQ);
        AppMethodBeat.o(95577);
        return;
        paramInt1 = paramq.FIN.CommentUserList.size();
        break;
        label753:
        i = paramq.FIN.LikeUserList.size();
      }
      catch (Throwable paramq)
      {
        ac.e("MicroMsg.NetSceneSnsAdObjectDetial", "TimeLineAdPreloadHelper->checkPreloadAdResource exp=" + paramq.toString());
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