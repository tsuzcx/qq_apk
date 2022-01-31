package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.be;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.lang.ref.WeakReference;

final class l$8
  implements View.OnClickListener
{
  l$8(l paraml, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34683);
    be.aaG().cs(this.bHS, this.yWR);
    paramView = (Context)this.AmR.vUD.get();
    aw.aaz();
    String str = (String)c.Ru().get(68377, null);
    aw.aaz();
    c.Ru().set(68377, "");
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_timeline_NeedFirstLoadint", true);
    if (!bo.isNullOrNil(str)) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (n.raS != null)
      {
        bool2 = bool1;
        if (n.raS.bbZ() > 0) {
          bool2 = false;
        }
      }
      localIntent.putExtra("sns_resume_state", bool2);
      com.tencent.mm.bq.d.b(paramView, "sns", ".ui.SnsTimeLineUI", localIntent);
      h.qsU.e(11002, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
      AppMethodBeat.o(34683);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l.8
 * JD-Core Version:    0.7.0.1
 */