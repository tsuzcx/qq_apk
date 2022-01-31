package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class i
{
  public k ndq;
  
  public i(String paramString)
  {
    this.ndq = new k(paramString, 10);
  }
  
  public static String ci(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return g.DP().Dz().get(9, null);
    }
    return paramString + "_" + paramInt;
  }
  
  public final j ch(String paramString, int paramInt)
  {
    paramString = k.readFromFile(this.ndq.ndA + ci(paramString, paramInt));
    if ((paramString == null) || (paramString.length == 0)) {
      return null;
    }
    try
    {
      paramString = (j)new j().aH(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      y.printErrStackTrace("MicroMsg.DraftBoxMgr", paramString, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.i
 * JD-Core Version:    0.7.0.1
 */