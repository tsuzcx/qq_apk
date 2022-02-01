package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.cez;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.protocal.protobuf.etm;
import com.tencent.mm.protocal.protobuf.etn;
import com.tencent.mm.protocal.protobuf.eud;
import com.tencent.mm.protocal.protobuf.eue;
import com.tencent.mm.protocal.protobuf.euk;
import com.tencent.mm.protocal.protobuf.euv;
import com.tencent.mm.protocal.protobuf.eux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.IOException;
import java.util.LinkedList;

public final class w
{
  l GSZ;
  eue GZQ;
  private etn GZR;
  private int GZS;
  
  public w(l paraml)
  {
    AppMethodBeat.i(115201);
    this.GSZ = null;
    this.GZQ = new eue();
    this.GZR = null;
    this.GZS = 0;
    this.GSZ = paraml;
    AppMethodBeat.o(115201);
  }
  
  private void a(etn parametn)
  {
    AppMethodBeat.i(115203);
    if (parametn == null)
    {
      e.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
      this.GZS += 1;
      AppMethodBeat.o(115203);
      return;
    }
    if (this.GZR == null) {
      this.GZR = new etn();
    }
    int i = 0;
    while (i < parametn.oTz)
    {
      etm localetm = (etm)parametn.oTA.get(i);
      this.GZR.oTA.add(localetm);
      i += 1;
    }
    this.GZR.oTz = this.GZR.oTA.size();
    AppMethodBeat.o(115203);
  }
  
  private void b(etn parametn)
  {
    AppMethodBeat.i(115204);
    if ((this.GZR == null) || (this.GZR.oTz <= 0))
    {
      AppMethodBeat.o(115204);
      return;
    }
    int i = 0;
    while (i < this.GZR.oTz)
    {
      etm localetm = (etm)this.GZR.oTA.get(i);
      parametn.oTA.add(localetm);
      i += 1;
    }
    parametn.oTz = parametn.oTA.size();
    fIE();
    AppMethodBeat.o(115204);
  }
  
  public final int a(etn parametn, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(115206);
    if (this.GSZ.GVV.roomId == 0)
    {
      e.Loge("MicroMsg.Voip.VoipSyncHandle", f.apq() + "failed to do voip sync , roomid = 0");
      AppMethodBeat.o(115206);
      return 0;
    }
    if (this.GSZ.GWb)
    {
      e.Loge("MicroMsg.Voip.VoipSyncHandle", f.apq() + "voip syncing, push to cache...");
      a(parametn);
      AppMethodBeat.o(115206);
      return 0;
    }
    this.GSZ.GWb = true;
    if (parametn == null)
    {
      parametn = new etn();
      parametn.oTz = 0;
      parametn.oTA = new LinkedList();
    }
    for (;;)
    {
      b(parametn);
      this.GZS = 0;
      if (this.GSZ.GVZ == null) {
        this.GSZ.GVZ = "".getBytes();
      }
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + paramBoolean + ",cmdList:" + parametn.oTz + ",syncKey.length:" + this.GSZ.GVZ.length + ",selector:" + paramInt);
      new m(this.GSZ.GVV.roomId, parametn, this.GSZ.GVZ, this.GSZ.GVV.ypH, paramInt).fII();
      AppMethodBeat.o(115206);
      return 0;
    }
  }
  
  public final void a(final eud parameud)
  {
    AppMethodBeat.i(115208);
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115200);
        MMHandlerThread.postToMainThread(new w.2(w.this, parameud));
        AppMethodBeat.o(115200);
      }
    });
    AppMethodBeat.o(115208);
  }
  
  public final void a(final euk parameuk)
  {
    AppMethodBeat.i(115209);
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177026);
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
        Object localObject1 = parameuk.KMS.getBuffer().toByteArray();
        int i;
        for (;;)
        {
          try
          {
            localObject1 = (eue)new eue().parseFrom((byte[])localObject1);
            if ((((eue)localObject1).NpJ != null) && (((eue)localObject1).NpJ.KMS != null) && (((eue)localObject1).NpJ.KMS.getBuffer() != null)) {
              w.this.GZQ.NpJ = ((eue)localObject1).NpJ;
            }
            if ((((eue)localObject1).NpK.KMS != null) && (((eue)localObject1).NpK.KMS.getBuffer() != null)) {
              w.this.GZQ.NpK = ((eue)localObject1).NpK;
            }
            if (((eue)localObject1).NrE != 0) {
              w.this.GZQ.NrE = ((eue)localObject1).NrE;
            }
            if ((((eue)localObject1).NrF != null) && (((eue)localObject1).NrF.NpY != 0)) {
              w.this.GZQ.NrF = ((eue)localObject1).NrF;
            }
            if ((((eue)localObject1).NrG != null) && (((eue)localObject1).NrG.NpY != 0)) {
              w.this.GZQ.NrG = ((eue)localObject1).NrG;
            }
            if ((((eue)localObject1).Nsg != null) && (((eue)localObject1).Nsg.size() != 0))
            {
              w.this.GZQ.Nsg = ((eue)localObject1).Nsg;
              w.this.GZQ.Nsf = ((eue)localObject1).Nsg.size();
            }
            if (((eue)localObject1).NrI != 0) {
              w.this.GZQ.NrI = ((eue)localObject1).NrI;
            }
            if (((eue)localObject1).NrJ != 0) {
              w.this.GZQ.NrJ = ((eue)localObject1).NrJ;
            }
            if (((eue)localObject1).NrN.NpY != 0) {
              w.this.GZQ.NrN = ((eue)localObject1).NrN;
            }
            if (((eue)localObject1).NrO > 0)
            {
              w.this.GZQ.NrO = ((eue)localObject1).NrO;
              if (((eue)localObject1).yqc <= 0) {
                break label866;
              }
              w.this.GZQ.yqc = (((eue)localObject1).yqc - 1);
              e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + w.this.GZQ.yqc + "] from relaydata");
              if (((eue)localObject1).NrP <= 0) {
                break label887;
              }
              w.this.GZQ.NrP = ((eue)localObject1).NrP;
              w.this.GZQ.NrQ = ((eue)localObject1).NrQ;
              w.this.GZQ.NrR = ((eue)localObject1).NrR;
              w.this.GZQ.NrS = ((eue)localObject1).NrS;
              e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + ((eue)localObject1).NrP + ", ARQRttThreshold: " + ((eue)localObject1).NrQ + ", ARQUsedRateThreshold: " + ((eue)localObject1).NrR + ", ARQRespRateThreshold: " + ((eue)localObject1).NrS);
              if (((eue)localObject1).NrW <= 0) {
                break label897;
              }
              w.this.GZQ.NrW = ((eue)localObject1).NrW;
              w.this.GZQ.NrZ = ((eue)localObject1).NrZ;
              if (((eue)localObject1).Nsb != null) {
                w.this.GZQ.Nsb = ((eue)localObject1).Nsb;
              }
              w.this.GZQ.Nse = ((eue)localObject1).Nse;
              w.this.GZQ.Nsd = ((eue)localObject1).Nsd;
              w.this.GSZ.GWj.d(((eue)localObject1).Nse, ((eue)localObject1).Nsd, w.this.GSZ.GVV.roomId, w.this.GSZ.GVV.ypH);
              if ((w.this.GZQ.NpJ == null) || (w.this.GZQ.NpJ.KMS == null) || (w.this.GZQ.NpJ.KMS.getBuffer() == null) || (w.this.GZQ.NrE == 0) || (w.this.GZQ.NpK == null) || (w.this.GZQ.NpK.KMS == null) || (w.this.GZQ.NpK.KMS.getBuffer() == null) || (((w.this.GZQ.NrF == null) || (w.this.GZQ.NrF.NpY == 0)) && ((((eue)localObject1).Nrx == null) || (((eue)localObject1).Nrx.MPZ <= 0)))) {
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
          w.this.GZQ.NrO = 0;
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
          continue;
          label866:
          w.this.GZQ.yqc = 1;
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
          continue;
          label887:
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
          continue;
          label897:
          w.this.GZQ.NrW = 0;
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
          continue;
          label918:
          i = 0;
        }
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + w.this.GZQ.NrZ + " BothSideSwitchFlag = " + localIOException.Nsa);
        w.this.GSZ.adk(w.this.GZQ.NrE);
        w.this.GSZ.ci(w.this.GZQ.NpJ.KMS.getBuffer().toByteArray());
        if ((localIOException.NrL != null) && (localIOException.NrL.getBuffer() != null) && (localIOException.NrX != null) && (localIOException.NrX.getBuffer() != null)) {
          w.this.GSZ.a(localIOException.NrL.getBuffer().toByteArray(), localIOException.NrK, w.this.GZQ.yqc, localIOException.NrX.getBuffer().toByteArray());
        }
        if (c.fFg().fHU() != 0) {
          w.this.GSZ.cj(w.this.GZQ.NpK.KMS.getBuffer().toByteArray());
        }
        Object localObject2;
        if ((localIOException.Nrx == null) || (localIOException.Nrx.MPZ == 0))
        {
          localObject2 = new dml();
          ((dml)localObject2).LqX = 0;
          ((dml)localObject2).LqY = "";
          ((dml)localObject2).LqZ = "";
          ((dml)localObject2).Lra = w.this.GSZ.GVV.netType;
          ((dml)localObject2).Lrb = 4;
          ((dml)localObject2).Lrc = 2;
          ((dml)localObject2).MPX = localIOException.NrF;
          ((dml)localObject2).MPY = localIOException.NrN;
          localIOException.Nrx = new dmm();
          localIOException.Nrx.MPZ = 1;
          localIOException.Nrx.MQa = new LinkedList();
          localIOException.Nrx.MQa.add(localObject2);
        }
        if ((localIOException.Nry == null) || (localIOException.Nry.Lri == 0))
        {
          localObject2 = new ahj();
          ((ahj)localObject2).LqX = 1;
          ((ahj)localObject2).LqY = "";
          ((ahj)localObject2).LqZ = "";
          ((ahj)localObject2).Lra = w.this.GSZ.GVV.netType;
          ((ahj)localObject2).Lrb = 4;
          ((ahj)localObject2).Lrc = 2;
          ((ahj)localObject2).Lrd = localIOException.NrG;
          ((ahj)localObject2).Lre = localIOException.Nsf;
          ((ahj)localObject2).Lrf = localIOException.Nsg;
          localIOException.Nry = new ahk();
          localIOException.Nry.Lri = 1;
          localIOException.Nry.Lrj = new LinkedList();
          localIOException.Nry.Lrj.add(localObject2);
        }
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "relay conn cnt: " + localIOException.Nrx.MPZ);
        try
        {
          w.this.GSZ.GVV.HbZ = localIOException.Nrx.toByteArray();
        }
        catch (Exception localException2)
        {
          try
          {
            w.this.GSZ.GVV.Hca = localIOException.Nry.toByteArray();
          }
          catch (Exception localException2)
          {
            try
            {
              for (;;)
              {
                if (localIOException.Nsh.LYw > 0) {
                  w.this.GSZ.GVV.Hcb = localIOException.Nsh.toByteArray();
                }
                e.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + w.this.GZQ.Nsf);
                w.this.GSZ.k(w.this.GZQ.NrO, w.this.GZQ.NrP, w.this.GZQ.NrQ, w.this.GZQ.NrR, w.this.GZQ.NrS);
                w.this.GSZ.adj(w.this.GZQ.NrW);
                localObject2 = w.this.GSZ;
                i = w.this.GZQ.NrI;
                int j = w.this.GZQ.NrJ;
                ((l)localObject2).GVV.HaC = i;
                ((l)localObject2).GVV.HaD = j;
                w.this.GSZ.adi(w.this.GZQ.NrZ);
                w.this.GSZ.GVV.HbM = localIOException.Nsa;
                if ((localIOException.Nsc != null) && (localIOException.Nsc.getBuffer() != null)) {
                  w.this.GSZ.GVV.HaG = localIOException.Nsc.getBuffer().toByteArray();
                }
                if ((localIOException.NrU != null) && (localIOException.NrU.getBuffer() != null) && (localIOException.NrV != null) && (localIOException.NrV.getBuffer() != null)) {
                  w.this.GSZ.c(localIOException.NrT, localIOException.NrU.getBuffer().toByteArray(), localIOException.NrV.getBuffer().toByteArray());
                }
                localObject2 = w.this.GSZ;
                cez localcez = w.this.GZQ.Nsb;
                localObject2 = ((l)localObject2).GVV;
                e.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + localcez.Mky + " Bitrate: " + localcez.Mkz);
                ((v2protocal)localObject2).field_jbmParamArraySize = 27;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray = new int[((v2protocal)localObject2).field_jbmParamArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[0] = localcez.Mkx;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[1] = localcez.Mky;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[2] = localcez.Mkz;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[3] = localcez.MkA;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[4] = localcez.MkB;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[5] = localcez.MkC;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[6] = localcez.MkD;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[7] = localcez.MkG;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[8] = localcez.MkH;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[9] = localcez.MkK;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[10] = localcez.MkL;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[11] = localcez.MkO;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[12] = localcez.MkP;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[13] = localcez.MkS;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[14] = localcez.MkT;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[15] = localcez.MkW;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[16] = localcez.MkX;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[17] = localcez.Mla;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[18] = localcez.Mlb;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[19] = localcez.Mle;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[20] = localcez.Mlf;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[21] = localcez.Mli;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[22] = localcez.Mlj;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[23] = localcez.Mlm;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[24] = localcez.Mln;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[25] = localcez.Mlq;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[26] = localcez.Mlr;
                ((v2protocal)localObject2).field_jbmParamDoubleArraySize = 20;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray = new double[((v2protocal)localObject2).field_jbmParamDoubleArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[0] = localcez.MkE;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[1] = localcez.MkF;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[2] = localcez.MkI;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[3] = localcez.MkJ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[4] = localcez.MkM;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[5] = localcez.MkN;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[6] = localcez.MkQ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[7] = localcez.MkR;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[8] = localcez.MkU;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[9] = localcez.MkV;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[10] = localcez.MkY;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[11] = localcez.MkZ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[12] = localcez.Mlc;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[13] = localcez.Mld;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[14] = localcez.Mlg;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[15] = localcez.Mlh;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[16] = localcez.Mlk;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[17] = localcez.Mll;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[18] = localcez.Mlo;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[19] = localcez.Mlp;
                w.this.GSZ.fGI();
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
  
  public final void a(euv parameuv, int paramInt)
  {
    AppMethodBeat.i(115207);
    e.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + parameuv.oTW);
    if (parameuv.oTW == 1)
    {
      this.GSZ.GVu = true;
      if (1 == paramInt) {
        this.GSZ.GVV.Hcw.fGS();
      }
      if (3 == paramInt) {
        this.GSZ.GVV.Hcw.fGT();
      }
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(paramInt)));
      this.GSZ.GVW.dZK();
      c.fFg().GYS.fIB();
      this.GSZ.GVv = true;
      if (this.GSZ.GVx == true)
      {
        this.GSZ.GVx = false;
        if (this.GSZ.GVt != true) {
          break label249;
        }
        e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115198);
            w.this.GSZ.fGy();
            AppMethodBeat.o(115198);
          }
        });
      }
      for (;;)
      {
        h.CyF.a(11519, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(2) });
        this.GSZ.fGI();
        this.GSZ.fGK();
        AppMethodBeat.o(115207);
        return;
        label249:
        if (this.GSZ.GVw == true)
        {
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
          this.GSZ.K(1, -9000, "");
        }
        else
        {
          e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
        }
      }
    }
    if (parameuv.oTW == 6)
    {
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
      this.GSZ.GVx = true;
      this.GSZ.GVV.Hbj = 1;
      this.GSZ.fGI();
      AppMethodBeat.o(115207);
      return;
    }
    if (parameuv.oTW == 8)
    {
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
      this.GSZ.GVV.Hcw.GXd = 211;
      this.GSZ.GVV.Hcw.GXc = 11;
      this.GSZ.GVV.Hcw.GXo = 12;
      h.CyF.a(11519, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(3) });
      this.GSZ.K(1, 211, "");
      this.GSZ.fGK();
      AppMethodBeat.o(115207);
      return;
    }
    if (parameuv.oTW == 2)
    {
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
      this.GSZ.GVV.Hcw.GXc = 103;
      this.GSZ.GVV.Hcw.GXo = 4;
      this.GSZ.GVV.Hcw.GXv = ((int)(System.currentTimeMillis() - this.GSZ.GVV.Hcw.beginTime));
      h.CyF.a(11519, new Object[] { Integer.valueOf(c.fFg().fHU()), Long.valueOf(c.fFg().fHV()), Long.valueOf(c.fFg().fGu()), Integer.valueOf(1) });
      this.GSZ.fGK();
      this.GSZ.K(4, 0, "");
      AppMethodBeat.o(115207);
      return;
    }
    if (parameuv.oTW == 3)
    {
      this.GSZ.GVV.Hcw.GXo = 5;
      AppMethodBeat.o(115207);
      return;
    }
    if (parameuv.oTW == 4)
    {
      e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
      if (this.GSZ.mStatus < 6) {
        this.GSZ.GVV.Hcw.GXp = 1;
      }
      this.GSZ.GVV.Hcw.GXc = 110;
      this.GSZ.K(6, 0, "");
      this.GSZ.fGK();
      AppMethodBeat.o(115207);
      return;
    }
    e.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + parameuv.oTW);
    AppMethodBeat.o(115207);
  }
  
  public final void adv(int paramInt)
  {
    AppMethodBeat.i(115202);
    Object localObject2 = e.int2bytes(paramInt);
    Object localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = new SKBuiltinBuffer_t();
    try
    {
      ((SKBuiltinBuffer_t)localObject2).setBuffer(((SKBuiltinBuffer_t)localObject1).toByteArray());
      localObject1 = new etm();
      ((etm)localObject1).Lms = 3;
      ((etm)localObject1).Lmt = ((SKBuiltinBuffer_t)localObject2);
      ((etm)localObject1).xNH = z.aTY();
      localObject2 = new etn();
      ((etn)localObject2).oTz = 1;
      ((etn)localObject2).oTA.add(localObject1);
      a((etn)localObject2, false, 4);
      AppMethodBeat.o(115202);
      return;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
      AppMethodBeat.o(115202);
    }
  }
  
  public final void b(euk parameuk)
  {
    AppMethodBeat.i(115210);
    this.GSZ.ck(parameuk.KMS.getBuffer().toByteArray());
    AppMethodBeat.o(115210);
  }
  
  public final void c(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(115211);
    int i = e.co(paramSKBuiltinBuffer_t.getBuffer().toByteArray());
    e.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(i)));
    this.GSZ.ade(i & 0xFF);
    AppMethodBeat.o(115211);
  }
  
  public final void fIE()
  {
    AppMethodBeat.i(115205);
    if (this.GZR == null)
    {
      AppMethodBeat.o(115205);
      return;
    }
    this.GZR.oTA.clear();
    this.GZR.oTz = 0;
    this.GZR = null;
    this.GZS = 0;
    AppMethodBeat.o(115205);
  }
  
  public final void p(q paramq)
  {
    AppMethodBeat.i(115212);
    Log.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
    this.GSZ.GWb = false;
    Object localObject1 = (eux)((m)paramq).fIJ();
    if (this.GSZ.GVZ == null)
    {
      AppMethodBeat.o(115212);
      return;
    }
    this.GSZ.GVV.parseSyncKeyBuff(this.GSZ.GVZ, this.GSZ.GVZ.length);
    int j = this.GSZ.GVV.field_statusSyncKey;
    int k = this.GSZ.GVV.field_relayDataSyncKey;
    int m = this.GSZ.GVV.field_connectingStatusKey;
    this.GSZ.GVV.parseSyncKeyBuff(((eux)localObject1).Lev.getBuffer().toByteArray(), ((eux)localObject1).Lev.getILen());
    int n = this.GSZ.GVV.field_statusSyncKey;
    int i1 = this.GSZ.GVV.field_relayDataSyncKey;
    int i2 = this.GSZ.GVV.field_connectingStatusKey;
    Log.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + j + " oldRelayDataSyncKey:" + k + " oldConnectingStatusSyncKey:" + m);
    Log.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + n + " newRelayDataSyncKey:" + i1 + " newConnectingStatusSyncKey:" + i2);
    this.GSZ.GVZ = ((eux)localObject1).Lev.getBuffer().toByteArray();
    Log.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + ((eux)localObject1).KZh);
    localObject1 = ((eux)localObject1).NsY.oTA;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0))
    {
      Log.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + ((LinkedList)localObject1).size());
      int i = ((m)paramq).fIH();
      Log.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + ((LinkedList)localObject1).size() + ",selector = " + i);
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        paramq = (etm)((LinkedList)localObject1).get(i);
        int i3 = paramq.Lms;
        Log.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i3)));
        if (i3 == 1) {
          if (n > j)
          {
            if (this.GSZ.GVV.roomId != 0) {
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
            localObject2 = (euv)new euv().parseFrom(paramq.Lmt.getBuffer().toByteArray());
            e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + paramq.xNH + ",itemStatus =  " + ((euv)localObject2).oTW);
            a((euv)localObject2, 3);
          }
          catch (IOException paramq)
          {
            Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramq, "", new Object[0]);
          }
          continue;
          if (i3 == 2)
          {
            if (i1 > k) {
              if (this.GSZ.GVV.roomId == 0)
              {
                e.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
              }
              else
              {
                try
                {
                  localObject2 = (euk)new euk().parseFrom(paramq.Lmt.getBuffer().toByteArray());
                  e.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + ((euk)localObject2).oUv + ",from user = " + paramq.xNH);
                  if (((euk)localObject2).oUv != 5) {
                    break label712;
                  }
                  a((euk)localObject2);
                }
                catch (IOException paramq)
                {
                  Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramq, "", new Object[0]);
                }
                continue;
                label712:
                if (((euk)localObject2).oUv == 3)
                {
                  this.GSZ.cj(((euk)localObject2).KMS.getBuffer().toByteArray());
                  if ((((euk)localObject2).KMS != null) && (((euk)localObject2).KMS.getBuffer() != null)) {
                    this.GZQ.NpK = ((euk)localObject2);
                  }
                }
                else if (((euk)localObject2).oUv == 2)
                {
                  this.GSZ.ci(((euk)localObject2).KMS.getBuffer().toByteArray());
                  if ((((euk)localObject2).KMS != null) && (((euk)localObject2).KMS.getBuffer() != null)) {
                    this.GZQ.NpJ = ((euk)localObject2);
                  }
                }
                else if (((euk)localObject2).oUv == 1)
                {
                  b((euk)localObject2);
                }
                else if (((euk)localObject2).oUv == 6)
                {
                  paramq = ((euk)localObject2).KMS.getBuffer().toByteArray();
                  try
                  {
                    paramq = (eud)new eud().parseFrom(paramq);
                    if (paramq == null) {
                      continue;
                    }
                    this.GSZ.GVY.a(paramq);
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
            if (this.GSZ.GVV.roomId == 0)
            {
              Log.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
            }
            else
            {
              try
              {
                localObject2 = new SKBuiltinBuffer_t().parseFrom(paramq.Lmt.getBuffer().toByteArray());
                if (!paramq.xNH.equals(z.aTY())) {
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
              c((SKBuiltinBuffer_t)localObject2);
            }
          }
        }
      }
    }
    Log.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
    if (((this.GZR != null) && (this.GZR.oTz > 0)) || (this.GZS > 0)) {
      a(null, false, 7);
    }
    AppMethodBeat.o(115212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.w
 * JD-Core Version:    0.7.0.1
 */