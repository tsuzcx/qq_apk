package com.tencent.tmassistantsdk.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;

public class Res
{
  private static final String TAG = "Res";
  protected final String RclassName;
  protected Context ctx;
  
  public Res(Context paramContext)
  {
    AppMethodBeat.i(102524);
    this.ctx = paramContext;
    this.RclassName = (this.ctx.getPackageName() + ".R");
    AppMethodBeat.o(102524);
  }
  
  private int reflectResouce(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102525);
    if ((this.RclassName == null) || (paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(102525);
      return 0;
    }
    try
    {
      paramString1 = Class.forName(this.RclassName + "$" + paramString1);
      int i = Util.getInt(paramString1.getField(paramString2).get(paramString1.newInstance()).toString(), -1);
      AppMethodBeat.o(102525);
      return i;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("Res", paramString1, "", new Object[0]);
      AppMethodBeat.o(102525);
    }
    return -1;
  }
  
  public int drawable(String paramString)
  {
    AppMethodBeat.i(102527);
    int i = reflectResouce("drawable", paramString);
    AppMethodBeat.o(102527);
    return i;
  }
  
  public int id(String paramString)
  {
    AppMethodBeat.i(102529);
    int i = reflectResouce("id", paramString);
    AppMethodBeat.o(102529);
    return i;
  }
  
  public int layout(String paramString)
  {
    AppMethodBeat.i(102528);
    int i = reflectResouce("layout", paramString);
    AppMethodBeat.o(102528);
    return i;
  }
  
  public int string(String paramString)
  {
    AppMethodBeat.i(102526);
    int i = reflectResouce("string", paramString);
    AppMethodBeat.o(102526);
    return i;
  }
  
  public int style(String paramString)
  {
    AppMethodBeat.i(102530);
    int i = reflectResouce("style", paramString);
    AppMethodBeat.o(102530);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.Res
 * JD-Core Version:    0.7.0.1
 */