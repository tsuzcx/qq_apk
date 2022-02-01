package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetFirstPageMsgListReq
  extends JceStruct
{
  public String attachInfo = "";
  
  public stGetFirstPageMsgListReq() {}
  
  public stGetFirstPageMsgListReq(String paramString)
  {
    this.attachInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.attachInfo = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.attachInfo;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetFirstPageMsgListReq
 * JD-Core Version:    0.7.0.1
 */