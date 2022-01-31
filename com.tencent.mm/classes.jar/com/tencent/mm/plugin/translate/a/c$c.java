package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.model.bd;

public final class c$c
{
  private static int pKK = 0;
  public String aWf;
  public byte[] cQQ;
  public String cad;
  public String cbK;
  public String cbR;
  public String id;
  public int pKH;
  public int pKI;
  public String pKJ;
  public int ret;
  public int type;
  
  public c$c(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte)
  {
    this.cbK = paramString1;
    this.id = paramString2;
    this.type = paramInt;
    this.aWf = paramString3;
    this.cQQ = paramArrayOfByte;
    if (pKK == 2147483647) {
      pKK = 0;
    }
    int i = pKK + 1;
    pKK = i;
    this.pKI = i;
    if (paramInt == 1)
    {
      paramInt = bd.iH(paramString1);
      if (paramInt != -1)
      {
        paramString2 = paramString1.substring(0, paramInt).trim();
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          this.pKJ = paramString2;
          this.cbK = paramString1.substring(paramInt + 1).trim();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.c.c
 * JD-Core Version:    0.7.0.1
 */