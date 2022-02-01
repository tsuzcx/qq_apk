package com.tencent.thumbplayer.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private String ahIc;
  private String model;
  private String prefix;
  public String tag;
  public String taskId;
  
  public b(b paramb, String paramString)
  {
    AppMethodBeat.i(226935);
    this.prefix = "";
    this.ahIc = "";
    this.taskId = "";
    this.model = "";
    this.tag = "TPLogger";
    a(paramb, paramString);
    AppMethodBeat.o(226935);
  }
  
  public b(String paramString)
  {
    this(paramString, "", "", "");
  }
  
  public b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(226931);
    this.prefix = "";
    this.ahIc = "";
    this.taskId = "";
    this.model = "";
    this.tag = "TPLogger";
    this.prefix = paramString1;
    this.ahIc = paramString2;
    this.taskId = paramString3;
    this.model = paramString4;
    kaB();
    AppMethodBeat.o(226931);
  }
  
  public final void a(b paramb, String paramString)
  {
    AppMethodBeat.i(226939);
    if (paramb != null)
    {
      this.prefix = paramb.prefix;
      this.ahIc = paramb.ahIc;
    }
    for (this.taskId = paramb.taskId;; this.taskId = "")
    {
      this.model = paramString;
      kaB();
      AppMethodBeat.o(226939);
      return;
      this.prefix = "";
      this.ahIc = "";
    }
  }
  
  public final void kaB()
  {
    AppMethodBeat.i(226943);
    this.tag = this.prefix;
    if (!TextUtils.isEmpty(this.ahIc)) {
      this.tag = (this.tag + "_C" + this.ahIc);
    }
    if (!TextUtils.isEmpty(this.taskId)) {
      this.tag = (this.tag + "_T" + this.taskId);
    }
    if (!TextUtils.isEmpty(this.model)) {
      this.tag = (this.tag + "_" + this.model);
    }
    AppMethodBeat.o(226943);
  }
  
  public String toString()
  {
    AppMethodBeat.i(226948);
    String str = "TPLoggerContext{prefix='" + this.prefix + '\'' + ", classId='" + this.ahIc + '\'' + ", taskId='" + this.taskId + '\'' + ", model='" + this.model + '\'' + ", tag='" + this.tag + '\'' + '}';
    AppMethodBeat.o(226948);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.f.b
 * JD-Core Version:    0.7.0.1
 */