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
  public byte bConstellation;
  public byte bMarriage;
  public long lTinyId;
  public String strCompany = "";
  public String strDistance = "";
  public String strElapse = "";
  public String strSchool = "";
  public long uHomeCity;
  public long uHomeCountry;
  public long uHomeProvince;
  public long uHomeZone;
  public long uProfession;
  public long uSchoolId;
  public byte[] vActivityList;
  public byte[] vDateInfo;
  public byte[] vFaces;
  public byte[] vGroupList;
  public byte[] vNearbyInfo;
  
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
    if (this.vFaces != null) {
      paramJceOutputStream.write(this.vFaces, 0);
    }
    paramJceOutputStream.write(this.bConstellation, 1);
    paramJceOutputStream.write(this.uProfession, 2);
    if (this.strCompany != null) {
      paramJceOutputStream.write(this.strCompany, 3);
    }
    if (this.strSchool != null) {
      paramJceOutputStream.write(this.strSchool, 4);
    }
    paramJceOutputStream.write(this.uHomeCountry, 5);
    paramJceOutputStream.write(this.uHomeProvince, 6);
    paramJceOutputStream.write(this.uHomeCity, 7);
    if (this.vDateInfo != null) {
      paramJceOutputStream.write(this.vDateInfo, 8);
    }
    if (this.strDistance != null) {
      paramJceOutputStream.write(this.strDistance, 9);
    }
    if (this.strElapse != null) {
      paramJceOutputStream.write(this.strElapse, 10);
    }
    paramJceOutputStream.write(this.bMarriage, 11);
    paramJceOutputStream.write(this.uHomeZone, 12);
    paramJceOutputStream.write(this.lTinyId, 13);
    paramJceOutputStream.write(this.uSchoolId, 14);
    if (this.vGroupList != null) {
      paramJceOutputStream.write(this.vGroupList, 15);
    }
    if (this.vNearbyInfo != null) {
      paramJceOutputStream.write(this.vNearbyInfo, 16);
    }
    if (this.vActivityList != null) {
      paramJceOutputStream.write(this.vActivityList, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCard.DateCard
 * JD-Core Version:    0.7.0.1
 */