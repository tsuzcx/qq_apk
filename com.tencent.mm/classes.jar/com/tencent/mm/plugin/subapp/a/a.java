package com.tencent.mm.plugin.subapp.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyRespone", "", "(Lkotlin/jvm/functions/Function1;)V", "hasbeginRec", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a.a zPv;
  private b<? super Boolean, y> cQD;
  private boolean zPu;
  
  static
  {
    AppMethodBeat.i(196998);
    zPv = new a.a((byte)0);
    AppMethodBeat.o(196998);
  }
  
  public a(b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(196997);
    this.cQD = paramb;
    AppMethodBeat.o(196997);
  }
  
  public final void Mv()
  {
    AppMethodBeat.i(196995);
    int i = b("record", Integer.valueOf(4));
    this.zPu = false;
    if (i != 0)
    {
      hv(100);
      AppMethodBeat.o(196995);
      return;
    }
    new b(this).sendEmptyMessageDelayed(0, 50L);
    AppMethodBeat.o(196995);
  }
  
  public final void hv(int paramInt)
  {
    AppMethodBeat.i(196996);
    super.hv(paramInt);
    ac.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.zPu)
    {
      AppMethodBeat.o(196996);
      return;
    }
    this.zPu = true;
    this.cQD.ay(Boolean.TRUE);
    AppMethodBeat.o(196996);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$requestAudioRecordDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends ao
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(196994);
      k.h(paramMessage, "msg");
      ac.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder handleMessage");
      if (a.a(this.zPw))
      {
        AppMethodBeat.o(196994);
        return;
      }
      this.zPw.hv(200);
      this.zPw.Sl("record");
      AppMethodBeat.o(196994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */