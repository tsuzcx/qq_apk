package com.tencent.mm.plugin.multitalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "innerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getInnerPlayer", "()Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "setInnerPlayer", "(Lcom/tencent/mm/plugin/voip/model/AudioPlayer;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "checkRingPlayStop", "", "enableSpeakerOn", "", "value", "getAudioPlayErrState", "", "getAudioPlayerStreamType", "getCurrentStreamType", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "status", "refreshHandFree", "releaseAudioDeviceCauseStopRing", "releaseAudioPlayingDevice", "requestAudioDeviceToStartRing", "isCallingParty", "type", "requestAudioPlayingDevice", "setSpeakerPhoneOnInternal", "isSpeakerPhoneOn", "turnVolumeDown", "turnVolumeUp", "unInit", "Companion", "plugin-multitalk_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a tOk;
  private com.tencent.mm.compatible.util.b hDB;
  public i sAC;
  public com.tencent.mm.plugin.voip.model.c tOj;
  
  static
  {
    AppMethodBeat.i(189974);
    tOk = new a.a((byte)0);
    AppMethodBeat.o(189974);
  }
  
  public a()
  {
    AppMethodBeat.i(189973);
    this.sAC = new i(aj.getContext());
    this.hDB = new com.tencent.mm.compatible.util.b(aj.getContext());
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "multitalke");
    com.tencent.mm.plugin.audio.d.a.bvI();
    com.tencent.mm.plugin.audio.d.c.bvI();
    this.hDB.requestFocus();
    if (bvz())
    {
      if (vQ(4))
      {
        b("multitalke", Integer.valueOf(4));
        AppMethodBeat.o(189973);
        return;
      }
      b("multitalke", Integer.valueOf(3));
      AppMethodBeat.o(189973);
      return;
    }
    b("multitalke", Integer.valueOf(2));
    AppMethodBeat.o(189973);
  }
  
  public static void NX()
  {
    AppMethodBeat.i(189964);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.Oe("multitalke");
    AppMethodBeat.o(189964);
  }
  
  public static int cHD()
  {
    AppMethodBeat.i(189969);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    localObject = com.tencent.mm.plugin.audio.d.a.mpy;
    if (com.tencent.mm.plugin.audio.d.a.bvC())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      int i = com.tencent.mm.plugin.audio.c.a.a.bvB().bvx();
      AppMethodBeat.o(189969);
      return i;
    }
    localObject = p.cSO();
    k.g(localObject, "SubCoreMultiTalk.getMultiTalkManager()");
    if (!((f)localObject).cSx())
    {
      AppMethodBeat.o(189969);
      return 3;
    }
    AppMethodBeat.o(189969);
    return 0;
  }
  
  public static void cRy()
  {
    AppMethodBeat.i(189966);
    if ((vQ(3)) || (vQ(4)))
    {
      p.cSO().nu(false);
      AppMethodBeat.o(189966);
      return;
    }
    p.cSO().nu(true);
    AppMethodBeat.o(189966);
  }
  
  public final void I(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(189967);
    if (paramInt == 0)
    {
      if (!this.mpg)
      {
        ad.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing ignore bluetooth or not bt plug");
        this.sAC.aE(1, paramBoolean);
        AppMethodBeat.o(189967);
        return;
      }
      ad.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing but waitting the bt connected");
      this.mpf = ((d.g.a.b)new b(this, paramBoolean));
      AppMethodBeat.o(189967);
      return;
    }
    this.mpf = null;
    this.sAC.Y(false, 1);
    AppMethodBeat.o(189967);
  }
  
  public final void Mu()
  {
    AppMethodBeat.i(189970);
    ad.i("MicroMsg.MT.MultiTalkAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", new Object[] { Boolean.valueOf(vQ(3)), Boolean.valueOf(vQ(4)), Integer.valueOf(hashCode()) });
    if (bvz())
    {
      p.cSO().nu(false);
      if (vQ(4)) {
        b("multitalke", Integer.valueOf(4));
      }
      for (;;)
      {
        p.cSN().nv(true);
        this.hDB.requestFocus();
        AppMethodBeat.o(189970);
        return;
        b("multitalke", Integer.valueOf(3));
      }
    }
    f localf = p.cSO();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localf.cSj()) {
      b("multitalke", Integer.valueOf(1));
    }
    for (;;)
    {
      p.cSN().nv(false);
      break;
      b("multitalke", Integer.valueOf(2));
    }
  }
  
  public final void cRA()
  {
    AppMethodBeat.i(189971);
    bvv();
    Oc("multitalke");
    this.hDB.XF();
    AppMethodBeat.o(189971);
  }
  
  public final void cRz()
  {
    AppMethodBeat.i(189968);
    this.mpf = null;
    this.sAC.stop();
    this.hDB.XF();
    AppMethodBeat.o(189968);
  }
  
  public final void hL(int paramInt)
  {
    AppMethodBeat.i(189972);
    super.hL(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(189972);
      return;
    case 2: 
      p.cSO().nu(false);
      ck(false);
      p.cSO().nD(false);
      p.cSN().nv(true);
      AppMethodBeat.o(189972);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      localf = p.cSO();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
      if ((localf.cSx()) && (!vQ(3)))
      {
        bool1 = true;
        localf = p.cSO();
        k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
        bool2 = bool1;
        if (localf.cSx())
        {
          bool2 = bool1;
          if (!vQ(3))
          {
            localf = p.cSO();
            k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
            bool2 = localf.cSA();
          }
        }
        if (!vQ(3)) {
          break label359;
        }
        p.cSN().nv(true);
        bool1 = vQ(3);
        localf = p.cSO();
        k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool3 = localf.cSj();
        localf = p.cSO();
        k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
        boolean bool4 = localf.cSA();
        localf = p.cSO();
        k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
        ad.i("MicroMsg.MT.MultiTalkAudioManager", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(localf.cSx()), Boolean.valueOf(vQ(4)), Boolean.valueOf(bool2) });
        p.cSO().nD(bool2);
        if (!vQ(3)) {
          break label369;
        }
        p.cSO().nu(false);
      }
      for (;;)
      {
        if (!bool2) {
          break label379;
        }
        com.tencent.mm.plugin.voip.c.dRR().setVoicePlayDevice(1);
        AppMethodBeat.o(189972);
        return;
        bool1 = false;
        break;
        p.cSN().nv(false);
        break label196;
        p.cSO().nu(true);
      }
      if (vQ(3))
      {
        com.tencent.mm.plugin.voip.c.dRR().setVoicePlayDevice(3);
        AppMethodBeat.o(189972);
        return;
      }
      com.tencent.mm.plugin.voip.c.dRR().setVoicePlayDevice(2);
      AppMethodBeat.o(189972);
      return;
    case 8: 
      label196:
      label359:
      label369:
      label379:
      localf = p.cSO();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
      bool1 = localf.cSj();
      localf = p.cSO();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
      bool2 = localf.cSA();
      localf = p.cSO();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
      ad.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug connected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localf.cSx()), Boolean.valueOf(vQ(3)) });
      p.cSO().nu(false);
      com.tencent.mm.plugin.voip.c.dRR().setVoicePlayDevice(3);
      p.cSO().nD(false);
      p.cSN().nv(true);
      AppMethodBeat.o(189972);
      return;
    }
    f localf = p.cSO();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool1 = localf.cSj();
    localf = p.cSO();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    boolean bool2 = localf.cSA();
    localf = p.cSO();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    ad.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug disconnected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(localf.cSx()), Boolean.valueOf(vQ(4)) });
    localf = p.cSO();
    k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    if (localf.cSx())
    {
      localf = p.cSO();
      k.g(localf, "SubCoreMultiTalk.getMultiTalkManager()");
    }
    for (bool1 = localf.cSA();; bool1 = true)
    {
      if (vQ(4)) {
        bool1 = false;
      }
      if (bool1) {
        com.tencent.mm.plugin.voip.c.dRR().setVoicePlayDevice(1);
      }
      for (;;)
      {
        p.cSO().nD(bool1);
        p.cSO().nu(true);
        p.cSN().nv(false);
        break;
        if (vQ(4)) {
          com.tencent.mm.plugin.voip.c.dRR().setVoicePlayDevice(4);
        } else {
          com.tencent.mm.plugin.voip.c.dRR().setVoicePlayDevice(2);
        }
      }
    }
  }
  
  public final void nr(boolean paramBoolean)
  {
    AppMethodBeat.i(189965);
    ad.i("MicroMsg.MT.MultiTalkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    hJ(paramBoolean);
    if (this.tOj != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.tOj;
      if (localc != null)
      {
        if (localc.isPlaying() == true)
        {
          localc = this.tOj;
          if (localc != null)
          {
            localc.rr(paramBoolean);
            AppMethodBeat.o(189965);
          }
        }
      }
      else
      {
        AppMethodBeat.o(189965);
        return;
      }
    }
    AppMethodBeat.o(189965);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.a
 * JD-Core Version:    0.7.0.1
 */