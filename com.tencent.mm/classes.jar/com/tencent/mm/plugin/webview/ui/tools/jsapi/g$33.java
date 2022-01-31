package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.g.a.ki.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

final class g$33
  extends c<ki>
{
  g$33(g paramg)
  {
    AppMethodBeat.i(154955);
    this.__eventId = ki.class.getName().hashCode();
    AppMethodBeat.o(154955);
  }
  
  private boolean a(ki paramki)
  {
    AppMethodBeat.i(154956);
    String str = paramki.cAc.state;
    ab.i("MicroMsg.MsgHandler", "backgroundAudioListener callback in, state:%s", new Object[] { str });
    boolean bool = paramki.cAc.cAe;
    int i = (int)(paramki.cAc.duration / 1000L);
    if (!bool)
    {
      ab.e("MicroMsg.MsgHandler", "is not from QQMusicPlayer, don't callback!");
      AppMethodBeat.o(154956);
      return false;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("background_audio_state_player_state", str);
      localBundle.putInt("background_audio_state_player_duration", i);
      if (paramki.cAc.czW != null)
      {
        localBundle.putString("background_audio_state_player_src", paramki.cAc.czW.fKp);
        localBundle.putString("background_audio_state_player_src_id", paramki.cAc.czW.fKH);
      }
      localBundle.putInt("background_audio_state_player_err_code", paramki.cAc.errCode);
      str = "";
      if (!TextUtils.isEmpty(paramki.cAc.errMsg)) {
        str = paramki.cAc.errMsg;
      }
      localBundle.putString("background_audio_state_player_err_msg", str);
      if (g.l(this.vqm) != null)
      {
        ab.i("MicroMsg.MsgHandler", "onBackgroundAudioStateChange");
        g.l(this.vqm).e(2100, localBundle);
      }
      for (;;)
      {
        AppMethodBeat.o(154956);
        return true;
        ab.e("MicroMsg.MsgHandler", "backgroundAudioListener callbacker is null");
      }
      return false;
    }
    catch (Exception paramki)
    {
      ab.e("MicroMsg.MsgHandler", paramki.getMessage());
      AppMethodBeat.o(154956);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.33
 * JD-Core Version:    0.7.0.1
 */