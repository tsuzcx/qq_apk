package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stUpdateFollowDramaReq
  extends JceStruct
{
  public String dramaID = "";
  public int type = 0;
  
  public stUpdateFollowDramaReq() {}
  
  public stUpdateFollowDramaReq(String paramString, int paramInt)
  {
    this.dramaID = paramString;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dramaID = paramJceInputStream.readString(0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.dramaID;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.type, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stUpdateFollowDramaReq
 * JD-Core Version:    0.7.0.1
 */