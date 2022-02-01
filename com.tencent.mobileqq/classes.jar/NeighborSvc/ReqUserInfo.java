package NeighborSvc;

import NeighborComm.LocalInfoType;
import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class ReqUserInfo
  extends JceStruct
{
  static int cache_eListType;
  static int cache_eLocalInfo;
  static GPS cache_stGps;
  static ArrayList<Cell> cache_vCells;
  static byte[] cache_vLBSKeyData;
  static ArrayList<Long> cache_vMacs;
  static ArrayList<SOSO_Cell> cache_vSOSOCells;
  static ArrayList<SOSO_Wifi> cache_vSOSOMac;
  public int eListType = ListType.ListType_Normal.value();
  public int eLocalInfo = LocalInfoType.LocalInfoType_Decode.value();
  public GPS stGps = null;
  public String strAuthName = "";
  public String strAuthPassword = "";
  public ArrayList<Cell> vCells = null;
  public byte[] vLBSKeyData = null;
  public ArrayList<Long> vMacs = null;
  public ArrayList<SOSO_Cell> vSOSOCells = null;
  public ArrayList<SOSO_Wifi> vSOSOMac = null;
  
  public ReqUserInfo() {}
  
  public ReqUserInfo(GPS paramGPS, ArrayList<Long> paramArrayList, ArrayList<Cell> paramArrayList1, String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte, ArrayList<SOSO_Wifi> paramArrayList2, ArrayList<SOSO_Cell> paramArrayList3)
  {
    this.stGps = paramGPS;
    this.vMacs = paramArrayList;
    this.vCells = paramArrayList1;
    this.strAuthName = paramString1;
    this.strAuthPassword = paramString2;
    this.eListType = paramInt1;
    this.eLocalInfo = paramInt2;
    this.vLBSKeyData = paramArrayOfByte;
    this.vSOSOMac = paramArrayList2;
    this.vSOSOCells = paramArrayList3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new GPS();
    }
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 0, true));
    if (cache_vMacs == null)
    {
      cache_vMacs = new ArrayList();
      cache_vMacs.add(Long.valueOf(0L));
    }
    this.vMacs = ((ArrayList)paramJceInputStream.read(cache_vMacs, 1, true));
    Object localObject;
    if (cache_vCells == null)
    {
      cache_vCells = new ArrayList();
      localObject = new Cell();
      cache_vCells.add(localObject);
    }
    this.vCells = ((ArrayList)paramJceInputStream.read(cache_vCells, 2, true));
    this.strAuthName = paramJceInputStream.readString(3, true);
    this.strAuthPassword = paramJceInputStream.readString(4, true);
    this.eListType = paramJceInputStream.read(this.eListType, 5, false);
    this.eLocalInfo = paramJceInputStream.read(this.eLocalInfo, 6, false);
    if (cache_vLBSKeyData == null)
    {
      cache_vLBSKeyData = (byte[])new byte[1];
      ((byte[])cache_vLBSKeyData)[0] = 0;
    }
    this.vLBSKeyData = ((byte[])paramJceInputStream.read(cache_vLBSKeyData, 7, false));
    if (cache_vSOSOMac == null)
    {
      cache_vSOSOMac = new ArrayList();
      localObject = new SOSO_Wifi();
      cache_vSOSOMac.add(localObject);
    }
    this.vSOSOMac = ((ArrayList)paramJceInputStream.read(cache_vSOSOMac, 8, false));
    if (cache_vSOSOCells == null)
    {
      cache_vSOSOCells = new ArrayList();
      localObject = new SOSO_Cell();
      cache_vSOSOCells.add(localObject);
    }
    this.vSOSOCells = ((ArrayList)paramJceInputStream.read(cache_vSOSOCells, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.vMacs, 1);
    paramJceOutputStream.write(this.vCells, 2);
    paramJceOutputStream.write(this.strAuthName, 3);
    paramJceOutputStream.write(this.strAuthPassword, 4);
    paramJceOutputStream.write(this.eListType, 5);
    paramJceOutputStream.write(this.eLocalInfo, 6);
    Object localObject = this.vLBSKeyData;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 7);
    }
    localObject = this.vSOSOMac;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 8);
    }
    localObject = this.vSOSOCells;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NeighborSvc.ReqUserInfo
 * JD-Core Version:    0.7.0.1
 */