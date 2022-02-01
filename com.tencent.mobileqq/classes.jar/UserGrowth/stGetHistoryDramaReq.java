package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetHistoryDramaReq
  extends JceStruct
{
  public String attachInfo = "";
  public String personID = "";
  
  public stGetHistoryDramaReq() {}
  
  public stGetHistoryDramaReq(String paramString1, String paramString2)
  {
    this.personID = paramString1;
    this.attachInfo = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.personID = paramJceInputStream.readString(0, false);
    this.attachInfo = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.personID;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.attachInfo;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetHistoryDramaReq
 * JD-Core Version:    0.7.0.1
 */