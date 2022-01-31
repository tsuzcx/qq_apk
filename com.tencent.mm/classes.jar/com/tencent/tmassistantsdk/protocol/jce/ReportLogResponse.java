package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class ReportLogResponse
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "ReportLogResponse";
  public int ret = 0;
  
  static
  {
    AppMethodBeat.i(76089);
    if (!ReportLogResponse.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(76089);
      return;
    }
  }
  
  public ReportLogResponse() {}
  
  public ReportLogResponse(int paramInt)
  {
    this.ret = paramInt;
  }
  
  public final String className()
  {
    return "jce.ReportLogResponse";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(76084);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(76084);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(76084);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76087);
    new JceDisplayer(paramStringBuilder, paramInt).display(this.ret, "ret");
    AppMethodBeat.o(76087);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(76088);
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.ret, false);
    AppMethodBeat.o(76088);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76082);
    if (paramObject == null)
    {
      AppMethodBeat.o(76082);
      return false;
    }
    paramObject = (ReportLogResponse)paramObject;
    boolean bool = JceUtil.equals(this.ret, paramObject.ret);
    AppMethodBeat.o(76082);
    return bool;
  }
  
  public final String fullClassName()
  {
    return "ReportLogResponse";
  }
  
  public final int getRet()
  {
    return this.ret;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76083);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(76083);
      throw localException1;
    }
    catch (Exception localException2)
    {
      ab.printErrStackTrace("ReportLogResponse", localException2, "", new Object[0]);
      AppMethodBeat.o(76083);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(76086);
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    AppMethodBeat.o(76086);
  }
  
  public final void setRet(int paramInt)
  {
    this.ret = paramInt;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(76085);
    paramJceOutputStream.write(this.ret, 0);
    AppMethodBeat.o(76085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.ReportLogResponse
 * JD-Core Version:    0.7.0.1
 */