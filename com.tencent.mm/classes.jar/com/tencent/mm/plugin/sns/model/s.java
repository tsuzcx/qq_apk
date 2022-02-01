package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.cg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.protocal.protobuf.fdj;
import com.tencent.mm.protocal.protobuf.fdo;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.fej;
import com.tencent.mm.protocal.protobuf.fem;
import com.tencent.mm.protocal.protobuf.fen;
import com.tencent.mm.protocal.protobuf.feo;
import com.tencent.mm.protocal.protobuf.fep;
import com.tencent.mm.protocal.protobuf.feq;
import com.tencent.mm.protocal.protobuf.fex;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends com.tencent.mm.am.p
  implements m
{
  public long Qsu;
  public fdv Qsv;
  private Object Qsw;
  private int Qsx;
  public com.tencent.mm.am.h callback;
  private MMHandler handler;
  public int icg;
  private c rr;
  public int type;
  
  public s(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, null, null);
  }
  
  public s(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(95602);
    this.type = -1;
    this.Qsu = 0L;
    this.icg = -1;
    this.Qsx = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Qsv = null;
    this.type = 9;
    this.Qsu = paramLong;
    Log.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + this.type);
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new fep();
    ((c.a)localObject1).otF = new feq();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    ((c.a)localObject1).funcId = 218;
    ((c.a)localObject1).otG = 104;
    ((c.a)localObject1).respCmdId = 1000000104;
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (fep)c.b.b(this.rr.otB);
    Object localObject2 = al.hgB().vj(paramLong);
    if (localObject2 != null) {
      this.icg = ((SnsInfo)localObject2).localid;
    }
    localObject2 = aw(paramLong, this.type);
    feo localfeo = new feo();
    localfeo.IJG = paramInt1;
    localfeo.abDU = paramInt2;
    localfeo.abDV = com.tencent.mm.platformtools.w.Sk(paramString);
    try
    {
      paramString = localfeo.toByteArray();
      ((fem)localObject2).abfg = new gol().df(paramString);
      paramString = new LinkedList();
      paramString.add(localObject2);
      ((fep)localObject1).abDX = paramString;
      ((fep)localObject1).abDW = paramString.size();
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
  
  public s(long paramLong, int paramInt, fdv paramfdv)
  {
    this(paramLong, paramInt, paramfdv, null);
  }
  
  private s(long paramLong, int paramInt, fdv paramfdv, Object paramObject)
  {
    AppMethodBeat.i(95601);
    this.type = -1;
    this.Qsu = 0L;
    this.icg = -1;
    this.Qsx = 0;
    this.handler = new MMHandler(Looper.getMainLooper());
    this.Qsv = paramfdv;
    this.type = paramInt;
    this.Qsu = paramLong;
    this.Qsw = paramObject;
    Log.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + paramInt);
    if (paramfdv != null) {
      Log.i("MicroMsg.NetSceneSnsObjectOp", paramfdv.abDh + " " + paramfdv.abDj);
    }
    paramfdv = new c.a();
    paramfdv.otE = new fep();
    paramfdv.otF = new feq();
    paramfdv.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    paramfdv.funcId = 218;
    paramfdv.otG = 104;
    paramfdv.respCmdId = 1000000104;
    this.rr = paramfdv.bEF();
    paramfdv = (fep)c.b.b(this.rr.otB);
    Object localObject = al.hgB().vj(paramLong);
    if (localObject != null) {
      this.icg = ((SnsInfo)localObject).localid;
    }
    paramObject = a(paramLong, paramInt, this.Qsv, paramObject);
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramObject);
    paramfdv.abDX = ((LinkedList)localObject);
    paramfdv.abDW = ((LinkedList)localObject).size();
    if (paramInt == 1) {
      try
      {
        paramObject = new gdd();
        paramObject.acaX = new gol().df(d.MtP.gtE());
        paramfdv.YKb = new gol().df(paramObject.toByteArray());
        AppMethodBeat.o(95601);
        return;
      }
      finally {}
    }
    AppMethodBeat.o(95601);
  }
  
  public s(long paramLong, int paramInt, Object paramObject)
  {
    this(paramLong, paramInt, null, paramObject);
  }
  
  private static fem a(long paramLong, int paramInt, fdv paramfdv, Object paramObject)
  {
    AppMethodBeat.i(95603);
    fem localfem = aw(paramLong, paramInt);
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
      localObject1 = al.hgE().vd(paramLong);
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
        if ((paramfdv == null) || ((paramfdv.abDh == 0) && (paramfdv.abDj == 0L)))
        {
          AppMethodBeat.o(95603);
          return localfem;
          localObject1 = paramObject.toString();
          break;
          label203:
          localObject2 = ((ADInfo)localObject2).uxInfo;
          break label142;
        }
        paramObject = new fdo();
        paramObject.abDd = paramfdv.abDj;
        paramObject.abCM = com.tencent.mm.platformtools.w.Sk(Util.nullAs((String)localObject2, ""));
      }
      for (;;)
      {
        try
        {
          paramfdv = paramObject.toByteArray();
          localfem.abfg = new gol().df(paramfdv);
          AppMethodBeat.o(95603);
          return localfem;
        }
        catch (Exception paramfdv)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramfdv, "", new Object[0]);
          continue;
        }
        if (paramInt != 7) {
          break;
        }
        paramfdv = new fdg();
        paramfdv.abCM = com.tencent.mm.platformtools.w.Sk(Util.nullAs((String)localObject2, ""));
        try
        {
          paramfdv = paramfdv.toByteArray();
          localfem.abfg = new gol().df(paramfdv);
        }
        catch (Exception paramfdv)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramfdv, "", new Object[0]);
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
          paramfdv = (ADInfo.c.a)paramObject;
          localObject2 = Util.nullAs((String)localObject2, "");
        }
      }
      label520:
      label1161:
      for (paramfdv = (String)localObject2 + new StringBuilder("&").append(paramfdv.QmE).append("|").append(paramfdv.QHn).toString();; paramfdv = (fdv)localObject2)
      {
        localObject2 = new fdj();
        ((fdj)localObject2).abCM = com.tencent.mm.platformtools.w.Sk(Util.nullAs(paramfdv, ""));
        if (localObject1 != null)
        {
          ((fdj)localObject2).IcB = ((SnsInfo)localObject1).getAdRecSrc();
          paramfdv = ((SnsInfo)localObject1).getSnsId();
          localObject1 = al.hgB().aZK(paramfdv);
          if (localObject1 != null)
          {
            paramfdv = k.b(((SnsInfo)localObject1).getTimeLine());
            ((fdj)localObject2).abCO = com.tencent.mm.platformtools.w.Sk(Util.nullAs(paramfdv, ""));
          }
        }
        else
        {
          if (paramInt == 0) {
            break label1156;
          }
        }
        for (paramfdv = (ADInfo.c.a)paramObject;; paramfdv = null)
        {
          for (;;)
          {
            for (;;)
            {
              if ((paramfdv != null) && (paramfdv.QHl > 0))
              {
                ((fdj)localObject2).abCQ = paramfdv.QHl;
                if (((fdj)localObject2).abCR != null) {
                  ((fdj)localObject2).abCR.addAll(paramfdv.QHm);
                }
                if ((paramfdv.QHl != 1) || (((Integer)paramfdv.QHm.get(0)).intValue() != ADInfo.c.a.QHg))
                {
                  al.hgE().delete(paramLong);
                  al.hgH().vh(paramLong);
                  n.vg(paramLong);
                }
                Log.i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp, reasonIdCount = " + paramfdv.QHl);
              }
              for (;;)
              {
                try
                {
                  paramfdv = ((fdj)localObject2).toByteArray();
                  localfem.abfg = new gol().df(paramfdv);
                }
                catch (Exception paramfdv)
                {
                  Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramfdv, "", new Object[0]);
                }
                break;
                paramInt = 0;
                break label382;
                Log.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { paramfdv });
                paramfdv = "";
                break label520;
                if ((paramInt != 0) && (((ADInfo.c.a)paramObject).QHk == ADInfo.c.a.QHg))
                {
                  ((fdj)localObject2).abCP = ADInfo.c.a.QHg;
                }
                else
                {
                  al.hgE().delete(paramLong);
                  al.hgH().vh(paramLong);
                  n.vg(paramLong);
                  if (paramInt != 0) {
                    ((fdj)localObject2).abCP = ((ADInfo.c.a)paramObject).QHk;
                  }
                }
              }
              if (paramInt != 4) {
                break label889;
              }
              if ((paramfdv == null) || ((paramfdv.abDh == 0) && (paramfdv.abDj == 0L)))
              {
                AppMethodBeat.o(95603);
                return localfem;
              }
              paramObject = new fen();
              paramObject.abDh = paramfdv.abDh;
              try
              {
                paramfdv = paramObject.toByteArray();
                localfem.abfg = new gol().df(paramfdv);
              }
              catch (Exception paramfdv)
              {
                Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramfdv, "", new Object[0]);
              }
            }
            break;
            label889:
            if (paramInt == 10)
            {
              paramfdv = new fex();
              if ((paramObject instanceof com.tencent.mm.bx.b))
              {
                paramObject = (com.tencent.mm.bx.b)paramObject;
                paramfdv.abED = com.tencent.mm.platformtools.w.aN(paramObject.Op);
                Log.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + paramObject.Op.length);
              }
              for (;;)
              {
                try
                {
                  paramfdv = paramfdv.toByteArray();
                  localfem.abfg = new gol().df(paramfdv);
                  Log.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + paramfdv.length);
                }
                catch (Exception paramfdv)
                {
                  Log.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + paramfdv.getMessage());
                  Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramfdv, "", new Object[0]);
                }
                break;
                Log.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
              }
            }
            if (paramInt != 12) {
              break;
            }
            if (!(paramObject instanceof fej)) {
              break label1145;
            }
            paramfdv = (fej)paramObject;
            try
            {
              localfem.abfg = com.tencent.mm.platformtools.w.aN(paramfdv.toByteArray());
              Log.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + paramfdv.abDR);
            }
            catch (Exception paramfdv)
            {
              Log.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + paramfdv.getMessage());
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
  
  private static fem aw(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95604);
    fem localfem = new fem();
    localfem.abfg = new gol();
    localfem.Id = paramLong;
    localfem.muC = paramInt;
    AppMethodBeat.o(95604);
    return localfem;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(95605);
    this.callback = paramh;
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
        al.hgA().uR(this.Qsu);
        continue;
        al.hgA().uT(this.Qsu);
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
          al.hgA().hfT();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95606);
          return;
          al.hgA().uR(this.Qsu);
          al.hgB().delete(this.Qsu);
          params = (feq)c.c.b(((c)params).otC);
          if (params.abDZ == 1)
          {
            al.hgF().J(al.hgg(), params.abEb);
            continue;
            params = al.hgB().vj(this.Qsu);
            if (params != null)
            {
              params.setPravited(1);
              params.setLocalPrivate();
              al.hgB().b(this.Qsu, params);
              continue;
              params = al.hgB().vj(this.Qsu);
              if (params != null)
              {
                params.setPravited(0);
                params.unLocalPrivate();
                params.setExtFlag();
                al.hgB().b(this.Qsu, params);
                continue;
                al.hgA().uT(this.Qsu);
              }
            }
          }
        }
        paramArrayOfByte = al.hgB().vj(this.Qsu);
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
          break label1515;
        }
        params = (fdv)localIterator.next();
        if ((this.Qsv == null) || (params.abDh != this.Qsv.abDh)) {
          continue;
        }
        if (params != null) {
          localSnsObject.CommentUserList.remove(params);
        }
        paramArrayOfByte.setAttrBuf(localSnsObject.toByteArray());
        al.hgB().V(paramArrayOfByte);
        al.hgH().p(paramArrayOfByte.field_snsId, this.Qsv.abDh, this.Qsv.vhJ);
      }
      catch (Exception params)
      {
        Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", params, "", new Object[0]);
      }
      break;
      paramArrayOfByte = al.hgE().vd(this.Qsu);
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
            break label1509;
          }
          params = (fdv)localIterator.next();
          if ((this.Qsv == null) || (params.abDj != this.Qsv.abDj)) {
            continue;
          }
          if (params != null) {
            localSnsObject.CommentUserList.remove(params);
          }
          paramArrayOfByte.setAttrBuf(localSnsObject.toByteArray());
          al.hgE().replace(paramArrayOfByte);
          al.hgH().p(paramArrayOfByte.field_snsId, this.Qsv.abDj, this.Qsv.vhJ);
        }
        catch (Exception params)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", params, "", new Object[0]);
        }
        break;
        al.hgA().uT(this.Qsu);
        break;
        if ((this.Qsw != null) && ((this.Qsw instanceof ADInfo.c.a)))
        {
          paramInt1 = 1;
          label814:
          if (paramInt1 == 0) {
            break label1503;
          }
        }
        label1110:
        label1503:
        for (params = (ADInfo.c.a)this.Qsw;; params = null)
        {
          if ((params != null) && (params.QHl > 0))
          {
            if ((params.QHl != 1) || (((Integer)params.QHm.get(0)).intValue() != ADInfo.c.a.QHg))
            {
              al.hgE().delete(this.Qsu);
              al.hgH().vh(this.Qsu);
              n.vg(this.Qsu);
              new cg().publish();
            }
            Log.i("MicroMsg.NetSceneSnsObjectOp", "onGYNetEnd, reasonIdCount = " + params.QHl);
            break;
            paramInt1 = 0;
            break label814;
          }
          if ((this.Qsw != null) && ((this.Qsw instanceof ADInfo.c.a)) && (((ADInfo.c.a)this.Qsw).QHk == ADInfo.c.a.QHg)) {
            break;
          }
          al.hgE().delete(this.Qsu);
          al.hgH().vh(this.Qsu);
          n.vg(this.Qsu);
          new cg().publish();
          break;
          params = al.hgB().vj(this.Qsu);
          if (params == null) {
            break;
          }
          params.removeSourceFlag(2);
          al.hgB().b(this.Qsu, params);
          break;
          Log.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.Qsx);
          int i;
          int j;
          if (this.Qsx == 0)
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acMe, Boolean.TRUE);
            com.tencent.mm.kernel.h.baF();
            paramInt1 = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMg, Integer.valueOf(0))).intValue();
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acMg, Integer.valueOf(paramInt1 + 1));
            com.tencent.mm.kernel.h.baF();
            i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acMh, Integer.valueOf(0))).intValue();
            if (this.Qsx != 0) {
              break label1324;
            }
            i += 1;
            j = i * 2 + 198;
            paramInt1 = j;
            if (j >= 216) {
              paramInt1 = 216;
            }
            if (paramInt1 >= 200) {
              com.tencent.mm.plugin.sns.lucky.a.b.rG(paramInt1);
            }
            Log.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + paramInt1 + " " + i);
            paramInt1 = i;
          }
          for (;;)
          {
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acMh, Integer.valueOf(paramInt1));
            break;
            if (this.Qsx != 1) {
              break label1110;
            }
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acMe, Boolean.FALSE);
            break label1110;
            paramInt1 = i;
            if (this.Qsx == 1)
            {
              i += 1;
              j = i * 2 + 198 + 1;
              paramInt1 = j;
              if (j >= 217) {
                paramInt1 = 217;
              }
              if (paramInt1 >= 201) {
                com.tencent.mm.plugin.sns.lucky.a.b.rG(paramInt1);
              }
              Log.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + paramInt1 + " " + i);
              paramInt1 = i;
            }
          }
          if ((this.Qsw == null) || (!(this.Qsw instanceof fej))) {
            break;
          }
          if (((fej)this.Qsw).abDR == 1) {}
          for (boolean bool = true;; bool = false)
          {
            al.hgH().V(this.Qsu, bool);
            Log.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[] { Long.valueOf(this.Qsu), Boolean.valueOf(bool) });
            break;
          }
        }
        label1324:
        label1509:
        params = null;
      }
      label1515:
      params = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.s
 * JD-Core Version:    0.7.0.1
 */