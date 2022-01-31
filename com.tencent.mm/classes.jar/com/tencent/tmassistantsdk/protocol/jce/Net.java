package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mm.sdk.platformtools.y;

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
    if (!Net.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
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
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.netType, "netType");
    paramStringBuilder.display(this.extNetworkOperator, "extNetworkOperator");
    paramStringBuilder.display(this.extNetworkType, "extNetworkType");
    paramStringBuilder.display(this.isWap, "isWap");
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.netType, true);
    paramStringBuilder.displaySimple(this.extNetworkOperator, true);
    paramStringBuilder.displaySimple(this.extNetworkType, true);
    paramStringBuilder.displaySimple(this.isWap, false);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (Net)paramObject;
    } while ((!JceUtil.equals(this.netType, paramObject.netType)) || (!JceUtil.equals(this.extNetworkOperator, paramObject.extNetworkOperator)) || (!JceUtil.equals(this.extNetworkType, paramObject.extNetworkType)) || (!JceUtil.equals(this.isWap, paramObject.isWap)));
    return true;
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
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("Net", localException, "", new Object[0]);
    }
    return 0;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.netType = paramJceInputStream.read(this.netType, 0, true);
    this.extNetworkOperator = paramJceInputStream.readString(1, false);
    this.extNetworkType = paramJceInputStream.read(this.extNetworkType, 2, false);
    this.isWap = paramJceInputStream.read(this.isWap, 3, false);
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
    paramJceOutputStream.write(this.netType, 0);
    if (this.extNetworkOperator != null) {
      paramJceOutputStream.write(this.extNetworkOperator, 1);
    }
    paramJceOutputStream.write(this.extNetworkType, 2);
    paramJceOutputStream.write(this.isWap, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmassistantsdk.protocol.jce.Net
 * JD-Core Version:    0.7.0.1
 */