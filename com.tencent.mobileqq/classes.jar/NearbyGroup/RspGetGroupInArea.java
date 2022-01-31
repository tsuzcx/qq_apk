package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RspGetGroupInArea
  extends JceStruct
{
  static GroupArea cache_stGroupArea;
  public GroupArea stGroupArea;
  
  public RspGetGroupInArea() {}
  
  public RspGetGroupInArea(GroupArea paramGroupArea)
  {
    this.stGroupArea = paramGroupArea;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGroupArea == null) {
      cache_stGroupArea = new GroupArea();
    }
    this.stGroupArea = ((GroupArea)paramJceInputStream.read(cache_stGroupArea, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stGroupArea != null) {
      paramJceOutputStream.write(this.stGroupArea, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NearbyGroup.RspGetGroupInArea
 * JD-Core Version:    0.7.0.1
 */