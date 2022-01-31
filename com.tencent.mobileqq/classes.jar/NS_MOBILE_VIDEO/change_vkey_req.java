package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class change_vkey_req
  extends JceStruct
{
  static ArrayList<String> cache_video_urls;
  public ArrayList<String> video_urls;
  
  public change_vkey_req() {}
  
  public change_vkey_req(ArrayList<String> paramArrayList)
  {
    this.video_urls = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_video_urls == null)
    {
      cache_video_urls = new ArrayList();
      cache_video_urls.add("");
    }
    this.video_urls = ((ArrayList)paramJceInputStream.read(cache_video_urls, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.video_urls != null) {
      paramJceOutputStream.write(this.video_urls, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.change_vkey_req
 * JD-Core Version:    0.7.0.1
 */