package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aw;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n<dzp, dzq>
{
  public g(List<String> paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, LinkedList<ccp> paramLinkedList)
  {
    AppMethodBeat.i(115237);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hQF = new dzp();
    ((b.a)localObject1).hQG = new dzq();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipinvite";
    ((b.a)localObject1).funcId = 170;
    ((b.a)localObject1).hQH = 63;
    ((b.a)localObject1).respCmdId = 1000000063;
    this.rr = ((b.a)localObject1).aDS();
    localObject1 = (dzp)this.rr.hQD.hQJ;
    Object localObject2 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      ((LinkedList)localObject2).add(new cxn().aQV((String)paramList.get(i)));
      i += 1;
    }
    ((dzp)localObject1).HzT = com.tencent.mm.model.v.aAC();
    ((dzp)localObject1).Iey = ((LinkedList)localObject2);
    ((dzp)localObject1).Iex = ((LinkedList)localObject2).size();
    ((dzp)localObject1).GqB = paramInt1;
    ((dzp)localObject1).HPZ = 0;
    ((dzp)localObject1).Iel = paramInt2;
    ((dzp)localObject1).Hzx = paramInt3;
    paramList = new ead();
    paramList.nJA = 2;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte1);
    paramList.FTj = ((SKBuiltinBuffer_t)localObject2);
    ((dzp)localObject1).Idl = paramList;
    paramList = new ead();
    paramList.nJA = 3;
    paramArrayOfByte1 = new SKBuiltinBuffer_t();
    paramArrayOfByte1.setBuffer(paramArrayOfByte2);
    paramList.FTj = paramArrayOfByte1;
    ((dzp)localObject1).Idm = paramList;
    ((dzp)localObject1).Idp = System.currentTimeMillis();
    paramInt1 = ((a)com.tencent.mm.kernel.g.ab(a.class)).Kp(2);
    ae.i("MicroMsg.NetSceneVoipInvite", "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dzp)localObject1).Idq = paramInt1;
      ((dzp)localObject1).Idr = paramLinkedList.size();
      ((dzp)localObject1).Ids = paramLinkedList;
      AppMethodBeat.o(115237);
      return;
      if (paramInt1 == 3) {
        paramInt1 = 3;
      } else if (paramInt1 == 1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final com.tencent.mm.ak.f eBL()
  {
    AppMethodBeat.i(115238);
    com.tencent.mm.ak.f local1 = new com.tencent.mm.ak.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115236);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + g.this.CsR.mStatus);
        dzq localdzq = (dzq)g.this.eBP();
        paramAnonymousn = (dzp)((g)paramAnonymousn).eBQ();
        if ((paramAnonymousInt2 != 238) && (c.eys().Cvg.CvS))
        {
          c.eys().b(localdzq.Gxq, localdzq.Gxr, paramAnonymousn.Iel);
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipInvite", " steve:[simucall] new simul call invite response  return!, DO NOT use inviteresp info,  I'm callee!!");
          AppMethodBeat.o(115236);
          return;
        }
        if (g.this.CsR.mStatus != 2)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.CsR.mStatus + " should:2");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.CsR.Csj.Cxx = localdzq.IdG;
        g.this.CsR.Csj.Cxy = localdzq.IdH;
        g.this.CsR.Csj.Cxz = localdzq.IdI;
        g.this.CsR.Csj.CxA = localdzq.IdJ;
        g.this.CsR.Csj.CxC = localdzq.IdL;
        g.this.CsR.Csj.CxB = localdzq.IdQ;
        g.this.CsR.Csj.Cyh = localdzq.IeB;
        g.this.CsR.Csj.CwQ = localdzq.Idx;
        g.this.CsR.Csj.CxE = localdzq.IdS;
        g.this.CsR.UR(localdzq.Idv);
        g.this.CsR.Csj.CwU = localdzq.Idy;
        if ((localdzq.Idz != null) && (localdzq.Idz.getBuffer() != null)) {
          g.this.CsR.Csj.CwS = localdzq.Idz.getBuffer().toByteArray();
        }
        if ((localdzq.Idz != null) && (localdzq.Idz.getILen() >= 12))
        {
          ByteBuffer localByteBuffer = ByteBuffer.wrap(localdzq.Idz.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = localByteBuffer.order();
          i = localByteBuffer.getInt();
          com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          g.this.CsR.Csj.CxD = i;
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.CsR.Csj.Cxx + ",audioTsdEdge = " + g.this.CsR.Csj.Cxy + ",passthroughQosAlgorithm = " + g.this.CsR.Csj.Cxz + ",fastPlayRepair = " + g.this.CsR.Csj.CxA + ", audioDtx = " + g.this.CsR.Csj.CxC + ",switchtcpPktCnt = " + g.this.CsR.Csj.CwP + ",SvrCfgListV = " + g.this.CsR.Csj.CxB + ", setMaxBRForRelay=" + g.this.CsR.Csj.CxE + ",EnableDataAccept = " + g.this.CsR.Csj.Cyh + ",WifiScanInterval = " + g.this.CsR.Csj.CwU + ",BaseBRTuneRatio=" + g.this.CsR.Csj.CxD);
        g.this.CsR.Csj.CxF = localdzq.IdP;
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.CsR.Csj.CxF);
        g.this.CsR.Csj.CxG = localdzq.IdT;
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.CsR.Csj.CxG);
        int i = com.tencent.mm.plugin.voip.b.f.getNetType(ak.getContext());
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + localdzq.Gxq + "," + localdzq.Gxr);
            switch (paramAnonymousInt2)
            {
            default: 
              g.this.CsR.Csj.CyH.Ctt = 12;
              g.this.CsR.Csj.CyH.CtF = 99;
              com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(5), Integer.valueOf(i) });
            }
            for (;;)
            {
              g.this.CsR.Csj.CyH.Ctu = paramAnonymousInt2;
              g.this.CsR.J(1, paramAnonymousInt2, paramAnonymousString);
              AppMethodBeat.o(115236);
              return;
              g.this.CsR.CrJ = true;
              g.this.CsR.CrL = false;
              g.this.CsR.CrK = false;
              g.this.CsR.Csj.Cxw = 0;
              g.this.CsR.Csj.Cxv = 0;
              g.this.CsR.setStatus(3);
              g.this.CsR.Csj.roomId = localdzq.Gxq;
              g.this.CsR.Csj.uXg = localdzq.Gxr;
              g.this.CsR.Csj.uXn = localdzq.HzI;
              paramAnonymousString = g.this.CsR.Csj;
              paramAnonymousString.CyI |= 0x1;
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "steve:[simucall]: use old svr-based simulcall! iSimulCallStatus: " + g.this.CsR.Csj.CyI);
              g.this.CsR.Csk.Uy(paramAnonymousn.Iel);
              AppMethodBeat.o(115236);
              return;
              g.this.CsR.Csj.CyH.Ctt = 13;
              g.this.CsR.Csj.CyH.CtF = 2;
              com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.CsR.Csj.CyH.Ctt = 13;
              g.this.CsR.Csj.CyH.CtF = 9;
              com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.CsR.Csj.CyH.Ctt = 12;
              g.this.CsR.Csj.CyH.CtF = 12;
              com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(8), Integer.valueOf(i) });
              continue;
              g.this.CsR.Csj.CyH.Ctt = 12;
              g.this.CsR.Csj.CyH.CtF = 1;
              com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(3), Integer.valueOf(i) });
              continue;
              g.this.CsR.Csj.CyH.Ctt = 12;
              g.this.CsR.Csj.CyH.CtF = 10;
              com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(7), Integer.valueOf(i) });
              continue;
              g.this.CsR.Csj.CyH.Ctt = 13;
              g.this.CsR.Csj.CyH.CtF = 11;
              com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(4), Integer.valueOf(i) });
              continue;
              ae.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + localdzq.IeC + " seconds!");
              c.eys().Cvo = System.currentTimeMillis();
              if (localdzq.IeC != 0) {
                c.eys().Cvp = (localdzq.IeC * 1000);
              } else {
                c.eys().Cvp = 30000L;
              }
            }
          }
          g.this.CsR.Csj.CyH.Ctt = 12;
          g.this.CsR.Csj.CyH.Ctu = paramAnonymousInt2;
          g.this.CsR.Csj.CyH.CtF = 99;
          com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(9), Integer.valueOf(i) });
          g.this.CsR.J(1, -9004, "");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.CsR.setStatus(4);
        g.this.CsR.Csj.roomId = localdzq.Gxq;
        g.this.CsR.Csj.uXg = localdzq.Gxr;
        g.this.CsR.Csj.uXn = localdzq.HzI;
        com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(c.eys().eBd()), Long.valueOf(c.eys().eBe()), Long.valueOf(c.eys().ezE()), Integer.valueOf(1), Integer.valueOf(i) });
        if (localdzq.IeA > 0)
        {
          paramAnonymousString = g.this.CsR;
          long l = localdzq.IeA * 1000;
          paramAnonymousString.CsC.ay(l, l);
        }
        c.eys().eBp();
        g.this.CsR.ezP();
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.CsR.Csj.roomId + ",memberid = " + g.this.CsR.Csj.uXn + "VoipSyncInterval = " + localdzq.IeA);
        g.this.CsR.Csk.eyY();
        com.tencent.mm.plugin.voip.b.f.c(c.eys().eBd(), c.eys().eBe(), 0, 1);
        AppMethodBeat.o(115236);
      }
    };
    AppMethodBeat.o(115238);
    return local1;
  }
  
  public final int getType()
  {
    return 170;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.g
 * JD-Core Version:    0.7.0.1
 */