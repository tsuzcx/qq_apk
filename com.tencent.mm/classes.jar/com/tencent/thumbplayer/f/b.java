package com.tencent.thumbplayer.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private String Sap;
  private String model;
  private String prefix;
  public String tag;
  public String taskId;
  
  public b(b paramb, String paramString)
  {
    AppMethodBeat.i(189276);
    this.prefix = "";
    this.Sap = "";
    this.taskId = "";
    this.model = "";
    this.tag = "TPLogger";
    a(paramb, paramString);
    AppMethodBeat.o(189276);
  }
  
  public b(String paramString)
  {
    this(paramString, "", "", "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(189275);
    this.prefix = "";
    this.Sap = "";
    this.taskId = "";
    this.model = "";
    this.tag = "TPLogger";
    this.prefix = paramString1;
    this.Sap = paramString2;
    this.taskId = paramString3;
    this.model = paramString4;
    hnE();
    AppMethodBeat.o(189275);
  }
  
  public final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(189277);
    if (paramb != null)
    {
      this.prefix = paramb.prefix;
      this.Sap = paramb.Sap;
    }
    for (this.taskId = paramb.taskId;; this.taskId = "")
    {
      this.model = paramString;
      hnE();
      AppMethodBeat.o(189277);
      return;
      this.prefix = "";
      this.Sap = "";
    }
  }
  
  public final void hnE()
  {
    AppMethodBeat.i(189278);
    this.tag = this.prefix;
    if (!TextUtils.isEmpty(this.Sap)) {
      this.tag = (this.tag + "_C" + this.Sap);
    }
    if (!TextUtils.isEmpty(this.taskId)) {
      this.tag = (this.tag + "_T" + this.taskId);
    }
    if (!TextUtils.isEmpty(this.model)) {
      this.tag = (this.tag + "_" + this.model);
    }
    AppMethodBeat.o(189278);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189279);
    String str = "TPLoggerContext{prefix='" + this.prefix + '\'' + ", classId='" + this.Sap + '\'' + ", taskId='" + this.taskId + '\'' + ", model='" + this.model + '\'' + ", tag='" + this.tag + '\'' + '}';
    AppMethodBeat.o(189279);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.f.b
 * JD-Core Version:    0.7.0.1
 */