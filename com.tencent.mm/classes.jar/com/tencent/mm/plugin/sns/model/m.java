package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.cdh;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m
  extends com.tencent.mm.ai.m
  implements com.tencent.mm.network.k
{
  public static List<Long> reu;
  public static List<Long> rev;
  private long cIo;
  public com.tencent.mm.ai.f callback;
  private String fVg;
  private b rr;
  
  static
  {
    AppMethodBeat.i(36253);
    reu = Collections.synchronizedList(new LinkedList());
    rev = Collections.synchronizedList(new LinkedList());
    AppMethodBeat.o(36253);
  }
  
  public m(long paramLong, int paramInt, String paramString)
  {
    AppMethodBeat.i(36249);
    this.cIo = paramLong;
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new cdi();
    ((b.a)localObject1).fsY = new cdj();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
    ((b.a)localObject1).funcId = 683;
    Object localObject2 = new StringBuilder();
    g.RM();
    this.fVg = (g.RL().cachePath + "ad_detail_session");
    int i;
    if (at.isWifi(ah.getContext())) {
      i = 1;
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.vfs.e.i(this.fVg, 0, -1);
      this.rr = ((b.a)localObject1).ado();
      ((cdi)this.rr.fsV.fta).Id = paramLong;
      ((cdi)this.rr.fsV.fta).xNO = aa.ac((byte[])localObject2);
      ((cdi)this.rr.fsV.fta).Scene = paramInt;
      ((cdi)this.rr.fsV.fta).xNQ = i;
      if ((paramString != null) && (paramString.length() > 0)) {
        ((cdi)this.rr.fsV.fta).xNP = aa.wB(paramString);
      }
      localObject1 = new StringBuilder("req snsId ").append(paramLong).append(" ").append(com.tencent.mm.plugin.sns.data.i.lq(paramLong)).append(" scene ").append(paramInt).append(" buf is null? ");
      if (localObject2 == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("MicroMsg.NetSceneSnsAdObjectDetial", bool);
        ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), paramString });
        AppMethodBeat.o(36249);
        return;
        if (at.is3G(ah.getContext()))
        {
          i = 3;
          break;
        }
        if (at.is4G(ah.getContext()))
        {
          i = 4;
          break;
        }
        if (!at.is2G(ah.getContext())) {
          break label388;
        }
        i = 2;
        break;
      }
      label388:
      i = 0;
    }
  }
  
  public m(long paramLong, btk parambtk)
  {
    this(paramLong, 2, "");
    AppMethodBeat.i(36250);
    ((cdi)this.rr.fsV.fta).wpo = parambtk;
    AppMethodBeat.o(36250);
  }
  
  private static boolean lA(long paramLong)
  {
    AppMethodBeat.i(36248);
    reu.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(36248);
    return true;
  }
  
  public static boolean lx(long paramLong)
  {
    AppMethodBeat.i(36245);
    if (reu.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(36245);
      return false;
    }
    reu.add(Long.valueOf(paramLong));
    AppMethodBeat.o(36245);
    return true;
  }
  
  public static boolean ly(long paramLong)
  {
    AppMethodBeat.i(36246);
    if (rev.contains(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(36246);
      return false;
    }
    rev.add(Long.valueOf(paramLong));
    AppMethodBeat.o(36246);
    return true;
  }
  
  private static boolean lz(long paramLong)
  {
    AppMethodBeat.i(36247);
    rev.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(36247);
    return true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(36251);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36251);
    return i;
  }
  
  public final int getType()
  {
    return 683;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36252);
    ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + paramInt2 + " errCode " + paramInt3);
    int i = 0;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt1 = 1;
      if (paramInt1 != 0) {
        break label203;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if (((cdi)this.rr.fsV.fta).Scene != 2) {
        break label190;
      }
      h.qsU.cT(955, 1);
    }
    for (;;)
    {
      lA(this.cIo);
      lz(this.cIo);
      AppMethodBeat.o(36252);
      return;
      paramInt1 = i;
      if (paramInt2 != 4) {
        break;
      }
      paramInt1 = i;
      if (paramInt3 != 1) {
        break;
      }
      paramq = aa.a(((cdj)this.rr.fsW.fta).xNO);
      if (paramq != null)
      {
        com.tencent.mm.vfs.e.deleteFile(this.fVg);
        com.tencent.mm.vfs.e.b(this.fVg, paramq, paramq.length);
      }
      paramInt1 = 0;
      break;
      label190:
      h.qsU.cT(955, 0);
    }
    label203:
    paramq = aa.a(((cdj)this.rr.fsW.fta).xNO);
    if (paramq != null)
    {
      com.tencent.mm.vfs.e.deleteFile(this.fVg);
      com.tencent.mm.vfs.e.b(this.fVg, paramq, paramq.length);
    }
    paramq = ((cdj)this.rr.fsW.fta).xNR;
    paramArrayOfByte = ((cdj)this.rr.fsW.fta).xNS;
    paramInt1 = ((cdi)this.rr.fsV.fta).Scene;
    if (paramq != null)
    {
      ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + aa.b(paramq.xNM.ObjectDesc));
      ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + paramq.xNN);
    }
    if ((paramq != null) && (paramq.xNM != null) && (paramq.xNM.DeleteFlag > 0))
    {
      ab.i("MicroMsg.NetSceneSnsAdObjectDetial", paramq.xNM.Id + " will remove by get detail ");
      lA(this.cIo);
      lz(this.cIo);
      ag.cpi().delete(paramq.xNM.Id);
      ag.cpk().lU(paramq.xNM.Id);
      com.tencent.mm.plugin.sns.storage.i.lT(paramq.xNM.Id);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36252);
      return;
    }
    if ((paramq != null) && (paramq.xNM != null)) {
      ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment:" + paramq.xNM.CommentUserList.size() + " like: " + paramq.xNM.LikeUserList.size());
    }
    if (paramInt1 == 2)
    {
      ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", new Object[] { Long.valueOf(this.cIo) });
      paramq = ((cdj)this.rr.fsW.fta).xNT;
      if (paramq != null) {
        a.a(paramq);
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      lA(this.cIo);
      lz(this.cIo);
      AppMethodBeat.o(36252);
      return;
      a.a(paramq, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.m
 * JD-Core Version:    0.7.0.1
 */