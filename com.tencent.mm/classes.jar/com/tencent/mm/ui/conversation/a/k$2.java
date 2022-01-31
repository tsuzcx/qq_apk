package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.s;
import java.lang.ref.WeakReference;

final class k$2
  implements View.OnClickListener
{
  k$2(k paramk, int paramInt1, int paramInt2) {}
  
  public final void onClick(View paramView)
  {
    bc.HI().bi(this.bns, this.uJr);
    paramView = (Context)this.vUP.sdy.get();
    if (paramView != null)
    {
      au.Hx();
      if (!c.isSDCardAvailable()) {
        s.gM(paramView);
      }
    }
    else
    {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("intent_set_avatar", true);
    localIntent.putExtra("KEnterFromBanner", true);
    d.b(paramView, "setting", ".ui.setting.SettingsPersonalInfoUI", localIntent);
    h.nFQ.f(11002, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k.2
 * JD-Core Version:    0.7.0.1
 */