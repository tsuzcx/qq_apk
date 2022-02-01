package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends r
{
  private String chatroomName;
  private List<String> pJZ;
  
  public b(o paramo, String paramString)
  {
    super(paramo, null, true, true);
    AppMethodBeat.i(114707);
    this.chatroomName = paramString;
    aNm();
    AppMethodBeat.o(114707);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(114708);
    Log.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
    this.pJZ = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jy(this.chatroomName);
    if (this.pJZ == null) {
      this.pJZ = new ArrayList();
    }
    AppMethodBeat.o(114708);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(114710);
    int i = this.pJZ.size();
    AppMethodBeat.o(114710);
    return i;
  }
  
  public final a yk(int paramInt)
  {
    AppMethodBeat.i(114709);
    Object localObject = (String)this.pJZ.get(paramInt);
    localObject = ((n)h.ax(n.class)).bzA().JE((String)localObject);
    e locale = new e(paramInt);
    locale.contact = ((au)localObject);
    locale.afey = gZe();
    AppMethodBeat.o(114709);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.b
 * JD-Core Version:    0.7.0.1
 */