package com.tencent.mm.plugin.multitalk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/ilinkservice/audio/ILinkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "isAvailable", "onAudioDeviceStateChanged", "", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", "channels", "duration", "stopPlay", "unInit", "Companion", "plugin-multitalk_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a wpA;
  public com.tencent.mm.compatible.util.b iAr;
  public com.tencent.mm.plugin.voip.model.c pcA;
  public boolean pcz;
  
  static
  {
    AppMethodBeat.i(190893);
    wpA = new a.a((byte)0);
    AppMethodBeat.o(190893);
  }
  
  public a()
  {
    AppMethodBeat.i(190892);
    this.iAr = new com.tencent.mm.compatible.util.b(ak.getContext());
    com.tencent.mm.plugin.audio.d.a.bHI();
    com.tencent.mm.plugin.audio.d.c.bHI();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "openvoice");
    AppMethodBeat.o(190892);
  }
  
  private final boolean oM(boolean paramBoolean)
  {
    AppMethodBeat.i(190890);
    com.tencent.mm.plugin.voip.model.c localc = this.pcA;
    if ((localc != null) && (localc.isPlaying() == true))
    {
      localc = this.pcA;
      if (localc == null) {
        p.gkB();
      }
      paramBoolean = localc.ti(paramBoolean);
      AppMethodBeat.o(190890);
      return paramBoolean;
    }
    AppMethodBeat.o(190890);
    return false;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(190888);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.Wy("openvoice");
    AppMethodBeat.o(190888);
  }
  
  public final void hE(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(190891);
    super.hE(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(190891);
      return;
    case 2: 
      bool1 = this.pcz;
      this.pcz = (jG(false) & bool1);
      AppMethodBeat.o(190891);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      this.pcz &= jG(true);
      AppMethodBeat.o(190891);
      return;
    case 9: 
      ae.i("MicroMsg.ILinkAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(xs(4)) });
      if (!xs(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.pcz;
      this.pcz = (jG(bool1) & bool2);
      AppMethodBeat.o(190891);
      return;
      ae.i("MicroMsg.ILinkAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(xs(4)) });
      bool1 = this.pcz;
      this.pcz = (jG(false) & bool1);
      break;
      bool1 = true;
    }
  }
  
  public final boolean jG(boolean paramBoolean)
  {
    AppMethodBeat.i(190889);
    ae.i("MicroMsg.ILinkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    io(paramBoolean);
    paramBoolean = oM(paramBoolean);
    AppMethodBeat.o(190889);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.a.a
 * JD-Core Version:    0.7.0.1
 */