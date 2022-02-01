package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.protocal.protobuf.abv;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.bjj;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dmd;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.dmv;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dnm;
import com.tencent.mm.protocal.protobuf.dno;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.io.IOException;
import java.util.LinkedList;

public final class w
{
  l zfA;
  dmv zmN;
  private dme zmO;
  private int zmP;
  
  public w(l paraml)
  {
    AppMethodBeat.i(115201);
    this.zfA = null;
    this.zmN = new dmv();
    this.zmO = null;
    this.zmP = 0;
    this.zfA = paraml;
    AppMethodBeat.o(115201);
  }
  
  private void a(dme paramdme)
  {
    AppMethodBeat.i(115203);
    if (paramdme == null)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
      this.zmP += 1;
      AppMethodBeat.o(115203);
      return;
    }
    if (this.zmO == null) {
      this.zmO = new dme();
    }
    int i = 0;
    while (i < paramdme.mAK)
    {
      dmd localdmd = (dmd)paramdme.mAL.get(i);
      this.zmO.mAL.add(localdmd);
      i += 1;
    }
    this.zmO.mAK = this.zmO.mAL.size();
    AppMethodBeat.o(115203);
  }
  
  private void b(dme paramdme)
  {
    AppMethodBeat.i(115204);
    if ((this.zmO == null) || (this.zmO.mAK <= 0))
    {
      AppMethodBeat.o(115204);
      return;
    }
    int i = 0;
    while (i < this.zmO.mAK)
    {
      dmd localdmd = (dmd)this.zmO.mAL.get(i);
      paramdme.mAL.add(localdmd);
      i += 1;
    }
    paramdme.mAK = paramdme.mAL.size();
    dVf();
    AppMethodBeat.o(115204);
  }
  
  public final void Qt(int paramInt)
  {
    AppMethodBeat.i(115202);
    Object localObject2 = com.tencent.mm.plugin.voip.b.c.QA(paramInt);
    Object localObject1 = new SKBuiltinBuffer_t();
    ((SKBuiltinBuffer_t)localObject1).setBuffer((byte[])localObject2);
    localObject2 = new SKBuiltinBuffer_t();
    try
    {
      ((SKBuiltinBuffer_t)localObject2).setBuffer(((SKBuiltinBuffer_t)localObject1).toByteArray());
      localObject1 = new dmd();
      ((dmd)localObject1).CYY = 3;
      ((dmd)localObject1).CYZ = ((SKBuiltinBuffer_t)localObject2);
      ((dmd)localObject1).sdQ = com.tencent.mm.model.u.aqG();
      localObject2 = new dme();
      ((dme)localObject2).mAK = 1;
      ((dme)localObject2).mAL.add(localObject1);
      a((dme)localObject2, false, 4);
      AppMethodBeat.o(115202);
      return;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
      AppMethodBeat.o(115202);
    }
  }
  
  public final int a(dme paramdme, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(115206);
    if (this.zfA.ziZ.roomId == 0)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipSyncHandle", f.XJ() + "failed to do voip sync , roomid = 0");
      AppMethodBeat.o(115206);
      return 0;
    }
    if (this.zfA.zjf)
    {
      com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipSyncHandle", f.XJ() + "voip syncing, push to cache...");
      a(paramdme);
      AppMethodBeat.o(115206);
      return 0;
    }
    this.zfA.zjf = true;
    if (paramdme == null)
    {
      paramdme = new dme();
      paramdme.mAK = 0;
      paramdme.mAL = new LinkedList();
    }
    for (;;)
    {
      b(paramdme);
      this.zmP = 0;
      if (this.zfA.zjd == null) {
        this.zfA.zjd = "".getBytes();
      }
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + paramBoolean + ",cmdList:" + paramdme.mAK + ",syncKey.length:" + this.zfA.zjd.length + ",selector:" + paramInt);
      new m(this.zfA.ziZ.roomId, paramdme, this.zfA.zjd, this.zfA.ziZ.sAY, paramInt).dVj();
      AppMethodBeat.o(115206);
      return 0;
    }
  }
  
  public final void a(final dmu paramdmu)
  {
    AppMethodBeat.i(115208);
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115200);
        aq.f(new w.2(w.this, paramdmu));
        AppMethodBeat.o(115200);
      }
    });
    AppMethodBeat.o(115208);
  }
  
  public final void a(final dnb paramdnb)
  {
    AppMethodBeat.i(115209);
    g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177026);
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
        Object localObject1 = paramdnb.CCV.getBuffer().toByteArray();
        int i;
        for (;;)
        {
          try
          {
            localObject1 = (dmv)new dmv().parseFrom((byte[])localObject1);
            if ((((dmv)localObject1).EAU != null) && (((dmv)localObject1).EAU.CCV != null) && (((dmv)localObject1).EAU.CCV.getBuffer() != null)) {
              w.this.zmN.EAU = ((dmv)localObject1).EAU;
            }
            if ((((dmv)localObject1).EAV.CCV != null) && (((dmv)localObject1).EAV.CCV.getBuffer() != null)) {
              w.this.zmN.EAV = ((dmv)localObject1).EAV;
            }
            if (((dmv)localObject1).ECP != 0) {
              w.this.zmN.ECP = ((dmv)localObject1).ECP;
            }
            if ((((dmv)localObject1).ECQ != null) && (((dmv)localObject1).ECQ.EBj != 0)) {
              w.this.zmN.ECQ = ((dmv)localObject1).ECQ;
            }
            if ((((dmv)localObject1).ECR != null) && (((dmv)localObject1).ECR.EBj != 0)) {
              w.this.zmN.ECR = ((dmv)localObject1).ECR;
            }
            if ((((dmv)localObject1).EDr != null) && (((dmv)localObject1).EDr.size() != 0))
            {
              w.this.zmN.EDr = ((dmv)localObject1).EDr;
              w.this.zmN.EDq = ((dmv)localObject1).EDr.size();
            }
            if (((dmv)localObject1).ECT != 0) {
              w.this.zmN.ECT = ((dmv)localObject1).ECT;
            }
            if (((dmv)localObject1).ECU != 0) {
              w.this.zmN.ECU = ((dmv)localObject1).ECU;
            }
            if (((dmv)localObject1).ECY.EBj != 0) {
              w.this.zmN.ECY = ((dmv)localObject1).ECY;
            }
            if (((dmv)localObject1).ECZ > 0)
            {
              w.this.zmN.ECZ = ((dmv)localObject1).ECZ;
              if (((dmv)localObject1).sBt <= 0) {
                break label907;
              }
              w.this.zmN.sBt = (((dmv)localObject1).sBt - 1);
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + w.this.zmN.sBt + "] from relaydata");
              if (((dmv)localObject1).EDa <= 0) {
                break label928;
              }
              w.this.zmN.EDa = ((dmv)localObject1).EDa;
              w.this.zmN.EDb = ((dmv)localObject1).EDb;
              w.this.zmN.EDc = ((dmv)localObject1).EDc;
              w.this.zmN.EDd = ((dmv)localObject1).EDd;
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + ((dmv)localObject1).EDa + ", ARQRttThreshold: " + ((dmv)localObject1).EDb + ", ARQUsedRateThreshold: " + ((dmv)localObject1).EDc + ", ARQRespRateThreshold: " + ((dmv)localObject1).EDd);
              if (((dmv)localObject1).EDh <= 0) {
                break label938;
              }
              w.this.zmN.EDh = ((dmv)localObject1).EDh;
              w.this.zmN.EDk = ((dmv)localObject1).EDk;
              if (((dmv)localObject1).EDm != null) {
                w.this.zmN.EDm = ((dmv)localObject1).EDm;
              }
              w.this.zmN.EDp = ((dmv)localObject1).EDp;
              w.this.zmN.EDo = ((dmv)localObject1).EDo;
              w.this.zfA.zjn.b(((dmv)localObject1).EDp, ((dmv)localObject1).EDo, w.this.zfA.ziZ.roomId, w.this.zfA.ziZ.sAY);
              if ((w.this.zmN.EAU == null) || (w.this.zmN.EAU.CCV == null) || (w.this.zmN.EAU.CCV.getBuffer() == null) || (w.this.zmN.ECP == 0) || (w.this.zmN.EAV == null) || (w.this.zmN.EAV.CCV == null) || (w.this.zmN.EAV.CCV.getBuffer() == null) || (w.this.zmN.ECQ == null) || (w.this.zmN.ECQ.EBj == 0) || (w.this.zmN.ECR == null) || (w.this.zmN.ECR.EBj == 0) || (w.this.zmN.ECY == null) || (w.this.zmN.ECY.EBj == 0)) {
                break label959;
              }
              i = 1;
              if (i != 0) {
                break;
              }
              com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
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
          w.this.zmN.ECZ = 0;
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
          continue;
          label907:
          w.this.zmN.sBt = 1;
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
          continue;
          label928:
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
          continue;
          label938:
          w.this.zmN.EDh = 0;
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
          continue;
          label959:
          i = 0;
        }
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + w.this.zmN.EDk + " BothSideSwitchFlag = " + localIOException.EDl);
        w.this.zfA.Qi(w.this.zmN.ECP);
        w.this.zfA.bJ(w.this.zmN.EAU.CCV.getBuffer().toByteArray());
        if ((localIOException.ECW != null) && (localIOException.ECW.getBuffer() != null) && (localIOException.EDi != null) && (localIOException.EDi.getBuffer() != null)) {
          w.this.zfA.a(localIOException.ECW.getBuffer().toByteArray(), localIOException.ECV, w.this.zmN.sBt, localIOException.EDi.getBuffer().toByteArray());
        }
        if (com.tencent.mm.plugin.voip.c.dRQ().dUz() != 0) {
          w.this.zfA.bK(w.this.zmN.EAV.CCV.getBuffer().toByteArray());
        }
        Object localObject2;
        if ((localIOException.ECI == null) || (localIOException.ECI.Eee == 0))
        {
          localObject2 = new cir();
          ((cir)localObject2).Dch = 0;
          ((cir)localObject2).Dci = "";
          ((cir)localObject2).Dcj = "";
          ((cir)localObject2).Dck = w.this.zfA.ziZ.netType;
          ((cir)localObject2).Dcl = 4;
          ((cir)localObject2).Dcm = 2;
          ((cir)localObject2).Eec = localIOException.ECQ;
          ((cir)localObject2).Eed = localIOException.ECY;
          localIOException.ECI = new cis();
          localIOException.ECI.Eee = 1;
          localIOException.ECI.Eef = new LinkedList();
          localIOException.ECI.Eef.add(localObject2);
        }
        if ((localIOException.ECJ == null) || (localIOException.ECJ.Dcs == 0))
        {
          localObject2 = new abu();
          ((abu)localObject2).Dch = 1;
          ((abu)localObject2).Dci = "";
          ((abu)localObject2).Dcj = "";
          ((abu)localObject2).Dck = w.this.zfA.ziZ.netType;
          ((abu)localObject2).Dcl = 4;
          ((abu)localObject2).Dcm = 2;
          ((abu)localObject2).Dcn = localIOException.ECR;
          ((abu)localObject2).Dco = localIOException.EDq;
          ((abu)localObject2).Dcp = localIOException.EDr;
          localIOException.ECJ = new abv();
          localIOException.ECJ.Dcs = 1;
          localIOException.ECJ.Dct = new LinkedList();
          localIOException.ECJ.Dct.add(localObject2);
        }
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "relay conn cnt: " + localIOException.ECI.Eee);
        try
        {
          w.this.zfA.ziZ.zoT = localIOException.ECI.toByteArray();
        }
        catch (Exception localException2)
        {
          try
          {
            w.this.zfA.ziZ.zoU = localIOException.ECJ.toByteArray();
          }
          catch (Exception localException2)
          {
            try
            {
              for (;;)
              {
                if (localIOException.EDs.DvR > 0) {
                  w.this.zfA.ziZ.zoV = localIOException.EDs.toByteArray();
                }
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + w.this.zmN.EDq);
                w.this.zfA.i(w.this.zmN.ECZ, w.this.zmN.EDa, w.this.zmN.EDb, w.this.zmN.EDc, w.this.zmN.EDd);
                w.this.zfA.Qh(w.this.zmN.EDh);
                localObject2 = w.this.zfA;
                i = w.this.zmN.ECT;
                int j = w.this.zmN.ECU;
                ((l)localObject2).ziZ.zny = i;
                ((l)localObject2).ziZ.znz = j;
                w.this.zfA.Qg(w.this.zmN.EDk);
                w.this.zfA.ziZ.zoH = localIOException.EDl;
                if ((localIOException.EDn != null) && (localIOException.EDn.getBuffer() != null)) {
                  w.this.zfA.ziZ.znC = localIOException.EDn.getBuffer().toByteArray();
                }
                if ((localIOException.EDf != null) && (localIOException.EDf.getBuffer() != null) && (localIOException.EDg != null) && (localIOException.EDg.getBuffer() != null)) {
                  w.this.zfA.c(localIOException.EDe, localIOException.EDf.getBuffer().toByteArray(), localIOException.EDg.getBuffer().toByteArray());
                }
                localObject2 = w.this.zfA;
                bjj localbjj = w.this.zmN.EDm;
                localObject2 = ((l)localObject2).ziZ;
                com.tencent.mm.plugin.voip.b.c.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + localbjj.DGT + " Bitrate: " + localbjj.DGU);
                ((v2protocal)localObject2).field_jbmParamArraySize = 27;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray = new int[((v2protocal)localObject2).field_jbmParamArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[0] = localbjj.DGS;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[1] = localbjj.DGT;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[2] = localbjj.DGU;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[3] = localbjj.DGV;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[4] = localbjj.DGW;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[5] = localbjj.DGX;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[6] = localbjj.DGY;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[7] = localbjj.DHb;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[8] = localbjj.DHc;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[9] = localbjj.DHf;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[10] = localbjj.DHg;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[11] = localbjj.DHj;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[12] = localbjj.DHk;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[13] = localbjj.DHn;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[14] = localbjj.DHo;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[15] = localbjj.DHr;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[16] = localbjj.DHs;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[17] = localbjj.DHv;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[18] = localbjj.DHw;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[19] = localbjj.DHz;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[20] = localbjj.DHA;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[21] = localbjj.DHD;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[22] = localbjj.DHE;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[23] = localbjj.DHH;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[24] = localbjj.DHI;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[25] = localbjj.DHL;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[26] = localbjj.DHM;
                ((v2protocal)localObject2).field_jbmParamDoubleArraySize = 20;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray = new double[((v2protocal)localObject2).field_jbmParamDoubleArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[0] = localbjj.DGZ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[1] = localbjj.DHa;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[2] = localbjj.DHd;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[3] = localbjj.DHe;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[4] = localbjj.DHh;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[5] = localbjj.DHi;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[6] = localbjj.DHl;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[7] = localbjj.DHm;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[8] = localbjj.DHp;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[9] = localbjj.DHq;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[10] = localbjj.DHt;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[11] = localbjj.DHu;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[12] = localbjj.DHx;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[13] = localbjj.DHy;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[14] = localbjj.DHB;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[15] = localbjj.DHC;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[16] = localbjj.DHF;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[17] = localbjj.DHG;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[18] = localbjj.DHJ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[19] = localbjj.DHK;
                w.this.zfA.dTo();
                com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
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
  
  public final void a(dnm paramdnm, int paramInt)
  {
    AppMethodBeat.i(115207);
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + paramdnm.mBi);
    if (paramdnm.mBi == 1)
    {
      this.zfA.ziy = true;
      if (1 == paramInt) {
        this.zfA.ziZ.zpq.dTy();
      }
      if (3 == paramInt) {
        this.zfA.ziZ.zpq.dTz();
      }
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(paramInt)));
      this.zfA.zja.cGD();
      com.tencent.mm.plugin.voip.c.dRQ().zlR.dVc();
      this.zfA.ziz = true;
      if (this.zfA.ziB == true)
      {
        this.zfA.ziB = false;
        if (this.zfA.zix != true) {
          break label250;
        }
        com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115198);
            w.this.zfA.dTg();
            AppMethodBeat.o(115198);
          }
        });
      }
      for (;;)
      {
        h.vKh.f(11519, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(2) });
        this.zfA.dTo();
        this.zfA.dTq();
        AppMethodBeat.o(115207);
        return;
        label250:
        if (this.zfA.ziA == true)
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
          this.zfA.I(1, -9000, "");
        }
        else
        {
          com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
        }
      }
    }
    if (paramdnm.mBi == 6)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
      this.zfA.ziB = true;
      this.zfA.ziZ.zoe = 1;
      this.zfA.dTo();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdnm.mBi == 8)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
      this.zfA.ziZ.zpq.zki = 211;
      this.zfA.ziZ.zpq.zkh = 11;
      this.zfA.ziZ.zpq.zkt = 12;
      h.vKh.f(11519, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(3) });
      this.zfA.I(1, 211, "");
      this.zfA.dTq();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdnm.mBi == 2)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
      this.zfA.ziZ.zpq.zkh = 103;
      this.zfA.ziZ.zpq.zkt = 4;
      this.zfA.ziZ.zpq.zkA = ((int)(System.currentTimeMillis() - this.zfA.ziZ.zpq.beginTime));
      h.vKh.f(11519, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(1) });
      this.zfA.dTq();
      this.zfA.I(4, 0, "");
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdnm.mBi == 3)
    {
      this.zfA.ziZ.zpq.zkt = 5;
      AppMethodBeat.o(115207);
      return;
    }
    if (paramdnm.mBi == 4)
    {
      com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
      if (this.zfA.mStatus < 6) {
        this.zfA.ziZ.zpq.zku = 1;
      }
      this.zfA.ziZ.zpq.zkh = 110;
      this.zfA.I(6, 0, "");
      this.zfA.dTq();
      AppMethodBeat.o(115207);
      return;
    }
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + paramdnm.mBi);
    AppMethodBeat.o(115207);
  }
  
  public final void b(dnb paramdnb)
  {
    AppMethodBeat.i(115210);
    this.zfA.bL(paramdnb.CCV.getBuffer().toByteArray());
    AppMethodBeat.o(115210);
  }
  
  public final void c(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(115211);
    int i = com.tencent.mm.plugin.voip.b.c.bP(paramSKBuiltinBuffer_t.getBuffer().toByteArray());
    com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(i)));
    this.zfA.Qc(i & 0xFF);
    AppMethodBeat.o(115211);
  }
  
  public final void dVf()
  {
    AppMethodBeat.i(115205);
    if (this.zmO == null)
    {
      AppMethodBeat.o(115205);
      return;
    }
    this.zmO.mAL.clear();
    this.zmO.mAK = 0;
    this.zmO = null;
    this.zmP = 0;
    AppMethodBeat.o(115205);
  }
  
  public final void o(n paramn)
  {
    AppMethodBeat.i(115212);
    ad.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
    this.zfA.zjf = false;
    Object localObject1 = (dno)((m)paramn).dVk();
    if (this.zfA.zjd == null)
    {
      AppMethodBeat.o(115212);
      return;
    }
    this.zfA.ziZ.parseSyncKeyBuff(this.zfA.zjd, this.zfA.zjd.length);
    int j = this.zfA.ziZ.field_statusSyncKey;
    int k = this.zfA.ziZ.field_relayDataSyncKey;
    int m = this.zfA.ziZ.field_connectingStatusKey;
    this.zfA.ziZ.parseSyncKeyBuff(((dno)localObject1).CRx.getBuffer().toByteArray(), ((dno)localObject1).CRx.getILen());
    int n = this.zfA.ziZ.field_statusSyncKey;
    int i1 = this.zfA.ziZ.field_relayDataSyncKey;
    int i2 = this.zfA.ziZ.field_connectingStatusKey;
    ad.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + j + " oldRelayDataSyncKey:" + k + " oldConnectingStatusSyncKey:" + m);
    ad.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + n + " newRelayDataSyncKey:" + i1 + " newConnectingStatusSyncKey:" + i2);
    this.zfA.zjd = ((dno)localObject1).CRx.getBuffer().toByteArray();
    ad.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + ((dno)localObject1).CNq);
    localObject1 = ((dno)localObject1).EEj.mAL;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0))
    {
      ad.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + ((LinkedList)localObject1).size());
      int i = ((m)paramn).dVi();
      ad.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + ((LinkedList)localObject1).size() + ",selector = " + i);
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        paramn = (dmd)((LinkedList)localObject1).get(i);
        int i3 = paramn.CYY;
        ad.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i3)));
        if (i3 == 1) {
          if (n > j)
          {
            if (this.zfA.ziZ.roomId != 0) {
              break label487;
            }
            com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
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
            localObject2 = (dnm)new dnm().parseFrom(paramn.CYZ.getBuffer().toByteArray());
            com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + paramn.sdQ + ",itemStatus =  " + ((dnm)localObject2).mBi);
            a((dnm)localObject2, 3);
          }
          catch (IOException paramn)
          {
            ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
          }
          continue;
          if (i3 == 2)
          {
            if (i1 > k) {
              if (this.zfA.ziZ.roomId == 0)
              {
                com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
              }
              else
              {
                try
                {
                  localObject2 = (dnb)new dnb().parseFrom(paramn.CYZ.getBuffer().toByteArray());
                  com.tencent.mm.plugin.voip.b.c.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + ((dnb)localObject2).mBH + ",from user = " + paramn.sdQ);
                  if (((dnb)localObject2).mBH != 5) {
                    break label712;
                  }
                  a((dnb)localObject2);
                }
                catch (IOException paramn)
                {
                  ad.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramn, "", new Object[0]);
                }
                continue;
                label712:
                if (((dnb)localObject2).mBH == 3)
                {
                  this.zfA.bK(((dnb)localObject2).CCV.getBuffer().toByteArray());
                  if ((((dnb)localObject2).CCV != null) && (((dnb)localObject2).CCV.getBuffer() != null)) {
                    this.zmN.EAV = ((dnb)localObject2);
                  }
                }
                else if (((dnb)localObject2).mBH == 2)
                {
                  this.zfA.bJ(((dnb)localObject2).CCV.getBuffer().toByteArray());
                  if ((((dnb)localObject2).CCV != null) && (((dnb)localObject2).CCV.getBuffer() != null)) {
                    this.zmN.EAU = ((dnb)localObject2);
                  }
                }
                else if (((dnb)localObject2).mBH == 1)
                {
                  b((dnb)localObject2);
                }
                else if (((dnb)localObject2).mBH == 6)
                {
                  paramn = ((dnb)localObject2).CCV.getBuffer().toByteArray();
                  try
                  {
                    paramn = (dmu)new dmu().parseFrom(paramn);
                    if (paramn == null) {
                      continue;
                    }
                    this.zfA.zjc.a(paramn);
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
            if (this.zfA.ziZ.roomId == 0)
            {
              ad.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
            }
            else
            {
              try
              {
                localObject2 = new SKBuiltinBuffer_t().parseFrom(paramn.CYZ.getBuffer().toByteArray());
                if (!paramn.sdQ.equals(com.tencent.mm.model.u.aqG())) {
                  break label1018;
                }
                com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
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
    if (((this.zmO != null) && (this.zmO.mAK > 0)) || (this.zmP > 0)) {
      a(null, false, 7);
    }
    AppMethodBeat.o(115212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.w
 * JD-Core Version:    0.7.0.1
 */