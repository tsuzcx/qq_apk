package com.tencent.mm.plugin.multitalk.a;

import android.os.SystemClock;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bs;
import junit.framework.Assert;

final class d$1
  implements com.tencent.pb.talkroom.sdk.e
{
  d$1(d paramd) {}
  
  public final int a(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.b paramb)
  {
    this.mtu.mts = paramb;
    paramInt1 = this.mtu.mtq.a(this.mtu.mtt, paramInt1, paramInt2);
    y.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.b.f.yi().ys()), Boolean.valueOf(p.blF().mtB) });
    if ((com.tencent.mm.compatible.b.f.yi().ys() != p.blF().mtB) && (p.blF().lpn.amn())) {
      this.mtu.mtq.gV(p.blF().mtB);
    }
    return paramInt1;
  }
  
  public final int a(int paramInt1, int paramInt2, com.tencent.pb.talkroom.sdk.c paramc)
  {
    this.mtu.mtr = paramc;
    this.mtu.iEq = new com.tencent.mm.f.b.c(paramInt1, 1, 7);
    this.mtu.iEq.ey(paramInt2);
    this.mtu.iEq.aY(true);
    this.mtu.iEq.up();
    this.mtu.iEq.bCE = -19;
    this.mtu.iEq.t(1, false);
    this.mtu.iEq.aX(true);
    this.mtu.iEq.bCP = this.mtu.bDg;
    if (this.mtu.iEq.uq()) {
      return 1;
    }
    return -1;
  }
  
  public final boolean bkJ()
  {
    int i = m.yR();
    y.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:" + i);
    if ((i & 0x400) != 0) {
      com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v7a.so");
    }
    for (;;)
    {
      return true;
      if ((i & 0x200) != 0)
      {
        com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec.so");
        Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
      }
      else
      {
        com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v5.so");
        Assert.assertTrue("Can't remove libvoipCodec.so yet.", false);
      }
    }
  }
  
  public final int bkK()
  {
    String str = g.DP().DA().cwa();
    q.fa(str);
    y.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: " + str);
    d.a(this.mtu);
    return 0;
  }
  
  public final boolean bkL()
  {
    y.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
    c localc = this.mtu.mtq;
    synchronized (localc.iEG)
    {
      y.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(localc.bSr), Integer.valueOf(localc.hashCode()) });
      if (localc.bSr)
      {
        com.tencent.mm.plugin.voip.model.b localb = localc.iEF;
        if (localb != null)
        {
          localc.iEL.dzS = SystemClock.elapsedRealtime();
          localb.bPF();
          y.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + localc.iEL.zJ());
          localb.bPC();
          localc.bSr = false;
          localc.iEF = null;
          com.tencent.mm.compatible.b.f.yi().yx();
          com.tencent.mm.compatible.b.f.yi().setMode(0);
        }
        localc.iEH.ek(ae.getContext());
        com.tencent.mm.compatible.b.f.yi().yl();
        com.tencent.mm.compatible.b.f.yi().b(localc);
        localc.eLi.zE();
      }
      return true;
    }
  }
  
  public final boolean bkM()
  {
    y.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
    try
    {
      if (this.mtu.iEq != null)
      {
        this.mtu.iEq.bCP = null;
        this.mtu.iEq.uh();
      }
      this.mtu.iEq = null;
      return true;
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :" + localException);
    }
    return false;
  }
  
  public final int bkN()
  {
    int j = 0;
    y.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
    int i = j;
    if (this.mtu.mtq != null)
    {
      c localc = this.mtu.mtq;
      i = j;
      if (localc.iEF != null) {
        i = localc.iEF.bPH();
      }
    }
    float f = com.tencent.mm.compatible.b.f.yi().getStreamMaxVolume(i);
    return (int)(com.tencent.mm.compatible.b.f.yi().getStreamVolume(i) / f * 100.0F);
  }
  
  public final int bkO()
  {
    y.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
    if (this.mtu.iEq != null) {
      return this.mtu.iEq.us();
    }
    return -2;
  }
  
  public final int bkP()
  {
    y.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
    if (this.mtu.iEq != null) {
      return this.mtu.iEq.bCt;
    }
    return 0;
  }
  
  public final int bkQ()
  {
    int j = 0;
    y.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
    int i = j;
    if (this.mtu.mtq != null)
    {
      c localc = this.mtu.mtq;
      i = j;
      if (localc.iEF != null) {
        i = localc.iEF.bPG();
      }
    }
    return i;
  }
  
  public final boolean c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + paramInt1 + " cmdid " + paramInt2);
    paramArrayOfByte = new o(paramInt1, paramInt2, paramArrayOfByte);
    g.Dk().a(paramArrayOfByte, 0);
    return false;
  }
  
  public final boolean hI(boolean paramBoolean)
  {
    y.i("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mtu.mtq.gV(paramBoolean);
    return true;
  }
  
  public final boolean o(int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      y.v(paramString1, paramString2);
    }
    for (;;)
    {
      return false;
      y.v(paramString1, paramString2);
      continue;
      y.d(paramString1, paramString2);
      continue;
      y.i(paramString1, paramString2);
      continue;
      y.w(paramString1, paramString2);
      continue;
      y.e(paramString1, paramString2);
      continue;
      y.f(paramString1, paramString2);
    }
  }
  
  public final int yR()
  {
    return m.yR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.d.1
 * JD-Core Version:    0.7.0.1
 */