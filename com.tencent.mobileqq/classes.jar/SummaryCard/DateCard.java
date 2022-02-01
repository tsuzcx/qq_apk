package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DateCard
  extends JceStruct
{
  static byte[] cache_vActivityList;
  static byte[] cache_vDateInfo;
  static byte[] cache_vFaces = (byte[])new byte[1];
  static byte[] cache_vGroupList;
  static byte[] cache_vNearbyInfo;
  public byte bConstellation = 0;
  public byte bMarriage = 0;
  public long lTinyId = 0L;
  public String strCompany = "";
  public String strDistance = "";
  public String strElapse = "";
  public String strSchool = "";
  public long uHomeCity = 0L;
  public long uHomeCountry = 0L;
  public long uHomeProvince = 0L;
  public long uHomeZone = 0L;
  public long uProfession = 0L;
  public long uSchoolId = 0L;
  public byte[] vActivityList = null;
  public byte[] vDateInfo = null;
  public byte[] vFaces = null;
  public byte[] vGroupList = null;
  public byte[] vNearbyInfo = null;
  
  static
  {
    ((byte[])cache_vFaces)[0] = 0;
    cache_vDateInfo = (byte[])new byte[1];
    ((byte[])cache_vDateInfo)[0] = 0;
    cache_vGroupList = (byte[])new byte[1];
    ((byte[])cache_vGroupList)[0] = 0;
    cache_vNearbyInfo = (byte[])new byte[1];
    ((byte[])cache_vNearbyInfo)[0] = 0;
    cache_vActivityList = (byte[])new byte[1];
    ((byte[])cache_vActivityList)[0] = 0;
  }
  
  public DateCard() {}
  
  public DateCard(byte[] paramArrayOfByte1, byte paramByte1, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte2, String paramString3, String paramString4, byte paramByte2, long paramLong5, long paramLong6, long paramLong7, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    this.vFaces = paramArrayOfByte1;
    this.bConstellation = paramByte1;
    this.uProfession = paramLong1;
    this.strCompany = paramString1;
    this.strSchool = paramString2;
    this.uHomeCountry = paramLong2;
    this.uHomeProvince = paramLong3;
    this.uHomeCity = paramLong4;
    this.vDateInfo = paramArrayOfByte2;
    this.strDistance = paramString3;
    this.strElapse = paramString4;
    this.bMarriage = paramByte2;
    this.uHomeZone = paramLong5;
    this.lTinyId = paramLong6;
    this.uSchoolId = paramLong7;
    this.vGroupList = paramArrayOfByte3;
    this.vNearbyInfo = paramArrayOfByte4;
    this.vActivityList = paramArrayOfByte5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vFaces = ((byte[])paramJceInputStream.read(cache_vFaces, 0, false));
    this.bConstellation = paramJceInputStream.read(this.bConstellation, 1, false);
    this.uProfession = paramJceInputStream.read(this.uProfession, 2, false);
    this.strCompany = paramJceInputStream.readString(3, false);
    this.strSchool = paramJceInputStream.readString(4, false);
    this.uHomeCountry = paramJceInputStream.read(this.uHomeCountry, 5, false);
    this.uHomeProvince = paramJceInputStream.read(this.uHomeProvince, 6, false);
    this.uHomeCity = paramJceInputStream.read(this.uHomeCity, 7, false);
    this.vDateInfo = ((byte[])paramJceInputStream.read(cache_vDateInfo, 8, false));
    this.strDistance = paramJceInputStream.readString(9, false);
    this.strElapse = paramJceInputStream.readString(10, false);
    this.bMarriage = paramJceInputStream.read(this.bMarriage, 11, false);
    this.uHomeZone = paramJceInputStream.read(this.uHomeZone, 12, false);
    this.lTinyId = paramJceInputStream.read(this.lTinyId, 13, false);
    this.uSchoolId = paramJceInputStream.read(this.uSchoolId, 14, false);
    this.vGroupList = ((byte[])paramJceInputStream.read(cache_vGroupList, 15, false));
    this.vNearbyInfo = ((byte[])paramJceInputStream.read(cache_vNearbyInfo, 16, false));
    this.vActivityList = ((byte[])paramJceInputStream.read(cache_vActivityList, 17, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.vFaces;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 0);
    }
    paramJceOutputStream.write(this.bConstellation, 1);
    paramJceOutputStream.write(this.uProfession, 2);
    localObject = this.strCompany;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.strSchool;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.uHomeCountry, 5);
    paramJceOutputStream.write(this.uHomeProvince, 6);
    paramJceOutputStream.write(this.uHomeCity, 7);
    localObject = this.vDateInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 8);
    }
    localObject = this.strDistance;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.strElapse;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.bMarriage, 11);
    paramJceOutputStream.write(this.uHomeZone, 12);
    paramJceOutputStream.write(this.lTinyId, 13);
    paramJceOutputStream.write(this.uSchoolId, 14);
    localObject = this.vGroupList;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 15);
    }
    localObject = this.vNearbyInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 16);
    }
    localObject = this.vActivityList;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.DateCard
 * JD-Core Version:    0.7.0.1
 */