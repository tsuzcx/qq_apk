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
  public byte bReqType = 0;
  public byte bTriggered = 0;
  public int iSeq = 0;
  public long lUIN = 0L;
  public short shVersion = 0;
  public byte[] vCookies = null;
  
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
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ReqHead)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.lUIN, paramObject.lUIN))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.shVersion, paramObject.shVersion))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.iSeq, paramObject.iSeq))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.bReqType, paramObject.bReqType))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.bTriggered, paramObject.bTriggered))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.vCookies, paramObject.vCookies)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
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
    byte[] arrayOfByte = this.vCookies;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.ReqHead
 * JD-Core Version:    0.7.0.1
 */