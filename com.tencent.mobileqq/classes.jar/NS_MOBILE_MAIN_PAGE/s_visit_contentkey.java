package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_visit_contentkey
  extends JceStruct
{
  public long appid;
  public String contentid = "";
  public long tid;
  
  public s_visit_contentkey() {}
  
  public s_visit_contentkey(long paramLong1, long paramLong2, String paramString)
  {
    this.tid = paramLong1;
    this.appid = paramLong2;
    this.contentid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.tid = paramJceInputStream.read(this.tid, 0, true);
    this.appid = paramJceInputStream.read(this.appid, 1, true);
    this.contentid = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.tid, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.contentid, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_visit_contentkey
 * JD-Core Version:    0.7.0.1
 */