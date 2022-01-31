package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class n$c
{
  String content;
  Map<String, String> pJc;
  int status = 0;
  
  public n$c(int paramInt, Map<String, String> paramMap, String paramString)
  {
    this.status = paramInt;
    this.pJc = paramMap;
    this.content = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(67959);
    StringBuilder localStringBuilder = new StringBuilder("Response status:").append(this.status).append(", cookie:");
    Object localObject;
    if (this.pJc != null)
    {
      localObject = this.pJc;
      localObject = localStringBuilder.append(localObject).append(", content length :");
      if (this.content == null) {
        break label87;
      }
    }
    label87:
    for (int i = this.content.length();; i = 0)
    {
      localObject = i;
      AppMethodBeat.o(67959);
      return localObject;
      localObject = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.n.c
 * JD-Core Version:    0.7.0.1
 */