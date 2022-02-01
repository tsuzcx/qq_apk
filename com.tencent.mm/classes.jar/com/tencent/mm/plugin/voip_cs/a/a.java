package com.tencent.mm.plugin.voip_cs.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "audioPlayDevCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "mPcmRecListener", "com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1;", "player", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "recorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "enableSpeaker", "", "speakerOn", "", "getAudioPlayVolume", "", "getAudioPlayerStreamType", "getAudioRecordReadNum", "getCurrentStreamType", "isRingStop", "iniRecord", "initPlayer", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "startPlayAudio", "startRecordAudio", "stop", "switchSpeakerPhone", "unInit", "Companion", "plugin-voip-cs_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.e
{
  public static final a.a Oim;
  private final com.tencent.mm.plugin.voip.model.b FrC;
  public com.tencent.mm.plugin.voip.model.c NMO;
  private final c Oil;
  public com.tencent.mm.audio.b.c tQq;
  
  static
  {
    AppMethodBeat.i(213218);
    Oim = new a.a((byte)0);
    AppMethodBeat.o(213218);
  }
  
  public a()
  {
    AppMethodBeat.i(213215);
    this.FrC = ((com.tencent.mm.plugin.voip.model.b)b.Oin);
    this.Oil = new c();
    com.tencent.mm.plugin.audio.d.b.crG();
    d.crG();
    this.tQq = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    Object localObject = this.tQq;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).kD(20);
    }
    localObject = this.tQq;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).dD(true);
    }
    localObject = this.tQq;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).aeR();
    }
    localObject = this.tQq;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).z(1, false);
    }
    localObject = this.tQq;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).dC(true);
    }
    localObject = this.tQq;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).a((c.a)this.Oil);
    }
    this.NMO = new com.tencent.mm.plugin.voip.model.c();
    localObject = this.NMO;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).S(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
    }
    localObject = this.NMO;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).K(MMApplicationContext.getContext(), false);
    }
    localObject = this.NMO;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).a(this.FrC);
    }
    localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voipcs");
    AppMethodBeat.o(213215);
  }
  
  private final boolean AK(boolean paramBoolean)
  {
    AppMethodBeat.i(213192);
    if (this.NMO != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.NMO;
      if (localc == null) {
        p.iCn();
      }
      paramBoolean = localc.AK(paramBoolean);
      AppMethodBeat.o(213192);
      return paramBoolean;
    }
    AppMethodBeat.o(213192);
    return false;
  }
  
  private final void Bg(boolean paramBoolean)
  {
    AppMethodBeat.i(213195);
    Log.printDebugStack("MicroMsg.cs.VoIPCsAudioManager", "enableSpeaker: ".concat(String.valueOf(paramBoolean)), new Object[0]);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    localObject = com.tencent.mm.plugin.audio.d.b.rKe;
    if (com.tencent.mm.plugin.audio.d.b.cro()) {}
    for (boolean bool = false;; bool = paramBoolean)
    {
      if (af.juI.jnK)
      {
        af.juI.Y();
        if (af.juI.jnL > 0) {
          AK(bool);
        }
      }
      if ((af.juI.jor >= 0) || (af.juI.jos >= 0)) {
        AK(paramBoolean);
      }
      if (this.NMO != null)
      {
        localObject = this.NMO;
        if (localObject == null) {
          p.iCn();
        }
        a(paramBoolean, ((com.tencent.mm.plugin.voip.model.c)localObject).gxF(), false);
        com.tencent.mm.plugin.voip_cs.c.c.gEV().AW(paramBoolean);
      }
      AppMethodBeat.o(213195);
      return;
    }
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(213189);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.anX("voipcs");
    AppMethodBeat.o(213189);
  }
  
  public final int Bw(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(213199);
    Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
    localObject = com.tencent.mm.plugin.audio.d.b.rKe;
    if (com.tencent.mm.plugin.audio.d.b.cro())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      i = com.tencent.mm.plugin.audio.c.a.a.crn().cri();
    }
    for (;;)
    {
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "Current StreamType:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(213199);
      return i;
      if (!paramBoolean)
      {
        localObject = com.tencent.mm.plugin.voip_cs.c.c.gEW();
        p.j(localObject, "SubCoreVoipCS.getVoipCSService()");
        if ((((com.tencent.mm.plugin.voip_cs.c.e)localObject).gFc() != 2) && (this.NMO != null))
        {
          localObject = this.NMO;
          if (localObject == null) {
            p.iCn();
          }
          i = ((com.tencent.mm.plugin.voip.model.c)localObject).gxF();
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public final void acR()
  {
    AppMethodBeat.i(213207);
    if (!crh())
    {
      Object localObject = com.tencent.mm.plugin.audio.c.a.rJX;
      localObject = com.tencent.mm.plugin.audio.d.b.rKe;
      if (!com.tencent.mm.plugin.audio.d.b.cro()) {}
    }
    else
    {
      b("voipcs", Integer.valueOf(4));
      Bg(false);
      AppMethodBeat.o(213207);
      return;
    }
    b("voipcs", Integer.valueOf(1));
    Bg(true);
    AppMethodBeat.o(213207);
  }
  
  public final void ko(int paramInt)
  {
    AppMethodBeat.i(213211);
    super.ko(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(213211);
      return;
      anT("voipcs");
      Bg(true);
      AppMethodBeat.o(213211);
      return;
      Bg(false);
      AppMethodBeat.o(213211);
      return;
      Bg(false);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(a.e.voip_voice_come_from_earpiece), 0).show();
      AppMethodBeat.o(213211);
      return;
      Bg(true);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(a.e.voip_voice_come_from_speaker), 0).show();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pcm", "", "kotlin.jvm.PlatformType", "len", "PlayDevDataCallBack"})
  static final class b
    implements com.tencent.mm.plugin.voip.model.b
  {
    public static final b Oin;
    
    static
    {
      AppMethodBeat.i(214070);
      Oin = new b();
      AppMethodBeat.o(214070);
    }
    
    public final int R(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(214069);
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.gEV();
      p.j(locala, "SubCoreVoipCS.getVoipCSEngine()");
      paramInt = locala.gFq().playCallback(paramArrayOfByte, paramInt);
      if (paramInt != 0) {
        Log.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + paramArrayOfByte.length + ",ret:" + paramInt);
      }
      if (paramInt != 0)
      {
        AppMethodBeat.o(214069);
        return 1;
      }
      AppMethodBeat.o(214069);
      return 0;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder$OnPcmRecListener;", "onRecError", "", "state", "", "detailState", "onRecPcmDataReady", "pcm", "", "len", "plugin-voip-cs_release"})
  public static final class c
    implements c.a
  {
    public final void cC(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(214103);
      Log.i("MicroMsg.cs.VoIPCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(214103);
    }
    
    public final void w(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(214101);
      p.k(paramArrayOfByte, "pcm");
      if (paramInt <= 0)
      {
        Log.e("MicroMsg.cs.VoIPCsAudioManager", "pcm data len <= 0");
        AppMethodBeat.o(214101);
        return;
      }
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "onRecPcmDataReady,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.gEV();
      p.j(locala, "SubCoreVoipCS.getVoipCSEngine()");
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "recordCallback,ret:".concat(String.valueOf(locala.gFq().recordCallback(paramArrayOfByte, paramInt, 200))));
      AppMethodBeat.o(214101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.a.a
 * JD-Core Version:    0.7.0.1
 */