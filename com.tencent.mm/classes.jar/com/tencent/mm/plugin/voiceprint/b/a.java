package com.tencent.mm.plugin.voiceprint.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "hasBeginRec", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecorderDevice", "context", "Landroid/content/Context;", "stopRecord", "isContinue", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a.a AvH;
  private boolean AvG;
  private d.g.a.b<? super Boolean, y> cQD;
  private com.tencent.mm.compatible.util.b ied;
  
  static
  {
    AppMethodBeat.i(197006);
    AvH = new a.a((byte)0);
    AppMethodBeat.o(197006);
  }
  
  public a(d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(197005);
    this.cQD = paramb;
    com.tencent.mm.plugin.audio.d.a.bCE();
    c.bCE();
    paramb = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    AppMethodBeat.o(197005);
  }
  
  private final void Mw()
  {
    AppMethodBeat.i(197002);
    Sl("record");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.So("record");
    AppMethodBeat.o(197002);
  }
  
  public final boolean gw(Context paramContext)
  {
    AppMethodBeat.i(197001);
    k.h(paramContext, "context");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mRw;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.ied = new com.tencent.mm.compatible.util.b(paramContext);
    int i = b("record", Integer.valueOf(4));
    this.AvG = false;
    if (i != 0) {
      hv(100);
    }
    for (;;)
    {
      AppMethodBeat.o(197001);
      return false;
      new b(this).sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  public final void hv(int paramInt)
  {
    AppMethodBeat.i(197004);
    super.hv(paramInt);
    ac.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.AvG)
    {
      AppMethodBeat.o(197004);
      return;
    }
    this.AvG = true;
    Mw();
    this.cQD.ay(Boolean.TRUE);
    AppMethodBeat.o(197004);
  }
  
  public final void so(boolean paramBoolean)
  {
    AppMethodBeat.i(197003);
    if (!paramBoolean) {
      Mw();
    }
    com.tencent.mm.compatible.util.b localb = this.ied;
    if (localb != null)
    {
      localb.YC();
      AppMethodBeat.o(197003);
      return;
    }
    AppMethodBeat.o(197003);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager$requestAudioRecorderDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends ao
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(197000);
      k.h(paramMessage, "msg");
      ac.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder handleMessage");
      if (a.a(this.AvI))
      {
        AppMethodBeat.o(197000);
        return;
      }
      this.AvI.Sl("record");
      this.AvI.hv(200);
      AppMethodBeat.o(197000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.b.a
 * JD-Core Version:    0.7.0.1
 */