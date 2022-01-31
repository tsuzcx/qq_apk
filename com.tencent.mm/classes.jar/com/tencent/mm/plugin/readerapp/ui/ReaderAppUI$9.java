package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;

final class ReaderAppUI$9
  implements View.OnClickListener
{
  ReaderAppUI$9(ReaderAppUI paramReaderAppUI, int paramInt1, String paramString, bj parambj, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    if (20 == this.bns)
    {
      h.nFQ.f(15413, new Object[] { Integer.valueOf(8), this.noT, this.noU.getTitle() });
      paramView = new Intent();
      paramView.putExtra("mode", 1);
      Object localObject = this.noU.getUrl();
      paramView.putExtra("news_svr_id", this.noU.dXl);
      paramView.putExtra("news_svr_tweetid", this.noU.HW());
      paramView.putExtra("rawUrl", ReaderAppUI.a(this.noS, (String)localObject));
      paramView.putExtra("title", this.noU.getName());
      paramView.putExtra("webpageTitle", this.noU.getTitle());
      paramView.putExtra("useJs", true);
      paramView.putExtra("vertical_scroll", true);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("snsWebSource", 3);
      paramView.putExtra("jsapiargs", (Bundle)localObject);
      paramView.putExtra("shortUrl", this.noU.HX());
      paramView.putExtra("type", this.noU.type);
      paramView.putExtra("tweetid", this.noU.HW());
      paramView.putExtra("geta8key_username", "newsapp");
      paramView.putExtra("KPublisherId", "msg_" + Long.toString(this.noU.dXl));
      paramView.putExtra("pre_username", "newsapp");
      paramView.putExtra("prePublishId", "msg_" + Long.toString(this.noU.dXl));
      paramView.putExtra("preUsername", "newsapp");
      paramView.putExtra("preChatName", "newsapp");
      paramView.putExtra("preMsgIndex", this.noV);
      paramView.putExtra("geta8key_scene", 16);
      paramView.addFlags(536870912);
      a.eUR.j(paramView, this.noS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.9
 * JD-Core Version:    0.7.0.1
 */