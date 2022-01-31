package com.tencent.tmassistantsdk.util;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;

public class Res
{
  private static final String TAG = "Res";
  protected final String RclassName;
  protected Context ctx;
  
  public Res(Context paramContext)
  {
    this.ctx = paramContext;
    this.RclassName = (this.ctx.getPackageName() + ".R");
  }
  
  private int reflectResouce(String paramString1, String paramString2)
  {
    if ((this.RclassName == null) || (paramString1 == null) || (paramString2 == null)) {
      return 0;
    }
    try
    {
      paramString1 = Class.forName(this.RclassName + "$" + paramString1);
      int i = bk.getInt(paramString1.getField(paramString2).get(paramString1.newInstance()).toString(), -1);
      return i;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("Res", paramString1, "", new Object[0]);
    }
    return -1;
  }
  
  public int drawable(String paramString)
  {
    return reflectResouce("drawable", paramString);
  }
  
  public int id(String paramString)
  {
    return reflectResouce("id", paramString);
  }
  
  public int layout(String paramString)
  {
    return reflectResouce("layout", paramString);
  }
  
  public int string(String paramString)
  {
    return reflectResouce("string", paramString);
  }
  
  public int style(String paramString)
  {
    return reflectResouce("style", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.Res
 * JD-Core Version:    0.7.0.1
 */