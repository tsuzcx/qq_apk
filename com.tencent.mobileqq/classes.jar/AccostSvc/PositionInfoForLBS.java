package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PositionInfoForLBS
  extends JceStruct
{
  static GPS cache_stGps;
  static ArrayList cache_vCells;
  static byte[] cache_vLBSKeyData;
  static ArrayList cache_vMacs;
  public byte bPositionInfoType;
  public GPS stGps;
  public ArrayList vCells;
  public byte[] vLBSKeyData;
  public ArrayList vMacs;
  
  public PositionInfoForLBS() {}
  
  public PositionInfoForLBS(byte paramByte, GPS paramGPS, ArrayList paramArrayList1, ArrayList paramArrayList2, byte[] paramArrayOfByte)
  {
    this.bPositionInfoType = paramByte;
    this.stGps = paramGPS;
    this.vMacs = paramArrayList1;
    this.vCells = paramArrayList2;
    this.vLBSKeyData = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bPositionInfoType = paramJceInputStream.read(this.bPositionInfoType, 1, true);
    if (cache_stGps == null) {
      cache_stGps = new GPS();
    }
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 2, false));
    if (cache_vMacs == null)
    {
      cache_vMacs = new ArrayList();
      cache_vMacs.add(Long.valueOf(0L));
    }
    this.vMacs = ((ArrayList)paramJceInputStream.read(cache_vMacs, 3, false));
    if (cache_vCells == null)
    {
      cache_vCells = new ArrayList();
      Cell localCell = new Cell();
      cache_vCells.add(localCell);
    }
    this.vCells = ((ArrayList)paramJceInputStream.read(cache_vCells, 4, false));
    if (cache_vLBSKeyData == null)
    {
      cache_vLBSKeyData = (byte[])new byte[1];
      ((byte[])cache_vLBSKeyData)[0] = 0;
    }
    this.vLBSKeyData = ((byte[])paramJceInputStream.read(cache_vLBSKeyData, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bPositionInfoType, 1);
    if (this.stGps != null) {
      paramJceOutputStream.write(this.stGps, 2);
    }
    if (this.vMacs != null) {
      paramJceOutputStream.write(this.vMacs, 3);
    }
    if (this.vCells != null) {
      paramJceOutputStream.write(this.vCells, 4);
    }
    if (this.vLBSKeyData != null) {
      paramJceOutputStream.write(this.vLBSKeyData, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     AccostSvc.PositionInfoForLBS
 * JD-Core Version:    0.7.0.1
 */