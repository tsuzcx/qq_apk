package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.report.service.h;
import java.lang.ref.WeakReference;

final class k$5
  implements View.OnClickListener
{
  k$5(k paramk, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    bc.HI().bi(this.bns, this.uJr);
    paramView = (Context)this.vUP.sdy.get();
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 17);
    d.b(paramView, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
    h.nFQ.f(11002, new Object[] { Integer.valueOf(10), Integer.valueOf(1) });
    h.nFQ.f(12065, new Object[] { Integer.valueOf(2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k.5
 * JD-Core Version:    0.7.0.1
 */