package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bso;
import com.tencent.mm.protocal.c.bsr;
import com.tencent.mm.protocal.c.bsw;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.btn;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.btr;
import com.tencent.mm.protocal.c.bts;
import com.tencent.mm.protocal.c.btt;
import com.tencent.mm.protocal.c.btu;
import com.tencent.mm.protocal.c.btv;
import com.tencent.mm.protocal.c.bub;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends m
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ah.b dmK;
  public com.tencent.mm.ah.f dmL;
  private ah handler = new ah(Looper.getMainLooper());
  public int onc = -1;
  private long oqb = 0L;
  private btd oqc;
  private Object oqd;
  private int oqe = 0;
  public int type = -1;
  
  public r(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, null, null);
  }
  
  public r(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    this.oqc = null;
    this.type = 9;
    this.oqb = paramLong;
    y.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + this.type);
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecH = new btu();
    ((b.a)localObject1).ecI = new btv();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    ((b.a)localObject1).ecG = 218;
    ((b.a)localObject1).ecJ = 104;
    ((b.a)localObject1).ecK = 1000000104;
    this.dmK = ((b.a)localObject1).Kt();
    localObject1 = (btu)this.dmK.ecE.ecN;
    Object localObject2 = af.bDF().gt(paramLong);
    if (localObject2 != null) {
      this.onc = ((n)localObject2).oLk;
    }
    localObject2 = w(paramLong, this.type);
    btt localbtt = new btt();
    localbtt.pyo = paramInt1;
    localbtt.tKr = paramInt2;
    localbtt.tKs = aa.pj(paramString);
    try
    {
      paramString = localbtt.toByteArray();
      ((btr)localObject2).txZ = new bmk().bs(paramString);
      paramString = new LinkedList();
      paramString.add(localObject2);
      ((btu)localObject1).tKu = paramString;
      ((btu)localObject1).tKt = paramString.size();
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramString, "", new Object[0]);
      }
    }
  }
  
  public r(long paramLong, int paramInt, btd parambtd)
  {
    this(paramLong, paramInt, parambtd, null);
  }
  
  private r(long paramLong, int paramInt, btd parambtd, Object paramObject)
  {
    this.oqc = parambtd;
    this.type = paramInt;
    this.oqb = paramLong;
    this.oqd = paramObject;
    y.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + paramInt);
    if (parambtd != null) {
      y.i("MicroMsg.NetSceneSnsObjectOp", parambtd.tJu + " " + parambtd.tJx);
    }
    parambtd = new b.a();
    parambtd.ecH = new btu();
    parambtd.ecI = new btv();
    parambtd.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    parambtd.ecG = 218;
    parambtd.ecJ = 104;
    parambtd.ecK = 1000000104;
    this.dmK = parambtd.Kt();
    parambtd = (btu)this.dmK.ecE.ecN;
    Object localObject = af.bDF().gt(paramLong);
    if (localObject != null) {
      this.onc = ((n)localObject).oLk;
    }
    paramObject = a(paramLong, paramInt, this.oqc, paramObject);
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramObject);
    parambtd.tKu = ((LinkedList)localObject);
    parambtd.tKt = ((LinkedList)localObject).size();
  }
  
  public r(long paramLong, int paramInt, Object paramObject)
  {
    this(paramLong, paramInt, null, paramObject);
  }
  
  private static btr a(long paramLong, int paramInt, btd parambtd, Object paramObject)
  {
    btr localbtr = w(paramLong, paramInt);
    Object localObject2 = new StringBuilder("getSnsObjectOp ").append(paramInt).append(" ");
    Object localObject1;
    if (paramObject == null)
    {
      localObject1 = "";
      y.i("MicroMsg.NetSceneSnsObjectOp", (String)localObject1);
      localObject2 = "";
      if ((paramInt != 8) && (paramInt != 10) && (paramInt != 7) && (paramInt != 8) && (paramInt != 6)) {
        break label1028;
      }
      localObject1 = af.bDI().gk(paramLong);
      if (localObject1 == null) {
        break label1022;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).bGl();
      label106:
      if ((localObject1 == null) || (!((n)localObject1).yr(32))) {
        break label1019;
      }
      localObject2 = ((n)localObject1).bGb();
      if (localObject2 != null) {
        break label199;
      }
      localObject2 = "";
      label137:
      y.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo " + (String)localObject2);
    }
    for (;;)
    {
      if (paramInt == 6)
      {
        if ((parambtd == null) || ((parambtd.tJu == 0) && (parambtd.tJx == 0L)))
        {
          return localbtr;
          localObject1 = paramObject.toString();
          break;
          label199:
          localObject2 = ((a)localObject2).ovV;
          break label137;
        }
        paramObject = new bsw();
        paramObject.tJq = parambtd.tJx;
        paramObject.tJe = aa.pj(bk.aM((String)localObject2, ""));
      }
      for (;;)
      {
        try
        {
          parambtd = paramObject.toByteArray();
          localbtr.txZ = new bmk().bs(parambtd);
          return localbtr;
        }
        catch (Exception parambtd)
        {
          y.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", parambtd, "", new Object[0]);
          continue;
        }
        if (paramInt != 7) {
          break;
        }
        parambtd = new bso();
        parambtd.tJe = aa.pj(bk.aM((String)localObject2, ""));
        try
        {
          parambtd = parambtd.toByteArray();
          localbtr.txZ = new bmk().bs(parambtd);
        }
        catch (Exception parambtd)
        {
          y.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", parambtd, "", new Object[0]);
        }
      }
      if (paramInt == 8) {
        if ((paramObject != null) && ((paramObject instanceof a.b.a)))
        {
          paramInt = 1;
          label372:
          if (paramInt == 0) {
            break label1013;
          }
          parambtd = (a.b.a)paramObject;
          localObject2 = bk.aM((String)localObject2, "");
        }
      }
      label619:
      label1013:
      for (parambtd = (String)localObject2 + new StringBuilder("&").append(parambtd.omN).append("|").append(parambtd.oAD).toString();; parambtd = (btd)localObject2)
      {
        for (;;)
        {
          for (;;)
          {
            localObject2 = new bsr();
            ((bsr)localObject2).tJe = aa.pj(bk.aM(parambtd, ""));
            if (localObject1 != null)
            {
              ((bsr)localObject2).swS = ((n)localObject1).bGO();
              parambtd = ((n)localObject1).bGk();
              localObject1 = af.bDF().OA(parambtd);
              if (localObject1 != null)
              {
                parambtd = com.tencent.mm.plugin.sns.a.b.f.a(((n)localObject1).bGe());
                label510:
                ((bsr)localObject2).tJg = aa.pj(bk.aM(parambtd, ""));
              }
            }
            else
            {
              if ((paramInt == 0) || (((a.b.a)paramObject).oAC != a.b.a.oAy)) {
                break label619;
              }
              ((bsr)localObject2).tJh = a.b.a.oAy;
            }
            for (;;)
            {
              try
              {
                parambtd = ((bsr)localObject2).toByteArray();
                localbtr.txZ = new bmk().bs(parambtd);
              }
              catch (Exception parambtd)
              {
                y.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", parambtd, "", new Object[0]);
              }
              break;
              paramInt = 0;
              break label372;
              y.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { parambtd });
              parambtd = "";
              break label510;
              af.bDI().delete(paramLong);
              af.bDK().go(paramLong);
              i.gn(paramLong);
              if (paramInt != 0) {
                ((bsr)localObject2).tJh = ((a.b.a)paramObject).oAC;
              }
            }
            if (paramInt != 4) {
              break label746;
            }
            if ((parambtd == null) || ((parambtd.tJu == 0) && (parambtd.tJx == 0L))) {
              return localbtr;
            }
            paramObject = new bts();
            paramObject.tJu = parambtd.tJu;
            try
            {
              parambtd = paramObject.toByteArray();
              localbtr.txZ = new bmk().bs(parambtd);
            }
            catch (Exception parambtd)
            {
              y.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", parambtd, "", new Object[0]);
            }
          }
          break;
          if (paramInt == 10)
          {
            parambtd = new bub();
            if ((paramObject instanceof com.tencent.mm.bv.b))
            {
              paramObject = (com.tencent.mm.bv.b)paramObject;
              parambtd.tKM = aa.I(paramObject.oY);
              y.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + paramObject.oY.length);
            }
            for (;;)
            {
              try
              {
                parambtd = parambtd.toByteArray();
                localbtr.txZ = new bmk().bs(parambtd);
                y.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + parambtd.length);
              }
              catch (Exception parambtd)
              {
                y.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + parambtd.getMessage());
                y.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", parambtd, "", new Object[0]);
              }
              break;
              y.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
          }
          if (paramInt != 12) {
            break;
          }
          if (!(paramObject instanceof btn)) {
            break label1002;
          }
          parambtd = (btn)paramObject;
          try
          {
            localbtr.txZ = aa.I(parambtd.toByteArray());
            y.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + parambtd.tJT);
          }
          catch (Exception parambtd)
          {
            y.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + parambtd.getMessage());
          }
        }
        break;
        y.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
        break;
      }
      label746:
      label1019:
      continue;
      label1002:
      label1022:
      localObject1 = null;
      break label106;
      label1028:
      localObject1 = null;
    }
  }
  
  private static btr w(long paramLong, int paramInt)
  {
    btr localbtr = new btr();
    localbtr.txZ = new bmk();
    localbtr.sGd = paramLong;
    localbtr.kTS = paramInt;
    return localbtr;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (this.type == 1)) {
        switch (this.type)
        {
        }
      }
      for (;;)
      {
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
        af.bDE().ge(this.oqb);
        continue;
        af.bDE().gg(this.oqb);
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
          af.bDE().bDg();
          this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
          return;
          af.bDE().ge(this.oqb);
          af.bDF().delete(this.oqb);
          continue;
          paramq = af.bDF().gt(this.oqb);
          if (paramq != null)
          {
            paramq.field_pravited = 1;
            paramq.bGy();
            af.bDF().b(this.oqb, paramq);
            continue;
            paramq = af.bDF().gt(this.oqb);
            if (paramq != null)
            {
              paramq.field_pravited = 0;
              paramq.field_localPrivate = 0;
              paramq.bGB();
              af.bDF().b(this.oqb, paramq);
              continue;
              af.bDE().gg(this.oqb);
            }
          }
        }
        paramArrayOfByte = af.bDF().gt(this.oqb);
      } while (paramArrayOfByte == null);
    }
    for (;;)
    {
      bto localbto;
      Iterator localIterator;
      try
      {
        localbto = (bto)new bto().aH(paramArrayOfByte.field_attrBuf);
        localIterator = localbto.tKb.iterator();
        if (!localIterator.hasNext()) {
          break label1291;
        }
        paramq = (btd)localIterator.next();
        if ((this.oqc == null) || (paramq.tJu != this.oqc.tJu)) {
          continue;
        }
        if (paramq != null) {
          localbto.tKb.remove(paramq);
        }
        paramArrayOfByte.aL(localbto.toByteArray());
        af.bDF().C(paramArrayOfByte);
        af.bDK().e(paramArrayOfByte.field_snsId, this.oqc.tJu, this.oqc.hQR);
      }
      catch (Exception paramq)
      {
        y.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
      }
      break;
      paramArrayOfByte = af.bDI().gk(this.oqb);
      if (paramArrayOfByte == null) {
        break;
      }
      for (;;)
      {
        try
        {
          localbto = (bto)new bto().aH(paramArrayOfByte.field_attrBuf);
          localIterator = localbto.tKb.iterator();
          if (!localIterator.hasNext()) {
            break label1285;
          }
          paramq = (btd)localIterator.next();
          if ((this.oqc == null) || (paramq.tJx != this.oqc.tJx)) {
            continue;
          }
          if (paramq != null) {
            localbto.tKb.remove(paramq);
          }
          paramArrayOfByte.aL(localbto.toByteArray());
          af.bDI().a(paramArrayOfByte);
          af.bDK().e(paramArrayOfByte.field_snsId, this.oqc.tJx, this.oqc.hQR);
        }
        catch (Exception paramq)
        {
          y.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
        }
        break;
        af.bDE().gg(this.oqb);
        break;
        if ((this.oqd != null) && ((this.oqd instanceof a.b.a)) && (((a.b.a)this.oqd).oAC == a.b.a.oAy)) {
          break;
        }
        af.bDI().delete(this.oqb);
        af.bDK().go(this.oqb);
        i.gn(this.oqb);
        break;
        paramq = af.bDF().gt(this.oqb);
        if (paramq == null) {
          break;
        }
        paramq.ys(2);
        af.bDF().b(this.oqb, paramq);
        break;
        y.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.oqe);
        label891:
        int i;
        int j;
        if (this.oqe == 0)
        {
          g.DQ();
          g.DP().Dz().c(ac.a.urI, Boolean.valueOf(true));
          g.DQ();
          paramInt1 = ((Integer)g.DP().Dz().get(ac.a.urK, Integer.valueOf(0))).intValue();
          g.DQ();
          g.DP().Dz().c(ac.a.urK, Integer.valueOf(paramInt1 + 1));
          g.DQ();
          i = ((Integer)g.DP().Dz().get(ac.a.urL, Integer.valueOf(0))).intValue();
          if (this.oqe != 0) {
            break label1106;
          }
          i += 1;
          j = i * 2 + 198;
          paramInt1 = j;
          if (j >= 216) {
            paramInt1 = 216;
          }
          if (paramInt1 >= 200) {
            com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(paramInt1);
          }
          y.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + paramInt1 + " " + i);
          paramInt1 = i;
        }
        for (;;)
        {
          g.DQ();
          g.DP().Dz().c(ac.a.urL, Integer.valueOf(paramInt1));
          break;
          if (this.oqe != 1) {
            break label891;
          }
          g.DQ();
          g.DP().Dz().c(ac.a.urI, Boolean.valueOf(false));
          break label891;
          label1106:
          paramInt1 = i;
          if (this.oqe == 1)
          {
            i += 1;
            j = i * 2 + 198 + 1;
            paramInt1 = j;
            if (j >= 217) {
              paramInt1 = 217;
            }
            if (paramInt1 >= 201) {
              com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(paramInt1);
            }
            y.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + paramInt1 + " " + i);
            paramInt1 = i;
          }
        }
        if ((this.oqd == null) || (!(this.oqd instanceof btn))) {
          break;
        }
        if (((btn)this.oqd).tJT == 1) {}
        for (boolean bool = true;; bool = false)
        {
          af.bDK().u(this.oqb, bool);
          y.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[] { Long.valueOf(this.oqb), Boolean.valueOf(bool) });
          break;
        }
        label1285:
        paramq = null;
      }
      label1291:
      paramq = null;
    }
  }
  
  public final int getType()
  {
    return 218;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.r
 * JD-Core Version:    0.7.0.1
 */