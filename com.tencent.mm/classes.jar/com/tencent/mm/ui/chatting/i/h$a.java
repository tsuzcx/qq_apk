package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.a.c.b;

final class h$a
  extends c.b
{
  public String appId;
  public String desc;
  public int iconRes;
  public String imagePath;
  public String source;
  
  public h$a(h paramh, long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramLong1, paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final boolean atP(String paramString)
  {
    AppMethodBeat.i(32646);
    if (paramString != null)
    {
      paramString = paramString.toLowerCase();
      if (!atQ(paramString))
      {
        if ((!bo.isNullOrNil(this.source)) && (isContains(paramString, this.source.toLowerCase())))
        {
          AppMethodBeat.o(32646);
          return true;
        }
      }
      else if ((!bo.isNullOrNil(this.source)) && (this.source.toLowerCase().contains(paramString)))
      {
        AppMethodBeat.o(32646);
        return true;
      }
      boolean bool = super.atP(paramString);
      AppMethodBeat.o(32646);
      return bool;
    }
    AppMethodBeat.o(32646);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.h.a
 * JD-Core Version:    0.7.0.1
 */