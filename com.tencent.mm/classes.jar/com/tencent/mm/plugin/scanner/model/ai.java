package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

public final class ai
{
  public static ai yEN;
  public String bVF;
  public String eQY;
  public String kML;
  public String kMT;
  public String title;
  public String url;
  public String yEA;
  public a yEB;
  public a yEC;
  public a yED;
  public a yEE;
  public List<String> yEF;
  public List<String> yEG;
  public List<String> yEH;
  public List<String> yEI;
  public List<String> yEJ;
  public String yEK;
  public String yEL;
  public String yEM;
  public b yEw;
  c yEx;
  public c yEy;
  c yEz;
  
  public static final class a
  {
    private String country;
    private String hZS;
    private String iqx;
    private String kMX;
    private String kMY;
    private String yEO;
    private String yEP;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      AppMethodBeat.i(51651);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      this.yEO = str;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      this.yEP = paramString1;
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      this.kMX = paramString1;
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      this.hZS = paramString1;
      paramString1 = paramString5;
      if (paramString5 == null) {
        paramString1 = "";
      }
      this.iqx = paramString1;
      paramString1 = paramString6;
      if (paramString6 == null) {
        paramString1 = "";
      }
      this.kMY = paramString1;
      paramString1 = paramString7;
      if (paramString7 == null) {
        paramString1 = "";
      }
      this.country = paramString1;
      AppMethodBeat.o(51651);
    }
    
    public final String bkK()
    {
      AppMethodBeat.i(51652);
      if ((bu.aSm(this.yEO)) || (bu.aSm(this.yEP)) || (bu.aSm(this.kMX)) || (bu.aSm(this.hZS)) || (bu.aSm(this.iqx)) || (bu.aSm(this.country)))
      {
        localObject = new StringBuilder();
        if (this.country.length() > 0)
        {
          ((StringBuilder)localObject).append(this.country);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.iqx.length() > 0) {
          ((StringBuilder)localObject).append(this.iqx + " ");
        }
        if (this.hZS.length() > 0) {
          ((StringBuilder)localObject).append(this.hZS);
        }
        if ((this.iqx.length() > 0) || (this.hZS.length() > 0)) {
          ((StringBuilder)localObject).append("\n");
        }
        if (this.kMX.length() > 0)
        {
          ((StringBuilder)localObject).append(this.kMX + " ");
          ((StringBuilder)localObject).append("\n");
        }
        if (this.yEP.length() > 0)
        {
          ((StringBuilder)localObject).append(this.yEP);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.yEO.length() > 0)
        {
          ((StringBuilder)localObject).append(this.yEO);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.kMY.length() > 0) {
          ((StringBuilder)localObject).append(this.kMY);
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
      if (this.yEO.length() > 0)
      {
        ((StringBuilder)localObject).append(this.yEO);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.yEP.length() > 0)
      {
        ((StringBuilder)localObject).append(this.yEP);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.kMX.length() > 0)
      {
        ((StringBuilder)localObject).append(this.kMX);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.hZS.length() > 0) {
        ((StringBuilder)localObject).append(this.hZS + " ");
      }
      if (this.iqx.length() > 0) {
        ((StringBuilder)localObject).append(this.iqx + " ");
      }
      if (this.kMY.length() > 0) {
        ((StringBuilder)localObject).append(this.kMY);
      }
      if ((this.hZS.length() > 0) || (this.iqx.length() > 0)) {
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
    
    public final String bkK()
    {
      AppMethodBeat.i(51654);
      Object localObject = new StringBuilder();
      if ((bu.aSm(this.firstName)) || (bu.aSm(this.middleName)) || (bu.aSm(this.lastName)))
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
    public String hnC;
    public String yEQ;
    
    public c(String paramString1, String paramString2)
    {
      this.hnC = paramString1;
      this.yEQ = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ai
 * JD-Core Version:    0.7.0.1
 */