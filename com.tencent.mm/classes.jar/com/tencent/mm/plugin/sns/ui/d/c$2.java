package com.tencent.mm.plugin.sns.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.MaskImageButton;

final class c$2
  implements View.OnLongClickListener
{
  c$2(c paramc) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(100202);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    final String str = (String)paramView.getTag();
    ae.d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str)));
    if (bu.isNullOrNil(str))
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(100202);
      return true;
    }
    if (str.equals(ah.dXj()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(100202);
      return true;
    }
    final p localp;
    if ((((MaskImageButton)paramView).hjr != null) && ((((MaskImageButton)paramView).hjr instanceof String)))
    {
      localObject = (String)((MaskImageButton)paramView).hjr;
      new Intent();
      localp = ah.dXE().aBr((String)localObject);
      if ((localp == null) || (!localp.Rt(32))) {
        break label318;
      }
    }
    label318:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(100202);
        return false;
        localObject = "";
        break;
      }
      int[] arrayOfInt = new int[2];
      if ((paramView.getTag(2131306044) instanceof int[])) {
        arrayOfInt = (int[])paramView.getTag(2131306044);
      }
      for (;;)
      {
        new com.tencent.mm.ui.widget.b.a(this.AQE.activity).a(paramView, new View.OnCreateContextMenuListener()new n.e
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(100200);
            g.ajS();
            paramAnonymousView = ((l)g.ab(l.class)).azF().aUL(localp.field_userName);
            paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL();
            int i;
            if (j.DEBUG)
            {
              i = 1;
              if (paramAnonymousContextMenuInfo.getInt("MMSocialBlackListFlag", i) != 1) {
                break label178;
              }
              i = 1;
              label73:
              if ((paramAnonymousView == null) || (localp == null) || (!an.aUq(localp.field_userName)) || (!"3552365301".equals(paramAnonymousView.field_openImAppid))) {
                break label203;
              }
              if (i == 0) {
                break label184;
              }
            }
            label178:
            label184:
            for (paramAnonymousView = c.2.this.AQE.activity.getString(2131757746);; paramAnonymousView = c.2.this.AQE.activity.getString(2131757748))
            {
              paramAnonymousContextMenu.add(0, 0, 0, paramAnonymousView);
              paramAnonymousContextMenu.add(1, 1, 0, c.2.this.AQE.activity.getString(2131764022));
              AppMethodBeat.o(100200);
              return;
              i = 0;
              break;
              i = 0;
              break label73;
            }
            label203:
            if (i != 0) {}
            for (paramAnonymousView = c.2.this.AQE.activity.getString(2131757746);; paramAnonymousView = c.2.this.AQE.activity.getString(2131757747))
            {
              paramAnonymousContextMenu.add(0, 0, 0, paramAnonymousView);
              break;
            }
          }
        }, new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            long l = 0L;
            AppMethodBeat.i(100201);
            switch (paramAnonymousMenuItem.getItemId())
            {
            default: 
              AppMethodBeat.o(100201);
              return;
            case 0: 
              localObject1 = new Intent();
              if (localp == null)
              {
                ((Intent)localObject1).putExtra("sns_permission_snsinfo_svr_id", l);
                ((Intent)localObject1).putExtra("sns_permission_userName", str);
                ((Intent)localObject1).putExtra("sns_permission_anim", true);
                ((Intent)localObject1).putExtra("sns_permission_block_scene", 5);
                paramAnonymousInt = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOK, 0);
                localObject2 = c.2.this.AQE.activity;
                if (paramAnonymousInt != 0) {
                  break label163;
                }
              }
              label163:
              for (paramAnonymousMenuItem = ".ui.PermissionSettingUI";; paramAnonymousMenuItem = ".ui.PermissionSettingUI2")
              {
                d.b((Context)localObject2, "profile", paramAnonymousMenuItem, (Intent)localObject1, 11);
                AppMethodBeat.o(100201);
                return;
                l = localp.field_snsId;
                break;
              }
            }
            Object localObject2 = new Intent();
            Object localObject1 = ah.dXE().aBr(this.AQG);
            if (localObject1 == null)
            {
              ae.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + this.AQG);
              AppMethodBeat.o(100201);
              return;
            }
            ae.i("MicroMsg.TimelineClickListener", "expose id " + ((p)localObject1).getSnsId() + " " + ((p)localObject1).field_userName);
            if (localObject1 == null)
            {
              label268:
              ((Intent)localObject2).putExtra("k_expose_msg_id", l);
              if (localObject1 != null) {
                break label437;
              }
            }
            label437:
            for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = ((p)localObject1).field_userName)
            {
              ((Intent)localObject2).putExtra("k_username", paramAnonymousMenuItem);
              ((Intent)localObject2).putExtra("showShare", false);
              ((Intent)localObject2).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
              d.b(c.2.this.AQE.activity, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
              g.ajS();
              paramAnonymousMenuItem = ((l)g.ab(l.class)).azF().aUL(localp.field_userName);
              if ((paramAnonymousMenuItem == null) || (localp == null) || (!an.aUq(localp.field_userName)) || (!"3552365301".equals(paramAnonymousMenuItem.field_openImAppid))) {
                break;
              }
              paramAnonymousMenuItem = com.tencent.mm.plugin.sns.j.e.zKO;
              com.tencent.mm.plugin.sns.j.e.aAX(((p)localObject1).field_userName);
              break;
              l = ((p)localObject1).field_snsId;
              break label268;
            }
          }
        }, arrayOfInt[0], arrayOfInt[1]);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(100202);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c.2
 * JD-Core Version:    0.7.0.1
 */