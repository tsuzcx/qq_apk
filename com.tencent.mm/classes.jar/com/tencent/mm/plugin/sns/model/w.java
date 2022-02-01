package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ekw;
import com.tencent.mm.protocal.protobuf.ekx;
import com.tencent.mm.protocal.protobuf.eky;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends q
  implements com.tencent.mm.network.m
{
  public LinkedList<ekw> JVZ;
  public int JWa;
  public i callback;
  private int fCN;
  private String md5;
  private d rr;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(95648);
    this.JVZ = null;
    this.fCN = paramInt;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ekx();
    ((d.a)localObject).lBV = new eky();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
    ((d.a)localObject).funcId = 292;
    ((d.a)localObject).lBW = 116;
    ((d.a)localObject).respCmdId = 1000000116;
    this.rr = ((d.a)localObject).bgN();
    localObject = aj.fOM().bbr("@__weixintsnstag").field_md5;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      this.md5 = ((String)localObject);
      ekx localekx = (ekx)d.b.b(this.rr.lBR);
      localekx.RLe = paramInt;
      localekx.UmM = ((String)localObject);
      AppMethodBeat.o(95648);
      return;
    }
  }
  
  public static com.tencent.mm.plugin.sns.storage.s a(com.tencent.mm.plugin.sns.storage.s params, ekw paramekw)
  {
    AppMethodBeat.i(95650);
    params.field_tagId = paramekw.UmL;
    params.field_tagName = Util.nullAs(paramekw.CQx, "");
    params.field_count = paramekw.rVx;
    params.hF(paramekw.rVy);
    Log.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + paramekw.toString());
    AppMethodBeat.o(95650);
    return params;
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
  
  private static boolean b(com.tencent.mm.plugin.sns.storage.s params, ekw paramekw)
  {
    boolean bool2 = false;
    AppMethodBeat.i(95654);
    params = params.field_memberList.split(",");
    paramekw = paramekw.rVy.iterator();
    label83:
    label90:
    label93:
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramekw.hasNext())
      {
        eaf localeaf = (eaf)paramekw.next();
        i = 0;
        if (i >= params.length) {
          break label90;
        }
        if (!params[i].equals(localeaf)) {
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
  
  public final List<String> QI(long paramLong)
  {
    AppMethodBeat.i(95652);
    LinkedList localLinkedList = new LinkedList();
    if (this.JVZ == null)
    {
      AppMethodBeat.o(95652);
      return localLinkedList;
    }
    Iterator localIterator = this.JVZ.iterator();
    while (localIterator.hasNext())
    {
      ekw localekw = (ekw)localIterator.next();
      if (localekw.UmL == paramLong)
      {
        localIterator = localekw.rVy.iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add(((eaf)localIterator.next()).Ufy);
        }
        AppMethodBeat.o(95652);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(95652);
    return localLinkedList;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(95649);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95649);
    return i;
  }
  
  public final int getType()
  {
    return 292;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95653);
    Log.d("MicroMsg.NetSceneSnsTagList", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    Object localObject1 = (eky)d.c.b(((d)params).lBS);
    Log.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[] { Integer.valueOf(this.JWa) });
    this.JWa = ((eky)localObject1).JWa;
    this.JVZ = ((eky)localObject1).rVy;
    params = ((eky)localObject1).UmM;
    if (this.md5.equals(params))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    paramArrayOfByte = aj.fOO().fTb();
    Object localObject2;
    if (this.fCN != 3) {
      localObject2 = paramArrayOfByte.iterator();
    }
    label507:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        Iterator localIterator = ((eky)localObject1).rVy.iterator();
        ekw localekw;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localekw = (ekw)localIterator.next();
        } while (((Long)localObject3).longValue() != localekw.UmL);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label507;
        }
        ((Iterator)localObject2).remove();
        aj.fOO().Rg(((Long)localObject3).longValue());
        break;
        localObject1 = ((eky)localObject1).rVy.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ekw)((Iterator)localObject1).next();
          if (!a(paramArrayOfByte, Long.valueOf(((ekw)localObject2).UmL)))
          {
            localObject3 = new com.tencent.mm.plugin.sns.storage.s();
            a((com.tencent.mm.plugin.sns.storage.s)localObject3, (ekw)localObject2);
            aj.fOO().a((com.tencent.mm.plugin.sns.storage.s)localObject3);
          }
          else
          {
            localObject3 = aj.fOO().Rf(((ekw)localObject2).UmL);
            if (((((com.tencent.mm.plugin.sns.storage.s)localObject3).field_tagName != null) && (!((com.tencent.mm.plugin.sns.storage.s)localObject3).field_tagName.equals(((ekw)localObject2).CQx))) || (((com.tencent.mm.plugin.sns.storage.s)localObject3).field_count != ((ekw)localObject2).rVx) || (b((com.tencent.mm.plugin.sns.storage.s)localObject3, (ekw)localObject2)))
            {
              a((com.tencent.mm.plugin.sns.storage.s)localObject3, (ekw)localObject2);
              aj.fOO().a((com.tencent.mm.plugin.sns.storage.s)localObject3);
            }
          }
        }
        paramArrayOfByte = aj.fOM().bbr("@__weixintsnstag");
        paramArrayOfByte.field_md5 = params;
        aj.fOM().a(paramArrayOfByte);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95653);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.w
 * JD-Core Version:    0.7.0.1
 */