package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.io.IOException;
import java.util.LinkedList;

public final class v
{
  k ttm;
  csu tzA;
  private csj tzB;
  private int tzC;
  
  public v(k paramk)
  {
    AppMethodBeat.i(4682);
    this.ttm = null;
    this.tzA = new csu();
    this.tzB = null;
    this.tzC = 0;
    this.ttm = paramk;
    AppMethodBeat.o(4682);
  }
  
  private void a(csj paramcsj)
  {
    AppMethodBeat.i(4684);
    if (paramcsj == null)
    {
      a.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
      this.tzC += 1;
      AppMethodBeat.o(4684);
      return;
    }
    if (this.tzB == null) {
      this.tzB = new csj();
    }
    int i = 0;
    while (i < paramcsj.jJu)
    {
      csi localcsi = (csi)paramcsj.jJv.get(i);
      this.tzB.jJv.add(localcsi);
      i += 1;
    }
    this.tzB.jJu = this.tzB.jJv.size();
    AppMethodBeat.o(4684);
  }
  
  private void b(csj paramcsj)
  {
    AppMethodBeat.i(4685);
    if ((this.tzB == null) || (this.tzB.jJu <= 0))
    {
      AppMethodBeat.o(4685);
      return;
    }
    int i = 0;
    while (i < this.tzB.jJu)
    {
      csi localcsi = (csi)this.tzB.jJv.get(i);
      paramcsj.jJv.add(localcsi);
      i += 1;
    }
    paramcsj.jJu = paramcsj.jJv.size();
    cOo();
    AppMethodBeat.o(4685);
  }
  
  public final void HE(int paramInt)
  {
    AppMethodBeat.i(4683);
    Object localObject2 = a.HI(paramInt);
    Object localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = new SKBuiltinBuffer_t();
    try
    {
      ((SKBuiltinBuffer_t)localObject2).setBuffer(((SKBuiltinBuffer_t)localObject1).toByteArray());
      localObject1 = new csi();
      ((csi)localObject1).wMC = 3;
      ((csi)localObject1).wMD = ((SKBuiltinBuffer_t)localObject2);
      ((csi)localObject1).num = r.Zn();
      localObject2 = new csj();
      ((csj)localObject2).jJu = 1;
      ((csj)localObject2).jJv.add(localObject1);
      a((csj)localObject2, false, 4);
      AppMethodBeat.o(4683);
      return;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
      AppMethodBeat.o(4683);
    }
  }
  
  public final int a(csj paramcsj, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(4687);
    if (this.ttm.tvj.nMZ == 0)
    {
      a.Loge("MicroMsg.Voip.VoipSyncHandle", com.tencent.mm.compatible.util.g.Ml() + "failed to do voip sync , roomid = 0");
      AppMethodBeat.o(4687);
      return 0;
    }
    if (this.ttm.tvp)
    {
      a.Loge("MicroMsg.Voip.VoipSyncHandle", com.tencent.mm.compatible.util.g.Ml() + "voip syncing, push to cache...");
      a(paramcsj);
      AppMethodBeat.o(4687);
      return 0;
    }
    this.ttm.tvp = true;
    if (paramcsj == null)
    {
      paramcsj = new csj();
      paramcsj.jJu = 0;
      paramcsj.jJv = new LinkedList();
    }
    for (;;)
    {
      b(paramcsj);
      this.tzC = 0;
      if (this.ttm.tvn == null) {
        this.ttm.tvn = "".getBytes();
      }
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + paramBoolean + ",cmdList:" + paramcsj.jJu + ",syncKey.length:" + this.ttm.tvn.length + ",selector:" + paramInt);
      new com.tencent.mm.plugin.voip.model.a.m(this.ttm.tvj.nMZ, paramcsj, this.ttm.tvn, this.ttm.tvj.nNa, paramInt).cOs();
      AppMethodBeat.o(4687);
      return 0;
    }
  }
  
  public final void a(cta paramcta)
  {
    AppMethodBeat.i(4689);
    com.tencent.mm.kernel.g.RO().ac(new v.1(this, paramcta));
    AppMethodBeat.o(4689);
  }
  
  public final void a(ctl paramctl, int paramInt)
  {
    AppMethodBeat.i(4688);
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + paramctl.jJS);
    if (paramctl.jJS == 1)
    {
      this.ttm.tuI = true;
      if (1 == paramInt) {
        this.ttm.tvj.tBN.cMs();
      }
      if (3 == paramInt) {
        this.ttm.tvj.tBN.cMt();
      }
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(paramInt)));
      this.ttm.tvk.bII();
      com.tencent.mm.plugin.voip.b.cLC().tyR.cOn();
      this.ttm.tuJ = true;
      if (this.ttm.tuL == true)
      {
        this.ttm.tuL = false;
        if (this.ttm.tuH != true) {
          break label247;
        }
        a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
        this.ttm.cMf();
      }
      for (;;)
      {
        h.qsU.e(11519, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(2) });
        this.ttm.cMk();
        this.ttm.cMm();
        AppMethodBeat.o(4688);
        return;
        label247:
        if (this.ttm.tuK == true)
        {
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
          this.ttm.y(1, -9000, "");
        }
        else
        {
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
        }
      }
    }
    if (paramctl.jJS == 6)
    {
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
      this.ttm.tuL = true;
      this.ttm.tvj.tAF = 1;
      this.ttm.cMk();
      AppMethodBeat.o(4688);
      return;
    }
    if (paramctl.jJS == 8)
    {
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
      this.ttm.tvj.tBN.twc = 211;
      this.ttm.tvj.tBN.twb = 11;
      this.ttm.tvj.tBN.twn = 12;
      h.qsU.e(11519, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(3) });
      this.ttm.y(1, 211, "");
      this.ttm.cMm();
      AppMethodBeat.o(4688);
      return;
    }
    if (paramctl.jJS == 2)
    {
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
      this.ttm.tvj.tBN.twb = 103;
      this.ttm.tvj.tBN.twn = 4;
      this.ttm.tvj.tBN.twu = ((int)(System.currentTimeMillis() - this.ttm.tvj.tBN.beginTime));
      h.qsU.e(11519, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNU()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cNV()), Long.valueOf(com.tencent.mm.plugin.voip.b.cLC().cMb()), Integer.valueOf(1) });
      this.ttm.cMm();
      this.ttm.y(4, 0, "");
      AppMethodBeat.o(4688);
      return;
    }
    if (paramctl.jJS == 3)
    {
      this.ttm.tvj.tBN.twn = 5;
      AppMethodBeat.o(4688);
      return;
    }
    if (paramctl.jJS == 4)
    {
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
      if (this.ttm.mStatus < 6) {
        this.ttm.tvj.tBN.two = 1;
      }
      this.ttm.tvj.tBN.twb = 110;
      this.ttm.y(6, 0, "");
      this.ttm.cMm();
      AppMethodBeat.o(4688);
      return;
    }
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + paramctl.jJS);
    AppMethodBeat.o(4688);
  }
  
  public final void b(cta paramcta)
  {
    AppMethodBeat.i(4690);
    this.ttm.bt(paramcta.wtq.getBuffer().toByteArray());
    AppMethodBeat.o(4690);
  }
  
  public final void c(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(4691);
    int i = a.by(paramSKBuiltinBuffer_t.getBuffer().toByteArray());
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(i)));
    this.ttm.Hj(i & 0xFF);
    AppMethodBeat.o(4691);
  }
  
  public final void cOo()
  {
    AppMethodBeat.i(4686);
    if (this.tzB == null)
    {
      AppMethodBeat.o(4686);
      return;
    }
    this.tzB.jJv.clear();
    this.tzB.jJu = 0;
    this.tzB = null;
    this.tzC = 0;
    AppMethodBeat.o(4686);
  }
  
  public final void o(com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(4692);
    ab.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
    this.ttm.tvp = false;
    Object localObject1 = (ctn)((com.tencent.mm.plugin.voip.model.a.m)paramm).cOt();
    if (this.ttm.tvn == null)
    {
      AppMethodBeat.o(4692);
      return;
    }
    this.ttm.tvj.parseSyncKeyBuff(this.ttm.tvn, this.ttm.tvn.length);
    int j = this.ttm.tvj.field_statusSyncKey;
    int k = this.ttm.tvj.field_relayDataSyncKey;
    int m = this.ttm.tvj.field_connectingStatusKey;
    this.ttm.tvj.parseSyncKeyBuff(((ctn)localObject1).wFR.getBuffer().toByteArray(), ((ctn)localObject1).wFR.getILen());
    int n = this.ttm.tvj.field_statusSyncKey;
    int i1 = this.ttm.tvj.field_relayDataSyncKey;
    int i2 = this.ttm.tvj.field_connectingStatusKey;
    ab.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + j + " oldRelayDataSyncKey:" + k + " oldConnectingStatusSyncKey:" + m);
    ab.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + n + " newRelayDataSyncKey:" + i1 + " newConnectingStatusSyncKey:" + i2);
    this.ttm.tvn = ((ctn)localObject1).wFR.getBuffer().toByteArray();
    ab.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + ((ctn)localObject1).wBX);
    localObject1 = ((ctn)localObject1).ycD.jJv;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0))
    {
      ab.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + ((LinkedList)localObject1).size());
      int i = ((com.tencent.mm.plugin.voip.model.a.m)paramm).cOr();
      ab.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + ((LinkedList)localObject1).size() + ",selector = " + i);
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        paramm = (csi)((LinkedList)localObject1).get(i);
        int i3 = paramm.wMC;
        ab.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i3)));
        if (i3 == 1) {
          if (n > j)
          {
            if (this.ttm.tvj.nMZ != 0) {
              break label487;
            }
            a.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label487:
          Object localObject2;
          try
          {
            localObject2 = (ctl)new ctl().parseFrom(paramm.wMD.getBuffer().toByteArray());
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + paramm.num + ",itemStatus =  " + ((ctl)localObject2).jJS);
            a((ctl)localObject2, 3);
          }
          catch (IOException paramm)
          {
            ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramm, "", new Object[0]);
          }
          continue;
          if (i3 == 2)
          {
            if (i1 > k) {
              if (this.ttm.tvj.nMZ == 0)
              {
                a.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
              }
              else
              {
                try
                {
                  localObject2 = (cta)new cta().parseFrom(paramm.wMD.getBuffer().toByteArray());
                  a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + ((cta)localObject2).jKs + ",from user = " + paramm.num);
                  if (((cta)localObject2).jKs != 5) {
                    break label712;
                  }
                  a((cta)localObject2);
                }
                catch (IOException paramm)
                {
                  ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramm, "", new Object[0]);
                }
                continue;
                label712:
                if (((cta)localObject2).jKs == 3)
                {
                  this.ttm.bs(((cta)localObject2).wtq.getBuffer().toByteArray());
                  if ((((cta)localObject2).wtq != null) && (((cta)localObject2).wtq.getBuffer() != null)) {
                    this.tzA.xZY = ((cta)localObject2);
                  }
                }
                else if (((cta)localObject2).jKs == 2)
                {
                  this.ttm.br(((cta)localObject2).wtq.getBuffer().toByteArray());
                  if ((((cta)localObject2).wtq != null) && (((cta)localObject2).wtq.getBuffer() != null)) {
                    this.tzA.xZX = ((cta)localObject2);
                  }
                }
                else if (((cta)localObject2).jKs == 1)
                {
                  b((cta)localObject2);
                }
              }
            }
          }
          else if ((i3 == 3) && (i2 > m)) {
            if (this.ttm.tvj.nMZ == 0)
            {
              ab.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
            }
            else
            {
              try
              {
                localObject2 = new SKBuiltinBuffer_t().parseFrom(paramm.wMD.getBuffer().toByteArray());
                if (!paramm.num.equals(r.Zn())) {
                  break label945;
                }
                a.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
              }
              catch (IOException paramm)
              {
                ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramm, "", new Object[0]);
              }
              continue;
              label945:
              c((SKBuiltinBuffer_t)localObject2);
            }
          }
        }
      }
    }
    ab.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
    if (((this.tzB != null) && (this.tzB.jJu > 0)) || (this.tzC > 0)) {
      a(null, false, 7);
    }
    AppMethodBeat.o(4692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v
 * JD-Core Version:    0.7.0.1
 */