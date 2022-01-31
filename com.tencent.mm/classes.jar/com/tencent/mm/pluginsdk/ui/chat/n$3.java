package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Set;

final class n$3
  implements VoiceInputLayout.b
{
  n$3(n paramn) {}
  
  public final void aWL()
  {
    n.a(this.shE, System.currentTimeMillis());
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(n.p(this.shE)) });
    y.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(n.p(this.shE)) });
    n.d(this.shE, false);
    n.b(this.shE, true);
    n.c(this.shE, true);
    n.b(this.shE, 0L);
    n.q(this.shE);
    n.m(this.shE);
    n.r(this.shE).setVisibility(8);
    n.b(this.shE, false);
    n.l(this.shE).sbm = 3;
    n.l(this.shE).b(n.i(this.shE));
    n.cVt();
    if (n.i(this.shE) != null)
    {
      if ((n.i(this.shE).getText() != null) && (n.i(this.shE).getText().length() > 0)) {
        n.i(this.shE).setCursorVisible(true);
      }
      n.i(this.shE).requestFocus();
      bk.hideVKB(n.h(this.shE));
    }
    if ((n.s(this.shE) instanceof Activity)) {
      ((Activity)n.s(this.shE)).getWindow().addFlags(128);
    }
    n.t(this.shE).setVisibility(4);
    n.u(this.shE).setVisibility(4);
    n.v(this.shE).setVisibility(8);
    n.i(this.shE).setHint(this.shE.getResources().getString(R.l.voice_input_panel_hint_content));
    n.o(this.shE).lr(true);
    n.f(this.shE).setVisibility(8);
    this.shE.Eq(1);
  }
  
  public final void aWM()
  {
    int i = 0;
    n.o(this.shE).lr(false);
    n.i(this.shE).setHint(null);
    TextView localTextView = n.f(this.shE);
    if ((n.g(this.shE).size() < 2) || (n.i(this.shE).getText().length() > 0)) {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
  
  public final void aWN()
  {
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
    n.w(this.shE);
    n.l(this.shE).a(n.i(this.shE));
    n.m(this.shE);
    if ((n.s(this.shE) instanceof Activity)) {
      ((Activity)n.s(this.shE)).getWindow().clearFlags(128);
    }
    n.KT(2);
    n.o(this.shE).lr(false);
    n.i(this.shE).setHint(null);
    TextView localTextView = n.f(this.shE);
    if ((n.g(this.shE).size() < 2) || (n.i(this.shE).getText().length() > 0)) {}
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public final void aWO()
  {
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    n.l(this.shE).a(n.i(this.shE));
    n.m(this.shE);
    if ((n.s(this.shE) instanceof Activity)) {
      ((Activity)n.s(this.shE)).getWindow().clearFlags(128);
    }
    n.KT(3);
    n.o(this.shE).lr(false);
    n.i(this.shE).setHint(null);
  }
  
  public final void aWP()
  {
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    n.w(this.shE);
    n.l(this.shE).a(n.i(this.shE));
    n.m(this.shE);
    if ((n.s(this.shE) instanceof Activity)) {
      ((Activity)n.s(this.shE)).getWindow().clearFlags(128);
    }
    n.Er(1);
    n.o(this.shE).lr(false);
    n.i(this.shE).setHint(null);
  }
  
  public final void ag(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(System.currentTimeMillis()) });
    n.w(this.shE);
    n.l(this.shE).a(n.i(this.shE));
    n.m(this.shE);
    if ((n.s(this.shE) instanceof Activity)) {
      ((Activity)n.s(this.shE)).getWindow().clearFlags(128);
    }
    n.Er(paramInt1);
    if (paramInt1 == 12) {
      n.c(this.shE, R.l.voice_input_please_check_network);
    }
    for (;;)
    {
      n.o(this.shE).lr(false);
      n.i(this.shE).setHint(null);
      return;
      n.c(this.shE, R.l.app_err_system_busy_tip);
    }
  }
  
  public final void b(String[] paramArrayOfString, Set<String> paramSet)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0].length() > 0))
    {
      if (n.x(this.shE))
      {
        n.c(this.shE, false);
        n.y(this.shE);
      }
      n.l(this.shE).a(n.i(this.shE), paramArrayOfString[0], true);
      if (n.i(this.shE).getText().length() != 0)
      {
        n.i(this.shE).setCursorVisible(true);
        n.i(this.shE).requestFocus();
        bk.hideVKB(n.h(this.shE));
      }
      if ((!n.z(this.shE)) && (paramArrayOfString[0].length() != 0))
      {
        n.d(this.shE, true);
        n.b(this.shE, System.currentTimeMillis());
        y.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.A(this.shE) - n.p(this.shE)) });
      }
      n.B(this.shE).addAll(paramSet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.3
 * JD-Core Version:    0.7.0.1
 */