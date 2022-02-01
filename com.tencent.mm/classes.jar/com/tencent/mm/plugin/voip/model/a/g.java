package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n<dmn, dmo>
{
  public g(List<String> paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, LinkedList<bso> paramLinkedList)
  {
    AppMethodBeat.i(115237);
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new dmn();
    ((b.a)localObject1).gUV = new dmo();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipinvite";
    ((b.a)localObject1).funcId = 170;
    ((b.a)localObject1).reqCmdId = 63;
    ((b.a)localObject1).respCmdId = 1000000063;
    this.rr = ((b.a)localObject1).atI();
    localObject1 = (dmn)this.rr.gUS.gUX;
    Object localObject2 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      ((LinkedList)localObject2).add(new cmf().aEE((String)paramList.get(i)));
      i += 1;
    }
    ((dmn)localObject1).DZr = com.tencent.mm.model.u.aqG();
    ((dmn)localObject1).ECh = ((LinkedList)localObject2);
    ((dmn)localObject1).ECg = ((LinkedList)localObject2).size();
    ((dmn)localObject1).CYi = paramInt1;
    ((dmn)localObject1).EoJ = 0;
    ((dmn)localObject1).EBU = paramInt2;
    ((dmn)localObject1).DYV = paramInt3;
    paramList = new dnb();
    paramList.mBH = 2;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte1);
    paramList.CCV = ((SKBuiltinBuffer_t)localObject2);
    ((dmn)localObject1).EAU = paramList;
    paramList = new dnb();
    paramList.mBH = 3;
    paramArrayOfByte1 = new SKBuiltinBuffer_t();
    paramArrayOfByte1.setBuffer(paramArrayOfByte2);
    paramList.CCV = paramArrayOfByte1;
    ((dmn)localObject1).EAV = paramList;
    ((dmn)localObject1).EAY = System.currentTimeMillis();
    paramInt1 = ((a)com.tencent.mm.kernel.g.ab(a.class)).Gw(2);
    ad.i("MicroMsg.NetSceneVoipInvite", "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dmn)localObject1).EAZ = paramInt1;
      ((dmn)localObject1).EBa = paramLinkedList.size();
      ((dmn)localObject1).EBb = paramLinkedList;
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
  
  public final com.tencent.mm.al.g dVg()
  {
    AppMethodBeat.i(115238);
    com.tencent.mm.al.g local1 = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115236);
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + g.this.zjH.mStatus);
        dmo localdmo = (dmo)g.this.dVk();
        paramAnonymousn = (dmn)((g)paramAnonymousn).dVl();
        if ((paramAnonymousInt2 != 238) && (com.tencent.mm.plugin.voip.c.dRQ().zlR.zmE))
        {
          com.tencent.mm.plugin.voip.c.dRQ().a(localdmo.DdZ, localdmo.Dea, paramAnonymousn.EBU);
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.NetSceneVoipInvite", " steve:[simucall] new simul call invite response  return!, DO NOT use inviteresp info,  I'm callee!!");
          AppMethodBeat.o(115236);
          return;
        }
        if (g.this.zjH.mStatus != 2)
        {
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.zjH.mStatus + " should:2");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.zjH.ziZ.zog = localdmo.EBp;
        g.this.zjH.ziZ.zoh = localdmo.EBq;
        g.this.zjH.ziZ.zoi = localdmo.EBr;
        g.this.zjH.ziZ.zoj = localdmo.EBs;
        g.this.zjH.ziZ.zol = localdmo.EBu;
        g.this.zjH.ziZ.zok = localdmo.EBz;
        g.this.zjH.ziZ.zoQ = localdmo.ECk;
        g.this.zjH.ziZ.znB = localdmo.EBg;
        g.this.zjH.ziZ.zon = localdmo.EBB;
        g.this.zjH.Qj(localdmo.EBe);
        g.this.zjH.ziZ.znF = localdmo.EBh;
        if ((localdmo.EBi != null) && (localdmo.EBi.getBuffer() != null)) {
          g.this.zjH.ziZ.znD = localdmo.EBi.getBuffer().toByteArray();
        }
        if ((localdmo.EBi != null) && (localdmo.EBi.getILen() >= 12))
        {
          ByteBuffer localByteBuffer = ByteBuffer.wrap(localdmo.EBi.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = localByteBuffer.order();
          i = localByteBuffer.getInt();
          com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          g.this.zjH.ziZ.zom = i;
        }
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.zjH.ziZ.zog + ",audioTsdEdge = " + g.this.zjH.ziZ.zoh + ",passthroughQosAlgorithm = " + g.this.zjH.ziZ.zoi + ",fastPlayRepair = " + g.this.zjH.ziZ.zoj + ", audioDtx = " + g.this.zjH.ziZ.zol + ",switchtcpPktCnt = " + g.this.zjH.ziZ.znA + ",SvrCfgListV = " + g.this.zjH.ziZ.zok + ", setMaxBRForRelay=" + g.this.zjH.ziZ.zon + ",EnableDataAccept = " + g.this.zjH.ziZ.zoQ + ",WifiScanInterval = " + g.this.zjH.ziZ.znF + ",BaseBRTuneRatio=" + g.this.zjH.ziZ.zom);
        g.this.zjH.ziZ.zoo = localdmo.EBy;
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.zjH.ziZ.zoo);
        g.this.zjH.ziZ.zop = localdmo.EBC;
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.zjH.ziZ.zop);
        int i = com.tencent.mm.plugin.voip.b.c.getNetType(aj.getContext());
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + localdmo.DdZ + "," + localdmo.Dea);
            switch (paramAnonymousInt2)
            {
            default: 
              g.this.zjH.ziZ.zpq.zkh = 12;
              g.this.zjH.ziZ.zpq.zkt = 99;
              h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(5), Integer.valueOf(i) });
            }
            for (;;)
            {
              g.this.zjH.ziZ.zpq.zki = paramAnonymousInt2;
              g.this.zjH.I(1, paramAnonymousInt2, paramAnonymousString);
              AppMethodBeat.o(115236);
              return;
              g.this.zjH.ziz = true;
              g.this.zjH.ziB = false;
              g.this.zjH.ziA = false;
              g.this.zjH.ziZ.zof = 0;
              g.this.zjH.ziZ.zoe = 0;
              g.this.zjH.setStatus(3);
              g.this.zjH.ziZ.roomId = localdmo.DdZ;
              g.this.zjH.ziZ.sAY = localdmo.Dea;
              g.this.zjH.ziZ.sBf = localdmo.DZg;
              paramAnonymousString = g.this.zjH.ziZ;
              paramAnonymousString.zpr |= 0x1;
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.NetSceneVoipInvite", "steve:[simucall]: use old svr-based simulcall! iSimulCallStatus: " + g.this.zjH.ziZ.zpr);
              g.this.zjH.zja.PQ(paramAnonymousn.EBU);
              AppMethodBeat.o(115236);
              return;
              g.this.zjH.ziZ.zpq.zkh = 13;
              g.this.zjH.ziZ.zpq.zkt = 2;
              h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.zjH.ziZ.zpq.zkh = 13;
              g.this.zjH.ziZ.zpq.zkt = 9;
              h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.zjH.ziZ.zpq.zkh = 12;
              g.this.zjH.ziZ.zpq.zkt = 12;
              h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(8), Integer.valueOf(i) });
              continue;
              g.this.zjH.ziZ.zpq.zkh = 12;
              g.this.zjH.ziZ.zpq.zkt = 1;
              h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(3), Integer.valueOf(i) });
              continue;
              g.this.zjH.ziZ.zpq.zkh = 12;
              g.this.zjH.ziZ.zpq.zkt = 10;
              h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(7), Integer.valueOf(i) });
              continue;
              g.this.zjH.ziZ.zpq.zkh = 13;
              g.this.zjH.ziZ.zpq.zkt = 11;
              h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(4), Integer.valueOf(i) });
              continue;
              ad.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + localdmo.ECl + " seconds!");
              com.tencent.mm.plugin.voip.c.dRQ().zlZ = System.currentTimeMillis();
              if (localdmo.ECl != 0) {
                com.tencent.mm.plugin.voip.c.dRQ().zma = (localdmo.ECl * 1000);
              } else {
                com.tencent.mm.plugin.voip.c.dRQ().zma = 30000L;
              }
            }
          }
          g.this.zjH.ziZ.zpq.zkh = 12;
          g.this.zjH.ziZ.zpq.zki = paramAnonymousInt2;
          g.this.zjH.ziZ.zpq.zkt = 99;
          h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(9), Integer.valueOf(i) });
          g.this.zjH.I(1, -9004, "");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.zjH.setStatus(4);
        g.this.zjH.ziZ.roomId = localdmo.DdZ;
        g.this.zjH.ziZ.sAY = localdmo.Dea;
        g.this.zjH.ziZ.sBf = localdmo.DZg;
        h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(1), Integer.valueOf(i) });
        if (localdmo.ECj > 0)
        {
          paramAnonymousString = g.this.zjH;
          long l = localdmo.ECj * 1000;
          paramAnonymousString.zjs.av(l, l);
        }
        com.tencent.mm.plugin.voip.c.dRQ().dUK();
        g.this.zjH.dTl();
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.zjH.ziZ.roomId + ",memberid = " + g.this.zjH.ziZ.sBf + "VoipSyncInterval = " + localdmo.ECj);
        g.this.zjH.zja.dSu();
        com.tencent.mm.plugin.voip.b.c.c(com.tencent.mm.plugin.voip.c.dRQ().dUz(), com.tencent.mm.plugin.voip.c.dRQ().dUA(), 0, 1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.g
 * JD-Core Version:    0.7.0.1
 */