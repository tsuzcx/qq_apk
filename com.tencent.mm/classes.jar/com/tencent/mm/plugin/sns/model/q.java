package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class q
  extends n
  implements com.tencent.mm.network.k
{
  public com.tencent.mm.al.g callback;
  public int dzf;
  private ap handler;
  private com.tencent.mm.al.b rr;
  public int type;
  private long wFg;
  private cuo wFh;
  private Object wFi;
  private int wFj;
  
  public q(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, null, null);
  }
  
  public q(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(95602);
    this.type = -1;
    this.wFg = 0L;
    this.dzf = -1;
    this.wFj = 0;
    this.handler = new ap(Looper.getMainLooper());
    this.wFh = null;
    this.type = 9;
    this.wFg = paramLong;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + this.type);
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new cvg();
    ((b.a)localObject1).gUV = new cvh();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    ((b.a)localObject1).funcId = 218;
    ((b.a)localObject1).reqCmdId = 104;
    ((b.a)localObject1).respCmdId = 1000000104;
    this.rr = ((b.a)localObject1).atI();
    localObject1 = (cvg)this.rr.gUS.gUX;
    Object localObject2 = af.dtu().th(paramLong);
    if (localObject2 != null) {
      this.dzf = ((p)localObject2).xiB;
    }
    localObject2 = M(paramLong, this.type);
    cvf localcvf = new cvf();
    localcvf.Scene = paramInt1;
    localcvf.EmI = paramInt2;
    localcvf.EmJ = z.BE(paramString);
    try
    {
      paramString = localcvf.toByteArray();
      ((cvd)localObject2).DUf = new SKBuiltinBuffer_t().setBuffer(paramString);
      paramString = new LinkedList();
      paramString.add(localObject2);
      ((cvg)localObject1).EmL = paramString;
      ((cvg)localObject1).EmK = paramString.size();
      AppMethodBeat.o(95602);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramString, "", new Object[0]);
      }
    }
  }
  
  public q(long paramLong, int paramInt, cuo paramcuo)
  {
    this(paramLong, paramInt, paramcuo, null);
  }
  
  private q(long paramLong, int paramInt, cuo paramcuo, Object paramObject)
  {
    AppMethodBeat.i(95601);
    this.type = -1;
    this.wFg = 0L;
    this.dzf = -1;
    this.wFj = 0;
    this.handler = new ap(Looper.getMainLooper());
    this.wFh = paramcuo;
    this.type = paramInt;
    this.wFg = paramLong;
    this.wFi = paramObject;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + paramInt);
    if (paramcuo != null) {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", paramcuo.Ema + " " + paramcuo.Emc);
    }
    paramcuo = new b.a();
    paramcuo.gUU = new cvg();
    paramcuo.gUV = new cvh();
    paramcuo.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    paramcuo.funcId = 218;
    paramcuo.reqCmdId = 104;
    paramcuo.respCmdId = 1000000104;
    this.rr = paramcuo.atI();
    paramcuo = (cvg)this.rr.gUS.gUX;
    Object localObject = af.dtu().th(paramLong);
    if (localObject != null) {
      this.dzf = ((p)localObject).xiB;
    }
    paramObject = a(paramLong, paramInt, this.wFh, paramObject);
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramObject);
    paramcuo.EmL = ((LinkedList)localObject);
    paramcuo.EmK = ((LinkedList)localObject).size();
    AppMethodBeat.o(95601);
  }
  
  public q(long paramLong, int paramInt, Object paramObject)
  {
    this(paramLong, paramInt, null, paramObject);
  }
  
  private static cvd M(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95604);
    cvd localcvd = new cvd();
    localcvd.DUf = new SKBuiltinBuffer_t();
    localcvd.Id = paramLong;
    localcvd.fVE = paramInt;
    AppMethodBeat.o(95604);
    return localcvd;
  }
  
  private static cvd a(long paramLong, int paramInt, cuo paramcuo, Object paramObject)
  {
    AppMethodBeat.i(95603);
    cvd localcvd = M(paramLong, paramInt);
    Object localObject2 = new StringBuilder("getSnsObjectOp ").append(paramInt).append(" ");
    Object localObject1;
    if (paramObject == null)
    {
      localObject1 = "";
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", (String)localObject1);
      localObject2 = "";
      if ((paramInt != 8) && (paramInt != 10) && (paramInt != 7) && (paramInt != 8) && (paramInt != 6)) {
        break label1046;
      }
      localObject1 = af.dtx().sY(paramLong);
      if (localObject1 == null) {
        break label1040;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).dxE();
      label113:
      if ((localObject1 == null) || (!((p)localObject1).Nb(32))) {
        break label1037;
      }
      localObject2 = ((p)localObject1).dxu();
      if (localObject2 != null) {
        break label205;
      }
      localObject2 = "";
      label144:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo ".concat(String.valueOf(localObject2)));
    }
    for (;;)
    {
      if (paramInt == 6)
      {
        if ((paramcuo == null) || ((paramcuo.Ema == 0) && (paramcuo.Emc == 0L)))
        {
          AppMethodBeat.o(95603);
          return localcvd;
          localObject1 = paramObject.toString();
          break;
          label205:
          localObject2 = ((a)localObject2).dvK;
          break label144;
        }
        paramObject = new cuh();
        paramObject.ElW = paramcuo.Emc;
        paramObject.ElK = z.BE(bt.by((String)localObject2, ""));
      }
      for (;;)
      {
        try
        {
          paramcuo = paramObject.toByteArray();
          localcvd.DUf = new SKBuiltinBuffer_t().setBuffer(paramcuo);
          AppMethodBeat.o(95603);
          return localcvd;
        }
        catch (Exception paramcuo)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcuo, "", new Object[0]);
          continue;
        }
        if (paramInt != 7) {
          break;
        }
        paramcuo = new ctz();
        paramcuo.ElK = z.BE(bt.by((String)localObject2, ""));
        try
        {
          paramcuo = paramcuo.toByteArray();
          localcvd.DUf = new SKBuiltinBuffer_t().setBuffer(paramcuo);
        }
        catch (Exception paramcuo)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcuo, "", new Object[0]);
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
          paramcuo = (a.c.a)paramObject;
          localObject2 = bt.by((String)localObject2, "");
        }
      }
      label1031:
      for (paramcuo = (String)localObject2 + new StringBuilder("&").append(paramcuo.wAf).append("|").append(paramcuo.wSE).toString();; paramcuo = (cuo)localObject2)
      {
        for (;;)
        {
          for (;;)
          {
            localObject2 = new cuc();
            ((cuc)localObject2).ElK = z.BE(bt.by(paramcuo, ""));
            if (localObject1 != null)
            {
              ((cuc)localObject2).rNz = ((p)localObject1).dyi();
              paramcuo = ((p)localObject1).getSnsId();
              localObject1 = af.dtu().apJ(paramcuo);
              if (localObject1 != null)
              {
                paramcuo = h.b(((p)localObject1).dxy());
                label522:
                ((cuc)localObject2).ElM = z.BE(bt.by(paramcuo, ""));
              }
            }
            else
            {
              if ((paramInt == 0) || (((a.c.a)paramObject).wSD != a.c.a.wSz)) {
                break label631;
              }
              ((cuc)localObject2).ElN = a.c.a.wSz;
            }
            for (;;)
            {
              try
              {
                paramcuo = ((cuc)localObject2).toByteArray();
                localcvd.DUf = new SKBuiltinBuffer_t().setBuffer(paramcuo);
              }
              catch (Exception paramcuo)
              {
                com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcuo, "", new Object[0]);
              }
              break;
              paramInt = 0;
              break label384;
              com.tencent.mm.sdk.platformtools.ad.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { paramcuo });
              paramcuo = "";
              break label522;
              label631:
              af.dtx().delete(paramLong);
              af.dtz().tc(paramLong);
              i.tb(paramLong);
              if (paramInt != 0) {
                ((cuc)localObject2).ElN = ((a.c.a)paramObject).wSD;
              }
            }
            if (paramInt != 4) {
              break label764;
            }
            if ((paramcuo == null) || ((paramcuo.Ema == 0) && (paramcuo.Emc == 0L)))
            {
              AppMethodBeat.o(95603);
              return localcvd;
            }
            paramObject = new cve();
            paramObject.Ema = paramcuo.Ema;
            try
            {
              paramcuo = paramObject.toByteArray();
              localcvd.DUf = new SKBuiltinBuffer_t().setBuffer(paramcuo);
            }
            catch (Exception paramcuo)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcuo, "", new Object[0]);
            }
          }
          break;
          label764:
          if (paramInt == 10)
          {
            paramcuo = new cvn();
            if ((paramObject instanceof com.tencent.mm.bx.b))
            {
              paramObject = (com.tencent.mm.bx.b)paramObject;
              paramcuo.Enh = z.am(paramObject.wA);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + paramObject.wA.length);
            }
            for (;;)
            {
              try
              {
                paramcuo = paramcuo.toByteArray();
                localcvd.DUf = new SKBuiltinBuffer_t().setBuffer(paramcuo);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + paramcuo.length);
              }
              catch (Exception paramcuo)
              {
                com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + paramcuo.getMessage());
                com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcuo, "", new Object[0]);
              }
              break;
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
          }
          if (paramInt != 12) {
            break;
          }
          if (!(paramObject instanceof cva)) {
            break label1020;
          }
          paramcuo = (cva)paramObject;
          try
          {
            localcvd.DUf = z.am(paramcuo.toByteArray());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + paramcuo.EmF);
          }
          catch (Exception paramcuo)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + paramcuo.getMessage());
          }
        }
        break;
        label1020:
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
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
        af.dtt().sM(this.wFg);
        continue;
        af.dtt().sO(this.wFg);
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
          af.dtt().dsV();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95606);
          return;
          af.dtt().sM(this.wFg);
          af.dtu().delete(this.wFg);
          paramq = (cvh)((com.tencent.mm.al.b)paramq).gUT.gUX;
          if (paramq.EmN == 1)
          {
            af.dty().x(af.dta(), paramq.EmP);
            continue;
            paramq = af.dtu().th(this.wFg);
            if (paramq != null)
            {
              paramq.field_pravited = 1;
              paramq.dxR();
              af.dtu().b(this.wFg, paramq);
              continue;
              paramq = af.dtu().th(this.wFg);
              if (paramq != null)
              {
                paramq.field_pravited = 0;
                paramq.field_localPrivate = 0;
                paramq.dxU();
                af.dtu().b(this.wFg, paramq);
                continue;
                af.dtt().sO(this.wFg);
              }
            }
          }
        }
        paramArrayOfByte = af.dtu().th(this.wFg);
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
        paramq = (cuo)localIterator.next();
        if ((this.wFh == null) || (paramq.Ema != this.wFh.Ema)) {
          continue;
        }
        if (paramq != null) {
          localSnsObject.CommentUserList.remove(paramq);
        }
        paramArrayOfByte.bC(localSnsObject.toByteArray());
        af.dtu().J(paramArrayOfByte);
        af.dtz().i(paramArrayOfByte.field_snsId, this.wFh.Ema, this.wFh.mBH);
      }
      catch (Exception paramq)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
      }
      break;
      paramArrayOfByte = af.dtx().sY(this.wFg);
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
          paramq = (cuo)localIterator.next();
          if ((this.wFh == null) || (paramq.Emc != this.wFh.Emc)) {
            continue;
          }
          if (paramq != null) {
            localSnsObject.CommentUserList.remove(paramq);
          }
          paramArrayOfByte.bC(localSnsObject.toByteArray());
          af.dtx().replace(paramArrayOfByte);
          af.dtz().i(paramArrayOfByte.field_snsId, this.wFh.Emc, this.wFh.mBH);
        }
        catch (Exception paramq)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
        }
        break;
        af.dtt().sO(this.wFg);
        break;
        if ((this.wFi != null) && ((this.wFi instanceof a.c.a)) && (((a.c.a)this.wFi).wSD == a.c.a.wSz)) {
          break;
        }
        af.dtx().delete(this.wFg);
        af.dtz().tc(this.wFg);
        i.tb(this.wFg);
        break;
        paramq = af.dtu().th(this.wFg);
        if (paramq == null) {
          break;
        }
        paramq.Nc(2);
        af.dtu().b(this.wFg, paramq);
        break;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.wFj);
        label951:
        int i;
        int j;
        if (this.wFj == 0)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fke, Boolean.TRUE);
          com.tencent.mm.kernel.g.afC();
          paramInt1 = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fkg, Integer.valueOf(0))).intValue();
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fkg, Integer.valueOf(paramInt1 + 1));
          com.tencent.mm.kernel.g.afC();
          i = ((Integer)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fkh, Integer.valueOf(0))).intValue();
          if (this.wFj != 0) {
            break label1165;
          }
          i += 1;
          j = i * 2 + 198;
          paramInt1 = j;
          if (j >= 216) {
            paramInt1 = 216;
          }
          if (paramInt1 >= 200) {
            com.tencent.mm.plugin.sns.lucky.a.b.lI(paramInt1);
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + paramInt1 + " " + i);
          paramInt1 = i;
        }
        for (;;)
        {
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fkh, Integer.valueOf(paramInt1));
          break;
          if (this.wFj != 1) {
            break label951;
          }
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fke, Boolean.FALSE);
          break label951;
          label1165:
          paramInt1 = i;
          if (this.wFj == 1)
          {
            i += 1;
            j = i * 2 + 198 + 1;
            paramInt1 = j;
            if (j >= 217) {
              paramInt1 = 217;
            }
            if (paramInt1 >= 201) {
              com.tencent.mm.plugin.sns.lucky.a.b.lI(paramInt1);
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + paramInt1 + " " + i);
            paramInt1 = i;
          }
        }
        if ((this.wFi == null) || (!(this.wFi instanceof cva))) {
          break;
        }
        if (((cva)this.wFi).EmF == 1) {}
        for (boolean bool = true;; bool = false)
        {
          af.dtz().E(this.wFg, bool);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[] { Long.valueOf(this.wFg), Boolean.valueOf(bool) });
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