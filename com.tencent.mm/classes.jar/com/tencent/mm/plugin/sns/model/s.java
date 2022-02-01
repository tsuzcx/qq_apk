package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.g.j;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.eab;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.protocal.protobuf.eap;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends q
  implements com.tencent.mm.network.m
{
  public long DIt;
  public dzo DIu;
  private Object DIv;
  private int DIw;
  public com.tencent.mm.ak.i callback;
  public int ecf;
  private MMHandler handler;
  private com.tencent.mm.ak.d rr;
  public int type;
  
  public s(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, null, null);
  }
  
  public s(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(95602);
    this.type = -1;
    this.DIt = 0L;
    this.ecf = -1;
    this.DIw = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.DIu = null;
    this.type = 9;
    this.DIt = paramLong;
    Log.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + this.type);
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new eah();
    ((d.a)localObject1).iLO = new eai();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    ((d.a)localObject1).funcId = 218;
    ((d.a)localObject1).iLP = 104;
    ((d.a)localObject1).respCmdId = 1000000104;
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (eah)this.rr.iLK.iLR;
    Object localObject2 = aj.faO().JJ(paramLong);
    if (localObject2 != null) {
      this.ecf = ((SnsInfo)localObject2).localid;
    }
    localObject2 = V(paramLong, this.type);
    eag localeag = new eag();
    localeag.Scene = paramInt1;
    localeag.MZz = paramInt2;
    localeag.MZA = z.Su(paramString);
    try
    {
      paramString = localeag.toByteArray();
      ((eae)localObject2).MDa = new SKBuiltinBuffer_t().setBuffer(paramString);
      paramString = new LinkedList();
      paramString.add(localObject2);
      ((eah)localObject1).MZC = paramString;
      ((eah)localObject1).MZB = paramString.size();
      AppMethodBeat.o(95602);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramString, "", new Object[0]);
      }
    }
  }
  
  public s(long paramLong, int paramInt, dzo paramdzo)
  {
    this(paramLong, paramInt, paramdzo, null);
  }
  
  private s(long paramLong, int paramInt, dzo paramdzo, Object paramObject)
  {
    AppMethodBeat.i(95601);
    this.type = -1;
    this.DIt = 0L;
    this.ecf = -1;
    this.DIw = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.DIu = paramdzo;
    this.type = paramInt;
    this.DIt = paramLong;
    this.DIv = paramObject;
    Log.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + paramInt);
    if (paramdzo != null) {
      Log.i("MicroMsg.NetSceneSnsObjectOp", paramdzo.MYT + " " + paramdzo.MYV);
    }
    paramdzo = new d.a();
    paramdzo.iLN = new eah();
    paramdzo.iLO = new eai();
    paramdzo.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    paramdzo.funcId = 218;
    paramdzo.iLP = 104;
    paramdzo.respCmdId = 1000000104;
    this.rr = paramdzo.aXF();
    paramdzo = (eah)this.rr.iLK.iLR;
    Object localObject = aj.faO().JJ(paramLong);
    if (localObject != null) {
      this.ecf = ((SnsInfo)localObject).localid;
    }
    paramObject = a(paramLong, paramInt, this.DIu, paramObject);
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramObject);
    paramdzo.MZC = ((LinkedList)localObject);
    paramdzo.MZB = ((LinkedList)localObject).size();
    if (paramInt == 1) {
      try
      {
        paramObject = new ewf();
        paramObject.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
        paramdzo.KLQ = new SKBuiltinBuffer_t().setBuffer(paramObject.toByteArray());
        AppMethodBeat.o(95601);
        return;
      }
      catch (Throwable paramdzo) {}
    }
    AppMethodBeat.o(95601);
  }
  
  public s(long paramLong, int paramInt, Object paramObject)
  {
    this(paramLong, paramInt, null, paramObject);
  }
  
  private static eae V(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95604);
    eae localeae = new eae();
    localeae.MDa = new SKBuiltinBuffer_t();
    localeae.Id = paramLong;
    localeae.him = paramInt;
    AppMethodBeat.o(95604);
    return localeae;
  }
  
  private static eae a(long paramLong, int paramInt, dzo paramdzo, Object paramObject)
  {
    AppMethodBeat.i(95603);
    eae localeae = V(paramLong, paramInt);
    Object localObject2 = new StringBuilder("getSnsObjectOp ").append(paramInt).append(" ");
    Object localObject1;
    if (paramObject == null)
    {
      localObject1 = "";
      Log.i("MicroMsg.NetSceneSnsObjectOp", (String)localObject1);
      localObject2 = "";
      if ((paramInt != 8) && (paramInt != 10) && (paramInt != 7) && (paramInt != 8) && (paramInt != 6)) {
        break label1044;
      }
      localObject1 = aj.faR().JE(paramLong);
      if (localObject1 == null) {
        break label1038;
      }
      localObject1 = ((AdSnsInfo)localObject1).convertToSnsInfo();
      label113:
      if ((localObject1 == null) || (!((SnsInfo)localObject1).isAd())) {
        break label1035;
      }
      localObject2 = ((SnsInfo)localObject1).getAdInfo();
      if (localObject2 != null) {
        break label203;
      }
      localObject2 = "";
      label142:
      Log.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo ".concat(String.valueOf(localObject2)));
    }
    for (;;)
    {
      if (paramInt == 6)
      {
        if ((paramdzo == null) || ((paramdzo.MYT == 0) && (paramdzo.MYV == 0L)))
        {
          AppMethodBeat.o(95603);
          return localeae;
          localObject1 = paramObject.toString();
          break;
          label203:
          localObject2 = ((ADInfo)localObject2).uxInfo;
          break label142;
        }
        paramObject = new dzh();
        paramObject.MYP = paramdzo.MYV;
        paramObject.MYD = z.Su(Util.nullAs((String)localObject2, ""));
      }
      for (;;)
      {
        try
        {
          paramdzo = paramObject.toByteArray();
          localeae.MDa = new SKBuiltinBuffer_t().setBuffer(paramdzo);
          AppMethodBeat.o(95603);
          return localeae;
        }
        catch (Exception paramdzo)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdzo, "", new Object[0]);
          continue;
        }
        if (paramInt != 7) {
          break;
        }
        paramdzo = new dyz();
        paramdzo.MYD = z.Su(Util.nullAs((String)localObject2, ""));
        try
        {
          paramdzo = paramdzo.toByteArray();
          localeae.MDa = new SKBuiltinBuffer_t().setBuffer(paramdzo);
        }
        catch (Exception paramdzo)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdzo, "", new Object[0]);
        }
      }
      if (paramInt == 8) {
        if ((paramObject != null) && ((paramObject instanceof ADInfo.c.a)))
        {
          paramInt = 1;
          label382:
          if (paramInt == 0) {
            break label1029;
          }
          paramdzo = (ADInfo.c.a)paramObject;
          localObject2 = Util.nullAs((String)localObject2, "");
        }
      }
      label1029:
      for (paramdzo = (String)localObject2 + new StringBuilder("&").append(paramdzo.DDs).append("|").append(paramdzo.DWe).toString();; paramdzo = (dzo)localObject2)
      {
        for (;;)
        {
          for (;;)
          {
            localObject2 = new dzc();
            ((dzc)localObject2).MYD = z.Su(Util.nullAs(paramdzo, ""));
            if (localObject1 != null)
            {
              ((dzc)localObject2).xub = ((SnsInfo)localObject1).getAdRecSrc();
              paramdzo = ((SnsInfo)localObject1).getSnsId();
              localObject1 = aj.faO().aQl(paramdzo);
              if (localObject1 != null)
              {
                paramdzo = j.b(((SnsInfo)localObject1).getTimeLine());
                label520:
                ((dzc)localObject2).MYF = z.Su(Util.nullAs(paramdzo, ""));
              }
            }
            else
            {
              if ((paramInt == 0) || (((ADInfo.c.a)paramObject).DWd != ADInfo.c.a.DVZ)) {
                break label629;
              }
              ((dzc)localObject2).MYG = ADInfo.c.a.DVZ;
            }
            for (;;)
            {
              try
              {
                paramdzo = ((dzc)localObject2).toByteArray();
                localeae.MDa = new SKBuiltinBuffer_t().setBuffer(paramdzo);
              }
              catch (Exception paramdzo)
              {
                Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdzo, "", new Object[0]);
              }
              break;
              paramInt = 0;
              break label382;
              Log.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { paramdzo });
              paramdzo = "";
              break label520;
              label629:
              aj.faR().delete(paramLong);
              aj.faT().JI(paramLong);
              com.tencent.mm.plugin.sns.storage.g.JH(paramLong);
              if (paramInt != 0) {
                ((dzc)localObject2).MYG = ((ADInfo.c.a)paramObject).DWd;
              }
            }
            if (paramInt != 4) {
              break label762;
            }
            if ((paramdzo == null) || ((paramdzo.MYT == 0) && (paramdzo.MYV == 0L)))
            {
              AppMethodBeat.o(95603);
              return localeae;
            }
            paramObject = new eaf();
            paramObject.MYT = paramdzo.MYT;
            try
            {
              paramdzo = paramObject.toByteArray();
              localeae.MDa = new SKBuiltinBuffer_t().setBuffer(paramdzo);
            }
            catch (Exception paramdzo)
            {
              Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdzo, "", new Object[0]);
            }
          }
          break;
          label762:
          if (paramInt == 10)
          {
            paramdzo = new eap();
            if ((paramObject instanceof com.tencent.mm.bw.b))
            {
              paramObject = (com.tencent.mm.bw.b)paramObject;
              paramdzo.Nac = z.aC(paramObject.zy);
              Log.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + paramObject.zy.length);
            }
            for (;;)
            {
              try
              {
                paramdzo = paramdzo.toByteArray();
                localeae.MDa = new SKBuiltinBuffer_t().setBuffer(paramdzo);
                Log.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + paramdzo.length);
              }
              catch (Exception paramdzo)
              {
                Log.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + paramdzo.getMessage());
                Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdzo, "", new Object[0]);
              }
              break;
              Log.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
          }
          if (paramInt != 12) {
            break;
          }
          if (!(paramObject instanceof eab)) {
            break label1018;
          }
          paramdzo = (eab)paramObject;
          try
          {
            localeae.MDa = z.aC(paramdzo.toByteArray());
            Log.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + paramdzo.MZw);
          }
          catch (Exception paramdzo)
          {
            Log.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + paramdzo.getMessage());
          }
        }
        break;
        label1018:
        Log.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
        break;
      }
      label1035:
      continue;
      label1038:
      localObject1 = null;
      break label113;
      label1044:
      localObject1 = null;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(95605);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95605);
    return i;
  }
  
  public final int getType()
  {
    return 218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95606);
    Log.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (this.type == 1)) {
        switch (this.type)
        {
        }
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95606);
        return;
        aj.faN().Js(this.DIt);
        continue;
        aj.faN().Ju(this.DIt);
      }
    }
    switch (this.type)
    {
    case 10: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 4: 
      do
      {
        for (;;)
        {
          aj.faN().fan();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95606);
          return;
          aj.faN().Js(this.DIt);
          aj.faO().delete(this.DIt);
          params = (eai)((com.tencent.mm.ak.d)params).iLL.iLR;
          if (params.MZE == 1)
          {
            aj.faS().D(aj.fau(), params.MZG);
            continue;
            params = aj.faO().JJ(this.DIt);
            if (params != null)
            {
              params.setPravited(1);
              params.setLocalPrivate();
              aj.faO().b(this.DIt, params);
              continue;
              params = aj.faO().JJ(this.DIt);
              if (params != null)
              {
                params.setPravited(0);
                params.unLocalPrivate();
                params.setExtFlag();
                aj.faO().b(this.DIt, params);
                continue;
                aj.faN().Ju(this.DIt);
              }
            }
          }
        }
        paramArrayOfByte = aj.faO().JJ(this.DIt);
      } while (paramArrayOfByte == null);
    }
    for (;;)
    {
      SnsObject localSnsObject;
      Iterator localIterator;
      try
      {
        localSnsObject = (SnsObject)new SnsObject().parseFrom(paramArrayOfByte.field_attrBuf);
        localIterator = localSnsObject.CommentUserList.iterator();
        if (!localIterator.hasNext()) {
          break label1367;
        }
        params = (dzo)localIterator.next();
        if ((this.DIu == null) || (params.MYT != this.DIu.MYT)) {
          continue;
        }
        if (params != null) {
          localSnsObject.CommentUserList.remove(params);
        }
        paramArrayOfByte.setAttrBuf(localSnsObject.toByteArray());
        aj.faO().S(paramArrayOfByte);
        aj.faT().j(paramArrayOfByte.field_snsId, this.DIu.MYT, this.DIu.oUv);
      }
      catch (Exception params)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", params, "", new Object[0]);
      }
      break;
      paramArrayOfByte = aj.faR().JE(this.DIt);
      if (paramArrayOfByte == null) {
        break;
      }
      for (;;)
      {
        try
        {
          localSnsObject = (SnsObject)new SnsObject().parseFrom(paramArrayOfByte.field_attrBuf);
          localIterator = localSnsObject.CommentUserList.iterator();
          if (!localIterator.hasNext()) {
            break label1361;
          }
          params = (dzo)localIterator.next();
          if ((this.DIu == null) || (params.MYV != this.DIu.MYV)) {
            continue;
          }
          if (params != null) {
            localSnsObject.CommentUserList.remove(params);
          }
          paramArrayOfByte.setAttrBuf(localSnsObject.toByteArray());
          aj.faR().replace(paramArrayOfByte);
          aj.faT().j(paramArrayOfByte.field_snsId, this.DIu.MYV, this.DIu.oUv);
        }
        catch (Exception params)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", params, "", new Object[0]);
        }
        break;
        aj.faN().Ju(this.DIt);
        break;
        if ((this.DIv != null) && ((this.DIv instanceof ADInfo.c.a)) && (((ADInfo.c.a)this.DIv).DWd == ADInfo.c.a.DVZ)) {
          break;
        }
        aj.faR().delete(this.DIt);
        aj.faT().JI(this.DIt);
        com.tencent.mm.plugin.sns.storage.g.JH(this.DIt);
        params = new bs();
        EventCenter.instance.publish(params);
        break;
        params = aj.faO().JJ(this.DIt);
        if (params == null) {
          break;
        }
        params.removeSourceFlag(2);
        aj.faO().b(this.DIt, params);
        break;
        Log.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.DIw);
        label968:
        int i;
        int j;
        if (this.DIw == 0)
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWK, Boolean.TRUE);
          com.tencent.mm.kernel.g.aAi();
          paramInt1 = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NWM, Integer.valueOf(0))).intValue();
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWM, Integer.valueOf(paramInt1 + 1));
          com.tencent.mm.kernel.g.aAi();
          i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NWN, Integer.valueOf(0))).intValue();
          if (this.DIw != 0) {
            break label1182;
          }
          i += 1;
          j = i * 2 + 198;
          paramInt1 = j;
          if (j >= 216) {
            paramInt1 = 216;
          }
          if (paramInt1 >= 200) {
            com.tencent.mm.plugin.sns.lucky.a.b.pl(paramInt1);
          }
          Log.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + paramInt1 + " " + i);
          paramInt1 = i;
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWN, Integer.valueOf(paramInt1));
          break;
          if (this.DIw != 1) {
            break label968;
          }
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.NWK, Boolean.FALSE);
          break label968;
          label1182:
          paramInt1 = i;
          if (this.DIw == 1)
          {
            i += 1;
            j = i * 2 + 198 + 1;
            paramInt1 = j;
            if (j >= 217) {
              paramInt1 = 217;
            }
            if (paramInt1 >= 201) {
              com.tencent.mm.plugin.sns.lucky.a.b.pl(paramInt1);
            }
            Log.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + paramInt1 + " " + i);
            paramInt1 = i;
          }
        }
        if ((this.DIv == null) || (!(this.DIv instanceof eab))) {
          break;
        }
        if (((eab)this.DIv).MZw == 1) {}
        for (boolean bool = true;; bool = false)
        {
          aj.faT().L(this.DIt, bool);
          Log.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[] { Long.valueOf(this.DIt), Boolean.valueOf(bool) });
          break;
        }
        label1361:
        params = null;
      }
      label1367:
      params = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s
 * JD-Core Version:    0.7.0.1
 */