package com.tencent.mm.wear.app.ui.message;

import com.tencent.mm.e.a.ah;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.f.e;
import com.tencent.mm.wear.app.f.g;
import com.tencent.mm.wear.app.g.b;
import java.io.IOException;

final class a
  extends com.tencent.mm.wear.app.g.a
{
  private String abU;
  
  public a(OverseaReplyTextUI paramOverseaReplyTextUI, String paramString)
  {
    this.abU = paramString;
  }
  
  protected final void execute()
  {
    if (this.agc.nd() > 0) {}
    for (int i = 2;; i = 1) {
      try
      {
        Object localObject = new ah();
        ((ah)localObject).VN = this.agc.getUsername();
        ((ah)localObject).Ws = i;
        ((ah)localObject).Wt = this.abU;
        localObject = new e(this.agc.nd(), 11023, ((ah)localObject).toByteArray());
        ((e)localObject).mU();
        ((e)localObject).a(new g()
        {
          public final void mV()
          {
            com.tencent.mm.wear.a.b.a.aiT.postDelayed(new Runnable()
            {
              public final void run()
              {
                a.this.agc.finish();
              }
            }, 1000L);
          }
        });
        h.mc().a((com.tencent.mm.wear.app.g.a)localObject);
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  protected final String getName()
  {
    return "SendTextTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.a
 * JD-Core Version:    0.7.0.1
 */