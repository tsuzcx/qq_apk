package com.tencent.mm.plugin.voiceprint.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "hasBeginRec", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecorderDevice", "context", "Landroid/content/Context;", "stopRecord", "isContinue", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a.a zdb;
  private d.g.a.b<? super Boolean, y> cTg;
  private com.tencent.mm.compatible.util.b hDB;
  private boolean zda;
  
  static
  {
    AppMethodBeat.i(191884);
    zdb = new a.a((byte)0);
    AppMethodBeat.o(191884);
  }
  
  public a(d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(191883);
    this.cTg = paramb;
    com.tencent.mm.plugin.audio.d.a.bvI();
    c.bvI();
    paramb = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    AppMethodBeat.o(191883);
  }
  
  private final void My()
  {
    AppMethodBeat.i(191880);
    Oc("record");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.Oe("record");
    AppMethodBeat.o(191880);
  }
  
  public final boolean gk(Context paramContext)
  {
    AppMethodBeat.i(191879);
    k.h(paramContext, "context");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.mpv;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.hDB = new com.tencent.mm.compatible.util.b(paramContext);
    int i = b("record", Integer.valueOf(4));
    this.zda = false;
    if (i != 0) {
      hL(100);
    }
    for (;;)
    {
      AppMethodBeat.o(191879);
      return false;
      new b(this).sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  public final void hL(int paramInt)
  {
    AppMethodBeat.i(191882);
    super.hL(paramInt);
    ad.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.zda)
    {
      AppMethodBeat.o(191882);
      return;
    }
    this.zda = true;
    My();
    this.cTg.aA(Boolean.TRUE);
    AppMethodBeat.o(191882);
  }
  
  public final void rn(boolean paramBoolean)
  {
    AppMethodBeat.i(191881);
    if (!paramBoolean) {
      My();
    }
    com.tencent.mm.compatible.util.b localb = this.hDB;
    if (localb != null)
    {
      localb.XF();
      AppMethodBeat.o(191881);
      return;
    }
    AppMethodBeat.o(191881);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager$requestAudioRecorderDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(191878);
      k.h(paramMessage, "msg");
      ad.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder handleMessage");
      if (a.a(this.zdc))
      {
        AppMethodBeat.o(191878);
        return;
      }
      this.zdc.Oc("record");
      this.zdc.hL(200);
      AppMethodBeat.o(191878);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.b.a
 * JD-Core Version:    0.7.0.1
 */