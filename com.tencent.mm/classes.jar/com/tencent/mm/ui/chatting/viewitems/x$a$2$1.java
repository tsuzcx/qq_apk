package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class x$a$2$1
  implements f
{
  x$a$2$1(x.a.2 param2) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33152);
    aw.Rc().b(1198, this);
    ab.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.FALSE });
    if (x.a(this.zVE.zVD.zVk) != null)
    {
      x.a(this.zVE.zVD.zVk).dismiss();
      x.a(this.zVE.zVD.zVk, null);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      t.makeText(this.zVE.bTJ.getContext(), 2131301979, 0).show();
      AppMethodBeat.o(33152);
      return;
    }
    if (this.zVE.fkH != this.zVE.bTJ.getTag())
    {
      ab.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[] { Long.valueOf(this.zVE.fkH.field_msgId) });
      AppMethodBeat.o(33152);
      return;
    }
    paramString = ((s)paramm).acw();
    if (paramString == null)
    {
      t.makeText(this.zVE.bTJ.getContext(), 2131301979, 0).show();
      AppMethodBeat.o(33152);
      return;
    }
    paramm = paramString.yhW;
    ab.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[] { this.zVE.vqy });
    try
    {
      paramString = String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[] { this.zVE.vqy, URLEncoder.encode(x.d(this.zVE.zVD.zVk), "utf-8"), URLEncoder.encode(paramm, "utf-8") });
      ab.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[] { paramm, x.d(this.zVE.zVD.zVk), paramString });
      paramm = new Intent();
      paramm.putExtra("rawUrl", paramString);
      d.b(x.b(this.zVE.zVD.zVk).zJz.getContext(), "webview", ".ui.tools.WebViewUI", paramm);
      AppMethodBeat.o(33152);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      ab.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
      t.makeText(this.zVE.bTJ.getContext(), 2131301984, 0).show();
      AppMethodBeat.o(33152);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.a.2.1
 * JD-Core Version:    0.7.0.1
 */