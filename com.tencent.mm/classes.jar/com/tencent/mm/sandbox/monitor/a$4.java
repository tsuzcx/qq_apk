package com.tencent.mm.sandbox.monitor;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import java.util.TimerTask;

final class a$4
  extends TimerTask
{
  a$4(Map paramMap) {}
  
  public final void run()
  {
    Object localObject = new Intent(MMApplicationContext.getContext(), AppUpdaterUI.class);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("intent_extra_desc", (String)this.NEc.get(".Response.desc"));
    ((Intent)localObject).putExtra("intent_update_type", 999);
    ((Intent)localObject).putExtra("intent_extra_download_url", new String[] { (String)this.NEc.get(".Response.url") });
    Context localContext = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/sandbox/monitor/CrashUpload$4", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/sandbox/monitor/CrashUpload$4", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sandbox.monitor.a.4
 * JD-Core Version:    0.7.0.1
 */