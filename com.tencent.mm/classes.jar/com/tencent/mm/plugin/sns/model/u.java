package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dbh;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends com.tencent.mm.ak.n
  implements k
{
  public g callback;
  private int dgm;
  private String md5;
  private b rr;
  public LinkedList<dbg> xSg;
  public int xSh;
  
  public u(int paramInt)
  {
    AppMethodBeat.i(95648);
    this.xSg = null;
    this.dgm = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dbh();
    ((b.a)localObject).hvu = new dbi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
    ((b.a)localObject).funcId = 292;
    ((b.a)localObject).reqCmdId = 116;
    ((b.a)localObject).respCmdId = 1000000116;
    this.rr = ((b.a)localObject).aAz();
    localObject = af.dHV().auY("@__weixintsnstag").field_md5;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      this.md5 = ((String)localObject);
      dbh localdbh = (dbh)this.rr.hvr.hvw;
      localdbh.OpCode = paramInt;
      localdbh.FKw = ((String)localObject);
      AppMethodBeat.o(95648);
      return;
    }
  }
  
  public static v a(v paramv, dbg paramdbg)
  {
    AppMethodBeat.i(95650);
    paramv.field_tagId = paramdbg.FKv;
    paramv.field_tagName = bs.bG(paramdbg.tkJ, "");
    paramv.field_count = paramdbg.ncL;
    paramv.fH(paramdbg.ncM);
    ac.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + paramdbg.toString());
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
  
  private static boolean b(v paramv, dbg paramdbg)
  {
    boolean bool2 = false;
    AppMethodBeat.i(95654);
    paramv = paramv.field_memberList.split(",");
    paramdbg = paramdbg.ncM.iterator();
    label83:
    label90:
    label93:
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramdbg.hasNext())
      {
        crm localcrm = (crm)paramdbg.next();
        i = 0;
        if (i >= paramv.length) {
          break label90;
        }
        if (!paramv[i].equals(localcrm)) {
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
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(95649);
    this.callback = paramg;
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
    ac.d("MicroMsg.NetSceneSnsTagList", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    Object localObject1 = (dbi)((b)paramq).hvs.hvw;
    ac.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[] { Integer.valueOf(this.xSh) });
    this.xSh = ((dbi)localObject1).xSh;
    this.xSg = ((dbi)localObject1).ncM;
    paramq = ((dbi)localObject1).FKw;
    if (this.md5.equals(paramq))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    paramArrayOfByte = af.dHX().dMZ();
    Object localObject2;
    if (this.dgm != 3) {
      localObject2 = paramArrayOfByte.iterator();
    }
    label504:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        Iterator localIterator = ((dbi)localObject1).ncM.iterator();
        dbg localdbg;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localdbg = (dbg)localIterator.next();
        } while (((Long)localObject3).longValue() != localdbg.FKv);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label504;
        }
        ((Iterator)localObject2).remove();
        af.dHX().xN(((Long)localObject3).longValue());
        break;
        localObject1 = ((dbi)localObject1).ncM.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dbg)((Iterator)localObject1).next();
          if (!a(paramArrayOfByte, Long.valueOf(((dbg)localObject2).FKv)))
          {
            localObject3 = new v();
            a((v)localObject3, (dbg)localObject2);
            af.dHX().a((v)localObject3);
          }
          else
          {
            localObject3 = af.dHX().xM(((dbg)localObject2).FKv);
            if (((((v)localObject3).field_tagName != null) && (!((v)localObject3).field_tagName.equals(((dbg)localObject2).tkJ))) || (((v)localObject3).field_count != ((dbg)localObject2).ncL) || (b((v)localObject3, (dbg)localObject2)))
            {
              a((v)localObject3, (dbg)localObject2);
              af.dHX().a((v)localObject3);
            }
          }
        }
        paramArrayOfByte = af.dHV().auY("@__weixintsnstag");
        paramArrayOfByte.field_md5 = paramq;
        af.dHV().a(paramArrayOfByte);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95653);
        return;
      }
    }
  }
  
  public final List<String> xm(long paramLong)
  {
    AppMethodBeat.i(95652);
    LinkedList localLinkedList = new LinkedList();
    if (this.xSg == null)
    {
      AppMethodBeat.o(95652);
      return localLinkedList;
    }
    Iterator localIterator = this.xSg.iterator();
    while (localIterator.hasNext())
    {
      dbg localdbg = (dbg)localIterator.next();
      if (localdbg.FKv == paramLong)
      {
        localIterator = localdbg.ncM.iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add(((crm)localIterator.next()).FEm);
        }
        AppMethodBeat.o(95652);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(95652);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u
 * JD-Core Version:    0.7.0.1
 */