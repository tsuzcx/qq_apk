package com.tencent.mm.pluginsdk.ui.websearch;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WebSearchVoiceInputLayoutImpl$2
  implements View.OnTouchListener
{
  WebSearchVoiceInputLayoutImpl$2(WebSearchVoiceInputLayoutImpl paramWebSearchVoiceInputLayoutImpl) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(28222);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(28222);
      return false;
      WebSearchVoiceInputLayoutImpl.a(this.wgp, false);
      WebSearchVoiceInputLayoutImpl.a(this.wgp, bo.yB());
      ab.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(this.wgp)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(this.wgp)) });
      WebSearchVoiceInputLayoutImpl.b(this.wgp).dnn();
      this.wgp.B(false, false);
      continue;
      ab.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(this.wgp)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(this.wgp)) });
      if (WebSearchVoiceInputLayoutImpl.f(this.wgp))
      {
        this.wgp.B(true, false);
        WebSearchVoiceInputLayoutImpl.a(this.wgp, false);
        WebSearchVoiceInputLayoutImpl.a(this.wgp, 0L);
      }
      else
      {
        this.wgp.B(false, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.2
 * JD-Core Version:    0.7.0.1
 */