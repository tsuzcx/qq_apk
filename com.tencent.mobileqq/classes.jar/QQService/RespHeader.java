package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespHeader
  extends JceStruct
{
  public int iReplyCode;
  public int iSeq;
  public long lMID;
  public short shVersion;
  public String strResult = "";
  
  public RespHeader() {}
  
  public RespHeader(short paramShort, int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt1;
    this.lMID = paramLong;
    this.iReplyCode = paramInt2;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    this.lMID = paramJceInputStream.read(this.lMID, 2, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 3, true);
    this.strResult = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.lMID, 2);
    paramJceOutputStream.write(this.iReplyCode, 3);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     QQService.RespHeader
 * JD-Core Version:    0.7.0.1
 */