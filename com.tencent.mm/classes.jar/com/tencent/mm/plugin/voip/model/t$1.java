package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.cfj;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.LinkedList;

final class t$1
  implements Runnable
{
  t$1(t paramt, cfp paramcfp) {}
  
  public final void run()
  {
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
    Object localObject1 = this.pUb.szp.tFM.toByteArray();
    for (;;)
    {
      try
      {
        localObject1 = (cfj)new cfj().aH((byte[])localObject1);
        if ((((cfj)localObject1).tSF != null) && (((cfj)localObject1).tSF.szp != null) && (((cfj)localObject1).tSF.szp.tFM != null)) {
          this.pUc.pTY.tSF = ((cfj)localObject1).tSF;
        }
        if ((((cfj)localObject1).tSG.szp != null) && (((cfj)localObject1).tSG.szp.tFM != null)) {
          this.pUc.pTY.tSG = ((cfj)localObject1).tSG;
        }
        if (((cfj)localObject1).tTX != 0) {
          this.pUc.pTY.tTX = ((cfj)localObject1).tTX;
        }
        if ((((cfj)localObject1).tTY != null) && (((cfj)localObject1).tTY.tSS != 0)) {
          this.pUc.pTY.tTY = ((cfj)localObject1).tTY;
        }
        if ((((cfj)localObject1).tTZ != null) && (((cfj)localObject1).tTZ.tSS != 0)) {
          this.pUc.pTY.tTZ = ((cfj)localObject1).tTZ;
        }
        if ((((cfj)localObject1).tUz != null) && (((cfj)localObject1).tUz.size() != 0))
        {
          this.pUc.pTY.tUz = ((cfj)localObject1).tUz;
          this.pUc.pTY.tUy = ((cfj)localObject1).tUz.size();
        }
        if (((cfj)localObject1).tUb != 0) {
          this.pUc.pTY.tUb = ((cfj)localObject1).tUb;
        }
        if (((cfj)localObject1).tUc != 0) {
          this.pUc.pTY.tUc = ((cfj)localObject1).tUc;
        }
        if (((cfj)localObject1).tUg.tSS != 0) {
          this.pUc.pTY.tUg = ((cfj)localObject1).tUg;
        }
        if (((cfj)localObject1).tUh > 0)
        {
          this.pUc.pTY.tUh = ((cfj)localObject1).tUh;
          if (((cfj)localObject1).lpZ <= 0) {
            break label892;
          }
          this.pUc.pTY.lpZ = (((cfj)localObject1).lpZ - 1);
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + this.pUc.pTY.lpZ + "] from relaydata");
          if (((cfj)localObject1).tUi <= 0) {
            break label913;
          }
          this.pUc.pTY.tUi = ((cfj)localObject1).tUi;
          this.pUc.pTY.tUj = ((cfj)localObject1).tUj;
          this.pUc.pTY.tUk = ((cfj)localObject1).tUk;
          this.pUc.pTY.tUl = ((cfj)localObject1).tUl;
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + ((cfj)localObject1).tUi + ", ARQRttThreshold: " + ((cfj)localObject1).tUj + ", ARQUsedRateThreshold: " + ((cfj)localObject1).tUk + ", ARQRespRateThreshold: " + ((cfj)localObject1).tUl);
          if (((cfj)localObject1).tUp <= 0) {
            break label923;
          }
          this.pUc.pTY.tUp = ((cfj)localObject1).tUp;
          this.pUc.pTY.tUs = ((cfj)localObject1).tUs;
          if (((cfj)localObject1).tUu != null) {
            this.pUc.pTY.tUu = ((cfj)localObject1).tUu;
          }
          this.pUc.pTY.tUx = ((cfj)localObject1).tUx;
          this.pUc.pTY.tUw = ((cfj)localObject1).tUw;
          this.pUc.pNq.pQq.a(((cfj)localObject1).tUx, ((cfj)localObject1).tUw, this.pUc.pNq.pQe.lpD, this.pUc.pNq.pQe.lpE);
          if ((this.pUc.pTY.tSF == null) || (this.pUc.pTY.tSF.szp == null) || (this.pUc.pTY.tSF.szp.tFM == null) || (this.pUc.pTY.tTX == 0) || (this.pUc.pTY.tSG == null) || (this.pUc.pTY.tSG.szp == null) || (this.pUc.pTY.tSG.szp.tFM == null) || (this.pUc.pTY.tTY == null) || (this.pUc.pTY.tTY.tSS == 0) || (this.pUc.pTY.tTZ == null) || (this.pUc.pTY.tTZ.tSS == 0) || (this.pUc.pTY.tUg == null) || (this.pUc.pTY.tUg.tSS == 0)) {
            break label944;
          }
          i = 1;
          if (i != 0) {
            break;
          }
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
          return;
        }
      }
      catch (IOException localIOException)
      {
        y.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
        return;
      }
      this.pUc.pTY.tUh = 0;
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
      continue;
      label892:
      this.pUc.pTY.lpZ = 1;
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
      continue;
      label913:
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
      continue;
      label923:
      this.pUc.pTY.tUp = 0;
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
      continue;
      label944:
      i = 0;
    }
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + this.pUc.pTY.tUs + " BothSideSwitchFlag = " + localIOException.tUt);
    this.pUc.pNq.Ac(this.pUc.pTY.tTX);
    this.pUc.pNq.aR(this.pUc.pTY.tSF.szp.tFM.toByteArray());
    if ((localIOException.tUe != null) && (localIOException.tUe.tFM != null) && (localIOException.tUq != null) && (localIOException.tUq.tFM != null)) {
      this.pUc.pNq.a(localIOException.tUe.tFM.toByteArray(), localIOException.tUd, this.pUc.pTY.lpZ, localIOException.tUq.tFM.toByteArray());
    }
    if (com.tencent.mm.plugin.voip.b.bPx().bRd() != 0) {
      this.pUc.pNq.aS(this.pUc.pTY.tSG.szp.tFM.toByteArray());
    }
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + this.pUc.pTY.tUy);
    this.pUc.pNq.a(this.pUc.pTY.tTY, this.pUc.pTY.tTZ, this.pUc.pTY.tUg, this.pUc.pTY.tUz);
    this.pUc.pNq.h(this.pUc.pTY.tUh, this.pUc.pTY.tUi, this.pUc.pTY.tUj, this.pUc.pTY.tUk, this.pUc.pTY.tUl);
    this.pUc.pNq.Ab(this.pUc.pTY.tUp);
    Object localObject2 = this.pUc.pNq;
    int i = this.pUc.pTY.tUb;
    int j = this.pUc.pTY.tUc;
    ((j)localObject2).pQe.pUG = i;
    ((j)localObject2).pQe.pUH = j;
    this.pUc.pNq.Aa(this.pUc.pTY.tUs);
    this.pUc.pNq.pQe.pVC = localIOException.tUt;
    if ((localIOException.tUv != null) && (localIOException.tUv.tFM != null)) {
      this.pUc.pNq.pQe.pUK = localIOException.tUv.tFM.toByteArray();
    }
    if ((localIOException.tUn != null) && (localIOException.tUn.tFM != null) && (localIOException.tUo != null) && (localIOException.tUo.tFM != null)) {
      this.pUc.pNq.b(localIOException.tUm, localIOException.tUn.tFM.toByteArray(), localIOException.tUo.tFM.toByteArray());
    }
    localObject2 = this.pUc.pNq;
    asc localasc = this.pUc.pTY.tUu;
    localObject2 = ((j)localObject2).pQe;
    a.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + localasc.tnp + " Bitrate: " + localasc.tnq);
    ((v2protocal)localObject2).field_jbmParamArraySize = 27;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray = new int[((v2protocal)localObject2).field_jbmParamArraySize];
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[0] = localasc.tno;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[1] = localasc.tnp;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[2] = localasc.tnq;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[3] = localasc.tnr;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[4] = localasc.tns;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[5] = localasc.tnt;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[6] = localasc.tnu;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[7] = localasc.tnx;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[8] = localasc.tny;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[9] = localasc.tnB;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[10] = localasc.tnC;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[11] = localasc.tnF;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[12] = localasc.tnG;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[13] = localasc.tnJ;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[14] = localasc.tnK;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[15] = localasc.tnN;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[16] = localasc.tnO;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[17] = localasc.tnR;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[18] = localasc.tnS;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[19] = localasc.tnV;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[20] = localasc.tnW;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[21] = localasc.tnZ;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[22] = localasc.toa;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[23] = localasc.tod;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[24] = localasc.toe;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[25] = localasc.toh;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[26] = localasc.toi;
    ((v2protocal)localObject2).field_jbmParamDoubleArraySize = 20;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray = new double[((v2protocal)localObject2).field_jbmParamDoubleArraySize];
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[0] = localasc.tnv;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[1] = localasc.tnw;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[2] = localasc.tnz;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[3] = localasc.tnA;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[4] = localasc.tnD;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[5] = localasc.tnE;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[6] = localasc.tnH;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[7] = localasc.tnI;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[8] = localasc.tnL;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[9] = localasc.tnM;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[10] = localasc.tnP;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[11] = localasc.tnQ;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[12] = localasc.tnT;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[13] = localasc.tnU;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[14] = localasc.tnX;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[15] = localasc.tnY;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[16] = localasc.tob;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[17] = localasc.toc;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[18] = localasc.tof;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[19] = localasc.tog;
    this.pUc.pNq.bQg();
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.t.1
 * JD-Core Version:    0.7.0.1
 */