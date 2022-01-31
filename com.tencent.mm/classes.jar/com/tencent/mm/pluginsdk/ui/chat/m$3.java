package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.o;

final class m$3
  implements AdapterView.OnItemClickListener
{
  m$3(m paramm) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(62456);
    if (this.vZl.vZh == null) {}
    for (paramAdapterView = null;; paramAdapterView = this.vZl.vZh.ur(paramInt))
    {
      if ((paramAdapterView != null) && (this.vZl.vZc != null) && (this.vZl.vWL != null))
      {
        this.vZl.vZc.B(paramAdapterView);
        this.vZl.vWL.clear();
        h.qsU.e(10994, new Object[] { Integer.valueOf(1), this.vZl.vZd, "", Integer.valueOf(paramInt), paramAdapterView.Al(), Integer.valueOf(this.vZl.vZh.getCount()) });
      }
      this.vZl.vZa.dismiss();
      AppMethodBeat.o(62456);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.m.3
 * JD-Core Version:    0.7.0.1
 */