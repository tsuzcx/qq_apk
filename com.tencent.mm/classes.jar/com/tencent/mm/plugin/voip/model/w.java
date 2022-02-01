package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.c.e;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.protobuf.ahu;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fdc;
import com.tencent.mm.protocal.protobuf.fdx;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.protocal.protobuf.feo;
import com.tencent.mm.protocal.protobuf.fep;
import com.tencent.mm.protocal.protobuf.fev;
import com.tencent.mm.protocal.protobuf.ffg;
import com.tencent.mm.protocal.protobuf.ffi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.IOException;
import java.util.LinkedList;

public final class w
{
  l NJk;
  fep NQa;
  private fdy NQb;
  private int NQc;
  
  public w(l paraml)
  {
    AppMethodBeat.i(115201);
    this.NJk = null;
    this.NQa = new fep();
    this.NQb = null;
    this.NQc = 0;
    this.NJk = paraml;
    AppMethodBeat.o(115201);
  }
  
  private void a(fdy paramfdy)
  {
    AppMethodBeat.i(115203);
    if (paramfdy == null)
    {
      e.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
      this.NQc += 1;
      AppMethodBeat.o(115203);
      return;
    }
    if (this.NQb == null) {
      this.NQb = new fdy();
    }
    int i = 0;
    while (i < paramfdy.rVx)
    {
      fdx localfdx = (fdx)paramfdy.rVy.get(i);
      this.NQb.rVy.add(localfdx);
      i += 1;
    }
    this.NQb.rVx = this.NQb.rVy.size();
    AppMethodBeat.o(115203);
  }
  
  private void b(fdy paramfdy)
  {
    AppMethodBeat.i(115204);
    if ((this.NQb == null) || (this.NQb.rVx <= 0))
    {
      AppMethodBeat.o(115204);
      return;
    }
    int i = 0;
    while (i < this.NQb.rVx)
    {
      fdx localfdx = (fdx)this.NQb.rVy.get(i);
      paramfdy.rVy.add(localfdx);
      i += 1;
    }
    paramfdy.rVx = paramfdy.rVy.size();
    gAT();
    AppMethodBeat.o(115204);
  }
  
  public final int a(fdy paramfdy, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(115206);
    if (this.NJk.NMi.roomId == 0)
    {
      e.Loge("MicroMsg.Voip.VoipSyncHandle", f.avD() + "failed to do voip sync , roomid = 0");
      AppMethodBeat.o(115206);
      return 0;
    }
    if (this.NJk.NMo)
    {
      e.Loge("MicroMsg.Voip.VoipSyncHandle", f.avD() + "voip syncing, push to cache...");
      a(paramfdy);
      AppMethodBeat.o(115206);
      return 0;
    }
    this.NJk.NMo = true;
    if (paramfdy == null)
    {
      paramfdy = new fdy();
      paramfdy.rVx = 0;
      paramfdy.rVy = new LinkedList();
    }
    for (;;)
    {
      b(paramfdy);
      this.NQc = 0;
      if (this.NJk.NMm == null) {
        this.NJk.NMm = "".getBytes();
      }
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + paramBoolean + ",cmdList:" + paramfdy.rVx + ",syncKey.length:" + this.NJk.NMm.length + ",selector:" + paramInt);
      new m(this.NJk.NMi.roomId, paramfdy, this.NJk.NMm, this.NJk.NMi.DPJ, paramInt).gAX();
      AppMethodBeat.o(115206);
      return 0;
    }
  }
  
  public final void a(final feo paramfeo)
  {
    AppMethodBeat.i(115208);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115200);
        MMHandlerThread.postToMainThread(new w.2(w.this, paramfeo));
        AppMethodBeat.o(115200);
      }
    });
    AppMethodBeat.o(115208);
  }
  
  public final void a(final fev paramfev)
  {
    AppMethodBeat.i(115209);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177026);
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
        Object localObject1 = paramfev.RNM.Tkb.toByteArray();
        int i;
        for (;;)
        {
          try
          {
            localObject1 = (fep)new fep().parseFrom((byte[])localObject1);
            if ((((fep)localObject1).UCF != null) && (((fep)localObject1).UCF.RNM != null) && (((fep)localObject1).UCF.RNM.Tkb != null)) {
              w.this.NQa.UCF = ((fep)localObject1).UCF;
            }
            if ((((fep)localObject1).UCG.RNM != null) && (((fep)localObject1).UCG.RNM.Tkb != null)) {
              w.this.NQa.UCG = ((fep)localObject1).UCG;
            }
            if (((fep)localObject1).UEB != 0) {
              w.this.NQa.UEB = ((fep)localObject1).UEB;
            }
            if ((((fep)localObject1).UEC != null) && (((fep)localObject1).UEC.UCU != 0)) {
              w.this.NQa.UEC = ((fep)localObject1).UEC;
            }
            if ((((fep)localObject1).UED != null) && (((fep)localObject1).UED.UCU != 0)) {
              w.this.NQa.UED = ((fep)localObject1).UED;
            }
            if ((((fep)localObject1).UFd != null) && (((fep)localObject1).UFd.size() != 0))
            {
              w.this.NQa.UFd = ((fep)localObject1).UFd;
              w.this.NQa.UFc = ((fep)localObject1).UFd.size();
            }
            if (((fep)localObject1).UEF != 0) {
              w.this.NQa.UEF = ((fep)localObject1).UEF;
            }
            if (((fep)localObject1).UEG != 0) {
              w.this.NQa.UEG = ((fep)localObject1).UEG;
            }
            if (((fep)localObject1).UEK.UCU != 0) {
              w.this.NQa.UEK = ((fep)localObject1).UEK;
            }
            if (((fep)localObject1).UEL > 0)
            {
              w.this.NQa.UEL = ((fep)localObject1).UEL;
              if (((fep)localObject1).DQe <= 0) {
                break label866;
              }
              w.this.NQa.DQe = (((fep)localObject1).DQe - 1);
              e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + w.this.NQa.DQe + "] from relaydata");
              if (((fep)localObject1).UEM <= 0) {
                break label887;
              }
              w.this.NQa.UEM = ((fep)localObject1).UEM;
              w.this.NQa.UEN = ((fep)localObject1).UEN;
              w.this.NQa.UEO = ((fep)localObject1).UEO;
              w.this.NQa.UEP = ((fep)localObject1).UEP;
              e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + ((fep)localObject1).UEM + ", ARQRttThreshold: " + ((fep)localObject1).UEN + ", ARQUsedRateThreshold: " + ((fep)localObject1).UEO + ", ARQRespRateThreshold: " + ((fep)localObject1).UEP);
              if (((fep)localObject1).UET <= 0) {
                break label897;
              }
              w.this.NQa.UET = ((fep)localObject1).UET;
              w.this.NQa.UEW = ((fep)localObject1).UEW;
              if (((fep)localObject1).UEY != null) {
                w.this.NQa.UEY = ((fep)localObject1).UEY;
              }
              w.this.NQa.UFb = ((fep)localObject1).UFb;
              w.this.NQa.UFa = ((fep)localObject1).UFa;
              w.this.NJk.NMw.d(((fep)localObject1).UFb, ((fep)localObject1).UFa, w.this.NJk.NMi.roomId, w.this.NJk.NMi.DPJ);
              if ((w.this.NQa.UCF == null) || (w.this.NQa.UCF.RNM == null) || (w.this.NQa.UCF.RNM.Tkb == null) || (w.this.NQa.UEB == 0) || (w.this.NQa.UCG == null) || (w.this.NQa.UCG.RNM == null) || (w.this.NQa.UCG.RNM.Tkb == null) || (((w.this.NQa.UEC == null) || (w.this.NQa.UEC.UCU == 0)) && ((((fep)localObject1).UEu == null) || (((fep)localObject1).UEu.Ucd <= 0)))) {
                break label918;
              }
              i = 1;
              if (i != 0) {
                break;
              }
              e.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
              AppMethodBeat.o(177026);
              return;
            }
          }
          catch (IOException localIOException)
          {
            Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
            AppMethodBeat.o(177026);
            return;
          }
          w.this.NQa.UEL = 0;
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
          continue;
          label866:
          w.this.NQa.DQe = 1;
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
          continue;
          label887:
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
          continue;
          label897:
          w.this.NQa.UET = 0;
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
          continue;
          label918:
          i = 0;
        }
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + w.this.NQa.UEW + " BothSideSwitchFlag = " + localIOException.UEX);
        w.this.NJk.akV(w.this.NQa.UEB);
        w.this.NJk.cy(w.this.NQa.UCF.RNM.Tkb.toByteArray());
        if ((localIOException.UEI != null) && (localIOException.UEI.Tkb != null) && (localIOException.UEU != null) && (localIOException.UEU.Tkb != null)) {
          w.this.NJk.a(localIOException.UEI.Tkb.toByteArray(), localIOException.UEH, w.this.NQa.DQe, localIOException.UEU.Tkb.toByteArray());
        }
        if (c.gxs().gAn() != 0) {
          w.this.NJk.cz(w.this.NQa.UCG.RNM.Tkb.toByteArray());
        }
        Object localObject2;
        if ((localIOException.UEu == null) || (localIOException.UEu.Ucd == 0))
        {
          localObject2 = new dwc();
          ((dwc)localObject2).Ssu = 0;
          ((dwc)localObject2).Ssv = "";
          ((dwc)localObject2).Ssw = "";
          ((dwc)localObject2).Ssx = w.this.NJk.NMi.netType;
          ((dwc)localObject2).Ssy = 4;
          ((dwc)localObject2).Ssz = 2;
          ((dwc)localObject2).Ucb = localIOException.UEC;
          ((dwc)localObject2).Ucc = localIOException.UEK;
          localIOException.UEu = new dwd();
          localIOException.UEu.Ucd = 1;
          localIOException.UEu.Uce = new LinkedList();
          localIOException.UEu.Uce.add(localObject2);
        }
        if ((localIOException.UEv == null) || (localIOException.UEv.SsF == 0))
        {
          localObject2 = new ahu();
          ((ahu)localObject2).Ssu = 1;
          ((ahu)localObject2).Ssv = "";
          ((ahu)localObject2).Ssw = "";
          ((ahu)localObject2).Ssx = w.this.NJk.NMi.netType;
          ((ahu)localObject2).Ssy = 4;
          ((ahu)localObject2).Ssz = 2;
          ((ahu)localObject2).SsA = localIOException.UED;
          ((ahu)localObject2).SsB = localIOException.UFc;
          ((ahu)localObject2).SsC = localIOException.UFd;
          localIOException.UEv = new ahv();
          localIOException.UEv.SsF = 1;
          localIOException.UEv.SsG = new LinkedList();
          localIOException.UEv.SsG.add(localObject2);
        }
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "relay conn cnt: " + localIOException.UEu.Ucd);
        try
        {
          w.this.NJk.NMi.NSl = localIOException.UEu.toByteArray();
        }
        catch (Exception localException2)
        {
          try
          {
            w.this.NJk.NMi.NSm = localIOException.UEv.toByteArray();
          }
          catch (Exception localException2)
          {
            try
            {
              for (;;)
              {
                if (localIOException.UFe.ThN > 0) {
                  w.this.NJk.NMi.NSn = localIOException.UFe.toByteArray();
                }
                e.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + w.this.NQa.UFc);
                w.this.NJk.n(w.this.NQa.UEL, w.this.NQa.UEM, w.this.NQa.UEN, w.this.NQa.UEO, w.this.NQa.UEP);
                w.this.NJk.akU(w.this.NQa.UET);
                localObject2 = w.this.NJk;
                i = w.this.NQa.UEF;
                int j = w.this.NQa.UEG;
                ((l)localObject2).NMi.NQO = i;
                ((l)localObject2).NMi.NQP = j;
                w.this.NJk.akT(w.this.NQa.UEW);
                w.this.NJk.NMi.NRY = localIOException.UEX;
                if ((localIOException.UEZ != null) && (localIOException.UEZ.Tkb != null)) {
                  w.this.NJk.NMi.NQS = localIOException.UEZ.Tkb.toByteArray();
                }
                if ((localIOException.UER != null) && (localIOException.UER.Tkb != null) && (localIOException.UES != null) && (localIOException.UES.Tkb != null)) {
                  w.this.NJk.c(localIOException.UEQ, localIOException.UER.Tkb.toByteArray(), localIOException.UES.Tkb.toByteArray());
                }
                localObject2 = w.this.NJk;
                cnt localcnt = w.this.NQa.UEY;
                localObject2 = ((l)localObject2).NMi;
                e.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + localcnt.Tvq + " Bitrate: " + localcnt.Tvr);
                ((v2protocal)localObject2).field_jbmParamArraySize = 27;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray = new int[((v2protocal)localObject2).field_jbmParamArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[0] = localcnt.Tvp;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[1] = localcnt.Tvq;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[2] = localcnt.Tvr;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[3] = localcnt.Tvs;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[4] = localcnt.Tvt;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[5] = localcnt.Tvu;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[6] = localcnt.Tvv;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[7] = localcnt.Tvy;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[8] = localcnt.Tvz;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[9] = localcnt.TvC;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[10] = localcnt.TvD;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[11] = localcnt.TvG;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[12] = localcnt.TvH;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[13] = localcnt.TvK;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[14] = localcnt.TvL;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[15] = localcnt.TvO;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[16] = localcnt.TvP;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[17] = localcnt.TvS;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[18] = localcnt.TvT;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[19] = localcnt.TvW;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[20] = localcnt.TvX;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[21] = localcnt.Twa;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[22] = localcnt.Twb;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[23] = localcnt.Twe;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[24] = localcnt.Twf;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[25] = localcnt.Twi;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[26] = localcnt.Twj;
                ((v2protocal)localObject2).field_jbmParamDoubleArraySize = 20;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray = new double[((v2protocal)localObject2).field_jbmParamDoubleArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[0] = localcnt.Tvw;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[1] = localcnt.Tvx;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[2] = localcnt.TvA;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[3] = localcnt.TvB;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[4] = localcnt.TvE;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[5] = localcnt.TvF;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[6] = localcnt.TvI;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[7] = localcnt.TvJ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[8] = localcnt.TvM;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[9] = localcnt.TvN;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[10] = localcnt.TvQ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[11] = localcnt.TvR;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[12] = localcnt.TvU;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[13] = localcnt.TvV;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[14] = localcnt.TvY;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[15] = localcnt.TvZ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[16] = localcnt.Twc;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[17] = localcnt.Twd;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[18] = localcnt.Twg;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[19] = localcnt.Twh;
                w.this.NJk.gyW();
                e.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                AppMethodBeat.o(177026);
                return;
                localException1 = localException1;
                Log.e("MicroMsg.Voip.VoipSyncHandle", "relay conn info to byte array fail..");
                continue;
                localException2 = localException2;
                Log.e("MicroMsg.Voip.VoipSyncHandle", "direct conn info to byte array fail..");
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                Log.e("MicroMsg.Voip.VoipSyncHandle", "nic query info to byte array fail..");
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(115209);
  }
  
  public final void a(ffg paramffg, int paramInt)
  {
    AppMethodBeat.i(115207);
    e.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + paramffg.rVU);
    if (paramffg.rVU == 1)
    {
      this.NJk.NLH = true;
      if (1 == paramInt) {
        this.NJk.NMi.NSI.gzg();
      }
      if (3 == paramInt) {
        this.NJk.NMi.NSI.gzh();
      }
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(paramInt)));
      this.NJk.NMj.eIH();
      c.gxs().NPf.gAQ();
      this.NJk.NLI = true;
      if (this.NJk.NLK == true)
      {
        this.NJk.NLK = false;
        if (this.NJk.NLG != true) {
          break label249;
        }
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115198);
            w.this.NJk.gyM();
            AppMethodBeat.o(115198);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(11519, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(2) });
        this.NJk.gyW();
        this.NJk.gyY();
        AppMethodBeat.o(115207);
        return;
        label249:
        if (this.NJk.NLJ == true)
        {
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
          this.NJk.J(1, -9000, "");
        }
        else
        {
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
        }
      }
    }
    if (paramffg.rVU == 6)
    {
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
      this.NJk.NLK = true;
      this.NJk.NMi.NRv = 1;
      this.NJk.gyW();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramffg.rVU == 8)
    {
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
      this.NJk.NMi.NSI.NNr = 211;
      this.NJk.NMi.NSI.NNq = 11;
      this.NJk.NMi.NSI.NNC = 12;
      com.tencent.mm.plugin.report.service.h.IzE.a(11519, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(3) });
      this.NJk.J(1, 211, "");
      this.NJk.gyY();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramffg.rVU == 2)
    {
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
      this.NJk.NMi.NSI.NNq = 103;
      this.NJk.NMi.NSI.NNC = 4;
      this.NJk.NMi.NSI.NNJ = ((int)(System.currentTimeMillis() - this.NJk.NMi.NSI.beginTime));
      com.tencent.mm.plugin.report.service.h.IzE.a(11519, new Object[] { Integer.valueOf(c.gxs().gAn()), Long.valueOf(c.gxs().gAo()), Long.valueOf(c.gxs().gyI()), Integer.valueOf(1) });
      this.NJk.gyY();
      this.NJk.J(4, 0, "");
      AppMethodBeat.o(115207);
      return;
    }
    if (paramffg.rVU == 3)
    {
      this.NJk.NMi.NSI.NNC = 5;
      AppMethodBeat.o(115207);
      return;
    }
    if (paramffg.rVU == 4)
    {
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
      if (this.NJk.mStatus < 6) {
        this.NJk.NMi.NSI.NND = 1;
      }
      this.NJk.NMi.NSI.NNq = 110;
      this.NJk.J(6, 0, "");
      this.NJk.gyY();
      AppMethodBeat.o(115207);
      return;
    }
    e.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + paramffg.rVU);
    AppMethodBeat.o(115207);
  }
  
  public final void ale(int paramInt)
  {
    AppMethodBeat.i(115202);
    Object localObject2 = e.int2bytes(paramInt);
    Object localObject1 = new eae();
    ((eae)localObject1).dc((byte[])localObject2);
    localObject2 = new eae();
    try
    {
      ((eae)localObject2).dc(((eae)localObject1).toByteArray());
      localObject1 = new fdx();
      ((fdx)localObject1).SnG = 3;
      ((fdx)localObject1).SnH = ((eae)localObject2);
      ((fdx)localObject1).CRR = z.bcZ();
      localObject2 = new fdy();
      ((fdy)localObject2).rVx = 1;
      ((fdy)localObject2).rVy.add(localObject1);
      a((fdy)localObject2, false, 4);
      AppMethodBeat.o(115202);
      return;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
      AppMethodBeat.o(115202);
    }
  }
  
  public final void b(fev paramfev)
  {
    AppMethodBeat.i(115210);
    this.NJk.cA(paramfev.RNM.Tkb.toByteArray());
    AppMethodBeat.o(115210);
  }
  
  public final void c(eae parameae)
  {
    AppMethodBeat.i(115211);
    int i = e.cE(parameae.Tkb.toByteArray());
    e.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(i)));
    this.NJk.akO(i & 0xFF);
    AppMethodBeat.o(115211);
  }
  
  public final void gAT()
  {
    AppMethodBeat.i(115205);
    if (this.NQb == null)
    {
      AppMethodBeat.o(115205);
      return;
    }
    this.NQb.rVy.clear();
    this.NQb.rVx = 0;
    this.NQb = null;
    this.NQc = 0;
    AppMethodBeat.o(115205);
  }
  
  public final void p(q paramq)
  {
    AppMethodBeat.i(115212);
    Log.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
    this.NJk.NMo = false;
    Object localObject1 = (ffi)((m)paramq).gAY();
    if (this.NJk.NMm == null)
    {
      AppMethodBeat.o(115212);
      return;
    }
    this.NJk.NMi.parseSyncKeyBuff(this.NJk.NMm, this.NJk.NMm.length);
    int j = this.NJk.NMi.field_statusSyncKey;
    int k = this.NJk.NMi.field_relayDataSyncKey;
    int m = this.NJk.NMi.field_connectingStatusKey;
    this.NJk.NMi.parseSyncKeyBuff(((ffi)localObject1).SfI.Tkb.toByteArray(), ((ffi)localObject1).SfI.Ufv);
    int n = this.NJk.NMi.field_statusSyncKey;
    int i1 = this.NJk.NMi.field_relayDataSyncKey;
    int i2 = this.NJk.NMi.field_connectingStatusKey;
    Log.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + j + " oldRelayDataSyncKey:" + k + " oldConnectingStatusSyncKey:" + m);
    Log.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + n + " newRelayDataSyncKey:" + i1 + " newConnectingStatusSyncKey:" + i2);
    this.NJk.NMm = ((ffi)localObject1).SfI.Tkb.toByteArray();
    Log.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + ((ffi)localObject1).Saq);
    localObject1 = ((ffi)localObject1).UFV.rVy;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0))
    {
      Log.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + ((LinkedList)localObject1).size());
      int i = ((m)paramq).gAW();
      Log.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + ((LinkedList)localObject1).size() + ",selector = " + i);
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        paramq = (fdx)((LinkedList)localObject1).get(i);
        int i3 = paramq.SnG;
        Log.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i3)));
        if (i3 == 1) {
          if (n > j)
          {
            if (this.NJk.NMi.roomId != 0) {
              break label487;
            }
            e.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
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
            localObject2 = (ffg)new ffg().parseFrom(paramq.SnH.Tkb.toByteArray());
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + paramq.CRR + ",itemStatus =  " + ((ffg)localObject2).rVU);
            a((ffg)localObject2, 3);
          }
          catch (IOException paramq)
          {
            Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramq, "", new Object[0]);
          }
          continue;
          if (i3 == 2)
          {
            if (i1 > k) {
              if (this.NJk.NMi.roomId == 0)
              {
                e.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
              }
              else
              {
                try
                {
                  localObject2 = (fev)new fev().parseFrom(paramq.SnH.Tkb.toByteArray());
                  e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + ((fev)localObject2).rWu + ",from user = " + paramq.CRR);
                  if (((fev)localObject2).rWu != 5) {
                    break label712;
                  }
                  a((fev)localObject2);
                }
                catch (IOException paramq)
                {
                  Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramq, "", new Object[0]);
                }
                continue;
                label712:
                if (((fev)localObject2).rWu == 3)
                {
                  this.NJk.cz(((fev)localObject2).RNM.Tkb.toByteArray());
                  if ((((fev)localObject2).RNM != null) && (((fev)localObject2).RNM.Tkb != null)) {
                    this.NQa.UCG = ((fev)localObject2);
                  }
                }
                else if (((fev)localObject2).rWu == 2)
                {
                  this.NJk.cy(((fev)localObject2).RNM.Tkb.toByteArray());
                  if ((((fev)localObject2).RNM != null) && (((fev)localObject2).RNM.Tkb != null)) {
                    this.NQa.UCF = ((fev)localObject2);
                  }
                }
                else if (((fev)localObject2).rWu == 1)
                {
                  b((fev)localObject2);
                }
                else if (((fev)localObject2).rWu == 6)
                {
                  paramq = ((fev)localObject2).RNM.Tkb.toByteArray();
                  try
                  {
                    paramq = (feo)new feo().parseFrom(paramq);
                    if (paramq == null) {
                      continue;
                    }
                    this.NJk.NMl.a(paramq);
                  }
                  catch (IOException paramq)
                  {
                    for (;;)
                    {
                      Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramq, "", new Object[0]);
                      paramq = null;
                    }
                  }
                }
              }
            }
          }
          else if ((i3 == 3) && (i2 > m)) {
            if (this.NJk.NMi.roomId == 0)
            {
              Log.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
            }
            else
            {
              try
              {
                localObject2 = new eae().dd(paramq.SnH.Tkb.toByteArray());
                if (!paramq.CRR.equals(z.bcZ())) {
                  break label1018;
                }
                e.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
              }
              catch (IOException paramq)
              {
                Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramq, "", new Object[0]);
              }
              continue;
              label1018:
              c((eae)localObject2);
            }
          }
        }
      }
    }
    Log.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
    if (((this.NQb != null) && (this.NQb.rVx > 0)) || (this.NQc > 0)) {
      a(null, false, 7);
    }
    AppMethodBeat.o(115212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.w
 * JD-Core Version:    0.7.0.1
 */