package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stGetAllFeedsByDramaIDRsp
  extends JceStruct
{
  static ArrayList<String> cache_feedIDs = new ArrayList();
  public ArrayList<String> feedIDs = null;
  
  static
  {
    cache_feedIDs.add("");
  }
  
  public stGetAllFeedsByDramaIDRsp() {}
  
  public stGetAllFeedsByDramaIDRsp(ArrayList<String> paramArrayList)
  {
    this.feedIDs = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.feedIDs = ((ArrayList)paramJceInputStream.read(cache_feedIDs, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.feedIDs;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetAllFeedsByDramaIDRsp
 * JD-Core Version:    0.7.0.1
 */