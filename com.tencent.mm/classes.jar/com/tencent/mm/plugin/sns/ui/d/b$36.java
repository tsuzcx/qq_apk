package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class b$36
  implements View.OnClickListener
{
  b$36(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof String)) {}
    do
    {
      return;
      paramView = (String)paramView.getTag();
      paramView = af.bDF().OB(paramView);
    } while ((paramView == null) || (!paramView.yr(32)));
    y.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
    paramView = b.a(this.ppl, paramView);
    if (paramView == null)
    {
      y.e("MicroMsg.TimelineClickListener", "the adInfo is null");
      return;
    }
    if (bk.bl(paramView.oAh))
    {
      y.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
      return;
    }
    y.i("MicroMsg.TimelineClickListener", "open webview url : " + paramView.oAh);
    Intent localIntent = new Intent();
    localIntent.putExtra("jsapiargs", new Bundle());
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("rawUrl", paramView.oAh);
    com.tencent.mm.plugin.sns.c.a.eUR.j(localIntent, this.ppl.activity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.36
 * JD-Core Version:    0.7.0.1
 */