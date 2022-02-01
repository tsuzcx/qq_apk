package com.tencent.xweb.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebResourceRequest;
import java.util.Map;

public final class a
{
  WebResourceRequest aabR;
  
  public a(WebResourceRequest paramWebResourceRequest)
  {
    this.aabR = paramWebResourceRequest;
  }
  
  public final Bundle getBundle()
  {
    AppMethodBeat.i(153550);
    Object localObject;
    if ((this.aabR != null) && (this.aabR.getRequestHeaders() != null) && (!this.aabR.isForMainFrame()) && (this.aabR.getRequestHeaders().containsKey("Accept")))
    {
      localObject = (String)this.aabR.getRequestHeaders().get("Accept");
      if ((localObject == null) || (!((String)localObject).startsWith("text/html"))) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("resourceType", 1);
        AppMethodBeat.o(153550);
        return localObject;
      }
      AppMethodBeat.o(153550);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.a.a
 * JD-Core Version:    0.7.0.1
 */