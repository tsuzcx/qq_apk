package com.tencent.thumbplayer.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private String ZCZ;
  private String model;
  private String prefix;
  public String tag;
  public String taskId;
  
  public b(b paramb, String paramString)
  {
    AppMethodBeat.i(220758);
    this.prefix = "";
    this.ZCZ = "";
    this.taskId = "";
    this.model = "";
    this.tag = "TPLogger";
    a(paramb, paramString);
    AppMethodBeat.o(220758);
  }
  
  public b(String paramString)
  {
    this(paramString, "", "", "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(220752);
    this.prefix = "";
    this.ZCZ = "";
    this.taskId = "";
    this.model = "";
    this.tag = "TPLogger";
    this.prefix = paramString1;
    this.ZCZ = paramString2;
    this.taskId = paramString3;
    this.model = paramString4;
    irf();
    AppMethodBeat.o(220752);
  }
  
  public final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(220762);
    if (paramb != null)
    {
      this.prefix = paramb.prefix;
      this.ZCZ = paramb.ZCZ;
    }
    for (this.taskId = paramb.taskId;; this.taskId = "")
    {
      this.model = paramString;
      irf();
      AppMethodBeat.o(220762);
      return;
      this.prefix = "";
      this.ZCZ = "";
    }
  }
  
  public final void irf()
  {
    AppMethodBeat.i(220766);
    this.tag = this.prefix;
    if (!TextUtils.isEmpty(this.ZCZ)) {
      this.tag = (this.tag + "_C" + this.ZCZ);
    }
    if (!TextUtils.isEmpty(this.taskId)) {
      this.tag = (this.tag + "_T" + this.taskId);
    }
    if (!TextUtils.isEmpty(this.model)) {
      this.tag = (this.tag + "_" + this.model);
    }
    AppMethodBeat.o(220766);
  }
  
  public String toString()
  {
    AppMethodBeat.i(220771);
    String str = "TPLoggerContext{prefix='" + this.prefix + '\'' + ", classId='" + this.ZCZ + '\'' + ", taskId='" + this.taskId + '\'' + ", model='" + this.model + '\'' + ", tag='" + this.tag + '\'' + '}';
    AppMethodBeat.o(220771);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.f.b
 * JD-Core Version:    0.7.0.1
 */