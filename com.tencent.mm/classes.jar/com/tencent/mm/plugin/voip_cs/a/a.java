package com.tencent.mm.plugin.voip_cs.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "audioPlayDevCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "mPcmRecListener", "com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1;", "player", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "recorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "enableSpeaker", "", "speakerOn", "", "getAudioPlayVolume", "", "getAudioPlayerStreamType", "getAudioRecordReadNum", "getCurrentStreamType", "isRingStop", "iniRecord", "initPlayer", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "startPlayAudio", "startRecordAudio", "stop", "switchSpeakerPhone", "unInit", "Companion", "plugin-voip-cs_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.e
{
  public static final a.a CLK;
  private final c CLJ;
  public com.tencent.mm.plugin.voip.model.c CsS;
  public com.tencent.mm.audio.b.c pcI;
  private final com.tencent.mm.plugin.voip.model.b wqI;
  
  static
  {
    AppMethodBeat.i(193503);
    CLK = new a.a((byte)0);
    AppMethodBeat.o(193503);
  }
  
  public a()
  {
    AppMethodBeat.i(193502);
    this.wqI = ((com.tencent.mm.plugin.voip.model.b)b.CLL);
    this.CLJ = new c();
    com.tencent.mm.plugin.audio.d.a.bHI();
    com.tencent.mm.plugin.audio.d.c.bHI();
    this.pcI = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    Object localObject = this.pcI;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).hQ(20);
    }
    localObject = this.pcI;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).cv(true);
    }
    localObject = this.pcI;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).PM();
    }
    localObject = this.pcI;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).t(1, false);
    }
    localObject = this.pcI;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).cu(true);
    }
    localObject = this.pcI;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).a((c.a)this.CLJ);
    }
    this.CsS = new com.tencent.mm.plugin.voip.model.c();
    localObject = this.CsS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).M(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
    }
    localObject = this.CsS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).C(ak.getContext(), false);
    }
    localObject = this.CsS;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).a(this.wqI);
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voipcs");
    AppMethodBeat.o(193502);
  }
  
  private final void tE(boolean paramBoolean)
  {
    AppMethodBeat.i(193498);
    com.tencent.mm.sdk.platformtools.ae.l("MicroMsg.cs.VoIPCsAudioManager", "enableSpeaker: ".concat(String.valueOf(paramBoolean)), new Object[0]);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.cs.VoIPCsAudioManager", "MMCore.getAudioManager() " + bHx());
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    localObject = com.tencent.mm.plugin.audio.d.a.nxr;
    if (com.tencent.mm.plugin.audio.d.a.bHz()) {}
    for (boolean bool = false;; bool = paramBoolean)
    {
      if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYn)
      {
        com.tencent.mm.compatible.deviceinfo.ae.geN.dump();
        if (com.tencent.mm.compatible.deviceinfo.ae.geN.fYo > 0) {
          ti(bool);
        }
      }
      if ((com.tencent.mm.compatible.deviceinfo.ae.geN.fYQ >= 0) || (com.tencent.mm.compatible.deviceinfo.ae.geN.fYR >= 0)) {
        ti(paramBoolean);
      }
      if (this.CsS != null)
      {
        localObject = this.CsS;
        if (localObject == null) {
          p.gkB();
        }
        a(paramBoolean, ((com.tencent.mm.plugin.voip.model.c)localObject).aNQ(), false);
        com.tencent.mm.plugin.voip_cs.c.c.eFj().tu(paramBoolean);
      }
      AppMethodBeat.o(193498);
      return;
    }
  }
  
  private final boolean ti(boolean paramBoolean)
  {
    AppMethodBeat.i(193497);
    if (this.CsS != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.CsS;
      if (localc == null) {
        p.gkB();
      }
      paramBoolean = localc.ti(paramBoolean);
      AppMethodBeat.o(193497);
      return paramBoolean;
    }
    AppMethodBeat.o(193497);
    return false;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(193496);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.Wy("voipcs");
    AppMethodBeat.o(193496);
  }
  
  public final void NZ()
  {
    AppMethodBeat.i(193500);
    if (!bHt())
    {
      Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      localObject = com.tencent.mm.plugin.audio.d.a.nxr;
      if (!com.tencent.mm.plugin.audio.d.a.bHz()) {}
    }
    else
    {
      b("voipcs", Integer.valueOf(4));
      tE(false);
      AppMethodBeat.o(193500);
      return;
    }
    b("voipcs", Integer.valueOf(1));
    tE(true);
    AppMethodBeat.o(193500);
  }
  
  public final void hE(int paramInt)
  {
    AppMethodBeat.i(193501);
    super.hE(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(193501);
      return;
      Wv("voipcs");
      tE(true);
      AppMethodBeat.o(193501);
      return;
      tE(false);
      AppMethodBeat.o(193501);
      return;
      tE(false);
      Toast.makeText(ak.getContext(), (CharSequence)ak.getContext().getString(2131764936), 0).show();
      AppMethodBeat.o(193501);
      return;
      tE(true);
      Toast.makeText(ak.getContext(), (CharSequence)ak.getContext().getString(2131764937), 0).show();
    }
  }
  
  public final int tU(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(193499);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nxo;
    localObject = com.tencent.mm.plugin.audio.d.a.nxr;
    if (com.tencent.mm.plugin.audio.d.a.bHz())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nxo;
      i = com.tencent.mm.plugin.audio.c.a.a.bHy().bHu();
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.cs.VoIPCsAudioManager", "Current StreamType:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(193499);
      return i;
      if (!paramBoolean)
      {
        localObject = com.tencent.mm.plugin.voip_cs.c.c.eFk();
        p.g(localObject, "SubCoreVoipCS.getVoipCSService()");
        if ((((com.tencent.mm.plugin.voip_cs.c.e)localObject).eFq() != 2) && (this.CsS != null))
        {
          localObject = this.CsS;
          if (localObject == null) {
            p.gkB();
          }
          i = ((com.tencent.mm.plugin.voip.model.c)localObject).aNQ();
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "pcm", "", "kotlin.jvm.PlatformType", "len", "PlayDevDataCallBack"})
  static final class b
    implements com.tencent.mm.plugin.voip.model.b
  {
    public static final b CLL;
    
    static
    {
      AppMethodBeat.i(193493);
      CLL = new b();
      AppMethodBeat.o(193493);
    }
    
    public final int O(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(193492);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.eFj();
      p.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      paramInt = locala.eFE().playCallback(paramArrayOfByte, paramInt);
      if (paramInt != 0) {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + paramArrayOfByte.length + ",ret:" + paramInt);
      }
      if (paramInt != 0)
      {
        AppMethodBeat.o(193492);
        return 1;
      }
      AppMethodBeat.o(193492);
      return 0;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder$OnPcmRecListener;", "onRecError", "", "state", "", "detailState", "onRecPcmDataReady", "pcm", "", "len", "plugin-voip-cs_release"})
  public static final class c
    implements c.a
  {
    public final void ch(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193495);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.cs.VoIPCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(193495);
    }
    
    public final void u(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(193494);
      p.h(paramArrayOfByte, "pcm");
      if (paramInt <= 0)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.cs.VoIPCsAudioManager", "pcm data len <= 0");
        AppMethodBeat.o(193494);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.cs.VoIPCsAudioManager", "onRecPcmDataReady,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.eFj();
      p.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.cs.VoIPCsAudioManager", "recordCallback,ret:".concat(String.valueOf(locala.eFE().recordCallback(paramArrayOfByte, paramInt, 200))));
      AppMethodBeat.o(193494);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.a.a
 * JD-Core Version:    0.7.0.1
 */