package com.tencent.mm.plugin.voiceprint.b;

import android.content.Context;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.plugin.audio.d.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyResponse", "", "(Lkotlin/jvm/functions/Function1;)V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "hasBeginRec", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecorderDevice", "context", "Landroid/content/Context;", "stopRecord", "isContinue", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a.a CmD;
  private boolean CmC;
  private d.g.a.b<? super Boolean, z> dcV;
  private com.tencent.mm.compatible.util.b iAr;
  
  static
  {
    AppMethodBeat.i(188266);
    CmD = new a.a((byte)0);
    AppMethodBeat.o(188266);
  }
  
  public a(d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(188265);
    this.dcV = paramb;
    com.tencent.mm.plugin.audio.d.a.bHI();
    c.bHI();
    paramb = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    AppMethodBeat.o(188265);
  }
  
  private final void Od()
  {
    AppMethodBeat.i(188262);
    Wv("record");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.Wy("record");
    AppMethodBeat.o(188262);
  }
  
  public final boolean gE(Context paramContext)
  {
    AppMethodBeat.i(188261);
    p.h(paramContext, "context");
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.nxo;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "record");
    this.iAr = new com.tencent.mm.compatible.util.b(paramContext);
    int i = b("record", Integer.valueOf(4));
    this.CmC = false;
    if (i != 0) {
      hE(100);
    }
    for (;;)
    {
      AppMethodBeat.o(188261);
      return false;
      new b(this).sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  public final void hE(int paramInt)
  {
    AppMethodBeat.i(188264);
    super.hE(paramInt);
    ae.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.CmC)
    {
      AppMethodBeat.o(188264);
      return;
    }
    this.CmC = true;
    Od();
    this.dcV.invoke(Boolean.TRUE);
    AppMethodBeat.o(188264);
  }
  
  public final void te(boolean paramBoolean)
  {
    AppMethodBeat.i(188263);
    if (!paramBoolean) {
      Od();
    }
    com.tencent.mm.compatible.util.b localb = this.iAr;
    if (localb != null)
    {
      localb.abn();
      AppMethodBeat.o(188263);
      return;
    }
    AppMethodBeat.o(188263);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/voiceprint/audio/VoicePrintRecorderAudioManager$requestAudioRecorderDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends aq
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(188260);
      p.h(paramMessage, "msg");
      ae.d("MicroMsg.VoicePrintRecorderAudioManager", " Recorder handleMessage");
      if (a.a(this.CmE))
      {
        AppMethodBeat.o(188260);
        return;
      }
      this.CmE.Wv("record");
      this.CmE.hE(200);
      AppMethodBeat.o(188260);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.b.a
 * JD-Core Version:    0.7.0.1
 */