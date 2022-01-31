package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.n;

final class ReaderAppUI$9
  implements View.OnClickListener
{
  ReaderAppUI$9(ReaderAppUI paramReaderAppUI, int paramInt1, String paramString, bl parambl, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(76821);
    if (20 == this.bHS)
    {
      h.qsU.e(15413, new Object[] { Integer.valueOf(8), this.pUh, this.pUi.getTitle() });
      paramView = new Intent();
      paramView.putExtra("mode", 1);
      Object localObject = this.pUi.getUrl();
      paramView.putExtra("news_svr_id", this.pUi.fnt);
      paramView.putExtra("news_svr_tweetid", this.pUi.aaV());
      paramView.putExtra("rawUrl", ReaderAppUI.a(this.pUg, (String)localObject));
      paramView.putExtra("title", this.pUi.getName());
      paramView.putExtra("webpageTitle", this.pUi.getTitle());
      paramView.putExtra("useJs", true);
      paramView.putExtra("vertical_scroll", true);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("snsWebSource", 3);
      paramView.putExtra("jsapiargs", (Bundle)localObject);
      paramView.putExtra("shortUrl", this.pUi.aaW());
      paramView.putExtra("type", this.pUi.type);
      paramView.putExtra("tweetid", this.pUi.aaV());
      paramView.putExtra("geta8key_username", "newsapp");
      paramView.putExtra("KPublisherId", "msg_" + Long.toString(this.pUi.fnt));
      paramView.putExtra("pre_username", "newsapp");
      paramView.putExtra("prePublishId", "msg_" + Long.toString(this.pUi.fnt));
      paramView.putExtra("preUsername", "newsapp");
      paramView.putExtra("preChatName", "newsapp");
      paramView.putExtra("preMsgIndex", this.pUj);
      paramView.putExtra("geta8key_scene", 16);
      paramView.addFlags(536870912);
      a.gmO.i(paramView, this.pUg);
    }
    AppMethodBeat.o(76821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.9
 * JD-Core Version:    0.7.0.1
 */