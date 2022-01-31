package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class g$1
  implements f
{
  g$1(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(4716);
    a.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + paramInt1 + " errCode:" + paramInt2 + " status:" + this.tzP.tvE.mStatus);
    if (this.tzP.tvE.mStatus != 2)
    {
      a.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + this.tzP.tvE.mStatus + " should:2");
      AppMethodBeat.o(4716);
      return;
    }
    cst localcst = (cst)this.tzP.cOt();
    this.tzP.tvE.tvj.tAH = localcst.yaq;
    this.tzP.tvE.tvj.tAI = localcst.yar;
    this.tzP.tvE.tvj.tAJ = localcst.yas;
    this.tzP.tvE.tvj.tAK = localcst.yat;
    this.tzP.tvE.tvj.tAM = localcst.yav;
    this.tzP.tvE.tvj.tAL = localcst.yaB;
    this.tzP.tvE.tvj.tBq = localcst.ybm;
    this.tzP.tvE.tvj.tAk = localcst.yah;
    this.tzP.tvE.tvj.tAO = localcst.yaD;
    this.tzP.tvE.Hq(localcst.yaf);
    this.tzP.tvE.tvj.tAn = localcst.yai;
    if ((localcst.yaj != null) && (localcst.yaj.getBuffer() != null)) {
      this.tzP.tvE.tvj.tAm = localcst.yaj.getBuffer().toByteArray();
    }
    if ((localcst.yaj != null) && (localcst.yaj.getILen() >= 12))
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(localcst.yaj.getBuffer().toByteArray(), 8, 4);
      ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
      ByteOrder localByteOrder2 = localByteBuffer.order();
      i = localByteBuffer.getInt();
      a.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
      this.tzP.tvE.tvj.tAN = i;
    }
    a.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + this.tzP.tvE.tvj.tAH + ",audioTsdEdge = " + this.tzP.tvE.tvj.tAI + ",passthroughQosAlgorithm = " + this.tzP.tvE.tvj.tAJ + ",fastPlayRepair = " + this.tzP.tvE.tvj.tAK + ", audioDtx = " + this.tzP.tvE.tvj.tAM + ",switchtcpPktCnt = " + this.tzP.tvE.tvj.tAj + ",SvrCfgListV = " + this.tzP.tvE.tvj.tAL + ", setMaxBRForRelay=" + this.tzP.tvE.tvj.tAO + ",EnableDataAccept = " + this.tzP.tvE.tvj.tBq + ",WifiScanInterval = " + this.tzP.tvE.tvj.tAn + ",BaseBRTuneRatio=" + this.tzP.tvE.tvj.tAN);
    this.tzP.tvE.tvj.tAP = localcst.yaA;
    a.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + this.tzP.tvE.tvj.tAP);
    this.tzP.tvE.tvj.tAQ = localcst.yaE;
    a.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + this.tzP.tvE.tvj.tAQ);
    int i = a.getNetType(ah.getContext());
    if (paramInt1 != 0)
    {
      if (paramInt1 == 4)
      {
        a.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + localcst.wQP + "," + localcst.wQQ);
        switch (paramInt2)
        {
        default: 
          this.tzP.tvE.tvj.tBN.twb = 12;
          this.tzP.tvE.tvj.tBN.twn = 99;
          h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(5), Integer.valueOf(i) });
        }
        for (;;)
        {
          this.tzP.tvE.tvj.tBN.twc = paramInt2;
          this.tzP.tvE.y(1, paramInt2, paramString);
          AppMethodBeat.o(4716);
          return;
          this.tzP.tvE.tuJ = true;
          this.tzP.tvE.tuL = false;
          this.tzP.tvE.tuK = false;
          this.tzP.tvE.tvj.tAG = 0;
          this.tzP.tvE.tvj.tAF = 0;
          this.tzP.tvE.setStatus(3);
          this.tzP.tvE.tvj.nMZ = localcst.wQP;
          this.tzP.tvE.tvj.nNa = localcst.wQQ;
          this.tzP.tvE.tvj.nNh = localcst.xCv;
          paramString = (css)((g)paramm).cOu();
          this.tzP.tvE.tvk.Hx(paramString.xQo);
          AppMethodBeat.o(4716);
          return;
          this.tzP.tvE.tvj.tBN.twb = 13;
          this.tzP.tvE.tvj.tBN.twn = 2;
          h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(2), Integer.valueOf(i) });
          continue;
          this.tzP.tvE.tvj.tBN.twb = 13;
          this.tzP.tvE.tvj.tBN.twn = 9;
          h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(2), Integer.valueOf(i) });
          continue;
          this.tzP.tvE.tvj.tBN.twb = 12;
          this.tzP.tvE.tvj.tBN.twn = 12;
          h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(8), Integer.valueOf(i) });
          continue;
          this.tzP.tvE.tvj.tBN.twb = 12;
          this.tzP.tvE.tvj.tBN.twn = 1;
          h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(3), Integer.valueOf(i) });
          continue;
          this.tzP.tvE.tvj.tBN.twb = 12;
          this.tzP.tvE.tvj.tBN.twn = 10;
          h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(7), Integer.valueOf(i) });
          continue;
          this.tzP.tvE.tvj.tBN.twb = 13;
          this.tzP.tvE.tvj.tBN.twn = 11;
          h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(4), Integer.valueOf(i) });
          continue;
          ab.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + localcst.ybn + " seconds!");
          com.tencent.mm.plugin.voip.b.cLC().tyY = System.currentTimeMillis();
          if (localcst.ybn != 0) {
            com.tencent.mm.plugin.voip.b.cLC().tyZ = (localcst.ybn * 1000);
          } else {
            com.tencent.mm.plugin.voip.b.cLC().tyZ = 30000L;
          }
        }
      }
      this.tzP.tvE.tvj.tBN.twb = 12;
      this.tzP.tvE.tvj.tBN.twc = paramInt2;
      this.tzP.tvE.tvj.tBN.twn = 99;
      h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(9), Integer.valueOf(i) });
      this.tzP.tvE.y(1, -9004, "");
      AppMethodBeat.o(4716);
      return;
    }
    this.tzP.tvE.setStatus(4);
    this.tzP.tvE.tvj.nMZ = localcst.wQP;
    this.tzP.tvE.tvj.nNa = localcst.wQQ;
    this.tzP.tvE.tvj.nNh = localcst.xCv;
    h.qsU.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(1), Integer.valueOf(i) });
    if (localcst.ybl > 0)
    {
      paramString = this.tzP.tvE;
      long l = localcst.ybl * 1000;
      paramString.tvx.ag(l, l);
    }
    com.tencent.mm.plugin.voip.b.cLC().cNZ();
    boolean bool2 = v2protocal.cOJ();
    boolean bool1;
    int j;
    int k;
    if (com.tencent.mm.plugin.voip.b.cLE() == 0)
    {
      bool1 = true;
      paramInt2 = ac.eru.eoy;
      i = ac.eru.eoz;
      paramInt1 = this.tzP.tvE.tvj.tAk;
      j = (this.tzP.tvE.tvj.tAk >> 11 & 0x1) << 3 | paramInt1 >> 4 & 0x7;
      k = 0;
      paramInt1 = k;
      if (bool2)
      {
        paramInt1 = k;
        if (bool1)
        {
          if ((i < 0) && (paramInt2 < 0)) {
            break label2681;
          }
          if (paramInt2 < 0) {
            break label2659;
          }
          paramInt1 = paramInt2;
        }
      }
    }
    for (;;)
    {
      a.Logi("MicroMsg.NetSceneVoipInvite", "NetSceneInviteResp set voipbeauty local=" + bool2 + ", server=" + j + ", blacklist=" + paramInt2 + ", whitelist=" + i + ",isLibInitOK=" + bool1 + ", UICallback" + this.tzP.tvE.tvk + ", finalFlag=" + paramInt1);
      if (this.tzP.tvE.tvk != null) {
        this.tzP.tvE.tvk.setVoipBeauty(paramInt1);
      }
      this.tzP.tvE.tvj.tBr = paramInt1;
      this.tzP.tvE.tvj.tBs = j;
      a.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + this.tzP.tvE.tvj.nMZ + ",memberid = " + this.tzP.tvE.tvj.nNh + "VoipSyncInterval = " + localcst.ybl);
      this.tzP.tvE.tvk.cMX();
      a.c(com.tencent.mm.plugin.voip.b.cLC().cNU(), com.tencent.mm.plugin.voip.b.cLC().cNV(), 0, 1);
      AppMethodBeat.o(4716);
      return;
      bool1 = false;
      break;
      label2659:
      paramInt1 = k;
      if (i >= 0)
      {
        paramInt1 = k;
        if (j == 0)
        {
          paramInt1 = i;
          continue;
          label2681:
          paramInt1 = k;
          if (j > 0) {
            paramInt1 = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.g.1
 * JD-Core Version:    0.7.0.1
 */