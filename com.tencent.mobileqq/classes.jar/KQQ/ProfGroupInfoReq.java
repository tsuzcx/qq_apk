package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ProfGroupInfoReq
  extends JceStruct
{
  public byte cIfGetAuthInfo = 0;
  public byte cIsGetGroupAlbum = 0;
  public byte cStatOption = 0;
  public long dwTimeStamp = 0L;
  public long uGroupCode = 0L;
  public int wSourceID = 0;
  public int wSourceSubID = 0;
  
  public ProfGroupInfoReq() {}
  
  public ProfGroupInfoReq(long paramLong1, byte paramByte1, long paramLong2, byte paramByte2, int paramInt1, int paramInt2, byte paramByte3)
  {
    this.uGroupCode = paramLong1;
    this.cIsGetGroupAlbum = paramByte1;
    this.dwTimeStamp = paramLong2;
    this.cStatOption = paramByte2;
    this.wSourceID = paramInt1;
    this.wSourceSubID = paramInt2;
    this.cIfGetAuthInfo = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uGroupCode = paramJceInputStream.read(this.uGroupCode, 0, true);
    this.cIsGetGroupAlbum = paramJceInputStream.read(this.cIsGetGroupAlbum, 1, false);
    this.dwTimeStamp = paramJceInputStream.read(this.dwTimeStamp, 2, false);
    this.cStatOption = paramJceInputStream.read(this.cStatOption, 3, false);
    this.wSourceID = paramJceInputStream.read(this.wSourceID, 4, false);
    this.wSourceSubID = paramJceInputStream.read(this.wSourceSubID, 5, false);
    this.cIfGetAuthInfo = paramJceInputStream.read(this.cIfGetAuthInfo, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uGroupCode, 0);
    paramJceOutputStream.write(this.cIsGetGroupAlbum, 1);
    paramJceOutputStream.write(this.dwTimeStamp, 2);
    paramJceOutputStream.write(this.cStatOption, 3);
    paramJceOutputStream.write(this.wSourceID, 4);
    paramJceOutputStream.write(this.wSourceSubID, 5);
    paramJceOutputStream.write(this.cIfGetAuthInfo, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.ProfGroupInfoReq
 * JD-Core Version:    0.7.0.1
 */