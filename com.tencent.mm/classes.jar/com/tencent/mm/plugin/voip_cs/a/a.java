package com.tencent.mm.plugin.voip_cs.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "audioPlayDevCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "mPcmRecListener", "com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1;", "player", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "recorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "enableSpeaker", "", "speakerOn", "", "getAudioPlayVolume", "", "getAudioPlayerStreamType", "getAudioRecordReadNum", "getCurrentStreamType", "isRingStop", "iniRecord", "initPlayer", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "startPlayAudio", "startRecordAudio", "stop", "switchSpeakerPhone", "unInit", "Companion", "plugin-voip-cs_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.e
{
  public static final a.a Cug;
  public com.tencent.mm.plugin.voip.model.c Cbr;
  private final c Cuf;
  public com.tencent.mm.audio.b.c oWf;
  private final com.tencent.mm.plugin.voip.model.b wbj;
  
  static
  {
    AppMethodBeat.i(192874);
    Cug = new a.a((byte)0);
    AppMethodBeat.o(192874);
  }
  
  public a()
  {
    AppMethodBeat.i(192873);
    this.wbj = ((com.tencent.mm.plugin.voip.model.b)b.Cuh);
    this.Cuf = new c();
    com.tencent.mm.plugin.audio.d.a.bGM();
    com.tencent.mm.plugin.audio.d.c.bGM();
    this.oWf = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    Object localObject = this.oWf;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).hO(20);
    }
    localObject = this.oWf;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).cv(true);
    }
    localObject = this.oWf;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).PN();
    }
    localObject = this.oWf;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).t(1, false);
    }
    localObject = this.oWf;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).cu(true);
    }
    localObject = this.oWf;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).a((c.a)this.Cuf);
    }
    this.Cbr = new com.tencent.mm.plugin.voip.model.c();
    localObject = this.Cbr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).M(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
    }
    localObject = this.Cbr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).C(aj.getContext(), false);
    }
    localObject = this.Cbr;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).a(this.wbj);
    }
    localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voipcs");
    AppMethodBeat.o(192873);
  }
  
  private final boolean tb(boolean paramBoolean)
  {
    AppMethodBeat.i(192868);
    if (this.Cbr != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.Cbr;
      if (localc == null) {
        p.gfZ();
      }
      paramBoolean = localc.tb(paramBoolean);
      AppMethodBeat.o(192868);
      return paramBoolean;
    }
    AppMethodBeat.o(192868);
    return false;
  }
  
  private final void tx(boolean paramBoolean)
  {
    AppMethodBeat.i(192869);
    ad.l("MicroMsg.cs.VoIPCsAudioManager", "enableSpeaker: ".concat(String.valueOf(paramBoolean)), new Object[0]);
    ad.d("MicroMsg.cs.VoIPCsAudioManager", "MMCore.getAudioManager() " + bGB());
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    localObject = com.tencent.mm.plugin.audio.d.a.nrY;
    if (com.tencent.mm.plugin.audio.d.a.bGD()) {}
    for (boolean bool = false;; bool = paramBoolean)
    {
      if (ae.gcF.fWh)
      {
        ae.gcF.dump();
        if (ae.gcF.fWi > 0) {
          tb(bool);
        }
      }
      if ((ae.gcF.fWK >= 0) || (ae.gcF.fWL >= 0)) {
        tb(paramBoolean);
      }
      if (this.Cbr != null)
      {
        localObject = this.Cbr;
        if (localObject == null) {
          p.gfZ();
        }
        a(paramBoolean, ((com.tencent.mm.plugin.voip.model.c)localObject).aNs(), false);
        com.tencent.mm.plugin.voip_cs.c.c.eBB().tn(paramBoolean);
      }
      AppMethodBeat.o(192869);
      return;
    }
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(192867);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.VM("voipcs");
    AppMethodBeat.o(192867);
  }
  
  public final void Ob()
  {
    AppMethodBeat.i(192871);
    if (!bGx())
    {
      Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      localObject = com.tencent.mm.plugin.audio.d.a.nrY;
      if (!com.tencent.mm.plugin.audio.d.a.bGD()) {}
    }
    else
    {
      b("voipcs", Integer.valueOf(4));
      tx(false);
      AppMethodBeat.o(192871);
      return;
    }
    b("voipcs", Integer.valueOf(1));
    tx(true);
    AppMethodBeat.o(192871);
  }
  
  public final void hC(int paramInt)
  {
    AppMethodBeat.i(192872);
    super.hC(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192872);
      return;
      VJ("voipcs");
      tx(true);
      AppMethodBeat.o(192872);
      return;
      tx(false);
      AppMethodBeat.o(192872);
      return;
      tx(false);
      Toast.makeText(aj.getContext(), (CharSequence)aj.getContext().getString(2131764936), 0).show();
      AppMethodBeat.o(192872);
      return;
      tx(true);
      Toast.makeText(aj.getContext(), (CharSequence)aj.getContext().getString(2131764937), 0).show();
    }
  }
  
  public final int tN(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(192870);
    Object localObject = com.tencent.mm.plugin.audio.c.a.nrV;
    localObject = com.tencent.mm.plugin.audio.d.a.nrY;
    if (com.tencent.mm.plugin.audio.d.a.bGD())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.nrV;
      i = com.tencent.mm.plugin.audio.c.a.a.bGC().bGy();
    }
    for (;;)
    {
      ad.d("MicroMsg.cs.VoIPCsAudioManager", "Current StreamType:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(192870);
      return i;
      if (!paramBoolean)
      {
        localObject = com.tencent.mm.plugin.voip_cs.c.c.eBC();
        p.g(localObject, "SubCoreVoipCS.getVoipCSService()");
        if ((((com.tencent.mm.plugin.voip_cs.c.e)localObject).eBI() != 2) && (this.Cbr != null))
        {
          localObject = this.Cbr;
          if (localObject == null) {
            p.gfZ();
          }
          i = ((com.tencent.mm.plugin.voip.model.c)localObject).aNs();
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "pcm", "", "kotlin.jvm.PlatformType", "len", "PlayDevDataCallBack"})
  static final class b
    implements com.tencent.mm.plugin.voip.model.b
  {
    public static final b Cuh;
    
    static
    {
      AppMethodBeat.i(192864);
      Cuh = new b();
      AppMethodBeat.o(192864);
    }
    
    public final int O(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(192863);
      ad.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.eBB();
      p.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      paramInt = locala.eBW().playCallback(paramArrayOfByte, paramInt);
      if (paramInt != 0) {
        ad.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + paramArrayOfByte.length + ",ret:" + paramInt);
      }
      if (paramInt != 0)
      {
        AppMethodBeat.o(192863);
        return 1;
      }
      AppMethodBeat.o(192863);
      return 0;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder$OnPcmRecListener;", "onRecError", "", "state", "", "detailState", "onRecPcmDataReady", "pcm", "", "len", "plugin-voip-cs_release"})
  public static final class c
    implements c.a
  {
    public final void ch(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192866);
      ad.i("MicroMsg.cs.VoIPCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(192866);
    }
    
    public final void u(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(192865);
      p.h(paramArrayOfByte, "pcm");
      if (paramInt <= 0)
      {
        ad.e("MicroMsg.cs.VoIPCsAudioManager", "pcm data len <= 0");
        AppMethodBeat.o(192865);
        return;
      }
      ad.d("MicroMsg.cs.VoIPCsAudioManager", "onRecPcmDataReady,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.eBB();
      p.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      ad.d("MicroMsg.cs.VoIPCsAudioManager", "recordCallback,ret:".concat(String.valueOf(locala.eBW().recordCallback(paramArrayOfByte, paramInt, 200))));
      AppMethodBeat.o(192865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.a.a
 * JD-Core Version:    0.7.0.1
 */