package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSimpleGetFeedDetailReq
  extends JceStruct
{
  public String feedid = "";
  
  public stSimpleGetFeedDetailReq() {}
  
  public stSimpleGetFeedDetailReq(String paramString)
  {
    this.feedid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feedid = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.feedid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stSimpleGetFeedDetailReq
 * JD-Core Version:    0.7.0.1
 */