package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.f;
import com.tencent.mm.as.g;
import com.tencent.mm.as.l;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

final class ao$5
  implements n.d
{
  ao$5(bi parambi, Context paramContext, boolean paramBoolean, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 1;
    String str = paramMenuItem.getTitle();
    if (this.dUy.field_msgId > 0L) {}
    for (paramMenuItem = o.OJ().bY(this.dUy.field_msgId);; paramMenuItem = null)
    {
      if (((paramMenuItem == null) || (paramMenuItem.enp <= 0L)) && (this.dUy.field_msgSvrId > 0L)) {
        paramMenuItem = o.OJ().bX(this.dUy.field_msgSvrId);
      }
      for (;;)
      {
        if (paramMenuItem == null)
        {
          y.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
          return;
        }
        if ((paramMenuItem.offset >= paramMenuItem.ebK) && (paramMenuItem.ebK != 0))
        {
          if (this.dUy.field_isSend == 1) {
            if (paramMenuItem.Or()) {
              paramInt = 1;
            }
          }
          for (;;)
          {
            localObject = q.Gj();
            paramMenuItem = o.OJ().o(f.c(paramMenuItem), "", "");
            if (!bk.bl(paramMenuItem))
            {
              y.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[] { str, paramMenuItem });
              paramMenuItem = new l(4, (String)localObject, str, paramMenuItem, paramInt, null, 0, "", "", true, R.g.chat_img_template);
              au.Dk().a(paramMenuItem, 0);
              bt.If().d(bt.dXD, null);
            }
            com.tencent.mm.plugin.report.service.h.nFQ.f(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), str });
            com.tencent.mm.ui.base.h.bC(this.val$context, this.val$context.getString(R.l.app_saved));
            return;
            paramInt = 0;
            continue;
            if (!paramMenuItem.Or()) {
              paramInt = 0;
            } else if (!com.tencent.mm.vfs.e.bK(f.a(paramMenuItem).enq)) {
              paramInt = 0;
            } else {
              paramInt = 1;
            }
          }
        }
        paramMenuItem = new Intent(this.val$context, ImageGalleryUI.class);
        paramMenuItem.putExtra("img_gallery_msg_id", this.dUy.field_msgId);
        paramMenuItem.putExtra("img_gallery_msg_svr_id", this.dUy.field_msgSvrId);
        paramMenuItem.putExtra("img_gallery_talker", this.dUy.field_talker);
        paramMenuItem.putExtra("img_gallery_chatroom_name", this.dUy.field_talker);
        paramMenuItem.putExtra("img_gallery_is_restransmit_after_download", true);
        paramMenuItem.putExtra("img_gallery_directly_send_name", str);
        paramMenuItem.putExtra("start_chatting_ui", false);
        str = this.dUy.field_talker;
        Object localObject = new Bundle();
        if (this.vmT) {
          paramInt = 2;
        }
        for (;;)
        {
          ((Bundle)localObject).putInt("stat_scene", paramInt);
          ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(this.dUy.field_msgSvrId));
          ((Bundle)localObject).putString("stat_chat_talker_username", str);
          ((Bundle)localObject).putString("stat_send_msg_user", this.gPH);
          paramMenuItem.putExtra("_stat_obj", (Bundle)localObject);
          this.val$context.startActivity(paramMenuItem);
          return;
          if (s.hl(str)) {
            paramInt = 7;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao.5
 * JD-Core Version:    0.7.0.1
 */