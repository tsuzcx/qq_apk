package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.e;
import java.util.LinkedList;

final class t$10$2
  implements am.b.a
{
  t$10$2(t.10 param10, String paramString) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(this.vre.vqY.byx.vtz.getContext(), new t.10.2.1(this));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(3));
    au.Hx();
    paramString = c.Fw().abl(t.d(this.vre.vqY));
    if (paramString != null) {}
    for (paramString = bk.aM(paramString.cCQ, "");; paramString = "")
    {
      locala.WA(paramString);
      locala.b(t.d(this.vre.vqY), this.mYS, localLinkedList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.t.10.2
 * JD-Core Version:    0.7.0.1
 */