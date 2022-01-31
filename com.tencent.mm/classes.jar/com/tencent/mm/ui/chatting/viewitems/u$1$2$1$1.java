package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.r.c.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class u$1$2$1$1
  implements c.a
{
  u$1$2$1$1(u.1.2.1 param1, String paramString) {}
  
  public final void b(WxaAttributes paramWxaAttributes)
  {
    if (paramWxaAttributes == null)
    {
      s.makeText(this.vEd.vEc.hdG.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
      return;
    }
    Object localObject = paramWxaAttributes.field_appId;
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(this.uJs)))
    {
      y.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[] { localObject, this.uJs });
      s.makeText(this.vEd.vEc.hdG.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
      return;
    }
    try
    {
      paramWxaAttributes = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(this.uJs, "utf-8"), Integer.valueOf(1), Integer.valueOf(this.vEd.vEc.vEb), Integer.valueOf(this.vEd.vEc.fUd) });
      y.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { this.uJs, localObject, paramWxaAttributes });
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramWxaAttributes);
      d.b(u.b(this.vEd.vEc.vEa.vDZ).vtz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      return;
    }
    catch (UnsupportedEncodingException paramWxaAttributes)
    {
      y.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
      s.makeText(this.vEd.vEc.hdG.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.1.2.1.1
 * JD-Core Version:    0.7.0.1
 */