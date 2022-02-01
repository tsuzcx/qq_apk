package com.tencent.mm.plugin.multitalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.m;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.voip.ui.d;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "innerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getInnerPlayer", "()Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "setInnerPlayer", "(Lcom/tencent/mm/plugin/voip/model/AudioPlayer;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "checkRingPlayStop", "", "enableSpeakerOn", "", "value", "getAudioPlayErrState", "", "getAudioPlayerStreamType", "getCurrentStreamType", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "status", "refreshHandFree", "releaseAudioDeviceCauseStopRing", "releaseAudioPlayingDevice", "requestAudioDeviceToStartRing", "isCallingParty", "type", "requestAudioPlayingDevice", "setSpeakerPhoneOnInternal", "isSpeakerPhoneOn", "turnVolumeDown", "turnVolumeUp", "unInit", "Companion", "plugin-multitalk_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a wlZ;
  public i haq;
  private com.tencent.mm.compatible.util.b iAr;
  public com.tencent.mm.plugin.voip.model.c wlY;
  
  static
  {
    AppMethodBeat.i(190886);
    wlZ = new a.a((byte)0);
    AppMethodBeat.o(190886);
  }
  
  public a()
  {
    AppMethodBeat.i(190885);
    this.haq = new i(ak.getContext());
    this.iAr = new com.tencent.mm.compatible.util.b(ak.getContext());
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "multitalke");
    com.tencent.mm.plugin.audio.d.a.bHI();
    com.tencent.mm.plugin.audio.d.c.bHI();
    this.iAr.requestFocus();
    if (bHw())
    {
      if (xs(4))
      {
        b("multitalke", Integer.valueOf(4));
        AppMethodBeat.o(190885);
        return;
      }
      b("multitalke", Integer.valueOf(3));
      AppMethodBeat.o(190885);
      return;
    }
    b("multitalke", Integer.valueOf(2));
    AppMethodBeat.o(190885);
  }
  
  public static int dgR()
  {
    AppMethodBeat.i(190881);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    localObject = com.tencent.mm.plugin.audio.d.a.nxr;
    if (com.tencent.mm.plugin.audio.d.a.bHz())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      int i = com.tencent.mm.plugin.audio.c.a.a.bHy().bHu();
      AppMethodBeat.o(190881);
      return i;
    }
    localObject = com.tencent.mm.plugin.multitalk.model.z.dtK();
    p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((o)localObject).cbt())
    {
      AppMethodBeat.o(190881);
      return 3;
    }
    AppMethodBeat.o(190881);
    return 0;
  }
  
  public static void drE()
  {
    AppMethodBeat.i(190878);
    if ((xs(3)) || (xs(4)))
    {
      com.tencent.mm.plugin.multitalk.model.z.dtK().oP(false);
      AppMethodBeat.o(190878);
      return;
    }
    com.tencent.mm.plugin.multitalk.model.z.dtK().oP(true);
    AppMethodBeat.o(190878);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(190876);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.Wy("multitalke");
    AppMethodBeat.o(190876);
  }
  
  public final void M(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(190879);
    if (paramInt == 0)
    {
      if (!this.nwZ)
      {
        ae.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing ignore bluetooth or not bt plug");
        this.haq.aU(1, paramBoolean);
        AppMethodBeat.o(190879);
        return;
      }
      ae.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing but waitting the bt connected");
      this.nwY = ((d.g.a.b)new b(this, paramBoolean));
      AppMethodBeat.o(190879);
      return;
    }
    this.nwY = null;
    this.haq.X(false, 1);
    AppMethodBeat.o(190879);
  }
  
  public final void NZ()
  {
    AppMethodBeat.i(190882);
    ae.i("MicroMsg.MT.MultiTalkAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(xs(3)), Boolean.valueOf(xs(4)), Integer.valueOf(hashCode()) });
    if (bHw())
    {
      com.tencent.mm.plugin.multitalk.model.z.dtK().oP(false);
      if (xs(4)) {
        b("multitalke", Integer.valueOf(4));
      }
      for (;;)
      {
        com.tencent.mm.plugin.multitalk.model.z.dtJ().oR(false);
        com.tencent.mm.plugin.multitalk.model.z.dtJ().oQ(true);
        this.iAr.requestFocus();
        AppMethodBeat.o(190882);
        return;
        b("multitalke", Integer.valueOf(3));
      }
    }
    o localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localo.dsV())
    {
      b("multitalke", Integer.valueOf(1));
      com.tencent.mm.plugin.multitalk.model.z.dtJ().oR(true);
    }
    for (;;)
    {
      com.tencent.mm.plugin.multitalk.model.z.dtJ().oQ(false);
      break;
      b("multitalke", Integer.valueOf(2));
      com.tencent.mm.plugin.multitalk.model.z.dtJ().oR(false);
    }
  }
  
  public final void drF()
  {
    AppMethodBeat.i(190880);
    this.nwY = null;
    this.haq.stop();
    this.iAr.abn();
    AppMethodBeat.o(190880);
  }
  
  public final void drG()
  {
    AppMethodBeat.i(190883);
    bHs();
    Wv("multitalke");
    this.iAr.abn();
    AppMethodBeat.o(190883);
  }
  
  public final void hE(int paramInt)
  {
    AppMethodBeat.i(190884);
    super.hE(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(190884);
      return;
    case 2: 
      com.tencent.mm.plugin.multitalk.model.z.dtK().oP(false);
      cn(false);
      com.tencent.mm.plugin.multitalk.model.z.dtK().pb(false);
      com.tencent.mm.plugin.multitalk.model.z.dtJ().oQ(true);
      com.tencent.mm.plugin.multitalk.model.z.dtJ().oR(false);
      AppMethodBeat.o(190884);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
      if ((localo.cbt()) && (!xs(3)))
      {
        bool1 = true;
        localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
        p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
        bool2 = bool1;
        if (localo.cbt())
        {
          bool2 = bool1;
          if (!xs(3))
          {
            localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
            p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
            bool2 = localo.dtv();
          }
        }
        if (!xs(3)) {
          break label366;
        }
        com.tencent.mm.plugin.multitalk.model.z.dtJ().oQ(true);
        bool1 = xs(3);
        localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
        p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool3 = localo.dsV();
        localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
        p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool4 = localo.dtv();
        localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
        p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
        ae.i("MicroMsg.MT.MultiTalkAudioManager", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(localo.cbt()), Boolean.valueOf(xs(4)), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.multitalk.model.z.dtK().pb(bool2);
        if (!xs(3)) {
          break label383;
        }
        com.tencent.mm.plugin.multitalk.model.z.dtK().oP(false);
      }
      for (;;)
      {
        if (!bool2) {
          break label393;
        }
        com.tencent.mm.plugin.voip.c.eyt().setVoicePlayDevice(1);
        AppMethodBeat.o(190884);
        return;
        bool1 = false;
        break;
        com.tencent.mm.plugin.multitalk.model.z.dtJ().oQ(false);
        com.tencent.mm.plugin.multitalk.model.z.dtJ().oR(bool2);
        break label203;
        com.tencent.mm.plugin.multitalk.model.z.dtK().oP(true);
      }
      if (xs(3))
      {
        com.tencent.mm.plugin.voip.c.eyt().setVoicePlayDevice(3);
        AppMethodBeat.o(190884);
        return;
      }
      com.tencent.mm.plugin.voip.c.eyt().setVoicePlayDevice(2);
      AppMethodBeat.o(190884);
      return;
    case 8: 
      label203:
      label366:
      label383:
      localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
      label393:
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
      bool1 = localo.dsV();
      localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
      bool2 = localo.dtv();
      localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
      ae.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug connected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localo.cbt()), Boolean.valueOf(xs(3)) });
      com.tencent.mm.plugin.multitalk.model.z.dtK().oP(false);
      com.tencent.mm.plugin.voip.c.eyt().setVoicePlayDevice(3);
      com.tencent.mm.plugin.multitalk.model.z.dtK().pb(false);
      com.tencent.mm.plugin.multitalk.model.z.dtJ().oQ(true);
      com.tencent.mm.plugin.multitalk.model.z.dtJ().oR(false);
      AppMethodBeat.o(190884);
      return;
    }
    o localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool1 = localo.dsV();
    localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool2 = localo.dtv();
    localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    ae.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug disconnected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localo.cbt()), Boolean.valueOf(xs(4)) });
    localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
    p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localo.cbt())
    {
      localo = com.tencent.mm.plugin.multitalk.model.z.dtK();
      p.g(localo, "SubCoreMultiTalk.getMultiTalkManager()");
    }
    for (bool1 = localo.dtv();; bool1 = true)
    {
      if (xs(4)) {
        bool1 = false;
      }
      if (bool1) {
        com.tencent.mm.plugin.voip.c.eyt().setVoicePlayDevice(1);
      }
      for (;;)
      {
        com.tencent.mm.plugin.multitalk.model.z.dtK().pb(bool1);
        com.tencent.mm.plugin.multitalk.model.z.dtK().oP(true);
        com.tencent.mm.plugin.multitalk.model.z.dtJ().oQ(false);
        com.tencent.mm.plugin.multitalk.model.z.dtJ().oR(bool1);
        break;
        if (xs(4)) {
          com.tencent.mm.plugin.voip.c.eyt().setVoicePlayDevice(4);
        } else {
          com.tencent.mm.plugin.voip.c.eyt().setVoicePlayDevice(2);
        }
      }
    }
  }
  
  public final void oK(boolean paramBoolean)
  {
    AppMethodBeat.i(190877);
    ae.i("MicroMsg.MT.MultiTalkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    io(paramBoolean);
    if (this.wlY != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.wlY;
      if (localc != null)
      {
        if (localc.isPlaying() == true)
        {
          localc = this.wlY;
          if (localc != null)
          {
            localc.ti(paramBoolean);
            AppMethodBeat.o(190877);
          }
        }
      }
      else
      {
        AppMethodBeat.o(190877);
        return;
      }
    }
    AppMethodBeat.o(190877);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.a
 * JD-Core Version:    0.7.0.1
 */