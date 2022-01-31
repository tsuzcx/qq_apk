package com.tencent.tmassistantsdk.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;

public class Res
{
  private static final String TAG = "Res";
  protected final String RclassName;
  protected Context ctx;
  
  public Res(Context paramContext)
  {
    AppMethodBeat.i(76281);
    this.ctx = paramContext;
    this.RclassName = (this.ctx.getPackageName() + ".R");
    AppMethodBeat.o(76281);
  }
  
  private int reflectResouce(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76282);
    if ((this.RclassName == null) || (paramString1 == null) || (paramString2 == null))
    {
      AppMethodBeat.o(76282);
      return 0;
    }
    try
    {
      paramString1 = Class.forName(this.RclassName + "$" + paramString1);
      int i = bo.getInt(paramString1.getField(paramString2).get(paramString1.newInstance()).toString(), -1);
      AppMethodBeat.o(76282);
      return i;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("Res", paramString1, "", new Object[0]);
      AppMethodBeat.o(76282);
    }
    return -1;
  }
  
  public int drawable(String paramString)
  {
    AppMethodBeat.i(76284);
    int i = reflectResouce("drawable", paramString);
    AppMethodBeat.o(76284);
    return i;
  }
  
  public int id(String paramString)
  {
    AppMethodBeat.i(76286);
    int i = reflectResouce("id", paramString);
    AppMethodBeat.o(76286);
    return i;
  }
  
  public int layout(String paramString)
  {
    AppMethodBeat.i(76285);
    int i = reflectResouce("layout", paramString);
    AppMethodBeat.o(76285);
    return i;
  }
  
  public int string(String paramString)
  {
    AppMethodBeat.i(76283);
    int i = reflectResouce("string", paramString);
    AppMethodBeat.o(76283);
    return i;
  }
  
  public int style(String paramString)
  {
    AppMethodBeat.i(76287);
    int i = reflectResouce("style", paramString);
    AppMethodBeat.o(76287);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.Res
 * JD-Core Version:    0.7.0.1
 */