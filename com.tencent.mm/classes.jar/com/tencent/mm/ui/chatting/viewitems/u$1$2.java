package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.cnj;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

final class u$1$2
  implements n.d
{
  u$1$2(u.1 param1, View paramView, String paramString, int paramInt1, int paramInt2, bi parambi) {}
  
  public final void onMMMenuItemSelected(final MenuItem paramMenuItem, int paramInt)
  {
    y.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramMenuItem.getItemId()), Integer.valueOf(paramInt) });
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    }
    au.Dk().a(1198, new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
      {
        au.Dk().b(1198, this);
        y.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString, Boolean.valueOf(false) });
        if (u.a(u.1.2.this.vEa.vDZ) != null)
        {
          u.a(u.1.2.this.vEa.vDZ).dismiss();
          u.a(u.1.2.this.vEa.vDZ, null);
        }
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          com.tencent.mm.ui.base.s.makeText(u.1.2.this.hdG.getContext(), R.l.notify_message_settings_complain_failed, 0).show();
          return;
        }
        paramAnonymousString = ((com.tencent.mm.modelappbrand.s)paramAnonymousm).Jy();
        if (paramAnonymousString == null)
        {
          com.tencent.mm.ui.base.s.makeText(u.1.2.this.hdG.getContext(), R.l.notify_message_settings_complain_failed, 0).show();
          return;
        }
        paramAnonymousString = paramAnonymousString.uad;
        y.i("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { u.1.2.this.rzx });
        ((c)g.r(c.class)).a(u.1.2.this.rzx, new u.1.2.1.1(this, paramAnonymousString));
      }
    });
    paramMenuItem = new com.tencent.mm.modelappbrand.s(this.dUy.field_content);
    u localu = this.vEa.vDZ;
    Context localContext = this.hdG.getContext();
    this.hdG.getResources().getString(R.l.app_tip);
    u.a(localu, h.b(localContext, this.hdG.getResources().getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        au.Dk().c(paramMenuItem);
      }
    }));
    au.Dk().a(paramMenuItem, 0);
    u.C(4, u.c(this.vEa.vDZ), u.d(this.vEa.vDZ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.1.2
 * JD-Core Version:    0.7.0.1
 */