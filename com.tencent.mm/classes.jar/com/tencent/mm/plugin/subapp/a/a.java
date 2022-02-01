package com.tencent.mm.plugin.subapp.a;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseRecorderAudioManager;", "onStartRecord", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isImmediatelyRespone", "", "(Lkotlin/jvm/functions/Function1;)V", "hasbeginRec", "getOnStartRecord", "()Lkotlin/jvm/functions/Function1;", "setOnStartRecord", "onAudioDeviceStateChanged", "status", "", "releaseAudioRecordDevice", "requestAudioRecordDevice", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends d
{
  public static final a.a SEs;
  private boolean SEt;
  private b<? super Boolean, ah> hqF;
  
  static
  {
    AppMethodBeat.i(291981);
    SEs = new a.a((byte)0);
    AppMethodBeat.o(291981);
  }
  
  public a(b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(291976);
    this.hqF = paramb;
    AppMethodBeat.o(291976);
  }
  
  public final void aEU()
  {
    AppMethodBeat.i(291983);
    int i = b("record", Integer.valueOf(4));
    this.SEt = false;
    if (i != 0)
    {
      nW(100);
      AppMethodBeat.o(291983);
      return;
    }
    new b(this).sendEmptyMessageDelayed(0, 50L);
    AppMethodBeat.o(291983);
  }
  
  public final void nW(int paramInt)
  {
    AppMethodBeat.i(291987);
    super.nW(paramInt);
    Log.d("MicroMsg.VoiceRemindRecordAudioManager", s.X(" Recorder onAudioDeviceStateChange :", Integer.valueOf(paramInt)));
    if (this.SEt)
    {
      AppMethodBeat.o(291987);
      return;
    }
    this.SEt = true;
    this.hqF.invoke(Boolean.TRUE);
    AppMethodBeat.o(291987);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/subapp/audio/VoiceRemindRecordAudioManager$requestAudioRecordDevice$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends MMHandler
  {
    b(a parama) {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(291974);
      s.u(paramMessage, "msg");
      Log.d("MicroMsg.VoiceRemindRecordAudioManager", " Recorder handleMessage");
      if (a.a(this.SEu))
      {
        AppMethodBeat.o(291974);
        return;
      }
      this.SEu.nW(200);
      this.SEu.ahq("record");
      AppMethodBeat.o(291974);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a
 * JD-Core Version:    0.7.0.1
 */