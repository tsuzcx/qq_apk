package com.tencent.mm.pluginsdk.ui.websearch;

import android.app.Activity;
import android.content.res.Resources;
import android.media.AudioManager;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.List;

final class a$5
  implements VoiceInputLayout.b
{
  a$5(a parama) {}
  
  public final void at(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(28250);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Long.valueOf(System.currentTimeMillis()) });
    a.d(this.wgr);
    if ((a.j(this.wgr) instanceof Activity)) {
      ((Activity)a.j(this.wgr)).getWindow().clearFlags(128);
    }
    if (paramInt1 == 12) {
      a.a(this.wgr, 2131304555);
    }
    for (;;)
    {
      a.e(this.wgr).pd(false);
      a.c(this.wgr).setHint(null);
      AppMethodBeat.o(28250);
      return;
      a.a(this.wgr, 2131296926);
    }
  }
  
  public final void bDq()
  {
    AppMethodBeat.i(28244);
    a.a(this.wgr, System.currentTimeMillis());
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", new Object[] { Long.valueOf(a.g(this.wgr)) });
    ab.d("VOICEDEBUG", "Start Record Time = %s", new Object[] { Long.valueOf(a.g(this.wgr)) });
    a.b(this.wgr, false);
    a.c(this.wgr, true);
    a.d(this.wgr, true);
    a.b(this.wgr, 0L);
    a.h(this.wgr);
    a.d(this.wgr);
    a.i(this.wgr).setVisibility(8);
    a.c(this.wgr, false);
    a locala = this.wgr;
    if (locala.elW != null) {
      locala.elW.setStreamMute(3, true);
    }
    if ((a.j(this.wgr) instanceof Activity)) {
      ((Activity)a.j(this.wgr)).getWindow().addFlags(128);
    }
    a.k(this.wgr).setVisibility(4);
    a.l(this.wgr).setVisibility(4);
    a.m(this.wgr).setVisibility(8);
    a.c(this.wgr).setHint(this.wgr.getResources().getString(2131304554));
    a.e(this.wgr).pd(true);
    AppMethodBeat.o(28244);
  }
  
  public final void bDt()
  {
    AppMethodBeat.i(28245);
    a.e(this.wgr).pd(false);
    a.c(this.wgr).setHint(null);
    AppMethodBeat.o(28245);
  }
  
  public final void bDu()
  {
    AppMethodBeat.i(28246);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
    a.d(this.wgr);
    if ((a.j(this.wgr) instanceof Activity)) {
      ((Activity)a.j(this.wgr)).getWindow().clearFlags(128);
    }
    a.e(this.wgr).pd(false);
    a.c(this.wgr).setHint(null);
    a.b(this.wgr, 2);
    AppMethodBeat.o(28246);
  }
  
  public final void bDv()
  {
    AppMethodBeat.i(28247);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    a.d(this.wgr);
    if ((a.j(this.wgr) instanceof Activity)) {
      ((Activity)a.j(this.wgr)).getWindow().clearFlags(128);
    }
    a.e(this.wgr).pd(false);
    a.c(this.wgr).setHint(null);
    AppMethodBeat.o(28247);
  }
  
  public final void bDw()
  {
    AppMethodBeat.i(28248);
    ab.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    a.d(this.wgr);
    if ((a.j(this.wgr) instanceof Activity)) {
      ((Activity)a.j(this.wgr)).getWindow().clearFlags(128);
    }
    a.e(this.wgr).pd(false);
    a.c(this.wgr).setHint(null);
    a.b(this.wgr, 2);
    AppMethodBeat.o(28248);
  }
  
  public final void c(String[] paramArrayOfString, List<String> paramList)
  {
    AppMethodBeat.i(138175);
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0].length() > 0))
    {
      if (a.n(this.wgr)) {
        a.d(this.wgr, false);
      }
      ab.i("MicroMsg.VoiceInputPanel", "onDetected %s", new Object[] { paramArrayOfString[0] });
      a.c(this.wgr).setText(paramArrayOfString[0]);
      if ((!a.o(this.wgr)) && (paramArrayOfString[0].length() != 0))
      {
        a.b(this.wgr, true);
        a.b(this.wgr, System.currentTimeMillis());
        ab.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", new Object[] { Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.p(this.wgr) - a.g(this.wgr)) });
      }
      a.q(this.wgr).addAll(paramList);
    }
    AppMethodBeat.o(138175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.a.5
 * JD-Core Version:    0.7.0.1
 */