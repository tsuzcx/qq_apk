package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class aj$a
{
  private String INa;
  private String INb;
  private String country;
  private String lLi;
  private String oOu;
  private String oOv;
  private String region;
  
  public aj$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(51651);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.INa = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.INb = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.oOu = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    this.lLi = paramString1;
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    this.region = paramString1;
    paramString1 = paramString6;
    if (paramString6 == null) {
      paramString1 = "";
    }
    this.oOv = paramString1;
    paramString1 = paramString7;
    if (paramString7 == null) {
      paramString1 = "";
    }
    this.country = paramString1;
    AppMethodBeat.o(51651);
  }
  
  public final String bRQ()
  {
    AppMethodBeat.i(51652);
    if ((Util.isChinese(this.INa)) || (Util.isChinese(this.INb)) || (Util.isChinese(this.oOu)) || (Util.isChinese(this.lLi)) || (Util.isChinese(this.region)) || (Util.isChinese(this.country)))
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
      if (this.lLi.length() > 0) {
        ((StringBuilder)localObject).append(this.lLi);
      }
      if ((this.region.length() > 0) || (this.lLi.length() > 0)) {
        ((StringBuilder)localObject).append("\n");
      }
      if (this.oOu.length() > 0)
      {
        ((StringBuilder)localObject).append(this.oOu + " ");
        ((StringBuilder)localObject).append("\n");
      }
      if (this.INb.length() > 0)
      {
        ((StringBuilder)localObject).append(this.INb);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.INa.length() > 0)
      {
        ((StringBuilder)localObject).append(this.INa);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.oOv.length() > 0) {
        ((StringBuilder)localObject).append(this.oOv);
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
    if (this.INa.length() > 0)
    {
      ((StringBuilder)localObject).append(this.INa);
      ((StringBuilder)localObject).append("\n");
    }
    if (this.INb.length() > 0)
    {
      ((StringBuilder)localObject).append(this.INb);
      ((StringBuilder)localObject).append("\n");
    }
    if (this.oOu.length() > 0)
    {
      ((StringBuilder)localObject).append(this.oOu);
      ((StringBuilder)localObject).append("\n");
    }
    if (this.lLi.length() > 0) {
      ((StringBuilder)localObject).append(this.lLi + " ");
    }
    if (this.region.length() > 0) {
      ((StringBuilder)localObject).append(this.region + " ");
    }
    if (this.oOv.length() > 0) {
      ((StringBuilder)localObject).append(this.oOv);
    }
    if ((this.lLi.length() > 0) || (this.region.length() > 0)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.aj.a
 * JD-Core Version:    0.7.0.1
 */