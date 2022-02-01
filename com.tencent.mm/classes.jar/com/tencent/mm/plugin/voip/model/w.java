package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.dqz;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.dsl;
import com.tencent.mm.protocal.protobuf.dsm;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.protocal.protobuf.dtd;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import java.io.IOException;
import java.util.LinkedList;

public final class w
{
  dsm AFB;
  private drv AFC;
  private int AFD;
  l Ayh;
  
  public w(l paraml)
  {
    AppMethodBeat.i(115201);
    this.Ayh = null;
    this.AFB = new dsm();
    this.AFC = null;
    this.AFD = 0;
    this.Ayh = paraml;
    AppMethodBeat.o(115201);
  }
  
  private void a(drv paramdrv)
  {
    AppMethodBeat.i(115203);
    if (paramdrv == null)
    {
      d.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
      this.AFD += 1;
      AppMethodBeat.o(115203);
      return;
    }
    if (this.AFC == null) {
      this.AFC = new drv();
    }
    int i = 0;
    while (i < paramdrv.ncL)
    {
      dru localdru = (dru)paramdrv.ncM.get(i);
      this.AFC.ncM.add(localdru);
      i += 1;
    }
    this.AFC.ncL = this.AFC.ncM.size();
    AppMethodBeat.o(115203);
  }
  
  private void b(drv paramdrv)
  {
    AppMethodBeat.i(115204);
    if ((this.AFC == null) || (this.AFC.ncL <= 0))
    {
      AppMethodBeat.o(115204);
      return;
    }
    int i = 0;
    while (i < this.AFC.ncL)
    {
      dru localdru = (dru)this.AFC.ncM.get(i);
      paramdrv.ncM.add(localdru);
      i += 1;
    }
    paramdrv.ncL = paramdrv.ncM.size();
    ekr();
    AppMethodBeat.o(115204);
  }
  
  public final void SC(int paramInt)
  {
    AppMethodBeat.i(115202);
    Object localObject2 = d.SJ(paramInt);
    Object localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = new SKBuiltinBuffer_t();
    try
    {
      ((SKBuiltinBuffer_t)localObject2).setBuffer(((SKBuiltinBuffer_t)localObject1).toByteArray());
      localObject1 = new dru();
      ((dru)localObject1).ErL = 3;
      ((dru)localObject1).ErM = ((SKBuiltinBuffer_t)localObject2);
      ((dru)localObject1).tlK = com.tencent.mm.model.u.axw();
      localObject2 = new drv();
      ((drv)localObject2).ncL = 1;
      ((drv)localObject2).ncM.add(localObject1);
      a((drv)localObject2, false, 4);
      AppMethodBeat.o(115202);
      return;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
      AppMethodBeat.o(115202);
    }
  }
  
  public final int a(drv paramdrv, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(115206);
    if (this.Ayh.ABJ.roomId == 0)
    {
      d.Loge("MicroMsg.Voip.VoipSyncHandle", f.YG() + "failed to do voip sync , roomid = 0");
      AppMethodBeat.o(115206);
      return 0;
    }
    if (this.Ayh.ABP)
    {
      d.Loge("MicroMsg.Voip.VoipSyncHandle", f.YG() + "voip syncing, push to cache...");
      a(paramdrv);
      AppMethodBeat.o(115206);
      return 0;
    }
    this.Ayh.ABP = true;
    if (paramdrv == null)
    {
      paramdrv = new drv();
      paramdrv.ncL = 0;
      paramdrv.ncM = new LinkedList();
    }
    for (;;)
    {
      b(paramdrv);
      this.AFD = 0;
      if (this.Ayh.ABN == null) {
        this.Ayh.ABN = "".getBytes();
      }
      d.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + paramBoolean + ",cmdList:" + paramdrv.ncL + ",syncKey.length:" + this.Ayh.ABN.length + ",selector:" + paramInt);
      new m(this.Ayh.ABJ.roomId, paramdrv, this.Ayh.ABN, this.Ayh.ABJ.tIG, paramInt).ekv();
      AppMethodBeat.o(115206);
      return 0;
    }
  }
  
  public final void a(final dsl paramdsl)
  {
    AppMethodBeat.i(115208);
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115200);
        ap.f(new w.2(w.this, paramdsl));
        AppMethodBeat.o(115200);
      }
    });
    AppMethodBeat.o(115208);
  }
  
  public final void a(final dss paramdss)
  {
    AppMethodBeat.i(115209);
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177026);
        d.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
        Object localObject1 = paramdss.DVs.getBuffer().toByteArray();
        int i;
        for (;;)
        {
          try
          {
            localObject1 = (dsm)new dsm().parseFrom((byte[])localObject1);
            if ((((dsm)localObject1).FYh != null) && (((dsm)localObject1).FYh.DVs != null) && (((dsm)localObject1).FYh.DVs.getBuffer() != null)) {
              w.this.AFB.FYh = ((dsm)localObject1).FYh;
            }
            if ((((dsm)localObject1).FYi.DVs != null) && (((dsm)localObject1).FYi.DVs.getBuffer() != null)) {
              w.this.AFB.FYi = ((dsm)localObject1).FYi;
            }
            if (((dsm)localObject1).Gac != 0) {
              w.this.AFB.Gac = ((dsm)localObject1).Gac;
            }
            if ((((dsm)localObject1).Gad != null) && (((dsm)localObject1).Gad.FYw != 0)) {
              w.this.AFB.Gad = ((dsm)localObject1).Gad;
            }
            if ((((dsm)localObject1).Gae != null) && (((dsm)localObject1).Gae.FYw != 0)) {
              w.this.AFB.Gae = ((dsm)localObject1).Gae;
            }
            if ((((dsm)localObject1).GaE != null) && (((dsm)localObject1).GaE.size() != 0))
            {
              w.this.AFB.GaE = ((dsm)localObject1).GaE;
              w.this.AFB.GaD = ((dsm)localObject1).GaE.size();
            }
            if (((dsm)localObject1).Gag != 0) {
              w.this.AFB.Gag = ((dsm)localObject1).Gag;
            }
            if (((dsm)localObject1).Gah != 0) {
              w.this.AFB.Gah = ((dsm)localObject1).Gah;
            }
            if (((dsm)localObject1).Gal.FYw != 0) {
              w.this.AFB.Gal = ((dsm)localObject1).Gal;
            }
            if (((dsm)localObject1).Gam > 0)
            {
              w.this.AFB.Gam = ((dsm)localObject1).Gam;
              if (((dsm)localObject1).tJb <= 0) {
                break label907;
              }
              w.this.AFB.tJb = (((dsm)localObject1).tJb - 1);
              d.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + w.this.AFB.tJb + "] from relaydata");
              if (((dsm)localObject1).Gan <= 0) {
                break label928;
              }
              w.this.AFB.Gan = ((dsm)localObject1).Gan;
              w.this.AFB.Gao = ((dsm)localObject1).Gao;
              w.this.AFB.Gap = ((dsm)localObject1).Gap;
              w.this.AFB.Gaq = ((dsm)localObject1).Gaq;
              d.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + ((dsm)localObject1).Gan + ", ARQRttThreshold: " + ((dsm)localObject1).Gao + ", ARQUsedRateThreshold: " + ((dsm)localObject1).Gap + ", ARQRespRateThreshold: " + ((dsm)localObject1).Gaq);
              if (((dsm)localObject1).Gau <= 0) {
                break label938;
              }
              w.this.AFB.Gau = ((dsm)localObject1).Gau;
              w.this.AFB.Gax = ((dsm)localObject1).Gax;
              if (((dsm)localObject1).Gaz != null) {
                w.this.AFB.Gaz = ((dsm)localObject1).Gaz;
              }
              w.this.AFB.GaC = ((dsm)localObject1).GaC;
              w.this.AFB.GaB = ((dsm)localObject1).GaB;
              w.this.Ayh.ABX.a(((dsm)localObject1).GaC, ((dsm)localObject1).GaB, w.this.Ayh.ABJ.roomId, w.this.Ayh.ABJ.tIG);
              if ((w.this.AFB.FYh == null) || (w.this.AFB.FYh.DVs == null) || (w.this.AFB.FYh.DVs.getBuffer() == null) || (w.this.AFB.Gac == 0) || (w.this.AFB.FYi == null) || (w.this.AFB.FYi.DVs == null) || (w.this.AFB.FYi.DVs.getBuffer() == null) || (w.this.AFB.Gad == null) || (w.this.AFB.Gad.FYw == 0) || (w.this.AFB.Gae == null) || (w.this.AFB.Gae.FYw == 0) || (w.this.AFB.Gal == null) || (w.this.AFB.Gal.FYw == 0)) {
                break label959;
              }
              i = 1;
              if (i != 0) {
                break;
              }
              d.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
              AppMethodBeat.o(177026);
              return;
            }
          }
          catch (IOException localIOException)
          {
            ac.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
            AppMethodBeat.o(177026);
            return;
          }
          w.this.AFB.Gam = 0;
          d.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
          continue;
          label907:
          w.this.AFB.tJb = 1;
          d.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
          continue;
          label928:
          d.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
          continue;
          label938:
          w.this.AFB.Gau = 0;
          d.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
          continue;
          label959:
          i = 0;
        }
        d.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + w.this.AFB.Gax + " BothSideSwitchFlag = " + localIOException.Gay);
        w.this.Ayh.Sr(w.this.AFB.Gac);
        w.this.Ayh.bI(w.this.AFB.FYh.DVs.getBuffer().toByteArray());
        if ((localIOException.Gaj != null) && (localIOException.Gaj.getBuffer() != null) && (localIOException.Gav != null) && (localIOException.Gav.getBuffer() != null)) {
          w.this.Ayh.a(localIOException.Gaj.getBuffer().toByteArray(), localIOException.Gai, w.this.AFB.tJb, localIOException.Gav.getBuffer().toByteArray());
        }
        if (c.ehb().ejL() != 0) {
          w.this.Ayh.bJ(w.this.AFB.FYi.DVs.getBuffer().toByteArray());
        }
        Object localObject2;
        if ((localIOException.FZV == null) || (localIOException.FZV.FBe == 0))
        {
          localObject2 = new cny();
          ((cny)localObject2).Evo = 0;
          ((cny)localObject2).Evp = "";
          ((cny)localObject2).Evq = "";
          ((cny)localObject2).Evr = w.this.Ayh.ABJ.netType;
          ((cny)localObject2).Evs = 4;
          ((cny)localObject2).Evt = 2;
          ((cny)localObject2).FBc = localIOException.Gad;
          ((cny)localObject2).FBd = localIOException.Gal;
          localIOException.FZV = new cnz();
          localIOException.FZV.FBe = 1;
          localIOException.FZV.FBf = new LinkedList();
          localIOException.FZV.FBf.add(localObject2);
        }
        if ((localIOException.FZW == null) || (localIOException.FZW.Evz == 0))
        {
          localObject2 = new act();
          ((act)localObject2).Evo = 1;
          ((act)localObject2).Evp = "";
          ((act)localObject2).Evq = "";
          ((act)localObject2).Evr = w.this.Ayh.ABJ.netType;
          ((act)localObject2).Evs = 4;
          ((act)localObject2).Evt = 2;
          ((act)localObject2).Evu = localIOException.Gae;
          ((act)localObject2).Evv = localIOException.GaD;
          ((act)localObject2).Evw = localIOException.GaE;
          localIOException.FZW = new acu();
          localIOException.FZW.Evz = 1;
          localIOException.FZW.EvA = new LinkedList();
          localIOException.FZW.EvA.add(localObject2);
        }
        d.Logi("MicroMsg.Voip.VoipSyncHandle", "relay conn cnt: " + localIOException.FZV.FBe);
        try
        {
          w.this.Ayh.ABJ.AHI = localIOException.FZV.toByteArray();
        }
        catch (Exception localException2)
        {
          try
          {
            w.this.Ayh.ABJ.AHJ = localIOException.FZW.toByteArray();
          }
          catch (Exception localException2)
          {
            try
            {
              for (;;)
              {
                if (localIOException.GaF.ERm > 0) {
                  w.this.Ayh.ABJ.AHK = localIOException.GaF.toByteArray();
                }
                d.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + w.this.AFB.GaD);
                w.this.Ayh.i(w.this.AFB.Gam, w.this.AFB.Gan, w.this.AFB.Gao, w.this.AFB.Gap, w.this.AFB.Gaq);
                w.this.Ayh.Sq(w.this.AFB.Gau);
                localObject2 = w.this.Ayh;
                i = w.this.AFB.Gag;
                int j = w.this.AFB.Gah;
                ((l)localObject2).ABJ.AGm = i;
                ((l)localObject2).ABJ.AGn = j;
                w.this.Ayh.Sp(w.this.AFB.Gax);
                w.this.Ayh.ABJ.AHw = localIOException.Gay;
                if ((localIOException.GaA != null) && (localIOException.GaA.getBuffer() != null)) {
                  w.this.Ayh.ABJ.AGq = localIOException.GaA.getBuffer().toByteArray();
                }
                if ((localIOException.Gas != null) && (localIOException.Gas.getBuffer() != null) && (localIOException.Gat != null) && (localIOException.Gat.getBuffer() != null)) {
                  w.this.Ayh.c(localIOException.Gar, localIOException.Gas.getBuffer().toByteArray(), localIOException.Gat.getBuffer().toByteArray());
                }
                localObject2 = w.this.Ayh;
                bnb localbnb = w.this.AFB.Gaz;
                localObject2 = ((l)localObject2).ABJ;
                d.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + localbnb.Fcn + " Bitrate: " + localbnb.Fco);
                ((v2protocal)localObject2).field_jbmParamArraySize = 27;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray = new int[((v2protocal)localObject2).field_jbmParamArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[0] = localbnb.Fcm;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[1] = localbnb.Fcn;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[2] = localbnb.Fco;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[3] = localbnb.Fcp;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[4] = localbnb.Fcq;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[5] = localbnb.Fcr;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[6] = localbnb.Fcs;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[7] = localbnb.Fcv;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[8] = localbnb.Fcw;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[9] = localbnb.Fcz;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[10] = localbnb.FcA;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[11] = localbnb.FcD;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[12] = localbnb.FcE;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[13] = localbnb.FcH;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[14] = localbnb.FcI;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[15] = localbnb.FcL;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[16] = localbnb.FcM;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[17] = localbnb.FcP;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[18] = localbnb.FcQ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[19] = localbnb.FcT;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[20] = localbnb.FcU;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[21] = localbnb.FcX;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[22] = localbnb.FcY;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[23] = localbnb.Fdb;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[24] = localbnb.Fdc;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[25] = localbnb.Fdf;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[26] = localbnb.Fdg;
                ((v2protocal)localObject2).field_jbmParamDoubleArraySize = 20;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray = new double[((v2protocal)localObject2).field_jbmParamDoubleArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[0] = localbnb.Fct;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[1] = localbnb.Fcu;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[2] = localbnb.Fcx;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[3] = localbnb.Fcy;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[4] = localbnb.FcB;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[5] = localbnb.FcC;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[6] = localbnb.FcF;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[7] = localbnb.FcG;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[8] = localbnb.FcJ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[9] = localbnb.FcK;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[10] = localbnb.FcN;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[11] = localbnb.FcO;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[12] = localbnb.FcR;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[13] = localbnb.FcS;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[14] = localbnb.FcV;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[15] = localbnb.FcW;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[16] = localbnb.FcZ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[17] = localbnb.Fda;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[18] = localbnb.Fdd;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[19] = localbnb.Fde;
                w.this.Ayh.eiA();
                d.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                AppMethodBeat.o(177026);
                return;
                localException1 = localException1;
                ac.e("MicroMsg.Voip.VoipSyncHandle", "relay conn info to byte array fail..");
                continue;
                localException2 = localException2;
                ac.e("MicroMsg.Voip.VoipSyncHandle", "direct conn info to byte array fail..");
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ac.e("MicroMsg.Voip.VoipSyncHandle", "nic query info to byte array fail..");
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(115209);
  }
  
  public final void a(dtd paramdtd, int paramInt)
  {
    AppMethodBeat.i(115207);
    d.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + paramdtd.ndj);
    if (paramdtd.ndj == 1)
    {
      this.Ayh.ABi = true;
      if (1 == paramInt) {
        this.Ayh.ABJ.AIf.eiK();
      }
      if (3 == paramInt) {
        this.Ayh.ABJ.AIf.eiL();
      }
      d.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(paramInt)));
      this.Ayh.ABK.cTN();
      c.ehb().AEF.eko();
      this.Ayh.ABj = true;
      if (this.Ayh.ABl == true)
      {
        this.Ayh.ABl = false;
        if (this.Ayh.ABh != true) {
          break label250;
        }
        d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115198);
            w.this.Ayh.eis();
            AppMethodBeat.o(115198);
          }
        });
      }
      for (;;)
      {
        h.wUl.f(11519, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(2) });
        this.Ayh.eiA();
        this.Ayh.eiC();
        AppMethodBeat.o(115207);
        return;
        label250:
        if (this.Ayh.ABk == true)
        {
          d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
          this.Ayh.H(1, -9000, "");
        }
        else
        {
          d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
        }
      }
    }
    if (paramdtd.ndj == 6)
    {
      d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
      d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
      this.Ayh.ABl = true;
      this.Ayh.ABJ.AGT = 1;
      this.Ayh.eiA();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdtd.ndj == 8)
    {
      d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
      this.Ayh.ABJ.AIf.ACS = 211;
      this.Ayh.ABJ.AIf.ACR = 11;
      this.Ayh.ABJ.AIf.ADd = 12;
      h.wUl.f(11519, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(3) });
      this.Ayh.H(1, 211, "");
      this.Ayh.eiC();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdtd.ndj == 2)
    {
      d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
      this.Ayh.ABJ.AIf.ACR = 103;
      this.Ayh.ABJ.AIf.ADd = 4;
      this.Ayh.ABJ.AIf.ADk = ((int)(System.currentTimeMillis() - this.Ayh.ABJ.AIf.beginTime));
      h.wUl.f(11519, new Object[] { Integer.valueOf(c.ehb().ejL()), Long.valueOf(c.ehb().ejM()), Long.valueOf(c.ehb().eim()), Integer.valueOf(1) });
      this.Ayh.eiC();
      this.Ayh.H(4, 0, "");
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdtd.ndj == 3)
    {
      this.Ayh.ABJ.AIf.ADd = 5;
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdtd.ndj == 4)
    {
      d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
      if (this.Ayh.mStatus < 6) {
        this.Ayh.ABJ.AIf.ADe = 1;
      }
      this.Ayh.ABJ.AIf.ACR = 110;
      this.Ayh.H(6, 0, "");
      this.Ayh.eiC();
      AppMethodBeat.o(115207);
      return;
    }
    d.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + paramdtd.ndj);
    AppMethodBeat.o(115207);
  }
  
  public final void b(dss paramdss)
  {
    AppMethodBeat.i(115210);
    this.Ayh.bK(paramdss.DVs.getBuffer().toByteArray());
    AppMethodBeat.o(115210);
  }
  
  public final void c(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(115211);
    int i = d.bO(paramSKBuiltinBuffer_t.getBuffer().toByteArray());
    d.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(i)));
    this.Ayh.Sl(i & 0xFF);
    AppMethodBeat.o(115211);
  }
  
  public final void ekr()
  {
    AppMethodBeat.i(115205);
    if (this.AFC == null)
    {
      AppMethodBeat.o(115205);
      return;
    }
    this.AFC.ncM.clear();
    this.AFC.ncL = 0;
    this.AFC = null;
    this.AFD = 0;
    AppMethodBeat.o(115205);
  }
  
  public final void n(n paramn)
  {
    AppMethodBeat.i(115212);
    ac.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
    this.Ayh.ABP = false;
    Object localObject1 = (dtf)((m)paramn).ekw();
    if (this.Ayh.ABN == null)
    {
      AppMethodBeat.o(115212);
      return;
    }
    this.Ayh.ABJ.parseSyncKeyBuff(this.Ayh.ABN, this.Ayh.ABN.length);
    int j = this.Ayh.ABJ.field_statusSyncKey;
    int k = this.Ayh.ABJ.field_relayDataSyncKey;
    int m = this.Ayh.ABJ.field_connectingStatusKey;
    this.Ayh.ABJ.parseSyncKeyBuff(((dtf)localObject1).Eki.getBuffer().toByteArray(), ((dtf)localObject1).Eki.getILen());
    int n = this.Ayh.ABJ.field_statusSyncKey;
    int i1 = this.Ayh.ABJ.field_relayDataSyncKey;
    int i2 = this.Ayh.ABJ.field_connectingStatusKey;
    ac.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + j + " oldRelayDataSyncKey:" + k + " oldConnectingStatusSyncKey:" + m);
    ac.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + n + " newRelayDataSyncKey:" + i1 + " newConnectingStatusSyncKey:" + i2);
    this.Ayh.ABN = ((dtf)localObject1).Eki.getBuffer().toByteArray();
    ac.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + ((dtf)localObject1).EfS);
    localObject1 = ((dtf)localObject1).Gbw.ncM;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0))
    {
      ac.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + ((LinkedList)localObject1).size());
      int i = ((m)paramn).eku();
      ac.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + ((LinkedList)localObject1).size() + ",selector = " + i);
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        paramn = (dru)((LinkedList)localObject1).get(i);
        int i3 = paramn.ErL;
        ac.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i3)));
        if (i3 == 1) {
          if (n > j)
          {
            if (this.Ayh.ABJ.roomId != 0) {
              break label487;
            }
            d.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
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
            localObject2 = (dtd)new dtd().parseFrom(paramn.ErM.getBuffer().toByteArray());
            d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + paramn.tlK + ",itemStatus =  " + ((dtd)localObject2).ndj);
            a((dtd)localObject2, 3);
          }
          catch (IOException paramn)
          {
            ac.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
          }
          continue;
          if (i3 == 2)
          {
            if (i1 > k) {
              if (this.Ayh.ABJ.roomId == 0)
              {
                d.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
              }
              else
              {
                try
                {
                  localObject2 = (dss)new dss().parseFrom(paramn.ErM.getBuffer().toByteArray());
                  d.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + ((dss)localObject2).ndI + ",from user = " + paramn.tlK);
                  if (((dss)localObject2).ndI != 5) {
                    break label712;
                  }
                  a((dss)localObject2);
                }
                catch (IOException paramn)
                {
                  ac.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
                }
                continue;
                label712:
                if (((dss)localObject2).ndI == 3)
                {
                  this.Ayh.bJ(((dss)localObject2).DVs.getBuffer().toByteArray());
                  if ((((dss)localObject2).DVs != null) && (((dss)localObject2).DVs.getBuffer() != null)) {
                    this.AFB.FYi = ((dss)localObject2);
                  }
                }
                else if (((dss)localObject2).ndI == 2)
                {
                  this.Ayh.bI(((dss)localObject2).DVs.getBuffer().toByteArray());
                  if ((((dss)localObject2).DVs != null) && (((dss)localObject2).DVs.getBuffer() != null)) {
                    this.AFB.FYh = ((dss)localObject2);
                  }
                }
                else if (((dss)localObject2).ndI == 1)
                {
                  b((dss)localObject2);
                }
                else if (((dss)localObject2).ndI == 6)
                {
                  paramn = ((dss)localObject2).DVs.getBuffer().toByteArray();
                  try
                  {
                    paramn = (dsl)new dsl().parseFrom(paramn);
                    if (paramn == null) {
                      continue;
                    }
                    this.Ayh.ABM.a(paramn);
                  }
                  catch (IOException paramn)
                  {
                    for (;;)
                    {
                      ac.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
                      paramn = null;
                    }
                  }
                }
              }
            }
          }
          else if ((i3 == 3) && (i2 > m)) {
            if (this.Ayh.ABJ.roomId == 0)
            {
              ac.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
            }
            else
            {
              try
              {
                localObject2 = new SKBuiltinBuffer_t().parseFrom(paramn.ErM.getBuffer().toByteArray());
                if (!paramn.tlK.equals(com.tencent.mm.model.u.axw())) {
                  break label1018;
                }
                d.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
              }
              catch (IOException paramn)
              {
                ac.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
              }
              continue;
              label1018:
              c((SKBuiltinBuffer_t)localObject2);
            }
          }
        }
      }
    }
    ac.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
    if (((this.AFC != null) && (this.AFC.ncL > 0)) || (this.AFD > 0)) {
      a(null, false, 7);
    }
    AppMethodBeat.o(115212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.w
 * JD-Core Version:    0.7.0.1
 */