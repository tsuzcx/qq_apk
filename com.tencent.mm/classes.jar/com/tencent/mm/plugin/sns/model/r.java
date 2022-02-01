package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dfs;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.protocal.protobuf.dga;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dgw;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.dha;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.eby;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends n
  implements com.tencent.mm.network.k
{
  public com.tencent.mm.ak.f callback;
  public int dKr;
  private aq handler;
  private com.tencent.mm.ak.b rr;
  public int type;
  public long zyk;
  public dgh zyl;
  private Object zym;
  private int zyn;
  
  public r(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, null, null);
  }
  
  public r(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(95602);
    this.type = -1;
    this.zyk = 0L;
    this.dKr = -1;
    this.zyn = 0;
    this.handler = new aq(Looper.getMainLooper());
    this.zyl = null;
    this.type = 9;
    this.zyk = paramLong;
    ae.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + this.type);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new dgz();
    ((b.a)localObject1).hQG = new dha();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    ((b.a)localObject1).funcId = 218;
    ((b.a)localObject1).hQH = 104;
    ((b.a)localObject1).respCmdId = 1000000104;
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (dgz)this.rr.hQD.hQJ;
    Object localObject2 = ah.dXE().AG(paramLong);
    if (localObject2 != null) {
      this.dKr = ((p)localObject2).AdJ;
    }
    localObject2 = U(paramLong, this.type);
    dgy localdgy = new dgy();
    localdgy.Scene = paramInt1;
    localdgy.HNS = paramInt2;
    localdgy.HNT = z.Jw(paramString);
    try
    {
      paramString = localdgy.toByteArray();
      ((dgw)localObject2).Huc = new SKBuiltinBuffer_t().setBuffer(paramString);
      paramString = new LinkedList();
      paramString.add(localObject2);
      ((dgz)localObject1).HNV = paramString;
      ((dgz)localObject1).HNU = paramString.size();
      AppMethodBeat.o(95602);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramString, "", new Object[0]);
      }
    }
  }
  
  public r(long paramLong, int paramInt, dgh paramdgh)
  {
    this(paramLong, paramInt, paramdgh, null);
  }
  
  private r(long paramLong, int paramInt, dgh paramdgh, Object paramObject)
  {
    AppMethodBeat.i(95601);
    this.type = -1;
    this.zyk = 0L;
    this.dKr = -1;
    this.zyn = 0;
    this.handler = new aq(Looper.getMainLooper());
    this.zyl = paramdgh;
    this.type = paramInt;
    this.zyk = paramLong;
    this.zym = paramObject;
    ae.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + paramInt);
    if (paramdgh != null) {
      ae.i("MicroMsg.NetSceneSnsObjectOp", paramdgh.HNk + " " + paramdgh.HNm);
    }
    paramdgh = new b.a();
    paramdgh.hQF = new dgz();
    paramdgh.hQG = new dha();
    paramdgh.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    paramdgh.funcId = 218;
    paramdgh.hQH = 104;
    paramdgh.respCmdId = 1000000104;
    this.rr = paramdgh.aDS();
    paramdgh = (dgz)this.rr.hQD.hQJ;
    Object localObject = ah.dXE().AG(paramLong);
    if (localObject != null) {
      this.dKr = ((p)localObject).AdJ;
    }
    paramObject = a(paramLong, paramInt, this.zyl, paramObject);
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramObject);
    paramdgh.HNV = ((LinkedList)localObject);
    paramdgh.HNU = ((LinkedList)localObject).size();
    if (paramInt == 1) {
      try
      {
        paramObject = new eby();
        paramObject.Ihs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.wJt.dye());
        paramdgh.FSj = new SKBuiltinBuffer_t().setBuffer(paramObject.toByteArray());
        AppMethodBeat.o(95601);
        return;
      }
      catch (Throwable paramdgh) {}
    }
    AppMethodBeat.o(95601);
  }
  
  public r(long paramLong, int paramInt, Object paramObject)
  {
    this(paramLong, paramInt, null, paramObject);
  }
  
  private static dgw U(long paramLong, int paramInt)
  {
    AppMethodBeat.i(95604);
    dgw localdgw = new dgw();
    localdgw.Huc = new SKBuiltinBuffer_t();
    localdgw.Id = paramLong;
    localdgw.gvx = paramInt;
    AppMethodBeat.o(95604);
    return localdgw;
  }
  
  private static dgw a(long paramLong, int paramInt, dgh paramdgh, Object paramObject)
  {
    AppMethodBeat.i(95603);
    dgw localdgw = U(paramLong, paramInt);
    Object localObject2 = new StringBuilder("getSnsObjectOp ").append(paramInt).append(" ");
    Object localObject1;
    if (paramObject == null)
    {
      localObject1 = "";
      ae.i("MicroMsg.NetSceneSnsObjectOp", (String)localObject1);
      localObject2 = "";
      if ((paramInt != 8) && (paramInt != 10) && (paramInt != 7) && (paramInt != 8) && (paramInt != 6)) {
        break label1046;
      }
      localObject1 = ah.dXH().Ax(paramLong);
      if (localObject1 == null) {
        break label1040;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).ebV();
      label113:
      if ((localObject1 == null) || (!((p)localObject1).Rt(32))) {
        break label1037;
      }
      localObject2 = ((p)localObject1).dVi();
      if (localObject2 != null) {
        break label205;
      }
      localObject2 = "";
      label144:
      ae.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo ".concat(String.valueOf(localObject2)));
    }
    for (;;)
    {
      if (paramInt == 6)
      {
        if ((paramdgh == null) || ((paramdgh.HNk == 0) && (paramdgh.HNm == 0L)))
        {
          AppMethodBeat.o(95603);
          return localdgw;
          localObject1 = paramObject.toString();
          break;
          label205:
          localObject2 = ((a)localObject2).dGD;
          break label144;
        }
        paramObject = new dga();
        paramObject.HNg = paramdgh.HNm;
        paramObject.HMU = z.Jw(bu.bI((String)localObject2, ""));
      }
      for (;;)
      {
        try
        {
          paramdgh = paramObject.toByteArray();
          localdgw.Huc = new SKBuiltinBuffer_t().setBuffer(paramdgh);
          AppMethodBeat.o(95603);
          return localdgw;
        }
        catch (Exception paramdgh)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdgh, "", new Object[0]);
          continue;
        }
        if (paramInt != 7) {
          break;
        }
        paramdgh = new dfs();
        paramdgh.HMU = z.Jw(bu.bI((String)localObject2, ""));
        try
        {
          paramdgh = paramdgh.toByteArray();
          localdgw.Huc = new SKBuiltinBuffer_t().setBuffer(paramdgh);
        }
        catch (Exception paramdgh)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdgh, "", new Object[0]);
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
          paramdgh = (a.c.a)paramObject;
          localObject2 = bu.bI((String)localObject2, "");
        }
      }
      label1031:
      for (paramdgh = (String)localObject2 + new StringBuilder("&").append(paramdgh.zte).append("|").append(paramdgh.zML).toString();; paramdgh = (dgh)localObject2)
      {
        for (;;)
        {
          for (;;)
          {
            localObject2 = new dfv();
            ((dfv)localObject2).HMU = z.Jw(bu.bI(paramdgh, ""));
            if (localObject1 != null)
            {
              ((dfv)localObject2).ucK = ((p)localObject1).ecz();
              paramdgh = ((p)localObject1).getSnsId();
              localObject1 = ah.dXE().aBq(paramdgh);
              if (localObject1 != null)
              {
                paramdgh = com.tencent.mm.plugin.sns.ad.e.i.b(((p)localObject1).ebP());
                label522:
                ((dfv)localObject2).HMW = z.Jw(bu.bI(paramdgh, ""));
              }
            }
            else
            {
              if ((paramInt == 0) || (((a.c.a)paramObject).zMK != a.c.a.zMG)) {
                break label631;
              }
              ((dfv)localObject2).HMX = a.c.a.zMG;
            }
            for (;;)
            {
              try
              {
                paramdgh = ((dfv)localObject2).toByteArray();
                localdgw.Huc = new SKBuiltinBuffer_t().setBuffer(paramdgh);
              }
              catch (Exception paramdgh)
              {
                ae.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdgh, "", new Object[0]);
              }
              break;
              paramInt = 0;
              break label384;
              ae.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { paramdgh });
              paramdgh = "";
              break label522;
              label631:
              ah.dXH().delete(paramLong);
              ah.dXJ().AB(paramLong);
              com.tencent.mm.plugin.sns.storage.i.AA(paramLong);
              if (paramInt != 0) {
                ((dfv)localObject2).HMX = ((a.c.a)paramObject).zMK;
              }
            }
            if (paramInt != 4) {
              break label764;
            }
            if ((paramdgh == null) || ((paramdgh.HNk == 0) && (paramdgh.HNm == 0L)))
            {
              AppMethodBeat.o(95603);
              return localdgw;
            }
            paramObject = new dgx();
            paramObject.HNk = paramdgh.HNk;
            try
            {
              paramdgh = paramObject.toByteArray();
              localdgw.Huc = new SKBuiltinBuffer_t().setBuffer(paramdgh);
            }
            catch (Exception paramdgh)
            {
              ae.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdgh, "", new Object[0]);
            }
          }
          break;
          label764:
          if (paramInt == 10)
          {
            paramdgh = new dhg();
            if ((paramObject instanceof com.tencent.mm.bw.b))
            {
              paramObject = (com.tencent.mm.bw.b)paramObject;
              paramdgh.HOr = z.al(paramObject.zr);
              ae.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + paramObject.zr.length);
            }
            for (;;)
            {
              try
              {
                paramdgh = paramdgh.toByteArray();
                localdgw.Huc = new SKBuiltinBuffer_t().setBuffer(paramdgh);
                ae.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + paramdgh.length);
              }
              catch (Exception paramdgh)
              {
                ae.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + paramdgh.getMessage());
                ae.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramdgh, "", new Object[0]);
              }
              break;
              ae.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
          }
          if (paramInt != 12) {
            break;
          }
          if (!(paramObject instanceof dgt)) {
            break label1020;
          }
          paramdgh = (dgt)paramObject;
          try
          {
            localdgw.Huc = z.al(paramdgh.toByteArray());
            ae.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + paramdgh.HNP);
          }
          catch (Exception paramdgh)
          {
            ae.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + paramdgh.getMessage());
          }
        }
        break;
        label1020:
        ae.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
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
        ah.dXD().Am(this.zyk);
        continue;
        ah.dXD().Ao(this.zyk);
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
          ah.dXD().dXe();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(95606);
          return;
          ah.dXD().Am(this.zyk);
          ah.dXE().delete(this.zyk);
          paramq = (dha)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
          if (paramq.HNX == 1)
          {
            ah.dXI().y(ah.dXj(), paramq.HNZ);
            continue;
            paramq = ah.dXE().AG(this.zyk);
            if (paramq != null)
            {
              paramq.field_pravited = 1;
              paramq.eci();
              ah.dXE().b(this.zyk, paramq);
              continue;
              paramq = ah.dXE().AG(this.zyk);
              if (paramq != null)
              {
                paramq.field_pravited = 0;
                paramq.field_localPrivate = 0;
                paramq.ecl();
                ah.dXE().b(this.zyk, paramq);
                continue;
                ah.dXD().Ao(this.zyk);
              }
            }
          }
        }
        paramArrayOfByte = ah.dXE().AG(this.zyk);
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
        paramq = (dgh)localIterator.next();
        if ((this.zyl == null) || (paramq.HNk != this.zyl.HNk)) {
          continue;
        }
        if (paramq != null) {
          localSnsObject.CommentUserList.remove(paramq);
        }
        paramArrayOfByte.bL(localSnsObject.toByteArray());
        ah.dXE().M(paramArrayOfByte);
        ah.dXJ().i(paramArrayOfByte.field_snsId, this.zyl.HNk, this.zyl.nJA);
      }
      catch (Exception paramq)
      {
        ae.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
      }
      break;
      paramArrayOfByte = ah.dXH().Ax(this.zyk);
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
          paramq = (dgh)localIterator.next();
          if ((this.zyl == null) || (paramq.HNm != this.zyl.HNm)) {
            continue;
          }
          if (paramq != null) {
            localSnsObject.CommentUserList.remove(paramq);
          }
          paramArrayOfByte.bL(localSnsObject.toByteArray());
          ah.dXH().replace(paramArrayOfByte);
          ah.dXJ().i(paramArrayOfByte.field_snsId, this.zyl.HNm, this.zyl.nJA);
        }
        catch (Exception paramq)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
        }
        break;
        ah.dXD().Ao(this.zyk);
        break;
        if ((this.zym != null) && ((this.zym instanceof a.c.a)) && (((a.c.a)this.zym).zMK == a.c.a.zMG)) {
          break;
        }
        ah.dXH().delete(this.zyk);
        ah.dXJ().AB(this.zyk);
        com.tencent.mm.plugin.sns.storage.i.AA(this.zyk);
        break;
        paramq = ah.dXE().AG(this.zyk);
        if (paramq == null) {
          break;
        }
        paramq.Ru(2);
        ah.dXE().b(this.zyk, paramq);
        break;
        ae.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.zyn);
        label951:
        int i;
        int j;
        if (this.zyn == 0)
        {
          g.ajS();
          g.ajR().ajA().set(am.a.IOI, Boolean.TRUE);
          g.ajS();
          paramInt1 = ((Integer)g.ajR().ajA().get(am.a.IOK, Integer.valueOf(0))).intValue();
          g.ajS();
          g.ajR().ajA().set(am.a.IOK, Integer.valueOf(paramInt1 + 1));
          g.ajS();
          i = ((Integer)g.ajR().ajA().get(am.a.IOL, Integer.valueOf(0))).intValue();
          if (this.zyn != 0) {
            break label1165;
          }
          i += 1;
          j = i * 2 + 198;
          paramInt1 = j;
          if (j >= 216) {
            paramInt1 = 216;
          }
          if (paramInt1 >= 200) {
            com.tencent.mm.plugin.sns.lucky.a.b.md(paramInt1);
          }
          ae.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + paramInt1 + " " + i);
          paramInt1 = i;
        }
        for (;;)
        {
          g.ajS();
          g.ajR().ajA().set(am.a.IOL, Integer.valueOf(paramInt1));
          break;
          if (this.zyn != 1) {
            break label951;
          }
          g.ajS();
          g.ajR().ajA().set(am.a.IOI, Boolean.FALSE);
          break label951;
          label1165:
          paramInt1 = i;
          if (this.zyn == 1)
          {
            i += 1;
            j = i * 2 + 198 + 1;
            paramInt1 = j;
            if (j >= 217) {
              paramInt1 = 217;
            }
            if (paramInt1 >= 201) {
              com.tencent.mm.plugin.sns.lucky.a.b.md(paramInt1);
            }
            ae.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + paramInt1 + " " + i);
            paramInt1 = i;
          }
        }
        if ((this.zym == null) || (!(this.zym instanceof dgt))) {
          break;
        }
        if (((dgt)this.zym).HNP == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ah.dXJ().G(this.zyk, bool);
          ae.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[] { Long.valueOf(this.zyk), Boolean.valueOf(bool) });
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
 * Qualified Name:     com.tencent.mm.plugin.sns.model.r
 * JD-Core Version:    0.7.0.1
 */