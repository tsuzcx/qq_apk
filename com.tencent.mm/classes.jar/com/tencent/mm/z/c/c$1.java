package com.tencent.mm.z.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.b.b.a;
import com.tencent.mm.z.b.d;

final class c$1
  implements b.a
{
  c$1(c paramc, int paramInt) {}
  
  public final void aj(Object paramObject)
  {
    AppMethodBeat.i(115302);
    e locale = this.eGs.eGo.eGt;
    int i = this.bAX;
    if (paramObject == null) {}
    for (paramObject = "";; paramObject = paramObject.toString())
    {
      Object localObject = paramObject;
      if (bo.isNullOrNil(paramObject)) {
        localObject = "{}";
      }
      locale.eGy.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[] { Integer.valueOf(i), localObject }), null);
      AppMethodBeat.o(115302);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.z.c.c.1
 * JD-Core Version:    0.7.0.1
 */