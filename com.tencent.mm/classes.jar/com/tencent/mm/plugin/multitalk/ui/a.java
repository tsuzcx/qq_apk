package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends r
{
  private String chatroomName;
  private List<String> mNr;
  
  public a(o paramo, String paramString)
  {
    super(paramo, null, true, true);
    AppMethodBeat.i(114707);
    this.chatroomName = paramString;
    ate();
    AppMethodBeat.o(114707);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(114708);
    Log.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
    this.mNr = ((b)h.ae(b.class)).bbV().RA(this.chatroomName);
    if (this.mNr == null) {
      this.mNr = new ArrayList();
    }
    AppMethodBeat.o(114708);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114710);
    int i = this.mNr.size();
    AppMethodBeat.o(114710);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(114709);
    Object localObject = (String)this.mNr.get(paramInt);
    localObject = ((n)h.ae(n.class)).bbL().RG((String)localObject);
    e locale = new e(paramInt);
    locale.contact = ((as)localObject);
    locale.XsX = fJk();
    AppMethodBeat.o(114709);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a
 * JD-Core Version:    0.7.0.1
 */