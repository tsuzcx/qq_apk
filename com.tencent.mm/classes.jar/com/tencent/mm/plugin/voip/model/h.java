package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.p;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.byz;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class h
  extends m
  implements k
{
  private static final List<Object> fIA;
  private static final Set<Long> tuw;
  private f callback;
  private long cpO;
  private final List<bi> fIB;
  private b rr;
  
  static
  {
    AppMethodBeat.i(4365);
    fIA = new ArrayList();
    tuw = new HashSet();
    AppMethodBeat.o(4365);
  }
  
  public h()
  {
    AppMethodBeat.i(4359);
    this.fIB = new LinkedList();
    ab.d("MicroMsg.NetSceneSendMsg", "dktext :" + bo.dtY());
    ab.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
    AppMethodBeat.o(4359);
  }
  
  public h(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(4358);
    this.fIB = new LinkedList();
    ab.d("MicroMsg.NetSceneSendMsg", "dktext :" + bo.dtY());
    if (!bo.isNullOrNil(paramString1))
    {
      bi localbi = new bi();
      localbi.setStatus(1);
      localbi.kj(paramString1);
      localbi.fQ(bf.py(paramString1));
      localbi.hL(1);
      localbi.setContent(paramString2);
      localbi.setType(paramInt);
      this.cpO = ((j)g.E(j.class)).bPQ().Z(localbi);
      if (this.cpO == -1L) {
        break label173;
      }
    }
    label173:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ab.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.cpO);
      AppMethodBeat.o(4358);
      return;
    }
  }
  
  private void aii()
  {
    AppMethodBeat.i(4363);
    int i = 0;
    while (i < this.fIB.size())
    {
      lK(i);
      i += 1;
    }
    AppMethodBeat.o(4363);
  }
  
  private void lK(int paramInt)
  {
    AppMethodBeat.i(4364);
    Object localObject = (bi)this.fIB.get(paramInt);
    ((bi)localObject).setStatus(5);
    ((j)g.E(j.class)).bPQ().a(((dd)localObject).field_msgId, (bi)localObject);
    localObject = fIA.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Iterator)localObject).next();
    }
    AppMethodBeat.o(4364);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(4361);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new byz();
    paramf.fsY = new bza();
    paramf.uri = "/cgi-bin/micromsg-bin/newsendmsg";
    paramf.funcId = 522;
    paramf.reqCmdId = 237;
    paramf.respCmdId = 1000000237;
    this.rr = paramf.ado();
    paramf = (byz)this.rr.fsV.fta;
    List localList = ((j)g.E(j.class)).bPQ().bQc();
    if (localList.size() == 0)
    {
      ab.i("MicroMsg.NetSceneSendMsg", "no sending message");
      AppMethodBeat.o(4361);
      return -2;
    }
    this.fIB.clear();
    int i = 0;
    while (i < localList.size())
    {
      bi localbi = (bi)localList.get(i);
      if (localbi.field_isSend == 1)
      {
        bdc localbdc = new bdc();
        localbdc.woQ = new bwc().aoF(localbi.field_talker);
        localbdc.CreateTime = ((int)(localbi.field_createTime / 1000L));
        localbdc.jKs = localbi.getType();
        localbdc.ntu = localbi.field_content;
        localbdc.xtf = p.t(r.Zn(), localbi.field_createTime).hashCode();
        localbdc.woU = bh.aaR();
        paramf.jJv.add(localbdc);
        paramf.jJu = paramf.jJv.size();
        this.fIB.add(localbi);
      }
      i += 1;
    }
    i = dispatch(parame, this.rr, this);
    if (i < 0) {
      aii();
    }
    AppMethodBeat.o(4361);
    return i;
  }
  
  public final int getType()
  {
    return 522;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(4362);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      aii();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(4362);
      return;
    }
    paramq = ((bza)this.rr.fsW.fta).jJv;
    if (this.fIB.size() == paramq.size())
    {
      paramInt1 = 0;
      while (paramInt1 < paramq.size())
      {
        paramArrayOfByte = (bdd)paramq.get(paramInt1);
        if (paramArrayOfByte.Ret != 0)
        {
          ab.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + paramArrayOfByte.Ret);
          lK(paramInt1);
          this.callback.onSceneEnd(4, paramArrayOfByte.Ret, paramString, this);
          AppMethodBeat.o(4362);
          return;
        }
        long l = ((bi)this.fIB.get(paramInt1)).field_msgId;
        ab.i("MicroMsg.NetSceneSendMsg", "msg local id = " + l + ", SvrId = " + paramArrayOfByte.pIG + " sent successfully!");
        bi localbi = ((j)g.E(j.class)).bPQ().kB(l);
        localbi.fP(paramArrayOfByte.pIG);
        localbi.setStatus(2);
        ((j)g.E(j.class)).bPQ().a(l, localbi);
        paramInt1 += 1;
      }
      ab.i("MicroMsg.NetSceneSendMsg", "total " + paramInt1 + " msgs sent successfully");
    }
    paramInt1 = doScene(dispatcher(), this.callback);
    if (paramInt1 == -2)
    {
      this.callback.onSceneEnd(0, 0, paramString, this);
      AppMethodBeat.o(4362);
      return;
    }
    if (paramInt1 < 0) {
      this.callback.onSceneEnd(3, -1, paramString, this);
    }
    AppMethodBeat.o(4362);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(4360);
    if (this.fIB.size() > 0)
    {
      paramq = m.b.ftu;
      AppMethodBeat.o(4360);
      return paramq;
    }
    paramq = m.b.ftv;
    AppMethodBeat.o(4360);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.h
 * JD-Core Version:    0.7.0.1
 */