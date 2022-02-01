package com.tencent.mm.plugin.sns.ui.listener;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.f;
import com.tencent.mm.ui.tools.MaskImageButton;

final class c$2
  implements View.OnLongClickListener
{
  c$2(c paramc) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(100202);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aYj());
    final String str = (String)paramView.getTag();
    Log.d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str)));
    if (Util.isNullOrNil(str))
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(100202);
      return true;
    }
    if (str.equals(al.hgg()))
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(100202);
      return true;
    }
    final SnsInfo localSnsInfo;
    if ((((MaskImageButton)paramView).nsy != null) && ((((MaskImageButton)paramView).nsy instanceof String)))
    {
      localObject = (String)((MaskImageButton)paramView).nsy;
      new Intent();
      localSnsInfo = al.hgB().aZL((String)localObject);
      if ((localSnsInfo == null) || (!localSnsInfo.isAd())) {
        break label315;
      }
    }
    label315:
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
      if ((paramView.getTag(b.f.touch_loc) instanceof int[])) {
        arrayOfInt = (int[])paramView.getTag(b.f.touch_loc);
      }
      for (;;)
      {
        new com.tencent.mm.ui.widget.b.a(c.f(this.RQM)).a(paramView, new View.OnCreateContextMenuListener()new u.i
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(100200);
            h.baF();
            paramAnonymousView = ((n)h.ax(n.class)).bzA().bxv(localSnsInfo.getUserName());
            int i;
            if (((com.tencent.mm.plugin.zero.b.a)h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("MMSocialBlackListFlag", 1) == 1)
            {
              i = 1;
              if ((paramAnonymousView == null) || (localSnsInfo == null) || (!au.bwO(localSnsInfo.getUserName())) || (!"3552365301".equals(paramAnonymousView.field_openImAppid))) {
                break label188;
              }
              if (i == 0) {
                break label168;
              }
            }
            label168:
            for (paramAnonymousView = c.f(c.2.this.RQM).getString(b.j.contact_info_op_permission);; paramAnonymousView = c.f(c.2.this.RQM).getString(b.j.contact_info_op_sns_permission_openim))
            {
              paramAnonymousContextMenu.add(0, 0, 0, paramAnonymousView);
              paramAnonymousContextMenu.add(1, 1, 0, c.f(c.2.this.RQM).getString(b.j.sns_timeline_expose));
              AppMethodBeat.o(100200);
              return;
              i = 0;
              break;
            }
            label188:
            if (i != 0) {}
            for (paramAnonymousView = c.f(c.2.this.RQM).getString(b.j.contact_info_op_permission);; paramAnonymousView = c.f(c.2.this.RQM).getString(b.j.contact_info_op_sns_permission))
            {
              paramAnonymousContextMenu.add(0, 0, 0, paramAnonymousView);
              break;
            }
          }
        }, new u.i()
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
              if (localSnsInfo == null)
              {
                ((Intent)localObject1).putExtra("sns_permission_snsinfo_svr_id", l);
                ((Intent)localObject1).putExtra("sns_permission_userName", str);
                ((Intent)localObject1).putExtra("sns_permission_anim", true);
                ((Intent)localObject1).putExtra("sns_permission_block_scene", 5);
                paramAnonymousInt = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 0);
                localObject2 = c.f(c.2.this.RQM);
                if (paramAnonymousInt != 0) {
                  break label163;
                }
              }
              label163:
              for (paramAnonymousMenuItem = ".ui.PermissionSettingUI";; paramAnonymousMenuItem = ".ui.PermissionSettingUI2")
              {
                com.tencent.mm.br.c.b((Context)localObject2, "profile", paramAnonymousMenuItem, (Intent)localObject1, 11);
                AppMethodBeat.o(100201);
                return;
                l = localSnsInfo.field_snsId;
                break;
              }
            }
            Object localObject2 = new Intent();
            Object localObject1 = al.hgB().aZL(this.RQO);
            if (localObject1 == null)
            {
              Log.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + this.RQO);
              AppMethodBeat.o(100201);
              return;
            }
            Log.i("MicroMsg.TimelineClickListener", "expose id " + ((SnsInfo)localObject1).getSnsId() + " " + ((SnsInfo)localObject1).field_userName);
            if (localObject1 == null)
            {
              label268:
              ((Intent)localObject2).putExtra("k_expose_msg_id", l);
              if (localObject1 != null) {
                break label438;
              }
            }
            label438:
            for (paramAnonymousMenuItem = "";; paramAnonymousMenuItem = ((SnsInfo)localObject1).field_userName)
            {
              ((Intent)localObject2).putExtra("k_username", paramAnonymousMenuItem);
              ((Intent)localObject2).putExtra("showShare", false);
              ((Intent)localObject2).putExtra("rawUrl", String.format(f.f.adwf, new Object[] { Integer.valueOf(33) }));
              com.tencent.mm.br.c.b(c.f(c.2.this.RQM), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
              h.baF();
              paramAnonymousMenuItem = ((n)h.ax(n.class)).bzA().bxv(localSnsInfo.getUserName());
              if ((paramAnonymousMenuItem == null) || (localSnsInfo == null) || (!au.bwO(localSnsInfo.getUserName())) || (!"3552365301".equals(paramAnonymousMenuItem.field_openImAppid))) {
                break;
              }
              paramAnonymousMenuItem = j.QFS;
              j.aZq(((SnsInfo)localObject1).getUserName());
              break;
              l = ((SnsInfo)localObject1).field_snsId;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.listener.c.2
 * JD-Core Version:    0.7.0.1
 */