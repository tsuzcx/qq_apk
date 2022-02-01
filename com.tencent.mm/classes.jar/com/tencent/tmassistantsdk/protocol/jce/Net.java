package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class Net
  extends JceStruct
  implements Cloneable
{
  private static final String TAG = "Net";
  public String extNetworkOperator = "";
  public int extNetworkType = 0;
  public byte isWap = 0;
  public byte netType = 0;
  
  static
  {
    AppMethodBeat.i(102319);
    if (!Net.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(102319);
      return;
    }
  }
  
  public Net() {}
  
  public Net(byte paramByte1, String paramString, int paramInt, byte paramByte2)
  {
    this.netType = paramByte1;
    this.extNetworkOperator = paramString;
    this.extNetworkType = paramInt;
    this.isWap = paramByte2;
  }
  
  public final String className()
  {
    return "jce.Net";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(102314);
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
      AppMethodBeat.o(102314);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(102314);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102317);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.netType, "netType");
    paramStringBuilder.display(this.extNetworkOperator, "extNetworkOperator");
    paramStringBuilder.display(this.extNetworkType, "extNetworkType");
    paramStringBuilder.display(this.isWap, "isWap");
    AppMethodBeat.o(102317);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(102318);
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.netType, true);
    paramStringBuilder.displaySimple(this.extNetworkOperator, true);
    paramStringBuilder.displaySimple(this.extNetworkType, true);
    paramStringBuilder.displaySimple(this.isWap, false);
    AppMethodBeat.o(102318);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(102312);
    if (paramObject == null)
    {
      AppMethodBeat.o(102312);
      return false;
    }
    paramObject = (Net)paramObject;
    if ((JceUtil.equals(this.netType, paramObject.netType)) && (JceUtil.equals(this.extNetworkOperator, paramObject.extNetworkOperator)) && (JceUtil.equals(this.extNetworkType, paramObject.extNetworkType)) && (JceUtil.equals(this.isWap, paramObject.isWap)))
    {
      AppMethodBeat.o(102312);
      return true;
    }
    AppMethodBeat.o(102312);
    return false;
  }
  
  public final String fullClassName()
  {
    return "Net";
  }
  
  public final String getExtNetworkOperator()
  {
    return this.extNetworkOperator;
  }
  
  public final int getExtNetworkType()
  {
    return this.extNetworkType;
  }
  
  public final byte getIsWap()
  {
    return this.isWap;
  }
  
  public final byte getNetType()
  {
    return this.netType;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(102313);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(102313);
      throw localException1;
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace("Net", localException2, "", new Object[0]);
      AppMethodBeat.o(102313);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(102316);
    this.netType = paramJceInputStream.read(this.netType, 0, true);
    this.extNetworkOperator = paramJceInputStream.readString(1, false);
    this.extNetworkType = paramJceInputStream.read(this.extNetworkType, 2, false);
    this.isWap = paramJceInputStream.read(this.isWap, 3, false);
    AppMethodBeat.o(102316);
  }
  
  public final void setExtNetworkOperator(String paramString)
  {
    this.extNetworkOperator = paramString;
  }
  
  public final void setExtNetworkType(int paramInt)
  {
    this.extNetworkType = paramInt;
  }
  
  public final void setIsWap(byte paramByte)
  {
    this.isWap = paramByte;
  }
  
  public final void setNetType(byte paramByte)
  {
    this.netType = paramByte;
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(102315);
    paramJceOutputStream.write(this.netType, 0);
    if (this.extNetworkOperator != null) {
      paramJceOutputStream.write(this.extNetworkOperator, 1);
    }
    paramJceOutputStream.write(this.extNetworkType, 2);
    paramJceOutputStream.write(this.isWap, 3);
    AppMethodBeat.o(102315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.Net
 * JD-Core Version:    0.7.0.1
 */