package com.tencent.mm.plugin.subapp.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyRespone", "", "(Lkotlin/jvm/functions/Function1;)V", "hasbeginRec", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a yCh;
  private b<? super Boolean, y> cTg;
  private boolean yCg;
  
  static
  {
    AppMethodBeat.i(191877);
    yCh = new a((byte)0);
    AppMethodBeat.o(191877);
  }
  
  public a(b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(191876);
    this.cTg = paramb;
    AppMethodBeat.o(191876);
  }
  
  public final void Mx()
  {
    AppMethodBeat.i(191874);
    int i = b("record", Integer.valueOf(4));
    this.yCg = false;
    if (i != 0)
    {
      hL(100);
      AppMethodBeat.o(191874);
      return;
    }
    new b(this).sendEmptyMessageDelayed(0, 50L);
    AppMethodBeat.o(191874);
  }
  
  public final void hL(int paramInt)
  {
    AppMethodBeat.i(191875);
    super.hL(paramInt);
    ad.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.yCg)
    {
      AppMethodBeat.o(191875);
      return;
    }
    this.yCg = true;
    this.cTg.aA(Boolean.TRUE);
    AppMethodBeat.o(191875);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$Companion;", "", "()V", "TAG", "", "app_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$requestAudioRecordDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(191873);
      k.h(paramMessage, "msg");
      ad.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder handleMessage");
      if (a.a(this.yCi))
      {
        AppMethodBeat.o(191873);
        return;
      }
      this.yCi.hL(200);
      this.yCi.Oc("record");
      AppMethodBeat.o(191873);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */