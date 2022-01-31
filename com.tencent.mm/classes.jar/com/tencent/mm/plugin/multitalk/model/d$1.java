package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bs;
import junit.framework.Assert;

final class d$1
  implements com.tencent.pb.talkroom.sdk.e
{
  d$1(d paramd) {}
  
  public final int Lo()
  {
    AppMethodBeat.i(53894);
    int i = m.Lo();
    AppMethodBeat.o(53894);
    return i;
  }
  
  public final int a(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    AppMethodBeat.i(53897);
    this.oTf.oTd = paramb;
    paramInt1 = this.oTf.oTb.a(this.oTf.oTe, paramInt1, paramInt2);
    ab.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.b.g.KC().KM()), Boolean.valueOf(p.bTF().oTm) });
    if ((com.tencent.mm.compatible.b.g.KC().KM() != p.bTF().oTm) && (p.bTF().nMJ.Dt())) {
      this.oTf.oTb.iE(p.bTF().oTm);
    }
    AppMethodBeat.o(53897);
    return paramInt1;
  }
  
  public final int a(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.c paramc)
  {
    AppMethodBeat.i(53898);
    this.oTf.oTc = paramc;
    this.oTf.kJB = new com.tencent.mm.audio.b.c(paramInt1, 1, 7);
    this.oTf.kJB.gA(paramInt2);
    this.oTf.kJB.bA(true);
    this.oTf.kJB.EB();
    this.oTf.kJB.cjs = -19;
    this.oTf.kJB.t(1, false);
    this.oTf.kJB.bz(true);
    this.oTf.kJB.cjD = this.oTf.cjU;
    if (this.oTf.kJB.EC())
    {
      AppMethodBeat.o(53898);
      return 1;
    }
    AppMethodBeat.o(53898);
    return -1;
  }
  
  public final boolean bSJ()
  {
    AppMethodBeat.i(53893);
    int i = m.Lo();
    ab.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:".concat(String.valueOf(i)));
    if ((i & 0x400) != 0) {
      com.tencent.mm.compatible.loader.d.B(ah.getContext(), "libvoipCodec_v7a.so");
    }
    for (;;)
    {
      AppMethodBeat.o(53893);
      return true;
      if ((i & 0x200) != 0)
      {
        com.tencent.mm.compatible.loader.d.B(ah.getContext(), "libvoipCodec.so");
        Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
      }
      else
      {
        com.tencent.mm.compatible.loader.d.B(ah.getContext(), "libvoipCodec_v5.so");
        Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
      }
    }
  }
  
  public final int bSK()
  {
    AppMethodBeat.i(53895);
    Object localObject = com.tencent.mm.kernel.g.RL().Rv().dyM();
    ac.ll((String)localObject);
    ab.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: ".concat(String.valueOf(localObject)));
    localObject = this.oTf;
    byte[] arrayOfByte1 = new byte[1];
    arrayOfByte1[0] = 0;
    byte[] arrayOfByte2 = new byte[2];
    byte[] arrayOfByte3;
    if (ac.erv.eno >= 0)
    {
      arrayOfByte2[0] = ((byte)ac.erv.eno);
      ((d)localObject).oTa.setAppCmd(406, arrayOfByte2, 1);
      if (ac.erv.enr < 0) {
        break label925;
      }
      arrayOfByte3 = new byte[5];
      if ((ac.erv.ens >= 0) && (ac.erv.ent >= 0))
      {
        arrayOfByte3[0] = ((byte)ac.erv.ens);
        arrayOfByte3[1] = ((byte)ac.erv.ent);
        if (ac.erv.enu < 0) {
          break label905;
        }
        arrayOfByte3[2] = ((byte)ac.erv.enu);
        arrayOfByte3[3] = ((byte)ac.erv.enr);
        arrayOfByte3[4] = ((byte)ac.erv.env);
        ((d)localObject).oTa.setAppCmd(404, arrayOfByte3, 5);
      }
      label207:
      if (ac.erv.enp < 0) {
        break label956;
      }
      arrayOfByte2[0] = ((byte)ac.erv.enp);
      ((d)localObject).oTa.setAppCmd(408, arrayOfByte2, 1);
    }
    for (;;)
    {
      if ((ac.erv.enA[0] > 0) || (ac.erv.enA[1] > 0))
      {
        arrayOfByte2[0] = 0;
        arrayOfByte2[1] = 0;
        if ((ac.erv.enA[0] > 0) && (ac.erv.enA[0] < 10000)) {
          arrayOfByte2[0] = ((byte)ac.erv.enA[0]);
        }
        if ((ac.erv.enA[1] > 0) && (ac.erv.enA[1] < 10000)) {
          arrayOfByte2[1] = ((byte)ac.erv.enA[1]);
        }
        ((d)localObject).oTa.setAppCmd(423, arrayOfByte2, 2);
      }
      if ((ac.erv.emQ >= 0) || (ac.erv.emS >= 0))
      {
        arrayOfByte2[0] = -1;
        arrayOfByte2[1] = -1;
        if (ac.erv.emQ >= 0) {
          arrayOfByte2[0] = ((byte)ac.erv.emQ);
        }
        if (ac.erv.emS >= 0) {
          arrayOfByte2[1] = ((byte)ac.erv.emS);
        }
        ((d)localObject).oTa.setAppCmd(414, arrayOfByte2, 2);
      }
      if ((ac.erv.emR >= 0) || (ac.erv.emT >= 0))
      {
        arrayOfByte2[0] = -1;
        arrayOfByte2[1] = -1;
        if (ac.erv.emR >= 0) {
          arrayOfByte2[0] = ((byte)ac.erv.emR);
        }
        if (ac.erv.emT >= 0) {
          arrayOfByte2[1] = ((byte)ac.erv.emT);
        }
        ((d)localObject).oTa.setAppCmd(415, arrayOfByte2, 2);
      }
      if ((ac.erv.emU >= 0) || (ac.erv.emV >= 0))
      {
        arrayOfByte2[0] = -1;
        arrayOfByte2[1] = -1;
        if (ac.erv.emU >= 0) {
          arrayOfByte2[0] = ((byte)ac.erv.emU);
        }
        if (ac.erv.emV >= 0) {
          arrayOfByte2[1] = ((byte)ac.erv.emV);
        }
        ((d)localObject).oTa.setAppCmd(422, arrayOfByte2, 2);
      }
      if (ac.erv.emW >= 0)
      {
        arrayOfByte2[0] = ((byte)ac.erv.emW);
        ((d)localObject).oTa.setAppCmd(416, arrayOfByte2, 1);
      }
      if ((ac.erv.emX >= 0) && (ac.erv.emX != 5))
      {
        arrayOfByte2[0] = ((byte)ac.erv.emX);
        ((d)localObject).oTa.setAppCmd(417, arrayOfByte2, 1);
      }
      if ((ac.erv.emY >= 0) && (ac.erv.emY != 5))
      {
        arrayOfByte2[0] = ((byte)ac.erv.emY);
        ((d)localObject).oTa.setAppCmd(418, arrayOfByte2, 1);
      }
      if (ac.erv.emZ >= 0)
      {
        arrayOfByte2[0] = ((byte)ac.erv.emZ);
        ((d)localObject).oTa.setAppCmd(419, arrayOfByte2, 1);
      }
      if (1 != ac.erv.eny) {
        break label1005;
      }
      arrayOfByte3 = new byte[30];
      int n = 0;
      while (n < 15)
      {
        arrayOfByte3[(n * 2)] = ((byte)(ac.erv.enz[n] & 0xFF));
        arrayOfByte3[(n * 2 + 1)] = ((byte)(ac.erv.enz[n] >> 8 & 0xFF));
        n += 1;
      }
      if (ac.erv.eno != -2) {
        break;
      }
      ((d)localObject).oTa.setAppCmd(407, arrayOfByte1, 1);
      break;
      label905:
      ((d)localObject).oTa.setAppCmd(404, arrayOfByte3, 2);
      break label207;
      label925:
      if (ac.erv.enr != -2) {
        break label207;
      }
      ((d)localObject).oTa.setAppCmd(405, arrayOfByte1, 1);
      break label207;
      label956:
      if (ac.erv.enp == -2) {
        ((d)localObject).oTa.setAppCmd(409, arrayOfByte1, 1);
      }
    }
    ((d)localObject).oTa.setAppCmd(420, arrayOfByte3, 30);
    label1005:
    if (ac.erv.eny == 0) {
      ((d)localObject).oTa.setAppCmd(421, arrayOfByte1, 1);
    }
    if (ac.erv.enC > 0)
    {
      arrayOfByte2[0] = ((byte)ac.erv.enC);
      ((d)localObject).oTa.setAppCmd(424, arrayOfByte2, 1);
    }
    if (ac.erv.ena > 0)
    {
      arrayOfByte2[0] = ((byte)ac.erv.ena);
      ((d)localObject).oTa.setAppCmd(431, arrayOfByte2, 4);
    }
    if (ac.erv.enK >= 0)
    {
      int i = (byte)ac.erv.enK;
      int j = (byte)ac.erv.enL;
      int k = (byte)ac.erv.enM;
      int m = (byte)ac.erv.enN;
      ((d)localObject).oTa.setAppCmd(426, new byte[] { i, j, k, m }, 4);
    }
    AppMethodBeat.o(53895);
    return 0;
  }
  
  public final boolean bSL()
  {
    AppMethodBeat.i(53899);
    ab.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
    c localc = this.oTf.oTb;
    synchronized (localc.kJS)
    {
      ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(localc.isStart), Integer.valueOf(localc.hashCode()) });
      if (localc.isStart)
      {
        com.tencent.mm.plugin.voip.model.c localc1 = localc.kJR;
        if (localc1 != null)
        {
          localc.kJX.etf = SystemClock.elapsedRealtime();
          localc1.cLJ();
          ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + localc.kJX.Mm());
          localc1.cLG();
          localc.isStart = false;
          localc.kJR = null;
          com.tencent.mm.compatible.b.g.KC().KS();
          com.tencent.mm.compatible.b.g.KC().setMode(0);
        }
        localc.kJT.fg(ah.getContext());
        com.tencent.mm.compatible.b.g.KC().b(localc);
        localc.gaP.Mh();
      }
      AppMethodBeat.o(53899);
      return true;
    }
  }
  
  public final boolean bSM()
  {
    AppMethodBeat.i(53900);
    ab.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
    try
    {
      if (this.oTf.kJB != null)
      {
        this.oTf.kJB.cjD = null;
        this.oTf.kJB.Et();
      }
      this.oTf.kJB = null;
      AppMethodBeat.o(53900);
      return true;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :".concat(String.valueOf(localException)));
      AppMethodBeat.o(53900);
    }
    return false;
  }
  
  public final int bSN()
  {
    int j = 0;
    AppMethodBeat.i(53901);
    ab.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
    int i = j;
    if (this.oTf.oTb != null)
    {
      c localc = this.oTf.oTb;
      i = j;
      if (localc.kJR != null) {
        i = localc.kJR.cLL();
      }
    }
    float f = com.tencent.mm.compatible.b.g.KC().getStreamMaxVolume(i);
    i = (int)(com.tencent.mm.compatible.b.g.KC().getStreamVolume(i) / f * 100.0F);
    AppMethodBeat.o(53901);
    return i;
  }
  
  public final int bSO()
  {
    AppMethodBeat.i(53902);
    ab.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
    if (this.oTf.kJB != null)
    {
      int i = this.oTf.kJB.EF();
      AppMethodBeat.o(53902);
      return i;
    }
    AppMethodBeat.o(53902);
    return -2;
  }
  
  public final int bSP()
  {
    AppMethodBeat.i(53903);
    ab.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
    if (this.oTf.kJB != null)
    {
      int i = this.oTf.kJB.cjh;
      AppMethodBeat.o(53903);
      return i;
    }
    AppMethodBeat.o(53903);
    return 0;
  }
  
  public final int bSQ()
  {
    AppMethodBeat.i(53904);
    ab.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
    if (this.oTf.oTb != null)
    {
      c localc = this.oTf.oTb;
      if (localc.kJR != null)
      {
        int i = localc.kJR.cLK();
        AppMethodBeat.o(53904);
        return i;
      }
      AppMethodBeat.o(53904);
      return 0;
    }
    AppMethodBeat.o(53904);
    return 0;
  }
  
  public final boolean d(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53892);
    ab.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + paramInt1 + " cmdid " + paramInt2);
    paramArrayOfByte = new o(paramInt1, paramInt2, paramArrayOfByte);
    com.tencent.mm.kernel.g.Rc().a(paramArrayOfByte, 0);
    AppMethodBeat.o(53892);
    return false;
  }
  
  public final boolean jB(boolean paramBoolean)
  {
    AppMethodBeat.i(53896);
    ab.b("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oTf.oTb.iE(paramBoolean);
    AppMethodBeat.o(53896);
    return true;
  }
  
  public final boolean y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(53891);
    switch (paramInt)
    {
    default: 
      ab.v(paramString1, paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(53891);
      return false;
      ab.v(paramString1, paramString2);
      continue;
      ab.d(paramString1, paramString2);
      continue;
      ab.i(paramString1, paramString2);
      continue;
      ab.w(paramString1, paramString2);
      continue;
      ab.e(paramString1, paramString2);
      continue;
      ab.f(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.d.1
 * JD-Core Version:    0.7.0.1
 */