package com.tencent.mm.plugin.voip_cs.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "audioPlayDevCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "mPcmRecListener", "com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1;", "player", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "recorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "enableSpeaker", "", "speakerOn", "", "getAudioPlayVolume", "", "getAudioPlayerStreamType", "getAudioRecordReadNum", "getCurrentStreamType", "isRingStop", "iniRecord", "initPlayer", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "startPlayAudio", "startRecordAudio", "stop", "switchSpeakerPhone", "unInit", "Companion", "plugin-voip-cs_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.e
{
  public static final a.a zBK;
  public com.tencent.mm.audio.b.c nPF;
  private final com.tencent.mm.plugin.voip.model.b tOv;
  private final c zBJ;
  public com.tencent.mm.plugin.voip.model.c zjI;
  
  static
  {
    AppMethodBeat.i(190849);
    zBK = new a.a((byte)0);
    AppMethodBeat.o(190849);
  }
  
  public a()
  {
    AppMethodBeat.i(190848);
    com.tencent.mm.plugin.audio.d.a.bvI();
    com.tencent.mm.plugin.audio.d.c.bvI();
    this.nPF = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    Object localObject = this.nPF;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).hX(20);
    }
    localObject = this.nPF;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).cs(true);
    }
    localObject = this.nPF;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).Oi();
    }
    localObject = this.nPF;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).t(1, false);
    }
    localObject = this.nPF;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).cr(true);
    }
    localObject = this.nPF;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).a((c.a)this.zBJ);
    }
    this.zjI = new com.tencent.mm.plugin.voip.model.c();
    localObject = this.zjI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).K(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
    }
    localObject = this.zjI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).z(aj.getContext(), false);
    }
    localObject = this.zjI;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).a(this.tOv);
    }
    localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voipcs");
    this.zBJ = new c();
    this.tOv = ((com.tencent.mm.plugin.voip.model.b)b.zBL);
    AppMethodBeat.o(190848);
  }
  
  public static void NX()
  {
    AppMethodBeat.i(190842);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.Oe("voipcs");
    AppMethodBeat.o(190842);
  }
  
  private final void rM(boolean paramBoolean)
  {
    AppMethodBeat.i(190844);
    ad.l("MicroMsg.cs.VoIPCsAudioManager", "enableSpeaker: ".concat(String.valueOf(paramBoolean)), new Object[0]);
    ad.d("MicroMsg.cs.VoIPCsAudioManager", "MMCore.getAudioManager() " + bvA());
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    localObject = com.tencent.mm.plugin.audio.d.a.mpy;
    if (com.tencent.mm.plugin.audio.d.a.bvC()) {}
    for (boolean bool = false;; bool = paramBoolean)
    {
      if (ae.fFx.fzm)
      {
        ae.fFx.dump();
        if (ae.fFx.fzn > 0) {
          rr(bool);
        }
      }
      if ((ae.fFx.fzP >= 0) || (ae.fFx.fzQ >= 0)) {
        rr(paramBoolean);
      }
      if (this.zjI != null)
      {
        localObject = this.zjI;
        if (localObject == null) {
          k.fvU();
        }
        a(paramBoolean, ((com.tencent.mm.plugin.voip.model.c)localObject).aDs(), false);
        com.tencent.mm.plugin.voip_cs.c.c.dYg().rD(paramBoolean);
      }
      AppMethodBeat.o(190844);
      return;
    }
  }
  
  private final boolean rr(boolean paramBoolean)
  {
    AppMethodBeat.i(190843);
    if (this.zjI != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.zjI;
      if (localc == null) {
        k.fvU();
      }
      paramBoolean = localc.rr(paramBoolean);
      AppMethodBeat.o(190843);
      return paramBoolean;
    }
    AppMethodBeat.o(190843);
    return false;
  }
  
  public final void Mu()
  {
    AppMethodBeat.i(190846);
    if (!bvw())
    {
      Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      localObject = com.tencent.mm.plugin.audio.d.a.mpy;
      if (!com.tencent.mm.plugin.audio.d.a.bvC()) {}
    }
    else
    {
      b("voipcs", Integer.valueOf(4));
      rM(false);
      AppMethodBeat.o(190846);
      return;
    }
    b("voipcs", Integer.valueOf(1));
    rM(true);
    AppMethodBeat.o(190846);
  }
  
  public final void hL(int paramInt)
  {
    AppMethodBeat.i(190847);
    super.hL(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190847);
      return;
      Oc("voipcs");
      rM(true);
      AppMethodBeat.o(190847);
      return;
      rM(false);
      AppMethodBeat.o(190847);
      return;
      rM(false);
      Toast.makeText(aj.getContext(), (CharSequence)aj.getContext().getString(2131764936), 0).show();
      AppMethodBeat.o(190847);
      return;
      rM(true);
      Toast.makeText(aj.getContext(), (CharSequence)aj.getContext().getString(2131764937), 0).show();
    }
  }
  
  public final int sc(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(190845);
    Object localObject = com.tencent.mm.plugin.audio.c.a.mpv;
    localObject = com.tencent.mm.plugin.audio.d.a.mpy;
    if (com.tencent.mm.plugin.audio.d.a.bvC())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.mpv;
      i = com.tencent.mm.plugin.audio.c.a.a.bvB().bvx();
    }
    for (;;)
    {
      ad.d("MicroMsg.cs.VoIPCsAudioManager", "Current StreamType:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(190845);
      return i;
      if (!paramBoolean)
      {
        localObject = com.tencent.mm.plugin.voip_cs.c.c.dYh();
        k.g(localObject, "SubCoreVoipCS.getVoipCSService()");
        if ((((com.tencent.mm.plugin.voip_cs.c.e)localObject).dYn() != 2) && (this.zjI != null))
        {
          localObject = this.zjI;
          if (localObject == null) {
            k.fvU();
          }
          i = ((com.tencent.mm.plugin.voip.model.c)localObject).aDs();
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "pcm", "", "kotlin.jvm.PlatformType", "len", "PlayDevDataCallBack"})
  static final class b
    implements com.tencent.mm.plugin.voip.model.b
  {
    public static final b zBL;
    
    static
    {
      AppMethodBeat.i(190839);
      zBL = new b();
      AppMethodBeat.o(190839);
    }
    
    public final int Q(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(190838);
      ad.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.dYg();
      k.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      paramInt = locala.dYB().playCallback(paramArrayOfByte, paramInt);
      if (paramInt != 0) {
        ad.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + paramArrayOfByte.length + ",ret:" + paramInt);
      }
      if (paramInt != 0)
      {
        AppMethodBeat.o(190838);
        return 1;
      }
      AppMethodBeat.o(190838);
      return 0;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder$OnPcmRecListener;", "onRecError", "", "state", "", "detailState", "onRecPcmDataReady", "pcm", "", "len", "plugin-voip-cs_release"})
  public static final class c
    implements c.a
  {
    public final void ch(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(190841);
      ad.i("MicroMsg.cs.VoIPCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(190841);
    }
    
    public final void w(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(190840);
      k.h(paramArrayOfByte, "pcm");
      if (paramInt <= 0)
      {
        ad.e("MicroMsg.cs.VoIPCsAudioManager", "pcm data len <= 0");
        AppMethodBeat.o(190840);
        return;
      }
      ad.d("MicroMsg.cs.VoIPCsAudioManager", "onRecPcmDataReady,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.dYg();
      k.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      ad.d("MicroMsg.cs.VoIPCsAudioManager", "recordCallback,ret:".concat(String.valueOf(locala.dYB().recordCallback(paramArrayOfByte, paramInt, 200))));
      AppMethodBeat.o(190840);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.a.a
 * JD-Core Version:    0.7.0.1
 */