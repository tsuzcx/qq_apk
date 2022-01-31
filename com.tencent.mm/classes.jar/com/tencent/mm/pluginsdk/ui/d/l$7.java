package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R.c;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.pluginsdk.f.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.k;
import java.util.List;

final class l$7
  implements AdapterView.OnItemClickListener
{
  l$7(String paramString, List paramList, Context paramContext, k paramk, DialogInterface.OnDismissListener paramOnDismissListener, int paramInt, Bundle paramBundle) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = this.lzG.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
    paramAdapterView = (String)this.kbG.get(paramInt);
    y.i("MicroMsg.MailPhoneMenuHelper", paramAdapterView);
    if (this.val$context.getString(R.l.chatting_phone_use).equals(paramAdapterView))
    {
      paramAdapterView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramView));
      paramAdapterView.addFlags(268435456);
      if (bk.i(this.val$context, paramAdapterView)) {
        this.val$context.startActivity(paramAdapterView);
      }
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10112, "1");
      this.sjO.dismiss();
      if (this.sjL != null) {
        this.sjL.onDismiss(null);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!this.val$context.getString(R.l.chatting_phone_use_by_ipcall).equals(paramAdapterView)) {
            break;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(12059, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          paramAdapterView = new Intent();
          paramAdapterView.putExtra("IPCallTalkUI_phoneNumber", paramView);
          d.b(this.val$context, "ipcall", ".ui.IPCallDialUI", paramAdapterView);
          this.sjO.dismiss();
        } while (this.sjL == null);
        this.sjL.onDismiss(null);
        return;
        if (this.val$context.getString(R.l.chatting_phone_add_op).equals(paramAdapterView))
        {
          if ((l.coc()) && (l.cod())) {
            paramAdapterView = this.val$context.getResources().getStringArray(R.c.phone_url_add);
          }
          for (;;)
          {
            this.val$context.getResources().getString(R.l.chatting_phone_maybe_phone);
            com.tencent.mm.ui.base.h.a(this.val$context, this.lzG, paramAdapterView, "", new l.7.1(this, paramView), new l.7.2(this));
            this.sjO.dismiss();
            return;
            if (l.coc())
            {
              paramAdapterView = new String[1];
              paramAdapterView[0] = this.val$context.getResources().getString(R.l.chatting_phone_add_contact);
            }
            else
            {
              paramAdapterView = new String[1];
              paramAdapterView[0] = this.val$context.getResources().getString(R.l.chatting_phone_modify_contact);
            }
          }
        }
        if (this.val$context.getString(R.l.chatting_phone_copy).equals(paramAdapterView))
        {
          a.a(this.val$context, paramView, paramView);
          com.tencent.mm.plugin.report.service.h.nFQ.aC(10115, "1");
          if (this.sjL != null) {
            this.sjL.onDismiss(null);
          }
          this.sjO.dismiss();
          Toast.makeText(this.val$context, this.val$context.getString(R.l.app_copy_ok), 1).show();
          return;
        }
        if (this.val$context.getString(R.l.chatting_phone_download_wxpb).equals(paramAdapterView))
        {
          y.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
          return;
        }
        if (!l.sjK.equals(paramAdapterView)) {
          break;
        }
        l.a((Activity)this.val$context, this.lzG, this.sjP);
        this.sjO.dismiss();
      } while (this.sjL == null);
      this.sjL.onDismiss(null);
      return;
      y.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
      this.sjO.dismiss();
    } while (this.sjL == null);
    this.sjL.onDismiss(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.7
 * JD-Core Version:    0.7.0.1
 */