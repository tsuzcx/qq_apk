package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFollowReq
  extends JceStruct
{
  static int cache_action;
  public int action = 0;
  public String personId = "";
  
  public stFollowReq() {}
  
  public stFollowReq(String paramString, int paramInt)
  {
    this.personId = paramString;
    this.action = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.personId = paramJceInputStream.readString(0, false);
    this.action = paramJceInputStream.read(this.action, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.personId;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.action, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stFollowReq
 * JD-Core Version:    0.7.0.1
 */