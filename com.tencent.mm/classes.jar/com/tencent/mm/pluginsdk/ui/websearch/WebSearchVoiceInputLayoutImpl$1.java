package com.tencent.mm.pluginsdk.ui.websearch;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.k;
import com.tencent.mm.sdk.platformtools.ab;

final class WebSearchVoiceInputLayoutImpl$1
  implements View.OnLongClickListener
{
  WebSearchVoiceInputLayoutImpl$1(WebSearchVoiceInputLayoutImpl paramWebSearchVoiceInputLayoutImpl) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(28221);
    ab.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(this.wgp)) });
    WebSearchVoiceInputLayoutImpl.a(this.wgp, true);
    WebSearchVoiceInputLayoutImpl.b(this.wgp).dnm();
    AppMethodBeat.o(28221);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.1
 * JD-Core Version:    0.7.0.1
 */