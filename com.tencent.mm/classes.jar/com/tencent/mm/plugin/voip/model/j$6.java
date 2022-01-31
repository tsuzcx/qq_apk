package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.a.a;

final class j$6
  implements Runnable
{
  j$6(j paramj) {}
  
  public final void run()
  {
    if ((j.c(this.pQy) != 2) && (j.c(this.pQy) != 3) && (j.c(this.pQy) != 4))
    {
      a.Logi("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + j.c(this.pQy));
      return;
    }
    if (this.pQy.pPA)
    {
      a.Logi("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
      return;
    }
    a.Logi("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
    int k = (this.pQy.pQe.pVp >> 2 & 0x3) >> 1 & 0x1 & (this.pQy.pQe.pVp & 0x3) >> 1 & 0x1;
    v2protocal localv2protocal = this.pQy.pQe;
    int m = this.pQy.pQe.pUz;
    long l1 = this.pQy.pQe.lpD;
    int n = this.pQy.pQe.lpL;
    long l2 = this.pQy.pQe.lpE;
    byte[] arrayOfByte1 = this.pQy.pQe.pUB;
    int i1 = this.pQy.pQe.channelStrategy;
    int i2 = this.pQy.pQe.pUG;
    int i3 = this.pQy.pQe.pUH;
    int i4 = this.pQy.pQe.pUE;
    int i;
    byte[] arrayOfByte2;
    int i5;
    int i6;
    int i7;
    byte[] arrayOfByte3;
    int i8;
    int i9;
    if (this.pQy.pQe.pUF == null)
    {
      i = 0;
      arrayOfByte2 = this.pQy.pQe.pUF;
      i5 = this.pQy.pQe.pUI;
      i6 = this.pQy.pQe.pUy;
      i7 = this.pQy.pQe.pVz;
      arrayOfByte3 = this.pQy.pQe.pVA;
      i8 = this.pQy.pQe.pVB;
      i9 = this.pQy.pQe.pUJ;
      if (this.pQy.pQe.pUK != null) {
        break label548;
      }
    }
    label548:
    for (int j = 0;; j = this.pQy.pQe.pUK.length)
    {
      j = localv2protocal.setConfigInfo(m, l1, n, l2, arrayOfByte1, i1, i2, i3, i4, i, arrayOfByte2, i5, k, i6, i7, arrayOfByte3, i8, i9, j, this.pQy.pQe.pUK);
      i = j;
      if (j == 0) {
        i = this.pQy.pQe.connectToPeerRelay();
      }
      a.Logi("MicroMsg.Voip.VoipContext", "zhengxue[Logic], mARQFlag: " + k + ",  NetType: " + this.pQy.pQe.pUy + ", EncryptStrategy: " + this.pQy.pQe.pVz);
      if (i >= 0) {
        break label563;
      }
      a.Loge("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:" + i);
      this.pQy.pQe.pWi.pQU = 14;
      this.pQy.s(1, -9002, "");
      return;
      i = this.pQy.pQe.pUF.length;
      break;
    }
    label563:
    this.pQy.pPA = true;
    this.pQy.pQe.pWi.pRb = 1;
    this.pQy.pQe.pWi.pRj = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.j.6
 * JD-Core Version:    0.7.0.1
 */