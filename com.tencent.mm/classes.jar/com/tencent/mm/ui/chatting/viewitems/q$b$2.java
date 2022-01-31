package com.tencent.mm.ui.chatting.viewitems;

import android.widget.TextView;
import com.tencent.mm.ae.a;
import com.tencent.mm.ae.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.protocal.c.bzp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class q$b$2
  implements k.a
{
  q$b$2(q.b paramb, q.d paramd, a parama) {}
  
  public final void a(String paramString, bzp parambzp)
  {
    y.d("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "ShareKey:%s UpdatableMsgInfo:%s", new Object[] { paramString, parambzp.content });
    if (this.vDr.vDw == null) {
      y.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "viewHolder.appbrandUpdateTv is null, return");
    }
    do
    {
      String str;
      do
      {
        return;
        str = (String)this.vDr.vDw.getTag();
        if (bk.bl(str))
        {
          y.w("MicroMsg.ChattingItemAppMsgWxaDynamicTo", "oriShareKey is null, return");
          return;
        }
      } while (!str.equals(paramString));
      this.vDr.vDw.setVisibility(0);
      this.vDr.vDw.setText(parambzp.content);
      this.vDr.vDw.setTextColor(bk.bq(parambzp.tIo, this.vDr.vDw.getCurrentTextColor()));
    } while ((parambzp.state != 1) || (((k)g.r(k.class)).jv(paramString).field_btnState != 1));
    if (bk.bl(this.vDu.dPM))
    {
      this.vDr.vDx.setVisibility(8);
      return;
    }
    this.vDr.vDx.setVisibility(0);
    this.vDr.vDx.setText(this.vDu.dPM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.b.2
 * JD-Core Version:    0.7.0.1
 */