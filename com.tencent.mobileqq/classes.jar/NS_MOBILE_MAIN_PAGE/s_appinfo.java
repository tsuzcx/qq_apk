package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_appinfo
  extends JceStruct
{
  public int infonum;
  
  public s_appinfo() {}
  
  public s_appinfo(int paramInt)
  {
    this.infonum = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.infonum = paramJceInputStream.read(this.infonum, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.infonum, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_appinfo
 * JD-Core Version:    0.7.0.1
 */