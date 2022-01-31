package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHeader
  extends JceStruct
{
  static int cache_eBusiType;
  static int cache_eMqqSysType;
  public int eBusiType = 0;
  public int eMqqSysType = MqqSysType.MqqSysType_default.value();
  public long iAppID;
  public long lMID;
  public short shVersion;
  public long uClientIp;
  public long uClientPort;
  
  public ReqHeader() {}
  
  public ReqHeader(short paramShort, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2)
  {
    this.shVersion = paramShort;
    this.lMID = paramLong1;
    this.iAppID = paramLong2;
    this.eBusiType = paramInt1;
    this.uClientIp = paramLong3;
    this.uClientPort = paramLong4;
    this.eMqqSysType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.lMID = paramJceInputStream.read(this.lMID, 1, true);
    this.iAppID = paramJceInputStream.read(this.iAppID, 2, true);
    this.eBusiType = paramJceInputStream.read(this.eBusiType, 3, false);
    this.uClientIp = paramJceInputStream.read(this.uClientIp, 4, false);
    this.uClientPort = paramJceInputStream.read(this.uClientPort, 5, false);
    this.eMqqSysType = paramJceInputStream.read(this.eMqqSysType, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.lMID, 1);
    paramJceOutputStream.write(this.iAppID, 2);
    paramJceOutputStream.write(this.eBusiType, 3);
    paramJceOutputStream.write(this.uClientIp, 4);
    paramJceOutputStream.write(this.uClientPort, 5);
    paramJceOutputStream.write(this.eMqqSysType, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NeighborSvc.ReqHeader
 * JD-Core Version:    0.7.0.1
 */