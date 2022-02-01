package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.storage.ac;
import com.tencent.mm.plugin.sns.storage.ad;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ffe;
import com.tencent.mm.protocal.protobuf.fff;
import com.tencent.mm.protocal.protobuf.ffg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends p
  implements m
{
  public LinkedList<ffe> Qta;
  public int Qtb;
  public h callback;
  private int hHC;
  private String md5;
  private c rr;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(95648);
    this.Qta = null;
    this.hHC = paramInt;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fff();
    ((c.a)localObject).otF = new ffg();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
    ((c.a)localObject).funcId = 292;
    ((c.a)localObject).otG = 116;
    ((c.a)localObject).respCmdId = 1000000116;
    this.rr = ((c.a)localObject).bEF();
    localObject = al.hgF().aZW("@__weixintsnstag").field_md5;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      this.md5 = ((String)localObject);
      fff localfff = (fff)c.b.b(this.rr.otB);
      localfff.YIq = paramInt;
      localfff.abET = ((String)localObject);
      AppMethodBeat.o(95648);
      return;
    }
  }
  
  public static ac a(ac paramac, ffe paramffe)
  {
    AppMethodBeat.i(95650);
    paramac.field_tagId = paramffe.abES;
    paramac.field_tagName = Util.nullAs(paramffe.IKH, "");
    paramac.field_count = paramffe.vgN;
    paramac.kG(paramffe.vgO);
    Log.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + paramffe.toString());
    AppMethodBeat.o(95650);
    return paramac;
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
  
  private static boolean b(ac paramac, ffe paramffe)
  {
    boolean bool2 = false;
    AppMethodBeat.i(95654);
    paramac = paramac.field_memberList.split(",");
    paramffe = paramffe.vgO.iterator();
    label83:
    label90:
    label93:
    for (;;)
    {
      boolean bool1 = bool2;
      if (paramffe.hasNext())
      {
        etl localetl = (etl)paramffe.next();
        i = 0;
        if (i >= paramac.length) {
          break label90;
        }
        if (!paramac[i].equals(localetl)) {
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
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(95649);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95649);
    return i;
  }
  
  public final int getType()
  {
    return 292;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95653);
    Log.d("MicroMsg.NetSceneSnsTagList", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    Object localObject1 = (ffg)c.c.b(((c)params).otC);
    Log.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[] { Integer.valueOf(this.Qtb) });
    this.Qtb = ((ffg)localObject1).Qtb;
    this.Qta = ((ffg)localObject1).vgO;
    params = ((ffg)localObject1).abET;
    if (this.md5.equals(params))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    paramArrayOfByte = al.hgI().hlo();
    Object localObject2;
    if (this.hHC != 3) {
      localObject2 = paramArrayOfByte.iterator();
    }
    label504:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        Iterator localIterator = ((ffg)localObject1).vgO.iterator();
        ffe localffe;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localffe = (ffe)localIterator.next();
        } while (((Long)localObject3).longValue() != localffe.abES);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label504;
        }
        ((Iterator)localObject2).remove();
        al.hgI().vm(((Long)localObject3).longValue());
        break;
        localObject1 = ((ffg)localObject1).vgO.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ffe)((Iterator)localObject1).next();
          if (!a(paramArrayOfByte, Long.valueOf(((ffe)localObject2).abES)))
          {
            localObject3 = new ac();
            a((ac)localObject3, (ffe)localObject2);
            al.hgI().a((ac)localObject3);
          }
          else
          {
            localObject3 = al.hgI().vl(((ffe)localObject2).abES);
            if (((((ac)localObject3).field_tagName != null) && (!((ac)localObject3).field_tagName.equals(((ffe)localObject2).IKH))) || (((ac)localObject3).field_count != ((ffe)localObject2).vgN) || (b((ac)localObject3, (ffe)localObject2)))
            {
              a((ac)localObject3, (ffe)localObject2);
              al.hgI().a((ac)localObject3);
            }
          }
        }
        paramArrayOfByte = al.hgF().aZW("@__weixintsnstag");
        paramArrayOfByte.field_md5 = params;
        al.hgF().a(paramArrayOfByte);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95653);
        return;
      }
    }
  }
  
  public final List<String> uO(long paramLong)
  {
    AppMethodBeat.i(95652);
    LinkedList localLinkedList = new LinkedList();
    if (this.Qta == null)
    {
      AppMethodBeat.o(95652);
      return localLinkedList;
    }
    Iterator localIterator = this.Qta.iterator();
    while (localIterator.hasNext())
    {
      ffe localffe = (ffe)localIterator.next();
      if (localffe.abES == paramLong)
      {
        localIterator = localffe.vgO.iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add(((etl)localIterator.next()).abwM);
        }
        AppMethodBeat.o(95652);
        return localLinkedList;
      }
    }
    AppMethodBeat.o(95652);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.w
 * JD-Core Version:    0.7.0.1
 */