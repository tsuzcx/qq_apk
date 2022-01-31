package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.h.c;

final class l$7$1
  implements h.c
{
  l$7$1(l.7 param7, String paramString) {}
  
  public final void gl(int paramInt)
  {
    if (this.sjQ.sjL != null) {
      this.sjQ.sjL.onDismiss(null);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (l.coc())
      {
        Context localContext = this.sjQ.val$context;
        String str = this.ixq;
        Intent localIntent = new Intent("android.intent.action.INSERT");
        localIntent.setType("vnd.android.cursor.dir/contact");
        localIntent.putExtra("phone", str);
        localContext.startActivity(localIntent);
        h.nFQ.aC(10113, "1");
        return;
      }
      l.bp(this.sjQ.val$context, this.ixq);
      h.nFQ.aC(10114, "1");
      return;
    }
    l.bp(this.sjQ.val$context, this.ixq);
    h.nFQ.aC(10114, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.7.1
 * JD-Core Version:    0.7.0.1
 */