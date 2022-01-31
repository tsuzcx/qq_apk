package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;

final class s$8
  implements n.d
{
  s$8(s params, com.tencent.mm.plugin.sns.storage.n paramn, bcs parambcs, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(38256);
    paramInt = paramMenuItem.getItemId();
    ab.d("MicroMsg.GalleryTitleManager", "showAlert ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38256);
      return;
      if ((this.rHq != null) && (this.rHq.csh().xTS != null))
      {
        s.a(this.rHr, this.rHq, this.rdM);
        AppMethodBeat.o(38256);
        return;
        s.a(this.rHr, this.rHq, this.rdM, this.lU);
        AppMethodBeat.o(38256);
        return;
        if ((this.rHq != null) && (this.rHq.csh().xTS != null))
        {
          if (this.rHq.csh().xTS.wNZ == 1)
          {
            paramMenuItem = ao.gl(ag.getAccSnsPath(), this.rdM.Id) + i.l(this.rdM);
            this.rHr.abY(paramMenuItem);
            AppMethodBeat.o(38256);
            return;
          }
          s.aca(this.rHq.csH());
          AppMethodBeat.o(38256);
          return;
          if ((this.rHq != null) && (this.rHq.csh().xTS != null))
          {
            if (this.rHq.field_type != 15)
            {
              com.tencent.mm.pluginsdk.ui.tools.n.k(ao.gl(ag.getAccSnsPath(), this.rdM.Id) + i.l(this.rdM), this.rHr.context);
              AppMethodBeat.o(38256);
              return;
            }
            s.abZ(this.rHq.csH());
            AppMethodBeat.o(38256);
            return;
            paramMenuItem = this.rHr;
            long l = this.rHq.field_snsId;
            com.tencent.mm.plugin.sns.storage.n localn = ag.cpf().lZ(l);
            if ((l == 0L) || (localn == null))
            {
              AppMethodBeat.o(38256);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("k_username", localn.field_userName);
            localIntent.putExtra("k_expose_msg_id", l);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
            d.b(paramMenuItem.context, "webview", ".ui.tools.WebViewUI", localIntent);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.8
 * JD-Core Version:    0.7.0.1
 */