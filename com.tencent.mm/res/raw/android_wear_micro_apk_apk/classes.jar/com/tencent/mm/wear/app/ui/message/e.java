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
  private String aas;
  private int ada;
  private String adf;
  private long agy;
  
  public e(ReplyVoiceUI paramReplyVoiceUI, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    this.aas = paramString1;
    this.agy = paramLong;
    this.adf = paramString2;
    this.ada = paramInt;
  }
  
  protected final void execute()
  {
    Object localObject = c.a(new File(this.aas));
    c.S(this.aas);
    if (localObject == null) {
      return;
    }
    d.c("MicroMsg.ReplyVoiceUI", "try to send voice data to phone, data size=%d | talker=%s", new Object[] { Integer.valueOf(localObject.length), this.adf });
    try
    {
      ai localai = new ai();
      localai.VN = this.adf;
      localai.Wu = this.agy;
      localai.Wo = new com.tencent.mm.d.b((byte[])localObject);
      if (this.ada > 0) {}
      for (localai.Ws = 2;; localai.Ws = 1)
      {
        localObject = new com.tencent.mm.wear.app.f.e(this.ada, 11022, localai.toByteArray());
        ((com.tencent.mm.wear.app.f.e)localObject).a(new g()
        {
          public final void mV()
          {
            com.tencent.mm.wear.a.b.a.aiT.postDelayed(new Runnable()
            {
              public final void run()
              {
                e.this.agA.finish();
              }
            }, 1000L);
          }
        });
        h.mc().a((com.tencent.mm.wear.app.g.a)localObject);
        com.tencent.mm.wear.app.d.a.bM(1);
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