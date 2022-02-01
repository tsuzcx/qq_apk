package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetAllFeedsByDramaIDReq
  extends JceStruct
{
  public String dramaID = "";
  
  public stGetAllFeedsByDramaIDReq() {}
  
  public stGetAllFeedsByDramaIDReq(String paramString)
  {
    this.dramaID = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dramaID = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.dramaID;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetAllFeedsByDramaIDReq
 * JD-Core Version:    0.7.0.1
 */