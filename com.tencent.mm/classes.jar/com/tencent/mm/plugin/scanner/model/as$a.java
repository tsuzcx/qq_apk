package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class as$a
{
  private String OUd;
  private String OUe;
  private String country;
  private String oDK;
  private String rSh;
  private String rSi;
  private String region;
  
  public as$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(51651);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.OUd = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.OUe = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.rSh = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    this.oDK = paramString1;
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    this.region = paramString1;
    paramString1 = paramString6;
    if (paramString6 == null) {
      paramString1 = "";
    }
    this.rSi = paramString1;
    paramString1 = paramString7;
    if (paramString7 == null) {
      paramString1 = "";
    }
    this.country = paramString1;
    AppMethodBeat.o(51651);
  }
  
  public final String crV()
  {
    AppMethodBeat.i(51652);
    if ((Util.isChinese(this.OUd)) || (Util.isChinese(this.OUe)) || (Util.isChinese(this.rSh)) || (Util.isChinese(this.oDK)) || (Util.isChinese(this.region)) || (Util.isChinese(this.country)))
    {
      localObject = new StringBuilder();
      if (this.country.length() > 0)
      {
        ((StringBuilder)localObject).append(this.country);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.region.length() > 0) {
        ((StringBuilder)localObject).append(this.region + " ");
      }
      if (this.oDK.length() > 0) {
        ((StringBuilder)localObject).append(this.oDK);
      }
      if ((this.region.length() > 0) || (this.oDK.length() > 0)) {
        ((StringBuilder)localObject).append("\n");
      }
      if (this.rSh.length() > 0)
      {
        ((StringBuilder)localObject).append(this.rSh + " ");
        ((StringBuilder)localObject).append("\n");
      }
      if (this.OUe.length() > 0)
      {
        ((StringBuilder)localObject).append(this.OUe);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.OUd.length() > 0)
      {
        ((StringBuilder)localObject).append(this.OUd);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.rSi.length() > 0) {
        ((StringBuilder)localObject).append(this.rSi);
      }
      str = ((StringBuilder)localObject).toString();
      localObject = str;
      if (str.endsWith("\n")) {
        localObject = str.substring(0, str.length() - 1);
      }
      AppMethodBeat.o(51652);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (this.OUd.length() > 0)
    {
      ((StringBuilder)localObject).append(this.OUd);
      ((StringBuilder)localObject).append("\n");
    }
    if (this.OUe.length() > 0)
    {
      ((StringBuilder)localObject).append(this.OUe);
      ((StringBuilder)localObject).append("\n");
    }
    if (this.rSh.length() > 0)
    {
      ((StringBuilder)localObject).append(this.rSh);
      ((StringBuilder)localObject).append("\n");
    }
    if (this.oDK.length() > 0) {
      ((StringBuilder)localObject).append(this.oDK + " ");
    }
    if (this.region.length() > 0) {
      ((StringBuilder)localObject).append(this.region + " ");
    }
    if (this.rSi.length() > 0) {
      ((StringBuilder)localObject).append(this.rSi);
    }
    if ((this.oDK.length() > 0) || (this.region.length() > 0)) {
      ((StringBuilder)localObject).append("\n");
    }
    if (this.country.length() > 0) {
      ((StringBuilder)localObject).append(this.country);
    }
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (str.endsWith("\n")) {
      localObject = str.substring(0, str.length() - 1);
    }
    AppMethodBeat.o(51652);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.as.a
 * JD-Core Version:    0.7.0.1
 */