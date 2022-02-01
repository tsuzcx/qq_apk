package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UnReadSummaryInfo
  extends JceStruct
{
  public String attach_info = "";
  public int hasmore = 0;
  public int need_more_unread_msg = 0;
  public int req_num = 0;
  
  public UnReadSummaryInfo() {}
  
  public UnReadSummaryInfo(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.hasmore = paramInt1;
    this.attach_info = paramString;
    this.req_num = paramInt2;
    this.need_more_unread_msg = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.attach_info = paramJceInputStream.readString(2, false);
    this.req_num = paramJceInputStream.read(this.req_num, 3, false);
    this.need_more_unread_msg = paramJceInputStream.read(this.need_more_unread_msg, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.hasmore, 1);
    if (this.attach_info != null) {
      paramJceOutputStream.write(this.attach_info, 2);
    }
    paramJceOutputStream.write(this.req_num, 3);
    paramJceOutputStream.write(this.need_more_unread_msg, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.UnReadSummaryInfo
 * JD-Core Version:    0.7.0.1
 */