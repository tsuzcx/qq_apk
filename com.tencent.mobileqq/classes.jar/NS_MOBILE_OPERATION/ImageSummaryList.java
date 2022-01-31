package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ImageSummaryList
  extends JceStruct
{
  static ArrayList<ImageSummary> cache_vecImageSummary;
  public ArrayList<ImageSummary> vecImageSummary;
  
  public ImageSummaryList() {}
  
  public ImageSummaryList(ArrayList<ImageSummary> paramArrayList)
  {
    this.vecImageSummary = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecImageSummary == null)
    {
      cache_vecImageSummary = new ArrayList();
      ImageSummary localImageSummary = new ImageSummary();
      cache_vecImageSummary.add(localImageSummary);
    }
    this.vecImageSummary = ((ArrayList)paramJceInputStream.read(cache_vecImageSummary, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecImageSummary != null) {
      paramJceOutputStream.write(this.vecImageSummary, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     NS_MOBILE_OPERATION.ImageSummaryList
 * JD-Core Version:    0.7.0.1
 */