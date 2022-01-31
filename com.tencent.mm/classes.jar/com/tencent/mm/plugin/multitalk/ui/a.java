package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends o
{
  private String chatroomName;
  private List<String> eYb;
  
  public a(l paraml, String paramString)
  {
    super(paraml, null, true, true);
    this.chatroomName = paramString;
    y.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
    this.eYb = ((c)g.r(c.class)).FF().ir(this.chatroomName);
    if (this.eYb == null) {
      this.eYb = new ArrayList();
    }
  }
  
  public final int getCount()
  {
    return this.eYb.size();
  }
  
  protected final com.tencent.mm.ui.contact.a.a jQ(int paramInt)
  {
    Object localObject = (String)this.eYb.get(paramInt);
    localObject = ((j)g.r(j.class)).Fw().abl((String)localObject);
    com.tencent.mm.plugin.multitalk.ui.widget.a locala = new com.tencent.mm.plugin.multitalk.ui.widget.a(paramInt);
    locala.dnp = ((ad)localObject);
    locala.vLJ = bBJ();
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.a
 * JD-Core Version:    0.7.0.1
 */