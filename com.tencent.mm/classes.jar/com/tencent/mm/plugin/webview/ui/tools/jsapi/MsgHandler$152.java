package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.a.ox.a;
import com.tencent.mm.aw.a;
import com.tencent.mm.plugin.webview.ui.tools.media.h;
import com.tencent.mm.plugin.webview.ui.tools.media.h.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class MsgHandler$152
  extends IListener<ox>
{
  MsgHandler$152(j paramj, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(297396);
    this.__eventId = ox.class.getName().hashCode();
    AppMethodBeat.o(297396);
  }
  
  private boolean c(ox paramox)
  {
    AppMethodBeat.i(297406);
    Object localObject = paramox.hRN.state;
    Log.i("MicroMsg.MsgHandler", "backgroundAudioListener callback in, state:%s", new Object[] { localObject });
    boolean bool = paramox.hRN.hRO;
    int i = (int)(paramox.hRN.duration / 1000L);
    if (!bool)
    {
      Log.e("MicroMsg.MsgHandler", "is not from QQMusicPlayer, don't callback!");
      AppMethodBeat.o(297406);
      return false;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("background_audio_state_player_state", (String)localObject);
      localBundle.putInt("background_audio_state_player_duration", i);
      if (paramox.hRN.hRG != null)
      {
        localBundle.putString("background_audio_state_player_src", paramox.hRN.hRG.oOB);
        localBundle.putString("background_audio_state_player_src_id", paramox.hRN.hRG.oOT);
      }
      localBundle.putInt("background_audio_state_player_err_code", paramox.hRN.errCode);
      localObject = "";
      if (!TextUtils.isEmpty(paramox.hRN.errMsg)) {
        localObject = paramox.hRN.errMsg;
      }
      localBundle.putString("background_audio_state_player_err_msg", (String)localObject);
      paramox = a.bLn();
      if (paramox != null)
      {
        localObject = h.Xmy;
        paramox = h.a.iBH().bmH(paramox.oOv);
        if (!Util.isNullOrNil(paramox)) {
          localBundle.putString("background_audio_state_player_audio_id", paramox);
        }
      }
      if (j.k(this.XjI) != null)
      {
        Log.i("MicroMsg.MsgHandler", "onBackgroundAudioStateChange");
        j.k(this.XjI).i(2100, localBundle);
      }
      for (;;)
      {
        AppMethodBeat.o(297406);
        return true;
        Log.e("MicroMsg.MsgHandler", "backgroundAudioListener callbacker is null");
      }
      return false;
    }
    catch (Exception paramox)
    {
      Log.e("MicroMsg.MsgHandler", paramox.getMessage());
      AppMethodBeat.o(297406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.MsgHandler.152
 * JD-Core Version:    0.7.0.1
 */