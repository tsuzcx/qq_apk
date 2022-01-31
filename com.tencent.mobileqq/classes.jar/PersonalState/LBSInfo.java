package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class LBSInfo
  extends JceStruct
{
  static GPS cache_stGps;
  static ArrayList<Cell> cache_vCells;
  static ArrayList<Wifi> cache_vWifis;
  public GPS stGps;
  public ArrayList<Cell> vCells;
  public ArrayList<Wifi> vWifis;
  
  public LBSInfo() {}
  
  public LBSInfo(GPS paramGPS, ArrayList<Wifi> paramArrayList, ArrayList<Cell> paramArrayList1)
  {
    this.stGps = paramGPS;
    this.vWifis = paramArrayList;
    this.vCells = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new GPS();
    }
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 0, false));
    Object localObject;
    if (cache_vWifis == null)
    {
      cache_vWifis = new ArrayList();
      localObject = new Wifi();
      cache_vWifis.add(localObject);
    }
    this.vWifis = ((ArrayList)paramJceInputStream.read(cache_vWifis, 1, false));
    if (cache_vCells == null)
    {
      cache_vCells = new ArrayList();
      localObject = new Cell();
      cache_vCells.add(localObject);
    }
    this.vCells = ((ArrayList)paramJceInputStream.read(cache_vCells, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stGps != null) {
      paramJceOutputStream.write(this.stGps, 0);
    }
    if (this.vWifis != null) {
      paramJceOutputStream.write(this.vWifis, 1);
    }
    if (this.vCells != null) {
      paramJceOutputStream.write(this.vCells, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     PersonalState.LBSInfo
 * JD-Core Version:    0.7.0.1
 */