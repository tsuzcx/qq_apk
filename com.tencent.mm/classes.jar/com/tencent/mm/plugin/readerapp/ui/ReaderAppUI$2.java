package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.i.c;
import com.tencent.mm.plugin.webview.i.d;
import com.tencent.mm.plugin.webview.k.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import kotlin.g.b.p;

final class ReaderAppUI$2
  implements View.OnClickListener
{
  ReaderAppUI$2(ReaderAppUI paramReaderAppUI, int paramInt1, String paramString, bw parambw, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(161677);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    if (20 == this.val$type)
    {
      h.IzE.a(15413, new Object[] { Integer.valueOf(8), this.Hyz, this.HyA.getTitle() });
      paramView = new Intent();
      paramView.putExtra("mode", 1);
      localObject1 = this.HyA.getUrl();
      paramView.putExtra("news_svr_id", this.HyA.lvs);
      paramView.putExtra("news_svr_tweetid", this.HyA.bfc());
      paramView.putExtra("rawUrl", ReaderAppUI.a(this.Hyy, (String)localObject1));
      paramView.putExtra("title", this.HyA.getName());
      paramView.putExtra("webpageTitle", this.HyA.getTitle());
      paramView.putExtra("key_show_web_page_title", true);
      paramView.putExtra("useJs", true);
      paramView.putExtra("vertical_scroll", true);
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("snsWebSource", 3);
      paramView.putExtra("jsapiargs", (Bundle)localObject2);
      paramView.putExtra("shortUrl", this.HyA.bfd());
      paramView.putExtra("type", this.HyA.type);
      paramView.putExtra("tweetid", this.HyA.bfc());
      paramView.putExtra("geta8key_username", "newsapp");
      paramView.putExtra("KPublisherId", "msg_" + Long.toString(this.HyA.lvs));
      paramView.putExtra("pre_username", "newsapp");
      paramView.putExtra("prePublishId", "msg_" + Long.toString(this.HyA.lvs));
      paramView.putExtra("preUsername", "newsapp");
      paramView.putExtra("preChatName", "newsapp");
      paramView.putExtra("preMsgIndex", this.HyB);
      paramView.putExtra("geta8key_scene", 66);
      paramView.putExtra("webview_scene_type", 1);
      paramView.putExtra("webview_scene_note", ab.aXb(String.format("%d|%d|%s|%s|%s", new Object[] { Integer.valueOf(this.HyA.bfk()), Integer.valueOf(this.HyA.bfi()), this.HyA.aCt(), this.Hyz, this.HyA.bfc() })));
      paramView.putExtra("bizEnterId", (int)(System.currentTimeMillis() / 1000L));
      paramView.putExtra("KOpenArticleSceneFromScene", 0);
      paramView.addFlags(536870912);
      localObject2 = o.QAC;
      localObject2 = d.PZK;
      p.k(localObject1, "url");
      p.k(localObject2, "action");
      if (o.a(true, (String)localObject1, (d)localObject2, c.PZE, 0L)) {
        paramView.putExtra("prefetch_has_report_in_click", true);
      }
      com.tencent.mm.plugin.readerapp.b.a.mIG.h(paramView, this.Hyy);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(161677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.2
 * JD-Core Version:    0.7.0.1
 */