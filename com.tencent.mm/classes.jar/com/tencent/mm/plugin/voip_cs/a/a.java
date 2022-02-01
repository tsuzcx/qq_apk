package com.tencent.mm.plugin.voip_cs.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "audioPlayDevCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "mPcmRecListener", "com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1;", "player", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "recorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "enableSpeaker", "", "speakerOn", "", "getAudioPlayVolume", "", "getAudioPlayerStreamType", "getAudioRecordReadNum", "getCurrentStreamType", "isRingStop", "iniRecord", "initPlayer", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "startPlayAudio", "startRecordAudio", "stop", "switchSpeakerPhone", "unInit", "Companion", "plugin-voip-cs_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.e
{
  public static final a.a ATY;
  public com.tencent.mm.plugin.voip.model.c ACs;
  private final c ATX;
  public com.tencent.mm.audio.b.c osJ;
  private final com.tencent.mm.plugin.voip.model.b uWY;
  
  static
  {
    AppMethodBeat.i(205760);
    ATY = new a.a((byte)0);
    AppMethodBeat.o(205760);
  }
  
  public a()
  {
    AppMethodBeat.i(205759);
    this.uWY = ((com.tencent.mm.plugin.voip.model.b)b.ATZ);
    this.ATX = new c();
    com.tencent.mm.plugin.audio.d.a.bCE();
    com.tencent.mm.plugin.audio.d.c.bCE();
    this.osJ = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    Object localObject = this.osJ;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).hH(20);
    }
    localObject = this.osJ;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).ct(true);
    }
    localObject = this.osJ;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).Oe();
    }
    localObject = this.osJ;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).t(1, false);
    }
    localObject = this.osJ;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).cs(true);
    }
    localObject = this.osJ;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).a((c.a)this.ATX);
    }
    this.ACs = new com.tencent.mm.plugin.voip.model.c();
    localObject = this.ACs;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).M(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
    }
    localObject = this.ACs;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).A(ai.getContext(), false);
    }
    localObject = this.ACs;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).a(this.uWY);
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voipcs");
    AppMethodBeat.o(205759);
  }
  
  private final void sN(boolean paramBoolean)
  {
    AppMethodBeat.i(205755);
    ac.l("MicroMsg.cs.VoIPCsAudioManager", "enableSpeaker: ".concat(String.valueOf(paramBoolean)), new Object[0]);
    ac.d("MicroMsg.cs.VoIPCsAudioManager", "MMCore.getAudioManager() " + bCw());
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    localObject = com.tencent.mm.plugin.audio.d.a.mRz;
    if (com.tencent.mm.plugin.audio.d.a.bCy()) {}
    for (boolean bool = false;; bool = paramBoolean)
    {
      if (ae.fJe.fCT)
      {
        ae.fJe.dump();
        if (ae.fJe.fCU > 0) {
          ss(bool);
        }
      }
      if ((ae.fJe.fDw >= 0) || (ae.fJe.fDx >= 0)) {
        ss(paramBoolean);
      }
      if (this.ACs != null)
      {
        localObject = this.ACs;
        if (localObject == null) {
          k.fOy();
        }
        a(paramBoolean, ((com.tencent.mm.plugin.voip.model.c)localObject).aKj(), false);
        com.tencent.mm.plugin.voip_cs.c.c.enC().sE(paramBoolean);
      }
      AppMethodBeat.o(205755);
      return;
    }
  }
  
  private final boolean ss(boolean paramBoolean)
  {
    AppMethodBeat.i(205754);
    if (this.ACs != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.ACs;
      if (localc == null) {
        k.fOy();
      }
      paramBoolean = localc.ss(paramBoolean);
      AppMethodBeat.o(205754);
      return paramBoolean;
    }
    AppMethodBeat.o(205754);
    return false;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(205753);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.So("voipcs");
    AppMethodBeat.o(205753);
  }
  
  public final void Ms()
  {
    AppMethodBeat.i(205757);
    if (!bCs())
    {
      Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      localObject = com.tencent.mm.plugin.audio.d.a.mRz;
      if (!com.tencent.mm.plugin.audio.d.a.bCy()) {}
    }
    else
    {
      b("voipcs", Integer.valueOf(4));
      sN(false);
      AppMethodBeat.o(205757);
      return;
    }
    b("voipcs", Integer.valueOf(1));
    sN(true);
    AppMethodBeat.o(205757);
  }
  
  public final void hv(int paramInt)
  {
    AppMethodBeat.i(205758);
    super.hv(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(205758);
      return;
      Sl("voipcs");
      sN(true);
      AppMethodBeat.o(205758);
      return;
      sN(false);
      AppMethodBeat.o(205758);
      return;
      sN(false);
      Toast.makeText(ai.getContext(), (CharSequence)ai.getContext().getString(2131764936), 0).show();
      AppMethodBeat.o(205758);
      return;
      sN(true);
      Toast.makeText(ai.getContext(), (CharSequence)ai.getContext().getString(2131764937), 0).show();
    }
  }
  
  public final int td(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(205756);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mRw;
    localObject = com.tencent.mm.plugin.audio.d.a.mRz;
    if (com.tencent.mm.plugin.audio.d.a.bCy())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mRw;
      i = com.tencent.mm.plugin.audio.c.a.a.bCx().bCt();
    }
    for (;;)
    {
      ac.d("MicroMsg.cs.VoIPCsAudioManager", "Current StreamType:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(205756);
      return i;
      if (!paramBoolean)
      {
        localObject = com.tencent.mm.plugin.voip_cs.c.c.enD();
        k.g(localObject, "SubCoreVoipCS.getVoipCSService()");
        if ((((com.tencent.mm.plugin.voip_cs.c.e)localObject).enJ() != 2) && (this.ACs != null))
        {
          localObject = this.ACs;
          if (localObject == null) {
            k.fOy();
          }
          i = ((com.tencent.mm.plugin.voip.model.c)localObject).aKj();
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "pcm", "", "kotlin.jvm.PlatformType", "len", "PlayDevDataCallBack"})
  static final class b
    implements com.tencent.mm.plugin.voip.model.b
  {
    public static final b ATZ;
    
    static
    {
      AppMethodBeat.i(205750);
      ATZ = new b();
      AppMethodBeat.o(205750);
    }
    
    public final int O(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(205749);
      ac.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.enC();
      k.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      paramInt = locala.enX().playCallback(paramArrayOfByte, paramInt);
      if (paramInt != 0) {
        ac.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + paramArrayOfByte.length + ",ret:" + paramInt);
      }
      if (paramInt != 0)
      {
        AppMethodBeat.o(205749);
        return 1;
      }
      AppMethodBeat.o(205749);
      return 0;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder$OnPcmRecListener;", "onRecError", "", "state", "", "detailState", "onRecPcmDataReady", "pcm", "", "len", "plugin-voip-cs_release"})
  public static final class c
    implements c.a
  {
    public final void cf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205752);
      ac.i("MicroMsg.cs.VoIPCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(205752);
    }
    
    public final void u(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(205751);
      k.h(paramArrayOfByte, "pcm");
      if (paramInt <= 0)
      {
        ac.e("MicroMsg.cs.VoIPCsAudioManager", "pcm data len <= 0");
        AppMethodBeat.o(205751);
        return;
      }
      ac.d("MicroMsg.cs.VoIPCsAudioManager", "onRecPcmDataReady,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.enC();
      k.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      ac.d("MicroMsg.cs.VoIPCsAudioManager", "recordCallback,ret:".concat(String.valueOf(locala.enX().recordCallback(paramArrayOfByte, paramInt, 200))));
      AppMethodBeat.o(205751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.a.a
 * JD-Core Version:    0.7.0.1
 */