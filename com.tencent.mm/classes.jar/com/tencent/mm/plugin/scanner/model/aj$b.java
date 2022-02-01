package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class aj$b
{
  private String firstName;
  private String lastName;
  private String middleName;
  
  public aj$b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(51653);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.firstName = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.middleName = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.lastName = paramString1;
    AppMethodBeat.o(51653);
  }
  
  public final String bRQ()
  {
    AppMethodBeat.i(51654);
    Object localObject = new StringBuilder();
    if ((Util.isChinese(this.firstName)) || (Util.isChinese(this.middleName)) || (Util.isChinese(this.lastName)))
    {
      if (this.lastName.trim().length() > 0) {
        ((StringBuilder)localObject).append(this.lastName);
      }
      if (this.middleName.trim().length() > 0) {
        ((StringBuilder)localObject).append(this.middleName);
      }
      if (this.firstName.trim().length() > 0) {
        ((StringBuilder)localObject).append(this.firstName);
      }
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(51654);
      return localObject;
      if (this.firstName.trim().length() > 0) {
        ((StringBuilder)localObject).append(this.firstName);
      }
      if (this.middleName.trim().length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.middleName);
      }
      if (this.lastName.trim().length() > 0)
      {
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(this.lastName);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.aj.b
 * JD-Core Version:    0.7.0.1
 */