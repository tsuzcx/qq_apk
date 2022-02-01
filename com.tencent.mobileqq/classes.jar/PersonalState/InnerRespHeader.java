package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class InnerRespHeader
  extends JceStruct
{
  public int iReplyCode = 0;
  public int iSeq = 0;
  public long lUIN = 0L;
  public short shVersion = 0;
  public String strResult = "";
  
  public InnerRespHeader() {}
  
  public InnerRespHeader(short paramShort, int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt1;
    this.lUIN = paramLong;
    this.iReplyCode = paramInt2;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    this.lUIN = paramJceInputStream.read(this.lUIN, 2, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 3, true);
    this.strResult = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.lUIN, 2);
    paramJceOutputStream.write(this.iReplyCode, 3);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PersonalState.InnerRespHeader
 * JD-Core Version:    0.7.0.1
 */