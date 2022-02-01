package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends q
{
  private String chatroomName;
  private List<String> jWf;
  
  public a(n paramn, String paramString)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(114707);
    this.chatroomName = paramString;
    and();
    AppMethodBeat.o(114707);
  }
  
  public final void and()
  {
    AppMethodBeat.i(114708);
    Log.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
    this.jWf = ((c)g.af(c.class)).aSX().Kh(this.chatroomName);
    if (this.jWf == null) {
      this.jWf = new ArrayList();
    }
    AppMethodBeat.o(114708);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114710);
    int i = this.jWf.size();
    AppMethodBeat.o(114710);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(114709);
    Object localObject = (String)this.jWf.get(paramInt);
    localObject = ((l)g.af(l.class)).aSN().Kn((String)localObject);
    e locale = new e(paramInt);
    locale.contact = ((as)localObject);
    locale.PWh = eWh();
    AppMethodBeat.o(114709);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a
 * JD-Core Version:    0.7.0.1
 */