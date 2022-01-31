package com.tencent.mm.pluginsdk.ui.chat;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

final class n$3
  implements VoiceInputLayout.b
{
  n$3(n paramn) {}
  
  public final void at(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(27974);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(System.currentTimeMillis()) });
    n.v(this.vZW);
    n.k(this.vZW).a(n.h(this.vZW));
    n.l(this.vZW);
    if ((n.r(this.vZW) instanceof Activity)) {
      ((Activity)n.r(this.vZW)).getWindow().clearFlags(128);
    }
    n.Mq(paramInt1);
    if (paramInt1 == 12) {
      n.c(this.vZW, 2131304555);
    }
    for (;;)
    {
      n.n(this.vZW).pd(false);
      n.h(this.vZW).setHint(null);
      AppMethodBeat.o(27974);
      return;
      n.c(this.vZW, 2131296926);
    }
  }
  
  public final void bDq()
  {
    AppMethodBeat.i(27968);
    n.a(this.vZW, System.currentTimeMillis());
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(n.o(this.vZW)) });
    ab.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(n.o(this.vZW)) });
    n.b(this.vZW, false);
    n.c(this.vZW, true);
    n.d(this.vZW, true);
    n.b(this.vZW, 0L);
    n.p(this.vZW);
    n.l(this.vZW);
    n.q(this.vZW).setVisibility(8);
    n.c(this.vZW, false);
    n.k(this.vZW).vSt = 3;
    n.k(this.vZW).b(n.h(this.vZW));
    n.doZ();
    if (n.h(this.vZW) != null)
    {
      if ((n.h(this.vZW).getText() != null) && (n.h(this.vZW).getText().length() > 0)) {
        n.h(this.vZW).setCursorVisible(true);
      }
      n.h(this.vZW).requestFocus();
      bo.hideVKB(n.f(this.vZW));
    }
    if ((n.r(this.vZW) instanceof Activity)) {
      ((Activity)n.r(this.vZW)).getWindow().addFlags(128);
    }
    n.s(this.vZW).setVisibility(4);
    n.t(this.vZW).setVisibility(4);
    n.u(this.vZW).setVisibility(8);
    n.h(this.vZW).setHint(this.vZW.getResources().getString(2131304554));
    n.n(this.vZW).pd(true);
    n.e(this.vZW).setVisibility(8);
    this.vZW.Mo(1);
    AppMethodBeat.o(27968);
  }
  
  public final void bDt()
  {
    int i = 0;
    AppMethodBeat.i(27969);
    n.n(this.vZW).pd(false);
    n.h(this.vZW).setHint(null);
    TextView localTextView = n.e(this.vZW);
    if ((n.g(this.vZW).size() < 2) || (n.h(this.vZW).getText().length() > 0)) {
      i = 8;
    }
    localTextView.setVisibility(i);
    AppMethodBeat.o(27969);
  }
  
  public final void bDu()
  {
    AppMethodBeat.i(27970);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
    n.v(this.vZW);
    n.k(this.vZW).a(n.h(this.vZW));
    n.l(this.vZW);
    if ((n.r(this.vZW) instanceof Activity)) {
      ((Activity)n.r(this.vZW)).getWindow().clearFlags(128);
    }
    n.Mp(2);
    n.n(this.vZW).pd(false);
    n.h(this.vZW).setHint(null);
    TextView localTextView = n.e(this.vZW);
    if ((n.g(this.vZW).size() < 2) || (n.h(this.vZW).getText().length() > 0)) {}
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(27970);
      return;
    }
  }
  
  public final void bDv()
  {
    AppMethodBeat.i(27971);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    n.k(this.vZW).a(n.h(this.vZW));
    n.l(this.vZW);
    if ((n.r(this.vZW) instanceof Activity)) {
      ((Activity)n.r(this.vZW)).getWindow().clearFlags(128);
    }
    n.Mp(3);
    n.n(this.vZW).pd(false);
    n.h(this.vZW).setHint(null);
    AppMethodBeat.o(27971);
  }
  
  public final void bDw()
  {
    AppMethodBeat.i(27972);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    n.v(this.vZW);
    n.k(this.vZW).a(n.h(this.vZW));
    n.l(this.vZW);
    if ((n.r(this.vZW) instanceof Activity)) {
      ((Activity)n.r(this.vZW)).getWindow().clearFlags(128);
    }
    n.Mq(1);
    n.n(this.vZW).pd(false);
    n.h(this.vZW).setHint(null);
    AppMethodBeat.o(27972);
  }
  
  public final void c(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(138174);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0].length() > 0))
    {
      if (n.w(this.vZW))
      {
        n.d(this.vZW, false);
        n.x(this.vZW);
      }
      n.k(this.vZW).a(n.h(this.vZW), paramArrayOfString[0], true);
      if (n.h(this.vZW).getText().length() != 0)
      {
        n.h(this.vZW).setCursorVisible(true);
        n.h(this.vZW).requestFocus();
        bo.hideVKB(n.f(this.vZW));
      }
      if ((!n.y(this.vZW)) && (paramArrayOfString[0].length() != 0))
      {
        n.b(this.vZW, true);
        n.b(this.vZW, System.currentTimeMillis());
        ab.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.z(this.vZW) - n.o(this.vZW)) });
      }
      n.A(this.vZW).addAll(paramList);
    }
    AppMethodBeat.o(138174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.3
 * JD-Core Version:    0.7.0.1
 */