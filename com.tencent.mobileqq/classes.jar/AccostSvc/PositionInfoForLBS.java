package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class PositionInfoForLBS
  extends JceStruct
{
  static GPS cache_stGps;
  static ArrayList<Cell> cache_vCells;
  static byte[] cache_vLBSKeyData;
  static ArrayList<Long> cache_vMacs;
  public byte bPositionInfoType = 0;
  public GPS stGps = null;
  public ArrayList<Cell> vCells = null;
  public byte[] vLBSKeyData = null;
  public ArrayList<Long> vMacs = null;
  
  public PositionInfoForLBS() {}
  
  public PositionInfoForLBS(byte paramByte, GPS paramGPS, ArrayList<Long> paramArrayList, ArrayList<Cell> paramArrayList1, byte[] paramArrayOfByte)
  {
    this.bPositionInfoType = paramByte;
    this.stGps = paramGPS;
    this.vMacs = paramArrayList;
    this.vCells = paramArrayList1;
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
    Object localObject = this.stGps;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.vMacs;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.vCells;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    localObject = this.vLBSKeyData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     AccostSvc.PositionInfoForLBS
 * JD-Core Version:    0.7.0.1
 */