package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHeader
  extends JceStruct
{
  static int cache_eBusiType;
  static int cache_eMqqSysType;
  public byte bNeedAck;
  public int eBusiType = BusinessType.BusinessType_MQQ.value();
  public int eMqqSysType = MqqSysType.MqqSysType_default.value();
  public long iAppID;
  public long lMID;
  public short shVersion;
  
  public ReqHeader() {}
  
  public ReqHeader(short paramShort, long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte paramByte)
  {
    this.shVersion = paramShort;
    this.lMID = paramLong1;
    this.iAppID = paramLong2;
    this.eBusiType = paramInt1;
    this.eMqqSysType = paramInt2;
    this.bNeedAck = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.lMID = paramJceInputStream.read(this.lMID, 1, true);
    this.iAppID = paramJceInputStream.read(this.iAppID, 2, true);
    this.eBusiType = paramJceInputStream.read(this.eBusiType, 3, false);
    this.eMqqSysType = paramJceInputStream.read(this.eMqqSysType, 4, false);
    this.bNeedAck = paramJceInputStream.read(this.bNeedAck, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.lMID, 1);
    paramJceOutputStream.write(this.iAppID, 2);
    paramJceOutputStream.write(this.eBusiType, 3);
    paramJceOutputStream.write(this.eMqqSysType, 4);
    paramJceOutputStream.write(this.bNeedAck, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     AccostSvc.ReqHeader
 * JD-Core Version:    0.7.0.1
 */