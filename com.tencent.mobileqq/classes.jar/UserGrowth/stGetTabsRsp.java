package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stGetTabsRsp
  extends JceStruct
{
  static ArrayList<stTabInfo> cache_Tabs = new ArrayList();
  public ArrayList<stTabInfo> Tabs = null;
  
  static
  {
    stTabInfo localstTabInfo = new stTabInfo();
    cache_Tabs.add(localstTabInfo);
  }
  
  public stGetTabsRsp() {}
  
  public stGetTabsRsp(ArrayList<stTabInfo> paramArrayList)
  {
    this.Tabs = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Tabs = ((ArrayList)paramJceInputStream.read(cache_Tabs, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.Tabs != null) {
      paramJceOutputStream.write(this.Tabs, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stGetTabsRsp
 * JD-Core Version:    0.7.0.1
 */