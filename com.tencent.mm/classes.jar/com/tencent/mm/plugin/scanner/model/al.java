package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class al
{
  public static al CHN;
  public String CHA;
  public a CHB;
  public a CHC;
  public a CHD;
  public a CHE;
  public List<String> CHF;
  public List<String> CHG;
  public List<String> CHH;
  public List<String> CHI;
  public List<String> CHJ;
  public String CHK;
  public String CHL;
  public String CHM;
  public b CHw;
  c CHx;
  public c CHy;
  c CHz;
  public String fuD;
  public String lRD;
  public String lRL;
  public String nickName;
  public String title;
  public String url;
  
  public static final class a
  {
    private String CHO;
    private String CHP;
    private String country;
    private String iUQ;
    private String jlI;
    private String lRP;
    private String lRQ;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      AppMethodBeat.i(51651);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      this.CHO = str;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      this.CHP = paramString1;
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      this.lRP = paramString1;
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      this.iUQ = paramString1;
      paramString1 = paramString5;
      if (paramString5 == null) {
        paramString1 = "";
      }
      this.jlI = paramString1;
      paramString1 = paramString6;
      if (paramString6 == null) {
        paramString1 = "";
      }
      this.lRQ = paramString1;
      paramString1 = paramString7;
      if (paramString7 == null) {
        paramString1 = "";
      }
      this.country = paramString1;
      AppMethodBeat.o(51651);
    }
    
    public final String bGg()
    {
      AppMethodBeat.i(51652);
      if ((Util.isChinese(this.CHO)) || (Util.isChinese(this.CHP)) || (Util.isChinese(this.lRP)) || (Util.isChinese(this.iUQ)) || (Util.isChinese(this.jlI)) || (Util.isChinese(this.country)))
      {
        localObject = new StringBuilder();
        if (this.country.length() > 0)
        {
          ((StringBuilder)localObject).append(this.country);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.jlI.length() > 0) {
          ((StringBuilder)localObject).append(this.jlI + " ");
        }
        if (this.iUQ.length() > 0) {
          ((StringBuilder)localObject).append(this.iUQ);
        }
        if ((this.jlI.length() > 0) || (this.iUQ.length() > 0)) {
          ((StringBuilder)localObject).append("\n");
        }
        if (this.lRP.length() > 0)
        {
          ((StringBuilder)localObject).append(this.lRP + " ");
          ((StringBuilder)localObject).append("\n");
        }
        if (this.CHP.length() > 0)
        {
          ((StringBuilder)localObject).append(this.CHP);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.CHO.length() > 0)
        {
          ((StringBuilder)localObject).append(this.CHO);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.lRQ.length() > 0) {
          ((StringBuilder)localObject).append(this.lRQ);
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
      if (this.CHO.length() > 0)
      {
        ((StringBuilder)localObject).append(this.CHO);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.CHP.length() > 0)
      {
        ((StringBuilder)localObject).append(this.CHP);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.lRP.length() > 0)
      {
        ((StringBuilder)localObject).append(this.lRP);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.iUQ.length() > 0) {
        ((StringBuilder)localObject).append(this.iUQ + " ");
      }
      if (this.jlI.length() > 0) {
        ((StringBuilder)localObject).append(this.jlI + " ");
      }
      if (this.lRQ.length() > 0) {
        ((StringBuilder)localObject).append(this.lRQ);
      }
      if ((this.iUQ.length() > 0) || (this.jlI.length() > 0)) {
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
    
    public final String bGg()
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
  
  public static final class c
  {
    public String CHQ;
    public String igV;
    
    public c(String paramString1, String paramString2)
    {
      this.igV = paramString1;
      this.CHQ = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.al
 * JD-Core Version:    0.7.0.1
 */