package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetSimpleRecommendDramaReq
  extends JceStruct
{
  public String enterDramaID = "";
  
  public stGetSimpleRecommendDramaReq() {}
  
  public stGetSimpleRecommendDramaReq(String paramString)
  {
    this.enterDramaID = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.enterDramaID = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.enterDramaID;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetSimpleRecommendDramaReq
 * JD-Core Version:    0.7.0.1
 */