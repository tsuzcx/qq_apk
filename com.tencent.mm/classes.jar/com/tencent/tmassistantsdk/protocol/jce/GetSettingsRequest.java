package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class GetSettingsRequest
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "GetSettingsRequest";
  public String reserve = "";
  
  static
  {
    AppMethodBeat.i(102299);
    if (!GetSettingsRequest.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102299);
      return;
    }
  }
  
  public GetSettingsRequest() {}
  
  public GetSettingsRequest(String paramString)
  {
    this.reserve = paramString;
  }
  
  public final String className()
  {
    return "jce.GetSettingsRequest";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(102294);
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
      AppMethodBeat.o(102294);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(102294);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102297);
    new JceDisplayer(paramStringBuilder, paramInt).display(this.reserve, "reserve");
    AppMethodBeat.o(102297);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102298);
    new JceDisplayer(paramStringBuilder, paramInt).displaySimple(this.reserve, false);
    AppMethodBeat.o(102298);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(102292);
    if (paramObject == null)
    {
      AppMethodBeat.o(102292);
      return false;
    }
    paramObject = (GetSettingsRequest)paramObject;
    boolean bool = JceUtil.equals(this.reserve, paramObject.reserve);
    AppMethodBeat.o(102292);
    return bool;
  }
  
  public final String fullClassName()
  {
    return "GetSettingsRequest";
  }
  
  public final String getReserve()
  {
    return this.reserve;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(102293);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(102293);
      throw localException1;
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace("GetSettingsRequest", localException2, "", new Object[0]);
      AppMethodBeat.o(102293);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102296);
    this.reserve = paramJceInputStream.readString(0, false);
    AppMethodBeat.o(102296);
  }
  
  public final void setReserve(String paramString)
  {
    this.reserve = paramString;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102295);
    if (this.reserve != null) {
      paramJceOutputStream.write(this.reserve, 0);
    }
    AppMethodBeat.o(102295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest
 * JD-Core Version:    0.7.0.1
 */