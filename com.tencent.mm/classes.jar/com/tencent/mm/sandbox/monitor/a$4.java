package com.tencent.mm.sandbox.monitor;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.Map;
import java.util.TimerTask;

final class a$4
  extends TimerTask
{
  a$4(Map paramMap) {}
  
  public final void run()
  {
    Object localObject = new Intent(ai.getContext(), AppUpdaterUI.class);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("intent_extra_desc", (String)this.GkL.get(".Response.desc"));
    ((Intent)localObject).putExtra("intent_update_type", 999);
    ((Intent)localObject).putExtra("intent_extra_download_url", new String[] { (String)this.GkL.get(".Response.url") });
    Context localContext = ai.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/sandbox/monitor/CrashUpload$4", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/sandbox/monitor/CrashUpload$4", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.a.4
 * JD-Core Version:    0.7.0.1
 */