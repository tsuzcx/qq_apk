package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.h.a.nb;
import com.tencent.mm.h.a.nb.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.n.d;
import java.util.Map;

final class a$2$2
  implements n.d
{
  a$2$2(a.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      do
      {
        return;
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Ksnsupload_type", 0);
        paramMenuItem.putExtra("sns_kemdia_path", a.2.d(this.nuv));
        localObject = u.ij("fav_");
        u.Hc().v((String)localObject, true).h("prePublishId", "fav_");
        paramMenuItem.putExtra("reportSessionId", (String)localObject);
        d.b(a.2.c(this.nuv), "sns", ".ui.SnsUploadUI", paramMenuItem);
        return;
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_File_Name", a.2.d(this.nuv));
        paramMenuItem.putExtra("Retr_Compress_Type", 0);
        paramMenuItem.putExtra("Retr_Msg_Type", 0);
        d.e(a.2.c(this.nuv), ".ui.transmit.MsgRetransmitUI", paramMenuItem);
        return;
      } while (q.a(a.2.d(this.nuv), a.2.c(this.nuv), R.l.cropimage_saved));
      Toast.makeText(a.2.c(this.nuv), a.2.c(this.nuv).getString(R.l.favorite_save_fail), 1).show();
      return;
      paramMenuItem = (nb)this.nuv.nus.kbT.get(a.2.d(this.nuv));
    } while (paramMenuItem == null);
    Object localObject = new cd();
    ((cd)localObject).bIi.activity = ((Activity)a.2.c(this.nuv));
    ((cd)localObject).bIi.bGE = paramMenuItem.bWI.result;
    ((cd)localObject).bIi.bIj = paramMenuItem.bWI.bIj;
    ((cd)localObject).bIi.bIk = paramMenuItem.bWI.bIk;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a.2.2
 * JD-Core Version:    0.7.0.1
 */