package com.tencent.mm.ui.chatting.h;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.chatting.a.c.b;

final class f$a
  extends c.b
{
  public String aWf;
  public String appId;
  public int iconRes;
  public String imagePath;
  
  public f$a(f paramf, long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramLong1, paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final boolean ado(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.toLowerCase();
      if (!adp(paramString))
      {
        if ((bk.bl(this.aWf)) || (!isContains(paramString, this.aWf.toLowerCase()))) {}
      }
      else {
        while ((!bk.bl(this.aWf)) && (this.aWf.toLowerCase().contains(paramString))) {
          return true;
        }
      }
      return super.ado(paramString);
    }
    return false;
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.f.a
 * JD-Core Version:    0.7.0.1
 */