package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RspGetPositionApi
  extends JceStruct
{
  static GPS cache_stUsrLoc;
  static ArrayList cache_vCells;
  static ArrayList cache_vMacs;
  public int iDistrictCode;
  public int iRange = -1;
  public GPS stUsrLoc;
  public String strCity = "";
  public String strDistrict = "";
  public String strPremises = "";
  public String strProvince = "";
  public String strRoad = "";
  public String strTown = "";
  public ArrayList vCells;
  public ArrayList vMacs;
  
  public RspGetPositionApi() {}
  
  public RspGetPositionApi(GPS paramGPS, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.stUsrLoc = paramGPS;
    this.iRange = paramInt1;
    this.strProvince = paramString1;
    this.strCity = paramString2;
    this.strDistrict = paramString3;
    this.strTown = paramString4;
    this.strRoad = paramString5;
    this.strPremises = paramString6;
    this.iDistrictCode = paramInt2;
    this.vMacs = paramArrayList1;
    this.vCells = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUsrLoc == null) {
      cache_stUsrLoc = new GPS();
    }
    this.stUsrLoc = ((GPS)paramJceInputStream.read(cache_stUsrLoc, 0, true));
    this.iRange = paramJceInputStream.read(this.iRange, 1, true);
    this.strProvince = paramJceInputStream.readString(2, true);
    this.strCity = paramJceInputStream.readString(3, true);
    this.strDistrict = paramJceInputStream.readString(4, true);
    this.strTown = paramJceInputStream.readString(5, true);
    this.strRoad = paramJceInputStream.readString(6, true);
    this.strPremises = paramJceInputStream.readString(7, true);
    this.iDistrictCode = paramJceInputStream.read(this.iDistrictCode, 8, true);
    if (cache_vMacs == null)
    {
      cache_vMacs = new ArrayList();
      cache_vMacs.add(Long.valueOf(0L));
    }
    this.vMacs = ((ArrayList)paramJceInputStream.read(cache_vMacs, 9, false));
    if (cache_vCells == null)
    {
      cache_vCells = new ArrayList();
      Cell localCell = new Cell();
      cache_vCells.add(localCell);
    }
    this.vCells = ((ArrayList)paramJceInputStream.read(cache_vCells, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUsrLoc, 0);
    paramJceOutputStream.write(this.iRange, 1);
    paramJceOutputStream.write(this.strProvince, 2);
    paramJceOutputStream.write(this.strCity, 3);
    paramJceOutputStream.write(this.strDistrict, 4);
    paramJceOutputStream.write(this.strTown, 5);
    paramJceOutputStream.write(this.strRoad, 6);
    paramJceOutputStream.write(this.strPremises, 7);
    paramJceOutputStream.write(this.iDistrictCode, 8);
    if (this.vMacs != null) {
      paramJceOutputStream.write(this.vMacs, 9);
    }
    if (this.vCells != null) {
      paramJceOutputStream.write(this.vCells, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBSAddrProtocol.RspGetPositionApi
 * JD-Core Version:    0.7.0.1
 */