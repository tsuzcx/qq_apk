package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;

final class k$8
  implements View.OnClickListener
{
  k$8(k paramk, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    bc.HI().bi(this.bns, this.uJr);
    paramView = (Context)this.vUP.sdy.get();
    au.Hx();
    String str = (String)c.Dz().get(68377, null);
    au.Hx();
    c.Dz().o(68377, "");
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
    if (!bk.bl(str)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (n.omE != null)
      {
        bool2 = bool1;
        if (n.omE.aAo() > 0) {
          bool2 = false;
        }
      }
      localIntent.putExtra("sns_resume_state", bool2);
      com.tencent.mm.br.d.b(paramView, "sns", ".ui.SnsTimeLineUI", localIntent);
      h.nFQ.f(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k.8
 * JD-Core Version:    0.7.0.1
 */