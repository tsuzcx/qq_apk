package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bf;

public final class c$c
{
  private static int toW = 0;
  public String cID;
  public String cKn;
  public String cKw;
  public int cKx;
  public byte[] dHc;
  public String id;
  public int ret;
  public String source;
  public int toU;
  public String toV;
  public int type;
  
  public c$c(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26062);
    this.cKn = paramString1;
    this.id = paramString2;
    this.type = paramInt;
    this.source = paramString3;
    this.dHc = paramArrayOfByte;
    if (toW == 2147483647) {
      toW = 0;
    }
    int i = toW + 1;
    toW = i;
    this.toU = i;
    if (paramInt == 1)
    {
      paramInt = bf.pt(paramString1);
      if (paramInt != -1)
      {
        paramString2 = paramString1.substring(0, paramInt).trim();
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          this.toV = paramString2;
          this.cKn = paramString1.substring(paramInt + 1).trim();
        }
      }
    }
    AppMethodBeat.o(26062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.c.c
 * JD-Core Version:    0.7.0.1
 */