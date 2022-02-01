package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

public final class ah
{
  public static ah yoO;
  public String bVF;
  public String ePn;
  public String kJE;
  public String kJw;
  public String title;
  public String url;
  c yoA;
  public String yoB;
  public a yoC;
  public a yoD;
  public a yoE;
  public a yoF;
  public List<String> yoG;
  public List<String> yoH;
  public List<String> yoI;
  public List<String> yoJ;
  public List<String> yoK;
  public String yoL;
  public String yoM;
  public String yoN;
  public b yox;
  c yoy;
  public c yoz;
  
  public static final class a
  {
    private String country;
    private String hXa;
    private String inD;
    private String kJI;
    private String kJJ;
    private String yoP;
    private String yoQ;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
    {
      AppMethodBeat.i(51651);
      String str = paramString1;
      if (paramString1 == null) {
        str = "";
      }
      this.yoP = str;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      this.yoQ = paramString1;
      paramString1 = paramString3;
      if (paramString3 == null) {
        paramString1 = "";
      }
      this.kJI = paramString1;
      paramString1 = paramString4;
      if (paramString4 == null) {
        paramString1 = "";
      }
      this.hXa = paramString1;
      paramString1 = paramString5;
      if (paramString5 == null) {
        paramString1 = "";
      }
      this.inD = paramString1;
      paramString1 = paramString6;
      if (paramString6 == null) {
        paramString1 = "";
      }
      this.kJJ = paramString1;
      paramString1 = paramString7;
      if (paramString7 == null) {
        paramString1 = "";
      }
      this.country = paramString1;
      AppMethodBeat.o(51651);
    }
    
    public final String bkb()
    {
      AppMethodBeat.i(51652);
      if ((bt.aQP(this.yoP)) || (bt.aQP(this.yoQ)) || (bt.aQP(this.kJI)) || (bt.aQP(this.hXa)) || (bt.aQP(this.inD)) || (bt.aQP(this.country)))
      {
        localObject = new StringBuilder();
        if (this.country.length() > 0)
        {
          ((StringBuilder)localObject).append(this.country);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.inD.length() > 0) {
          ((StringBuilder)localObject).append(this.inD + " ");
        }
        if (this.hXa.length() > 0) {
          ((StringBuilder)localObject).append(this.hXa);
        }
        if ((this.inD.length() > 0) || (this.hXa.length() > 0)) {
          ((StringBuilder)localObject).append("\n");
        }
        if (this.kJI.length() > 0)
        {
          ((StringBuilder)localObject).append(this.kJI + " ");
          ((StringBuilder)localObject).append("\n");
        }
        if (this.yoQ.length() > 0)
        {
          ((StringBuilder)localObject).append(this.yoQ);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.yoP.length() > 0)
        {
          ((StringBuilder)localObject).append(this.yoP);
          ((StringBuilder)localObject).append("\n");
        }
        if (this.kJJ.length() > 0) {
          ((StringBuilder)localObject).append(this.kJJ);
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
      if (this.yoP.length() > 0)
      {
        ((StringBuilder)localObject).append(this.yoP);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.yoQ.length() > 0)
      {
        ((StringBuilder)localObject).append(this.yoQ);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.kJI.length() > 0)
      {
        ((StringBuilder)localObject).append(this.kJI);
        ((StringBuilder)localObject).append("\n");
      }
      if (this.hXa.length() > 0) {
        ((StringBuilder)localObject).append(this.hXa + " ");
      }
      if (this.inD.length() > 0) {
        ((StringBuilder)localObject).append(this.inD + " ");
      }
      if (this.kJJ.length() > 0) {
        ((StringBuilder)localObject).append(this.kJJ);
      }
      if ((this.hXa.length() > 0) || (this.inD.length() > 0)) {
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
    
    public final String bkb()
    {
      AppMethodBeat.i(51654);
      Object localObject = new StringBuilder();
      if ((bt.aQP(this.firstName)) || (bt.aQP(this.middleName)) || (bt.aQP(this.lastName)))
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
    public String hkO;
    public String yoR;
    
    public c(String paramString1, String paramString2)
    {
      this.hkO = paramString1;
      this.yoR = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ah
 * JD-Core Version:    0.7.0.1
 */