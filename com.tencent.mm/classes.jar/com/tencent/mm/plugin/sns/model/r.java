package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cdd;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.cdl;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.ced;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.ceh;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class r
  extends m
  implements com.tencent.mm.network.k
{
  public int cIp;
  public com.tencent.mm.ai.f callback;
  private ak handler;
  private long reI;
  private cds reJ;
  private Object reK;
  private int reL;
  private com.tencent.mm.ai.b rr;
  public int type;
  
  public r(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, null, null);
  }
  
  public r(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(36277);
    this.type = -1;
    this.reI = 0L;
    this.cIp = -1;
    this.reL = 0;
    this.handler = new ak(Looper.getMainLooper());
    this.reJ = null;
    this.type = 9;
    this.reI = paramLong;
    ab.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + this.type);
    Object localObject1 = new b.a();
    ((b.a)localObject1).fsX = new cej();
    ((b.a)localObject1).fsY = new cek();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    ((b.a)localObject1).funcId = 218;
    ((b.a)localObject1).reqCmdId = 104;
    ((b.a)localObject1).respCmdId = 1000000104;
    this.rr = ((b.a)localObject1).ado();
    localObject1 = (cej)this.rr.fsV.fta;
    Object localObject2 = ag.cpf().lZ(paramLong);
    if (localObject2 != null) {
      this.cIp = ((n)localObject2).rCV;
    }
    localObject2 = D(paramLong, this.type);
    cei localcei = new cei();
    localcei.Scene = paramInt1;
    localcei.xOG = paramInt2;
    localcei.xOH = aa.wA(paramString);
    try
    {
      paramString = localcei.toByteArray();
      ((ceg)localObject2).xyz = new SKBuiltinBuffer_t().setBuffer(paramString);
      paramString = new LinkedList();
      paramString.add(localObject2);
      ((cej)localObject1).xOJ = paramString;
      ((cej)localObject1).xOI = paramString.size();
      AppMethodBeat.o(36277);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramString, "", new Object[0]);
      }
    }
  }
  
  public r(long paramLong, int paramInt, cds paramcds)
  {
    this(paramLong, paramInt, paramcds, null);
  }
  
  private r(long paramLong, int paramInt, cds paramcds, Object paramObject)
  {
    AppMethodBeat.i(36276);
    this.type = -1;
    this.reI = 0L;
    this.cIp = -1;
    this.reL = 0;
    this.handler = new ak(Looper.getMainLooper());
    this.reJ = paramcds;
    this.type = paramInt;
    this.reI = paramLong;
    this.reK = paramObject;
    ab.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + paramLong + "  op : " + paramInt);
    if (paramcds != null) {
      ab.i("MicroMsg.NetSceneSnsObjectOp", paramcds.xNY + " " + paramcds.xOa);
    }
    paramcds = new b.a();
    paramcds.fsX = new cej();
    paramcds.fsY = new cek();
    paramcds.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
    paramcds.funcId = 218;
    paramcds.reqCmdId = 104;
    paramcds.respCmdId = 1000000104;
    this.rr = paramcds.ado();
    paramcds = (cej)this.rr.fsV.fta;
    Object localObject = ag.cpf().lZ(paramLong);
    if (localObject != null) {
      this.cIp = ((n)localObject).rCV;
    }
    paramObject = a(paramLong, paramInt, this.reJ, paramObject);
    localObject = new LinkedList();
    ((LinkedList)localObject).add(paramObject);
    paramcds.xOJ = ((LinkedList)localObject);
    paramcds.xOI = ((LinkedList)localObject).size();
    AppMethodBeat.o(36276);
  }
  
  public r(long paramLong, int paramInt, Object paramObject)
  {
    this(paramLong, paramInt, null, paramObject);
  }
  
  private static ceg D(long paramLong, int paramInt)
  {
    AppMethodBeat.i(36279);
    ceg localceg = new ceg();
    localceg.xyz = new SKBuiltinBuffer_t();
    localceg.Id = paramLong;
    localceg.nrS = paramInt;
    AppMethodBeat.o(36279);
    return localceg;
  }
  
  private static ceg a(long paramLong, int paramInt, cds paramcds, Object paramObject)
  {
    AppMethodBeat.i(36278);
    ceg localceg = D(paramLong, paramInt);
    Object localObject2 = new StringBuilder("getSnsObjectOp ").append(paramInt).append(" ");
    Object localObject1;
    if (paramObject == null)
    {
      localObject1 = "";
      ab.i("MicroMsg.NetSceneSnsObjectOp", (String)localObject1);
      localObject2 = "";
      if ((paramInt != 8) && (paramInt != 10) && (paramInt != 7) && (paramInt != 8) && (paramInt != 6)) {
        break label1046;
      }
      localObject1 = ag.cpi().lQ(paramLong);
      if (localObject1 == null) {
        break label1040;
      }
      localObject1 = ((com.tencent.mm.plugin.sns.storage.e)localObject1).csn();
      label113:
      if ((localObject1 == null) || (!((n)localObject1).Ex(32))) {
        break label1037;
      }
      localObject2 = ((n)localObject1).csd();
      if (localObject2 != null) {
        break label205;
      }
      localObject2 = "";
      label144:
      ab.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo ".concat(String.valueOf(localObject2)));
    }
    for (;;)
    {
      if (paramInt == 6)
      {
        if ((paramcds == null) || ((paramcds.xNY == 0) && (paramcds.xOa == 0L)))
        {
          AppMethodBeat.o(36278);
          return localceg;
          localObject1 = paramObject.toString();
          break;
          label205:
          localObject2 = ((a)localObject2).cFe;
          break label144;
        }
        paramObject = new cdl();
        paramObject.xNU = paramcds.xOa;
        paramObject.xNI = aa.wA(bo.bf((String)localObject2, ""));
      }
      for (;;)
      {
        try
        {
          paramcds = paramObject.toByteArray();
          localceg.xyz = new SKBuiltinBuffer_t().setBuffer(paramcds);
          AppMethodBeat.o(36278);
          return localceg;
        }
        catch (Exception paramcds)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcds, "", new Object[0]);
          continue;
        }
        if (paramInt != 7) {
          break;
        }
        paramcds = new cdd();
        paramcds.xNI = aa.wA(bo.bf((String)localObject2, ""));
        try
        {
          paramcds = paramcds.toByteArray();
          localceg.xyz = new SKBuiltinBuffer_t().setBuffer(paramcds);
        }
        catch (Exception paramcds)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcds, "", new Object[0]);
        }
      }
      if (paramInt == 8) {
        if ((paramObject != null) && ((paramObject instanceof a.b.a)))
        {
          paramInt = 1;
          label384:
          if (paramInt == 0) {
            break label1031;
          }
          paramcds = (a.b.a)paramObject;
          localObject2 = bo.bf((String)localObject2, "");
        }
      }
      label1031:
      for (paramcds = (String)localObject2 + new StringBuilder("&").append(paramcds.rbb).append("|").append(paramcds.rpN).toString();; paramcds = (cds)localObject2)
      {
        for (;;)
        {
          for (;;)
          {
            localObject2 = new cdg();
            ((cdg)localObject2).xNI = aa.wA(bo.bf(paramcds, ""));
            if (localObject1 != null)
            {
              ((cdg)localObject2).niK = ((n)localObject1).csR();
              paramcds = ((n)localObject1).getSnsId();
              localObject1 = ag.cpf().abu(paramcds);
              if (localObject1 != null)
              {
                paramcds = com.tencent.mm.plugin.sns.a.b.f.a(((n)localObject1).csh());
                label522:
                ((cdg)localObject2).xNK = aa.wA(bo.bf(paramcds, ""));
              }
            }
            else
            {
              if ((paramInt == 0) || (((a.b.a)paramObject).rpM != a.b.a.rpI)) {
                break label631;
              }
              ((cdg)localObject2).xNL = a.b.a.rpI;
            }
            for (;;)
            {
              try
              {
                paramcds = ((cdg)localObject2).toByteArray();
                localceg.xyz = new SKBuiltinBuffer_t().setBuffer(paramcds);
              }
              catch (Exception paramcds)
              {
                ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcds, "", new Object[0]);
              }
              break;
              paramInt = 0;
              break label384;
              ab.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", new Object[] { paramcds });
              paramcds = "";
              break label522;
              label631:
              ag.cpi().delete(paramLong);
              ag.cpk().lU(paramLong);
              i.lT(paramLong);
              if (paramInt != 0) {
                ((cdg)localObject2).xNL = ((a.b.a)paramObject).rpM;
              }
            }
            if (paramInt != 4) {
              break label764;
            }
            if ((paramcds == null) || ((paramcds.xNY == 0) && (paramcds.xOa == 0L)))
            {
              AppMethodBeat.o(36278);
              return localceg;
            }
            paramObject = new ceh();
            paramObject.xNY = paramcds.xNY;
            try
            {
              paramcds = paramObject.toByteArray();
              localceg.xyz = new SKBuiltinBuffer_t().setBuffer(paramcds);
            }
            catch (Exception paramcds)
            {
              ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcds, "", new Object[0]);
            }
          }
          break;
          label764:
          if (paramInt == 10)
          {
            paramcds = new ceq();
            if ((paramObject instanceof com.tencent.mm.bv.b))
            {
              paramObject = (com.tencent.mm.bv.b)paramObject;
              paramcds.xPb = aa.ac(paramObject.pW);
              ab.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + paramObject.pW.length);
            }
            for (;;)
            {
              try
              {
                paramcds = paramcds.toByteArray();
                localceg.xyz = new SKBuiltinBuffer_t().setBuffer(paramcds);
                ab.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + paramcds.length);
              }
              catch (Exception paramcds)
              {
                ab.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + paramcds.getMessage());
                ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramcds, "", new Object[0]);
              }
              break;
              ab.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
          }
          if (paramInt != 12) {
            break;
          }
          if (!(paramObject instanceof ced)) {
            break label1020;
          }
          paramcds = (ced)paramObject;
          try
          {
            localceg.xyz = aa.ac(paramcds.toByteArray());
            ab.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + paramcds.xOD);
          }
          catch (Exception paramcds)
          {
            ab.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + paramcds.getMessage());
          }
        }
        break;
        label1020:
        ab.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(36280);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(36280);
    return i;
  }
  
  public final int getType()
  {
    return 218;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(36281);
    ab.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
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
        AppMethodBeat.o(36281);
        return;
        ag.cpe().lJ(this.reI);
        continue;
        ag.cpe().lL(this.reI);
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
          ag.cpe().coF();
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          AppMethodBeat.o(36281);
          return;
          ag.cpe().lJ(this.reI);
          ag.cpf().delete(this.reI);
          continue;
          paramq = ag.cpf().lZ(this.reI);
          if (paramq != null)
          {
            paramq.field_pravited = 1;
            paramq.csB();
            ag.cpf().b(this.reI, paramq);
            continue;
            paramq = ag.cpf().lZ(this.reI);
            if (paramq != null)
            {
              paramq.field_pravited = 0;
              paramq.field_localPrivate = 0;
              paramq.csE();
              ag.cpf().b(this.reI, paramq);
              continue;
              ag.cpe().lL(this.reI);
            }
          }
        }
        paramArrayOfByte = ag.cpf().lZ(this.reI);
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
          break label1311;
        }
        paramq = (cds)localIterator.next();
        if ((this.reJ == null) || (paramq.xNY != this.reJ.xNY)) {
          continue;
        }
        if (paramq != null) {
          localSnsObject.CommentUserList.remove(paramq);
        }
        paramArrayOfByte.bj(localSnsObject.toByteArray());
        ag.cpf().B(paramArrayOfByte);
        ag.cpk().g(paramArrayOfByte.field_snsId, this.reJ.xNY, this.reJ.jKs);
      }
      catch (Exception paramq)
      {
        ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
      }
      break;
      paramArrayOfByte = ag.cpi().lQ(this.reI);
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
            break label1305;
          }
          paramq = (cds)localIterator.next();
          if ((this.reJ == null) || (paramq.xOa != this.reJ.xOa)) {
            continue;
          }
          if (paramq != null) {
            localSnsObject.CommentUserList.remove(paramq);
          }
          paramArrayOfByte.bj(localSnsObject.toByteArray());
          ag.cpi().replace(paramArrayOfByte);
          ag.cpk().g(paramArrayOfByte.field_snsId, this.reJ.xOa, this.reJ.jKs);
        }
        catch (Exception paramq)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", paramq, "", new Object[0]);
        }
        break;
        ag.cpe().lL(this.reI);
        break;
        if ((this.reK != null) && ((this.reK instanceof a.b.a)) && (((a.b.a)this.reK).rpM == a.b.a.rpI)) {
          break;
        }
        ag.cpi().delete(this.reI);
        ag.cpk().lU(this.reI);
        i.lT(this.reI);
        break;
        paramq = ag.cpf().lZ(this.reI);
        if (paramq == null) {
          break;
        }
        paramq.Ey(2);
        ag.cpf().b(this.reI, paramq);
        break;
        ab.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.reL);
        label912:
        int i;
        int j;
        if (this.reL == 0)
        {
          g.RM();
          g.RL().Ru().set(ac.a.yBI, Boolean.TRUE);
          g.RM();
          paramInt1 = ((Integer)g.RL().Ru().get(ac.a.yBK, Integer.valueOf(0))).intValue();
          g.RM();
          g.RL().Ru().set(ac.a.yBK, Integer.valueOf(paramInt1 + 1));
          g.RM();
          i = ((Integer)g.RL().Ru().get(ac.a.yBL, Integer.valueOf(0))).intValue();
          if (this.reL != 0) {
            break label1126;
          }
          i += 1;
          j = i * 2 + 198;
          paramInt1 = j;
          if (j >= 216) {
            paramInt1 = 216;
          }
          if (paramInt1 >= 200) {
            com.tencent.mm.plugin.sns.lucky.a.b.kS(paramInt1);
          }
          ab.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + paramInt1 + " " + i);
          paramInt1 = i;
        }
        for (;;)
        {
          g.RM();
          g.RL().Ru().set(ac.a.yBL, Integer.valueOf(paramInt1));
          break;
          if (this.reL != 1) {
            break label912;
          }
          g.RM();
          g.RL().Ru().set(ac.a.yBI, Boolean.FALSE);
          break label912;
          label1126:
          paramInt1 = i;
          if (this.reL == 1)
          {
            i += 1;
            j = i * 2 + 198 + 1;
            paramInt1 = j;
            if (j >= 217) {
              paramInt1 = 217;
            }
            if (paramInt1 >= 201) {
              com.tencent.mm.plugin.sns.lucky.a.b.kS(paramInt1);
            }
            ab.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + paramInt1 + " " + i);
            paramInt1 = i;
          }
        }
        if ((this.reK == null) || (!(this.reK instanceof ced))) {
          break;
        }
        if (((ced)this.reK).xOD == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ag.cpk().z(this.reI, bool);
          ab.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[] { Long.valueOf(this.reI), Boolean.valueOf(bool) });
          break;
        }
        label1305:
        paramq = null;
      }
      label1311:
      paramq = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.r
 * JD-Core Version:    0.7.0.1
 */