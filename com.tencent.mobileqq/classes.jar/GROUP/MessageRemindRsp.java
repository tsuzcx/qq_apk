package GROUP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MessageRemindRsp
  extends JceStruct
{
  public int eNowLevel = 0;
  public int eRemindLevel = 0;
  public int iFreezedType = 0;
  public long iGroupExpiredTime = 0L;
  public int iGroupType = 0;
  public int iLhGroupExpiredTime = 0;
  public long iNextReqTime = 0L;
  public long iSVIPExpiredTime = 0L;
  public int iUserRole = 0;
  public boolean isFreezed = true;
  
  public MessageRemindRsp() {}
  
  public MessageRemindRsp(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.iGroupExpiredTime = paramLong1;
    this.iSVIPExpiredTime = paramLong2;
    this.iNextReqTime = paramLong3;
    this.eRemindLevel = paramInt1;
    this.eNowLevel = paramInt2;
    this.isFreezed = paramBoolean;
    this.iUserRole = paramInt3;
    this.iFreezedType = paramInt4;
    this.iLhGroupExpiredTime = paramInt5;
    this.iGroupType = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iGroupExpiredTime = paramJceInputStream.read(this.iGroupExpiredTime, 0, true);
    this.iSVIPExpiredTime = paramJceInputStream.read(this.iSVIPExpiredTime, 1, false);
    this.iNextReqTime = paramJceInputStream.read(this.iNextReqTime, 2, false);
    this.eRemindLevel = paramJceInputStream.read(this.eRemindLevel, 3, false);
    this.eNowLevel = paramJceInputStream.read(this.eNowLevel, 4, false);
    this.isFreezed = paramJceInputStream.read(this.isFreezed, 5, false);
    this.iUserRole = paramJceInputStream.read(this.iUserRole, 6, false);
    this.iFreezedType = paramJceInputStream.read(this.iFreezedType, 7, false);
    this.iLhGroupExpiredTime = paramJceInputStream.read(this.iLhGroupExpiredTime, 8, false);
    this.iGroupType = paramJceInputStream.read(this.iGroupType, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iGroupExpiredTime, 0);
    paramJceOutputStream.write(this.iSVIPExpiredTime, 1);
    paramJceOutputStream.write(this.iNextReqTime, 2);
    paramJceOutputStream.write(this.eRemindLevel, 3);
    paramJceOutputStream.write(this.eNowLevel, 4);
    paramJceOutputStream.write(this.isFreezed, 5);
    paramJceOutputStream.write(this.iUserRole, 6);
    paramJceOutputStream.write(this.iFreezedType, 7);
    paramJceOutputStream.write(this.iLhGroupExpiredTime, 8);
    paramJceOutputStream.write(this.iGroupType, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     GROUP.MessageRemindRsp
 * JD-Core Version:    0.7.0.1
 */