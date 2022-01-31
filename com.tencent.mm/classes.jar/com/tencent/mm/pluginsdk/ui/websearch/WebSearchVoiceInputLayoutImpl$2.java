package com.tencent.mm.pluginsdk.ui.websearch;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebSearchVoiceInputLayoutImpl$2
  implements View.OnTouchListener
{
  WebSearchVoiceInputLayoutImpl$2(WebSearchVoiceInputLayoutImpl paramWebSearchVoiceInputLayoutImpl) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      WebSearchVoiceInputLayoutImpl.a(this.snR, false);
      WebSearchVoiceInputLayoutImpl.a(this.snR, bk.UZ());
      y.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(this.snR)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(this.snR)) });
      WebSearchVoiceInputLayoutImpl.b(this.snR).cmx();
      this.snR.y(false, false);
      return false;
    }
    y.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(this.snR)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(this.snR)) });
    if (WebSearchVoiceInputLayoutImpl.f(this.snR))
    {
      this.snR.y(true, false);
      WebSearchVoiceInputLayoutImpl.a(this.snR, false);
      WebSearchVoiceInputLayoutImpl.a(this.snR, 0L);
      return false;
    }
    this.snR.y(false, true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.2
 * JD-Core Version:    0.7.0.1
 */