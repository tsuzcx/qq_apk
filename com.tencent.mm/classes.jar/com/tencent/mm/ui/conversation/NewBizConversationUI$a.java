package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.p.a;
import java.util.HashMap;
import java.util.LinkedList;

final class NewBizConversationUI$a
  extends e
{
  private String cCC;
  HashMap<String, NewBizConversationUI.b> jWA;
  
  public NewBizConversationUI$a(Context paramContext, String paramString, p.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(34554);
    this.cCC = paramString;
    this.jWA = new HashMap();
    AppMethodBeat.o(34554);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(34555);
    aw.aaz();
    setCursor(c.YF().c(t.flc, this.ejc, this.cCC));
    if (this.zaq != null) {
      this.zaq.apT();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(34555);
  }
  
  public final void a(ak paramak, int paramInt)
  {
    AppMethodBeat.i(34557);
    aw.aaz();
    a(paramak, c.YF().g(paramak), paramInt, true);
    AppMethodBeat.o(34557);
  }
  
  protected final void a(ak paramak, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    AppMethodBeat.i(34556);
    if (paramak == null)
    {
      AppMethodBeat.o(34556);
      return;
    }
    NewBizConversationUI.b localb = (NewBizConversationUI.b)this.jWA.get(paramak.field_username);
    if (localb == null)
    {
      localb = new NewBizConversationUI.b((byte)0);
      this.jWA.put(paramak.field_username, localb);
    }
    for (;;)
    {
      if (localb.fQt > 0)
      {
        AppMethodBeat.o(34556);
        return;
      }
      localb.xHg = paramBoolean1;
      if ((localb.xHj) || (paramak.field_unReadCount > 0)) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localb.xHj = paramBoolean1;
        localb.ntX = (paramInt + 1);
        if (paramBoolean2) {
          localb.fQt = localb.ntX;
        }
        localb.xHi = ((int)(System.currentTimeMillis() / 1000L));
        if (paramak.field_lastSeq != localb.xyE) {
          break;
        }
        AppMethodBeat.o(34556);
        return;
      }
      localb.xyE = paramak.field_lastSeq;
      paramak = ((j)g.E(j.class)).bPQ().Tm(paramak.field_username);
      if ((paramak != null) && (paramak.dvV()))
      {
        paramak = ((a)g.E(a.class)).b(paramak.field_msgId, paramak.field_content);
        if ((paramak != null) && (!bo.es(paramak.fjy)) && (!bo.isNullOrNil(((q)paramak.fjy.get(0)).url))) {
          try
          {
            paramak = Uri.parse(((q)paramak.fjy.get(0)).url);
            localb.xHe = bo.getLong(paramak.getQueryParameter("mid"), 0L);
            localb.xHf = bo.getInt(paramak.getQueryParameter("idx"), 0);
            AppMethodBeat.o(34556);
            return;
          }
          catch (UnsupportedOperationException paramak)
          {
            ab.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramak.getMessage() });
            AppMethodBeat.o(34556);
            return;
          }
          catch (Exception paramak)
          {
            ab.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramak.getMessage() });
          }
        }
      }
      AppMethodBeat.o(34556);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.a
 * JD-Core Version:    0.7.0.1
 */