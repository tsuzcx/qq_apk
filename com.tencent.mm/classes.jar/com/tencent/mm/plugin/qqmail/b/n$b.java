package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class n$b
{
  int pJa;
  Map<String, String> pJb;
  Map<String, String> pJc;
  n.d pJd;
  
  public n$b(int paramInt, Map<String, String> paramMap1, Map<String, String> paramMap2, n.d paramd)
  {
    this.pJa = paramInt;
    this.pJb = paramMap1;
    this.pJc = paramMap2;
    this.pJd = paramd;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(67958);
    StringBuilder localStringBuilder = new StringBuilder("Request method:").append(this.pJa).append(", params:");
    if (this.pJb != null)
    {
      localObject = this.pJb;
      localStringBuilder = localStringBuilder.append(localObject).append(", cookie:");
      if (this.pJc == null) {
        break label84;
      }
    }
    label84:
    for (Object localObject = this.pJc;; localObject = "")
    {
      localObject = localObject;
      AppMethodBeat.o(67958);
      return localObject;
      localObject = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.n.b
 * JD-Core Version:    0.7.0.1
 */