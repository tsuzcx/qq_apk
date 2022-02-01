package com.tencent.mm.wear.app.g;

import android.content.Context;
import android.content.Intent;
import android.support.wearable.activity.ConfirmationActivity;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;

public abstract class a
  implements Runnable
{
  public a()
  {
    d.d("MicroMsg.BaseWorkerTask", "Create %s", new Object[] { getName() });
  }
  
  public static void ou()
  {
    com.tencent.mm.wear.a.b.a.amv.post(new Runnable()
    {
      public final void run()
      {
        Intent localIntent = new Intent(MMApplication.getContext(), ConfirmationActivity.class);
        localIntent.setFlags(268435456);
        if (this.amn) {
          localIntent.putExtra("animation_type", 1);
        }
        for (;;)
        {
          MMApplication.getContext().startActivity(localIntent);
          return;
          localIntent.putExtra("animation_type", 3);
        }
      }
    });
  }
  
  protected abstract void execute();
  
  protected abstract String getName();
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    d.d("MicroMsg.BaseWorkerTask", "start to execute %s", new Object[] { getName() });
    execute();
    long l2 = System.currentTimeMillis();
    d.c("MicroMsg.BaseWorkerTask", "end to execute %s | use time %d", new Object[] { getName(), Long.valueOf(l2 - l1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.g.a
 * JD-Core Version:    0.7.0.1
 */