package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.ad.d.h;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.czl;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.daz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
  extends n
  implements com.tencent.mm.network.k
{
  public com.tencent.mm.ak.g callback;
  public int dwR;
  private ao handler;
  private com.tencent.mm.ak.b rr;
  public int type;
  private long xRB;
  private daa xRC;
  private Object xRD;
  private int xRE;
  
  public q(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, null, null);
  }
  
  public q(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(95602);
    this.type = -1;
    this.xRB = 0L;
    this.dwR = -1;
    this.xRE = 0;
    this.handler = new ao(Looper.getMainLooper());
    this.xRC = null;
    this.type = 9;
    this.xRB = paramLong;
    ac.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + this.type);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new das();
    ((b.a)localObject1).hvu = new dat();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    ((b.a)localObject1).funcId = 218;
    ((b.a)localObject1).reqCmdId = 104;
    ((b.a)localObject1).respCmdId = 1000000104;
    this.rr = ((b.a)localObject1).aAz();
    localObject1 = (das)this.rr.hvr.hvw;
    Object localObject2 = af.dHR().xK(paramLong);
    if (localObject2 != null) {
      this.dwR = ((p)localObject2).yvp;
    }
    localObject2 = P(paramLong, this.type);
    dar localdar = new dar();
    localdar.Scene = paramInt1;
    localdar.FJH = paramInt2;
    localdar.FJI = z.FI(paramString);
    try
    {
      paramString = localdar.toByteArray();
      ((dap)localObject2).FqS = new SKBuiltinBuffer_t().setBuffer(paramString);
      paramString = new LinkedList();
      paramString.add(localObject2);
      ((das)localObject1).FJK = paramString;
      ((das)localObject1).FJJ = paramString.size();
      AppMethodBeat.o(95602);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramString, "", new Object[0]);
      }
    }
  }
  
  public q(long paramLong, int paramInt, daa paramdaa)
  {
    this(paramLong, paramInt, paramdaa, null);
  }
  
  private q(long paramLong, int paramInt, daa paramdaa, Object paramObject)
  {
    AppMethodBeat.i(95601);
    this.type = -1;
    this.xRB = 0L;
    this.dwR = -1;
    this.xRE = 0;
    this.handler = new ao(Looper.getMainLooper());
    this.xRC = paramdaa;
    this.type = paramInt;
    this.xRB = paramLong;
    this.xRD = paramObject;
    ac.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + paramInt);
    if (paramdaa != null) {
      ac.i("MicroMsg.NetSceneSnsObjectOp", paramdaa.FIZ + " " + paramdaa.FJb);
    }
    paramdaa = new b.a();
    paramdaa.hvt = new das();
    paramdaa.hvu = new dat();
    paramdaa.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    paramdaa.funcId = 218;
    paramdaa.reqCmdId = 104;
    paramdaa.respCmdId = 1000000104;
    this.rr = paramdaa.aAz();
    paramdaa = (das)this.rr.hvr.hvw;
    Object localObject = af.dHR().xK(paramLong);
    if (localObject != null) {
      this.dwR = ((p)localObject).yvp;
    }
    paramObject = a(paramLong, paramInt, this.xRC, paramObject);
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramObject);
    paramdaa.FJK = ((LinkedList)localObject);
    paramdaa.FJJ = ((LinkedList)localObject).size();
    AppMethodBeat.o(95601);
  }
  
  public q(long paramLong, int paramInt, Object paramObject)
  {
    this(paramLong, paramInt, null, paramObject);
  }
  
  private static dap P(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95604);
    dap localdap = new dap();
    localdap.FqS = new SKBuiltinBuffer_t();
    localdap.Id = paramLong;
    localdap.fZz = paramInt;
    AppMethodBeat.o(95604);
    return localdap;
  }
  
  private static dap a(long paramLong, int paramInt, daa paramdaa, Object paramObject)
  {
    AppMethodBeat.i(95603);
    dap localdap = P(paramLong, paramInt);
    Object localObject2 = new StringBuilder("getSnsObjectOp ").append(paramInt).append(" ");
    Object localObject1;
    if (paramObject == null)
    {
      localObject1 = "";
      ac.i("MicroMsg.NetSceneSnsObjectOp", (String)localObject1);
      localObject2 = "";
      if ((paramInt != 8) && (paramInt != 10) && (paramInt != 7) && (paramInt != 8) && (paramInt != 6)) {
        break label1046;
      }
      localObject1 = af.dHU().xB(paramLong);
      if (localObject1 == null) {
        break label1040;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dMb();
      label113:
      if ((localObject1 == null) || (!((p)localObject1).Pe(32))) {
        break label1037;
      }
      localObject2 = ((p)localObject1).dFQ();
      if (localObject2 != null) {
        break label205;
      }
      localObject2 = "";
      label144:
      ac.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo ".concat(String.valueOf(localObject2)));
    }
    for (;;)
    {
      if (paramInt == 6)
      {
        if ((paramdaa == null) || ((paramdaa.FIZ == 0) && (paramdaa.FJb == 0L)))
        {
          AppMethodBeat.o(95603);
          return localdap;
          localObject1 = paramObject.toString();
          break;
          label205:
          localObject2 = ((a)localObject2).dtx;
          break label144;
        }
        paramObject = new czt();
        paramObject.FIV = paramdaa.FJb;
        paramObject.FIJ = z.FI(bs.bG((String)localObject2, ""));
      }
      for (;;)
      {
        try
        {
          paramdaa = paramObject.toByteArray();
          localdap.FqS = new SKBuiltinBuffer_t().setBuffer(paramdaa);
          AppMethodBeat.o(95603);
          return localdap;
        }
        catch (Exception paramdaa)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdaa, "", new Object[0]);
          continue;
        }
        if (paramInt != 7) {
          break;
        }
        paramdaa = new czl();
        paramdaa.FIJ = z.FI(bs.bG((String)localObject2, ""));
        try
        {
          paramdaa = paramdaa.toByteArray();
          localdap.FqS = new SKBuiltinBuffer_t().setBuffer(paramdaa);
        }
        catch (Exception paramdaa)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdaa, "", new Object[0]);
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
          paramdaa = (a.c.a)paramObject;
          localObject2 = bs.bG((String)localObject2, "");
        }
      }
      label1031:
      for (paramdaa = (String)localObject2 + new StringBuilder("&").append(paramdaa.xMz).append("|").append(paramdaa.yfo).toString();; paramdaa = (daa)localObject2)
      {
        for (;;)
        {
          for (;;)
          {
            localObject2 = new czo();
            ((czo)localObject2).FIJ = z.FI(bs.bG(paramdaa, ""));
            if (localObject1 != null)
            {
              ((czo)localObject2).sVo = ((p)localObject1).dMF();
              paramdaa = ((p)localObject1).getSnsId();
              localObject1 = af.dHR().auS(paramdaa);
              if (localObject1 != null)
              {
                paramdaa = h.b(((p)localObject1).dLV());
                label522:
                ((czo)localObject2).FIL = z.FI(bs.bG(paramdaa, ""));
              }
            }
            else
            {
              if ((paramInt == 0) || (((a.c.a)paramObject).yfn != a.c.a.yfj)) {
                break label631;
              }
              ((czo)localObject2).FIM = a.c.a.yfj;
            }
            for (;;)
            {
              try
              {
                paramdaa = ((czo)localObject2).toByteArray();
                localdap.FqS = new SKBuiltinBuffer_t().setBuffer(paramdaa);
              }
              catch (Exception paramdaa)
              {
                ac.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdaa, "", new Object[0]);
              }
              break;
              paramInt = 0;
              break label384;
              ac.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { paramdaa });
              paramdaa = "";
              break label522;
              label631:
              af.dHU().delete(paramLong);
              af.dHW().xF(paramLong);
              i.xE(paramLong);
              if (paramInt != 0) {
                ((czo)localObject2).FIM = ((a.c.a)paramObject).yfn;
              }
            }
            if (paramInt != 4) {
              break label764;
            }
            if ((paramdaa == null) || ((paramdaa.FIZ == 0) && (paramdaa.FJb == 0L)))
            {
              AppMethodBeat.o(95603);
              return localdap;
            }
            paramObject = new daq();
            paramObject.FIZ = paramdaa.FIZ;
            try
            {
              paramdaa = paramObject.toByteArray();
              localdap.FqS = new SKBuiltinBuffer_t().setBuffer(paramdaa);
            }
            catch (Exception paramdaa)
            {
              ac.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdaa, "", new Object[0]);
            }
          }
          break;
          label764:
          if (paramInt == 10)
          {
            paramdaa = new daz();
            if ((paramObject instanceof com.tencent.mm.bw.b))
            {
              paramObject = (com.tencent.mm.bw.b)paramObject;
              paramdaa.FKg = z.al(paramObject.xy);
              ac.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + paramObject.xy.length);
            }
            for (;;)
            {
              try
              {
                paramdaa = paramdaa.toByteArray();
                localdap.FqS = new SKBuiltinBuffer_t().setBuffer(paramdaa);
                ac.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + paramdaa.length);
              }
              catch (Exception paramdaa)
              {
                ac.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + paramdaa.getMessage());
                ac.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdaa, "", new Object[0]);
              }
              break;
              ac.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
          }
          if (paramInt != 12) {
            break;
          }
          if (!(paramObject instanceof dam)) {
            break label1020;
          }
          paramdaa = (dam)paramObject;
          try
          {
            localdap.FqS = z.al(paramdaa.toByteArray());
            ac.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + paramdaa.FJE);
          }
          catch (Exception paramdaa)
          {
            ac.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + paramdaa.getMessage());
          }
        }
        break;
        label1020:
        ac.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(95605);
    this.callback = paramg;
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
    ac.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
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
        af.dHQ().xp(this.xRB);
        continue;
        af.dHQ().xr(this.xRB);
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
          af.dHQ().dHs();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95606);
          return;
          af.dHQ().xp(this.xRB);
          af.dHR().delete(this.xRB);
          paramq = (dat)((com.tencent.mm.ak.b)paramq).hvs.hvw;
          if (paramq.FJM == 1)
          {
            af.dHV().v(af.dHx(), paramq.FJO);
            continue;
            paramq = af.dHR().xK(this.xRB);
            if (paramq != null)
            {
              paramq.field_pravited = 1;
              paramq.dMo();
              af.dHR().b(this.xRB, paramq);
              continue;
              paramq = af.dHR().xK(this.xRB);
              if (paramq != null)
              {
                paramq.field_pravited = 0;
                paramq.field_localPrivate = 0;
                paramq.dMr();
                af.dHR().b(this.xRB, paramq);
                continue;
                af.dHQ().xr(this.xRB);
              }
            }
          }
        }
        paramArrayOfByte = af.dHR().xK(this.xRB);
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
        paramq = (daa)localIterator.next();
        if ((this.xRC == null) || (paramq.FIZ != this.xRC.FIZ)) {
          continue;
        }
        if (paramq != null) {
          localSnsObject.CommentUserList.remove(paramq);
        }
        paramArrayOfByte.bB(localSnsObject.toByteArray());
        af.dHR().K(paramArrayOfByte);
        af.dHW().i(paramArrayOfByte.field_snsId, this.xRC.FIZ, this.xRC.ndI);
      }
      catch (Exception paramq)
      {
        ac.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
      }
      break;
      paramArrayOfByte = af.dHU().xB(this.xRB);
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
          paramq = (daa)localIterator.next();
          if ((this.xRC == null) || (paramq.FJb != this.xRC.FJb)) {
            continue;
          }
          if (paramq != null) {
            localSnsObject.CommentUserList.remove(paramq);
          }
          paramArrayOfByte.bB(localSnsObject.toByteArray());
          af.dHU().replace(paramArrayOfByte);
          af.dHW().i(paramArrayOfByte.field_snsId, this.xRC.FJb, this.xRC.ndI);
        }
        catch (Exception paramq)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
        }
        break;
        af.dHQ().xr(this.xRB);
        break;
        if ((this.xRD != null) && ((this.xRD instanceof a.c.a)) && (((a.c.a)this.xRD).yfn == a.c.a.yfj)) {
          break;
        }
        af.dHU().delete(this.xRB);
        af.dHW().xF(this.xRB);
        i.xE(this.xRB);
        break;
        paramq = af.dHR().xK(this.xRB);
        if (paramq == null) {
          break;
        }
        paramq.Pf(2);
        af.dHR().b(this.xRB, paramq);
        break;
        ac.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.xRE);
        label951:
        int i;
        int j;
        if (this.xRE == 0)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHT, Boolean.TRUE);
          com.tencent.mm.kernel.g.agS();
          paramInt1 = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHV, Integer.valueOf(0))).intValue();
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHV, Integer.valueOf(paramInt1 + 1));
          com.tencent.mm.kernel.g.agS();
          i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GHW, Integer.valueOf(0))).intValue();
          if (this.xRE != 0) {
            break label1165;
          }
          i += 1;
          j = i * 2 + 198;
          paramInt1 = j;
          if (j >= 216) {
            paramInt1 = 216;
          }
          if (paramInt1 >= 200) {
            com.tencent.mm.plugin.sns.lucky.a.b.lA(paramInt1);
          }
          ac.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + paramInt1 + " " + i);
          paramInt1 = i;
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHW, Integer.valueOf(paramInt1));
          break;
          if (this.xRE != 1) {
            break label951;
          }
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GHT, Boolean.FALSE);
          break label951;
          label1165:
          paramInt1 = i;
          if (this.xRE == 1)
          {
            i += 1;
            j = i * 2 + 198 + 1;
            paramInt1 = j;
            if (j >= 217) {
              paramInt1 = 217;
            }
            if (paramInt1 >= 201) {
              com.tencent.mm.plugin.sns.lucky.a.b.lA(paramInt1);
            }
            ac.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + paramInt1 + " " + i);
            paramInt1 = i;
          }
        }
        if ((this.xRD == null) || (!(this.xRD instanceof dam))) {
          break;
        }
        if (((dam)this.xRD).FJE == 1) {}
        for (boolean bool = true;; bool = false)
        {
          af.dHW().E(this.xRB, bool);
          ac.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[] { Long.valueOf(this.xRB), Boolean.valueOf(bool) });
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