package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BusiRespHead
  extends JceStruct
{
  public int iReplyCode = 0;
  public int iSeq = 0;
  public short shVersion = 0;
  public String strResult = "";
  
  public BusiRespHead() {}
  
  public BusiRespHead(short paramShort, int paramInt1, int paramInt2, String paramString)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt1;
    this.iReplyCode = paramInt2;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 2, true);
    this.strResult = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.iReplyCode, 2);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     PersonalState.BusiRespHead
 * JD-Core Version:    0.7.0.1
 */