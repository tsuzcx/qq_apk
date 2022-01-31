package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FloatItemView
  extends JceStruct
{
  static CustomFileInfo cache_stFileInfo = new CustomFileInfo();
  public CustomFileInfo stFileInfo;
  
  public FloatItemView() {}
  
  public FloatItemView(CustomFileInfo paramCustomFileInfo)
  {
    this.stFileInfo = paramCustomFileInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stFileInfo = ((CustomFileInfo)paramJceInputStream.read(cache_stFileInfo, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stFileInfo != null) {
      paramJceOutputStream.write(this.stFileInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.FloatItemView
 * JD-Core Version:    0.7.0.1
 */