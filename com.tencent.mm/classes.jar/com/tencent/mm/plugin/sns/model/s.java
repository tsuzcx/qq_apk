package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.bx;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.f.k;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eiz;
import com.tencent.mm.protocal.protobuf.ejc;
import com.tencent.mm.protocal.protobuf.ejh;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.ekb;
import com.tencent.mm.protocal.protobuf.eke;
import com.tencent.mm.protocal.protobuf.ekf;
import com.tencent.mm.protocal.protobuf.ekg;
import com.tencent.mm.protocal.protobuf.ekh;
import com.tencent.mm.protocal.protobuf.eki;
import com.tencent.mm.protocal.protobuf.ekp;
import com.tencent.mm.protocal.protobuf.fgr;
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
  public long JVt;
  public ejo JVu;
  private Object JVv;
  private int JVw;
  public com.tencent.mm.an.i callback;
  public int fWh;
  private MMHandler handler;
  private com.tencent.mm.an.d rr;
  public int type;
  
  public s(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, null, null);
  }
  
  public s(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(95602);
    this.type = -1;
    this.JVt = 0L;
    this.fWh = -1;
    this.JVw = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.JVu = null;
    this.type = 9;
    this.JVt = paramLong;
    Log.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + this.type);
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new ekh();
    ((d.a)localObject1).lBV = new eki();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    ((d.a)localObject1).funcId = 218;
    ((d.a)localObject1).lBW = 104;
    ((d.a)localObject1).respCmdId = 1000000104;
    this.rr = ((d.a)localObject1).bgN();
    localObject1 = (ekh)d.b.b(this.rr.lBR);
    Object localObject2 = aj.fOI().Rd(paramLong);
    if (localObject2 != null) {
      this.fWh = ((SnsInfo)localObject2).localid;
    }
    localObject2 = ae(paramLong, this.type);
    ekg localekg = new ekg();
    localekg.CPw = paramInt1;
    localekg.UlT = paramInt2;
    localekg.UlU = z.ZW(paramString);
    try
    {
      paramString = localekg.toByteArray();
      ((eke)localObject2).TOI = new eae().dc(paramString);
      paramString = new LinkedList();
      paramString.add(localObject2);
      ((ekh)localObject1).UlW = paramString;
      ((ekh)localObject1).UlV = paramString.size();
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
  
  public s(long paramLong, int paramInt, ejo paramejo)
  {
    this(paramLong, paramInt, paramejo, null);
  }
  
  private s(long paramLong, int paramInt, ejo paramejo, Object paramObject)
  {
    AppMethodBeat.i(95601);
    this.type = -1;
    this.JVt = 0L;
    this.fWh = -1;
    this.JVw = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.JVu = paramejo;
    this.type = paramInt;
    this.JVt = paramLong;
    this.JVv = paramObject;
    Log.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + paramInt);
    if (paramejo != null) {
      Log.i("MicroMsg.NetSceneSnsObjectOp", paramejo.Uln + " " + paramejo.Ulp);
    }
    paramejo = new d.a();
    paramejo.lBU = new ekh();
    paramejo.lBV = new eki();
    paramejo.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    paramejo.funcId = 218;
    paramejo.lBW = 104;
    paramejo.respCmdId = 1000000104;
    this.rr = paramejo.bgN();
    paramejo = (ekh)d.b.b(this.rr.lBR);
    Object localObject = aj.fOI().Rd(paramLong);
    if (localObject != null) {
      this.fWh = ((SnsInfo)localObject).localid;
    }
    paramObject = a(paramLong, paramInt, this.JVu, paramObject);
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramObject);
    paramejo.UlW = ((LinkedList)localObject);
    paramejo.UlV = ((LinkedList)localObject).size();
    if (paramInt == 1) {
      try
      {
        paramObject = new fgr();
        paramObject.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
        paramejo.RMN = new eae().dc(paramObject.toByteArray());
        AppMethodBeat.o(95601);
        return;
      }
      catch (Throwable paramejo) {}
    }
    AppMethodBeat.o(95601);
  }
  
  public s(long paramLong, int paramInt, Object paramObject)
  {
    this(paramLong, paramInt, null, paramObject);
  }
  
  private static eke a(long paramLong, int paramInt, ejo paramejo, Object paramObject)
  {
    AppMethodBeat.i(95603);
    eke localeke = ae(paramLong, paramInt);
    Object localObject2 = new StringBuilder("getSnsObjectOp ").append(paramInt).append(" ");
    Object localObject1;
    if (paramObject == null)
    {
      localObject1 = "";
      Log.i("MicroMsg.NetSceneSnsObjectOp", (String)localObject1);
      localObject2 = "";
      if ((paramInt != 8) && (paramInt != 10) && (paramInt != 7) && (paramInt != 8) && (paramInt != 6)) {
        break label1176;
      }
      localObject1 = aj.fOL().QX(paramLong);
      if (localObject1 == null) {
        break label1170;
      }
      localObject1 = ((AdSnsInfo)localObject1).convertToSnsInfo();
      label113:
      if ((localObject1 == null) || (!((SnsInfo)localObject1).isAd())) {
        break label1167;
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
        if ((paramejo == null) || ((paramejo.Uln == 0) && (paramejo.Ulp == 0L)))
        {
          AppMethodBeat.o(95603);
          return localeke;
          localObject1 = paramObject.toString();
          break;
          label203:
          localObject2 = ((ADInfo)localObject2).uxInfo;
          break label142;
        }
        paramObject = new ejh();
        paramObject.Ulj = paramejo.Ulp;
        paramObject.UkV = z.ZW(Util.nullAs((String)localObject2, ""));
      }
      for (;;)
      {
        try
        {
          paramejo = paramObject.toByteArray();
          localeke.TOI = new eae().dc(paramejo);
          AppMethodBeat.o(95603);
          return localeke;
        }
        catch (Exception paramejo)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramejo, "", new Object[0]);
          continue;
        }
        if (paramInt != 7) {
          break;
        }
        paramejo = new eiz();
        paramejo.UkV = z.ZW(Util.nullAs((String)localObject2, ""));
        try
        {
          paramejo = paramejo.toByteArray();
          localeke.TOI = new eae().dc(paramejo);
        }
        catch (Exception paramejo)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramejo, "", new Object[0]);
        }
      }
      if (paramInt == 8) {
        if ((paramObject != null) && ((paramObject instanceof ADInfo.c.a)))
        {
          paramInt = 1;
          label382:
          if (paramInt == 0) {
            break label1161;
          }
          paramejo = (ADInfo.c.a)paramObject;
          localObject2 = Util.nullAs((String)localObject2, "");
        }
      }
      label520:
      label1161:
      for (paramejo = (String)localObject2 + new StringBuilder("&").append(paramejo.JPX).append("|").append(paramejo.Kjq).toString();; paramejo = (ejo)localObject2)
      {
        localObject2 = new ejc();
        ((ejc)localObject2).UkV = z.ZW(Util.nullAs(paramejo, ""));
        if (localObject1 != null)
        {
          ((ejc)localObject2).Cqs = ((SnsInfo)localObject1).getAdRecSrc();
          paramejo = ((SnsInfo)localObject1).getSnsId();
          localObject1 = aj.fOI().bbk(paramejo);
          if (localObject1 != null)
          {
            paramejo = k.b(((SnsInfo)localObject1).getTimeLine());
            ((ejc)localObject2).UkX = z.ZW(Util.nullAs(paramejo, ""));
          }
        }
        else
        {
          if (paramInt == 0) {
            break label1156;
          }
        }
        for (paramejo = (ADInfo.c.a)paramObject;; paramejo = null)
        {
          for (;;)
          {
            for (;;)
            {
              if ((paramejo != null) && (paramejo.Kjo > 0))
              {
                ((ejc)localObject2).UkZ = paramejo.Kjo;
                if (((ejc)localObject2).Ula != null) {
                  ((ejc)localObject2).Ula.addAll(paramejo.Kjp);
                }
                if ((paramejo.Kjo != 1) || (((Integer)paramejo.Kjp.get(0)).intValue() != ADInfo.c.a.Kjj))
                {
                  aj.fOL().delete(paramLong);
                  aj.fON().Rb(paramLong);
                  com.tencent.mm.plugin.sns.storage.g.Ra(paramLong);
                }
                Log.i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp, reasonIdCount = " + paramejo.Kjo);
              }
              for (;;)
              {
                try
                {
                  paramejo = ((ejc)localObject2).toByteArray();
                  localeke.TOI = new eae().dc(paramejo);
                }
                catch (Exception paramejo)
                {
                  Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramejo, "", new Object[0]);
                }
                break;
                paramInt = 0;
                break label382;
                Log.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { paramejo });
                paramejo = "";
                break label520;
                if ((paramInt != 0) && (((ADInfo.c.a)paramObject).Kjn == ADInfo.c.a.Kjj))
                {
                  ((ejc)localObject2).UkY = ADInfo.c.a.Kjj;
                }
                else
                {
                  aj.fOL().delete(paramLong);
                  aj.fON().Rb(paramLong);
                  com.tencent.mm.plugin.sns.storage.g.Ra(paramLong);
                  if (paramInt != 0) {
                    ((ejc)localObject2).UkY = ((ADInfo.c.a)paramObject).Kjn;
                  }
                }
              }
              if (paramInt != 4) {
                break label889;
              }
              if ((paramejo == null) || ((paramejo.Uln == 0) && (paramejo.Ulp == 0L)))
              {
                AppMethodBeat.o(95603);
                return localeke;
              }
              paramObject = new ekf();
              paramObject.Uln = paramejo.Uln;
              try
              {
                paramejo = paramObject.toByteArray();
                localeke.TOI = new eae().dc(paramejo);
              }
              catch (Exception paramejo)
              {
                Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramejo, "", new Object[0]);
              }
            }
            break;
            label889:
            if (paramInt == 10)
            {
              paramejo = new ekp();
              if ((paramObject instanceof com.tencent.mm.cd.b))
              {
                paramObject = (com.tencent.mm.cd.b)paramObject;
                paramejo.Umw = z.aN(paramObject.UH);
                Log.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + paramObject.UH.length);
              }
              for (;;)
              {
                try
                {
                  paramejo = paramejo.toByteArray();
                  localeke.TOI = new eae().dc(paramejo);
                  Log.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + paramejo.length);
                }
                catch (Exception paramejo)
                {
                  Log.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + paramejo.getMessage());
                  Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramejo, "", new Object[0]);
                }
                break;
                Log.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
              }
            }
            if (paramInt != 12) {
              break;
            }
            if (!(paramObject instanceof ekb)) {
              break label1145;
            }
            paramejo = (ekb)paramObject;
            try
            {
              localeke.TOI = z.aN(paramejo.toByteArray());
              Log.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + paramejo.UlQ);
            }
            catch (Exception paramejo)
            {
              Log.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + paramejo.getMessage());
            }
          }
          break;
          label1145:
          Log.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
          break;
        }
      }
      label1156:
      label1167:
      continue;
      label1170:
      localObject1 = null;
      break label113;
      label1176:
      localObject1 = null;
    }
  }
  
  private static eke ae(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95604);
    eke localeke = new eke();
    localeke.TOI = new eae();
    localeke.Id = paramLong;
    localeke.jUk = paramInt;
    AppMethodBeat.o(95604);
    return localeke;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
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
        aj.fOH().QL(this.JVt);
        continue;
        aj.fOH().QN(this.JVt);
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
          aj.fOH().fOh();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95606);
          return;
          aj.fOH().QL(this.JVt);
          aj.fOI().delete(this.JVt);
          params = (eki)d.c.b(((com.tencent.mm.an.d)params).lBS);
          if (params.UlY == 1)
          {
            aj.fOM().D(aj.fOo(), params.Uma);
            continue;
            params = aj.fOI().Rd(this.JVt);
            if (params != null)
            {
              params.setPravited(1);
              params.setLocalPrivate();
              aj.fOI().b(this.JVt, params);
              continue;
              params = aj.fOI().Rd(this.JVt);
              if (params != null)
              {
                params.setPravited(0);
                params.unLocalPrivate();
                params.setExtFlag();
                aj.fOI().b(this.JVt, params);
                continue;
                aj.fOH().QN(this.JVt);
              }
            }
          }
        }
        paramArrayOfByte = aj.fOI().Rd(this.JVt);
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
          break label1529;
        }
        params = (ejo)localIterator.next();
        if ((this.JVu == null) || (params.Uln != this.JVu.Uln)) {
          continue;
        }
        if (params != null) {
          localSnsObject.CommentUserList.remove(params);
        }
        paramArrayOfByte.setAttrBuf(localSnsObject.toByteArray());
        aj.fOI().T(paramArrayOfByte);
        aj.fON().j(paramArrayOfByte.field_snsId, this.JVu.Uln, this.JVu.rWu);
      }
      catch (Exception params)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", params, "", new Object[0]);
      }
      break;
      paramArrayOfByte = aj.fOL().QX(this.JVt);
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
            break label1523;
          }
          params = (ejo)localIterator.next();
          if ((this.JVu == null) || (params.Ulp != this.JVu.Ulp)) {
            continue;
          }
          if (params != null) {
            localSnsObject.CommentUserList.remove(params);
          }
          paramArrayOfByte.setAttrBuf(localSnsObject.toByteArray());
          aj.fOL().replace(paramArrayOfByte);
          aj.fON().j(paramArrayOfByte.field_snsId, this.JVu.Ulp, this.JVu.rWu);
        }
        catch (Exception params)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", params, "", new Object[0]);
        }
        break;
        aj.fOH().QN(this.JVt);
        break;
        if ((this.JVv != null) && ((this.JVv instanceof ADInfo.c.a)))
        {
          paramInt1 = 1;
          label814:
          if (paramInt1 == 0) {
            break label1517;
          }
        }
        label1124:
        label1517:
        for (params = (ADInfo.c.a)this.JVv;; params = null)
        {
          if ((params != null) && (params.Kjo > 0))
          {
            if ((params.Kjo != 1) || (((Integer)params.Kjp.get(0)).intValue() != ADInfo.c.a.Kjj))
            {
              aj.fOL().delete(this.JVt);
              aj.fON().Rb(this.JVt);
              com.tencent.mm.plugin.sns.storage.g.Ra(this.JVt);
              paramArrayOfByte = new bx();
              EventCenter.instance.publish(paramArrayOfByte);
            }
            Log.i("MicroMsg.NetSceneSnsObjectOp", "onGYNetEnd, reasonIdCount = " + params.Kjo);
            break;
            paramInt1 = 0;
            break label814;
          }
          if ((this.JVv != null) && ((this.JVv instanceof ADInfo.c.a)) && (((ADInfo.c.a)this.JVv).Kjn == ADInfo.c.a.Kjj)) {
            break;
          }
          aj.fOL().delete(this.JVt);
          aj.fON().Rb(this.JVt);
          com.tencent.mm.plugin.sns.storage.g.Ra(this.JVt);
          params = new bx();
          EventCenter.instance.publish(params);
          break;
          params = aj.fOI().Rd(this.JVt);
          if (params == null) {
            break;
          }
          params.removeSourceFlag(2);
          aj.fOI().b(this.JVt, params);
          break;
          Log.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.JVw);
          int i;
          int j;
          if (this.JVw == 0)
          {
            h.aHH();
            h.aHG().aHp().set(ar.a.VkK, Boolean.TRUE);
            h.aHH();
            paramInt1 = ((Integer)h.aHG().aHp().get(ar.a.VkM, Integer.valueOf(0))).intValue();
            h.aHH();
            h.aHG().aHp().set(ar.a.VkM, Integer.valueOf(paramInt1 + 1));
            h.aHH();
            i = ((Integer)h.aHG().aHp().get(ar.a.VkN, Integer.valueOf(0))).intValue();
            if (this.JVw != 0) {
              break label1338;
            }
            i += 1;
            j = i * 2 + 198;
            paramInt1 = j;
            if (j >= 216) {
              paramInt1 = 216;
            }
            if (paramInt1 >= 200) {
              com.tencent.mm.plugin.sns.lucky.a.b.rE(paramInt1);
            }
            Log.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + paramInt1 + " " + i);
            paramInt1 = i;
          }
          for (;;)
          {
            h.aHH();
            h.aHG().aHp().set(ar.a.VkN, Integer.valueOf(paramInt1));
            break;
            if (this.JVw != 1) {
              break label1124;
            }
            h.aHH();
            h.aHG().aHp().set(ar.a.VkK, Boolean.FALSE);
            break label1124;
            paramInt1 = i;
            if (this.JVw == 1)
            {
              i += 1;
              j = i * 2 + 198 + 1;
              paramInt1 = j;
              if (j >= 217) {
                paramInt1 = 217;
              }
              if (paramInt1 >= 201) {
                com.tencent.mm.plugin.sns.lucky.a.b.rE(paramInt1);
              }
              Log.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + paramInt1 + " " + i);
              paramInt1 = i;
            }
          }
          if ((this.JVv == null) || (!(this.JVv instanceof ekb))) {
            break;
          }
          if (((ekb)this.JVv).UlQ == 1) {}
          for (boolean bool = true;; bool = false)
          {
            aj.fON().L(this.JVt, bool);
            Log.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[] { Long.valueOf(this.JVt), Boolean.valueOf(bool) });
            break;
          }
        }
        label1338:
        label1523:
        params = null;
      }
      label1529:
      params = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s
 * JD-Core Version:    0.7.0.1
 */