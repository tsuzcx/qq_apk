package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFriendFeedReq
  extends JceStruct
{
  public String attachInfo = "";
  
  public stFriendFeedReq() {}
  
  public stFriendFeedReq(String paramString)
  {
    this.attachInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.attachInfo != null) {
      paramJceOutputStream.write(this.attachInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stFriendFeedReq
 * JD-Core Version:    0.7.0.1
 */