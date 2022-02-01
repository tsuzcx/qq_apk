package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.protocal.protobuf.del;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.fzo;
import com.tencent.mm.protocal.protobuf.gaj;
import com.tencent.mm.protocal.protobuf.gak;
import com.tencent.mm.protocal.protobuf.gba;
import com.tencent.mm.protocal.protobuf.gbb;
import com.tencent.mm.protocal.protobuf.gbh;
import com.tencent.mm.protocal.protobuf.gbs;
import com.tencent.mm.protocal.protobuf.gbu;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.io.IOException;
import java.util.LinkedList;

public final class w
{
  gbb UCM;
  private gak UCN;
  private int UCO;
  l UvO;
  
  public w(l paraml)
  {
    AppMethodBeat.i(115201);
    this.UvO = null;
    this.UCM = new gbb();
    this.UCN = null;
    this.UCO = 0;
    this.UvO = paraml;
    AppMethodBeat.o(115201);
  }
  
  private void a(gak paramgak)
  {
    AppMethodBeat.i(115203);
    if (paramgak == null)
    {
      g.Loge("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
      this.UCO += 1;
      AppMethodBeat.o(115203);
      return;
    }
    if (this.UCN == null) {
      this.UCN = new gak();
    }
    int i = 0;
    while (i < paramgak.vgN)
    {
      gaj localgaj = (gaj)paramgak.vgO.get(i);
      this.UCN.vgO.add(localgaj);
      i += 1;
    }
    this.UCN.vgN = this.UCN.vgO.size();
    AppMethodBeat.o(115203);
  }
  
  private void b(gak paramgak)
  {
    AppMethodBeat.i(115204);
    if ((this.UCN == null) || (this.UCN.vgN <= 0))
    {
      AppMethodBeat.o(115204);
      return;
    }
    int i = 0;
    while (i < this.UCN.vgN)
    {
      gaj localgaj = (gaj)this.UCN.vgO.get(i);
      paramgak.vgO.add(localgaj);
      i += 1;
    }
    paramgak.vgN = paramgak.vgO.size();
    hYS();
    AppMethodBeat.o(115204);
  }
  
  public final int a(gak paramgak, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(115206);
    if (this.UvO.UyU.roomId == 0)
    {
      g.Loge("MicroMsg.Voip.VoipSyncHandle", f.aPX() + "failed to do voip sync , roomid = 0");
      AppMethodBeat.o(115206);
      return 0;
    }
    if (this.UvO.Uza)
    {
      g.Loge("MicroMsg.Voip.VoipSyncHandle", f.aPX() + "voip syncing, push to cache...");
      a(paramgak);
      AppMethodBeat.o(115206);
      return 0;
    }
    this.UvO.Uza = true;
    if (paramgak == null)
    {
      paramgak = new gak();
      paramgak.vgN = 0;
      paramgak.vgO = new LinkedList();
    }
    for (;;)
    {
      b(paramgak);
      this.UCO = 0;
      if (this.UvO.UyY == null) {
        this.UvO.UyY = "".getBytes();
      }
      g.Logi("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + paramBoolean + ",cmdList:" + paramgak.vgN + ",syncKey.length:" + this.UvO.UyY.length + ",selector:" + paramInt);
      paramgak = new m(this.UvO.UyU.roomId, paramgak, this.UvO.UyY, this.UvO.UyU.Hnt, paramInt);
      this.UvO.UyU.UFN.UAQ = System.currentTimeMillis();
      paramgak.hYW();
      AppMethodBeat.o(115206);
      return 0;
    }
  }
  
  public final void a(final gba paramgba)
  {
    AppMethodBeat.i(115208);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115200);
        MMHandlerThread.postToMainThread(new w.2(w.this, paramgba));
        AppMethodBeat.o(115200);
      }
    });
    AppMethodBeat.o(115208);
  }
  
  public final void a(final gbh paramgbh)
  {
    AppMethodBeat.i(115209);
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177026);
        g.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
        Object localObject1 = paramgbh.YLa.aaxD.toByteArray();
        int i;
        for (;;)
        {
          try
          {
            localObject1 = (gbb)new gbb().parseFrom((byte[])localObject1);
            if ((((gbb)localObject1).abWP != null) && (((gbb)localObject1).abWP.YLa != null) && (((gbb)localObject1).abWP.YLa.aaxD != null)) {
              w.this.UCM.abWP = ((gbb)localObject1).abWP;
            }
            if ((((gbb)localObject1).abWQ.YLa != null) && (((gbb)localObject1).abWQ.YLa.aaxD != null)) {
              w.this.UCM.abWQ = ((gbb)localObject1).abWQ;
            }
            if (((gbb)localObject1).abYM != 0) {
              w.this.UCM.abYM = ((gbb)localObject1).abYM;
            }
            if ((((gbb)localObject1).abYN != null) && (((gbb)localObject1).abYN.abXf != 0)) {
              w.this.UCM.abYN = ((gbb)localObject1).abYN;
            }
            if ((((gbb)localObject1).abYO != null) && (((gbb)localObject1).abYO.abXf != 0)) {
              w.this.UCM.abYO = ((gbb)localObject1).abYO;
            }
            if ((((gbb)localObject1).abZo != null) && (((gbb)localObject1).abZo.size() != 0))
            {
              w.this.UCM.abZo = ((gbb)localObject1).abZo;
              w.this.UCM.abZn = ((gbb)localObject1).abZo.size();
            }
            if (((gbb)localObject1).abYQ != 0) {
              w.this.UCM.abYQ = ((gbb)localObject1).abYQ;
            }
            if (((gbb)localObject1).abYR != 0) {
              w.this.UCM.abYR = ((gbb)localObject1).abYR;
            }
            if (((gbb)localObject1).abYV.abXf != 0) {
              w.this.UCM.abYV = ((gbb)localObject1).abYV;
            }
            if (((gbb)localObject1).abYW > 0)
            {
              w.this.UCM.abYW = ((gbb)localObject1).abYW;
              if (((gbb)localObject1).JHp <= 0) {
                break label866;
              }
              w.this.UCM.JHp = (((gbb)localObject1).JHp - 1);
              g.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + w.this.UCM.JHp + "] from relaydata");
              if (((gbb)localObject1).abYX <= 0) {
                break label887;
              }
              w.this.UCM.abYX = ((gbb)localObject1).abYX;
              w.this.UCM.abYY = ((gbb)localObject1).abYY;
              w.this.UCM.abYZ = ((gbb)localObject1).abYZ;
              w.this.UCM.abZa = ((gbb)localObject1).abZa;
              g.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + ((gbb)localObject1).abYX + ", ARQRttThreshold: " + ((gbb)localObject1).abYY + ", ARQUsedRateThreshold: " + ((gbb)localObject1).abYZ + ", ARQRespRateThreshold: " + ((gbb)localObject1).abZa);
              if (((gbb)localObject1).abZe <= 0) {
                break label897;
              }
              w.this.UCM.abZe = ((gbb)localObject1).abZe;
              w.this.UCM.abZh = ((gbb)localObject1).abZh;
              if (((gbb)localObject1).abZj != null) {
                w.this.UCM.abZj = ((gbb)localObject1).abZj;
              }
              w.this.UCM.abZm = ((gbb)localObject1).abZm;
              w.this.UCM.abZl = ((gbb)localObject1).abZl;
              w.this.UvO.Uzi.d(((gbb)localObject1).abZm, ((gbb)localObject1).abZl, w.this.UvO.UyU.roomId, w.this.UvO.UyU.Hnt);
              if ((w.this.UCM.abWP == null) || (w.this.UCM.abWP.YLa == null) || (w.this.UCM.abWP.YLa.aaxD == null) || (w.this.UCM.abYM == 0) || (w.this.UCM.abWQ == null) || (w.this.UCM.abWQ.YLa == null) || (w.this.UCM.abWQ.YLa.aaxD == null) || (((w.this.UCM.abYN == null) || (w.this.UCM.abYN.abXf == 0)) && ((((gbb)localObject1).abYF == null) || (((gbb)localObject1).abYF.abtq <= 0)))) {
                break label918;
              }
              i = 1;
              if (i != 0) {
                break;
              }
              g.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
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
          w.this.UCM.abYW = 0;
          g.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
          continue;
          label866:
          w.this.UCM.JHp = 1;
          g.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
          continue;
          label887:
          g.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
          continue;
          label897:
          w.this.UCM.abZe = 0;
          g.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
          continue;
          label918:
          i = 0;
        }
        g.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + w.this.UCM.abZh + " BothSideSwitchFlag = " + localIOException.abZi);
        w.this.UvO.aqr(w.this.UCM.abYM);
        w.this.UvO.cC(w.this.UCM.abWP.YLa.aaxD.toByteArray());
        if ((localIOException.abYT != null) && (localIOException.abYT.aaxD != null) && (localIOException.abZf != null) && (localIOException.abZf.aaxD != null)) {
          w.this.UvO.a(localIOException.abYT.aaxD.toByteArray(), localIOException.abYS, w.this.UCM.JHp, localIOException.abZf.aaxD.toByteArray());
        }
        if (SubCoreVoip.hVp().hYr() != 0) {
          w.this.UvO.cD(w.this.UCM.abWQ.YLa.aaxD.toByteArray());
        }
        Object localObject2;
        if ((localIOException.abYF == null) || (localIOException.abYF.abtq == 0))
        {
          localObject2 = new epe();
          ((epe)localObject2).ZrC = 0;
          ((epe)localObject2).ZrD = "";
          ((epe)localObject2).ZrE = "";
          ((epe)localObject2).ZrF = w.this.UvO.UyU.netType;
          ((epe)localObject2).ZrG = 4;
          ((epe)localObject2).ZrH = 2;
          ((epe)localObject2).abto = localIOException.abYN;
          ((epe)localObject2).abtp = localIOException.abYV;
          localIOException.abYF = new epf();
          localIOException.abYF.abtq = 1;
          localIOException.abYF.abtr = new LinkedList();
          localIOException.abYF.abtr.add(localObject2);
        }
        if ((localIOException.abYG == null) || (localIOException.abYG.ZrN == 0))
        {
          localObject2 = new akl();
          ((akl)localObject2).ZrC = 1;
          ((akl)localObject2).ZrD = "";
          ((akl)localObject2).ZrE = "";
          ((akl)localObject2).ZrF = w.this.UvO.UyU.netType;
          ((akl)localObject2).ZrG = 4;
          ((akl)localObject2).ZrH = 2;
          ((akl)localObject2).ZrI = localIOException.abYO;
          ((akl)localObject2).ZrJ = localIOException.abZn;
          ((akl)localObject2).ZrK = localIOException.abZo;
          localIOException.abYG = new akm();
          localIOException.abYG.ZrN = 1;
          localIOException.abYG.ZrO = new LinkedList();
          localIOException.abYG.ZrO.add(localObject2);
        }
        g.Logi("MicroMsg.Voip.VoipSyncHandle", "relay conn cnt: " + localIOException.abYF.abtq);
        try
        {
          w.this.UvO.UyU.UFq = localIOException.abYF.toByteArray();
        }
        catch (Exception localException2)
        {
          try
          {
            w.this.UvO.UyU.UFr = localIOException.abYG.toByteArray();
          }
          catch (Exception localException2)
          {
            try
            {
              for (;;)
              {
                if (localIOException.abZp.aavd > 0) {
                  w.this.UvO.UyU.UFs = localIOException.abZp.toByteArray();
                }
                g.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + w.this.UCM.abZn);
                w.this.UvO.p(w.this.UCM.abYW, w.this.UCM.abYX, w.this.UCM.abYY, w.this.UCM.abYZ, w.this.UCM.abZa);
                w.this.UvO.aqq(w.this.UCM.abZe);
                localObject2 = w.this.UvO;
                i = w.this.UCM.abYQ;
                int j = w.this.UCM.abYR;
                ((l)localObject2).UyU.UDA = i;
                ((l)localObject2).UyU.UDB = j;
                w.this.UvO.aqp(w.this.UCM.abZh);
                w.this.UvO.UyU.UFd = localIOException.abZi;
                if ((localIOException.abZk != null) && (localIOException.abZk.aaxD != null)) {
                  w.this.UvO.UyU.UDE = localIOException.abZk.aaxD.toByteArray();
                }
                if ((localIOException.abZc != null) && (localIOException.abZc.aaxD != null) && (localIOException.abZd != null) && (localIOException.abZd.aaxD != null)) {
                  w.this.UvO.c(localIOException.abZb, localIOException.abZc.aaxD.toByteArray(), localIOException.abZd.aaxD.toByteArray());
                }
                localObject2 = w.this.UvO;
                del localdel = w.this.UCM.abZj;
                localObject2 = ((l)localObject2).UyU;
                g.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + localdel.aaJW + " Bitrate: " + localdel.aaJX);
                ((v2protocal)localObject2).field_jbmParamArraySize = 27;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray = new int[((v2protocal)localObject2).field_jbmParamArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[0] = localdel.aaJV;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[1] = localdel.aaJW;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[2] = localdel.aaJX;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[3] = localdel.aaJY;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[4] = localdel.aaJZ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[5] = localdel.aaKa;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[6] = localdel.aaKb;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[7] = localdel.aaKe;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[8] = localdel.aaKf;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[9] = localdel.aaKi;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[10] = localdel.aaKj;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[11] = localdel.aaKm;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[12] = localdel.aaKn;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[13] = localdel.aaKq;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[14] = localdel.aaKr;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[15] = localdel.aaKu;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[16] = localdel.aaKv;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[17] = localdel.aaKy;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[18] = localdel.aaKz;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[19] = localdel.aaKC;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[20] = localdel.aaKD;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[21] = localdel.aaKG;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[22] = localdel.aaKH;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[23] = localdel.aaKK;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[24] = localdel.aaKL;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[25] = localdel.aaKO;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[26] = localdel.aaKP;
                ((v2protocal)localObject2).field_jbmParamDoubleArraySize = 20;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray = new double[((v2protocal)localObject2).field_jbmParamDoubleArraySize];
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[0] = localdel.aaKc;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[1] = localdel.aaKd;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[2] = localdel.aaKg;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[3] = localdel.aaKh;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[4] = localdel.aaKk;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[5] = localdel.aaKl;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[6] = localdel.aaKo;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[7] = localdel.aaKp;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[8] = localdel.aaKs;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[9] = localdel.aaKt;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[10] = localdel.aaKw;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[11] = localdel.aaKx;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[12] = localdel.aaKA;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[13] = localdel.aaKB;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[14] = localdel.aaKE;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[15] = localdel.aaKF;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[16] = localdel.aaKI;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[17] = localdel.aaKJ;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[18] = localdel.aaKM;
                ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[19] = localdel.aaKN;
                w.this.UvO.hWQ();
                g.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
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
  
  public final void a(gbs paramgbs, int paramInt)
  {
    AppMethodBeat.i(115207);
    g.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + paramgbs.vhk);
    if (paramgbs.vhk == 1)
    {
      this.UvO.Uyt = true;
      if (1 == paramInt) {
        this.UvO.UyU.UFN.hXc();
      }
      if (3 == paramInt) {
        this.UvO.UyU.UFN.hXd();
      }
      g.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: ".concat(String.valueOf(paramInt)));
      this.UvO.UyV.fwj();
      SubCoreVoip.hVp().UBE.hYQ();
      this.UvO.Uyu = true;
      if (this.UvO.Uyw == true)
      {
        this.UvO.Uyw = false;
        if (this.UvO.Uys != true) {
          break label249;
        }
        g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115198);
            w.this.UvO.hWG();
            AppMethodBeat.o(115198);
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(11519, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(2) });
        this.UvO.hWQ();
        this.UvO.hWS();
        AppMethodBeat.o(115207);
        return;
        label249:
        if (this.UvO.Uyv == true)
        {
          g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
          this.UvO.S(1, -9000, "");
        }
        else
        {
          g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
        }
      }
    }
    if (paramgbs.vhk == 6)
    {
      g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
      g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
      this.UvO.Uyw = true;
      this.UvO.UyU.UEA = 1;
      this.UvO.hWQ();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramgbs.vhk == 8)
    {
      g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
      this.UvO.UyU.UFN.UAi = 211;
      this.UvO.UyU.UFN.UAh = 11;
      this.UvO.UyU.UFN.UAt = 12;
      com.tencent.mm.plugin.report.service.h.OAn.b(11519, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(3) });
      this.UvO.S(1, 211, "");
      this.UvO.hWS();
      AppMethodBeat.o(115207);
      return;
    }
    if (paramgbs.vhk == 2)
    {
      g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
      this.UvO.UyU.UFN.UAh = 103;
      this.UvO.UyU.UFN.UAt = 4;
      this.UvO.UyU.UFN.UAA = ((int)(System.currentTimeMillis() - this.UvO.UyU.UFN.beginTime));
      com.tencent.mm.plugin.report.service.h.OAn.b(11519, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(1) });
      this.UvO.hWS();
      this.UvO.S(4, 0, "");
      AppMethodBeat.o(115207);
      return;
    }
    if (paramgbs.vhk == 3)
    {
      this.UvO.UyU.UFN.UAt = 5;
      AppMethodBeat.o(115207);
      return;
    }
    if (paramgbs.vhk == 4)
    {
      g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
      if (this.UvO.mStatus < 6) {
        this.UvO.UyU.UFN.UAu = 1;
      }
      this.UvO.UyU.UFN.UAh = 110;
      this.UvO.S(6, 0, "");
      this.UvO.hWS();
      AppMethodBeat.o(115207);
      return;
    }
    g.Logi("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + paramgbs.vhk);
    AppMethodBeat.o(115207);
  }
  
  public final void aqC(int paramInt)
  {
    AppMethodBeat.i(115202);
    Object localObject2 = g.int2bytes(paramInt);
    Object localObject1 = new gol();
    ((gol)localObject1).df((byte[])localObject2);
    localObject2 = new gol();
    try
    {
      ((gol)localObject2).df(((gol)localObject1).toByteArray());
      localObject1 = new gaj();
      ((gaj)localObject1).Zmc = 3;
      ((gaj)localObject1).Zmd = ((gol)localObject2);
      ((gaj)localObject1).IMh = z.bAM();
      localObject2 = new gak();
      ((gak)localObject2).vgN = 1;
      ((gak)localObject2).vgO.add(localObject1);
      a((gak)localObject2, false, 4);
      AppMethodBeat.o(115202);
      return;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
      AppMethodBeat.o(115202);
    }
  }
  
  public final void b(gbh paramgbh)
  {
    AppMethodBeat.i(115210);
    this.UvO.cE(paramgbh.YLa.aaxD.toByteArray());
    AppMethodBeat.o(115210);
  }
  
  public final void c(gol paramgol)
  {
    AppMethodBeat.i(115211);
    int i = g.cI(paramgol.aaxD.toByteArray());
    g.Logi("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = ".concat(String.valueOf(i)));
    this.UvO.aqg(i & 0xFF);
    AppMethodBeat.o(115211);
  }
  
  public final void hYS()
  {
    AppMethodBeat.i(115205);
    if (this.UCN == null)
    {
      AppMethodBeat.o(115205);
      return;
    }
    this.UCN.vgO.clear();
    this.UCN.vgN = 0;
    this.UCN = null;
    this.UCO = 0;
    AppMethodBeat.o(115205);
  }
  
  public final void p(p paramp)
  {
    AppMethodBeat.i(115212);
    Log.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
    this.UvO.Uza = false;
    Object localObject1 = (gbu)((m)paramp).hYX();
    if (this.UvO.UyY == null)
    {
      AppMethodBeat.o(115212);
      return;
    }
    this.UvO.UyU.parseSyncKeyBuff(this.UvO.UyY, this.UvO.UyY.length);
    int j = this.UvO.UyU.field_statusSyncKey;
    int k = this.UvO.UyU.field_relayDataSyncKey;
    int m = this.UvO.UyU.field_connectingStatusKey;
    this.UvO.UyU.parseSyncKeyBuff(((gbu)localObject1).ZdD.aaxD.toByteArray(), ((gbu)localObject1).ZdD.abwJ);
    int n = this.UvO.UyU.field_statusSyncKey;
    int i1 = this.UvO.UyU.field_relayDataSyncKey;
    int i2 = this.UvO.UyU.field_connectingStatusKey;
    Log.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + j + " oldRelayDataSyncKey:" + k + " oldConnectingStatusSyncKey:" + m);
    Log.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + n + " newRelayDataSyncKey:" + i1 + " newConnectingStatusSyncKey:" + i2);
    this.UvO.UyY = ((gbu)localObject1).ZdD.aaxD.toByteArray();
    Log.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + ((gbu)localObject1).YYp);
    localObject1 = ((gbu)localObject1).acaf.vgO;
    if ((localObject1 != null) && (((LinkedList)localObject1).size() != 0))
    {
      Log.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + ((LinkedList)localObject1).size());
      int i = ((m)paramp).hYV();
      Log.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + ((LinkedList)localObject1).size() + ",selector = " + i);
      i = 0;
      if (i < ((LinkedList)localObject1).size())
      {
        paramp = (gaj)((LinkedList)localObject1).get(i);
        int i3 = paramp.Zmc;
        Log.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:".concat(String.valueOf(i3)));
        if (i3 == 1) {
          if (n > j)
          {
            if (this.UvO.UyU.roomId != 0) {
              break label487;
            }
            g.Loge("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
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
            localObject2 = (gbs)new gbs().parseFrom(paramp.Zmd.aaxD.toByteArray());
            g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + paramp.IMh + ",itemStatus =  " + ((gbs)localObject2).vhk);
            a((gbs)localObject2, 3);
          }
          catch (IOException paramp)
          {
            Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramp, "", new Object[0]);
          }
          continue;
          if (i3 == 2)
          {
            if (i1 > k) {
              if (this.UvO.UyU.roomId == 0)
              {
                g.Loge("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
              }
              else
              {
                try
                {
                  localObject2 = (gbh)new gbh().parseFrom(paramp.Zmd.aaxD.toByteArray());
                  g.Logi("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + ((gbh)localObject2).vhJ + ",from user = " + paramp.IMh);
                  if (((gbh)localObject2).vhJ != 5) {
                    break label712;
                  }
                  a((gbh)localObject2);
                }
                catch (IOException paramp)
                {
                  Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramp, "", new Object[0]);
                }
                continue;
                label712:
                if (((gbh)localObject2).vhJ == 3)
                {
                  this.UvO.cD(((gbh)localObject2).YLa.aaxD.toByteArray());
                  if ((((gbh)localObject2).YLa != null) && (((gbh)localObject2).YLa.aaxD != null)) {
                    this.UCM.abWQ = ((gbh)localObject2);
                  }
                }
                else if (((gbh)localObject2).vhJ == 2)
                {
                  this.UvO.cC(((gbh)localObject2).YLa.aaxD.toByteArray());
                  if ((((gbh)localObject2).YLa != null) && (((gbh)localObject2).YLa.aaxD != null)) {
                    this.UCM.abWP = ((gbh)localObject2);
                  }
                }
                else if (((gbh)localObject2).vhJ == 1)
                {
                  b((gbh)localObject2);
                }
                else if (((gbh)localObject2).vhJ == 6)
                {
                  paramp = ((gbh)localObject2).YLa.aaxD.toByteArray();
                  try
                  {
                    paramp = (gba)new gba().parseFrom(paramp);
                    if (paramp == null) {
                      continue;
                    }
                    this.UvO.UyX.a(paramp);
                  }
                  catch (IOException paramp)
                  {
                    for (;;)
                    {
                      Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramp, "", new Object[0]);
                      paramp = null;
                    }
                  }
                }
              }
            }
          }
          else if ((i3 == 3) && (i2 > m)) {
            if (this.UvO.UyU.roomId == 0)
            {
              Log.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
            }
            else
            {
              try
              {
                localObject2 = new gol().dg(paramp.Zmd.aaxD.toByteArray());
                if (!paramp.IMh.equals(z.bAM())) {
                  break label1018;
                }
                g.Loge("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
              }
              catch (IOException paramp)
              {
                Log.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", paramp, "", new Object[0]);
              }
              continue;
              label1018:
              c((gol)localObject2);
            }
          }
        }
      }
    }
    Log.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
    if (((this.UCN != null) && (this.UCN.vgN > 0)) || (this.UCO > 0)) {
      a(null, false, 7);
    }
    AppMethodBeat.o(115212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.w
 * JD-Core Version:    0.7.0.1
 */