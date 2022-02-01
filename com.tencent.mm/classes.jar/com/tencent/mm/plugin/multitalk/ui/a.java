package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends q
{
  private String chatroomName;
  private List<String> iYA;
  
  public a(n paramn, String paramString)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(114707);
    this.chatroomName = paramString;
    Zq();
    AppMethodBeat.o(114707);
  }
  
  public final void Zq()
  {
    AppMethodBeat.i(114708);
    ae.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
    this.iYA = ((c)g.ab(c.class)).azP().BB(this.chatroomName);
    if (this.iYA == null) {
      this.iYA = new ArrayList();
    }
    AppMethodBeat.o(114708);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114710);
    int i = this.iYA.size();
    AppMethodBeat.o(114710);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(114709);
    Object localObject = (String)this.iYA.get(paramInt);
    localObject = ((l)g.ab(l.class)).azF().BH((String)localObject);
    e locale = new e(paramInt);
    locale.contact = ((an)localObject);
    locale.KJj = dUh();
    AppMethodBeat.o(114709);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a
 * JD-Core Version:    0.7.0.1
 */