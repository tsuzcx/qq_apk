package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class stConfMsgRecord
  extends JceStruct
  implements Cloneable
{
  static byte[] cache_vAppShareCookie;
  static byte[] cache_vMsg;
  static byte[] cache_vRemarkOfSender;
  public byte cConfType = 0;
  public long lConfUin = 0L;
  public long lFromUin = 0L;
  public long lGroupUin = 0L;
  public long lSendUin = 0L;
  public long lToUin = 0L;
  public long uAppShareID = 0L;
  public long uInfoSeq = 0L;
  public int uMsgLen = 0;
  public long uMsgSeq = 0L;
  public long uMsgTime = 0L;
  public byte[] vAppShareCookie = null;
  public byte[] vMsg = null;
  public byte[] vRemarkOfSender = null;
  public int wSeqNum = 0;
  public int wType = 0;
  
  public stConfMsgRecord() {}
  
  public stConfMsgRecord(int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, byte paramByte, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, int paramInt3, byte[] paramArrayOfByte1, long paramLong9, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.wType = paramInt1;
    this.wSeqNum = paramInt2;
    this.lFromUin = paramLong1;
    this.lToUin = paramLong2;
    this.lGroupUin = paramLong3;
    this.cConfType = paramByte;
    this.lConfUin = paramLong4;
    this.lSendUin = paramLong5;
    this.uMsgSeq = paramLong6;
    this.uMsgTime = paramLong7;
    this.uInfoSeq = paramLong8;
    this.uMsgLen = paramInt3;
    this.vMsg = paramArrayOfByte1;
    this.uAppShareID = paramLong9;
    this.vAppShareCookie = paramArrayOfByte2;
    this.vRemarkOfSender = paramArrayOfByte3;
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
    paramStringBuilder.display(this.wType, "wType");
    paramStringBuilder.display(this.wSeqNum, "wSeqNum");
    paramStringBuilder.display(this.lFromUin, "lFromUin");
    paramStringBuilder.display(this.lToUin, "lToUin");
    paramStringBuilder.display(this.lGroupUin, "lGroupUin");
    paramStringBuilder.display(this.cConfType, "cConfType");
    paramStringBuilder.display(this.lConfUin, "lConfUin");
    paramStringBuilder.display(this.lSendUin, "lSendUin");
    paramStringBuilder.display(this.uMsgSeq, "uMsgSeq");
    paramStringBuilder.display(this.uMsgTime, "uMsgTime");
    paramStringBuilder.display(this.uInfoSeq, "uInfoSeq");
    paramStringBuilder.display(this.uMsgLen, "uMsgLen");
    paramStringBuilder.display(this.vMsg, "vMsg");
    paramStringBuilder.display(this.uAppShareID, "uAppShareID");
    paramStringBuilder.display(this.vAppShareCookie, "vAppShareCookie");
    paramStringBuilder.display(this.vRemarkOfSender, "vRemarkOfSender");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (stConfMsgRecord)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.wType, paramObject.wType))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.wSeqNum, paramObject.wSeqNum))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.lFromUin, paramObject.lFromUin))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.lToUin, paramObject.lToUin))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.lGroupUin, paramObject.lGroupUin))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.cConfType, paramObject.cConfType))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.lConfUin, paramObject.lConfUin))
                {
                  bool1 = bool2;
                  if (JceUtil.equals(this.lSendUin, paramObject.lSendUin))
                  {
                    bool1 = bool2;
                    if (JceUtil.equals(this.uMsgSeq, paramObject.uMsgSeq))
                    {
                      bool1 = bool2;
                      if (JceUtil.equals(this.uMsgTime, paramObject.uMsgTime))
                      {
                        bool1 = bool2;
                        if (JceUtil.equals(this.uInfoSeq, paramObject.uInfoSeq))
                        {
                          bool1 = bool2;
                          if (JceUtil.equals(this.uMsgLen, paramObject.uMsgLen))
                          {
                            bool1 = bool2;
                            if (JceUtil.equals(this.vMsg, paramObject.vMsg))
                            {
                              bool1 = bool2;
                              if (JceUtil.equals(this.uAppShareID, paramObject.uAppShareID))
                              {
                                bool1 = bool2;
                                if (JceUtil.equals(this.vAppShareCookie, paramObject.vAppShareCookie))
                                {
                                  bool1 = bool2;
                                  if (JceUtil.equals(this.vRemarkOfSender, paramObject.vRemarkOfSender)) {
                                    bool1 = true;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
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
  
  public byte getCConfType()
  {
    return this.cConfType;
  }
  
  public long getLConfUin()
  {
    return this.lConfUin;
  }
  
  public long getLFromUin()
  {
    return this.lFromUin;
  }
  
  public long getLGroupUin()
  {
    return this.lGroupUin;
  }
  
  public long getLSendUin()
  {
    return this.lSendUin;
  }
  
  public long getLToUin()
  {
    return this.lToUin;
  }
  
  public long getUAppShareID()
  {
    return this.uAppShareID;
  }
  
  public long getUInfoSeq()
  {
    return this.uInfoSeq;
  }
  
  public int getUMsgLen()
  {
    return this.uMsgLen;
  }
  
  public long getUMsgSeq()
  {
    return this.uMsgSeq;
  }
  
  public long getUMsgTime()
  {
    return this.uMsgTime;
  }
  
  public byte[] getVAppShareCookie()
  {
    return this.vAppShareCookie;
  }
  
  public byte[] getVMsg()
  {
    return this.vMsg;
  }
  
  public byte[] getVRemarkOfSender()
  {
    return this.vRemarkOfSender;
  }
  
  public int getWSeqNum()
  {
    return this.wSeqNum;
  }
  
  public int getWType()
  {
    return this.wType;
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
    this.wType = paramJceInputStream.read(this.wType, 0, true);
    this.wSeqNum = paramJceInputStream.read(this.wSeqNum, 1, true);
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 2, true);
    this.lToUin = paramJceInputStream.read(this.lToUin, 3, true);
    this.lGroupUin = paramJceInputStream.read(this.lGroupUin, 4, true);
    this.cConfType = paramJceInputStream.read(this.cConfType, 5, true);
    this.lConfUin = paramJceInputStream.read(this.lConfUin, 6, true);
    this.lSendUin = paramJceInputStream.read(this.lSendUin, 7, true);
    this.uMsgSeq = paramJceInputStream.read(this.uMsgSeq, 8, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 9, true);
    this.uInfoSeq = paramJceInputStream.read(this.uInfoSeq, 10, true);
    this.uMsgLen = paramJceInputStream.read(this.uMsgLen, 11, true);
    if (cache_vMsg == null)
    {
      cache_vMsg = (byte[])new byte[1];
      ((byte[])cache_vMsg)[0] = 0;
    }
    this.vMsg = ((byte[])paramJceInputStream.read(cache_vMsg, 12, true));
    this.uAppShareID = paramJceInputStream.read(this.uAppShareID, 13, false);
    if (cache_vAppShareCookie == null)
    {
      cache_vAppShareCookie = (byte[])new byte[1];
      ((byte[])cache_vAppShareCookie)[0] = 0;
    }
    this.vAppShareCookie = ((byte[])paramJceInputStream.read(cache_vAppShareCookie, 14, false));
    if (cache_vRemarkOfSender == null)
    {
      cache_vRemarkOfSender = (byte[])new byte[1];
      ((byte[])cache_vRemarkOfSender)[0] = 0;
    }
    this.vRemarkOfSender = ((byte[])paramJceInputStream.read(cache_vRemarkOfSender, 15, false));
  }
  
  public void setCConfType(byte paramByte)
  {
    this.cConfType = paramByte;
  }
  
  public void setLConfUin(long paramLong)
  {
    this.lConfUin = paramLong;
  }
  
  public void setLFromUin(long paramLong)
  {
    this.lFromUin = paramLong;
  }
  
  public void setLGroupUin(long paramLong)
  {
    this.lGroupUin = paramLong;
  }
  
  public void setLSendUin(long paramLong)
  {
    this.lSendUin = paramLong;
  }
  
  public void setLToUin(long paramLong)
  {
    this.lToUin = paramLong;
  }
  
  public void setUAppShareID(long paramLong)
  {
    this.uAppShareID = paramLong;
  }
  
  public void setUInfoSeq(long paramLong)
  {
    this.uInfoSeq = paramLong;
  }
  
  public void setUMsgLen(int paramInt)
  {
    this.uMsgLen = paramInt;
  }
  
  public void setUMsgSeq(long paramLong)
  {
    this.uMsgSeq = paramLong;
  }
  
  public void setUMsgTime(long paramLong)
  {
    this.uMsgTime = paramLong;
  }
  
  public void setVAppShareCookie(byte[] paramArrayOfByte)
  {
    this.vAppShareCookie = paramArrayOfByte;
  }
  
  public void setVMsg(byte[] paramArrayOfByte)
  {
    this.vMsg = paramArrayOfByte;
  }
  
  public void setVRemarkOfSender(byte[] paramArrayOfByte)
  {
    this.vRemarkOfSender = paramArrayOfByte;
  }
  
  public void setWSeqNum(int paramInt)
  {
    this.wSeqNum = paramInt;
  }
  
  public void setWType(int paramInt)
  {
    this.wType = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wType, 0);
    paramJceOutputStream.write(this.wSeqNum, 1);
    paramJceOutputStream.write(this.lFromUin, 2);
    paramJceOutputStream.write(this.lToUin, 3);
    paramJceOutputStream.write(this.lGroupUin, 4);
    paramJceOutputStream.write(this.cConfType, 5);
    paramJceOutputStream.write(this.lConfUin, 6);
    paramJceOutputStream.write(this.lSendUin, 7);
    paramJceOutputStream.write(this.uMsgSeq, 8);
    paramJceOutputStream.write(this.uMsgTime, 9);
    paramJceOutputStream.write(this.uInfoSeq, 10);
    paramJceOutputStream.write(this.uMsgLen, 11);
    paramJceOutputStream.write(this.vMsg, 12);
    paramJceOutputStream.write(this.uAppShareID, 13);
    byte[] arrayOfByte = this.vAppShareCookie;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 14);
    }
    arrayOfByte = this.vRemarkOfSender;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.stConfMsgRecord
 * JD-Core Version:    0.7.0.1
 */