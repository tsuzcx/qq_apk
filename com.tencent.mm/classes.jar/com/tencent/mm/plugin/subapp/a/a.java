package com.tencent.mm.plugin.subapp.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyRespone", "", "(Lkotlin/jvm/functions/Function1;)V", "hasbeginRec", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a.a Byu;
  private boolean Byt;
  private b<? super Boolean, z> dcV;
  
  static
  {
    AppMethodBeat.i(188257);
    Byu = new a.a((byte)0);
    AppMethodBeat.o(188257);
  }
  
  public a(b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(188256);
    this.dcV = paramb;
    AppMethodBeat.o(188256);
  }
  
  public final void Oc()
  {
    AppMethodBeat.i(188254);
    int i = b("record", Integer.valueOf(4));
    this.Byt = false;
    if (i != 0)
    {
      hE(100);
      AppMethodBeat.o(188254);
      return;
    }
    new b(this).sendEmptyMessageDelayed(0, 50L);
    AppMethodBeat.o(188254);
  }
  
  public final void hE(int paramInt)
  {
    AppMethodBeat.i(188255);
    super.hE(paramInt);
    ae.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.Byt)
    {
      AppMethodBeat.o(188255);
      return;
    }
    this.Byt = true;
    this.dcV.invoke(Boolean.TRUE);
    AppMethodBeat.o(188255);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$requestAudioRecordDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends aq
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(188253);
      p.h(paramMessage, "msg");
      ae.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder handleMessage");
      if (a.a(this.Byv))
      {
        AppMethodBeat.o(188253);
        return;
      }
      this.Byv.hE(200);
      this.Byv.Wv("record");
      AppMethodBeat.o(188253);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */