package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class u
{
  private DexLoader a = null;
  
  public u(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public String a(Context paramContext)
  {
    AppMethodBeat.i(188414);
    if (this.a != null)
    {
      Object localObject = this.a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
      if (localObject != null)
      {
        paramContext = this.a.invokeMethod(localObject, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[] { Context.class }, new Object[] { paramContext });
        if (paramContext != null)
        {
          paramContext = String.valueOf(paramContext);
          AppMethodBeat.o(188414);
          return paramContext;
        }
      }
    }
    AppMethodBeat.o(188414);
    return "";
  }
  
  public void a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(188413);
    if (this.a != null)
    {
      Object localObject = this.a.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
      if (localObject != null) {
        this.a.invokeMethod(localObject, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
      }
    }
    AppMethodBeat.o(188413);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.u
 * JD-Core Version:    0.7.0.1
 */