package com.tencent.mm.pluginsdk.ui.websearch;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.y;

final class WebSearchVoiceInputLayoutImpl$1
  implements View.OnLongClickListener
{
  WebSearchVoiceInputLayoutImpl$1(WebSearchVoiceInputLayoutImpl paramWebSearchVoiceInputLayoutImpl) {}
  
  public final boolean onLongClick(View paramView)
  {
    y.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(this.snR)) });
    WebSearchVoiceInputLayoutImpl.a(this.snR, true);
    WebSearchVoiceInputLayoutImpl.b(this.snR).cmw();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.1
 * JD-Core Version:    0.7.0.1
 */