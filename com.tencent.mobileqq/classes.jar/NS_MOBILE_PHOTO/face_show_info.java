package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import photo_share_struct.uin_nick_info;

public final class face_show_info
  extends JceStruct
{
  static ArrayList<String> cache_groupids;
  static uin_nick_info cache_pic_host = new uin_nick_info();
  static int cache_status;
  public ArrayList<String> groupids = null;
  public uin_nick_info pic_host = null;
  public int status = 0;
  
  static
  {
    cache_groupids = new ArrayList();
    cache_groupids.add("");
  }
  
  public face_show_info() {}
  
  public face_show_info(int paramInt, uin_nick_info paramuin_nick_info, ArrayList<String> paramArrayList)
  {
    this.status = paramInt;
    this.pic_host = paramuin_nick_info;
    this.groupids = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.status = paramJceInputStream.read(this.status, 0, false);
    this.pic_host = ((uin_nick_info)paramJceInputStream.read(cache_pic_host, 1, false));
    this.groupids = ((ArrayList)paramJceInputStream.read(cache_groupids, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.status, 0);
    Object localObject = this.pic_host;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.groupids;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.face_show_info
 * JD-Core Version:    0.7.0.1
 */