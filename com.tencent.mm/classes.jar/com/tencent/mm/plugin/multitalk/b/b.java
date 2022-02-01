package com.tencent.mm.plugin.multitalk.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "innerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getInnerPlayer", "()Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "setInnerPlayer", "(Lcom/tencent/mm/plugin/voip/model/AudioPlayer;)V", "isSpeakerSetFailed", "", "()Z", "setSpeakerSetFailed", "(Z)V", "checkCurrentIsSpeakerMute", "checkRingPlayStop", "enableSpeakerOn", "value", "getAudioPlayErrState", "", "getAudioPlayerStreamType", "getCurrentStreamType", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "isAvailable", "isHeadsetOrBluetoothPlugged", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "", "status", "playRingSound", "refreshHandFree", "releaseAudioDeviceCauseStopRing", "releaseAudioPlayingDevice", "requestAudioDeviceToStartRing", "isCallingParty", "type", "requestAudioPlayingDevice", "setSpeakerPhoneOnInternal", "isSpeakerPhoneOn", "startMultitalkRing", "isOutCall", "stopMultitalkRing", "tryRequestBluetoothDevice", "turnVolumeDown", "turnVolumeUp", "unInit", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final b.a Liq;
  public com.tencent.mm.plugin.voip.model.c Lir;
  private com.tencent.mm.compatible.util.b peV;
  public boolean wTx;
  
  static
  {
    AppMethodBeat.i(284686);
    Liq = new b.a((byte)0);
    AppMethodBeat.o(284686);
  }
  
  public b()
  {
    AppMethodBeat.i(284624);
    this.peV = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "multitalke");
    com.tencent.mm.plugin.audio.d.b.cUq();
    d.cUq();
    com.tencent.mm.plugin.audio.broadcast.bluetooth.a.ahp("multitalke");
    this.peV.requestFocus();
    localObject = com.tencent.mm.plugin.ringtone.c.OBr;
    if (com.tencent.mm.plugin.ringtone.c.gOh())
    {
      if (cTT())
      {
        if (Fa(4))
        {
          b("multitalke", Integer.valueOf(4));
          AppMethodBeat.o(284624);
          return;
        }
        b("multitalke", Integer.valueOf(3));
        AppMethodBeat.o(284624);
        return;
      }
      b("multitalke", Integer.valueOf(1));
    }
    AppMethodBeat.o(284624);
  }
  
  public static int fwf()
  {
    AppMethodBeat.i(284664);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject = com.tencent.mm.plugin.audio.d.b.uVo;
    int i;
    if (com.tencent.mm.plugin.audio.d.b.cTX())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      i = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();
      AppMethodBeat.o(284664);
      return i;
    }
    if ((!ac.ggS().dro()) && (com.tencent.mm.plugin.ringtone.c.gOk()))
    {
      i = ((com.tencent.mm.plugin.ringtone.a)h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType();
      AppMethodBeat.o(284664);
      return i;
    }
    if (!ac.ggS().dro())
    {
      AppMethodBeat.o(284664);
      return 3;
    }
    AppMethodBeat.o(284664);
    return 0;
  }
  
  public static void gdV()
  {
    AppMethodBeat.i(284637);
    Bundle localBundle = new Bundle();
    localBundle.putString("scene", "close");
    ((com.tencent.mm.plugin.ringtone.a)h.ax(com.tencent.mm.plugin.ringtone.a.class)).responseSence(com.tencent.mm.plugin.ringtone.a.a.OBe, localBundle);
    AppMethodBeat.o(284637);
  }
  
  public static void gdW()
  {
    AppMethodBeat.i(284650);
    if ((Fa(3)) || (Fa(4)))
    {
      ac.ggS().yP(false);
      AppMethodBeat.o(284650);
      return;
    }
    ac.ggS().yP(true);
    AppMethodBeat.o(284650);
  }
  
  public static boolean gdX()
  {
    AppMethodBeat.i(284653);
    if ((Fa(3)) || (Fa(4)))
    {
      AppMethodBeat.o(284653);
      return true;
    }
    AppMethodBeat.o(284653);
    return false;
  }
  
  public static boolean gea()
  {
    AppMethodBeat.i(284660);
    if (((com.tencent.mm.plugin.ringtone.a)h.ax(com.tencent.mm.plugin.ringtone.a.class)).checkPlayerStatus() == 9)
    {
      AppMethodBeat.o(284660);
      return true;
    }
    AppMethodBeat.o(284660);
    return false;
  }
  
  private void gec()
  {
    AppMethodBeat.i(284669);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject = com.tencent.mm.plugin.audio.d.b.uVo;
    if (com.tencent.mm.plugin.audio.d.b.cUa()) {
      Log.i("MicroMsg.MT.MultiTalkAudioManager", s.X("tryRequestBluetoothDevice, ret:", Integer.valueOf(b("multitalke", Integer.valueOf(4)))));
    }
    AppMethodBeat.o(284669);
  }
  
  public static boolean gee()
  {
    AppMethodBeat.i(284673);
    boolean bool = ac.ggR().LnL;
    AppMethodBeat.o(284673);
    return bool;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(284645);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.ahu("multitalke");
    AppMethodBeat.o(284645);
  }
  
  public static void yI(boolean paramBoolean)
  {
    AppMethodBeat.i(284629);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOutCall", paramBoolean);
    localBundle.putString("scene", "start");
    ((com.tencent.mm.plugin.ringtone.a)h.ax(com.tencent.mm.plugin.ringtone.a.class)).responseSence(com.tencent.mm.plugin.ringtone.a.a.OBe, localBundle);
    AppMethodBeat.o(284629);
  }
  
  public final void aER()
  {
    AppMethodBeat.i(284717);
    gec();
    boolean bool1 = Fa(3);
    boolean bool2 = Fa(4);
    boolean bool3 = cTT();
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject = com.tencent.mm.plugin.audio.d.b.uVo;
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b, isUsingExternalAudioDevice:%b, isBluetoothCanUse:%b, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(com.tencent.mm.plugin.audio.d.b.cUa()), Integer.valueOf(hashCode()) });
    if (!cTT())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      if (!com.tencent.mm.plugin.audio.d.b.cUa()) {}
    }
    else
    {
      ac.ggS().yP(false);
      if (!Fa(4))
      {
        localObject = com.tencent.mm.plugin.audio.c.a.uVi;
        localObject = com.tencent.mm.plugin.audio.d.b.uVo;
        if (!com.tencent.mm.plugin.audio.d.b.cUa()) {}
      }
      else
      {
        b("multitalke", Integer.valueOf(4));
      }
      for (;;)
      {
        ac.ggR().yR(false);
        ac.ggR().yQ(true);
        this.peV.requestFocus();
        AppMethodBeat.o(284717);
        return;
        if (Fa(3)) {
          b("multitalke", Integer.valueOf(3));
        }
      }
    }
    if (ac.ggS().snA)
    {
      b("multitalke", Integer.valueOf(1));
      ac.ggR().yR(true);
    }
    for (;;)
    {
      ac.ggR().yQ(false);
      break;
      b("multitalke", Integer.valueOf(2));
      ac.ggR().yR(false);
    }
  }
  
  public final void ac(final boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(284703);
    if (paramInt == 0) {
      if (!cTL())
      {
        Log.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing ignore bluetooth or not bt plug");
        yI(paramBoolean);
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        localObject = com.tencent.mm.plugin.ringtone.c.OBr;
        if (!com.tencent.mm.plugin.ringtone.c.gOh()) {}
      }
      else
      {
        gec();
      }
      AppMethodBeat.o(284703);
      return;
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing but waitting the bt connected");
      ad((kotlin.g.a.b)new b(this, paramBoolean));
      continue;
      ad(null);
      Object localObject = new Bundle();
      ((Bundle)localObject).putString("scene", "end");
      ((Bundle)localObject).putInt("streamType", gdZ());
      ((com.tencent.mm.plugin.ringtone.a)h.ax(com.tencent.mm.plugin.ringtone.a.class)).responseSence(com.tencent.mm.plugin.ringtone.a.a.OBe, (Bundle)localObject);
    }
  }
  
  public final int gdY()
  {
    AppMethodBeat.i(284695);
    com.tencent.mm.plugin.voip.model.c localc = this.Lir;
    if (localc == null)
    {
      AppMethodBeat.o(284695);
      return 0;
    }
    int i = localc.hVG();
    AppMethodBeat.o(284695);
    return i;
  }
  
  public final int gdZ()
  {
    AppMethodBeat.i(284698);
    com.tencent.mm.plugin.voip.model.c localc = this.Lir;
    if (localc == null)
    {
      AppMethodBeat.o(284698);
      return 0;
    }
    int i = localc.gdZ();
    AppMethodBeat.o(284698);
    return i;
  }
  
  public final void geb()
  {
    AppMethodBeat.i(284711);
    ad(null);
    gdV();
    AppMethodBeat.o(284711);
  }
  
  public final void ged()
  {
    AppMethodBeat.i(284719);
    cTP();
    ee(false);
    ahq("multitalke");
    this.peV.aPS();
    AppMethodBeat.o(284719);
  }
  
  public void nW(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(284724);
    super.nW(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(284724);
      return;
    case 2: 
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "qipeng, BCT_BT_ScoStateConnected");
      ac.ggS().yP(false);
      ee(false);
      ac.ggS().zb(false);
      ac.ggR().yQ(true);
      ac.ggR().yR(false);
      ac.ggT().setVoicePlayDevice(4);
      AppMethodBeat.o(284724);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "qipeng, BCT_BT_ScoStateDisconnected");
      if ((ac.ggS().dro()) && (!Fa(3)))
      {
        bool1 = true;
        bool2 = bool1;
        if (ac.ggS().dro())
        {
          bool2 = bool1;
          if (!Fa(3)) {
            bool2 = ac.ggS().Loc;
          }
        }
        if (!Fa(3)) {
          break label330;
        }
        ac.ggR().yQ(true);
        Log.i("MicroMsg.MT.MultiTalkAudioManager", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", new Object[] { Boolean.valueOf(Fa(3)), Boolean.valueOf(ac.ggS().snA), Boolean.valueOf(ac.ggS().Loc), Boolean.valueOf(ac.ggS().dro()), Boolean.valueOf(Fa(4)), Boolean.valueOf(bool2) });
        ac.ggS().zb(bool2);
        ac.ggR().yQ(false);
        if (!Fa(3)) {
          break label340;
        }
        ac.ggS().yP(false);
        ac.ggR().yQ(true);
      }
      for (;;)
      {
        if (!bool2) {
          break label350;
        }
        ac.ggT().setVoicePlayDevice(1);
        AppMethodBeat.o(284724);
        return;
        bool1 = false;
        break;
        ac.ggR().yR(bool2);
        break label195;
        ac.ggS().yP(true);
      }
      if (Fa(3))
      {
        ac.ggT().setVoicePlayDevice(3);
        AppMethodBeat.o(284724);
        return;
      }
      ac.ggT().setVoicePlayDevice(2);
      AppMethodBeat.o(284724);
      return;
    case 8: 
      label195:
      label330:
      label340:
      label350:
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "qipeng, BCT_HP_HeadsetPlugged");
      Log.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug connected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(ac.ggS().snA), Boolean.valueOf(ac.ggS().Loc), Boolean.valueOf(ac.ggS().dro()), Boolean.valueOf(Fa(3)) });
      ac.ggS().yP(false);
      ac.ggS().zb(false);
      ac.ggT().setVoicePlayDevice(3);
      ac.ggR().yQ(true);
      ac.ggR().yR(false);
      AppMethodBeat.o(284724);
      return;
    }
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "qipeng, BCT_HP_HeadsetUnPlugged");
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug disconnected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(ac.ggS().snA), Boolean.valueOf(ac.ggS().Loc), Boolean.valueOf(ac.ggS().dro()), Boolean.valueOf(Fa(4)) });
    if (ac.ggS().dro()) {}
    for (boolean bool1 = ac.ggS().Loc;; bool1 = true)
    {
      ac.ggR().yQ(false);
      if (Fa(4))
      {
        ac.ggR().yQ(true);
        bool1 = bool2;
      }
      for (;;)
      {
        if (bool1) {
          ac.ggT().setVoicePlayDevice(1);
        }
        for (;;)
        {
          ac.ggS().zb(bool1);
          ac.ggS().yP(true);
          ac.ggR().yR(bool1);
          break;
          if (Fa(4)) {
            ac.ggT().setVoicePlayDevice(4);
          } else {
            ac.ggT().setVoicePlayDevice(2);
          }
        }
      }
    }
  }
  
  public final boolean yJ(boolean paramBoolean)
  {
    int i = 1;
    boolean bool = false;
    AppMethodBeat.i(284690);
    Log.i("MicroMsg.MT.MultiTalkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    lN(paramBoolean);
    com.tencent.mm.plugin.voip.model.c localc = this.Lir;
    if ((localc != null) && (localc.UvL == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localc = this.Lir;
        s.checkNotNull(localc);
        bool = localc.Gj(paramBoolean);
      }
      this.wTx = bool;
      paramBoolean = this.wTx;
      AppMethodBeat.o(284690);
      return paramBoolean;
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(b paramb, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.b
 * JD-Core Version:    0.7.0.1
 */