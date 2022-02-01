package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bv;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.z;

final class ReaderAppUI$2
  implements View.OnClickListener
{
  ReaderAppUI$2(ReaderAppUI paramReaderAppUI, int paramInt1, String paramString, bv parambv, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(161677);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (20 == this.val$type)
    {
      h.CyF.a(15413, new Object[] { Integer.valueOf(8), this.BCv, this.BCw.getTitle() });
      paramView = new Intent();
      paramView.putExtra("mode", 1);
      localObject = this.BCw.getUrl();
      paramView.putExtra("news_svr_id", this.BCw.iFs);
      paramView.putExtra("news_svr_tweetid", this.BCw.aVZ());
      paramView.putExtra("rawUrl", ReaderAppUI.a(this.BCu, (String)localObject));
      paramView.putExtra("title", this.BCw.getName());
      paramView.putExtra("webpageTitle", this.BCw.getTitle());
      paramView.putExtra("key_show_web_page_title", true);
      paramView.putExtra("useJs", true);
      paramView.putExtra("vertical_scroll", true);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("snsWebSource", 3);
      paramView.putExtra("jsapiargs", (Bundle)localObject);
      paramView.putExtra("shortUrl", this.BCw.aWa());
      paramView.putExtra("type", this.BCw.type);
      paramView.putExtra("tweetid", this.BCw.aVZ());
      paramView.putExtra("geta8key_username", "newsapp");
      paramView.putExtra("KPublisherId", "msg_" + Long.toString(this.BCw.iFs));
      paramView.putExtra("pre_username", "newsapp");
      paramView.putExtra("prePublishId", "msg_" + Long.toString(this.BCw.iFs));
      paramView.putExtra("preUsername", "newsapp");
      paramView.putExtra("preChatName", "newsapp");
      paramView.putExtra("preMsgIndex", this.BCx);
      paramView.putExtra("geta8key_scene", 66);
      paramView.putExtra("webview_scene_type", 1);
      paramView.putExtra("webview_scene_note", z.bfG(String.format("%d|%d|%s|%s|%s", new Object[] { Integer.valueOf(this.BCw.aWh()), Integer.valueOf(this.BCw.aWf()), this.BCw.avy(), this.BCv, this.BCw.aVZ() })));
      paramView.putExtra("bizEnterId", (int)(System.currentTimeMillis() / 1000L));
      paramView.putExtra("KOpenArticleSceneFromScene", 0);
      paramView.addFlags(536870912);
      com.tencent.mm.plugin.readerapp.b.a.jRt.i(paramView, this.BCu);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/readerapp/ui/ReaderAppUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(161677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.2
 * JD-Core Version:    0.7.0.1
 */