package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.pl;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.avc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

final class c$1
  implements h.c
{
  c$1(c paramc, t.n paramn) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      Intent localIntent = new Intent();
      try
      {
        localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[] { URLEncoder.encode(this.vhr.pyp, "UTF-8"), URLEncoder.encode(this.vhr.dRD, "UTF-8"), Long.valueOf(this.vhr.bWO.field_msgSvrId), Integer.valueOf((int)(this.vhr.bWO.field_createTime / 1000L)), Integer.valueOf(42) }));
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("showShare", false);
        d.b(c.a(this.vhs).vtz.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        y.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[] { localUnsupportedEncodingException.getMessage() });
        return;
      }
      y.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[] { this.vhr.pyp, this.vhr.dRD });
      au.Dk().a(1030, this.vhs);
      localObject2 = new avc();
      ((avc)localObject2).svx = 1;
      ((avc)localObject2).tqI = this.vhr.dRD;
      ((avc)localObject2).bGw = "";
      localObject1 = new LinkedList();
      ((LinkedList)localObject1).add(localObject2);
      localObject2 = new pl();
      ((pl)localObject2).bYY.bXl = this.vhr.pyp;
      ((pl)localObject2).bYY.bYZ = ((LinkedList)localObject1);
    } while (!com.tencent.mm.sdk.b.a.udP.m((b)localObject2));
    Object localObject1 = this.vhs;
    Object localObject2 = c.a(this.vhs).vtz.getContext();
    c.a(this.vhs).vtz.getMMResources().getString(R.l.app_tip);
    c.a((c)localObject1, h.b((Context)localObject2, c.a(this.vhs).vtz.getMMResources().getString(R.l.app_waiting), true, new c.1.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.1
 * JD-Core Version:    0.7.0.1
 */