package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;

final class m$3
  implements AdapterView.OnItemClickListener
{
  m$3(m paramm) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.sgS.sgO == null) {}
    for (paramAdapterView = null;; paramAdapterView = this.sgS.sgO.pW(paramInt))
    {
      if ((paramAdapterView != null) && (this.sgS.sgJ != null) && (this.sgS.sfs != null))
      {
        this.sgS.sgJ.m(paramAdapterView);
        this.sgS.sfs.clear();
        h.nFQ.f(10994, new Object[] { Integer.valueOf(1), this.sgS.sgK, "", Integer.valueOf(paramInt), paramAdapterView.Wv(), Integer.valueOf(this.sgS.sgO.getCount()) });
      }
      this.sgS.sgH.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.3
 * JD-Core Version:    0.7.0.1
 */