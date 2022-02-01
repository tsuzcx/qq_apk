package com.tencent.mm.plugin.voiceprint.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "hasBeginRec", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecorderDevice", "context", "Landroid/content/Context;", "stopRecord", "isContinue", "Companion", "app_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.d
{
  public static final a.a NGP;
  private boolean NGO;
  private kotlin.g.a.b<? super Boolean, x> fmu;
  private com.tencent.mm.compatible.util.b mlj;
  
  static
  {
    AppMethodBeat.i(285565);
    NGP = new a.a((byte)0);
    AppMethodBeat.o(285565);
  }
  
  public a(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(285564);
    this.fmu = paramb;
    com.tencent.mm.plugin.audio.d.b.crG();
    com.tencent.mm.plugin.audio.d.d.crG();
    paramb = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    AppMethodBeat.o(285564);
  }
  
  private final void acV()
  {
    AppMethodBeat.i(285561);
    anT("record");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.anX("record");
    AppMethodBeat.o(285561);
  }
  
  public final void AF(boolean paramBoolean)
  {
    AppMethodBeat.i(285562);
    if (!paramBoolean) {
      acV();
    }
    com.tencent.mm.compatible.util.b localb = this.mlj;
    if (localb != null)
    {
      localb.avz();
      AppMethodBeat.o(285562);
      return;
    }
    AppMethodBeat.o(285562);
  }
  
  public final boolean iD(Context paramContext)
  {
    AppMethodBeat.i(285560);
    p.k(paramContext, "context");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.rJX;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.mlj = new com.tencent.mm.compatible.util.b(paramContext);
    int i = b("record", Integer.valueOf(4));
    this.NGO = false;
    if (i != 0) {
      ko(100);
    }
    for (;;)
    {
      AppMethodBeat.o(285560);
      return false;
      new b(this).sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  public final void ko(int paramInt)
  {
    AppMethodBeat.i(285563);
    super.ko(paramInt);
    Log.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.NGO)
    {
      AppMethodBeat.o(285563);
      return;
    }
    this.NGO = true;
    acV();
    this.fmu.invoke(Boolean.TRUE);
    AppMethodBeat.o(285563);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager$requestAudioRecorderDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(286060);
      p.k(paramMessage, "msg");
      Log.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder handleMessage");
      if (a.a(this.NGQ))
      {
        AppMethodBeat.o(286060);
        return;
      }
      this.NGQ.anT("record");
      this.NGQ.ko(200);
      AppMethodBeat.o(286060);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.b.a
 * JD-Core Version:    0.7.0.1
 */