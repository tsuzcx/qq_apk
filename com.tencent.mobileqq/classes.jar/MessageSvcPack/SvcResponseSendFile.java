package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcResponseSendFile
  extends JceStruct
{
  public String strResult = "";
  public long uReplyCode;
  
  public SvcResponseSendFile() {}
  
  public SvcResponseSendFile(long paramLong, String paramString)
  {
    this.uReplyCode = paramLong;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uReplyCode = paramJceInputStream.read(this.uReplyCode, 0, true);
    this.strResult = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uReplyCode, 0);
    if (this.strResult != null) {
      paramJceOutputStream.write(this.strResult, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     MessageSvcPack.SvcResponseSendFile
 * JD-Core Version:    0.7.0.1
 */