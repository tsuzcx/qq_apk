package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_count
  extends JceStruct
{
  static ArrayList<multiple_count> cache_mulcount = new ArrayList();
  public String desc = "";
  public String icon = "";
  public int icon_height = 0;
  public int icon_width = 0;
  public ArrayList<multiple_count> mulcount = null;
  public int num = 0;
  public int type = 0;
  
  static
  {
    multiple_count localmultiple_count = new multiple_count();
    cache_mulcount.add(localmultiple_count);
  }
  
  public cell_count() {}
  
  public cell_count(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, ArrayList<multiple_count> paramArrayList)
  {
    this.type = paramInt1;
    this.num = paramInt2;
    this.icon = paramString1;
    this.desc = paramString2;
    this.icon_width = paramInt3;
    this.icon_height = paramInt4;
    this.mulcount = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.num = paramJceInputStream.read(this.num, 1, false);
    this.icon = paramJceInputStream.readString(2, false);
    this.desc = paramJceInputStream.readString(3, false);
    this.icon_width = paramJceInputStream.read(this.icon_width, 4, false);
    this.icon_height = paramJceInputStream.read(this.icon_height, 5, false);
    this.mulcount = ((ArrayList)paramJceInputStream.read(cache_mulcount, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.num, 1);
    if (this.icon != null) {
      paramJceOutputStream.write(this.icon, 2);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 3);
    }
    paramJceOutputStream.write(this.icon_width, 4);
    paramJceOutputStream.write(this.icon_height, 5);
    if (this.mulcount != null) {
      paramJceOutputStream.write(this.mulcount, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_count
 * JD-Core Version:    0.7.0.1
 */