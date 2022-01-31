package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.protocal.d;
import java.util.List;

final class ReaderItemListView$a$2
  implements View.OnClickListener
{
  ReaderItemListView$a$2(ReaderItemListView.a parama, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(76858);
    int i = this.pUD;
    Intent localIntent = new Intent();
    localIntent.putExtra("mode", 1);
    paramView = ((bl)ReaderItemListView.a(this.pUC.pUB).get(i)).getUrl();
    if (paramView.contains("?"))
    {
      paramView = paramView + "&dt=2&cv=0x" + Integer.toHexString(d.whH) + "&w=" + ReaderItemListView.f(this.pUC.pUB).widthPixels;
      localIntent.putExtra("rawUrl", paramView);
      localIntent.putExtra("webpageTitle", ((bl)ReaderItemListView.a(this.pUC.pUB).get(i)).getTitle());
      localIntent.putExtra("title", ReaderItemListView.g(this.pUC.pUB).getString(2131300617));
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      paramView = new Bundle();
      if (((bl)ReaderItemListView.a(this.pUC.pUB).get(i)).type != 20) {
        break label407;
      }
      paramView.putInt("snsWebSource", 3);
    }
    for (;;)
    {
      localIntent.putExtra("jsapiargs", paramView);
      localIntent.putExtra("shortUrl", ((bl)ReaderItemListView.a(this.pUC.pUB).get(i)).aaW());
      localIntent.putExtra("type", ((bl)ReaderItemListView.a(this.pUC.pUB).get(i)).type);
      localIntent.putExtra("tweetid", ((bl)ReaderItemListView.a(this.pUC.pUB).get(i)).aaV());
      localIntent.putExtra("geta8key_username", "blogapp");
      a.gmO.i(localIntent, ReaderItemListView.g(this.pUC.pUB));
      AppMethodBeat.o(76858);
      return;
      paramView = paramView + "?dt=2&cv=0x" + Integer.toHexString(d.whH) + "&w=" + ReaderItemListView.f(this.pUC.pUB).widthPixels;
      break;
      label407:
      paramView.putInt("snsWebSource", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderItemListView.a.2
 * JD-Core Version:    0.7.0.1
 */