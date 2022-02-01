package com.tencent.mm.plugin.multitalk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ilinkservice/audio/ILinkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "isAvailable", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", "channels", "duration", "stopPlay", "unInit", "Companion", "plugin-multitalk_release"})
public final class a
  extends com.tencent.mm.plugin.audio.b.b
{
  public static final a.a zKM;
  public com.tencent.mm.compatible.util.b jvG;
  public boolean qry;
  public c qrz;
  
  static
  {
    AppMethodBeat.i(239560);
    zKM = new a.a((byte)0);
    AppMethodBeat.o(239560);
  }
  
  public a()
  {
    AppMethodBeat.i(239559);
    this.jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    com.tencent.mm.plugin.audio.d.b.cet();
    d.cet();
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.a((com.tencent.mm.plugin.audio.b.a)this, "openvoice");
    AppMethodBeat.o(239559);
  }
  
  private final boolean ru(boolean paramBoolean)
  {
    AppMethodBeat.i(239557);
    c localc = this.qrz;
    if ((localc != null) && (localc.isPlaying() == true))
    {
      localc = this.qrz;
      if (localc == null) {
        p.hyc();
      }
      paramBoolean = localc.wS(paramBoolean);
      AppMethodBeat.o(239557);
      return paramBoolean;
    }
    AppMethodBeat.o(239557);
    return false;
  }
  
  public static void unInit()
  {
    AppMethodBeat.i(239555);
    com.tencent.mm.plugin.audio.c.a.a locala = com.tencent.mm.plugin.audio.c.a.oIh;
    com.tencent.mm.plugin.audio.c.a.a.agt("openvoice");
    AppMethodBeat.o(239555);
  }
  
  public final void iY(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(239558);
    super.iY(paramInt);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      AppMethodBeat.o(239558);
      return;
    case 2: 
      this.qry &= kJ(false);
      ac.eol().ry(true);
      ac.eol().rz(false);
      AppMethodBeat.o(239558);
      return;
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      this.qry &= kJ(true);
      ac.eol().ry(false);
      q localq = ac.eom();
      p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      bool1 = bool2;
      if (localq.czl())
      {
        bool1 = bool2;
        if (!AY(3)) {
          bool1 = true;
        }
      }
      localq = ac.eom();
      p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      bool2 = bool1;
      if (localq.czl())
      {
        bool2 = bool1;
        if (!AY(3))
        {
          localq = ac.eom();
          p.g(localq, "SubCoreMultiTalk.getMultiTalkManager()");
          bool2 = localq.enS();
        }
      }
      if (AY(3))
      {
        ac.eol().ry(true);
        AppMethodBeat.o(239558);
        return;
      }
      ac.eol().rz(bool2);
      AppMethodBeat.o(239558);
      return;
    case 9: 
      Log.i("MicroMsg.ILinkAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(AY(4)) });
      ac.eol().ry(false);
      if (AY(4)) {
        ac.eol().ry(true);
      }
      break;
    }
    for (;;)
    {
      this.qry &= kJ(bool1);
      ac.eol().rz(bool1);
      AppMethodBeat.o(239558);
      return;
      Log.i("MicroMsg.ILinkAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(AY(4)) });
      this.qry &= kJ(false);
      ac.eol().ry(true);
      ac.eol().rz(false);
      break;
      bool1 = true;
    }
  }
  
  public final boolean kJ(boolean paramBoolean)
  {
    AppMethodBeat.i(239556);
    Log.i("MicroMsg.ILinkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    jp(paramBoolean);
    paramBoolean = ru(paramBoolean);
    AppMethodBeat.o(239556);
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.a.a
 * JD-Core Version:    0.7.0.1
 */