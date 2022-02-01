package EncounterSvc;

import NeighborComm.SOSO_Cell;
import NeighborComm.SOSO_Wifi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqUserInfo
  extends JceStruct
{
  static int cache_eListType;
  static int cache_eLocalInfo;
  static GPS cache_stGps = new GPS();
  static ArrayList<Cell> cache_vCells;
  static byte[] cache_vLBSKeyData;
  static ArrayList<Long> cache_vMacs = new ArrayList();
  static ArrayList<SOSO_Cell> cache_vSOSOCells;
  static ArrayList<SOSO_Wifi> cache_vSOSOMac;
  public int eListType = 1;
  public int eLocalInfo = 0;
  public GPS stGps = null;
  public String strAuthName = "";
  public String strAuthPassword = "";
  public ArrayList<Cell> vCells = null;
  public byte[] vLBSKeyData = null;
  public ArrayList<Long> vMacs = null;
  public ArrayList<SOSO_Cell> vSOSOCells = null;
  public ArrayList<SOSO_Wifi> vSOSOMac = null;
  
  static
  {
    cache_vMacs.add(Long.valueOf(0L));
    cache_vCells = new ArrayList();
    Object localObject = new Cell();
    cache_vCells.add(localObject);
    cache_eListType = 0;
    cache_eLocalInfo = 0;
    cache_vLBSKeyData = (byte[])new byte[1];
    ((byte[])cache_vLBSKeyData)[0] = 0;
    cache_vSOSOMac = new ArrayList();
    localObject = new SOSO_Wifi();
    cache_vSOSOMac.add(localObject);
    cache_vSOSOCells = new ArrayList();
    localObject = new SOSO_Cell();
    cache_vSOSOCells.add(localObject);
  }
  
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
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 0, false));
    this.vMacs = ((ArrayList)paramJceInputStream.read(cache_vMacs, 1, false));
    this.vCells = ((ArrayList)paramJceInputStream.read(cache_vCells, 2, false));
    this.strAuthName = paramJceInputStream.readString(3, false);
    this.strAuthPassword = paramJceInputStream.readString(4, false);
    this.eListType = paramJceInputStream.read(this.eListType, 5, false);
    this.eLocalInfo = paramJceInputStream.read(this.eLocalInfo, 6, false);
    this.vLBSKeyData = ((byte[])paramJceInputStream.read(cache_vLBSKeyData, 7, false));
    this.vSOSOMac = ((ArrayList)paramJceInputStream.read(cache_vSOSOMac, 8, false));
    this.vSOSOCells = ((ArrayList)paramJceInputStream.read(cache_vSOSOCells, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stGps != null) {
      paramJceOutputStream.write(this.stGps, 0);
    }
    if (this.vMacs != null) {
      paramJceOutputStream.write(this.vMacs, 1);
    }
    if (this.vCells != null) {
      paramJceOutputStream.write(this.vCells, 2);
    }
    if (this.strAuthName != null) {
      paramJceOutputStream.write(this.strAuthName, 3);
    }
    if (this.strAuthPassword != null) {
      paramJceOutputStream.write(this.strAuthPassword, 4);
    }
    paramJceOutputStream.write(this.eListType, 5);
    paramJceOutputStream.write(this.eLocalInfo, 6);
    if (this.vLBSKeyData != null) {
      paramJceOutputStream.write(this.vLBSKeyData, 7);
    }
    if (this.vSOSOMac != null) {
      paramJceOutputStream.write(this.vSOSOMac, 8);
    }
    if (this.vSOSOCells != null) {
      paramJceOutputStream.write(this.vSOSOCells, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     EncounterSvc.ReqUserInfo
 * JD-Core Version:    0.7.0.1
 */