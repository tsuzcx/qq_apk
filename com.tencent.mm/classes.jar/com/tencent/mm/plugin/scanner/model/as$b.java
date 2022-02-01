package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class as$b
{
  private String rSj;
  private String rSk;
  private String rSl;
  
  public as$b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(51653);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.rSj = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.rSk = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.rSl = paramString1;
    AppMethodBeat.o(51653);
  }
  
  public final String crV()
  {
    AppMethodBeat.i(51654);
    Object localObject = new StringBuilder();
    if ((Util.isChinese(this.rSj)) || (Util.isChinese(this.rSk)) || (Util.isChinese(this.rSl)))
    {
      if (this.rSl.trim().length() > 0) {
        ((StringBuilder)localObject).append(this.rSl);
      }
      if (this.rSk.trim().length() > 0) {
        ((StringBuilder)localObject).append(this.rSk);
      }
      if (this.rSj.trim().length() > 0) {
        ((StringBuilder)localObject).append(this.rSj);
      }
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(51654);
      return localObject;
      if (this.rSj.trim().length() > 0) {
        ((StringBuilder)localObject).append(this.rSj);
      }
      if (this.rSk.trim().length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.rSk);
      }
      if (this.rSl.trim().length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.rSl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.as.b
 * JD-Core Version:    0.7.0.1
 */