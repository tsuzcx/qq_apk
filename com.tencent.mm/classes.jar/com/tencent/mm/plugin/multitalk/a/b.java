package com.tencent.mm.plugin.multitalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.c.a.a;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.ui.widget.n;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "innerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getInnerPlayer", "()Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "setInnerPlayer", "(Lcom/tencent/mm/plugin/voip/model/AudioPlayer;)V", "isSpeakerSetFailed", "", "()Z", "setSpeakerSetFailed", "(Z)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "checkCurrentIsSpeakerMute", "checkRingPlayStop", "enableSpeakerOn", "value", "getAudioPlayErrState", "", "getAudioPlayerStreamType", "getCurrentStreamType", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "isAvailable", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "", "status", "refreshHandFree", "releaseAudioDeviceCauseStopRing", "releaseAudioPlayingDevice", "requestAudioDeviceToStartRing", "isCallingParty", "type", "requestAudioPlayingDevice", "setSpeakerPhoneOnInternal", "isSpeakerPhoneOn", "tryRequestBluetoothDevice", "turnVolumeDown", "turnVolumeUp", "unInit", "Companion", "plugin-multitalk_release"})
public class b
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final b.a Fmn;
  public c Fmm;
  public e kHI;
  private com.tencent.mm.compatible.util.b mlj;
  public boolean tQg;
  
  static
  {
    AppMethodBeat.i(199622);
    Fmn = new b.a((byte)0);
    AppMethodBeat.o(199622);
  }
  
  public b()
  {
    AppMethodBeat.i(199621);
    this.kHI = new e(MMApplicationContext.getContext());
    this.mlj = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    a.a.a((com.tencent.mm.plugin.audio.b.a)this, "multitalke");
    com.tencent.mm.plugin.audio.d.b.crG();
    d.crG();
    com.tencent.mm.plugin.audio.broadcast.bluetooth.a.anS("multitalke");
    this.mlj.avy();
    if (crk())
    {
      if (Ez(4))
      {
        b("multitalke", Integer.valueOf(4));
        AppMethodBeat.o(199621);
        return;
      }
      b("multitalke", Integer.valueOf(3));
      AppMethodBeat.o(199621);
      return;
    }
    b("multitalke", Integer.valueOf(2));
    AppMethodBeat.o(199621);
  }
  
  public static int eJJ()
  {
    AppMethodBeat.i(199594);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    localObject = com.tencent.mm.plugin.audio.d.b.rKe;
    if (com.tencent.mm.plugin.audio.d.b.cro())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      int i = a.a.crn().cri();
      AppMethodBeat.o(199594);
      return i;
    }
    localObject = ad.eYc();
    p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((com.tencent.mm.plugin.multitalk.model.q)localObject).cNL())
    {
      AppMethodBeat.o(199594);
      return 3;
    }
    AppMethodBeat.o(199594);
    return 0;
  }
  
  public static void eVi()
  {
    AppMethodBeat.i(199578);
    if ((Ez(3)) || (Ez(4)))
    {
      ad.eYc().uA(false);
      AppMethodBeat.o(199578);
      return;
    }
    ad.eYc().uA(true);
    AppMethodBeat.o(199578);
  }
  
  private void eVl()
  {
    AppMethodBeat.i(199596);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    localObject = com.tencent.mm.plugin.audio.d.b.rKe;
    if (com.tencent.mm.plugin.audio.d.b.crr()) {
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "tryRequestBluetoothDevice, ret:".concat(String.valueOf(b("multitalke", Integer.valueOf(4)))));
    }
    AppMethodBeat.o(199596);
  }
  
  public static boolean eVn()
  {
    AppMethodBeat.i(199618);
    boolean bool = ad.eYb().eVn();
    AppMethodBeat.o(199618);
    return bool;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(199571);
    a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    a.a.anX("multitalke");
    AppMethodBeat.o(199571);
  }
  
  public final void aa(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(199585);
    if (paramInt == 0) {
      if (!crd())
      {
        Log.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing ignore bluetooth or not bt plug");
        this.kHI.M(a.g.phonering, 1, paramBoolean);
      }
    }
    for (;;)
    {
      eVl();
      AppMethodBeat.o(199585);
      return;
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing but waitting the bt connected");
      B((kotlin.g.a.b)new b(this, paramBoolean));
      continue;
      B(null);
      this.kHI.i(a.g.close_lower_volume, false, 1);
    }
  }
  
  public final void acR()
  {
    AppMethodBeat.i(199601);
    eVl();
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(Ez(3)), Boolean.valueOf(Ez(4)), Integer.valueOf(hashCode()) });
    if (!crk())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      if (!com.tencent.mm.plugin.audio.d.b.crr()) {}
    }
    else
    {
      ad.eYc().uA(false);
      if (!Ez(4))
      {
        localObject = com.tencent.mm.plugin.audio.c.a.rJX;
        localObject = com.tencent.mm.plugin.audio.d.b.rKe;
        if (!com.tencent.mm.plugin.audio.d.b.crr()) {}
      }
      else
      {
        b("multitalke", Integer.valueOf(4));
      }
      for (;;)
      {
        ad.eYb().uC(false);
        ad.eYb().uB(true);
        this.mlj.avy();
        AppMethodBeat.o(199601);
        return;
        if (Ez(3)) {
          b("multitalke", Integer.valueOf(3));
        }
      }
    }
    Object localObject = ad.eYc();
    p.j(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((com.tencent.mm.plugin.multitalk.model.q)localObject).eXe())
    {
      b("multitalke", Integer.valueOf(1));
      ad.eYb().uC(true);
    }
    for (;;)
    {
      ad.eYb().uB(false);
      break;
      b("multitalke", Integer.valueOf(2));
      ad.eYb().uC(false);
    }
  }
  
  public final int eVj()
  {
    AppMethodBeat.i(199579);
    c localc = this.Fmm;
    if (localc != null)
    {
      int i = localc.gxE();
      AppMethodBeat.o(199579);
      return i;
    }
    AppMethodBeat.o(199579);
    return 0;
  }
  
  public final void eVk()
  {
    AppMethodBeat.i(199589);
    B(null);
    this.kHI.stop();
    this.mlj.avz();
    AppMethodBeat.o(199589);
  }
  
  public final void eVm()
  {
    AppMethodBeat.i(199602);
    crg();
    anT("multitalke");
    this.mlj.avz();
    AppMethodBeat.o(199602);
  }
  
  public void ko(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(199617);
    super.ko(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(199617);
      return;
    case 2: 
      ad.eYc().uA(false);
      ds(false);
      ad.eYc().uM(false);
      ad.eYb().uB(true);
      ad.eYb().uC(false);
      ad.eYd().setVoicePlayDevice(4);
      AppMethodBeat.o(199617);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      localq = ad.eYc();
      p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      if ((localq.cNL()) && (!Ez(3)))
      {
        bool1 = true;
        localq = ad.eYc();
        p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        bool2 = bool1;
        if (localq.cNL())
        {
          bool2 = bool1;
          if (!Ez(3))
          {
            localq = ad.eYc();
            p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
            bool2 = localq.eXI();
          }
        }
        if (!Ez(3)) {
          break label387;
        }
        ad.eYb().uB(true);
        bool1 = Ez(3);
        localq = ad.eYc();
        p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        bool3 = localq.eXe();
        localq = ad.eYc();
        p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool4 = localq.eXI();
        localq = ad.eYc();
        p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
        Log.i("MicroMsg.MT.MultiTalkAudioManager", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(localq.cNL()), Boolean.valueOf(Ez(4)), Boolean.valueOf(bool2) });
        ad.eYc().uM(bool2);
        ad.eYb().uB(false);
        if (!Ez(3)) {
          break label397;
        }
        ad.eYc().uA(false);
        ad.eYb().uB(true);
      }
      for (;;)
      {
        if (!bool2) {
          break label407;
        }
        ad.eYd().setVoicePlayDevice(1);
        AppMethodBeat.o(199617);
        return;
        bool1 = false;
        break;
        ad.eYb().uC(bool2);
        break label210;
        ad.eYc().uA(true);
      }
      if (Ez(3))
      {
        ad.eYd().setVoicePlayDevice(3);
        AppMethodBeat.o(199617);
        return;
      }
      ad.eYd().setVoicePlayDevice(2);
      AppMethodBeat.o(199617);
      return;
    case 8: 
      label210:
      localq = ad.eYc();
      label387:
      label397:
      label407:
      p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      bool1 = localq.eXe();
      localq = ad.eYc();
      p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      bool2 = localq.eXI();
      localq = ad.eYc();
      p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug connected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localq.cNL()), Boolean.valueOf(Ez(3)) });
      ad.eYc().uA(false);
      ad.eYc().uM(false);
      ad.eYd().setVoicePlayDevice(3);
      ad.eYb().uB(true);
      ad.eYb().uC(false);
      AppMethodBeat.o(199617);
      return;
    }
    com.tencent.mm.plugin.multitalk.model.q localq = ad.eYc();
    p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool1 = localq.eXe();
    localq = ad.eYc();
    p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool3 = localq.eXI();
    localq = ad.eYc();
    p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug disconnected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(localq.cNL()), Boolean.valueOf(Ez(4)) });
    localq = ad.eYc();
    p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localq.cNL())
    {
      localq = ad.eYc();
      p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
    }
    for (bool1 = localq.eXI();; bool1 = true)
    {
      ad.eYb().uB(false);
      if (Ez(4))
      {
        ad.eYb().uB(true);
        bool1 = bool2;
      }
      for (;;)
      {
        if (bool1) {
          ad.eYd().setVoicePlayDevice(1);
        }
        for (;;)
        {
          ad.eYc().uM(bool1);
          ad.eYc().uA(true);
          ad.eYb().uC(bool1);
          break;
          if (Ez(4)) {
            ad.eYd().setVoicePlayDevice(4);
          } else {
            ad.eYd().setVoicePlayDevice(2);
          }
        }
      }
    }
  }
  
  public final boolean uw(boolean paramBoolean)
  {
    boolean bool2 = false;
    AppMethodBeat.i(199575);
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    kA(paramBoolean);
    c localc = this.Fmm;
    boolean bool1 = bool2;
    if (localc != null)
    {
      bool1 = bool2;
      if (localc.isPlaying() == true)
      {
        localc = this.Fmm;
        if (localc == null) {
          p.iCn();
        }
        bool1 = localc.AK(paramBoolean);
      }
    }
    this.tQg = bool1;
    paramBoolean = this.tQg;
    AppMethodBeat.o(199575);
    return paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    b(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.b
 * JD-Core Version:    0.7.0.1
 */