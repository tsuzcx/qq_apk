package com.tencent.mm.plugin.multitalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "innerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getInnerPlayer", "()Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "setInnerPlayer", "(Lcom/tencent/mm/plugin/voip/model/AudioPlayer;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "checkRingPlayStop", "", "enableSpeakerOn", "", "value", "getAudioPlayErrState", "", "getAudioPlayerStreamType", "getCurrentStreamType", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "status", "refreshHandFree", "releaseAudioDeviceCauseStopRing", "releaseAudioPlayingDevice", "requestAudioDeviceToStartRing", "isCallingParty", "type", "requestAudioPlayingDevice", "setSpeakerPhoneOnInternal", "isSpeakerPhoneOn", "turnVolumeDown", "turnVolumeUp", "unInit", "Companion", "plugin-multitalk_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a vZV;
  public i gXE;
  private com.tencent.mm.compatible.util.b ixy;
  public com.tencent.mm.plugin.voip.model.c vZU;
  
  static
  {
    AppMethodBeat.i(206623);
    vZV = new a.a((byte)0);
    AppMethodBeat.o(206623);
  }
  
  public a()
  {
    AppMethodBeat.i(206622);
    this.gXE = new i(aj.getContext());
    this.ixy = new com.tencent.mm.compatible.util.b(aj.getContext());
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "multitalke");
    com.tencent.mm.plugin.audio.d.a.bGM();
    com.tencent.mm.plugin.audio.d.c.bGM();
    this.ixy.requestFocus();
    if (bGA())
    {
      if (xn(4))
      {
        b("multitalke", Integer.valueOf(4));
        AppMethodBeat.o(206622);
        return;
      }
      b("multitalke", Integer.valueOf(3));
      AppMethodBeat.o(206622);
      return;
    }
    b("multitalke", Integer.valueOf(2));
    AppMethodBeat.o(206622);
  }
  
  public static int ddZ()
  {
    AppMethodBeat.i(206618);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    localObject = com.tencent.mm.plugin.audio.d.a.nrY;
    if (com.tencent.mm.plugin.audio.d.a.bGD())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      int i = com.tencent.mm.plugin.audio.c.a.a.bGC().bGy();
      AppMethodBeat.o(206618);
      return i;
    }
    localObject = com.tencent.mm.plugin.multitalk.model.z.dqx();
    p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((o)localObject).cae())
    {
      AppMethodBeat.o(206618);
      return 3;
    }
    AppMethodBeat.o(206618);
    return 0;
  }
  
  public static void doG()
  {
    AppMethodBeat.i(206615);
    if ((xn(3)) || (xn(4)))
    {
      com.tencent.mm.plugin.multitalk.model.z.dqx().oI(false);
      AppMethodBeat.o(206615);
      return;
    }
    com.tencent.mm.plugin.multitalk.model.z.dqx().oI(true);
    AppMethodBeat.o(206615);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(206613);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.VM("multitalke");
    AppMethodBeat.o(206613);
  }
  
  public final void K(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(206616);
    if (paramInt == 0)
    {
      if (!this.nrG)
      {
        ad.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing ignore bluetooth or not bt plug");
        this.gXE.aO(1, paramBoolean);
        AppMethodBeat.o(206616);
        return;
      }
      ad.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing but waitting the bt connected");
      this.nrF = ((d.g.a.b)new b(this, paramBoolean));
      AppMethodBeat.o(206616);
      return;
    }
    this.nrF = null;
    this.gXE.U(false, 1);
    AppMethodBeat.o(206616);
  }
  
  public final void Ob()
  {
    AppMethodBeat.i(206619);
    ad.i("MicroMsg.MT.MultiTalkAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(xn(3)), Boolean.valueOf(xn(4)), Integer.valueOf(hashCode()) });
    if (bGA())
    {
      com.tencent.mm.plugin.multitalk.model.z.dqx().oI(false);
      if (xn(4)) {
        b("multitalke", Integer.valueOf(4));
      }
      for (;;)
      {
        com.tencent.mm.plugin.multitalk.model.z.dqw().oK(false);
        com.tencent.mm.plugin.multitalk.model.z.dqw().oJ(true);
        this.ixy.requestFocus();
        AppMethodBeat.o(206619);
        return;
        b("multitalke", Integer.valueOf(3));
      }
    }
    o localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localo.dpK())
    {
      b("multitalke", Integer.valueOf(1));
      com.tencent.mm.plugin.multitalk.model.z.dqw().oK(true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.multitalk.model.z.dqw().oJ(false);
      break;
      b("multitalke", Integer.valueOf(2));
      com.tencent.mm.plugin.multitalk.model.z.dqw().oK(false);
    }
  }
  
  public final void doH()
  {
    AppMethodBeat.i(206617);
    this.nrF = null;
    this.gXE.stop();
    this.ixy.abe();
    AppMethodBeat.o(206617);
  }
  
  public final void doI()
  {
    AppMethodBeat.i(206620);
    bGw();
    VJ("multitalke");
    this.ixy.abe();
    AppMethodBeat.o(206620);
  }
  
  public final void hC(int paramInt)
  {
    AppMethodBeat.i(206621);
    super.hC(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(206621);
      return;
    case 2: 
      com.tencent.mm.plugin.multitalk.model.z.dqx().oI(false);
      cn(false);
      com.tencent.mm.plugin.multitalk.model.z.dqx().oU(false);
      com.tencent.mm.plugin.multitalk.model.z.dqw().oJ(true);
      com.tencent.mm.plugin.multitalk.model.z.dqw().oK(false);
      AppMethodBeat.o(206621);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
      if ((localo.cae()) && (!xn(3)))
      {
        bool1 = true;
        localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
        p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
        bool2 = bool1;
        if (localo.cae())
        {
          bool2 = bool1;
          if (!xn(3))
          {
            localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
            p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
            bool2 = localo.dqi();
          }
        }
        if (!xn(3)) {
          break label366;
        }
        com.tencent.mm.plugin.multitalk.model.z.dqw().oJ(true);
        bool1 = xn(3);
        localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
        p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool3 = localo.dpK();
        localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
        p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool4 = localo.dqi();
        localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
        p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
        ad.i("MicroMsg.MT.MultiTalkAudioManager", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(localo.cae()), Boolean.valueOf(xn(4)), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.multitalk.model.z.dqx().oU(bool2);
        if (!xn(3)) {
          break label383;
        }
        com.tencent.mm.plugin.multitalk.model.z.dqx().oI(false);
      }
      for (;;)
      {
        if (!bool2) {
          break label393;
        }
        com.tencent.mm.plugin.voip.c.euN().setVoicePlayDevice(1);
        AppMethodBeat.o(206621);
        return;
        bool1 = false;
        break;
        com.tencent.mm.plugin.multitalk.model.z.dqw().oJ(false);
        com.tencent.mm.plugin.multitalk.model.z.dqw().oK(bool2);
        break label203;
        com.tencent.mm.plugin.multitalk.model.z.dqx().oI(true);
      }
      if (xn(3))
      {
        com.tencent.mm.plugin.voip.c.euN().setVoicePlayDevice(3);
        AppMethodBeat.o(206621);
        return;
      }
      com.tencent.mm.plugin.voip.c.euN().setVoicePlayDevice(2);
      AppMethodBeat.o(206621);
      return;
    case 8: 
      label203:
      label366:
      label383:
      localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
      label393:
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
      bool1 = localo.dpK();
      localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
      bool2 = localo.dqi();
      localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
      ad.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug connected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localo.cae()), Boolean.valueOf(xn(3)) });
      com.tencent.mm.plugin.multitalk.model.z.dqx().oI(false);
      com.tencent.mm.plugin.voip.c.euN().setVoicePlayDevice(3);
      com.tencent.mm.plugin.multitalk.model.z.dqx().oU(false);
      com.tencent.mm.plugin.multitalk.model.z.dqw().oJ(true);
      com.tencent.mm.plugin.multitalk.model.z.dqw().oK(false);
      AppMethodBeat.o(206621);
      return;
    }
    o localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool1 = localo.dpK();
    localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool2 = localo.dqi();
    localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    ad.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug disconnected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localo.cae()), Boolean.valueOf(xn(4)) });
    localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localo.cae())
    {
      localo = com.tencent.mm.plugin.multitalk.model.z.dqx();
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    }
    for (bool1 = localo.dqi();; bool1 = true)
    {
      if (xn(4)) {
        bool1 = false;
      }
      if (bool1) {
        com.tencent.mm.plugin.voip.c.euN().setVoicePlayDevice(1);
      }
      for (;;)
      {
        com.tencent.mm.plugin.multitalk.model.z.dqx().oU(bool1);
        com.tencent.mm.plugin.multitalk.model.z.dqx().oI(true);
        com.tencent.mm.plugin.multitalk.model.z.dqw().oJ(false);
        com.tencent.mm.plugin.multitalk.model.z.dqw().oK(bool1);
        break;
        if (xn(4)) {
          com.tencent.mm.plugin.voip.c.euN().setVoicePlayDevice(4);
        } else {
          com.tencent.mm.plugin.voip.c.euN().setVoicePlayDevice(2);
        }
      }
    }
  }
  
  public final void oF(boolean paramBoolean)
  {
    AppMethodBeat.i(206614);
    ad.i("MicroMsg.MT.MultiTalkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    iq(paramBoolean);
    if (this.vZU != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.vZU;
      if (localc != null)
      {
        if (localc.isPlaying() == true)
        {
          localc = this.vZU;
          if (localc != null)
          {
            localc.tb(paramBoolean);
            AppMethodBeat.o(206614);
          }
        }
      }
      else
      {
        AppMethodBeat.o(206614);
        return;
      }
    }
    AppMethodBeat.o(206614);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<Boolean, d.z>
  {
    b(a parama, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.a
 * JD-Core Version:    0.7.0.1
 */