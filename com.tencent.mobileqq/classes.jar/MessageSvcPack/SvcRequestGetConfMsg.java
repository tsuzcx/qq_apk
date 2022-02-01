package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class SvcRequestGetConfMsg
  extends JceStruct
  implements Cloneable
{
  public byte cGetPttUrl = 0;
  public byte cGetSmartRemark = 0;
  public byte cVerifyType = 0;
  public long dwLastGetTime = 0L;
  public long dwLastInfoSeq = 0L;
  public long lBeginSeq = 0L;
  public long lConfUin = 0L;
  public long lEndSeq = 0L;
  
  public SvcRequestGetConfMsg() {}
  
  public SvcRequestGetConfMsg(long paramLong1, long paramLong2, long paramLong3, byte paramByte1, byte paramByte2, byte paramByte3, long paramLong4, long paramLong5)
  {
    this.lConfUin = paramLong1;
    this.lBeginSeq = paramLong2;
    this.lEndSeq = paramLong3;
    this.cVerifyType = paramByte1;
    this.cGetPttUrl = paramByte2;
    this.cGetSmartRemark = paramByte3;
    this.dwLastGetTime = paramLong4;
    this.dwLastInfoSeq = paramLong5;
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
    paramStringBuilder.display(this.lConfUin, "lConfUin");
    paramStringBuilder.display(this.lBeginSeq, "lBeginSeq");
    paramStringBuilder.display(this.lEndSeq, "lEndSeq");
    paramStringBuilder.display(this.cVerifyType, "cVerifyType");
    paramStringBuilder.display(this.cGetPttUrl, "cGetPttUrl");
    paramStringBuilder.display(this.cGetSmartRemark, "cGetSmartRemark");
    paramStringBuilder.display(this.dwLastGetTime, "dwLastGetTime");
    paramStringBuilder.display(this.dwLastInfoSeq, "dwLastInfoSeq");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (SvcRequestGetConfMsg)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.lConfUin, paramObject.lConfUin))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.lBeginSeq, paramObject.lBeginSeq))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.lEndSeq, paramObject.lEndSeq))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.cVerifyType, paramObject.cVerifyType))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.cGetPttUrl, paramObject.cGetPttUrl))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.cGetSmartRemark, paramObject.cGetSmartRemark))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.dwLastGetTime, paramObject.dwLastGetTime))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.dwLastInfoSeq, paramObject.dwLastInfoSeq)) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public byte getCGetPttUrl()
  {
    return this.cGetPttUrl;
  }
  
  public byte getCGetSmartRemark()
  {
    return this.cGetSmartRemark;
  }
  
  public byte getCVerifyType()
  {
    return this.cVerifyType;
  }
  
  public long getDwLastGetTime()
  {
    return this.dwLastGetTime;
  }
  
  public long getDwLastInfoSeq()
  {
    return this.dwLastInfoSeq;
  }
  
  public long getLBeginSeq()
  {
    return this.lBeginSeq;
  }
  
  public long getLConfUin()
  {
    return this.lConfUin;
  }
  
  public long getLEndSeq()
  {
    return this.lEndSeq;
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
    this.lConfUin = paramJceInputStream.read(this.lConfUin, 0, true);
    this.lBeginSeq = paramJceInputStream.read(this.lBeginSeq, 1, true);
    this.lEndSeq = paramJceInputStream.read(this.lEndSeq, 2, true);
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 3, false);
    this.cGetPttUrl = paramJceInputStream.read(this.cGetPttUrl, 4, false);
    this.cGetSmartRemark = paramJceInputStream.read(this.cGetSmartRemark, 5, false);
    this.dwLastGetTime = paramJceInputStream.read(this.dwLastGetTime, 6, false);
    this.dwLastInfoSeq = paramJceInputStream.read(this.dwLastInfoSeq, 7, false);
  }
  
  public void setCGetPttUrl(byte paramByte)
  {
    this.cGetPttUrl = paramByte;
  }
  
  public void setCGetSmartRemark(byte paramByte)
  {
    this.cGetSmartRemark = paramByte;
  }
  
  public void setCVerifyType(byte paramByte)
  {
    this.cVerifyType = paramByte;
  }
  
  public void setDwLastGetTime(long paramLong)
  {
    this.dwLastGetTime = paramLong;
  }
  
  public void setDwLastInfoSeq(long paramLong)
  {
    this.dwLastInfoSeq = paramLong;
  }
  
  public void setLBeginSeq(long paramLong)
  {
    this.lBeginSeq = paramLong;
  }
  
  public void setLConfUin(long paramLong)
  {
    this.lConfUin = paramLong;
  }
  
  public void setLEndSeq(long paramLong)
  {
    this.lEndSeq = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lConfUin, 0);
    paramJceOutputStream.write(this.lBeginSeq, 1);
    paramJceOutputStream.write(this.lEndSeq, 2);
    paramJceOutputStream.write(this.cVerifyType, 3);
    paramJceOutputStream.write(this.cGetPttUrl, 4);
    paramJceOutputStream.write(this.cGetSmartRemark, 5);
    paramJceOutputStream.write(this.dwLastGetTime, 6);
    paramJceOutputStream.write(this.dwLastInfoSeq, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGetConfMsg
 * JD-Core Version:    0.7.0.1
 */