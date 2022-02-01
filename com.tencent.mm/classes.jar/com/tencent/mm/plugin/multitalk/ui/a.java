package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends q
{
  private String chatroomName;
  private List<String> ico;
  
  public a(n paramn, String paramString)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(114707);
    this.chatroomName = paramString;
    VP();
    AppMethodBeat.o(114707);
  }
  
  public final void VP()
  {
    AppMethodBeat.i(114708);
    ad.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
    this.ico = ((c)g.ab(c.class)).apV().tL(this.chatroomName);
    if (this.ico == null) {
      this.ico = new ArrayList();
    }
    AppMethodBeat.o(114708);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114710);
    int i = this.ico.size();
    AppMethodBeat.o(114710);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a pU(int paramInt)
  {
    AppMethodBeat.i(114709);
    Object localObject = (String)this.ico.get(paramInt);
    localObject = ((k)g.ab(k.class)).apM().aHY((String)localObject);
    e locale = new e(paramInt);
    locale.contact = ((af)localObject);
    locale.GVT = dqZ();
    AppMethodBeat.o(114709);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a
 * JD-Core Version:    0.7.0.1
 */