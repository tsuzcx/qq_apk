package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.protocal.protobuf.dxo;
import com.tencent.mm.protocal.protobuf.dxp;
import com.tencent.mm.protocal.protobuf.dyf;
import com.tencent.mm.protocal.protobuf.dyg;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.io.IOException;
import java.util.LinkedList;

public final class w
{
  l BXC;
  dyg CeB;
  private dxp CeC;
  private int CeD;
  
  public w(l paraml)
  {
    AppMethodBeat.i(115201);
    this.BXC = null;
    this.CeB = new dyg();
    this.CeC = null;
    this.CeD = 0;
    this.BXC = paraml;
    AppMethodBeat.o(115201);
  }
  
  private void a(dxp paramdxp)
  {
    AppMethodBeat.i(115203);
    if (paramdxp == null)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
      this.CeD += 1;
      AppMethodBeat.o(115203);
      return;
    }
    if (this.CeC == null) {
      this.CeC = new dxp();
    }
    int i = 0;
    while (i < paramdxp.nDi)
    {
      dxo localdxo = (dxo)paramdxp.nDj.get(i);
      this.CeC.nDj.add(localdxo);
      i += 1;
    }
    this.CeC.nDi = this.CeC.nDj.size();
    AppMethodBeat.o(115203);
  }
  
  private void b(dxp paramdxp)
  {
    AppMethodBeat.i(115204);
    if ((this.CeC == null) || (this.CeC.nDi <= 0))
    {
      AppMethodBeat.o(115204);
      return;
    }
    int i = 0;
    while (i < this.CeC.nDi)
    {
      dxo localdxo = (dxo)this.CeC.nDj.get(i);
      paramdxp.nDj.add(localdxo);
      i += 1;
    }
    paramdxp.nDi = paramdxp.nDj.size();
    eyc();
    AppMethodBeat.o(115204);
  }
  
  public final void Ut(int paramInt)
  {
    AppMethodBeat.i(115202);
    Object localObject2 = com.tencent.mm.plugin.voip.b.f.UC(paramInt);
    Object localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = new SKBuiltinBuffer_t();
    try
    {
      ((SKBuiltinBuffer_t)localObject2).setBuffer(((SKBuiltinBuffer_t)localObject1).toByteArray());
      localObject1 = new dxo();
      ((dxo)localObject1).FYU = 3;
      ((dxo)localObject1).FYV = ((SKBuiltinBuffer_t)localObject2);
      ((dxo)localObject1).ukj = com.tencent.mm.model.u.aAm();
      localObject2 = new dxp();
      ((dxp)localObject2).nDi = 1;
      ((dxp)localObject2).nDj.add(localObject1);
      a((dxp)localObject2, false, 4);
      AppMethodBeat.o(115202);
      return;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
      AppMethodBeat.o(115202);
    }
  }
  
  public final int a(dxp paramdxp, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(115206);
    if (this.BXC.CaI.roomId == 0)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", com.tencent.mm.compatible.util.f.abi() + "failed to do voip sync , roomid = 0");
      AppMethodBeat.o(115206);
      return 0;
    }
    if (this.BXC.CaO)
    {
      com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", com.tencent.mm.compatible.util.f.abi() + "voip syncing, push to cache...");
      a(paramdxp);
      AppMethodBeat.o(115206);
      return 0;
    }
    this.BXC.CaO = true;
    if (paramdxp == null)
    {
      paramdxp = new dxp();
      paramdxp.nDi = 0;
      paramdxp.nDj = new LinkedList();
    }
    for (;;)
    {
      b(paramdxp);
      this.CeD = 0;
      if (this.BXC.CaM == null) {
        this.BXC.CaM = "".getBytes();
      }
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + paramBoolean + ",cmdList:" + paramdxp.nDi + ",syncKey.length:" + this.BXC.CaM.length + ",selector:" + paramInt);
      new m(this.BXC.CaI.roomId, paramdxp, this.BXC.CaM, this.BXC.CaI.uLt, paramInt).eyg();
      AppMethodBeat.o(115206);
      return 0;
    }
  }
  
  public final void a(final dyf paramdyf)
  {
    AppMethodBeat.i(115208);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115200);
        aq.f(new w.2(w.this, paramdyf));
        AppMethodBeat.o(115200);
      }
    });
    AppMethodBeat.o(115208);
  }
  
  public final void a(final dym paramdym)
  {
    AppMethodBeat.i(115209);
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177026);
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
        Object localObject1 = paramdym.FAN.getBuffer().toByteArray();
        int i;
        for (;;)
        {
          try
          {
            localObject1 = (dyg)new dyg().parseFrom((byte[])localObject1);
            if ((((dyg)localObject1).HJd != null) && (((dyg)localObject1).HJd.FAN != null) && (((dyg)localObject1).HJd.FAN.getBuffer() != null)) {
              w.this.CeB.HJd = ((dyg)localObject1).HJd;
            }
            if ((((dyg)localObject1).HJe.FAN != null) && (((dyg)localObject1).HJe.FAN.getBuffer() != null)) {
              w.this.CeB.HJe = ((dyg)localObject1).HJe;
            }
            if (((dyg)localObject1).HKY != 0) {
              w.this.CeB.HKY = ((dyg)localObject1).HKY;
            }
            if ((((dyg)localObject1).HKZ != null) && (((dyg)localObject1).HKZ.HJs != 0)) {
              w.this.CeB.HKZ = ((dyg)localObject1).HKZ;
            }
            if ((((dyg)localObject1).HLa != null) && (((dyg)localObject1).HLa.HJs != 0)) {
              w.this.CeB.HLa = ((dyg)localObject1).HLa;
            }
            if ((((dyg)localObject1).HLA != null) && (((dyg)localObject1).HLA.size() != 0))
            {
              w.this.CeB.HLA = ((dyg)localObject1).HLA;
              w.this.CeB.HLz = ((dyg)localObject1).HLA.size();
            }
            if (((dyg)localObject1).HLc != 0) {
              w.this.CeB.HLc = ((dyg)localObject1).HLc;
            }
            if (((dyg)localObject1).HLd != 0) {
              w.this.CeB.HLd = ((dyg)localObject1).HLd;
            }
            if (((dyg)localObject1).HLh.HJs != 0) {
              w.this.CeB.HLh = ((dyg)localObject1).HLh;
            }
            if (((dyg)localObject1).HLi > 0)
            {
              w.this.CeB.HLi = ((dyg)localObject1).HLi;
              if (((dyg)localObject1).uLO <= 0) {
                break label907;
              }
              w.this.CeB.uLO = (((dyg)localObject1).uLO - 1);
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + w.this.CeB.uLO + "] from relaydata");
              if (((dyg)localObject1).HLj <= 0) {
                break label928;
              }
              w.this.CeB.HLj = ((dyg)localObject1).HLj;
              w.this.CeB.HLk = ((dyg)localObject1).HLk;
              w.this.CeB.HLl = ((dyg)localObject1).HLl;
              w.this.CeB.HLm = ((dyg)localObject1).HLm;
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + ((dyg)localObject1).HLj + ", ARQRttThreshold: " + ((dyg)localObject1).HLk + ", ARQUsedRateThreshold: " + ((dyg)localObject1).HLl + ", ARQRespRateThreshold: " + ((dyg)localObject1).HLm);
              if (((dyg)localObject1).HLq <= 0) {
                break label938;
              }
              w.this.CeB.HLq = ((dyg)localObject1).HLq;
              w.this.CeB.HLt = ((dyg)localObject1).HLt;
              if (((dyg)localObject1).HLv != null) {
                w.this.CeB.HLv = ((dyg)localObject1).HLv;
              }
              w.this.CeB.HLy = ((dyg)localObject1).HLy;
              w.this.CeB.HLx = ((dyg)localObject1).HLx;
              w.this.BXC.CaW.c(((dyg)localObject1).HLy, ((dyg)localObject1).HLx, w.this.BXC.CaI.roomId, w.this.BXC.CaI.uLt);
              if ((w.this.CeB.HJd == null) || (w.this.CeB.HJd.FAN == null) || (w.this.CeB.HJd.FAN.getBuffer() == null) || (w.this.CeB.HKY == 0) || (w.this.CeB.HJe == null) || (w.this.CeB.HJe.FAN == null) || (w.this.CeB.HJe.FAN.getBuffer() == null) || (w.this.CeB.HKZ == null) || (w.this.CeB.HKZ.HJs == 0) || (w.this.CeB.HLa == null) || (w.this.CeB.HLa.HJs == 0) || (w.this.CeB.HLh == null) || (w.this.CeB.HLh.HJs == 0)) {
                break label959;
              }
              i = 1;
              if (i != 0) {
                break;
              }
              com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
              AppMethodBeat.o(177026);
              return;
            }
          }
          catch (IOException localIOException)
          {
            ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
            AppMethodBeat.o(177026);
            return;
          }
          w.this.CeB.HLi = 0;
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
          continue;
          label907:
          w.this.CeB.uLO = 1;
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
          continue;
          label928:
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
          continue;
          label938:
          w.this.CeB.HLq = 0;
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
          continue;
          label959:
          i = 0;
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + w.this.CeB.HLt + " BothSideSwitchFlag = " + localIOException.HLu);
        w.this.BXC.Uj(w.this.CeB.HKY);
        w.this.BXC.bP(w.this.CeB.HJd.FAN.getBuffer().toByteArray());
        if ((localIOException.HLf != null) && (localIOException.HLf.getBuffer() != null) && (localIOException.HLr != null) && (localIOException.HLr.getBuffer() != null)) {
          w.this.BXC.a(localIOException.HLf.getBuffer().toByteArray(), localIOException.HLe, w.this.CeB.uLO, localIOException.HLr.getBuffer().toByteArray());
        }
        if (c.euM().exw() != 0) {
          w.this.BXC.bQ(w.this.CeB.HJe.FAN.getBuffer().toByteArray());
        }
        Object localObject2;
        if ((localIOException.HKR == null) || (localIOException.HKR.Hlr == 0))
        {
          localObject2 = new ctb();
          ((ctb)localObject2).GcK = 0;
          ((ctb)localObject2).GcL = "";
          ((ctb)localObject2).GcM = "";
          ((ctb)localObject2).GcN = w.this.BXC.CaI.netType;
          ((ctb)localObject2).GcO = 4;
          ((ctb)localObject2).GcP = 2;
          ((ctb)localObject2).Hlp = localIOException.HKZ;
          ((ctb)localObject2).Hlq = localIOException.HLh;
          localIOException.HKR = new ctc();
          localIOException.HKR.Hlr = 1;
          localIOException.HKR.Hls = new LinkedList();
          localIOException.HKR.Hls.add(localObject2);
        }
        if ((localIOException.HKS == null) || (localIOException.HKS.GcV == 0))
        {
          localObject2 = new aeu();
          ((aeu)localObject2).GcK = 1;
          ((aeu)localObject2).GcL = "";
          ((aeu)localObject2).GcM = "";
          ((aeu)localObject2).GcN = w.this.BXC.CaI.netType;
          ((aeu)localObject2).GcO = 4;
          ((aeu)localObject2).GcP = 2;
          ((aeu)localObject2).GcQ = localIOException.HLa;
          ((aeu)localObject2).GcR = localIOException.HLz;
          ((aeu)localObject2).GcS = localIOException.HLA;
          localIOException.HKS = new aev();
          localIOException.HKS.GcV = 1;
          localIOException.HKS.GcW = new LinkedList();
          localIOException.HKS.GcW.add(localObject2);
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "relay conn cnt: " + localIOException.HKR.Hlr);
        try
        {
          w.this.BXC.CaI.CgJ = localIOException.HKR.toByteArray();
        }
        catch (Exception localException2)
        {
          try
          {
            w.this.BXC.CaI.CgK = localIOException.HKS.toByteArray();
          }
          catch (Exception localException2)
          {
            try
            {
              for (;;)
              {
                if (localIOException.HLB.GAE > 0) {
                  w.this.BXC.CaI.CgL = localIOException.HLB.toByteArray();
                }
                com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + w.this.CeB.HLz);
                w.this.BXC.j(w.this.CeB.HLi, w.this.CeB.HLj, w.this.CeB.HLk, w.this.CeB.HLl, w.this.CeB.HLm);
                w.this.BXC.Ui(w.this.CeB.HLq);
                localObject2 = w.this.BXC;
                i = w.this.CeB.HLc;
                int j = w.this.CeB.HLd;
                ((l)localObject2).CaI.Cfm = i;
                ((l)localObject2).CaI.Cfn = j;
                w.this.BXC.Uh(w.this.CeB.HLt);
                w.this.BXC.CaI.Cgx = localIOException.HLu;
                if ((localIOException.HLw != null) && (localIOException.HLw.getBuffer() != null)) {
                  w.this.BXC.CaI.Cfq = localIOException.HLw.getBuffer().toByteArray();
                }
                if ((localIOException.HLo != null) && (localIOException.HLo.getBuffer() != null) && (localIOException.HLp != null) && (localIOException.HLp.getBuffer() != null)) {
                  w.this.BXC.c(localIOException.HLn, localIOException.HLo.getBuffer().toByteArray(), localIOException.HLp.getBuffer().toByteArray());
                }
                localObject2 = w.this.BXC;
                brl localbrl = w.this.CeB.HLv;
                localObject2 = ((l)localObject2).CaI;
                com.tencent.mm.plugin.voip.b.f.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + localbrl.GLN + " Bitrate: " + localbrl.GLO);
                ((v2protocal)localObject2).field_jbmParamArraySize = 27;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray = new int[((v2protocal)localObject2).field_jbmParamArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[0] = localbrl.GLM;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[1] = localbrl.GLN;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[2] = localbrl.GLO;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[3] = localbrl.GLP;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[4] = localbrl.GLQ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[5] = localbrl.GLR;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[6] = localbrl.GLS;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[7] = localbrl.GLV;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[8] = localbrl.GLW;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[9] = localbrl.GLZ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[10] = localbrl.GMa;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[11] = localbrl.GMd;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[12] = localbrl.GMe;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[13] = localbrl.GMh;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[14] = localbrl.GMi;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[15] = localbrl.GMl;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[16] = localbrl.GMm;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[17] = localbrl.GMp;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[18] = localbrl.GMq;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[19] = localbrl.GMt;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[20] = localbrl.GMu;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[21] = localbrl.GMx;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[22] = localbrl.GMy;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[23] = localbrl.GMB;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[24] = localbrl.GMC;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[25] = localbrl.GMF;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[26] = localbrl.GMG;
                ((v2protocal)localObject2).field_jbmParamDoubleArraySize = 20;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray = new double[((v2protocal)localObject2).field_jbmParamDoubleArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[0] = localbrl.GLT;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[1] = localbrl.GLU;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[2] = localbrl.GLX;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[3] = localbrl.GLY;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[4] = localbrl.GMb;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[5] = localbrl.GMc;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[6] = localbrl.GMf;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[7] = localbrl.GMg;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[8] = localbrl.GMj;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[9] = localbrl.GMk;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[10] = localbrl.GMn;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[11] = localbrl.GMo;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[12] = localbrl.GMr;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[13] = localbrl.GMs;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[14] = localbrl.GMv;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[15] = localbrl.GMw;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[16] = localbrl.GMz;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[17] = localbrl.GMA;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[18] = localbrl.GMD;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[19] = localbrl.GME;
                w.this.BXC.ewl();
                com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
                AppMethodBeat.o(177026);
                return;
                localException1 = localException1;
                ad.e("MicroMsg.Voip.VoipSyncHandle", "relay conn info to byte array fail..");
                continue;
                localException2 = localException2;
                ad.e("MicroMsg.Voip.VoipSyncHandle", "direct conn info to byte array fail..");
              }
            }
            catch (Exception localException3)
            {
              for (;;)
              {
                ad.e("MicroMsg.Voip.VoipSyncHandle", "nic query info to byte array fail..");
              }
            }
          }
        }
      }
    });
    AppMethodBeat.o(115209);
  }
  
  public final void a(dyx paramdyx, int paramInt)
  {
    AppMethodBeat.i(115207);
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + paramdyx.nDG);
    if (paramdyx.nDG == 1)
    {
      this.BXC.Cah = true;
      if (1 == paramInt) {
        this.BXC.CaI.Chg.ewv();
      }
      if (3 == paramInt) {
        this.BXC.CaI.Chg.eww();
      }
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(paramInt)));
      this.BXC.CaJ.dcY();
      c.euM().CdF.exZ();
      this.BXC.Cai = true;
      if (this.BXC.Cak == true)
      {
        this.BXC.Cak = false;
        if (this.BXC.Cag != true) {
          break label250;
        }
        com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115198);
            w.this.BXC.ewd();
            AppMethodBeat.o(115198);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(11519, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(2) });
        this.BXC.ewl();
        this.BXC.ewn();
        AppMethodBeat.o(115207);
        return;
        label250:
        if (this.BXC.Caj == true)
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
          this.BXC.J(1, -9000, "");
        }
        else
        {
          com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
        }
      }
    }
    if (paramdyx.nDG == 6)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
      this.BXC.Cak = true;
      this.BXC.CaI.CfU = 1;
      this.BXC.ewl();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdyx.nDG == 8)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
      this.BXC.CaI.Chg.CbT = 211;
      this.BXC.CaI.Chg.CbS = 11;
      this.BXC.CaI.Chg.Cce = 12;
      com.tencent.mm.plugin.report.service.g.yhR.f(11519, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(3) });
      this.BXC.J(1, 211, "");
      this.BXC.ewn();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdyx.nDG == 2)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
      this.BXC.CaI.Chg.CbS = 103;
      this.BXC.CaI.Chg.Cce = 4;
      this.BXC.CaI.Chg.Ccl = ((int)(System.currentTimeMillis() - this.BXC.CaI.Chg.beginTime));
      com.tencent.mm.plugin.report.service.g.yhR.f(11519, new Object[] { Integer.valueOf(c.euM().exw()), Long.valueOf(c.euM().exx()), Long.valueOf(c.euM().evX()), Integer.valueOf(1) });
      this.BXC.ewn();
      this.BXC.J(4, 0, "");
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdyx.nDG == 3)
    {
      this.BXC.CaI.Chg.Cce = 5;
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdyx.nDG == 4)
    {
      com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
      if (this.BXC.mStatus < 6) {
        this.BXC.CaI.Chg.Ccf = 1;
      }
      this.BXC.CaI.Chg.CbS = 110;
      this.BXC.J(6, 0, "");
      this.BXC.ewn();
      AppMethodBeat.o(115207);
      return;
    }
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + paramdyx.nDG);
    AppMethodBeat.o(115207);
  }
  
  public final void b(dym paramdym)
  {
    AppMethodBeat.i(115210);
    this.BXC.bR(paramdym.FAN.getBuffer().toByteArray());
    AppMethodBeat.o(115210);
  }
  
  public final void c(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(115211);
    int i = com.tencent.mm.plugin.voip.b.f.bV(paramSKBuiltinBuffer_t.getBuffer().toByteArray());
    com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(i)));
    this.BXC.Ud(i & 0xFF);
    AppMethodBeat.o(115211);
  }
  
  public final void eyc()
  {
    AppMethodBeat.i(115205);
    if (this.CeC == null)
    {
      AppMethodBeat.o(115205);
      return;
    }
    this.CeC.nDj.clear();
    this.CeC.nDi = 0;
    this.CeC = null;
    this.CeD = 0;
    AppMethodBeat.o(115205);
  }
  
  public final void n(n paramn)
  {
    AppMethodBeat.i(115212);
    ad.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
    this.BXC.CaO = false;
    Object localObject1 = (dyz)((m)paramn).eyh();
    if (this.BXC.CaM == null)
    {
      AppMethodBeat.o(115212);
      return;
    }
    this.BXC.CaI.parseSyncKeyBuff(this.BXC.CaM, this.BXC.CaM.length);
    int j = this.BXC.CaI.field_statusSyncKey;
    int k = this.BXC.CaI.field_relayDataSyncKey;
    int m = this.BXC.CaI.field_connectingStatusKey;
    this.BXC.CaI.parseSyncKeyBuff(((dyz)localObject1).FRr.getBuffer().toByteArray(), ((dyz)localObject1).FRr.getILen());
    int n = this.BXC.CaI.field_statusSyncKey;
    int i1 = this.BXC.CaI.field_relayDataSyncKey;
    int i2 = this.BXC.CaI.field_connectingStatusKey;
    ad.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + j + " oldRelayDataSyncKey:" + k + " oldConnectingStatusSyncKey:" + m);
    ad.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + n + " newRelayDataSyncKey:" + i1 + " newConnectingStatusSyncKey:" + i2);
    this.BXC.CaM = ((dyz)localObject1).FRr.getBuffer().toByteArray();
    ad.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + ((dyz)localObject1).FMr);
    localObject1 = ((dyz)localObject1).HMt.nDj;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0))
    {
      ad.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + ((LinkedList)localObject1).size());
      int i = ((m)paramn).eyf();
      ad.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + ((LinkedList)localObject1).size() + ",selector = " + i);
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        paramn = (dxo)((LinkedList)localObject1).get(i);
        int i3 = paramn.FYU;
        ad.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i3)));
        if (i3 == 1) {
          if (n > j)
          {
            if (this.BXC.CaI.roomId != 0) {
              break label487;
            }
            com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
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
            localObject2 = (dyx)new dyx().parseFrom(paramn.FYV.getBuffer().toByteArray());
            com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + paramn.ukj + ",itemStatus =  " + ((dyx)localObject2).nDG);
            a((dyx)localObject2, 3);
          }
          catch (IOException paramn)
          {
            ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
          }
          continue;
          if (i3 == 2)
          {
            if (i1 > k) {
              if (this.BXC.CaI.roomId == 0)
              {
                com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
              }
              else
              {
                try
                {
                  localObject2 = (dym)new dym().parseFrom(paramn.FYV.getBuffer().toByteArray());
                  com.tencent.mm.plugin.voip.b.f.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + ((dym)localObject2).nEf + ",from user = " + paramn.ukj);
                  if (((dym)localObject2).nEf != 5) {
                    break label712;
                  }
                  a((dym)localObject2);
                }
                catch (IOException paramn)
                {
                  ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
                }
                continue;
                label712:
                if (((dym)localObject2).nEf == 3)
                {
                  this.BXC.bQ(((dym)localObject2).FAN.getBuffer().toByteArray());
                  if ((((dym)localObject2).FAN != null) && (((dym)localObject2).FAN.getBuffer() != null)) {
                    this.CeB.HJe = ((dym)localObject2);
                  }
                }
                else if (((dym)localObject2).nEf == 2)
                {
                  this.BXC.bP(((dym)localObject2).FAN.getBuffer().toByteArray());
                  if ((((dym)localObject2).FAN != null) && (((dym)localObject2).FAN.getBuffer() != null)) {
                    this.CeB.HJd = ((dym)localObject2);
                  }
                }
                else if (((dym)localObject2).nEf == 1)
                {
                  b((dym)localObject2);
                }
                else if (((dym)localObject2).nEf == 6)
                {
                  paramn = ((dym)localObject2).FAN.getBuffer().toByteArray();
                  try
                  {
                    paramn = (dyf)new dyf().parseFrom(paramn);
                    if (paramn == null) {
                      continue;
                    }
                    this.BXC.CaL.a(paramn);
                  }
                  catch (IOException paramn)
                  {
                    for (;;)
                    {
                      ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
                      paramn = null;
                    }
                  }
                }
              }
            }
          }
          else if ((i3 == 3) && (i2 > m)) {
            if (this.BXC.CaI.roomId == 0)
            {
              ad.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
            }
            else
            {
              try
              {
                localObject2 = new SKBuiltinBuffer_t().parseFrom(paramn.FYV.getBuffer().toByteArray());
                if (!paramn.ukj.equals(com.tencent.mm.model.u.aAm())) {
                  break label1018;
                }
                com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
              }
              catch (IOException paramn)
              {
                ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
              }
              continue;
              label1018:
              c((SKBuiltinBuffer_t)localObject2);
            }
          }
        }
      }
    }
    ad.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
    if (((this.CeC != null) && (this.CeC.nDi > 0)) || (this.CeD > 0)) {
      a(null, false, 7);
    }
    AppMethodBeat.o(115212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.w
 * JD-Core Version:    0.7.0.1
 */