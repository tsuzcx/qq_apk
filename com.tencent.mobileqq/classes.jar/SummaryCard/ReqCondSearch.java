package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqCondSearch
  extends JceStruct
{
  static byte[] cache_vCityId = (byte[])new byte[1];
  static byte[] cache_vHomeId;
  public short cAge;
  public byte cConstellationId;
  public byte cGender;
  public short cMaxAge = 120;
  public short cMinAge = 18;
  public long dwFlag;
  public long dwSessionID;
  public int iOccupationId;
  public int iPage;
  public String strNick = "";
  public byte[] vCityId;
  public byte[] vHomeId;
  
  static
  {
    ((byte[])cache_vCityId)[0] = 0;
    cache_vHomeId = (byte[])new byte[1];
    ((byte[])cache_vHomeId)[0] = 0;
  }
  
  public ReqCondSearch() {}
  
  public ReqCondSearch(int paramInt1, long paramLong1, long paramLong2, String paramString, byte paramByte1, byte[] paramArrayOfByte1, short paramShort1, byte[] paramArrayOfByte2, byte paramByte2, int paramInt2, short paramShort2, short paramShort3)
  {
    this.iPage = paramInt1;
    this.dwSessionID = paramLong1;
    this.dwFlag = paramLong2;
    this.strNick = paramString;
    this.cGender = paramByte1;
    this.vCityId = paramArrayOfByte1;
    this.cAge = paramShort1;
    this.vHomeId = paramArrayOfByte2;
    this.cConstellationId = paramByte2;
    this.iOccupationId = paramInt2;
    this.cMinAge = paramShort2;
    this.cMaxAge = paramShort3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iPage = paramJceInputStream.read(this.iPage, 0, true);
    this.dwSessionID = paramJceInputStream.read(this.dwSessionID, 1, true);
    this.dwFlag = paramJceInputStream.read(this.dwFlag, 2, true);
    this.strNick = paramJceInputStream.readString(3, false);
    this.cGender = paramJceInputStream.read(this.cGender, 4, false);
    this.vCityId = ((byte[])paramJceInputStream.read(cache_vCityId, 5, false));
    this.cAge = paramJceInputStream.read(this.cAge, 6, false);
    this.vHomeId = ((byte[])paramJceInputStream.read(cache_vHomeId, 7, false));
    this.cConstellationId = paramJceInputStream.read(this.cConstellationId, 8, false);
    this.iOccupationId = paramJceInputStream.read(this.iOccupationId, 9, false);
    this.cMinAge = paramJceInputStream.read(this.cMinAge, 10, false);
    this.cMaxAge = paramJceInputStream.read(this.cMaxAge, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iPage, 0);
    paramJceOutputStream.write(this.dwSessionID, 1);
    paramJceOutputStream.write(this.dwFlag, 2);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 3);
    }
    paramJceOutputStream.write(this.cGender, 4);
    if (this.vCityId != null) {
      paramJceOutputStream.write(this.vCityId, 5);
    }
    paramJceOutputStream.write(this.cAge, 6);
    if (this.vHomeId != null) {
      paramJceOutputStream.write(this.vHomeId, 7);
    }
    paramJceOutputStream.write(this.cConstellationId, 8);
    paramJceOutputStream.write(this.iOccupationId, 9);
    paramJceOutputStream.write(this.cMinAge, 10);
    paramJceOutputStream.write(this.cMaxAge, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCard.ReqCondSearch
 * JD-Core Version:    0.7.0.1
 */