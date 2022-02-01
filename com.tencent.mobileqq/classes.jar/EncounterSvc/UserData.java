package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserData
  extends JceStruct
{
  static byte[] cache_strCookie = (byte[])new byte[1];
  public int iLat = 900000000;
  public int iLon = 900000000;
  public long lNextGrid = 0L;
  public long lOriginGrid = 0L;
  public int lTime = 0;
  public byte[] strCookie = null;
  public String strProvince = "";
  
  static
  {
    ((byte[])cache_strCookie)[0] = 0;
  }
  
  public UserData() {}
  
  public UserData(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString, byte[] paramArrayOfByte)
  {
    this.lTime = paramInt1;
    this.iLat = paramInt2;
    this.iLon = paramInt3;
    this.lOriginGrid = paramLong1;
    this.lNextGrid = paramLong2;
    this.strProvince = paramString;
    this.strCookie = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lTime = paramJceInputStream.read(this.lTime, 0, true);
    this.iLat = paramJceInputStream.read(this.iLat, 1, true);
    this.iLon = paramJceInputStream.read(this.iLon, 2, true);
    this.lOriginGrid = paramJceInputStream.read(this.lOriginGrid, 3, true);
    this.lNextGrid = paramJceInputStream.read(this.lNextGrid, 4, true);
    this.strProvince = paramJceInputStream.readString(5, false);
    this.strCookie = ((byte[])paramJceInputStream.read(cache_strCookie, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lTime, 0);
    paramJceOutputStream.write(this.iLat, 1);
    paramJceOutputStream.write(this.iLon, 2);
    paramJceOutputStream.write(this.lOriginGrid, 3);
    paramJceOutputStream.write(this.lNextGrid, 4);
    Object localObject = this.strProvince;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.strCookie;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     EncounterSvc.UserData
 * JD-Core Version:    0.7.0.1
 */