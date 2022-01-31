package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bk;

public final class p$a
{
  private String country;
  private String eBh;
  private String elb;
  private String fGP;
  private String fGQ;
  private String nHR;
  private String nHS;
  
  public p$a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.nHR = str;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this.nHS = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this.fGP = paramString1;
    paramString1 = paramString4;
    if (paramString4 == null) {
      paramString1 = "";
    }
    this.elb = paramString1;
    paramString1 = paramString5;
    if (paramString5 == null) {
      paramString1 = "";
    }
    this.eBh = paramString1;
    paramString1 = paramString6;
    if (paramString6 == null) {
      paramString1 = "";
    }
    this.fGQ = paramString1;
    paramString1 = paramString7;
    if (paramString7 == null) {
      paramString1 = "";
    }
    this.country = paramString1;
  }
  
  public final String acH()
  {
    Object localObject;
    String str;
    if ((bk.Zz(this.nHR)) || (bk.Zz(this.nHS)) || (bk.Zz(this.fGP)) || (bk.Zz(this.elb)) || (bk.Zz(this.eBh)) || (bk.Zz(this.country)))
    {
      localObject = new StringBuilder();
      if (this.country.length() > 0)
      {
        ((StringBuilder)localObject).append(this.country);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.eBh.length() > 0) {
        ((StringBuilder)localObject).append(this.eBh + " ");
      }
      if (this.elb.length() > 0) {
        ((StringBuilder)localObject).append(this.elb);
      }
      if ((this.eBh.length() > 0) || (this.elb.length() > 0)) {
        ((StringBuilder)localObject).append("\n");
      }
      if (this.fGP.length() > 0)
      {
        ((StringBuilder)localObject).append(this.fGP + " ");
        ((StringBuilder)localObject).append("\n");
      }
      if (this.nHS.length() > 0)
      {
        ((StringBuilder)localObject).append(this.nHS);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.nHR.length() > 0)
      {
        ((StringBuilder)localObject).append(this.nHR);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.fGQ.length() > 0) {
        ((StringBuilder)localObject).append(this.fGQ);
      }
      str = ((StringBuilder)localObject).toString();
      localObject = str;
      if (str.endsWith("\n")) {
        localObject = str.substring(0, str.length() - 1);
      }
    }
    do
    {
      return localObject;
      localObject = new StringBuilder();
      if (this.nHR.length() > 0)
      {
        ((StringBuilder)localObject).append(this.nHR);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.nHS.length() > 0)
      {
        ((StringBuilder)localObject).append(this.nHS);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.fGP.length() > 0)
      {
        ((StringBuilder)localObject).append(this.fGP);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.elb.length() > 0) {
        ((StringBuilder)localObject).append(this.elb + " ");
      }
      if (this.eBh.length() > 0) {
        ((StringBuilder)localObject).append(this.eBh + " ");
      }
      if (this.fGQ.length() > 0) {
        ((StringBuilder)localObject).append(this.fGQ);
      }
      if ((this.elb.length() > 0) || (this.eBh.length() > 0)) {
        ((StringBuilder)localObject).append("\n");
      }
      if (this.country.length() > 0) {
        ((StringBuilder)localObject).append(this.country);
      }
      str = ((StringBuilder)localObject).toString();
      localObject = str;
    } while (!str.endsWith("\n"));
    return str.substring(0, str.length() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.p.a
 * JD-Core Version:    0.7.0.1
 */