package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_LabelInfo
  extends JceStruct
{
  static ArrayList<String> cache_client_groupid;
  static ArrayList<String> cache_labels = new ArrayList();
  public ArrayList<String> client_groupid = null;
  public ArrayList<String> labels = null;
  
  static
  {
    cache_labels.add("");
    cache_client_groupid = new ArrayList();
    cache_client_groupid.add("");
  }
  
  public s_LabelInfo() {}
  
  public s_LabelInfo(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    this.labels = paramArrayList1;
    this.client_groupid = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.labels = ((ArrayList)paramJceInputStream.read(cache_labels, 0, false));
    this.client_groupid = ((ArrayList)paramJceInputStream.read(cache_client_groupid, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.labels;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
    localArrayList = this.client_groupid;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_LabelInfo
 * JD-Core Version:    0.7.0.1
 */