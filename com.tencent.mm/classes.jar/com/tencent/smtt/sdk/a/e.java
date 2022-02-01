package com.tencent.smtt.sdk.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class e
  implements d
{
  private DexLoader a;
  
  public e(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public void a()
  {
    AppMethodBeat.i(54828);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    AppMethodBeat.o(54828);
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54827);
    paramContext = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
    if ((paramContext instanceof Boolean))
    {
      boolean bool = ((Boolean)paramContext).booleanValue();
      AppMethodBeat.o(54827);
      return bool;
    }
    AppMethodBeat.o(54827);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.e
 * JD-Core Version:    0.7.0.1
 */