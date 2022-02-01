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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.k.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MaskImageButton;

final class b$2
  implements View.OnLongClickListener
{
  b$2(b paramb) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(100202);
    final String str2 = (String)paramView.getTag();
    ad.d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str2)));
    if (bt.isNullOrNil(str2))
    {
      AppMethodBeat.o(100202);
      return true;
    }
    if (str2.equals(com.tencent.mm.plugin.sns.model.af.dta()))
    {
      AppMethodBeat.o(100202);
      return true;
    }
    final String str1;
    final p localp;
    if ((((MaskImageButton)paramView).glT != null) && ((((MaskImageButton)paramView).glT instanceof String)))
    {
      str1 = (String)((MaskImageButton)paramView).glT;
      new Intent();
      localp = com.tencent.mm.plugin.sns.model.af.dtu().apK(str1);
      if ((localp == null) || (!localp.Nb(32))) {
        break label237;
      }
    }
    label237:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        AppMethodBeat.o(100202);
        return false;
        str1 = "";
        break;
      }
      int[] arrayOfInt = new int[2];
      if ((paramView.getTag(2131306044) instanceof int[])) {
        arrayOfInt = (int[])paramView.getTag(2131306044);
      }
      for (;;)
      {
        new com.tencent.mm.ui.widget.b.a(this.xUj.activity).a(paramView, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(100200);
            g.afC();
            paramAnonymousView = ((k)g.ab(k.class)).apM().aHX(localp.field_userName);
            paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd();
            int i;
            if (h.DEBUG)
            {
              i = 1;
              if (paramAnonymousContextMenuInfo.getInt("MMSocialBlackListFlag", i) != 1) {
                break label178;
              }
              i = 1;
              label73:
              if ((paramAnonymousView == null) || (localp == null) || (!com.tencent.mm.storage.af.aHH(localp.field_userName)) || (!"3552365301".equals(paramAnonymousView.field_openImAppid))) {
                break label203;
              }
              if (i == 0) {
                break label184;
              }
            }
            label178:
            label184:
            for (paramAnonymousView = b.2.this.xUj.activity.getString(2131757746);; paramAnonymousView = b.2.this.xUj.activity.getString(2131757748))
            {
              paramAnonymousContextMenu.add(0, 0, 0, paramAnonymousView);
              paramAnonymousContextMenu.add(1, 1, 0, b.2.this.xUj.activity.getString(2131764022));
              AppMethodBeat.o(100200);
              return;
              i = 0;
              break;
              i = 0;
              break label73;
            }
            label203:
            if (i != 0) {}
            for (paramAnonymousView = b.2.this.xUj.activity.getString(2131757746);; paramAnonymousView = b.2.this.xUj.activity.getString(2131757747))
            {
              paramAnonymousContextMenu.add(0, 0, 0, paramAnonymousView);
              break;
            }
          }
        }, new n.d()
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
                ((Intent)localObject1).putExtra("sns_permission_userName", str2);
                ((Intent)localObject1).putExtra("sns_permission_anim", true);
                ((Intent)localObject1).putExtra("sns_permission_block_scene", 5);
                paramAnonymousInt = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pxj, 0);
                localObject2 = b.2.this.xUj.activity;
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
            Object localObject1 = com.tencent.mm.plugin.sns.model.af.dtu().apK(str1);
            if (localObject1 == null)
            {
              ad.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + str1);
              AppMethodBeat.o(100201);
              return;
            }
            ad.i("MicroMsg.TimelineClickListener", "expose id " + ((p)localObject1).getSnsId() + " " + ((p)localObject1).field_userName);
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
              d.b(b.2.this.xUj.activity, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
              g.afC();
              paramAnonymousMenuItem = ((k)g.ab(k.class)).apM().aHX(localp.field_userName);
              if ((paramAnonymousMenuItem == null) || (localp == null) || (!com.tencent.mm.storage.af.aHH(localp.field_userName)) || (!"3552365301".equals(paramAnonymousMenuItem.field_openImAppid))) {
                break;
              }
              paramAnonymousMenuItem = f.wQY;
              f.app(((p)localObject1).field_userName);
              break;
              l = ((p)localObject1).field_snsId;
              break label268;
            }
          }
        }, arrayOfInt[0], arrayOfInt[1]);
        AppMethodBeat.o(100202);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.2
 * JD-Core Version:    0.7.0.1
 */