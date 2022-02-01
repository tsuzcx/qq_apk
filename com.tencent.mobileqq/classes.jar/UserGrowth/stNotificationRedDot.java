package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stNotificationRedDot
  extends JceStruct
{
  static int cache_type;
  public String text = "";
  public int type = 0;
  
  public stNotificationRedDot() {}
  
  public stNotificationRedDot(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.text = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.text = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    String str = this.text;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stNotificationRedDot
 * JD-Core Version:    0.7.0.1
 */