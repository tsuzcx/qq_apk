package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class label_show_info
  extends JceStruct
{
  static ArrayList<String> cache_labelids = new ArrayList();
  public String label = "";
  public ArrayList<String> labelids = null;
  
  static
  {
    cache_labelids.add("");
  }
  
  public label_show_info() {}
  
  public label_show_info(String paramString, ArrayList<String> paramArrayList)
  {
    this.label = paramString;
    this.labelids = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.label = paramJceInputStream.readString(0, false);
    this.labelids = ((ArrayList)paramJceInputStream.read(cache_labelids, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.label;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.labelids;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.label_show_info
 * JD-Core Version:    0.7.0.1
 */