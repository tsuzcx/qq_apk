package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cex;
import com.tencent.mm.protocal.c.cey;
import com.tencent.mm.protocal.c.cfj;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.protocal.c.cga;
import com.tencent.mm.protocal.c.cgc;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.LinkedList;

public final class t
{
  j pNq = null;
  cfj pTY = new cfj();
  private cey pTZ = null;
  private int pUa = 0;
  
  public t(j paramj)
  {
    this.pNq = paramj;
  }
  
  private void a(cey paramcey)
  {
    if (paramcey == null)
    {
      a.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
      this.pUa += 1;
      return;
    }
    if (this.pTZ == null) {
      this.pTZ = new cey();
    }
    int i = 0;
    while (i < paramcey.hPS)
    {
      cex localcex = (cex)paramcey.hPT.get(i);
      this.pTZ.hPT.add(localcex);
      i += 1;
    }
    this.pTZ.hPS = this.pTZ.hPT.size();
  }
  
  private void b(cey paramcey)
  {
    if ((this.pTZ == null) || (this.pTZ.hPS <= 0)) {
      return;
    }
    int i = 0;
    while (i < this.pTZ.hPS)
    {
      cex localcex = (cex)this.pTZ.hPT.get(i);
      paramcey.hPT.add(localcex);
      i += 1;
    }
    paramcey.hPS = paramcey.hPT.size();
    bRx();
  }
  
  public final int a(cey paramcey, boolean paramBoolean, int paramInt)
  {
    if (this.pNq.pQe.lpD == 0)
    {
      a.Loge("MicroMsg.Voip.VoipSyncHandle", com.tencent.mm.compatible.util.g.zI() + "failed to do voip sync , roomid = 0");
      return 0;
    }
    if (this.pNq.pQk)
    {
      a.Loge("MicroMsg.Voip.VoipSyncHandle", com.tencent.mm.compatible.util.g.zI() + "voip syncing, push to cache...");
      a(paramcey);
      return 0;
    }
    this.pNq.pQk = true;
    if (paramcey == null)
    {
      paramcey = new cey();
      paramcey.hPS = 0;
      paramcey.hPT = new LinkedList();
    }
    for (;;)
    {
      b(paramcey);
      this.pUa = 0;
      if (this.pNq.pQi == null) {
        this.pNq.pQi = "".getBytes();
      }
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + paramBoolean + ",cmdList:" + paramcey.hPS + ",syncKey.length:" + this.pNq.pQi.length + ",selector:" + paramInt);
      new com.tencent.mm.plugin.voip.model.a.m(this.pNq.pQe.lpD, paramcey, this.pNq.pQi, this.pNq.pQe.lpE, paramInt).bRB();
      return 0;
    }
  }
  
  public final void a(cfp paramcfp)
  {
    com.tencent.mm.kernel.g.DS().O(new t.1(this, paramcfp));
  }
  
  public final void a(cga paramcga, int paramInt)
  {
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + paramcga.hQq);
    if (paramcga.hQq == 1)
    {
      this.pNq.pPD = true;
      if (1 == paramInt)
      {
        paramcga = this.pNq.pQe.pWi;
        if (0L == paramcga.pRw)
        {
          paramcga.pRw = System.currentTimeMillis();
          a.Logi("MicroMsg.VoipDailReport", "accept received timestamp:" + paramcga.pRw);
        }
      }
      if (3 == paramInt)
      {
        paramcga = this.pNq.pQe.pWi;
        if (0L == paramcga.pRx)
        {
          paramcga.pRx = System.currentTimeMillis();
          a.Logi("MicroMsg.VoipDailReport", "sync accept received timestamp:" + paramcga.pRx);
        }
      }
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: " + paramInt);
      this.pNq.pQf.bbA();
      com.tencent.mm.plugin.voip.b.bPx().pTq.bRw();
      this.pNq.pPE = true;
      if (this.pNq.pPG == true)
      {
        this.pNq.pPG = false;
        if (this.pNq.pPC != true) {
          break label317;
        }
        a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
        this.pNq.bQa();
      }
      for (;;)
      {
        h.nFQ.f(11519, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(2) });
        this.pNq.bQg();
        this.pNq.bQi();
        return;
        label317:
        if (this.pNq.pPF == true)
        {
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
          this.pNq.s(1, -9000, "");
        }
        else
        {
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
        }
      }
    }
    if (paramcga.hQq == 6)
    {
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
      this.pNq.pPG = true;
      this.pNq.pQe.pVd = 1;
      this.pNq.bQg();
      return;
    }
    if (paramcga.hQq == 8)
    {
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
      this.pNq.pQe.pWi.pQV = 211;
      this.pNq.pQe.pWi.pQU = 11;
      this.pNq.pQe.pWi.pRg = 12;
      h.nFQ.f(11519, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(3) });
      this.pNq.s(1, 211, "");
      this.pNq.bQi();
      return;
    }
    if (paramcga.hQq == 2)
    {
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
      this.pNq.pQe.pWi.pQU = 103;
      this.pNq.pQe.pWi.pRg = 4;
      this.pNq.pQe.pWi.pRn = ((int)(System.currentTimeMillis() - this.pNq.pQe.pWi.beginTime));
      h.nFQ.f(11519, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(1) });
      this.pNq.bQi();
      this.pNq.s(4, 0, "");
      return;
    }
    if (paramcga.hQq == 3)
    {
      this.pNq.pQe.pWi.pRg = 5;
      return;
    }
    if (paramcga.hQq == 4)
    {
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
      if (this.pNq.mStatus < 6) {
        this.pNq.pQe.pWi.pRh = 1;
      }
      this.pNq.pQe.pWi.pQU = 110;
      this.pNq.s(6, 0, "");
      this.pNq.bQi();
      return;
    }
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + paramcga.hQq);
  }
  
  public final void b(cfp paramcfp)
  {
    j localj = this.pNq;
    paramcfp = paramcfp.szp.tFM.toByteArray();
    localj.pQe.pUD = paramcfp;
    localj.bQh();
  }
  
  public final void bRx()
  {
    if (this.pTZ == null) {
      return;
    }
    this.pTZ.hPT.clear();
    this.pTZ.hPS = 0;
    this.pTZ = null;
    this.pUa = 0;
  }
  
  public final void c(bmk parambmk)
  {
    int i = a.aX(parambmk.tFM.toByteArray());
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = " + i);
    parambmk = this.pNq;
    i &= 0xFF;
    if ((8 == i) || (9 == i)) {
      parambmk.pPW = i;
    }
    for (;;)
    {
      if ((1 == i) || (3 == i)) {
        parambmk.zY(2);
      }
      parambmk.pQf.Ah(i);
      return;
      parambmk.pPU = i;
      parambmk.pPS = i;
    }
  }
  
  public final void o(com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
    this.pNq.pQk = false;
    Object localObject1 = (cgc)((com.tencent.mm.plugin.voip.model.a.m)paramm).bRC();
    this.pNq.pQe.parseSyncKeyBuff(this.pNq.pQi, this.pNq.pQi.length);
    int j = this.pNq.pQe.field_statusSyncKey;
    int k = this.pNq.pQe.field_relayDataSyncKey;
    int m = this.pNq.pQe.field_connectingStatusKey;
    this.pNq.pQe.parseSyncKeyBuff(((cgc)localObject1).sIi.tFM.toByteArray(), ((cgc)localObject1).sIi.tFK);
    int n = this.pNq.pQe.field_statusSyncKey;
    int i1 = this.pNq.pQe.field_relayDataSyncKey;
    int i2 = this.pNq.pQe.field_connectingStatusKey;
    y.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + j + " oldRelayDataSyncKey:" + k + " oldConnectingStatusSyncKey:" + m);
    y.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + n + " newRelayDataSyncKey:" + i1 + " newConnectingStatusSyncKey:" + i2);
    this.pNq.pQi = ((cgc)localObject1).sIi.tFM.toByteArray();
    y.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + ((cgc)localObject1).sFD);
    localObject1 = ((cgc)localObject1).tVm.hPT;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0))
    {
      y.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + ((LinkedList)localObject1).size());
      int i = ((com.tencent.mm.plugin.voip.model.a.m)paramm).bRA();
      y.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + ((LinkedList)localObject1).size() + ",selector = " + i);
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        paramm = (cex)((LinkedList)localObject1).get(i);
        int i3 = paramm.sOA;
        y.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:" + i3);
        if (i3 == 1) {
          if (n > j)
          {
            if (this.pNq.pQe.lpD != 0) {
              break label471;
            }
            a.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label471:
          Object localObject2;
          try
          {
            localObject2 = (cga)new cga().aH(paramm.sOB.tFM.toByteArray());
            a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + paramm.kWn + ",itemStatus =  " + ((cga)localObject2).hQq);
            a((cga)localObject2, 3);
          }
          catch (IOException paramm)
          {
            y.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramm, "", new Object[0]);
          }
          continue;
          if (i3 == 2)
          {
            if (i1 > k) {
              if (this.pNq.pQe.lpD == 0)
              {
                a.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
              }
              else
              {
                try
                {
                  localObject2 = (cfp)new cfp().aH(paramm.sOB.tFM.toByteArray());
                  a.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + ((cfp)localObject2).hQR + ",from user = " + paramm.kWn);
                  if (((cfp)localObject2).hQR != 5) {
                    break label696;
                  }
                  a((cfp)localObject2);
                }
                catch (IOException paramm)
                {
                  y.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramm, "", new Object[0]);
                }
                continue;
                label696:
                if (((cfp)localObject2).hQR == 3)
                {
                  this.pNq.aS(((cfp)localObject2).szp.tFM.toByteArray());
                  if ((((cfp)localObject2).szp != null) && (((cfp)localObject2).szp.tFM != null)) {
                    this.pTY.tSG = ((cfp)localObject2);
                  }
                }
                else if (((cfp)localObject2).hQR == 2)
                {
                  this.pNq.aR(((cfp)localObject2).szp.tFM.toByteArray());
                  if ((((cfp)localObject2).szp != null) && (((cfp)localObject2).szp.tFM != null)) {
                    this.pTY.tSF = ((cfp)localObject2);
                  }
                }
                else if (((cfp)localObject2).hQR == 1)
                {
                  b((cfp)localObject2);
                }
              }
            }
          }
          else if ((i3 == 3) && (i2 > m)) {
            if (this.pNq.pQe.lpD == 0)
            {
              y.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
            }
            else
            {
              try
              {
                localObject2 = new bmk().bt(paramm.sOB.tFM.toByteArray());
                if (!paramm.kWn.equals(q.Gj())) {
                  break label929;
                }
                a.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
              }
              catch (IOException paramm)
              {
                y.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramm, "", new Object[0]);
              }
              continue;
              label929:
              c((bmk)localObject2);
            }
          }
        }
      }
    }
    y.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
    if (((this.pTZ != null) && (this.pTZ.hPS > 0)) || (this.pUa > 0)) {
      a(null, false, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.t
 * JD-Core Version:    0.7.0.1
 */