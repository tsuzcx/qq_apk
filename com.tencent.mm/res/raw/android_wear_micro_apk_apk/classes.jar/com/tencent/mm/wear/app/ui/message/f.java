package com.tencent.mm.wear.app.ui.message;

import com.tencent.mm.e.a.ah;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.f.e;
import com.tencent.mm.wear.app.f.g;
import com.tencent.mm.wear.app.g.b;
import java.io.IOException;

final class f
  extends com.tencent.mm.wear.app.g.a
{
  private f(TextMessageConfirmUI paramTextMessageConfirmUI) {}
  
  protected final void execute()
  {
    int i = 2;
    if (this.akA.nQ() > 0) {}
    for (;;)
    {
      try
      {
        Object localObject = new ah();
        ((ah)localObject).XI = this.akA.getUsername();
        ((ah)localObject).Yn = i;
        ((ah)localObject).Yo = TextMessageConfirmUI.a(this.akA);
        localObject = new e(this.akA.nQ(), 11023, ((ah)localObject).toByteArray());
        ((e)localObject).nG();
        ((e)localObject).a(new g()
        {
          public final void nH()
          {
            com.tencent.mm.wear.a.b.a.amv.postDelayed(new Runnable()
            {
              public final void run()
              {
                f.this.akA.finish();
              }
            }, 1000L);
          }
        });
        h.mP().a((com.tencent.mm.wear.app.g.a)localObject);
        com.tencent.mm.wear.app.d.a.ci(2);
        return;
      }
      catch (IOException localIOException) {}
      i = 1;
    }
  }
  
  protected final String getName()
  {
    return "SendTextTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.f
 * JD-Core Version:    0.7.0.1
 */