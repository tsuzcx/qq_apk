package com.tencent.xweb.a;

import android.os.Bundle;
import com.tencent.xweb.l;
import java.util.Map;

public final class a
{
  l xhA;
  
  public a(l paraml)
  {
    this.xhA = paraml;
  }
  
  public final Bundle getBundle()
  {
    Object localObject;
    if ((this.xhA != null) && (this.xhA.getRequestHeaders() != null) && (!this.xhA.isForMainFrame()) && (this.xhA.getRequestHeaders().containsKey("Accept")))
    {
      localObject = (String)this.xhA.getRequestHeaders().get("Accept");
      if ((localObject == null) || (!((String)localObject).startsWith("text/html"))) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("resourceType", 1);
        return localObject;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.a.a
 * JD-Core Version:    0.7.0.1
 */