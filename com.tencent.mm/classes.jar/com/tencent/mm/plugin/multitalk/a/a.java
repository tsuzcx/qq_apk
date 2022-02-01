package com.tencent.mm.plugin.multitalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "innerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getInnerPlayer", "()Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "setInnerPlayer", "(Lcom/tencent/mm/plugin/voip/model/AudioPlayer;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "checkRingPlayStop", "", "enableSpeakerOn", "", "value", "getAudioPlayErrState", "", "getAudioPlayerStreamType", "getCurrentStreamType", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "status", "refreshHandFree", "releaseAudioDeviceCauseStopRing", "releaseAudioPlayingDevice", "requestAudioDeviceToStartRing", "isCallingParty", "type", "requestAudioPlayingDevice", "setSpeakerPhoneOnInternal", "isSpeakerPhoneOn", "turnVolumeDown", "turnVolumeUp", "unInit", "Companion", "plugin-multitalk_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a uWN;
  public i gDU;
  private com.tencent.mm.compatible.util.b ied;
  public com.tencent.mm.plugin.voip.model.c uWM;
  
  static
  {
    AppMethodBeat.i(200712);
    uWN = new a.a((byte)0);
    AppMethodBeat.o(200712);
  }
  
  public a()
  {
    AppMethodBeat.i(200711);
    this.gDU = new i(ai.getContext());
    this.ied = new com.tencent.mm.compatible.util.b(ai.getContext());
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "multitalke");
    com.tencent.mm.plugin.audio.d.a.bCE();
    com.tencent.mm.plugin.audio.d.c.bCE();
    this.ied.requestFocus();
    if (bCv())
    {
      if (wH(4))
      {
        b("multitalke", Integer.valueOf(4));
        AppMethodBeat.o(200711);
        return;
      }
      b("multitalke", Integer.valueOf(3));
      AppMethodBeat.o(200711);
      return;
    }
    b("multitalke", Integer.valueOf(2));
    AppMethodBeat.o(200711);
  }
  
  public static int cUO()
  {
    AppMethodBeat.i(200707);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    localObject = com.tencent.mm.plugin.audio.d.a.mRz;
    if (com.tencent.mm.plugin.audio.d.a.bCy())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      int i = com.tencent.mm.plugin.audio.c.a.a.bCx().bCt();
      AppMethodBeat.o(200707);
      return i;
    }
    localObject = p.dgx();
    k.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((f)localObject).bVB())
    {
      AppMethodBeat.o(200707);
      return 3;
    }
    AppMethodBeat.o(200707);
    return 0;
  }
  
  public static void dfi()
  {
    AppMethodBeat.i(200704);
    if ((wH(3)) || (wH(4)))
    {
      p.dgx().oo(false);
      AppMethodBeat.o(200704);
      return;
    }
    p.dgx().oo(true);
    AppMethodBeat.o(200704);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(200702);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.So("multitalke");
    AppMethodBeat.o(200702);
  }
  
  public final void K(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(200705);
    if (paramInt == 0)
    {
      if (!this.mRh)
      {
        ac.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing ignore bluetooth or not bt plug");
        this.gDU.aI(1, paramBoolean);
        AppMethodBeat.o(200705);
        return;
      }
      ac.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing but waitting the bt connected");
      this.mRg = ((d.g.a.b)new b(this, paramBoolean));
      AppMethodBeat.o(200705);
      return;
    }
    this.mRg = null;
    this.gDU.T(false, 1);
    AppMethodBeat.o(200705);
  }
  
  public final void Ms()
  {
    AppMethodBeat.i(200708);
    ac.i("MicroMsg.MT.MultiTalkAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(wH(3)), Boolean.valueOf(wH(4)), Integer.valueOf(hashCode()) });
    if (bCv())
    {
      p.dgx().oo(false);
      if (wH(4)) {
        b("multitalke", Integer.valueOf(4));
      }
      for (;;)
      {
        p.dgw().op(true);
        this.ied.requestFocus();
        AppMethodBeat.o(200708);
        return;
        b("multitalke", Integer.valueOf(3));
      }
    }
    f localf = p.dgx();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localf.dfT()) {
      b("multitalke", Integer.valueOf(1));
    }
    for (;;)
    {
      p.dgw().op(false);
      break;
      b("multitalke", Integer.valueOf(2));
    }
  }
  
  public final void dfj()
  {
    AppMethodBeat.i(200706);
    this.mRg = null;
    this.gDU.stop();
    this.ied.YC();
    AppMethodBeat.o(200706);
  }
  
  public final void dfk()
  {
    AppMethodBeat.i(200709);
    bCr();
    Sl("multitalke");
    this.ied.YC();
    AppMethodBeat.o(200709);
  }
  
  public final void hv(int paramInt)
  {
    AppMethodBeat.i(200710);
    super.hv(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(200710);
      return;
    case 2: 
      p.dgx().oo(false);
      cm(false);
      p.dgx().ox(false);
      p.dgw().op(true);
      AppMethodBeat.o(200710);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      localf = p.dgx();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
      if ((localf.bVB()) && (!wH(3)))
      {
        bool1 = true;
        localf = p.dgx();
        k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
        bool2 = bool1;
        if (localf.bVB())
        {
          bool2 = bool1;
          if (!wH(3))
          {
            localf = p.dgx();
            k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
            bool2 = localf.dgj();
          }
        }
        if (!wH(3)) {
          break label359;
        }
        p.dgw().op(true);
        bool1 = wH(3);
        localf = p.dgx();
        k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool3 = localf.dfT();
        localf = p.dgx();
        k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool4 = localf.dgj();
        localf = p.dgx();
        k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
        ac.i("MicroMsg.MT.MultiTalkAudioManager", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(localf.bVB()), Boolean.valueOf(wH(4)), Boolean.valueOf(bool2) });
        p.dgx().ox(bool2);
        if (!wH(3)) {
          break label369;
        }
        p.dgx().oo(false);
      }
      for (;;)
      {
        if (!bool2) {
          break label379;
        }
        com.tencent.mm.plugin.voip.c.ehc().setVoicePlayDevice(1);
        AppMethodBeat.o(200710);
        return;
        bool1 = false;
        break;
        p.dgw().op(false);
        break label196;
        p.dgx().oo(true);
      }
      if (wH(3))
      {
        com.tencent.mm.plugin.voip.c.ehc().setVoicePlayDevice(3);
        AppMethodBeat.o(200710);
        return;
      }
      com.tencent.mm.plugin.voip.c.ehc().setVoicePlayDevice(2);
      AppMethodBeat.o(200710);
      return;
    case 8: 
      label196:
      label359:
      label369:
      label379:
      localf = p.dgx();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
      bool1 = localf.dfT();
      localf = p.dgx();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
      bool2 = localf.dgj();
      localf = p.dgx();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
      ac.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug connected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localf.bVB()), Boolean.valueOf(wH(3)) });
      p.dgx().oo(false);
      com.tencent.mm.plugin.voip.c.ehc().setVoicePlayDevice(3);
      p.dgx().ox(false);
      p.dgw().op(true);
      AppMethodBeat.o(200710);
      return;
    }
    f localf = p.dgx();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool1 = localf.dfT();
    localf = p.dgx();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool2 = localf.dgj();
    localf = p.dgx();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    ac.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug disconnected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localf.bVB()), Boolean.valueOf(wH(4)) });
    localf = p.dgx();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localf.bVB())
    {
      localf = p.dgx();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    }
    for (bool1 = localf.dgj();; bool1 = true)
    {
      if (wH(4)) {
        bool1 = false;
      }
      if (bool1) {
        com.tencent.mm.plugin.voip.c.ehc().setVoicePlayDevice(1);
      }
      for (;;)
      {
        p.dgx().ox(bool1);
        p.dgx().oo(true);
        p.dgw().op(false);
        break;
        if (wH(4)) {
          com.tencent.mm.plugin.voip.c.ehc().setVoicePlayDevice(4);
        } else {
          com.tencent.mm.plugin.voip.c.ehc().setVoicePlayDevice(2);
        }
      }
    }
  }
  
  public final void ol(boolean paramBoolean)
  {
    AppMethodBeat.i(200703);
    ac.i("MicroMsg.MT.MultiTalkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ih(paramBoolean);
    if (this.uWM != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.uWM;
      if (localc != null)
      {
        if (localc.isPlaying() == true)
        {
          localc = this.uWM;
          if (localc != null)
          {
            localc.ss(paramBoolean);
            AppMethodBeat.o(200703);
          }
        }
      }
      else
      {
        AppMethodBeat.o(200703);
        return;
      }
    }
    AppMethodBeat.o(200703);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
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