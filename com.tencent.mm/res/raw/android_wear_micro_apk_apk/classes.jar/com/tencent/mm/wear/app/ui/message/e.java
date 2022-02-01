package com.tencent.mm.wear.app.ui.message;

import com.tencent.mm.e.a.ai;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.a.f.c;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.f.g;
import java.io.File;
import java.io.IOException;

final class e
  extends com.tencent.mm.wear.app.g.a
{
  private String adT;
  private int agB;
  private String agG;
  private long aka;
  
  public e(ReplyVoiceUI paramReplyVoiceUI, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    this.adT = paramString1;
    this.aka = paramLong;
    this.agG = paramString2;
    this.agB = paramInt;
  }
  
  protected final void execute()
  {
    Object localObject = c.a(new File(this.adT));
    c.Z(this.adT);
    if (localObject == null) {
      return;
    }
    d.c("MicroMsg.ReplyVoiceUI", "try to send voice data to phone, data size=%d | talker=%s", new Object[] { Integer.valueOf(localObject.length), this.agG });
    try
    {
      ai localai = new ai();
      localai.XI = this.agG;
      localai.Yp = this.aka;
      localai.Yj = new com.tencent.mm.d.b((byte[])localObject);
      if (this.agB > 0) {}
      for (localai.Yn = 2;; localai.Yn = 1)
      {
        localObject = new com.tencent.mm.wear.app.f.e(this.agB, 11022, localai.toByteArray());
        ((com.tencent.mm.wear.app.f.e)localObject).a(new g()
        {
          public final void nH()
          {
            com.tencent.mm.wear.a.b.a.amv.postDelayed(new Runnable()
            {
              public final void run()
              {
                e.this.akc.finish();
              }
            }, 1000L);
          }
        });
        h.mP().a((com.tencent.mm.wear.app.g.a)localObject);
        com.tencent.mm.wear.app.d.a.ci(1);
        return;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  protected final String getName()
  {
    return "SendVoiceTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.e
 * JD-Core Version:    0.7.0.1
 */