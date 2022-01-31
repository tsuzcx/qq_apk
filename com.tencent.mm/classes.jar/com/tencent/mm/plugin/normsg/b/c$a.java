package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class c$a
  implements View.OnClickListener
{
  private final View.OnClickListener pib;
  
  c$a(View.OnClickListener paramOnClickListener)
  {
    this.pib = paramOnClickListener;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(10432);
    synchronized (c.access$000())
    {
      if (!c.access$000().containsKey(paramView))
      {
        if (this.pib != null) {
          this.pib.onClick(paramView);
        }
        AppMethodBeat.o(10432);
        return;
      }
    }
    for (;;)
    {
      synchronized (c.ajx())
      {
        for (;;)
        {
          if (!c.ajx().containsKey(paramView))
          {
            Class localClass = (Class)c.access$000().get(paramView);
            if (localClass != null) {}
            try
            {
              a.ymk.l((b)localClass.newInstance());
              break;
              paramView = finally;
              AppMethodBeat.o(10432);
              throw paramView;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.CBCH", localThrowable, "failure to instantiate event class: " + localClass.getName(), new Object[0]);
              }
            }
          }
        }
      }
      c.ajx().remove(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.c.a
 * JD-Core Version:    0.7.0.1
 */