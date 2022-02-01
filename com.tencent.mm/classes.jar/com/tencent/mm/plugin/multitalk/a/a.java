package com.tencent.mm.plugin.multitalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "innerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getInnerPlayer", "()Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "setInnerPlayer", "(Lcom/tencent/mm/plugin/voip/model/AudioPlayer;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "checkCurrentIsSpeakerMute", "", "checkRingPlayStop", "enableSpeakerOn", "", "value", "getAudioPlayErrState", "", "getAudioPlayerStreamType", "getCurrentStreamType", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "status", "refreshHandFree", "releaseAudioDeviceCauseStopRing", "releaseAudioPlayingDevice", "requestAudioDeviceToStartRing", "isCallingParty", "type", "requestAudioPlayingDevice", "setSpeakerPhoneOnInternal", "isSpeakerPhoneOn", "turnVolumeDown", "turnVolumeUp", "unInit", "Companion", "plugin-multitalk_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a zHc;
  public e hTl;
  private com.tencent.mm.compatible.util.b jvG;
  public c zHb;
  
  static
  {
    AppMethodBeat.i(239553);
    zHc = new a.a((byte)0);
    AppMethodBeat.o(239553);
  }
  
  public a()
  {
    AppMethodBeat.i(239552);
    this.hTl = new e(MMApplicationContext.getContext());
    this.jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "multitalke");
    com.tencent.mm.plugin.audio.d.b.cet();
    d.cet();
    com.tencent.mm.plugin.audio.broadcast.bluetooth.a.agp("multitalke");
    this.jvG.requestFocus();
    if (cdZ())
    {
      if (AY(4))
      {
        b("multitalke", Integer.valueOf(4));
        AppMethodBeat.o(239552);
        return;
      }
      b("multitalke", Integer.valueOf(3));
      AppMethodBeat.o(239552);
      return;
    }
    b("multitalke", Integer.valueOf(2));
    AppMethodBeat.o(239552);
  }
  
  public static int eaL()
  {
    AppMethodBeat.i(239547);
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    localObject = com.tencent.mm.plugin.audio.d.b.oIo;
    if (com.tencent.mm.plugin.audio.d.b.ceb())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      int i = com.tencent.mm.plugin.audio.c.a.a.cea().cdX();
      AppMethodBeat.o(239547);
      return i;
    }
    localObject = ac.eom();
    p.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((com.tencent.mm.plugin.multitalk.model.q)localObject).czl())
    {
      AppMethodBeat.o(239547);
      return 3;
    }
    AppMethodBeat.o(239547);
    return 0;
  }
  
  public static boolean elC()
  {
    AppMethodBeat.i(239551);
    boolean bool = ac.eol().elC();
    AppMethodBeat.o(239551);
    return bool;
  }
  
  public static void elz()
  {
    AppMethodBeat.i(239544);
    if ((AY(3)) || (AY(4)))
    {
      ac.eom().rx(false);
      AppMethodBeat.o(239544);
      return;
    }
    ac.eom().rx(true);
    AppMethodBeat.o(239544);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(239542);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.agt("multitalke");
    AppMethodBeat.o(239542);
  }
  
  public final void P(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(239545);
    if (paramInt == 0)
    {
      if (!this.oHS)
      {
        Log.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing ignore bluetooth or not bt plug");
        this.hTl.bl(1, paramBoolean);
        AppMethodBeat.o(239545);
        return;
      }
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing but waitting the bt connected");
      this.oHR = ((kotlin.g.a.b)new b(this, paramBoolean));
      AppMethodBeat.o(239545);
      return;
    }
    this.oHR = null;
    this.hTl.g(2131689973, false, 1);
    AppMethodBeat.o(239545);
  }
  
  public final void Yl()
  {
    AppMethodBeat.i(239548);
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(AY(3)), Boolean.valueOf(AY(4)), Integer.valueOf(hashCode()) });
    if (cdZ())
    {
      ac.eom().rx(false);
      if (AY(4)) {
        b("multitalke", Integer.valueOf(4));
      }
      for (;;)
      {
        ac.eol().rz(false);
        ac.eol().ry(true);
        this.jvG.requestFocus();
        AppMethodBeat.o(239548);
        return;
        b("multitalke", Integer.valueOf(3));
      }
    }
    com.tencent.mm.plugin.multitalk.model.q localq = ac.eom();
    p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localq.enq())
    {
      b("multitalke", Integer.valueOf(1));
      ac.eol().rz(true);
    }
    for (;;)
    {
      ac.eol().ry(false);
      break;
      b("multitalke", Integer.valueOf(2));
      ac.eol().rz(false);
    }
  }
  
  public final void elA()
  {
    AppMethodBeat.i(239546);
    this.oHR = null;
    this.hTl.stop();
    this.jvG.apm();
    AppMethodBeat.o(239546);
  }
  
  public final void elB()
  {
    AppMethodBeat.i(239549);
    cdV();
    agq("multitalke");
    this.jvG.apm();
    AppMethodBeat.o(239549);
  }
  
  public final void iY(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(239550);
    super.iY(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(239550);
      return;
    case 2: 
      ac.eom().rx(false);
      cV(false);
      ac.eom().rJ(false);
      ac.eol().ry(true);
      ac.eol().rz(false);
      ac.eon().setVoicePlayDevice(4);
      AppMethodBeat.o(239550);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      localq = ac.eom();
      p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      if ((localq.czl()) && (!AY(3)))
      {
        bool1 = true;
        localq = ac.eom();
        p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        bool2 = bool1;
        if (localq.czl())
        {
          bool2 = bool1;
          if (!AY(3))
          {
            localq = ac.eom();
            p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
            bool2 = localq.enS();
          }
        }
        if (!AY(3)) {
          break label387;
        }
        ac.eol().ry(true);
        bool1 = AY(3);
        localq = ac.eom();
        p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        bool3 = localq.enq();
        localq = ac.eom();
        p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool4 = localq.enS();
        localq = ac.eom();
        p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        Log.i("MicroMsg.MT.MultiTalkAudioManager", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(localq.czl()), Boolean.valueOf(AY(4)), Boolean.valueOf(bool2) });
        ac.eom().rJ(bool2);
        ac.eol().ry(false);
        if (!AY(3)) {
          break label397;
        }
        ac.eom().rx(false);
        ac.eol().ry(true);
      }
      for (;;)
      {
        if (!bool2) {
          break label407;
        }
        ac.eon().setVoicePlayDevice(1);
        AppMethodBeat.o(239550);
        return;
        bool1 = false;
        break;
        ac.eol().rz(bool2);
        break label210;
        ac.eom().rx(true);
      }
      if (AY(3))
      {
        ac.eon().setVoicePlayDevice(3);
        AppMethodBeat.o(239550);
        return;
      }
      ac.eon().setVoicePlayDevice(2);
      AppMethodBeat.o(239550);
      return;
    case 8: 
      label210:
      localq = ac.eom();
      label387:
      label397:
      label407:
      p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      bool1 = localq.enq();
      localq = ac.eom();
      p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      bool2 = localq.enS();
      localq = ac.eom();
      p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug connected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localq.czl()), Boolean.valueOf(AY(3)) });
      ac.eom().rx(false);
      ac.eom().rJ(false);
      ac.eon().setVoicePlayDevice(3);
      ac.eol().ry(true);
      ac.eol().rz(false);
      AppMethodBeat.o(239550);
      return;
    }
    com.tencent.mm.plugin.multitalk.model.q localq = ac.eom();
    p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool1 = localq.enq();
    localq = ac.eom();
    p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool3 = localq.enS();
    localq = ac.eom();
    p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug disconnected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(localq.czl()), Boolean.valueOf(AY(4)) });
    localq = ac.eom();
    p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localq.czl())
    {
      localq = ac.eom();
      p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    }
    for (bool1 = localq.enS();; bool1 = true)
    {
      ac.eol().ry(false);
      if (AY(4))
      {
        ac.eol().ry(true);
        bool1 = bool2;
      }
      for (;;)
      {
        if (bool1) {
          ac.eon().setVoicePlayDevice(1);
        }
        for (;;)
        {
          ac.eom().rJ(bool1);
          ac.eom().rx(true);
          ac.eol().rz(bool1);
          break;
          if (AY(4)) {
            ac.eon().setVoicePlayDevice(4);
          } else {
            ac.eon().setVoicePlayDevice(2);
          }
        }
      }
    }
  }
  
  public final void rs(boolean paramBoolean)
  {
    AppMethodBeat.i(239543);
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    jp(paramBoolean);
    if (this.zHb != null)
    {
      c localc = this.zHb;
      if (localc != null)
      {
        if (localc.isPlaying() == true)
        {
          localc = this.zHb;
          if (localc != null)
          {
            localc.wS(paramBoolean);
            AppMethodBeat.o(239543);
          }
        }
      }
      else
      {
        AppMethodBeat.o(239543);
        return;
      }
    }
    AppMethodBeat.o(239543);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
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