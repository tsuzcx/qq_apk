package com.tencent.xweb.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.r;
import java.util.Map;

public final class a
{
  r BEN;
  
  public a(r paramr)
  {
    this.BEN = paramr;
  }
  
  public final Bundle getBundle()
  {
    AppMethodBeat.i(84556);
    Object localObject;
    if ((this.BEN != null) && (this.BEN.getRequestHeaders() != null) && (!this.BEN.isForMainFrame()) && (this.BEN.getRequestHeaders().containsKey("Accept")))
    {
      localObject = (String)this.BEN.getRequestHeaders().get("Accept");
      if ((localObject == null) || (!((String)localObject).startsWith("text/html"))) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("resourceType", 1);
        AppMethodBeat.o(84556);
        return localObject;
      }
      AppMethodBeat.o(84556);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.a.a
 * JD-Core Version:    0.7.0.1
 */