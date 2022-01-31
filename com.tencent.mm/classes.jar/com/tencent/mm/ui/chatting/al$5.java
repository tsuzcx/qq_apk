package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.f;
import com.tencent.mm.at.g;
import com.tencent.mm.at.l;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

final class al$5
  implements n.d
{
  al$5(bi parambi, Context paramContext, boolean paramBoolean, String paramString) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(31014);
    String str = paramMenuItem.getTitle();
    paramMenuItem = null;
    if (this.fkH.field_msgId > 0L) {
      paramMenuItem = o.ahC().gT(this.fkH.field_msgId);
    }
    if (((paramMenuItem == null) || (paramMenuItem.fDL <= 0L)) && (this.fkH.field_msgSvrId > 0L)) {
      paramMenuItem = o.ahC().gS(this.fkH.field_msgSvrId);
    }
    for (;;)
    {
      if (paramMenuItem == null)
      {
        ab.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
        AppMethodBeat.o(31014);
        return;
      }
      if ((paramMenuItem.offset >= paramMenuItem.fsd) && (paramMenuItem.fsd != 0))
      {
        if (this.fkH.field_isSend == 1) {
          if (paramMenuItem.ahh()) {
            paramInt = 1;
          }
        }
        for (;;)
        {
          localObject = r.Zn();
          paramMenuItem = o.ahC().q(f.c(paramMenuItem), "", "");
          if (!bo.isNullOrNil(paramMenuItem))
          {
            ab.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", new Object[] { str, paramMenuItem });
            paramMenuItem = new l(4, (String)localObject, str, paramMenuItem, paramInt, null, 0, "", "", true, 2130838228);
            aw.Rc().a(paramMenuItem, 0);
            bv.abc().c(bv.fnI, null);
          }
          com.tencent.mm.plugin.report.service.h.qsU.e(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), str });
          com.tencent.mm.ui.base.h.bO(this.val$context, this.val$context.getString(2131297064));
          AppMethodBeat.o(31014);
          return;
          paramInt = 0;
          continue;
          if (!paramMenuItem.ahh()) {
            paramInt = 0;
          } else if (!com.tencent.mm.vfs.e.cN(f.a(paramMenuItem).fDM)) {
            paramInt = 0;
          } else {
            paramInt = 1;
          }
        }
      }
      ab.i("MicroMsg.LongClickBrandServiceHelper", "[ImageGalleryUI] enter");
      paramMenuItem = new Intent(this.val$context, ImageGalleryUI.class);
      paramMenuItem.putExtra("img_gallery_msg_id", this.fkH.field_msgId);
      paramMenuItem.putExtra("img_gallery_msg_svr_id", this.fkH.field_msgSvrId);
      paramMenuItem.putExtra("img_gallery_talker", this.fkH.field_talker);
      paramMenuItem.putExtra("img_gallery_chatroom_name", this.fkH.field_talker);
      paramMenuItem.putExtra("img_gallery_is_restransmit_after_download", true);
      paramMenuItem.putExtra("img_gallery_directly_send_name", str);
      paramMenuItem.putExtra("start_chatting_ui", false);
      str = this.fkH.field_talker;
      Object localObject = new Bundle();
      if (this.zCp) {
        paramInt = 2;
      }
      for (;;)
      {
        ((Bundle)localObject).putInt("stat_scene", paramInt);
        ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(this.fkH.field_msgSvrId));
        ((Bundle)localObject).putString("stat_chat_talker_username", str);
        ((Bundle)localObject).putString("stat_send_msg_user", this.irt);
        paramMenuItem.putExtra("_stat_obj", (Bundle)localObject);
        this.val$context.startActivity(paramMenuItem);
        AppMethodBeat.o(31014);
        return;
        if (t.nU(str)) {
          paramInt = 7;
        } else {
          paramInt = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.al.5
 * JD-Core Version:    0.7.0.1
 */