package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.h.a.jy.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class g$29
  extends c<jy>
{
  g$29(g paramg)
  {
    this.udX = jy.class.getName().hashCode();
  }
  
  private boolean a(jy paramjy)
  {
    String str = paramjy.bSA.state;
    y.i("MicroMsg.MsgHandler", "backgroundAudioListener callback in, state:%s", new Object[] { str });
    boolean bool = paramjy.bSA.bSC;
    int i = (int)(paramjy.bSA.duration / 1000L);
    if (!bool)
    {
      y.e("MicroMsg.MsgHandler", "is not from QQMusicPlayer, don't callback!");
      return false;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("background_audio_state_player_state", str);
      localBundle.putInt("background_audio_state_player_duration", i);
      if (paramjy.bSA.bSu != null)
      {
        localBundle.putString("background_audio_state_player_src", paramjy.bSA.bSu.euD);
        localBundle.putString("background_audio_state_player_src_id", paramjy.bSA.bSu.euV);
      }
      localBundle.putInt("background_audio_state_player_err_code", paramjy.bSA.errCode);
      str = "";
      if (!TextUtils.isEmpty(paramjy.bSA.aox)) {
        str = paramjy.bSA.aox;
      }
      localBundle.putString("background_audio_state_player_err_msg", str);
      if (g.D(this.rzi) != null)
      {
        y.i("MicroMsg.MsgHandler", "onBackgroundAudioStateChange");
        g.D(this.rzi).b(2100, localBundle);
      }
      else
      {
        y.e("MicroMsg.MsgHandler", "backgroundAudioListener callbacker is null");
      }
    }
    catch (Exception paramjy)
    {
      y.e("MicroMsg.MsgHandler", paramjy.getMessage());
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.29
 * JD-Core Version:    0.7.0.1
 */