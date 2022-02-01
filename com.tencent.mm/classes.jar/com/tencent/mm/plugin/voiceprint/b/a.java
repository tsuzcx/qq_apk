package com.tencent.mm.plugin.voiceprint.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "hasBeginRec", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecorderDevice", "context", "Landroid/content/Context;", "stopRecord", "isContinue", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.audio.b.d
{
  public static final a.a UsO;
  private boolean UsP;
  private kotlin.g.a.b<? super Boolean, ah> hqF;
  private com.tencent.mm.compatible.util.b peV;
  
  static
  {
    AppMethodBeat.i(272646);
    UsO = new a.a((byte)0);
    AppMethodBeat.o(272646);
  }
  
  public a(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(272634);
    this.hqF = paramb;
    com.tencent.mm.plugin.audio.d.b.cUq();
    com.tencent.mm.plugin.audio.d.d.cUq();
    paramb = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    AppMethodBeat.o(272634);
  }
  
  private final void aEV()
  {
    AppMethodBeat.i(272639);
    ahq("record");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.ahu("record");
    AppMethodBeat.o(272639);
  }
  
  public final void Ge(boolean paramBoolean)
  {
    AppMethodBeat.i(272654);
    if (!paramBoolean) {
      aEV();
    }
    com.tencent.mm.compatible.util.b localb = this.peV;
    if (localb != null) {
      localb.aPS();
    }
    AppMethodBeat.o(272654);
  }
  
  public final boolean kv(Context paramContext)
  {
    AppMethodBeat.i(272650);
    s.u(paramContext, "context");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.uVi;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.peV = new com.tencent.mm.compatible.util.b(paramContext);
    int i = b("record", Integer.valueOf(4));
    this.UsP = false;
    if (i != 0) {
      nW(100);
    }
    for (;;)
    {
      AppMethodBeat.o(272650);
      return false;
      new b(this).sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  public final void nW(int paramInt)
  {
    AppMethodBeat.i(272658);
    super.nW(paramInt);
    Log.d("MicroMsg.VoicePrintRecorderAudioManager", s.X(" Recorder onAudioDeviceStateChange :", Integer.valueOf(paramInt)));
    if (this.UsP)
    {
      AppMethodBeat.o(272658);
      return;
    }
    this.UsP = true;
    aEV();
    this.hqF.invoke(Boolean.TRUE);
    AppMethodBeat.o(272658);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager$requestAudioRecorderDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MMHandler
  {
    b(a parama) {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(272637);
      s.u(paramMessage, "msg");
      Log.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder handleMessage");
      if (a.a(this.UsQ))
      {
        AppMethodBeat.o(272637);
        return;
      }
      this.UsQ.ahq("record");
      this.UsQ.nW(200);
      AppMethodBeat.o(272637);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.b.a
 * JD-Core Version:    0.7.0.1
 */