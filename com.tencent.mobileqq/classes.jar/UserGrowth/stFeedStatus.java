package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFeedStatus
  extends JceStruct
{
  public String feedId = "";
  public String msg = "";
  public int status = 0;
  
  public stFeedStatus() {}
  
  public stFeedStatus(String paramString1, int paramInt, String paramString2)
  {
    this.feedId = paramString1;
    this.status = paramInt;
    this.msg = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feedId = paramJceInputStream.readString(0, false);
    this.status = paramJceInputStream.read(this.status, 1, false);
    this.msg = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.feedId != null) {
      paramJceOutputStream.write(this.feedId, 0);
    }
    paramJceOutputStream.write(this.status, 1);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stFeedStatus
 * JD-Core Version:    0.7.0.1
 */