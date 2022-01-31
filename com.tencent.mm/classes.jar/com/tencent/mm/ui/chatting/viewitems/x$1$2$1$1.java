package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class x$1$2$1$1
  implements i.a
{
  x$1$2$1$1(x.1.2.1 param1, String paramString) {}
  
  public final void d(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(33123);
    if (paramWxaAttributes == null)
    {
      t.makeText(this.zVo.zVn.bTJ.getContext(), 2131301984, 0).show();
      AppMethodBeat.o(33123);
      return;
    }
    Object localObject = paramWxaAttributes.field_appId;
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(this.tgD)))
    {
      ab.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[] { localObject, this.tgD });
      t.makeText(this.zVo.zVn.bTJ.getContext(), 2131301984, 0).show();
      AppMethodBeat.o(33123);
      return;
    }
    try
    {
      paramWxaAttributes = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[] { URLEncoder.encode((String)localObject, "utf-8"), URLEncoder.encode(this.tgD, "utf-8"), Integer.valueOf(1), Integer.valueOf(this.zVo.zVn.zVm), Integer.valueOf(this.zVo.zVn.hnF) });
      ab.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { this.tgD, localObject, paramWxaAttributes });
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramWxaAttributes);
      d.b(x.b(this.zVo.zVn.zVl.zVk).zJz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(33123);
      return;
    }
    catch (UnsupportedEncodingException paramWxaAttributes)
    {
      ab.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
      t.makeText(this.zVo.zVn.bTJ.getContext(), 2131301984, 0).show();
      AppMethodBeat.o(33123);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.1.2.1.1
 * JD-Core Version:    0.7.0.1
 */