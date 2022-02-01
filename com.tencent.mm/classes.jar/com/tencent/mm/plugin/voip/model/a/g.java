package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dse;
import com.tencent.mm.protocal.protobuf.dsf;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n<dse, dsf>
{
  public g(List<String> paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, LinkedList<bxf> paramLinkedList)
  {
    AppMethodBeat.i(115237);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new dse();
    ((b.a)localObject1).hvu = new dsf();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipinvite";
    ((b.a)localObject1).funcId = 170;
    ((b.a)localObject1).reqCmdId = 63;
    ((b.a)localObject1).respCmdId = 1000000063;
    this.rr = ((b.a)localObject1).aAz();
    localObject1 = (dse)this.rr.hvr.hvw;
    Object localObject2 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      ((LinkedList)localObject2).add(new crm().aJV((String)paramList.get(i)));
      i += 1;
    }
    ((dse)localObject1).Fwn = com.tencent.mm.model.u.axw();
    ((dse)localObject1).FZu = ((LinkedList)localObject2);
    ((dse)localObject1).FZt = ((LinkedList)localObject2).size();
    ((dse)localObject1).EqS = paramInt1;
    ((dse)localObject1).FLI = 0;
    ((dse)localObject1).FZh = paramInt2;
    ((dse)localObject1).FvR = paramInt3;
    paramList = new dss();
    paramList.ndI = 2;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte1);
    paramList.DVs = ((SKBuiltinBuffer_t)localObject2);
    ((dse)localObject1).FYh = paramList;
    paramList = new dss();
    paramList.ndI = 3;
    paramArrayOfByte1 = new SKBuiltinBuffer_t();
    paramArrayOfByte1.setBuffer(paramArrayOfByte2);
    paramList.DVs = paramArrayOfByte1;
    ((dse)localObject1).FYi = paramList;
    ((dse)localObject1).FYl = System.currentTimeMillis();
    paramInt1 = ((a)com.tencent.mm.kernel.g.ab(a.class)).Is(2);
    ac.i("MicroMsg.NetSceneVoipInvite", "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dse)localObject1).FYm = paramInt1;
      ((dse)localObject1).FYn = paramLinkedList.size();
      ((dse)localObject1).FYo = paramLinkedList;
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
  
  public final com.tencent.mm.ak.g eks()
  {
    AppMethodBeat.i(115238);
    com.tencent.mm.ak.g local1 = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
      {
        AppMethodBeat.i(115236);
        d.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + g.this.ACr.mStatus);
        dsf localdsf = (dsf)g.this.ekw();
        paramAnonymousn = (dse)((g)paramAnonymousn).ekx();
        if ((paramAnonymousInt2 != 238) && (c.ehb().AEF.AFr))
        {
          c.ehb().b(localdsf.Exf, localdsf.Exg, paramAnonymousn.FZh);
          d.Loge("MicroMsg.NetSceneVoipInvite", " steve:[simucall] new simul call invite response  return!, DO NOT use inviteresp info,  I'm callee!!");
          AppMethodBeat.o(115236);
          return;
        }
        if (g.this.ACr.mStatus != 2)
        {
          d.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.ACr.mStatus + " should:2");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.ACr.ABJ.AGV = localdsf.FYC;
        g.this.ACr.ABJ.AGW = localdsf.FYD;
        g.this.ACr.ABJ.AGX = localdsf.FYE;
        g.this.ACr.ABJ.AGY = localdsf.FYF;
        g.this.ACr.ABJ.AHa = localdsf.FYH;
        g.this.ACr.ABJ.AGZ = localdsf.FYM;
        g.this.ACr.ABJ.AHF = localdsf.FZx;
        g.this.ACr.ABJ.AGp = localdsf.FYt;
        g.this.ACr.ABJ.AHc = localdsf.FYO;
        g.this.ACr.Ss(localdsf.FYr);
        g.this.ACr.ABJ.AGt = localdsf.FYu;
        if ((localdsf.FYv != null) && (localdsf.FYv.getBuffer() != null)) {
          g.this.ACr.ABJ.AGr = localdsf.FYv.getBuffer().toByteArray();
        }
        if ((localdsf.FYv != null) && (localdsf.FYv.getILen() >= 12))
        {
          ByteBuffer localByteBuffer = ByteBuffer.wrap(localdsf.FYv.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = localByteBuffer.order();
          i = localByteBuffer.getInt();
          d.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          g.this.ACr.ABJ.AHb = i;
        }
        d.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.ACr.ABJ.AGV + ",audioTsdEdge = " + g.this.ACr.ABJ.AGW + ",passthroughQosAlgorithm = " + g.this.ACr.ABJ.AGX + ",fastPlayRepair = " + g.this.ACr.ABJ.AGY + ", audioDtx = " + g.this.ACr.ABJ.AHa + ",switchtcpPktCnt = " + g.this.ACr.ABJ.AGo + ",SvrCfgListV = " + g.this.ACr.ABJ.AGZ + ", setMaxBRForRelay=" + g.this.ACr.ABJ.AHc + ",EnableDataAccept = " + g.this.ACr.ABJ.AHF + ",WifiScanInterval = " + g.this.ACr.ABJ.AGt + ",BaseBRTuneRatio=" + g.this.ACr.ABJ.AHb);
        g.this.ACr.ABJ.AHd = localdsf.FYL;
        d.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.ACr.ABJ.AHd);
        g.this.ACr.ABJ.AHe = localdsf.FYP;
        d.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.ACr.ABJ.AHe);
        int i = d.getNetType(ai.getContext());
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            d.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + localdsf.Exf + "," + localdsf.Exg);
            switch (paramAnonymousInt2)
            {
            default: 
              g.this.ACr.ABJ.AIf.ACR = 12;
              g.this.ACr.ABJ.AIf.ADd = 99;
              h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(5), Integer.valueOf(i) });
            }
            for (;;)
            {
              g.this.ACr.ABJ.AIf.ACS = paramAnonymousInt2;
              g.this.ACr.H(1, paramAnonymousInt2, paramAnonymousString);
              AppMethodBeat.o(115236);
              return;
              g.this.ACr.ABj = true;
              g.this.ACr.ABl = false;
              g.this.ACr.ABk = false;
              g.this.ACr.ABJ.AGU = 0;
              g.this.ACr.ABJ.AGT = 0;
              g.this.ACr.setStatus(3);
              g.this.ACr.ABJ.roomId = localdsf.Exf;
              g.this.ACr.ABJ.tIG = localdsf.Exg;
              g.this.ACr.ABJ.tIN = localdsf.Fwc;
              paramAnonymousString = g.this.ACr.ABJ;
              paramAnonymousString.AIg |= 0x1;
              d.Logi("MicroMsg.NetSceneVoipInvite", "steve:[simucall]: use old svr-based simulcall! iSimulCallStatus: " + g.this.ACr.ABJ.AIg);
              g.this.ACr.ABK.RZ(paramAnonymousn.FZh);
              AppMethodBeat.o(115236);
              return;
              g.this.ACr.ABJ.AIf.ACR = 13;
              g.this.ACr.ABJ.AIf.ADd = 2;
              h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.ACr.ABJ.AIf.ACR = 13;
              g.this.ACr.ABJ.AIf.ADd = 9;
              h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.ACr.ABJ.AIf.ACR = 12;
              g.this.ACr.ABJ.AIf.ADd = 12;
              h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(8), Integer.valueOf(i) });
              continue;
              g.this.ACr.ABJ.AIf.ACR = 12;
              g.this.ACr.ABJ.AIf.ADd = 1;
              h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(3), Integer.valueOf(i) });
              continue;
              g.this.ACr.ABJ.AIf.ACR = 12;
              g.this.ACr.ABJ.AIf.ADd = 10;
              h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(7), Integer.valueOf(i) });
              continue;
              g.this.ACr.ABJ.AIf.ACR = 13;
              g.this.ACr.ABJ.AIf.ADd = 11;
              h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(4), Integer.valueOf(i) });
              continue;
              ac.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + localdsf.FZy + " seconds!");
              c.ehb().AEN = System.currentTimeMillis();
              if (localdsf.FZy != 0) {
                c.ehb().AEO = (localdsf.FZy * 1000);
              } else {
                c.ehb().AEO = 30000L;
              }
            }
          }
          g.this.ACr.ABJ.AIf.ACR = 12;
          g.this.ACr.ABJ.AIf.ACS = paramAnonymousInt2;
          g.this.ACr.ABJ.AIf.ADd = 99;
          h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(9), Integer.valueOf(i) });
          g.this.ACr.H(1, -9004, "");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.ACr.setStatus(4);
        g.this.ACr.ABJ.roomId = localdsf.Exf;
        g.this.ACr.ABJ.tIG = localdsf.Exg;
        g.this.ACr.ABJ.tIN = localdsf.Fwc;
        h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(1), Integer.valueOf(i) });
        if (localdsf.FZw > 0)
        {
          paramAnonymousString = g.this.ACr;
          long l = localdsf.FZw * 1000;
          paramAnonymousString.ACc.au(l, l);
        }
        c.ehb().ejW();
        g.this.ACr.eix();
        d.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.ACr.ABJ.roomId + ",memberid = " + g.this.ACr.ABJ.tIN + "VoipSyncInterval = " + localdsf.FZw);
        g.this.ACr.ABK.ehG();
        d.c(c.ehb().ejL(), c.ehb().ejM(), 0, 1);
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