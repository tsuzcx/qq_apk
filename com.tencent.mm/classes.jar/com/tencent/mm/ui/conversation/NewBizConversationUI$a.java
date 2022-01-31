package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.r.a;
import java.util.HashMap;
import java.util.LinkedList;

final class NewBizConversationUI$a
  extends e
{
  private String bUU;
  HashMap<String, NewBizConversationUI.b> igI;
  
  public NewBizConversationUI$a(Context paramContext, String paramString, r.a parama)
  {
    super(paramContext, parama);
    this.bUU = paramString;
    this.igI = new HashMap();
  }
  
  public final void a(ak paramak, int paramInt)
  {
    au.Hx();
    a(paramak, c.FB().g(paramak), paramInt, true);
  }
  
  protected final void a(ak paramak, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramak == null) {}
    label330:
    for (;;)
    {
      return;
      NewBizConversationUI.b localb = (NewBizConversationUI.b)this.igI.get(paramak.field_username);
      if (localb == null)
      {
        localb = new NewBizConversationUI.b((byte)0);
        this.igI.put(paramak.field_username, localb);
      }
      for (;;)
      {
        if (localb.eAB > 0) {
          break label330;
        }
        localb.tEq = paramBoolean1;
        if ((localb.tEt) || (paramak.field_unReadCount > 0)) {
          paramBoolean1 = true;
        }
        for (;;)
        {
          localb.tEt = paramBoolean1;
          localb.kVX = (paramInt + 1);
          if (paramBoolean2) {
            localb.eAB = localb.kVX;
          }
          localb.tEs = ((int)(System.currentTimeMillis() / 1000L));
          if (paramak.field_lastSeq == localb.tIh) {
            break;
          }
          localb.tIh = paramak.field_lastSeq;
          paramak = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HA(paramak.field_username);
          if ((paramak == null) || (!paramak.ctz())) {
            break;
          }
          paramak = ((a)com.tencent.mm.kernel.g.r(a.class)).d(paramak.field_msgId, paramak.field_content);
          if ((paramak == null) || (bk.dk(paramak.dTx)) || (bk.bl(((m)paramak.dTx.get(0)).url))) {
            break;
          }
          try
          {
            paramak = Uri.parse(((m)paramak.dTx.get(0)).url);
            localb.tEo = bk.getLong(paramak.getQueryParameter("mid"), 0L);
            localb.tEp = bk.getInt(paramak.getQueryParameter("idx"), 0);
            return;
          }
          catch (UnsupportedOperationException paramak)
          {
            y.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramak.getMessage() });
            return;
            paramBoolean1 = false;
          }
          catch (Exception paramak)
          {
            y.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramak.getMessage() });
            return;
          }
        }
      }
    }
  }
  
  public final void yc()
  {
    au.Hx();
    setCursor(c.FB().c(s.dUT, this.dru, this.bUU));
    if (this.uMi != null) {
      this.uMi.Wp();
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.a
 * JD-Core Version:    0.7.0.1
 */