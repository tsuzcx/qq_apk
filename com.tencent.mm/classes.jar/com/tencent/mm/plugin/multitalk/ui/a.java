package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends q
{
  private String chatroomName;
  private List<String> iVH;
  
  public a(n paramn, String paramString)
  {
    super(paramn, null, true, true);
    AppMethodBeat.i(114707);
    this.chatroomName = paramString;
    Zh();
    AppMethodBeat.o(114707);
  }
  
  public final void Zh()
  {
    AppMethodBeat.i(114708);
    ad.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
    this.iVH = ((c)g.ab(c.class)).azz().AR(this.chatroomName);
    if (this.iVH == null) {
      this.iVH = new ArrayList();
    }
    AppMethodBeat.o(114708);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114710);
    int i = this.iVH.size();
    AppMethodBeat.o(114710);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    AppMethodBeat.i(114709);
    Object localObject = (String)this.iVH.get(paramInt);
    localObject = ((l)g.ab(l.class)).azp().Bf((String)localObject);
    e locale = new e(paramInt);
    locale.contact = ((am)localObject);
    locale.KmP = dQK();
    AppMethodBeat.o(114709);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a
 * JD-Core Version:    0.7.0.1
 */