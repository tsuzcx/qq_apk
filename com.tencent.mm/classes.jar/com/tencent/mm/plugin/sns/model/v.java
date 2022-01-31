package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.protocal.protobuf.cez;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends com.tencent.mm.ai.m
  implements k
{
  public f callback;
  private String cqq;
  private int ctW;
  public LinkedList<cex> rfo;
  public int rfp;
  private b rr;
  
  public v(int paramInt)
  {
    AppMethodBeat.i(36323);
    this.rfo = null;
    this.ctW = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cey();
    ((b.a)localObject).fsY = new cez();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
    ((b.a)localObject).funcId = 292;
    ((b.a)localObject).reqCmdId = 116;
    ((b.a)localObject).respCmdId = 1000000116;
    this.rr = ((b.a)localObject).ado();
    localObject = ag.cpj().abz("@__weixintsnstag").field_md5;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      this.cqq = ((String)localObject);
      cey localcey = (cey)this.rr.fsV.fta;
      localcey.OpCode = paramInt;
      localcey.xPr = ((String)localObject);
      AppMethodBeat.o(36323);
      return;
    }
  }
  
  public static t a(t paramt, cex paramcex)
  {
    AppMethodBeat.i(36325);
    paramt.field_tagId = paramcex.xPq;
    paramt.field_tagName = bo.bf(paramcex.ntn, "");
    paramt.field_count = paramcex.jJu;
    paramt.dj(paramcex.jJv);
    ab.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + paramcex.toString());
    AppMethodBeat.o(36325);
    return paramt;
  }
  
  private static boolean a(List<Long> paramList, Long paramLong)
  {
    AppMethodBeat.i(36326);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Long)paramList.next()).longValue() == paramLong.longValue())
      {
        AppMethodBeat.o(36326);
        return true;
      }
    }
    AppMethodBeat.o(36326);
    return false;
  }
  
  private static boolean b(t paramt, cex paramcex)
  {
    boolean bool2 = false;
    AppMethodBeat.i(36329);
    paramt = paramt.field_memberList.split(",");
    paramcex = paramcex.jJv.iterator();
    label83:
    label90:
    label93:
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramcex.hasNext())
      {
        bwc localbwc = (bwc)paramcex.next();
        i = 0;
        if (i >= paramt.length) {
          break label90;
        }
        if (!paramt[i].equals(localbwc)) {
          break label83;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label93;
        }
        bool1 = true;
        AppMethodBeat.o(36329);
        return bool1;
        i += 1;
        break;
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(36324);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36324);
    return i;
  }
  
  public final int getType()
  {
    return 292;
  }
  
  public final List<String> lG(long paramLong)
  {
    AppMethodBeat.i(36327);
    LinkedList localLinkedList = new LinkedList();
    if (this.rfo == null)
    {
      AppMethodBeat.o(36327);
      return localLinkedList;
    }
    Iterator localIterator = this.rfo.iterator();
    while (localIterator.hasNext())
    {
      cex localcex = (cex)localIterator.next();
      if (localcex.xPq == paramLong)
      {
        localIterator = localcex.jJv.iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add(((bwc)localIterator.next()).xJE);
        }
        AppMethodBeat.o(36327);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(36327);
    return localLinkedList;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36328);
    ab.d("MicroMsg.NetSceneSnsTagList", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36328);
      return;
    }
    Object localObject1 = (cez)((b)paramq).fsW.fta;
    ab.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[] { Integer.valueOf(this.rfp) });
    this.rfp = ((cez)localObject1).rfp;
    this.rfo = ((cez)localObject1).jJv;
    paramq = ((cez)localObject1).xPr;
    if (this.cqq.equals(paramq))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(36328);
      return;
    }
    paramArrayOfByte = ag.cpl().cti();
    Object localObject2;
    if (this.ctW != 3) {
      localObject2 = paramArrayOfByte.iterator();
    }
    label507:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        Iterator localIterator = ((cez)localObject1).jJv.iterator();
        cex localcex;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localcex = (cex)localIterator.next();
        } while (((Long)localObject3).longValue() != localcex.xPq);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label507;
        }
        ((Iterator)localObject2).remove();
        ag.cpl().mc(((Long)localObject3).longValue());
        break;
        localObject1 = ((cez)localObject1).jJv.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cex)((Iterator)localObject1).next();
          if (!a(paramArrayOfByte, Long.valueOf(((cex)localObject2).xPq)))
          {
            localObject3 = new t();
            a((t)localObject3, (cex)localObject2);
            ag.cpl().a((t)localObject3);
          }
          else
          {
            localObject3 = ag.cpl().mb(((cex)localObject2).xPq);
            if (((((t)localObject3).field_tagName != null) && (!((t)localObject3).field_tagName.equals(((cex)localObject2).ntn))) || (((t)localObject3).field_count != ((cex)localObject2).jJu) || (b((t)localObject3, (cex)localObject2)))
            {
              a((t)localObject3, (cex)localObject2);
              ag.cpl().a((t)localObject3);
            }
          }
        }
        paramArrayOfByte = ag.cpj().abz("@__weixintsnstag");
        paramArrayOfByte.field_md5 = paramq;
        ag.cpj().a(paramArrayOfByte);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(36328);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.v
 * JD-Core Version:    0.7.0.1
 */