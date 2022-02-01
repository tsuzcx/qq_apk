package NearbyPubAcct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class LBSInfo
  extends JceStruct
{
  static Attr cache_stAttr;
  static GPS cache_stGps;
  static ArrayList<Cell> cache_vCells;
  static ArrayList<Wifi> cache_vWifis;
  public Attr stAttr = null;
  public GPS stGps = null;
  public ArrayList<Cell> vCells = null;
  public ArrayList<Wifi> vWifis = null;
  
  public LBSInfo() {}
  
  public LBSInfo(GPS paramGPS, ArrayList<Wifi> paramArrayList, ArrayList<Cell> paramArrayList1, Attr paramAttr)
  {
    this.stGps = paramGPS;
    this.vWifis = paramArrayList;
    this.vCells = paramArrayList1;
    this.stAttr = paramAttr;
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
    if (cache_stAttr == null) {
      cache_stAttr = new Attr();
    }
    this.stAttr = ((Attr)paramJceInputStream.read(cache_stAttr, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stGps;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.vWifis;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.vCells;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.stAttr;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NearbyPubAcct.LBSInfo
 * JD-Core Version:    0.7.0.1
 */