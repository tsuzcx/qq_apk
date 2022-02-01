package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class ac
{
  public static ac vQi;
  public String bNK;
  public String evs;
  public String jNV;
  public String jOd;
  public String title;
  public String url;
  public b vPR;
  c vPS;
  public c vPT;
  c vPU;
  public String vPV;
  public a vPW;
  public a vPX;
  public a vPY;
  public a vPZ;
  public List<String> vQa;
  public List<String> vQb;
  public List<String> vQc;
  public List<String> vQd;
  public List<String> vQe;
  public String vQf;
  public String vQg;
  public String vQh;
  
  public static final class a
  {
    private String country;
    private String hdS;
    private String htG;
    private String jOh;
    private String jOi;
    private String vQj;
    private String vQk;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      AppMethodBeat.i(51651);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      this.vQj = str;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      this.vQk = paramString1;
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      this.jOh = paramString1;
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      this.hdS = paramString1;
      paramString1 = paramString5;
      if (paramString5 == null) {
        paramString1 = "";
      }
      this.htG = paramString1;
      paramString1 = paramString6;
      if (paramString6 == null) {
        paramString1 = "";
      }
      this.jOi = paramString1;
      paramString1 = paramString7;
      if (paramString7 == null) {
        paramString1 = "";
      }
      this.country = paramString1;
      AppMethodBeat.o(51651);
    }
    
    public final String aZF()
    {
      AppMethodBeat.i(51652);
      if ((bt.aFS(this.vQj)) || (bt.aFS(this.vQk)) || (bt.aFS(this.jOh)) || (bt.aFS(this.hdS)) || (bt.aFS(this.htG)) || (bt.aFS(this.country)))
      {
        localObject = new StringBuilder();
        if (this.country.length() > 0)
        {
          ((StringBuilder)localObject).append(this.country);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.htG.length() > 0) {
          ((StringBuilder)localObject).append(this.htG + " ");
        }
        if (this.hdS.length() > 0) {
          ((StringBuilder)localObject).append(this.hdS);
        }
        if ((this.htG.length() > 0) || (this.hdS.length() > 0)) {
          ((StringBuilder)localObject).append("\n");
        }
        if (this.jOh.length() > 0)
        {
          ((StringBuilder)localObject).append(this.jOh + " ");
          ((StringBuilder)localObject).append("\n");
        }
        if (this.vQk.length() > 0)
        {
          ((StringBuilder)localObject).append(this.vQk);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.vQj.length() > 0)
        {
          ((StringBuilder)localObject).append(this.vQj);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.jOi.length() > 0) {
          ((StringBuilder)localObject).append(this.jOi);
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
      if (this.vQj.length() > 0)
      {
        ((StringBuilder)localObject).append(this.vQj);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.vQk.length() > 0)
      {
        ((StringBuilder)localObject).append(this.vQk);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.jOh.length() > 0)
      {
        ((StringBuilder)localObject).append(this.jOh);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.hdS.length() > 0) {
        ((StringBuilder)localObject).append(this.hdS + " ");
      }
      if (this.htG.length() > 0) {
        ((StringBuilder)localObject).append(this.htG + " ");
      }
      if (this.jOi.length() > 0) {
        ((StringBuilder)localObject).append(this.jOi);
      }
      if ((this.hdS.length() > 0) || (this.htG.length() > 0)) {
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
    
    public final String aZF()
    {
      AppMethodBeat.i(51654);
      Object localObject = new StringBuilder();
      if ((bt.aFS(this.firstName)) || (bt.aFS(this.middleName)) || (bt.aFS(this.lastName)))
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
    public String gsf;
    public String vQl;
    
    public c(String paramString1, String paramString2)
    {
      this.gsf = paramString1;
      this.vQl = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ac
 * JD-Core Version:    0.7.0.1
 */