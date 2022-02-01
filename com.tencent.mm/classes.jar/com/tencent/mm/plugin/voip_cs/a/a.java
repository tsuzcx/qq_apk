package com.tencent.mm.plugin.voip_cs.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "audioPlayDevCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "mPcmRecListener", "com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1;", "player", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "recorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "enableSpeaker", "", "speakerOn", "", "getAudioPlayVolume", "", "getAudioPlayerStreamType", "getAudioRecordReadNum", "getCurrentStreamType", "isRingStop", "iniRecord", "initPlayer", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "startPlayAudio", "startRecordAudio", "stop", "switchSpeakerPhone", "unInit", "Companion", "plugin-voip-cs_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.e
{
  public static final a.a HqB;
  public com.tencent.mm.plugin.voip.model.c GWB;
  private final c HqA;
  public com.tencent.mm.audio.b.c qrH;
  private final com.tencent.mm.plugin.voip.model.b zMj;
  
  static
  {
    AppMethodBeat.i(199046);
    HqB = new a.a((byte)0);
    AppMethodBeat.o(199046);
  }
  
  public a()
  {
    AppMethodBeat.i(199045);
    this.zMj = ((com.tencent.mm.plugin.voip.model.b)b.HqC);
    this.HqA = new c();
    com.tencent.mm.plugin.audio.d.b.cet();
    d.cet();
    this.qrH = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
    Object localObject = this.qrH;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).jk(20);
    }
    localObject = this.qrH;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).dd(true);
    }
    localObject = this.qrH;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).aag();
    }
    localObject = this.qrH;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).x(1, false);
    }
    localObject = this.qrH;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).dc(true);
    }
    localObject = this.qrH;
    if (localObject != null) {
      ((com.tencent.mm.audio.b.c)localObject).a((c.a)this.HqA);
    }
    this.GWB = new com.tencent.mm.plugin.voip.model.c();
    localObject = this.GWB;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).N(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
    }
    localObject = this.GWB;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).F(MMApplicationContext.getContext(), false);
    }
    localObject = this.GWB;
    if (localObject != null) {
      ((com.tencent.mm.plugin.voip.model.c)localObject).a(this.zMj);
    }
    localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "voipcs");
    AppMethodBeat.o(199045);
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(199039);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.agt("voipcs");
    AppMethodBeat.o(199039);
  }
  
  private final boolean wS(boolean paramBoolean)
  {
    AppMethodBeat.i(199040);
    if (this.GWB != null)
    {
      com.tencent.mm.plugin.voip.model.c localc = this.GWB;
      if (localc == null) {
        p.hyc();
      }
      paramBoolean = localc.wS(paramBoolean);
      AppMethodBeat.o(199040);
      return paramBoolean;
    }
    AppMethodBeat.o(199040);
    return false;
  }
  
  private final void xo(boolean paramBoolean)
  {
    AppMethodBeat.i(199041);
    Log.printDebugStack("MicroMsg.cs.VoIPCsAudioManager", "enableSpeaker: ".concat(String.valueOf(paramBoolean)), new Object[0]);
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    localObject = com.tencent.mm.plugin.audio.d.b.oIo;
    if (com.tencent.mm.plugin.audio.d.b.ceb()) {}
    for (boolean bool = false;; bool = paramBoolean)
    {
      if (ae.gKu.gDA)
      {
        ae.gKu.dump();
        if (ae.gKu.gDB > 0) {
          wS(bool);
        }
      }
      if ((ae.gKu.gEh >= 0) || (ae.gKu.gEi >= 0)) {
        wS(paramBoolean);
      }
      if (this.GWB != null)
      {
        localObject = this.GWB;
        if (localObject == null) {
          p.hyc();
        }
        a(paramBoolean, ((com.tencent.mm.plugin.voip.model.c)localObject).bhV(), false);
        com.tencent.mm.plugin.voip_cs.c.c.fMr().xe(paramBoolean);
      }
      AppMethodBeat.o(199041);
      return;
    }
  }
  
  public final void Yl()
  {
    AppMethodBeat.i(199043);
    if (!cdW())
    {
      Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      localObject = com.tencent.mm.plugin.audio.d.b.oIo;
      if (!com.tencent.mm.plugin.audio.d.b.ceb()) {}
    }
    else
    {
      b("voipcs", Integer.valueOf(4));
      xo(false);
      AppMethodBeat.o(199043);
      return;
    }
    b("voipcs", Integer.valueOf(1));
    xo(true);
    AppMethodBeat.o(199043);
  }
  
  public final void iY(int paramInt)
  {
    AppMethodBeat.i(199044);
    super.iY(paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199044);
      return;
      agq("voipcs");
      xo(true);
      AppMethodBeat.o(199044);
      return;
      xo(false);
      AppMethodBeat.o(199044);
      return;
      xo(false);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(2131767377), 0).show();
      AppMethodBeat.o(199044);
      return;
      xo(true);
      Toast.makeText(MMApplicationContext.getContext(), (CharSequence)MMApplicationContext.getContext().getString(2131767378), 0).show();
    }
  }
  
  public final int xC(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(199042);
    Object localObject = com.tencent.mm.plugin.audio.c.a.oIh;
    localObject = com.tencent.mm.plugin.audio.d.b.oIo;
    if (com.tencent.mm.plugin.audio.d.b.ceb())
    {
      localObject = com.tencent.mm.plugin.audio.c.a.oIh;
      i = com.tencent.mm.plugin.audio.c.a.a.cea().cdX();
    }
    for (;;)
    {
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "Current StreamType:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(199042);
      return i;
      if (!paramBoolean)
      {
        localObject = com.tencent.mm.plugin.voip_cs.c.c.fMs();
        p.g(localObject, "SubCoreVoipCS.getVoipCSService()");
        if ((((com.tencent.mm.plugin.voip_cs.c.e)localObject).fMy() != 2) && (this.GWB != null))
        {
          localObject = this.GWB;
          if (localObject == null) {
            p.hyc();
          }
          i = ((com.tencent.mm.plugin.voip.model.c)localObject).bhV();
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pcm", "", "kotlin.jvm.PlatformType", "len", "PlayDevDataCallBack"})
  static final class b
    implements com.tencent.mm.plugin.voip.model.b
  {
    public static final b HqC;
    
    static
    {
      AppMethodBeat.i(199036);
      HqC = new b();
      AppMethodBeat.o(199036);
    }
    
    public final int Q(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(199035);
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.fMr();
      p.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      paramInt = locala.fMM().playCallback(paramArrayOfByte, paramInt);
      if (paramInt != 0) {
        Log.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + paramArrayOfByte.length + ",ret:" + paramInt);
      }
      if (paramInt != 0)
      {
        AppMethodBeat.o(199035);
        return 1;
      }
      AppMethodBeat.o(199035);
      return 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder$OnPcmRecListener;", "onRecError", "", "state", "", "detailState", "onRecPcmDataReady", "pcm", "", "len", "plugin-voip-cs_release"})
  public static final class c
    implements c.a
  {
    public final void cj(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199038);
      Log.i("MicroMsg.cs.VoIPCsAudioManager", "OnPcmRecListener onRecError %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(199038);
    }
    
    public final void w(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(199037);
      p.h(paramArrayOfByte, "pcm");
      if (paramInt <= 0)
      {
        Log.e("MicroMsg.cs.VoIPCsAudioManager", "pcm data len <= 0");
        AppMethodBeat.o(199037);
        return;
      }
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "onRecPcmDataReady,pcm data len:" + paramArrayOfByte.length);
      com.tencent.mm.plugin.voip_cs.c.b.a locala = com.tencent.mm.plugin.voip_cs.c.c.fMr();
      p.g(locala, "SubCoreVoipCS.getVoipCSEngine()");
      Log.d("MicroMsg.cs.VoIPCsAudioManager", "recordCallback,ret:".concat(String.valueOf(locala.fMM().recordCallback(paramArrayOfByte, paramInt, 200))));
      AppMethodBeat.o(199037);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.a.a
 * JD-Core Version:    0.7.0.1
 */