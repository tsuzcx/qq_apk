package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.etw;
import com.tencent.mm.protocal.protobuf.etx;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n<etw, etx>
{
  public g(List<String> paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, LinkedList<csu> paramLinkedList)
  {
    AppMethodBeat.i(115237);
    Object localObject1 = new d.a();
    ((d.a)localObject1).iLN = new etw();
    ((d.a)localObject1).iLO = new etx();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipinvite";
    ((d.a)localObject1).funcId = 170;
    ((d.a)localObject1).iLP = 63;
    ((d.a)localObject1).respCmdId = 1000000063;
    this.rr = ((d.a)localObject1).aXF();
    localObject1 = (etw)this.rr.iLK.iLR;
    Object localObject2 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      ((LinkedList)localObject2).add(new dqi().bhy((String)paramList.get(i)));
      i += 1;
    }
    ((etw)localObject1).MKC = z.aTY();
    ((etw)localObject1).NqW = ((LinkedList)localObject2);
    ((etw)localObject1).NqV = ((LinkedList)localObject2).size();
    ((etw)localObject1).Llx = paramInt1;
    ((etw)localObject1).NbR = 0;
    ((etw)localObject1).NqJ = paramInt2;
    ((etw)localObject1).MKg = paramInt3;
    paramList = new euk();
    paramList.oUv = 2;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte1);
    paramList.KMS = ((SKBuiltinBuffer_t)localObject2);
    ((etw)localObject1).NpJ = paramList;
    paramList = new euk();
    paramList.oUv = 3;
    paramArrayOfByte1 = new SKBuiltinBuffer_t();
    paramArrayOfByte1.setBuffer(paramArrayOfByte2);
    paramList.KMS = paramArrayOfByte1;
    ((etw)localObject1).NpK = paramList;
    ((etw)localObject1).NpN = System.currentTimeMillis();
    paramInt1 = ((a)com.tencent.mm.kernel.g.af(a.class)).Qr(2);
    Log.i("MicroMsg.NetSceneVoipInvite", "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((etw)localObject1).NpO = paramInt1;
      ((etw)localObject1).NpP = paramLinkedList.size();
      ((etw)localObject1).NpQ = paramLinkedList;
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
  
  public final i fIF()
  {
    AppMethodBeat.i(115238);
    i local1 = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(115236);
        e.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + g.this.GWA.mStatus);
        etx localetx = (etx)g.this.fIJ();
        paramAnonymousq = (etw)((g)paramAnonymousq).fIK();
        if ((paramAnonymousInt2 != 238) && (c.fFg().GYS.GZG))
        {
          c.fFg().b(localetx.LsZ, localetx.Lta, paramAnonymousq.NqJ);
          e.Loge("MicroMsg.NetSceneVoipInvite", " steve:[simucall] new simul call invite response  return!, DO NOT use inviteresp info,  I'm callee!!");
          AppMethodBeat.o(115236);
          return;
        }
        if (g.this.GWA.mStatus != 2)
        {
          e.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.GWA.mStatus + " should:2");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.GWA.GVV.Hbl = localetx.Nqe;
        g.this.GWA.GVV.Hbm = localetx.Nqf;
        g.this.GWA.GVV.Hbn = localetx.Nqg;
        g.this.GWA.GVV.Hbo = localetx.Nqh;
        g.this.GWA.GVV.Hbq = localetx.Nqj;
        g.this.GWA.GVV.Hbp = localetx.Nqo;
        g.this.GWA.GVV.HbV = localetx.NqZ;
        g.this.GWA.GVV.HaF = localetx.NpV;
        g.this.GWA.GVV.Hbs = localetx.Nqq;
        g.this.GWA.adl(localetx.NpT);
        g.this.GWA.GVV.HaJ = localetx.NpW;
        if ((localetx.NpX != null) && (localetx.NpX.getBuffer() != null)) {
          g.this.GWA.GVV.HaH = localetx.NpX.getBuffer().toByteArray();
        }
        if ((localetx.NpX != null) && (localetx.NpX.getILen() >= 12))
        {
          ByteBuffer localByteBuffer = ByteBuffer.wrap(localetx.NpX.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = localByteBuffer.order();
          i = localByteBuffer.getInt();
          e.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          g.this.GWA.GVV.Hbr = i;
        }
        e.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.GWA.GVV.Hbl + ",audioTsdEdge = " + g.this.GWA.GVV.Hbm + ",passthroughQosAlgorithm = " + g.this.GWA.GVV.Hbn + ",fastPlayRepair = " + g.this.GWA.GVV.Hbo + ", audioDtx = " + g.this.GWA.GVV.Hbq + ",switchtcpPktCnt = " + g.this.GWA.GVV.HaE + ",SvrCfgListV = " + g.this.GWA.GVV.Hbp + ", setMaxBRForRelay=" + g.this.GWA.GVV.Hbs + ",EnableDataAccept = " + g.this.GWA.GVV.HbV + ",WifiScanInterval = " + g.this.GWA.GVV.HaJ + ",BaseBRTuneRatio=" + g.this.GWA.GVV.Hbr);
        g.this.GWA.GVV.Hbt = localetx.Nqn;
        e.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.GWA.GVV.Hbt);
        g.this.GWA.GVV.Hbu = localetx.Nqr;
        e.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.GWA.GVV.Hbu);
        int i = e.getNetType(MMApplicationContext.getContext());
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            e.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + localetx.LsZ + "," + localetx.Lta);
            switch (paramAnonymousInt2)
            {
            default: 
              g.this.GWA.GVV.Hcw.GXc = 12;
              g.this.GWA.GVV.Hcw.GXo = 99;
              h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(5), Integer.valueOf(i) });
            }
            for (;;)
            {
              g.this.GWA.GVV.Hcw.GXd = paramAnonymousInt2;
              g.this.GWA.K(1, paramAnonymousInt2, paramAnonymousString);
              AppMethodBeat.o(115236);
              return;
              g.this.GWA.GVv = true;
              g.this.GWA.GVx = false;
              g.this.GWA.GVw = false;
              g.this.GWA.GVV.Hbk = 0;
              g.this.GWA.GVV.Hbj = 0;
              g.this.GWA.setStatus(3);
              g.this.GWA.GVV.roomId = localetx.LsZ;
              g.this.GWA.GVV.ypH = localetx.Lta;
              g.this.GWA.GVV.ypO = localetx.MKr;
              paramAnonymousString = g.this.GWA.GVV;
              paramAnonymousString.Hcx |= 0x1;
              e.Logi("MicroMsg.NetSceneVoipInvite", "steve:[simucall]: use old svr-based simulcall! iSimulCallStatus: " + g.this.GWA.GVV.Hcx);
              g.this.GWA.GVW.acR(paramAnonymousq.NqJ);
              AppMethodBeat.o(115236);
              return;
              g.this.GWA.GVV.Hcw.GXc = 13;
              g.this.GWA.GVV.Hcw.GXo = 2;
              h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.GWA.GVV.Hcw.GXc = 13;
              g.this.GWA.GVV.Hcw.GXo = 9;
              h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.GWA.GVV.Hcw.GXc = 12;
              g.this.GWA.GVV.Hcw.GXo = 12;
              h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(8), Integer.valueOf(i) });
              continue;
              g.this.GWA.GVV.Hcw.GXc = 12;
              g.this.GWA.GVV.Hcw.GXo = 1;
              h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(3), Integer.valueOf(i) });
              continue;
              g.this.GWA.GVV.Hcw.GXc = 12;
              g.this.GWA.GVV.Hcw.GXo = 10;
              h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(7), Integer.valueOf(i) });
              continue;
              g.this.GWA.GVV.Hcw.GXc = 13;
              g.this.GWA.GVV.Hcw.GXo = 11;
              h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(4), Integer.valueOf(i) });
              continue;
              Log.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + localetx.Nra + " seconds!");
              c.fFg().GZa = System.currentTimeMillis();
              if (localetx.Nra != 0) {
                c.fFg().GZb = (localetx.Nra * 1000);
              } else {
                c.fFg().GZb = 30000L;
              }
            }
          }
          g.this.GWA.GVV.Hcw.GXc = 12;
          g.this.GWA.GVV.Hcw.GXd = paramAnonymousInt2;
          g.this.GWA.GVV.Hcw.GXo = 99;
          h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(9), Integer.valueOf(i) });
          g.this.GWA.K(1, -9004, "");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.GWA.setStatus(4);
        g.this.GWA.GVV.roomId = localetx.LsZ;
        g.this.GWA.GVV.ypH = localetx.Lta;
        g.this.GWA.GVV.ypO = localetx.MKr;
        h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(1), Integer.valueOf(i) });
        if (localetx.NqY > 0)
        {
          paramAnonymousString = g.this.GWA;
          long l = localetx.NqY * 1000;
          paramAnonymousString.GWl.startTimer(l);
        }
        c.fFg().fIj();
        g.this.GWA.fGE();
        g.this.GWA.fGF();
        e.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.GWA.GVV.roomId + ",memberid = " + g.this.GWA.GVV.ypO + "VoipSyncInterval = " + localetx.NqY);
        g.this.GWA.GVW.fFO();
        e.c(c.fFg().fHU(), c.fFg().fHV(), 0, 1);
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