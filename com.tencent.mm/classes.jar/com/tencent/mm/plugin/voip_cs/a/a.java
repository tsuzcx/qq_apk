package com.tencent.mm.plugin.voip_cs.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "audioPlayDevCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "mPcmRecListener", "com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1;", "player", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "recorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "enableSpeaker", "", "speakerOn", "", "getAudioPlayVolume", "", "getAudioPlayerStreamType", "getAudioRecordReadNum", "getCurrentStreamType", "isRingStop", "iniRecord", "initPlayer", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "startPlayAudio", "startRecordAudio", "stop", "switchSpeakerPhone", "unInit", "Companion", "plugin-voip-cs_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.audio.b.e
{
  public static final a.a UWH;
  private final com.tencent.mm.plugin.voip.model.b LnP;
  private final b UWI;
  public com.tencent.mm.plugin.voip.model.c UzC;
  public com.tencent.mm.audio.b.c wTG;
  
  static
  {
    AppMethodBeat.i(263889);
    UWH = new a.a((byte)0);
    AppMethodBeat.o(263889);
  }
  
  public a()
  {
    AppMethodBeat.i(263880);
    this.LnP = a..ExternalSyntheticLambda0.INSTANCE;
    this.UWI = new b();
    com.tencent.mm.plugin.audio.d.b.cUq();
    d.cUq();
    this.wTG = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    Object localObject = this.wTG;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).ok(20);
    }
    localObject = this.wTG;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).ep(true);
    }
    localObject = this.wTG;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).aGP();
    }
    localObject = this.wTG;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).O(1, false);
    }
    localObject = this.wTG;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).eo(true);
    }
    localObject = this.wTG;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).hwy = ((c.a)this.UWI);
    }
    this.UzC = new com.tencent.mm.plugin.voip.model.c();
    localObject = this.UzC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).ac(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
    }
    localObject = this.UzC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).R(MMApplicationContext.getContext(), false);
    }
    localObject = this.UzC;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).UvX = this.LnP;
    }
    localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voipcs");
    AppMethodBeat.o(263880);
  }
  
  private final void GK(boolean paramBoolean)
  {
    AppMethodBeat.i(263884);
    Log.printDebugStack("MicroMsg.cs.VoIPCsAudioManager", s.X("enableSpeaker: ", Boolean.valueOf(paramBoolean)), new Object[0]);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject = com.tencent.mm.plugin.audio.d.b.uVo;
    if (com.tencent.mm.plugin.audio.d.b.cTX()) {}
    for (boolean bool = false;; bool = paramBoolean)
    {
      if (af.lXZ.lQS)
      {
        af.lXZ.aQ();
        if (af.lXZ.lQT > 0) {
          Gj(bool);
        }
      }
      if ((af.lXZ.lRz >= 0) || (af.lXZ.lRA >= 0)) {
        Gj(paramBoolean);
      }
      if (this.UzC != null)
      {
        localObject = this.UzC;
        s.checkNotNull(localObject);
        a(paramBoolean, ((com.tencent.mm.plugin.voip.model.c)localObject).gdZ(), false);
        localObject = com.tencent.mm.plugin.voip_cs.model.c.idW();
        if (!paramBoolean) {
          break label172;
        }
      }
      label172:
      for (int i = ((com.tencent.mm.plugin.voip_cs.model.b.a)localObject).UYC.setAppCmd(401);; i = ((com.tencent.mm.plugin.voip_cs.model.b.a)localObject).UYC.setAppCmd(402))
      {
        if (i < 0) {
          g.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(i)));
        }
        AppMethodBeat.o(263884);
        return;
      }
    }
  }
  
  private final boolean Gj(boolean paramBoolean)
  {
    AppMethodBeat.i(263883);
    if (this.UzC != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.UzC;
      s.checkNotNull(localc);
      paramBoolean = localc.Gj(paramBoolean);
      AppMethodBeat.o(263883);
      return paramBoolean;
    }
    AppMethodBeat.o(263883);
    return false;
  }
  
  private static final int ag(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(263885);
    Log.d("MicroMsg.cs.VoIPCsAudioManager", s.X("PlayDevDataCallBack,pcm data len:", Integer.valueOf(paramArrayOfByte.length)));
    paramInt = com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.playCallback(paramArrayOfByte, paramInt);
    if (paramInt != 0) {
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + paramArrayOfByte.length + ",ret:" + paramInt);
    }
    if (paramInt != 0)
    {
      AppMethodBeat.o(263885);
      return 1;
    }
    AppMethodBeat.o(263885);
    return 0;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(263881);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.ahu("voipcs");
    AppMethodBeat.o(263881);
  }
  
  public final int Hc(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(263891);
    Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
    localObject = com.tencent.mm.plugin.audio.d.b.uVo;
    if (com.tencent.mm.plugin.audio.d.b.cTX())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      i = com.tencent.mm.plugin.audio.c.a.a.cTW().cTR();
    }
    for (;;)
    {
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "Current StreamType:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(263891);
      return i;
      if (!paramBoolean) {
        if ((com.tencent.mm.plugin.voip_cs.model.c.idX().UXR != 2) && (this.UzC != null))
        {
          localObject = this.UzC;
          s.checkNotNull(localObject);
          i = ((com.tencent.mm.plugin.voip.model.c)localObject).gdZ();
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public final void aER()
  {
    AppMethodBeat.i(263892);
    if (!cTQ())
    {
      Object localObject = com.tencent.mm.plugin.audio.c.a.uVi;
      localObject = com.tencent.mm.plugin.audio.d.b.uVo;
      if (!com.tencent.mm.plugin.audio.d.b.cTX()) {}
    }
    else
    {
      b("voipcs", Integer.valueOf(4));
      GK(false);
      AppMethodBeat.o(263892);
      return;
    }
    b("voipcs", Integer.valueOf(1));
    GK(true);
    AppMethodBeat.o(263892);
  }
  
  public final void nW(int paramInt)
  {
    AppMethodBeat.i(263895);
    super.nW(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(263895);
      return;
      ahq("voipcs");
      GK(true);
      AppMethodBeat.o(263895);
      return;
      GK(false);
      AppMethodBeat.o(263895);
      return;
      GK(false);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(a.e.voip_voice_come_from_earpiece), 0).show();
      AppMethodBeat.o(263895);
      return;
      GK(true);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(a.e.voip_voice_come_from_speaker), 0).show();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder$OnPcmRecListener;", "onRecError", "", "state", "", "detailState", "onRecPcmDataReady", "pcm", "", "len", "plugin-voip-cs_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c.a
  {
    public final void ds(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(263879);
      Log.i("MicroMsg.cs.VoIPCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(263879);
    }
    
    public final void u(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(263877);
      s.u(paramArrayOfByte, "pcm");
      if (paramInt <= 0)
      {
        Log.e("MicroMsg.cs.VoIPCsAudioManager", "pcm data len <= 0");
        AppMethodBeat.o(263877);
        return;
      }
      Log.d("MicroMsg.cs.VoIPCsAudioManager", s.X("onRecPcmDataReady,pcm data len:", Integer.valueOf(paramArrayOfByte.length)));
      Log.d("MicroMsg.cs.VoIPCsAudioManager", s.X("recordCallback,ret:", Integer.valueOf(com.tencent.mm.plugin.voip_cs.model.c.idW().UYC.recordCallback(paramArrayOfByte, paramInt, 200))));
      AppMethodBeat.o(263877);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.a.a
 * JD-Core Version:    0.7.0.1
 */