package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class multiple_count
  extends JceStruct
{
  static ArrayList<String> cache_icon = new ArrayList();
  public ArrayList<String> icon = null;
  public int num = 0;
  public int type = 0;
  
  static
  {
    cache_icon.add("");
  }
  
  public multiple_count() {}
  
  public multiple_count(int paramInt1, int paramInt2, ArrayList<String> paramArrayList)
  {
    this.type = paramInt1;
    this.num = paramInt2;
    this.icon = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.num = paramJceInputStream.read(this.num, 1, false);
    this.icon = ((ArrayList)paramJceInputStream.read(cache_icon, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.num, 1);
    if (this.icon != null) {
      paramJceOutputStream.write(this.icon, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.multiple_count
 * JD-Core Version:    0.7.0.1
 */