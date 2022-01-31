package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class c
  implements com.tencent.mm.compatible.b.g.a, HeadsetPlugReceiver.a
{
  com.tencent.mm.compatible.util.b gaP;
  boolean isStart;
  com.tencent.mm.plugin.voip.model.c kJR;
  final Object kJS;
  HeadsetPlugReceiver kJT;
  private boolean kJU;
  private boolean kJV;
  private int kJW;
  com.tencent.mm.compatible.util.g.a kJX;
  private final Object nNF;
  
  public c()
  {
    AppMethodBeat.i(53885);
    this.kJR = null;
    this.nNF = new Object();
    this.kJS = new Object();
    this.isStart = false;
    this.kJU = false;
    this.kJV = false;
    this.kJX = new com.tencent.mm.compatible.util.g.a();
    this.gaP = new com.tencent.mm.compatible.util.b(ah.getContext());
    this.kJT = new HeadsetPlugReceiver();
    AppMethodBeat.o(53885);
  }
  
  private boolean bSI()
  {
    AppMethodBeat.i(53890);
    boolean bool1;
    if ((p.bTF().nMJ.Dt()) && (!this.kJU))
    {
      bool1 = true;
      bool2 = bool1;
      if (p.bTF().nMJ.Dt())
      {
        bool2 = bool1;
        if (!this.kJU) {
          if (!p.bTF().oTn) {
            break label157;
          }
        }
      }
    }
    label157:
    for (boolean bool2 = true;; bool2 = false)
    {
      p.bTE().jA(false);
      ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[] { Boolean.valueOf(this.kJU), Boolean.valueOf(p.bTF().oTm), Boolean.valueOf(p.bTF().oTn), Boolean.valueOf(p.bTF().nMJ.Dt()), Boolean.valueOf(this.kJV), Boolean.valueOf(bool2) });
      AppMethodBeat.o(53890);
      return bool2;
      bool1 = false;
      break;
    }
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53886);
    synchronized (this.kJS)
    {
      if (this.isStart)
      {
        ab.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(53886);
        return -1;
      }
      ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.kJR == null)
      {
        this.kJR = new com.tencent.mm.plugin.voip.model.c();
        this.kJR.F(paramInt1, 1, paramInt2, 0);
      }
      this.kJR.x(ah.getContext(), false);
      this.kJR.ttu = paramb;
      g.KC().a(this);
      this.kJU = g.KC().KN();
      this.kJV = g.KC().KH();
      ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(this.kJU), Boolean.valueOf(this.kJV), Integer.valueOf(hashCode()) });
      this.gaP.requestFocus();
      this.kJT.a(ah.getContext(), this);
      if ((this.kJU) || (this.kJV))
      {
        p.bTF().jz(false);
        if (this.kJV) {
          g.KC().KE();
        }
        p.bTE().jA(true);
        ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
        this.isStart = true;
        this.kJX.etf = SystemClock.elapsedRealtime();
        paramInt1 = this.kJR.cLH();
        ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.kJX.Mm());
        ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(53886);
        return paramInt1;
      }
      p.bTE().jA(false);
    }
  }
  
  public final void gj(boolean paramBoolean)
  {
    boolean bool3 = true;
    AppMethodBeat.i(53888);
    boolean bool2;
    boolean bool1;
    label157:
    d locald;
    if (this.kJU != paramBoolean)
    {
      this.kJU = paramBoolean;
      ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "onHeadsetState: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(this.kJU), Boolean.valueOf(p.bTF().oTm), Boolean.valueOf(p.bTF().oTn), Boolean.valueOf(p.bTF().nMJ.Dt()), Boolean.valueOf(this.kJV) });
      if ((!p.bTF().nMJ.Dt()) || (this.kJU)) {
        break label220;
      }
      bool2 = true;
      if (paramBoolean) {
        p.bTF().jz(false);
      }
      bool1 = bool2;
      if (p.bTF().nMJ.Dt())
      {
        bool1 = bool2;
        if (!this.kJU)
        {
          if (!p.bTF().oTn) {
            break label225;
          }
          bool1 = true;
        }
      }
      if (this.kJV) {
        bool1 = false;
      }
      iE(bool1);
      p.bTF().jF(bool1);
      if (!paramBoolean) {
        p.bTF().jz(true);
      }
      locald = p.bTE();
      if ((this.kJV) || (!paramBoolean)) {
        break label230;
      }
    }
    label220:
    label225:
    label230:
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      locald.jA(paramBoolean);
      AppMethodBeat.o(53888);
      return;
      bool2 = false;
      break;
      bool1 = false;
      break label157;
    }
  }
  
  public final void gy(int paramInt)
  {
    AppMethodBeat.i(53889);
    ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "onBluetoothHeadsetStateChange, status: %d, isStart: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.isStart) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.kJW = paramInt;
      AppMethodBeat.o(53889);
      return;
      this.kJV = true;
      g.KC().KE();
      continue;
      if (paramInt != this.kJW)
      {
        this.kJV = true;
        p.bTF().jz(false);
        iE(false);
        p.bTF().jF(false);
        p.bTE().jA(true);
        continue;
        if (paramInt != this.kJW)
        {
          this.kJV = false;
          boolean bool = bSI();
          iE(bool);
          p.bTF().jF(bool);
          p.bTF().jz(true);
          continue;
          g.KC().KE();
          continue;
          if (paramInt != this.kJW)
          {
            this.kJV = false;
            g.KC().KF();
            bool = bSI();
            iE(bool);
            p.bTF().jF(bool);
            p.bTF().jz(true);
          }
        }
      }
    }
  }
  
  public final void iE(boolean paramBoolean)
  {
    AppMethodBeat.i(53887);
    ab.i("MicroMsg.MT.MultiTalkAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    g.KC().bN(paramBoolean);
    if ((this.kJR != null) && (this.kJR.ttj)) {
      this.kJR.mJ(paramBoolean);
    }
    AppMethodBeat.o(53887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.c
 * JD-Core Version:    0.7.0.1
 */