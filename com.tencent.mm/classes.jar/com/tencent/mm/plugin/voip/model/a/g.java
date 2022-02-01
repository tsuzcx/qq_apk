package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.o;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gat;
import com.tencent.mm.protocal.protobuf.gau;
import com.tencent.mm.protocal.protobuf.gbh;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n<gat, gau>
{
  public g(List<String> paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, LinkedList<dtl> paramLinkedList)
  {
    AppMethodBeat.i(115237);
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new gat();
    ((c.a)localObject1).otF = new gau();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipinvite";
    ((c.a)localObject1).funcId = 170;
    ((c.a)localObject1).otG = 63;
    ((c.a)localObject1).respCmdId = 1000000063;
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (gat)c.b.b(this.rr.otB);
    Object localObject2 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      ((LinkedList)localObject2).add(new etl().btH((String)paramList.get(i)));
      i += 1;
    }
    ((gat)localObject1).abnl = z.bAM();
    ((gat)localObject1).abYd = ((LinkedList)localObject2);
    ((gat)localObject1).abYc = ((LinkedList)localObject2).size();
    ((gat)localObject1).ZkT = paramInt1;
    ((gat)localObject1).abGP = 0;
    ((gat)localObject1).abXQ = paramInt2;
    ((gat)localObject1).abmP = paramInt3;
    paramList = new gbh();
    paramList.vhJ = 2;
    localObject2 = new gol();
    ((gol)localObject2).df(paramArrayOfByte1);
    paramList.YLa = ((gol)localObject2);
    ((gat)localObject1).abWP = paramList;
    paramList = new gbh();
    paramList.vhJ = 3;
    paramArrayOfByte1 = new gol();
    paramArrayOfByte1.df(paramArrayOfByte2);
    paramList.YLa = paramArrayOfByte1;
    ((gat)localObject1).abWQ = paramList;
    ((gat)localObject1).abWT = System.currentTimeMillis();
    ((gat)localObject1).abWX = this.UzB.UyU.getIpStack();
    paramInt1 = ((a)com.tencent.mm.kernel.h.ax(a.class)).aaG(2);
    com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.NetSceneVoipInvite", "simType:" + paramInt1 + " ipstack:" + ((gat)localObject1).abWX);
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((gat)localObject1).abWU = paramInt1;
      ((gat)localObject1).abWV = paramLinkedList.size();
      ((gat)localObject1).abWW = paramLinkedList;
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
  
  public final int getType()
  {
    return 170;
  }
  
  public final com.tencent.mm.am.h hYT()
  {
    AppMethodBeat.i(115238);
    com.tencent.mm.am.h local1 = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(115236);
        com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + g.this.UzB.mStatus);
        gau localgau = (gau)g.this.hYX();
        paramAnonymousp = (gat)((g)paramAnonymousp).hYY();
        if ((paramAnonymousInt2 != 238) && (SubCoreVoip.hVp().UBE.UCy))
        {
          SubCoreVoip.hVp().d(localgau.Zvz, localgau.ZvA, paramAnonymousp.abXQ);
          com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.NetSceneVoipInvite", " steve:[simucall] new simul call invite response  return!, DO NOT use inviteresp info,  I'm callee!!");
          AppMethodBeat.o(115236);
          return;
        }
        if (g.this.UzB.mStatus != 2)
        {
          com.tencent.mm.plugin.voip.f.g.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.UzB.mStatus + " should:2");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.UzB.UyU.UEC = localgau.abXl;
        g.this.UzB.UyU.UED = localgau.abXm;
        g.this.UzB.UyU.UEE = localgau.abXn;
        g.this.UzB.UyU.UEF = localgau.abXo;
        g.this.UzB.UyU.UEH = localgau.abXq;
        g.this.UzB.UyU.UEG = localgau.abXv;
        g.this.UzB.UyU.UFm = localgau.abYg;
        g.this.UzB.UyU.UDD = localgau.abXc;
        g.this.UzB.UyU.UEJ = localgau.abXx;
        g.this.UzB.aqs(localgau.abXa);
        g.this.UzB.UyU.UDH = localgau.abXd;
        if ((localgau.abXe != null) && (localgau.abXe.aaxD != null)) {
          g.this.UzB.UyU.UDF = localgau.abXe.aaxD.toByteArray();
        }
        if ((localgau.abXe != null) && (localgau.abXe.abwJ >= 12))
        {
          ByteBuffer localByteBuffer = ByteBuffer.wrap(localgau.abXe.aaxD.toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = localByteBuffer.order();
          i = localByteBuffer.getInt();
          com.tencent.mm.plugin.voip.f.g.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          g.this.UzB.UyU.UEI = i;
        }
        com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.UzB.UyU.UEC + ",audioTsdEdge = " + g.this.UzB.UyU.UED + ",passthroughQosAlgorithm = " + g.this.UzB.UyU.UEE + ",fastPlayRepair = " + g.this.UzB.UyU.UEF + ", audioDtx = " + g.this.UzB.UyU.UEH + ",switchtcpPktCnt = " + g.this.UzB.UyU.UDC + ",SvrCfgListV = " + g.this.UzB.UyU.UEG + ", setMaxBRForRelay=" + g.this.UzB.UyU.UEJ + ",EnableDataAccept = " + g.this.UzB.UyU.UFm + ",WifiScanInterval = " + g.this.UzB.UyU.UDH + ",BaseBRTuneRatio=" + g.this.UzB.UyU.UEI);
        g.this.UzB.UyU.UEK = localgau.abXu;
        com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.UzB.UyU.UEK);
        g.this.UzB.UyU.UEL = localgau.abXy;
        com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.UzB.UyU.UEL);
        MMApplicationContext.getContext();
        int i = com.tencent.mm.plugin.voip.f.g.ibq();
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + localgau.Zvz + "," + localgau.ZvA);
            switch (paramAnonymousInt2)
            {
            default: 
              g.this.UzB.UyU.UFN.UAh = 12;
              g.this.UzB.UyU.UFN.UAt = 99;
              com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(5), Integer.valueOf(i) });
            }
            for (;;)
            {
              g.this.UzB.UyU.UFN.UAi = paramAnonymousInt2;
              g.this.UzB.S(1, paramAnonymousInt2, paramAnonymousString);
              AppMethodBeat.o(115236);
              return;
              g.this.UzB.Uyu = true;
              g.this.UzB.Uyw = false;
              g.this.UzB.Uyv = false;
              g.this.UzB.UyU.UEB = 0;
              g.this.UzB.UyU.UEA = 0;
              g.this.UzB.setStatus(3);
              g.this.UzB.UyU.roomId = localgau.Zvz;
              g.this.UzB.UyU.Hnt = localgau.ZvA;
              g.this.UzB.UyU.JHb = localgau.abna;
              paramAnonymousString = g.this.UzB.UyU;
              paramAnonymousString.UFO |= 0x1;
              com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.NetSceneVoipInvite", "steve:[simucall]: use old svr-based simulcall! iSimulCallStatus: " + g.this.UzB.UyU.UFO);
              g.this.UzB.UyV.VS(paramAnonymousp.abXQ);
              AppMethodBeat.o(115236);
              return;
              g.this.UzB.UyU.UFN.UAh = 13;
              g.this.UzB.UyU.UFN.UAt = 2;
              com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.UzB.UyU.UFN.UAh = 13;
              g.this.UzB.UyU.UFN.UAt = 9;
              com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.UzB.UyU.UFN.UAh = 12;
              g.this.UzB.UyU.UFN.UAt = 12;
              com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(8), Integer.valueOf(i) });
              continue;
              g.this.UzB.UyU.UFN.UAh = 12;
              g.this.UzB.UyU.UFN.UAt = 1;
              com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(3), Integer.valueOf(i) });
              continue;
              g.this.UzB.UyU.UFN.UAh = 12;
              g.this.UzB.UyU.UFN.UAt = 10;
              com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(7), Integer.valueOf(i) });
              continue;
              g.this.UzB.UyU.UFN.UAh = 13;
              g.this.UzB.UyU.UFN.UAt = 11;
              com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(4), Integer.valueOf(i) });
              continue;
              Log.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + localgau.abYh + " seconds!");
              SubCoreVoip.hVp().UBN = System.currentTimeMillis();
              if (localgau.abYh != 0) {
                SubCoreVoip.hVp().UBO = (localgau.abYh * 1000);
              } else {
                SubCoreVoip.hVp().UBO = 30000L;
              }
            }
          }
          g.this.UzB.UyU.UFN.UAh = 12;
          g.this.UzB.UyU.UFN.UAi = paramAnonymousInt2;
          g.this.UzB.UyU.UFN.UAt = 99;
          com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(9), Integer.valueOf(i) });
          g.this.UzB.S(1, -9004, "");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.UzB.setStatus(4);
        g.this.UzB.UyU.roomId = localgau.Zvz;
        g.this.UzB.UyU.Hnt = localgau.ZvA;
        g.this.UzB.UyU.JHb = localgau.abna;
        com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(1), Integer.valueOf(i) });
        if (localgau.abYf > 0)
        {
          paramAnonymousString = g.this.UzB;
          long l = localgau.abYf * 1000;
          paramAnonymousString.Uzk.startTimer(l);
        }
        SubCoreVoip.hVp().hYC();
        g.this.UzB.hWM();
        g.this.UzB.hWN();
        paramAnonymousString = g.this.UzB.UyU.UFN;
        paramAnonymousString.wS((int)(System.currentTimeMillis() - paramAnonymousString.UAM));
        com.tencent.mm.plugin.voip.f.g.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.UzB.UyU.roomId + ",memberid = " + g.this.UzB.UyU.JHb + "VoipSyncInterval = " + localgau.abYf);
        g.this.UzB.UyV.fwd();
        com.tencent.mm.plugin.voip.f.g.c(SubCoreVoip.hVp().hYr(), SubCoreVoip.hVp().hVw(), 0, 1);
        AppMethodBeat.o(115236);
      }
    };
    AppMethodBeat.o(115238);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.g
 * JD-Core Version:    0.7.0.1
 */