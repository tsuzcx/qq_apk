package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqHead
  extends JceStruct
  implements Cloneable
{
  static byte[] cache_vCookies;
  public byte bReqType;
  public byte bTriggered;
  public int iSeq;
  public long lUIN;
  public short shVersion;
  public byte[] vCookies;
  
  static
  {
    if (!ReqHead.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ReqHead() {}
  
  public ReqHead(long paramLong, short paramShort, int paramInt, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte)
  {
    this.lUIN = paramLong;
    this.shVersion = paramShort;
    this.iSeq = paramInt;
    this.bReqType = paramByte1;
    this.bTriggered = paramByte2;
    this.vCookies = paramArrayOfByte;
  }
  
  public Object clone()
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
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.lUIN, "lUIN");
    paramStringBuilder.display(this.shVersion, "shVersion");
    paramStringBuilder.display(this.iSeq, "iSeq");
    paramStringBuilder.display(this.bReqType, "bReqType");
    paramStringBuilder.display(this.bTriggered, "bTriggered");
    paramStringBuilder.display(this.vCookies, "vCookies");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (ReqHead)paramObject;
    } while ((!JceUtil.equals(this.lUIN, paramObject.lUIN)) || (!JceUtil.equals(this.shVersion, paramObject.shVersion)) || (!JceUtil.equals(this.iSeq, paramObject.iSeq)) || (!JceUtil.equals(this.bReqType, paramObject.bReqType)) || (!JceUtil.equals(this.bTriggered, paramObject.bTriggered)) || (!JceUtil.equals(this.vCookies, paramObject.vCookies)));
    return true;
  }
  
  public byte getBReqType()
  {
    return this.bReqType;
  }
  
  public byte getBTriggered()
  {
    return this.bTriggered;
  }
  
  public int getISeq()
  {
    return this.iSeq;
  }
  
  public long getLUIN()
  {
    return this.lUIN;
  }
  
  public short getShVersion()
  {
    return this.shVersion;
  }
  
  public byte[] getVCookies()
  {
    return this.vCookies;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.shVersion = paramJceInputStream.read(this.shVersion, 1, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 2, true);
    this.bReqType = paramJceInputStream.read(this.bReqType, 3, false);
    this.bTriggered = paramJceInputStream.read(this.bTriggered, 4, false);
    if (cache_vCookies == null)
    {
      cache_vCookies = (byte[])new byte[1];
      ((byte[])cache_vCookies)[0] = 0;
    }
    this.vCookies = ((byte[])paramJceInputStream.read(cache_vCookies, 5, false));
  }
  
  public void setBReqType(byte paramByte)
  {
    this.bReqType = paramByte;
  }
  
  public void setBTriggered(byte paramByte)
  {
    this.bTriggered = paramByte;
  }
  
  public void setISeq(int paramInt)
  {
    this.iSeq = paramInt;
  }
  
  public void setLUIN(long paramLong)
  {
    this.lUIN = paramLong;
  }
  
  public void setShVersion(short paramShort)
  {
    this.shVersion = paramShort;
  }
  
  public void setVCookies(byte[] paramArrayOfByte)
  {
    this.vCookies = paramArrayOfByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.shVersion, 1);
    paramJceOutputStream.write(this.iSeq, 2);
    paramJceOutputStream.write(this.bReqType, 3);
    paramJceOutputStream.write(this.bTriggered, 4);
    if (this.vCookies != null) {
      paramJceOutputStream.write(this.vCookies, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.ReqHead
 * JD-Core Version:    0.7.0.1
 */