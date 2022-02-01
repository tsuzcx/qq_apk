package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CondFitUser
  extends JceStruct
{
  static byte[] cache_vRichSign = (byte[])new byte[1];
  public byte cConstellationId = 0;
  public byte cSex = 0;
  public long dwAge = 0L;
  public long dwCity = 0L;
  public long dwCountry = 0L;
  public long dwProvince = 0L;
  public int iOccupationId = 0;
  public long lUIN = 0L;
  public String locDesc;
  public String personalSignature;
  public String strNick = "";
  public byte[] vRichSign = null;
  
  static
  {
    ((byte[])cache_vRichSign)[0] = 0;
  }
  
  public CondFitUser() {}
  
  public CondFitUser(long paramLong1, String paramString, byte[] paramArrayOfByte, byte paramByte1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, byte paramByte2, int paramInt)
  {
    this.lUIN = paramLong1;
    this.strNick = paramString;
    this.vRichSign = paramArrayOfByte;
    this.cSex = paramByte1;
    this.dwAge = paramLong2;
    this.dwCountry = paramLong3;
    this.dwProvince = paramLong4;
    this.dwCity = paramLong5;
    this.cConstellationId = paramByte2;
    this.iOccupationId = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.strNick = paramJceInputStream.readString(1, false);
    this.vRichSign = ((byte[])paramJceInputStream.read(cache_vRichSign, 2, false));
    this.cSex = paramJceInputStream.read(this.cSex, 3, false);
    this.dwAge = paramJceInputStream.read(this.dwAge, 4, false);
    this.dwCountry = paramJceInputStream.read(this.dwCountry, 5, false);
    this.dwProvince = paramJceInputStream.read(this.dwProvince, 6, false);
    this.dwCity = paramJceInputStream.read(this.dwCity, 7, false);
    this.cConstellationId = paramJceInputStream.read(this.cConstellationId, 8, false);
    this.iOccupationId = paramJceInputStream.read(this.iOccupationId, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 1);
    }
    if (this.vRichSign != null) {
      paramJceOutputStream.write(this.vRichSign, 2);
    }
    paramJceOutputStream.write(this.cSex, 3);
    paramJceOutputStream.write(this.dwAge, 4);
    paramJceOutputStream.write(this.dwCountry, 5);
    paramJceOutputStream.write(this.dwProvince, 6);
    paramJceOutputStream.write(this.dwCity, 7);
    paramJceOutputStream.write(this.cConstellationId, 8);
    paramJceOutputStream.write(this.iOccupationId, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.CondFitUser
 * JD-Core Version:    0.7.0.1
 */