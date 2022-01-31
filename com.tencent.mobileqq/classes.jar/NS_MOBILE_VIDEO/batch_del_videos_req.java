package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class batch_del_videos_req
  extends JceStruct
{
  static ArrayList<String> cache_vids;
  public long uin;
  public ArrayList<String> vids;
  
  public batch_del_videos_req() {}
  
  public batch_del_videos_req(long paramLong, ArrayList<String> paramArrayList)
  {
    this.uin = paramLong;
    this.vids = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    if (cache_vids == null)
    {
      cache_vids = new ArrayList();
      cache_vids.add("");
    }
    this.vids = ((ArrayList)paramJceInputStream.read(cache_vids, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.vids != null) {
      paramJceOutputStream.write(this.vids, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_VIDEO.batch_del_videos_req
 * JD-Core Version:    0.7.0.1
 */