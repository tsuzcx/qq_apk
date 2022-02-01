package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class check_video_illegal_req
  extends JceStruct
{
  static ArrayList<UrlInput> cache_video_urls = new ArrayList();
  public ArrayList<UrlInput> video_urls;
  
  static
  {
    UrlInput localUrlInput = new UrlInput();
    cache_video_urls.add(localUrlInput);
  }
  
  public check_video_illegal_req() {}
  
  public check_video_illegal_req(ArrayList<UrlInput> paramArrayList)
  {
    this.video_urls = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.video_urls = ((ArrayList)paramJceInputStream.read(cache_video_urls, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.video_urls;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.check_video_illegal_req
 * JD-Core Version:    0.7.0.1
 */