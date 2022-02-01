package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

public final class ae
{
  public static ae xaP;
  public String bLs;
  public String exO;
  public String koE;
  public String kow;
  public String title;
  public String url;
  public c xaA;
  c xaB;
  public String xaC;
  public a xaD;
  public a xaE;
  public a xaF;
  public a xaG;
  public List<String> xaH;
  public List<String> xaI;
  public List<String> xaJ;
  public List<String> xaK;
  public List<String> xaL;
  public String xaM;
  public String xaN;
  public String xaO;
  public b xay;
  c xaz;
  
  public static final class a
  {
    private String country;
    private String hEv;
    private String hUi;
    private String koI;
    private String koJ;
    private String xaQ;
    private String xaR;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      AppMethodBeat.i(51651);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      this.xaQ = str;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      this.xaR = paramString1;
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      this.koI = paramString1;
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      this.hEv = paramString1;
      paramString1 = paramString5;
      if (paramString5 == null) {
        paramString1 = "";
      }
      this.hUi = paramString1;
      paramString1 = paramString6;
      if (paramString6 == null) {
        paramString1 = "";
      }
      this.koJ = paramString1;
      paramString1 = paramString7;
      if (paramString7 == null) {
        paramString1 = "";
      }
      this.country = paramString1;
      AppMethodBeat.o(51651);
    }
    
    public final String bgx()
    {
      AppMethodBeat.i(51652);
      if ((bs.aLj(this.xaQ)) || (bs.aLj(this.xaR)) || (bs.aLj(this.koI)) || (bs.aLj(this.hEv)) || (bs.aLj(this.hUi)) || (bs.aLj(this.country)))
      {
        localObject = new StringBuilder();
        if (this.country.length() > 0)
        {
          ((StringBuilder)localObject).append(this.country);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.hUi.length() > 0) {
          ((StringBuilder)localObject).append(this.hUi + " ");
        }
        if (this.hEv.length() > 0) {
          ((StringBuilder)localObject).append(this.hEv);
        }
        if ((this.hUi.length() > 0) || (this.hEv.length() > 0)) {
          ((StringBuilder)localObject).append("\n");
        }
        if (this.koI.length() > 0)
        {
          ((StringBuilder)localObject).append(this.koI + " ");
          ((StringBuilder)localObject).append("\n");
        }
        if (this.xaR.length() > 0)
        {
          ((StringBuilder)localObject).append(this.xaR);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.xaQ.length() > 0)
        {
          ((StringBuilder)localObject).append(this.xaQ);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.koJ.length() > 0) {
          ((StringBuilder)localObject).append(this.koJ);
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
      if (this.xaQ.length() > 0)
      {
        ((StringBuilder)localObject).append(this.xaQ);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.xaR.length() > 0)
      {
        ((StringBuilder)localObject).append(this.xaR);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.koI.length() > 0)
      {
        ((StringBuilder)localObject).append(this.koI);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.hEv.length() > 0) {
        ((StringBuilder)localObject).append(this.hEv + " ");
      }
      if (this.hUi.length() > 0) {
        ((StringBuilder)localObject).append(this.hUi + " ");
      }
      if (this.koJ.length() > 0) {
        ((StringBuilder)localObject).append(this.koJ);
      }
      if ((this.hEv.length() > 0) || (this.hUi.length() > 0)) {
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
  
  public static final class b
  {
    private String firstName;
    private String lastName;
    private String middleName;
    
    public b(String paramString1, String paramString2, String paramString3)
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
    
    public final String bgx()
    {
      AppMethodBeat.i(51654);
      Object localObject = new StringBuilder();
      if ((bs.aLj(this.firstName)) || (bs.aLj(this.middleName)) || (bs.aLj(this.lastName)))
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
  
  public static final class c
  {
    public String gSN;
    public String xaS;
    
    public c(String paramString1, String paramString2)
    {
      this.gSN = paramString1;
      this.xaS = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ae
 * JD-Core Version:    0.7.0.1
 */