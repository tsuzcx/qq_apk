package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.pluginsdk.model.app.g;

final class ReadMailUI$6
  implements Runnable
{
  ReadMailUI$6(ReadMailUI paramReadMailUI) {}
  
  public final void run()
  {
    Intent localIntent = this.njK.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
    g.a(this.njK, localIntent, this.njK.getString(b.j.chatfooter_mail_without_unread_count), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.6
 * JD-Core Version:    0.7.0.1
 */