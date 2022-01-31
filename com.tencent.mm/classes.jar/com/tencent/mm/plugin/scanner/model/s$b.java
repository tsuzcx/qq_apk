package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class s$b
{
  private String firstName;
  private String lastName;
  private String middleName;
  
  public s$b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(80888);
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
    AppMethodBeat.o(80888);
  }
  
  public final String aCR()
  {
    AppMethodBeat.i(80889);
    Object localObject = new StringBuilder();
    if ((bo.apE(this.firstName)) || (bo.apE(this.middleName)) || (bo.apE(this.lastName)))
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
      AppMethodBeat.o(80889);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.s.b
 * JD-Core Version:    0.7.0.1
 */