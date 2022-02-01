package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgu;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends com.tencent.mm.al.n
  implements k
{
  public f callback;
  private int drI;
  private String md5;
  private b rr;
  public LinkedList<dgt> zia;
  public int zib;
  
  public u(int paramInt)
  {
    AppMethodBeat.i(95648);
    this.zia = null;
    this.drI = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dgu();
    ((b.a)localObject).hNN = new dgv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
    ((b.a)localObject).funcId = 292;
    ((b.a)localObject).hNO = 116;
    ((b.a)localObject).respCmdId = 1000000116;
    this.rr = ((b.a)localObject).aDC();
    localObject = ag.dUi().aAf("@__weixintsnstag").field_md5;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      this.md5 = ((String)localObject);
      dgu localdgu = (dgu)this.rr.hNK.hNQ;
      localdgu.OpCode = paramInt;
      localdgu.Hve = ((String)localObject);
      AppMethodBeat.o(95648);
      return;
    }
  }
  
  public static v a(v paramv, dgt paramdgt)
  {
    AppMethodBeat.i(95650);
    paramv.field_tagId = paramdgt.Hvd;
    paramv.field_tagName = bt.bI(paramdgt.uiP, "");
    paramv.field_count = paramdgt.nDi;
    paramv.fS(paramdgt.nDj);
    ad.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + paramdgt.toString());
    AppMethodBeat.o(95650);
    return paramv;
  }
  
  private static boolean a(List<Long> paramList, Long paramLong)
  {
    AppMethodBeat.i(95651);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((Long)paramList.next()).longValue() == paramLong.longValue())
      {
        AppMethodBeat.o(95651);
        return true;
      }
    }
    AppMethodBeat.o(95651);
    return false;
  }
  
  private static boolean b(v paramv, dgt paramdgt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(95654);
    paramv = paramv.field_memberList.split(",");
    paramdgt = paramdgt.nDj.iterator();
    label83:
    label90:
    label93:
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramdgt.hasNext())
      {
        cwt localcwt = (cwt)paramdgt.next();
        i = 0;
        if (i >= paramv.length) {
          break label90;
        }
        if (!paramv[i].equals(localcwt)) {
          break label83;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label93;
        }
        bool1 = true;
        AppMethodBeat.o(95654);
        return bool1;
        i += 1;
        break;
      }
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(95649);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95649);
    return i;
  }
  
  public final int getType()
  {
    return 292;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95653);
    ad.d("MicroMsg.NetSceneSnsTagList", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    Object localObject1 = (dgv)((b)paramq).hNL.hNQ;
    ad.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[] { Integer.valueOf(this.zib) });
    this.zib = ((dgv)localObject1).zib;
    this.zia = ((dgv)localObject1).nDj;
    paramq = ((dgv)localObject1).Hve;
    if (this.md5.equals(paramq))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    paramArrayOfByte = ag.dUk().dZo();
    Object localObject2;
    if (this.drI != 3) {
      localObject2 = paramArrayOfByte.iterator();
    }
    label504:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        Iterator localIterator = ((dgv)localObject1).nDj.iterator();
        dgt localdgt;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localdgt = (dgt)localIterator.next();
        } while (((Long)localObject3).longValue() != localdgt.Hvd);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label504;
        }
        ((Iterator)localObject2).remove();
        ag.dUk().Al(((Long)localObject3).longValue());
        break;
        localObject1 = ((dgv)localObject1).nDj.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dgt)((Iterator)localObject1).next();
          if (!a(paramArrayOfByte, Long.valueOf(((dgt)localObject2).Hvd)))
          {
            localObject3 = new v();
            a((v)localObject3, (dgt)localObject2);
            ag.dUk().a((v)localObject3);
          }
          else
          {
            localObject3 = ag.dUk().Ak(((dgt)localObject2).Hvd);
            if (((((v)localObject3).field_tagName != null) && (!((v)localObject3).field_tagName.equals(((dgt)localObject2).uiP))) || (((v)localObject3).field_count != ((dgt)localObject2).nDi) || (b((v)localObject3, (dgt)localObject2)))
            {
              a((v)localObject3, (dgt)localObject2);
              ag.dUk().a((v)localObject3);
            }
          }
        }
        paramArrayOfByte = ag.dUi().aAf("@__weixintsnstag");
        paramArrayOfByte.field_md5 = paramq;
        ag.dUi().a(paramArrayOfByte);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95653);
        return;
      }
    }
  }
  
  public final List<String> zL(long paramLong)
  {
    AppMethodBeat.i(95652);
    LinkedList localLinkedList = new LinkedList();
    if (this.zia == null)
    {
      AppMethodBeat.o(95652);
      return localLinkedList;
    }
    Iterator localIterator = this.zia.iterator();
    while (localIterator.hasNext())
    {
      dgt localdgt = (dgt)localIterator.next();
      if (localdgt.Hvd == paramLong)
      {
        localIterator = localdgt.nDj.iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add(((cwt)localIterator.next()).HoB);
        }
        AppMethodBeat.o(95652);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(95652);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u
 * JD-Core Version:    0.7.0.1
 */