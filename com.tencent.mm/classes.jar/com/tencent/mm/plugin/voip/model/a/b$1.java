package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.model.w;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crp;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.cta;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class b$1
  implements f
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(4698);
    a.Logi(this.tzJ.TAG, "Anwser response:" + paramInt1 + " errCode:" + paramInt2 + " status:" + this.tzJ.tvE.mStatus);
    if (this.tzJ.tvE.mStatus == 1)
    {
      a.Logi(this.tzJ.TAG, "reject ok!");
      AppMethodBeat.o(4698);
      return;
    }
    if (this.tzJ.tvE.mStatus != 4)
    {
      a.Loge(this.tzJ.TAG, "Anwser response not within WAITCONNECT, ignored.");
      AppMethodBeat.o(4698);
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 == 4)
      {
        this.tzJ.tvE.tvj.tBN.twb = 12;
        this.tzJ.tvE.tvj.tBN.twc = paramInt2;
        this.tzJ.tvE.y(1, paramInt2, "");
        AppMethodBeat.o(4698);
        return;
      }
      this.tzJ.tvE.tvj.tBN.twb = 12;
      this.tzJ.tvE.tvj.tBN.twc = paramInt2;
      this.tzJ.tvE.y(1, -9004, "");
      AppMethodBeat.o(4698);
      return;
    }
    paramString = (crp)this.tzJ.cOt();
    this.tzJ.tvE.tvj.nMZ = paramString.wQP;
    this.tzJ.tvE.tvj.nNa = paramString.wQQ;
    this.tzJ.tvE.tvj.nNh = paramString.yad;
    this.tzJ.tvE.tvj.tAH = paramString.yaq;
    this.tzJ.tvE.tvj.tAI = paramString.yar;
    this.tzJ.tvE.tvj.tAJ = paramString.yas;
    this.tzJ.tvE.tvj.tAK = paramString.yat;
    this.tzJ.tvE.tvj.tAM = paramString.yav;
    this.tzJ.tvE.tvj.tAL = paramString.yaB;
    this.tzJ.tvE.tvj.tAk = paramString.yah;
    this.tzJ.tvE.tvj.tAO = paramString.yaD;
    this.tzJ.tvE.Hq(paramString.yaf);
    this.tzJ.tvE.tvj.tAn = paramString.yai;
    if ((paramString.yaj != null) && (paramString.yaj.getBuffer() != null)) {
      this.tzJ.tvE.tvj.tAm = paramString.yaj.getBuffer().toByteArray();
    }
    if (paramString.yaj.getILen() >= 12)
    {
      paramm = ByteBuffer.wrap(paramString.yaj.getBuffer().toByteArray(), 8, 4);
      ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
      ByteOrder localByteOrder2 = paramm.order();
      paramInt1 = paramm.getInt();
      a.Logd(this.tzJ.TAG, "steve:nSvrBaseBRTuneRatio1:" + paramInt1 + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
      this.tzJ.tvE.tvj.tAN = paramInt1;
    }
    a.Logi(this.tzJ.TAG, "onAnwserResp: audioTsdfBeyond3G = " + this.tzJ.tvE.tvj.tAH + ",audioTsdEdge = " + this.tzJ.tvE.tvj.tAI + ",passthroughQosAlgorithm = " + this.tzJ.tvE.tvj.tAJ + ",fastPlayRepair = " + this.tzJ.tvE.tvj.tAK + ", audioDtx = " + this.tzJ.tvE.tvj.tAM + ", switchtcppktCnt=" + this.tzJ.tvE.tvj.tAj + ", SvrCfgListV=" + this.tzJ.tvE.tvj.tAL + ", setMaxBRForRelay=" + this.tzJ.tvE.tvj.tAO + ", RedirectreqThreshold=" + paramString.yae.ybJ + ", BothSideSwitchFlag=" + paramString.yae.ybK + ", WifiScanInterval=" + paramString.yai + ", BaseBRTuneRatio=" + this.tzJ.tvE.tvj.tAN);
    this.tzJ.tvE.tvj.tAP = paramString.yaA;
    this.tzJ.tvE.tvj.tAQ = paramString.yaE;
    a.Logi(this.tzJ.TAG, "answerResp AudioAecMode5 = " + this.tzJ.tvE.tvj.tAP);
    boolean bool2 = v2protocal.cOJ();
    boolean bool1;
    int i;
    int j;
    int k;
    if (com.tencent.mm.plugin.voip.b.cLE() == 0)
    {
      bool1 = true;
      paramInt2 = ac.eru.eoy;
      i = ac.eru.eoz;
      paramInt1 = this.tzJ.tvE.tvj.tAk;
      j = (this.tzJ.tvE.tvj.tAk >> 11 & 0x1) << 3 | paramInt1 >> 4 & 0x7;
      k = 0;
      paramInt1 = k;
      if (bool2)
      {
        paramInt1 = k;
        if (bool1)
        {
          if ((i < 0) && (paramInt2 < 0)) {
            break label1533;
          }
          if (paramInt2 < 0) {
            break label1511;
          }
          paramInt1 = paramInt2;
        }
      }
      label1061:
      a.Logi(this.tzJ.TAG, "NetSceneAnswerResp set voipbeauty local=" + bool2 + ", server=" + j + ", blacklist=" + paramInt2 + ", whitelist=" + i + ",isLibInitOK=" + bool1 + ", UICallback" + this.tzJ.tvE.tvk + ", finalFlag=" + paramInt1);
      if (this.tzJ.tvE.tvk != null) {
        this.tzJ.tvE.tvk.setVoipBeauty(paramInt1);
      }
      this.tzJ.tvE.tvj.tBr = paramInt1;
      this.tzJ.tvE.tvj.tBs = j;
      this.tzJ.tvE.tuJ = true;
      a.Logi(this.tzJ.TAG, "answer ok, roomid =" + this.tzJ.tvE.tvj.nMZ + ",memberid = " + this.tzJ.tvE.tvj.nNh);
      paramString = paramString.yae;
      if (paramString.nNv <= 0) {
        break label1547;
      }
      paramString.nNv -= 1;
      a.Logi(this.tzJ.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramString.nNv + "] from answerresp relaydata");
    }
    for (;;)
    {
      a.Logi(this.tzJ.TAG, "answer with relayData peerid.length =" + paramString.xZX.wtq.getILen());
      a.Logi(this.tzJ.TAG, "answer with relayData capinfo.length =" + paramString.xZY.wtq.getILen());
      this.tzJ.tvE.Hp(paramString.ybo);
      this.tzJ.tvE.tvv.a(paramString.ybO, paramString.ybN, this.tzJ.tvE.tvj.nMZ, this.tzJ.tvE.tvj.nNa);
      try
      {
        g.RO().ac(new b.1.1(this, paramString));
        AppMethodBeat.o(4698);
        return;
      }
      catch (Exception paramString)
      {
        label1511:
        ab.e(this.tzJ.TAG, "get proxy ip fail..");
        AppMethodBeat.o(4698);
      }
      bool1 = false;
      break;
      paramInt1 = k;
      if (i < 0) {
        break label1061;
      }
      paramInt1 = k;
      if (j != 0) {
        break label1061;
      }
      paramInt1 = i;
      break label1061;
      label1533:
      paramInt1 = k;
      if (j <= 0) {
        break label1061;
      }
      paramInt1 = j;
      break label1061;
      label1547:
      paramString.nNv = 1;
      a.Logi(this.tzJ.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b.1
 * JD-Core Version:    0.7.0.1
 */