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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyRespone", "", "(Lkotlin/jvm/functions/Function1;)V", "hasbeginRec", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a.a FJf;
  private boolean FJe;
  private b<? super Boolean, x> dtM;
  
  static
  {
    AppMethodBeat.i(230897);
    FJf = new a.a((byte)0);
    AppMethodBeat.o(230897);
  }
  
  public a(b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(230896);
    this.dtM = paramb;
    AppMethodBeat.o(230896);
  }
  
  public final void Yo()
  {
    AppMethodBeat.i(230894);
    int i = b("record", Integer.valueOf(4));
    this.FJe = false;
    if (i != 0)
    {
      iY(100);
      AppMethodBeat.o(230894);
      return;
    }
    new b(this).sendEmptyMessageDelayed(0, 50L);
    AppMethodBeat.o(230894);
  }
  
  public final void iY(int paramInt)
  {
    AppMethodBeat.i(230895);
    super.iY(paramInt);
    Log.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.FJe)
    {
      AppMethodBeat.o(230895);
      return;
    }
    this.FJe = true;
    this.dtM.invoke(Boolean.TRUE);
    AppMethodBeat.o(230895);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$requestAudioRecordDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends MMHandler
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(230893);
      p.h(paramMessage, "msg");
      Log.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder handleMessage");
      if (a.a(this.FJg))
      {
        AppMethodBeat.o(230893);
        return;
      }
      this.FJg.iY(200);
      this.FJg.agq("record");
      AppMethodBeat.o(230893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */