package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ayd;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.LinkedList;

final class v$1
  implements Runnable
{
  v$1(v paramv, cta paramcta) {}
  
  public final void run()
  {
    AppMethodBeat.i(4681);
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData begin");
    Object localObject1 = this.tzD.wtq.getBuffer().toByteArray();
    for (;;)
    {
      try
      {
        localObject1 = (csu)new csu().parseFrom((byte[])localObject1);
        if ((((csu)localObject1).xZX != null) && (((csu)localObject1).xZX.wtq != null) && (((csu)localObject1).xZX.wtq.getBuffer() != null)) {
          this.tzE.tzA.xZX = ((csu)localObject1).xZX;
        }
        if ((((csu)localObject1).xZY.wtq != null) && (((csu)localObject1).xZY.wtq.getBuffer() != null)) {
          this.tzE.tzA.xZY = ((csu)localObject1).xZY;
        }
        if (((csu)localObject1).ybo != 0) {
          this.tzE.tzA.ybo = ((csu)localObject1).ybo;
        }
        if ((((csu)localObject1).ybp != null) && (((csu)localObject1).ybp.yak != 0)) {
          this.tzE.tzA.ybp = ((csu)localObject1).ybp;
        }
        if ((((csu)localObject1).ybq != null) && (((csu)localObject1).ybq.yak != 0)) {
          this.tzE.tzA.ybq = ((csu)localObject1).ybq;
        }
        if ((((csu)localObject1).ybQ != null) && (((csu)localObject1).ybQ.size() != 0))
        {
          this.tzE.tzA.ybQ = ((csu)localObject1).ybQ;
          this.tzE.tzA.ybP = ((csu)localObject1).ybQ.size();
        }
        if (((csu)localObject1).ybs != 0) {
          this.tzE.tzA.ybs = ((csu)localObject1).ybs;
        }
        if (((csu)localObject1).ybt != 0) {
          this.tzE.tzA.ybt = ((csu)localObject1).ybt;
        }
        if (((csu)localObject1).ybx.yak != 0) {
          this.tzE.tzA.ybx = ((csu)localObject1).ybx;
        }
        if (((csu)localObject1).yby > 0)
        {
          this.tzE.tzA.yby = ((csu)localObject1).yby;
          if (((csu)localObject1).nNv <= 0) {
            break label910;
          }
          this.tzE.tzA.nNv = (((csu)localObject1).nNv - 1);
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[ENCRYPT] got encryptStrategy[" + this.tzE.tzA.nNv + "] from relaydata");
          if (((csu)localObject1).ybz <= 0) {
            break label931;
          }
          this.tzE.tzA.ybz = ((csu)localObject1).ybz;
          this.tzE.tzA.ybA = ((csu)localObject1).ybA;
          this.tzE.tzA.ybB = ((csu)localObject1).ybB;
          this.tzE.tzA.ybC = ((csu)localObject1).ybC;
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got ARQCacheLen: " + ((csu)localObject1).ybz + ", ARQRttThreshold: " + ((csu)localObject1).ybA + ", ARQUsedRateThreshold: " + ((csu)localObject1).ybB + ", ARQRespRateThreshold: " + ((csu)localObject1).ybC);
          if (((csu)localObject1).ybG <= 0) {
            break label941;
          }
          this.tzE.tzA.ybG = ((csu)localObject1).ybG;
          this.tzE.tzA.ybJ = ((csu)localObject1).ybJ;
          if (((csu)localObject1).ybL != null) {
            this.tzE.tzA.ybL = ((csu)localObject1).ybL;
          }
          this.tzE.tzA.ybO = ((csu)localObject1).ybO;
          this.tzE.tzA.ybN = ((csu)localObject1).ybN;
          this.tzE.ttm.tvv.a(((csu)localObject1).ybO, ((csu)localObject1).ybN, this.tzE.ttm.tvj.nMZ, this.tzE.ttm.tvj.nNa);
          if ((this.tzE.tzA.xZX == null) || (this.tzE.tzA.xZX.wtq == null) || (this.tzE.tzA.xZX.wtq.getBuffer() == null) || (this.tzE.tzA.ybo == 0) || (this.tzE.tzA.xZY == null) || (this.tzE.tzA.xZY.wtq == null) || (this.tzE.tzA.xZY.wtq.getBuffer() == null) || (this.tzE.tzA.ybp == null) || (this.tzE.tzA.ybp.yak == 0) || (this.tzE.tzA.ybq == null) || (this.tzE.tzA.ybq.yak == 0) || (this.tzE.tzA.ybx == null) || (this.tzE.tzA.ybx.yak == 0)) {
            break label962;
          }
          i = 1;
          if (i != 0) {
            break;
          }
          a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
          AppMethodBeat.o(4681);
          return;
        }
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", localIOException, "", new Object[0]);
        AppMethodBeat.o(4681);
        return;
      }
      this.tzE.tzA.yby = 0;
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQstrategy in mrdata");
      continue;
      label910:
      this.tzE.tzA.nNv = 1;
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no EncryptStrategy in mrdata");
      continue;
      label931:
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no ARQKeyParameters in mrdata");
      continue;
      label941:
      this.tzE.tzA.ybG = 0;
      a.Logi("MicroMsg.Voip.VoipSyncHandle", "zhengxue[LOGIC]:got no QosStrategy in mrdata");
      continue;
      label962:
      i = 0;
    }
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "multiRelayData recv all, update. RedirectReqThreshold = " + this.tzE.tzA.ybJ + " BothSideSwitchFlag = " + localIOException.ybK);
    this.tzE.ttm.Hp(this.tzE.tzA.ybo);
    this.tzE.ttm.br(this.tzE.tzA.xZX.wtq.getBuffer().toByteArray());
    if ((localIOException.ybv != null) && (localIOException.ybv.getBuffer() != null) && (localIOException.ybH != null) && (localIOException.ybH.getBuffer() != null)) {
      this.tzE.ttm.a(localIOException.ybv.getBuffer().toByteArray(), localIOException.ybu, this.tzE.tzA.nNv, localIOException.ybH.getBuffer().toByteArray());
    }
    if (com.tencent.mm.plugin.voip.b.cLC().cNU() != 0) {
      this.tzE.ttm.bs(this.tzE.tzA.xZY.wtq.getBuffer().toByteArray());
    }
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "onMultiRelayData natsvr =" + this.tzE.tzA.ybP);
    this.tzE.ttm.a(this.tzE.tzA.ybp, this.tzE.tzA.ybq, this.tzE.tzA.ybx, this.tzE.tzA.ybQ);
    this.tzE.ttm.i(this.tzE.tzA.yby, this.tzE.tzA.ybz, this.tzE.tzA.ybA, this.tzE.tzA.ybB, this.tzE.tzA.ybC);
    this.tzE.ttm.Ho(this.tzE.tzA.ybG);
    Object localObject2 = this.tzE.ttm;
    int i = this.tzE.tzA.ybs;
    int j = this.tzE.tzA.ybt;
    ((k)localObject2).tvj.tAh = i;
    ((k)localObject2).tvj.tAi = j;
    this.tzE.ttm.Hn(this.tzE.tzA.ybJ);
    this.tzE.ttm.tvj.tBh = localIOException.ybK;
    if ((localIOException.ybM != null) && (localIOException.ybM.getBuffer() != null)) {
      this.tzE.ttm.tvj.tAl = localIOException.ybM.getBuffer().toByteArray();
    }
    if ((localIOException.ybE != null) && (localIOException.ybE.getBuffer() != null) && (localIOException.ybF != null) && (localIOException.ybF.getBuffer() != null)) {
      this.tzE.ttm.c(localIOException.ybD, localIOException.ybE.getBuffer().toByteArray(), localIOException.ybF.getBuffer().toByteArray());
    }
    localObject2 = this.tzE.ttm;
    ayd localayd = this.tzE.tzA.ybL;
    localObject2 = ((k)localObject2).tvj;
    a.Logd("MicroMsg.Voip", "v2protocal updateJbmBitrateRsSvrParam BitrateFlag : " + localayd.xnk + " Bitrate: " + localayd.xnl);
    ((v2protocal)localObject2).field_jbmParamArraySize = 27;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray = new int[((v2protocal)localObject2).field_jbmParamArraySize];
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[0] = localayd.xnj;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[1] = localayd.xnk;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[2] = localayd.xnl;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[3] = localayd.xnm;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[4] = localayd.xnn;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[5] = localayd.xno;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[6] = localayd.xnp;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[7] = localayd.xns;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[8] = localayd.xnt;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[9] = localayd.xnw;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[10] = localayd.xnx;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[11] = localayd.xnA;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[12] = localayd.xnB;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[13] = localayd.xnE;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[14] = localayd.xnF;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[15] = localayd.xnI;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[16] = localayd.xnJ;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[17] = localayd.xnM;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[18] = localayd.xnN;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[19] = localayd.xnQ;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[20] = localayd.xnR;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[21] = localayd.xnU;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[22] = localayd.xnV;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[23] = localayd.xnY;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[24] = localayd.xnZ;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[25] = localayd.xoc;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamArray[26] = localayd.xod;
    ((v2protocal)localObject2).field_jbmParamDoubleArraySize = 20;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray = new double[((v2protocal)localObject2).field_jbmParamDoubleArraySize];
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[0] = localayd.xnq;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[1] = localayd.xnr;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[2] = localayd.xnu;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[3] = localayd.xnv;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[4] = localayd.xny;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[5] = localayd.xnz;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[6] = localayd.xnC;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[7] = localayd.xnD;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[8] = localayd.xnG;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[9] = localayd.xnH;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[10] = localayd.xnK;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[11] = localayd.xnL;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[12] = localayd.xnO;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[13] = localayd.xnP;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[14] = localayd.xnS;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[15] = localayd.xnT;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[16] = localayd.xnW;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[17] = localayd.xnX;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[18] = localayd.xoa;
    ((v2protocal)localObject2).field_jbmBitratRsSvrParamDoubleArray[19] = localayd.xob;
    this.tzE.ttm.cMk();
    a.Logi("MicroMsg.Voip.VoipSyncHandle", "__onMultiRelayData end");
    AppMethodBeat.o(4681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.v.1
 * JD-Core Version:    0.7.0.1
 */