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
  private String afv;
  
  public a(OverseaReplyTextUI paramOverseaReplyTextUI, String paramString)
  {
    this.afv = paramString;
  }
  
  protected final void execute()
  {
    if (this.ajE.nQ() > 0) {}
    for (int i = 2;; i = 1) {
      try
      {
        Object localObject = new ah();
        ((ah)localObject).XI = this.ajE.getUsername();
        ((ah)localObject).Yn = i;
        ((ah)localObject).Yo = this.afv;
        localObject = new e(this.ajE.nQ(), 11023, ((ah)localObject).toByteArray());
        ((e)localObject).nG();
        ((e)localObject).a(new g()
        {
          public final void nH()
          {
            com.tencent.mm.wear.a.b.a.amv.postDelayed(new Runnable()
            {
              public final void run()
              {
                a.this.ajE.finish();
              }
            }, 1000L);
          }
        });
        h.mP().a((com.tencent.mm.wear.app.g.a)localObject);
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