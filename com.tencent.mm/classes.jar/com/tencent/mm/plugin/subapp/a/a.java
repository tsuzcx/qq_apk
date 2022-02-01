package com.tencent.mm.plugin.subapp.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyRespone", "", "(Lkotlin/jvm/functions/Function1;)V", "hasbeginRec", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a.a Mdd;
  private boolean Mdc;
  private b<? super Boolean, x> fmu;
  
  static
  {
    AppMethodBeat.i(276505);
    Mdd = new a.a((byte)0);
    AppMethodBeat.o(276505);
  }
  
  public a(b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(276504);
    this.fmu = paramb;
    AppMethodBeat.o(276504);
  }
  
  public final void acU()
  {
    AppMethodBeat.i(276501);
    int i = b("record", Integer.valueOf(4));
    this.Mdc = false;
    if (i != 0)
    {
      ko(100);
      AppMethodBeat.o(276501);
      return;
    }
    new b(this).sendEmptyMessageDelayed(0, 50L);
    AppMethodBeat.o(276501);
  }
  
  public final void ko(int paramInt)
  {
    AppMethodBeat.i(276503);
    super.ko(paramInt);
    Log.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.Mdc)
    {
      AppMethodBeat.o(276503);
      return;
    }
    this.Mdc = true;
    this.fmu.invoke(Boolean.TRUE);
    AppMethodBeat.o(276503);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$requestAudioRecordDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(288407);
      p.k(paramMessage, "msg");
      Log.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder handleMessage");
      if (a.a(this.Mde))
      {
        AppMethodBeat.o(288407);
        return;
      }
      this.Mde.ko(200);
      this.Mde.anT("record");
      AppMethodBeat.o(288407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */