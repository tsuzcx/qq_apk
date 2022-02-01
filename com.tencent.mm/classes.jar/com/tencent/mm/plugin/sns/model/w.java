package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.eay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends q
  implements com.tencent.mm.network.m
{
  public LinkedList<eaw> DIZ;
  public int DJa;
  public i callback;
  private int dJY;
  private String md5;
  private d rr;
  
  public w(int paramInt)
  {
    AppMethodBeat.i(95648);
    this.DIZ = null;
    this.dJY = paramInt;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new eax();
    ((d.a)localObject).iLO = new eay();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
    ((d.a)localObject).funcId = 292;
    ((d.a)localObject).iLP = 116;
    ((d.a)localObject).respCmdId = 1000000116;
    this.rr = ((d.a)localObject).aXF();
    localObject = aj.faS().aQr("@__weixintsnstag").field_md5;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      this.md5 = ((String)localObject);
      eax localeax = (eax)this.rr.iLK.iLR;
      localeax.OpCode = paramInt;
      localeax.Nas = ((String)localObject);
      AppMethodBeat.o(95648);
      return;
    }
  }
  
  public static com.tencent.mm.plugin.sns.storage.s a(com.tencent.mm.plugin.sns.storage.s params, eaw parameaw)
  {
    AppMethodBeat.i(95650);
    params.field_tagId = parameaw.Nar;
    params.field_tagName = Util.nullAs(parameaw.xMo, "");
    params.field_count = parameaw.oTz;
    params.gX(parameaw.oTA);
    Log.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + parameaw.toString());
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
  
  private static boolean b(com.tencent.mm.plugin.sns.storage.s params, eaw parameaw)
  {
    boolean bool2 = false;
    AppMethodBeat.i(95654);
    params = params.field_memberList.split(",");
    parameaw = parameaw.oTA.iterator();
    label83:
    label90:
    label93:
    for (;;)
    {
      boolean bool1 = bool2;
      if (parameaw.hasNext())
      {
        dqi localdqi = (dqi)parameaw.next();
        i = 0;
        if (i >= params.length) {
          break label90;
        }
        if (!params[i].equals(localdqi)) {
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
  
  public final List<String> Jp(long paramLong)
  {
    AppMethodBeat.i(95652);
    LinkedList localLinkedList = new LinkedList();
    if (this.DIZ == null)
    {
      AppMethodBeat.o(95652);
      return localLinkedList;
    }
    Iterator localIterator = this.DIZ.iterator();
    while (localIterator.hasNext())
    {
      eaw localeaw = (eaw)localIterator.next();
      if (localeaw.Nar == paramLong)
      {
        localIterator = localeaw.oTA.iterator();
        while (localIterator.hasNext()) {
          localLinkedList.add(((dqi)localIterator.next()).MTo);
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
    Object localObject1 = (eay)((d)params).iLL.iLR;
    Log.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", new Object[] { Integer.valueOf(this.DJa) });
    this.DJa = ((eay)localObject1).DJa;
    this.DIZ = ((eay)localObject1).oTA;
    params = ((eay)localObject1).Nas;
    if (this.md5.equals(params))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95653);
      return;
    }
    paramArrayOfByte = aj.faU().ffg();
    Object localObject2;
    if (this.dJY != 3) {
      localObject2 = paramArrayOfByte.iterator();
    }
    label507:
    for (;;)
    {
      Object localObject3;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        Iterator localIterator = ((eay)localObject1).oTA.iterator();
        eaw localeaw;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localeaw = (eaw)localIterator.next();
        } while (((Long)localObject3).longValue() != localeaw.Nar);
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label507;
        }
        ((Iterator)localObject2).remove();
        aj.faU().JM(((Long)localObject3).longValue());
        break;
        localObject1 = ((eay)localObject1).oTA.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (eaw)((Iterator)localObject1).next();
          if (!a(paramArrayOfByte, Long.valueOf(((eaw)localObject2).Nar)))
          {
            localObject3 = new com.tencent.mm.plugin.sns.storage.s();
            a((com.tencent.mm.plugin.sns.storage.s)localObject3, (eaw)localObject2);
            aj.faU().a((com.tencent.mm.plugin.sns.storage.s)localObject3);
          }
          else
          {
            localObject3 = aj.faU().JL(((eaw)localObject2).Nar);
            if (((((com.tencent.mm.plugin.sns.storage.s)localObject3).field_tagName != null) && (!((com.tencent.mm.plugin.sns.storage.s)localObject3).field_tagName.equals(((eaw)localObject2).xMo))) || (((com.tencent.mm.plugin.sns.storage.s)localObject3).field_count != ((eaw)localObject2).oTz) || (b((com.tencent.mm.plugin.sns.storage.s)localObject3, (eaw)localObject2)))
            {
              a((com.tencent.mm.plugin.sns.storage.s)localObject3, (eaw)localObject2);
              aj.faU().a((com.tencent.mm.plugin.sns.storage.s)localObject3);
            }
          }
        }
        paramArrayOfByte = aj.faS().aQr("@__weixintsnstag");
        paramArrayOfByte.field_md5 = params;
        aj.faS().a(paramArrayOfByte);
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95653);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.w
 * JD-Core Version:    0.7.0.1
 */