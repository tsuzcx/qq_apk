package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class s$a
{
  private String country;
  private String fBs;
  private String fQZ;
  private String hKf;
  private String hKg;
  private String qvr;
  private String qvs;
  
  public s$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(80886);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.qvr = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.qvs = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.hKf = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    this.fBs = paramString1;
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    this.fQZ = paramString1;
    paramString1 = paramString6;
    if (paramString6 == null) {
      paramString1 = "";
    }
    this.hKg = paramString1;
    paramString1 = paramString7;
    if (paramString7 == null) {
      paramString1 = "";
    }
    this.country = paramString1;
    AppMethodBeat.o(80886);
  }
  
  public final String aCR()
  {
    AppMethodBeat.i(80887);
    if ((bo.apE(this.qvr)) || (bo.apE(this.qvs)) || (bo.apE(this.hKf)) || (bo.apE(this.fBs)) || (bo.apE(this.fQZ)) || (bo.apE(this.country)))
    {
      localObject = new StringBuilder();
      if (this.country.length() > 0)
      {
        ((StringBuilder)localObject).append(this.country);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.fQZ.length() > 0) {
        ((StringBuilder)localObject).append(this.fQZ + " ");
      }
      if (this.fBs.length() > 0) {
        ((StringBuilder)localObject).append(this.fBs);
      }
      if ((this.fQZ.length() > 0) || (this.fBs.length() > 0)) {
        ((StringBuilder)localObject).append("\n");
      }
      if (this.hKf.length() > 0)
      {
        ((StringBuilder)localObject).append(this.hKf + " ");
        ((StringBuilder)localObject).append("\n");
      }
      if (this.qvs.length() > 0)
      {
        ((StringBuilder)localObject).append(this.qvs);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.qvr.length() > 0)
      {
        ((StringBuilder)localObject).append(this.qvr);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.hKg.length() > 0) {
        ((StringBuilder)localObject).append(this.hKg);
      }
      str = ((StringBuilder)localObject).toString();
      localObject = str;
      if (str.endsWith("\n")) {
        localObject = str.substring(0, str.length() - 1);
      }
      AppMethodBeat.o(80887);
      return localObject;
    }
    Object localObject = new StringBuilder();
    if (this.qvr.length() > 0)
    {
      ((StringBuilder)localObject).append(this.qvr);
      ((StringBuilder)localObject).append("\n");
    }
    if (this.qvs.length() > 0)
    {
      ((StringBuilder)localObject).append(this.qvs);
      ((StringBuilder)localObject).append("\n");
    }
    if (this.hKf.length() > 0)
    {
      ((StringBuilder)localObject).append(this.hKf);
      ((StringBuilder)localObject).append("\n");
    }
    if (this.fBs.length() > 0) {
      ((StringBuilder)localObject).append(this.fBs + " ");
    }
    if (this.fQZ.length() > 0) {
      ((StringBuilder)localObject).append(this.fQZ + " ");
    }
    if (this.hKg.length() > 0) {
      ((StringBuilder)localObject).append(this.hKg);
    }
    if ((this.fBs.length() > 0) || (this.fQZ.length() > 0)) {
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
    AppMethodBeat.o(80887);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.s.a
 * JD-Core Version:    0.7.0.1
 */