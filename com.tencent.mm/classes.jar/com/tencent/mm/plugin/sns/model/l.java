package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.protocal.protobuf.cuf;
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
  public static List<Long> wEQ;
  public static List<Long> wER;
  public com.tencent.mm.al.g callback;
  private long dze;
  private String hxQ;
  private b rr;
  
  static
  {
    AppMethodBeat.i(95578);
    wEQ = Collections.synchronizedList(new LinkedList());
    wER = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(95578);
  }
  
  public l(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(95574);
    this.dze = paramLong;
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new cue();
    ((b.a)localObject1).gUV = new cuf();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
    ((b.a)localObject1).funcId = 683;
    Object localObject2 = new StringBuilder();
    com.tencent.mm.kernel.g.afC();
    this.hxQ = (com.tencent.mm.kernel.g.afB().cachePath + "ad_detail_session");
    int i;
    if (ay.isWifi(aj.getContext())) {
      i = 1;
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.vfs.i.aR(this.hxQ, 0, -1);
      this.rr = ((b.a)localObject1).atI();
      ((cue)this.rr.gUS.gUX).Id = paramLong;
      ((cue)this.rr.gUS.gUX).ElQ = z.am((byte[])localObject2);
      ((cue)this.rr.gUS.gUX).Scene = paramInt;
      ((cue)this.rr.gUS.gUX).ElS = i;
      if ((paramString != null) && (paramString.length() > 0)) {
        ((cue)this.rr.gUS.gUX).ElR = z.BF(paramString);
      }
      localObject1 = new StringBuilder("req snsId ").append(paramLong).append(" ").append(com.tencent.mm.plugin.sns.data.q.st(paramLong)).append(" scene ").append(paramInt).append(" buf is null? ");
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
  
  public l(long paramLong, ciu paramciu)
  {
    this(paramLong, 2, "");
    AppMethodBeat.i(95575);
    ((cue)this.rr.gUS.gUX).CxV = paramciu;
    AppMethodBeat.o(95575);
  }
  
  public static boolean sA(long paramLong)
  {
    AppMethodBeat.i(95570);
    if (wEQ.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95570);
      return false;
    }
    wEQ.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95570);
    return true;
  }
  
  public static boolean sB(long paramLong)
  {
    AppMethodBeat.i(95571);
    if (wER.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(95571);
      return false;
    }
    wER.add(Long.valueOf(paramLong));
    AppMethodBeat.o(95571);
    return true;
  }
  
  private static boolean sC(long paramLong)
  {
    AppMethodBeat.i(95572);
    wER.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95572);
    return true;
  }
  
  private static boolean sD(long paramLong)
  {
    AppMethodBeat.i(95573);
    wEQ.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(95573);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
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
    ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + paramInt2 + " errCode " + paramInt3);
    int i = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label203;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (((cue)this.rr.gUS.gUX).Scene != 2) {
        break label190;
      }
      h.vKh.dB(955, 1);
    }
    for (;;)
    {
      sD(this.dze);
      sC(this.dze);
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
      paramq = z.a(((cuf)this.rr.gUT.gUX).ElQ);
      if (paramq != null)
      {
        com.tencent.mm.vfs.i.deleteFile(this.hxQ);
        com.tencent.mm.vfs.i.f(this.hxQ, paramq, paramq.length);
      }
      paramInt1 = 0;
      break;
      label190:
      h.vKh.dB(955, 0);
    }
    label203:
    paramq = z.a(((cuf)this.rr.gUT.gUX).ElQ);
    if (paramq != null)
    {
      com.tencent.mm.vfs.i.deleteFile(this.hxQ);
      com.tencent.mm.vfs.i.f(this.hxQ, paramq, paramq.length);
    }
    paramq = ((cuf)this.rr.gUT.gUX).ElT;
    paramArrayOfByte = ((cuf)this.rr.gUT.gUX).ElU;
    int j = ((cue)this.rr.gUS.gUX).Scene;
    if (paramq != null)
    {
      ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + z.b(paramq.ElO.ObjectDesc));
      ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + paramq.ElP);
    }
    if ((paramq != null) && (paramq.ElO != null) && (paramq.ElO.DeleteFlag > 0))
    {
      ad.i("MicroMsg.NetSceneSnsAdObjectDetial", paramq.ElO.Id + " will remove by get detail ");
      sD(this.dze);
      sC(this.dze);
      af.dtx().delete(paramq.ElO.Id);
      af.dtz().tc(paramq.ElO.Id);
      com.tencent.mm.plugin.sns.storage.i.tb(paramq.ElO.Id);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95577);
      return;
    }
    if ((paramq != null) && (paramq.ElO != null))
    {
      if (paramq.ElO.CommentUserList == null)
      {
        paramInt1 = 0;
        if (paramq.ElO.LikeUserList != null) {
          break label719;
        }
        i = 0;
        label541:
        ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment.size=" + paramInt1 + " liked.size=" + i + ", likeFlag=" + paramq.ElO.LikeFlag + ", snsId=" + com.tencent.mm.plugin.sns.data.q.st(paramq.ElO.Id));
      }
    }
    else
    {
      if (j != 2) {
        break label735;
      }
      ad.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", new Object[] { Long.valueOf(this.dze) });
      paramq = ((cuf)this.rr.gUT.gUX).ElV;
      if (paramq != null) {
        a.b(paramq);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      sD(this.dze);
      sC(this.dze);
      AppMethodBeat.o(95577);
      return;
      paramInt1 = paramq.ElO.CommentUserList.size();
      break;
      label719:
      i = paramq.ElO.LikeUserList.size();
      break label541;
      label735:
      a.a(paramq, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.l
 * JD-Core Version:    0.7.0.1
 */