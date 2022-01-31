package com.tencent.mm.plugin.multitalk.a;

import android.os.SystemClock;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.model.a;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements f.a, HeadsetPlugReceiver.a
{
  boolean bSr = false;
  com.tencent.mm.compatible.util.b eLi = new com.tencent.mm.compatible.util.b(ae.getContext());
  com.tencent.mm.plugin.voip.model.b iEF = null;
  final Object iEG = new Object();
  HeadsetPlugReceiver iEH = new HeadsetPlugReceiver();
  private boolean iEI = false;
  private boolean iEJ = false;
  private int iEK;
  g.a iEL = new g.a();
  private final Object lqj = new Object();
  
  private boolean bkI()
  {
    boolean bool1;
    if ((p.blF().lpn.amn()) && (!this.iEI))
    {
      bool1 = true;
      bool2 = bool1;
      if (p.blF().lpn.amn())
      {
        bool2 = bool1;
        if (!this.iEI) {
          if (!p.blF().mtC) {
            break label147;
          }
        }
      }
    }
    label147:
    for (boolean bool2 = true;; bool2 = false)
    {
      p.blE().hH(false);
      y.i("MicroMsg.MT.MultiTalkAudioPlayer", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[] { Boolean.valueOf(this.iEI), Boolean.valueOf(p.blF().mtB), Boolean.valueOf(p.blF().mtC), Boolean.valueOf(p.blF().lpn.amn()), Boolean.valueOf(this.iEJ), Boolean.valueOf(bool2) });
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public final int a(a parama, int paramInt1, int paramInt2)
  {
    synchronized (this.iEG)
    {
      if (this.bSr)
      {
        y.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
        return -1;
      }
      y.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.iEF == null)
      {
        this.iEF = new com.tencent.mm.plugin.voip.model.b();
        this.iEF.z(paramInt1, 1, paramInt2, 0);
      }
      this.iEF.t(ae.getContext(), false);
      this.iEF.pNy = parama;
      com.tencent.mm.compatible.b.f.yi().a(this);
      this.iEI = com.tencent.mm.compatible.b.f.yi().yt();
      this.iEJ = com.tencent.mm.compatible.b.f.yi().yn();
      y.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(this.iEI), Boolean.valueOf(this.iEJ), Integer.valueOf(hashCode()) });
      y.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
      this.bSr = true;
      this.iEL.dzS = SystemClock.elapsedRealtime();
      paramInt1 = this.iEF.bPD();
      y.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.iEL.zJ());
      this.eLi.requestFocus();
      this.iEH.a(ae.getContext(), this);
      if ((this.iEI) || (this.iEJ))
      {
        p.blF().hG(false);
        if (this.iEJ) {
          com.tencent.mm.compatible.b.f.yi().yk();
        }
      }
      y.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      return paramInt1;
    }
  }
  
  public final void eH(boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool2;
    boolean bool1;
    label152:
    d locald;
    if (this.iEI != paramBoolean)
    {
      this.iEI = paramBoolean;
      y.i("MicroMsg.MT.MultiTalkAudioPlayer", "onHeadsetState: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(this.iEI), Boolean.valueOf(p.blF().mtB), Boolean.valueOf(p.blF().mtC), Boolean.valueOf(p.blF().lpn.amn()), Boolean.valueOf(this.iEJ) });
      if ((!p.blF().lpn.amn()) || (this.iEI)) {
        break label210;
      }
      bool2 = true;
      if (paramBoolean) {
        p.blF().hG(false);
      }
      bool1 = bool2;
      if (p.blF().lpn.amn())
      {
        bool1 = bool2;
        if (!this.iEI)
        {
          if (!p.blF().mtC) {
            break label215;
          }
          bool1 = true;
        }
      }
      if (this.iEJ) {
        bool1 = false;
      }
      gV(bool1);
      p.blF().hM(bool1);
      if (!paramBoolean) {
        p.blF().hG(true);
      }
      locald = p.blE();
      if ((this.iEJ) || (!paramBoolean)) {
        break label220;
      }
    }
    label210:
    label215:
    label220:
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      locald.hH(paramBoolean);
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label152;
    }
  }
  
  public final void ew(int paramInt)
  {
    y.i("MicroMsg.MT.MultiTalkAudioPlayer", "onBluetoothHeadsetStateChange, status: %d, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.bSr) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.iEK = paramInt;
      return;
      this.iEJ = true;
      com.tencent.mm.compatible.b.f.yi().yk();
      continue;
      if (paramInt != this.iEK)
      {
        this.iEJ = true;
        p.blF().hG(false);
        gV(false);
        p.blF().hM(false);
        p.blE().hH(true);
        continue;
        if (paramInt != this.iEK)
        {
          this.iEJ = false;
          boolean bool = bkI();
          gV(bool);
          p.blF().hM(bool);
          p.blF().hG(true);
          continue;
          if (paramInt != this.iEK)
          {
            this.iEJ = false;
            com.tencent.mm.compatible.b.f.yi().yl();
            bool = bkI();
            gV(bool);
            p.blF().hM(bool);
            p.blF().hG(true);
          }
        }
      }
    }
  }
  
  public final void gV(boolean paramBoolean)
  {
    y.i("MicroMsg.MT.MultiTalkAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.compatible.b.f.yi().bn(paramBoolean);
    if ((this.iEF != null) && (this.iEF.pNn)) {
      this.iEF.jQ(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.c
 * JD-Core Version:    0.7.0.1
 */