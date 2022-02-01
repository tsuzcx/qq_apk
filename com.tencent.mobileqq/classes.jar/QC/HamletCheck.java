package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class HamletCheck
  extends JceStruct
{
  static ArrayList<UniBusinessCheckItem> cache_itemlist = new ArrayList();
  public ArrayList<UniBusinessCheckItem> itemlist = null;
  public int locationtype = 0;
  public long uid = 0L;
  
  static
  {
    UniBusinessCheckItem localUniBusinessCheckItem = new UniBusinessCheckItem();
    cache_itemlist.add(localUniBusinessCheckItem);
  }
  
  public HamletCheck() {}
  
  public HamletCheck(long paramLong, int paramInt, ArrayList<UniBusinessCheckItem> paramArrayList)
  {
    this.uid = paramLong;
    this.locationtype = paramInt;
    this.itemlist = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uid = paramJceInputStream.read(this.uid, 0, false);
    this.locationtype = paramJceInputStream.read(this.locationtype, 1, false);
    this.itemlist = ((ArrayList)paramJceInputStream.read(cache_itemlist, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uid, 0);
    paramJceOutputStream.write(this.locationtype, 1);
    ArrayList localArrayList = this.itemlist;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.HamletCheck
 * JD-Core Version:    0.7.0.1
 */