package com.tencent.mm.ui.chatting.a;

import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;

final class a$3
  implements g.a
{
  a$3(a parama) {}
  
  public final void a(g paramg, g.c paramc)
  {
    if ((paramg == null) || (paramc == null)) {}
    while ((paramc.talker == null) || (a.a(this.voh).getTalkerUserName() == null) || (!paramc.talker.equals(a.a(this.voh).getTalkerUserName()))) {
      return;
    }
    this.voh.cDo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.a.3
 * JD-Core Version:    0.7.0.1
 */