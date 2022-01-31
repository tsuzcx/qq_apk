package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c;

final class ak$2
  implements ChatFooter.c
{
  ak$2(ak paramak) {}
  
  public final void a(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if (paramBoolean1.booleanValue())
    {
      if (paramBoolean2.booleanValue()) {
        ak.a(this.vsO, Boolean.valueOf(true), Boolean.valueOf(true));
      }
    }
    else {
      return;
    }
    ak.a(this.vsO, Boolean.valueOf(false), Boolean.valueOf(true));
  }
  
  public final void b(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if (paramBoolean1.booleanValue())
    {
      if (paramBoolean2.booleanValue()) {
        ak.a(this.vsO, Boolean.valueOf(true), Boolean.valueOf(false));
      }
    }
    else {
      return;
    }
    ak.a(this.vsO, Boolean.valueOf(false), Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ak.2
 * JD-Core Version:    0.7.0.1
 */