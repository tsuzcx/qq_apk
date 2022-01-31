package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetAreaList
  extends JceStruct
{
  static byte[] cache_vClientVersion = (byte[])new byte[1];
  public int iLat;
  public int iLon;
  public int iRadius;
  public long uiClientType;
  public byte[] vClientVersion;
  
  static
  {
    ((byte[])cache_vClientVersion)[0] = 0;
  }
  
  public ReqGetAreaList() {}
  
  public ReqGetAreaList(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, long paramLong)
  {
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.iRadius = paramInt3;
    this.vClientVersion = paramArrayOfByte;
    this.uiClientType = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iLat = paramJceInputStream.read(this.iLat, 0, true);
    this.iLon = paramJceInputStream.read(this.iLon, 1, true);
    this.iRadius = paramJceInputStream.read(this.iRadius, 2, true);
    this.vClientVersion = ((byte[])paramJceInputStream.read(cache_vClientVersion, 3, false));
    this.uiClientType = paramJceInputStream.read(this.uiClientType, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iLat, 0);
    paramJceOutputStream.write(this.iLon, 1);
    paramJceOutputStream.write(this.iRadius, 2);
    if (this.vClientVersion != null) {
      paramJceOutputStream.write(this.vClientVersion, 3);
    }
    paramJceOutputStream.write(this.uiClientType, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NearbyGroup.ReqGetAreaList
 * JD-Core Version:    0.7.0.1
 */