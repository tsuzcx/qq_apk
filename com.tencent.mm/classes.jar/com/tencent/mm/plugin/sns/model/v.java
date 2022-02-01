package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.protocal.protobuf.dho;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v
  extends com.tencent.mm.ak.n
  implements k
{
  public f callback;
  private int dsO;
  private String md5;
  private b rr;
  public LinkedList<dhn> zyP;
  public int zyQ;
  
  public v(int paramInt)
  {
    AppMethodBeat.i(95648);
    this.zyP = null;
    this.dsO = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dho();
    ((b.a)localObject).hQG = new dhp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
    ((b.a)localObject).funcId = 292;
    ((b.a)localObject).hQH = 116;
    ((b.a)localObject).respCmdId = 1000000116;
    this.rr = ((b.a)localObject).aDS();
    localObject = ah.dXI().aBw("@__weixintsnstag").field_md5;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      this.md5 = ((String)localObject);
      dho localdho = (dho)this.rr.hQD.hQJ;
      localdho.OpCode = paramInt;
      localdho.HOH = ((String)localObject);
      AppMethodBeat.o(95648);
      return;
    }
  }
  
  public static com.tencent.mm.plugin.sns.storage.v a(com.tencent.mm.plugin.sns.storage.v paramv, dhn paramdhn)
  {
    AppMethodBeat.i(95650);
    paramv.field_tagId = paramdhn.HOG;
    paramv.field_tagName = bu.bI(paramdhn.uum, "");
    paramv.field_count = paramdhn.nID;
    paramv.gb(paramdhn.nIE);
    ae.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + paramdhn.toString());
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
  
  private static boolean b(com.tencent.mm.plugin.sns.storage.v paramv, dhn paramdhn)
  {
    boolean bool2 = false;
    AppMethodBeat.i(95654);
    paramv = paramv.field_memberList.split(",");
    paramdhn = paramdhn.nIE.iterator();
    label83:
    label90:
    label93:
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramdhn.hasNext())
      {
        cxn localcxn = (cxn)paramdhn.next();
        i = 0;
        if (i >= paramv.length) {
          break label90;
        }
        if (!paramv[i].equals(localcxn)) {
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
  
  public final List<String> Aj(long paramLong)
  {
    AppMethodBeat.i(95652);
    LinkedList localLinkedList = new LinkedList();
    if (this.zyP == null)
    {
      AppMethodBeat.o(95652);
      return localLinkedList;
    }
    Iterator localIterator = this.zyP.iterator();
    while (localIterator.hasNext())
    {
      dhn localdhn = (dhn)localIterator.next();
      if (localdhn.HOG == paramLong)
      {
        localIterator = localdhn.nIE.iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add(((cxn)localIterator.next()).HId);
        }
        AppMethodBeat.o(95652);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(95652);
    return localLinkedList;
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
    ae.d("MicroMsg.NetSceneSnsTagList", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    Object localObject1 = (dhp)((b)paramq).hQE.hQJ;
    ae.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[] { Integer.valueOf(this.zyQ) });
    this.zyQ = ((dhp)localObject1).zyQ;
    this.zyP = ((dhp)localObject1).nIE;
    paramq = ((dhp)localObject1).HOH;
    if (this.md5.equals(paramq))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    paramArrayOfByte = ah.dXK().ecT();
    Object localObject2;
    if (this.dsO != 3) {
      localObject2 = paramArrayOfByte.iterator();
    }
    label507:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        Iterator localIterator = ((dhp)localObject1).nIE.iterator();
        dhn localdhn;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localdhn = (dhn)localIterator.next();
        } while (((Long)localObject3).longValue() != localdhn.HOG);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label507;
        }
        ((Iterator)localObject2).remove();
        ah.dXK().AJ(((Long)localObject3).longValue());
        break;
        localObject1 = ((dhp)localObject1).nIE.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dhn)((Iterator)localObject1).next();
          if (!a(paramArrayOfByte, Long.valueOf(((dhn)localObject2).HOG)))
          {
            localObject3 = new com.tencent.mm.plugin.sns.storage.v();
            a((com.tencent.mm.plugin.sns.storage.v)localObject3, (dhn)localObject2);
            ah.dXK().a((com.tencent.mm.plugin.sns.storage.v)localObject3);
          }
          else
          {
            localObject3 = ah.dXK().AI(((dhn)localObject2).HOG);
            if (((((com.tencent.mm.plugin.sns.storage.v)localObject3).field_tagName != null) && (!((com.tencent.mm.plugin.sns.storage.v)localObject3).field_tagName.equals(((dhn)localObject2).uum))) || (((com.tencent.mm.plugin.sns.storage.v)localObject3).field_count != ((dhn)localObject2).nID) || (b((com.tencent.mm.plugin.sns.storage.v)localObject3, (dhn)localObject2)))
            {
              a((com.tencent.mm.plugin.sns.storage.v)localObject3, (dhn)localObject2);
              ah.dXK().a((com.tencent.mm.plugin.sns.storage.v)localObject3);
            }
          }
        }
        paramArrayOfByte = ah.dXI().aBw("@__weixintsnstag");
        paramArrayOfByte.field_md5 = paramq;
        ah.dXI().a(paramArrayOfByte);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95653);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.v
 * JD-Core Version:    0.7.0.1
 */