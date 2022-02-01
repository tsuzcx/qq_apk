package com.tencent.xweb;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class ab
{
  private WebResourceRequest aifm;
  
  public ab(WebResourceRequest paramWebResourceRequest)
  {
    this.aifm = paramWebResourceRequest;
  }
  
  public final Bundle getBundle()
  {
    AppMethodBeat.i(212498);
    Object localObject;
    if ((this.aifm != null) && (this.aifm.getRequestHeaders() != null) && (!this.aifm.isForMainFrame()) && (this.aifm.getRequestHeaders().containsKey("Accept")))
    {
      localObject = (String)this.aifm.getRequestHeaders().get("Accept");
      if ((localObject == null) || (!((String)localObject).startsWith("text/html"))) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("resourceType", 1);
        AppMethodBeat.o(212498);
        return localObject;
      }
      AppMethodBeat.o(212498);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.ab
 * JD-Core Version:    0.7.0.1
 */