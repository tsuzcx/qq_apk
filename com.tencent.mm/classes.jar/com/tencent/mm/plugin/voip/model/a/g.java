package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.protocal.protobuf.dxz;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.List;

public final class g
  extends n<dxy, dxz>
{
  public g(List<String> paramList, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, LinkedList<cbv> paramLinkedList)
  {
    AppMethodBeat.i(115237);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hNM = new dxy();
    ((b.a)localObject1).hNN = new dxz();
    ((b.a)localObject1).uri = "/cgi-bin/micromsg-bin/voipinvite";
    ((b.a)localObject1).funcId = 170;
    ((b.a)localObject1).hNO = 63;
    ((b.a)localObject1).respCmdId = 1000000063;
    this.rr = ((b.a)localObject1).aDC();
    localObject1 = (dxy)this.rr.hNK.hNQ;
    Object localObject2 = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      ((LinkedList)localObject2).add(new cwt().aPy((String)paramList.get(i)));
      i += 1;
    }
    ((dxy)localObject1).Hgt = com.tencent.mm.model.u.aAm();
    ((dxy)localObject1).HKq = ((LinkedList)localObject2);
    ((dxy)localObject1).HKp = ((LinkedList)localObject2).size();
    ((dxy)localObject1).FYc = paramInt1;
    ((dxy)localObject1).Hwq = 0;
    ((dxy)localObject1).HKd = paramInt2;
    ((dxy)localObject1).HfX = paramInt3;
    paramList = new dym();
    paramList.nEf = 2;
    localObject2 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject2).setBuffer(paramArrayOfByte1);
    paramList.FAN = ((SKBuiltinBuffer_t)localObject2);
    ((dxy)localObject1).HJd = paramList;
    paramList = new dym();
    paramList.nEf = 3;
    paramArrayOfByte1 = new SKBuiltinBuffer_t();
    paramArrayOfByte1.setBuffer(paramArrayOfByte2);
    paramList.FAN = paramArrayOfByte1;
    ((dxy)localObject1).HJe = paramList;
    ((dxy)localObject1).HJh = System.currentTimeMillis();
    paramInt1 = ((a)com.tencent.mm.kernel.g.ab(a.class)).JP(2);
    ad.i("MicroMsg.NetSceneVoipInvite", "simType: %s", new Object[] { Integer.valueOf(paramInt1) });
    if (paramInt1 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      ((dxy)localObject1).HJi = paramInt1;
      ((dxy)localObject1).HJj = paramLinkedList.size();
      ((dxy)localObject1).HJk = paramLinkedList;
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
  
  public final com.tencent.mm.al.f eyd()
  {
    AppMethodBeat.i(115238);
    com.tencent.mm.al.f local1 = new com.tencent.mm.al.f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
      {
        AppMethodBeat.i(115236);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " status:" + g.this.Cbq.mStatus);
        dxz localdxz = (dxz)g.this.eyh();
        paramAnonymousn = (dxy)((g)paramAnonymousn).eyi();
        if ((paramAnonymousInt2 != 238) && (c.euM().CdF.Cer))
        {
          c.euM().b(localdxz.GeI, localdxz.GeJ, paramAnonymousn.HKd);
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipInvite", " steve:[simucall] new simul call invite response  return!, DO NOT use inviteresp info,  I'm callee!!");
          AppMethodBeat.o(115236);
          return;
        }
        if (g.this.Cbq.mStatus != 2)
        {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + g.this.Cbq.mStatus + " should:2");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.Cbq.CaI.CfW = localdxz.HJy;
        g.this.Cbq.CaI.CfX = localdxz.HJz;
        g.this.Cbq.CaI.CfY = localdxz.HJA;
        g.this.Cbq.CaI.CfZ = localdxz.HJB;
        g.this.Cbq.CaI.Cgb = localdxz.HJD;
        g.this.Cbq.CaI.Cga = localdxz.HJI;
        g.this.Cbq.CaI.CgG = localdxz.HKt;
        g.this.Cbq.CaI.Cfp = localdxz.HJp;
        g.this.Cbq.CaI.Cgd = localdxz.HJK;
        g.this.Cbq.Uk(localdxz.HJn);
        g.this.Cbq.CaI.Cft = localdxz.HJq;
        if ((localdxz.HJr != null) && (localdxz.HJr.getBuffer() != null)) {
          g.this.Cbq.CaI.Cfr = localdxz.HJr.getBuffer().toByteArray();
        }
        if ((localdxz.HJr != null) && (localdxz.HJr.getILen() >= 12))
        {
          ByteBuffer localByteBuffer = ByteBuffer.wrap(localdxz.HJr.getBuffer().toByteArray(), 8, 4);
          ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
          ByteOrder localByteOrder2 = localByteBuffer.order();
          i = localByteBuffer.getInt();
          com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
          g.this.Cbq.CaI.Cgc = i;
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + g.this.Cbq.CaI.CfW + ",audioTsdEdge = " + g.this.Cbq.CaI.CfX + ",passthroughQosAlgorithm = " + g.this.Cbq.CaI.CfY + ",fastPlayRepair = " + g.this.Cbq.CaI.CfZ + ", audioDtx = " + g.this.Cbq.CaI.Cgb + ",switchtcpPktCnt = " + g.this.Cbq.CaI.Cfo + ",SvrCfgListV = " + g.this.Cbq.CaI.Cga + ", setMaxBRForRelay=" + g.this.Cbq.CaI.Cgd + ",EnableDataAccept = " + g.this.Cbq.CaI.CgG + ",WifiScanInterval = " + g.this.Cbq.CaI.Cft + ",BaseBRTuneRatio=" + g.this.Cbq.CaI.Cgc);
        g.this.Cbq.CaI.Cge = localdxz.HJH;
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + g.this.Cbq.CaI.Cge);
        g.this.Cbq.CaI.Cgf = localdxz.HJL;
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + g.this.Cbq.CaI.Cgf);
        int i = com.tencent.mm.plugin.voip.b.f.getNetType(aj.getContext());
        if (paramAnonymousInt1 != 0)
        {
          if (paramAnonymousInt1 == 4)
          {
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + localdxz.GeI + "," + localdxz.GeJ);
            switch (paramAnonymousInt2)
            {
            default: 
              g.this.Cbq.CaI.Chg.CbS = 12;
              g.this.Cbq.CaI.Chg.Cce = 99;
              com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(5), Integer.valueOf(i) });
            }
            for (;;)
            {
              g.this.Cbq.CaI.Chg.CbT = paramAnonymousInt2;
              g.this.Cbq.J(1, paramAnonymousInt2, paramAnonymousString);
              AppMethodBeat.o(115236);
              return;
              g.this.Cbq.Cai = true;
              g.this.Cbq.Cak = false;
              g.this.Cbq.Caj = false;
              g.this.Cbq.CaI.CfV = 0;
              g.this.Cbq.CaI.CfU = 0;
              g.this.Cbq.setStatus(3);
              g.this.Cbq.CaI.roomId = localdxz.GeI;
              g.this.Cbq.CaI.uLt = localdxz.GeJ;
              g.this.Cbq.CaI.uLA = localdxz.Hgi;
              paramAnonymousString = g.this.Cbq.CaI;
              paramAnonymousString.Chh |= 0x1;
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "steve:[simucall]: use old svr-based simulcall! iSimulCallStatus: " + g.this.Cbq.CaI.Chh);
              g.this.Cbq.CaJ.TR(paramAnonymousn.HKd);
              AppMethodBeat.o(115236);
              return;
              g.this.Cbq.CaI.Chg.CbS = 13;
              g.this.Cbq.CaI.Chg.Cce = 2;
              com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.Cbq.CaI.Chg.CbS = 13;
              g.this.Cbq.CaI.Chg.Cce = 9;
              com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(2), Integer.valueOf(i) });
              continue;
              g.this.Cbq.CaI.Chg.CbS = 12;
              g.this.Cbq.CaI.Chg.Cce = 12;
              com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(8), Integer.valueOf(i) });
              continue;
              g.this.Cbq.CaI.Chg.CbS = 12;
              g.this.Cbq.CaI.Chg.Cce = 1;
              com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(3), Integer.valueOf(i) });
              continue;
              g.this.Cbq.CaI.Chg.CbS = 12;
              g.this.Cbq.CaI.Chg.Cce = 10;
              com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(7), Integer.valueOf(i) });
              continue;
              g.this.Cbq.CaI.Chg.CbS = 13;
              g.this.Cbq.CaI.Chg.Cce = 11;
              com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(4), Integer.valueOf(i) });
              continue;
              ad.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + localdxz.HKu + " seconds!");
              c.euM().CdN = System.currentTimeMillis();
              if (localdxz.HKu != 0) {
                c.euM().CdO = (localdxz.HKu * 1000);
              } else {
                c.euM().CdO = 30000L;
              }
            }
          }
          g.this.Cbq.CaI.Chg.CbS = 12;
          g.this.Cbq.CaI.Chg.CbT = paramAnonymousInt2;
          g.this.Cbq.CaI.Chg.Cce = 99;
          com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(9), Integer.valueOf(i) });
          g.this.Cbq.J(1, -9004, "");
          AppMethodBeat.o(115236);
          return;
        }
        g.this.Cbq.setStatus(4);
        g.this.Cbq.CaI.roomId = localdxz.GeI;
        g.this.Cbq.CaI.uLt = localdxz.GeJ;
        g.this.Cbq.CaI.uLA = localdxz.Hgi;
        com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(1), Integer.valueOf(i) });
        if (localdxz.HKs > 0)
        {
          paramAnonymousString = g.this.Cbq;
          long l = localdxz.HKs * 1000;
          paramAnonymousString.Cbb.az(l, l);
        }
        c.euM().exH();
        g.this.Cbq.ewi();
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + g.this.Cbq.CaI.roomId + ",memberid = " + g.this.Cbq.CaI.uLA + "VoipSyncInterval = " + localdxz.HKs);
        g.this.Cbq.CaJ.evr();
        com.tencent.mm.plugin.voip.b.f.c(c.euM().exw(), c.euM().exx(), 0, 1);
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