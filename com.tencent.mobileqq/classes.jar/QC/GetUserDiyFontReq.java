package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetUserDiyFontReq
  extends JceStruct
{
  public int diyFontId = 0;
  public long targetUin = 0L;
  
  public GetUserDiyFontReq() {}
  
  public GetUserDiyFontReq(long paramLong, int paramInt)
  {
    this.targetUin = paramLong;
    this.diyFontId = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.targetUin = paramJceInputStream.read(this.targetUin, 0, false);
    this.diyFontId = paramJceInputStream.read(this.diyFontId, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.targetUin, 0);
    paramJceOutputStream.write(this.diyFontId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.GetUserDiyFontReq
 * JD-Core Version:    0.7.0.1
 */