package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetGroupInArea
  extends JceStruct
{
  static byte[] cache_vClientVersion = (byte[])new byte[1];
  public long dwGroupStartIdx;
  public int iCount;
  public int iFilterId;
  public int iLat;
  public int iLon;
  public String strAreaName = "";
  public long uiClientType;
  public long uiLabelStyle;
  public byte[] vClientVersion;
  
  static
  {
    ((byte[])cache_vClientVersion)[0] = 0;
  }
  
  public ReqGetGroupInArea() {}
  
  public ReqGetGroupInArea(String paramString, int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, long paramLong2, byte[] paramArrayOfByte, long paramLong3)
  {
    this.strAreaName = paramString;
    this.iLat = paramInt1;
    this.iLon = paramInt2;
    this.dwGroupStartIdx = paramLong1;
    this.iCount = paramInt3;
    this.iFilterId = paramInt4;
    this.uiLabelStyle = paramLong2;
    this.vClientVersion = paramArrayOfByte;
    this.uiClientType = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strAreaName = paramJceInputStream.readString(0, true);
    this.iLat = paramJceInputStream.read(this.iLat, 1, true);
    this.iLon = paramJceInputStream.read(this.iLon, 2, true);
    this.dwGroupStartIdx = paramJceInputStream.read(this.dwGroupStartIdx, 3, false);
    this.iCount = paramJceInputStream.read(this.iCount, 4, true);
    this.iFilterId = paramJceInputStream.read(this.iFilterId, 5, false);
    this.uiLabelStyle = paramJceInputStream.read(this.uiLabelStyle, 6, false);
    this.vClientVersion = ((byte[])paramJceInputStream.read(cache_vClientVersion, 7, false));
    this.uiClientType = paramJceInputStream.read(this.uiClientType, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strAreaName, 0);
    paramJceOutputStream.write(this.iLat, 1);
    paramJceOutputStream.write(this.iLon, 2);
    paramJceOutputStream.write(this.dwGroupStartIdx, 3);
    paramJceOutputStream.write(this.iCount, 4);
    paramJceOutputStream.write(this.iFilterId, 5);
    paramJceOutputStream.write(this.uiLabelStyle, 6);
    if (this.vClientVersion != null) {
      paramJceOutputStream.write(this.vClientVersion, 7);
    }
    paramJceOutputStream.write(this.uiClientType, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NearbyGroup.ReqGetGroupInArea
 * JD-Core Version:    0.7.0.1
 */