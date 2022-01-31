package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.protocal.protobuf.bbm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

final class c$1
  implements h.c
{
  c$1(c paramc, s.o paramo) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(30379);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(30379);
      return;
      Intent localIntent = new Intent();
      try
      {
        localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[] { URLEncoder.encode(this.zwl.tac, "UTF-8"), URLEncoder.encode(this.zwl.fhC, "UTF-8"), Long.valueOf(this.zwl.cEE.field_msgSvrId), Integer.valueOf((int)(this.zwl.cEE.field_createTime / 1000L)), Integer.valueOf(42) }));
        localIntent.putExtra("show_bottom", false);
        localIntent.putExtra("showShare", false);
        d.b(c.a(this.zwm).zJz.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
        AppMethodBeat.o(30379);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        ab.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[] { localUnsupportedEncodingException.getMessage() });
        AppMethodBeat.o(30379);
        return;
      }
      ab.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[] { this.zwl.tac, this.zwl.fhC });
      aw.Rc().a(1030, this.zwm);
      Object localObject2 = new bbm();
      ((bbm)localObject2).woE = 1;
      ((bbm)localObject2).xqI = this.zwl.fhC;
      ((bbm)localObject2).Title = "";
      Object localObject1 = new LinkedList();
      ((LinkedList)localObject1).add(localObject2);
      localObject2 = new qs();
      ((qs)localObject2).cHj.cFh = this.zwl.tac;
      ((qs)localObject2).cHj.cHk = ((LinkedList)localObject1);
      if (com.tencent.mm.sdk.b.a.ymk.l((b)localObject2))
      {
        localObject1 = this.zwm;
        localObject2 = c.a(this.zwm).zJz.getContext();
        c.a(this.zwm).zJz.getMMResources().getString(2131297087);
        c.a((c)localObject1, h.b((Context)localObject2, c.a(this.zwm).zJz.getMMResources().getString(2131297112), true, new c.1.1(this)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.1
 * JD-Core Version:    0.7.0.1
 */