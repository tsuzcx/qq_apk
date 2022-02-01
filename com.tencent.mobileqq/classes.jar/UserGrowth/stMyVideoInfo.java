package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMyVideoInfo
  extends JceStruct
{
  public int flag = 0;
  public String jumpurl = "";
  
  public stMyVideoInfo() {}
  
  public stMyVideoInfo(String paramString, int paramInt)
  {
    this.jumpurl = paramString;
    this.flag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.jumpurl = paramJceInputStream.readString(0, false);
    this.flag = paramJceInputStream.read(this.flag, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.jumpurl != null) {
      paramJceOutputStream.write(this.jumpurl, 0);
    }
    paramJceOutputStream.write(this.flag, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stMyVideoInfo
 * JD-Core Version:    0.7.0.1
 */