package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.a.c.b;

final class d$a
  extends c.b
{
  public String desc;
  public int iconRes;
  
  public d$a(d paramd, long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramLong1, paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final boolean atP(String paramString)
  {
    AppMethodBeat.i(32543);
    if (paramString != null)
    {
      boolean bool = super.atP(paramString.toLowerCase());
      AppMethodBeat.o(32543);
      return bool;
    }
    AppMethodBeat.o(32543);
    return false;
  }
  
  public final int getType()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.d.a
 * JD-Core Version:    0.7.0.1
 */