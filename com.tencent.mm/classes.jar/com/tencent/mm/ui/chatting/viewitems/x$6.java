package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class x$6
  implements View.OnClickListener
{
  x$6(x paramx, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33132);
    if (!bo.isNullOrNil(this.val$url))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.val$url);
      d.b(x.b(this.zVk).zJz.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      h.qsU.e(11608, new Object[] { x.d(this.zVk), this.vqy, Integer.valueOf(2) });
    }
    AppMethodBeat.o(33132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.6
 * JD-Core Version:    0.7.0.1
 */