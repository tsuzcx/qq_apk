package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.a.c.b;

final class a$a
  extends c.b
{
  public j.b cEn;
  public long cFn;
  public String desc;
  public String fiY;
  public String iXo;
  public String imagePath;
  
  public a$a(a parama, long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, j.b paramb, long paramLong3, String paramString7, String paramString8, String paramString9)
  {
    super(paramLong1, paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
    this.fiY = paramString6;
    this.cEn = paramb;
    this.cFn = paramLong3;
    this.desc = paramString7;
    this.imagePath = paramString8;
    this.iXo = paramString9;
  }
  
  public final boolean atP(String paramString)
  {
    AppMethodBeat.i(32514);
    if (paramString != null)
    {
      paramString = paramString.toLowerCase();
      if (!atQ(paramString))
      {
        if ((!bo.isNullOrNil(this.desc)) && (isContains(paramString, this.desc.toLowerCase())))
        {
          AppMethodBeat.o(32514);
          return true;
        }
      }
      else if ((!bo.isNullOrNil(this.desc)) && (this.desc.toLowerCase().contains(paramString)))
      {
        AppMethodBeat.o(32514);
        return true;
      }
      boolean bool = super.atP(paramString);
      AppMethodBeat.o(32514);
      return bool;
    }
    AppMethodBeat.o(32514);
    return false;
  }
  
  public final int getType()
  {
    return 33;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a.a
 * JD-Core Version:    0.7.0.1
 */