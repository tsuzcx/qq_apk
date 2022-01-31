package com.tencent.mm.plugin.normsg.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class c$a
  implements View.OnClickListener
{
  private final View.OnClickListener mHV;
  
  c$a(View.OnClickListener paramOnClickListener)
  {
    this.mHV = paramOnClickListener;
  }
  
  public final void onClick(View paramView)
  {
    synchronized ()
    {
      if (!c.aiY().containsKey(paramView))
      {
        if (this.mHV != null) {
          this.mHV.onClick(paramView);
        }
        return;
      }
    }
    for (;;)
    {
      synchronized (c.Qq())
      {
        for (;;)
        {
          if (!c.Qq().containsKey(paramView))
          {
            Class localClass = (Class)c.aiY().get(paramView);
            if (localClass != null) {}
            try
            {
              a.udP.m((b)localClass.newInstance());
              break;
              paramView = finally;
              throw paramView;
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                y.printErrStackTrace("MicroMsg.CBCH", localThrowable, "failure to instantiate event class: " + localClass.getName(), new Object[0]);
              }
            }
          }
        }
      }
      c.Qq().remove(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.c.a
 * JD-Core Version:    0.7.0.1
 */