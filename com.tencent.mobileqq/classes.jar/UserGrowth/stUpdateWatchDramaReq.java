package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stUpdateWatchDramaReq
  extends JceStruct
{
  public String dramaID = "";
  public String feedID = "";
  public int feedNum = 0;
  public int feedSecond = 0;
  
  public stUpdateWatchDramaReq() {}
  
  public stUpdateWatchDramaReq(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.dramaID = paramString1;
    this.feedNum = paramInt1;
    this.feedSecond = paramInt2;
    this.feedID = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dramaID = paramJceInputStream.readString(0, false);
    this.feedNum = paramJceInputStream.read(this.feedNum, 1, false);
    this.feedSecond = paramJceInputStream.read(this.feedSecond, 2, false);
    this.feedID = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.dramaID;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.feedNum, 1);
    paramJceOutputStream.write(this.feedSecond, 2);
    str = this.feedID;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stUpdateWatchDramaReq
 * JD-Core Version:    0.7.0.1
 */