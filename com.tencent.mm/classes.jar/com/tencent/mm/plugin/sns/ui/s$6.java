package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;

final class s$6
  implements n.d
{
  s$6(s params, n paramn, awd paramawd, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = paramMenuItem.getItemId();
    y.d("MicroMsg.GalleryTitleManager", "showAlert " + paramInt);
    switch (paramInt)
    {
    case 5: 
    default: 
    case 6: 
    case 8: 
    case 3: 
    case 2: 
    case 4: 
      long l;
      n localn;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while ((this.oPF == null) || (this.oPF.bGe().tNr == null));
            s.a(this.oPE, this.oPF, this.opu);
            return;
            s.a(this.oPE, this.oPF, this.opu, this.kX);
            return;
          } while ((this.oPF == null) || (this.oPF.bGe().tNr == null));
          if (this.oPF.bGe().tNr.sPI == 1)
          {
            paramMenuItem = an.eJ(af.getAccSnsPath(), this.opu.lsK) + i.l(this.opu);
            this.oPE.Pe(paramMenuItem);
            return;
          }
          s.Pg(this.oPF.bGE());
          return;
        } while ((this.oPF == null) || (this.oPF.bGe().tNr == null));
        if (this.oPF.field_type != 15)
        {
          l.i(an.eJ(af.getAccSnsPath(), this.opu.lsK) + i.l(this.opu), this.oPE.context);
          return;
        }
        s.Pf(this.oPF.bGE());
        return;
        paramMenuItem = this.oPE;
        l = this.oPF.field_snsId;
        localn = af.bDF().gt(l);
      } while ((l == 0L) || (localn == null));
      Intent localIntent = new Intent();
      localIntent.putExtra("k_username", localn.field_userName);
      localIntent.putExtra("k_expose_msg_id", l);
      localIntent.putExtra("showShare", false);
      localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
      d.b(paramMenuItem.context, "webview", ".ui.tools.WebViewUI", localIntent);
      return;
    }
    paramMenuItem = new Bundle();
    paramMenuItem.putString("stat_msg_id", "sns_" + i.fN(this.oPF.field_snsId));
    paramMenuItem.putString("stat_send_msg_user", this.oPF.field_userName);
    paramMenuItem.putInt("stat_scene", 3);
    s.a(this.oPE, paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s.6
 * JD-Core Version:    0.7.0.1
 */