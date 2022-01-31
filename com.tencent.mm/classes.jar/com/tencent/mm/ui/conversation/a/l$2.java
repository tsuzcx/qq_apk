package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.be;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;

final class l$2
  implements View.OnClickListener
{
  l$2(l paraml, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34677);
    be.aaG().cs(this.bHS, this.yWR);
    paramView = (Context)this.AmR.vUD.get();
    if (paramView != null)
    {
      aw.aaz();
      if (!c.isSDCardAvailable())
      {
        t.ii(paramView);
        AppMethodBeat.o(34677);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("intent_set_avatar", true);
      localIntent.putExtra("KEnterFromBanner", true);
      d.b(paramView, "setting", ".ui.setting.SettingsPersonalInfoUI", localIntent);
      h.qsU.e(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
    }
    AppMethodBeat.o(34677);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.l.2
 * JD-Core Version:    0.7.0.1
 */