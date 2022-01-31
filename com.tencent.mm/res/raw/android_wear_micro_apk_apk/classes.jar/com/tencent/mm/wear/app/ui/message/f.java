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
    if (this.agY.nd() > 0) {}
    for (;;)
    {
      try
      {
        Object localObject = new ah();
        ((ah)localObject).VN = this.agY.getUsername();
        ((ah)localObject).Ws = i;
        ((ah)localObject).Wt = TextMessageConfirmUI.a(this.agY);
        localObject = new e(this.agY.nd(), 11023, ((ah)localObject).toByteArray());
        ((e)localObject).mU();
        ((e)localObject).a(new g()
        {
          public final void mV()
          {
            com.tencent.mm.wear.a.b.a.aiT.postDelayed(new Runnable()
            {
              public final void run()
              {
                f.this.agY.finish();
              }
            }, 1000L);
          }
        });
        h.mc().a((com.tencent.mm.wear.app.g.a)localObject);
        com.tencent.mm.wear.app.d.a.bM(2);
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