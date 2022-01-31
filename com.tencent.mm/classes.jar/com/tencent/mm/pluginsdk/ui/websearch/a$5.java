package com.tencent.mm.pluginsdk.ui.websearch;

import android.app.Activity;
import android.content.res.Resources;
import android.media.AudioManager;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Set;

final class a$5
  implements VoiceInputLayout.b
{
  a$5(a parama) {}
  
  public final void aWL()
  {
    a.a(this.snT, System.currentTimeMillis());
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(a.g(this.snT)) });
    y.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(a.g(this.snT)) });
    a.b(this.snT, false);
    a.c(this.snT, true);
    a.d(this.snT, true);
    a.b(this.snT, 0L);
    a.h(this.snT);
    a.d(this.snT);
    a.i(this.snT).setVisibility(8);
    a.c(this.snT, false);
    a locala = this.snT;
    if (locala.dui != null) {
      locala.dui.setStreamMute(3, true);
    }
    if ((a.j(this.snT) instanceof Activity)) {
      ((Activity)a.j(this.snT)).getWindow().addFlags(128);
    }
    a.k(this.snT).setVisibility(4);
    a.l(this.snT).setVisibility(4);
    a.m(this.snT).setVisibility(8);
    a.c(this.snT).setHint(this.snT.getResources().getString(R.l.voice_input_panel_hint_content));
    a.e(this.snT).lr(true);
  }
  
  public final void aWM()
  {
    a.e(this.snT).lr(false);
    a.c(this.snT).setHint(null);
  }
  
  public final void aWN()
  {
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
    a.d(this.snT);
    if ((a.j(this.snT) instanceof Activity)) {
      ((Activity)a.j(this.snT)).getWindow().clearFlags(128);
    }
    a.e(this.snT).lr(false);
    a.c(this.snT).setHint(null);
    a.b(this.snT, 2);
  }
  
  public final void aWO()
  {
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    a.d(this.snT);
    if ((a.j(this.snT) instanceof Activity)) {
      ((Activity)a.j(this.snT)).getWindow().clearFlags(128);
    }
    a.e(this.snT).lr(false);
    a.c(this.snT).setHint(null);
  }
  
  public final void aWP()
  {
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    a.d(this.snT);
    if ((a.j(this.snT) instanceof Activity)) {
      ((Activity)a.j(this.snT)).getWindow().clearFlags(128);
    }
    a.e(this.snT).lr(false);
    a.c(this.snT).setHint(null);
    a.b(this.snT, 2);
  }
  
  public final void ag(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(System.currentTimeMillis()) });
    a.d(this.snT);
    if ((a.j(this.snT) instanceof Activity)) {
      ((Activity)a.j(this.snT)).getWindow().clearFlags(128);
    }
    if (paramInt1 == 12) {
      a.a(this.snT, R.l.voice_input_please_check_network);
    }
    for (;;)
    {
      a.e(this.snT).lr(false);
      a.c(this.snT).setHint(null);
      return;
      a.a(this.snT, R.l.app_err_system_busy_tip);
    }
  }
  
  public final void b(String[] paramArrayOfString, Set<String> paramSet)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0].length() > 0))
    {
      if (a.n(this.snT)) {
        a.d(this.snT, false);
      }
      y.i("MicroMsg.VoiceInputPanel", "onDetected %s", new Object[] { paramArrayOfString[0] });
      a.c(this.snT).setText(paramArrayOfString[0]);
      if ((!a.o(this.snT)) && (paramArrayOfString[0].length() != 0))
      {
        a.b(this.snT, true);
        a.b(this.snT, System.currentTimeMillis());
        y.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.p(this.snT) - a.g(this.snT)) });
      }
      a.q(this.snT).addAll(paramSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a.5
 * JD-Core Version:    0.7.0.1
 */