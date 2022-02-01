package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.d.h;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dey;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfz;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dge;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
  extends n
  implements com.tencent.mm.network.k
{
  public com.tencent.mm.al.f callback;
  public int dJd;
  private ap handler;
  private com.tencent.mm.al.b rr;
  public int type;
  public long zhv;
  public dfn zhw;
  private Object zhx;
  private int zhy;
  
  public q(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, null, null);
  }
  
  public q(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(95602);
    this.type = -1;
    this.zhv = 0L;
    this.dJd = -1;
    this.zhy = 0;
    this.handler = new ap(Looper.getMainLooper());
    this.zhw = null;
    this.type = 9;
    this.zhv = paramLong;
    ad.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + this.type);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new dgf();
    ((b.a)localObject1).hNN = new dgg();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    ((b.a)localObject1).funcId = 218;
    ((b.a)localObject1).hNO = 104;
    ((b.a)localObject1).respCmdId = 1000000104;
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (dgf)this.rr.hNK.hNQ;
    Object localObject2 = ag.dUe().Ai(paramLong);
    if (localObject2 != null) {
      this.dJd = ((p)localObject2).zMC;
    }
    localObject2 = U(paramLong, this.type);
    dge localdge = new dge();
    localdge.Scene = paramInt1;
    localdge.Hup = paramInt2;
    localdge.Huq = z.IX(paramString);
    try
    {
      paramString = localdge.toByteArray();
      ((dgc)localObject2).HaC = new SKBuiltinBuffer_t().setBuffer(paramString);
      paramString = new LinkedList();
      paramString.add(localObject2);
      ((dgf)localObject1).Hus = paramString;
      ((dgf)localObject1).Hur = paramString.size();
      AppMethodBeat.o(95602);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramString, "", new Object[0]);
      }
    }
  }
  
  public q(long paramLong, int paramInt, dfn paramdfn)
  {
    this(paramLong, paramInt, paramdfn, null);
  }
  
  private q(long paramLong, int paramInt, dfn paramdfn, Object paramObject)
  {
    AppMethodBeat.i(95601);
    this.type = -1;
    this.zhv = 0L;
    this.dJd = -1;
    this.zhy = 0;
    this.handler = new ap(Looper.getMainLooper());
    this.zhw = paramdfn;
    this.type = paramInt;
    this.zhv = paramLong;
    this.zhx = paramObject;
    ad.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + paramInt);
    if (paramdfn != null) {
      ad.i("MicroMsg.NetSceneSnsObjectOp", paramdfn.HtH + " " + paramdfn.HtJ);
    }
    paramdfn = new b.a();
    paramdfn.hNM = new dgf();
    paramdfn.hNN = new dgg();
    paramdfn.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    paramdfn.funcId = 218;
    paramdfn.hNO = 104;
    paramdfn.respCmdId = 1000000104;
    this.rr = paramdfn.aDC();
    paramdfn = (dgf)this.rr.hNK.hNQ;
    Object localObject = ag.dUe().Ai(paramLong);
    if (localObject != null) {
      this.dJd = ((p)localObject).zMC;
    }
    paramObject = a(paramLong, paramInt, this.zhw, paramObject);
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramObject);
    paramdfn.Hus = ((LinkedList)localObject);
    paramdfn.Hur = ((LinkedList)localObject).size();
    AppMethodBeat.o(95601);
  }
  
  public q(long paramLong, int paramInt, Object paramObject)
  {
    this(paramLong, paramInt, null, paramObject);
  }
  
  private static dgc U(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95604);
    dgc localdgc = new dgc();
    localdgc.HaC = new SKBuiltinBuffer_t();
    localdgc.Id = paramLong;
    localdgc.gsV = paramInt;
    AppMethodBeat.o(95604);
    return localdgc;
  }
  
  private static dgc a(long paramLong, int paramInt, dfn paramdfn, Object paramObject)
  {
    AppMethodBeat.i(95603);
    dgc localdgc = U(paramLong, paramInt);
    Object localObject2 = new StringBuilder("getSnsObjectOp ").append(paramInt).append(" ");
    Object localObject1;
    if (paramObject == null)
    {
      localObject1 = "";
      ad.i("MicroMsg.NetSceneSnsObjectOp", (String)localObject1);
      localObject2 = "";
      if ((paramInt != 8) && (paramInt != 10) && (paramInt != 7) && (paramInt != 8) && (paramInt != 6)) {
        break label1046;
      }
      localObject1 = ag.dUh().zZ(paramLong);
      if (localObject1 == null) {
        break label1040;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dYr();
      label113:
      if ((localObject1 == null) || (!((p)localObject1).QM(32))) {
        break label1037;
      }
      localObject2 = ((p)localObject1).dRK();
      if (localObject2 != null) {
        break label205;
      }
      localObject2 = "";
      label144:
      ad.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo ".concat(String.valueOf(localObject2)));
    }
    for (;;)
    {
      if (paramInt == 6)
      {
        if ((paramdfn == null) || ((paramdfn.HtH == 0) && (paramdfn.HtJ == 0L)))
        {
          AppMethodBeat.o(95603);
          return localdgc;
          localObject1 = paramObject.toString();
          break;
          label205:
          localObject2 = ((a)localObject2).dFy;
          break label144;
        }
        paramObject = new dfg();
        paramObject.HtD = paramdfn.HtJ;
        paramObject.Htr = z.IX(bt.bI((String)localObject2, ""));
      }
      for (;;)
      {
        try
        {
          paramdfn = paramObject.toByteArray();
          localdgc.HaC = new SKBuiltinBuffer_t().setBuffer(paramdfn);
          AppMethodBeat.o(95603);
          return localdgc;
        }
        catch (Exception paramdfn)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdfn, "", new Object[0]);
          continue;
        }
        if (paramInt != 7) {
          break;
        }
        paramdfn = new dey();
        paramdfn.Htr = z.IX(bt.bI((String)localObject2, ""));
        try
        {
          paramdfn = paramdfn.toByteArray();
          localdgc.HaC = new SKBuiltinBuffer_t().setBuffer(paramdfn);
        }
        catch (Exception paramdfn)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdfn, "", new Object[0]);
        }
      }
      if (paramInt == 8) {
        if ((paramObject != null) && ((paramObject instanceof a.c.a)))
        {
          paramInt = 1;
          label384:
          if (paramInt == 0) {
            break label1031;
          }
          paramdfn = (a.c.a)paramObject;
          localObject2 = bt.bI((String)localObject2, "");
        }
      }
      label1031:
      for (paramdfn = (String)localObject2 + new StringBuilder("&").append(paramdfn.zcr).append("|").append(paramdfn.zvq).toString();; paramdfn = (dfn)localObject2)
      {
        for (;;)
        {
          for (;;)
          {
            localObject2 = new dfb();
            ((dfb)localObject2).Htr = z.IX(bt.bI(paramdfn, ""));
            if (localObject1 != null)
            {
              ((dfb)localObject2).tRT = ((p)localObject1).dYV();
              paramdfn = ((p)localObject1).getSnsId();
              localObject1 = ag.dUe().azZ(paramdfn);
              if (localObject1 != null)
              {
                paramdfn = h.b(((p)localObject1).dYl());
                label522:
                ((dfb)localObject2).Htt = z.IX(bt.bI(paramdfn, ""));
              }
            }
            else
            {
              if ((paramInt == 0) || (((a.c.a)paramObject).zvp != a.c.a.zvl)) {
                break label631;
              }
              ((dfb)localObject2).Htu = a.c.a.zvl;
            }
            for (;;)
            {
              try
              {
                paramdfn = ((dfb)localObject2).toByteArray();
                localdgc.HaC = new SKBuiltinBuffer_t().setBuffer(paramdfn);
              }
              catch (Exception paramdfn)
              {
                ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdfn, "", new Object[0]);
              }
              break;
              paramInt = 0;
              break label384;
              ad.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { paramdfn });
              paramdfn = "";
              break label522;
              label631:
              ag.dUh().delete(paramLong);
              ag.dUj().Ad(paramLong);
              i.Ac(paramLong);
              if (paramInt != 0) {
                ((dfb)localObject2).Htu = ((a.c.a)paramObject).zvp;
              }
            }
            if (paramInt != 4) {
              break label764;
            }
            if ((paramdfn == null) || ((paramdfn.HtH == 0) && (paramdfn.HtJ == 0L)))
            {
              AppMethodBeat.o(95603);
              return localdgc;
            }
            paramObject = new dgd();
            paramObject.HtH = paramdfn.HtH;
            try
            {
              paramdfn = paramObject.toByteArray();
              localdgc.HaC = new SKBuiltinBuffer_t().setBuffer(paramdfn);
            }
            catch (Exception paramdfn)
            {
              ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdfn, "", new Object[0]);
            }
          }
          break;
          label764:
          if (paramInt == 10)
          {
            paramdfn = new dgm();
            if ((paramObject instanceof com.tencent.mm.bx.b))
            {
              paramObject = (com.tencent.mm.bx.b)paramObject;
              paramdfn.HuO = z.al(paramObject.zr);
              ad.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + paramObject.zr.length);
            }
            for (;;)
            {
              try
              {
                paramdfn = paramdfn.toByteArray();
                localdgc.HaC = new SKBuiltinBuffer_t().setBuffer(paramdfn);
                ad.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + paramdfn.length);
              }
              catch (Exception paramdfn)
              {
                ad.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + paramdfn.getMessage());
                ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdfn, "", new Object[0]);
              }
              break;
              ad.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
          }
          if (paramInt != 12) {
            break;
          }
          if (!(paramObject instanceof dfz)) {
            break label1020;
          }
          paramdfn = (dfz)paramObject;
          try
          {
            localdgc.HaC = z.al(paramdfn.toByteArray());
            ad.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + paramdfn.Hum);
          }
          catch (Exception paramdfn)
          {
            ad.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + paramdfn.getMessage());
          }
        }
        break;
        label1020:
        ad.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
        break;
      }
      label1037:
      continue;
      label1040:
      localObject1 = null;
      break label113;
      label1046:
      localObject1 = null;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(95605);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(95605);
    return i;
  }
  
  public final int getType()
  {
    return 218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95606);
    ad.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
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
        ag.dUd().zO(this.zhv);
        continue;
        ag.dUd().zQ(this.zhv);
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
          ag.dUd().dTE();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95606);
          return;
          ag.dUd().zO(this.zhv);
          ag.dUe().delete(this.zhv);
          paramq = (dgg)((com.tencent.mm.al.b)paramq).hNL.hNQ;
          if (paramq.Huu == 1)
          {
            ag.dUi().x(ag.dTJ(), paramq.Huw);
            continue;
            paramq = ag.dUe().Ai(this.zhv);
            if (paramq != null)
            {
              paramq.field_pravited = 1;
              paramq.dYE();
              ag.dUe().b(this.zhv, paramq);
              continue;
              paramq = ag.dUe().Ai(this.zhv);
              if (paramq != null)
              {
                paramq.field_pravited = 0;
                paramq.field_localPrivate = 0;
                paramq.dYH();
                ag.dUe().b(this.zhv, paramq);
                continue;
                ag.dUd().zQ(this.zhv);
              }
            }
          }
        }
        paramArrayOfByte = ag.dUe().Ai(this.zhv);
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
          break label1350;
        }
        paramq = (dfn)localIterator.next();
        if ((this.zhw == null) || (paramq.HtH != this.zhw.HtH)) {
          continue;
        }
        if (paramq != null) {
          localSnsObject.CommentUserList.remove(paramq);
        }
        paramArrayOfByte.bI(localSnsObject.toByteArray());
        ag.dUe().M(paramArrayOfByte);
        ag.dUj().i(paramArrayOfByte.field_snsId, this.zhw.HtH, this.zhw.nEf);
      }
      catch (Exception paramq)
      {
        ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
      }
      break;
      paramArrayOfByte = ag.dUh().zZ(this.zhv);
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
            break label1344;
          }
          paramq = (dfn)localIterator.next();
          if ((this.zhw == null) || (paramq.HtJ != this.zhw.HtJ)) {
            continue;
          }
          if (paramq != null) {
            localSnsObject.CommentUserList.remove(paramq);
          }
          paramArrayOfByte.bI(localSnsObject.toByteArray());
          ag.dUh().replace(paramArrayOfByte);
          ag.dUj().i(paramArrayOfByte.field_snsId, this.zhw.HtJ, this.zhw.nEf);
        }
        catch (Exception paramq)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
        }
        break;
        ag.dUd().zQ(this.zhv);
        break;
        if ((this.zhx != null) && ((this.zhx instanceof a.c.a)) && (((a.c.a)this.zhx).zvp == a.c.a.zvl)) {
          break;
        }
        ag.dUh().delete(this.zhv);
        ag.dUj().Ad(this.zhv);
        i.Ac(this.zhv);
        break;
        paramq = ag.dUe().Ai(this.zhv);
        if (paramq == null) {
          break;
        }
        paramq.QN(2);
        ag.dUe().b(this.zhv, paramq);
        break;
        ad.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.zhy);
        label951:
        int i;
        int j;
        if (this.zhy == 0)
        {
          g.ajD();
          g.ajC().ajl().set(al.a.Iul, Boolean.TRUE);
          g.ajD();
          paramInt1 = ((Integer)g.ajC().ajl().get(al.a.Iun, Integer.valueOf(0))).intValue();
          g.ajD();
          g.ajC().ajl().set(al.a.Iun, Integer.valueOf(paramInt1 + 1));
          g.ajD();
          i = ((Integer)g.ajC().ajl().get(al.a.Iuo, Integer.valueOf(0))).intValue();
          if (this.zhy != 0) {
            break label1165;
          }
          i += 1;
          j = i * 2 + 198;
          paramInt1 = j;
          if (j >= 216) {
            paramInt1 = 216;
          }
          if (paramInt1 >= 200) {
            com.tencent.mm.plugin.sns.lucky.a.b.ma(paramInt1);
          }
          ad.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + paramInt1 + " " + i);
          paramInt1 = i;
        }
        for (;;)
        {
          g.ajD();
          g.ajC().ajl().set(al.a.Iuo, Integer.valueOf(paramInt1));
          break;
          if (this.zhy != 1) {
            break label951;
          }
          g.ajD();
          g.ajC().ajl().set(al.a.Iul, Boolean.FALSE);
          break label951;
          label1165:
          paramInt1 = i;
          if (this.zhy == 1)
          {
            i += 1;
            j = i * 2 + 198 + 1;
            paramInt1 = j;
            if (j >= 217) {
              paramInt1 = 217;
            }
            if (paramInt1 >= 201) {
              com.tencent.mm.plugin.sns.lucky.a.b.ma(paramInt1);
            }
            ad.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + paramInt1 + " " + i);
            paramInt1 = i;
          }
        }
        if ((this.zhx == null) || (!(this.zhx instanceof dfz))) {
          break;
        }
        if (((dfz)this.zhx).Hum == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ag.dUj().E(this.zhv, bool);
          ad.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[] { Long.valueOf(this.zhv), Boolean.valueOf(bool) });
          break;
        }
        label1344:
        paramq = null;
      }
      label1350:
      paramq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.q
 * JD-Core Version:    0.7.0.1
 */