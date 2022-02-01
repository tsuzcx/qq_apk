package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetDramaFeedsReq
  extends JceStruct
{
  public String attachInfo = "";
  public String curFeedID = "";
  public String dramaID = "";
  public int refresh = 0;
  
  public stGetDramaFeedsReq() {}
  
  public stGetDramaFeedsReq(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.dramaID = paramString1;
    this.curFeedID = paramString2;
    this.refresh = paramInt;
    this.attachInfo = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dramaID = paramJceInputStream.readString(0, false);
    this.curFeedID = paramJceInputStream.readString(1, false);
    this.refresh = paramJceInputStream.read(this.refresh, 2, false);
    this.attachInfo = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.dramaID;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.curFeedID;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.refresh, 2);
    str = this.attachInfo;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetDramaFeedsReq
 * JD-Core Version:    0.7.0.1
 */