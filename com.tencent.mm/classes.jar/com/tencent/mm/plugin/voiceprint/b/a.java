package com.tencent.mm.plugin.voiceprint.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "hasBeginRec", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecorderDevice", "context", "Landroid/content/Context;", "stopRecord", "isContinue", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a.a BVc;
  private boolean BVb;
  private d.g.a.b<? super Boolean, z> dbT;
  private com.tencent.mm.compatible.util.b ixy;
  
  static
  {
    AppMethodBeat.i(194862);
    BVc = new a.a((byte)0);
    AppMethodBeat.o(194862);
  }
  
  public a(d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(194861);
    this.dbT = paramb;
    com.tencent.mm.plugin.audio.d.a.bGM();
    c.bGM();
    paramb = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    AppMethodBeat.o(194861);
  }
  
  private final void Of()
  {
    AppMethodBeat.i(194858);
    VJ("record");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.VM("record");
    AppMethodBeat.o(194858);
  }
  
  public final boolean gz(Context paramContext)
  {
    AppMethodBeat.i(194857);
    p.h(paramContext, "context");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nrV;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.ixy = new com.tencent.mm.compatible.util.b(paramContext);
    int i = b("record", Integer.valueOf(4));
    this.BVb = false;
    if (i != 0) {
      hC(100);
    }
    for (;;)
    {
      AppMethodBeat.o(194857);
      return false;
      new b(this).sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  public final void hC(int paramInt)
  {
    AppMethodBeat.i(194860);
    super.hC(paramInt);
    ad.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.BVb)
    {
      AppMethodBeat.o(194860);
      return;
    }
    this.BVb = true;
    Of();
    this.dbT.invoke(Boolean.TRUE);
    AppMethodBeat.o(194860);
  }
  
  public final void sX(boolean paramBoolean)
  {
    AppMethodBeat.i(194859);
    if (!paramBoolean) {
      Of();
    }
    com.tencent.mm.compatible.util.b localb = this.ixy;
    if (localb != null)
    {
      localb.abe();
      AppMethodBeat.o(194859);
      return;
    }
    AppMethodBeat.o(194859);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager$requestAudioRecorderDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(194856);
      p.h(paramMessage, "msg");
      ad.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder handleMessage");
      if (a.a(this.BVd))
      {
        AppMethodBeat.o(194856);
        return;
      }
      this.BVd.VJ("record");
      this.BVd.hC(200);
      AppMethodBeat.o(194856);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.b.a
 * JD-Core Version:    0.7.0.1
 */