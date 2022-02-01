package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.feh;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.protocal.protobuf.fev;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n<feh, fei>
{
  public g(List<String> paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, LinkedList<dbt> paramLinkedList)
  {
    AppMethodBeat.i(115237);
    Object localObject1 = new d.a();
    ((d.a)localObject1).lBU = new feh();
    ((d.a)localObject1).lBV = new fei();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipinvite";
    ((d.a)localObject1).funcId = 170;
    ((d.a)localObject1).lBW = 63;
    ((d.a)localObject1).respCmdId = 1000000063;
    this.rr = ((d.a)localObject1).bgN();
    localObject1 = (feh)d.b.b(this.rr.lBR);
    Object localObject2 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      ((LinkedList)localObject2).add(new eaf().btQ((String)paramList.get(i)));
      i += 1;
    }
    ((feh)localObject1).TWw = z.bcZ();
    ((feh)localObject1).UDS = ((LinkedList)localObject2);
    ((feh)localObject1).UDR = ((LinkedList)localObject2).size();
    ((feh)localObject1).SmH = paramInt1;
    ((feh)localObject1).Uon = 0;
    ((feh)localObject1).UDF = paramInt2;
    ((feh)localObject1).TWa = paramInt3;
    paramList = new fev();
    paramList.rWu = 2;
    localObject2 = new eae();
    ((eae)localObject2).dc(paramArrayOfByte1);
    paramList.RNM = ((eae)localObject2);
    ((feh)localObject1).UCF = paramList;
    paramList = new fev();
    paramList.rWu = 3;
    paramArrayOfByte1 = new eae();
    paramArrayOfByte1.dc(paramArrayOfByte2);
    paramList.RNM = paramArrayOfByte1;
    ((feh)localObject1).UCG = paramList;
    ((feh)localObject1).UCJ = System.currentTimeMillis();
    paramInt1 = ((a)com.tencent.mm.kernel.h.ae(a.class)).WE(2);
    Log.i("MicroMsg.NetSceneVoipInvite", "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((feh)localObject1).UCK = paramInt1;
      ((feh)localObject1).UCL = paramLinkedList.size();
      ((feh)localObject1).UCM = paramLinkedList;
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
  
  public final i gAU()
  {
    AppMethodBeat.i(115238);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115236);
        e.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + g.this.NMN.mStatus);
        fei localfei = (fei)g.this.gAY();
        paramAnonymousq = (feh)((g)paramAnonymousq).gAZ();
        if ((paramAnonymousInt2 != 238) && (c.gxs().NPf.NPQ))
        {
          c.gxs().b(localfei.Svu, localfei.Svv, paramAnonymousq.UDF);
          e.Loge("MicroMsg.NetSceneVoipInvite", " steve:[simucall] new simul call invite response  return!, DO NOT use inviteresp info,  I'm callee!!");
          AppMethodBeat.o(115236);
          return;
        }
        if (g.this.NMN.mStatus != 2)
        {
          e.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.NMN.mStatus + " should:2");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.NMN.NMi.NRx = localfei.UDa;
        g.this.NMN.NMi.NRy = localfei.UDb;
        g.this.NMN.NMi.NRz = localfei.UDc;
        g.this.NMN.NMi.NRA = localfei.UDd;
        g.this.NMN.NMi.NRC = localfei.UDf;
        g.this.NMN.NMi.NRB = localfei.UDk;
        g.this.NMN.NMi.NSh = localfei.UDV;
        g.this.NMN.NMi.NQR = localfei.UCR;
        g.this.NMN.NMi.NRE = localfei.UDm;
        g.this.NMN.akW(localfei.UCP);
        g.this.NMN.NMi.NQV = localfei.UCS;
        if ((localfei.UCT != null) && (localfei.UCT.Tkb != null)) {
          g.this.NMN.NMi.NQT = localfei.UCT.Tkb.toByteArray();
        }
        if ((localfei.UCT != null) && (localfei.UCT.Ufv >= 12))
        {
          ByteBuffer localByteBuffer = ByteBuffer.wrap(localfei.UCT.Tkb.toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = localByteBuffer.order();
          i = localByteBuffer.getInt();
          e.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          g.this.NMN.NMi.NRD = i;
        }
        e.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.NMN.NMi.NRx + ",audioTsdEdge = " + g.this.NMN.NMi.NRy + ",passthroughQosAlgorithm = " + g.this.NMN.NMi.NRz + ",fastPlayRepair = " + g.this.NMN.NMi.NRA + ", audioDtx = " + g.this.NMN.NMi.NRC + ",switchtcpPktCnt = " + g.this.NMN.NMi.NQQ + ",SvrCfgListV = " + g.this.NMN.NMi.NRB + ", setMaxBRForRelay=" + g.this.NMN.NMi.NRE + ",EnableDataAccept = " + g.this.NMN.NMi.NSh + ",WifiScanInterval = " + g.this.NMN.NMi.NQV + ",BaseBRTuneRatio=" + g.this.NMN.NMi.NRD);
        g.this.NMN.NMi.NRF = localfei.UDj;
        e.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.NMN.NMi.NRF);
        g.this.NMN.NMi.NRG = localfei.UDn;
        e.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.NMN.NMi.NRG);
        int i = e.getNetType(MMApplicationContext.getContext());
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            e.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + localfei.Svu + "," + localfei.Svv);
            switch (paramAnonymousInt2)
            {
            default: 
              g.this.NMN.NMi.NSI.NNq = 12;
              g.this.NMN.NMi.NSI.NNC = 99;
              com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(5), Integer.valueOf(i) });
            }
            for (;;)
            {
              g.this.NMN.NMi.NSI.NNr = paramAnonymousInt2;
              g.this.NMN.J(1, paramAnonymousInt2, paramAnonymousString);
              AppMethodBeat.o(115236);
              return;
              g.this.NMN.NLI = true;
              g.this.NMN.NLK = false;
              g.this.NMN.NLJ = false;
              g.this.NMN.NMi.NRw = 0;
              g.this.NMN.NMi.NRv = 0;
              g.this.NMN.setStatus(3);
              g.this.NMN.NMi.roomId = localfei.Svu;
              g.this.NMN.NMi.DPJ = localfei.Svv;
              g.this.NMN.NMi.DPQ = localfei.TWl;
              paramAnonymousString = g.this.NMN.NMi;
              paramAnonymousString.NSJ |= 0x1;
              e.Logi("MicroMsg.NetSceneVoipInvite", "steve:[simucall]: use old svr-based simulcall! iSimulCallStatus: " + g.this.NMN.NMi.NSJ);
              g.this.NMN.NMj.akC(paramAnonymousq.UDF);
              AppMethodBeat.o(115236);
              return;
              g.this.NMN.NMi.NSI.NNq = 13;
              g.this.NMN.NMi.NSI.NNC = 2;
              com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.NMN.NMi.NSI.NNq = 13;
              g.this.NMN.NMi.NSI.NNC = 9;
              com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.NMN.NMi.NSI.NNq = 12;
              g.this.NMN.NMi.NSI.NNC = 12;
              com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(8), Integer.valueOf(i) });
              continue;
              g.this.NMN.NMi.NSI.NNq = 12;
              g.this.NMN.NMi.NSI.NNC = 1;
              com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(3), Integer.valueOf(i) });
              continue;
              g.this.NMN.NMi.NSI.NNq = 12;
              g.this.NMN.NMi.NSI.NNC = 10;
              com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(7), Integer.valueOf(i) });
              continue;
              g.this.NMN.NMi.NSI.NNq = 13;
              g.this.NMN.NMi.NSI.NNC = 11;
              com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(4), Integer.valueOf(i) });
              continue;
              Log.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + localfei.UDW + " seconds!");
              c.gxs().NPo = System.currentTimeMillis();
              if (localfei.UDW != 0) {
                c.gxs().NPp = (localfei.UDW * 1000);
              } else {
                c.gxs().NPp = 30000L;
              }
            }
          }
          g.this.NMN.NMi.NSI.NNq = 12;
          g.this.NMN.NMi.NSI.NNr = paramAnonymousInt2;
          g.this.NMN.NMi.NSI.NNC = 99;
          com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(9), Integer.valueOf(i) });
          g.this.NMN.J(1, -9004, "");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.NMN.setStatus(4);
        g.this.NMN.NMi.roomId = localfei.Svu;
        g.this.NMN.NMi.DPJ = localfei.Svv;
        g.this.NMN.NMi.DPQ = localfei.TWl;
        com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(1), Integer.valueOf(i) });
        if (localfei.UDU > 0)
        {
          paramAnonymousString = g.this.NMN;
          long l = localfei.UDU * 1000;
          paramAnonymousString.NMy.startTimer(l);
        }
        c.gxs().gAC();
        g.this.NMN.gyS();
        g.this.NMN.gyT();
        e.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.NMN.NMi.roomId + ",memberid = " + g.this.NMN.NMi.DPQ + "VoipSyncInterval = " + localfei.UDU);
        g.this.NMN.NMj.gxZ();
        e.c(c.gxs().gAn(), c.gxs().gAo(), 0, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.g
 * JD-Core Version:    0.7.0.1
 */