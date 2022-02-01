package com.tencent.mm.plugin.subapp.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyRespone", "", "(Lkotlin/jvm/functions/Function1;)V", "hasbeginRec", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "app_release"})
public final class a
  extends d
{
  public static final a.a BgW;
  private boolean BgV;
  private b<? super Boolean, z> dbT;
  
  static
  {
    AppMethodBeat.i(194853);
    BgW = new a.a((byte)0);
    AppMethodBeat.o(194853);
  }
  
  public a(b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(194852);
    this.dbT = paramb;
    AppMethodBeat.o(194852);
  }
  
  public final void Oe()
  {
    AppMethodBeat.i(194850);
    int i = b("record", Integer.valueOf(4));
    this.BgV = false;
    if (i != 0)
    {
      hC(100);
      AppMethodBeat.o(194850);
      return;
    }
    new b(this).sendEmptyMessageDelayed(0, 50L);
    AppMethodBeat.o(194850);
  }
  
  public final void hC(int paramInt)
  {
    AppMethodBeat.i(194851);
    super.hC(paramInt);
    ad.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder onAudioDeviceStateChange :".concat(String.valueOf(paramInt)));
    if (this.BgV)
    {
      AppMethodBeat.o(194851);
      return;
    }
    this.BgV = true;
    this.dbT.invoke(Boolean.TRUE);
    AppMethodBeat.o(194851);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$requestAudioRecordDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"})
  public static final class b
    extends ap
  {
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(194849);
      p.h(paramMessage, "msg");
      ad.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder handleMessage");
      if (a.a(this.BgX))
      {
        AppMethodBeat.o(194849);
        return;
      }
      this.BgX.hC(200);
      this.BgX.VJ("record");
      AppMethodBeat.o(194849);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */