package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.p;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends p
{
  private String chatroomName;
  private List<String> gpY;
  
  public a(m paramm, String paramString)
  {
    super(paramm, null, true, true);
    AppMethodBeat.i(54174);
    this.chatroomName = paramString;
    ab.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
    this.gpY = ((c)g.E(c.class)).YJ().oY(this.chatroomName);
    if (this.gpY == null) {
      this.gpY = new ArrayList();
    }
    AppMethodBeat.o(54174);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(54176);
    int i = this.gpY.size();
    AppMethodBeat.o(54176);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a mM(int paramInt)
  {
    AppMethodBeat.i(54175);
    Object localObject = (String)this.gpY.get(paramInt);
    localObject = ((j)g.E(j.class)).YA().arw((String)localObject);
    com.tencent.mm.plugin.multitalk.ui.widget.a locala = new com.tencent.mm.plugin.multitalk.ui.widget.a(paramInt);
    locala.contact = ((ad)localObject);
    locala.Adl = cni();
    AppMethodBeat.o(54175);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a
 * JD-Core Version:    0.7.0.1
 */