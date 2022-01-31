package com.tencent.mm.plugin.n;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;

public final class a
{
  public String lnE;
  public String lnF;
  public int lnG;
  public int lnH;
  public int lnI;
  public int lnJ;
  public int lnK;
  public int lnL;
  
  public static String Fv(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    return paramString.replace(",", ";");
  }
  
  public static String bM(String paramString)
  {
    paramString = e.c(paramString, 0, 6);
    if ((paramString == null) || (paramString.length != 6)) {
      return "";
    }
    try
    {
      paramString = new String(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      y.e("MicroMsg.ImgExtInfoReport", "getFileExt UnsupportedEncodingException:" + paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.n.a
 * JD-Core Version:    0.7.0.1
 */