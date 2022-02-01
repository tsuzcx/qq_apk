package com.tencent.mm.plugin.voiceprint.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "hasBeginRec", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecorderDevice", "context", "Landroid/content/Context;", "stopRecord", "isContinue", "Companion", "app_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.d
{
  public static final a.a GQE;
  private boolean GQD;
  private kotlin.g.a.b<? super Boolean, x> dtM;
  private com.tencent.mm.compatible.util.b jvG;
  
  static
  {
    AppMethodBeat.i(230908);
    GQE = new a.a((byte)0);
    AppMethodBeat.o(230908);
  }
  
  public a(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(230907);
    this.dtM = paramb;
    com.tencent.mm.plugin.audio.d.b.cet();
    com.tencent.mm.plugin.audio.d.d.cet();
    paramb = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    AppMethodBeat.o(230907);
  }
  
  private final void Yp()
  {
    AppMethodBeat.i(230904);
    agq("record");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.agt("record");
    AppMethodBeat.o(230904);
  }
  
  public final boolean hx(Context paramContext)
  {
    AppMethodBeat.i(230903);
    p.h(paramContext, "context");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.jvG = new com.tencent.mm.compatible.util.b(paramContext);
    int i = b("record", Integer.valueOf(4));
    this.GQD = false;
    if (i != 0) {
      iY(100);
    }
    for (;;)
    {
      AppMethodBeat.o(230903);
      return false;
      new b(this).sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  public final void iY(int paramInt)
  {
    AppMethodBeat.i(230906);
    super.iY(paramInt);
    Log.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.GQD)
    {
      AppMethodBeat.o(230906);
      return;
    }
    this.GQD = true;
    Yp();
    this.dtM.invoke(Boolean.TRUE);
    AppMethodBeat.o(230906);
  }
  
  public final void wN(boolean paramBoolean)
  {
    AppMethodBeat.i(230905);
    if (!paramBoolean) {
      Yp();
    }
    com.tencent.mm.compatible.util.b localb = this.jvG;
    if (localb != null)
    {
      localb.apm();
      AppMethodBeat.o(230905);
      return;
    }
    AppMethodBeat.o(230905);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager$requestAudioRecorderDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(230902);
      p.h(paramMessage, "msg");
      Log.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder handleMessage");
      if (a.a(this.GQF))
      {
        AppMethodBeat.o(230902);
        return;
      }
      this.GQF.agq("record");
      this.GQF.iY(200);
      AppMethodBeat.o(230902);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.b.a
 * JD-Core Version:    0.7.0.1
 */