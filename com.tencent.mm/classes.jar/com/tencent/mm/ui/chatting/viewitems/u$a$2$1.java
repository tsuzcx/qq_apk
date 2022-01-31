package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.cnj;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class u$a$2$1
  implements f
{
  u$a$2$1(u.a.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(1198, this);
    y.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(false) });
    if (u.a(this.vEt.vEs.vDZ) != null)
    {
      u.a(this.vEt.vEs.vDZ).dismiss();
      u.a(this.vEt.vEs.vDZ, null);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.ui.base.s.makeText(this.vEt.hdG.getContext(), R.l.notify_message_settings_complain_failed, 0).show();
      return;
    }
    if (this.vEt.dUy != this.vEt.hdG.getTag())
    {
      y.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(this.vEt.dUy.field_msgId) });
      return;
    }
    paramString = ((com.tencent.mm.modelappbrand.s)paramm).Jy();
    if (paramString == null)
    {
      com.tencent.mm.ui.base.s.makeText(this.vEt.hdG.getContext(), R.l.notify_message_settings_complain_failed, 0).show();
      return;
    }
    paramm = paramString.uad;
    y.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { this.vEt.rzx });
    try
    {
      paramString = String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[] { this.vEt.rzx, URLEncoder.encode(u.d(this.vEt.vEs.vDZ), "utf-8"), URLEncoder.encode(paramm, "utf-8") });
      y.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramm, u.d(this.vEt.vEs.vDZ), paramString });
      paramm = new Intent();
      paramm.putExtra("rawUrl", paramString);
      d.b(u.b(this.vEt.vEs.vDZ).vtz.getContext(), "webview", ".ui.tools.WebViewUI", paramm);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      y.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
      com.tencent.mm.ui.base.s.makeText(this.vEt.hdG.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.a.2.1
 * JD-Core Version:    0.7.0.1
 */