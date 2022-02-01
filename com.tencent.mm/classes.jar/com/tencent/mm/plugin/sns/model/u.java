package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends com.tencent.mm.al.n
  implements k
{
  public g callback;
  private int diR;
  private String md5;
  private b rr;
  public LinkedList<cvu> wFM;
  public int wFN;
  
  public u(int paramInt)
  {
    AppMethodBeat.i(95648);
    this.wFM = null;
    this.diR = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new cvv();
    ((b.a)localObject).gUV = new cvw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
    ((b.a)localObject).funcId = 292;
    ((b.a)localObject).reqCmdId = 116;
    ((b.a)localObject).respCmdId = 1000000116;
    this.rr = ((b.a)localObject).atI();
    localObject = af.dty().apP("@__weixintsnstag").field_md5;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      this.md5 = ((String)localObject);
      cvv localcvv = (cvv)this.rr.gUS.gUX;
      localcvv.OpCode = paramInt;
      localcvv.Enx = ((String)localObject);
      AppMethodBeat.o(95648);
      return;
    }
  }
  
  public static v a(v paramv, cvu paramcvu)
  {
    AppMethodBeat.i(95650);
    paramv.field_tagId = paramcvu.Enw;
    paramv.field_tagName = bt.by(paramcvu.scP, "");
    paramv.field_count = paramcvu.mAK;
    paramv.fz(paramcvu.mAL);
    ad.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + paramcvu.toString());
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
  
  private static boolean b(v paramv, cvu paramcvu)
  {
    boolean bool2 = false;
    AppMethodBeat.i(95654);
    paramv = paramv.field_memberList.split(",");
    paramcvu = paramcvu.mAL.iterator();
    label83:
    label90:
    label93:
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramcvu.hasNext())
      {
        cmf localcmf = (cmf)paramcvu.next();
        i = 0;
        if (i >= paramv.length) {
          break label90;
        }
        if (!paramv[i].equals(localcmf)) {
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
    ad.d("MicroMsg.NetSceneSnsTagList", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    Object localObject1 = (cvw)((b)paramq).gUT.gUX;
    ad.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[] { Integer.valueOf(this.wFN) });
    this.wFN = ((cvw)localObject1).wFN;
    this.wFM = ((cvw)localObject1).mAL;
    paramq = ((cvw)localObject1).Enx;
    if (this.md5.equals(paramq))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    paramArrayOfByte = af.dtA().dyC();
    Object localObject2;
    if (this.diR != 3) {
      localObject2 = paramArrayOfByte.iterator();
    }
    label504:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        Iterator localIterator = ((cvw)localObject1).mAL.iterator();
        cvu localcvu;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localcvu = (cvu)localIterator.next();
        } while (((Long)localObject3).longValue() != localcvu.Enw);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label504;
        }
        ((Iterator)localObject2).remove();
        af.dtA().tk(((Long)localObject3).longValue());
        break;
        localObject1 = ((cvw)localObject1).mAL.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cvu)((Iterator)localObject1).next();
          if (!a(paramArrayOfByte, Long.valueOf(((cvu)localObject2).Enw)))
          {
            localObject3 = new v();
            a((v)localObject3, (cvu)localObject2);
            af.dtA().a((v)localObject3);
          }
          else
          {
            localObject3 = af.dtA().tj(((cvu)localObject2).Enw);
            if (((((v)localObject3).field_tagName != null) && (!((v)localObject3).field_tagName.equals(((cvu)localObject2).scP))) || (((v)localObject3).field_count != ((cvu)localObject2).mAK) || (b((v)localObject3, (cvu)localObject2)))
            {
              a((v)localObject3, (cvu)localObject2);
              af.dtA().a((v)localObject3);
            }
          }
        }
        paramArrayOfByte = af.dty().apP("@__weixintsnstag");
        paramArrayOfByte.field_md5 = paramq;
        af.dty().a(paramArrayOfByte);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95653);
        return;
      }
    }
  }
  
  public final List<String> sJ(long paramLong)
  {
    AppMethodBeat.i(95652);
    LinkedList localLinkedList = new LinkedList();
    if (this.wFM == null)
    {
      AppMethodBeat.o(95652);
      return localLinkedList;
    }
    Iterator localIterator = this.wFM.iterator();
    while (localIterator.hasNext())
    {
      cvu localcvu = (cvu)localIterator.next();
      if (localcvu.Enw == paramLong)
      {
        localIterator = localcvu.mAL.iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add(((cmf)localIterator.next()).Ehn);
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