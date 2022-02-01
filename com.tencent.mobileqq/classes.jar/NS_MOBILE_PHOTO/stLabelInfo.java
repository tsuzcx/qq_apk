package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stLabelInfo
  extends JceStruct
{
  static ArrayList<String> cache_labels = new ArrayList();
  public ArrayList<String> labels = null;
  
  static
  {
    cache_labels.add("");
  }
  
  public stLabelInfo() {}
  
  public stLabelInfo(ArrayList<String> paramArrayList)
  {
    this.labels = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.labels = ((ArrayList)paramJceInputStream.read(cache_labels, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.labels;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.stLabelInfo
 * JD-Core Version:    0.7.0.1
 */