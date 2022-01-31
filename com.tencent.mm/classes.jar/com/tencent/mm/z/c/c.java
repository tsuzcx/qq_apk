package com.tencent.mm.z.c;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.d.a;
import java.util.Map;

public final class c
{
  c.a eGo;
  private a eGp;
  public d eGq;
  b eGr;
  
  public c(Context paramContext, e parame, a parama, b paramb)
  {
    AppMethodBeat.i(115304);
    this.eGo = new c.a(paramContext, parame);
    this.eGp = parama;
    this.eGr = paramb;
    AppMethodBeat.o(115304);
  }
  
  public final String f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(115305);
    try
    {
      Object localObject = this.eGq;
      if (bo.isNullOrNil(paramString1)) {}
      for (localObject = null; localObject == null; localObject = (com.tencent.mm.z.b.b)((d)localObject).eGv.get(paramString1))
      {
        paramString2 = this.eGr.mh(paramString1);
        AppMethodBeat.o(115305);
        return paramString2;
      }
      paramString2 = this.eGr.a(this.eGo, this.eGp, (com.tencent.mm.z.b.b)localObject, paramString2, new c.1(this, paramInt));
      AppMethodBeat.o(115305);
      return paramString2;
    }
    catch (Exception paramString2)
    {
      ab.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", new Object[] { paramString1, Log.getStackTraceString(paramString2) });
      AppMethodBeat.o(115305);
      throw paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.z.c.c
 * JD-Core Version:    0.7.0.1
 */