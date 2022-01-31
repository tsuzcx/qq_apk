package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.r;

final class q$a
  implements Runnable
{
  String url;
  
  private q$a(q paramq) {}
  
  public final void run()
  {
    if ((this.nMN.nLB == null) || (q.e(this.nMN))) {
      return;
    }
    r.a(new e());
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jsapi_args_appid", "wx751a1acca5688ba3");
    localIntent.putExtra("jsapiargs", localBundle);
    localIntent.putExtra("rawUrl", this.url);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("title", R.l.scan_entry_street);
    localIntent.putExtra("webview_bg_color_rsID", R.e.black);
    localIntent.putExtra("geta8key_scene", 13);
    localIntent.setFlags(65536);
    b.eUR.j(localIntent, this.nMN.nLB.getContext());
    this.nMN.nLB.getContext().finish();
    this.nMN.nLB.getContext().overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.q.a
 * JD-Core Version:    0.7.0.1
 */