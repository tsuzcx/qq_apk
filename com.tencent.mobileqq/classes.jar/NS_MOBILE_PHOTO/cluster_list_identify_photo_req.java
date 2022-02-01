package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cluster_list_identify_photo_req
  extends JceStruct
{
  static comm_page_info cache_page_info = new comm_page_info();
  public String categoryid = "";
  public long op_uin = 0L;
  public comm_page_info page_info = null;
  
  public cluster_list_identify_photo_req() {}
  
  public cluster_list_identify_photo_req(long paramLong, String paramString, comm_page_info paramcomm_page_info)
  {
    this.op_uin = paramLong;
    this.categoryid = paramString;
    this.page_info = paramcomm_page_info;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op_uin = paramJceInputStream.read(this.op_uin, 0, false);
    this.categoryid = paramJceInputStream.readString(1, false);
    this.page_info = ((comm_page_info)paramJceInputStream.read(cache_page_info, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op_uin, 0);
    Object localObject = this.categoryid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.page_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.cluster_list_identify_photo_req
 * JD-Core Version:    0.7.0.1
 */